用户表：
CREATE TABLE `tb_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` BIGINT(20) NULL COMMENT '用户唯一id标识',
  `avatar_link` VARCHAR(55) NULL COMMENT '用户头像',
  `nickname` VARCHAR(45) NULL COMMENT '用户昵称',
  `mobile` VARCHAR(45) NULL COMMENT '用户手机号',
  `gender` TINYINT(4) NULL COMMENT '性别，1=男，2=女，3=保密',
  `birthday` BIGINT(20) NULL COMMENT '生日时间戳',
  `address` VARCHAR(256) NULL COMMENT '收货地址',
  `status` TINYINT(4) NULL COMMENT '用户状态，1=正常，2=冻结，3=注销',
  `create_time` BIGINT(20) NULL COMMENT '创建时间时间戳',
  `update_time` BIGINT(20) NULL COMMENT '更新时间时间戳',
  `delete_sign` TINYINT(4) NULL COMMENT '1=正常，2=逻辑删除',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '用户表';

商品表：
CREATE TABLE `tb_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_code` BIGINT(20) NULL COMMENT '商品编码',
  `product_name` VARCHAR(256) NULL COMMENT '商品名称',
  `price` DECIMAL(10,2) NULL COMMENT '商品价格',
  `product_desc` VARCHAR(512) NULL COMMENT '商品描述',
  `prodict_img_url` VARCHAR(128) NULL COMMENT '商品图片链接地址',
  `status` TINYINT(4) NULL COMMENT '1=待上架，2=上架，3=下架',
  `create_time` BIGINT(20) NULL COMMENT '创建时间时间戳',
  `update_time` BIGINT(20) NULL COMMENT '更新时间时间戳',
  `delete_sign` TINYINT(4) NULL COMMENT '1=正常，2=逻辑删除',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '商品表';

订单表：
CREATE TABLE `sojourn-md-test`.`tb_order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_no` BIGINT(20) NULL COMMENT '订单号',
  `user_id` BIGINT(20) NULL COMMENT '用户唯一标识',
  `address` VARCHAR(256) NULL COMMENT '收获地址',
  `mobile` VARCHAR(45) NULL COMMENT '用户收货手机号',
  `product_code` BIGINT(20) NULL COMMENT '商品编码',
  `price` DECIMAL(10,2) NULL COMMENT '商品价格',
  `product_quantity` INT(11) NULL COMMENT '商品数量',
  `order_amount` DECIMAL(10,2) NULL COMMENT '订单实付金额',
  `status` TINYINT(4) NULL COMMENT '1=待支付，2=已支付，3=配送中，4=已完成，5=已退货',
  `create_time` BIGINT(20) NULL COMMENT '创建时间时间戳',
  `update_time` BIGINT(20) NULL COMMENT '更新时间时间戳',
  `delete_sign` TINYINT(4) NULL COMMENT '1=正常，2=逻辑删除',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '订单表';
	

	
	
	
	
	
	