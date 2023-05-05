package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 流程实体类
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@TableName("process")
public class Process {
    /**
     * 流程id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 订单id
     */
    private Long cargoId;
    /**
     * 流程时间
     */
    private LocalDateTime operationTime;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作类型
     */
    private String operation;
}
