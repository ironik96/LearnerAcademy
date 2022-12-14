CREATE TABLE Teacher(
    t_id int NOT NULL AUTO_INCREMENT,
    t_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(t_id)
);
CREATE TABLE Class(
    c_id int NOT NULL AUTO_INCREMENT,
    c_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(c_id)
);
CREATE TABLE Subject(
    sbjct_id int NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY(sbjct_id)
);
CREATE TABLE Student(
    stdnt_id int NOT NULL AUTO_INCREMENT,
    stdnt_name VARCHAR(255) NOT NULL,
    c_id int NOT NULL,
    PRIMARY KEY(stdnt_id),
    FOREIGN KEY (c_id) REFERENCES Class(c_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
CREATE TABLE TeacherClassSubject(
    c_id int NOT NULL,
    sbjct_id int NOT NULL,
    t_id int,
    CONSTRAINT pk_tcs PRIMARY KEY (c_id, sbjct_id),
    FOREIGN KEY (c_id) REFERENCES Class(c_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (sbjct_id) REFERENCES Subject(sbjct_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (t_id) REFERENCES Teacher(t_id)
    ON DELETE SET NULL
    ON UPDATE SET NULL

);