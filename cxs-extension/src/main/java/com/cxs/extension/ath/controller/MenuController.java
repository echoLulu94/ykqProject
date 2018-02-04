package com.cxs.extension.ath.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.extension.ath.dto.MenuDto;
import com.cxs.extension.ath.result.MenuResult;
import com.cxs.extension.ath.service.api.MenuService;

/**
 *
 * @Description: 菜单控制器
 * @ClassName: MenuController
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年09月19日
 */
@Controller
@RequestMapping("/ath")
public class MenuController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MenuService menuService;

    /*保存菜单*/
    @RequestMapping(value = "/saveMenu")
	@ResponseBody
    public ResultDo<MenuDto> saveMenu(MenuDto menuDto){
    	return menuService.saveMenu(menuDto);
	}

    /*删除菜单*/
    @RequestMapping(value = "/deleteMenu")
	@ResponseBody
    public ResultDo<String> deleteMenuById(String id){
    	return menuService.deleteMenuById(id);
	}

	/*删除菜单*/
    @RequestMapping(value = "/deleteAllMenu")
	@ResponseBody
    public ResultDo<String []> deleteAllMenu(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = menuService.deleteMenuByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(MenuResult.DELETE_BY_IDS_FAILURE);
			logger.error(MenuResult.DELETE_BY_IDS_FAILURE.getValue(),e);
		}
		return resultDo;
	}

    /*更新菜单*/
    @RequestMapping(value = "/updateMenu")
	@ResponseBody
    public ResultDo<MenuDto> updateMenu(MenuDto menuDto){
    	return menuService.updateMenu(menuDto);
	}

    /*显示菜单详情*/
	@RequestMapping("/viewMenu")
	@ResponseBody
	public ResultDo<MenuDto> viewMenu(String id){
		logger.info("menuId:"+id);
		return menuService.findMenuById(id);
	}

	/*查询菜单*/
	@RequestMapping("/findMenu")
	@ResponseBody
	public ResultDo<PageDto<MenuDto>> findMenu(PageDto<MenuDto> pageDto, MenuDto menuDto){
		return menuService.findMenu(pageDto, menuDto);
	}
}
