package com.cxs.extension.ath.dto;

import java.io.Serializable;
/**
 * 
 * @Description: 资源数据对象
 * @ClassName: ResourceDto
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月16日
 */
public class ResourceDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**子系统编号*/
	private String subSysCode;
	/**子系统名称*/
	private String subSysName;
	/**子系统uri*/
	private String subSysUri;
	/**模块编号*/
	private String modCode;
	/**模块名称*/
	private String modName;
	/**模块uri*/
	private String modUri;
	/**资源编号*/
	private String rescCode;
	/**资源值*/
	private String rescValue;
	/**资源名称*/
	private String rescName;
	/**uri类型:0-内部链接;1-外部链接*/
	private String rescUriType;
	/**资源uri*/
	private String rescUri;
	/**备注*/
	private String rescDes;
	/**创建时间*/
	private Long createTime;
	/**更新时间*/
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
	 *方法: 取得子系统编号
	 *@return: String  子系统编号
	 */
	public String getSubSysCode(){
		return this.subSysCode;
	}

	/**
	 *方法: 设置子系统编号
	 *@param: String  子系统编号
	 */
	public void setSubSysCode(String subSysCode){
		this.subSysCode = subSysCode;
	}
	
	/**
	 *方法: 取得子系统名称
	 *@return: String  子系统名称
	 */
	public String getSubSysName(){
		return this.subSysName;
	}

	/**
	 *方法: 设置子系统名称
	 *@param: String  子系统名称
	 */
	public void setSubSysName(String subSysName){
		this.subSysName = subSysName;
	}
	
	/**
	 *方法: 取得子系统uri
	 *@return: String  子系统uri
	 */
	public String getSubSysUri(){
		return this.subSysUri;
	}

	/**
	 *方法: 设置子系统uri
	 *@param: String  子系统uri
	 */
	public void setSubSysUri(String subSysUri){
		this.subSysUri = subSysUri;
	}
	
	/**
	 *方法: 取得模块编号
	 *@return: String  模块编号
	 */
	public String getModCode(){
		return this.modCode;
	}

	/**
	 *方法: 设置模块编号
	 *@param: String  模块编号
	 */
	public void setModCode(String modCode){
		this.modCode = modCode;
	}
	
	/**
	 *方法: 取得模块名称
	 *@return: String  模块名称
	 */
	public String getModName(){
		return this.modName;
	}

	/**
	 *方法: 设置模块名称
	 *@param: String  模块名称
	 */
	public void setModName(String modName){
		this.modName = modName;
	}
	
	/**
	 *方法: 取得模块uri
	 *@return: String  模块uri
	 */
	public String getModUri(){
		return this.modUri;
	}

	/**
	 *方法: 设置模块uri
	 *@param: String  模块uri
	 */
	public void setModUri(String modUri){
		this.modUri = modUri;
	}
	
	/**
	 *方法: 取得资源编号
	 *@return: String  资源编号
	 */
	public String getRescCode(){
		return this.rescCode;
	}

	/**
	 *方法: 设置资源编号
	 *@param: String  资源编号
	 */
	public void setRescCode(String rescCode){
		this.rescCode = rescCode;
	}
	
	/**
	 *方法: 取得资源值
	 *@return: String  资源值
	 */
	public String getRescValue(){
		return this.rescValue;
	}

	/**
	 *方法: 设置资源值
	 *@param: String  资源值
	 */
	public void setRescValue(String rescValue){
		this.rescValue = rescValue;
	}
	
	/**
	 *方法: 取得资源名称
	 *@return: String  资源名称
	 */
	public String getRescName(){
		return this.rescName;
	}

	/**
	 *方法: 设置资源名称
	 *@param: String  资源名称
	 */
	public void setRescName(String rescName){
		this.rescName = rescName;
	}
	
	/**
	 *方法: 取得uri类型:0-内部链接;1-外部链接
	 *@return: String  uri类型:0-内部链接;1-外部链接
	 */
	public String getRescUriType(){
		return this.rescUriType;
	}

	/**
	 *方法: 设置uri类型:0-内部链接;1-外部链接
	 *@param: String  uri类型:0-内部链接;1-外部链接
	 */
	public void setRescUriType(String rescUriType){
		this.rescUriType = rescUriType;
	}
	
	/**
	 *方法: 取得资源uri
	 *@return: String  资源uri
	 */
	public String getRescUri(){
		return this.rescUri;
	}

	/**
	 *方法: 设置资源uri
	 *@param: String  资源uri
	 */
	public void setRescUri(String rescUri){
		this.rescUri = rescUri;
	}
	
	/**
	 *方法: 取得备注
	 *@return: String  备注
	 */
	public String getRescDes(){
		return this.rescDes;
	}

	/**
	 *方法: 设置备注
	 *@param: String  备注
	 */
	public void setRescDes(String rescDes){
		this.rescDes = rescDes;
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
	 *方法: 取得更新时间
	 *@return: Long  更新时间
	 */
	public Long getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置更新时间
	 *@param: Long  更新时间
	 */
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
}
