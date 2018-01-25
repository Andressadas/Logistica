-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_logistica
--

CREATE DATABASE IF NOT EXISTS db_logistica;
USE db_logistica;

--
-- Definition of table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
  `id_ciudad` int(10) unsigned NOT NULL auto_increment,
  `id_departamento` int(10) unsigned NOT NULL,
  `nombre_ciudad` varchar(45) NOT NULL,
  PRIMARY KEY  (`id_ciudad`),
  KEY `FK_ciudad_1` (`id_departamento`),
  CONSTRAINT `FK_ciudad_1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ciudad`
--

/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int(10) unsigned NOT NULL auto_increment,
  `nombre_cliente` varchar(45) NOT NULL,
  `tipo_cliente` char(15) default NULL,
  `tipo_identificacion` char(5) NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `telefono` char(15) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `ciudad` int(10) unsigned NOT NULL,
  `departamento` int(10) unsigned NOT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY  (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(10) unsigned NOT NULL auto_increment,
  `nombre_departamento` varchar(45) NOT NULL,
  PRIMARY KEY  (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `envio`
--

DROP TABLE IF EXISTS `envio`;
CREATE TABLE `envio` (
  `id_envio` int(10) unsigned NOT NULL auto_increment,
  `ruta` int(10) unsigned NOT NULL,
  `fecha_recive` datetime NOT NULL,
  `fecha_entrega` datetime NOT NULL,
  `costo_envio` int(10) unsigned NOT NULL,
  `costo_adicional_envio` int(10) unsigned NOT NULL,
  `costo_total_envio` int(10) unsigned NOT NULL,
  `peso_neto` int(10) unsigned NOT NULL,
  `peso_adicional` int(10) unsigned NOT NULL,
  `cliente` int(10) unsigned NOT NULL,
  `ciudad_destino` int(10) unsigned NOT NULL,
  `descripcion_envio` varchar(60) NOT NULL,
  PRIMARY KEY  (`id_envio`),
  KEY `FK_envio_1` (`ruta`),
  KEY `FK_envio_2` (`ciudad_destino`),
  KEY `FK_envio_3` (`cliente`),
  CONSTRAINT `FK_envio_1` FOREIGN KEY (`ruta`) REFERENCES `ruta` (`id_ruta`),
  CONSTRAINT `FK_envio_2` FOREIGN KEY (`ciudad_destino`) REFERENCES `ciudad` (`id_ciudad`),
  CONSTRAINT `FK_envio_3` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `envio`
--

/*!40000 ALTER TABLE `envio` DISABLE KEYS */;
/*!40000 ALTER TABLE `envio` ENABLE KEYS */;


--
-- Definition of table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
CREATE TABLE `ruta` (
  `id_ruta` int(10) unsigned NOT NULL auto_increment,
  `nombre_ruta` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  PRIMARY KEY  (`id_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruta`
--

/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;


--
-- Definition of table `ruta_ciudad`
--

DROP TABLE IF EXISTS `ruta_ciudad`;
CREATE TABLE `ruta_ciudad` (
  `id_ruta_ciudad` int(10) unsigned NOT NULL auto_increment,
  `ciudad` int(10) unsigned NOT NULL,
  `ruta` int(10) unsigned NOT NULL,
  `tarifa` int(10) unsigned NOT NULL,
  `tarifa_adicional` int(10) unsigned NOT NULL,
  `punto` char(10) NOT NULL,
  PRIMARY KEY  (`id_ruta_ciudad`),
  KEY `FK_ruta_ciudad_1` (`ciudad`),
  KEY `FK_ruta_ciudad_2` (`ruta`),
  CONSTRAINT `FK_ruta_ciudad_2` FOREIGN KEY (`ruta`) REFERENCES `ruta` (`id_ruta`),
  CONSTRAINT `FK_ruta_ciudad_1` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruta_ciudad`
--

/*!40000 ALTER TABLE `ruta_ciudad` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruta_ciudad` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
