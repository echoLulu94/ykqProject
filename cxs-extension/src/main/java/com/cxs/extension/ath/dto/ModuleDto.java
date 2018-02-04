package com.cxs.extension.ath.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Description: 模块数据对象
 * @ClassName: ModuleDto
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月16日
 */
public class ModuleDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**子系统编号*/
	private String subSysCode;
	/**模块编号*/
	private String modCode;
	/**mod_value*/
	private String modValue;
	/**模块名称*/
	private String modName;
	/**表名*/
	private String tableName;
	/**模块uri*/
	private String modUri;
	/**模块描述*/
	private String modDes;
	/**创建时间*/
	private Long createTime;
	/**更新时间*/
	private Long updateTime;
	/**资源列表*/
	private List<ResourceDto> rescDtoList;
	
	
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
	 *方法: 取得mod_value
	 *@return: String  mod_value
	 */
	public String getModValue(){
		return this.modValue;
	}

	/**
	 *方法: 设置mod_value
	 *@param: String  mod_value
	 */
	public void setModValue(String modValue){
		this.modValue = modValue;
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
	 *方法: 取得表名
	 *@return: String  表名
	 */
	public String getTableName(){
		return this.tableName;
	}

	/**
	 *方法: 设置表名
	 *@param: String  表名
	 */
	public void setTableName(String tableName){
		this.tableName = tableName;
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
	 *方法: 取得模块描述
	 *@return: String  模块描述
	 */
	public String getModDes(){
		return this.modDes;
	}

	/**
	 *方法: 设置模块描述
	 *@param: String  模块描述
	 */
	public void setModDes(String modDes){
		this.modDes = modDes;
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

	public List<ResourceDto> getRescDtoList() {
		return rescDtoList;
	}

	public void setRescDtoList(List<ResourceDto> rescDtoList) {
		this.rescDtoList = rescDtoList;
	}
}
