package com.cxs.extension.sys.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @Description: 媒资表实体类
 * @ClassName: Media 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月08日
 */
@Entity
@Table(name = "sys_media", schema = "")
public class Media implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**媒资类型*/
	@Column(name ="file_type",nullable=true)
	private String fileType;
	/**媒资路径标志*/
	@Column(name ="path_flag",nullable=true)
	private String pathFlag;
	/**用户id*/
	@Column(name ="uploader",nullable=true)
	private String uploader;
	/**上传者类型：1-用户；2-客户；3-游客*/
	@Column(name ="uploader_type",nullable=true)
	private String uploaderType;
	/**文件md5值*/
	@Column(name ="file_md5",nullable=true)
	private String fileMd5;
	/**源文件名*/
	@Column(name ="original_filename",nullable=true)
	private String originalFilename;
	/**媒资相对路径*/
	@Column(name ="static_relative_path",nullable=true)
	private String staticRelativePath;
	/**文件名称*/
	@Column(name ="file_name",nullable=true)
	private String fileName;
	/**创建时间*/
	@Column(name ="create_time",nullable=true)
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
	 *方法: 取得媒资类型
	 *@return: String  媒资类型
	 */
	public String getFileType(){
		return this.fileType;
	}

	/**
	 *方法: 设置媒资类型
	 *@param: String  媒资类型
	 */
	public void setFileType(String fileType){
		this.fileType = fileType;
	}
	
	/**
	 *方法: 取得用户id
	 *@return: String  用户id
	 */
	public String getUploader(){
		return this.uploader;
	}

	/**
	 *方法: 设置用户id
	 *@param: String  用户id
	 */
	public void setUploader(String uploader){
		this.uploader = uploader;
	}
	
	/**
	 *方法: 取得上传者类型：1-用户；2-客户；3-游客
	 *@return: String  上传者类型：1-用户；2-客户；3-游客
	 */
	public String getUploaderType(){
		return this.uploaderType;
	}

	/**
	 *方法: 设置上传者类型：1-用户；2-客户；3-游客
	 *@param: String  上传者类型：1-用户；2-客户；3-游客
	 */
	public void setUploaderType(String uploaderType){
		this.uploaderType = uploaderType;
	}
	
	/**
	 *方法: 取得文件md5值
	 *@return: String  文件md5值
	 */
	public String getFileMd5(){
		return this.fileMd5;
	}

	/**
	 *方法: 设置文件md5值
	 *@param: String  文件md5值
	 */
	public void setFileMd5(String fileMd5){
		this.fileMd5 = fileMd5;
	}
	
	/**
	 *方法: 取得源文件名
	 *@return: String  源文件名
	 */
	public String getOriginalFilename(){
		return this.originalFilename;
	}

	/**
	 *方法: 设置源文件名
	 *@param: String  源文件名
	 */
	public void setOriginalFilename(String originalFilename){
		this.originalFilename = originalFilename;
	}
	
	/**
	 *方法: 取得媒资相对路径
	 *@return: String  媒资相对路径
	 */
	public String getStaticRelativePath(){
		return this.staticRelativePath;
	}

	/**
	 *方法: 设置媒资相对路径
	 *@param: String  媒资相对路径
	 */
	public void setStaticRelativePath(String staticRelativePath){
		this.staticRelativePath = staticRelativePath;
	}
	
	/**
	 *方法: 取得文件名称
	 *@return: String  文件名称
	 */
	public String getFileName(){
		return this.fileName;
	}

	/**
	 *方法: 设置文件名称
	 *@param: String  文件名称
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
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

	public String getPathFlag() {
		return pathFlag;
	}

	public void setPathFlag(String pathFlag) {
		this.pathFlag = pathFlag;
	}
	
}
