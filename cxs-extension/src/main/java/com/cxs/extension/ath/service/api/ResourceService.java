package com.cxs.extension.ath.service.api;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cxs.extension.ath.dto.ResourceDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 资源业务处理接口定义
 * @ClassName: ResourceService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface ResourceService {
	
    /**
     * 保存资源
     * @param resourceDto 需保存资源数据对象
     * @return
     */
    ResultDo<ResourceDto> saveResource(ResourceDto resourceDto);
    
    /**
     * 根据id删除资源
     * @param id id
     * @return
     */
    ResultDo<String> deleteResourceById(String id);
	
    /**
     * 根据id数组批量删除资源
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteResourceByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除资源
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteResourceByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新资源信息
	 * @param resourcedto 需更新资源数据对象
	 * @return
	 */
    ResultDo<ResourceDto> updateResource(ResourceDto resourcedto);
    
    /**
     * 根据id查找资源
     * @param id id
     * @return
     */
    ResultDo<ResourceDto> findResourceById(String id);
    
    /**
     * 根据资源编号查找资源
     * @param rescCode 资源编号
     * @return
     */
    ResultDo<ResourceDto> findByRescCode(String rescCode);
    
    /**
     * 分页查询资源信息
     * @param pageDto 分页对象
     * @return
     */
	ResultDo<PageDto<ResourceDto>> findResource(PageDto<ResourceDto> pageDto);
	
	/**
	 * 根据查询条件分页查询资源对象
	 * @param pageDto 分页对象
	 * @param resourcedto 查询条件
	 * @return
	 */
	ResultDo<PageDto<ResourceDto>> findResource(PageDto<ResourceDto> pageDto, ResourceDto resourcedto);
	
	/**
	 * 导入资源
	 * @param file 导入资源文件
	 * @return
	 * @throws IOException 
	 */
	ResultDo<Boolean> importResource(MultipartFile file) throws IOException;

	/**
	 * 导出资源
	 * @return
	 * @throws IOException
	 */
	ResultDo<String> exportResource() throws IOException;
}