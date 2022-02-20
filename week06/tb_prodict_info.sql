CREATE TABLE `javaadvancedtrainingcamp`.`tb_prodict_info` (
  `id_product` VARCHAR(255) NOT NULL,
  `product_name` VARCHAR(255) NULL COMMENT '商品名称',
  `subtitle` VARCHAR(255) NULL COMMENT '副标题',
  `main_image` VARCHAR(500) NULL COMMENT '产品主图',
  `detail` TEXT NULL COMMENT '商品其他描述',
  `product_price` DECIMAL(20,2) NULL COMMENT '商品价格',
  `statues` VARCHAR(2) NULL COMMENT ' 商品状态,1-在售 2-下架 3-删除',
  `stock` INT(11) NULL COMMENT '库存数量',
  `creat_time` DATE NULL COMMENT '创建时间',
  `update_time` DATE NULL COMMENT '修改时间',
  PRIMARY KEY (`id_product`))
COMMENT = '商品信息表';