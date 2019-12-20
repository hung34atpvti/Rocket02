DROP DATABASE IF EXISTS as4;
CREATE DATABASE IF NOT EXISTS as4;
USE as4;

-- Question 1:
CREATE TABLE Department (
    Department_Number 		INT AUTO_INCREMENT,
    Department_Name 		VARCHAR(255),
    PRIMARY KEY (Department_Number)
);

CREATE TABLE Employee_Table (
    Employee_Number 		INT AUTO_INCREMENT,
    Employee_Name 			VARCHAR(255),
    Department_Number 		INT,
    PRIMARY KEY (Employee_Number),
    FOREIGN KEY (Department_Number)
        REFERENCES Department (Department_Number)
);

CREATE TABLE Employee_Skill_Table (
    Employee_Number 		INT,
    Skill_Code 				VARCHAR(255),
    Date_Registered 		DATE,
    FOREIGN KEY (Employee_Number)
        REFERENCES Employee_Table (Employee_Number)
);

-- Question 2:
INSERT INTO Department 
	(Department_Name) 
VALUES 
	('Smart'	), 
	('Truth'	),
	('Fracture'	),
	('Stayed'	),
	('More'		),
	('Mess'		),
	('Time'		),
	('Decide'	),
	('Way'		),
	('Go'		);

INSERT INTO Employee_Table
	(Employee_Name,Department_Number)
VALUES
	('Sometimes'	,1),
	('Good'			,1),
	('Answer'		,1),
	('Matter'		,2),
	('Question'		,2),
	('Sense'		,2),
	('Humor'		,3),
	('Simple'		,3),
	('Juliet'		,3),
	('Romeo'		,4);

INSERT INTO Employee_Skill_Table
	(Employee_Number,Skill_Code,Date_Registered)
VALUES
	(1				,'heading'	,'2018-08-26'),
	(1				,'back'		,'2017-09-25'),
	(1				,'Colorado'	,'2016-10-24'),
	(1				,'Java'		,'2018-08-26'),
	(2				,'tomorrow'	,'2015-11-23'),
	(2				,'after'	,'2014-12-22'),
	(3				,'Santa'	,'2013-01-21'),
	(4				,'Barbara'	,'2012-02-20'),
	(5				,'making'	,'2011-03-19'),
	(6				,'arrange'	,'2010-04-18'),
	(7				,'know '	,'2019-05-17');

-- Question 3:
SELECT 
	et.Employee_Number,et.Employee_Name
FROM 
	Employee_Table et
JOIN 
	Employee_Skill_Table est 
ON 
	et.Employee_Number=est.Employee_Number 
	and est.Skill_Code = 'Java'
GROUP BY 
	et.Employee_Number;

-- Question 4:
SELECT 
	d.Department_Number,
    d.Department_Name,
    COUNT(emp.Employee_Number) AS count_emp
FROM
	Department d,
    Employee_Table emp
WHERE
	d.Department_Number = emp.Department_Number
GROUP BY
	d.Department_Number,
    d.Department_Name
HAVING
	count_emp > 3;

-- Question 5:    
SELECT   	
    emp.Department_Number,
    d.Department_Name,
    emp.Employee_Number, 
    emp.Employee_Name
FROM 
	Department d,
    Employee_Table emp
WHERE 
	d.Department_Number = emp.Department_Number
GROUP BY
	emp.Employee_Number, 
    emp.Employee_Name
ORDER BY
	emp.Department_Number;

-- Question 6:    
SELECT
	emp.Employee_Number, 
    emp.Employee_Name,
    COUNT(s.Employee_Number) AS count_skill
FROM
	Employee_Skill_Table s,
    Employee_Table emp
WHERE
	s.Employee_Number=emp.Employee_Number
GROUP BY
	emp.Employee_Number, 
    emp.Employee_Name
HAVING
	count_skill > 1;
	
    

    
    









