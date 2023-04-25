package com.prprv.customs.service;

import com.prprv.customs.entity.Orders;
import com.prprv.customs.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 入关服务接口实现类
 * @author phj233
 * @since 2023/4/23 9:09
 * @see ClearanceService
 */
@Service
@RequiredArgsConstructor
public class ClearanceServiceImpl implements ClearanceService{
    private final CargoMapper cargoMapper;
    private final CustomerMapper customerMapper;
    private final DeclarationMapper declarationMapper;
    private final OrdersMapper ordersMapper;
    private final ProcessMapper processMapper;


    /**
     * 清仓
     */
    public void clearance(Orders orders){
        //TODO
    }

    /**
     *
     * 入仓
     */
    public void declaration(Orders orders){
        //TODO
    }
}
