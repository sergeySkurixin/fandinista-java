-- entity tables
CREATE TABLE IF NOT EXISTS users (
  id              BIGSERIAL,
  name            VARCHAR(50) NOT NULL,
  email           VARCHAR(50) NOT NULL,
  password_digest CHAR(60)    NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (id),
  CONSTRAINT uq_musician_name UNIQUE (name),
  CONSTRAINT uq_musician_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS fans (
  id BIGINT NOT NULL,
  CONSTRAINT pk_fans PRIMARY KEY (id),
  CONSTRAINT fk_users_1 FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS genres (
  id   SERIAL,
  name VARCHAR(255) NOT NULL,
  CONSTRAINT pk_genres PRIMARY KEY (id),
  CONSTRAINT uq_genre_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS musicians (
  id     BIGINT NOT NULL,
  rating INT DEFAULT 0,
  genre  VARCHAR(255),
  CONSTRAINT pk_musicians PRIMARY KEY (id),
  CONSTRAINT fk_users_2 FOREIGN KEY (id) REFERENCES users (id),
  CONSTRAINT fk_genres FOREIGN KEY (genre) REFERENCES genres (name)
);

CREATE TABLE IF NOT EXISTS places (
  id     BIGINT NOT NULL,
  rating INT DEFAULT 0,
  CONSTRAINT pk_places PRIMARY KEY (id),
  CONSTRAINT fk_users_3 FOREIGN KEY (id) REFERENCES users (id)
);

-- relations
CREATE TABLE IF NOT EXISTS favorite_musicians (
  id          BIGSERIAL,
  fan_id      BIGINT NOT NULL,
  musician_id BIGINT NOT NULL,
  CONSTRAINT pk_fav_musicians PRIMARY KEY (id),
  CONSTRAINT fk_fans_1 FOREIGN KEY (fan_id) REFERENCES fans (id),
  CONSTRAINT fk_musicians FOREIGN KEY (musician_id) REFERENCES musicians (id),
  CONSTRAINT uq_fan_musician UNIQUE (fan_id, musician_id)
);

CREATE TABLE IF NOT EXISTS favorite_places (
  id       BIGSERIAL,
  fan_id   BIGINT NOT NULL,
  place_id BIGINT NOT NULL,
  CONSTRAINT pk_fav_places PRIMARY KEY (id),
  CONSTRAINT fk_fans_2 FOREIGN KEY (fan_id) REFERENCES fans (id),
  CONSTRAINT fk_places FOREIGN KEY (place_id) REFERENCES places (id),
  CONSTRAINT uq_fan_place UNIQUE (fan_id, place_id)
);

-- CREATE TABLE IF NOT EXISTS FANS (
--   ID              SERIAL,
--   NAME            VARCHAR(50) NOT NULL,
--   EMAIL           VARCHAR(50),
--   PASSWORD_DIGEST CHAR(60)    NOT NULL,
--   REMEMBER_TOKEN  CHAR(32)    NOT NULL,
--   RATING          INT DEFAULT 0,
--   CONSTRAINT PK_FANS PRIMARY KEY (ID),
--   CONSTRAINT UQ_FAN_NAME UNIQUE (NAME),
--   CONSTRAINT UQ_FAN_EMAIL UNIQUE (EMAIL)
-- );
--
-- CREATE TABLE IF NOT EXISTS GENRES (
--   ID   SERIAL,
--   NAME VARCHAR(255) NOT NULL,
--   CONSTRAINT PK_GENRES PRIMARY KEY (ID),
--   CONSTRAINT UQ_GENRE_NAME UNIQUE (NAME)
-- );
--
-- CREATE TABLE IF NOT EXISTS MUSICIANS (
--   ID              SERIAL,
--   NAME            VARCHAR(50) NOT NULL,
--   EMAIL           VARCHAR(50) NOT NULL,
--   PASSWORD_DIGEST CHAR(60)    NOT NULL,
--   REMEMBER_TOKEN  CHAR(32)    NOT NULL,
--   RATING          INT DEFAULT 0,
--   GENRE           VARCHAR(255),
--   CONSTRAINT PK_MUSICIANS PRIMARY KEY (ID),
--   CONSTRAINT FK_GENRES FOREIGN KEY (GENRE) REFERENCES GENRES (NAME),
--   CONSTRAINT UQ_MUSICIAN_NAME UNIQUE (NAME),
--   CONSTRAINT UQ_MUSICIAN_EMAIL UNIQUE (EMAIL)
-- );
--
-- CREATE TABLE IF NOT EXISTS PLACES (
--   ID              SERIAL,
--   NAME            VARCHAR(50) NOT NULL,
--   EMAIL           VARCHAR(50) NOT NULL,
--   PASSWORD_DIGEST CHAR(60)    NOT NULL,
--   REMEMBER_TOKEN  CHAR(32)    NOT NULL,
--   RATING          INT DEFAULT 0,
--   CONSTRAINT PK_PLACES PRIMARY KEY (ID),
--   CONSTRAINT UQ_PLACE_NAME UNIQUE (NAME),
--   CONSTRAINT UQ_PLACE_EMAIL UNIQUE (EMAIL)
-- );
--
-- CREATE TABLE IF NOT EXISTS FAVORITE_MUSICIANS (
--   ID          SERIAL,
--   FAN_ID      INT,
--   MUSICIAN_ID INT,
--   CONSTRAINT PK_FAV_MUSICIANS PRIMARY KEY (ID),
--   CONSTRAINT FK_FANS FOREIGN KEY (FAN_ID) REFERENCES FANS (ID),
--   CONSTRAINT FK_MUSICIANS FOREIGN KEY (MUSICIAN_ID) REFERENCES MUSICIANS (ID),
--   CONSTRAINT UQ_FAN_MUSICIAN UNIQUE (FAN_ID, MUSICIAN_ID)
-- );
--
-- CREATE TABLE IF NOT EXISTS FAVORITE_PLACES (
--   ID       SERIAL,
--   FAN_ID   INT,
--   PLACE_ID INT,
--   CONSTRAINT PK_FAV_PLACES PRIMARY KEY (ID),
--   CONSTRAINT FK_FANS FOREIGN KEY (FAN_ID) REFERENCES FANS (ID),
--   CONSTRAINT FK_PLACES FOREIGN KEY (PLACE_ID) REFERENCES PLACES (ID),
--   CONSTRAINT UQ_FAN_PLACE UNIQUE (FAN_ID, PLACE_ID)
-- );
