CREATE TABLE tests (
                       id bigint PRIMARY KEY,
                       name VARCHAR(200) NOT NULL,
                       payload jsonb not null
);