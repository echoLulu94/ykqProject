package com.cxs.extension.ath.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.ath.dto.MenuDto;
import com.cxs.extension.ath.entity.Menu;
import com.cxs.extension.ath.result.MenuResult;
import com.cxs.extension.ath.mapper.MenuMapper;
import com.cxs.extension.ath.service.api.MenuService;
import com.cxs.extension.ath.utils.MenuParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.utils.IdUtil;
import com.cxs.framework.utils.StringUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 菜单业务处理实现类
 * @ClassName: MenuServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年09月19日 
 *
 */
@Service
public class MenuServiceImpl implements MenuService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public ResultDo<MenuDto> saveMenu(MenuDto menuDto) {
		ResultDo<MenuDto> resultDo = new ResultDo<MenuDto>();
		Menu menu =new Menu();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=menuDto){
				menuDto.setId(IdUtil.getUuid());
				menuDto.setCreateTime(time);
				menuDto.setUpdateTime(time);
				MenuParseUtil.parseToEntity(menuDto,menu);
				menuMapper.insert(menu);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(MenuResult.SAVE_FAILURE);
				logger.error(MenuResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.SAVE_FAILURE);
			logger.error(MenuResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(menuDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteMenuById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = menuMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(MenuResult.DELETE_MENU_NOT_EXIST);
					logger.error(MenuResult.DELETE_MENU_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(MenuResult.DELETE_ID_NOT_NULL);
				logger.error(MenuResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.DELETE_FAILURE);
			logger.error(MenuResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteMenuByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			menuMapper.deleteByIds(shortIds);
	    		}
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(MenuResult.DELETE_IDS_NOT_NULL);
				logger.error(MenuResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.DELETE_BY_IDS_FAILURE);
			logger.error(MenuResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteMenuByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			menuMapper.deleteByIds(shortIds);
	    		}
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(MenuResult.DELETE_IDS_NOT_NULL);
				logger.error(MenuResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.DELETE_BY_IDS_FAILURE);
			logger.error(MenuResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<MenuDto> updateMenu(MenuDto menuDto) {
		ResultDo<MenuDto> resultDo = new ResultDo<MenuDto>();
		Menu menu = new Menu();
		/*当前时间*/
		long time = System.currentTimeMillis();
		try{
			menuDto.setUpdateTime(time);
			MenuParseUtil.parseToEntity(menuDto,menu);
			menuMapper.updateByPrimaryKeySelective(menu);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.UPDATE_FAILURE);
			logger.error(MenuResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(menuDto);
		return resultDo;
	}

	@Override
	public ResultDo<MenuDto> findMenuById(String id) {
		MenuDto menuDto = new MenuDto();
		ResultDo<MenuDto> resultDo = new ResultDo<MenuDto>();
		try{
			if(null!=id&&!"".equals(id)){
				Menu menu = menuMapper.selectByPrimaryKey(id);
				MenuParseUtil.parseToDto(menu,menuDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(MenuResult.FIND_BY_ID_NOT_NULL);
				logger.error(MenuResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.FIND_FAILURE);
			logger.error(MenuResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(menuDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<MenuDto>> findMenu(PageDto<MenuDto> pageDto) {
		List<MenuDto> menuDtoList = new ArrayList<MenuDto>();
		List<Menu> menuList = null;
		ResultDo<PageDto<MenuDto>> resultDo=new ResultDo<PageDto<MenuDto>>();
		try{
			pageDto.setTotalRecord(menuMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			menuList = menuMapper.selectAll();
			MenuParseUtil.parseToDtoList(menuList,menuDtoList);
			pageDto.setPageData(menuDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.FIND_FAILURE);
			logger.error(MenuResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<MenuDto>> findMenu(PageDto<MenuDto> pageDto, MenuDto menuDto) {
        List<MenuDto> menuDtoList = new ArrayList<MenuDto>();
		ResultDo<PageDto<MenuDto>> resultDo = new ResultDo<PageDto<MenuDto>>();
        List<Menu> menuList=null;
		try{
			Example example = new Example(Menu.class);
			example.createCriteria();
			if(StringUtil.isNotEmpty(menuDto.getMenuCode())) {
				example.getOredCriteria().get(0).andLike("menuCode", "%" + menuDto.getMenuCode() + "%");
			}
			if(StringUtil.isNotEmpty(menuDto.getRescCode())) {
				example.getOredCriteria().get(0).andLike("rescCode", "%" + menuDto.getRescCode() + "%");
			}
			example.setOrderByClause("create_time  DESC");
			pageDto.setTotalRecord(menuMapper.selectCountByExample(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			menuList = menuMapper.selectByExample(example);
			MenuParseUtil.parseToDtoList(menuList,menuDtoList);
			pageDto.setPageData(menuDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(MenuResult.FIND_FAILURE);
			logger.error(MenuResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}
}