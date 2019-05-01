CREATE SCHEMA `jobportal` ;

CREATE TABLE `job` (
  `jobid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `keywords` text,
  `location` varchar(100) NOT NULL,
  `salaryrange` varchar(100) DEFAULT NULL,
  `postedby` varchar(100) NOT NULL,
  `image` text,
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `userjob` (
  `userid` int(11) NOT NULL,
  `jobid` int(11) NOT NULL,
  KEY `jobid_idx` (`jobid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `jobid` FOREIGN KEY (`jobid`) REFERENCES `job` (`jobid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci