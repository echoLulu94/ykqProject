package com.cxs.extension.ath.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxs.extension.ath.entity.Module;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 模块数据库操作封装类
 * @ClassName: ModuleMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface ModuleMapper extends CoreMapper<Module> {

	/**
	 * 根据id列表删除模块
	 * @param ids id列表
	 */
	@Delete("delete from ath_module where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

	/**
	 * 根据模块编号查找
	 * @param subSysCode 子系统编号
	 * @param modCode 模块编号
	 * @return
	 */
	@Select("select * from ath_module where sub_sys_code = #{subSysCode} and mod_code = #{modCode}")
	Module selectByCodes(@Param("subSysCode") String subSysCode, @Param("modCode") String modCode);

	/**
	 * 根据子系统编号查找模块列表
	 * @param subSysCode 子系统编号
	 * @return
	 */
	@Select("select mod_code modCode, mod_name modName from ath_module where sub_sys_code = #{subSysCode}")
	List<Module> selectBySubSysCode(@Param("subSysCode") String subSysCode);

	/**
	 * 根据子系统编号、模块编号、id查找是否可修改
	 * @param id id
	 * @param subSysCode 子系统编号
	 * @param modCode 模块编号
	 * @return
	 */
	@Select("select * from ath_module where id<>#{id} and sub_sys_code = #{subSysCode} and mod_code = #{modCode}")
	Module selectByCodesAndId(@Param("id") String id, @Param("subSysCode") String subSysCode, @Param("modCode") String modCode);

}
