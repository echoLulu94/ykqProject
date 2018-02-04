package com.cxs.extension.sys.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 短信验证码表实体类
 * @ClassName: VerificationCode 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月01日
 */
@Entity
@Table(name = "sys_verification_code", schema = "")
public class VerificationCode implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**会员ID*/
	@Column(name ="member_id",nullable=true)
	private String memberId;
	/**手机号码*/
	@Column(name ="phone",nullable=true)
	private String phone;
	/**验证码*/
	@Column(name ="code",nullable=true)
	private Integer code;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
	private Long createTime;
	/**修改时间*/
	@Column(name ="expiry_time",nullable=true)
	private Long expiryTime;
	/**业务标识*/
	@Column(name ="business_type",nullable=true)
	private String businessType;
	/**状态：10-有效；11-已过期；12-已使用*/
	@Column(name ="status",nullable=true)
	private String status;
	
	
	/**
	 *方法: 取得id
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置id
	 *@param: String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得会员ID
	 *@return: String  会员ID
	 */
	public String getMemberId(){
		return this.memberId;
	}

	/**
	 *方法: 设置会员ID
	 *@param: String  会员ID
	 */
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
	/**
	 *方法: 取得手机号码
	 *@return: String  手机号码
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置手机号码
	 *@param: String  手机号码
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	/**
	 *方法: 取得验证码
	 *@return: Integer  验证码
	 */
	public Integer getCode(){
		return this.code;
	}

	/**
	 *方法: 设置验证码
	 *@param: Integer  验证码
	 */
	public void setCode(Integer code){
		this.code = code;
	}
	
	/**
	 *方法: 取得创建时间
	 *@return: Long  创建时间
	 */
	public Long getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置创建时间
	 *@param: Long  创建时间
	 */
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	
	/**
	 *方法: 取得修改时间
	 *@return: Long  修改时间
	 */
	public Long getExpiryTime(){
		return this.expiryTime;
	}

	/**
	 *方法: 设置修改时间
	 *@param: Long  修改时间
	 */
	public void setExpiryTime(Long expiryTime){
		this.expiryTime = expiryTime;
	}
	
	/**
	 *方法: 取得业务标识
	 *@return: String  业务标识
	 */
	public String getBusinessType(){
		return this.businessType;
	}

	/**
	 *方法: 设置业务标识
	 *@param: String  业务标识
	 */
	public void setBusinessType(String businessType){
		this.businessType = businessType;
	}
	
	/**
	 *方法: 取得状态：10-有效；11-已过期；12-已使用
	 *@return: String  状态：10-有效；11-已过期；12-已使用
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置状态：10-有效；11-已过期；12-已使用
	 *@param: String  状态：10-有效；11-已过期；12-已使用
	 */
	public void setStatus(String status){
		this.status = status;
	}
}
