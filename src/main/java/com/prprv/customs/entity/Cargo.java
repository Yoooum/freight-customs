package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@TableName("cargo")
public class Cargo {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer quantity;
    private Double weight;
    private Double value;
    private String destination;
    private String status;
}
