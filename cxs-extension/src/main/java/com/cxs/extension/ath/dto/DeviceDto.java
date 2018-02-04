package com.cxs.extension.ath.dto;

import java.io.Serializable;
/**
 * 
 * @Description: 设备数据对象
 * @ClassName: DeviceDto
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日
 */
public class DeviceDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**设备id*/
	private String deviceId;
	/**系统类型*/
	private String systemType;
	/**系统版本*/
	private String systemVersion;
	/**设备型号:例如iphone7*/
	private String deviceModel;
	/**设备名称：例如**‘s iphone*/
	private String deviceName;
	/**设备类型*/
	private String uiMode;
	/**运营商名称*/
	private String operator;
	/**网络连接类型*/
	private String connectionType;
	/**创建时间*/
	private Long createTime;
	/**update_time*/
	private Long updateTime;
	
	
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
	 *方法: 取得设备id
	 *@return: String  设备id
	 */
	public String getDeviceId(){
		return this.deviceId;
	}

	/**
	 *方法: 设置设备id
	 *@param: String  设备id
	 */
	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}
	
	/**
	 *方法: 取得系统类型
	 *@return: String  系统类型
	 */
	public String getSystemType(){
		return this.systemType;
	}

	/**
	 *方法: 设置系统类型
	 *@param: String  系统类型
	 */
	public void setSystemType(String systemType){
		this.systemType = systemType;
	}
	
	/**
	 *方法: 取得系统版本
	 *@return: String  系统版本
	 */
	public String getSystemVersion(){
		return this.systemVersion;
	}

	/**
	 *方法: 设置系统版本
	 *@param: String  系统版本
	 */
	public void setSystemVersion(String systemVersion){
		this.systemVersion = systemVersion;
	}
	
	/**
	 *方法: 取得设备型号:例如iphone7
	 *@return: String  设备型号:例如iphone7
	 */
	public String getDeviceModel(){
		return this.deviceModel;
	}

	/**
	 *方法: 设置设备型号:例如iphone7
	 *@param: String  设备型号:例如iphone7
	 */
	public void setDeviceModel(String deviceModel){
		this.deviceModel = deviceModel;
	}
	
	/**
	 *方法: 取得设备名称：例如**‘s iphone
	 *@return: String  设备名称：例如**‘s iphone
	 */
	public String getDeviceName(){
		return this.deviceName;
	}

	/**
	 *方法: 设置设备名称：例如**‘s iphone
	 *@param: String  设备名称：例如**‘s iphone
	 */
	public void setDeviceName(String deviceName){
		this.deviceName = deviceName;
	}
	
	/**
	 *方法: 取得设备类型
	 *@return: String  设备类型
	 */
	public String getUiMode(){
		return this.uiMode;
	}

	/**
	 *方法: 设置设备类型
	 *@param: String  设备类型
	 */
	public void setUiMode(String uiMode){
		this.uiMode = uiMode;
	}
	
	/**
	 *方法: 取得运营商名称
	 *@return: String  运营商名称
	 */
	public String getOperator(){
		return this.operator;
	}

	/**
	 *方法: 设置运营商名称
	 *@param: String  运营商名称
	 */
	public void setOperator(String operator){
		this.operator = operator;
	}
	
	/**
	 *方法: 取得网络连接类型
	 *@return: String  网络连接类型
	 */
	public String getConnectionType(){
		return this.connectionType;
	}

	/**
	 *方法: 设置网络连接类型
	 *@param: String  网络连接类型
	 */
	public void setConnectionType(String connectionType){
		this.connectionType = connectionType;
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
	 *方法: 取得update_time
	 *@return: Long  update_time
	 */
	public Long getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置update_time
	 *@param: Long  update_time
	 */
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
}
