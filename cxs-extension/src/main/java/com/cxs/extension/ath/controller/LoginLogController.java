package com.cxs.extension.ath.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.ath.dto.LoginLogDto;
import com.cxs.extension.ath.result.LoginLogResult;
import com.cxs.extension.ath.service.api.LoginLogService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 登录日志控制器
 * @ClassName: LoginLogController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/ath")
public class LoginLogController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginLogService loginLogService;
    
    /*保存登录日志*/
    @RequestMapping(value = "/saveLoginLog")
	@ResponseBody
    public ResultDo<LoginLogDto> saveLoginLog(LoginLogDto loginLogDto){
    	return loginLogService.saveLoginLog(loginLogDto);
	}
    
    /*删除登录日志*/
    @RequestMapping(value = "/deleteLoginLog")
	@ResponseBody
    public ResultDo<String> deleteLoginLogById(String id){
    	return loginLogService.deleteLoginLogById(id);
	}

	/*删除登录日志*/
    @RequestMapping(value = "/deleteAllLoginLog")
	@ResponseBody
    public ResultDo<String []> deleteAllLoginLog(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = loginLogService.deleteLoginLogByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.DELETE_BY_IDS_FAILURE);
			logger.error(LoginLogResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新登录日志*/
    @RequestMapping(value = "/updateLoginLog")
	@ResponseBody
    public ResultDo<LoginLogDto> updateLoginLog(LoginLogDto loginLogDto){
    	return loginLogService.updateLoginLog(loginLogDto);
	}

    /*显示登录日志详情*/
	@RequestMapping("/viewLoginLog")
	@ResponseBody
	public ResultDo<LoginLogDto> viewLoginLog(String id){
		logger.info("loginLogId:"+id);
		return loginLogService.findLoginLogById(id);
	}

	/*查询登录日志*/
	@RequestMapping("/findLoginLog")
	@ResponseBody
	public ResultDo<PageDto<LoginLogDto>> findLoginLog(PageDto<LoginLogDto> pageDto, LoginLogDto loginLogDto){
		return loginLogService.findLoginLog(pageDto, loginLogDto);
	}
}
