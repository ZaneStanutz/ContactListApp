/***********************************************************
* Create the database named contact and user contact_user
************************************************************/
DROP DATABASE IF EXISTS contact;

CREATE DATABASE contact;

USE contact;

CREATE TABLE Contact (
	UserID INT NOT NULL AUTO_INCREMENT,
    Email Varchar(50),
    FirstName VARCHAR(50),
	LastName VARCHAR(50),
    PhoneNumber VARCHAR(15),
    
    PRIMARY KEY(UserId)
); 

-- Create contact_user and grant privileges

DELIMITER //
CREATE PROCEDURE drop_user_if_exists()
BEGIN
    DECLARE userCount BIGINT DEFAULT 0 ;

    SELECT COUNT(*) INTO userCount FROM mysql.user
    WHERE User = 'contact_user' and  Host = 'localhost';

    IF userCount > 0 THEN
        DROP USER contact_user@localhost;
    END IF;
END ; //
DELIMITER ;

CALL drop_user_if_exists() ;

CREATE USER contact_user@localhost IDENTIFIED BY 'root';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP
ON contact.*
TO contact_user@localhost;