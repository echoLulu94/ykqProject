package com.cxs.extension.ath.service.api;

import java.util.List;

import com.cxs.extension.ath.dto.LoginLogDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 登录日志业务处理接口定义
 * @ClassName: LoginLogService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface LoginLogService {
	
    /**
     * 保存登录日志
     * @param loginLogDto 需保存登录日志数据对象
     * @return
     */
    ResultDo<LoginLogDto> saveLoginLog(LoginLogDto loginLogDto);
    
    /**
     * 根据id删除登录日志
     * @param id id
     * @return
     */
    ResultDo<String> deleteLoginLogById(String id);
	
    /**
     * 根据id数组批量删除登录日志
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteLoginLogByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除登录日志
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteLoginLogByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新登录日志信息
	 * @param loginLogdto 需更新登录日志数据对象
	 * @return
	 */
    ResultDo<LoginLogDto> updateLoginLog(LoginLogDto loginLogdto);
    
    /**
     * 根据id查找登录日志
     * @param id id
     * @return
     */
    ResultDo<LoginLogDto> findLoginLogById(String id);
    
    /**
     * 分页查询登录日志信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<LoginLogDto>> findLoginLog(PageDto<LoginLogDto> pageDto);
	
	/**
	 * 根据查询条件分页查询登录日志对象
	 * @param page 分页对象
	 * @param loginLogdto 查询条件
	 * @return
	 */
	ResultDo<PageDto<LoginLogDto>> findLoginLog(PageDto<LoginLogDto> pageDto, LoginLogDto loginLogdto);
}