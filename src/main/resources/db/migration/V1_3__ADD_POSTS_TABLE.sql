CREATE TABLE IF NOT EXISTS posts (
  id      BIGSERIAL,
  title   VARCHAR(100),
  body    TEXT   NOT NULL,
  user_id BIGINT NOT NULL,
  CONSTRAINT pk_posts PRIMARY KEY (id),
  CONSTRAINT fk_users_posts FOREIGN KEY (user_id) REFERENCES users (id)
);
