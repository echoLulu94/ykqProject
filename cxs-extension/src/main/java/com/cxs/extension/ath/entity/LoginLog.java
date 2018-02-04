package com.cxs.extension.ath.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 登录日志表实体类
 * @ClassName: LoginLog 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日
 */
@Entity
@Table(name = "ath_login_log", schema = "")
public class LoginLog implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**登录名*/
	@Column(name ="login_name",nullable=true)
	private String loginName;
	/**登录时间*/
	@Column(name ="login_time",nullable=true)
	private Long loginTime;
	/**登录渠道:10-pc;11-android;12-ios*/
	@Column(name ="login_channel",nullable=true)
	private String loginChannel;
	/**登录设备id*/
	@Column(name ="device_id",nullable=true)
	private String deviceId;
	/**登录ip*/
	@Column(name ="login_ip",nullable=true)
	private String loginIp;
	/**是否成功：0-失败；1-成功;*/
	@Column(name ="login_flag",nullable=true)
	private String loginFlag;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
	private Long createTime;
	
	
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
	 *方法: 取得登录名
	 *@return: String  登录名
	 */
	public String getLoginName(){
		return this.loginName;
	}

	/**
	 *方法: 设置登录名
	 *@param: String  登录名
	 */
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	
	/**
	 *方法: 取得登录时间
	 *@return: Long  登录时间
	 */
	public Long getLoginTime(){
		return this.loginTime;
	}

	/**
	 *方法: 设置登录时间
	 *@param: Long  登录时间
	 */
	public void setLoginTime(Long loginTime){
		this.loginTime = loginTime;
	}
	
	/**
	 *方法: 取得登录渠道:10-pc;11-android;12-ios
	 *@return: String  登录渠道:10-pc;11-android;12-ios
	 */
	public String getLoginChannel(){
		return this.loginChannel;
	}

	/**
	 *方法: 设置登录渠道:10-pc;11-android;12-ios
	 *@param: String  登录渠道:10-pc;11-android;12-ios
	 */
	public void setLoginChannel(String loginChannel){
		this.loginChannel = loginChannel;
	}
	
	/**
	 *方法: 取得登录设备id
	 *@return: String  登录设备id
	 */
	public String getDeviceId(){
		return this.deviceId;
	}

	/**
	 *方法: 设置登录设备id
	 *@param: String  登录设备id
	 */
	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}
	
	/**
	 *方法: 取得登录ip
	 *@return: String  登录ip
	 */
	public String getLoginIp(){
		return this.loginIp;
	}

	/**
	 *方法: 设置登录ip
	 *@param: String  登录ip
	 */
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}
	
	/**
	 *方法: 取得是否成功：0-失败；1-成功;
	 *@return: String  是否成功：0-失败；1-成功;
	 */
	public String getLoginFlag(){
		return this.loginFlag;
	}

	/**
	 *方法: 设置是否成功：0-失败；1-成功;
	 *@param: String  是否成功：0-失败；1-成功;
	 */
	public void setLoginFlag(String loginFlag){
		this.loginFlag = loginFlag;
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
}
