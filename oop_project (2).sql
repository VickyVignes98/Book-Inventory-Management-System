-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2019 at 03:00 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int(4) NOT NULL,
  `price (RM)` float NOT NULL,
  `store_location` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `year` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`, `quantity`, `price (RM)`, `store_location`, `author`, `publisher`, `category`, `year`) VALUES
(0, 'Hingga Akhir Nafasku', 20, 28, 'Kuantan', 'Hanah Rishas', 'Penulisan2U', 'Novel', 2019),
(1, 'GUINNESS WORLD RECORDS 2020', 15, 109.9, 'Gambang', 'Guinness World Records', 'Guinness World Records', 'Yearbook,Reference', 2019),
(2, 'Doctor Sleep (MTI)', 20, 42.9, 'Pekan', 'Stephen King', 'Charles Scribner\'s Sons', 'Horror fiction, Suspense, Paranormal fiction', 2013),
(3, 'Lawak Kampus Kompilasi Mantap', 10, 22.43, 'Pekan', 'Keith', 'Gempak Starz', 'Comics', 2011),
(4, 'Geronimo Stilton #52 ', 15, 15, 'Kuantan', 'Stilton,Geronimo', 'Scholastic Inc', 'Character Stories', 2014),
(5, 'Great Expectations', 10, 24.95, 'Gambang', 'Dickens,Charles', 'Penguin Books Ltd', 'Fiction Classic', 2019),
(6, 'Illustrated Robin Hood ', 13, 39.9, 'Gambang', 'Jones,Rob llod', 'Usborne', 'Children Classics', 2011),
(7, '  GET SMART PLUS 4 WORKBOOK', 43, 17, 'Kuantan', 'Pan Asia', 'Paperpack', 'Reference,Study', 2013),
(8, 'Master Your Motivation', 14, 77.9, 'Gambang', 'Susan Fowler', 'Random House', 'Psychology', 2019);

-- --------------------------------------------------------

--
-- Table structure for table `stationery`
--

CREATE TABLE `stationery` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price (RM)` float NOT NULL,
  `store_location` varchar(50) NOT NULL,
  `type` varchar(30) NOT NULL,
  `manufacturer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stationery`
--

INSERT INTO `stationery` (`id`, `name`, `quantity`, `price (RM)`, `store_location`, `type`, `manufacturer`) VALUES
(0, 'Staedtler Luna Coloured Pencils - 12 Colours', 30, 7.9, 'Gambang', 'Colour pencils', 'Staedtler'),
(1, '  Artline 90/10 Permanent Market - 10 Colour/Set', 100, 30, 'Kuantan', 'Marker Pens', 'Artline'),
(2, 'Faber Castell marker Value Pack A2  ', 25, 4.62, 'Pekan', 'Permanent Markers', 'Faber Castell'),
(3, 'Stabilo Colour Pencils-24 Pieces', 40, 32, 'Pekan', 'Colour Pencils', 'Stabilo'),
(4, 'Inky Robots Jotter', 24, 12.9, 'Gambang', 'Notebooks', 'INKY'),
(5, 'Faber Castell Needle Grip Mechanical Pencil Set ', 120, 4.4, 'Gambang', 'Mechanical Pencil', 'Faber Castell');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'vignes', 'vignes1234'),
(2, 'alif', 'alif1234'),
(3, 'amira', 'amira1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stationery`
--
ALTER TABLE `stationery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
