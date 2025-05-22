-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2025 a las 10:27:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `centro_de_adopcon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adopcion`
--

CREATE TABLE `adopcion` (
  `Nombre` varchar(30) NOT NULL,
  `DNI` varchar(30) NOT NULL,
  `NTelefono` int(30) NOT NULL,
  `ChipMascota` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `adopcion`
--

INSERT INTO `adopcion` (`Nombre`, `DNI`, `NTelefono`, `ChipMascota`) VALUES
('fer', '363656C', 35657573, '1234567891');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_cambios_nuevo`
--

CREATE TABLE `historial_cambios_nuevo` (
  `id` int(11) NOT NULL,
  `ChipMascota` varchar(50) DEFAULT NULL,
  `Nombre_Anterior` varchar(100) DEFAULT NULL,
  `Nombre_Nuevo` varchar(100) DEFAULT NULL,
  `Edad_Anterior` int(11) DEFAULT NULL,
  `Edad_Nueva` int(11) DEFAULT NULL,
  `Especie_Anterior` varchar(100) DEFAULT NULL,
  `Especie_Nueva` varchar(100) DEFAULT NULL,
  `Raza_Anterior` varchar(100) DEFAULT NULL,
  `Raza_Nueva` varchar(100) DEFAULT NULL,
  `Fecha_Cambio` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_cambios_nuevo`
--

INSERT INTO `historial_cambios_nuevo` (`id`, `ChipMascota`, `Nombre_Anterior`, `Nombre_Nuevo`, `Edad_Anterior`, `Edad_Nueva`, `Especie_Anterior`, `Especie_Nueva`, `Raza_Anterior`, `Raza_Nueva`, `Fecha_Cambio`) VALUES
(1, '123123', 'Javi', 'Javier', 22, 25, 'Mono', 'Monos', 'Chimpacé', 'Chimpacée', '2025-05-20 08:19:33'),
(2, '123123', 'Javier', 'Javier', 25, 27, 'Monos', 'Monos', 'Chimpacée', 'Chimpacée', '2025-05-20 08:22:50'),
(3, '123123', 'Javier', 'Javier', 27, 50, 'Monos', 'Monos', 'Chimpacée', 'Chimpacée', '2025-05-20 08:25:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

CREATE TABLE `mascotas` (
  `ChipMascota` int(30) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Especie` varchar(30) NOT NULL,
  `Raza` varchar(30) NOT NULL,
  `Edad` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`ChipMascota`, `Nombre`, `Especie`, `Raza`, `Edad`) VALUES
(123123, 'Javier', 'Monos', 'Chimpacée', 50);

--
-- Disparadores `mascotas`
--
DELIMITER $$
CREATE TRIGGER `guardar_cambios_mascota` AFTER UPDATE ON `mascotas` FOR EACH ROW BEGIN INSERT INTO historial_cambios_nuevo (ChipMascota, Nombre_Anterior, Nombre_Nuevo, Edad_Anterior, Edad_Nueva, Especie_Anterior, Especie_Nueva, Raza_Anterior, Raza_Nueva, Fecha_Cambio) VALUES (OLD.ChipMascota, OLD.Nombre, NEW.Nombre, OLD.Edad, NEW.Edad, OLD.Especie, NEW.Especie, OLD.Raza, NEW.Raza, NOW()); END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `adopcion`
--
ALTER TABLE `adopcion`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `historial_cambios_nuevo`
--
ALTER TABLE `historial_cambios_nuevo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD PRIMARY KEY (`ChipMascota`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_cambios_nuevo`
--
ALTER TABLE `historial_cambios_nuevo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
