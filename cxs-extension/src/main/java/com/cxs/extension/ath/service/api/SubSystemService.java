package com.cxs.extension.ath.service.api;

import java.util.List;

import com.cxs.extension.ath.dto.SubSystemDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 子系统业务处理接口定义
 * @ClassName: SubSystemService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface SubSystemService {
	
    /**
     * 保存子系统
     * @param subSystemDto 需保存子系统数据对象
     * @return
     */
    ResultDo<SubSystemDto> saveSubSystem(SubSystemDto subSystemDto);
    
    /**
     * 根据id删除子系统
     * @param id id
     * @return
     */
    ResultDo<String> deleteSubSystemById(String id);
	
    /**
     * 根据id数组批量删除子系统
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteSubSystemByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除子系统
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteSubSystemByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新子系统信息
	 * @param subSystemdto 需更新子系统数据对象
	 * @return
	 */
    ResultDo<SubSystemDto> updateSubSystem(SubSystemDto subSystemdto);
    
    /**
     * 根据id查找子系统
     * @param id id
     * @return
     */
    ResultDo<SubSystemDto> findSubSystemById(String id);
    
    /**
     * 查询所有子系统信息
     * @return
     */
	ResultDo<List<SubSystemDto>> findAll();
    
    /**
     * 分页查询子系统信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<SubSystemDto>> findSubSystem(PageDto<SubSystemDto> pageDto);
	
	/**
	 * 根据查询条件分页查询子系统对象
	 * @param page 分页对象
	 * @param subSystemdto 查询条件
	 * @return
	 */
	ResultDo<PageDto<SubSystemDto>> findSubSystem(PageDto<SubSystemDto> pageDto, SubSystemDto subSystemdto);
	
	/**
     * 根据系统编码查找子系统
	 * @param subSysCode 系统编码
	 * @return
	 */
	ResultDo<SubSystemDto> findByCode(String subSysCode);
	
	/**
	 * 根据系统编码查询是否存在
	 * @param subSysCode
	 * @return
	 */
	Boolean isExistByCode(String subSysCode);
    
}