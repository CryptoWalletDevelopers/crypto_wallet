DROP TABLE IF EXISTS role_tbl;
CREATE TABLE role_tbl (
                       id                    INT,
                       title                 VARCHAR(20) NOT NULL UNIQUE,
                       PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_tbl;
CREATE TABLE user_tbl (
  id                    BIGSERIAL,
  login                 VARCHAR(30) NOT NULL UNIQUE,
  password              VARCHAR(255),
  email                 VARCHAR(30) NOT NULL UNIQUE,
  token                 VARCHAR(50),
  approved              BOOL,
  date_exp              TIMESTAMP,
  id_role_tbl               INT,
  PRIMARY KEY (id),
  FOREIGN KEY (id_role_tbl) REFERENCES role_tbl(id)
);

DROP TABLE IF EXISTS currency_tbl;
CREATE TABLE currency_tbl (
      id              BIGSERIAL,
      title           VARCHAR(30) NOT NULL,
      short_title     VARCHAR(10) NOT NULL,
      precision       INT,
      index           INT,
      logo            TEXT,
      PRIMARY KEY (id)
);

DROP TABLE IF EXISTS address_tbl;
CREATE TABLE address_tbl (
      id            BIGSERIAL,
      id_user       BIGINT,
      index         INT,
      address       VARCHAR(70),
      id_currency   BIGINT,
      PRIMARY KEY (id),
      FOREIGN KEY (id_user) REFERENCES user_tbl (id),
      FOREIGN KEY (id_currency) REFERENCES currency_tbl (id)
);

DROP TABLE IF EXISTS node_tbl;
CREATE TABLE node_tbl (
      id            BIGSERIAL,
      id_currency   BIGSERIAL,
      ip            varchar(16) NOT NULL,
      port          varchar (6) NOT NULL,
      PRIMARY KEY (id),
      FOREIGN KEY (id_currency) REFERENCES currency_tbl (id)
);

INSERT INTO role_tbl (id, title) VALUES (1, 'ROLE_USER');
INSERT INTO role_tbl (id, title) VALUES (2, 'ROLE_ADMIN');