-- database: ../DataBase/PJEcuaFauna.sqlite

/*
Copyright
autor: Pozo Josselyn 
fecha: 14/08/2024
descripcion: Script SQL para la creacion de tablas 
de la base de datos EcuaFauna2k24A
*/

DROP TABLE IF EXISTS PJPais;
DROP TABLE IF EXISTS PJRegion;
DROP TABLE IF EXISTS PJProvincias;
DROP TABLE IF EXISTS PJIngestaNativa;
DROP TABLE IF EXISTS PJGenoAlimento;
DROP TABLE IF EXISTS PJTipoAlimento;
DROP TABLE IF EXISTS PJAlimento;
DROP TABLE IF EXISTS PJSexo;
DROP TABLE IF EXISTS PJHormiga;

CREATE TABLE PJPais 
(
    IdPJPais    INTEGER PRIMARY KEY AUTOINCREMENT,
    NombrePais  VARCHAR (50) NOT NULL UNIQUE,
    Estado      CHAR(1) NOT NULL DEFAULT('A') CHECK (Estado IN ('A', 'X')),
    FechaCrea   DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE PJRegion
(
    IdPJRegion      INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreRegion    VARCHAR(50) NOT NULL UNIQUE,
    IdPJPais        INTEGER NOT NULL, 
    Estado          CHAR(1)     NOT NULL DEFAULT ('A') CHECK (Estado IN ('A', 'X')),
    FechaCrea       DATETIME DEFAULT (datetime('now', 'localtime')),
    CONSTRAINT      fk_Pais FOREIGN KEY(idPJPais) REFERENCES PJPais(idPJPais)
);

CREATE TABLE PJProvincias(
    idPJProvincia       INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreProvincia     VARCHAR(30) NOT NULL UNIQUE,
    IdPais              INTEGER NOT NULL,
    IdRegion            INTEGER NOT NULL,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK (Estado IN ('A', 'X')),
    FechaCrea           DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE PJIngestaNativa
(
    IdPJIngestaNativa     INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreIngestaNativa   VARCHAR (50) NOT NULL UNIQUE,
    Estado                CHAR(1) NOT NULL DEFAULT('A') CHECK (Estado IN ('A', 'X')),
    FechaCrea             DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE PJGenoAlimento
(
    IdPJGenoAlimento    INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre              VARCHAR (50) NOT NULL UNIQUE,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK (Estado IN ('A', 'X')),
    FechaCrea           DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE PJTipoAlimento(
    idPJTipoAlimento    INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoAlimento        VARCHAR(20) NOT NULL,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime')) 
);

CREATE TABLE PJAlimento
(
    IdPJAlimento      INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreAlimento    VARCHAR (50) NOT NULL UNIQUE,
    IdTipoAlimento    INTEGER NOT NULL,
    FechaCrea         DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE PJSexo
(
    IdSexo      INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre      VARCHAR (50) NOT NULL,
    Estado      CHAR(1) NOT NULL DEFAULT('A') CHECK (Estado IN ('A', 'X')),
    FechaCrea   DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE PJHormiga 
(
    IdHormiga           INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoHormiga         VARCHAR(30) NOT NULL UNIQUE,
    idSexo              INTEGER NOT NULL,
    idProvincia         INTEGER NOT NULL,
    idGenoAlimento      INTEGER NOT NULL,
    idIngestaNativa     INTEGER NOT NULL,
    Estado              CHAR(1) DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime')),
    CONSTRAINT          fk_Sexo FOREIGN KEY (idSexo) REFERENCES AJSexo(idAJSexo),
    CONSTRAINT          fk_Provincia FOREIGN KEY (idProvincia) REFERENCES AJProvincias(idAJProvincia),
    CONSTRAINT          fk_GenoAlimento FOREIGN KEY (idGenoAlimento) REFERENCES AJGenoAlimento(idAJGenoAlimento),
    CONSTRAINT          fk_IngestaNativa FOREIGN KEY (idIngestaNativa) REFERENCES AJIngestaNativa(idAJIngestaNativa)
);


