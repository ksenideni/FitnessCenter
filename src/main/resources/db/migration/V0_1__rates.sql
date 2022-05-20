CREATE SEQUENCE rates_id_seq;
CREATE TABLE rates
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('faqs_id_seq'),
    name        VARCHAR(255),
    description TEXT
);
