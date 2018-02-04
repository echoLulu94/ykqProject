package com.cxs.extension.csr.result;

import java.util.AbstractMap;
import java.util.Map;

/**
*
* @Description: 客户模块接口响应码定义类
*	注：所有成功编码统一为：API1000
* @ClassName: CustomerResult
* @author: ryan.guo
* @email: chinazan@qq.com
* @date: 2017年07月30日
*
*/
public class CustomerResult {
	public static Map.Entry<String,String> ADD_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101010","新增客户初始化数据失败！");
	public static Map.Entry<String,String> ADD_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101011","新增客户初始化数据成功！");
	public static Map.Entry<String,String> SAVE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101110","客户保存失败！");
	public static Map.Entry<String,String> SAVE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101111","客户保存成功！");
	public static Map.Entry<String,String> SAVE_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("CSR101112","客户不能为空！");
	public static Map.Entry<String,String> DELETE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101210","客户删除失败！");
	public static Map.Entry<String,String> DELETE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101211","客户删除成功！");
	public static Map.Entry<String,String> DELETE_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("CSR101212","客户删除,id不能为空！");
	public static Map.Entry<String,String> DELETE_CUSTOMER_NOT_EXIST =  new AbstractMap.SimpleEntry<String, String>("CSR101213","要删除的客户不存在！");
	public static Map.Entry<String,String> DELETE_BY_IDS_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101214","客户批量删除失败！");
	public static Map.Entry<String,String> DELETE_IDS_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("CSR101215","客户批量删除,id列表不能为空！");
	public static Map.Entry<String,String> UPDATE_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101310","客户修改失败！");
	public static Map.Entry<String,String> UPDATE_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101311","客户修改成功！");
	public static Map.Entry<String,String> VIEW_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101410","查找客户详情失败！");
	public static Map.Entry<String,String> VIEW_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101411","查找客户详情成功！");
	public static Map.Entry<String,String> FIND_FAILURE =  new AbstractMap.SimpleEntry<String, String>("CSR101510","客户查询失败！");
	public static Map.Entry<String,String> FIND_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101511","客户查询成功！");
	public static Map.Entry<String,String> FIND_BY_ID_NOT_NULL =  new AbstractMap.SimpleEntry<String, String>("CSR101512","根据客户id查询，id不能为空！");
	public static Map.Entry<String,String> FIND_BY_ID_SUCCESS =  new AbstractMap.SimpleEntry<String, String>("CSR101513","根据客户id查询成功！");
}
