package com.cxs.extension.sys.dto;

import java.io.Serializable;
/**
 * 
 * @Description: 数据对象
 * @ClassName: ResourceSmsDto
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日
 */
public class ResourceSmsDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**资源编号*/
	private String rescCode;
	/**短信类型：1-验证码；2-订单*/
	private String smsType;
	/**模板编号*/
	private String templateCode;
	/**创建时间*/
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
	 *方法: 取得短信类型：1-验证码；2-订单
	 *@return: String  短信类型：1-验证码；2-订单
	 */
	public String getSmsType(){
		return this.smsType;
	}

	/**
	 *方法: 设置短信类型：1-验证码；2-订单
	 *@param: String  短信类型：1-验证码；2-订单
	 */
	public void setSmsType(String smsType){
		this.smsType = smsType;
	}
	
	/**
	 *方法: 取得模板编号
	 *@return: String  模板编号
	 */
	public String getTemplateCode(){
		return this.templateCode;
	}

	/**
	 *方法: 设置模板编号
	 *@param: String  模板编号
	 */
	public void setTemplateCode(String templateCode){
		this.templateCode = templateCode;
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
