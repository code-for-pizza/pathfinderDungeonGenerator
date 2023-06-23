CREATE TABLE creatures (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    cr INTEGER,
    traits VARCHAR(255),
    sources varchar(255),
    hp INTEGER,
    ac INTEGER,
    abilityScore VARCHAR2(255),
    savingThrows VARCHAR2(255),
    immunities VARCHAR2(5000),
    resistance VARCHAR2(5000),
    speed VARCHAR2(5000),
    actions VARCHAR2(5000),
    skills VARCHAR2(255)
);