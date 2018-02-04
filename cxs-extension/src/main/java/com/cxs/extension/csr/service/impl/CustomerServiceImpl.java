package com.cxs.extension.csr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.entity.User;
import com.cxs.extension.ath.result.UserResult;
import com.cxs.framework.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cxs.extension.csr.dto.CustomerDto;
import com.cxs.extension.csr.entity.Customer;
import com.cxs.extension.csr.mapper.CustomerMapper;
import com.cxs.extension.csr.result.CustomerResult;
import com.cxs.extension.csr.service.api.CustomerService;
import com.cxs.extension.csr.utils.CustomerParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @Description: 客户业务处理实现类
 * @ClassName: CustomerServiceImpl 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月30日 
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public ResultDo<CustomerDto> saveCustomer(CustomerDto customerDto) {
		ResultDo<CustomerDto> resultDo = new ResultDo<CustomerDto>();
		Customer customer =new Customer();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			if(null!=customerDto){
				customerDto.setId(IdUtil.getUuid());
				customerDto.setCreateTime(time);
				customerDto.setUpdateTime(time);
				CustomerParseUtil.parseToEntity(customerDto,customer);
				customerMapper.insert(customer);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(CustomerResult.SAVE_FAILURE);
				logger.error(CustomerResult.SAVE_FAILURE.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.SAVE_FAILURE);
			logger.error(CustomerResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(customerDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteCustomerById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try{
	        if(null!=id&&!"".equals(id)){
		        int i = customerMapper.deleteByPrimaryKey(id);
				if(i==0){
					resultDo.setResultDo(CustomerResult.DELETE_CUSTOMER_NOT_EXIST);
					logger.error(CustomerResult.DELETE_CUSTOMER_NOT_EXIST.getValue());
				}else{
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			}else{
				resultDo.setResultDo(CustomerResult.DELETE_ID_NOT_NULL);
				logger.error(CustomerResult.DELETE_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.DELETE_FAILURE);
			logger.error(CustomerResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
    }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteCustomerByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try{
	        if(null!=ids&&ids.length>0){
	        	for(String shortIds:IdUtil.getIdsList(ids)){
	    			customerMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(CustomerResult.DELETE_IDS_NOT_NULL);
				logger.error(CustomerResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.DELETE_BY_IDS_FAILURE);
			logger.error(CustomerResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteCustomerByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try{
	        if(null!=idList&&!idList.isEmpty()){
	        	for(String shortIds:IdUtil.getIdsList(idList)){
	    			customerMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
	    		}
			}else{
				resultDo.setResultDo(CustomerResult.DELETE_IDS_NOT_NULL);
				logger.error(CustomerResult.DELETE_IDS_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			logger.error(CustomerResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}
	
	@Override
	public ResultDo<CustomerDto> updateCustomer(CustomerDto customerDto) {
		ResultDo<CustomerDto> resultDo = new ResultDo<CustomerDto>();
		Customer customer = new Customer();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try{
			customerDto.setUpdateTime(time);
			CustomerParseUtil.parseToEntity(customerDto,customer);
			customerMapper.updateByPrimaryKeySelective(customer);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.UPDATE_FAILURE);
			logger.error(CustomerResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(customerDto);
		return resultDo;
	}

	@Override
	public ResultDo<CustomerDto> findCustomerById(String id) {
		CustomerDto customerDto = new CustomerDto();
		ResultDo<CustomerDto> resultDo = new ResultDo<CustomerDto>();
		try{
			if(null!=id&&!"".equals(id)){
				Customer customer = customerMapper.selectByPrimaryKey(id);
				CustomerParseUtil.parseToDto(customer,customerDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				resultDo.setResultDo(CustomerResult.FIND_BY_ID_NOT_NULL);
				logger.error(CustomerResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.FIND_FAILURE);
			logger.error(CustomerResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(customerDto);
		return resultDo;
    }

	@Override
	public ResultDo<PageDto<CustomerDto>> findCustomer(PageDto<CustomerDto> pageDto) {
		logger.debug("debug test");
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		List<Customer> customerList = null;
		ResultDo<PageDto<CustomerDto>> resultDo=new ResultDo<PageDto<CustomerDto>>();
		try{
			pageDto.setTotalRecord(customerMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			customerList = customerMapper.selectAll();
			CustomerParseUtil.parseToDtoList(customerList,customerDtoList);
			pageDto.setPageData(customerDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.FIND_FAILURE);
			logger.error(CustomerResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<CustomerDto>> findCustomer(PageDto<CustomerDto> pageDto, CustomerDto customerDto) {
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		ResultDo<PageDto<CustomerDto>> resultDo = new ResultDo<PageDto<CustomerDto>>();
		List<Customer> customerList=null;
		try{
			Customer example = new Customer();
			// TODO 设置查询条件	
			pageDto.setTotalRecord(customerMapper.selectCount(example));
			PageHelper.startPage(pageDto.getPageCurrent(),pageDto.getPageSize());
			customerList = customerMapper.select(example);
			CustomerParseUtil.parseToDtoList(customerList,customerDtoList);
			pageDto.setPageData(customerDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}catch (Exception e) {
			resultDo.setResultDo(CustomerResult.FIND_FAILURE);
			logger.error(CustomerResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	@Override
	public ResultDo<CustomerDto> findCustomerByOIDOrUID(String openId, String unionId) {
		ResultDo<CustomerDto> resultDo = new ResultDo<CustomerDto>();

		CustomerDto customerDto = new CustomerDto();
		Customer customer = new Customer();
		if(StringUtil.isEmpty(unionId)&&StringUtil.isEmpty(openId)){
			resultDo.setResultDo(CustomerResult.FIND_FAILURE);
			logger.error(CustomerResult.FIND_FAILURE.getValue());
		}else{
			if(StringUtil.isNotEmpty(unionId)){
				customer.setUnionId(unionId);
				customer = customerMapper.selectOne(customer);
			}else{
				customer.setOpenId(openId);
				customer = customerMapper.selectOne(customer);
			}
			if(null!=customer&&StringUtil.isNotEmpty(customer.getId())){
				CustomerParseUtil.parseToDto(customer,customerDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}else{
				Customer customerNew = new Customer();
				customerNew.setId(IdUtil.getUuid());
				customerNew.setUnionId(unionId);
				customerNew.setOpenId(openId);
				customerMapper.insert(customerNew);
				CustomerParseUtil.parseToDto(customerNew,customerDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			}
		}
		resultDo.setResultData(customerDto);
		return resultDo;
	}

	@Override
	public ResultDo<?> uploadHeadImgUrl(CustomerDto customerDto) {
		ResultDo<?> resultDo = new ResultDo<>();
		Customer customer = customerMapper.selectByPrimaryKey(customerDto.getId());
		if(null!=customer) {
			customer.setHeadImgUrl(customerDto.getHeadImgUrl());
			customerMapper.updateByPrimaryKey(customer);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		}else {
			resultDo.setResultDo(UserResult.UPDATE_HEAD_FAILURE);
			logger.error(UserResult.UPDATE_HEAD_FAILURE.getValue());
		}
		return resultDo;
	}
}