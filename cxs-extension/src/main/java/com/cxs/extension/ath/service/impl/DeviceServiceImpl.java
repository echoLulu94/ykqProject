package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.ath.dto.DeviceDto;
import com.cxs.extension.ath.entity.Device;
import com.cxs.extension.ath.mapper.DeviceMapper;
import com.cxs.extension.ath.result.DeviceResult;
import com.cxs.extension.ath.service.api.DeviceService;
import com.cxs.extension.ath.utils.DeviceParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @Description: 登录设备业务处理实现类
 * @ClassName: DeviceServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
@Service
public class DeviceServiceImpl implements DeviceService {

private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DeviceMapper deviceMapper;

	@Override
	public ResultDo<DeviceDto> saveDevice(DeviceDto deviceDto) {
		ResultDo<DeviceDto> resultDo = new ResultDo<DeviceDto>();
		Device device =new Device();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=deviceDto){
				deviceDto.setId(IdUtil.getUuid());
				deviceDto.setCreateTime(time);
				deviceDto.setUpdateTime(time);
				DeviceParseUtil.parseToEntity(deviceDto,device);
				deviceMapper.insert(device);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(DeviceResult.SAVE_FAILURE);
				logger.error(DeviceResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.SAVE_FAILURE);
			logger.error(DeviceResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(deviceDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteDeviceById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = deviceMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(DeviceResult.DELETE_DEVICE_NOT_EXIST);
					logger.error(DeviceResult.DELETE_DEVICE_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(DeviceResult.DELETE_ID_NOT_NULL);
				logger.error(DeviceResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.DELETE_FAILURE);
			logger.error(DeviceResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteDeviceByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			deviceMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(DeviceResult.DELETE_IDS_NOT_NULL);
				logger.error(DeviceResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.DELETE_BY_IDS_FAILURE);
			logger.error(DeviceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteDeviceByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			deviceMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(DeviceResult.DELETE_IDS_NOT_NULL);
				logger.error(DeviceResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(DeviceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<DeviceDto> updateDevice(DeviceDto deviceDto) {
		ResultDo<DeviceDto> resultDo = new ResultDo<DeviceDto>();
		Device device = new Device();
		/*当前时间*/
		long time = System.currentTimeMillis();
		try{
			deviceDto.setUpdateTime(time);
			DeviceParseUtil.parseToEntity(deviceDto,device);
			deviceMapper.updateByPrimaryKeySelective(device);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.UPDATE_FAILURE);
			logger.error(DeviceResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(deviceDto);
		return resultDo;
	}

	@Override
	public ResultDo<DeviceDto> findDeviceById(String id) {
		DeviceDto deviceDto = new DeviceDto();
		ResultDo<DeviceDto> resultDo = new ResultDo<DeviceDto>();
		try{
			if(null!=id&&!"".equals(id)){
				Device device = deviceMapper.selectByPrimaryKey(id);
				DeviceParseUtil.parseToDto(device,deviceDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(DeviceResult.FIND_BY_ID_NOT_NULL);
				logger.error(DeviceResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.FIND_FAILURE);
			logger.error(DeviceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(deviceDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<DeviceDto>> findDevice(PageDto<DeviceDto> pageDto) {
		logger.debug("debug test");
		List<DeviceDto> deviceDtoList = new ArrayList<DeviceDto>();
		List<Device> deviceList = null;
		ResultDo<PageDto<DeviceDto>> resultDo=new ResultDo<PageDto<DeviceDto>>();
		try{
			pageDto.setTotalRecord(deviceMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			deviceList = deviceMapper.selectAll();
			DeviceParseUtil.parseToDtoList(deviceList,deviceDtoList);
			pageDto.setPageData(deviceDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.FIND_FAILURE);
			logger.error(DeviceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<DeviceDto>> findDevice(PageDto<DeviceDto> pageDto, DeviceDto deviceDto) {
        List<DeviceDto> deviceDtoList = new ArrayList<DeviceDto>();
		ResultDo<PageDto<DeviceDto>> resultDo = new ResultDo<PageDto<DeviceDto>>();
        List<Device> deviceList=null;
		try{
			Device example = new Device();
			// TODO 设置查询条件	
			pageDto.setTotalRecord(deviceMapper.selectCount(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			deviceList = deviceMapper.select(example);
			DeviceParseUtil.parseToDtoList(deviceList,deviceDtoList);
			pageDto.setPageData(deviceDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(DeviceResult.FIND_FAILURE);
			logger.error(DeviceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}
}