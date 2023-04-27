package com.prprv.customs.service;

import com.prprv.customs.common.result.Result;
import com.prprv.customs.common.result.ResultEnum;
import com.prprv.customs.common.result.ResultUtil;
import com.prprv.customs.entity.Cargo;
import com.prprv.customs.entity.Declaration;
import com.prprv.customs.entity.Orders;
import com.prprv.customs.mapper.CargoMapper;
import com.prprv.customs.mapper.DeclarationMapper;
import com.prprv.customs.mapper.OrdersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 入关服务接口实现类
 * @author phj233
 * @since 2023/4/23 9:09
 * @see DeclarationService
 */
@Service
@RequiredArgsConstructor
public class DeclarationServiceImpl implements DeclarationService{
    final private CargoMapper cargoMapper;
    final private DeclarationMapper declarationMapper;
    final private OrdersMapper ordersMapper;
    /**
     * 创建货物-货物进入海关管辖区域，海关工作人员创建货物信息记录，插入cargo表中。
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
     * 申报货物-海关工作人员创建申报记录，
     * 插入declaration表中，并将对应货物记录的状态更新为“已申报”。
     * @param cargoId 货物id
     * @return Result
     */
    @Override
    public Result<Object> declareGoods(Long cargoId) {
      try {
          //根据日期时间生成declarationNo，格式为：年月日时分秒,为一串数字
          String declarationNo =cargoId + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
          //创建申报单
          Declaration declaration = new Declaration();
            declaration.setDeclarationNo(declarationNo);
            declaration.setCargoId(cargoId);
            declaration.setStatus("已申报");
            //更新货物状态
            cargoMapper.selectById(cargoId).setStatus("已申报");
            //插入申报单
            declarationMapper.insert(declaration);
            return ResultUtil.success(declaration);
      }catch (Exception e){
          return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
      }
    }

    /**
     * 创建订单-客户下单并支付，订单信息被记录到orders表中，
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
