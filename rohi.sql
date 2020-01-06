-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 10, 2016 at 11:00 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rohi`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE IF NOT EXISTS `details` (
  `id` varchar(15) NOT NULL DEFAULT '',
  `surname` varchar(45) NOT NULL DEFAULT '',
  `other_names` varchar(50) NOT NULL DEFAULT '',
  `sex` varchar(7) NOT NULL DEFAULT '',
  `address` varchar(75) NOT NULL DEFAULT '',
  `occupation` varchar(45) NOT NULL DEFAULT '',
  `ethnic_group` varchar(20) NOT NULL DEFAULT '',
  `town` varchar(45) NOT NULL DEFAULT '',
  `dob` varchar(35) NOT NULL DEFAULT '',
  `nationality` varchar(45) NOT NULL DEFAULT '',
  `email` varchar(65) NOT NULL DEFAULT '',
  `phone_number` varchar(15) NOT NULL DEFAULT '',
  `religion` varchar(25) NOT NULL DEFAULT '',
  `civil_state` varchar(15) NOT NULL DEFAULT '',
  `next_of_kin` varchar(45) NOT NULL DEFAULT '',
  `next_of_kin_number` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`id`, `surname`, `other_names`, `sex`, `address`, `occupation`, `ethnic_group`, `town`, `dob`, `nationality`, `email`, `phone_number`, `religion`, `civil_state`, `next_of_kin`, `next_of_kin_number`) VALUES
('RS/01065', 'fatokimi', 'S.A', 'Male', 'Oda road Akure', 'civil servant', 'Yoruba', 'Akure', '5October1955', 'Nigerian', 'Fatokimisa@yahoo.com', '08034277423', 'christian', 'Married', 'Mrs. Fatokimi', '08034277423'),
('RS/02242', 'Adeyemi', 'Bukunola', 'Female', 'No. 2  Ademoagun street Akure', 'Student', 'Yoruba', 'Akure', '7April1993', 'Nigerian', 'AdeyemiBukun@yahoo.com', '08062463138', 'Christianity', 'Single', 'Mr. Adeyemi', '08062463138'),
('RS/07557', 'Adekola', 'Adetutu', 'Female', 'No. 2 Ireakari off Ibeke Orita', 'Civil Servant', 'Yoruba', 'Idanre', '1July1980', 'Nigerian', 'Adekola_tutu@yahoo.com', '08032632477', 'Christianity', 'Married', 'Mr. Adekola', '08032632477'),
('RS/08663', 'Baba', 'Abiodun', 'Male', 'No. 126 Oba adesida roada Akure', 'Banker', 'Yoruba', 'Kwara', '3February1970', 'Nigerian', 'Abiodun09@yahoo.com', '08055762600', 'Muslim', 'Married', 'Mrs. Fawziath Baba', '07052582727'),
('RS/11614', 'Amusa', 'Fatima', 'Female', '137 Alagbaka quarter Akure', 'Trader', 'Yoruba', 'Ijebu remo', '10October1966', 'Nigerian', 'Amusaf@yahoo.com', '08025908106', 'Muslim', 'Married', 'Mr. Lateef Amusa', '08025908106'),
('RS/15258', 'Jesujoba', 'Alabi', 'Female', 'Oyo', 'NYSC', 'Yoruba', 'OYo', '1January2016', 'Nigeria', 'ajesujoba@yahoo.com', '0706485826', 'Xtain', 'Single', 'Jola', '07064845805');

-- --------------------------------------------------------

--
-- Table structure for table `readings`
--

CREATE TABLE IF NOT EXISTS `readings` (
  `card_number` varchar(15) NOT NULL DEFAULT '',
  `blood_pressure` varchar(15) NOT NULL DEFAULT '',
  `pulse_rate` varchar(15) NOT NULL DEFAULT '',
  `respiration_rate` varchar(15) NOT NULL DEFAULT '',
  `temperature` varchar(15) NOT NULL DEFAULT '',
  `heart_rate` varchar(15) NOT NULL DEFAULT '',
  `report` text NOT NULL,
  `dateEntered` varchar(45) NOT NULL DEFAULT '',
  `timeEntered` varchar(45) NOT NULL DEFAULT '',
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `readings`
--

INSERT INTO `readings` (`card_number`, `blood_pressure`, `pulse_rate`, `respiration_rate`, `temperature`, `heart_rate`, `report`, `dateEntered`, `timeEntered`, `id`) VALUES
('12:11:20 AM', 'RS/08663', '110/90', '76', '66', '66', '45', 'good', '2016-01-18', 1),
('RS/08663', '110/90', '45', '44', '77', '65', 'weak', '2016-01-18', '12:15:13 AM', 2),
('RS/07557', '120/90', '87', '56', '43', '35', 'cool', '2016-01-18', '08:10:15 AM', 3),
('RS/07557', '150/66', '46', '55', '77', '36', 'NOT GOOD', '2016-01-18', '09:08:56 AM', 4),
('RS/02242', '110/70', '90', '20', '90', '36', 'patient seen, said to have fainted after being beaten by mother using a coil of wire', '2016-01-18', '09:47:16 AM', 5),
('RS/01065', '110/70', '78', '20', '78', '36.7', 'feels better, exercising regularly, has proper diet, had frantal headache.\nThe headcahe radiated to the back of the head.\nhas pores in the back, afebile not pale\n ', '2016-01-05', '03:42:37 PM', 6),
('RS/01065', '110/70', '78', '20', '78', '36.7', 'pcm II tds, \nlexotan 1.5mg nocte *4/7,\nneurogesic balm, \nmoduretic I daily  *2/52,\namlodipine 5mg daily *2/52,\nclapidodrel *2/52', '2016-01-05', '03:52:57 PM', 7),
('RS/11614', '100/70', '78', '20', '78', '37.8', 'high body temperature, cold, body and headache.\nc/o malaria and fever,\nplan: in diclophenac injection 75mg start,\nin antenatal injection 160mg daily *3/7,\ntab pcm IItds *3/7,\ntab b.co Itds *5/7,\ntab Vit. c  II tds *5/7,\ncap Amoxil  500mg tds*5/7\ntab laridox III start', '2016-01-12', '04:02:54 PM', 8),
('RS/15258', '12', '23', '22', '43', '13', 'HE is very ok', '2016-01-27', '09:06:55 AM', 9);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
