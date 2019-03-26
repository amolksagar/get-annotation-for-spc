CREATE DATABASE IF NOT EXISTS `byo`;
USE `byo`;

CREATE TABLE IF NOT EXISTS ANNOTATION (
  id smallint(5) NOT NULL AUTO_INCREMENT primary key,
  adjustmentValue decimal(5,2) NOT NULL,
  adjustmentType char(1) NOT NULL,
  createdDate datetime NOT NULL ,
  expiredDate datetime NOT NULL ,
  currentValue decimal(5,2) NOT NULL,
  spId varchar(5) NOT NULL,
  spcId varchar(5) NOT NULL,  
  foreign key SPID_FK(spId)
  REFERENCES STATISTICAL_PROGRAM(ID) ON DELETE CASCADE ON UPDATE CASCADE,
  foreign key SPCID_FK(spcId)
  REFERENCES STATISTICAL_PROGRAM_CYCLE(ID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB;

insert into ANNOTATION (id,adjustmentValue,adjustmentType,createdDate,expiredDate,currentValue,spId,spcId) 
values (1,12,'A','2012-09-17 18:47:52','2018-09-17 18:47:52',100,'XYZ','XYZC');
insert into ANNOTATION (id,adjustmentValue,adjustmentType,createdDate,expiredDate,currentValue,spId,spcId) 
values (2,20,'M','2016-09-16 18:47:52','2017-09-17 18:47:52',100,'ABC','ABCC');
insert into ANNOTATION (id,adjustmentValue,adjustmentType,createdDate,expiredDate,currentValue,spId,spcId) 
values (3,29,'A','2012-09-12 18:47:52','2013-09-13 18:47:52',100,'QRT','QRTC');
insert into ANNOTATION (id,adjustmentValue,adjustmentType,createdDate,expiredDate,currentValue,spId,spcId) 
values (4,42,'A','2012-09-07 18:47:52','2014-09-23 18:47:52',100,'QRT','QRTC');
insert into ANNOTATION (id,adjustmentValue,adjustmentType,createdDate,expiredDate,currentValue,spId,spcId) 
values (5,56,'A','2017-09-17 18:47:52','2018-09-01 18:47:52',100,'QRT','QRTC');

select * from annotation;