-- CREATE TABLE menu (
--   menuNo int(11) NOT NULL AUTO_INCREMENT,
--   title varchar(255) DEFAULT NULL,
--   PRIMARY KEY (menuNo)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
--
-- CREATE TABLE submenu(
--   submenuNo int(11) NOT NULL AUTO_INCREMENT,
--   menuNo int(11) NOT NULL,
--   title VARCHAR (255) DEFAULT NULL,
--   PRIMARY KEY (submenuNo)
-- )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

-- CREATE TABLE organizationChat(
--   chatNo int(11) NOT NULL AUTO_INCREMET,
--   pNo int(11) NOT NULL,
--   departmentName VARCHAR (255) DEFAULT NULL,
-- )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8


CREATE TABLE positionData (
  positionNo int(11) NOT NULL AUTO_INCREMENT,
  ranking int(11) DEFAULT NULL,
  positionName varchar(50) DEFAULT NULL,
  PRIMARY KEY (positionNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE spotData (
  spotNo int(11) NOT NULL AUTO_INCREMENT,
  ranking int(11) DEFAULT NULL,
  spotName varchar(50) DEFAULT NULL,
  PRIMARY KEY (spotNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- CREATE TABLE member(
--   memberId VARCHAR (255) DEFAULT NULL,
--   pw VARCHAR (255) DEFAULT NULL,
--   name VARCHAR (50) DEFAULT NULL,
--   positionName VARCHAR (255) DEFAULT NULL,
--   spot VARCHAR (50) DEFAULT NULL,
--   email VARCHAR (50) DEFAULT NULL,
--   phoneNumber VARCHAR (50) DEFAULT NULL,
--   cellPhoneNumber VARCHAR (50) DEFAULT NULL,
--   pax VARCHAR (50) DEFAULT NULL,
--   entryDate DATE DEFAULT NULL,
--   PRIMARY KEY (memberId)
)

