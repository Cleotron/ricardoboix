CREATE TABLE poemas(
	titulo varchar (100)PRIMARY KEY,
	texto varchar(10000) NOT NULL,
	audio varchar(1000)
);

CREATE TABLE relatos(
	titulo varchar(100)PRIMARY KEY,
	texto VARCHAR (36000) NOT NULL
);

CREATE TABLE fotos(
	id serial PRIMARY KEY,
	foto BLOB
);

CREATE TABLE comentarios(
	id serial PRIMARY KEY,
	nombre varchar(100) NOT NULL,
	texto varchar(10000) NOT NULL,
	aprobado BOOLEAN NOT NULL DEFAULT FALSE
);