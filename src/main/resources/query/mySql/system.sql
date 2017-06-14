CREATE TABLE bordSetting(
  bordNo INT (11) NOT NULL AUTO_INCREMENT,
  sequence INT (11) NOT NULL,
  bordName VARCHAR (50) DEFAULT NULL,
  used tinyint(1) DEFAULT NULL,
  PRIMARY KEY (bordNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE defaultSystemSetting(
  systemSettingNo int(11) not NULL AUTO_INCREMENT,
  browserTitle VARCHAR (50) DEFAULT NULL,
  PRIMARY KEY(systemSettingNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;