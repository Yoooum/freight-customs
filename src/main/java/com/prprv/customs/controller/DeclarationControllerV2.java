package com.prprv.customs.controller;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.service.DeclarationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 入关控制器
 * @author phj233
 * @since  2023/4/23 8:25
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/declaration/v2")
public class DeclarationControllerV2 {
    final private DeclarationService declarationService;

    /**
     * 创建货物
     * @param cargo 货物信息
     * @return Result
     * @see DeclarationService#createGoods(Cargo)
     */
    @PostMapping("/createGoods")
    public Result<Object> createGoods(Cargo cargo) {
        try {
            return declarationService.createGoods(cargo);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 申报货物
     * @param id 货物id
     * @return Result
     * @see DeclarationService#declareGoods(Long)
     */
    @GetMapping("/declareGoods?id={id}")
    public Result<Object> declareGoods(@PathVariable Long id) {
        try {
            return declarationService.declareGoods(id);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 创建订单
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     * @see DeclarationService#createOrder(Long, Long)
     */
    @GetMapping("/createOrder?cargoId={cargoId}&customerId={customerId}")
    public Result<Object> createOrder(@PathVariable Long cargoId, @PathVariable Long customerId) {
        try {
            return declarationService.createOrder(cargoId, customerId);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
