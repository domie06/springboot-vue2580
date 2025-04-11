package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 停车记录
 *
 * @author 
 * @email
 */
@TableName("tingchejilu")
public class TingchejiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TingchejiluEntity() {

	}

	public TingchejiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "jin_time")

    private Date jinTime;


    /**
     * 出场时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Tingchejilu{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", jinTime=" + jinTime +
            ", chuTime=" + chuTime +
            ", tian=" + tian +
            ", newMoney=" + newMoney +
            ", tingchejiluContent=" + tingchejiluContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
