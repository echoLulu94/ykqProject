package com.cxs.extension.ath.service.api;

import java.util.List;

import com.cxs.extension.ath.dto.LoginLogHisDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 登录日志历史业务处理接口定义
 * @ClassName: LoginLogHisService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface LoginLogHisService {
	
    /**
     * 保存登录日志历史
     * @param loginLogHisDto 需保存登录日志历史数据对象
     * @return
     */
    ResultDo<LoginLogHisDto> saveLoginLogHis(LoginLogHisDto loginLogHisDto);
    
    /**
     * 根据id删除登录日志历史
     * @param id id
     * @return
     */
    ResultDo<String> deleteLoginLogHisById(String id);
	
    /**
     * 根据id数组批量删除登录日志历史
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteLoginLogHisByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除登录日志历史
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteLoginLogHisByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新登录日志历史信息
	 * @param loginLogHisdto 需更新登录日志历史数据对象
	 * @return
	 */
    ResultDo<LoginLogHisDto> updateLoginLogHis(LoginLogHisDto loginLogHisdto);
    
    /**
     * 根据id查找登录日志历史
     * @param id id
     * @return
     */
    ResultDo<LoginLogHisDto> findLoginLogHisById(String id);
    
    /**
     * 分页查询登录日志历史信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<LoginLogHisDto>> findLoginLogHis(PageDto<LoginLogHisDto> pageDto);
	
	/**
	 * 根据查询条件分页查询登录日志历史对象
	 * @param page 分页对象
	 * @param loginLogHisdto 查询条件
	 * @return
	 */
	ResultDo<PageDto<LoginLogHisDto>> findLoginLogHis(PageDto<LoginLogHisDto> pageDto, LoginLogHisDto loginLogHisdto);
}