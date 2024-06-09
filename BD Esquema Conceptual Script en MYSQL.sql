/*
Created: 5/25/2024
Modified: 5/25/2024
Model: Universal MySQL
Database: MySQL 8.0
*/

-- Create tables section -------------------------------------------------

-- Table ANIMAL

CREATE TABLE `ANIMAL`
(
  `AniCod` Varchar(10) NOT NULL,
  `AniPes` Int,
  `AniAñoNac` Int,
  `AniPro` Varchar(20),
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
  `NutNom` Varchar(30) NOT NULL,
  `NutInfRel` Text,
  `NutEstReg` Char(1),
  `EstCod` Char(1),
  `MagCod` Char(2)
)
;

CREATE INDEX `IX_Relationship50` ON `NUTRIENTE` (`MagCod`)
;

CREATE INDEX `IX_Relationship52` ON `NUTRIENTE` (`EstCod`)
;

ALTER TABLE `NUTRIENTE` ADD PRIMARY KEY (`NutNom`)
;

-- Table ALIMENTO

CREATE TABLE `ALIMENTO`
(
  `AliNom` Varchar(30) NOT NULL,
  `AliCos` Int,
  `AliInfAña` Text,
  `AliEstReg` Char(1),
  `MagCod` Char(2),
  `AliTipCod` Char(2)
)
;

CREATE INDEX `IX_Relationship51` ON `ALIMENTO` (`MagCod`)
;

CREATE INDEX `IX_Relationship55` ON `ALIMENTO` (`AliTipCod`)
;

ALTER TABLE `ALIMENTO` ADD PRIMARY KEY (`AliNom`)
;

-- Table TOMA

CREATE TABLE `TOMA`
(
  `TomCod` Int NOT NULL,
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
  `GraDir` Varchar(60),
  `GraNot` Text,
  `GraEstReg` Char(1),
  `CiuCod` Char(2),
  `EmpCod` Int NOT NULL
)
;

CREATE INDEX `IX_Relationship61` ON `GRANJA` (`CiuCod`)
;

ALTER TABLE `GRANJA` ADD PRIMARY KEY (`GraCod`, `EmpCod`)
;

-- Table PROVEEDORES

CREATE TABLE `PROVEEDORES`
(
  `ProCod` Char(10) NOT NULL,
  `ProNom` Varchar(30),
  `ProDir` Varchar(60),
  `ProCon` Varchar(8),
  `ProInfFis` Char(1) NOT NULL,
  `ProDes` Text,
  `ProEstReg` Char(1),
  `CiuCod` Char(2)
)
;

CREATE INDEX `IX_Relationship23` ON `PROVEEDORES` (`CiuCod`)
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
  `EmpCod` Int NOT NULL
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
  `NutNom` Varchar(30) NOT NULL,
  `AniNutCanNes` Int,
  `AniNutEstReg` Char(1)
)
;

ALTER TABLE `ANIMAL NUTRIENTE` ADD PRIMARY KEY (`AniCod`, `NutNom`)
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
  `NutNom` Varchar(30) NOT NULL,
  `AliNom` Varchar(30) NOT NULL,
  `NutAliCanCon` Int,
  `NutAliEstReg` Char(1)
)
;

ALTER TABLE `NUTRIENTE ALIMENTO` ADD PRIMARY KEY (`NutNom`, `AliNom`)
;

-- Table ALIMENTO DIETA TOMA

CREATE TABLE `ALIMENTO DIETA TOMA`
(
  `DieCod` Varchar(10) NOT NULL,
  `AliNom` Varchar(30) NOT NULL,
  `TomCod` Int NOT NULL,
  `AliDieTomCan` Decimal(4,2),
  `AliDieTomEstReg` Char(1)
)
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD PRIMARY KEY (`DieCod`, `AliNom`, `TomCod`)
;

-- Table STOCK

CREATE TABLE `STOCK`
(
  `AlmCod` Char(10) NOT NULL,
  `AliNom` Varchar(30) NOT NULL,
  `StoEst` Char(1),
  `StoCanDis` Int,
  `StoEstReg` Char(1),
  `GraCod` Char(10) NOT NULL,
  `EmpCod` Int NOT NULL
)
;

ALTER TABLE `STOCK` ADD PRIMARY KEY (`AliNom`, `AlmCod`, `GraCod`, `EmpCod`)
;

-- Table CIUDAD

CREATE TABLE `CIUDAD`
(
  `CiuCod` Char(2) NOT NULL,
  `CiuDes` Varchar(20),
  `CiuEstReg` Char(1),
  `PaiNom` Varchar(10)
)
;

CREATE INDEX `IX_Relationship78` ON `CIUDAD` (`PaiNom`)
;

ALTER TABLE `CIUDAD` ADD PRIMARY KEY (`CiuCod`)
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
  `CabPedCod` Char(1) NOT NULL,
  `ProCod` Char(10) NOT NULL,
  `CabPedEstReg` Char(1),
  `AlmCod` Char(10) NOT NULL,
  `GraCod` Char(10) NOT NULL,
  `EmpCod` Int NOT NULL
)
;

ALTER TABLE `CABECERA PEDIDO` ADD PRIMARY KEY (`CabPedCod`, `ProCod`, `AlmCod`, `GraCod`, `EmpCod`)
;

-- Table EMPRESA

CREATE TABLE `EMPRESA`
(
  `EmpCod` Int NOT NULL,
  `EmpNom` Varchar(20),
  `DetPetCod` Char(1),
  `CiuCod` Char(2)
)
;

CREATE INDEX `IX_Relationship76` ON `EMPRESA` (`CiuCod`)
;

ALTER TABLE `EMPRESA` ADD PRIMARY KEY (`EmpCod`)
;

-- Table PAIS

CREATE TABLE `PAIS`
(
  `PaiNom` Varchar(10) NOT NULL,
  `PaiDes` Varchar(20),
  `PaiEstReg` Char(1)
)
;

ALTER TABLE `PAIS` ADD PRIMARY KEY (`PaiNom`)
;

-- Table DETALLES DE PEDIDO

CREATE TABLE `DETALLES DE PEDIDO`
(
  `DetPedCod` Char(1) NOT NULL,
  `AliNom` Varchar(30) NOT NULL,
  `DetPedHorLle` Time,
  `DetPedDiaLle` Int,
  `DetPedMesLle` Int,
  `DetPedAñoLle` Int,
  `DetPedDes` Text,
  `DetPedEstReg` Char(1),
  `CabPedCod` Char(1) NOT NULL,
  `ProCod` Char(10) NOT NULL,
  `AlmCod` Char(10) NOT NULL,
  `GraCod` Char(10) NOT NULL,
  `EmpCod` Int NOT NULL
)
;

ALTER TABLE `DETALLES DE PEDIDO` ADD PRIMARY KEY (`DetPedCod`, `CabPedCod`, `ProCod`, `AlmCod`, `GraCod`, `EmpCod`, `AliNom`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `ANIMAL NUTRIENTE` ADD CONSTRAINT `Relationship2` FOREIGN KEY (`AniCod`) REFERENCES `ANIMAL` (`AniCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL NUTRIENTE` ADD CONSTRAINT `Relationship4` FOREIGN KEY (`NutNom`) REFERENCES `NUTRIENTE` (`NutNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD CONSTRAINT `Relationship5` FOREIGN KEY (`FecIniCod`) REFERENCES `FECHA INICIO` (`FecIniCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD CONSTRAINT `Relationship6` FOREIGN KEY (`DieCod`) REFERENCES `DIETA` (`DieCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DIETA ANIMAL FECHA INICIO` ADD CONSTRAINT `Relationship8` FOREIGN KEY (`AniCod`) REFERENCES `ANIMAL` (`AniCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE ALIMENTO` ADD CONSTRAINT `Relationship9` FOREIGN KEY (`NutNom`) REFERENCES `NUTRIENTE` (`NutNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE ALIMENTO` ADD CONSTRAINT `Relationship10` FOREIGN KEY (`AliNom`) REFERENCES `ALIMENTO` (`AliNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD CONSTRAINT `Relationship11` FOREIGN KEY (`DieCod`) REFERENCES `DIETA` (`DieCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD CONSTRAINT `Relationship12` FOREIGN KEY (`AliNom`) REFERENCES `ALIMENTO` (`AliNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO DIETA TOMA` ADD CONSTRAINT `Relationship13` FOREIGN KEY (`TomCod`) REFERENCES `TOMA` (`TomCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `STOCK` ADD CONSTRAINT `Relationship17` FOREIGN KEY (`AliNom`) REFERENCES `ALIMENTO` (`AliNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `STOCK` ADD CONSTRAINT `Relationship18` FOREIGN KEY (`AlmCod`, `GraCod`, `EmpCod`) REFERENCES `ALMACEN` (`AlmCod`, `GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `PROVEEDORES` ADD CONSTRAINT `Relationship23` FOREIGN KEY (`CiuCod`) REFERENCES `CIUDAD` (`CiuCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE` ADD CONSTRAINT `Relationship50` FOREIGN KEY (`MagCod`) REFERENCES `MAGNITUD` (`MagCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO` ADD CONSTRAINT `Relationship51` FOREIGN KEY (`MagCod`) REFERENCES `MAGNITUD` (`MagCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `NUTRIENTE` ADD CONSTRAINT `Relationship52` FOREIGN KEY (`EstCod`) REFERENCES `ESTADO` (`EstCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL` ADD CONSTRAINT `Relationship53` FOREIGN KEY (`AniTipCod`) REFERENCES `ANIMAL TIPO` (`AniTipCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ANIMAL` ADD CONSTRAINT `Relationship54` FOREIGN KEY (`AniUtiCod`) REFERENCES `ANIMAL UTILIDAD` (`AniUtiCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALIMENTO` ADD CONSTRAINT `Relationship55` FOREIGN KEY (`AliTipCod`) REFERENCES `ALIMENTO TIPO` (`AliTipCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `ALMACEN` ADD CONSTRAINT `Relationship56` FOREIGN KEY (`GraCod`, `EmpCod`) REFERENCES `GRANJA` (`GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `CABECERA PEDIDO` ADD CONSTRAINT `Relationship59` FOREIGN KEY (`ProCod`) REFERENCES `PROVEEDORES` (`ProCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `GRANJA` ADD CONSTRAINT `Relationship61` FOREIGN KEY (`CiuCod`) REFERENCES `CIUDAD` (`CiuCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `CABECERA PEDIDO` ADD CONSTRAINT `Relationship63` FOREIGN KEY (`AlmCod`, `GraCod`, `EmpCod`) REFERENCES `ALMACEN` (`AlmCod`, `GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `GRANJA` ADD CONSTRAINT `Relationship72` FOREIGN KEY (`EmpCod`) REFERENCES `EMPRESA` (`EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `EMPRESA` ADD CONSTRAINT `Relationship76` FOREIGN KEY (`CiuCod`) REFERENCES `CIUDAD` (`CiuCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `CIUDAD` ADD CONSTRAINT `Relationship78` FOREIGN KEY (`PaiNom`) REFERENCES `PAIS` (`PaiNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DETALLES DE PEDIDO` ADD CONSTRAINT `Relationship83` FOREIGN KEY (`CabPedCod`, `ProCod`, `AlmCod`, `GraCod`, `EmpCod`) REFERENCES `CABECERA PEDIDO` (`CabPedCod`, `ProCod`, `AlmCod`, `GraCod`, `EmpCod`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `DETALLES DE PEDIDO` ADD CONSTRAINT `Relationship84` FOREIGN KEY (`AliNom`) REFERENCES `ALIMENTO` (`AliNom`) ON DELETE NO ACTION ON UPDATE NO ACTION
;
