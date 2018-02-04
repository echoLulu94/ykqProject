package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.RoleDto;
import com.cxs.extension.ath.entity.Role;
/**
* 
* @Description: 角色表DTO和角色表互转工具类
* @ClassName: RoleParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
* @date: 2017年09月19日
*/
public class RoleParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param role 源角色表entity
	 * @param roleDto 目标角色表dto
	 */
	public static void parseToDto(Role role, RoleDto roleDto){
		parseToDto(role, roleDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param role 源角色表entity
	 * @param roleDto 目标角色表dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Role role, RoleDto roleDto, Boolean flag){
		if(flag){
			roleDto.setId(role.getId());
			roleDto.setCode(role.getCode());
			roleDto.setName(role.getName());
			roleDto.setMemo(role.getMemo());
			roleDto.setState(role.getState());
			roleDto.setCreateTime(role.getCreateTime());
			roleDto.setCreateBy(role.getCreateBy());
			roleDto.setUpdateTime(role.getUpdateTime());
			roleDto.setUpdateBy(role.getUpdateBy());
		}else{
			if(null!=role.getId()){
				roleDto.setId(role.getId());
			}
			if(null!=role.getCode()){
				roleDto.setCode(role.getCode());
			}
			if(null!=role.getName()){
				roleDto.setName(role.getName());
			}
			if(null!=role.getMemo()){
				roleDto.setMemo(role.getMemo());
			}
			if(null!=role.getState()){
				roleDto.setState(role.getState());
			}
			if(null!=role.getCreateTime()){
				roleDto.setCreateTime(role.getCreateTime());
			}
			if(null!=role.getCreateBy()){
				roleDto.setCreateBy(role.getCreateBy());
			}
			if(null!=role.getUpdateTime()){
				roleDto.setUpdateTime(role.getUpdateTime());
			}
			if(null!=role.getUpdateBy()){
				roleDto.setUpdateBy(role.getUpdateBy());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param roleDto 源角色表dto
	 * @param role 目标角色表entity
	 */
	public static void parseToEntity(RoleDto roleDto, Role role){
		parseToEntity(roleDto, role, false);
	}
	
	/**
	 * dto转entity
	 * @param roleDto 源角色表dto
	 * @param role 目标角色表entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(RoleDto roleDto, Role role, Boolean flag){
		if(flag){
			role.setId(roleDto.getId());
			role.setCode(roleDto.getCode());
			role.setName(roleDto.getName());
			role.setMemo(roleDto.getMemo());
			role.setState(roleDto.getState());
			role.setCreateTime(roleDto.getCreateTime());
			role.setCreateBy(roleDto.getCreateBy());
			role.setUpdateTime(roleDto.getUpdateTime());
			role.setUpdateBy(roleDto.getUpdateBy());
		}else{
			if(null!=roleDto.getId()){
				role.setId(roleDto.getId());
			}
			if(null!=roleDto.getCode()){
				role.setCode(roleDto.getCode());
			}
			if(null!=roleDto.getName()){
				role.setName(roleDto.getName());
			}
			if(null!=roleDto.getMemo()){
				role.setMemo(roleDto.getMemo());
			}
			if(null!=roleDto.getState()){
				role.setState(roleDto.getState());
			}
			if(null!=roleDto.getCreateTime()){
				role.setCreateTime(roleDto.getCreateTime());
			}
			if(null!=roleDto.getCreateBy()){
				role.setCreateBy(roleDto.getCreateBy());
			}
			if(null!=roleDto.getUpdateTime()){
				role.setUpdateTime(roleDto.getUpdateTime());
			}
			if(null!=roleDto.getUpdateBy()){
				role.setUpdateBy(roleDto.getUpdateBy());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param roleList 源角色表entity列表
	 * @param roleDtoList 目标角色表dto列表
	 */
	public static void parseToDtoList(List<Role> roleList, List<RoleDto> roleDtoList ){
		parseToDtoList(roleList, roleDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param roleList 源角色表entity列表
	 * @param roleDtoList 目标角色表dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Role> roleList, List<RoleDto> roleDtoList, Boolean flag){
		if(null!=roleList&&!roleList.isEmpty()){
			for (Role role:roleList) {
				RoleDto roleDto = new RoleDto();
				parseToDto(role, roleDto, flag);
				roleDtoList.add(roleDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param roleDtoList 源角色表dto列表
	 * @param roleList 目标角色表entity列表
	 */
	public static void parseToEntityList(List<RoleDto> roleDtoList, List<Role> roleList){
		parseToEntityList(roleDtoList, roleList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param roleDtoList 源角色表dto列表
	 * @param roleList 目标角色表entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<RoleDto> roleDtoList, List<Role> roleList, Boolean flag){
		if(null!=roleDtoList&&!roleDtoList.isEmpty()){
			for (RoleDto roleDto:roleDtoList) {
				Role role = new Role();
				parseToEntity(roleDto,role,flag);
				roleList.add(role);
			}
		}
	}
}
