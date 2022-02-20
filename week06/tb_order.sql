CREATE TABLE `javaadvancedtrainingcamp`.`tb_order` (
  `id_user` VARCHAR(45) NOT NULL COMMENT '用户id',
  `id_order` VARCHAR(45) NOT NULL,
  `order_amount` DOUBLE NULL COMMENT '订单金额',
  `order_status` NVARCHAR(2) NULL DEFAULT '1' COMMENT '是否生效‘1’生效\n‘0’失效',
  PRIMARY KEY (`id_order`))
COMMENT = '订单表';
