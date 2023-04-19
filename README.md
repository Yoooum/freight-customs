## Cargo表：货物表

| 列名 | 数据类型 | 约束条件 | 说明 |
| --- | --- | --- | --- |
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 主键，自增长 |
| name | VARCHAR(100) | NOT NULL | 货物名称 |
| quantity | INT | NOT NULL | 数量 |
| weight | DOUBLE | NOT NULL | 重量 |
| value | DOUBLE | NOT NULL | 价值 |
| destination | VARCHAR(100) | NOT NULL | 目的地 |
| status | VARCHAR(50) | NOT NULL | 状态 |

## Customer表：客户表

| 列名 | 数据类型 | 约束条件 | 说明 |
| --- | --- | --- | --- |
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 主键，自增长 |
| name | VARCHAR(100) | NOT NULL | 客户名称 |
| contact | VARCHAR(100) | NOT NULL | 客户联系方式 |

## Declaration表：报关单表

| 列名 | 数据类型 | 约束条件 | 说明 |
| --- | --- | --- | --- |
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 主键，自增长 |
| declaration_no | VARCHAR(100) | NOT NULL | 报关单号 |
| cargo_id | BIGINT | NOT NULL | 关联的货物id |
| declaration_time | DATETIME | NOT NULL | 报关时间 |
| status | VARCHAR(50) | NOT NULL | 状态 |

## Orders表：订单表

| 列名 | 数据类型 | 约束条件 | 说明 |
| --- | --- | --- | --- |
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 主键，自增长 |
| order_no | VARCHAR(100) | NOT NULL | 订单号 |
| customer_id | BIGINT | NOT NULL | 关联的客户id |
| cargo_id | BIGINT | NOT NULL | 关联的货物id |
| order_time | DATETIME | NOT NULL | 订单时间 |
| status | VARCHAR(50) | NOT NULL | 状态 |

## Process表：流程表

| 列名 | 数据类型 | 约束条件 | 说明 |
| --- | --- | --- | --- |
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 主键，自增长 |
| cargo_id | BIGINT | NOT NULL | 关联的货物id |
| operation_time | DATETIME | NOT NULL | 操作时间 |
| operator | VARCHAR(100) | NOT NULL | 操作人 |
| operation | VARCHAR(100) | NOT NULL | 操作类型 |
