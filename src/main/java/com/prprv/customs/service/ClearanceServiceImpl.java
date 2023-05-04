package com.prprv.customs.service;


import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.entity.Declaration;
import com.prprv.customs.entity.Orders;
import com.prprv.customs.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private final CustomerMapper customerMapper;
    private final DeclarationMapper declarationMapper;
    private final OrdersMapper ordersMapper;
    private final ProcessMapper processMapper;


    /**
     * 创建货物：货物离开关卡，工作人员创建货物信息记录，插入表"cargo"。
     * @param cargo 货物信息
     * @return Result
     */
    @Override
    public Result<Object> createGoods(Cargo cargo) {
        try {
            cargoMapper.insert(cargo);
            return ResultUtil.success(ResultEnum.SUCCESS);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }


    /**
     * 创建报关记录：工作人员创建报关(出关)记录。
     * @param cargoId 货物id
     * @return Result
     */
    @Override
    public Result<Object> declareGoods(Long cargoId) {
        try {
            //根据日期时间生成"declarationNo(出关报关单号)"，格式为：年月日时分秒，为一串数字
            String declarationNo =cargoId + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            //创建申报记录
            Declaration declaration = new Declaration();
            declaration.setDeclarationNo(declarationNo);
            declaration.setCargoId(cargoId);
            declaration.setStatus("已申报");
            //更新货物状态
            cargoMapper.selectById(cargoId).setStatus("已申报");
            //插入申报单
            declarationMapper.insert(declaration);
            return ResultUtil.success(declaration);
        }
        catch (Exception e) {
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 创建订单：客户下订单，订单记录插入表"orders"
     * 并将对应货物记录的状态更新为“待出库”。
     * @param cargoId 货物id
     * @param customerId 客户id
     * @return Result
     */
    @Override
    public Result<Object> createOrder(Long cargoId, Long customerId) {
        try {
            Orders orders = new Orders();
            //获取当前时间
            String orderNo =customerId + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            //创建订单
            orders.setOrderNo(orderNo);
            orders.setCustomerId(customerId);
            orders.setCargoId(cargoId);
            orders.setOrderTime(LocalDateTime.now());
            orders.setStatus("待出库");
            //更新货物状态
            cargoMapper.selectById(cargoId).setStatus("待出库");
            //插入订单
            ordersMapper.insert(orders);
            return ResultUtil.success(orders);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
