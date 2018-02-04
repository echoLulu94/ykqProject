package com.cxs.extension.sys.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: ResourceSmsResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class ResourceSmsResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141010","新增初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141011","新增初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141110","保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141111","保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS141112","不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141210","删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141211","删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS141212","删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_RESOURCESMS_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("SYS141213","要删除的不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141214","批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS141215","批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141310","修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141311","修改成功！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141410","查找详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141411","查找详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("SYS141510","查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141511","查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("SYS141512","根据id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("SYS141513","根据id查询成功！");
}
