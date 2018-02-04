package com.cxs.extension.sys.service.api;

import java.util.List;

import com.cxs.extension.sys.dto.ResourceSmsDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 业务处理接口定义
 * @ClassName: ResourceSmsService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月07日 
 *
 */
public interface ResourceSmsService {
	
    /**
     * 保存
     * @param resourceSmsDto 需保存数据对象
     * @return
     */
    ResultDo<ResourceSmsDto> saveResourceSms(ResourceSmsDto resourceSmsDto);
    
    /**
     * 根据id删除
     * @param id id
     * @return
     */
    ResultDo<String> deleteResourceSmsById(String id);
	
    /**
     * 根据id数组批量删除
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteResourceSmsByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteResourceSmsByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新信息
	 * @param resourceSmsdto 需更新数据对象
	 * @return
	 */
    ResultDo<ResourceSmsDto> updateResourceSms(ResourceSmsDto resourceSmsdto);
    
    /**
     * 根据id查找
     * @param id id
     * @return
     */
    ResultDo<ResourceSmsDto> findResourceSmsById(String id);
    
    /**
     * 分页查询信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<ResourceSmsDto>> findResourceSms(PageDto<ResourceSmsDto> pageDto);
	
	/**
	 * 根据查询条件分页查询对象
	 * @param page 分页对象
	 * @param resourceSmsdto 查询条件
	 * @return
	 */
	ResultDo<PageDto<ResourceSmsDto>> findResourceSms(PageDto<ResourceSmsDto> pageDto, ResourceSmsDto resourceSmsdto);
}