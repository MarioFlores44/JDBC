-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2023 a las 10:40:29
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prog_uf6`

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prog_UF6` DEFAULT CHARACTER SET utf8 ;
USE `prog_UF6` ;

-- -----------------------------------------------------
-- Table `mydb`.`comunitats_autonomes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prog_UF6`.`comunitats_autonomes` ;

--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidats`
--

CREATE TABLE `candidats` (
  `candidat_id` bigint(20) UNSIGNED NOT NULL,
  `candidatura_id` int(10) UNSIGNED NOT NULL,
  `persona_id` int(10) UNSIGNED NOT NULL,
  `provincia_id` tinyint(3) UNSIGNED NOT NULL,
  `num_ordre` tinyint(4) DEFAULT NULL COMMENT 'Num ordre del candidatdins la llista del partit dins de la circumpscripció que es presenta.',
  `tipus` enum('T','S') DEFAULT NULL COMMENT 'T=Titular, S=Suplent'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `candidats`
--

INSERT INTO `candidats` (`candidat_id`, `candidatura_id`, `persona_id`, `provincia_id`, `num_ordre`, `tipus`) VALUES
(1, 1, 1, 2, 1, 'T'),
(2, 2, 2, 1, 1, 'T');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidatures`
--

CREATE TABLE `candidatures` (
  `candidatura_id` int(10) UNSIGNED NOT NULL,
  `eleccio_id` tinyint(3) UNSIGNED NOT NULL,
  `codi_candidatura` char(6) DEFAULT NULL,
  `nom_curt` varchar(50) DEFAULT NULL COMMENT 'Sigles de la candidatura',
  `nom_llarg` varchar(150) DEFAULT NULL COMMENT 'Nom llarg de la candidatura (denominació)',
  `codi_acumulacio_provincia` char(6) DEFAULT NULL COMMENT 'Codi de la candidatura d''acumulació a nivell provincial.',
  `codi_acumulacio_ca` char(6) DEFAULT NULL COMMENT 'Codi de la candidatura d''acumulació a nivell de comunitat autònoma',
  `codi_acumulacio_nacional` char(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `candidatures`
--

INSERT INTO `candidatures` (`candidatura_id`, `eleccio_id`, `codi_candidatura`, `nom_curt`, `nom_llarg`, `codi_acumulacio_provincia`, `codi_acumulacio_ca`, `codi_acumulacio_nacional`) VALUES
(1, 2, 'ES2000', 'España 2000', 'España 2000', '3', '6', '1'),
(2, 3, 'PCE', 'PCE', 'Partit Comunista d\'Espanya', '3', '5', '8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comunitats_autonomes`
--

CREATE TABLE `comunitats_autonomes` (
  `comunitat_aut_id` tinyint(3) UNSIGNED NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `codi_ine` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comunitats_autonomes`
--

INSERT INTO `comunitats_autonomes` (`comunitat_aut_id`, `nom`, `codi_ine`) VALUES
(1, 'Catalunya', '09'),
(2, 'Valencia', '10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipis`
--

CREATE TABLE `municipis` (
  `municipi_id` smallint(5) UNSIGNED NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `codi_ine` char(3) NOT NULL,
  `provincia_id` tinyint(3) UNSIGNED NOT NULL,
  `districte` char(2) DEFAULT NULL COMMENT 'Número de districte municipal , sinó el seu valor serà 99. Per exemple aquí municiís com Blanes el seu valor serà 99, però en ciutats com Barcelona hi haurà el número de districte'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `municipis`
--

INSERT INTO `municipis` (`municipi_id`, `nom`, `codi_ine`, `provincia_id`, `districte`) VALUES
(2, 'Blanes', '300', 1, 'D2'),
(3, 'Sant Cugat del Vallès', '172', 2, 'D8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persones`
--

CREATE TABLE `persones` (
  `persona_id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `cog1` varchar(30) DEFAULT NULL,
  `cog2` varchar(30) DEFAULT NULL,
  `sexe` enum('M','F') DEFAULT NULL COMMENT 'M=Masculí, F=Femení',
  `data_naixement` date DEFAULT NULL,
  `dni` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persones`
--

INSERT INTO `persones` (`persona_id`, `nom`, `cog1`, `cog2`, `sexe`, `data_naixement`, `dni`) VALUES
(1, 'Mario', 'Flores', 'Muñoz', 'M', '2001-05-02', '12345687P'),
(2, 'Sergi', 'Triadó', 'Morales', 'M', '1996-03-25', '89671234Q');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincies`
--

CREATE TABLE `provincies` (
  `provincia_id` tinyint(3) UNSIGNED NOT NULL,
  `comunitat_aut_id` tinyint(3) UNSIGNED NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `codi_ine` char(2) NOT NULL,
  `num_escons` tinyint(3) UNSIGNED DEFAULT NULL COMMENT 'Numero d''escons que li pertoquen a aquella provincia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `provincies`
--

INSERT INTO `provincies` (`provincia_id`, `comunitat_aut_id`, `nom`, `codi_ine`, `num_escons`) VALUES
(1, 1, 'Girona', '17', 27),
(2, 1, 'Barcelona', '08', 51);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `candidats`
--
ALTER TABLE `candidats`
  ADD PRIMARY KEY (`candidat_id`),
  ADD UNIQUE KEY `uk_candidats_persona_cand` (`candidatura_id`,`persona_id`),
  ADD KEY `fk_candidats_provincies1_idx` (`provincia_id`),
  ADD KEY `fk_candidats_persones1_idx` (`persona_id`),
  ADD KEY `fk_candidats_candidatures1_idx` (`candidatura_id`);

--
-- Indices de la tabla `candidatures`
--
ALTER TABLE `candidatures`
  ADD PRIMARY KEY (`candidatura_id`),
  ADD UNIQUE KEY `uk_eleccions_partits` (`eleccio_id`,`codi_candidatura`);

--
-- Indices de la tabla `comunitats_autonomes`
--
ALTER TABLE `comunitats_autonomes`
  ADD PRIMARY KEY (`comunitat_aut_id`),
  ADD UNIQUE KEY `uk_com_aut_codi_ine` (`codi_ine`);

--
-- Indices de la tabla `municipis`
--
ALTER TABLE `municipis`
  ADD PRIMARY KEY (`municipi_id`),
  ADD UNIQUE KEY `uk_municipis_codi` (`codi_ine`,`provincia_id`,`districte`),
  ADD KEY `idx_fk_municipis_provincies1` (`provincia_id`);

--
-- Indices de la tabla `persones`
--
ALTER TABLE `persones`
  ADD PRIMARY KEY (`persona_id`),
  ADD UNIQUE KEY `uk_candidats_dni` (`dni`);

--
-- Indices de la tabla `provincies`
--
ALTER TABLE `provincies`
  ADD PRIMARY KEY (`provincia_id`),
  ADD UNIQUE KEY `uk_provincies_codi_ine` (`codi_ine`),
  ADD KEY `idx_fk_provincies_comunitats_autonomes` (`comunitat_aut_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `candidats`
--
ALTER TABLE `candidats`
  MODIFY `candidat_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `candidatures`
--
ALTER TABLE `candidatures`
  MODIFY `candidatura_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `comunitats_autonomes`
--
ALTER TABLE `comunitats_autonomes`
  MODIFY `comunitat_aut_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `municipis`
--
ALTER TABLE `municipis`
  MODIFY `municipi_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `persones`
--
ALTER TABLE `persones`
  MODIFY `persona_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `provincies`
--
ALTER TABLE `provincies`
  MODIFY `provincia_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `candidats`
--
ALTER TABLE `candidats`
  ADD CONSTRAINT `fk_candidats_candidatures1` FOREIGN KEY (`candidatura_id`) REFERENCES `candidatures` (`candidatura_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_candidats_persones1` FOREIGN KEY (`persona_id`) REFERENCES `persones` (`persona_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_candidats_provincies1` FOREIGN KEY (`provincia_id`) REFERENCES `provincies` (`provincia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `municipis`
--
ALTER TABLE `municipis`
  ADD CONSTRAINT `fk_municipis_provincies` FOREIGN KEY (`provincia_id`) REFERENCES `provincies` (`provincia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `provincies`
--
ALTER TABLE `provincies`
  ADD CONSTRAINT `fk_provincies_comunitats_autonomes` FOREIGN KEY (`comunitat_aut_id`) REFERENCES `comunitats_autonomes` (`comunitat_aut_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
