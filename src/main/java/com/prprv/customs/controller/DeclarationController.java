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
@RequestMapping("/declaration")
public class DeclarationController {
    final private DeclarationService declarationService;

    /**
     * 创建货物
     * @param cargo 货物信息
     * @return Result
     * @see DeclarationService#createGoods(Cargo)
     */
    @PostMapping("/createGoods")
    public Result<Object> createGoods(@RequestBody Cargo cargo) {
        try {
            return declarationService.createGoods(cargo);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 申报货物
     * 申报后货物状态变为已申报
     * @param id 货物id must be a number
     * @return Result
     * @see DeclarationService#declareGoods(Long)
     */
    @GetMapping("/declareGoods")
    public Result<Object> declareGoods(@RequestParam(value = "id") Long id) {
        System.out.println(id);
        try {
            return declarationService.declareGoods(id);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 创建订单
     * 创建订单后货物状态变为待出关
     * @param cargoId 货物id must be a number
     * @param customerId 客户id must be a number
     * @return Result
     * @see DeclarationService#createOrder(Long, Long)
     */
    @GetMapping("/createOrder")
    public Result<Object> createOrder(@RequestParam(value = "cargoId") Long cargoId, @RequestParam(value = "customerId") Long customerId) {
        try {
            return declarationService.createOrder(cargoId, customerId);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 分页查询报关单
     * 默认页码1 每页2条
     * @param page 页码
     * @param size 每页大小
     * @return Result
     * @see DeclarationService#findDeclaration(Integer, Integer)
     */
    @GetMapping("/findDeclaration")
    public Result<Object> findDeclaration(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "2") Integer size) {
        try {
            return declarationService.findDeclaration(page, size);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
    /**
     * 查询所有报关单
     * @return Result
     * @see DeclarationService#findAllDeclaration()
     */
    @GetMapping("/findAllDeclaration")
    public Result<Object> findAllDeclaration() {
        try {
            return declarationService.findAllDeclaration();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
