
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order_info
-- ----------------------------
DROP TABLE IF EXISTS `t_order_info`;
CREATE TABLE `t_order_info` (
                                order_no varchar(50) NOT NULL,
                                user_id bigint(20) DEFAULT NULL,
                                product_id bigint(20) DEFAULT NULL,
                                product_img varchar(255) DEFAULT NULL,
                                delivery_addr_id bigint(20) DEFAULT '-1',
                                product_name varchar(16) DEFAULT NULL,
                                product_count int(11) DEFAULT NULL,
                                product_price decimal(10,2) DEFAULT NULL,
                                seckill_price decimal(10,2) DEFAULT NULL,
                                status tinyint(4) DEFAULT NULL,
                                create_date datetime DEFAULT NULL,
                                pay_date datetime DEFAULT NULL,
                                seckill_date date DEFAULT NULL,
                                seckill_time int(11) DEFAULT NULL,
                                intergral decimal(10,0) DEFAULT NULL,
                                seckill_id bigint(20) DEFAULT NULL,
                                pay_type tinyint(4) DEFAULT '-1',
                                PRIMARY KEY (order_no),
                                UNIQUE KEY seckill_unique (user_id,seckill_id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_info
-- ----------------------------
INSERT INTO `t_order_info` VALUES ('1336557511364313088', '13088889999', '26', '/img/p4.jpg', null, '玉翊 新疆和田玉', '1', '1399.00', '899.00', '1', '2020-12-09 14:25:17', '2020-12-11 10:13:05', '2020-12-05', '10', '8991', '5', '1');
INSERT INTO `t_order_info` VALUES ('1336594359973314560', '13088889999', '24', '/img/p2.jpg', null, 'VAIO 11代新品笔记本', '1', '4999.00', '2999.00', '1', '2020-12-09 16:51:43', '2020-12-09 08:53:51', '2020-12-05', '10', '29990', '3', '1');
