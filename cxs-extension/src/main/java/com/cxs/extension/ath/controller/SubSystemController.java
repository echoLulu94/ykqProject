package com.cxs.extension.ath.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.ath.dto.SubSystemDto;
import com.cxs.extension.ath.result.ResourceResult;
import com.cxs.extension.ath.service.api.SubSystemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 子系统控制器
 * @ClassName: SubSystemController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/ath")
public class SubSystemController {


private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SubSystemService subSystemService;
    
    /*保存子系统*/
    @RequestMapping(value = "/saveSubSystem")
	@ResponseBody
    public ResultDo<SubSystemDto> saveSubSystem(SubSystemDto subSystemDto, HttpServletRequest request){
    	return subSystemService.saveSubSystem(subSystemDto);
	}
    
    /*删除子系统*/
    @RequestMapping(value = "/deleteSubSystem")
	@ResponseBody
    public ResultDo<String> deleteSubSystemById(String id){
    	return subSystemService.deleteSubSystemById(id);
	}

	/*删除子系统*/
    @RequestMapping(value = "/deleteAllSubSystem")
	@ResponseBody
    public ResultDo<String []> deleteAllSubSystem(String [] ids,HttpServletRequest request){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = subSystemService.deleteSubSystemByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(ResourceResult.DELETE_BY_IDS_FAILURE);
			logger.error(ResourceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新子系统*/
    @RequestMapping(value = "/updateSubSystem")
	@ResponseBody
    public ResultDo<SubSystemDto> updateSubSystem(SubSystemDto subSystemDto){
    	return subSystemService.updateSubSystem(subSystemDto);
	}

    /*显示子系统详情*/
	@RequestMapping("/viewSubSystem")
	@ResponseBody
	public ResultDo<SubSystemDto> viewSubSystem(String id){
		logger.info("subSystemId:"+id);
		return subSystemService.findSubSystemById(id);
	}

	/*查询子系统*/
	@RequestMapping("/findSubSystem")
	@ResponseBody
	public ResultDo<PageDto<SubSystemDto>> findSubSystem(PageDto<SubSystemDto> pageDto, SubSystemDto subSystemDto){
		return subSystemService.findSubSystem(pageDto, subSystemDto);
	}
}
