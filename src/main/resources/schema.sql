//CREATE TABLE yhdistys
(id BIGINT NOT NULL AUTO_INCREMENT 
,name VARCHAR(100) NOT NULL
,PRIMARY KEY (id)
);

//CREATE TABLE jasenyys
(id BIGINT NOT NULL AUTO_INCREMENT 
,name VARCHAR(50) NOT NULL
,PRIMARY KEY (id)
);

//CREATE TABLE jasen (
id BIGINT NOT NULL AUTO_INCREMENT
, etunimi VARCHAR(50) NOT NULL
, sukunimi VARCHAR(50) NOT NULL
, osoite VARCHAR(100) 
, postinumero VARCHAR(5)
, puhelin VARCHAR(30)
, email VARCHAR(100) NOT NULL
, yhdistysid BIGINT
, jasenyysid BIGINT
, PRIMARY KEY (id)
, FOREIGN KEY (yhdistysid) REFERENCES yhdistys(id)
, FOREIGN KEY (jasenyysid) REFERENCES jasenyys(id));

//INSERT INTO yhdistys (name) VALUES ('Helsinki'), ('Kuopio'), ('Oulu');

//INSERT INTO jasenyys (name) VALUES ('Jasen'), ('Opiskelija'), ('Nuoriso');


//INSERT INTO jasen (etunimi, sukunimi, osoite, postinumero,puhelin,email,yhdistysid,jasenyysid) 
VALUES ('Anne', 'Pelin','Koirasaarentie','00590','045112233','anne@anne.fi', 1,2), 
('Sissi', 'Pelin','Koiratie','00580','045998877','sissi@sissi.fi', 1,3),
('Heppu', 'Hei','Kertotie','00500','044123456','heppu@hei.fi', 2,1);


