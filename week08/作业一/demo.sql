 select * from t_order where id_order='111';
  select * from t_order where id_order='112';
  update t_order set order_amount='300' where id_order='1138'
  update t_order set order_amount='500' where id_order='1139'
  delete from t_order where  id_order='110';
  delete from t_order where  id_order='110';
  insert into  tb_order (id_order,id_user,order_amount,order_status ) values ('20000', '203', '300','1');
  insert into  tb_order_0 (id_order,id_user,order_amount,order_status ) values ('22000', '200', '80','1');