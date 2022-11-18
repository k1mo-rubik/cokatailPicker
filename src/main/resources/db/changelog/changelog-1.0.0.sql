CREATE TABLE customers
(
    id       BIGINT PRIMARY KEY NOT NULL,
    user_id  BIGINT             NOT NULL,
    nickname VARCHAR(255)       NOT NULL
);