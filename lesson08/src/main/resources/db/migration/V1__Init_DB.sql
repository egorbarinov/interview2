set search_path to sec;

-- USERS
create table users (
    id bigserial not null,
    username varchar(255),
    password varchar(255),
    email varchar(255),
    role varchar(255),
    primary key (id)
);

