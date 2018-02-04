package com.cxs.extension.ath.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 资源模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: ResourceResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class ResourceResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131010","新增资源初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131011","新增资源初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131110","资源保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131111","资源保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131112","资源不能为空！");
	public static Map.Entry<String,String> SAVE_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH131113","资源已经存在！");
	public static Map.Entry<String,String> SAVE_RESCCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131114","资源编码不能为空！");
	public static Map.Entry<String,String> SAVE_MODCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131115","资源所属模块编码不能为空！");
	public static Map.Entry<String,String> SAVE_SUBSYSCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131116","资源所属系统编码不能为空！");
	public static Map.Entry<String,String> SAVE_RESCNAME_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131117","资源名称不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131210","资源删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131211","资源删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131212","资源删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_RESOURCE_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("ATH131213","要删除的资源不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131214","资源批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131215","资源批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131310","资源修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131311","资源修改成功！");
	public static Map.Entry<String,String> UPDATE_EXISTS =  new AbstractMap.SimpleEntry<String, String>("ATH131312","资源已经存在，与现有资源冲突！");
	public static Map.Entry<String,String> UPDATE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131313","资源ID不能为空！");
	public static Map.Entry<String,String> UPDATE_RESCCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131314","资源编码不能为空！");
	public static Map.Entry<String,String> UPDATE_MODCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131315","资源所属模块编码不能为空！");
	public static Map.Entry<String,String> UPDATE_SUBSYSCODE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131316","资源所属系统编码不能为空！");
	public static Map.Entry<String,String> UPDATE_RESCNAME_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131317","资源名称不能为空！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131410","查找资源详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131411","查找资源详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("ATH131510","资源查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131511","资源查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131512","根据资源id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131513","根据资源id查询成功！");
	public static Map.Entry<String,String> FIND_RESOURCE_COUNT_ERROR =  new AbstractMap.SimpleEntry<String, String>("ATH131514","查询资源总数失败！");
	public static Map.Entry<String,String> IMPORT_ERROR =  new AbstractMap.SimpleEntry<String, String>("ATH131610","导入资源失败！");
	public static Map.Entry<String,String> IMPORT_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("ATH131611","导入资源成功！");
	public static Map.Entry<String,String> IMPORT_FILE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131612","导入资源文件不能为空！");
	public static Map.Entry<String,String> IMPORT_LIST_NULL =  new AbstractMap.SimpleEntry<String, String>("ATH131613","导入资源文件为空，无需导入！");

}
