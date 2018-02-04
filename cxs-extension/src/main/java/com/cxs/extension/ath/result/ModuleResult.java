package com.cxs.extension.ath.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 模块模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: ModuleResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class ModuleResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111010","新增模块初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111011","新增模块初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111110","模块保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111111","模块保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111112","模块不能为空！");
	public static Map.Entry<String,String> SAVE_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH111113","模块已经存在！");
	public static Map.Entry<String,String> SAVE_MODCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111114","模块编码不能为空！");
	public static Map.Entry<String,String> SAVE_SUBSYSCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111115","模块所属系统编码不能为空！");
	public static Map.Entry<String,String> SAVE_MODNAME_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111116","模块名称不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111210","模块删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111211","模块删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111212","模块删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_MODULE_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("ATH111213","要删除的模块不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111214","模块批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111215","模块批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111310","模块修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111311","模块修改成功！");
	public static Map.Entry<String,String> UPDATE_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH111312","模块已经存在，与现有模块冲突！");
	public static Map.Entry<String,String> UPDATE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111313","模块ID不能为空！");
	public static Map.Entry<String,String> UPDATE_MODCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111314","模块编码不能为空！");
	public static Map.Entry<String,String> UPDATE_SUBSYSCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111315","模块所属系统编码不能为空！");
	public static Map.Entry<String,String> UPDATE_MODNAME_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111316","模块名称不能为空！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111410","查找模块详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111411","查找模块详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH111510","模块查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111511","模块查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH111512","根据模块id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH111513","根据模块id查询成功！");
	
}
