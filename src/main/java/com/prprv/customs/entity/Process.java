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
@TableName("process")
public class Process {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long cargoId;
    private LocalDateTime operationTime;
    private String operator;
    private String operation;
}
