package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("declaration")
public class Declaration {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String declarationNo;
    private Long CargoId;
    private LocalDateTime declarationTime;
    private String declarationType;
    private String status;
}
