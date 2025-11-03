create table benchmark(bid int IDENTITY(1,1),audit_Type varchar(30),acceptable_No int,remedial_Action varchar(200));
INSERT INTO benchmark(bid,audit_Type,acceptable_No,remedial_Action) VALUES(1,'Internal',3,'Action to be taken in 2 weeks');
INSERT INTO benchmark(bid,audit_Type,acceptable_No,remedial_Action) VALUES(2,'SOX',1,'Action to be taken in 1 week');