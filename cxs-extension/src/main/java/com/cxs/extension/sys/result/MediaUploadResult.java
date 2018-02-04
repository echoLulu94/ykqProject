package com.cxs.extension.sys.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: MediaUploadResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class MediaUploadResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1010","新增初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","新增初始化数据成功！");

	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1110","保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS1112","不能为空！");

	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1210","删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS1212","删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_MEDIAUPLOAD_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("SYS1213","要删除的不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1214","批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS1215","批量删除,id列表不能为空！");

	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1310","修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","修改成功！");

	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1410","查找详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","查找详情成功！");

	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS1510","查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS1512","根据id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","根据id查询成功！");

}
