USE adventureworks;

-- EX1
-- Q1:
-- Method 1: Subqueries
SELECT 
    p.Name
FROM
    product p
WHERE
    EXISTS( SELECT 
            1
        FROM
            productsubcategory psc
        WHERE
            p.ProductSubcategoryID = psc.ProductSubcategoryID
                AND psc.name = 'Saddles');
-- Method 2: Join
SELECT 
    p.Name
FROM
    product p
        JOIN
    productsubcategory psc ON p.ProductSubcategoryID = psc.ProductSubcategoryID
WHERE
    psc.name = 'Saddles';

-- Q2:
-- Method 1: Subqueries
SELECT 
    p.Name
FROM
    product p
WHERE
    EXISTS( SELECT 
            1
        FROM
            productsubcategory psc
        WHERE
            p.ProductSubcategoryID = psc.ProductSubcategoryID
                AND psc.name LIKE 'Bo%');
-- Method 2: Join
SELECT 
    p.Name
FROM
    product p
        JOIN
    productsubcategory psc ON p.ProductSubcategoryID = psc.ProductSubcategoryID
WHERE
    psc.name LIKE 'Bo%';
    
-- Q3:
SELECT 
    P.Name, P.ListPrice
FROM
    product p
WHERE
    p.ProductSubcategoryID = 3
	AND p.ListPrice = (SELECT 
							MIN(ListPrice)
						FROM
							(	SELECT 
									p.ListPrice
								FROM
									product p
								WHERE
									p.ProductSubcategoryID = 3) AS listpriceproduct);


               
    

    



