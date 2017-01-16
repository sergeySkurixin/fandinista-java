CREATE TABLE IF NOT EXISTS performances (
  id       BIGSERIAL,
  place_id BIGINT,
  name     VARCHAR(255) NOT NULL,
  CONSTRAINT pk_performances PRIMARY KEY (id),
  CONSTRAINT fk_perf_places FOREIGN KEY (place_id) REFERENCES places (id)
);

CREATE TABLE IF NOT EXISTS performance_musicians (
  id             BIGSERIAL,
  performance_id BIGINT,
  musician_id    BIGINT,
  CONSTRAINT pk_perf_musicians PRIMARY KEY (id),
  CONSTRAINT fk_performances FOREIGN KEY (performance_id) REFERENCES performances (id),
  CONSTRAINT fk_perf_musicians FOREIGN KEY (musician_id) REFERENCES musicians (id)
);
