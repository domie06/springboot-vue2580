package com.entity.vo;

import com.entity.TingchejiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 停车记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tingchejilu")
public class TingchejiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 进场时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jin_time")
    private Date jinTime;


    /**
     * 出场时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chu_time")
    private Date chuTime;


    /**
     * 天
     */

    @TableField(value = "tian")
    private Integer tian;


    /**
     * 总收费金额
     */

    @TableField(value = "new_money")
    private Double newMoney;


    /**
     * 备注
     */

    @TableField(value = "tingchejilu_content")
    private String tingchejiluContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：进场时间
	 */
    public Date getJinTime() {
        return jinTime;
    }


    /**
	 * 获取：进场时间
	 */

    public void setJinTime(Date jinTime) {
        this.jinTime = jinTime;
    }
    /**
	 * 设置：出场时间
	 */
    public Date getChuTime() {
        return chuTime;
    }


    /**
	 * 获取：出场时间
	 */

    public void setChuTime(Date chuTime) {
        this.chuTime = chuTime;
    }
    /**
	 * 设置：天
	 */
    public Integer getTian() {
        return tian;
    }


    /**
	 * 获取：天
	 */

    public void setTian(Integer tian) {
        this.tian = tian;
    }
    /**
	 * 设置：总收费金额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 获取：总收费金额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getTingchejiluContent() {
        return tingchejiluContent;
    }


    /**
	 * 获取：备注
	 */

    public void setTingchejiluContent(String tingchejiluContent) {
        this.tingchejiluContent = tingchejiluContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
