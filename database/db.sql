--  数据库变量风格,表名或字段名中不要出现大写字母，单词之间用下划线 _  连接

DROP DATABASE IF EXISTS `ranger`;
CREATE DATABASE `ranger` DEFAULT CHARACTER SET utf8;
USE `ranger`;

DROP TABLE IF EXISTS `traffic_type`;
CREATE TABLE `traffic_type`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL DEFAULT "",
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`)
) DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(45) NOT NULL DEFAULT "",
    `father_id` BIGINT(20) NOT NULL DEFAULT 0,
    PRIMARY KEY(`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `angency`;
CREATE TABLE `angency`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `register_name` VARCHAR(45) NOT NULL DEFAULT "",
    `register_certifate_type` VARCHAR(45) NOT NULL DEFAULT "",
    `register_brief` VARCHAR(100) NOT NULL DEFAULT "",
    `phone` VARCHAR(45) NOT NULL DEFAULT "",
    `email` VARCHAR(45) NOT NULL DEFAULT "",
    `address` VARCHAR(100) NOT NULL DEFAULT "",
    `lincense_picture` VARCHAR(100) NOT NULL DEFAULT "",
    `balance` DOUBLE NOT NULL DEFAULT 0,
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bank_card`;
CREATE TABLE `bank_card`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `angency_id` BIGINT(20) NOT NULL,
    `owner` VARCHAR(45) NOT NULL DEFAULT "",
    `card_number` VARCHAR(45) NOT NULL DEFAULT "",
    `bank` VARCHAR(45) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`angency_id`) REFERENCES `angency`(`id`),
    INDEX(`angency_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL DEFAULT "",
    `summary` VARCHAR(100) NOT NULL DEFAULT "",
    `search_content` VARCHAR(300) NOT NULL DEFAULT "",
    `duration` INT NOT NULL DEFAULT 1,
    `supplier_id` BIGINT(20) NOT NULL,
    `setoff_location_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`supplier_id`) REFERENCES `angency`(`id`),
    FOREIGN KEY(`setoff_location_id`) REFERENCES `location`(`id`),
    INDEX(`supplier_id`),
    INDEX(`setoff_location_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trip_traffic`;
CREATE TABLE `trip_traffic`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `traffic_type_id` BIGINT(20) NOT NULL,
    `product_id` BIGINT(20) NOT NULL,
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    `is_expired` BOOLEAN NOT NULL DEFAULT 0,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`traffic_type_id`) REFERENCES `traffic_type`(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    INDEX(`traffic_type_id`),
    INDEX(`product_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trip_accomodation`;
CREATE TABLE `trip_accomodation`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_id` BIGINT(20) NOT NULL,
    `accomodation_type` VARCHAR(45) NOT NULL DEFAULT "",
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    `is_expired` BOOLEAN NOT NULL DEFAULT 0,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    INDEX(`product_id`)
)DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `trip_detail`;
CREATE TABLE `trip_detail`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL DEFAULT "",
    `content` TEXT,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `product_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    INDEX(`product_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trip_picture`;
CREATE TABLE `trip_picture`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `picture_path` VARCHAR(100) NOT NULL DEFAULT "",
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    `product_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    INDEX(`product_id`)
)DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `trip_destination`;
CREATE TABLE `trip_destination`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_id` BIGINT(20) NOT NULL,
    `location_id` BIGINT(20) NOT NULL,
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    FOREIGN KEY(`location_id`) REFERENCES `location`(`id`),
    INDEX(`product_id`),
    INDEX(`location_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_id` BIGINT(20) NOT NULL,
    `angency_id` BIGINT(20) NOT NULL,
    `collect_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    FOREIGN KEY(`angency_id`) REFERENCES `angency`(`id`),
    INDEX(`product_id`),
    INDEX(`angency_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `guide`;
CREATE TABLE `guide`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `angency_id` BIGINT(20) NOT NULL,
    `name` VARCHAR(45) NOT NULL DEFAULT "",
    `gender` BIT(1) NOT NULL DEFAULT 1,
    `phone` VARCHAR(45) NOT NULL DEFAULT "",
    `email` VARCHAR(45) NOT NULL DEFAULT "",
    `address` VARCHAR(200) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`angency_id`) REFERENCES `angency`(`id`),
    INDEX(`angency_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tourist_type`;
CREATE TABLE `tourist_type`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL DEFAULT "",
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trip_price`;
CREATE TABLE `trip_price`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_id` BIGINT(20) NOT NULL,
    `tourist_type_id` BIGINT(20) NOT NULL,
    `price` DOUBLE NOT NULL DEFAULT 0,
    `is_expired` BOOLEAN NOT NULL DEFAULT 0,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    FOREIGN KEY(`tourist_type_id`) REFERENCES `tourist_type`(`id`),
    INDEX(`product_id`),
    INDEX(`tourist_type_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trip_setoff`;
CREATE TABLE `trip_setoff`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `product_id` BIGINT(20) NOT NULL,
    `guide_id` BIGINT(20) NOT NULL,
    `trip_setoff_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`product_id`) REFERENCES `product`(`id`),
    FOREIGN KEY(`guide_id`) REFERENCES `guide`(`id`),
    INDEX(`product_id`),
    INDEX(`guide_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `buyer_id` BIGINT(20) NOT NULL,
    `trip_setoff_id` BIGINT(20) NOT NULL,
    `booker` VARCHAR(45) NOT NULL DEFAULT "",
    `booker_phone` VARCHAR(45) NOT NULL DEFAULT "",
    `booker_address` VARCHAR(45) NOT NULL DEFAULT "",
    `book_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `confirm_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `state` INT NOT NULL DEFAULT 0,
    `cost` DOUBLE NOT NULL DEFAULT 0,
    `deposit` DOUBLE NOT NULL DEFAULT 0,
    `confirm_list_buyer` VARCHAR(100) NOT NULL DEFAULT "",
    `confirm_list_supplier` VARCHAR(100) NOT NULL DEFAULT "",
    `contract_supplier` VARCHAR(100) NOT NULL DEFAULT "",
    `contract_buyer` VARCHAR(100) NOT NULL DEFAULT "",
    `invoice` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`buyer_id`) REFERENCES `angency`(`id`),
    FOREIGN KEY(`trip_setoff_id`) REFERENCES `trip_setoff`(`id`),
    INDEX(`buyer_id`),
    INDEX(`trip_setoff_id`)
)DEFAULT CHARSET=utf8;

-- confirm_list_buyer 购买者发出的确认单的链接(路径)
-- invoice 发票，deposit 订金

DROP TABLE IF EXISTS `orderform_tourist`;
CREATE TABLE `orderform_tourist`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `orderform_id` BIGINT(20) NOT NULL,
    `tourist_type_id` BIGINT(20) NOT NULL,
    `name` VARCHAR(45) NOT NULL DEFAULT "",
    `gender` BIT(1) NOT NULL DEFAULT 0,
    `phone` VARCHAR(45) NOT NULL DEFAULT "",
    `email` VARCHAR(45) NOT NULL DEFAULT "",
    `birth_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `certifate_type` VARCHAR(45) NOT NULL DEFAULT "",
    `certifate_number` VARCHAR(45) NOT NULL DEFAULT "",
    `state` INT NOT NULL DEFAULT 0,
    `remark` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`orderform_id`) REFERENCES `orderform`(`id`),
    FOREIGN KEY(`tourist_type_id`) REFERENCES `tourist_type`(`id`),
    INDEX(`orderform_id`),
    INDEX(`tourist_type_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `orderform_tourist_picture`;
CREATE TABLE `orderform_tourist_picture`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `orderform_tourist_id` BIGINT(20) NOT NULL,
    `picture_path` VARCHAR(100) NOT NULL DEFAULT "",
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`orderform_tourist_id`) REFERENCES `orderform_tourist`(`id`),
    INDEX(`orderform_tourist_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `orderform_id` BIGINT(20) NOT NULL,
    `content` TEXT,
    `generate_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `is_viewed` BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`orderform_id`) REFERENCES `orderform`(`id`),
    INDEX(`orderform_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `orderform_track`;
CREATE TABLE `orderform_track`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `orderform_id` BIGINT(20) NOT NULL,
    `track_item` VARCHAR(100) NOT NULL DEFAULT "",
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`orderform_id`) REFERENCES `orderform`(`id`),
    INDEX(`orderform_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `orderform_id` BIGINT NOT NULL,
    `message` VARCHAR(200) NOT NULL DEFAULT "",
    `state` INT NOT NULL DEFAULT 0,
    `supplier_id` BIGINT(20) NOT NULL,
    `buyer_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`orderform_id`) REFERENCES `orderform`(`id`),
    FOREIGN KEY(`supplier_id`) REFERENCES `angency`(`id`),
    FOREIGN KEY(`buyer_id`) REFERENCES `angency`(`id`),
    INDEX(`orderform_id`),
    INDEX(`supplier_id`),
    INDEX(`buyer_id`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `refund_picture`;
CREATE TABLE `refund_picture`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `refund_id` BIGINT(20) NOT NULL,
    `picture_path` VARCHAR(100) NOT NULL DEFAULT "",
    `brief` VARCHAR(100) NOT NULL DEFAULT "",
    PRIMARY KEY(`id`),
    FOREIGN KEY(`refund_id`) REFERENCES `refund`(`id`),
    INDEX(`refund_id`)
)DEFAULT CHARSET=utf8;

-- 2014 04 16

ALTER TABLE angency ADD password varchar(45) NOT NULL DEFAULT "";
ALTER TABLE angency ADD name varchar(45) NOT NULL DEFAULT "";

-- 2014 04 25

alter table notification add receiver_id bigint(20) not null;
alter table notification add foreign key (receiver_id) references angency(id);
create index index_receiver_id on notification(receiver_id);

-- 2015 05 02

ALTER TABLE product ADD postcode varchar(10) NOT NULL DEFAULT "";
ALTER TABLE product ADD post_receiver varchar(45) NOT NULL DEFAULT "";
ALTER TABLE product ADD post_address varchar(100) NOT NULL DEFAULT "";
ALTER TABLE product ADD post_phone varchar(45) NOT NULL DEFAULT "";

-- 2015 05 05

-- delete from location where father_id = 1;

insert into location(name, father_id) values('China', 0);

insert into location(name, father_id) values('United States', 0);

insert into location(name, father_id) values('Beijing', 2);

insert into location(name, father_id) values('HongKong', 2);

insert into location(name, father_id) values('Taiwan', 2);

insert into location(name, father_id) values('Singapore', 1);
update location set father_id = 0 where id = 7;

insert into location(name, father_id) values('California', 3);

insert into location(name, father_id) values('Macao', 2);


































--
