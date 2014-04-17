-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2014 at 09:13 AM
-- Server version: 5.5.30
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sioui`
--

-- --------------------------------------------------------

--
-- Table structure for table `lowongans`
--

CREATE TABLE IF NOT EXISTS `lowongans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(255) NOT NULL,
  `deskripsi` text NOT NULL,
  `jabatan` varchar(255) NOT NULL,
  `minimum_tahun` int(11) NOT NULL,
  `pendaftaran_dimulai` datetime NOT NULL,
  `pendaftaran_selesai` datetime NOT NULL,
  `minimum_ipk` double NOT NULL,
  `jumlah_dibutuhkan` int(11) NOT NULL,
  `kategori` varchar(127) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `lowongans`
--

INSERT INTO `lowongans` (`id`, `judul`, `deskripsi`, `jabatan`, `minimum_tahun`, `pendaftaran_dimulai`, `pendaftaran_selesai`, `minimum_ipk`, `jumlah_dibutuhkan`, `kategori`) VALUES
(1, 'Staf Media Partner Computer Festival 2012', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,', 'Staf Media Partner', 2011, '2012-03-25 00:00:00', '2012-03-29 00:00:00', 3.75, 12, 'media, sponsorship'),
(2, 'Oprec Ristek 2014', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,', 'Anggota Ristek 2014', 2012, '2014-03-23 00:00:00', '2014-03-28 00:00:00', 3, 50, 'riset, teknologi'),
(3, 'Staf Pengabdian Masyarakat BEM Fasilkom UI 2014', 'Punya jiwa sosial yang tinggi? Ingin berkontribusi bagi masyarakat luas? Jadilah bagian dari keluarga Pengmas BEM Fasilkom UI 2014! #KontribusiDalamKolaborasi', 'Staf Pengabdian Masyarakat', 2012, '2014-02-11 00:00:00', '2014-02-20 00:00:00', 3, 8, 'sosial, pengabdian masyarakat, BEM'),
(4, 'Staf Media BEM Fasilkom UI 2014', 'Temen-temen yang punya kreativitas tinggi pas banget disini. Yuk gabung dengan keluarga Media BEM Fasilkom UI 2014! #KontribusiDalamKolaborasi', 'Staf Media', 2012, '2014-02-11 00:00:00', '2014-02-20 00:00:00', 3, 8, 'media, BEM');

-- --------------------------------------------------------

--
-- Table structure for table `organizations`
--

CREATE TABLE IF NOT EXISTS `organizations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_panjang` varchar(255) NOT NULL,
  `nama_pendek` varchar(127) NOT NULL,
  `tanggal_berdiri` date NOT NULL,
  `jenis` varchar(63) NOT NULL,
  `alamat` text NOT NULL,
  `deskripsi` text NOT NULL,
  `visi` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `organizations`
--

INSERT INTO `organizations` (`id`, `nama_panjang`, `nama_pendek`, `tanggal_berdiri`, `jenis`, `alamat`, `deskripsi`, `visi`) VALUES
(1, 'Badan Eksekutif Mahasiswa Fakultas Ilmu Komputer Universitas Indonesia', 'BEM Fasilkom UI', '2014-03-19', 'UKM', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quaerat, earum, dolores, optio explicabo officia ', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quaerat, earum, dolores, optio explicabo officia ', 'Lorem ipsum dolor sit amet');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('jojoeffe', 'jojoeffe');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
