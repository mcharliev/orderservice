--liquibase formatted sql

--changeset Merdan_Charliev:GOR-0003
INSERT INTO users (email, password, name) VALUES ('alex.stone@example.com', 'pass1234', 'Alex Stone');
INSERT INTO users (email, password, name) VALUES ('julia.bright@example.com', 'brightSecure!5', 'Julia Bright');
INSERT INTO users (email, password, name) VALUES ('mark.doe@example.com', 'doeMark007', 'Mark Doe');
INSERT INTO users (email, password, name) VALUES ('sara.connor@example.com', 'saraCon2024!', 'Sara Connor');
INSERT INTO users (email, password, name) VALUES ('tom.black@example.com', 'blackTom#42', 'Tom Black');

--rollback DELETE FROM users WHERE email IN ('alex.stone@example.com', 'julia.bright@example.com', 'mark.doe@example.com', 'sara.connor@example.com', 'tom.black@example.com');