package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.cxs.extension.ath.entity.Device;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 登录设备数据库操作封装类
 * @ClassName: DeviceMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface DeviceMapper extends CoreMapper<Device> {

	/**
	 * 根据id列表删除 登录设备
	 * @param ids
	 */
	@Delete("delete from ath_device where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
