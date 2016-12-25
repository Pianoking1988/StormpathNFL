CREATE TABLE match (
    id         SERIAL,
    season     INTEGER     DEFAULT 2017 NOT NULL,
    week       INTEGER     DEFAULT 1 NOT NULL,
    finished   TINYINT     DEFAULT 0 NOT NULL,
    homeTeam   INTEGER     DEFAULT 0 NOT NULL,
    roadTeam   INTEGER     DEFAULT 0 NOT NULL,
    homeScore  INTEGER     DEFAULT 0 NOT NULL,
    roadScore  INTEGER     DEFAULT 0 NOT NULL,
    overtime   TINYINT     DEFAULT 0 NOT NULL,
    PRIMARY KEY(id)
);