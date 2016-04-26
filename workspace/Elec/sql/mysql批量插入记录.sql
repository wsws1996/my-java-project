DELIMITER //  
CREATE PROCEDURE insertrecord()
BEGIN
DECLARE i INT;
SET i = 50;
WHILE i <= 150 do
        INSERT INTO `elec`.`Elec_User` (`userID`, `jctID`, `jctUnitID`, `userName`, `logonName`, `logonPwd`, `sexID`, `birthday`, `address`, `contactTel`, `email`, `mobile`, `isDuty`, `postID`, `onDutyDate`, `offDutyDate`, `remark`) VALUES (UUID(), '3', '2', UUID(), UUID(), 'D9840773233FA6B19FDE8CAF765402F5', '1', '2016-04-06 00:00:00', UUID(), '8888888', 'liang@sina.com', '13213213212', '1', '1', '2016-04-12 00:00:00', NULL, UUID());
        SET i = i + 1;
    END while;
	end; //  
	DELIMITER ; 
