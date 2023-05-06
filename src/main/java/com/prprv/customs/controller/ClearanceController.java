package com.prprv.customs.controller;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Process;
import com.prprv.customs.service.ClearanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 出关控制器
 * @author phj233
 * @since 2023/4/23 8:34
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/clearance")
public class ClearanceController {
    final private ClearanceServiceImpl clearanceService;

    /**
     * 查询待出关的货物
     * @return Result<Object> 待出关的货物
     */
    @GetMapping("/findClearanceGoods")
    public Result<Object> findClearanceGoods() {
        return ResultUtil.success(clearanceService.findClearanceGoods());
    }

    /**
     * 更新待出关的货物状态
     * 更新状态为出关中
     * @param cargoId 货物id
     * @return Result<Object> 更新结果
     */
    @GetMapping("/clearanceGoods")
    public Result<Object> clearanceGoods(@RequestParam Long cargoId) {
        return ResultUtil.success(clearanceService.clearanceGoods(cargoId));
    }

    /**
     * 审核报关单
     * @param declarationId 报关单id
     * @return Result<Object> 审核结果
     */
    @GetMapping("/auditDeclaration")
    public Result<Object> auditDeclaration(@RequestParam Long declarationId) {
        return ResultUtil.success(clearanceService.auditDeclaration(declarationId));
    }

    /**
     * 更新出关订单状态
     * 更新状态为已出关
     * @param orderNo 订单号
     * @return Result<Object> 更新结果
     */
    @GetMapping("/clearanceOrder")
    public Result<Object> clearanceOrder(@RequestParam String orderNo) {
        return ResultUtil.success(clearanceService.clearanceOrder(orderNo));
    }

    /**
     * 更新发货订单状态
     * 更新状态为已发货
     * @param orderNo 订单号
     * @return Result<Object> 更新结果
     */
    @GetMapping("/deliverOrder")
    public Result<Object> deliverOrder(@RequestParam String orderNo) {
        return ResultUtil.success(clearanceService.deliverOrder(orderNo));
    }

    /**
     * 记录流程日志
     * 完成出关后记录出关流程
     * @param process 操作
     * @return Result<Object> 记录结果
     */
    @PostMapping("/logProcess")
    public Result<Object> logProcess(@RequestBody Process process) {
        return ResultUtil.success(clearanceService.logProcess(process));
    }
}
