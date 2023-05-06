## 入关流程

入关流程如下：

1. 货物进入海关管辖区域，海关工作人员创建货物信息记录，插入cargo表中。

   ```sql
   INSERT INTO cargo(name, quantity, weight, value, destination, status) VALUES('货物名称', 10, 100.0, 1000.0, '目的地', '待申报');
   ```

2. 客户向海关申报货物，海关工作人员创建申报记录，插入declaration表中，并将对应货物记录的状态更新为“已申报”。

   ```sql
   INSERT INTO declaration(declaration_no, cargo_id, declaration_time, status) VALUES('申报单号', 1, NOW(), '已申报');
   UPDATE cargo SET status = '已申报' WHERE id = 1;
   ```

3. 客户下单并支付，订单信息被记录到orders表中，并将对应货物记录的状态更新为“待出库”。

   ```sql
   INSERT INTO orders(order_no, customer_id, cargo_id, order_time, status) VALUES('订单号', 1, 1, NOW(), '待出关');
   UPDATE cargo SET status = '待出关' WHERE id = 1;
   ```

4. 货物出关，海关工作人员创建出库操作记录，插入process表中，并将对应货物记录的状态更新为“已出关”。

   ```sql
   INSERT INTO process(cargo_id, operation_time, operator, operation) VALUES(1, NOW(), '出库操作人', '出库');
   UPDATE cargo SET status = '已出关' WHERE id = 1;
   ```

以上是简单的入关流程，实际流程可能会更复杂，需要根据实际情况进行设计和实现。


## 出关流程

出关流程通常包括以下步骤：

1. 查询需要出关的货物

   我们需要查询status为"待出关"的货物（若无此货物记录则先创建当前货物记录），并将其状态更新为"出关中"。可以使用以下SQL语句实现：
   
   ```sql
   UPDATE cargo SET status = '出关中' WHERE status = '待出关';
   SELECT * FROM cargo WHERE status = '出关中';
   ```

2. 审核报关单

   报关单需要审核才能通过出关。可以使用以下SQL语句更新报关单状态为"审核通过"：
   
   ```sql
   UPDATE declaration SET status = '审核通过' WHERE id = 1;
   ```

3. 更新出口订单状态-货物出关

   通过审核的货物需要生成出口订单。可以使用以下SQL语句创建订单：
   
   ```sql
   UPDATE orders SET status = '已出关' WHERE id = 1;
   ```

4. 更新出口订单状态-货物发货
   
   出口订单状态更新为"已发货"即可完成出关。可以使用以下SQL语句更新订单状态：
   
   ```sql
   UPDATE orders SET status = '已发货' WHERE id = 1;
   ```

5. 记录操作日志

   完成出关后，需要在操作日志中记录相应的操作。可以使用以下SQL语句创建操作日志：
   
   ```sql
   INSERT INTO process(cargo_id, operation_time, operator, operation)
   VALUES(1, NOW(), 'John Doe', '出关');
   ```
