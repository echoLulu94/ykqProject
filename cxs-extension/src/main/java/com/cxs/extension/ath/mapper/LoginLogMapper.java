package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.cxs.extension.ath.entity.LoginLog;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 登录日志数据库操作封装类
 * @ClassName: LoginLogMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface LoginLogMapper extends CoreMapper<LoginLog> {

	/**
	 * 根据id列表删除登录日志
	 * @param ids
	 */
	@Delete("delete from ath_login_log where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
