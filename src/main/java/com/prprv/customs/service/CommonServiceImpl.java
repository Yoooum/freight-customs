package com.prprv.customs.service;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Orders;
import com.prprv.customs.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/4/28
 */
@Service
@RequiredArgsConstructor
public abstract class CommonServiceImpl {
    public static Result<Object> getOrder(Long cargoId, Long customerId, CargoMapper cargoMapper, OrdersMapper ordersMapper) {
        try {
            Orders orders = new Orders();
            //获取当前时间
            String orderNo =customerId + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            //创建订单
            orders.setOrderNo(orderNo);
            orders.setCustomerId(customerId);
            orders.setCargoId(cargoId);
            orders.setOrderTime(LocalDateTime.now());
            orders.setStatus("待出库");
            //更新货物状态
            cargoMapper.selectById(cargoId).setStatus("待出库");
            //插入订单
            ordersMapper.insert(orders);
            return ResultUtil.success(orders);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

}
