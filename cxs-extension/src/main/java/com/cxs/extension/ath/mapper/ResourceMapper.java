package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxs.extension.ath.entity.Resource;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 资源数据库操作封装类
 * @ClassName: ResourceMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface ResourceMapper extends CoreMapper<Resource> {

	/**
	 * 根据id列表删除资源
	 * @param ids id列表
	 */
	@Delete("delete from ath_resource where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

	/**
	 * 根据资源编号查找资源
	 * @param rescCode 资源编号
	 * @return
	 */
	@Select("select * from ath_resource where resc_code = #{rescCode}")
	Resource selectByRescCode(@Param("rescCode") String rescCode);

	/**
	 * 根据子系统编号、模块编码、资源编号查找资源
	 * @param subSysCode 子系统编号
	 * @param modCode 模块编号
	 * @param rescCode 资源编号
	 * @return
	 */
	@Select("select * from ath_resource where sub_sys_code = #{subSysCode} and mod_code = #{modCode} and resc_code = #{rescCode}")
	Resource selectByCodes(@Param("subSysCode") String subSysCode, @Param("modCode") String modCode, @Param("rescCode") String rescCode);

	/**
	 * 根据子系统编号、模块编码、资源编号和资源ID查找是否可修改
	 * @param id id
	 * @param subSysCode 子系统编号
	 * @param modCode 模块编号
	 * @param rescCode 资源编号
	 * @return
	 */
	@Select("select * from ath_resource where id<>#{id} and sub_sys_code = #{subSysCode} and mod_code = #{modCode} and resc_code = #{rescCode}")
	Resource selectByCodesAndId(@Param("id") String id, @Param("subSysCode") String subSysCode, @Param("modCode") String modCode, @Param("rescCode") String rescCode);

	/**
	 * 根据模块编号查找资源
	 * @param modCode 模块编号
	 * @return
	 */
	@Select("select count(0) from ath_resource where mod_code = #{modCode}")
	Integer selectCountByModCode(@Param("modCode") String modCode);
}
