package com.cxs.extension.ath.service.impl;

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

import com.cxs.extension.ath.dto.SubSystemDto;
import com.cxs.extension.ath.dto.ModuleDto;
import com.cxs.extension.ath.entity.Module;
import com.cxs.extension.ath.mapper.ModuleMapper;
import com.cxs.extension.ath.result.ModuleResult;
import com.cxs.extension.ath.service.api.ModuleService;
import com.cxs.extension.ath.service.api.SubSystemService;
import com.cxs.extension.ath.utils.ModuleParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 
 * @Description: 模块业务处理实现类
 * @ClassName: ModuleServiceImpl
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
@Service
public class ModuleServiceImpl implements ModuleService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private SubSystemService subSystemService;

	@Override
	public ResultDo<ModuleDto> saveModule(ModuleDto moduleDto) {
		ResultDo<ModuleDto> resultDo = new ResultDo<ModuleDto>();
		Module module = new Module();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try {
			if (null != moduleDto) {
				if (StringUtil.isNotEmpty(moduleDto.getSubSysCode())) {
					if (StringUtil.isNotEmpty(moduleDto.getModCode())) {
						if (StringUtil.isNotEmpty(moduleDto.getModName())) {
							Module moduleTemp = moduleMapper.selectByCodes(moduleDto.getSubSysCode(),
									moduleDto.getModCode());
							if (null != moduleTemp) {
								resultDo.setResultDo(ModuleResult.SAVE_EXISTS);
								logger.error(ModuleResult.SAVE_EXISTS.getValue());
							} else {
								moduleDto.setId(IdUtil.getUuid());
								moduleDto.setCreateTime(time);
								moduleDto.setUpdateTime(time);
								ModuleParseUtil.parseToEntity(moduleDto, module);
								moduleMapper.insert(module);
								resultDo.setResultDo(InterfaceResult.SUCCESS);
								logger.info(InterfaceResult.SUCCESS.getValue());
							}
						} else {
							resultDo.setResultDo(ModuleResult.SAVE_MODNAME_NOT_NULL);
							logger.error(ModuleResult.SAVE_MODNAME_NOT_NULL.getValue());
						}
					} else {
						resultDo.setResultDo(ModuleResult.SAVE_MODCODE_NOT_NULL);
						logger.error(ModuleResult.SAVE_MODCODE_NOT_NULL.getValue());
					}
				} else {
					resultDo.setResultDo(ModuleResult.SAVE_SUBSYSCODE_NOT_NULL);
					logger.error(ModuleResult.SAVE_SUBSYSCODE_NOT_NULL.getValue());
				}
			} else {
				resultDo.setResultDo(ModuleResult.SAVE_FAILURE);
				logger.error(ModuleResult.SAVE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.SAVE_FAILURE);
			logger.error(ModuleResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(moduleDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteModuleById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try {
			if (null != id && !"".equals(id)) {
				int i = moduleMapper.deleteByPrimaryKey(id);
				if (i == 0) {
					resultDo.setResultDo(ModuleResult.DELETE_MODULE_NOT_EXIST);
					logger.info(ModuleResult.DELETE_MODULE_NOT_EXIST.getValue());
				} else {
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(ModuleResult.DELETE_ID_NOT_NULL);
				logger.error(ModuleResult.DELETE_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.DELETE_FAILURE);
			logger.error(ModuleResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteModuleByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try {
			if (null != ids && ids.length > 0) {
				for (String shortIds : IdUtil.getIdsList(ids)) {
					moduleMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(ModuleResult.DELETE_IDS_NOT_NULL);
				logger.error(ModuleResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.DELETE_BY_IDS_FAILURE);
			logger.error(ModuleResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteModuleByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try {
			if (null != idList && !idList.isEmpty()) {
				for (String shortIds : IdUtil.getIdsList(idList)) {
					moduleMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(ModuleResult.DELETE_IDS_NOT_NULL);
				logger.error(ModuleResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			logger.error(ModuleResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}

	@Override
	public ResultDo<ModuleDto> updateModule(ModuleDto moduleDto) {
		ResultDo<ModuleDto> resultDo = new ResultDo<ModuleDto>();
		Module module = new Module();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try {
			if (null != moduleDto) {
				if (StringUtil.isNotEmpty(moduleDto.getId())) {
					if (StringUtil.isNotEmpty(moduleDto.getSubSysCode())) {
						if (StringUtil.isNotEmpty(moduleDto.getModCode())) {
							if (StringUtil.isNotEmpty(moduleDto.getModName())) {
								Module moduleTemp = moduleMapper.selectByCodesAndId(moduleDto.getId(), moduleDto.getSubSysCode(), moduleDto.getModCode());
								if (null != moduleTemp) {
									resultDo.setResultDo(ModuleResult.UPDATE_EXISTS);
									logger.error(ModuleResult.UPDATE_EXISTS.getValue());
								} else {
									moduleDto.setUpdateTime(time);
									ModuleParseUtil.parseToEntity(moduleDto, module);
									moduleMapper.updateByPrimaryKeySelective(module);
									resultDo.setResultDo(InterfaceResult.SUCCESS);
									logger.info(InterfaceResult.SUCCESS.getValue());
								}
							} else {
								resultDo.setResultDo(ModuleResult.UPDATE_MODNAME_NOT_NULL);
								logger.error(ModuleResult.UPDATE_MODNAME_NOT_NULL.getValue());
							}
						} else {
							resultDo.setResultDo(ModuleResult.UPDATE_MODCODE_NOT_NULL);
							logger.error(ModuleResult.UPDATE_MODCODE_NOT_NULL.getValue());
						}
					} else {
						resultDo.setResultDo(ModuleResult.UPDATE_SUBSYSCODE_NOT_NULL);
						logger.error(ModuleResult.UPDATE_SUBSYSCODE_NOT_NULL.getValue());
					}
				} else {
					resultDo.setResultDo(ModuleResult.UPDATE_ID_NOT_NULL);
					logger.error(ModuleResult.UPDATE_ID_NOT_NULL.getValue());
				}

			} else {
				resultDo.setResultDo(ModuleResult.UPDATE_FAILURE);
				logger.error(ModuleResult.UPDATE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.UPDATE_FAILURE);
			logger.error(ModuleResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(moduleDto);
		return resultDo;
	}

	@Override
	public ResultDo<ModuleDto> findModuleById(String id) {
		ModuleDto moduleDto = new ModuleDto();
		ResultDo<ModuleDto> resultDo = new ResultDo<ModuleDto>();
		try {
			if (null != id && !"".equals(id)) {
				Module module = moduleMapper.selectByPrimaryKey(id);
				ModuleParseUtil.parseToDto(module, moduleDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			} else {
				resultDo.setResultDo(ModuleResult.FIND_BY_ID_NOT_NULL);
				logger.error(ModuleResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.FIND_FAILURE);
			logger.error(ModuleResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(moduleDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<ModuleDto>> findModule(PageDto<ModuleDto> pageDto) {
		logger.debug("debug test");
		List<ModuleDto> moduleDtoList = new ArrayList<ModuleDto>();
		List<Module> moduleList = null;
		ResultDo<PageDto<ModuleDto>> resultDo = new ResultDo<PageDto<ModuleDto>>();
		try {
			pageDto.setTotalRecord(moduleMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			moduleList = moduleMapper.selectAll();
			ModuleParseUtil.parseToDtoList(moduleList, moduleDtoList);
			pageDto.setPageData(moduleDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.FIND_FAILURE);
			logger.error(ModuleResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<ModuleDto>> findModule(PageDto<ModuleDto> pageDto, ModuleDto moduleDto) {
		List<ModuleDto> moduleDtoList = new ArrayList<ModuleDto>();
		ResultDo<PageDto<ModuleDto>> resultDo = new ResultDo<PageDto<ModuleDto>>();
		List<Module> moduleList = null;
		try {

			Example example = new Example(Module.class);
			example.createCriteria();
			if (StringUtil.isNotEmpty(moduleDto.getSubSysCode())) {
				example.getOredCriteria().get(0).andLike("subSysCode", "%" + moduleDto.getSubSysCode() + "%");
			}
			if (StringUtil.isNotEmpty(moduleDto.getModCode())) {
				example.getOredCriteria().get(0).andLike("modCode", "%" + moduleDto.getModCode() + "%");
			}
			if (StringUtil.isNotEmpty(moduleDto.getModName())) {
				example.getOredCriteria().get(0).andLike("modName", "%" + moduleDto.getModName() + "%");
			}
			example.setOrderByClause("create_time  DESC");
			pageDto.setTotalRecord(moduleMapper.selectCountByExample(example));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			moduleList = moduleMapper.selectByExample(example);
			ModuleParseUtil.parseToDtoList(moduleList, moduleDtoList);
			pageDto.setPageData(moduleDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.FIND_FAILURE);
			logger.error(ModuleResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<List<ModuleDto>> findBySubSysCode(String subSysCode) {
		List<ModuleDto> moduleDtoList = new ArrayList<ModuleDto>();
		ResultDo<List<ModuleDto>> resultDo = new ResultDo<List<ModuleDto>>();
		List<Module> moduleList = null;
		try {
			moduleList = moduleMapper.selectBySubSysCode(subSysCode);
			ModuleParseUtil.parseToDtoList(moduleList, moduleDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(ModuleResult.FIND_FAILURE);
			logger.error(ModuleResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(moduleDtoList);
		return resultDo;
	}

	@Override
	public Boolean isExistByCodes(String subSysCode, String modCode) {
		Boolean flag = false;
		Module module = moduleMapper.selectByCodes(subSysCode, modCode);
		if(null!=module){
			flag=true;
		}
		return flag;
	}


	public ResultDo<List<Map<String,Object>>> getModTree() {
			ResultDo<List<Map<String,Object>>> resultDo = new ResultDo<List<Map<String,Object>>>();
			List<Map<String,Object>> modTree = new ArrayList<Map<String,Object>>();
			try {
				ResultDo<List<SubSystemDto>> subSystemResultDo =subSystemService.findAll();
				if(InterfaceResult.SUCCESS.getKey().equals(subSystemResultDo.getResultCode())) {
					List<SubSystemDto> subSystemDtoList =subSystemResultDo.getResultData();
					for(SubSystemDto subSystemDto : subSystemDtoList) {
						Map<String,Object> subSystemMap = new HashMap<String,Object>();
						subSystemMap.put("id", subSystemDto.getSubSysCode());
						subSystemMap.put("label", subSystemDto.getSubSysName());
						List<Module> moduleList = moduleMapper.selectBySubSysCode(subSystemDto.getSubSysCode());
						if(null!=moduleList&&!moduleList.isEmpty()) {
							List<Map<String,String>> modList = new ArrayList<Map<String,String>>();
							for(Module module:moduleList) {
								Map<String,String> modMap = new HashMap<String,String>();
								modMap.put("id", module.getModCode());
								modMap.put("label", module.getModName());
								modList.add(modMap);
							}
							subSystemMap.put("children", modList);
						}
						modTree.add(subSystemMap);
					}
				}
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());		
			} catch (Exception e) {
				resultDo.setResultDo(ModuleResult.FIND_FAILURE);
				logger.error(ModuleResult.FIND_FAILURE.getValue(), e);
			}
			resultDo.setResultData(modTree);
			return resultDo;
		}

	
	
}