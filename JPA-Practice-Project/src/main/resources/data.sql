--create table course (
-- 
--	       id bigint not null,
--	        creation_time timestamp,
--	        last_update_time timestamp,
--	        name varchar(255) not null,
--	        primary key (id)
--	    )
INSERT INTO COURSE (ID, NAME, creation_time, last_update_time) 
VALUES(10001,  'Java', sysdate, sysdate);
INSERT INTO COURSE (ID, NAME, creation_time, last_update_time) 
VALUES(10002,  'Spring', sysdate, sysdate);
INSERT INTO COURSE (ID, NAME, creation_time, last_update_time) 
VALUES(10003,  'Devops', sysdate, sysdate);
