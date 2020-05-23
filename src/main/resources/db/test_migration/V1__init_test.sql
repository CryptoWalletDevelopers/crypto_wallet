DROP TABLE IF EXISTS user_tbl;
CREATE TABLE user_tbl (
                       id                    BIGSERIAL,
                       login                 VARCHAR(30) NOT NULL UNIQUE,
                       password              VARCHAR(30),
                       email                 VARCHAR(30) NOT NULL UNIQUE,
                       token                 VARCHAR(50),
                       approved              BOOL,
                       PRIMARY KEY (id)
);
INSERT INTO user_tbl (login, password, email, approved)
VALUES
('login1','pass1','a1@mail.ru',true),
('login2','pass2','a2@mail.ru',true);

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
CREATE TABLE address_tbl(
                           id            BIGSERIAL,
                           id_user       BIGINT,
                           index         INT,
                           address       VARCHAR(30),
                           id_currency   BIGINT,
                           PRIMARY KEY (id),
                           FOREIGN KEY (id_user) REFERENCES user_tbl (id),
                           FOREIGN KEY (id_currency) REFERENCES currency_tbl (id)
);

DROP TABLE IF EXISTS node_tbl;
CREATE TABLE node_tbl (
                       id            BIGSERIAL,
                       id_currency   BIGiNT,
                       ip            varchar(16) NOT NULL,
                       port          varchar (6) NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (id_currency) REFERENCES currency_tbl (id)
);
