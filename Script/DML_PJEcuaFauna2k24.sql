-- database: ../DataBase/PJEcuaFauna.sqlite

/*
Copyright
autor: Pozo Josselyn 
fecha: 14/08/2024
descripcion: Insertar datos iniciales 
*/

INSERT INTO PJPais
    (NombrePais) VALUES
    ('ECUADOR');

INSERT INTO PJRegion
    (NombreRegion, IdPJPais) VALUES
    ('COSTA', 1),
    ('SIERRA', 1),
    ('ORIENTE', 1),
    ('GALAPAGOS', 1);

INSERT INTO PJProvincias
    (NombreProvincia                   ,IdPais ,IdRegion) VALUES
    ('ESMERALDAS'                      ,1      ,1),
    ('MANABI'                          ,1      ,1),
    ('SANTO DOMINGO DE LOS TSACHILAS'  ,1      ,1),
    ('LOS RIOS'                        ,1      ,1),
    ('SANTA ELENA'                     ,1      ,1),
    ('GUAYAS'                          ,1      ,1),
    ('EL ORO'                          ,1      ,1),
    ('CARCHI'                          ,1      ,2),
    ('IMBABURA'                        ,1      ,2),
    ('PICHINCHA'                       ,1      ,2),
    ('COTOPAXI'                        ,1      ,2),
    ('TUNGURAHUA'                      ,1      ,2),
    ('BOLIVAR'                         ,1      ,2),
    ('CHIMBORAZO'                      ,1      ,2),
    ('CAÑAR'                           ,1      ,2),
    ('AZUAY'                           ,1      ,2),
    ('LOJA'                            ,1      ,2),
    ('SUCUMBIOS'                       ,1      ,3),
    ('ORELLANA'                        ,1      ,3),
    ('NAPO'                            ,1      ,3),
    ('PASTAZA'                         ,1      ,3),
    ('MORONA SANTIAGO'                 ,1      ,3),
    ('ZAMORA CHINCHIPE'                ,1      ,3),
    ('GALAPAGOS'                       ,1      ,4);

INSERT INTO PJIngestaNativa
    (NombreIngestaNativa) VALUES 
    ('CARNIVORO'),
    ('HERBIVORO'),
    ('OMNIVORO'),
    ('INSECTIVORO');

INSERT INTO PJGenoAlimento
    (Nombre) VALUES 
    ('X'),
    ('XX'),
    ('XY');

INSERT INTO PJTipoAlimento
    (TipoAlimento) VALUES 
    ('GenoAlimento'),
    ('IngestaNativa');

INSERT INTO PJSexo
    (Nombre) VALUES 
    ('MACHO'),
    ('HEMBRA'),
    ('ASEXUAL');


