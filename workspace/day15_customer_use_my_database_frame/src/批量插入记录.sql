DELIMITER //  
CREATE PROCEDURE ru()
BEGIN
DECLARE i INT;
SET i = 50;
WHILE i <= 150 do
        INSERT  INTO customer
        VALUES(i ,'123456' ,'l','2000-01-01','1454','rr@qq.com',null,null,null);
        SET i = i + 1;
    END while;
	end; //  
	DELIMITER ; 
