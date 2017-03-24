CREATE TABLE poemas(
	titulo varchar (100)PRIMARY KEY,
	texto varchar(10000) NOT NULL,
);

CREATE TABLE relatos(
	titulo varchar(100)PRIMARY KEY,
	texto VARCHAR (36000) NOT NULL,
);

CREATE TABLE fotos(
	id serial PRIMARY KEY,
	foto BLOB,
);