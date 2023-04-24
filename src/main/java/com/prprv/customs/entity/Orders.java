package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@TableName("orders")
public class Orders {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String orderNo;
    private Long customerId;
    private Long cargoId;
    private LocalDateTime orderTime;
    private String status;
}
