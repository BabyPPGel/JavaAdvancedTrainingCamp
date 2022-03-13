 delimiter //   -- 把界定符改成双斜杠
 CREATE PROCEDURE BatchInsert(IN init INT, IN loop_time INT)  -- 第一个参数为初始ID号（可自定义），第二个位生成MySQL记录个数
  BEGIN
      DECLARE Var INT;
      DECLARE ID INT;
      SET Var = 0;
      SET ID = init;
      WHILE Var < loop_time DO
          insert into  tb_order_detail (id_order,product_name,product_price,product_marque) values (ID, CONCAT('水杯', ID), CONCAT('55', ID),'j66');
          SET ID = ID + 1;
          SET Var = Var + 1;
      END WHILE;
  END;


CALL BatchInsert(1, 10000);   -- 调用存储过程插入函数