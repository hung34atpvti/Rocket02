DROP DATABASE IF EXISTS fe1;
CREATE DATABASE IF NOT EXISTS fe1;
USE fe1;

-- a
DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
	RN					INT AUTO_INCREMENT,
    Name				VARCHAR(255),
    Age					SMALLINT,
    Gender				BIT,
PRIMARY KEY (RN)
);

DROP TABLE IF EXISTS Subject;
CREATE TABLE Subject
(
	sID					INT AUTO_INCREMENT,
    sName				VARCHAR(255),
PRIMARY KEY (sID)
);

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject
(
	RN					INT,
	sID					INT,
    Mark				SMALLINT,
    Date				DATE,
	FOREIGN KEY (RN) REFERENCES Student(RN) ON DELETE CASCADE,
    FOREIGN KEY (sID) REFERENCES Subject(sID) ON UPDATE CASCADE
);

INSERT INTO Student
(Name, Age, Gender)
VALUES
('Nguyen Van Hieu',		21,		0),
('Le Nhu Hai Yen',		20,		1),
('Nguyen Thanh Huyen',	18,		1);

INSERT INTO Subject
(sName)
VALUES
('Toan'),
('Van'),
('Anh');

INSERT INTO StudentSubject
(RN, sID, Mark, Date)
VALUES
(1,	1,	7, '2019-03-12'),
(1,	2,	8, '2019-04-12'),
(2,	1,	9, '2019-05-12');


-- b/a
SELECT 	*
  FROM 	Subject s
 WHERE 	s.sID NOT IN
					(SELECT ss.sID
					   FROM StudentSubject ss);

-- b/b 
SELECT 	* 
  FROM 	Subject s 
 WHERE 	s.sID IN
				( SELECT ss.sID 
                    FROM StudentSubject ss 
				GROUP BY ss.sID 
                  HAVING COUNT(ss.sID) >= 2);
 
 
-- c
DROP VIEW IF EXISTS StudentInfo;
CREATE VIEW StudentInfo AS
	SELECT 	ss.RN,ss.sID,
			st.Name, 
            st.Age, 
            CASE st.GENDER 
				WHEN 0 THEN 'MALE' 
                WHEN 1 THEN 'FEMALE' 
                ELSE 'UNKNOWN' END AS Gender, 
            s.sName, 
            ss.Mark, 
            ss.Date
      FROM StudentSubject ss
      JOIN Student st ON ss.RN=st.RN
      JOIN Subject s ON ss.sID=s.sID;

SELECT * 
  FROM StudentInfo;


-- d/a
DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER $$
CREATE TRIGGER CasUpdate
BEFORE UPDATE ON Subject
FOR EACH ROW
	BEGIN
		UPDATE StudentSubject
           SET sID=NEW.sID
         WHERE sID=OLD.sID;
    END$$
DELIMITER ;

UPDATE Subject
   SET sID=5
 WHERE sID=1;
         
SELECT * FROM StudentSubject;

-- d/b
DROP TRIGGER IF EXISTS casDel;
DELIMITER $$
CREATE TRIGGER casDel
BEFORE DELETE ON Student
FOR EACH ROW
	BEGIN
		
    END$$
DELIMITER ;


-- e
DROP PROCEDURE IF EXISTS xoa;
DELIMITER $$
CREATE PROCEDURE xoa(IN StudentName VARCHAR(255),IN Mark SMALLINT)
	BEGIN
		IF (StudentName='*') THEN
			DELETE FROM Student;
		END IF;
        
		WITH cte_stu AS
			(SELECT st.RN AS id, 
					st.Name AS name
               FROM Student st
               JOIN StudentSubject ss ON st.RN=ss.RN
              WHERE ss.Mark<Mark
				AND st.Name = StudentName
		   GROUP BY st.RN,st.Name) DELETE FROM Student st WHERE st.RN IN (SELECT id FROM cte_stu);
    END$$
DELIMITER ;

CALL xoa('*',0);





    