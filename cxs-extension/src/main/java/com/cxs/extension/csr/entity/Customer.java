package com.cxs.extension.csr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 客户表实体类
 * @ClassName: Customer 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日
 */
@Entity
@Table(name = "csr_customer", schema = "")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**客户姓名*/
	@Column(name ="cust_name",nullable=true)
	private String custName;
	/**用户编号：业务员编号*/
	@Column(name ="user_code",nullable=true)
	private String userCode;
	/**推荐人编号*/
	@Column(name ="rd_code",nullable=true)
	private String rdCode;
	/**密码*/
	@Column(name ="pwd",nullable=true)
	private String pwd;
	/**手机号*/
	@Column(name ="phone",nullable=true)
	private String phone;
	/**微信openId*/
	@Column(name ="open_id",nullable=true)
	private String openId;
	/**union_id*/
	@Column(name ="union_id",nullable=true)
	private String unionId;
	/**城市*/
	@Column(name ="city",nullable=true)
	private String city;
	/**身份证*/
	@Column(name ="idcard",nullable=true)
	private String idcard;
	/**地区编号*/
	@Column(name ="area_code",nullable=true)
	private String areaCode;
	/**昵称*/
	@Column(name ="nick_name",nullable=true)
	private String nickName;
	/**头像*/
	@Column(name ="head_img_url",nullable=true)
	private String headImgUrl;
	/**秘钥*/
	@Column(name ="salt",nullable=true)
	private String salt;
	/**性别：0-女；1-男*/
	@Column(name ="sex",nullable=true)
	private String sex;
	/**生日*/
	@Column(name ="birthday",nullable=true)
	private String birthday;
	/**归属类型：10-业务员；11-部门公海；12-公司公海*/
	@Column(name ="belong_type",nullable=true)
	private String belongType;
	/**归属海编号：当归属类型为，部门公海和公司公海时不能为空*/
	@Column(name ="belong_code",nullable=true)
	private String belongCode;
	/**创建人*/
	@Column(name ="create_by",nullable=true)
	private String createBy;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
	private Long createTime;
	/**更新人*/
	@Column(name ="update_by",nullable=true)
	private String updateBy;
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
	 *方法: 取得客户姓名
	 *@return: String  客户姓名
	 */
	public String getCustName(){
		return this.custName;
	}

	/**
	 *方法: 设置客户姓名
	 *@param: String  客户姓名
	 */
	public void setCustName(String custName){
		this.custName = custName;
	}
	
	/**
	 *方法: 取得密码
	 *@return: String  密码
	 */
	public String getPwd(){
		return this.pwd;
	}

	/**
	 *方法: 设置密码
	 *@param: String  密码
	 */
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	
	/**
	 *方法: 取得手机号
	 *@return: String  手机号
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置手机号
	 *@param: String  手机号
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	/**
	 *方法: 取得微信openId
	 *@return: String  微信openId
	 */
	public String getOpenId(){
		return this.openId;
	}

	/**
	 *方法: 设置微信openId
	 *@param: String  微信openId
	 */
	public void setOpenId(String openId){
		this.openId = openId;
	}
	
	/**
	 *方法: 取得union_id
	 *@return: String  union_id
	 */
	public String getUnionId(){
		return this.unionId;
	}

	/**
	 *方法: 设置union_id
	 *@param: String  union_id
	 */
	public void setUnionId(String unionId){
		this.unionId = unionId;
	}
	
	/**
	 *方法: 取得城市
	 *@return: String  城市
	 */
	public String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置城市
	 *@param: String  城市
	 */
	public void setCity(String city){
		this.city = city;
	}
	
	/**
	 *方法: 取得身份证
	 *@return: String  身份证
	 */
	public String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置身份证
	 *@param: String  身份证
	 */
	public void setIdcard(String idcard){
		this.idcard = idcard;
	}
	
	/**
	 *方法: 取得地区编号
	 *@return: String  地区编号
	 */
	public String getAreaCode(){
		return this.areaCode;
	}

	/**
	 *方法: 设置地区编号
	 *@param: String  地区编号
	 */
	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}
	
	/**
	 *方法: 取得昵称
	 *@return: String  昵称
	 */
	public String getNickName(){
		return this.nickName;
	}

	/**
	 *方法: 设置昵称
	 *@param: String  昵称
	 */
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	
	/**
	 *方法: 取得头像
	 *@return: String  头像
	 */
	public String getHeadImgUrl(){
		return this.headImgUrl;
	}

	/**
	 *方法: 设置头像
	 *@param: String  头像
	 */
	public void setHeadImgUrl(String headImgUrl){
		this.headImgUrl = headImgUrl;
	}
	
	/**
	 *方法: 取得秘钥
	 *@return: String  秘钥
	 */
	public String getSalt(){
		return this.salt;
	}

	/**
	 *方法: 设置秘钥
	 *@param: String  秘钥
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}
	
	/**
	 *方法: 取得性别：0-女；1-男
	 *@return: String  性别：0-女；1-男
	 */
	public String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置性别：0-女；1-男
	 *@param: String  性别：0-女；1-男
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	
	/**
	 *方法: 取得生日
	 *@return: String  生日
	 */
	public String getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置生日
	 *@param: String  生日
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
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
	 *方法: 取得更新人
	 *@return: String  更新人
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置更新人
	 *@param: String  更新人
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRdCode() {
		return rdCode;
	}

	public void setRdCode(String rdCode) {
		this.rdCode = rdCode;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getBelongCode() {
		return belongCode;
	}

	public void setBelongCode(String belongCode) {
		this.belongCode = belongCode;
	}
}
