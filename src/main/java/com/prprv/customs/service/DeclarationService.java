package com.prprv.customs.service;


import com.prprv.customs.common.result.Result;
import com.prprv.customs.entity.Cargo;

/**
 * 入关服务接口
 * @author phj233
 * @since 2023/4/23 9:08
 */
public interface DeclarationService{

    /**
     * 创建货物
     * @param cargo 货物信息
     * @return Result
     */
    Result<Object> createGoods(Cargo cargo);

    /**
     * 申报货物
     * @param id 货物id
     * @return Result
     */
    Result<Object> declareGoods(Long id);

    /**
     * 创建订单
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     */
    Result<Object> createOrder(Long cargoId, Long customerId);

    /**
     * 查询申报单
     * @param page 页码
     * @param size 每页大小
     * @return Result
     */
    Result<Object> findDeclaration(Integer page, Integer size);

    /**
     * 查询所有申报单
     * @return Result
     */
    Result<Object> findAllDeclaration();
}
