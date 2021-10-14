-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2021 a las 21:13:19
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `dni` varchar(8) COLLATE latin1_spanish_ci NOT NULL,
  `nombres` varchar(40) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(11) COLLATE latin1_spanish_ci NOT NULL,
  `estado` varchar(1) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `dni`, `nombres`, `direccion`, `telefono`, `estado`) VALUES
(24, '14', 'DANIEL', 'CLLA 1455', '456888', '2'),
(25, '15', 'JUANES', 'CSS454', '344558', '1'),
(27, '16', 'JUAN JOSE', 'Csa 4 55', '312548778', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `IdDetalleVenta` int(11) NOT NULL,
  `IdVentas` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(11) NOT NULL,
  `Dni` varchar(8) COLLATE latin1_spanish_ci NOT NULL,
  `Nombres` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Telefono` varchar(12) COLLATE latin1_spanish_ci NOT NULL,
  `Estado` varchar(1) COLLATE latin1_spanish_ci NOT NULL,
  `Usuario` varchar(8) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Estado`, `Usuario`) VALUES
(2, '1', 'Diego', '3434346', '1', '1'),
(28, '2', 'JUAN', '31455876', '2', 'JUANITO'),
(29, '3', 'CAMILO', '31455587', '2', 'CALOZ3'),
(30, '4', 'EST', '31178896', '2', 'ESTEBAND');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `dni` varchar(20) CHARACTER SET utf16 COLLATE utf16_spanish2_ci NOT NULL,
  `nombres` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` varchar(1) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `dni`, `nombres`, `precio`, `stock`, `estado`) VALUES
(1, '14', 'PAN', 1500, 12, '2'),
(150, '17', 'YOGURT', 800, 12, '2'),
(152, '16', 'QUESO', 1500, 12, '2'),
(154, '18', 'HELADO', 1800, 102, '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdEmpleado` int(11) NOT NULL,
  `NumeroSerie` varchar(244) NOT NULL,
  `FechaVenta` date NOT NULL,
  `Monto` double NOT NULL,
  `Estado` varchar(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`IdDetalleVenta`,`IdVentas`,`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
