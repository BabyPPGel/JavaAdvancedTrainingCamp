CREATE TABLE `javaadvancedtrainingcamp`.`tb_shopping_cart` (
  `id` INT NOT NULL COMMENT 'id',
  `user_id` INT NULL COMMENT '用户id',
  `product_id` VARCHAR(45) NULL COMMENT '商品id',
  `shop_id` VARCHAR(45) NULL COMMENT '店铺id',
  `is_priduct_exists` VARCHAR(2) NULL DEFAULT '1' COMMENT '商品是否有效：1有效，0无效',
  `number` INT NULL COMMENT '购买数量',
  `creat_time` VARCHAR(45) NULL COMMENT '创建时间',
  PRIMARY KEY (`id`))
COMMENT = '购物车信息表';