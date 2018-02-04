package com.cxs.extension.ath.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 角色表表实体类
 * @ClassName: Role 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 */
@Entity
@Table(name = "ath_role", schema = "")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**角色编码*/
	@Column(name ="code",nullable=true)
	private String code;
	/**角色名称*/
	@Column(name ="name",nullable=true)
	private String name;
	/**备注*/
	@Column(name ="memo",nullable=true)
	private String memo;
	/**是否可用：0-不可用；1-可用*/
	@Column(name ="state",nullable=true)
	private String state;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
	private Long createTime;
	/**创建人*/
	@Column(name ="create_by",nullable=true)
	private String createBy;
	/**update_time*/
	@Column(name ="update_time",nullable=true)
	private Long updateTime;
	/**update_by*/
	@Column(name ="update_by",nullable=true)
	private String updateBy;
	
	
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
	 *方法: 取得角色编码
	 *@return: String  角色编码
	 */
	public String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置角色编码
	 *@param: String  角色编码
	 */
	public void setCode(String code){
		this.code = code;
	}
	
	/**
	 *方法: 取得角色名称
	 *@return: String  角色名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置角色名称
	 *@param: String  角色名称
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得备注
	 *@return: String  备注
	 */
	public String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置备注
	 *@param: String  备注
	 */
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	/**
	 *方法: 取得是否可用：0-不可用；1-可用
	 *@return: String  是否可用：0-不可用；1-可用
	 */
	public String getState(){
		return this.state;
	}

	/**
	 *方法: 设置是否可用：0-不可用；1-可用
	 *@param: String  是否可用：0-不可用；1-可用
	 */
	public void setState(String state){
		this.state = state;
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
	 *方法: 取得创建人
	 *@return: String  创建人
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置创建人
	 *@param: String  创建人
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
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
	
	/**
	 *方法: 取得update_by
	 *@return: String  update_by
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置update_by
	 *@param: String  update_by
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
}
