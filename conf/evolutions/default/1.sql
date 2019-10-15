-- Init

-- !Ups

CREATE TABLE BRAND (
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    country varchar(255) NOT NULL
);

CREATE TABLE MODEL (
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    production_start int NOT NULL,
    production_stop int
);

CREATE TABLE POSITION (
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    brand_id bigint not null,
    model_id bigint not null,
    year_of_issue int NOT NULL,
    mileage int not null,
    price int not null,
    FOREIGN KEY (brand_id) REFERENCES BRAND(id),
    FOREIGN KEY (model_id) REFERENCES MODEL(id)
);

-- !Downs

DROP TABLE BRAND;
DROP TABLE MODEL;
DROP TABLE POSITION;