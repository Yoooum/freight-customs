create table cargo
(
    id          bigint auto_increment
        primary key,
    name        varchar(255) null,
    quantity    int          null,
    weight      double       null,
    value       double       null,
    destination varchar(255) null,
    status      varchar(255) null
);

create table customer
(
    id      bigint auto_increment
        primary key,
    name    varchar(255) null,
    contact varchar(255) null
);

create table declaration
(
    id               bigint auto_increment
        primary key,
    declaration_no   varchar(255) null,
    cargo_id         bigint       null,
    declaration_time datetime     null,
    declaration_type varchar(50)  null,
    status           varchar(255) null
);

create table orders
(
    id         bigint auto_increment
        primary key,
    order_no   varchar(255) null,
    cargo_id   bigint       null,
    order_time datetime     null,
    status     varchar(255) null
);

create table process
(
    id             bigint auto_increment
        primary key,
    cargo_id       bigint       null,
    operation_time datetime     null,
    operator       varchar(255) null,
    operation      varchar(255) null
);

