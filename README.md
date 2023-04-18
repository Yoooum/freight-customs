### Cargo表：货物表

| 列名        | 数据类型     | 说明     |
| ----------- | ------------ | -------- |
| id          | bigint       | 自增主键 |
| name        | varchar(255) | 货物名称 |
| quantity    | int          | 货物数量 |
| weight      | double       | 货物重量 |
| value       | double       | 货物价值 |
| destination | varchar(255) | 目的地   |
| status      | varchar(255) | 状态     |

### Customer表：客户表

| 列名    | 数据类型     | 说明     |
| ------- | ------------ | -------- |
| id      | bigint       | 自增主键 |
| name    | varchar(255) | 客户名称 |
| contact | varchar(255) | 联系方式 |

### Declaration表：报关单表

| 列名            | 数据类型     | 说明                    |
| --------------- | ------------ | ----------------------- |
| id              | bigint       | 自增主键                |
| declarationNo   | varchar(255) | 报关单号                |
| cargoId         | bigint       | 关联到Cargo表的id |
| declarationTime | datetime     | 报关时间                |
| status          | varchar(255) | 报关状态                |

### Orders表：订单表

| 列名      | 数据类型     | 说明                    |
| --------- | ------------ | ----------------------- |
| id        | bigint       | 自增主键                |
| orderNo   | varchar(255) | 订单号                  |
| cargoId   | bigint       | 关联到Cargo表的id |
| orderTime | datetime     | 下单时间                |
| status    | varchar(255) | 订单状态                |

### Process表：流程表

| 列名          | 数据类型     | 说明                    |
| ------------- | ------------ | ----------------------- |
| id            | bigint       | 自增主键                |
| cargoId       | bigint       | 关联到Cargo表的id |
| operationTime | datetime     | 操作时间                |
| operator      | varchar(255) | 操作者                  |
| operation     | varchar(255) | 操作类型                |
