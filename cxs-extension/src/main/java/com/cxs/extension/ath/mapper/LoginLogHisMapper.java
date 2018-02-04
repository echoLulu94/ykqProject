package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.cxs.extension.ath.entity.LoginLogHis;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 登录日志历史数据库操作封装类
 * @ClassName: LoginLogHisMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface LoginLogHisMapper extends CoreMapper<LoginLogHis> {

	/**
	 * 根据id列表删除  登录日志历史
	 * @param ids
	 */
	@Delete("delete from ath_login_log_his where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
