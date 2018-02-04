package com.cxs.extension.ath.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 登录日志历史模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: LoginLogHisResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class LoginLogHisResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161010","新增登录日志历史初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161011","新增登录日志历史初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161110","登录日志历史保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161111","登录日志历史保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH161112","登录日志历史不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161210","登录日志历史删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161211","登录日志历史删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH161212","登录日志历史删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_LOGINLOGHIS_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("ATH161213","要删除的登录日志历史不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161214","登录日志历史批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH161215","登录日志历史批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161310","登录日志历史修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161311","登录日志历史修改成功！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161410","查找登录日志历史详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161411","查找登录日志历史详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH161510","登录日志历史查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161511","登录日志历史查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH161512","根据登录日志历史id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH161513","根据登录日志历史id查询成功！");
}
