package com.prprv.customs.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回结果枚举类
 * @author phj233
 * @since 2023/4/23 9:43
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "系统内部异常"),
    BAD_REQUEST(4000, "请求参数不合法或缺失"),
    CARGO_NOT_FOUND(4001, "没有找到指定的货物"),
    CUSTOMER_NOT_FOUND(4002, "没有找到指定的客户"),
    DECLARATION_NOT_FOUND(4003, "没有找到指定的报关单"),
    ORDERS_NOT_FOUND(4004, "没有找到指定的订单"),
    PROCESS_NOT_FOUND(4005, "没有找到指定的操作记录"),
    DUPLICATE_DECLARATION(4006, "报关单已存在"),
    DUPLICATE_ORDERS(4007, "订单已存在"),
    CARGO_ALREADY_CLEARED(4008, "货物已经完成出关"),
    CARGO_ALREADY_INBOUND(4009, "货物已经完成入关"),
    INVALID_OPERATION(4010, "操作无效或不允许"),
    UNABLE_TO_UPDATE_STATUS(4011, "更新状态失败"),
    UNABLE_TO_CREATE_RECORD(4012, "创建记录失败"),
    UNABLE_TO_DELETE_RECORD(4013, "删除记录失败"),
    UNABLE_TO_RETRIEVE_DATA(4014, "获取数据失败"),
    DATABASE_ERROR(4015, "数据库错误");

    private final Integer code;
    private final String msg;
}
