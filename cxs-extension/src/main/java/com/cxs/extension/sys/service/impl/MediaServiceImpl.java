package com.cxs.extension.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cxs.extension.core.config.SysConfig;
import com.cxs.extension.core.utils.RedisUtil;
import com.cxs.extension.core.utils.UploadUtil;
import com.cxs.extension.sys.dto.MediaDto;
import com.cxs.extension.sys.entity.Media;
import com.cxs.extension.sys.mapper.MediaMapper;
import com.cxs.extension.sys.result.MediaResult;
import com.cxs.extension.sys.service.api.MediaService;
import com.cxs.extension.sys.utils.MediaParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
/**
 * 
 * @Description: 媒资业务处理实现类
 * @ClassName: MediaServiceImpl
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
@Service
public class MediaServiceImpl implements MediaService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MediaMapper mediaMapper;
	@Autowired
	private SysConfig sysConfig;

	@Override
	public ResultDo<MediaDto> saveMedia(MediaDto mediaDto) {
		ResultDo<MediaDto> resultDo = new ResultDo<MediaDto>();
		Media media = new Media();
		try {
			if (null != mediaDto) {	
				//mediaDto的id为空，设为随机数，不为空就用参数的
				if(StringUtil.isEmpty(mediaDto.getId())) {
					mediaDto.setId(IdUtil.getUuid());					
				}else {
					mediaDto.setId(mediaDto.getId());
				}
				MediaParseUtil.parseToEntity(mediaDto, media);
				mediaMapper.insert(media);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());		
			} else {
				resultDo.setResultDo(MediaResult.SAVE_FAILURE);
				logger.error(MediaResult.SAVE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.SAVE_FAILURE);
			logger.error(MediaResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(mediaDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteMediaById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try {
			if (null != id && !"".equals(id)) {
				int i = mediaMapper.deleteByPrimaryKey(id);
				if (i == 0) {
					resultDo.setResultDo(MediaResult.DELETE_MEDIA_NOT_EXIST);
					logger.info(MediaResult.DELETE_MEDIA_NOT_EXIST.getValue());
				} else {
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(MediaResult.DELETE_ID_NOT_NULL);
				logger.error(MediaResult.DELETE_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.DELETE_FAILURE);
			logger.error(MediaResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteMediaByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try {
			if (null != ids && ids.length > 0) {
				for (String shortIds : IdUtil.getIdsList(ids)) {
					mediaMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(MediaResult.DELETE_IDS_NOT_NULL);
				logger.error(MediaResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.DELETE_BY_IDS_FAILURE);
			logger.error(MediaResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteMediaByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try {
			if (null != idList && !idList.isEmpty()) {
				for (String shortIds : IdUtil.getIdsList(idList)) {
					mediaMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(MediaResult.DELETE_IDS_NOT_NULL);
				logger.error(MediaResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			logger.error(MediaResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}

	@Override
	public ResultDo<MediaDto> updateMedia(MediaDto mediaDto) {
		ResultDo<MediaDto> resultDo = new ResultDo<MediaDto>();
		Media media = new Media();
		try {
			MediaParseUtil.parseToEntity(mediaDto, media);
			mediaMapper.updateByPrimaryKeySelective(media);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.UPDATE_FAILURE);
			logger.error(MediaResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(mediaDto);
		return resultDo;
	}

	@Override
	public ResultDo<MediaDto> findMediaById(String id) {
		MediaDto mediaDto = new MediaDto();
		ResultDo<MediaDto> resultDo = new ResultDo<MediaDto>();
		try {
			if (null != id && !"".equals(id)) {
				Media media = mediaMapper.selectByPrimaryKey(id);
				MediaParseUtil.parseToDto(media, mediaDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			} else {
				resultDo.setResultDo(MediaResult.FIND_BY_ID_NOT_NULL);
				logger.error(MediaResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.FIND_FAILURE);
			logger.error(MediaResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(mediaDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<MediaDto>> findMedia(PageDto<MediaDto> pageDto) {
		logger.debug("debug test");
		List<MediaDto> mediaDtoList = new ArrayList<MediaDto>();
		List<Media> mediaList = null;
		ResultDo<PageDto<MediaDto>> resultDo = new ResultDo<PageDto<MediaDto>>();
		try {
			pageDto.setTotalRecord(mediaMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			mediaList = mediaMapper.selectAll();
			MediaParseUtil.parseToDtoList(mediaList, mediaDtoList);
			pageDto.setPageData(mediaDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.FIND_FAILURE);
			logger.error(MediaResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<MediaDto>> findMedia(PageDto<MediaDto> pageDto, MediaDto mediaDto) {
		List<MediaDto> mediaDtoList = new ArrayList<MediaDto>();
		ResultDo<PageDto<MediaDto>> resultDo = new ResultDo<PageDto<MediaDto>>();
		List<Media> mediaList = null;
		try {
			Media example = new Media();
			// TODO 设置查询条件
			pageDto.setTotalRecord(mediaMapper.selectCount(example));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			mediaList = mediaMapper.select(example);
			MediaParseUtil.parseToDtoList(mediaList, mediaDtoList);
			pageDto.setPageData(mediaDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.FIND_FAILURE);
			logger.error(MediaResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	/**
	 * 上传图片
	 */
	@Override
	public ResultDo<Map<String,Object>> upload(MultipartFile file, String fileType) {

		Map<String,Object> map=new HashMap<String,Object>();
		ResultDo<Map<String,Object>> resultDo = new ResultDo<Map<String,Object>>();
		try {
			if (null != file) {
				String originalFilename = file.getOriginalFilename();
				logger.info("上传的文件名为：" + originalFilename);
				String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
				if(StringUtil.isNotEmpty(suffixName) && fileType.equals("10")){
				  suffixName=".png";
			    }
				logger.info("上传的后缀名为：" + suffixName);
				String fileName = IdUtil.getUuid() + suffixName;
				if (UploadUtil.upload(file, sysConfig.getStaticBasePath() + fileType + "/", fileName)) {
					Media media = new Media();
					String id =IdUtil.getUuid();
					media.setId(id);
					media.setFileType(fileType);
					media.setFileName(fileName);
					media.setCreateTime(System.currentTimeMillis());
					mediaMapper.insert(media);
					map.put("id", id);
					map.put("url", sysConfig.getStaticBaseUrl() + fileType + "/" + fileName);
					resultDo.setResultData(map);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				} else {
					resultDo.setResultDo(MediaResult.UPLOAD_SAVE_FILE_FAILURE);
					logger.error(MediaResult.UPLOAD_SAVE_FILE_FAILURE.getValue());
				}
			} else {
				resultDo.setResultDo(MediaResult.UPLOAD_FAILURE);
				logger.error(MediaResult.UPLOAD_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.UPLOAD_FAILURE);
			logger.error(MediaResult.UPLOAD_FAILURE.getValue(), e);
		}

		return resultDo;
	}
	/**
	 * 上传pdf
	 */
	public ResultDo<Map<String,Object>> uploadJul(MultipartFile file, String fileType, String filePath) {
		Map<String,Object> map=new HashMap<String,Object>();
		ResultDo<Map<String,Object>> resultDo = new ResultDo<Map<String,Object>>();
		try {
			if (null != file) {
				String originalFilename = file.getOriginalFilename();
				logger.info("上传的文件名为：" + originalFilename);
				String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
				logger.info("上传的后缀名为：" + suffixName);
				String fileName = IdUtil.getUuid() + suffixName;
				String julPath = sysConfig.getStaticBasePath() + RedisUtil.getInstance().getStr("STATIC_RES_PATH-JUL")+ filePath;
				if (UploadUtil.upload(file, julPath, fileName)) {
					Media media = new Media();
					String id =IdUtil.getUuid();
					media.setId(id);
					media.setFileType(fileType);
					media.setFileName(fileName);
					media.setCreateTime(System.currentTimeMillis());
					mediaMapper.insert(media);
					map.put("id", id);
					map.put("url", julPath +fileName);
					map.put("state", RedisUtil.getInstance().getStr("JOURNAL_STATE-AUDIT_WAIT"));
					resultDo.setResultData(map);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				} else {
					resultDo.setResultDo(MediaResult.UPLOAD_SAVE_FILE_FAILURE);
					logger.error(MediaResult.UPLOAD_SAVE_FILE_FAILURE.getValue());
				}
			} else {
				resultDo.setResultDo(MediaResult.UPLOAD_FAILURE);
				logger.error(MediaResult.UPLOAD_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(MediaResult.UPLOAD_FAILURE);
			logger.error(MediaResult.UPLOAD_FAILURE.getValue(), e);
		}

		return resultDo;
	}

	/**
	 * 上传图片
	 * 响应报文
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
	 */
	@Override
	public Map<String,Object> wueUpload(MultipartFile [] files, String fileType) {

		Map<String,Object> map=new HashMap<String,Object>();
//		默认上传图片失败
		map.put("errno",-1);
		List<String> picList = new ArrayList<String>();
		try {
			if (null != files) {
				for(MultipartFile file : files){
					String originalFilename = file.getOriginalFilename();
					logger.info("上传的文件名为：" + originalFilename);
					String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
					if(StringUtil.isEmpty(suffixName)){
						suffixName=".png";
					}
					logger.info("上传的后缀名为：" + suffixName);
					String fileName = IdUtil.getUuid() + suffixName;
					if (UploadUtil.upload(file, sysConfig.getStaticBasePath() + fileType + "/", fileName)) {
						Media media = new Media();
						String id =IdUtil.getUuid();
						media.setId(id);
						media.setFileType(fileType);
						media.setFileName(fileName);
						media.setCreateTime(System.currentTimeMillis());
						mediaMapper.insert(media);
						picList.add(sysConfig.getStaticBaseUrl() + fileType + "/" + fileName);
						logger.info(InterfaceResult.SUCCESS.getValue());
					} else {
						logger.error(MediaResult.UPLOAD_SAVE_FILE_FAILURE.getValue());
						return map;
					}
				}
//					设置为上传图片成功
				map.put("errno",0);
				map.put("data",picList);
			} else {
				logger.error(MediaResult.UPLOAD_FAILURE.getValue());
			}
		} catch (Exception e) {
			logger.error(MediaResult.UPLOAD_FAILURE.getValue(), e);
		}
		return map;
	}

	@Override
	public String findUrlById(String id) {
		String url = "";
		//一般上传图片，未设置标记，所以 pathFlag = "0" 未使用
		//String typeFlag = RedisUtil.getInstance().getStr("PATH_FLAG-TYPE_NAME");
		String srpFlag = RedisUtil.getInstance().getStr("PATH_FLAG-SRP_NAME");
		if (StringUtil.isNotEmpty(id)) {
			Media media = mediaMapper.selectByPrimaryKey(id);
			if (null != media && StringUtil.isNotEmpty(sysConfig.getStaticBaseUrl())
					&& StringUtil.isNotEmpty(media.getFileType()) && StringUtil.isNotEmpty(media.getFileName())) {
				if (StringUtil.isNotEmpty(media.getPathFlag())) {
					if(media.getPathFlag().equals(srpFlag)) {
						url = media.getStaticRelativePath() + media.getFileName();
						logger.info("StaticFullUrl:[" + url + "]");	
					}			
				} else {	
					url = media.getFileType() + "/" + media.getFileName();
					logger.info("StaticFullUrl:[" + url + "]");
				}
			} else {
				logger.error("获取媒资失败，媒资id：《" + id + "》");
			}
		}
		return url;
	}
	/* 根据idlist查询URL */
	@Override
	public ResultDo<List<Map<String, String>>> fineMediaByIdList(List<String> idList) throws Exception {
		ResultDo<List<Map<String, String>>> resultDo = new ResultDo<List<Map<String, String>>>();
		List<Map<String, String>> mediaList = new ArrayList<>();
		try {
			if (null != idList && !idList.isEmpty()) {
				for (String ids : IdUtil.getIdsList(idList)) {
					mediaList.addAll(mediaMapper.selectByIdList(ids));
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(MediaResult.FIND_FAILURE);
				logger.error(MediaResult.FIND_FAILURE.getValue());
			}
		} catch (Exception e) {
			logger.error(MediaResult.FIND_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(mediaList);
		return resultDo;
	}

	@Override
	public Map<String, Object> vueUpload(MultipartFile file, String fileType) {

		Map<String,Object> map=new HashMap<String,Object>();
		map.put("ok",false);
		map.put("msg","图片上传失败!");
		try {
			if (null != file) {
				String originalFilename = file.getOriginalFilename();
				logger.info("上传的文件名为：" + originalFilename);
				String suffixName ="";
				if("".indexOf(originalFilename)>-1){
					suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
				}else{
					suffixName=".png";
				}
				logger.info("上传的后缀名为：" + suffixName);
				String fileName = IdUtil.getUuid() + suffixName;
				if (UploadUtil.upload(file, sysConfig.getStaticBasePath() + fileType + "/", fileName)) {
					Media media = new Media();
					String id =IdUtil.getUuid();
					media.setId(id);
					media.setFileType(fileType);
					media.setFileName(fileName);
					media.setCreateTime(System.currentTimeMillis());
					mediaMapper.insert(media);
					map.put("ok", true);
					map.put("msg", "图片上传成功");
					map.put("data", sysConfig.getStaticBaseUrl() + fileType + "/" + fileName);
					logger.info("vue富文本编辑器上传图片,"+InterfaceResult.SUCCESS.getValue());
				} else {
					logger.error("vue富文本编辑器上传图片,"+MediaResult.UPLOAD_SAVE_FILE_FAILURE.getValue());
				}
			} else {
				logger.error("vue富文本编辑器上传图片,"+MediaResult.UPLOAD_FAILURE.getValue());
			}
		} catch (Exception e) {
			logger.error(MediaResult.UPLOAD_FAILURE.getValue(), e);
		}
		return map;
	}
}