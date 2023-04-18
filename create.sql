create table cargo
(
    id          bigint auto_increment comment '货物单号'
        primary key,
    name        varchar(255) not null comment '货物名称',
    quantity    int          not null comment '货物数量',
    weight      double       not null comment '货物重量',
    destination varchar(255) not null comment '来源/目的地',
    status      varchar(255) not null comment '货物状态'
)
    comment '货物表';

create table customer
(
    id              bigint auto_increment comment '客户'
        primary key,
    name            varchar(255) not null comment '客户名称',
    contact         varchar(255) not null comment '联系方式',
    cargoid         bigint       not null comment '客户货物号(关联到Cargo表id)',
    declarationNoid varchar(255) not null comment '报关单编号(关联到declaration表declarationNo)'
)
    comment '客户表';

create table declaration
(
    id              bigint auto_increment comment 'id'
        primary key,
    declarationNo   varchar(255) not null comment '报关单编号',
    cargoId         bigint       null comment '关联到Cargo表的id',
    type            varchar(255) not null comment '报关类型(入/出)',
    declarationTime datetime     not null comment '报关时间',
    status          varchar(255) not null comment '报关状态'
)
    comment '报关单表';

