--create table course (
-- 
--	       id bigint not null,
--	        creation_time timestamp,
--	        last_update_time timestamp,
--	        name varchar(255) not null,
--	        primary key (id)
--	    )

-- Dummy data to Insert into Course table at startup
INSERT INTO COURSE (ID, NAME, creation_time, last_update_time) 
VALUES(10001,  'Java', sysdate, sysdate);
INSERT INTO COURSE (ID, NAME, creation_time, last_update_time) 
VALUES(10002,  'Spring', sysdate, sysdate);
INSERT INTO COURSE (ID, NAME, creation_time, last_update_time) 
VALUES(10003,  'Devops', sysdate, sysdate);


-- Dummy data to Insert into Student table at startup
INSERT INTO STUDENT (ID, NAME, creation_time, last_update_time) 
VALUES(20001,  'Sanjeev Kumar', sysdate, sysdate);
INSERT INTO STUDENT (ID, NAME, creation_time, last_update_time) 
VALUES(20002,  'Saloni Kumari', sysdate, sysdate);
INSERT INTO STUDENT (ID, NAME, creation_time, last_update_time) 
VALUES(20003,  'Swati Shefali', sysdate, sysdate);


-- Dummy data to Insert into Passport table at startup
INSERT INTO PASSPORT (ID, NUMBER, creation_time, last_update_time) 
VALUES(30001,  'H23490', sysdate, sysdate);
INSERT INTO PASSPORT (ID, NUMBER, creation_time, last_update_time) 
VALUES(30002,  'W45612', sysdate, sysdate);
INSERT INTO PASSPORT (ID, NUMBER, creation_time, last_update_time) 
VALUES(30003,  'Q08787', sysdate, sysdate); 

-- Dummy data to Insert into Review table at startup
INSERT INTO REVIEW (ID, RATING, DESCRIPTION, creation_time, last_update_time) 
VALUES(30001,  '5', 'Excellent course !!!', sysdate, sysdate);
INSERT INTO REVIEW (ID, RATING, DESCRIPTION, creation_time, last_update_time) 
VALUES(30002,  '4', 'Nice tutorial. Keep it up', sysdate, sysdate);
INSERT INTO REVIEW (ID, RATING, DESCRIPTION, creation_time, last_update_time) 
VALUES(30003,  '3', 'Thank you for the tutorial', sysdate, sysdate);

