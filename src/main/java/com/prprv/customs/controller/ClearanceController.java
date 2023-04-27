package com.prprv.customs.controller;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.service.ClearanceService;
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
     * 创建货物
     * @param cargo 货物信息
     * @return Result
     * @see ClearanceService#createGoods(Cargo)
     */
    @PostMapping("/createGoods")
    public Result<Object> createGoods(Cargo cargo) {
        try {
            return clearanceService.createGoods(cargo);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 申报货物
     * @param id 货物id
     * @return Result
     * @see ClearanceService#declareGoods(Long)
     */
    @GetMapping("/declareGoods?id={id}")
    public Result<Object> declareGoods(@PathVariable Long id) {
        try {
            return clearanceService.declareGoods(id);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 创建订单
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     * @see ClearanceService#createOrder(Long, Long)
     */
    @GetMapping("/createOrder?cargoId={cargoId}&customerId={customerId}")
    public Result<Object> createOrder(@PathVariable Long cargoId, @PathVariable Long customerId) {
        try {
            return clearanceService.createOrder(cargoId, customerId);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }


}
