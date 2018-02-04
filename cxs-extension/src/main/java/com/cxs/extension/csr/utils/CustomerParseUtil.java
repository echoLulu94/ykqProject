package com.cxs.extension.csr.utils;

import java.util.List;

import com.cxs.extension.csr.dto.CustomerDto;
import com.cxs.extension.csr.entity.Customer;
/**
* 
* @Description: 客户DTO和客户互转工具类
* @ClassName: CustomerParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class CustomerParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param customer 源客户entity
	 * @param customerDto 目标客户dto
	 */
	public static void parseToDto(Customer customer, CustomerDto customerDto){
		parseToDto(customer, customerDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param customer 源客户entity
	 * @param customerDto 目标客户dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(Customer customer, CustomerDto customerDto, Boolean flag){
		if(flag){
			customerDto.setId(customer.getId());
			customerDto.setCustName(customer.getCustName());
			customerDto.setPwd(customer.getPwd());
			customerDto.setPhone(customer.getPhone());
			customerDto.setOpenId(customer.getOpenId());
			customerDto.setUnionId(customer.getUnionId());
			customerDto.setCity(customer.getCity());
			customerDto.setIdcard(customer.getIdcard());
			customerDto.setAreaCode(customer.getAreaCode());
			customerDto.setNickName(customer.getNickName());
			customerDto.setHeadImgUrl(customer.getHeadImgUrl());
			customerDto.setSalt(customer.getSalt());
			customerDto.setSex(customer.getSex());
			customerDto.setBirthday(customer.getBirthday());
			customerDto.setCreateBy(customer.getCreateBy());
			customerDto.setCreateTime(customer.getCreateTime());
			customerDto.setUpdateBy(customer.getUpdateBy());
			customerDto.setUpdateTime(customer.getUpdateTime());
			customerDto.setUserCode(customer.getUserCode());
			customerDto.setRdCode(customer.getRdCode());
			customerDto.setBelongType(customer.getBelongType());
			customerDto.setBelongCode(customer.getBelongCode());
		}else{
			if(null!=customer.getId()){
				customerDto.setId(customer.getId());
			}
			if(null!=customer.getCustName()){
				customerDto.setCustName(customer.getCustName());
			}
			if(null!=customer.getPwd()){
				customerDto.setPwd(customer.getPwd());
			}
			if(null!=customer.getPhone()){
				customerDto.setPhone(customer.getPhone());
			}
			if(null!=customer.getOpenId()){
				customerDto.setOpenId(customer.getOpenId());
			}
			if(null!=customer.getUnionId()){
				customerDto.setUnionId(customer.getUnionId());
			}
			if(null!=customer.getCity()){
				customerDto.setCity(customer.getCity());
			}
			if(null!=customer.getIdcard()){
				customerDto.setIdcard(customer.getIdcard());
			}
			if(null!=customer.getAreaCode()){
				customerDto.setAreaCode(customer.getAreaCode());
			}
			if(null!=customer.getNickName()){
				customerDto.setNickName(customer.getNickName());
			}
			if(null!=customer.getHeadImgUrl()){
				customerDto.setHeadImgUrl(customer.getHeadImgUrl());
			}
			if(null!=customer.getSalt()){
				customerDto.setSalt(customer.getSalt());
			}
			if(null!=customer.getSex()){
				customerDto.setSex(customer.getSex());
			}
			if(null!=customer.getBirthday()){
				customerDto.setBirthday(customer.getBirthday());
			}
			if(null!=customer.getCreateBy()){
				customerDto.setCreateBy(customer.getCreateBy());
			}
			if(null!=customer.getCreateTime()){
				customerDto.setCreateTime(customer.getCreateTime());
			}
			if(null!=customer.getUpdateBy()){
				customerDto.setUpdateBy(customer.getUpdateBy());
			}
			if(null!=customer.getUpdateTime()){
				customerDto.setUpdateTime(customer.getUpdateTime());
			}
			if(null!=customer.getUserCode()){
				customerDto.setUserCode(customer.getUserCode());
			}
			if(null!=customer.getRdCode()){
				customerDto.setRdCode(customer.getRdCode());
			}
			if(null!=customer.getBelongType()){
				customerDto.setBelongType(customer.getBelongType());
			}
			if(null!=customer.getBelongCode()){
				customerDto.setBelongCode(customer.getBelongCode());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param customerDto 源客户dto
	 * @param customer 目标客户entity
	 */
	public static void parseToEntity(CustomerDto customerDto, Customer customer){
		parseToEntity(customerDto, customer, false);
	}
	
	/**
	 * dto转entity
	 * @param customerDto 源客户dto
	 * @param customer 目标客户entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(CustomerDto customerDto, Customer customer, Boolean flag){
		if(flag){
			customer.setId(customerDto.getId());
			customer.setCustName(customerDto.getCustName());
			customer.setPwd(customerDto.getPwd());
			customer.setPhone(customerDto.getPhone());
			customer.setOpenId(customerDto.getOpenId());
			customer.setUnionId(customerDto.getUnionId());
			customer.setCity(customerDto.getCity());
			customer.setIdcard(customerDto.getIdcard());
			customer.setAreaCode(customerDto.getAreaCode());
			customer.setNickName(customerDto.getNickName());
			customer.setHeadImgUrl(customerDto.getHeadImgUrl());
			customer.setSalt(customerDto.getSalt());
			customer.setSex(customerDto.getSex());
			customer.setBirthday(customerDto.getBirthday());
			customer.setCreateBy(customerDto.getCreateBy());
			customer.setCreateTime(customerDto.getCreateTime());
			customer.setUpdateBy(customerDto.getUpdateBy());
			customer.setUpdateTime(customerDto.getUpdateTime());
			customer.setUserCode(customerDto.getUserCode());
			customer.setRdCode(customerDto.getRdCode());
			customer.setBelongType(customerDto.getBelongType());
			customer.setBelongCode(customerDto.getBelongCode());
		}else{
			if(null!=customerDto.getId()){
				customer.setId(customerDto.getId());
			}
			if(null!=customerDto.getCustName()){
				customer.setCustName(customerDto.getCustName());
			}
			if(null!=customerDto.getPwd()){
				customer.setPwd(customerDto.getPwd());
			}
			if(null!=customerDto.getPhone()){
				customer.setPhone(customerDto.getPhone());
			}
			if(null!=customerDto.getOpenId()){
				customer.setOpenId(customerDto.getOpenId());
			}
			if(null!=customerDto.getUnionId()){
				customer.setUnionId(customerDto.getUnionId());
			}
			if(null!=customerDto.getCity()){
				customer.setCity(customerDto.getCity());
			}
			if(null!=customerDto.getIdcard()){
				customer.setIdcard(customerDto.getIdcard());
			}
			if(null!=customerDto.getAreaCode()){
				customer.setAreaCode(customerDto.getAreaCode());
			}
			if(null!=customerDto.getNickName()){
				customer.setNickName(customerDto.getNickName());
			}
			if(null!=customerDto.getHeadImgUrl()){
				customer.setHeadImgUrl(customerDto.getHeadImgUrl());
			}
			if(null!=customerDto.getSalt()){
				customer.setSalt(customerDto.getSalt());
			}
			if(null!=customerDto.getSex()){
				customer.setSex(customerDto.getSex());
			}
			if(null!=customerDto.getBirthday()){
				customer.setBirthday(customerDto.getBirthday());
			}
			if(null!=customerDto.getCreateBy()){
				customer.setCreateBy(customerDto.getCreateBy());
			}
			if(null!=customerDto.getCreateTime()){
				customer.setCreateTime(customerDto.getCreateTime());
			}
			if(null!=customerDto.getUpdateBy()){
				customer.setUpdateBy(customerDto.getUpdateBy());
			}
			if(null!=customerDto.getUpdateTime()){
				customer.setUpdateTime(customerDto.getUpdateTime());
			}
			if(null!=customerDto.getUserCode()){
				customer.setUserCode(customerDto.getUserCode());
			}
			if(null!=customerDto.getRdCode()){
				customer.setRdCode(customerDto.getRdCode());
			}
			if(null!=customerDto.getBelongType()){
				customer.setBelongType(customerDto.getBelongType());
			}
			if(null!=customerDto.getBelongCode()){
				customer.setBelongCode(customerDto.getBelongCode());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param customerList 源客户entity列表
	 * @param customerDtoList 目标客户dto列表
	 */
	public static void parseToDtoList(List<Customer> customerList, List<CustomerDto> customerDtoList ){
		parseToDtoList(customerList, customerDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param customerList 源客户entity列表
	 * @param customerDtoList 目标客户dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<Customer> customerList, List<CustomerDto> customerDtoList, Boolean flag){
		if(null!=customerList&&!customerList.isEmpty()){
			for (Customer customer:customerList) {
				CustomerDto customerDto = new CustomerDto();
				parseToDto(customer, customerDto, flag);
				customerDtoList.add(customerDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param customerDtoList 源客户dto列表
	 * @param customerList 目标客户entity列表
	 */
	public static void parseToEntityList(List<CustomerDto> customerDtoList, List<Customer> customerList){
		parseToEntityList(customerDtoList, customerList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param customerDtoList 源客户dto列表
	 * @param customerList 目标客户entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<CustomerDto> customerDtoList, List<Customer> customerList, Boolean flag){
		if(null!=customerDtoList&&!customerDtoList.isEmpty()){
			for (CustomerDto customerDto:customerDtoList) {
				Customer customer = new Customer();
				parseToEntity(customerDto,customer,flag);
				customerList.add(customer);
			}
		}
	}
}
