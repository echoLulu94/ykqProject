package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.entity.User;
import com.cxs.extension.ath.mapper.UserMapper;
import com.cxs.extension.ath.result.UserResult;
import com.cxs.extension.ath.service.api.UserService;
import com.cxs.extension.ath.utils.UserParseUtil;
import com.cxs.extension.core.utils.CharacterUtil;
import com.cxs.extension.core.utils.MessageDigestUtil;
import com.cxs.extension.core.utils.RedisUtil;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.cxs.framework.utils.MD5;
import com.cxs.framework.utils.StringUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 用户业务处理实现类
 * @ClassName: UserServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月21日 
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DictItemService dictItemService;
	@Autowired
	private UserService userService;
	
	@Override
	public ResultDo<UserDto> saveUser(UserDto userDto) {
		ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
		User user =new User();
		/*当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=userDto){
				User userTmp = userMapper.findByPhone(userDto.getPhone());
				if(null == userTmp) {
					userDto.setSalt(CharacterUtil.createRandomId(256));
					userDto.setPwd(MessageDigestUtil.hmacsha512(userDto.getPwd(), userDto.getSalt()));
					userDto.setCreateTime(time);
					userDto.setRegisterTime(time);
					userDto.setId(IdUtil.getUuid());
					UserParseUtil.parseToEntity(userDto,user);
					userMapper.insert(user);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}else {
					resultDo.setResultDo(UserResult.USER_EXIST);
					logger.error(UserResult.USER_EXIST.getValue());
				}
			}else{
				resultDo.setResultDo(UserResult.SAVE_FAILURE);
				logger.error(UserResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.SAVE_FAILURE);
			logger.error(UserResult.SAVE_FAILURE.getValue(), e);
		}
		//返回数据时密码和加密因子设为空
		userDto.setSalt("******");
		userDto.setPwd("******");
		resultDo.setResultData(userDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteUserById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = userMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(UserResult.DELETE_USER_NOT_EXIST);
					logger.info(UserResult.DELETE_USER_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(UserResult.DELETE_ID_NOT_NULL);
				logger.error(UserResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.DELETE_FAILURE);
			logger.error(UserResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Override
	public ResultDo<String[]> deleteUserByIds(String[] ids) {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			userMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(UserResult.DELETE_IDS_NOT_NULL);
				logger.error(UserResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.DELETE_BY_IDS_FAILURE);
			logger.error(UserResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Override
	public ResultDo<List<String>> deleteUserByIdList(List<String> idList) {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			userMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(UserResult.DELETE_IDS_NOT_NULL);
				logger.error(UserResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.DELETE_BY_IDS_FAILURE);
			logger.error(UserResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<UserDto> updateUser(UserDto userDto) {
		ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
		/*当前时间*/
		long time = System.currentTimeMillis();
		try{
			User user = userMapper.selectByPrimaryKey(userDto.getId());
			user.setHeadImgUrl(userDto.getHeadImgUrl());
			user.setRealName(userDto.getRealName());
			user.setPhone(userDto.getPhone());
			user.setCode(userDto.getCode());
			user.setSex(userDto.getSex());
			user.setNickName(userDto.getNickName());
			user.setEnName(userDto.getEnName());
			user.setIdcard(userDto.getIdcard());
			user.setBirthday(userDto.getBirthday());
			user.setUserType(userDto.getUserType());
			user.setLocked(userDto.getLocked());
			user.setEmail(userDto.getEmail());
			user.setUpdateTime(time);
			user.setUpdateBy(userDto.getUpdateBy());
			userMapper.updateByPrimaryKeySelective(user);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.UPDATE_FAILURE);
			logger.error(UserResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(userDto);
		return resultDo;
	}

	@Override
	public ResultDo<UserDto> findUserById(String id) {
		UserDto userDto = new UserDto();
		ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
		try{
			if(null!=id&&!"".equals(id)){
				User user = userMapper.selectByPrimaryKey(id);
				UserParseUtil.parseToDto(user,userDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(UserResult.FIND_BY_ID_NOT_NULL);
				logger.error(UserResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.FIND_FAILURE);
			logger.error(UserResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(userDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<UserDto>> findUser(PageDto<UserDto> pageDto) {
		logger.debug("debug test");
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		List<User> userList = null;
		ResultDo<PageDto<UserDto>> resultDo=new ResultDo<PageDto<UserDto>>();
		try{
			pageDto.setTotalRecord(userMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			userList = userMapper.selectAll();
			UserParseUtil.parseToDtoList(userList,userDtoList);
			pageDto.setPageData(userDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.FIND_FAILURE);
			logger.error(UserResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<Map<String, Object>> findUser(PageDto<UserDto> pageDto, UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
        List<UserDto> userDtoList = new ArrayList<UserDto>();
		ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        List<User> userList=null;
		try{
			Example example = new Example(User.class);
			example.createCriteria();
			if(StringUtil.isNotEmpty(userDto.getRealName())) {
				example.getOredCriteria().get(0).andLike("realName", "%" + userDto.getRealName() + "%");
			}
			if(StringUtil.isNotEmpty(userDto.getPhone())) {
				example.getOredCriteria().get(0).andLike("phone", "%" + userDto.getPhone() + "%");
			}
			example.setOrderByClause("create_time  DESC");
			pageDto.setTotalRecord(userMapper.selectCountByExample(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			userList = userMapper.selectByExample(example);
			UserParseUtil.parseToDtoList(userList,userDtoList);
			pageDto.setPageData(userDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.FIND_FAILURE);
			logger.error(UserResult.FIND_FAILURE.getValue(), e);
		}
		resultMap.put("userMgmtDtoList", pageDto);
		resultMap.put("userStateList", dictItemService.findByTypeCode("USER_STATE").getResultData());
		resultMap.put("userTypeList", dictItemService.findByTypeCode("USER_TYPE").getResultData());
		resultMap.put("sexList", dictItemService.findByTypeCode("SEX").getResultData());
		resultDo.setResultData(resultMap);
		return resultDo;
	}

	@Override
	public UserDto findByPhone(String phone) {
		//User user = this.userMapper.findByPhone(phone);
		User userTmp = new User();
		userTmp.setPhone(phone);
		User user = this.userMapper.selectOne(userTmp);
		UserDto userDto = new UserDto();
		if(null!=user){
			UserParseUtil.parseToDto(user, userDto);
			return userDto;
		}else{
			return null;
		}
	}
	/*重置密码，设为字典固定值 ，未使用*/
	@Override
	public ResultDo<UserDto> resetPwd(UserDto userDto) {
		ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
		try{
			//查询该（手机号）用户对应的密钥。
			User userTmp = new User();
			userTmp.setPhone(userDto.getPhone());
			User user = this.userMapper.selectOne(userTmp);
			String pwd = RedisUtil.getInstance().getStr("SYS_CONF-RESET_PWD").trim();
			userDto.setPwd(MessageDigestUtil.hmacsha512(pwd, user.getSalt()));
			userMapper.updateToPwd(userDto.getPwd(), userDto.getId());
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.UPDATE_FAILURE);
			logger.error(UserResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(userDto);
		return resultDo;
	}

	
	@Override
	public ResultDo<UserDto> pwdEdit(UserDto userDto, String formerPwd) {
		ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
		try{ 
			ResultDo<UserDto> userDtoTmp = userService.findUserById(userDto.getId());
			if(InterfaceResult.SUCCESS.getKey().equals(userDtoTmp.getResultCode())) {
				String userPwd = MessageDigestUtil.hmacsha512(formerPwd, userDtoTmp.getResultData().getSalt());
				String pwd = userDtoTmp.getResultData().getPwd();
				if(userPwd.equals(pwd)) {
					userDto.setPwd(MessageDigestUtil.hmacsha512(userDto.getPwd(), userDtoTmp.getResultData().getSalt()));
					userMapper.updateToPwd(userDto.getPwd(), userDto.getId());
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());		
				}else {
					resultDo.setResultDo(UserResult.PWDEDIT_ERROR);
					logger.error(UserResult.PWDEDIT_ERROR.getValue());
				}
			}else {
				resultDo.setResultDo(UserResult.UPDATE_FAILURE);
				logger.error(UserResult.UPDATE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(UserResult.UPDATE_FAILURE);
			logger.error(UserResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(userDto);
		return resultDo;
	}

}