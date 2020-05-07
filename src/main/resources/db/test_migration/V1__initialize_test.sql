
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id                    BIGSERIAL,
  login                 VARCHAR(30) NOT NULL UNIQUE,
  password              VARCHAR(30),
  email                 VARCHAR(30) NOT NULL UNIQUE,
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

--ALTER TABLE addresses RENAME TO "address";
--
--ALTER TABLE users RENAME TO "user";
--
--ALTER TABLE currencies RENAME TO "currency";
--
--ALTER TABLE nodes RENAME TO "node";
--
--DROP TABLE IF EXISTS role;
--CREATE TABLE role (
--                       id                    INT,
--                       title                 VARCHAR(20) NOT NULL UNIQUE,
--                       PRIMARY KEY (id)
--);
--
--ALTER TABLE "user" ADD COLUMN date_exp TIMESTAMP;
--ALTER TABLE "user" ADD COLUMN id_role INT;
--ALTER TABLE "user" ADD FOREIGN KEY (id_role) REFERENCES role(id);
--ALTER TABLE "address" RENAME COLUMN id_client TO id_user;
--
--ALTER TABLE "address" RENAME TO address_tbl;
--ALTER TABLE "addresses_id_seq" RENAME TO "address_tbl_id_seq";
--
--ALTER TABLE wallet.role RENAME TO role_tbl;
--
--ALTER TABLE currency RENAME TO "currency_tbl";
--ALTER TABLE currencies_id_seq RENAME TO "currency_tbl_id_seq";
--
--ALTER TABLE node RENAME TO "node_tbl";
--ALTER TABLE nodes_id_seq RENAME TO "node_tbl_id_seq";
--
--ALTER TABLE wallet.user RENAME TO user_tbl;
--ALTER TABLE users_id_seq RENAME TO "user_tbl_id_seq";
--
--alter table wallet.user_tbl alter column password type varchar(255) using password::varchar(255);
--
--ALTER TABLE "address_tbl" add FOREIGN KEY (id_user) REFERENCES user_tbl (id);
--ALTER TABLE "address_tbl" add FOREIGN KEY (id_currency) REFERENCES currency_tbl (id);
--ALTER TABLE "node_tbl" add FOREIGN KEY (id_currency) REFERENCES currency_tbl (id);
--
--INSERT INTO wallet.role_tbl (id, title) VALUES (1, 'ROLE_USER');
--INSERT INTO wallet.role_tbl (id, title) VALUES (2, 'ROLE_ADMIN');