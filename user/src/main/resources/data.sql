create table user(uid int IDENTITY(1,1),name varchar(30),uname varchar(20),password varchar(40),role varchar(20),is_account_locked boolean );
--insert into user values(12,'himanshu','himanshu12','qwer','Role_User',false);




INSERT INTO user (uid,name,uname,password,role,is_account_locked) VALUES (12,'himanshu','himanshu12','qwer','Role_User',false);
--INSERT INTO user (user_id,user_name,user_password) VALUES (102,'lakshmi','6287');
--INSERT INTO user (user_id,user_name,user_password) VALUES (103,'shahanshah','8822');
--INSERT INTO user (user_id,user_name,user_password) VALUES (104,'dhanush','7612');