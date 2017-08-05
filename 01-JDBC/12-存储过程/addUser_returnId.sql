DELIMITER $$    /* $$作为结束符 */

CREATE

    PROCEDURE `db_jdbc`.`addUser_returnId`(IN NAME VARCHAR(45), IN birthday DATE, IN money FLOAT, OUT id INT)   /* $$输入三个参数，返回id */

    BEGIN
	INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES (NAME, birthday, money);
	/* MySql特有函数，不通用 */
	SELECT LAST_INSERT_ID() INTO id;
    END$$

DELIMITER ;