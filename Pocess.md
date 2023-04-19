## 出关流程

假设我们要模拟一次完整的出关流程，包括以下步骤：

1. 创建一条货物记录

    ```sql
    INSERT INTO cargo(name, quantity, weight, value, destination, status) VALUES ('iPhone 13', 500, 300, 1000000, 'USA', 'PENDING');
    ```

2. 创建一条客户记录

    ```sql
    INSERT INTO customer(name, contact) VALUES ('John Doe', 'john.doe@example.com');
    ```

3. 将货物与客户关联

    ```sql
    UPDATE cargo SET customer_id = 1 WHERE id = 1;
    ```

4. 创建一条申报记录，将货物和申报关联

    ```sql
    INSERT INTO declaration(declaration_no, cargo_id, declaration_time, status) VALUES ('D20220418001', 1, '2022-04-18 10:00:00', 'PENDING');
    ```

5. 创建一条订单记录，将货物和订单关联

    ```sql
    INSERT INTO orders(order_no, cargo_id, order_time, status) VALUES ('O20220418001', 1, '2022-04-18 10:30:00', 'PENDING');
    ```

6. 创建一条处理记录，将货物和处理记录关联

    ```sql
    INSERT INTO process(cargo_id, operation_time, operator, operation) VALUES (1, '2022-04-18 11:00:00', 'Customs Officer', 'CLEARANCE');
    ```

7. 更新货物状态为已出关

    ```sql
    UPDATE cargo SET status = 'CLEARED' WHERE id = 1;
    ```



## 入关流程

假设我们需要模拟一次完整的货物入关流程，以下是一些可能需要执行的步骤：

1. 创建客户信息

    首先，我们需要创建一个客户信息以便将来使用。这可以通过向`Customer`表中插入一条记录来完成：
    
    ```
    INSERT INTO Customer(name, contact) VALUES('John Doe', 'john.doe@example.com');
    ```
    
    这将在`Customer`表中创建一条新的记录，表示一个名为"John Doe"的客户，联系方式为"[john.doe@example.com](mailto:john.doe@example.com)"。

2. 创建货物信息

    接下来，我们需要创建一个货物信息以便进行入关操作。这可以通过向`Cargo`表中插入一条记录来完成：
    
    ```
    INSERT INTO Cargo(name, quantity, weight, value, destination, status) 
    VALUES('Smartphone', 100, 150.0, 20000.0, 'China', 'Inbound');
    ```
    
    这将在`Cargo`表中创建一条新的记录，表示一个名为"Smartphone"的货物，数量为100，重量为150kg，价值为20000元人民币，目的地为"China"，状态为"Inbound"。

3. 创建报关信息

    在进行入关操作之前，需要创建报关信息。这可以通过向`Declaration`表中插入一条记录来完成：
    
    ```
    INSERT INTO Declaration(declarationNo, cargoId, declarationTime, status) 
    VALUES('2023001', 1, NOW(), 'Submitted');
    ```
    
    这将在`Declaration`表中创建一条新的记录，表示一个编号为"2023001"的报关单，对应的货物ID为1（上一步创建的货物），报关时间为当前时间，状态为"Submitted"。

4. 确认报关信息

    确认报关信息可以通过更新`Declaration`表中相应记录的状态来完成：
    
    ```
    UPDATE Declaration SET status = 'Accepted' WHERE id = 1;
    ```
    
    这将把刚刚创建的报关单的状态从"Submitted"更新为"Accepted"。

5. 创建订单信息

    完成报关操作之后，需要创建订单信息以便将来使用。这可以通过向`Orders`表中插入一条记录来完成：
    
    ```
    INSERT INTO Orders(orderNo, cargoId, orderTime, status) 
    VALUES('ORD001', 1, NOW(), 'Pending');
    ```
    
    这将在`Orders`表中创建一条新的记录，表示一个订单，对应的货物ID为1（上一步创建的货物），订单号为"ORD001"，下单时间为当前时间，状态为"Pending"。

6. 更新货物状态

    更新货物状态可以通过更新`Cargo`表中相应记录的状态来完成：
    
    ```
    UPDATE Cargo SET status = 'Pending' WHERE id = 1;
    ```
    
    这将把刚刚创建的货物的状态从"Inbound"更新为"Pending"。

7. 创建操作日志

    最后，我们需要在`Process`表中创建一条记录，表示货物入关操作的相关信息：
    
    ```
    INSERT INTO Process(cargoId, operationTime, operator, operation) 
    VALUES(1, NOW(), 'John Doe', 'Inbound');
    ```
    
    这个SQL语句可以向Process表中插入一条记录，表示货物入关的操作信息。其中，cargoId指的是相关货物的ID，operationTime指的是操作时间，operator指的是操作人员的姓名，operation则表示具体的操作类型，这里是"入关"。这样一来，我们就记录了货物入关的相关信息。同样，对于货物的出关操作，也可以使用类似的SQL语句向Process表中插入一条记录，以记录相关信息。
