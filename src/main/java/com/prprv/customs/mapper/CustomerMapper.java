package com.prprv.customs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prprv.customs.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author phj233
 * @since 2023/4/23 8:48
 * @version 1.0
 * @see Customer
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
