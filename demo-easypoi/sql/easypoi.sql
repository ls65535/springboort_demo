/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.26 : Database - easypoi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easypoi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easypoi`;

/*Table structure for table `tb_item` */

DROP TABLE IF EXISTS `tb_item`;

CREATE TABLE `tb_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `sell_point` varchar(500) DEFAULT NULL COMMENT '商品卖点',
  `price` decimal(20,2) NOT NULL COMMENT '商品价格，单位为：分',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `barcode` varchar(30) DEFAULT NULL COMMENT '商品条形码',
  `image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `cid` bigint(10) NOT NULL COMMENT '所属类目，叶子类目',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `status` (`status`),
  KEY `updated` (`updated`),
  KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='商品表';

/*Data for the table `tb_item` */

insert  into `tb_item`(`id`,`title`,`sell_point`,`price`,`num`,`brand`,`barcode`,`image`,`cid`,`status`,`created`,`updated`) values (1,'联想电脑','清仓！仅北京，武汉仓有货！','5000.99',500,'联想',NULL,'http://image.jt.com/jd/4ef8861cf6854de9889f3db9b24dc371.jpg',5,1,'2015-03-08 21:33:18','2015-03-08 21:33:18'),(2,'三星S8','下单送12000毫安移动电源！双3.5英寸魔焕炫屏，以非凡视野纵观天下时局，尊崇翻盖设计，张弛中，尽显从容气度！','5999.66',500,'三星',NULL,'http://image.jt.com/images/1.jpg,http://image.jt.com/images/2.jpg,http://image.jt.com/images/3.jpg,http://image.jt.com/images/4.jpg,http://image.jt.com/images/5.jpg',3,1,'2015-03-08 21:27:54','2015-03-08 21:27:54'),(3,'三星S10','下单即送10400毫安移动电源！再赠手机魔法盒！','7000.00',10,'三星',NULL,'http://image.jt.com/jd/c1775819c7e44b1c903f27514e70b998.jpg',3,1,'2015-03-08 21:29:27','2015-03-08 21:29:27'),(4,'华为P20','经典回顾！超值价格值得拥有。','3000.00',99,'华为',NULL,'http://image.jt.com/jd/089b79cbe19f454dab24cce65f2e9602.jpg',3,1,'2015-03-08 21:28:16','2015-03-08 21:28:16'),(5,'华为P20Pro','下单赠12000毫安移动电源','36670.99',5000,'华为',NULL,'http://image.jt.com/jd/29e1b92dc7e146489ce46a2262479a0f.jpg',3,1,'2015-03-08 21:28:30','2015-03-08 21:28:30'),(6,'华为meat30','经典回顾！超值特惠！','6000.55',6,'华为',NULL,'http://image.jt.com/jd/5a45e88aeca046ec88d7b7ffbc47092a.jpg',3,1,'2015-03-08 21:28:44','2015-03-08 21:28:44'),(7,'小米8','要好屏，选夏普！日本原装面板，智能电视，高画质高音质！<a  target=\"blank\"  href=\"http://item.jd.com/1278686.html\">还有升级版安卓智能新机46DS52供您选择！</','2999.99',100,'小米',NULL,'http://image.jt.com/jd/2e45ff47f2e7424cb6d95fb9f05151bd.jpg',3,1,'2015-03-08 21:27:39','2015-03-08 21:27:39'),(8,'苹果11','4G 最近机','8999.99',999,'苹果',NULL,'http：///tett',3,1,'2019-10-13 17:53:55','2019-10-13 17:53:58'),(19,'奔驰s400','双排气','666666.99',5,'奔驰',NULL,'https://www.mercedes-benz.com.cn/?smtid=570962679z32cmz2dt02z1pdz0z',6,1,'2019-10-21 14:27:46',NULL);

/*Table structure for table `user_tab` */

DROP TABLE IF EXISTS `user_tab`;

CREATE TABLE `user_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_tab` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
