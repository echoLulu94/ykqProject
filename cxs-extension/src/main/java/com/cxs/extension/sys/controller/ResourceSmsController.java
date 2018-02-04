package com.cxs.extension.sys.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.sys.dto.ResourceSmsDto;
import com.cxs.extension.sys.result.ResourceSmsResult;
import com.cxs.extension.sys.service.api.ResourceSmsService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 控制器
 * @ClassName: ResourceSmsController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日
 */
@Controller
@RequestMapping("/sys")
public class ResourceSmsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResourceSmsService resourceSmsService;
    
    /*保存*/
    @RequestMapping(value = "/saveResourceSms")
	@ResponseBody
    public ResultDo<ResourceSmsDto> saveResourceSms(ResourceSmsDto resourceSmsDto){
    	return resourceSmsService.saveResourceSms(resourceSmsDto);
	}
    
    /*删除*/
    @RequestMapping(value = "/deleteResourceSms")
	@ResponseBody
    public ResultDo<String> deleteResourceSmsById(String id){
    	return resourceSmsService.deleteResourceSmsById(id);
	}

	/*删除*/
    @RequestMapping(value = "/deleteAllResourceSms")
	@ResponseBody
    public ResultDo<String []> deleteAllResourceSms(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = resourceSmsService.deleteResourceSmsByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.DELETE_BY_IDS_FAILURE);
			logger.error(ResourceSmsResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新*/
    @RequestMapping(value = "/updateResourceSms")
	@ResponseBody
    public ResultDo<ResourceSmsDto> updateResourceSms(ResourceSmsDto resourceSmsDto){
    	return resourceSmsService.updateResourceSms(resourceSmsDto);
	}

    /*显示详情*/
	@RequestMapping("/viewResourceSms")
	@ResponseBody
	public ResultDo<ResourceSmsDto> viewResourceSms(String id){
		logger.info("resourceSmsId:"+id);
		return resourceSmsService.findResourceSmsById(id);
	}

	/*查询*/
	@RequestMapping("/findResourceSms")
	@ResponseBody
	public ResultDo<PageDto<ResourceSmsDto>> findResourceSms(PageDto<ResourceSmsDto> pageDto, ResourceSmsDto resourceSmsDto){
		return resourceSmsService.findResourceSms(pageDto, resourceSmsDto);
	}
}
