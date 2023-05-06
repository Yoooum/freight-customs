package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 订单实体类
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("orders")
public class Orders {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 货物id
     */
    private Long cargoId;
    /**
     * 订单时间
     */
    private LocalDateTime orderTime;
    /**
     * 订单状态
     */
    private String status;
}
