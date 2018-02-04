package com.cxs.extension.ath.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.ath.dto.MenuDto;
import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.result.UserResult;
import com.cxs.extension.ath.service.api.UserService;
import com.cxs.extension.core.config.SysConfig;
import com.cxs.extension.core.utils.MessageDigestUtil;
import com.cxs.extension.core.utils.RedisUtil;
import com.cxs.extension.sys.interceptor.CorsInterceptor;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.ath.Token;

@Controller
@RequestMapping("/ath")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(CorsInterceptor.class);

	@Autowired
	private SysConfig sysConfig;
	@Autowired
	private UserService userService;
	@Autowired
	private DictItemService dictItemService;

	@RequestMapping("/login")
	@ResponseBody
	@NoAuth
	public ResultDo<UserDto> login(String phone, String pwd, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
		UserDto userDto = userService.findByPhone(phone);
		Integer loginFlag = 0;
		if (null != userDto) {
			// 获取用户输入的密码，并加密得到真实密码
			String password = MessageDigestUtil.hmacsha512(pwd, userDto.getSalt());
			if (userDto.getPwd().equals(password)) {
				Token token = Token.buildToken(sysConfig.getTokenName(), phone, userDto.getSalt(), Token.LOGIN_MAX_AGE);
				if (null == token) {
					resultDo.setResultDo(UserResult.LOGINNAME_OR_PWD_INCORRECT);
					logger.error(UserResult.LOGINNAME_OR_PWD_INCORRECT.getValue());
				} else {
					Cookie cookie = Token.buildCookie(sysConfig.getTokenName(), token.toTokenString(), token.getMaxAge());
					response.addCookie(cookie);
					loginFlag = 1;
				}
			} else {
				resultDo.setResultDo(UserResult.PWD_ERROR);
				logger.error(UserResult.PWD_ERROR.getValue());
			}
			if (loginFlag == 0) {
				// 登录失败
				if (null == userDto.getLoginFailCount()) {
					userDto.setLoginFailCount(0);
				}
				userDto.setLoginFailCount(userDto.getLoginFailCount() + 1);
				userService.updateUser(userDto);
			} else {
				// 登录成功
				userDto.setLoginTime(System.currentTimeMillis());
				if (null != userDto.getLoginFailCount() && userDto.getLoginFailCount() > 0) {
					// 登录失败次数不为0，
					userDto.setLoginFailCount(0);
				}
				// TODO 修改用户信息增加登录设备相关信息
				try {
					userService.updateUser(userDto);
				} catch (Exception e) {
					resultDo.setResultDo(UserResult.UPDATE_LOGIN_DEVICE_ERROR);
					logger.error(UserResult.UPDATE_LOGIN_DEVICE_ERROR.getValue(), e);
				}
				// TODO 记录登录日志
				// 返回用户信息,去除密码和加密秘钥信息
				userDto.setPwd("******");
				userDto.setSalt("******");
				

				/**所有菜单*/
				List<MenuDto> menuDtoList= new ArrayList<MenuDto>();
				
				MenuDto loginMenuDto = new MenuDto();
				loginMenuDto.setPath("/login");
				loginMenuDto.setComponent("login");
				loginMenuDto.setTitle("登陆");
				loginMenuDto.setHidden(true);
				loginMenuDto.setName("login");
				menuDtoList.add(loginMenuDto);

				MenuDto homeMenuDto = new MenuDto();
				homeMenuDto.setPath("/");
				homeMenuDto.setComponent("home");
				homeMenuDto.setTitle("首页");
				homeMenuDto.setIcon("el-icon-setting");
				homeMenuDto.setHidden(true);
				
				List<MenuDto> homeChildren = new ArrayList<MenuDto>();
				
				MenuDto indexMenuDto = new MenuDto();
				indexMenuDto.setPath("/index");
				indexMenuDto.setComponent("index");
				indexMenuDto.setTitle("首页");
				indexMenuDto.setName("index");
				homeChildren.add(indexMenuDto);
				
				homeMenuDto.setChildren(homeChildren);
				menuDtoList.add(homeMenuDto);
				
				if(null!=userDto.getUserType()&&userDto.getUserType().equals(RedisUtil.getInstance().getStr("USER_TYPE-SUPMGR"))) {
					/**一级菜单 - 权限管理 开始*/
					/**一级菜单权限管理对象*/
					MenuDto athMenuDto = new MenuDto();
					athMenuDto.setPath("/");
					athMenuDto.setComponent("home");
					athMenuDto.setTitle("权限管理");
					athMenuDto.setIcon("el-icon-setting");

					/**一级菜单权限管理对象子菜单列表*/
					List<MenuDto> athChildren = new ArrayList<MenuDto>();
					
					/**二级菜单-子系统管理*/
					MenuDto subSystemListMenuDto = new MenuDto();
					subSystemListMenuDto.setPath("/subSystemList");
					subSystemListMenuDto.setComponent("subSystemList");
					subSystemListMenuDto.setTitle("子系统管理");
					subSystemListMenuDto.setName("subSystemList");
					athChildren.add(subSystemListMenuDto);
					
					MenuDto moduleListMenuDto = new MenuDto();
					moduleListMenuDto.setPath("/moduleList");
					moduleListMenuDto.setComponent("moduleList");
					moduleListMenuDto.setTitle("模块管理");
					moduleListMenuDto.setName("moduleList");
					athChildren.add(moduleListMenuDto);
					
					MenuDto resourceListMenuDto = new MenuDto();
					resourceListMenuDto.setPath("/resourceList");
					resourceListMenuDto.setComponent("resourceList");
					resourceListMenuDto.setTitle("资源管理");
					resourceListMenuDto.setName("resourceList");
					athChildren.add(resourceListMenuDto);
					
					MenuDto resourceAddMenuDto = new MenuDto();
					resourceAddMenuDto.setPath("/resourceAdd");
					resourceAddMenuDto.setHidden(true);
					resourceAddMenuDto.setComponent("resourceAdd");
					resourceAddMenuDto.setTitle("资源添加");
					resourceAddMenuDto.setName("resourceAdd");
					athChildren.add(resourceAddMenuDto);
					
					MenuDto resourceEditMenuDto = new MenuDto();
					resourceEditMenuDto.setPath("/resourceEdit");
					resourceEditMenuDto.setHidden(true);
					resourceEditMenuDto.setComponent("resourceEdit");
					resourceEditMenuDto.setTitle("资源修改");
					resourceEditMenuDto.setName("resourceEdit");
					athChildren.add(resourceEditMenuDto);
					
					MenuDto resourceDetailMenuDto = new MenuDto();
					resourceDetailMenuDto.setPath("/resourceDetail");
					resourceDetailMenuDto.setHidden(true);
					resourceDetailMenuDto.setComponent("resourceDetail");
					resourceDetailMenuDto.setTitle("资源详情");
					resourceDetailMenuDto.setName("resourceDetail");
					athChildren.add(resourceDetailMenuDto);
					
					MenuDto userMgmtListMenuDto = new MenuDto();
					userMgmtListMenuDto.setPath("/userMgmtList");
					userMgmtListMenuDto.setComponent("userMgmtList");
					userMgmtListMenuDto.setTitle("用户管理");
					userMgmtListMenuDto.setName("userMgmtList");
					athChildren.add(userMgmtListMenuDto);
					
					MenuDto userMgmtAddMenuDto = new MenuDto();
					userMgmtAddMenuDto.setPath("/userMgmtAdd");
					userMgmtAddMenuDto.setHidden(true);
					userMgmtAddMenuDto.setComponent("userMgmtAdd");
					userMgmtAddMenuDto.setTitle("用户增加");
					userMgmtAddMenuDto.setName("userMgmtAdd");
					athChildren.add(userMgmtAddMenuDto);
					
					MenuDto userMgmtEditMenuDto = new MenuDto();
					userMgmtEditMenuDto.setPath("/userMgmtEdit");
					userMgmtEditMenuDto.setHidden(true);
					userMgmtEditMenuDto.setComponent("userMgmtEdit");
					userMgmtEditMenuDto.setTitle("用户修改");
					userMgmtEditMenuDto.setName("userMgmtEdit");
					athChildren.add(userMgmtEditMenuDto);
					
					MenuDto userMgmtDetailMenuDto = new MenuDto();
					userMgmtDetailMenuDto.setPath("/userMgmtDetail");
					userMgmtDetailMenuDto.setHidden(true);
					userMgmtDetailMenuDto.setComponent("userMgmtDetail");
					userMgmtDetailMenuDto.setTitle("用户详情");
					userMgmtDetailMenuDto.setName("userMgmtDetail");
					athChildren.add(userMgmtDetailMenuDto);
					
					MenuDto userSetMenuDto = new MenuDto();
					userSetMenuDto.setPath("/userSet");
				    userSetMenuDto.setHidden(true);
					userSetMenuDto.setComponent("userSet");
					userSetMenuDto.setTitle("设置");
					userSetMenuDto.setName("userSet");
					athChildren.add(userSetMenuDto);
					
					MenuDto pwdEditMenuDto = new MenuDto();
					pwdEditMenuDto.setPath("/pwdEdit");
					pwdEditMenuDto.setHidden(true);
					pwdEditMenuDto.setComponent("pwdEdit");
					pwdEditMenuDto.setTitle("密码修改");
					pwdEditMenuDto.setName("pwdEdit");
					athChildren.add(pwdEditMenuDto);
					
					MenuDto roleMgmtListMenuDto = new MenuDto();
					roleMgmtListMenuDto.setPath("/roleMgmtList");
					roleMgmtListMenuDto.setComponent("roleMgmtList");
					roleMgmtListMenuDto.setTitle("角色管理");
					roleMgmtListMenuDto.setName("roleMgmtList");
					athChildren.add(roleMgmtListMenuDto);
					
					MenuDto roleMgmtAddMenuDto = new MenuDto();
					roleMgmtAddMenuDto.setPath("/roleMgmtAdd");
					roleMgmtAddMenuDto.setHidden(true);
					roleMgmtAddMenuDto.setComponent("roleMgmtAdd");
					roleMgmtAddMenuDto.setTitle("角色增加");
					roleMgmtAddMenuDto.setName("roleMgmtAdd");
					athChildren.add(roleMgmtAddMenuDto);
					
					MenuDto roleMgmtEditMenuDto = new MenuDto();
					roleMgmtEditMenuDto.setPath("/roleMgmtEdit");
					roleMgmtEditMenuDto.setHidden(true);
					roleMgmtEditMenuDto.setComponent("roleMgmtEdit");
					roleMgmtEditMenuDto.setTitle("角色修改");
					roleMgmtEditMenuDto.setName("roleMgmtEdit");
					athChildren.add(roleMgmtEditMenuDto);
					
					MenuDto roleMgmtDetailMenuDto = new MenuDto();
					roleMgmtDetailMenuDto.setPath("/roleMgmtDetail");
					roleMgmtDetailMenuDto.setHidden(true);
					roleMgmtDetailMenuDto.setComponent("roleMgmtDetail");
					roleMgmtDetailMenuDto.setTitle("角色详情");
					roleMgmtDetailMenuDto.setName("roleMgmtDetail");
					athChildren.add(roleMgmtDetailMenuDto);
					
					MenuDto menuMgmtListMenuDto = new MenuDto();
					menuMgmtListMenuDto.setPath("/menuMgmtList");
					menuMgmtListMenuDto.setComponent("menuMgmtList");
					menuMgmtListMenuDto.setTitle("菜单管理");
					menuMgmtListMenuDto.setName("menuMgmtList");
					athChildren.add(menuMgmtListMenuDto);
					
					MenuDto menuMgmtAddMenuDto = new MenuDto();
					menuMgmtAddMenuDto.setPath("/menuMgmtAdd");
					menuMgmtAddMenuDto.setHidden(true);
					menuMgmtAddMenuDto.setComponent("menuMgmtAdd");
					menuMgmtAddMenuDto.setTitle("菜单增加");
					menuMgmtAddMenuDto.setName("menuMgmtAdd");
					athChildren.add(menuMgmtAddMenuDto);
					
					MenuDto menuMgmtEditMenuDto = new MenuDto();
					menuMgmtEditMenuDto.setPath("/menuMgmtEdit");
					menuMgmtEditMenuDto.setHidden(true);
					menuMgmtEditMenuDto.setComponent("menuMgmtEdit");
					menuMgmtEditMenuDto.setTitle("菜单修改");
					menuMgmtEditMenuDto.setName("menuMgmtEdit");
					athChildren.add(menuMgmtEditMenuDto);
					
					MenuDto menuMgmtDetailMenuDto = new MenuDto();
					menuMgmtDetailMenuDto.setPath("/menuMgmtDetail");
					menuMgmtDetailMenuDto.setHidden(true);
					menuMgmtDetailMenuDto.setComponent("menuMgmtDetail");
					menuMgmtDetailMenuDto.setTitle("菜单详情");
					menuMgmtDetailMenuDto.setName("menuMgmtDetail");
					athChildren.add(menuMgmtDetailMenuDto);
					
					/**把二级菜单加入一级菜单*/
					athMenuDto.setChildren(athChildren);
					/**把一级菜单权限管理加入所有菜单里欸包*/
					menuDtoList.add(athMenuDto);
					/**一级菜单 - 权限管理 结束*/
					
					/**一级菜单 - 配置管理 开始*/
					/**一级菜单配置管理对象*/
					MenuDto confMenuDto = new MenuDto();
					confMenuDto.setPath("/");
					confMenuDto.setComponent("home");
					confMenuDto.setTitle("配置管理");
					confMenuDto.setIcon("fa fa-book");
	
					/**一级菜单配置管理对象子菜单列表*/
					List<MenuDto> confChildren = new ArrayList<MenuDto>();
					
					/**二级菜单-字典类型管理*/
					MenuDto dictionaryTypeMenuDto = new MenuDto();
					dictionaryTypeMenuDto.setPath("/dictionaryType");
					dictionaryTypeMenuDto.setComponent("dictionaryType");
					dictionaryTypeMenuDto.setTitle("字典类型管理");
					dictionaryTypeMenuDto.setName("dictionaryType");
					confChildren.add(dictionaryTypeMenuDto);
					
					MenuDto dictionaryTypeAddMenuDto = new MenuDto();
					dictionaryTypeAddMenuDto.setPath("/dictionaryTypeAdd");
					dictionaryTypeAddMenuDto.setHidden(true);
					dictionaryTypeAddMenuDto.setComponent("dictionaryTypeAdd");
					dictionaryTypeAddMenuDto.setTitle("字典类型新增");
					dictionaryTypeAddMenuDto.setName("dictionaryTypeAdd");
					confChildren.add(dictionaryTypeAddMenuDto);
					
					MenuDto dictTypeDetailMenuDto = new MenuDto();
					dictTypeDetailMenuDto.setPath("/dictTypeDetail");
					dictTypeDetailMenuDto.setHidden(true);
					dictTypeDetailMenuDto.setComponent("dictTypeDetail");
					dictTypeDetailMenuDto.setTitle("字典类型详情");
					dictTypeDetailMenuDto.setName("dictTypeDetail");
					confChildren.add(dictTypeDetailMenuDto);
					
					MenuDto dictionaryItemMenuDto = new MenuDto();
					dictionaryItemMenuDto.setPath("/dictionaryItem");
					dictionaryItemMenuDto.setComponent("dictionaryItem");
					dictionaryItemMenuDto.setTitle("字典项管理");
					dictionaryItemMenuDto.setName("dictionaryItem");
					confChildren.add(dictionaryItemMenuDto);
					
					MenuDto dictItemDetailMenuDto = new MenuDto();
					dictItemDetailMenuDto.setPath("/dictItemDetail");
					dictItemDetailMenuDto.setHidden(true);
					dictItemDetailMenuDto.setComponent("dictItemDetail");
					dictItemDetailMenuDto.setTitle("字典项详情");
					dictItemDetailMenuDto.setName("dictItemDetail");
					confChildren.add(dictItemDetailMenuDto);
	
					
					/**把二级菜单加入一级菜单*/
					confMenuDto.setChildren(confChildren);
					/**把一级菜单配置管理加入所有菜单里*/
					menuDtoList.add(confMenuDto);
				}

				/**一级菜单 - 活动管理 开始*/
				/**一级菜单活动管理对象*/
				MenuDto actMenuDto = new MenuDto();
				actMenuDto.setPath("/");
				actMenuDto.setComponent("home");
				actMenuDto.setTitle("活动管理");
				actMenuDto.setIcon("fa fa-id-card-o");

				/**一级菜单活动管理对象子菜单列表*/
				List<MenuDto> actChildren = new ArrayList<MenuDto>();
				
				/**二级菜单-活动列表*/
				MenuDto activityListMenuDto = new MenuDto();
				activityListMenuDto.setPath("/activityList");
				activityListMenuDto.setComponent("activityList");
				activityListMenuDto.setTitle("活动列表");
				activityListMenuDto.setName("activityList");
				actChildren.add(activityListMenuDto);
				
				MenuDto activityAddMenuDto = new MenuDto();
				activityAddMenuDto.setPath("/activityAdd");
				activityAddMenuDto.setHidden(true);
				activityAddMenuDto.setComponent("activityAdd");
				activityAddMenuDto.setTitle("活动新增");
				activityAddMenuDto.setName("activityAdd");
				actChildren.add(activityAddMenuDto);
				
				MenuDto activityEditMenuDto = new MenuDto();
				activityEditMenuDto.setPath("/activityEdit");
				activityEditMenuDto.setHidden(true);
				activityEditMenuDto.setComponent("activityEdit");
				activityEditMenuDto.setTitle("活动编辑");
				activityEditMenuDto.setName("activityEdit");
				actChildren.add(activityEditMenuDto);
				
				MenuDto activityDetailMenuDto = new MenuDto();
				activityDetailMenuDto.setPath("/activityDetail");
				activityDetailMenuDto.setHidden(true);
				activityDetailMenuDto.setComponent("activityDetail");
				activityDetailMenuDto.setTitle("活动详情");
				activityDetailMenuDto.setName("activityDetail");
				actChildren.add(activityDetailMenuDto);
				
				MenuDto activityEnrollMenuDto = new MenuDto();
				activityEnrollMenuDto.setPath("/activityEnroll");
				activityEnrollMenuDto.setHidden(true);
				activityEnrollMenuDto.setComponent("activityEnroll");
				activityEnrollMenuDto.setTitle("报名信息");
				activityEnrollMenuDto.setName("activityEnroll");
				actChildren.add(activityEnrollMenuDto);
				
				/**把二级菜单加入一级菜单*/
				actMenuDto.setChildren(actChildren);
				/**把一级菜单活动管理加入所有菜单里*/
				menuDtoList.add(actMenuDto);
				
				/**一级菜单 - 资讯管理 开始*/
				/**一级菜单资讯管理对象*/
				MenuDto actLiveMenuDto = new MenuDto();
				actLiveMenuDto.setPath("/");
				actLiveMenuDto.setComponent("home");
				actLiveMenuDto.setTitle("资讯管理");
				actLiveMenuDto.setIcon("fa fa-video-camera");

				/**一级菜单资讯管理对象子菜单列表*/
				List<MenuDto> actLiveChildren = new ArrayList<MenuDto>();
				
				/**二级菜单-资讯列表*/
				MenuDto activityLiveListMenuDto = new MenuDto();
				activityLiveListMenuDto.setPath("/activityLiveList");
				activityLiveListMenuDto.setComponent("activityLiveList");
				activityLiveListMenuDto.setTitle("资讯列表");
				activityLiveListMenuDto.setName("activityLiveList");
				actLiveChildren.add(activityLiveListMenuDto);
				
				MenuDto activityLiveAddMenuDto = new MenuDto();
				activityLiveAddMenuDto.setPath("/activityLiveAdd");
				activityLiveAddMenuDto.setHidden(true);
				activityLiveAddMenuDto.setComponent("activityLiveAdd");
				activityLiveAddMenuDto.setTitle("资讯新增");
				activityAddMenuDto.setName("activityLiveAdd");
				actLiveChildren.add(activityLiveAddMenuDto);
				
				MenuDto activityLiveEditMenuDto = new MenuDto();
				activityLiveEditMenuDto.setPath("/activityLiveEdit");
				activityLiveEditMenuDto.setHidden(true);
				activityLiveEditMenuDto.setComponent("activityLiveEdit");
				activityLiveEditMenuDto.setTitle("资讯编辑");
				activityLiveEditMenuDto.setName("activityLiveEdit");
				actLiveChildren.add(activityLiveEditMenuDto);
				
				MenuDto activityLiveDetailMenuDto = new MenuDto();
				activityLiveDetailMenuDto.setPath("/activityLiveDetail");
				activityLiveDetailMenuDto.setHidden(true);
				activityLiveDetailMenuDto.setComponent("activityLiveDetail");
				activityLiveDetailMenuDto.setTitle("资讯详情");
				activityLiveDetailMenuDto.setName("activityLiveDetail");
				actLiveChildren.add(activityLiveDetailMenuDto);
				
				/**把二级菜单加入一级菜单*/
				actLiveMenuDto.setChildren(actLiveChildren);
				/**把actLive菜单活动管理加入所有菜单里*/
				menuDtoList.add(actLiveMenuDto);
				
				/**一级菜单 - 刊物管理 开始*/
				/**一级菜单刊物管理对象*/
				MenuDto julMenuDto = new MenuDto();
				julMenuDto.setPath("/");
				julMenuDto.setComponent("home");
				julMenuDto.setTitle("刊物管理");
				julMenuDto.setIcon("fa fa-print");

				/**一级菜单刊物管理对象子菜单列表*/
				List<MenuDto> julChildren = new ArrayList<MenuDto>();
				
				/**二级菜单-刊物列表*/
				MenuDto journalMgmtListMenuDto = new MenuDto();
				journalMgmtListMenuDto.setPath("/journalMgmtList");
				journalMgmtListMenuDto.setComponent("journalMgmtList");
				journalMgmtListMenuDto.setTitle("刊物列表");
				journalMgmtListMenuDto.setName("journalMgmtList");
				julChildren.add(journalMgmtListMenuDto);
				
				MenuDto journalMgmtAddMenuDto = new MenuDto();
				journalMgmtAddMenuDto.setPath("/journalMgmtAdd");
				journalMgmtAddMenuDto.setHidden(true);
				journalMgmtAddMenuDto.setComponent("journalMgmtAdd");
				journalMgmtAddMenuDto.setTitle("刊物新增");
				activityAddMenuDto.setName("journalMgmtAdd");
				julChildren.add(journalMgmtAddMenuDto);
				
				MenuDto journalMgmtEditMenuDto = new MenuDto();
				journalMgmtEditMenuDto.setPath("/journalMgmtEdit");
				journalMgmtEditMenuDto.setHidden(true);
				journalMgmtEditMenuDto.setComponent("journalMgmtEdit");
				journalMgmtEditMenuDto.setTitle("刊物编辑");
				journalMgmtEditMenuDto.setName("journalMgmtEdit");
				julChildren.add(journalMgmtEditMenuDto);
				
				MenuDto journalMgmtDetailMenuDto = new MenuDto();
				journalMgmtDetailMenuDto.setPath("/journalMgmtDetail");
				journalMgmtDetailMenuDto.setHidden(true);
				journalMgmtDetailMenuDto.setComponent("journalMgmtDetail");
				journalMgmtDetailMenuDto.setTitle("刊物详情");
				journalMgmtDetailMenuDto.setName("journalMgmtDetail");
				julChildren.add(journalMgmtDetailMenuDto);
				
				MenuDto journalMgmtAddUploadMenuDto = new MenuDto();
				journalMgmtAddUploadMenuDto.setPath("/journalMgmtAddUpload");
				journalMgmtAddUploadMenuDto.setHidden(true);
				journalMgmtAddUploadMenuDto.setComponent("journalMgmtAddUpload");
				journalMgmtAddUploadMenuDto.setTitle("新增刊物上传");
				journalMgmtAddUploadMenuDto.setName("journalMgmtAddUpload");
				julChildren.add(journalMgmtAddUploadMenuDto);
				
				MenuDto journalMgmtEditUploadMenuDto = new MenuDto();
				journalMgmtEditUploadMenuDto.setPath("/journalMgmtEditUpload");
				journalMgmtEditUploadMenuDto.setHidden(true);
				journalMgmtEditUploadMenuDto.setComponent("journalMgmtEditUpload");
				journalMgmtEditUploadMenuDto.setTitle("修改刊物上传");
				journalMgmtEditUploadMenuDto.setName("journalMgmtEditUpload");
				julChildren.add(journalMgmtEditUploadMenuDto);
				
				MenuDto journalContentListMenuDto = new MenuDto();
				journalContentListMenuDto.setPath("/journalContentList");
				journalContentListMenuDto.setHidden(true);
				journalContentListMenuDto.setComponent("journalContentList");
				journalContentListMenuDto.setTitle("刊物内页");
				journalContentListMenuDto.setName("journalContentList");
				julChildren.add(journalContentListMenuDto);
				
				MenuDto journalContentAddMenuDto = new MenuDto();
				journalContentAddMenuDto.setPath("/journalContentAdd");
				journalContentAddMenuDto.setHidden(true);
				journalContentAddMenuDto.setComponent("journalContentAdd");
				journalContentAddMenuDto.setTitle("刊物内页增加");
				journalContentAddMenuDto.setName("journalContentAdd");
				julChildren.add(journalContentAddMenuDto);
				
				MenuDto journalContentEditMenuDto = new MenuDto();
				journalContentEditMenuDto.setPath("/journalContentEdit");
				journalContentEditMenuDto.setHidden(true);
				journalContentEditMenuDto.setComponent("journalContentEdit");
				journalContentEditMenuDto.setTitle("刊物内页修改");
				journalContentEditMenuDto.setName("journalContentEdit");
				julChildren.add(journalContentEditMenuDto);
				
				MenuDto journalContentDetailMenuDto = new MenuDto();
				journalContentDetailMenuDto.setPath("/journalContentDetail");
				journalContentDetailMenuDto.setHidden(true);
				journalContentDetailMenuDto.setComponent("journalContentDetail");
				journalContentDetailMenuDto.setTitle("刊物内页详情");
				journalContentDetailMenuDto.setName("journalContentDetail");
				julChildren.add(journalContentDetailMenuDto);
					
				/**把二级菜单加入一级菜单*/
				julMenuDto.setChildren(julChildren);
				/**把刊物菜单活动管理加入所有菜单里*/
				menuDtoList.add(julMenuDto);

				MenuDto notFoundMenuDto = new MenuDto();
				notFoundMenuDto.setPath("*");
				notFoundMenuDto.setHidden(true);
				notFoundMenuDto.setTitle("404");
				notFoundMenuDto.setComponent("NotFound");
				menuDtoList.add(notFoundMenuDto);
				
				/**一级菜单 - 结束*/
				/**把所有菜单放入用户对象里*/
				userDto.setMenuDtoList(menuDtoList);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
				resultDo.setResultData(userDto);
			}
		} else {
			resultDo.setResultDo(UserResult.LOGIN_USER_NOT_EXIST);
			logger.error(UserResult.LOGIN_USER_NOT_EXIST.getValue());
		}
		return resultDo;
	}

	@RequestMapping("/logout")
	@ResponseBody
	@NoAuth
	public ResultDo<String> logout(HttpServletResponse response, HttpSession session) {
		ResultDo<String> resultDo = new ResultDo<String>();
		resultDo.setResultDo(InterfaceResult.SUCCESS);
		logger.info(InterfaceResult.SUCCESS.getValue());
		Cookie cookie = Token.buildCookie(sysConfig.getTokenName(), null, 0);
		response.addCookie(cookie);
		return resultDo;
	}

	@RequestMapping("/saveUser")
	@ResponseBody
	@NoAuth
	public ResultDo<UserDto> saveUser(UserDto userDto, HttpServletRequest request) {
		Token token = Token.readTokenFromCookie(sysConfig.getTokenName(),request.getCookies());
		if(null!=token){
			userDto.setCreateBy(token.getId());
		}
		return userService.saveUser(userDto);
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	@NoAuth
	public ResultDo<String> deleteUser(String id) {
		return userService.deleteUserById(id);
	}

	@RequestMapping("/deleteAllUser")
	@ResponseBody
	@NoAuth
	public ResultDo<String[]> deleteAllUser(String[] ids) {
		return userService.deleteUserByIds(ids);
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	@NoAuth
	public ResultDo<UserDto> updateUser(UserDto userDto, HttpServletRequest request) {
		Token token = Token.readTokenFromCookie(sysConfig.getTokenName(),request.getCookies());
		if(null!=token){
			userDto.setUpdateBy(token.getId());
		}
		return userService.updateUser(userDto);
	}

	/* 显示子系统详情 */
	@RequestMapping("/viewUser")
	@ResponseBody
	@NoAuth
	public ResultDo<Map<String, Object>> viewUser(String id) {
		logger.info("userId:" + id);
		ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			ResultDo<UserDto> userResultDto = userService.findUserById(id);
			String code = userResultDto.getResultCode();
			resultMap.put("userDto", userResultDto.getResultData());
			if (code.equals("API1000")) {
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			} else {
				resultDo.setResultDo(UserResult.VIEW_FAILURE);
				resultDo.setResultMsg(userResultDto.getResultMsg());
				logger.error(UserResult.VIEW_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(UserResult.VIEW_FAILURE);
			logger.error(UserResult.VIEW_FAILURE.getValue(), e);
		}
		resultMap.put("userStateList", dictItemService.findByTypeCode("USER_STATE").getResultData());
		resultMap.put("userTypeList", dictItemService.findByTypeCode("USER_TYPE").getResultData());
		resultMap.put("sexList", dictItemService.findByTypeCode("SEX").getResultData());
		resultDo.setResultData(resultMap);
		return resultDo;
	}

	@RequestMapping("/findUserById")
	@ResponseBody
	@NoAuth
	public ResultDo<UserDto> findUserById(String id) {
		return userService.findUserById(id);
	}

	@RequestMapping("/findUser")
	@ResponseBody
	@NoAuth
	public ResultDo<Map<String, Object>> findUser(PageDto<UserDto> pageDto, UserDto userdto) {
		return userService.findUser(pageDto, userdto);
	}

	/* 增加用户信息 */
	@RequestMapping("/addUser")
	@ResponseBody
	@NoAuth
	public ResultDo<Map<String, Object>> addUser() {
		ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap.put("userStateList", dictItemService.findByTypeCode("USER_STATE").getResultData());
			resultMap.put("userTypeList", dictItemService.findByTypeCode("USER_TYPE").getResultData());
			resultMap.put("sexList", dictItemService.findByTypeCode("SEX").getResultData());
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(UserResult.ADD_FAILURE);
			logger.error(UserResult.ADD_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resultMap);
		return resultDo;
	}

	/* 重置密码,设为字典固定值 */
	@RequestMapping("/resetPwd")
	@ResponseBody
	@NoAuth
	public ResultDo<UserDto> resetPwd(UserDto userDto) {
		return userService.resetPwd(userDto);
	}

	/* 修改密码 */
	@RequestMapping("/pwdEdit")
	@ResponseBody
	@NoAuth
	public ResultDo<UserDto> pwdEdit(UserDto userDto, String formerPwd) {
		return userService.pwdEdit(userDto, formerPwd);
	}

}
