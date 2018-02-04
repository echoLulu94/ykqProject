package com.cxs.extension.ath.service.api;

import java.util.List;
import java.util.Map;

import com.cxs.extension.ath.dto.ModuleDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 模块业务处理接口定义
 * @ClassName: ModuleService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface ModuleService {
	
    /**
     * 保存模块
     * @param moduleDto 需保存模块数据对象
     * @return
     */
    ResultDo<ModuleDto> saveModule(ModuleDto moduleDto);
    
    /**
     * 根据id删除模块
     * @param id id
     * @return
     */
    ResultDo<String> deleteModuleById(String id);
	
    /**
     * 根据id数组批量删除模块
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteModuleByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除模块
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteModuleByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新模块信息
	 * @param moduledto 需更新模块数据对象
	 * @return
	 */
    ResultDo<ModuleDto> updateModule(ModuleDto moduledto);
    
    /**
     * 根据id查找模块
     * @param id id
     * @return
     */
    ResultDo<ModuleDto> findModuleById(String id);
    
    /**
     * 分页查询模块信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<ModuleDto>> findModule(PageDto<ModuleDto> pageDto);
	
	/**
	 * 根据查询条件分页查询模块对象
	 * @param page 分页对象
	 * @param moduledto 查询条件
	 * @return
	 */
	ResultDo<PageDto<ModuleDto>> findModule(PageDto<ModuleDto> pageDto, ModuleDto moduledto);
	
	/**
	 * 根据子系统编号查找模块列表
	 * @param subSysCode 子系统编号
	 * @return
	 */
	ResultDo<List<ModuleDto>> findBySubSysCode(String subSysCode);
	
	/**
	 * 根据子系统编码和模块编码查询模块是否存在
	 * @param subSysCode 子系统编码
	 * @param modCode 模块编码
	 * @return
	 */
	Boolean isExistByCodes(String subSysCode, String modCode);
	
	/**
	 * 获取树形模块列表
	 * @return
	 */
	ResultDo<List<Map<String,Object>>> getModTree();
	
}