/*Para eliminar una tabla ees DROP TABLE IF EXISTS*/
DROP TABLE IF EXISTS VEHICULOS;
DROP TABLE IF EXISTS COLORES;
DROP TABLE IF EXISTS TIPOS;
/*UN BIGINT ES UN LONG*/

CREATE TABLE VEHICULOS (

	CODIGO			BIGINT			NOT NULL,
	MARCA			VARCHAR(100)	NOT NULL,
	MODELO			VARCHAR(100)	NOT NULL,
	COEFF			DOUBLE(10)		NOT NULL,
	
	PRIMARY KEY (CODIGO)		

);

CREATE TABLE COLORES (

	CODIGO			BIGINT			NOT NULL,
	NOMBRE			VARCHAR(60)		NOT NULL,
	COEFF			DOUBLE(10)		NOT NULL,
	
	PRIMARY KEY (CODIGO)
);

CREATE TABLE TIPOS (

	CODIGO			BIGINT			NOT NULL,
	NOMBRE			VARCHAR(60)		NOT NULL,
	COEFF			DOUBLE(10)		NOT NULL,
	
	PRIMARY KEY (CODIGO)
);

