
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 停车记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tingchejilu")
public class TingchejiluController {
    private static final Logger logger = LoggerFactory.getLogger(TingchejiluController.class);

    @Autowired
    private TingchejiluService tingchejiluService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = tingchejiluService.queryPage(params);

        //字典表数据转换
        List<TingchejiluView> list =(List<TingchejiluView>)page.getList();
        for(TingchejiluView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TingchejiluEntity tingchejilu = tingchejiluService.selectById(id);
        if(tingchejilu !=null){
            //entity转view
            TingchejiluView view = new TingchejiluView();
            BeanUtils.copyProperties( tingchejilu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(tingchejilu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TingchejiluEntity tingchejilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tingchejilu:{}",this.getClass().getName(),tingchejilu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            tingchejilu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        if((tingchejilu.getChuTime().getTime() - tingchejilu.getJinTime().getTime()) == 0){
            tingchejilu.setTian(1);
        }else{
            Long l = (tingchejilu.getChuTime().getTime() - tingchejilu.getJinTime().getTime()) / (1000 * 3600 * 24);
            tingchejilu.setTian(l.intValue()+1);
        }

        YonghuEntity yonghuEntity = yonghuService.selectById(tingchejilu.getYonghuId());
       if(yonghuEntity.getShifouhuiyuanTypes() == 2){
           int i = tingchejilu.getTian() * 10;
           double yue = yonghuEntity.getNewMoney() - i;
           if(yue <0)
               return R.error(511,"本次消费"+i+"元,账户余额"+yonghuEntity.getNewMoney()+",不够支付");
           yonghuEntity.setNewMoney(yue);
           yonghuService.updateById(yonghuEntity);


           tingchejilu.setNewMoney(Double.valueOf(i));
       }else{
           tingchejilu.setNewMoney(0.0);
       }



       tingchejilu.setInsertTime(new Date());
           tingchejilu.setCreateTime(new Date());
           tingchejiluService.insert(tingchejilu);
           return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TingchejiluEntity tingchejilu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tingchejilu:{}",this.getClass().getName(),tingchejilu.toString());

            tingchejiluService.updateById(tingchejilu);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tingchejiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TingchejiluEntity> tingchejiluList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TingchejiluEntity tingchejiluEntity = new TingchejiluEntity();
//                            tingchejiluEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tingchejiluEntity.setJinTime(new Date(data.get(0)));          //进场时间 要改的
//                            tingchejiluEntity.setChuTime(new Date(data.get(0)));          //出场时间 要改的
//                            tingchejiluEntity.setTian(Integer.valueOf(data.get(0)));   //天 要改的
//                            tingchejiluEntity.setNewMoney(data.get(0));                    //总收费金额 要改的
//                            tingchejiluEntity.setTingchejiluContent("");//照片
//                            tingchejiluEntity.setInsertTime(date);//时间
//                            tingchejiluEntity.setCreateTime(date);//时间
                            tingchejiluList.add(tingchejiluEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tingchejiluService.insertBatch(tingchejiluList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


//    public static void main(String[] args) {
//        Calendar old = Calendar.getInstance();
//        old.setTime(new Date());
//        old
//
//
//    }






}
