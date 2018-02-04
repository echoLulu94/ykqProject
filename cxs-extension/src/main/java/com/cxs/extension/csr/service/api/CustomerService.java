package com.cxs.extension.csr.service.api;

import java.util.List;

import com.cxs.extension.csr.dto.CustomerDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 客户业务处理接口定义
 * @ClassName: CustomerService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月30日 
 *
 */
public interface CustomerService {
	
    /**
     * 保存客户
     * @param customerDto 需保存客户数据对象
     * @return
     */
    ResultDo<CustomerDto> saveCustomer(CustomerDto customerDto);
    
    /**
     * 根据id删除客户
     * @param id id
     * @return
     */
    ResultDo<String> deleteCustomerById(String id);
	
    /**
     * 根据id数组批量删除客户
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteCustomerByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除客户
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteCustomerByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新客户信息
	 * @param customerdto 需更新客户数据对象
	 * @return
	 */
    ResultDo<CustomerDto> updateCustomer(CustomerDto customerdto);
    
    /**
     * 根据id查找客户
     * @param id id
     * @return
     */
    ResultDo<CustomerDto> findCustomerById(String id);
    
    /**
     * 分页查询客户信息
     * @param pageDto 分页对象
     * @return
     */
	ResultDo<PageDto<CustomerDto>> findCustomer(PageDto<CustomerDto> pageDto);
	
	/**
	 * 根据查询条件分页查询客户对象
	 * @param pageDto 分页对象
	 * @param customerdto 查询条件
	 * @return
	 */
	ResultDo<PageDto<CustomerDto>> findCustomer(PageDto<CustomerDto> pageDto, CustomerDto customerdto);

	/**
	 * 根据openId或unionId查询客户
	 * @param openId
	 * @param unionId
	 * @return
	 */
	ResultDo<CustomerDto> findCustomerByOIDOrUID(String openId, String unionId);

	/**
	 * 上传头像
	 * @param customerDto
	 * @return
	 */
	ResultDo<?> uploadHeadImgUrl(CustomerDto customerDto);
}