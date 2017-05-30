CREATE TABLE positionData (
  positionNo int(11) NOT NULL AUTO_INCREMENT,
  ranking int(11) DEFAULT NULL,
  positionName varchar(50) DEFAULT NULL,
  PRIMARY KEY (positionNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE spotData (
  spotNo int(11) NOT NULL AUTO_INCREMENT,
  ranking int(11) DEFAULT NULL,
  spotName varchar(50) DEFAULT NULL,
  PRIMARY KEY (spotNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

