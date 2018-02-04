package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.ath.dto.SubSystemDto;
import com.cxs.extension.ath.entity.SubSystem;
import com.cxs.extension.ath.mapper.SubSystemMapper;
import com.cxs.extension.ath.result.SubSystemResult;
import com.cxs.extension.ath.service.api.SubSystemService;
import com.cxs.extension.ath.utils.SubSystemParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.cxs.framework.utils.StringUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 子系统业务处理实现类
 * @ClassName: SubSystemServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
@Service
public class SubSystemServiceImpl implements SubSystemService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SubSystemMapper subSystemMapper;

	@Override
	public ResultDo<SubSystemDto> saveSubSystem(SubSystemDto subSystemDto) {
		ResultDo<SubSystemDto> resultDo = new ResultDo<SubSystemDto>();
		SubSystem subSystem =new SubSystem();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=subSystemDto){
				if(StringUtil.isNotEmpty(subSystemDto.getSubSysCode())){
					if(StringUtil.isNotEmpty(subSystemDto.getSubSysName())){
						SubSystem subSystemTemp = subSystemMapper.selectByCode(subSystemDto.getSubSysCode());
						if(null!=subSystemTemp){
							resultDo.setResultDo(SubSystemResult.SAVE_EXISTS);
							logger.info(SubSystemResult.SAVE_EXISTS.getValue());
						}else{
							subSystemDto.setId(IdUtil.getUuid());
							subSystemDto.setCreateTime(time);
							subSystemDto.setUpdateTime(time);
							SubSystemParseUtil.parseToEntity(subSystemDto,subSystem);
							subSystemMapper.insert(subSystem);
							resultDo.setResultDo(InterfaceResult.SUCCESS);
							logger.info(InterfaceResult.SUCCESS.getValue());
						}
					}else{
						resultDo.setResultDo(SubSystemResult.SAVE_EXISTS);
						logger.error(SubSystemResult.SAVE_EXISTS.getValue());
					}
				}else{
					resultDo.setResultDo(SubSystemResult.SAVE_EXISTS);
					logger.error(SubSystemResult.SAVE_EXISTS.getValue());
				}
			}else{
				resultDo.setResultDo(SubSystemResult.SAVE_FAILURE);
				logger.error(SubSystemResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.SAVE_FAILURE);
			logger.error(SubSystemResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(subSystemDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteSubSystemById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = subSystemMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(SubSystemResult.DELETE_SUBSYSTEM_NOT_EXIST);
					logger.info(SubSystemResult.DELETE_SUBSYSTEM_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(SubSystemResult.DELETE_ID_NOT_NULL);
				logger.error(SubSystemResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.DELETE_FAILURE);
			logger.error(SubSystemResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteSubSystemByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			subSystemMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(SubSystemResult.DELETE_IDS_NOT_NULL);
				logger.error(SubSystemResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.DELETE_BY_IDS_FAILURE);
			logger.error(SubSystemResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteSubSystemByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			subSystemMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(SubSystemResult.DELETE_IDS_NOT_NULL);
				logger.error(SubSystemResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(SubSystemResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<SubSystemDto> updateSubSystem(SubSystemDto subSystemDto) {
		ResultDo<SubSystemDto> resultDo = new ResultDo<SubSystemDto>();
		SubSystem subSystem = new SubSystem();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=subSystemDto){
				if(StringUtil.isNotEmpty(subSystemDto.getId())){
					if(StringUtil.isNotEmpty(subSystemDto.getSubSysCode())){
						if(StringUtil.isNotEmpty(subSystemDto.getSubSysName())){
							SubSystem subSystemTemp = subSystemMapper.selectByCodeAndId(subSystemDto.getId(),subSystemDto.getSubSysCode());
							if(null!=subSystemTemp){
				    			resultDo.setResultDo(SubSystemResult.UPDATE_EXISTS);
								logger.error(SubSystemResult.UPDATE_EXISTS.getValue());
							}else{
								subSystemDto.setUpdateTime(time);
								SubSystemParseUtil.parseToEntity(subSystemDto,subSystem);
								subSystemMapper.updateByPrimaryKeySelective(subSystem);
				    			resultDo.setResultDo(InterfaceResult.SUCCESS);
								logger.info(InterfaceResult.SUCCESS.getValue());
							}
						}else{
			    			resultDo.setResultDo(SubSystemResult.UPDATE_SUBSYSNAME_NOT_NULL);
							logger.error(SubSystemResult.UPDATE_SUBSYSNAME_NOT_NULL.getValue());
						}
					}else{
		    			resultDo.setResultDo(SubSystemResult.UPDATE_SUBSYSCODE_NOT_NULL);
						logger.error(SubSystemResult.UPDATE_SUBSYSCODE_NOT_NULL.getValue());
					}
				}else{
	    			resultDo.setResultDo(SubSystemResult.UPDATE_ID_NOT_NULL);
					logger.error(SubSystemResult.UPDATE_ID_NOT_NULL.getValue());
				}
			}else{
    			resultDo.setResultDo(SubSystemResult.SAVE_FAILURE);
				logger.error(SubSystemResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.UPDATE_FAILURE);
			logger.error(SubSystemResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(subSystemDto);
		return resultDo;
	}

	@Override
	public ResultDo<SubSystemDto> findSubSystemById(String id) {
		SubSystemDto subSystemDto = new SubSystemDto();
		ResultDo<SubSystemDto> resultDo = new ResultDo<SubSystemDto>();
		try{
			if(StringUtil.isNotEmpty(id)){
				SubSystem subSystem = subSystemMapper.selectByPrimaryKey(id);
				SubSystemParseUtil.parseToDto(subSystem,subSystemDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(SubSystemResult.FIND_BY_ID_NOT_NULL);
				logger.error(SubSystemResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.FIND_FAILURE);
			logger.error(SubSystemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(subSystemDto);
		return resultDo;
    }

	@Override
	public ResultDo<List<SubSystemDto>> findAll() {
		List<SubSystemDto> subSystemDtoList = new ArrayList<SubSystemDto>();
		List<SubSystem> subSystemList = null;
		ResultDo<List<SubSystemDto>> resultDo=new ResultDo<List<SubSystemDto>>();
		try{
			subSystemList = subSystemMapper.selectAll();
			SubSystemParseUtil.parseToDtoList(subSystemList,subSystemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.FIND_FAILURE);
			logger.error(SubSystemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(subSystemDtoList);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<SubSystemDto>> findSubSystem(PageDto<SubSystemDto> pageDto) {
		List<SubSystemDto> subSystemDtoList = new ArrayList<SubSystemDto>();
		List<SubSystem> subSystemList = null;
		ResultDo<PageDto<SubSystemDto>> resultDo=new ResultDo<PageDto<SubSystemDto>>();
		try{
			pageDto.setTotalRecord(subSystemMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			subSystemList = subSystemMapper.selectAll();
			SubSystemParseUtil.parseToDtoList(subSystemList,subSystemDtoList);
			pageDto.setPageData(subSystemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.FIND_FAILURE);
			logger.error(SubSystemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<SubSystemDto>> findSubSystem(PageDto<SubSystemDto> pageDto, SubSystemDto subSystemDto) {
        List<SubSystemDto> subSystemDtoList = new ArrayList<SubSystemDto>();
		ResultDo<PageDto<SubSystemDto>> resultDo = new ResultDo<PageDto<SubSystemDto>>();
        List<SubSystem> subSystemList=null;
		try{
			Example example = new Example(SubSystem.class,false);
			example.createCriteria();
			if(StringUtil.isNotEmpty(subSystemDto.getSubSysCode())){
				example.getOredCriteria().get(0).andLike("subSysCode", "%"+subSystemDto.getSubSysCode()+"%");
			}
			if(StringUtil.isNotEmpty(subSystemDto.getSubSysName())){
				example.getOredCriteria().get(0).andLike("subSysName", "%"+subSystemDto.getSubSysName()+"%");
			}
			example.setOrderByClause("create_time  DESC");
			pageDto.setTotalRecord(subSystemMapper.selectCountByExample(example));
			SubSystem subSystem = new SubSystem();
			SubSystemParseUtil.parseToEntity(subSystemDto, subSystem);
			subSystemList = subSystemMapper.selectByExample(example);
			SubSystemParseUtil.parseToDtoList(subSystemList,subSystemDtoList);
			pageDto.setPageData(subSystemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.FIND_FAILURE);
			logger.error(SubSystemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<SubSystemDto> findByCode(String subSysCode) {
		SubSystemDto subSystemDto = new SubSystemDto();
		ResultDo<SubSystemDto> resultDo = new ResultDo<SubSystemDto>();
		try{
			if(StringUtil.isNotEmpty(subSysCode)){
				SubSystem subSystem = subSystemMapper.selectByCode(subSysCode);
				if(null==subSystem){
					resultDo.setResultDo(SubSystemResult.FIND_BY_CODE_NOT_EXISTS);
					logger.error(SubSystemResult.FIND_BY_CODE_NOT_EXISTS.getValue());
				}else{
					SubSystemParseUtil.parseToDto(subSystem,subSystemDto);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(SubSystemResult.FIND_CODE_NOT_NULL);
				logger.error(SubSystemResult.FIND_CODE_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(SubSystemResult.FIND_FAILURE);
			logger.error(SubSystemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(subSystemDto);
		return resultDo;
    }

	@Override
	public Boolean isExistByCode(String subSysCode) {
		Boolean flag = false;
		try{
			if(StringUtil.isNotEmpty(subSysCode)){
				SubSystem subSystem = subSystemMapper.selectByCode(subSysCode);
				if(null!=subSystem){
					flag = true;
				}
			}else{
				logger.error(SubSystemResult.FIND_CODE_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(SubSystemResult.FIND_FAILURE.getValue(), e);
		}
		return flag;
	}
}