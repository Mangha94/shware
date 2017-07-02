CREATE TABLE boardSetting(
  boardNo INT (11) NOT NULL AUTO_INCREMENT,
  sequence INT (11) NOT NULL,
  boardName VARCHAR (50) DEFAULT NULL,
  used tinyint(1) DEFAULT NULL,
  PRIMARY KEY (boardNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE defaultSystemSetting(
  systemSettingNo int(11) not NULL AUTO_INCREMENT,
  browserTitle VARCHAR (50) DEFAULT NULL,
  PRIMARY KEY(systemSettingNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;