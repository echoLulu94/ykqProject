package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.MenuDto;
import com.cxs.extension.ath.entity.Menu;
/**
* 
* @Description: 菜单DTO和菜单互转工具类
* @ClassName: MenuParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
* @date: 2017年09月19日
*/
public class MenuParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param menu 源菜单entity
	 * @param menuDto 目标菜单dto
	 */
	public static void parseToDto(Menu menu, MenuDto menuDto){
		parseToDto(menu, menuDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param menu 源菜单entity
	 * @param menuDto 目标菜单dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Menu menu, MenuDto menuDto, Boolean flag){
		if(flag){
			menuDto.setId(menu.getId());
			menuDto.setMenuCode(menu.getMenuCode());
			menuDto.setRescCode(menu.getRescCode());
			menuDto.setParentMenuCode(menu.getParentMenuCode());
			menuDto.setCreateTime(menu.getCreateTime());
			menuDto.setCreateBy(menu.getCreateBy());
			menuDto.setUpdateTime(menu.getUpdateTime());
			menuDto.setUpdateBy(menu.getUpdateBy());
		}else{
			if(null!=menu.getId()){
				menuDto.setId(menu.getId());
			}
			if(null!=menu.getMenuCode()){
				menuDto.setMenuCode(menu.getMenuCode());
			}
			if(null!=menu.getRescCode()){
				menuDto.setRescCode(menu.getRescCode());
			}
			if(null!=menu.getParentMenuCode()){
				menuDto.setParentMenuCode(menu.getParentMenuCode());
			}
			if(null!=menu.getCreateTime()){
				menuDto.setCreateTime(menu.getCreateTime());
			}
			if(null!=menu.getCreateBy()){
				menuDto.setCreateBy(menu.getCreateBy());
			}
			if(null!=menu.getUpdateTime()){
				menuDto.setUpdateTime(menu.getUpdateTime());
			}
			if(null!=menu.getUpdateBy()){
				menuDto.setUpdateBy(menu.getUpdateBy());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param menuDto 源菜单dto
	 * @param menu 目标菜单entity
	 */
	public static void parseToEntity(MenuDto menuDto, Menu menu){
		parseToEntity(menuDto, menu, false);
	}
	
	/**
	 * dto转entity
	 * @param menuDto 源菜单dto
	 * @param menu 目标菜单entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(MenuDto menuDto, Menu menu, Boolean flag){
		if(flag){
			menu.setId(menuDto.getId());
			menu.setMenuCode(menuDto.getMenuCode());
			menu.setRescCode(menuDto.getRescCode());
			menu.setParentMenuCode(menuDto.getParentMenuCode());
			menu.setCreateTime(menuDto.getCreateTime());
			menu.setCreateBy(menuDto.getCreateBy());
			menu.setUpdateTime(menuDto.getUpdateTime());
			menu.setUpdateBy(menuDto.getUpdateBy());
		}else{
			if(null!=menuDto.getId()){
				menu.setId(menuDto.getId());
			}
			if(null!=menuDto.getMenuCode()){
				menu.setMenuCode(menuDto.getMenuCode());
			}
			if(null!=menuDto.getRescCode()){
				menu.setRescCode(menuDto.getRescCode());
			}
			if(null!=menuDto.getParentMenuCode()){
				menu.setParentMenuCode(menuDto.getParentMenuCode());
			}
			if(null!=menuDto.getCreateTime()){
				menu.setCreateTime(menuDto.getCreateTime());
			}
			if(null!=menuDto.getCreateBy()){
				menu.setCreateBy(menuDto.getCreateBy());
			}
			if(null!=menuDto.getUpdateTime()){
				menu.setUpdateTime(menuDto.getUpdateTime());
			}
			if(null!=menuDto.getUpdateBy()){
				menu.setUpdateBy(menuDto.getUpdateBy());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param menuList 源菜单entity列表
	 * @param menuDtoList 目标菜单dto列表
	 */
	public static void parseToDtoList(List<Menu> menuList, List<MenuDto> menuDtoList ){
		parseToDtoList(menuList, menuDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param menuList 源菜单entity列表
	 * @param menuDtoList 目标菜单dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Menu> menuList, List<MenuDto> menuDtoList, Boolean flag){
		if(null!=menuList&&!menuList.isEmpty()){
			for (Menu menu:menuList) {
				MenuDto menuDto = new MenuDto();
				parseToDto(menu, menuDto, flag);
				menuDtoList.add(menuDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param menuDtoList 源菜单dto列表
	 * @param menuList 目标菜单entity列表
	 */
	public static void parseToEntityList(List<MenuDto> menuDtoList, List<Menu> menuList){
		parseToEntityList(menuDtoList, menuList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param menuDtoList 源菜单dto列表
	 * @param menuList 目标菜单entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<MenuDto> menuDtoList, List<Menu> menuList, Boolean flag){
		if(null!=menuDtoList&&!menuDtoList.isEmpty()){
			for (MenuDto menuDto:menuDtoList) {
				Menu menu = new Menu();
				parseToEntity(menuDto,menu,flag);
				menuList.add(menu);
			}
		}
	}
}
