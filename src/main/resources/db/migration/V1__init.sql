DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id                    BIGSERIAL,
  login                 VARCHAR(30) NOT NULL UNIQUE,
  password              VARCHAR(30),
  email                 VARCHAR(30) UNIQUE,
  token                 VARCHAR(50),
  approved              BOOL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS currencies;
CREATE TABLE currencies (
      id              BIGSERIAL,
      title           VARCHAR(30) NOT NULL,
      short_title     VARCHAR(10) NOT NULL,
      precision       INT,
      index           INT,
      logo            TEXT,
      PRIMARY KEY (id)
);

DROP TABLE IF EXISTS addresses;
CREATE TABLE addresses (
      id            BIGSERIAL,
      id_client     BIGINT,
      index         INT,
      address       VARCHAR(30),
      id_currency   BIGINT,
      PRIMARY KEY (id),
      FOREIGN KEY (id_client) REFERENCES users (id),
      FOREIGN KEY (id_currency) REFERENCES currencies (id)
);

DROP TABLE IF EXISTS nodes;
CREATE TABLE nodes (
      id            BIGSERIAL,
      id_currency   BIGSERIAL,
      ip            varchar(16) NOT NULL,
      port          varchar (6) NOT NULL,
      PRIMARY KEY (id),
      FOREIGN KEY (id_currency) REFERENCES currencies (id)
);