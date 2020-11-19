-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 14 Kas 2020, 12:05:59
-- Sunucu sürümü: 10.4.14-MariaDB
-- PHP Sürümü: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `sarkuteri`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `alim`
--

CREATE TABLE `alim` (
  `id` int(10) UNSIGNED NOT NULL,
  `uretici_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `urun_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `tarih` date NOT NULL DEFAULT curdate(),
  `miktar` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `fiyat` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kasacikis`
--

CREATE TABLE `kasacikis` (
  `id` int(10) UNSIGNED NOT NULL,
  `uretici_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `odeme` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `tarih` date NOT NULL DEFAULT curdate(),
  `odeme_sekli` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT 'Hata'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kasagiris`
--

CREATE TABLE `kasagiris` (
  `id` int(10) UNSIGNED NOT NULL,
  `satici_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `tahsilat` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `tarih` date NOT NULL DEFAULT curdate(),
  `tahsilat_sekli` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT 'Hata'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `merkez`
--

CREATE TABLE `merkez` (
  `ad` char(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT 'TCKS Sarkuteri',
  `adres` char(50) COLLATE utf8_turkish_ci NOT NULL,
  `tlf` char(11) COLLATE utf8_turkish_ci NOT NULL,
  `kasa` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satici`
--

CREATE TABLE `satici` (
  `id` int(10) UNSIGNED NOT NULL,
  `ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT '0',
  `adres` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT '0',
  `tlf` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT '0',
  `borc` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satim`
--

CREATE TABLE `satim` (
  `id` int(10) UNSIGNED NOT NULL,
  `satici_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `urun_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `tarih` date NOT NULL DEFAULT curdate(),
  `miktar` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `fiyat` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uretici`
--

CREATE TABLE `uretici` (
  `id` int(10) UNSIGNED NOT NULL,
  `ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT '0',
  `adres` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT '0',
  `tlf` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT '0',
  `alacak` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urun`
--

CREATE TABLE `urun` (
  `id` int(10) UNSIGNED NOT NULL,
  `ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT 'Hata',
  `tur` varchar(50) COLLATE utf8_turkish_ci NOT NULL DEFAULT 'Hata',
  `stok` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `urun`
--

INSERT INTO `urun` (`id`, `ad`, `tur`, `stok`) VALUES
(28, 'armut', 'Meyve', 0);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `alim`
--
ALTER TABLE `alim`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uretici_id_fk` (`uretici_id`),
  ADD KEY `urun_id_fk` (`urun_id`);

--
-- Tablo için indeksler `kasacikis`
--
ALTER TABLE `kasacikis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uretici_id_fk1` (`uretici_id`);

--
-- Tablo için indeksler `kasagiris`
--
ALTER TABLE `kasagiris`
  ADD PRIMARY KEY (`id`),
  ADD KEY `satici_id_fk1` (`satici_id`);

--
-- Tablo için indeksler `satici`
--
ALTER TABLE `satici`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `satim`
--
ALTER TABLE `satim`
  ADD PRIMARY KEY (`id`),
  ADD KEY `satici_id_fk` (`satici_id`),
  ADD KEY `urun_id_fk1` (`urun_id`);

--
-- Tablo için indeksler `uretici`
--
ALTER TABLE `uretici`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `urun`
--
ALTER TABLE `urun`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `alim`
--
ALTER TABLE `alim`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Tablo için AUTO_INCREMENT değeri `kasacikis`
--
ALTER TABLE `kasacikis`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Tablo için AUTO_INCREMENT değeri `kasagiris`
--
ALTER TABLE `kasagiris`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Tablo için AUTO_INCREMENT değeri `satici`
--
ALTER TABLE `satici`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Tablo için AUTO_INCREMENT değeri `satim`
--
ALTER TABLE `satim`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Tablo için AUTO_INCREMENT değeri `uretici`
--
ALTER TABLE `uretici`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Tablo için AUTO_INCREMENT değeri `urun`
--
ALTER TABLE `urun`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `alim`
--
ALTER TABLE `alim`
  ADD CONSTRAINT `uretici_id_fk` FOREIGN KEY (`uretici_id`) REFERENCES `uretici` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `urun_id_fk` FOREIGN KEY (`urun_id`) REFERENCES `urun` (`id`) ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `kasacikis`
--
ALTER TABLE `kasacikis`
  ADD CONSTRAINT `uretici_id_fk1` FOREIGN KEY (`uretici_id`) REFERENCES `uretici` (`id`) ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `kasagiris`
--
ALTER TABLE `kasagiris`
  ADD CONSTRAINT `satici_id_fk1` FOREIGN KEY (`satici_id`) REFERENCES `satici` (`id`) ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `satim`
--
ALTER TABLE `satim`
  ADD CONSTRAINT `satici_id_fk` FOREIGN KEY (`satici_id`) REFERENCES `satici` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `urun_id_fk1` FOREIGN KEY (`urun_id`) REFERENCES `urun` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
