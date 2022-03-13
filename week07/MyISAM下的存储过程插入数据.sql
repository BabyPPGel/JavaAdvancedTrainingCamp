 ALTER TABLE tb_order_detail ENGINE = MYISAM;
 DROP PROCEDURE tb_order_detail.BatchInsert IF EXISTS;
 delimiter //
 CREATE PROCEDURE BatchInsert(IN start INT,IN loop_time INT)
  BEGIN
      DECLARE Var INT;
      DECLARE ID INT;
      SET Var = 0;
      SET ID= start;
      WHILE Var < loop_time DO
           insert into  tb_order_detail (id_order,product_name,product_price,product_marque) values (ID, CONCAT('棉花', ID), CONCAT('55', ID),'j66'); 
          SET Var = Var + 1;
          SET ID= ID + 1;
      END WHILE;
  END;
 delimiter ;
 
 ALTER TABLE tb_order_detail DISABLE KEYS;
 CALL BatchInsert(1, 100000);
 ALTER TABLE tb_order_detail ENABLE KEYS;