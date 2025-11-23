SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `UTFuneral`;
USE `UTFuneral` ;

CREATE TABLE IF NOT EXISTS `UTFuneral`.`defunto` (
  `def_id` INT NOT NULL AUTO_INCREMENT,
  `def_nome` VARCHAR(255) NULL DEFAULT NULL,
  `def_data_natalidade` DATE NULL DEFAULT NULL,
  `def_data_obito` DATE NULL DEFAULT NULL,
  `def_tipo_obito` VARCHAR(100) NULL DEFAULT NULL,
  `def_cemiterio` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`def_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`endereco` (
  `end_numero` INT NOT NULL,
  `end_rua` VARCHAR(255) NOT NULL,
  `end_cep` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`end_numero`, `end_rua`, `end_cep`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`plano` (
  `pla_id` INT NOT NULL AUTO_INCREMENT,
  `pla_preco` DOUBLE NOT NULL DEFAULT '0',
  `pla_nome` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`pla_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`produto` (
  `pro_id` INT NOT NULL AUTO_INCREMENT,
  `pro_perecivel` TINYINT(1) NOT NULL DEFAULT '0',
  `pro_quant_estoque` INT NOT NULL DEFAULT '0',
  `pro_preco` DOUBLE NOT NULL DEFAULT '0',
  `pro_nome` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`pro_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`plano_produto` (
  `pla_id` INT NOT NULL,
  `pro_id` INT NOT NULL,
  PRIMARY KEY (`pla_id`, `pro_id`),
  INDEX `pla_id` (`pla_id` ASC) VISIBLE,
  INDEX `pro_id` (`pro_id` ASC) VISIBLE,
  CONSTRAINT `plano_produto_ibfk_1`
    FOREIGN KEY (`pla_id`)
    REFERENCES `UTFuneral`.`plano` (`pla_id`),
  CONSTRAINT `plano_produto_ibfk_2`
    FOREIGN KEY (`pro_id`)
    REFERENCES `UTFuneral`.`produto` (`pro_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`servico` (
  `ser_id` INT NOT NULL AUTO_INCREMENT,
  `ser_nome` VARCHAR(255) NULL DEFAULT NULL,
  `ser_prestacao` DATE NULL DEFAULT NULL,
  `ser_preco` DOUBLE NOT NULL DEFAULT '0',
  `ser_tipo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`ser_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`plano_servico` (
  `pla_id` INT NOT NULL,
  `ser_id` INT NOT NULL,
  PRIMARY KEY (`pla_id`, `ser_id`),
  INDEX `pla_id` (`pla_id` ASC) VISIBLE,
  INDEX `ser_id` (`ser_id` ASC) VISIBLE,
  CONSTRAINT `plano_servico_ibfk_1`
    FOREIGN KEY (`pla_id`)
    REFERENCES `UTFuneral`.`plano` (`pla_id`),
  CONSTRAINT `plano_servico_ibfk_2`
    FOREIGN KEY (`ser_id`)
    REFERENCES `UTFuneral`.`servico` (`ser_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`sala` (
  `sal_numero` INT NOT NULL AUTO_INCREMENT,
  `sal_capacidade` INT NULL DEFAULT '0',
  PRIMARY KEY (`sal_numero`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`usuario` (
  `usu_cpf` VARCHAR(50) NOT NULL,
  `usu_nome` VARCHAR(255) NOT NULL,
  `usu_data_natalidade` DATE NOT NULL,
  `usu_login` VARCHAR(100) NOT NULL,
  `usu_senha` VARCHAR(255) NOT NULL,
  `usu_numero_telefone` VARCHAR(50) NULL DEFAULT NULL,
  `usu_admin` TINYINT(1) NOT NULL DEFAULT '0',
  `end_numero` INT NULL,
  `end_rua` VARCHAR(255) NULL,
  `end_cep` VARCHAR(20) NULL,
  `pla_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`usu_cpf`),
  UNIQUE INDEX `usu_login` (`usu_login` ASC) VISIBLE,
  INDEX `fk_usuario_plano` (`pla_id` ASC) VISIBLE,
  INDEX `fk_usuario_endereco` (`end_numero` ASC, `end_rua` ASC, `end_cep` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_endereco`
    FOREIGN KEY (`end_numero` , `end_rua` , `end_cep`)
    REFERENCES `UTFuneral`.`endereco` (`end_numero` , `end_rua` , `end_cep`),
  CONSTRAINT `fk_usuario_plano`
    FOREIGN KEY (`pla_id`)
    REFERENCES `UTFuneral`.`plano` (`pla_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`velorio` (
  `sal_numero` INT NOT NULL,
  `vel_data_horario` DATETIME NOT NULL,
  `def_id` INT NOT NULL,
  PRIMARY KEY (`sal_numero`, `vel_data_horario`),
  INDEX `fk_velorio_defunto` (`def_id` ASC) VISIBLE,
  CONSTRAINT `fk_velorio_defunto`
    FOREIGN KEY (`def_id`)
    REFERENCES `UTFuneral`.`defunto` (`def_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_velorio_sala`
    FOREIGN KEY (`sal_numero`)
    REFERENCES `UTFuneral`.`sala` (`sal_numero`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
