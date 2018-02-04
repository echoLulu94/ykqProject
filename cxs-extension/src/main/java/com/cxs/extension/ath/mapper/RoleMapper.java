package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.cxs.extension.ath.entity.Role;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 角色表数据库操作封装类
 * @ClassName: RoleMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 *
 */
@Repository
public interface RoleMapper extends CoreMapper<Role> {


	/**
	 * 根据id列表删除角色表
	 * @param ids id列表
	 */
	@Delete("delete from ath_role where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
