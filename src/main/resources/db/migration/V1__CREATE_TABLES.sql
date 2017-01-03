-- CREATE FANS, MUSICIANS, PLACES, FAVORITE_MUSICIANS, FAVORITE_PLACES
CREATE TABLE IF NOT EXISTS FANS (
  ID              SERIAL,
  NAME            VARCHAR(50) NOT NULL,
  EMAIL           VARCHAR(50) NOT NULL,
  PASSWORD_DIGEST CHAR(60)    NOT NULL,
  REMEMBER_TOKEN  CHAR(32)    NOT NULL,
  RATING          INT DEFAULT 0,
  CONSTRAINT PK_FANS PRIMARY KEY (ID),
  CONSTRAINT UQ_FAN_NAME UNIQUE (NAME),
  CONSTRAINT UQ_FAN_EMAIL UNIQUE (EMAIL)
);

CREATE TABLE IF NOT EXISTS GENRES (
  ID   SERIAL,
  NAME VARCHAR(255) NOT NULL,
  CONSTRAINT PK_GENRES PRIMARY KEY (ID),
  CONSTRAINT UQ_GENRE_NAME UNIQUE (NAME)
);

CREATE TABLE IF NOT EXISTS MUSICIANS (
  ID              SERIAL,
  NAME            VARCHAR(50) NOT NULL,
  EMAIL           VARCHAR(50) NOT NULL,
  PASSWORD_DIGEST CHAR(60)    NOT NULL,
  REMEMBER_TOKEN  CHAR(32)    NOT NULL,
  RATING          INT DEFAULT 0,
  GENRE           VARCHAR(255),
  CONSTRAINT PK_MUSICIANS PRIMARY KEY (ID),
  CONSTRAINT FK_GENRES FOREIGN KEY (GENRE) REFERENCES GENRES (NAME),
  CONSTRAINT UQ_MUSICIAN_NAME UNIQUE (NAME),
  CONSTRAINT UQ_MUSICIAN_EMAIL UNIQUE (EMAIL)
);

CREATE TABLE IF NOT EXISTS PLACES (
  ID              SERIAL,
  NAME            VARCHAR(50) NOT NULL,
  EMAIL           VARCHAR(50) NOT NULL,
  PASSWORD_DIGEST CHAR(60)    NOT NULL,
  REMEMBER_TOKEN  CHAR(32)    NOT NULL,
  RATING          INT DEFAULT 0,
  CONSTRAINT PK_PLACES PRIMARY KEY (ID),
  CONSTRAINT UQ_PLACE_NAME UNIQUE (NAME),
  CONSTRAINT UQ_PLACE_EMAIL UNIQUE (EMAIL)
);

CREATE TABLE IF NOT EXISTS FAVORITE_MUSICIANS (
  ID          SERIAL,
  FAN_ID      INT,
  MUSICIAN_ID INT,
  CONSTRAINT PK_FAV_MUSICIANS PRIMARY KEY (ID),
  CONSTRAINT FK_FANS FOREIGN KEY (FAN_ID) REFERENCES FANS (ID),
  CONSTRAINT FK_MUSICIANS FOREIGN KEY (MUSICIAN_ID) REFERENCES MUSICIANS (ID),
  CONSTRAINT UQ_FAN_MUSICIAN UNIQUE (FAN_ID, MUSICIAN_ID)
);

CREATE TABLE IF NOT EXISTS FAVORITE_PLACES (
  ID       SERIAL,
  FAN_ID   INT,
  PLACE_ID INT,
  CONSTRAINT PK_FAV_PLACES PRIMARY KEY (ID),
  CONSTRAINT FK_FANS FOREIGN KEY (FAN_ID) REFERENCES FANS (ID),
  CONSTRAINT FK_PLACES FOREIGN KEY (PLACE_ID) REFERENCES PLACES (ID),
  CONSTRAINT UQ_FAN_PLACE UNIQUE (FAN_ID, PLACE_ID)
);
