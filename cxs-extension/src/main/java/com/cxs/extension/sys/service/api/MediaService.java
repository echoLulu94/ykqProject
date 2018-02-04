package com.cxs.extension.sys.service.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cxs.extension.sys.dto.MediaDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 媒资业务处理接口定义
 * @ClassName: MediaService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface MediaService {
	
    /**
     * 保存媒资
     * @param mediaDto 需保存媒资数据对象
     * @return
     */
    ResultDo<MediaDto> saveMedia(MediaDto mediaDto);
    
    /**
     * 根据id删除媒资
     * @param id id
     * @return
     */
    ResultDo<String> deleteMediaById(String id);
	
    /**
     * 根据id数组批量删除媒资
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteMediaByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除媒资
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteMediaByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新媒资信息
	 * @param mediadto 需更新媒资数据对象
	 * @return
	 */
    ResultDo<MediaDto> updateMedia(MediaDto mediadto);
    
    /**
     * 根据id查找媒资
     * @param id id
     * @return
     */
    ResultDo<MediaDto> findMediaById(String id);
    
    /**
     * 分页查询媒资信息
     * @param pageDto 分页对象
     * @return
     */
	ResultDo<PageDto<MediaDto>> findMedia(PageDto<MediaDto> pageDto);
	
	/**
	 * 根据查询条件分页查询媒资对象
	 * @param pageDto 分页对象
	 * @param mediadto 查询条件
	 * @return
	 */
	ResultDo<PageDto<MediaDto>> findMedia(PageDto<MediaDto> pageDto, MediaDto mediadto);

	/**
	 * 上传图片
	 * @param file 上传的文件
	 * @param fileType 文件类型
	 * @return
	 */
	ResultDo<Map<String,Object>> upload(MultipartFile file, String fileType);
	/**
	 * 上传刊物PDF
	 * @param file 上传的文件
	 * @param fileType 文件类型
	 * @return
	 */
	ResultDo<Map<String,Object>> uploadJul(MultipartFile file, String fileType, String filePath);

	/**
	 * 上传图片
	 * {
	 * // errno 即错误代码，0 表示没有错误。
	 * //       如果有错误，errno != 0，可通过下文中的监听函数 fail 拿到该错误码进行自定义处理
	 * errno: 0,
	 *
	 * // data 是一个数组，返回若干图片的线上地址
	 * data: [
	 * '图片1地址',
	 * '图片2地址',
	 * '……'
	 * ]
	 * }
	 * @param files 上传的文件
	 * @param fileType 文件类型
	 * @return
	 */
	Map<String,Object> wueUpload(MultipartFile [] files, String fileType);

    /**
     * 根据媒资ID，获取媒资url
     * @param id 媒资id
     * @return
     */
	String findUrlById(String id);

	  /**
     * 根据id列表批量查询URl
     * @param idList id列表
     * @return
     */
	ResultDo<List<Map<String,String>>> fineMediaByIdList(List<String> idList) throws Exception;

	/**
	 * wue富文本编辑器上传图片,对返回值有要求
	 * 返回数据格式
	 * 		失败:{ok:false,msg:"错误描述"}
	 * 		成功:{ok:true,data:"图片地址"}
	 * @param file 上传的文件
	 * @param fileType 文件类型
	 * @return
	 */
	Map<String,Object> vueUpload(MultipartFile file, String fileType);
	
}