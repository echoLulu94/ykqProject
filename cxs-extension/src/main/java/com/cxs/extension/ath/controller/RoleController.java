package com.cxs.extension.ath.controller;


import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.extension.ath.dto.RoleDto;
import com.cxs.extension.ath.result.RoleResult;
import com.cxs.extension.ath.service.api.RoleService;
import com.cxs.extension.sys.interceptor.NoAuth;

/**
 *
 * @Description: 角色表控制器
 * @ClassName: RoleController
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 */
@Controller
@RequestMapping("/ath")
public class RoleController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleService roleService;

    /*保存角色表*/
    @RequestMapping(value = "/saveRole")
	@ResponseBody
	@NoAuth
    public ResultDo<RoleDto> saveRole(RoleDto roleDto){
    	return roleService.saveRole(roleDto);
	}

    /*删除角色表*/
    @RequestMapping(value = "/deleteRole")
	@ResponseBody
	@NoAuth
    public ResultDo<String> deleteRoleById(String id){
    	return roleService.deleteRoleById(id);
	}

	/*删除角色表*/
    @RequestMapping(value = "/deleteAllRole")
	@ResponseBody
	@NoAuth
    public ResultDo<String []> deleteAllRole(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = roleService.deleteRoleByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(RoleResult.DELETE_BY_IDS_FAILURE);
			logger.error(RoleResult.DELETE_BY_IDS_FAILURE.getValue(),e);
		}
		return resultDo;
	}

    /*更新角色表*/
    @RequestMapping(value = "/updateRole")
	@ResponseBody
	@NoAuth
    public ResultDo<RoleDto> updateRole(RoleDto roleDto){
    	return roleService.updateRole(roleDto);
	}

    /*显示角色表详情*/
	@RequestMapping("/viewRole")
	@ResponseBody
	@NoAuth
	public ResultDo<RoleDto> viewRole(String id){
		logger.info("roleId:"+id);
		return roleService.findRoleById(id);
	}

	/*查询角色表*/
	@RequestMapping("/findRole")
	@ResponseBody
	@NoAuth
	public ResultDo<Map<String, Object>> findRole(PageDto<RoleDto> pageDto, RoleDto roleDto){
		return roleService.findRole(pageDto, roleDto);
	}
}
