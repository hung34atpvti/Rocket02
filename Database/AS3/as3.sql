-- use db fresher
USE fresher;


-- Question 1: Add at least 10 records into created table
INSERT INTO trainee
(Full_Name				,Birth_Date		,Gender		,ET_IQ	,ET_Gmath	,ET_English		,Training_Class	,Evaluation_Notes	,VTI_Account	) 
VALUES
('Nguyen Le Minh'		,'1998-12-16'	,'male'		,5		,5			,5				,'CNTT58A'		,'Thong minh'		,'minhnguyenle'	),
('Cao Ba Quat'			,'1998-7-16'	,'male'		,15		,15			,19				,'CNTT58A'		,'Thong minh'		,'quatcaoba'	),
('Cao Thu Thao'			,'1998-8-16'	,'female'	,1		,15			,19				,'CNTT58A'		,'Thong minh'		,'thaocaothu'	),
('Le Nin'				,'1998-9-16'	,'male'		,5		,5			,19				,'CNTT58A'		,'Thong minh'		,'LN'			),
('Le Thi Than Thanh'	,'1998-10-16'	,'female'	,15		,1			,19				,'CNTT58A'		,'Thong minh'		,'LTC'			),
('Tran Van Do'			,'1998-11-16'	,'male'		,15		,5			,19				,'CNTT58A'		,'Thong minh'		,'TVB'			),
('Nguyen Van Sinh'		,'1998-12-16'	,'male'		,1		,15			,19				,'CNTT58A'		,'Thong minh'		,'NVA'			),
('Nguyen Thi Ngoc'		,'1998-01-16'	,'female'	,5		,5			,9				,'CNTT58A'		,'Cham hieu'		,'NTN'			),
('Nguyen Thao Phuong'	,'1998-02-16'	,'female'	,20		,20			,20				,'CNTT58A'		,'Nhanh tri'		,'NTP'			),
('Le Thu Huong'			,'1998-03-16'	,'female'	,1		,15			,9				,'CNTT58A'		,'Cham'				,'LTH'			);


-- Question 2: Query all the trainees who is passed the entry test, group them into different birth months
SELECT 
	*
FROM
	trainee
GROUP BY
	TraineeID
HAVING 
	MONTH(Birth_Date)
ORDER BY
	MONTH(Birth_Date);

	 
-- Question 3: Query the trainee who has the longest name, showing his/her age along with his/her basic information (as defined in the table)
SELECT 
	TraineeID, Full_Name, Birth_Date, Gender
FROM
	trainee
WHERE
	LENGTH(Full_Name) = (
						SELECT 
							MAX(LENGTH(Full_Name)) 
						FROM 
							trainee
                        );

    
/*
Question 4: Query all the ET-passed trainees. One trainee is considered as ET-passed
when he/she has the entry test points satisfied below criteria:
	ET_IQ + ET_Gmath>=20
	ET_IQ>=8
	ET_Gmath>=8
	ET_English>=18
*/
SELECT 
    *
FROM
    trainee
WHERE
    (ET_IQ + ET_Gmath) >= 20 
    AND ET_IQ >= 8
	AND ET_Gmath >= 8
	AND ET_English >= 18;

    
-- Question 5: delete information of trainee who has TraineeID = 3
DELETE FROM
	trainee
WHERE
	TraineeID = 3;

    
-- Question 6: trainee who has TraineeID = 5 move "2" class. Let update information into database
UPDATE
	trainee
SET
	Training_Class = '2'
WHERE
	TraineeID = 5;


