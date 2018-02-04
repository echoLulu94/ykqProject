package com.cxs.extension.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.sys.dto.ResourceSmsDto;
import com.cxs.extension.sys.entity.ResourceSms;
import com.cxs.extension.sys.mapper.ResourceSmsMapper;
import com.cxs.extension.sys.result.ResourceSmsResult;
import com.cxs.extension.sys.service.api.ResourceSmsService;
import com.cxs.extension.sys.utils.ResourceSmsParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @Description: 业务处理实现类
 * @ClassName: ResourceSmsServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日 
 *
 */
@Service
public class ResourceSmsServiceImpl implements ResourceSmsService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResourceSmsMapper resourceSmsMapper;

	@Override
	public ResultDo<ResourceSmsDto> saveResourceSms(ResourceSmsDto resourceSmsDto) {
		ResultDo<ResourceSmsDto> resultDo = new ResultDo<ResourceSmsDto>();
		ResourceSms resourceSms =new ResourceSms();
		try{
			if(null!=resourceSmsDto){
				resourceSmsDto.setId(IdUtil.getUuid());
				ResourceSmsParseUtil.parseToEntity(resourceSmsDto,resourceSms);
				resourceSmsMapper.insert(resourceSms);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(ResourceSmsResult.SAVE_FAILURE);
				logger.error(ResourceSmsResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.SAVE_FAILURE);
			logger.error(ResourceSmsResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceSmsDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteResourceSmsById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = resourceSmsMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(ResourceSmsResult.DELETE_RESOURCESMS_NOT_EXIST);
					logger.info(ResourceSmsResult.DELETE_RESOURCESMS_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(ResourceSmsResult.DELETE_ID_NOT_NULL);
				logger.error(ResourceSmsResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.DELETE_FAILURE);
			logger.error(ResourceSmsResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteResourceSmsByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			resourceSmsMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(ResourceSmsResult.DELETE_IDS_NOT_NULL);
				logger.error(ResourceSmsResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.DELETE_BY_IDS_FAILURE);
			logger.error(ResourceSmsResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteResourceSmsByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			resourceSmsMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(ResourceSmsResult.DELETE_IDS_NOT_NULL);
				logger.error(ResourceSmsResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(ResourceSmsResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<ResourceSmsDto> updateResourceSms(ResourceSmsDto resourceSmsDto) {
		ResultDo<ResourceSmsDto> resultDo = new ResultDo<ResourceSmsDto>();
		ResourceSms resourceSms = new ResourceSms();
		try{
			ResourceSmsParseUtil.parseToEntity(resourceSmsDto,resourceSms);
			resourceSmsMapper.updateByPrimaryKeySelective(resourceSms);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.UPDATE_FAILURE);
			logger.error(ResourceSmsResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceSmsDto);
		return resultDo;
	}

	@Override
	public ResultDo<ResourceSmsDto> findResourceSmsById(String id) {
		ResourceSmsDto resourceSmsDto = new ResourceSmsDto();
		ResultDo<ResourceSmsDto> resultDo = new ResultDo<ResourceSmsDto>();
		try{
			if(null!=id&&!"".equals(id)){
				ResourceSms resourceSms = resourceSmsMapper.selectByPrimaryKey(id);
				ResourceSmsParseUtil.parseToDto(resourceSms,resourceSmsDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(ResourceSmsResult.FIND_BY_ID_NOT_NULL);
				logger.error(ResourceSmsResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.FIND_FAILURE);
			logger.error(ResourceSmsResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceSmsDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<ResourceSmsDto>> findResourceSms(PageDto<ResourceSmsDto> pageDto) {
		logger.debug("debug test");
		List<ResourceSmsDto> resourceSmsDtoList = new ArrayList<ResourceSmsDto>();
		List<ResourceSms> resourceSmsList = null;
		ResultDo<PageDto<ResourceSmsDto>> resultDo=new ResultDo<PageDto<ResourceSmsDto>>();
		try{
			pageDto.setTotalRecord(resourceSmsMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			resourceSmsList = resourceSmsMapper.selectAll();
			ResourceSmsParseUtil.parseToDtoList(resourceSmsList,resourceSmsDtoList);
			pageDto.setPageData(resourceSmsDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.FIND_FAILURE);
			logger.error(ResourceSmsResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<ResourceSmsDto>> findResourceSms(PageDto<ResourceSmsDto> pageDto, ResourceSmsDto resourceSmsDto) {
        List<ResourceSmsDto> resourceSmsDtoList = new ArrayList<ResourceSmsDto>();
		ResultDo<PageDto<ResourceSmsDto>> resultDo = new ResultDo<PageDto<ResourceSmsDto>>();
        List<ResourceSms> resourceSmsList=null;
		try{
			ResourceSms example = new ResourceSms();
			// TODO 设置查询条件	
			pageDto.setTotalRecord(resourceSmsMapper.selectCount(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			resourceSmsList = resourceSmsMapper.select(example);
			ResourceSmsParseUtil.parseToDtoList(resourceSmsList,resourceSmsDtoList);
			pageDto.setPageData(resourceSmsDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(ResourceSmsResult.FIND_FAILURE);
			logger.error(ResourceSmsResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}
}