package com.cxs.extension.ath.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.ath.dto.DeviceDto;
import com.cxs.extension.ath.result.DeviceResult;
import com.cxs.extension.ath.service.api.DeviceService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 登录设备控制器
 * @ClassName: DeviceController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/ath")
public class DeviceController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DeviceService deviceService;
    
    /*保存登录设备*/
    @RequestMapping(value = "/saveDevice")
	@ResponseBody
    public ResultDo<DeviceDto> saveDevice(DeviceDto deviceDto){
    	return deviceService.saveDevice(deviceDto);
	}
    
    /*删除登录设备*/
    @RequestMapping(value = "/deleteDevice")
	@ResponseBody
    public ResultDo<String> deleteDeviceById(String id){
    	return deviceService.deleteDeviceById(id);
	}

	/*删除登录设备*/
    @RequestMapping(value = "/deleteAllDevice")
	@ResponseBody
    public ResultDo<String []> deleteAllDevice(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = deviceService.deleteDeviceByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(DeviceResult.DELETE_BY_IDS_FAILURE);
			logger.error(DeviceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新登录设备*/
    @RequestMapping(value = "/updateDevice")
	@ResponseBody
    public ResultDo<DeviceDto> updateDevice(DeviceDto deviceDto){
    	return deviceService.updateDevice(deviceDto);
	}

    /*显示登录设备详情*/
	@RequestMapping("/viewDevice")
	@ResponseBody
	public ResultDo<DeviceDto> viewDevice(String id){
		logger.info("deviceId:"+id);
		return deviceService.findDeviceById(id);
	}

	/*查询登录设备*/
	@RequestMapping("/findDevice")
	@ResponseBody
	public ResultDo<PageDto<DeviceDto>> findDevice(PageDto<DeviceDto> pageDto, DeviceDto deviceDto){
		return deviceService.findDevice(pageDto, deviceDto);
	}
}
