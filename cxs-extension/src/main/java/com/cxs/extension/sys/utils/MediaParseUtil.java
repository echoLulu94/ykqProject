package com.cxs.extension.sys.utils;

import java.util.List;

import com.cxs.extension.sys.dto.MediaDto;
import com.cxs.extension.sys.entity.Media;
/**
* 
* @Description: 媒资DTO和媒资互转工具类
* @ClassName: MediaParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class MediaParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param media 源媒资entity
	 * @param mediaDto 目标媒资dto
	 */
	public static void parseToDto(Media media, MediaDto mediaDto){
		parseToDto(media, mediaDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param media 源媒资entity
	 * @param mediaDto 目标媒资dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Media media, MediaDto mediaDto, Boolean flag){
		if(flag){
			mediaDto.setId(media.getId());
			mediaDto.setFileType(media.getFileType());
			mediaDto.setPathFlag(media.getPathFlag());
			mediaDto.setUploader(media.getUploader());
			mediaDto.setUploaderType(media.getUploaderType());
			mediaDto.setFileMd5(media.getFileMd5());
			mediaDto.setOriginalFilename(media.getOriginalFilename());
			mediaDto.setStaticRelativePath(media.getStaticRelativePath());
			mediaDto.setFileName(media.getFileName());
			mediaDto.setCreateTime(media.getCreateTime());
		}else{
			if(null!=media.getId()){
				mediaDto.setId(media.getId());
			}
			if(null!=media.getFileType()){
				mediaDto.setFileType(media.getFileType());
			}
			if(null!=media.getPathFlag()){
				mediaDto.setPathFlag(media.getPathFlag());
			}
			if(null!=media.getUploader()){
				mediaDto.setUploader(media.getUploader());
			}
			if(null!=media.getUploaderType()){
				mediaDto.setUploaderType(media.getUploaderType());
			}
			if(null!=media.getFileMd5()){
				mediaDto.setFileMd5(media.getFileMd5());
			}
			if(null!=media.getOriginalFilename()){
				mediaDto.setOriginalFilename(media.getOriginalFilename());
			}
			if(null!=media.getStaticRelativePath()){
				mediaDto.setStaticRelativePath(media.getStaticRelativePath());
			}
			if(null!=media.getFileName()){
				mediaDto.setFileName(media.getFileName());
			}
			if(null!=media.getCreateTime()){
				mediaDto.setCreateTime(media.getCreateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param mediaDto 源媒资dto
	 * @param media 目标媒资entity
	 */
	public static void parseToEntity(MediaDto mediaDto, Media media){
		parseToEntity(mediaDto, media, false);
	}
	
	/**
	 * dto转entity
	 * @param mediaDto 源媒资dto
	 * @param media 目标媒资entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(MediaDto mediaDto, Media media, Boolean flag){
		if(flag){
			media.setId(mediaDto.getId());
			media.setFileType(mediaDto.getFileType());
			media.setPathFlag(mediaDto.getPathFlag());
			media.setUploader(mediaDto.getUploader());
			media.setUploaderType(mediaDto.getUploaderType());
			media.setFileMd5(mediaDto.getFileMd5());
			media.setOriginalFilename(mediaDto.getOriginalFilename());
			media.setStaticRelativePath(mediaDto.getStaticRelativePath());
			media.setFileName(mediaDto.getFileName());
			media.setCreateTime(mediaDto.getCreateTime());
		}else{
			if(null!=mediaDto.getId()){
				media.setId(mediaDto.getId());
			}
			if(null!=mediaDto.getFileType()){
				media.setFileType(mediaDto.getFileType());
			}
			if(null!=mediaDto.getPathFlag()){
				media.setPathFlag(mediaDto.getPathFlag());
			}
			if(null!=mediaDto.getUploader()){
				media.setUploader(mediaDto.getUploader());
			}
			if(null!=mediaDto.getUploaderType()){
				media.setUploaderType(mediaDto.getUploaderType());
			}
			if(null!=mediaDto.getFileMd5()){
				media.setFileMd5(mediaDto.getFileMd5());
			}
			if(null!=mediaDto.getOriginalFilename()){
				media.setOriginalFilename(mediaDto.getOriginalFilename());
			}
			if(null!=mediaDto.getStaticRelativePath()){
				media.setStaticRelativePath(mediaDto.getStaticRelativePath());
			}
			if(null!=mediaDto.getFileName()){
				media.setFileName(mediaDto.getFileName());
			}
			if(null!=mediaDto.getCreateTime()){
				media.setCreateTime(mediaDto.getCreateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param mediaList 源媒资entity列表
	 * @param mediaDtoList 目标媒资dto列表
	 */
	public static void parseToDtoList(List<Media> mediaList, List<MediaDto> mediaDtoList ){
		parseToDtoList(mediaList, mediaDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param mediaList 源媒资entity列表
	 * @param mediaDtoList 目标媒资dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Media> mediaList, List<MediaDto> mediaDtoList, Boolean flag){
		if(null!=mediaList&&!mediaList.isEmpty()){
			for (Media media:mediaList) {
				MediaDto mediaDto = new MediaDto();
				parseToDto(media, mediaDto, flag);
				mediaDtoList.add(mediaDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param mediaDtoList 源媒资dto列表
	 * @param mediaList 目标媒资entity列表
	 */
	public static void parseToEntityList(List<MediaDto> mediaDtoList, List<Media> mediaList){
		parseToEntityList(mediaDtoList, mediaList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param mediaDtoList 源媒资dto列表
	 * @param mediaList 目标媒资entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<MediaDto> mediaDtoList, List<Media> mediaList, Boolean flag){
		if(null!=mediaDtoList&&!mediaDtoList.isEmpty()){
			for (MediaDto mediaDto:mediaDtoList) {
				Media media = new Media();
				parseToEntity(mediaDto,media,flag);
				mediaList.add(media);
			}
		}
	}
}
