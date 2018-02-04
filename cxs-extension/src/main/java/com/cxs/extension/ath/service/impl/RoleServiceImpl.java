package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.ath.dto.RoleDto;
import com.cxs.extension.ath.entity.Role;	
import com.cxs.extension.ath.result.RoleResult;
import com.cxs.extension.ath.mapper.RoleMapper;
import com.cxs.extension.ath.service.api.RoleService;
import com.cxs.extension.ath.utils.RoleParseUtil;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.utils.IdUtil;
import com.cxs.framework.utils.StringUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 角色表业务处理实现类
 * @ClassName: RoleServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日 
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private DictItemService dictItemService;

	@Override
	public ResultDo<RoleDto> saveRole(RoleDto roleDto) {
		ResultDo<RoleDto> resultDo = new ResultDo<RoleDto>();
		Role role =new Role();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=roleDto){
				roleDto.setId(IdUtil.getUuid());
				roleDto.setCreateTime(time);
				roleDto.setUpdateTime(time);
				RoleParseUtil.parseToEntity(roleDto,role);
				roleMapper.insert(role);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(RoleResult.SAVE_FAILURE);
				logger.error(RoleResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.SAVE_FAILURE);
			logger.error(RoleResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(roleDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteRoleById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = roleMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(RoleResult.DELETE_ROLE_NOT_EXIST);
					logger.error(RoleResult.DELETE_ROLE_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(RoleResult.DELETE_ID_NOT_NULL);
				logger.error(RoleResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.DELETE_FAILURE);
			logger.error(RoleResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteRoleByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			roleMapper.deleteByIds(shortIds);
	    		}
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(RoleResult.DELETE_IDS_NOT_NULL);
				logger.error(RoleResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.DELETE_BY_IDS_FAILURE);
			logger.error(RoleResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteRoleByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			roleMapper.deleteByIds(shortIds);
	    		}
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(RoleResult.DELETE_IDS_NOT_NULL);
				logger.error(RoleResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.DELETE_BY_IDS_FAILURE);
			logger.error(RoleResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<RoleDto> updateRole(RoleDto roleDto) {
		ResultDo<RoleDto> resultDo = new ResultDo<RoleDto>();
		Role role = new Role();
		/*当前时间*/
		long time = System.currentTimeMillis();
		try{
			roleDto.setUpdateTime(time);
			RoleParseUtil.parseToEntity(roleDto,role);
			roleMapper.updateByPrimaryKeySelective(role);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.UPDATE_FAILURE);
			logger.error(RoleResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(roleDto);
		return resultDo;
	}

	@Override
	public ResultDo<RoleDto> findRoleById(String id) {
		RoleDto roleDto = new RoleDto();
		ResultDo<RoleDto> resultDo = new ResultDo<RoleDto>();
		try{
			if(null!=id&&!"".equals(id)){
				Role role = roleMapper.selectByPrimaryKey(id);
				RoleParseUtil.parseToDto(role,roleDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(RoleResult.FIND_BY_ID_NOT_NULL);
				logger.error(RoleResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.FIND_FAILURE);
			logger.error(RoleResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(roleDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<RoleDto>> findRole(PageDto<RoleDto> pageDto) {
		List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
		List<Role> roleList = null;
		ResultDo<PageDto<RoleDto>> resultDo=new ResultDo<PageDto<RoleDto>>();
		try{
			pageDto.setTotalRecord(roleMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			roleList = roleMapper.selectAll();
			RoleParseUtil.parseToDtoList(roleList,roleDtoList);
			pageDto.setPageData(roleDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.FIND_FAILURE);
			logger.error(RoleResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<Map<String, Object>> findRole(PageDto<RoleDto> pageDto, RoleDto roleDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();		
        List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
        List<Role> roleList=null;
		try{
			Example example = new Example(Role.class);
			example.createCriteria();
			if(StringUtil.isNotEmpty(roleDto.getCode())) {
				example.getOredCriteria().get(0).andLike("code", "%" + roleDto.getCode() + "%");
			}
			if(StringUtil.isNotEmpty(roleDto.getName())) {
				example.getOredCriteria().get(0).andLike("name", "%" + roleDto.getName() + "%");
			}
			example.setOrderByClause("create_time  DESC");
			pageDto.setTotalRecord(roleMapper.selectCountByExample(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			roleList = roleMapper.selectByExample(example);
			RoleParseUtil.parseToDtoList(roleList,roleDtoList);
			pageDto.setPageData(roleDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(RoleResult.FIND_FAILURE);
			logger.error(RoleResult.FIND_FAILURE.getValue(), e);
		}
		resultMap.put("roleMgmtDtoList", pageDto);
		resultMap.put("dictItemList", dictItemService.findByTypeCode("USER_STATE").getResultData());
		resultDo.setResultData(resultMap);
		return resultDo;
	}
}