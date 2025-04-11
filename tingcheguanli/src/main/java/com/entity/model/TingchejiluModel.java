package com.entity.model;

import com.entity.TingchejiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 停车记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TingchejiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 进场时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jinTime;


    /**
     * 出场时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chuTime;


    /**
     * 天
     */
    private Integer tian;


    /**
     * 总收费金额
     */
    private Double newMoney;


    /**
     * 备注
     */
    private String tingchejiluContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：进场时间
	 */
    public Date getJinTime() {
        return jinTime;
    }


    /**
	 * 设置：进场时间
	 */
    public void setJinTime(Date jinTime) {
        this.jinTime = jinTime;
    }
    /**
	 * 获取：出场时间
	 */
    public Date getChuTime() {
        return chuTime;
    }


    /**
	 * 设置：出场时间
	 */
    public void setChuTime(Date chuTime) {
        this.chuTime = chuTime;
    }
    /**
	 * 获取：天
	 */
    public Integer getTian() {
        return tian;
    }


    /**
	 * 设置：天
	 */
    public void setTian(Integer tian) {
        this.tian = tian;
    }
    /**
	 * 获取：总收费金额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：总收费金额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：备注
	 */
    public String getTingchejiluContent() {
        return tingchejiluContent;
    }


    /**
	 * 设置：备注
	 */
    public void setTingchejiluContent(String tingchejiluContent) {
        this.tingchejiluContent = tingchejiluContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
