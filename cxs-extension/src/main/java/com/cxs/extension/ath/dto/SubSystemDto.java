package com.cxs.extension.ath.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Description: 子系统数据对象
 * @ClassName: SubSystemDto
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月16日
 */
public class SubSystemDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**系统编号*/
	private String subSysCode;
	/**子系统值*/
	private String subSysValue;
	/**系统名称*/
	private String subSysName;
	/**子系统uri*/
	private String subSysUri;
	/**系统描述*/
	private String subSysDes;
	/**创建时间*/
	private Long createTime;
	/**更新时间*/
	private Long updateTime;
	/**模块列表*/
	private List<ModuleDto> modDtoList;
	
	
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
	 *方法: 取得系统编号
	 *@return: String  系统编号
	 */
	public String getSubSysCode(){
		return this.subSysCode;
	}

	/**
	 *方法: 设置系统编号
	 *@param: String  系统编号
	 */
	public void setSubSysCode(String subSysCode){
		this.subSysCode = subSysCode;
	}
	
	/**
	 *方法: 取得子系统值
	 *@return: String  子系统值
	 */
	public String getSubSysValue(){
		return this.subSysValue;
	}

	/**
	 *方法: 设置子系统值
	 *@param: String  子系统值
	 */
	public void setSubSysValue(String subSysValue){
		this.subSysValue = subSysValue;
	}
	
	/**
	 *方法: 取得系统名称
	 *@return: String  系统名称
	 */
	public String getSubSysName(){
		return this.subSysName;
	}

	/**
	 *方法: 设置系统名称
	 *@param: String  系统名称
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
	 *方法: 取得系统描述
	 *@return: String  系统描述
	 */
	public String getSubSysDes(){
		return this.subSysDes;
	}

	/**
	 *方法: 设置系统描述
	 *@param: String  系统描述
	 */
	public void setSubSysDes(String subSysDes){
		this.subSysDes = subSysDes;
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

	public List<ModuleDto> getModDtoList() {
		return modDtoList;
	}

	public void setModDtoList(List<ModuleDto> modDtoList) {
		this.modDtoList = modDtoList;
	}
}
