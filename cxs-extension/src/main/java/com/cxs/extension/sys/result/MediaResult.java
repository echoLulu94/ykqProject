package com.cxs.extension.sys.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 媒资模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: MediaResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class MediaResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121010","新增媒资初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121011","新增媒资初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121110","媒资保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121111","媒资保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS121112","媒资不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121210","媒资删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121211","媒资删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS121212","媒资删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_MEDIA_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("SYS121213","要删除的媒资不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121214","媒资批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS121215","媒资批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121310","媒资修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121311","媒资修改成功！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121410","查找媒资详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121411","查找媒资详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121510","媒资查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121511","媒资查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS121512","根据媒资id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121513","根据媒资id查询成功！");
	public static Map.Entry<String,String> UPLOAD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121610","上传图片失败！");
	public static Map.Entry<String,String> UPLOAD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS121611","上传图片成功！");
	public static Map.Entry<String,String> UPLOAD_SAVE_FILE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS121612","上传图片，保存图片失败！");

}
