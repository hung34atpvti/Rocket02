DROP DATABASE IF EXISTS fte;
CREATE DATABASE IF NOT EXISTS fte;
USE fte;

-- a
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer
(
	CustomerID				INT AUTO_INCREMENT,
    Name					VARCHAR(255),
    Phone					CHAR(12),
    Email					VARCHAR(255),
    Address					VARCHAR(255),
    Note					TEXT,
PRIMARY KEY (CustomerID)
);

DROP TABLE IF EXISTS Car;
CREATE TABLE Car
(
	CarID					INT AUTO_INCREMENT,
    Maker					ENUM('HONDA','TOYOTA','NISSAN'),
    Model					VARCHAR(255),
    Year					INT,
    Color					VARCHAR(255),
    Note					TEXT,
PRIMARY KEY (CarID)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders
(
	OrderID					INT AUTO_INCREMENT,
    CustomerID				INT,
    CarID					INT,
    Amount					INT DEFAULT 1,
    SalePrice				FLOAT,
    OrderDate				DATE,
    DeliveryDate			DATE,
    DeliveryAddress			VARCHAR(255),
    Status					ENUM('0','1','2'),
    Note					TEXT,
PRIMARY KEY (OrderID),
	FOREIGN KEY (CustomerID) 	REFERENCES Customer (CustomerID),
    FOREIGN KEY (CarID) 		REFERENCES Car (CarID)
);

INSERT INTO Customer
(Name,Phone,EmaiL,Address,Note)				
VALUES
('Nguyen Manh Hung',	'0123456789',	'hung34atpvti@gmail.com',	'34atp',	'nothings'	),
('Nguyen Van Huy',		'0123456798',	'huy54@gmail.com',			'35atp',	''			),
('Tran Dinh Tung',		'0123456799',	'tung77@gmail.com',			'36atp',	''			),
('Le Phuong Thao',		'0123456788',	'thao95@gmail.com',			'37atp',	''			),
('Le Nhu Hai Yen',		'0936441998',	'yenle@gmail.com',			'38atp',	''			);

INSERT INTO Car
(Maker,Model,Year,Color,Note)
VALUES
('HONDA',	'CIVIC',	2000,	'red',		''),
('TOYOTA',	'VIOS',		2001,	'black',	''),
('NISSAN',	'GT578',	2002,	'white',	''),
('HONDA',	'WAVE',		2003,	'red',		''),
('TOYOTA',	'UPON',		2004,	'red',		'');

INSERT INTO Orders
(CustomerID,CarID,Amount,SalePrice,OrderDate,DeliveryDate,DeliveryAddress,Status,Note)
VALUES
(1, 1, 2,	200000,		'2019-09-09',	'2019-11-06',	'36 Hang Buom',			'1',	''),
(1, 2, 2,	20000,		'2019-10-08',	'2019-01-07',	'48 Hang Ma',			'1',	''),
(1, 3, 2,	2000,		'2019-11-07',	'2020-02-08',	'74 Chi Huyen',			'2',	''),
(2, 1, 2,	2000000,	'2019-12-06',	'2020-02-09',	'90 Giai Phong',		'0',	''),
(3, 3, 2,	400000,		'2020-01-05',	'2020-02-20',	'100 Hoang Quoc Viet',	'0',	'');


-- b
SELECT 	cu.CustomerID,
		cu.Name,
        COUNT(o.OrderID) AS Solanmua
FROM 	Customer AS cu
JOIN	Orders AS o
ON		cu.CustomerID=o.CustomerID
GROUP BY cu.CustomerID,cu.Name
ORDER BY Solanmua;

-- c
DROP PROCEDURE IF EXISTS hangSanXuat;
DELIMITER $$
CREATE PROCEDURE hangSanXuat()
		BEGIN			
            SET @dem=0;           
            
            WITH cte_dem AS
			(
				SELECT 	ca.Maker as Maker,
						COUNT(ca.Maker) as solanmua
				FROM Orders o
                JOIN Car ca ON o.CarID=ca.CarID
				GROUP BY ca.Maker
			)SELECT MAX(solanmua) into @dem FROM cte_dem;
            
             WITH cte_ten AS
			(
				SELECT 	ca.Maker as Maker,
						COUNT(ca.Maker) as solanmua
				FROM Orders o
                JOIN Car ca ON o.CarID=ca.CarID
				GROUP BY ca.Maker
			)SELECT Maker FROM cte_ten WHERE solanmua=@dem;					
        END$$
DELIMITER ;  

-- e
DROP PROCEDURE IF EXISTS ttKhach;
DELIMITER $$
CREATE PROCEDURE ttKhach(IN cusID INT)
	BEGIN
		SELECT o.OrderID, c.Name, o.Amount, ca.Maker
        FROM Orders o
        JOIN Customer c ON o.CustomerID=c.CustomerID
        JOIN Car ca ON o.CarID=ca.CarID
        WHERE o.CustomerID=cusID;
    END$$
DELIMITER ;

-- f
DROP TRIGGER IF EXISTS kiemtra;
DELIMITER $$
CREATE TRIGGER kiemtra
BEFORE INSERT ON Orders
FOR EACH ROW
	BEGIN
		DECLARE diDate,orDate DATE;
        SET diDate=NEW.DeliveryDate;
        SET orDate=ADDDATE(NEW.OrderDate,INTERVAL 15 DAY);
		IF (diDate < orDate) THEN 
			SIGNAL SQLSTATE '45000'
			SET message_text = 'Need (DeliveryDate > OrderDate+15)';
		END IF;
    END$$
DELIMITER ;

INSERT INTO Orders
(CustomerID,CarID,Amount,SalePrice,OrderDate,DeliveryDate,DeliveryAddress,Status,Note)
VALUES
(1,1,2,200000,'2019-09-09','2019-09-12','36 Hang Buom','1','');

-- d
DELIMITER $$
CREATE PROCEDURE xoa()
	BEGIN
		WITH cte_xoa AS
        (
			SELECT o.OrderID AS OID
			FROM Orders o        
			WHERE o.Status='2'
				AND YEAR(o.OrderDate)=YEAR(SUBDATE(CURDATE(),INTERVAL 1 YEAR))
		) SELECT COUNT(OID) FROM cte_xoa;
        
        WITH cte_xoa AS
        (
			SELECT o.OrderID AS OID
			FROM Orders o        
			WHERE o.Status='2'
				AND YEAR(o.OrderDate)=YEAR(SUBDATE(CURDATE(),INTERVAL 1 YEAR))
		) DELETE FROM Orders o 
			WHERE o.OrderID IN 
				(SELECT OID FROM cte_xoa);
    END$$
DELIMITER ;

CALL xoa();


    
        
