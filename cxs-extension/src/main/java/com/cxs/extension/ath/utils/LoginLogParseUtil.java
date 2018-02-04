package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.LoginLogDto;
import com.cxs.extension.ath.entity.LoginLog;
/**
* 
* @Description: 登录日志DTO和登录日志互转工具类
* @ClassName: LoginLogParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class LoginLogParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param loginLog 源登录日志entity
	 * @param loginLogDto 目标登录日志dto
	 */
	public static void parseToDto(LoginLog loginLog, LoginLogDto loginLogDto){
		parseToDto(loginLog, loginLogDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param loginLog 源登录日志entity
	 * @param loginLogDto 目标登录日志dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(LoginLog loginLog, LoginLogDto loginLogDto, Boolean flag){
		if(flag){
			loginLogDto.setId(loginLog.getId());
			loginLogDto.setLoginName(loginLog.getLoginName());
			loginLogDto.setLoginTime(loginLog.getLoginTime());
			loginLogDto.setLoginChannel(loginLog.getLoginChannel());
			loginLogDto.setDeviceId(loginLog.getDeviceId());
			loginLogDto.setLoginIp(loginLog.getLoginIp());
			loginLogDto.setLoginFlag(loginLog.getLoginFlag());
			loginLogDto.setCreateTime(loginLog.getCreateTime());
		}else{
			if(null!=loginLog.getId()){
				loginLogDto.setId(loginLog.getId());
			}
			if(null!=loginLog.getLoginName()){
				loginLogDto.setLoginName(loginLog.getLoginName());
			}
			if(null!=loginLog.getLoginTime()){
				loginLogDto.setLoginTime(loginLog.getLoginTime());
			}
			if(null!=loginLog.getLoginChannel()){
				loginLogDto.setLoginChannel(loginLog.getLoginChannel());
			}
			if(null!=loginLog.getDeviceId()){
				loginLogDto.setDeviceId(loginLog.getDeviceId());
			}
			if(null!=loginLog.getLoginIp()){
				loginLogDto.setLoginIp(loginLog.getLoginIp());
			}
			if(null!=loginLog.getLoginFlag()){
				loginLogDto.setLoginFlag(loginLog.getLoginFlag());
			}
			if(null!=loginLog.getCreateTime()){
				loginLogDto.setCreateTime(loginLog.getCreateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param loginLogDto 源登录日志dto
	 * @param loginLog 目标登录日志entity
	 */
	public static void parseToEntity(LoginLogDto loginLogDto, LoginLog loginLog){
		parseToEntity(loginLogDto, loginLog, false);
	}
	
	/**
	 * dto转entity
	 * @param loginLogDto 源登录日志dto
	 * @param loginLog 目标登录日志entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(LoginLogDto loginLogDto, LoginLog loginLog, Boolean flag){
		if(flag){
			loginLog.setId(loginLogDto.getId());
			loginLog.setLoginName(loginLogDto.getLoginName());
			loginLog.setLoginTime(loginLogDto.getLoginTime());
			loginLog.setLoginChannel(loginLogDto.getLoginChannel());
			loginLog.setDeviceId(loginLogDto.getDeviceId());
			loginLog.setLoginIp(loginLogDto.getLoginIp());
			loginLog.setLoginFlag(loginLogDto.getLoginFlag());
			loginLog.setCreateTime(loginLogDto.getCreateTime());
		}else{
			if(null!=loginLogDto.getId()){
				loginLog.setId(loginLogDto.getId());
			}
			if(null!=loginLogDto.getLoginName()){
				loginLog.setLoginName(loginLogDto.getLoginName());
			}
			if(null!=loginLogDto.getLoginTime()){
				loginLog.setLoginTime(loginLogDto.getLoginTime());
			}
			if(null!=loginLogDto.getLoginChannel()){
				loginLog.setLoginChannel(loginLogDto.getLoginChannel());
			}
			if(null!=loginLogDto.getDeviceId()){
				loginLog.setDeviceId(loginLogDto.getDeviceId());
			}
			if(null!=loginLogDto.getLoginIp()){
				loginLog.setLoginIp(loginLogDto.getLoginIp());
			}
			if(null!=loginLogDto.getLoginFlag()){
				loginLog.setLoginFlag(loginLogDto.getLoginFlag());
			}
			if(null!=loginLogDto.getCreateTime()){
				loginLog.setCreateTime(loginLogDto.getCreateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param loginLogList 源登录日志entity列表
	 * @param loginLogDtoList 目标登录日志dto列表
	 */
	public static void parseToDtoList(List<LoginLog> loginLogList, List<LoginLogDto> loginLogDtoList ){
		parseToDtoList(loginLogList, loginLogDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param loginLogList 源登录日志entity列表
	 * @param loginLogDtoList 目标登录日志dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<LoginLog> loginLogList, List<LoginLogDto> loginLogDtoList, Boolean flag){
		if(null!=loginLogList&&!loginLogList.isEmpty()){
			for (LoginLog loginLog:loginLogList) {
				LoginLogDto loginLogDto = new LoginLogDto();
				parseToDto(loginLog, loginLogDto, flag);
				loginLogDtoList.add(loginLogDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param loginLogDtoList 源登录日志dto列表
	 * @param loginLogList 目标登录日志entity列表
	 */
	public static void parseToEntityList(List<LoginLogDto> loginLogDtoList, List<LoginLog> loginLogList){
		parseToEntityList(loginLogDtoList, loginLogList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param loginLogDtoList 源登录日志dto列表
	 * @param loginLogList 目标登录日志entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<LoginLogDto> loginLogDtoList, List<LoginLog> loginLogList, Boolean flag){
		if(null!=loginLogDtoList&&!loginLogDtoList.isEmpty()){
			for (LoginLogDto loginLogDto:loginLogDtoList) {
				LoginLog loginLog = new LoginLog();
				parseToEntity(loginLogDto,loginLog,flag);
				loginLogList.add(loginLog);
			}
		}
	}
}
