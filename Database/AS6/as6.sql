drop database if exists Assignment6;  
create database if not exists Assignment6;  
use Assignment6;

CREATE TABLE Employee (
    EmployeeID 					INT AUTO_INCREMENT,
    EmployeeLastName 			NVARCHAR(255),
    EmployeeFistName 			NVARCHAR(255),
    EmployeeHireDate 			DATE,
    EmployeeStatus 				TEXT,
    SupervisorID 				INT,
    SocialSecurityNumber 		INT,
PRIMARY KEY (EmployeeID),
    FOREIGN KEY (SupervisorID)
        REFERENCES Employee (EmployeeID)
);

CREATE TABLE Projects (
    ProjectID 					INT AUTO_INCREMENT,
    EmployeeID 					INT,
    ProjectName 				NVARCHAR(255),
    ProjectStartDate	 		DATE,
    ProjectDescription 			TEXT,
    ProjectDetailt 				TEXT,
    ProjectCompletedOn 			DATE,
PRIMARY KEY (ProjectID),
    FOREIGN KEY (EmployeeID)
        REFERENCES Employee (EmployeeID)
);

CREATE TABLE Project_Modules (
    ModuleID 					INT AUTO_INCREMENT,
    ProjectID 					INT,
    EmployeeID 					INT,
    ProjectModulesDate 			DATE,
    ProjectModulesCompletedOn 	DATE,
    ProjectModulesDescription 	TEXT,
PRIMARY KEY (ModuleID),
    FOREIGN KEY (ProjectID)
        REFERENCES Projects (ProjectID)
        ON DELETE CASCADE
);

CREATE TABLE Work_Done (
    WorkDoneID 					INT AUTO_INCREMENT,
    EmployeeID 					INT,
    ModuleID 					INT,
    WorkDoneDate 				DATE,
    WorkDoneDescription 		TEXT,
    WorkDoneStatus 				TEXT,
PRIMARY KEY (WorkDoneID),
    FOREIGN KEY (EmployeeID)
        REFERENCES Employee (EmployeeID),
    FOREIGN KEY (ModuleID)
        REFERENCES Project_Modules (ModuleID)
        ON DELETE CASCADE
);

INSERT INTO Employee
(EmployeeLastName	,EmployeeFistName	,EmployeeHireDate	,EmployeeStatus	,SupervisorID	,SocialSecurityNumber	)
VALUES
('Nguyen'			,'Hung'				,'2017-07-07'		,'Om'			,1				,1						),
('Nguyen'			,'Huong'			,'2017-07-07'		,'Met'			,1				,3						),
('Le'				,'Minh'				,'2017-07-07'		,'Khoe'			,null			,6						);

INSERT INTO Projects
(EmployeeID	,ProjectName	,ProjectStartDate	,ProjectDescription	,ProjectDetailt	,ProjectCompletedOn	)
VALUES
(1			,'Java Web'		,'2018-09-09'		,'Spring Boot'		,'Web TMDT'		,'2019-12-30'		),
(1			,'C# Web'		,'2019-09-09'		,'ASP.NET MVC'		,'Web TMDT'		,'2020-12-30'		),
(2			,'NodeJS Web'	,'2017-09-09'		,'AngularJS'		,'Web TMDT'		,'2018-12-30'		);

INSERT INTO Project_Modules
(ProjectID,EmployeeID,ProjectModulesDate,ProjectModulesCompletedOn,ProjectModulesDescription)
VALUES
(1,1,'2018-09-09','2018-12-30','Thiet ke CSDL'),
(1,1,'2019-01-01','2019-02-25','Spring Boot'),
(1,2,'2018-09-09','2019-12-30','Nothing'),
(2,1,'2018-09-09','2018-12-30','Thiet ke CSDL'),
(2,1,'2018-09-09','2018-12-30','Thiet ke Web'),
(3,1,'2018-09-09','2018-12-30','Thiet ke CSDL'),
(3,1,'2019-09-09','2019-12-30','Thiet ke Front End');

INSERT INTO Work_Done
(EmployeeID,ModuleID,WorkDoneDate,WorkDoneDescription,WorkDoneStatus)
VALUES
(1,1,'2018-12-30','Xong tot','Xong'),
(1,2,'2019-02-25','Kem','Xong'),
(2,3,null,'Kem','Chua xong'),
(2,4,'2019-03-30','Kem','Xong'),
(2,5,null,'Kem','Chua xong'),
(2,6,'2019-03-30','Kem','Xong'),
(2,7,'2019-05-30','Kem','Xong');


DROP PROCEDURE IF EXISTS sp_RemoveProject;
DELIMITER $$
CREATE PROCEDURE sp_RemoveProject()
	BEGIN
		-- PRINT THE TOTAL RECORD
		SET @total=0;
		WITH cte_total_record AS
		(
			SELECT 
				p.ProjectID, 
                (COUNT(pm.ModuleID) + COUNT(wd.WorkDoneID)) AS total_record 
			FROM Projects p
			JOIN Project_Modules pm ON p.ProjectID = pm.ProjectID
			JOIN Work_Done wd ON pm.ModuleID = wd.ModuleID
			WHERE p.ProjectID NOT IN	
				(
					SELECT p.ProjectID
					FROM Projects p
					JOIN Project_Modules pm ON p.ProjectID = pm.ProjectID
					JOIN Work_Done wd ON pm.ModuleID = wd.ModuleID
					WHERE wd.WorkDoneDate IS NULL
					GROUP BY p.ProjectID
				)	
			GROUP BY p.ProjectID
			HAVING MAX(wd.WorkDoneDate) < SUBDATE(CURDATE(),INTERVAL 90 DAY)
		)
		SELECT SUM(total_record) INTO @total FROM cte_total_record;
		SELECT concat ("So ban ghi bi xoa la: ", @total) as '';
        
		-- DELETE RECORD --
        -- DELETE PROJECTS
        WITH cte_delete_p AS
		(
			SELECT p.ProjectID AS id
			FROM Projects p
			JOIN Project_Modules pm ON p.ProjectID = pm.ProjectID
			JOIN Work_Done wd ON pm.ModuleID = wd.ModuleID
			WHERE p.ProjectID NOT IN	
			(
				SELECT p.ProjectID
				FROM Projects p
				JOIN Project_Modules pm ON p.ProjectID = pm.ProjectID
				JOIN Work_Done wd ON pm.ModuleID = wd.ModuleID
				WHERE wd.WorkDoneDate IS NULL
				GROUP BY p.ProjectID
			)	
			GROUP BY p.ProjectID
			HAVING MAX(wd.WorkDoneDate) < SUBDATE(CURDATE(),INTERVAL 90 DAY)
		)
		DELETE FROM Projects WHERE ProjectID IN (SELECT id FROM cte_delete_p);
	END$$
DELIMITER ;

CALL sp_RemoveProject();

select * from projects;
select * from project_modules;
select * from work_done;