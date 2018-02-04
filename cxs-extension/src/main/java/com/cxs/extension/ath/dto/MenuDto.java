package com.cxs.extension.ath.dto;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @Description: 菜单数据对象
 * @ClassName: MenuDto
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 */
public class MenuDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**菜单编号*/
	private String menuCode;
	/**资源编号*/
	private String rescCode;
	/**父菜单编号*/
	private String parentMenuCode;
	/**创建时间*/
	private Long createTime;
	/**创建人*/
	private String createBy;
	/**修改时间*/
	private Long updateTime;
	/**修改人*/
	private String updateBy;
	/**路径*/
	private String path;
	/**组件（前端组件名称）*/
	private String component;
	/**标题（前端菜单显示名称）*/
	private String title;
	/**是否隐藏：true-隐藏；false-显示*/
	private Boolean hidden;
	/**菜单名称（前端代码中使用）*/
	private String name;
	/**菜单顺序*/
	private Integer sort;
	/**等级*/
	private Integer level;
	/**图标*/
	private String icon;
	/**子菜单*/
	private List<MenuDto> children;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<MenuDto> getChildren() {
		return children;
	}

	public void setChildren(List<MenuDto> children) {
		this.children = children;
	}
}
