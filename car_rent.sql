-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Kwi 2019, 03:48
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `car_rent`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tcar`
--

CREATE TABLE `tcar` (
  `car_id` int(11) NOT NULL,
  `brand` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `production_date` int(11) NOT NULL,
  `colour` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `engine_power` int(11) NOT NULL,
  `fuel_type` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mileage` int(11) NOT NULL,
  `engine_capacity` int(11) NOT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tcar`
--

INSERT INTO `tcar` (`car_id`, `brand`, `model`, `production_date`, `colour`, `engine_power`, `fuel_type`, `mileage`, `engine_capacity`, `type`) VALUES
(1, 'Audi', 'A8', 2011, 'black', 201, 'gasoline', 20120, 1800, 'CIVIL'),
(2, 'Opel', 'Astra', 1999, 'yellow', 50, 'disel', 500000, 1600, 'CIVIL'),
(3, '1', '1', 1, '1', 1, '1', 1, 1, 'CIVIL'),
(4, '2', '2', 2, '2', 2, '2', 2, 2, 'OFFROAD'),
(5, '12', 'dd', 233, 'blackl', 332, 'none', 1, 33333, 'CIVIL');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `treservations`
--

CREATE TABLE `treservations` (
  `book_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `car_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `login` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `treservations`
--

INSERT INTO `treservations` (`book_id`, `date`, `car_id`, `user_id`, `login`) VALUES
(1, '2019-04-10', 1, 1, '11'),
(2, '2020-10-10', 1, 0, '11'),
(3, '2019-10-10', 1, 4, '11'),
(4, '2019-10-10', 1, 4, '11'),
(5, '2019-01-01', 1, 4, '11'),
(6, '2019-10-10', 1, 4, '11'),
(7, '2019-10-10', 1, 4, '11'),
(8, '2019-10-10', 1, 4, '11'),
(9, '0001-01-01', 2, 4, '11'),
(10, '2019-10-10', 1, 4, '11'),
(11, '0219-02-02', 1, 4, '11'),
(12, '2019-10-10', 1, 4, '11');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuser`
--

CREATE TABLE `tuser` (
  `user_id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pesel` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'u',
  `login` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tuser`
--

INSERT INTO `tuser` (`user_id`, `name`, `surname`, `pass`, `pesel`, `status`, `login`) VALUES
(1, 'Adolf', 'Nowak', '111111', '12345678901', 'a', 'adnow'),
(2, 'Rudolf', 'Hess', '1111111', '10987654321', 'a', 'rudolf'),
(3, 'Bezimienny', 'Beznazwiska', 'brak', '11111111111', 'u', 'bezbez'),
(4, '11', '11', '11', '11', 'u', '11');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `tcar`
--
ALTER TABLE `tcar`
  ADD PRIMARY KEY (`car_id`);

--
-- Indeksy dla tabeli `treservations`
--
ALTER TABLE `treservations`
  ADD PRIMARY KEY (`book_id`);

--
-- Indeksy dla tabeli `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `pesel` (`pesel`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `tcar`
--
ALTER TABLE `tcar`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `treservations`
--
ALTER TABLE `treservations`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT dla tabeli `tuser`
--
ALTER TABLE `tuser`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
