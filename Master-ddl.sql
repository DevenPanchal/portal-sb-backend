CREATE SCHEMA if not exists  `jobportal`  ;

Use `jobportal`;

CREATE TABLE if not exists `job` (
  `jobid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `keywords` text,
  `location` varchar(100) NOT NULL,
  `salaryrange` varchar(100) DEFAULT NULL,
  `postedby` varchar(100) NOT NULL,
  `image` text,
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB ;

CREATE TABLE if not exists  `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `photo` text,
  `resume` text,
  `skills` text,
  `password` text,
  `role` varchar(100) NOT NULL,
  `education` varchar(100) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=62;


CREATE TABLE `userjob` (
    `userid` INT(11) NOT NULL,
    `jobid` INT(11) NOT NULL,
    KEY `jobid_idx` (`jobid`),
    KEY `userid_idx` (`userid`),
    CONSTRAINT `jobid` FOREIGN KEY (`jobid`)
        REFERENCES `job` (`jobid`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `userid` FOREIGN KEY (`userid`)
        REFERENCES `user` (`userid`)
)  ENGINE=INNODB;

