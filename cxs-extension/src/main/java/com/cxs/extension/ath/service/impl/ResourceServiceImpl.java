package com.cxs.extension.ath.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cxs.framework.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cxs.extension.ath.dto.ModuleDto;
import com.cxs.extension.ath.dto.ResourceDto;
import com.cxs.extension.ath.dto.SubSystemDto;
import com.cxs.extension.ath.entity.Resource;
import com.cxs.extension.ath.mapper.ResourceMapper;
import com.cxs.extension.ath.result.ResourceResult;
import com.cxs.extension.ath.service.api.ModuleService;
import com.cxs.extension.ath.service.api.ResourceService;
import com.cxs.extension.ath.service.api.SubSystemService;
import com.cxs.extension.ath.utils.ResourceParseUtil;
import com.cxs.extension.core.config.SysConfig;
import com.cxs.extension.core.utils.RedisUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.cxs.framework.utils.excel.ExcelImportUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 资源业务处理实现类
 * @ClassName: ResourceServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Autowired	
	private SubSystemService subSystemService;
	
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private SysConfig sysConfig;
	
	@Override
	public ResultDo<ResourceDto> saveResource(ResourceDto resourceDto) {
		ResultDo<ResourceDto> resultDo = new ResultDo<ResourceDto>();
		Resource resource =new Resource();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=resourceDto){
				if(null!=resourceDto.getSubSysCode()){
					if(null!=resourceDto.getModCode()){
						if(null!=resourceDto.getRescName()){
							Resource resourceTemp = resourceMapper.selectByCodes(resourceDto.getSubSysCode(), resourceDto.getModCode(), resourceDto.getRescCode());
							if(null!=resourceTemp){
								resultDo.setResultDo(ResourceResult.SAVE_EXISTS);
								logger.info(ResourceResult.SAVE_EXISTS.getValue());
							}else{
								resourceDto.setId(IdUtil.getUuid());
								resourceDto.setCreateTime(time);
								resourceDto.setUpdateTime(time);
								ResourceParseUtil.parseToEntity(resourceDto,resource);
								Integer sum =resourceMapper.selectCountByModCode(resourceDto.getModCode());
								resource.setRescCode(resource.getModCode()+sum);
								resourceMapper.insert(resource);
								resultDo.setResultDo(InterfaceResult.SUCCESS);
								logger.info(InterfaceResult.SUCCESS.getValue());
							}
						}else{
							resultDo.setResultDo(ResourceResult.SAVE_RESCNAME_NOT_NULL);
							logger.error(ResourceResult.SAVE_RESCNAME_NOT_NULL.getValue());
						}
					}else{
						resultDo.setResultDo(ResourceResult.SAVE_MODCODE_NOT_NULL);
						logger.error(ResourceResult.SAVE_MODCODE_NOT_NULL.getValue());
					}
				}else{
					resultDo.setResultDo(ResourceResult.SAVE_SUBSYSCODE_NOT_NULL);
					logger.error(ResourceResult.SAVE_SUBSYSCODE_NOT_NULL.getValue());
				}
			}else{
				resultDo.setResultDo(ResourceResult.SAVE_FAILURE);
				logger.error(ResourceResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.SAVE_FAILURE);
			logger.error(ResourceResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteResourceById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = resourceMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(ResourceResult.DELETE_RESOURCE_NOT_EXIST);
					logger.info(ResourceResult.DELETE_RESOURCE_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(ResourceResult.DELETE_ID_NOT_NULL);
				logger.error(ResourceResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.DELETE_FAILURE);
			logger.error(ResourceResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteResourceByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			resourceMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(ResourceResult.DELETE_IDS_NOT_NULL);
				logger.error(ResourceResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.DELETE_BY_IDS_FAILURE);
			logger.error(ResourceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteResourceByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			resourceMapper.deleteByIds(shortIds);
	    			resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
    			resultDo.setResultDo(ResourceResult.DELETE_IDS_NOT_NULL);
				logger.error(ResourceResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(ResourceResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<ResourceDto> updateResource(ResourceDto resourceDto) {
		ResultDo<ResourceDto> resultDo = new ResultDo<ResourceDto>();
		Resource resource = new Resource();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{

			if(null!=resourceDto){
				if(null!=resourceDto.getId()){
					if(null!=resourceDto.getSubSysCode()){
						if(null!=resourceDto.getModCode()){
							if(null!=resourceDto.getRescCode()){
								if(null!=resourceDto.getRescName()){
									Resource resourceTemp = resourceMapper.selectByCodesAndId(resourceDto.getId(), resourceDto.getSubSysCode(), resourceDto.getModCode(), resourceDto.getRescCode());
									if(null!=resourceTemp){
						    			resultDo.setResultDo(ResourceResult.UPDATE_EXISTS);
										logger.error(ResourceResult.UPDATE_EXISTS.getValue());
									}else{
										resourceDto.setUpdateTime(time);
										ResourceParseUtil.parseToEntity(resourceDto,resource);
										resourceMapper.updateByPrimaryKeySelective(resource);
						    			resultDo.setResultDo(InterfaceResult.SUCCESS);
										logger.info(InterfaceResult.SUCCESS.getValue());
									}
								}else{
					    			resultDo.setResultDo(ResourceResult.UPDATE_RESCNAME_NOT_NULL);
									logger.error(ResourceResult.UPDATE_RESCNAME_NOT_NULL.getValue());
								}
							}else{
				    			resultDo.setResultDo(ResourceResult.UPDATE_RESCCODE_NOT_NULL);
								logger.error(ResourceResult.UPDATE_RESCCODE_NOT_NULL.getValue());
							}
						}else{
			    			resultDo.setResultDo(ResourceResult.UPDATE_MODCODE_NOT_NULL);
							logger.error(ResourceResult.UPDATE_MODCODE_NOT_NULL.getValue());
						}
					}else{
		    			resultDo.setResultDo(ResourceResult.UPDATE_SUBSYSCODE_NOT_NULL);
						logger.error(ResourceResult.UPDATE_SUBSYSCODE_NOT_NULL.getValue());
					}
				}else{
	    			resultDo.setResultDo(ResourceResult.UPDATE_ID_NOT_NULL);
					logger.error(ResourceResult.UPDATE_ID_NOT_NULL.getValue());
				}
			}else{
    			resultDo.setResultDo(ResourceResult.UPDATE_FAILURE);
				logger.error(ResourceResult.UPDATE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.UPDATE_FAILURE);
			logger.error(ResourceResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceDto);
		return resultDo;
	}

	@Override
	public ResultDo<ResourceDto> findResourceById(String id) {
		ResourceDto resourceDto = new ResourceDto();
		ResultDo<ResourceDto> resultDo = new ResultDo<ResourceDto>();
		try{
			if(null!=id&&!"".equals(id)){
				Resource resource = resourceMapper.selectByPrimaryKey(id);
				ResourceParseUtil.parseToDto(resource,resourceDto);
				logger.debug("resourceDto rescUriType:"+resourceDto.getRescUriType());
    			resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
    			resultDo.setResultDo(ResourceResult.FIND_BY_ID_NOT_NULL);
				logger.error(ResourceResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.FIND_FAILURE);
			logger.error(ResourceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceDto);
		return resultDo;
    }

	@Override
	public ResultDo<ResourceDto> findByRescCode(String id) {
		ResourceDto resourceDto = new ResourceDto();
		ResultDo<ResourceDto> resultDo = new ResultDo<ResourceDto>();
		try{
			if(null!=id&&!"".equals(id)){
				Resource resource = resourceMapper.selectByPrimaryKey(id);
				ResourceParseUtil.parseToDto(resource,resourceDto);
				logger.debug("resourceDto rescUriType:"+resourceDto.getRescUriType());
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(ResourceResult.FIND_BY_ID_NOT_NULL);
				logger.error(ResourceResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.FIND_FAILURE);
			logger.error(ResourceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(resourceDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<ResourceDto>> findResource(PageDto<ResourceDto> pageDto) {
		List<ResourceDto> resourceDtoList = new ArrayList<ResourceDto>();
		List<Resource> resourceList = null;
		ResultDo<PageDto<ResourceDto>> resultDo=new ResultDo<PageDto<ResourceDto>>();
		try{
			pageDto.setTotalRecord(resourceMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			resourceList = resourceMapper.selectAll();
			ResourceParseUtil.parseToDtoList(resourceList,resourceDtoList);
			pageDto.setPageData(resourceDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.FIND_FAILURE);
			logger.error(ResourceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<ResourceDto>> findResource(PageDto<ResourceDto> pageDto, ResourceDto resourceDto) {
        List<ResourceDto> resourceDtoList = new ArrayList<ResourceDto>();
		ResultDo<PageDto<ResourceDto>> resultDo = new ResultDo<PageDto<ResourceDto>>();
        List<Resource> resourceList=null;
		try{
			Example example = new Example(Resource.class);
			example.createCriteria();
			if(StringUtil.isNotEmpty(resourceDto.getSubSysCode())){
				example.getOredCriteria().get(0).andLike("subSysCode", "%"+resourceDto.getSubSysCode()+"%");
			}
			if(StringUtil.isNotEmpty(resourceDto.getSubSysName())){
				example.getOredCriteria().get(0).andLike("subSysName", "%"+resourceDto.getSubSysName()+"%");
			}
			if(StringUtil.isNotEmpty(resourceDto.getModCode())){
				example.getOredCriteria().get(0).andLike("modCode", "%"+resourceDto.getModCode()+"%");
			}
			if(StringUtil.isNotEmpty(resourceDto.getModName())){
				example.getOredCriteria().get(0).andLike("modName", "%"+resourceDto.getModName()+"%");
			}
			if(StringUtil.isNotEmpty(resourceDto.getRescCode())){
				example.getOredCriteria().get(0).andLike("rescCode", "%"+resourceDto.getRescCode()+"%");
			}
			if(StringUtil.isNotEmpty(resourceDto.getRescName())){
				example.getOredCriteria().get(0).andLike("rescName", "%"+resourceDto.getRescName()+"%");
			}
			example.setOrderByClause("create_time  DESC");
			pageDto.setTotalRecord(resourceMapper.selectCountByExample(example));
			Resource resource = new Resource();
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			ResourceParseUtil.parseToEntity(resourceDto, resource);
			resourceList = resourceMapper.selectByExample(example);
			
			ResourceParseUtil.parseToDtoList(resourceList,resourceDtoList);
			pageDto.setPageData(resourceDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(ResourceResult.FIND_FAILURE);
			logger.error(ResourceResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<Boolean> importResource(MultipartFile file) throws IOException {
		Long now = System.currentTimeMillis();
		ResultDo<Boolean> resultDo  = new ResultDo<Boolean>();

		/**
		 * 测试代码开始
		 */
		File resourceFile = new File("/Users/apple/myproject/cxs-extension/doc/活动报名系统模块功能.xlsx");
		InputStream inputStream = new FileInputStream(resourceFile);
		/**
		 * 测试代码结束
		 */


//		InputStream inputStream = file.getInputStream();

		List<List<Object>> subSysList = ExcelImportUtil.readAllRows(inputStream,Integer.valueOf(RedisUtil.getInstance().getStr("RESC_IMP-SYS_START_SHEET")),Integer.valueOf(RedisUtil.getInstance().getStr("RESC_IMP-SYS_START_ROW")));
		Map<String,SubSystemDto> subSystemDtoMap = new HashMap<String,SubSystemDto>();
		if(null!=subSysList&&!subSysList.isEmpty()){
			for(List<Object> row : subSysList){
				String subSysCode = row.get(0)==null?"":String.valueOf(row.get(0));
				String subSysName = row.get(1)==null?"":String.valueOf(row.get(1));
				String subSysUri = row.get(2)==null?"":String.valueOf(row.get(2));
				String subSysDes = row.get(3)==null?"":String.valueOf(row.get(3));
				SubSystemDto subSystemDto = new SubSystemDto();
				subSystemDto.setId(IdUtil.getUuid());
				subSystemDto.setSubSysCode(subSysCode);
				subSystemDto.setSubSysName(subSysName);
				subSystemDto.setSubSysUri(subSysUri);
				subSystemDto.setSubSysDes(subSysDes);
				subSystemDto.setCreateTime(now);
				this.putSubSystem(subSystemDtoMap, subSystemDto);

				if(subSystemService.isExistByCode(subSystemDto.getSubSysCode())){
					logger.debug("子系统:["+subSystemDto.getSubSysName()+"]已经存在，无需插入！");
				}else{
					subSystemService.saveSubSystem(subSystemDto);
					logger.debug("插入子系统:["+subSystemDto.getSubSysName()+"]成功！");
				}
			}
		}

		List<List<Object>> modList = ExcelImportUtil.readAllRows(inputStream,Integer.valueOf(RedisUtil.getInstance().getStr("RESC_IMP-SYS_START_SHEET")),Integer.valueOf(RedisUtil.getInstance().getStr("RESC_IMP-SYS_START_ROW")));
		Map<String,ModuleDto> moduleDtoMap = new HashMap<String,ModuleDto>();
		if(null!=modList&&!modList.isEmpty()){
			for(List<Object> row : modList){
				ModuleDto moduleDto = new ModuleDto();
				String modCode = row.get(0)==null?"":String.valueOf(row.get(0));
				String modName = row.get(1)==null?"":String.valueOf(row.get(1));
				String tableName = row.get(2)==null?"":String.valueOf(row.get(2));
				String modUri = row.get(3)==null?"":String.valueOf(row.get(3));
				String modDes = row.get(4)==null?"":String.valueOf(row.get(4));
				String subSysCode = modCode.substring(0,2);
				this.putModule(moduleDtoMap,moduleDto);

				moduleDto.setId(IdUtil.getUuid());
				moduleDto.setSubSysCode(subSysCode);
				moduleDto.setModCode(modCode);
				moduleDto.setModName(modName);
				moduleDto.setTableName(tableName);
				moduleDto.setModUri(modUri);
				moduleDto.setModDes(modDes);

				if(moduleService.isExistByCodes(moduleDto.getSubSysCode(),moduleDto.getModCode())){
					logger.debug("模块:["+moduleDto.getModName()+"]已经存在，无需插入！");
				}else{
					moduleDto.setCreateTime(now);
					moduleService.saveModule(moduleDto);
					logger.debug("插入模块:["+moduleDto.getModName()+"]成功！");
				}
			}
		}
		List<List<Object>> rowList = ExcelImportUtil.readAllRows(inputStream,sysConfig.getResStartSheetIndex(),sysConfig.getResStartRowIndex());
		if(null!=rowList&&!rowList.isEmpty()){
			for(List<Object> row : rowList){
				String rescCode = row.get(0)==null?"":String.valueOf(row.get(0));
				String rescName = row.get(1)==null?"":String.valueOf(row.get(1));
				String tableName = row.get(2)==null?"":String.valueOf(row.get(2));
				String rescUriType = row.get(3)==null?"":String.valueOf(row.get(3));
				String rescUri = row.get(4)==null?"":String.valueOf(row.get(4));
				String rescDes = row.get(5)==null?"":String.valueOf(row.get(5));

				String subSysCode = rescCode.substring(0,2);
				SubSystemDto subSystemDto = subSystemDtoMap.get(subSysCode);
				String subSysName = subSystemDto.getSubSysName();
				String subSysUri = subSystemDto.getSubSysUri();

				String modCode = rescCode.substring(0,4);
				ModuleDto moduleDto = moduleDtoMap.get(modCode);
				String modName = moduleDto.getModName();
				String modUri = moduleDto.getModUri();
				Resource resource = new Resource();
				resource.setId(IdUtil.getUuid());
				resource.setSubSysCode(subSysCode);
				resource.setSubSysName(subSysName);
				resource.setSubSysUri(subSysUri);
				resource.setModCode(modCode);
				resource.setModName(modName);
				resource.setModUri(modUri);
				resource.setRescCode(rescCode);
				resource.setRescName(rescName);
				resource.setRescUriType(rescUriType);
				resource.setRescUri(rescUri);
				resource.setRescDes(rescDes);
				resource.setCreateTime(now);
				resource.setUpdateTime(now);
				Resource resourceResult = resourceMapper.selectByCodes(subSysCode, modCode, rescCode);
				if(null==resourceResult){
					resourceMapper.insert(resource);
					logger.debug("插入资源:["+subSysName+modName+rescName+"]成功！");
				}else{
					logger.debug("资源:["+subSysName+modName+rescName+"]已经存在，无需插入！");
				}
			}
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}else{
			resultDo.setResultDo(ResourceResult.IMPORT_LIST_NULL);
			logger.info(ResourceResult.IMPORT_LIST_NULL.getValue());
		}
		return resultDo;
	}
	
	private void putSubSystem(Map<String, SubSystemDto> subSystemMap, SubSystemDto subSystemDto){
		SubSystemDto subSystemTempDto = subSystemMap.get(subSystemDto.getSubSysCode());
		if(null==subSystemTempDto){
			subSystemMap.put(subSystemDto.getSubSysCode(), subSystemDto);
		}
	}
	
	private void putModule(Map<String, ModuleDto> moduleMap, ModuleDto moduleDto){
		if(null==moduleDto){
			moduleMap.put(moduleDto.getModCode(), moduleDto);
		}
	}



	@Override
	public ResultDo<String> exportResource() throws IOException {
//		@TODO 后期实现
//		ResultDo<List<SubSystemDto>> subSystemDtoResult = subSystemService.findAll();
//		List<Resource> resourceList  = resourceMapper.selectAll();
//
//		ResultDo<String> resultDo = new ResultDo<String>();
//		if(){
//
//		}else{
//
//		}
//		if(null!=resourceList&&!resourceList.isEmpty()){
//			ExcelExportUtil excelExportUtil = new ExcelExportUtil(ExcelExportUtil.ExcelType.XLSX);
////			创建表头
//			excelExportUtil.createRow();
//			excelExportUtil.setCellHeader(0, "序号");
//			excelExportUtil.setCellHeader(1, "姓名");
//			excelExportUtil.setCellHeader(2, "手机号");
//			excelExportUtil.setCellHeader(3, "地区");
//			excelExportUtil.setCellHeader(4, "状态名称");
//
//
//			String subSysCode = row.get(0)==null?"":String.valueOf(row.get(0));
//			String subSysName = row.get(1)==null?"":String.valueOf(row.get(1));
//			String subSysUri = row.get(2)==null?"":String.valueOf(row.get(2));
//			String modCode = row.get(3)==null?"":String.valueOf(row.get(3));
//			String modName = row.get(4)==null?"":String.valueOf(row.get(4));
//			String tableName = row.get(5)==null?"":String.valueOf(row.get(5));
//			String modUri = row.get(6)==null?"":String.valueOf(row.get(6));
//			String rescCode = row.get(7)==null?"":String.valueOf(row.get(7));
//			String rescName = row.get(8)==null?"":String.valueOf(row.get(8));
//			String rescUriType = row.get(9)==null?"1":String.valueOf(row.get(9));
//			String rescUri = row.get(10)==null?"":String.valueOf(row.get(10));
//			String rescDes = row.get(11)==null?"":String.valueOf(row.get(11));
//			Integer index = 1;
////			生成表内容
//			for(SignUpDto signUpDto : signUpResultDo.getResultData()){
//				excelExportUtil.createRow();
//				excelExportUtil.setCell(0, index);
//				excelExportUtil.setCell(1, signUpDto.getCustName());
//				excelExportUtil.setCell(2, signUpDto.getPhone());
//				excelExportUtil.setCell(3, signUpDto.getAreaCodeStr());
//				excelExportUtil.setCell(4, signUpDto.getStateName());
//				index++;
//			}
//
//			logger.info("导出报名信息：["+sysConfig.getStaticFullPath()+jedisPool.getResource().get("FILE_TYPE-EXCEL")+"/"+activityId+".xlsx]");
//			excelExportUtil.export(sysConfig.getStaticFullPath()+jedisPool.getResource().get("FILE_TYPE-EXCEL")+"/",activityId+".xlsx");
//			resultDo.setResultDo(InterfaceResult.SUCCESS);
//			logger.info(InterfaceResult.SUCCESS.getValue());
//
//			logger.info("报名信息下载地址：["+sysConfig.getStaticFullUrl()+jedisPool.getResource().get("FILE_TYPE-EXCEL")+"/"+activityId+".xlsx]");
//			resultDo.setResultData(sysConfig.getStaticFullUrl()+jedisPool.getResource().get("FILE_TYPE-EXCEL")+"/"+activityId+".xlsx");
//		}else if(InterfaceResult.LIST_EMPTY.getKey().equals(signUpResultDo.getResultCode())){
//			resultDo.setResultDo(InterfaceResult.LIST_EMPTY);
//			logger.error("报名信息列表为空！");
//		}else{
//			resultDo.setResultDo(ActivityResult.EXPORT_SIGNUP_FAILURE);
//		}
//		return resultDo;
		return null;
	}
}