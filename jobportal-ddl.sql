CREATE database IF NOT EXISTS jobportal ;

CREATE TABLE IF NOT EXISTS jobportal.job (
    jobid INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    keywords TEXT,
    location VARCHAR(100) NOT NULL,
    salaryrange VARCHAR(100),
    postedby VARCHAR(100) NOT NULL,
    image TEXT DEFAULT NULL,
    userid INT(11) NOT NULL,
    PRIMARY KEY (jobid)
   /* FOREIGN KEY (userid)
        REFERENCES user (userid)*/
)  ENGINE=INNODB
;

CREATE TABLE IF NOT EXISTS jobportal.user (
    userid INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    photo TEXT DEFAULT NULL,
    resume TEXT DEFAULT NULL,
    skills TEXT DEFAULT NULL,
    hashedpassword TEXT DEFAULT NULL,
    role VARCHAR(100) NOT NULL,
    education VARCHAR(100) NOT NULL,
    jobid INT(11) NOT NULL,
    PRIMARY KEY (userid)
    /*FOREIGN KEY (jobid) REFERENCES job (jobid)*/
)  ENGINE=INNODB
;

alter table jobportal.user add  FOREIGN KEY  (jobid) REFERENCES job (jobid);
alter table jobportal.job  add FOREIGN KEY (userid) REFERENCES user (userid);

ALTER TABLE jobportal.job CHANGE COLUMN userid  userid INT  NULL;
ALTER TABLE jobportal.user CHANGE COLUMN jobid jobid INT NULL;
