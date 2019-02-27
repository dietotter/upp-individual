CREATE DATABASE IF NOT EXISTS mydb;

CREATE TABLE IF NOT EXISTS `mydb`.`doctor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `speciality` VARCHAR(45) NOT NULL,
  `experience` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `mydb`.`patient` (
  `passport` VARCHAR(8) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`passport`));

CREATE TABLE IF NOT EXISTS `mydb`.`recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `patient_passport` VARCHAR(8) NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `doctor_id_idx` (`doctor_id` ASC),
  INDEX `patient_passport_idx` (`patient_passport` ASC),
  CONSTRAINT `patient_passport`
    FOREIGN KEY (`patient_passport`)
    REFERENCES `mydb`.`patient` (`passport`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `doctor_id`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `mydb`.`doctor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `mydb`.`drug` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NOT NULL,
  `producer` VARCHAR(45) NOT NULL,
  `package_price` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `mydb`.`drugstore` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `mydb`.`recipe_drug` (
  `recipe_id` INT NOT NULL,
  `drug_recipe_drug` INT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`recipe_id`, `drug_recipe_drug`),
  INDEX `drug_id_idx` (`drug_recipe_drug` ASC),
  CONSTRAINT `recipe_id`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `mydb`.`recipe` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `drug_recipe_drug`
    FOREIGN KEY (`drug_recipe_drug`)
    REFERENCES `mydb`.`drug` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `mydb`.`drugstore_drug` (
  `drugstore_id` INT NOT NULL,
  `drug_drugstore_drug` INT NOT NULL,
  `date` DATE NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`drugstore_id`, `drug_drugstore_drug`),
  INDEX `drug_id_idx` (`drug_drugstore_drug` ASC),
  CONSTRAINT `drugstore_id`
    FOREIGN KEY (`drugstore_id`)
    REFERENCES `mydb`.`drugstore` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `drug_drugstore_drug`
    FOREIGN KEY (`drug_drugstore_drug`)
    REFERENCES `mydb`.`drug` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO `mydb`.`doctor` (`surname`, `speciality`, `experience`) VALUES ('olena', 'dermatolog', '2');
INSERT INTO `mydb`.`doctor` (`surname`, `speciality`, `experience`) VALUES ('nik', 'hirurg', '5');
INSERT INTO `mydb`.`drug` (`name`, `producer`, `package_price`) VALUES ('jod', 'darnytsya', '17');
INSERT INTO `mydb`.`drug` (`name`, `producer`, `package_price`) VALUES ('ibuprofen', 'likhim', '21');
INSERT INTO `mydb`.`drug` (`name`, `producer`, `package_price`) VALUES ('aspirin', 'lol', '44');
INSERT INTO `mydb`.`patient` (`passport`, `surname`, `birthday`) VALUES ('CT382359', 'olena', '1998-03-03');
INSERT INTO `mydb`.`patient` (`passport`, `surname`, `birthday`) VALUES ('KK564738', 'nik', '2001-09-09');
INSERT INTO `mydb`.`drugstore` (`id`, `name`, `address`) VALUES ('1', 'med', 'kyiv, protasiv yar 3');
INSERT INTO `mydb`.`drugstore` (`id`, `name`, `address`) VALUES ('2', 'podoroznyk', 'kyiv,medova 2');
INSERT INTO `mydb`.`drugstore_drug` (`drugstore_id`, `drug_drugstore_drug`, `date`, `price`) VALUES ('1', '2', '2019-01-01', '200');
INSERT INTO `mydb`.`drugstore_drug` (`drugstore_id`, `drug_drugstore_drug`, `date`, `price`) VALUES ('1', '1', '2019-01-01', '291');
INSERT INTO `mydb`.`drugstore_drug` (`drugstore_id`, `drug_drugstore_drug`, `date`, `price`) VALUES ('2', '3', '2019-02-03', '20');
INSERT INTO `mydb`.`recipe` (`date`, `patient_passport`, `doctor_id`) VALUES ('2019-03-03', 'CT382359', '1');
INSERT INTO `mydb`.`recipe` (`date`, `patient_passport`, `doctor_id`) VALUES ('2018-02-01', 'CT382359', '2');
INSERT INTO `mydb`.`recipe` (`date`, `patient_passport`, `doctor_id`) VALUES ('2019-01-01', 'KK564738', '2');
INSERT INTO `mydb`.`recipe_drug` (`recipe_id`, `drug_recipe_drug`, `amount`) VALUES ('1', '3', '1');
INSERT INTO `mydb`.`recipe_drug` (`recipe_id`, `drug_recipe_drug`, `amount`) VALUES ('1', '2', '2');
INSERT INTO `mydb`.`recipe_drug` (`recipe_id`, `drug_recipe_drug`, `amount`) VALUES ('2', '2', '5');
INSERT INTO `mydb`.`recipe_drug` (`recipe_id`, `drug_recipe_drug`, `amount`) VALUES ('3', '1', '1');



