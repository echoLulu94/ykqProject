package com.cxs.extension.ath.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 子系统表实体类
 * @ClassName: SubSystem 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月16日
 */
@Entity
@Table(name = "ath_sub_system", schema = "")
public class SubSystem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**系统编号*/
	@Column(name ="sub_sys_code",nullable=true)
	private String subSysCode;
	/**子系统值*/
	@Column(name ="sub_sys_value",nullable=true)
	private String subSysValue;
	/**系统名称*/
	@Column(name ="sub_sys_name",nullable=true)
	private String subSysName;
	/**子系统uri*/
	@Column(name ="sub_sys_uri",nullable=true)
	private String subSysUri;
	/**系统描述*/
	@Column(name ="sub_sys_des",nullable=true)
	private String subSysDes;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
	private Long createTime;
	/**更新时间*/
	@Column(name ="update_time",nullable=true)
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
}
