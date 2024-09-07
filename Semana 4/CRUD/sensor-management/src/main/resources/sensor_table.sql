create database if not exists sensor_management;

USE sensor_management;

drop table if exists sensors;

CREATE TABLE `sensors` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `sensor_name` VARCHAR(255) DEFAULT NULL,
    `sensor_type` VARCHAR(100) DEFAULT NULL,
    `status` VARCHAR(50) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `sensors` (`id`,`sensor_name`,`sensor_type`,`status`) VALUES (1,'multisense','camera', 'calibrated');
INSERT INTO `sensors` (`id`,`sensor_name`,`sensor_type`,`status`) VALUES (2,'velodyne','LiDAR', 'calibrated');
