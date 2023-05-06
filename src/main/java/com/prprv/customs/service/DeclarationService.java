package com.prprv.customs.service;


import com.prprv.customs.common.result.Result;

/**
 * 入关服务接口
 * @author phj233
 * @since 2023/4/23 9:08
 */
public interface DeclarationService extends CommonService{
    /**
     * 查询订单
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
