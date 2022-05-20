CREATE SEQUENCE faqs_id_seq;
CREATE TABLE faqs
(
    id       BIGINT PRIMARY KEY DEFAULT nextval('faqs_id_seq'),
    question TEXT,
    answer   TEXT
);

CREATE SEQUENCE training_id_seq;
CREATE TABLE training
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('training_id_seq'),
    name        VARCHAR(255),
    description TEXT,
    level       VARCHAR(255)
);

CREATE SEQUENCE events_id_seq;
CREATE TABLE events
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('events_id_seq'),
    training_id BIGINT,
    start_time  TIME,
    end_time    TIME,
    day_of_week INT,
    FOREIGN KEY (training_id) REFERENCES training (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  BOOLEAN      NOT NULL DEFAULT TRUE,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);
INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$12$Se3O5zNDIuMMCrwcidwQzeJFMvArMijuf9OeKnnuGzDiWINuJ1eWC', true);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN'),
       ('admin', 'ROLE_USER');