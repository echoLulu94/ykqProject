package com.cxs.extension.ath.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 菜单表实体类
 * @ClassName: Menu 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 */
@Entity
@Table(name = "ath_menu", schema = "")
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**菜单编号*/
	@Column(name ="menu_code",nullable=true)
	private String menuCode;
	/**资源编号*/
	@Column(name ="resc_code",nullable=true)
	private String rescCode;
	/**父菜单编号*/
	@Column(name ="parent_menu_code",nullable=true)
	private String parentMenuCode;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
	private Long createTime;
	/**创建人*/
	@Column(name ="create_by",nullable=true)
	private String createBy;
	/**修改时间*/
	@Column(name ="update_time",nullable=true)
	private Long updateTime;
	/**修改人*/
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
	 *方法: 取得菜单编号
	 *@return: String  菜单编号
	 */
	public String getMenuCode(){
		return this.menuCode;
	}

	/**
	 *方法: 设置菜单编号
	 *@param: String  菜单编号
	 */
	public void setMenuCode(String menuCode){
		this.menuCode = menuCode;
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
	 *方法: 取得父菜单编号
	 *@return: String  父菜单编号
	 */
	public String getParentMenuCode(){
		return this.parentMenuCode;
	}

	/**
	 *方法: 设置父菜单编号
	 *@param: String  父菜单编号
	 */
	public void setParentMenuCode(String parentMenuCode){
		this.parentMenuCode = parentMenuCode;
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
	 *方法: 取得修改时间
	 *@return: Long  修改时间
	 */
	public Long getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置修改时间
	 *@param: Long  修改时间
	 */
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
	
	/**
	 *方法: 取得修改人
	 *@return: String  修改人
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置修改人
	 *@param: String  修改人
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
}
