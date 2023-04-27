package com.prprv.customs.service;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.entity.Cargo;

/**
 * 出关服务接口
 * @author phj233
 * @since 2023/4/23 9:08
 */
public interface ClearanceService {

    /**
     *创建货物记录：出关前更新货物记录并执行货物检查（若无此货物则创建)，插入cargo表中。
     * @param cargo 货物信息
     * @return Result
     */
    Result<Object> createGoods(Cargo cargo);

    /**
     * 货物申报：创建申报(报关)记录，更新货物申报状态，插入declaration表中。
     * @param cargoId 货物id
     * @return Result
     */
    Result<Object> declareGoods(Long cargoId);

    /**
     * 创建订单：客户创建订单，插入orders表中。
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     */
    Result<Object> createOrder(Long cargoId, Long customerId);
}
