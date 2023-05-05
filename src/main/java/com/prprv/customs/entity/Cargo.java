package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 货物实体类
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@TableName("cargo")
public class Cargo {

    /**
     * 货物id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 货物名称
     */
    private String name;
    /**
     * 货物数量
     */
    private Integer quantity;
    /**
     * 货物重量
     */
    private Double weight;
    /**
     * 货物价值
     */
    private Double value;
    /**
     * 货物目的地
     */
    private String destination;
    /**
     * 货物状态
     */
    private String status;
}
