package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxs.extension.ath.entity.SubSystem;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 子系统数据库操作封装类
 * @ClassName: SubSystemMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface SubSystemMapper extends CoreMapper<SubSystem> {

	/**
	 * 根据id列表删除子系统
	 * @param ids
	 */
	@Delete("delete from ath_sub_system where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

	/**
	 * 根据子系统编号查找
	 * @param subSysCode 子系统编号
	 * @return
	 */
	@Select("select * from ath_sub_system where sub_sys_code = #{subSysCode}")
	SubSystem selectByCode(@Param("subSysCode") String subSysCode);

	/**
	 * 根据子系统编号和id查找不重复的子系统
	 * @param id id
	 * @param subSysCode 子系统编号
	 * @return
	 */
	@Select("select * from ath_sub_system where id <> #{id} and sub_sys_code = #{subSysCode}")
	SubSystem selectByCodeAndId(@Param("id") String id, @Param("subSysCode") String subSysCode);
}
