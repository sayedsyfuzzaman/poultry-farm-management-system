# Host: localhost  (Version 5.5.5-10.1.9-MariaDB)
# Date: 2020-05-18 10:56:58
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "customer"
#

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `purchase` double(15,2) DEFAULT '0.00',
  `paid_balance` double(15,2) DEFAULT '0.00',
  `balance` double(15,2) DEFAULT '0.00',
  `date` datetime DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "customer"
#


#
# Structure for table "customer_log"
#

DROP TABLE IF EXISTS `customer_log`;
CREATE TABLE `customer_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `memo_no` int(11) DEFAULT NULL,
  `pre_balance` double(15,2) DEFAULT '0.00',
  `purchase` double(15,2) DEFAULT '0.00',
  `paid_balance` double(15,2) DEFAULT '0.00',
  `balance` double(15,2) DEFAULT '0.00',
  `date` datetime DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "customer_log"
#


#
# Structure for table "death_record"
#

DROP TABLE IF EXISTS `death_record`;
CREATE TABLE `death_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_no` varchar(255) DEFAULT NULL,
  `pre_quantity` int(11) DEFAULT NULL,
  `dead` int(11) DEFAULT NULL,
  `current_quantity` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "death_record"
#


#
# Structure for table "expenses"
#

DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_no` varchar(255) DEFAULT NULL,
  `amount` double(15,2) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "expenses"
#


#
# Structure for table "memo"
#

DROP TABLE IF EXISTS `memo`;
CREATE TABLE `memo` (
  `memo_no` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `total_weight` double(15,2) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `total_price` double(15,2) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`memo_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "memo"
#


#
# Structure for table "sale_log"
#

DROP TABLE IF EXISTS `sale_log`;
CREATE TABLE `sale_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `memo_no` int(11) DEFAULT NULL,
  `stock_no` varchar(255) DEFAULT NULL,
  `unit_price` double(15,2) DEFAULT '0.00',
  `weight` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double(15,2) DEFAULT '0.00',
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sale_log"
#


#
# Structure for table "stocks"
#

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE `stocks` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_no` varchar(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT '0',
  `total_dead` int(11) DEFAULT '0',
  `sale_quantity` int(11) DEFAULT '0',
  `current_quantity` int(11) DEFAULT '0',
  `cost_price` double(15,2) DEFAULT NULL,
  `sale_price` double(15,2) DEFAULT '0.00',
  `expense` double(15,2) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "stocks"
#


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'Sayed','01521347439','employee','employee','Dhaka',2),(2,'Syfuzzaman','01783149316','authority','authority','Dhaka',1);
