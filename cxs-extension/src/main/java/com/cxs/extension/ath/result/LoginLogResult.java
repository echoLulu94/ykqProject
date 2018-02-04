package com.cxs.extension.ath.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 登录日志模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: LoginLogResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class LoginLogResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151010","新增登录日志初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151011","新增登录日志初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151110","登录日志保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151111","登录日志保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH151112","登录日志不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151210","登录日志删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151211","登录日志删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH151212","登录日志删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_LOGINLOG_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("ATH151213","要删除的登录日志不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151214","登录日志批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH151215","登录日志批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151310","登录日志修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151311","登录日志修改成功！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151410","查找登录日志详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151411","查找登录日志详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH151510","登录日志查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151511","登录日志查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH151512","根据登录日志id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH151513","根据登录日志id查询成功！");
}
