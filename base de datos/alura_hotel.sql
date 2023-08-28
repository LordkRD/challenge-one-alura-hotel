CREATE DATABASE `alura_hotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE alura_hotel;

CREATE TABLE `huespedes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `FechaNacimiento` varchar(15) NOT NULL,
  `Nacionalidad` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `IdReserva` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `huespedes_ibfk_1` (`IdReserva`),
  CONSTRAINT `huespedes_ibfk_1` FOREIGN KEY (`IdReserva`) REFERENCES `reservas` (`Id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reservas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FechaEntrada` varchar(15) NOT NULL,
  `FechaSalida` varchar(15) NOT NULL,
  `Valor` float NOT NULL,
  `FormaPago` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `nombre_usuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
