create database web;
CREATE TABLE IF NOT EXISTS `web`.`usuario` (
`id` INT auto_increment NOT NULL,
  `cpf` VARCHAR(11) NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `nome` VARCHAR(100) NULL,
  `sobre_nome` VARCHAR(45) NULL,
  `matricula` VARCHAR(50) NULL,
  `data_nascimento` DATE NULL,
  `curriculo` VARCHAR(100) NULL,
  `cep` VARCHAR(45) NULL,
  `rua` VARCHAR(100) NULL,
  `numero` INT NULL,
  `estado` VARCHAR(45) NULL,
  `tipo` VARCHAR(3) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;