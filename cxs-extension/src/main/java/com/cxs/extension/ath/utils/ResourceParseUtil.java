package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.ResourceDto;
import com.cxs.extension.ath.entity.Resource;
/**
* 
* @Description: 资源DTO和资源互转工具类
* @ClassName: ResourceParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class ResourceParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param resource 源资源entity
	 * @param resourceDto 目标资源dto
	 */
	public static void parseToDto(Resource resource, ResourceDto resourceDto){
		parseToDto(resource, resourceDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param resource 源资源entity
	 * @param resourceDto 目标资源dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Resource resource, ResourceDto resourceDto, Boolean flag){
		if(flag){
			resourceDto.setId(resource.getId());
			resourceDto.setSubSysCode(resource.getSubSysCode());
			resourceDto.setSubSysName(resource.getSubSysName());
			resourceDto.setSubSysUri(resource.getSubSysUri());
			resourceDto.setModCode(resource.getModCode());
			resourceDto.setModName(resource.getModName());
			resourceDto.setModUri(resource.getModUri());
			resourceDto.setRescCode(resource.getRescCode());
			resourceDto.setRescValue(resource.getRescValue());
			resourceDto.setRescName(resource.getRescName());
			resourceDto.setRescUriType(resource.getRescUriType());
			resourceDto.setRescUri(resource.getRescUri());
			resourceDto.setRescDes(resource.getRescDes());
			resourceDto.setCreateTime(resource.getCreateTime());
			resourceDto.setUpdateTime(resource.getUpdateTime());
		}else{
			if(null!=resource.getId()){
				resourceDto.setId(resource.getId());
			}
			if(null!=resource.getSubSysCode()){
				resourceDto.setSubSysCode(resource.getSubSysCode());
			}
			if(null!=resource.getSubSysName()){
				resourceDto.setSubSysName(resource.getSubSysName());
			}
			if(null!=resource.getSubSysUri()){
				resourceDto.setSubSysUri(resource.getSubSysUri());
			}
			if(null!=resource.getModCode()){
				resourceDto.setModCode(resource.getModCode());
			}
			if(null!=resource.getModName()){
				resourceDto.setModName(resource.getModName());
			}
			if(null!=resource.getModUri()){
				resourceDto.setModUri(resource.getModUri());
			}
			if(null!=resource.getRescCode()){
				resourceDto.setRescCode(resource.getRescCode());
			}
			if(null!=resource.getRescValue()){
				resourceDto.setRescValue(resource.getRescValue());
			}
			if(null!=resource.getRescName()){
				resourceDto.setRescName(resource.getRescName());
			}
			if(null!=resource.getRescUriType()){
				resourceDto.setRescUriType(resource.getRescUriType());
			}
			if(null!=resource.getRescUri()){
				resourceDto.setRescUri(resource.getRescUri());
			}
			if(null!=resource.getRescDes()){
				resourceDto.setRescDes(resource.getRescDes());
			}
			if(null!=resource.getCreateTime()){
				resourceDto.setCreateTime(resource.getCreateTime());
			}
			if(null!=resource.getUpdateTime()){
				resourceDto.setUpdateTime(resource.getUpdateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param resourceDto 源资源dto
	 * @param resource 目标资源entity
	 */
	public static void parseToEntity(ResourceDto resourceDto, Resource resource){
		parseToEntity(resourceDto, resource, false);
	}
	
	/**
	 * dto转entity
	 * @param resourceDto 源资源dto
	 * @param resource 目标资源entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(ResourceDto resourceDto, Resource resource, Boolean flag){
		if(flag){
			resource.setId(resourceDto.getId());
			resource.setSubSysCode(resourceDto.getSubSysCode());
			resource.setSubSysName(resourceDto.getSubSysName());
			resource.setSubSysUri(resourceDto.getSubSysUri());
			resource.setModCode(resourceDto.getModCode());
			resource.setModName(resourceDto.getModName());
			resource.setModUri(resourceDto.getModUri());
			resource.setRescCode(resourceDto.getRescCode());
			resource.setRescValue(resourceDto.getRescValue());
			resource.setRescName(resourceDto.getRescName());
			resource.setRescUriType(resourceDto.getRescUriType());
			resource.setRescUri(resourceDto.getRescUri());
			resource.setRescDes(resourceDto.getRescDes());
			resource.setCreateTime(resourceDto.getCreateTime());
			resource.setUpdateTime(resourceDto.getUpdateTime());
		}else{
			if(null!=resourceDto.getId()){
				resource.setId(resourceDto.getId());
			}
			if(null!=resourceDto.getSubSysCode()){
				resource.setSubSysCode(resourceDto.getSubSysCode());
			}
			if(null!=resourceDto.getSubSysName()){
				resource.setSubSysName(resourceDto.getSubSysName());
			}
			if(null!=resourceDto.getSubSysUri()){
				resource.setSubSysUri(resourceDto.getSubSysUri());
			}
			if(null!=resourceDto.getModCode()){
				resource.setModCode(resourceDto.getModCode());
			}
			if(null!=resourceDto.getModName()){
				resource.setModName(resourceDto.getModName());
			}
			if(null!=resourceDto.getModUri()){
				resource.setModUri(resourceDto.getModUri());
			}
			if(null!=resourceDto.getRescCode()){
				resource.setRescCode(resourceDto.getRescCode());
			}
			if(null!=resourceDto.getRescValue()){
				resource.setRescValue(resourceDto.getRescValue());
			}
			if(null!=resourceDto.getRescName()){
				resource.setRescName(resourceDto.getRescName());
			}
			if(null!=resourceDto.getRescUriType()){
				resource.setRescUriType(resourceDto.getRescUriType());
			}
			if(null!=resourceDto.getRescUri()){
				resource.setRescUri(resourceDto.getRescUri());
			}
			if(null!=resourceDto.getRescDes()){
				resource.setRescDes(resourceDto.getRescDes());
			}
			if(null!=resourceDto.getCreateTime()){
				resource.setCreateTime(resourceDto.getCreateTime());
			}
			if(null!=resourceDto.getUpdateTime()){
				resource.setUpdateTime(resourceDto.getUpdateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param resourceList 源资源entity列表
	 * @param resourceDtoList 目标资源dto列表
	 */
	public static void parseToDtoList(List<Resource> resourceList, List<ResourceDto> resourceDtoList ){
		parseToDtoList(resourceList, resourceDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param resourceList 源资源entity列表
	 * @param resourceDtoList 目标资源dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Resource> resourceList, List<ResourceDto> resourceDtoList, Boolean flag){
		if(null!=resourceList&&!resourceList.isEmpty()){
			for (Resource resource:resourceList) {
				ResourceDto resourceDto = new ResourceDto();
				parseToDto(resource, resourceDto, flag);
				resourceDtoList.add(resourceDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param resourceDtoList 源资源dto列表
	 * @param resourceList 目标资源entity列表
	 */
	public static void parseToEntityList(List<ResourceDto> resourceDtoList, List<Resource> resourceList){
		parseToEntityList(resourceDtoList, resourceList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param resourceDtoList 源资源dto列表
	 * @param resourceList 目标资源entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<ResourceDto> resourceDtoList, List<Resource> resourceList, Boolean flag){
		if(null!=resourceDtoList&&!resourceDtoList.isEmpty()){
			for (ResourceDto resourceDto:resourceDtoList) {
				Resource resource = new Resource();
				parseToEntity(resourceDto,resource,flag);
				resourceList.add(resource);
			}
		}
	}
}
