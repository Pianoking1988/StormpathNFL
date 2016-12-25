CREATE TABLE team (
    id         SERIAL,
    name       VARCHAR(40) NOT NULL,
    conference VARCHAR(3)  NOT NULL,
    division   VARCHAR(5)  NOT NULL,
    PRIMARY KEY(id)
);