package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.SubSystemDto;
import com.cxs.extension.ath.entity.SubSystem;
/**
* 
* @Description: 子系统DTO和子系统互转工具类
* @ClassName: SubSystemParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class SubSystemParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param subSystem 源子系统entity
	 * @param subSystemDto 目标子系统dto
	 */
	public static void parseToDto(SubSystem subSystem, SubSystemDto subSystemDto){
		parseToDto(subSystem, subSystemDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param subSystem 源子系统entity
	 * @param subSystemDto 目标子系统dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(SubSystem subSystem, SubSystemDto subSystemDto, Boolean flag){
		if(flag){
			subSystemDto.setId(subSystem.getId());
			subSystemDto.setSubSysCode(subSystem.getSubSysCode());
			subSystemDto.setSubSysValue(subSystem.getSubSysValue());
			subSystemDto.setSubSysName(subSystem.getSubSysName());
			subSystemDto.setSubSysUri(subSystem.getSubSysUri());
			subSystemDto.setSubSysDes(subSystem.getSubSysDes());
			subSystemDto.setCreateTime(subSystem.getCreateTime());
			subSystemDto.setUpdateTime(subSystem.getUpdateTime());
		}else{
			if(null!=subSystem.getId()){
				subSystemDto.setId(subSystem.getId());
			}
			if(null!=subSystem.getSubSysCode()){
				subSystemDto.setSubSysCode(subSystem.getSubSysCode());
			}
			if(null!=subSystem.getSubSysValue()){
				subSystemDto.setSubSysValue(subSystem.getSubSysValue());
			}
			if(null!=subSystem.getSubSysName()){
				subSystemDto.setSubSysName(subSystem.getSubSysName());
			}
			if(null!=subSystem.getSubSysUri()){
				subSystemDto.setSubSysUri(subSystem.getSubSysUri());
			}
			if(null!=subSystem.getSubSysDes()){
				subSystemDto.setSubSysDes(subSystem.getSubSysDes());
			}
			if(null!=subSystem.getCreateTime()){
				subSystemDto.setCreateTime(subSystem.getCreateTime());
			}
			if(null!=subSystem.getUpdateTime()){
				subSystemDto.setUpdateTime(subSystem.getUpdateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param subSystemDto 源子系统dto
	 * @param subSystem 目标子系统entity
	 */
	public static void parseToEntity(SubSystemDto subSystemDto, SubSystem subSystem){
		parseToEntity(subSystemDto, subSystem, false);
	}
	
	/**
	 * dto转entity
	 * @param subSystemDto 源子系统dto
	 * @param subSystem 目标子系统entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(SubSystemDto subSystemDto, SubSystem subSystem, Boolean flag){
		if(flag){
			subSystem.setId(subSystemDto.getId());
			subSystem.setSubSysCode(subSystemDto.getSubSysCode());
			subSystem.setSubSysValue(subSystemDto.getSubSysValue());
			subSystem.setSubSysName(subSystemDto.getSubSysName());
			subSystem.setSubSysUri(subSystemDto.getSubSysUri());
			subSystem.setSubSysDes(subSystemDto.getSubSysDes());
			subSystem.setCreateTime(subSystemDto.getCreateTime());
			subSystem.setUpdateTime(subSystemDto.getUpdateTime());
		}else{
			if(null!=subSystemDto.getId()){
				subSystem.setId(subSystemDto.getId());
			}
			if(null!=subSystemDto.getSubSysCode()){
				subSystem.setSubSysCode(subSystemDto.getSubSysCode());
			}
			if(null!=subSystemDto.getSubSysValue()){
				subSystem.setSubSysValue(subSystemDto.getSubSysValue());
			}
			if(null!=subSystemDto.getSubSysName()){
				subSystem.setSubSysName(subSystemDto.getSubSysName());
			}
			if(null!=subSystemDto.getSubSysUri()){
				subSystem.setSubSysUri(subSystemDto.getSubSysUri());
			}
			if(null!=subSystemDto.getSubSysDes()){
				subSystem.setSubSysDes(subSystemDto.getSubSysDes());
			}
			if(null!=subSystemDto.getCreateTime()){
				subSystem.setCreateTime(subSystemDto.getCreateTime());
			}
			if(null!=subSystemDto.getUpdateTime()){
				subSystem.setUpdateTime(subSystemDto.getUpdateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param subSystemList 源子系统entity列表
	 * @param subSystemDtoList 目标子系统dto列表
	 */
	public static void parseToDtoList(List<SubSystem> subSystemList, List<SubSystemDto> subSystemDtoList ){
		parseToDtoList(subSystemList, subSystemDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param subSystemList 源子系统entity列表
	 * @param subSystemDtoList 目标子系统dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<SubSystem> subSystemList, List<SubSystemDto> subSystemDtoList, Boolean flag){
		if(null!=subSystemList&&!subSystemList.isEmpty()){
			for (SubSystem subSystem:subSystemList) {
				SubSystemDto subSystemDto = new SubSystemDto();
				parseToDto(subSystem, subSystemDto, flag);
				subSystemDtoList.add(subSystemDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param subSystemDtoList 源子系统dto列表
	 * @param subSystemList 目标子系统entity列表
	 */
	public static void parseToEntityList(List<SubSystemDto> subSystemDtoList, List<SubSystem> subSystemList){
		parseToEntityList(subSystemDtoList, subSystemList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param subSystemDtoList 源子系统dto列表
	 * @param subSystemList 目标子系统entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<SubSystemDto> subSystemDtoList, List<SubSystem> subSystemList, Boolean flag){
		if(null!=subSystemDtoList&&!subSystemDtoList.isEmpty()){
			for (SubSystemDto subSystemDto:subSystemDtoList) {
				SubSystem subSystem = new SubSystem();
				parseToEntity(subSystemDto,subSystem,flag);
				subSystemList.add(subSystem);
			}
		}
	}
}
