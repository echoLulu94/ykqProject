package com.cxs.extension.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxs.extension.core.utils.CoreMapper;
import com.cxs.extension.sys.entity.Media;

/**
 * 
 * @Description: 媒资数据库操作封装类
 * @ClassName: MediaMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface MediaMapper extends CoreMapper<Media> {

	/**
	 * 根据id列表删除媒资
	 * @param ids
	 */
	@Delete("delete from sys_media where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

	/**
	 * 根据id列表
	 * @param ids
	 */
	@Select("select id, file_type as fileType, path_flag as pathFlag, file_name as fileName,static_relative_path as staticRelativePath  from sys_media where id in (${ids})")
	List<Map<String,String>> selectByIdList(@Param("ids") String ids);

	

}
