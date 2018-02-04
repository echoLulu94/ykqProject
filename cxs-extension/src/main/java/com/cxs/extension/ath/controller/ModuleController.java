package com.cxs.extension.ath.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.ath.dto.ModuleDto;
import com.cxs.extension.ath.result.ModuleResult;
import com.cxs.extension.ath.service.api.ModuleService;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 模块控制器
 * @ClassName: ModuleController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/ath")
public class ModuleController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ModuleService moduleService;
    
    /*保存模块*/
    @RequestMapping(value = "/saveModule")
	@ResponseBody
	@NoAuth
    public ResultDo<ModuleDto> saveModule(ModuleDto moduleDto){
    	return moduleService.saveModule(moduleDto);
	}
    
    /*删除模块*/
    @RequestMapping(value = "/deleteModule")
	@ResponseBody
	@NoAuth
    public ResultDo<String> deleteModuleById(String id){
    	return moduleService.deleteModuleById(id);
	}

	/*删除模块*/
    @RequestMapping(value = "/deleteAllModule")
	@ResponseBody
	@NoAuth
    public ResultDo<String []> deleteAllModule(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = moduleService.deleteModuleByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.DELETE_BY_IDS_FAILURE);
			logger.error(ModuleResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新模块*/
    @RequestMapping(value = "/updateModule")
	@ResponseBody
	@NoAuth
    public ResultDo<ModuleDto> updateModule(ModuleDto moduleDto){
    	return moduleService.updateModule(moduleDto);
	}

    /*显示模块详情*/
	@RequestMapping("/viewModule")
	@ResponseBody
	@NoAuth
	public ResultDo<ModuleDto> viewModule(String id){
		logger.info("moduleId:"+id);
		return moduleService.findModuleById(id);
	}

	/*查询模块*/
	@RequestMapping("/findModule")
	@ResponseBody
	@NoAuth
	public ResultDo<PageDto<ModuleDto>> findModule(PageDto<ModuleDto> pageDto, ModuleDto moduleDto){
		return moduleService.findModule(pageDto, moduleDto);
	}

	/*根据子系统编号查询模块列表*/
	@RequestMapping("/fbsc")
	@ResponseBody
	@NoAuth
	public ResultDo<List<ModuleDto>> fbsc(String subSysCode){
		return moduleService.findBySubSysCode(subSysCode);
	}
	
	/*根据模块查询模块资源列表*/
	@RequestMapping("/getModTree")
	@ResponseBody
	@NoAuth
	public ResultDo<List<Map<String,Object>>> getModTree(){
		return moduleService.getModTree();
	}
}
