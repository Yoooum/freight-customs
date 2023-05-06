package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 申报单实体类
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("declaration")
public class Declaration {

    /**
     * 申报单id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 申报单号
     */
    private String declarationNo;
    /**
     * 货物id
     */
    private Long CargoId;
    /**
     * 申报时间
     */
    private LocalDateTime declarationTime;
    /**
     * 申报类型
     */
    private String declarationType;
    /**
     * 申报状态
     */
    private String status;
}
