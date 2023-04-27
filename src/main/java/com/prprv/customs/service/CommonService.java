package com.prprv.customs.service;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.entity.Cargo;

/**
 * A part same service interface.
 * @author Christine
 * @version 1.0
 * @since 2023/4/28
 */
public interface CommonService {

    /**
     *创建货物记录：出/入关前更新货物记录并执行货物检查（若此货物尚未登记则创建)货物记录，插入到表"cargo".
     * @param cargo 货物信息
     * @return Result
     */
    Result<Object> createGoods(Cargo cargo);

    /**
     * 货物申报：创建申报(报关)记录，更新货物申报状态，插入到表"declaration".
     * @param cargoId 货物id
     * @return Result
     */
    Result<Object> declareGoods(Long cargoId);

    /**
     * 创建订单：客户创建订单，插入到表"orders".
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     */
    Result<Object> createOrder(Long cargoId, Long customerId);

}
