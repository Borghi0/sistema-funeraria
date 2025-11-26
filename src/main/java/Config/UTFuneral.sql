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
  `pla_nome` VARCHAR(255) NULL DEFAULT NULL,
  `pla_preco` DOUBLE NOT NULL DEFAULT '0',  
  PRIMARY KEY (`pla_id`));

CREATE TABLE IF NOT EXISTS `UTFuneral`.`produto` (
  `pro_id` INT NOT NULL AUTO_INCREMENT,
  `pro_nome` VARCHAR(255) NULL DEFAULT NULL,
  `pro_perecivel` TINYINT(1) NOT NULL DEFAULT '0',
  `pro_quant_estoque` INT NOT NULL DEFAULT '0',
  `pro_preco` DOUBLE NOT NULL DEFAULT '0',  
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

CREATE TABLE IF NOT EXISTS sala(
				sal_numero INT NOT NULL AUTO_INCREMENT,
                sal_capacidade INT NOT NULL,
                PRIMARY KEY (sal_numero)
);

CREATE TABLE IF NOT EXISTS velorio(
                sal_numero INT,
                vel_data_horario DATETIME,
                def_id INT NOT NULL,
                PRIMARY KEY (sal_numero, vel_data_horario),
                CONSTRAINT fk_velorio_sala 
					FOREIGN KEY (sal_numero) REFERENCES sala(sal_numero)
                                        ON DELETE CASCADE,
                CONSTRAINT fk_velorio_defunto
					FOREIGN KEY (def_id) REFERENCES defunto(def_id)
);
