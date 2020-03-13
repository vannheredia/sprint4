-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema baproclub
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema baproclub
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `baproclub` DEFAULT CHARACTER SET latin1 ;
USE `baproclub` ;

-- -----------------------------------------------------
-- Table `baproclub`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baproclub`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
  `contrasenia` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `fecha_de_nacimiento` DATE NOT NULL,
  `lugar_de_nacimiento` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `resenia` VARCHAR(255) NOT NULL,
  `url_foto_perfil` VARCHAR(255) NULL DEFAULT NULL,
  `url_foto_portada` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `UK_kfsp0s1tflm1cwlj8idhqsad0` ON `baproclub`.`usuarios` (`email` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `baproclub`.`cuentas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baproclub`.`cuentas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `baproclub`.`publicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baproclub`.`publicaciones` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL DEFAULT NULL,
  `imagen_de_posteo` VARCHAR(255) NULL DEFAULT NULL,
  `texto` VARCHAR(255) NULL DEFAULT NULL,
  `una_cuenta_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `baproclub`.`comentarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baproclub`.`comentarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `un_comentario` VARCHAR(255) NULL DEFAULT NULL,
  `una_cuenta_id` INT(11) NULL DEFAULT NULL,
  `una_publicacion_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `baproclub`.`seguimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baproclub`.`seguimientos` (
  `seguidor_id` INT(11) NOT NULL,
  `seguido_id` INT(11) NOT NULL,
  PRIMARY KEY (`seguidor_id`, `seguido_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `baproclub`.`vinculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baproclub`.`vinculos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `activo` BIT(1) NOT NULL,
  `cuenta_seguida_id` INT(11) NULL DEFAULT NULL,
  `id_cuenta` INT(11) NULL DEFAULT NULL,
  `id_usuario` INT(11) NOT NULL,
  `id_usuario_seguido` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
