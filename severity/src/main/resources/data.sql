CREATE TABLE Project_Audit (
project_id int AUTO_INCREMENT,
application_ownername varchar(255) ,
project_manager_name varchar(100) ,
project_name varchar(255) DEFAULT NULL

);




CREATE TABLE audit_details (
aid int NOT NULL AUTO_INCREMENT,
audit_date datetime(6) DEFAULT NULL,
audit_type varchar(255) DEFAULT NULL,
execution_status varchar(255) DEFAULT NULL,
remedial_action varchar(255) DEFAULT NULL,
pid int DEFAULT NULL,
PRIMARY KEY (aid),
FOREIGN KEY (pid) REFERENCES Project_Audit (project_id));

CREATE TABLE project_user (
puid int NOT NULL AUTO_INCREMENT,
uname varchar(255) DEFAULT NULL,
pid int DEFAULT NULL,
PRIMARY KEY (puid),
FOREIGN KEY (pid) REFERENCES Project_Audit (project_id));



INSERT into Project_Audit (project_id,application_ownername,project_manager_name,project_name) values(12,'himanshu','karthik','audit management');
INSERT into Project_Audit (project_id,application_ownername,project_manager_name,project_name) values(13,'Rahul','Vinayak','factory management');

INSERT INTO audit_details (aid,audit_date,audit_type,execution_status,remedial_action,pid) VALUES(1,'2022-12-03 12:00:00','Internal','green','No action needed',12);
INSERT INTO audit_details (aid,audit_date,audit_type,execution_status,remedial_action,pid) VALUES(2,'2022-03-05 12:00:00','SOX','green','Action to be taken in 2 weeks',13);



INSERT INTO project_user (puid,uname,pid) VALUES(1,'vishal',12);
INSERT INTO project_user (puid,uname,pid) VALUES(2,'sagar',13);