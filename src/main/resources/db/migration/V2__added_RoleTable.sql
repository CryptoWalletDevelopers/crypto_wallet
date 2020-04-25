drop table if exists roles;
create table roles
(
    id    serial  not null,
    title varchar not null,
    primary key (id)
);

drop table if exists users_roles;
create table users_roles
(
    user_id bigint  not null,
    role_id integer not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

INSERT INTO wallet.roles (id, title) VALUES (1, 'ROLE_USER');