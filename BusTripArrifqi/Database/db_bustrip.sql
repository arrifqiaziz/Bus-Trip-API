-- Adminer 4.8.1 MySQL 5.5.5-10.4.21-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `agency`;
CREATE TABLE `agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8y56hykf78k5u3wmutny52wcf` (`owner_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `agency`;
INSERT INTO `agency` (`id`, `code`, `details`, `name`, `owner_user_id`) VALUES
(3,	'BDM',	'PT HS Budiman',	'PO Budiman',	2),
(2,	'RSI',	'PT Rosalia Indah',	'PO Rosalia',	1),
(1,	'PJS',	'PT Primajasa Perdanaraya Utama',	'PO Primajasa',	1);

DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `make` varchar(255) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK64nil2xxuhqde813s57dp1n9t` (`agency_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `bus`;
INSERT INTO `bus` (`id`, `capacity`, `code`, `make`, `agency_id`) VALUES
(4,	40,	'SCANIA01',	'15',	2),
(3,	40,	'MERCEDES03',	'20',	1),
(2,	40,	'MERCEDES02',	'5',	1),
(1,	60,	'MERCEDES01',	'10',	1),
(5,	25,	'SCANIA02',	'10',	2),
(6,	25,	'HINO01',	'5',	3);

DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `flyway_schema_history`;
INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1,	'1',	'<< Flyway Baseline >>',	'BASELINE',	'<< Flyway Baseline >>',	NULL,	'root',	'2022-06-28 16:29:40',	0,	1),
(2,	'1.1',	'insert bus',	'SQL',	'V1.1__insert_bus.sql',	-323711555,	'root',	'2022-06-28 16:29:40',	6,	1),
(3,	'1.2',	'insert role',	'SQL',	'V1.2__insert_role.sql',	-555065487,	'root',	'2022-06-28 16:29:40',	3,	1),
(4,	'1.3',	'insert stop',	'SQL',	'V1.3__insert_stop.sql',	-297623919,	'root',	'2022-06-28 16:29:40',	3,	1),
(5,	'1.4',	'insert trip',	'SQL',	'V1.4__insert_trip.sql',	0,	'root',	'2022-06-28 16:29:40',	3,	1);

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `roles`;
INSERT INTO `roles` (`id`, `name`) VALUES
(1,	'ROLE_ADMIN'),
(2,	'ROLE_USER');

DROP TABLE IF EXISTS `stop`;
CREATE TABLE `stop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `stop`;
INSERT INTO `stop` (`id`, `code`, `detail`, `name`) VALUES
(5,	'BDG01',	'Terminal Leuwipanjang',	'Bandung'),
(4,	'BGR02',	'Terminal Baranangsiang',	'Bogor'),
(2,	'JKT02',	'Terminal Lebak Bulus',	'Jakarta'),
(3,	'BGR01',	'Terminal Leuwiliang',	'Bogor'),
(1,	'JKT01',	'Terminal KP Rambutan',	'Jakarta');

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cancellable` bit(1) DEFAULT NULL,
  `journey_date` varchar(255) DEFAULT NULL,
  `seat_number` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `trip_schedule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdvt57mcco3ogsosi97odw563o` (`user_id`),
  KEY `FKfhudhsxbslgtmbrbkd3uak4ha` (`trip_schedule_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `ticket`;
INSERT INTO `ticket` (`id`, `cancellable`, `journey_date`, `seat_number`, `user_id`, `trip_schedule_id`) VALUES
(1,	CONV('1', 2, 10) + 0,	'05-08-2022',	1,	1,	1),
(4,	CONV('1', 2, 10) + 0,	'14-07-2022',	14,	1,	4),
(3,	CONV('1', 2, 10) + 0,	'20-10-2022',	20,	3,	3),
(2,	CONV('1', 2, 10) + 0,	'23-10-2022',	5,	2,	2);

DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fare` int(11) NOT NULL,
  `journey_time` int(11) NOT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  `bus_id` bigint(20) DEFAULT NULL,
  `dest_stop_id` bigint(20) DEFAULT NULL,
  `source_stop_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKab03gksoo5t3lo12ga3ixnykk` (`agency_id`),
  KEY `FKptvi61dd1hao1yig3in0gvcjs` (`bus_id`),
  KEY `FK1evbxrekvflflkfscj2i0fwv0` (`dest_stop_id`),
  KEY `FK5ln8w8n974euslk976dh6x7k5` (`source_stop_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `trip`;
INSERT INTO `trip` (`id`, `fare`, `journey_time`, `agency_id`, `bus_id`, `dest_stop_id`, `source_stop_id`) VALUES
(1,	10000,	1,	1,	2,	2,	1),
(2,	50000,	4,	1,	1,	3,	1),
(3,	100000,	8,	3,	3,	5,	3),
(4,	15000,	2,	2,	6,	4,	3),
(5,	40000,	2,	3,	5,	4,	2),
(6,	75000,	6,	2,	4,	5,	4);

DROP TABLE IF EXISTS `trip_schedule`;
CREATE TABLE `trip_schedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_seats` int(11) NOT NULL,
  `trip_date` varchar(255) DEFAULT NULL,
  `trip_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaqjflucdvoypakmjxtb7n2mmm` (`trip_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `trip_schedule`;
INSERT INTO `trip_schedule` (`id`, `available_seats`, `trip_date`, `trip_id`) VALUES
(1,	35,	'05-08-2022',	1),
(2,	60,	'23-10-2022',	2),
(3,	20,	'20-10-2022',	3),
(4,	20,	'14-07-2022',	4),
(5,	15,	'15-11-2022',	5),
(6,	25,	'12-12-2022',	6);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `first_name` varchar(120) DEFAULT NULL,
  `last_name` varchar(120) DEFAULT NULL,
  `mobile_number` varchar(120) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `user`;
INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `mobile_number`, `password`, `username`) VALUES
(4,	'dessy@gmail.com',	'Dessy',	'Maryati',	'085714838979',	'$2a$10$lr7XLUx1uSf8bd8ryugTtu8n1DtCGRgqyEni5RIh0Ofh71hgcHqhO',	'dessy'),
(3,	'hoiri@gmail.com',	'Hoiri',	'Ardhiansyah',	'085711848322',	'$2a$10$krW9tf3llq4KBuUjwHdRfOBUiAvl4D4CCvbe.K0O/nn/1e9s/xpi6',	'hoiri'),
(2,	'fahmi@gmail.com',	'Fahmi',	'Syah Zubaidi',	'081298537807',	'$2a$10$f9vRrC9MX8SWsYl4vEpzjei4PXNMMiF17AezPJRW7X2yUvRtNbm6G',	'fahmi'),
(1,	'arrifqiaziz@gmail.com',	'Arrifqi Aziz',	'Ardhiansyah',	'082111178380',	'$2a$10$NvUWYtXdrO5OlhtnX8aF8.OGYyCr1WBflS1klFn5/ybnKS/JSHFqm',	'arrifqiaziz');

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

TRUNCATE `user_roles`;
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1,	1),
(2,	2),
(3,	2),
(4,	2);

-- 2022-07-04 18:07:32
