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
     * 创建货物-货物进入海关管辖区域，海关工作人员创建货物信息记录，插入cargo表中。
     * @param cargo 货物信息
     * @return Result
     */
    Result<Object> createGoods(Cargo cargo);

    /**
     * 申报货物-海关工作人员创建申报记录，插入declaration表中，并将对应货物记录的状态更新为“已申报”。
     * @param cargoId 货物id
     * @return Result
     */
    Result<Object> declareGoods(Long cargoId);

    /**
     * 创建订单-客户创建订单，插入orders表中。
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     */
    Result<Object> createOrder(Long cargoId, Long customerId);
}
