--liquibase formatted sql
--changeset Merdan_Charliev:GOR-0001
CREATE TABLE orders
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT         NOT NULL,
    order_time   TIMESTAMP      NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    item         VARCHAR(100)   NOT NULL,
    quantity     INTEGER        NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
--rollback drop table orders;