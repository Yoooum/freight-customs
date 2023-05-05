package com.prprv.customs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 客户实体类
 * @author Yoooum
 */
@Data
@AllArgsConstructor
@TableName("customer")
public class Customer {
    /**
     * 客户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户联系方式
     */
    private String contact;
}
