package com.prprv.customs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prprv.customs.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author phj233
 * @since  2023/4/23 8:49
 * @version 1.0
 * @see Orders
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
