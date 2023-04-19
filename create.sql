-- 创建货物表
CREATE TABLE cargo (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  quantity INT NOT NULL,
  weight DOUBLE NOT NULL,
  value DOUBLE NOT NULL,
  destination VARCHAR(100) NOT NULL,
  status VARCHAR(50) NOT NULL
);

-- 创建客户表
CREATE TABLE customer (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  contact VARCHAR(100) NOT NULL
);

-- 创建报关单表
CREATE TABLE declaration (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  declaration_no VARCHAR(100) NOT NULL,
  cargo_id BIGINT NOT NULL,
  declaration_time DATETIME NOT NULL,
  status VARCHAR(50) NOT NULL
);

-- 创建订单表
CREATE TABLE orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_no VARCHAR(100) NOT NULL,
  customer_id BIGINT NOT NULL,
  cargo_id BIGINT NOT NULL,
  order_time DATETIME NOT NULL,
  status VARCHAR(50) NOT NULL
);

-- 创建流程表
CREATE TABLE process (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  cargo_id BIGINT NOT NULL,
  operation_time DATETIME NOT NULL,
  operator VARCHAR(100) NOT NULL,
  operation VARCHAR(100) NOT NULL
);
