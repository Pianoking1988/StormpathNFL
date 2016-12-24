create table team (
    id         serial,
    name       VARCHAR(40) not null,
    conference VARCHAR(3)  not null,
    division   VARCHAR(5)  not null,
    PRIMARY KEY(id)
);