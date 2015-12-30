-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2015 at 11:22 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_restaurant_shreedhar`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotel_timings`
--

CREATE TABLE IF NOT EXISTS `hotel_timings` (
  `htl_tmng_id` int(11) NOT NULL AUTO_INCREMENT,
  `rstnt_id` int(11) NOT NULL,
  `day` varchar(20) DEFAULT NULL,
  `strt_time` time NOT NULL DEFAULT '00:00:00',
  `end_time` time NOT NULL DEFAULT '00:00:00',
  PRIMARY KEY (`htl_tmng_id`),
  KEY `rstnt_id` (`rstnt_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `hotel_timings`
--

INSERT INTO `hotel_timings` (`htl_tmng_id`, `rstnt_id`, `day`, `strt_time`, `end_time`) VALUES
(1, 1, 'monday', '18:30:00', '23:30:00'),
(2, 1, 'tuesday', '18:30:00', '23:30:00'),
(3, 1, 'wednesday', '18:30:00', '23:30:00'),
(4, 1, 'thursday', '18:30:00', '23:30:00'),
(5, 1, 'friday', '18:30:00', '23:30:00'),
(6, 1, 'saturday', '04:00:00', '23:30:00'),
(7, 1, 'sunday', '04:00:00', '23:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `confirmation_id` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `active` int(1) NOT NULL DEFAULT '1',
  `table_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `confirmation_id` (`confirmation_id`),
  KEY `date` (`date`),
  KEY `email_id` (`email_id`),
  KEY `table_id` (`table_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`id`, `confirmation_id`, `date`, `start_time`, `end_time`, `email_id`, `active`, `table_id`) VALUES
(1, '456465465', '2015-12-23', '16:30:00', '20:00:00', 'kc.sridhar@gmail.com', 1, 1),
(2, '45645645', '2015-12-25', '16:00:00', '16:30:00', 'neha@gmail.com', 1, 2),
(3, 'eb4c68bc-a279-4e73-aa71-616bb58d6d2f', '2015-12-24', '06:30:00', '07:30:00', 'kc.sridhar@gmail.com', 1, 1),
(4, 'ead509f2-9acb-4617-a12a-1fcf46c28c82', '2015-12-23', '06:30:00', '07:30:00', 'skc382@nyu.edu', 1, 1),
(5, '528c23f9-d544-4430-832b-9c9dac0c779f', '2015-12-23', '06:30:00', '07:30:00', 'skc382@nyu.edu', 1, 2),
(6, 'c5f39d96-b2f5-4121-9926-4f0b28c4dd5b', '2015-12-29', '14:01:00', '15:01:00', 'blah@nyu.edu', 1, 2),
(7, '2e17e929-77fe-4824-afb8-56ec0e6801ce', '2015-12-30', '15:00:00', '17:00:00', 'boo@nyu.edu', 1, 2),
(8, 'eda0cbfb-089d-4af5-86ad-8806e69d4ad6', '2015-12-28', '14:01:00', '15:01:00', 'bow@bow.com', 1, 2),
(9, 'e2cff3a3-cd0f-4465-8a96-0f1c0a4acb7e', '2015-12-29', '19:00:00', '20:01:00', 'beep@beep.edu', 1, 2),
(10, 'f7bab824-4463-42df-8e46-c8bf9dee22d5', '2015-12-30', '17:01:00', '18:01:00', 'kaw@beep.com', 1, 2),
(11, 'a4424855-950c-43ac-b753-899a01be36ad', '2015-12-29', '02:02:00', '02:01:00', 'asd@fds', 1, 2),
(12, 'd2b4c0a2-95e3-4739-833c-a16760d0242a', '2015-12-29', '02:01:00', '02:01:00', 'dfg@dsfsd', 1, 2),
(13, '8f7b5399-85c7-4679-8c79-08a11cfb4d86', '2016-01-05', '14:01:00', '14:30:00', 'jkl@kjl', 1, 2),
(14, '80db101c-c516-4e11-abef-598735ed1a3b', '2016-01-04', '04:02:00', '05:01:00', 'asd@adw', 1, 2),
(15, '79c2ebea-3adf-4122-b472-1114af5386a8', '2016-01-04', '14:01:00', '14:01:00', 'jksajk@kjhshdjk', 1, 2),
(16, '0e554553-1f3b-4a08-b317-02fa3b983e46', '2015-12-30', '15:01:00', '14:01:00', 'asdw@sgsg', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_details`
--

CREATE TABLE IF NOT EXISTS `restaurant_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `restaurant_details`
--

INSERT INTO `restaurant_details` (`id`, `name`, `description`, `phone`) VALUES
(1, 'Shreedhar_Restaurant', 'We welcome you to a delicious feast of exquisite dishes in Star line.\r\n<br> With a wide range of world cuisines to choose from, we guarantee you a sumptuous feast experience in our restaurant.', '1002003001');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_table`
--

CREATE TABLE IF NOT EXISTS `restaurant_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shape` varchar(10) NOT NULL,
  `seating_size` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `restaurant_table`
--

INSERT INTO `restaurant_table` (`id`, `shape`, `seating_size`) VALUES
(1, 'round', 2),
(2, 'square', 6),
(3, 'round', 10),
(4, 'round', 15);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `email_id` varchar(30) NOT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) NOT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT 'USER',
  PRIMARY KEY (`email_id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email_id`, `Password`, `user_name`, `Phone`, `user_type`) VALUES
('asd@adw', NULL, 'asd', '3562722353', NULL),
('asd@fds', NULL, 'asd', '2343251511', NULL),
('asdw@sgsg', NULL, 'asd', '3245325255', NULL),
('beep@beep.edu', NULL, 'beep beep', '5456412122', NULL),
('blah@nyu.edu', NULL, 'neha', '6456556565', NULL),
('boo@nyu.edu', NULL, 'boo boo', '4566456555', NULL),
('bow@bow.com', NULL, 'bow bow', '4654565465', NULL),
('dfg@dsfsd', NULL, 'fdg', '4534534534', NULL),
('jkl@kjl', NULL, 'jkl', '5745545742', NULL),
('jksajk@kjhshdjk', NULL, 'sdjj', '5426453465', NULL),
('kaw@beep.com', NULL, 'kaw kaw', '5412535265', NULL),
('kc.sridhar@gmail.com', 'blahblah', 'shreedhar', '862001222', 'ADMIN'),
('neha@gmail.com', 'passwor', 'neha', '45685556', 'USER'),
('skc382@nyu.edu', 'password', 'FirstUSerHIbernate', '1236545', 'ADMIN');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hotel_timings`
--
ALTER TABLE `hotel_timings`
  ADD CONSTRAINT `hotel_timings_ibfk_1` FOREIGN KEY (`rstnt_id`) REFERENCES `restaurant_details` (`id`);

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `user` (`email_id`),
  ADD CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`table_id`) REFERENCES `restaurant_table` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
