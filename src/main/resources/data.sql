-- cats table
INSERT INTO cats (name, age) VALUES ('Milo',1);
INSERT INTO cats (name, age) VALUES ('Nana',5);
INSERT INTO cats (name, age) VALUES ('Miu',9);

-- members table
-- Default passwords here are: test123
INSERT INTO `members`
VALUES
('ana','{bcrypt}$2a$12$q4rrzkXJASN.do2i/jkr.e.xoJabQVWtx39TygaUM4YICDPJJu9fG',1),
('topson','{bcrypt}$2a$12$q4rrzkXJASN.do2i/jkr.e.xoJabQVWtx39TygaUM4YICDPJJu9fG',1),
('notail','{bcrypt}$2a$12$q4rrzkXJASN.do2i/jkr.e.xoJabQVWtx39TygaUM4YICDPJJu9fG',1);

-- roles table
INSERT INTO `roles`
VALUES
('ana','ROLE_EMPLOYEE'),
('topson','ROLE_EMPLOYEE'),
('topson','ROLE_MANAGER'),
('notail','ROLE_EMPLOYEE'),
('notail','ROLE_MANAGER'),
('notail','ROLE_ADMIN');