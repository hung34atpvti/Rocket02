-- EX1:
USE Assignment6;

DROP TRIGGER IF EXISTS check_condition_ins_pm;
DELIMITER $$
CREATE TRIGGER check_condition_ins_pm
BEFORE INSERT ON Project_Modules
FOR EACH ROW
	BEGIN
		DECLARE pm_d,p_sd,pm_c,p_pc DATE;
        
        SET pm_d = NEW.ProjectModulesDate;
        SET pm_c = NEW.ProjectModulesCompletedOn;
        SELECT ProjectStartDate INTO p_sd FROM Projects WHERE ProjectID = NEW.ProjectID;
        SELECT ProjectCompletedOn INTO p_pc FROM Projects WHERE ProjectID = NEW.ProjectID;  
		
        IF (pm_d<p_sd OR pm_c>p_pc) THEN
			
            IF (pm_d<p_sd AND pm_c>p_pc) THEN
				SIGNAL SQLSTATE '45000'
				SET message_text = 'Need (ProjectModulesDate > ProjectStartDate) || (ProjectModulesCompletedOn < ProjectCompletedOn)';
			
            ELSEIF (pm_c>p_pc) THEN
				SIGNAL SQLSTATE '45000'
				SET message_text = 'ProjectModulesCompletedOn must be smaller than ProjectCompletedOn';	
		
			ELSE
				SIGNAL SQLSTATE '45000'
				SET message_text = 'ProjectModulesDate must be bigger than ProjectStartDate';			
            
            END IF;	
            
        END IF;
	END $$
DELIMITER ;

INSERT INTO Project_Modules
(ProjectID,EmployeeID,ProjectModulesDate,ProjectModulesCompletedOn,ProjectModulesDescription)
VALUES
(1,1,'2017-09-09','2018-12-30','Thiet ke CSDL');

INSERT INTO Project_Modules
(ProjectID,EmployeeID,ProjectModulesDate,ProjectModulesCompletedOn,ProjectModulesDescription)
VALUES
(1,1,'2018-09-09','2020-12-30','Thiet ke CSDL');

INSERT INTO Project_Modules
(ProjectID,EmployeeID,ProjectModulesDate,ProjectModulesCompletedOn,ProjectModulesDescription)
VALUES
(1,1,'2017-09-09','2020-12-30','Thiet ke CSDL');

-- EX2:
USE fresher;

CREATE VIEW v_ex2 AS
	SELECT 
		*
	FROM
		trainee
	WHERE
		(ET_IQ + ET_Gmath) >= 20 
		AND ET_IQ >= 8
		AND ET_Gmath >= 8
		AND ET_English >= 18;
    
SELECT * FROM v_ex2;