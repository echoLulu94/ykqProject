package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.cxs.extension.ath.entity.Menu;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 菜单数据库操作封装类
 * @ClassName: MenuMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 *
 */
@Repository
public interface MenuMapper extends CoreMapper<Menu> {


	/**
	 * 根据id列表删除菜单
	 * @param ids id列表
	 */
	@Delete("delete from ath_menu where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
