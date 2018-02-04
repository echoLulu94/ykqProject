package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.ath.dto.LoginLogDto;
import com.cxs.extension.ath.entity.LoginLog;
import com.cxs.extension.ath.mapper.LoginLogMapper;
import com.cxs.extension.ath.result.LoginLogResult;
import com.cxs.extension.ath.service.api.LoginLogService;
import com.cxs.extension.ath.utils.LoginLogParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @Description: 登录日志业务处理实现类
 * @ClassName: LoginLogServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginLogMapper loginLogMapper;

	@Override
	public ResultDo<LoginLogDto> saveLoginLog(LoginLogDto loginLogDto) {
		ResultDo<LoginLogDto> resultDo = new ResultDo<LoginLogDto>();
		LoginLog loginLog =new LoginLog();
		/*当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=loginLogDto){
				loginLogDto.setId(IdUtil.getUuid());
				loginLogDto.setCreateTime(time);
				LoginLogParseUtil.parseToEntity(loginLogDto,loginLog);
				loginLogMapper.insert(loginLog);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(LoginLogResult.SAVE_FAILURE);
				logger.error(LoginLogResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.SAVE_FAILURE);
			logger.error(LoginLogResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(loginLogDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteLoginLogById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = loginLogMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(LoginLogResult.DELETE_LOGINLOG_NOT_EXIST);
					logger.info(LoginLogResult.DELETE_LOGINLOG_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(LoginLogResult.DELETE_ID_NOT_NULL);
				logger.error(LoginLogResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.DELETE_FAILURE);
			logger.error(LoginLogResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteLoginLogByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			loginLogMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(LoginLogResult.DELETE_IDS_NOT_NULL);
				logger.error(LoginLogResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.DELETE_BY_IDS_FAILURE);
			logger.error(LoginLogResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteLoginLogByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			loginLogMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(LoginLogResult.DELETE_IDS_NOT_NULL);
				logger.error(LoginLogResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(LoginLogResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<LoginLogDto> updateLoginLog(LoginLogDto loginLogDto) {
		ResultDo<LoginLogDto> resultDo = new ResultDo<LoginLogDto>();
		LoginLog loginLog = new LoginLog();
		try{
			LoginLogParseUtil.parseToEntity(loginLogDto,loginLog);
			loginLogMapper.updateByPrimaryKeySelective(loginLog);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.UPDATE_FAILURE);
			logger.error(LoginLogResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(loginLogDto);
		return resultDo;
	}

	@Override
	public ResultDo<LoginLogDto> findLoginLogById(String id) {
		LoginLogDto loginLogDto = new LoginLogDto();
		ResultDo<LoginLogDto> resultDo = new ResultDo<LoginLogDto>();
		try{
			if(null!=id&&!"".equals(id)){
				LoginLog loginLog = loginLogMapper.selectByPrimaryKey(id);
				LoginLogParseUtil.parseToDto(loginLog,loginLogDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(LoginLogResult.FIND_BY_ID_NOT_NULL);
				logger.error(LoginLogResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.FIND_FAILURE);
			logger.error(LoginLogResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(loginLogDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<LoginLogDto>> findLoginLog(PageDto<LoginLogDto> pageDto) {
		logger.debug("debug test");
		List<LoginLogDto> loginLogDtoList = new ArrayList<LoginLogDto>();
		List<LoginLog> loginLogList = null;
		ResultDo<PageDto<LoginLogDto>> resultDo=new ResultDo<PageDto<LoginLogDto>>();
		try{
			pageDto.setTotalRecord(loginLogMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			loginLogList = loginLogMapper.selectAll();
			LoginLogParseUtil.parseToDtoList(loginLogList,loginLogDtoList);
			pageDto.setPageData(loginLogDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.FIND_FAILURE);
			logger.error(LoginLogResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<LoginLogDto>> findLoginLog(PageDto<LoginLogDto> pageDto, LoginLogDto loginLogDto) {
        List<LoginLogDto> loginLogDtoList = new ArrayList<LoginLogDto>();
		ResultDo<PageDto<LoginLogDto>> resultDo = new ResultDo<PageDto<LoginLogDto>>();
        List<LoginLog> loginLogList=null;
		try{
			LoginLog example = new LoginLog();
			// TODO 设置查询条件	
			pageDto.setTotalRecord(loginLogMapper.selectCount(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			loginLogList = loginLogMapper.select(example);
			LoginLogParseUtil.parseToDtoList(loginLogList,loginLogDtoList);
			pageDto.setPageData(loginLogDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogResult.FIND_FAILURE);
			logger.error(LoginLogResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}
}