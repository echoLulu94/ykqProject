package com.cxs.extension.csr.controller;

import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.utils.ath.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.csr.dto.CustomerDto;
import com.cxs.extension.csr.result.CustomerResult;
import com.cxs.extension.csr.service.api.CustomerService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Description: 客户控制器
 * @ClassName: CustomerController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月30日
 */
@Controller
@RequestMapping("/csr")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService customerService;
    
    /*保存客户*/
    @RequestMapping(value = "/saveCustomer")
	@ResponseBody
    public ResultDo<CustomerDto> saveCustomer(CustomerDto customerDto){
    	return customerService.saveCustomer(customerDto);
	}
    
    /*删除客户*/
    @RequestMapping(value = "/deleteCustomer")
	@ResponseBody
    public ResultDo<String> deleteCustomerById(String id){
    	return customerService.deleteCustomerById(id);
	}

	/*删除客户*/
    @RequestMapping(value = "/deleteAllCustomer")
	@ResponseBody
    public ResultDo<String []> deleteAllCustomer(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = customerService.deleteCustomerByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(CustomerResult.DELETE_BY_IDS_FAILURE);
			logger.error(CustomerResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新客户*/
    @RequestMapping(value = "/updateCustomer")
	@ResponseBody
    public ResultDo<CustomerDto> updateCustomer(CustomerDto customerDto){
    	return customerService.updateCustomer(customerDto);
	}

	/*显示客户详情*/
	@RequestMapping("/viewCustomer")
	@ResponseBody
	public ResultDo<CustomerDto> viewCustomer(String id){
		logger.info("customerId:"+id);
		return customerService.findCustomerById(id);
	}

	/*显示客户详情*/
	@RequestMapping("/fcboou")
	@ResponseBody
	@NoAuth
	public ResultDo<CustomerDto> findCustomerByOpentIdOrUnionId(String openId, String unionId){
		return customerService.findCustomerByOIDOrUID(openId,unionId);
	}

	/*查询客户*/
	@RequestMapping("/findCustomer")
	@ResponseBody
	public ResultDo<PageDto<CustomerDto>> findCustomer(PageDto<CustomerDto> pageDto, CustomerDto customerDto){
		return customerService.findCustomer(pageDto, customerDto);
	}

	/* 修改客户头像 */
	@RequestMapping("/uh")
	@ResponseBody
	@NoAuth
	public ResultDo<?> uploadHeadImgUrl(CustomerDto customerDto) {
		return customerService.uploadHeadImgUrl(customerDto);
	}
}
