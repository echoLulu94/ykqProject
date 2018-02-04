package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.ath.dto.LoginLogHisDto;
import com.cxs.extension.ath.entity.LoginLogHis;
import com.cxs.extension.ath.mapper.LoginLogHisMapper;
import com.cxs.extension.ath.result.LoginLogHisResult;
import com.cxs.extension.ath.service.api.LoginLogHisService;
import com.cxs.extension.ath.utils.LoginLogHisParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @Description: 登录日志历史业务处理实现类
 * @ClassName: LoginLogHisServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
@Service
public class LoginLogHisServiceImpl implements LoginLogHisService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginLogHisMapper loginLogHisMapper;

	@Override
	public ResultDo<LoginLogHisDto> saveLoginLogHis(LoginLogHisDto loginLogHisDto) {
		ResultDo<LoginLogHisDto> resultDo = new ResultDo<LoginLogHisDto>();
		LoginLogHis loginLogHis =new LoginLogHis();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=loginLogHisDto){
				loginLogHisDto.setId(IdUtil.getUuid());
				loginLogHisDto.setCreateTime(time);
				LoginLogHisParseUtil.parseToEntity(loginLogHisDto,loginLogHis);
				loginLogHisMapper.insert(loginLogHis);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(LoginLogHisResult.SAVE_FAILURE);
				logger.error(LoginLogHisResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.SAVE_FAILURE);
			logger.error(LoginLogHisResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(loginLogHisDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteLoginLogHisById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = loginLogHisMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(LoginLogHisResult.DELETE_LOGINLOGHIS_NOT_EXIST);
					logger.error(LoginLogHisResult.DELETE_LOGINLOGHIS_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(LoginLogHisResult.DELETE_ID_NOT_NULL);
				logger.error(LoginLogHisResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.DELETE_FAILURE);
			logger.error(LoginLogHisResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteLoginLogHisByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			loginLogHisMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(LoginLogHisResult.DELETE_IDS_NOT_NULL);
				logger.error(LoginLogHisResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.DELETE_BY_IDS_FAILURE);
			logger.error(LoginLogHisResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteLoginLogHisByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			loginLogHisMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(LoginLogHisResult.DELETE_IDS_NOT_NULL);
				logger.error(LoginLogHisResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(LoginLogHisResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<LoginLogHisDto> updateLoginLogHis(LoginLogHisDto loginLogHisDto) {
		ResultDo<LoginLogHisDto> resultDo = new ResultDo<LoginLogHisDto>();
		LoginLogHis loginLogHis = new LoginLogHis();
		try{
			LoginLogHisParseUtil.parseToEntity(loginLogHisDto,loginLogHis);
			loginLogHisMapper.updateByPrimaryKeySelective(loginLogHis);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.UPDATE_FAILURE);
			logger.error(LoginLogHisResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(loginLogHisDto);
		return resultDo;
	}

	@Override
	public ResultDo<LoginLogHisDto> findLoginLogHisById(String id) {
		LoginLogHisDto loginLogHisDto = new LoginLogHisDto();
		ResultDo<LoginLogHisDto> resultDo = new ResultDo<LoginLogHisDto>();
		try{
			if(null!=id&&!"".equals(id)){
				LoginLogHis loginLogHis = loginLogHisMapper.selectByPrimaryKey(id);
				LoginLogHisParseUtil.parseToDto(loginLogHis,loginLogHisDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(LoginLogHisResult.FIND_BY_ID_NOT_NULL);
				logger.error(LoginLogHisResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.FIND_FAILURE);
			logger.error(LoginLogHisResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(loginLogHisDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<LoginLogHisDto>> findLoginLogHis(PageDto<LoginLogHisDto> pageDto) {
		logger.debug("debug test");
		List<LoginLogHisDto> loginLogHisDtoList = new ArrayList<LoginLogHisDto>();
		List<LoginLogHis> loginLogHisList = null;
		ResultDo<PageDto<LoginLogHisDto>> resultDo=new ResultDo<PageDto<LoginLogHisDto>>();
		try{
			pageDto.setTotalRecord(loginLogHisMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			loginLogHisList = loginLogHisMapper.selectAll();
			LoginLogHisParseUtil.parseToDtoList(loginLogHisList,loginLogHisDtoList);
			pageDto.setPageData(loginLogHisDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.FIND_FAILURE);
			logger.error(LoginLogHisResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<LoginLogHisDto>> findLoginLogHis(PageDto<LoginLogHisDto> pageDto, LoginLogHisDto loginLogHisDto) {
        List<LoginLogHisDto> loginLogHisDtoList = new ArrayList<LoginLogHisDto>();
		ResultDo<PageDto<LoginLogHisDto>> resultDo = new ResultDo<PageDto<LoginLogHisDto>>();
        List<LoginLogHis> loginLogHisList=null;
		try{
			LoginLogHis example = new LoginLogHis();
			// TODO 设置查询条件	
			pageDto.setTotalRecord(loginLogHisMapper.selectCount(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			loginLogHisList = loginLogHisMapper.select(example);
			LoginLogHisParseUtil.parseToDtoList(loginLogHisList,loginLogHisDtoList);
			pageDto.setPageData(loginLogHisDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(LoginLogHisResult.FIND_FAILURE);
			logger.error(LoginLogHisResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}
}