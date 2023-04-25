package com.prprv.customs.service;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.entity.Cargo;

/**
 * 入关服务接口
 * @author phj233
 * @since 2023/4/23 9:08
 */
public interface DeclarationService {
    /**
     * 创建货物
     * @param cargo 货物信息
     * @return Result<Object>
     */
    Result<Object> createGoods(Cargo cargo);

    /**
     * 创建申报单，更新货物状态为 已申报
     * @param cargoId 货物id
     * @return Result<Object>
     */
    Result<Object> declareGoods(Long cargoId);

    /**
     * 创建订单，更新货物状态为 待出库
     * @param cargoId 货物id
     */
    Result<Object> createOrder(Long cargoId, Long customerId);
}
