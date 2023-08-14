-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2021 at 08:02 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `se201`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `bankovni_racun` varchar(30) NOT NULL,
  `adresa` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `username`, `password`, `bankovni_racun`, `adresa`) VALUES
(1, 'bokica', 'boki876', '1234567893587945', 'Dositeja Obradovica 6'),
(2, 'foxmulder', 'trustn01', '9633322478515598', 'Vuka Karadzica 18'),
(3, 'danascully', 'alien123', '9998852478811658', 'Georgija Jaksica 12'),
(6, 'johnmcclane', 'diehard1', '6663332247123456', 'Svetosavska 23'),
(7, 'tonystark', 'ironman12', '8885559777456328', 'Marsala Tita 45');

-- --------------------------------------------------------

--
-- Table structure for table `objekat`
--

CREATE TABLE `objekat` (
  `id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `adresa` varchar(30) NOT NULL,
  `grad` varchar(30) NOT NULL,
  `tip` varchar(50) NOT NULL,
  `kapacitet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `objekat`
--

INSERT INTO `objekat` (`id`, `naziv`, `adresa`, `grad`, `tip`, `kapacitet`) VALUES
(1, 'O2', '42nd Street', 'London', 'Koncertna hala', 100),
(2, 'Mercedes-Benz Arena', 'Stephaplatz 13', 'Berlin', 'Koncertna hala', 80),
(3, 'T-Mobile Arena', 'Maria HilferStrase 2', 'Bec', 'Koncertna hala', 120),
(4, 'Cineplexx', 'Gospodara Vucica 12', 'Beograd', 'bioskop', 120),
(5, 'Atelje 212', 'Svetogorska 21', 'Beograd', 'pozoriste', 60),
(6, 'Narodno pozoriste', 'Francuska 3', 'Beograd', 'pozoriste', 90),
(7, 'Cineplexx BIG', 'Visnjicka 84', 'Beograd', 'Bioskop', 150),
(8, 'Stark Arena', 'Arsenija Cranojevica 58', 'Beograd', 'Koncertna hala', 200);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id` int(11) NOT NULL,
  `id_korisnik` int(11) NOT NULL,
  `id_objekat` int(11) NOT NULL,
  `vreme` varchar(5) NOT NULL,
  `brojSediste` int(11) NOT NULL,
  `metodPlacanja` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id`, `id_korisnik`, `id_objekat`, `vreme`, `brojSediste`, `metodPlacanja`) VALUES
(1, 2, 3, '16:30', 9, 'Visa'),
(2, 1, 4, '20:00', 7, 'Visa'),
(3, 4, 4, '19:45', 3, 'Visa'),
(4, 6, 6, '10:15', 15, 'PayPal'),
(5, 5, 8, '21:00', 16, 'PayPal'),
(6, 3, 7, '12:00', 22, 'Visa'),
(7, 5, 2, '17:50', 27, 'Visa'),
(8, 4, 3, '21:00', 4, 'PayPal'),
(9, 5, 4, '17:15', 8, 'PayPal'),
(10, 7, 8, '20:40', 29, 'Visa'),
(11, 6, 6, '11:15', 27, 'PayPal'),
(12, 5, 4, '22:40', 13, 'PayPal'),
(13, 1, 1, '20:20', 25, 'Visa'),
(14, 2, 2, '20:40', 8, 'Visa'),
(15, 4, 6, '22:25', 3, 'PayPal'),
(16, 4, 9, '11:45', 28, 'Visa'),
(17, 1, 1, '23:00', 7, 'Visa'),
(18, 3, 8, '19:00', 12, 'Visa'),
(19, 3, 2, '22:35', 17, 'PayPal'),
(20, 6, 1, '08:30', 26, 'Visa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `objekat`
--
ALTER TABLE `objekat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `objekat`
--
ALTER TABLE `objekat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
