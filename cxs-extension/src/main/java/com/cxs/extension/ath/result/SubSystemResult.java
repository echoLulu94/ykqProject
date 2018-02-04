package com.cxs.extension.ath.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 子系统模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: SubSystemResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class SubSystemResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101010","新增子系统初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101011","新增子系统初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101110","子系统保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101111","子系统保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101112","子系统不能为空！");
	public static Map.Entry<String,String> SAVE_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH101113","子系统编码已经存在！");
	public static Map.Entry<String,String> SAVE_SUBSYSCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101114","子系统编码不能为空！");
	public static Map.Entry<String,String> SAVE_SUBSYSNAME_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101115","子系统名称不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101210","子系统删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101211","子系统删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101212","子系统删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_SUBSYSTEM_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("ATH101213","要删除的子系统不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101214","子系统批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101215","子系统批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101310","子系统修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101311","子系统修改成功！");
	public static Map.Entry<String,String> UPDATE_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH101312","子系统已经存在，与现有子系统冲突！");
	public static Map.Entry<String,String> UPDATE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101313","子系统ID不能为空！");
	public static Map.Entry<String,String> UPDATE_SUBSYSCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101314","子系统编码不能为空！");
	public static Map.Entry<String,String> UPDATE_SUBSYSNAME_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101315","子系统名称不能为空！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101410","查找子系统详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101411","查找子系统详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH101510","子系统查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101511","子系统查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101512","根据子系统id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH101513","根据子系统id查询成功！");
	public static Map.Entry<String,String> FIND_BY_CODE_NOT_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH101514","根据子系统编码查询,子系统不存在！");
	public static Map.Entry<String,String> FIND_CODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH101515","子系统不能为空！");
	
}
