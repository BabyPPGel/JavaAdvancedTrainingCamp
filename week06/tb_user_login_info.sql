CREATE TABLE `tb_user_login_info` (
  `id` int NOT NULL,
  `login_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `login_nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `login_password` varchar(45) DEFAULT NULL COMMENT '密码',
  `id_Card_Number` varchar(45) DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户登录信息表'