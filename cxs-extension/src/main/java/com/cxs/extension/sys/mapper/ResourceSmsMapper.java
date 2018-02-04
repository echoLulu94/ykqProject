package com.cxs.extension.sys.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.cxs.extension.sys.entity.ResourceSms;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 数据库操作封装类
 * @ClassName: ResourceSmsMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日
 *
 */
@Repository
public interface ResourceSmsMapper extends CoreMapper<ResourceSms> {


	/**
	 * 根据id列表删除
	 * @param ids id列表
	 */
	@Delete("delete from sys_resource_sms where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
