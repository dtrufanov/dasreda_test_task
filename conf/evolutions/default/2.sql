-- Init

-- !Ups

INSERT into BRAND values (null, 'Volga', 'Russia');
INSERT into BRAND values (null, 'BMW', 'Germany');
INSERT into BRAND values (null, 'Toyota', 'Japan');

INSERT into MODEL values (null, 'Camry', 2000, 2010);
INSERT into MODEL values (null, 'LandCruiser', 2005, null);
INSERT into MODEL values (null, 'Priora', 2010, 2015);

INSERT into POSITION values (null, 1, 1, 2005, 100000, 300000);
INSERT into POSITION values (null, 2, 2, 2010, 300000, 1000000);
INSERT into POSITION values (null, 3, 3, 2013, 50000, 400000);

-- !Downs

DELETE from BRAND;
DELETE from BRAND;
DELETE from POSITION;