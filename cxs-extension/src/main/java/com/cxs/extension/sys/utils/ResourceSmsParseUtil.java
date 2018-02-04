package com.cxs.extension.sys.utils;

import java.util.List;

import com.cxs.extension.sys.dto.ResourceSmsDto;
import com.cxs.extension.sys.entity.ResourceSms;
/**
* 
* @Description: DTO和互转工具类
* @ClassName: ResourceSmsParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class ResourceSmsParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param resourceSms 源entity
	 * @param resourceSmsDto 目标dto
	 */
	public static void parseToDto(ResourceSms resourceSms, ResourceSmsDto resourceSmsDto){
		parseToDto(resourceSms, resourceSmsDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param resourceSms 源entity
	 * @param resourceSmsDto 目标dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(ResourceSms resourceSms, ResourceSmsDto resourceSmsDto, Boolean flag){
		if(flag){
			resourceSmsDto.setId(resourceSms.getId());
			resourceSmsDto.setRescCode(resourceSms.getRescCode());
			resourceSmsDto.setSmsType(resourceSms.getSmsType());
			resourceSmsDto.setTemplateCode(resourceSms.getTemplateCode());
			resourceSmsDto.setCreateTime(resourceSms.getCreateTime());
		}else{
			if(null!=resourceSms.getId()){
				resourceSmsDto.setId(resourceSms.getId());
			}
			if(null!=resourceSms.getRescCode()){
				resourceSmsDto.setRescCode(resourceSms.getRescCode());
			}
			if(null!=resourceSms.getSmsType()){
				resourceSmsDto.setSmsType(resourceSms.getSmsType());
			}
			if(null!=resourceSms.getTemplateCode()){
				resourceSmsDto.setTemplateCode(resourceSms.getTemplateCode());
			}
			if(null!=resourceSms.getCreateTime()){
				resourceSmsDto.setCreateTime(resourceSms.getCreateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param resourceSmsDto 源dto
	 * @param resourceSms 目标entity
	 */
	public static void parseToEntity(ResourceSmsDto resourceSmsDto, ResourceSms resourceSms){
		parseToEntity(resourceSmsDto, resourceSms, false);
	}
	
	/**
	 * dto转entity
	 * @param resourceSmsDto 源dto
	 * @param resourceSms 目标entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(ResourceSmsDto resourceSmsDto, ResourceSms resourceSms, Boolean flag){
		if(flag){
			resourceSms.setId(resourceSmsDto.getId());
			resourceSms.setRescCode(resourceSmsDto.getRescCode());
			resourceSms.setSmsType(resourceSmsDto.getSmsType());
			resourceSms.setTemplateCode(resourceSmsDto.getTemplateCode());
			resourceSms.setCreateTime(resourceSmsDto.getCreateTime());
		}else{
			if(null!=resourceSmsDto.getId()){
				resourceSms.setId(resourceSmsDto.getId());
			}
			if(null!=resourceSmsDto.getRescCode()){
				resourceSms.setRescCode(resourceSmsDto.getRescCode());
			}
			if(null!=resourceSmsDto.getSmsType()){
				resourceSms.setSmsType(resourceSmsDto.getSmsType());
			}
			if(null!=resourceSmsDto.getTemplateCode()){
				resourceSms.setTemplateCode(resourceSmsDto.getTemplateCode());
			}
			if(null!=resourceSmsDto.getCreateTime()){
				resourceSms.setCreateTime(resourceSmsDto.getCreateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param resourceSmsList 源entity列表
	 * @param resourceSmsDtoList 目标dto列表
	 */
	public static void parseToDtoList(List<ResourceSms> resourceSmsList, List<ResourceSmsDto> resourceSmsDtoList ){
		parseToDtoList(resourceSmsList, resourceSmsDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param resourceSmsList 源entity列表
	 * @param resourceSmsDtoList 目标dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<ResourceSms> resourceSmsList, List<ResourceSmsDto> resourceSmsDtoList, Boolean flag){
		if(null!=resourceSmsList&&!resourceSmsList.isEmpty()){
			for (ResourceSms resourceSms:resourceSmsList) {
				ResourceSmsDto resourceSmsDto = new ResourceSmsDto();
				parseToDto(resourceSms, resourceSmsDto, flag);
				resourceSmsDtoList.add(resourceSmsDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param resourceSmsDtoList 源dto列表
	 * @param resourceSmsList 目标entity列表
	 */
	public static void parseToEntityList(List<ResourceSmsDto> resourceSmsDtoList, List<ResourceSms> resourceSmsList){
		parseToEntityList(resourceSmsDtoList, resourceSmsList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param resourceSmsDtoList 源dto列表
	 * @param resourceSmsList 目标entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<ResourceSmsDto> resourceSmsDtoList, List<ResourceSms> resourceSmsList, Boolean flag){
		if(null!=resourceSmsDtoList&&!resourceSmsDtoList.isEmpty()){
			for (ResourceSmsDto resourceSmsDto:resourceSmsDtoList) {
				ResourceSms resourceSms = new ResourceSms();
				parseToEntity(resourceSmsDto,resourceSms,flag);
				resourceSmsList.add(resourceSms);
			}
		}
	}
}
