package com.cxs.extension.ath.service.api;

import java.util.List;

import com.cxs.extension.ath.dto.DeviceDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 登录设备业务处理接口定义
 * @ClassName: DeviceService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface DeviceService {
	
    /**
     * 保存登录设备
     * @param deviceDto 需保存登录设备数据对象
     * @return
     */
    ResultDo<DeviceDto> saveDevice(DeviceDto deviceDto);
    
    /**
     * 根据id删除登录设备
     * @param id id
     * @return
     */
    ResultDo<String> deleteDeviceById(String id);
	
    /**
     * 根据id数组批量删除登录设备
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteDeviceByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除登录设备
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteDeviceByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新登录设备信息
	 * @param devicedto 需更新登录设备数据对象
	 * @return
	 */
    ResultDo<DeviceDto> updateDevice(DeviceDto devicedto);
    
    /**
     * 根据id查找登录设备
     * @param id id
     * @return
     */
    ResultDo<DeviceDto> findDeviceById(String id);
    
    /**
     * 分页查询登录设备信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<DeviceDto>> findDevice(PageDto<DeviceDto> pageDto);
	
	/**
	 * 根据查询条件分页查询登录设备对象
	 * @param page 分页对象
	 * @param devicedto 查询条件
	 * @return
	 */
	ResultDo<PageDto<DeviceDto>> findDevice(PageDto<DeviceDto> pageDto, DeviceDto devicedto);
}