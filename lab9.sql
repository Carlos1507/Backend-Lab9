-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab9` DEFAULT CHARACTER SET utf8 ;
USE `lab9` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `contra` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`juego` (
  `idjuego` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idjuego`),
  INDEX `fk_juego_usuario1_idx` (`idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_juego_usuario1`
    FOREIGN KEY (`idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`imagenes` (
  `idimagenes` INT NOT NULL AUTO_INCREMENT,
  `imagen` LONGBLOB NOT NULL,
  PRIMARY KEY (`idimagenes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`juego_has_imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`juego_has_imagenes` (
  `idjuego` INT NOT NULL,
  `idimagenes` INT NOT NULL,
  `posicion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idjuego`, `idimagenes`),
  INDEX `fk_juego_has_imagenes_imagenes1_idx` (`idimagenes` ASC) VISIBLE,
  INDEX `fk_juego_has_imagenes_juego1_idx` (`idjuego` ASC) VISIBLE,
  CONSTRAINT `fk_juego_has_imagenes_juego1`
    FOREIGN KEY (`idjuego`)
    REFERENCES `mydb`.`juego` (`idjuego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_juego_has_imagenes_imagenes1`
    FOREIGN KEY (`idimagenes`)
    REFERENCES `mydb`.`imagenes` (`idimagenes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
