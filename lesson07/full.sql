BEGIN;

DROP SCHEMA IF EXISTS hibernate CASCADE;
CREATE SCHEMA hibernate;

DROP TABLE IF EXISTS hibernate.person CASCADE;
create type person_state as enum ('male', 'female');
create table hibernate.person(
                         id bigserial PRIMARY KEY,
                         name varchar(255),
                         age integer,
                         gender person_state
);

INSERT INTO hibernate.person (name, age, gender) VALUES
('Vasya Lozhkin', 30, 'male'),
('Vasya Oblomow', 28, 'male'),
('Monetochka', 20, 'female');

COMMIT;


-- BEGIN;
--
-- DROP SCHEMA IF EXISTS hibernate CASCADE;
-- CREATE SCHEMA hibernate;
--
-- DROP TABLE IF EXISTS person CASCADE;
-- CREATE TABLE person(id bigserial PRIMARY KEY, name VARCHAR(255), age integer, gender VARCHAR(255));
-- INSERT INTO person (name, age, gender) VALUES
-- ('Vasya Lozhkin', 30, 'male'),
-- ('Vasya Oblomow', 28, 'male'),
-- ('Monetochka', 20, 'female');
--
-- COMMIT;