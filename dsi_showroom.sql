-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2020 at 03:51 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dsi_showroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `v_id` int(11) NOT NULL,
  `v_type` varchar(255) NOT NULL,
  `model_no` varchar(255) NOT NULL,
  `engine_type` varchar(255) NOT NULL,
  `engine_power` varchar(255) NOT NULL,
  `tire_size` decimal(11,0) NOT NULL,
  `turbo` decimal(11,0) DEFAULT NULL,
  `weight` decimal(11,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`v_id`, `v_type`, `model_no`, `engine_type`, `engine_power`, `tire_size`, `turbo`, `weight`) VALUES
(1, 'Normal', 'fssf', 'Gas', '120hp', '25', NULL, NULL),
(2, 'Normal', 'dsdasd', 'Gas', '10', '15', NULL, NULL),
(4, 'Heavy', 'Heavy-xf1', 'Diesel', '1500gp', '30', NULL, '1500'),
(5, 'Heavy', 'Heay-001', 'Diesel', '1500 rmp', '30', NULL, '25000'),
(6, 'Normal', 'Normal-155', 'Diesel', '1660 rpm', '15', NULL, NULL),
(7, 'Sports', 'Sportsxfx-01', 'Oil', '2300 hp', '20', '125000', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`v_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `v_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
