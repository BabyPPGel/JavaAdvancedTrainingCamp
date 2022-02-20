CREATE TABLE `javaadvancedtrainingcamp`.`tb_order_detail` (
  `id_order` VARCHAR(46) NOT NULL COMMENT '订单id',
  `id_product` VARCHAR(45) NULL COMMENT '商品编号',
  `product_name` VARCHAR(255) NULL COMMENT '商品名称',
  `product_price` DOUBLE NULL COMMENT '商品价格',
  `product_marque` VARCHAR(45) NULL COMMENT '商品型号',
  `product_store_barcode` VARCHAR(45) NULL COMMENT '商品条码',
  `discount_rate` DOUBLE NULL COMMENT '折扣比例',
  `discount_amout` DOUBLE NULL COMMENT '折扣金额',
  `number` INT NULL COMMENT '购买金额',
  `subtotal` DOUBLE NULL COMMENT '小计金额',
  `is_product_exists` VARCHAR(2) NULL DEFAULT '1' COMMENT '商品是否有效：0失效，1生效',
  `remark` VARCHAR(255) NULL COMMENT '客户备注')
COMMENT = '订单详情表';
