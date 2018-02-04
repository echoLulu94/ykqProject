package com.cxs.extension.ath.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.ath.dto.LoginLogHisDto;
import com.cxs.extension.ath.result.LoginLogHisResult;
import com.cxs.extension.ath.service.api.LoginLogHisService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 登录日志历史控制器
 * @ClassName: LoginLogHisController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/ath")
public class LoginLogHisController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginLogHisService loginLogHisService;
    
    /*保存登录日志历史*/
    @RequestMapping(value = "/saveLoginLogHis")
	@ResponseBody
    public ResultDo<LoginLogHisDto> saveLoginLogHis(LoginLogHisDto loginLogHisDto){
    	return loginLogHisService.saveLoginLogHis(loginLogHisDto);
	}
    
    /*删除登录日志历史*/
    @RequestMapping(value = "/deleteLoginLogHis")
	@ResponseBody
    public ResultDo<String> deleteLoginLogHisById(String id){
    	return loginLogHisService.deleteLoginLogHisById(id);
	}

	/*删除登录日志历史*/
    @RequestMapping(value = "/deleteAllLoginLogHis")
	@ResponseBody
    public ResultDo<String []> deleteAllLoginLogHis(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = loginLogHisService.deleteLoginLogHisByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.DELETE_BY_IDS_FAILURE);
			logger.error(LoginLogHisResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新登录日志历史*/
    @RequestMapping(value = "/updateLoginLogHis")
	@ResponseBody
    public ResultDo<LoginLogHisDto> updateLoginLogHis(LoginLogHisDto loginLogHisDto){
    	return loginLogHisService.updateLoginLogHis(loginLogHisDto);
	}

    /*显示登录日志历史详情*/
	@RequestMapping("/viewLoginLogHis")
	@ResponseBody
	public ResultDo<LoginLogHisDto> viewLoginLogHis(String id){
		logger.info("loginLogHisId:"+id);
		return loginLogHisService.findLoginLogHisById(id);
	}

	/*查询登录日志历史*/
	@RequestMapping("/findLoginLogHis")
	@ResponseBody
	public ResultDo<PageDto<LoginLogHisDto>> findLoginLogHis(PageDto<LoginLogHisDto> pageDto, LoginLogHisDto loginLogHisDto){
		return loginLogHisService.findLoginLogHis(pageDto, loginLogHisDto);
	}
}
