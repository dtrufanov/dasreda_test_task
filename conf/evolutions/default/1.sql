-- Init

-- !Ups

CREATE TABLE BRAND (
    id int not null PRIMARY KEY,
    name varchar(255) NOT NULL,
    country varchar(255) NOT NULL
);

CREATE TABLE MODEL (
    id int not null  PRIMARY KEY,
    name varchar(255) NOT NULL,
    production_start int NOT NULL,
    production_stop int
);

CREATE TABLE POSITION (
    id int not null PRIMARY KEY,
    brand_id int not null,
    model_id int not null,
    year_of_issue int NOT NULL,
    mileage int not null,
    price int not null
);

-- !Downs

DROP TABLE BRAND;
DROP TABLE MODEL;
DROP TABLE POSITION;