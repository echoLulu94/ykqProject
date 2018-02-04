package com.cxs.extension.ath.service.api;

import java.util.List;

import com.cxs.extension.ath.dto.MenuDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 菜单业务处理接口定义
 * @ClassName: MenuService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日 
 *
 */
public interface MenuService {
	
    /**
     * 保存菜单
     * @param menuDto 需保存菜单数据对象
     * @return
     */
    ResultDo<MenuDto> saveMenu(MenuDto menuDto);
    
    /**
     * 根据id删除菜单
     * @param id id
     * @return
     */
    ResultDo<String> deleteMenuById(String id);
	
    /**
     * 根据id数组批量删除菜单
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteMenuByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除菜单
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteMenuByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新菜单信息
	 * @param menuDto 需更新菜单数据对象
	 * @return
	 */
    ResultDo<MenuDto> updateMenu(MenuDto menuDto);
    
    /**
     * 根据id查找菜单
     * @param id id
     * @return
     */
    ResultDo<MenuDto> findMenuById(String id);
    
    /**
     * 分页查询菜单信息
     * @param pageDto 分页对象
     * @return
     */
	ResultDo<PageDto<MenuDto>> findMenu(PageDto<MenuDto> pageDto);
	
	/**
	 * 根据查询条件分页查询菜单对象
	 * @param pageDto 分页对象
	 * @param menuDto 查询条件
	 * @return
	 */
	ResultDo<PageDto<MenuDto>> findMenu(PageDto<MenuDto> pageDto, MenuDto menuDto);
}