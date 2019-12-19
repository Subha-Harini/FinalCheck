-- MySQL Script generated by MySQL Workbench
-- 05/29/19 23:19:59
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `stock_market` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `stock_market` ;



CREATE TABLE IF NOT EXISTS `stock_market`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(50) NOT NULL,
  `us_password` VARCHAR(100) NOT NULL,
  `us_user_type` VARCHAR(8) NOT NULL,
  `us_email` VARCHAR(50) UNIQUE NOT NULL,
  `us_mobile_number` BIGINT(10) UNIQUE NOT NULL,
  `us_status` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `stock_market`.`confirmation` (
  `co_id` INT NOT NULL AUTO_INCREMENT,
  `co_token` VARCHAR(50) NOT NULL,
  `co_user_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`co_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `stock_market`.`sector` (
  `se_id` INT NOT NULL AUTO_INCREMENT,
  `se_sector_name` VARCHAR(30) NOT NULL,
  `se_brief` VARCHAR(400) NOT NULL,
   PRIMARY KEY (`se_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `stock_market`.`stock_exchange`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `stock_market`.`stock_exchange` (
  `ex_id` INT NOT NULL AUTO_INCREMENT,
  `ex_stock_exchange` VARCHAR(30) NOT NULL,
  `ex_brief` VARCHAR(400) NOT NULL,
  `ex_address` VARCHAR(200) NOT NULL,
  `ex_remarks` VARCHAR(500) NOT NULL,
  `ex_logo` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`ex_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `stock_market`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_market`.`company` (
  `cp_id` INT NOT NULL AUTO_INCREMENT,
  `cp_name` VARCHAR(30) NOT NULL,
  `cp_turnover` BIGINT NOT NULL,
  `cp_ceo` VARCHAR(30) NOT NULL,
  `cp_listed` BOOLEAN DEFAULT FALSE,
  `cp_se_id` INT NOT NULL,
  `cp_brief` VARCHAR(600) NOT NULL,
  `cp_logo` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`cp_id`),
  INDEX `cp_se_fk_idx` (`cp_se_id` ASC),
  CONSTRAINT `cp_se_fk`
    FOREIGN KEY (`cp_se_id`)
    REFERENCES `stock_market`.`sector` (`se_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `stock_market`.`board_of_directors`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `stock_market`.`board_of_directors` (
  `bd_id` INT NOT NULL AUTO_INCREMENT,
  `bd_cp_id` INT NOT NULL,
  `bd_name` VARCHAR(30) NOT NULL,
   PRIMARY KEY (`bd_id`),
   INDEX `bd_cp_fk_idx` (`bd_cp_id` ASC),
  CONSTRAINT `bd_cp_fk`
    FOREIGN KEY (`bd_cp_id`)
    REFERENCES `stock_market`.`company` (`cp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `stock_market`.`stock_price`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `stock_market`.`stock_price` (
  `sp_id` INT NOT NULL AUTO_INCREMENT,
  `sp_company_code` INT NOT NULL,
  `sp_stock_exchange` VARCHAR(30) NOT NULL,
  `sp_current_price` BIGINT NOT NULL,
  `sp_date` DATE NOT NULL,
  `sp_time` TIME(0) NOT NULL,
  PRIMARY KEY (`sp_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `stock_market`.`ipo`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `stock_market`.`ipo` (
  `ipo_id` INT NOT NULL AUTO_INCREMENT,
  `ipo_cp_id` INT NOT NULL,
  `ipo_ex_id` INT NOT NULL,
  `ipo_share_price` BIGINT NOT NULL,
  `ipo_total_shares` BIGINT NOT NULL,
  `ipo_date` DATETIME NOT NULL,
  `ipo_remarks` VARCHAR(400) NULL,
  PRIMARY KEY (`ipo_id`),
  INDEX `ipo_cp_id_fk_idx` (`ipo_cp_id` ASC),
  CONSTRAINT `ipo_cp_fk`
    FOREIGN KEY (`ipo_cp_id`)
    REFERENCES `stock_market`.`company` (`cp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
   INDEX `ipo_ex_id_fk_idx` (`ipo_ex_id` ASC),
  CONSTRAINT `ipo_ex_fk`
    FOREIGN KEY (`ipo_ex_id`)
    REFERENCES `stock_market`.`stock_exchange` (`ex_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `stock_market`.`company_stock`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `stock_market`.`company_stock` (
	`cs_id` INT NOT NULL AUTO_INCREMENT,
	`cs_cp_id` INT NULL,
	`cs_ex_id` INT NULL,
	PRIMARY KEY (`cs_id`),
	INDEX `cs_cp_fk_idx` (`cs_cp_id` ASC),
	INDEX `cs_ex_fk_idx` (`cs_ex_id` ASC),
	CONSTRAINT `cs_cp_fk`
		FOREIGN KEY (`cs_cp_id`)
		REFERENCES `stock_market`.`company` (`cp_id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT `cs_ex_fk`
		FOREIGN KEY (`cs_ex_id`)
		REFERENCES `stock_market`.`stock_exchange` (`ex_id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION)
	ENGINE = InnoDB;

insert into sector values (default,1,"Iron and Steel"),(default,2,"Pharmaceuticals"),(default,3,"HealthCare"),(default,4,"Banking");

insert into company values (default,"Reliance",123456,"Mukesh Ambani",true,1,"Good","https://logosvector.net/wp-content/uploads/2013/05/reliance-industries-vector-logo.png"),(default,"AstraZenaca",500000,"Pascal Soriot",true,2,"Good","https://botw-pd.s3.amazonaws.com/styles/logo-thumbnail/s3/0002/9083/brand.gif?itok=kp_3qOII"),(default,"Apollo Hospitals",800000,"Prathap Reddy",true,3,"Good","https://upload.wikimedia.org/wikipedia/en/thumb/2/24/Apollo_Hospitals_Svg_Logo.svg/1200px-Apollo_Hospitals_Svg_Logo.svg.png"),(default,"State Bank",600000,"Arijit Basu",true,4,"Good","https://qph.fs.quoracdn.net/main-qimg-2569681f342dd6c9319e2cab8920dbd2.webp"),
							(default,"Tata Steel",150000,"Narendran",true,1,"Good","https://coacharya.com/wp-content/uploads/2017/09/tata-logo.png"),(default,"Sun Pharmaceuticals",350000,"Dilip Shanghvi",true,2,"Good","https://upload.wikimedia.org/wikipedia/commons/2/26/Sun_Pharma_Logo.png"),(default,"Thyrocare",250000,"Arokiaswamy",true,3,"Good","https://botw-pd.s3.amazonaws.com/styles/logo-thumbnail/s3/082016/untitled-1_206.jpg?itok=qwvpSggW"),(default,"Indian Bank",450000,"Padmaja",true,4,"Good","https://logosvector.net/wp-content/uploads/2014/01/indian-bank-1907-vector-logo.png");
                            
insert into board_of_directors values (default,1,"Nita Ambani"),(default,1,"Deepak Jain"),(default,2,"Michel"),(default,2,"Philip"),(default,3,"Vinayak"),(default,3,"Murali"),(default,4,"Gupta"),(default,4,"Dinesh Kumar"),
			(default,5,"Mallika"),(default,5,"Deepak kapoor"),(default,6,"Sailesh"),(default,6,"Vivek"),(default,7,"Velumani"),(default,7,"Sundararaju"),(default,8,"Shenoy"),(default,8,"Vishwanath");


insert into stock_exchange values (default,"BSE","Bombay Stock Exchange","Dalal Street, Mumbai","Good Service","https://logodix.com/logo/1724617.gif"),(default,"NSE","National Stock Exchange","Delhi","Nil","https://bsmedia.business-standard.com/_media/bs/img/misc/2018-08/08/full/nse-logo-1533719825-40642190.jpg"),(default,"cSE","Calcutta Stock Exchange","Kolkata","Good","https://3adeal.com/images/detailed/2/logo_wz1w-ak.jpg?t=1493725972");

insert into company_stock values(default,1,1),(default,1,2),(default,2,1),(default,3,1),(default,3,2),(default,3,3),(default,4,1),(default,4,2),(default,4,3),(default,5,1),(default,5,2),(default,5,3),(default,6,2),(default,6,3),(default,7,2),(default,8,1);
  
  
insert into ipo values (default,1,1,1200,500000,'2018-10-01 10:30:00 ',"Good"),(default,1,2,1000,450000,'2014-06-20 10:30:00',"Nil"),(default,2,1,800,300000,'2015-11-25 10:30:00',"Good"),
			(default,3,1,1500,550000,'2000-08-18 10:00:00 ',"Good"),(default,3,2,1600,450000,'2005-06-18 10:30:00 ',"Good"),(default,3,3,1200,300000,'2009-07-08 10:00:00 ',"Nil"),
            (default,4,1,1200,450000,'1995-06-12 09:00:00 ',"Good"),(default,4,2,1200,550000,'1999-12-18 10:00:00 ',"Good"),(default,4,3,1000,350000,'2000-11-12 10:30:00 ',"Nil"),
            (default,5,1,1500,650000,'2000-06-12 10:00:00 ',"Good"),(default,5,2,1200,550000,'1999-12-18 10:00:00 ',"Good"),(default,5,3,1000,450000,'2000-11-12 10:30:00 ',"Nil"),
			(default,6,2,1000,450000,'2009-11-08 09:30:00 ',"Good"),(default,6,3,1200,550000,'2000-09-11 10:00:00',"Nil"),
            (default,7,2,1000,250000,'2010-08-20 10:30:00 ',"Nil"),(default,8,1,1200,550000,'1995-10-20 10:00:00 ',"Good");
		
select * from user;
select * from sector;
select * from company;
select * from company_stock;
select * from stock_exchange;
select * from board_of_directors;
select * from stock_price;
select * from ipo;