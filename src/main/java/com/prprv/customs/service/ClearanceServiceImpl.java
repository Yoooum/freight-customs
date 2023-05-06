package com.prprv.customs.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.entity.Declaration;
import com.prprv.customs.entity.Orders;
import com.prprv.customs.entity.Process;
import com.prprv.customs.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 出关服务接口实现类
 * @author phj233
 * @since 2023/4/23 9:09
 * @see ClearanceService
 */
@Service
@RequiredArgsConstructor
public class ClearanceServiceImpl implements ClearanceService {
    private final CargoMapper cargoMapper;
    private final DeclarationMapper declarationMapper;
    private final OrdersMapper ordersMapper;
    private final ProcessMapper processMapper;

    /**
     * 查询需要待出关的货物
     */
    @Override
    public Result<Object> findClearanceGoods() {
        try {
            QueryWrapper<Cargo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "待出关");
            List<Cargo> cargoList = cargoMapper.selectList(queryWrapper);
            queryWrapper.clear();
            return ResultUtil.success(cargoList);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 更新待出关的货物状态
     * 更新状态为出关中
     *
     * @param cargoId 货物id
     */
    @Override
    public Result<Object> clearanceGoods(Long cargoId) {
        try {
            Cargo cargo = cargoMapper.selectById(cargoId);
            cargo.setStatus("出关中");
            cargoMapper.updateById(cargo);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 审核报关单
     *
     * @param declarationId 报关单id
     */
    @Override
    public Result<Object> auditDeclaration(Long declarationId) {
        try {
            Declaration declaration = declarationMapper.selectById(declarationId);
            declaration.setStatus("审核通过");
            declarationMapper.updateById(declaration);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 更新出关订单状态
     * 更新状态为已出关
     *
     * @param orderNo 订单号
     */
    @Override
    public Result<Object> clearanceOrder(String orderNo) {
        try {
            Orders orders = ordersMapper.selectById(orderNo);
            orders.setStatus("已出关");
            ordersMapper.updateById(orders);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 更新发货订单状态
     * 更新状态为已发货
     *
     * @param orderNo 订单号
     */
    @Override
    public Result<Object> deliverOrder(String orderNo) {
        try {
            Orders orders = ordersMapper.selectById(orderNo);
            orders.setStatus("已发货");
            ordersMapper.updateById(orders);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 记录流程日志
     * 完成出关后记录出关流程
     *
     * @param process 操作
     */
    @Override
    public Result<Object> logProcess(Process process) {
        try {
            process.setOperationTime(LocalDateTime.now());
            process.setOperation("出关");
            processMapper.insert(process);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
