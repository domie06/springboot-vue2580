package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShangbaoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 上报
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangbao")
public class ShangbaoView extends ShangbaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 是否会员
			*/
			private Integer shifouhuiyuanTypes;
				/**
				* 是否会员的值
				*/
				private String shifouhuiyuanValue;
			/**
			* 会员截止日期
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date huiyuanTime;

	public ShangbaoView() {

	}

	public ShangbaoView(ShangbaoEntity shangbaoEntity) {
		try {
			BeanUtils.copyProperties(this, shangbaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 是否会员
					*/
					public Integer getShifouhuiyuanTypes() {
						return shifouhuiyuanTypes;
					}
					/**
					* 设置： 是否会员
					*/
					public void setShifouhuiyuanTypes(Integer shifouhuiyuanTypes) {
						this.shifouhuiyuanTypes = shifouhuiyuanTypes;
					}


						/**
						* 获取： 是否会员的值
						*/
						public String getShifouhuiyuanValue() {
							return shifouhuiyuanValue;
						}
						/**
						* 设置： 是否会员的值
						*/
						public void setShifouhuiyuanValue(String shifouhuiyuanValue) {
							this.shifouhuiyuanValue = shifouhuiyuanValue;
						}
					/**
					* 获取： 会员截止日期
					*/
					public Date getHuiyuanTime() {
						return huiyuanTime;
					}
					/**
					* 设置： 会员截止日期
					*/
					public void setHuiyuanTime(Date huiyuanTime) {
						this.huiyuanTime = huiyuanTime;
					}


}
