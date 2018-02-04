package com.cxs.extension.csr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.cxs.extension.csr.entity.Customer;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 客户数据库操作封装类
 * @ClassName: CustomerMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月30日
 *
 */
@Repository
public interface CustomerMapper extends CoreMapper<Customer> {

	/**
	 * 根据id列表删除客户
	 * @param ids
	 */
	@Delete("delete from csr_customer where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);

}
