package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.ModuleDto;
import com.cxs.extension.ath.entity.Module;
/**
* 
* @Description: 模块DTO和模块互转工具类
* @ClassName: ModuleParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class ModuleParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param module 源模块entity
	 * @param moduleDto 目标模块dto
	 */
	public static void parseToDto(Module module, ModuleDto moduleDto){
		parseToDto(module, moduleDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param module 源模块entity
	 * @param moduleDto 目标模块dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Module module, ModuleDto moduleDto, Boolean flag){
		if(flag){
			moduleDto.setId(module.getId());
			moduleDto.setSubSysCode(module.getSubSysCode());
			moduleDto.setModCode(module.getModCode());
			moduleDto.setModValue(module.getModValue());
			moduleDto.setModName(module.getModName());
			moduleDto.setTableName(module.getTableName());
			moduleDto.setModUri(module.getModUri());
			moduleDto.setModDes(module.getModDes());
			moduleDto.setCreateTime(module.getCreateTime());
			moduleDto.setUpdateTime(module.getUpdateTime());
		}else{
			if(null!=module.getId()){
				moduleDto.setId(module.getId());
			}
			if(null!=module.getSubSysCode()){
				moduleDto.setSubSysCode(module.getSubSysCode());
			}
			if(null!=module.getModCode()){
				moduleDto.setModCode(module.getModCode());
			}
			if(null!=module.getModValue()){
				moduleDto.setModValue(module.getModValue());
			}
			if(null!=module.getModName()){
				moduleDto.setModName(module.getModName());
			}
			if(null!=module.getTableName()){
				moduleDto.setTableName(module.getTableName());
			}
			if(null!=module.getModUri()){
				moduleDto.setModUri(module.getModUri());
			}
			if(null!=module.getModDes()){
				moduleDto.setModDes(module.getModDes());
			}
			if(null!=module.getCreateTime()){
				moduleDto.setCreateTime(module.getCreateTime());
			}
			if(null!=module.getUpdateTime()){
				moduleDto.setUpdateTime(module.getUpdateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param moduleDto 源模块dto
	 * @param module 目标模块entity
	 */
	public static void parseToEntity(ModuleDto moduleDto, Module module){
		parseToEntity(moduleDto, module, false);
	}
	
	/**
	 * dto转entity
	 * @param moduleDto 源模块dto
	 * @param module 目标模块entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(ModuleDto moduleDto, Module module, Boolean flag){
		if(flag){
			module.setId(moduleDto.getId());
			module.setSubSysCode(moduleDto.getSubSysCode());
			module.setModCode(moduleDto.getModCode());
			module.setModValue(moduleDto.getModValue());
			module.setModName(moduleDto.getModName());
			module.setTableName(moduleDto.getTableName());
			module.setModUri(moduleDto.getModUri());
			module.setModDes(moduleDto.getModDes());
			module.setCreateTime(moduleDto.getCreateTime());
			module.setUpdateTime(moduleDto.getUpdateTime());
		}else{
			if(null!=moduleDto.getId()){
				module.setId(moduleDto.getId());
			}
			if(null!=moduleDto.getSubSysCode()){
				module.setSubSysCode(moduleDto.getSubSysCode());
			}
			if(null!=moduleDto.getModCode()){
				module.setModCode(moduleDto.getModCode());
			}
			if(null!=moduleDto.getModValue()){
				module.setModValue(moduleDto.getModValue());
			}
			if(null!=moduleDto.getModName()){
				module.setModName(moduleDto.getModName());
			}
			if(null!=moduleDto.getTableName()){
				module.setTableName(moduleDto.getTableName());
			}
			if(null!=moduleDto.getModUri()){
				module.setModUri(moduleDto.getModUri());
			}
			if(null!=moduleDto.getModDes()){
				module.setModDes(moduleDto.getModDes());
			}
			if(null!=moduleDto.getCreateTime()){
				module.setCreateTime(moduleDto.getCreateTime());
			}
			if(null!=moduleDto.getUpdateTime()){
				module.setUpdateTime(moduleDto.getUpdateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param moduleList 源模块entity列表
	 * @param moduleDtoList 目标模块dto列表
	 */
	public static void parseToDtoList(List<Module> moduleList, List<ModuleDto> moduleDtoList ){
		parseToDtoList(moduleList, moduleDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param moduleList 源模块entity列表
	 * @param moduleDtoList 目标模块dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Module> moduleList, List<ModuleDto> moduleDtoList, Boolean flag){
		if(null!=moduleList&&!moduleList.isEmpty()){
			for (Module module:moduleList) {
				ModuleDto moduleDto = new ModuleDto();
				parseToDto(module, moduleDto, flag);
				moduleDtoList.add(moduleDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param moduleDtoList 源模块dto列表
	 * @param moduleList 目标模块entity列表
	 */
	public static void parseToEntityList(List<ModuleDto> moduleDtoList, List<Module> moduleList){
		parseToEntityList(moduleDtoList, moduleList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param moduleDtoList 源模块dto列表
	 * @param moduleList 目标模块entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<ModuleDto> moduleDtoList, List<Module> moduleList, Boolean flag){
		if(null!=moduleDtoList&&!moduleDtoList.isEmpty()){
			for (ModuleDto moduleDto:moduleDtoList) {
				Module module = new Module();
				parseToEntity(moduleDto,module,flag);
				moduleList.add(module);
			}
		}
	}
}
