CREATE TABLE `javaadvancedtrainingcamp`.`tb_user_info` (
  `user_name` INT NULL COMMENT '用户姓名',
  `id_Card_Number` VARCHAR(45) NOT NULL COMMENT '身份证号码',
  `phone_number` VARCHAR(45) NULL COMMENT '电话号码',
  `user_address` VARCHAR(255) NULL COMMENT '地址',
  `user_sex` VARCHAR(10) NULL COMMENT '用户性别')
COMMENT = '用户信息表';
