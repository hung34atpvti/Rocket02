--  E1:
--  Xoa csdl neu ton tai, tao va su dung csdl
DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE IF NOT EXISTS Fresher;
USE Fresher;

--  Question 1: Tao bang voi cac rang buoc va kieu du lieu
DROP TABLE IF EXISTS Trainee;
CREATE TABLE	Trainee
(
		TraineeID							SMALLINT AUTO_INCREMENT PRIMARY KEY,
		Full_Name							VARCHAR(30) NOT NULL,
        Birth_Date							DATE,
        Gender								ENUM('male','female','unknown'),
        ET_IQ								TINYINT,
        ET_Gmath							TINYINT,
        ET_English							TINYINT,
        Training_Class						CHAR(10),
        Evaluation_Notes					TEXT
);

--  Question 2: Them truong VTI_Account voi dieu kien not null unique
ALTER TABLE	Trainee 
		ADD VTI_Account						CHAR(20) NOT NULL UNIQUE;

-- E2: Data types        
CREATE TABLE	Bang1
(
		ID									MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
		Name								VARCHAR(30),
        Code								CHAR(5),
        ModifiedDate						DATETIME
);


-- E3: Data types
CREATE TABLE	Bang2
(
		ID									MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
		Name								VARCHAR(30),
        BirthDate							CHAR(5),
        Gender								ENUM('male','female','unknown'),
        IsDeletedFlag						BIT
);        
        
