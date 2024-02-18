--liquibase formatted sql
--changeset Merdan_Charliev:GOR-0001
CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL
);
--rollback drop table users;