-- 创建货物表
CREATE TABLE cargo (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  quantity INT,
  weight DOUBLE,
  value DOUBLE,
  destination VARCHAR(255),
  status VARCHAR(255),
  PRIMARY KEY (id)
);

-- 创建客户表
CREATE TABLE customer (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  contact VARCHAR(255),
  PRIMARY KEY (id)
);

-- 创建报关单表
CREATE TABLE declaration (
  id BIGINT NOT NULL AUTO_INCREMENT,
  declaration_no VARCHAR(255),
  cargo_id BIGINT,
  declaration_time DATETIME,
  status VARCHAR(255),
  PRIMARY KEY (id)
);

-- 创建订单表
CREATE TABLE orders (
  id BIGINT NOT NULL AUTO_INCREMENT,
  order_no VARCHAR(255),
  cargo_id BIGINT,
  order_time DATETIME,
  status VARCHAR(255),
  PRIMARY KEY (id)
);

-- 创建流程表
CREATE TABLE process (
  id BIGINT NOT NULL AUTO_INCREMENT,
  cargo_id BIGINT,
  operation_time DATETIME,
  operator VARCHAR(255),
  operation VARCHAR(255),
  PRIMARY KEY (id)
);
