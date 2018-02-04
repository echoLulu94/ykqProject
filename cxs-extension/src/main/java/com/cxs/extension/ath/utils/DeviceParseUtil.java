package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.DeviceDto;
import com.cxs.extension.ath.entity.Device;
/**
* 
* @Description: 设备DTO和设备互转工具类
* @ClassName: DeviceParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class DeviceParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param device 源设备entity
	 * @param deviceDto 目标设备dto
	 */
	public static void parseToDto(Device device, DeviceDto deviceDto){
		parseToDto(device, deviceDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param device 源设备entity
	 * @param deviceDto 目标设备dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Device device, DeviceDto deviceDto, Boolean flag){
		if(flag){
			deviceDto.setId(device.getId());
			deviceDto.setDeviceId(device.getDeviceId());
			deviceDto.setSystemType(device.getSystemType());
			deviceDto.setSystemVersion(device.getSystemVersion());
			deviceDto.setDeviceModel(device.getDeviceModel());
			deviceDto.setDeviceName(device.getDeviceName());
			deviceDto.setUiMode(device.getUiMode());
			deviceDto.setOperator(device.getOperator());
			deviceDto.setConnectionType(device.getConnectionType());
			deviceDto.setCreateTime(device.getCreateTime());
			deviceDto.setUpdateTime(device.getUpdateTime());
		}else{
			if(null!=device.getId()){
				deviceDto.setId(device.getId());
			}
			if(null!=device.getDeviceId()){
				deviceDto.setDeviceId(device.getDeviceId());
			}
			if(null!=device.getSystemType()){
				deviceDto.setSystemType(device.getSystemType());
			}
			if(null!=device.getSystemVersion()){
				deviceDto.setSystemVersion(device.getSystemVersion());
			}
			if(null!=device.getDeviceModel()){
				deviceDto.setDeviceModel(device.getDeviceModel());
			}
			if(null!=device.getDeviceName()){
				deviceDto.setDeviceName(device.getDeviceName());
			}
			if(null!=device.getUiMode()){
				deviceDto.setUiMode(device.getUiMode());
			}
			if(null!=device.getOperator()){
				deviceDto.setOperator(device.getOperator());
			}
			if(null!=device.getConnectionType()){
				deviceDto.setConnectionType(device.getConnectionType());
			}
			if(null!=device.getCreateTime()){
				deviceDto.setCreateTime(device.getCreateTime());
			}
			if(null!=device.getUpdateTime()){
				deviceDto.setUpdateTime(device.getUpdateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param deviceDto 源设备dto
	 * @param device 目标设备entity
	 */
	public static void parseToEntity(DeviceDto deviceDto, Device device){
		parseToEntity(deviceDto, device, false);
	}
	
	/**
	 * dto转entity
	 * @param deviceDto 源设备dto
	 * @param device 目标设备entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(DeviceDto deviceDto, Device device, Boolean flag){
		if(flag){
			device.setId(deviceDto.getId());
			device.setDeviceId(deviceDto.getDeviceId());
			device.setSystemType(deviceDto.getSystemType());
			device.setSystemVersion(deviceDto.getSystemVersion());
			device.setDeviceModel(deviceDto.getDeviceModel());
			device.setDeviceName(deviceDto.getDeviceName());
			device.setUiMode(deviceDto.getUiMode());
			device.setOperator(deviceDto.getOperator());
			device.setConnectionType(deviceDto.getConnectionType());
			device.setCreateTime(deviceDto.getCreateTime());
			device.setUpdateTime(deviceDto.getUpdateTime());
		}else{
			if(null!=deviceDto.getId()){
				device.setId(deviceDto.getId());
			}
			if(null!=deviceDto.getDeviceId()){
				device.setDeviceId(deviceDto.getDeviceId());
			}
			if(null!=deviceDto.getSystemType()){
				device.setSystemType(deviceDto.getSystemType());
			}
			if(null!=deviceDto.getSystemVersion()){
				device.setSystemVersion(deviceDto.getSystemVersion());
			}
			if(null!=deviceDto.getDeviceModel()){
				device.setDeviceModel(deviceDto.getDeviceModel());
			}
			if(null!=deviceDto.getDeviceName()){
				device.setDeviceName(deviceDto.getDeviceName());
			}
			if(null!=deviceDto.getUiMode()){
				device.setUiMode(deviceDto.getUiMode());
			}
			if(null!=deviceDto.getOperator()){
				device.setOperator(deviceDto.getOperator());
			}
			if(null!=deviceDto.getConnectionType()){
				device.setConnectionType(deviceDto.getConnectionType());
			}
			if(null!=deviceDto.getCreateTime()){
				device.setCreateTime(deviceDto.getCreateTime());
			}
			if(null!=deviceDto.getUpdateTime()){
				device.setUpdateTime(deviceDto.getUpdateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param deviceList 源设备entity列表
	 * @param deviceDtoList 目标设备dto列表
	 */
	public static void parseToDtoList(List<Device> deviceList, List<DeviceDto> deviceDtoList ){
		parseToDtoList(deviceList, deviceDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param deviceList 源设备entity列表
	 * @param deviceDtoList 目标设备dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Device> deviceList, List<DeviceDto> deviceDtoList, Boolean flag){
		if(null!=deviceList&&!deviceList.isEmpty()){
			for (Device device:deviceList) {
				DeviceDto deviceDto = new DeviceDto();
				parseToDto(device, deviceDto, flag);
				deviceDtoList.add(deviceDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param deviceDtoList 源设备dto列表
	 * @param deviceList 目标设备entity列表
	 */
	public static void parseToEntityList(List<DeviceDto> deviceDtoList, List<Device> deviceList){
		parseToEntityList(deviceDtoList, deviceList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param deviceDtoList 源设备dto列表
	 * @param deviceList 目标设备entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<DeviceDto> deviceDtoList, List<Device> deviceList, Boolean flag){
		if(null!=deviceDtoList&&!deviceDtoList.isEmpty()){
			for (DeviceDto deviceDto:deviceDtoList) {
				Device device = new Device();
				parseToEntity(deviceDto,device,flag);
				deviceList.add(device);
			}
		}
	}
}
