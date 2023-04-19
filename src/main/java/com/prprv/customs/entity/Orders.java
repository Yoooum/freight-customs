package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

/**
 * @author Yoooum
 */
public class Orders {

    private Long id;
    private String orderNo;
    private Long customerId;
    private Long cargoId;
    private LocalDateTime orderTime;
    private String status;
}
