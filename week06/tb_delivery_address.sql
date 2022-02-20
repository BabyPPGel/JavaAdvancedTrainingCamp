CREATE TABLE `javaadvancedtrainingcamp`.`tb_delivery_address` (
  `id_address` INT NOT NULL,
  `id_user` INT NULL COMMENT '用户id',
  `real_name` VARCHAR(255) NULL COMMENT '收货人姓名',
  `telphone` VARCHAR(45) NULL COMMENT '电话号码',
  `telphone_spare` VARCHAR(45) NULL COMMENT '备用联系电话',
  `address_country` VARCHAR(45) NULL COMMENT '国家',
  `address_province` VARCHAR(45) NULL COMMENT '省份',
  `address_city` VARCHAR(45) NULL COMMENT '城市',
  `address_area` VARCHAR(255) NULL COMMENT '地区',
  `address_street` VARCHAR(255) NULL COMMENT '街道',
  `is_default_address` VARCHAR(2) NULL COMMENT '是否默认收货地址',
  `creat_time` DATE NULL COMMENT '创建时间',
  PRIMARY KEY (`id_address`))
COMMENT = '收货地址表';