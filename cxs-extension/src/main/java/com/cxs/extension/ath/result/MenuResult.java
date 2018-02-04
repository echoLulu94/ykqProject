package com.cxs.extension.ath.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 菜单模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: MenuResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年09月19日
*
*/
public class MenuResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1010","新增菜单初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","新增菜单初始化数据成功！");

	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1110","菜单保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","菜单保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH1112","菜单不能为空！");

	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1210","菜单删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","菜单删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH1212","菜单删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_MENU_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("ATH1213","要删除的菜单不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1214","菜单批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH1215","菜单批量删除,id列表不能为空！");

	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1310","菜单修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","菜单修改成功！");

	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1410","查找菜单详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","查找菜单详情成功！");

	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH1510","菜单查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","菜单查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH1512","根据菜单id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("API1000","根据菜单id查询成功！");

}
