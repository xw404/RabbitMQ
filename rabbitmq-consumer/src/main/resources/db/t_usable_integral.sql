

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `t_usable_integral`;
CREATE TABLE t_usable_integral(
                                  `user_id` bigint(20) NOT NULL ,
                                  `gmt_created` datetime DEFAULT NULL,
                                  `gmt_modified` datetime DEFAULT NULL,
                                  `amount` bigint(20) DEFAULT NULL,
                                  `freezed_amount` bigint(20) DEFAULT NULL,
                                  PRIMARY KEY (`user_id`)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_usable_integral` VALUES ('13088889999', '2020-11-06 15:36:07', '2020-12-11 10:59:52', '500000', '0');