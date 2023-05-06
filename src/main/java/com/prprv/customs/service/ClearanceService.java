package com.prprv.customs.service;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.entity.Process;

/**
 * 出关服务接口
 * @author phj233
 * @since 2023/4/23 9:08
 */
public interface ClearanceService{
    /**
     * 查询需要待出关的货物
     */
    Result<Object> findClearanceGoods();

    /**
     * 更新待出关的货物状态
     * 更新状态为出关中
     * @param cargoId 货物id
     */
    Result<Object> clearanceGoods(Long cargoId);

    /**
     * 审核报关单
     * @param declarationId 报关单id
     */
    Result<Object> auditDeclaration(Long declarationId);

    /**
     * 更新出关订单状态
     * 更新状态为已出关
     * @param orderNo 订单号
     */
    Result<Object> clearanceOrder(String orderNo);

    /**
     * 更新发货订单状态
     * 更新状态为已发货
     * @param orderNo 订单号
     */
    Result<Object> deliverOrder(String orderNo);

    /**
     * 记录流程日志
     * 完成出关后记录出关流程
     * @param process 操作
     */
    Result<Object> logProcess(Process process);

}
