--liquibase formatted sql

--changeset merdan:1
CREATE TABLE orders
(
    id           BIGSERIAL PRIMARY KEY,
    order_time   TIMESTAMP      NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    item         VARCHAR(100)   NOT NULL,
    quantity     INTEGER        NOT NULL
);
--rollback DROP TABLE orders;