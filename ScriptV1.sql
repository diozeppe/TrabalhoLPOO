-- MySQL Script generated by MySQL Workbench
-- Fri 16 Jun 2017 10:20:17 AM BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `sobrenome` VARCHAR(45) NULL,
  `cpf` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Forma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Forma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valorA` DOUBLE NULL,
  `valorB` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Modelo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `qualidade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco_metro_quadrado` DOUBLE NULL,
  `Modelo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Material_Modelo1_idx` (`Modelo_id` ASC),
  CONSTRAINT `fk_Material_Modelo1`
    FOREIGN KEY (`Modelo_id`)
    REFERENCES `mydb`.`Modelo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tapete`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tapete` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Forma_id` INT NOT NULL,
  `Material_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Tapete_Forma1_idx` (`Forma_id` ASC),
  INDEX `fk_Tapete_Material1_idx` (`Material_id` ASC),
  CONSTRAINT `fk_Tapete_Forma1`
    FOREIGN KEY (`Forma_id`)
    REFERENCES `mydb`.`Forma` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tapete_Material1`
    FOREIGN KEY (`Material_id`)
    REFERENCES `mydb`.`Material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor` DOUBLE NULL,
  `cliente_id` INT NOT NULL,
  `Tapete_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_cliente_idx` (`cliente_id` ASC),
  INDEX `fk_Pedido_Tapete1_idx` (`Tapete_id` ASC),
  CONSTRAINT `fk_Pedido_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mydb`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Tapete1`
    FOREIGN KEY (`Tapete_id`)
    REFERENCES `mydb`.`Tapete` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;