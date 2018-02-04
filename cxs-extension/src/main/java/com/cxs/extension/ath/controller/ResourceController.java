package com.cxs.extension.ath.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cxs.extension.ath.dto.ResourceDto;
import com.cxs.extension.ath.result.ResourceResult;
import com.cxs.extension.ath.service.api.ResourceService;
import com.cxs.extension.ath.service.api.SubSystemService;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;

/**
 * 
 * @Description: 资源控制器
 * @ClassName: ResourceController
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/ath")
public class ResourceController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private SubSystemService subSystemService;
	@Autowired
	private DictItemService dictItemService;

	/* 新增资源 */
	@RequestMapping(value = "/addResource")
	@ResponseBody
	public ResultDo<Map<String,Object>> addResource(ResourceDto resourceDto) {
		ResultDo<Map<String,Object>> resultDo = new ResultDo<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map.put("subSystemList", subSystemService.findAll().getResultData());
			map.put("rescUriTypeList", dictItemService.findByTypeCode("RESC_URI_TYPE").getResultData());
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch(Exception e){
			resultDo.setResultDo(ResourceResult.ADD_FAILURE);
			logger.error(ResourceResult.ADD_FAILURE.getValue(), e);
		}
		resultDo.setResultData(map);
		return resultDo;
	}

	/* 保存资源 */
	@RequestMapping(value = "/saveResource")
	@ResponseBody
	public ResultDo<ResourceDto> saveResource(ResourceDto resourceDto) {
		return resourceService.saveResource(resourceDto);
	}

	/* 删除资源 */
	@RequestMapping(value = "/deleteResource")
	@ResponseBody
	public ResultDo<String> deleteResourceById(String id) {
		return resourceService.deleteResourceById(id);
	}

	/* 删除资源 */
	@RequestMapping(value = "/deleteAllResource")
	@ResponseBody
	public ResultDo<String[]> deleteAllResource(String[] ids) {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try {
			resultDo = resourceService.deleteResourceByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(ResourceResult.DELETE_BY_IDS_FAILURE);
			logger.error(ResourceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}

	/* 更新资源 */
	@RequestMapping(value = "/updateResource")
	@ResponseBody
	public ResultDo<ResourceDto> updateResource(ResourceDto resourceDto) {
		return resourceService.updateResource(resourceDto);
	}

	/* 显示资源详情 */
	@RequestMapping("/viewResource")
	@ResponseBody
	public ResultDo<Map<String,Object>> viewResource(String id) {
		ResultDo<Map<String,Object>> resultDo = new ResultDo<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subSystemList", subSystemService.findAll().getResultData());
		map.put("rescUriTypeList", dictItemService.findByTypeCode("RESC_URI_TYPE").getResultData());
		ResultDo<ResourceDto> resourceResultDo = resourceService.findResourceById(id);
		map.put("resourceDto", resourceResultDo.getResultData());
		resultDo.setResultData(map);
		resultDo.setResultDo(resourceResultDo.getResultCode(),resourceResultDo.getResultMsg());
		
		return resultDo;
	}

	/* 查询资源 */
	@RequestMapping("/findResource")
	@ResponseBody
	public ResultDo<PageDto<ResourceDto>> findResource(PageDto<ResourceDto> pageDto, ResourceDto resourceDto) {
		return resourceService.findResource(pageDto, resourceDto);
	}

	/**
	 * 导入资源
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/importResource")
	@ResponseBody
	@NoAuth
	public ResultDo<Boolean> importResource(@RequestParam(value = "file", required = false) MultipartFile file) {
		ResultDo<Boolean> resultDo  = new ResultDo<Boolean>();
//		if (file.isEmpty()) {
//			resultDo.setResult(InterfaceState.FAILURE, ResourceResult.getMap(ResourceResult.IMPORT_FILE_NOT_NULL));
//			logger.error(ResourceResult.IMPORT_FILE_NOT_NULL.getValue());
//		}else{
//			try {
//				resultDo  =resourceService.importResource(file);
//			} catch (IOException e) {
//				resultDo.setResult(InterfaceState.FAILURE, ResourceResult.getMap(ResourceResult.IMPORT_ERROR));
//				logger.error(ResourceResult.IMPORT_ERROR.getValue());
//			}
//		}
		try {
			resultDo  =resourceService.importResource(file);
		} catch (IOException e) {
			resultDo.setResultDo(ResourceResult.IMPORT_ERROR);
			logger.error(ResourceResult.IMPORT_ERROR.getValue(), e);
		}
		return resultDo;
	}

	/*导出excel*/
	@RequestMapping("/exportResource")
	@ResponseBody
	public ResultDo<String> exportResource(){
		try {
			return resourceService.exportResource();
		} catch (IOException e) {
//			后期实现
			return null;
		}
	}
}
