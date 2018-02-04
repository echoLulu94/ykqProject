package com.cxs.extension.ath.service.api;

import java.util.List;
import java.util.Map;

import com.cxs.extension.ath.dto.RoleDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 角色表业务处理接口定义
 * @ClassName: RoleService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日 
 *
 */
public interface RoleService {
	
    /**
     * 保存角色表
     * @param roleDto 需保存角色表数据对象
     * @return
     */
    ResultDo<RoleDto> saveRole(RoleDto roleDto);
    
    /**
     * 根据id删除角色表
     * @param id id
     * @return
     */
    ResultDo<String> deleteRoleById(String id);
	
    /**
     * 根据id数组批量删除角色表
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteRoleByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除角色表
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteRoleByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新角色表信息
	 * @param roleDto 需更新角色表数据对象
	 * @return
	 */
    ResultDo<RoleDto> updateRole(RoleDto roleDto);
    
    /**
     * 根据id查找角色表
     * @param id id
     * @return
     */
    ResultDo<RoleDto> findRoleById(String id);
    
    /**
     * 分页查询角色表信息
     * @param pageDto 分页对象
     * @return
     */
	ResultDo<PageDto<RoleDto>> findRole(PageDto<RoleDto> pageDto);
	
	/**
	 * 根据查询条件分页查询角色表对象
	 * @param pageDto 分页对象
	 * @param roleDto 查询条件
	 * @return
	 */
	ResultDo<Map<String, Object>> findRole(PageDto<RoleDto> pageDto, RoleDto roleDto);
}