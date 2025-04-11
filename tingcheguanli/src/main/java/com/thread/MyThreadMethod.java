package com.thread;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YonghuEntity;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线程执行方法（做一些项目启动后 一直要执行的操作，比如根据时间自动更改订单状态，比如订单签收30天自动收货功能，比如根据时间来更改状态）
 */
public class MyThreadMethod extends Thread  {

    private YonghuService yonghuService;
    public void run() {
        while (!this.isInterrupted()) {// 线程未中断执行循环
            try {

                System.out.println("--------------执行更新会员状态------------------");
                Map<String, Object> params = new HashMap<>();
                params.put("orderBy","id");
                params.put("page","1");
                params.put("limit","100");
                params.put("shifouhuiyuanTypes",1);
                params.put("huiyuanTimeEnd",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                PageUtils page = yonghuService.queryPage(params);
                List<YonghuEntity> list = (List<YonghuEntity>)page.getList();
                if(list != null && list.size()>0){
                    for(YonghuEntity y:list){
                        y.setShifouhuiyuanTypes(2);
                    }

                    yonghuService.updateBatchById(list);
                    System.out.println("--------------执行更新会员状态,更新了"+list.size()+"------------------");
                }
                Thread.sleep(5000); //每隔2000ms执行一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//			 ------------------ 开始执行 ---------------------------
//            System.out.println("线程执行中:" + System.currentTimeMillis());
        }
    }

    public YonghuService getYonghuService() {
        return yonghuService;
    }

    public void setYonghuService(YonghuService yonghuService) {
        this.yonghuService = yonghuService;
    }
}
