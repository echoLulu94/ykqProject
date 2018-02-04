package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.LoginLogHisDto;
import com.cxs.extension.ath.entity.LoginLogHis;
/**
* 
* @Description: 登录日志历史DTO和登录日志历史互转工具类
* @ClassName: LoginLogHisParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class LoginLogHisParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param loginLogHis 源登录日志历史entity
	 * @param loginLogHisDto 目标登录日志历史dto
	 */
	public static void parseToDto(LoginLogHis loginLogHis, LoginLogHisDto loginLogHisDto){
		parseToDto(loginLogHis, loginLogHisDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param loginLogHis 源登录日志历史entity
	 * @param loginLogHisDto 目标登录日志历史dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(LoginLogHis loginLogHis, LoginLogHisDto loginLogHisDto, Boolean flag){
		if(flag){
			loginLogHisDto.setId(loginLogHis.getId());
			loginLogHisDto.setLoginName(loginLogHis.getLoginName());
			loginLogHisDto.setLoginTime(loginLogHis.getLoginTime());
			loginLogHisDto.setLoginChannel(loginLogHis.getLoginChannel());
			loginLogHisDto.setDeviceId(loginLogHis.getDeviceId());
			loginLogHisDto.setLoginIp(loginLogHis.getLoginIp());
			loginLogHisDto.setLoginFlag(loginLogHis.getLoginFlag());
			loginLogHisDto.setCreateTime(loginLogHis.getCreateTime());
		}else{
			if(null!=loginLogHis.getId()){
				loginLogHisDto.setId(loginLogHis.getId());
			}
			if(null!=loginLogHis.getLoginName()){
				loginLogHisDto.setLoginName(loginLogHis.getLoginName());
			}
			if(null!=loginLogHis.getLoginTime()){
				loginLogHisDto.setLoginTime(loginLogHis.getLoginTime());
			}
			if(null!=loginLogHis.getLoginChannel()){
				loginLogHisDto.setLoginChannel(loginLogHis.getLoginChannel());
			}
			if(null!=loginLogHis.getDeviceId()){
				loginLogHisDto.setDeviceId(loginLogHis.getDeviceId());
			}
			if(null!=loginLogHis.getLoginIp()){
				loginLogHisDto.setLoginIp(loginLogHis.getLoginIp());
			}
			if(null!=loginLogHis.getLoginFlag()){
				loginLogHisDto.setLoginFlag(loginLogHis.getLoginFlag());
			}
			if(null!=loginLogHis.getCreateTime()){
				loginLogHisDto.setCreateTime(loginLogHis.getCreateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param loginLogHisDto 源登录日志历史dto
	 * @param loginLogHis 目标登录日志历史entity
	 */
	public static void parseToEntity(LoginLogHisDto loginLogHisDto, LoginLogHis loginLogHis){
		parseToEntity(loginLogHisDto, loginLogHis, false);
	}
	
	/**
	 * dto转entity
	 * @param loginLogHisDto 源登录日志历史dto
	 * @param loginLogHis 目标登录日志历史entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(LoginLogHisDto loginLogHisDto, LoginLogHis loginLogHis, Boolean flag){
		if(flag){
			loginLogHis.setId(loginLogHisDto.getId());
			loginLogHis.setLoginName(loginLogHisDto.getLoginName());
			loginLogHis.setLoginTime(loginLogHisDto.getLoginTime());
			loginLogHis.setLoginChannel(loginLogHisDto.getLoginChannel());
			loginLogHis.setDeviceId(loginLogHisDto.getDeviceId());
			loginLogHis.setLoginIp(loginLogHisDto.getLoginIp());
			loginLogHis.setLoginFlag(loginLogHisDto.getLoginFlag());
			loginLogHis.setCreateTime(loginLogHisDto.getCreateTime());
		}else{
			if(null!=loginLogHisDto.getId()){
				loginLogHis.setId(loginLogHisDto.getId());
			}
			if(null!=loginLogHisDto.getLoginName()){
				loginLogHis.setLoginName(loginLogHisDto.getLoginName());
			}
			if(null!=loginLogHisDto.getLoginTime()){
				loginLogHis.setLoginTime(loginLogHisDto.getLoginTime());
			}
			if(null!=loginLogHisDto.getLoginChannel()){
				loginLogHis.setLoginChannel(loginLogHisDto.getLoginChannel());
			}
			if(null!=loginLogHisDto.getDeviceId()){
				loginLogHis.setDeviceId(loginLogHisDto.getDeviceId());
			}
			if(null!=loginLogHisDto.getLoginIp()){
				loginLogHis.setLoginIp(loginLogHisDto.getLoginIp());
			}
			if(null!=loginLogHisDto.getLoginFlag()){
				loginLogHis.setLoginFlag(loginLogHisDto.getLoginFlag());
			}
			if(null!=loginLogHisDto.getCreateTime()){
				loginLogHis.setCreateTime(loginLogHisDto.getCreateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param loginLogHisList 源登录日志历史entity列表
	 * @param loginLogHisDtoList 目标登录日志历史dto列表
	 */
	public static void parseToDtoList(List<LoginLogHis> loginLogHisList, List<LoginLogHisDto> loginLogHisDtoList ){
		parseToDtoList(loginLogHisList, loginLogHisDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param loginLogHisList 源登录日志历史entity列表
	 * @param loginLogHisDtoList 目标登录日志历史dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<LoginLogHis> loginLogHisList, List<LoginLogHisDto> loginLogHisDtoList, Boolean flag){
		if(null!=loginLogHisList&&!loginLogHisList.isEmpty()){
			for (LoginLogHis loginLogHis:loginLogHisList) {
				LoginLogHisDto loginLogHisDto = new LoginLogHisDto();
				parseToDto(loginLogHis, loginLogHisDto, flag);
				loginLogHisDtoList.add(loginLogHisDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param loginLogHisDtoList 源登录日志历史dto列表
	 * @param loginLogHisList 目标登录日志历史entity列表
	 */
	public static void parseToEntityList(List<LoginLogHisDto> loginLogHisDtoList, List<LoginLogHis> loginLogHisList){
		parseToEntityList(loginLogHisDtoList, loginLogHisList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param loginLogHisDtoList 源登录日志历史dto列表
	 * @param loginLogHisList 目标登录日志历史entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<LoginLogHisDto> loginLogHisDtoList, List<LoginLogHis> loginLogHisList, Boolean flag){
		if(null!=loginLogHisDtoList&&!loginLogHisDtoList.isEmpty()){
			for (LoginLogHisDto loginLogHisDto:loginLogHisDtoList) {
				LoginLogHis loginLogHis = new LoginLogHis();
				parseToEntity(loginLogHisDto,loginLogHis,flag);
				loginLogHisList.add(loginLogHis);
			}
		}
	}
}
