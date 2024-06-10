/*
Created: 30/05/2024
Modified: 01/06/2024
Model: MySQL 8.0
Database: MySQL 8.0
*/

-- Create tables section -------------------------------------------------

-- Table ANIMAL

CREATE TABLE `ANIMAL`
(
  `AniCod` Varchar(10) NOT NULL,
  `AniPes` Int(4),
  `AniAñoNac` Int(4),
  `AniPro` Varchar(10),
  `AniDesDie` Text,
  `AniEstReg` Char(1),
  `AniUtiCod` Char(1),
  `AniTipCod` Char(2)
)
;

CREATE INDEX `IX_Relationship53` ON `ANIMAL` (`AniTipCod`)
;

CREATE INDEX `IX_Relationship54` ON `ANIMAL` (`AniUtiCod`)
;

ALTER TABLE `ANIMAL` ADD PRIMARY KEY (`AniCod`)
;

-- Table NUTRIENTE

CREATE TABLE `NUTRIENTE`
(
  `NutNom` Varchar(10) NOT NULL,
  `NutInfRel` Text,
  `NutEstReg` Char(1),
  `EstCod` Char(1) NOT NULL,
  `MagCod` Char(2),
  `NutCod` Char(8) NOT NULL
)
;

CREATE INDEX `IX_Relationship50` ON `NUTRIENTE` (`MagCod`)
;

CREATE INDEX `IX_Relationship52` ON `NUTRIENTE` (`EstCod`)
;

ALTER TABLE `NUTRIENTE` ADD PRIMARY KEY (`NutCod`)
;

ALTER TABLE `NUTRIENTE` ADD UNIQUE `NutCod` (`NutCod`)
;

ALTER TABLE `NUTRIENTE` ADD UNIQUE `NutNom` (`NutNom`)
;

-- Table ALIMENTO

CREATE TABLE `ALIMENTO`
(
  `AliNom` Varchar(30) NOT NULL,
  `AliCos` Float(9,2),
  `AliInfAña` Text,
  `AliEstReg` Char(1),
  `MagCod` Char(2),
  `AliTipCod` Char(2),
  `AliCod` Char(8) NOT NULL
)
;

CREATE INDEX `IX_Relationship51` ON `ALIMENTO` (`MagCod`)
;

CREATE INDEX `IX_Relationship55` ON `ALIMENTO` (`AliTipCod`)
;

ALTER TABLE `ALIMENTO` ADD PRIMARY KEY (`AliCod`)
;

ALTER TABLE `ALIMENTO` ADD UNIQUE `AliCod` (`AliCod`)
;

-- Table TOMA

CREATE TABLE `TOMA`
(
  `TomCod` Int(4) NOT NULL,
  `TomNom` Varchar(20),
  `TomHorIni` Time,
  `TomHorFin` Time,
  `TomOtrDat` Text,
  `TomEstReg` Char(1)
)
;

ALTER TABLE `TOMA` ADD PRIMARY KEY (`TomCod`)
;

-- Table DIETA

CREATE TABLE `DIETA`
(
  `DieCod` Varchar(10) NOT NULL,
  `DieFin` Varchar(60),
  `DieOtrDat` Text,
  `DieEstReg` Char(1)
)
;

ALTER TABLE `DIETA` ADD PRIMARY KEY (`DieCod`)
;

-- Table GRANJA

CREATE TABLE `GRANJA`
(
  `GraCod` Char(10) NOT NULL,
  `GraNom` Varchar(60),
  `GraNot` Text,
  `GraEstReg` Char(1),
  `CiuCod` Char(2),
  `EmpCod` Int(4) NOT NULL,
  `PaiCod` Int(3)
)
;

CREATE INDEX `IX_Relationship61` ON `GRANJA` (`CiuCod`, `PaiCod`)
;

ALTER TABLE `GRANJA` ADD PRIMARY KEY (`GraCod`, `EmpCod`)
;

-- Table PROVEEDORES

CREATE TABLE `PROVEEDORES`
(
  `ProCod` Char(10) NOT NULL,
  `ProNom` Varchar(30),
  `ProCon` Varchar(9),
  `ProInfFis` Char(8) NOT NULL,
  `ProDes` Text,
  `ProEstReg` Char(1),
  `CiuCod` Char(2),
  `PaiCod` Int(3)
)
;

CREATE INDEX `IX_Relationship23` ON `PROVEEDORES` (`CiuCod`, `PaiCod`)
;

ALTER TABLE `PROVEEDORES` ADD PRIMARY KEY (`ProCod`)
;

ALTER TABLE `PROVEEDORES` ADD UNIQUE `ProInfFis` (`ProInfFis`)
;

-- Table ALMACEN

CREATE TABLE `ALMACEN`
(
  `AlmCod` Char(10) NOT NULL,
  `AlmNot` Text,
  `AlmEstReg` Char(1),
  `GraCod` Char(10) NOT NULL,
  `EmpCod` Int(4) NOT NULL,
  `GraAlmCapMax` Int(9) NOT NULL,
  `AlmCapMin` Int(9) NOT NULL
)
;

ALTER TABLE `ALMACEN` ADD PRIMARY KEY (`AlmCod`, `GraCod`, `EmpCod`)
;

-- Table FECHA INICIO

CREATE TABLE `FECHA INICIO`
(
  `FecIniCod` Int NOT NULL,
  `FecIniDia` Int,
  `FecIniMes` Int,
  `FecIniAño` Int,
  `FecIniEstReg` Char(1)
)
;

ALTER TABLE `FECHA INICIO` ADD PRIMARY KEY (`FecIniCod`)
;

-- Table ANIMAL NUTRIENTE

CREATE TABLE `ANIMAL NUTRIENTE`
(
  `AniCod` Varchar(10) NOT NULL,
  `NutNom` Varchar(10) NOT NULL,
  `AniNutCanNes` Int,
  `AniNutEstReg` Char(1),
  `Attribute1` Char(8) NOT NULL
)
;

ALTER TABLE `ANIMAL NUTRIENTE` ADD PRIMARY KEY (`AniCod`, `NutNom`, `Attribute1`)
;

-- Table DIETA ANIMAL FECHA INICIO

CREATE TABLE `DIETA ANIMAL FECHA INICIO`
(
  `DieAniFecDesRel` Text,
  `DieAniFecEstReg` Char(1),
  `AniCod` Varchar(10) NOT NULL,
  `FecIniCod` Int NOT NULL,
  `DieCod` Varchar(10) NOT NULL
)
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD PRIMARY KEY (`FecIniCod`, `DieCod`, `AniCod`)
;

-- Table NUTRIENTE ALIMENTO

CREATE TABLE `NUTRIENTE ALIMENTO`
(
  `NutAliCanCon` Int,
  `NutAliEstReg` Char(1),
  `NutCod` Char(8) NOT NULL,
  `AliCod` Char(8) NOT NULL
)
;

ALTER TABLE `NUTRIENTE ALIMENTO` ADD PRIMARY KEY (`NutCod`, `AliCod`)
;

-- Table ALIMENTO DIETA TOMA

CREATE TABLE `ALIMENTO DIETA TOMA`
(
  `DieCod` Varchar(10) NOT NULL,
  `TomCod` Int(4) NOT NULL,
  `AliDieTomCan` Decimal(4,2),
  `AliDieTomEstReg` Char(1),
  `AliCod` Char(8) NOT NULL
)
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD PRIMARY KEY (`DieCod`, `TomCod`, `AliCod`)
;

-- Table STOCK

CREATE TABLE `STOCK`
(
  `AlmCod` Char(10) NOT NULL,
  `StoEst` Char(1),
  `StoCanDis` Int,
  `StoEstReg` Char(1),
  `GraCod` Char(10) NOT NULL,
  `EmpCod` Int(4) NOT NULL,
  `AliCod` Char(8) NOT NULL
)
;

ALTER TABLE `STOCK` ADD PRIMARY KEY (`AlmCod`, `GraCod`, `EmpCod`, `AliCod`)
;

-- Table CIUDAD

CREATE TABLE `CIUDAD`
(
  `CiuCod` Char(2) NOT NULL,
  `CiuDes` Varchar(20),
  `CiuEstReg` Char(1),
  `PaiCod` Int(3) NOT NULL
)
;

ALTER TABLE `CIUDAD` ADD PRIMARY KEY (`CiuCod`, `PaiCod`)
;

-- Table MAGNITUD

CREATE TABLE `MAGNITUD`
(
  `MagCod` Char(2) NOT NULL,
  `MagDes` Varchar(20),
  `MagEstReg` Char(1)
)
;

ALTER TABLE `MAGNITUD` ADD PRIMARY KEY (`MagCod`)
;

-- Table ESTADO

CREATE TABLE `ESTADO`
(
  `EstCod` Char(1) NOT NULL,
  `EstDes` Varchar(20),
  `EstEstReg` Char(1)
)
;

ALTER TABLE `ESTADO` ADD PRIMARY KEY (`EstCod`)
;

-- Table ANIMAL TIPO

CREATE TABLE `ANIMAL TIPO`
(
  `AniTipCod` Char(2) NOT NULL,
  `AniUtiDes` Varchar(20),
  `AniUtiEstReg` Char(1)
)
;

ALTER TABLE `ANIMAL TIPO` ADD PRIMARY KEY (`AniTipCod`)
;

-- Table ANIMAL UTILIDAD

CREATE TABLE `ANIMAL UTILIDAD`
(
  `AniUtiCod` Char(1) NOT NULL,
  `AniUtiDes` Varchar(20),
  `AniUtiEstReg` Char(1)
)
;

ALTER TABLE `ANIMAL UTILIDAD` ADD PRIMARY KEY (`AniUtiCod`)
;

-- Table ALIMENTO TIPO

CREATE TABLE `ALIMENTO TIPO`
(
  `AliTipCod` Char(2) NOT NULL,
  `AliTipDes` Varchar(20),
  `AliEstReg` Char(1)
)
;

ALTER TABLE `ALIMENTO TIPO` ADD PRIMARY KEY (`AliTipCod`)
;

-- Table CABECERA PEDIDO

CREATE TABLE `CABECERA PEDIDO`
(
  `CabPedCod` Int(9) NOT NULL,
  `ProCod` Char(10) NOT NULL,
  `CabPedEstReg` Char(1),
  `AlmCod` Char(10) NOT NULL,
  `GraCod` Char(10) NOT NULL,
  `EmpCod` Int(4) NOT NULL
)
;

CREATE INDEX `IX_Relationship59` ON `CABECERA PEDIDO` (`ProCod`)
;

CREATE INDEX `IX_Relationship63` ON `CABECERA PEDIDO` (`AlmCod`, `GraCod`, `EmpCod`)
;

ALTER TABLE `CABECERA PEDIDO` ADD PRIMARY KEY (`CabPedCod`)
;

-- Table EMPRESA

CREATE TABLE `EMPRESA`
(
  `EmpCod` Int(4) NOT NULL,
  `EmpNom` Varchar(60),
  `DetPetCod` Char(1),
  `CiuCod` Char(2),
  `PaiCod` Int(3) NOT NULL
)
;

CREATE INDEX `IX_Relationship76` ON `EMPRESA` (`CiuCod`, `PaiCod`)
;

ALTER TABLE `EMPRESA` ADD PRIMARY KEY (`EmpCod`)
;

-- Table PAIS

CREATE TABLE `PAIS`
(
  `PaiCod` Int(3) NOT NULL,
  `PaiDes` Varchar(20),
  `PaiEstReg` Char(1)
)
;

ALTER TABLE `PAIS` ADD PRIMARY KEY (`PaiCod`)
;

-- Table DETALLES DE PEDIDO

CREATE TABLE `DETALLES DE PEDIDO`
(
  `DetPedCod` Int(9) NOT NULL,
  `DetPedHorLle` Time,
  `DetPedDiaLle` Int(2),
  `DetPedMesLle` Int(2),
  `DetPedAñoLle` Int(2),
  `DetPedDes` Text,
  `DetPedEstReg` Char(1),
  `CabPedCod` Int(9) NOT NULL,
  `AliCod` Char(8)
)
;

CREATE INDEX `IX_Int28_Alimento_Detalles_Pedido` ON `DETALLES DE PEDIDO` (`AliCod`)
;

ALTER TABLE `DETALLES DE PEDIDO` ADD PRIMARY KEY (`DetPedCod`, `CabPedCod`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `DETALLES DE PEDIDO` ADD CONSTRAINT `Int28_Alimento_Detalles_Pedido` FOREIGN KEY (`AliCod`) REFERENCES `ALIMENTO` (`AliCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DETALLES DE PEDIDO` ADD CONSTRAINT `Int14_Cabecera_Detalles_Pedido` FOREIGN KEY (`CabPedCod`) REFERENCES `CABECERA PEDIDO` (`CabPedCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `CIUDAD` ADD CONSTRAINT `Int26_Pais_CIUDAD` FOREIGN KEY (`PaiCod`) REFERENCES `PAIS` (`PaiCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `EMPRESA` ADD CONSTRAINT `Int25_Ciudad_Empresa` FOREIGN KEY (`CiuCod`, `PaiCod`) REFERENCES `CIUDAD` (`CiuCod`, `PaiCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `GRANJA` ADD CONSTRAINT `Int27_Empresa_Granja` FOREIGN KEY (`EmpCod`) REFERENCES `EMPRESA` (`EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `CABECERA PEDIDO` ADD CONSTRAINT `Int12_Almacen_cabecera` FOREIGN KEY (`AlmCod`, `GraCod`, `EmpCod`) REFERENCES `ALMACEN` (`AlmCod`, `GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `GRANJA` ADD CONSTRAINT `Int17_Ciudad_Granja` FOREIGN KEY (`CiuCod`, `PaiCod`) REFERENCES `CIUDAD` (`CiuCod`, `PaiCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `CABECERA PEDIDO` ADD CONSTRAINT `Int11_Provedor_Cabecera` FOREIGN KEY (`ProCod`) REFERENCES `PROVEEDORES` (`ProCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALMACEN` ADD CONSTRAINT `Int13_Granja_Almacen` FOREIGN KEY (`GraCod`, `EmpCod`) REFERENCES `GRANJA` (`GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO` ADD CONSTRAINT `Int24_Tipo_Alimento` FOREIGN KEY (`AliTipCod`) REFERENCES `ALIMENTO TIPO` (`AliTipCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL` ADD CONSTRAINT `Int23 _Animal_Utilidad_Animal` FOREIGN KEY (`AniUtiCod`) REFERENCES `ANIMAL UTILIDAD` (`AniUtiCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL` ADD CONSTRAINT `Int22_Tipo_Animal` FOREIGN KEY (`AniTipCod`) REFERENCES `ANIMAL TIPO` (`AniTipCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE` ADD CONSTRAINT `Int21_Estado_Nutriente` FOREIGN KEY (`EstCod`) REFERENCES `ESTADO` (`EstCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO` ADD CONSTRAINT `Int20_Magnitud_Alimento` FOREIGN KEY (`MagCod`) REFERENCES `MAGNITUD` (`MagCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE` ADD CONSTRAINT `Int19_Magnitud_Nutriente` FOREIGN KEY (`MagCod`) REFERENCES `MAGNITUD` (`MagCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `PROVEEDORES` ADD CONSTRAINT `Int18_Ciudad_Proveedor` FOREIGN KEY (`CiuCod`, `PaiCod`) REFERENCES `CIUDAD` (`CiuCod`, `PaiCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `STOCK` ADD CONSTRAINT `Int15_Almacen_Stock` FOREIGN KEY (`AlmCod`, `GraCod`, `EmpCod`) REFERENCES `ALMACEN` (`AlmCod`, `GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `STOCK` ADD CONSTRAINT `Int16_Alimento_Stock` FOREIGN KEY (`AliCod`) REFERENCES `ALIMENTO` (`AliCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD CONSTRAINT `Int09_ Alimento_Dieta_Toma` FOREIGN KEY (`TomCod`) REFERENCES `TOMA` (`TomCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD CONSTRAINT `Int08_ Alimento_Dieta_Toma` FOREIGN KEY (`AliCod`) REFERENCES `ALIMENTO` (`AliCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD CONSTRAINT `Int10_Alimento_Dieta_Toma` FOREIGN KEY (`DieCod`) REFERENCES `DIETA` (`DieCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE ALIMENTO` ADD CONSTRAINT `Int03_ Alimento_Nutriente` FOREIGN KEY (`AliCod`) REFERENCES `ALIMENTO` (`AliCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE ALIMENTO` ADD CONSTRAINT `Int04_ Nutriente_Alimento` FOREIGN KEY (`NutCod`) REFERENCES `NUTRIENTE` (`NutCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD CONSTRAINT `Int06_ Dieta_Animal_FechaInicio` FOREIGN KEY (`AniCod`) REFERENCES `ANIMAL` (`AniCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD CONSTRAINT `Int05_ Dieta_Animal_FechaInicio` FOREIGN KEY (`DieCod`) REFERENCES `DIETA` (`DieCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD CONSTRAINT `Int07_ Dieta_Animal_FechaInicio` FOREIGN KEY (`FecIniCod`) REFERENCES `FECHA INICIO` (`FecIniCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL NUTRIENTE` ADD CONSTRAINT `Int02_ Nutriente_Alimento` FOREIGN KEY (`Attribute1`) REFERENCES `NUTRIENTE` (`NutCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL NUTRIENTE` ADD CONSTRAINT `Int01_ Animal_Nutriente` FOREIGN KEY (`AniCod`) REFERENCES `ANIMAL` (`AniCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

