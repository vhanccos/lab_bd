# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Alimento(models.Model):
    alinom = models.CharField(db_column='AliNom', max_length=30)  # Field name made lowercase.
    alicos = models.FloatField(db_column='AliCos', blank=True, null=True)  # Field name made lowercase.
    aliinfaña = models.TextField(db_column='AliInfAña', blank=True, null=True)  # Field name made lowercase.
    aliestreg = models.CharField(db_column='AliEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    magcod = models.ForeignKey('Magnitud', models.DO_NOTHING, db_column='MagCod', blank=True, null=True)  # Field name made lowercase.
    alitipcod = models.ForeignKey('AlimentoTipo', models.DO_NOTHING, db_column='AliTipCod', blank=True, null=True)  # Field name made lowercase.
    alicod = models.CharField(db_column='AliCod', primary_key=True, max_length=8)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALIMENTO'


class AlimentoDietaToma(models.Model):
    diecod = models.OneToOneField('Dieta', models.DO_NOTHING, db_column='DieCod', primary_key=True)  # Field name made lowercase. The composite primary key (DieCod, TomCod, AliCod) found, that is not supported. The first column is selected.
    tomcod = models.ForeignKey('Toma', models.DO_NOTHING, db_column='TomCod')  # Field name made lowercase.
    alidietomcan = models.DecimalField(db_column='AliDieTomCan', max_digits=4, decimal_places=2, blank=True, null=True)  # Field name made lowercase.
    alidietomestreg = models.CharField(db_column='AliDieTomEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    alicod = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALIMENTO DIETA TOMA'
        unique_together = (('diecod', 'tomcod', 'alicod'),)


class AlimentoTipo(models.Model):
    alitipcod = models.CharField(db_column='AliTipCod', primary_key=True, max_length=2)  # Field name made lowercase.
    alitipdes = models.CharField(db_column='AliTipDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    aliestreg = models.CharField(db_column='AliEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALIMENTO TIPO'


class Almacen(models.Model):
    almcod = models.CharField(db_column='AlmCod', primary_key=True, max_length=10)  # Field name made lowercase. The composite primary key (AlmCod, GraCod, EmpCod) found, that is not supported. The first column is selected.
    almnot = models.TextField(db_column='AlmNot', blank=True, null=True)  # Field name made lowercase.
    almestreg = models.CharField(db_column='AlmEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    gracod = models.ForeignKey('Granja', models.DO_NOTHING, db_column='GraCod')  # Field name made lowercase.
    empcod = models.ForeignKey('Granja', models.DO_NOTHING, db_column='EmpCod', related_name='almacen_empcod_set')  # Field name made lowercase.
    graalmcapmax = models.IntegerField(db_column='GraAlmCapMax')  # Field name made lowercase.
    almcapmin = models.IntegerField(db_column='AlmCapMin')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALMACEN'
        unique_together = (('almcod', 'gracod', 'empcod'),)


class Animal(models.Model):
    anicod = models.CharField(db_column='AniCod', primary_key=True, max_length=10)  # Field name made lowercase.
    anipes = models.IntegerField(db_column='AniPes', blank=True, null=True)  # Field name made lowercase.
    aniañonac = models.IntegerField(db_column='AniAñoNac', blank=True, null=True)  # Field name made lowercase.
    anipro = models.CharField(db_column='AniPro', max_length=10, blank=True, null=True)  # Field name made lowercase.
    anidesdie = models.TextField(db_column='AniDesDie', blank=True, null=True)  # Field name made lowercase.
    aniestreg = models.CharField(db_column='AniEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    aniuticod = models.ForeignKey('AnimalUtilidad', models.DO_NOTHING, db_column='AniUtiCod', blank=True, null=True)  # Field name made lowercase.
    anitipcod = models.ForeignKey('AnimalTipo', models.DO_NOTHING, db_column='AniTipCod', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ANIMAL'


class AnimalNutriente(models.Model):
    anicod = models.OneToOneField(Animal, models.DO_NOTHING, db_column='AniCod', primary_key=True)  # Field name made lowercase. The composite primary key (AniCod, NutNom, Attribute1) found, that is not supported. The first column is selected.
    nutnom = models.CharField(db_column='NutNom', max_length=10)  # Field name made lowercase.
    aninutcannes = models.IntegerField(db_column='AniNutCanNes', blank=True, null=True)  # Field name made lowercase.
    aninutestreg = models.CharField(db_column='AniNutEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    attribute1 = models.ForeignKey('Nutriente', models.DO_NOTHING, db_column='Attribute1')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ANIMAL NUTRIENTE'
        unique_together = (('anicod', 'nutnom', 'attribute1'),)


class AnimalTipo(models.Model):
    anitipcod = models.CharField(db_column='AniTipCod', primary_key=True, max_length=2)  # Field name made lowercase.
    aniutides = models.CharField(db_column='AniUtiDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    aniutiestreg = models.CharField(db_column='AniUtiEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ANIMAL TIPO'


class AnimalUtilidad(models.Model):
    aniuticod = models.CharField(db_column='AniUtiCod', primary_key=True, max_length=1)  # Field name made lowercase.
    aniutides = models.CharField(db_column='AniUtiDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    aniutiestreg = models.CharField(db_column='AniUtiEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ANIMAL UTILIDAD'


class CabeceraPedido(models.Model):
    cabpedcod = models.IntegerField(db_column='CabPedCod', primary_key=True)  # Field name made lowercase.
    procod = models.ForeignKey('Proveedores', models.DO_NOTHING, db_column='ProCod')  # Field name made lowercase.
    cabpedestreg = models.CharField(db_column='CabPedEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    almcod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='AlmCod')  # Field name made lowercase.
    gracod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='GraCod', related_name='cabecerapedido_gracod_set')  # Field name made lowercase.
    empcod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='EmpCod', related_name='cabecerapedido_empcod_set')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'CABECERA PEDIDO'


class Ciudad(models.Model):
    ciucod = models.CharField(db_column='CiuCod', primary_key=True, max_length=2)  # Field name made lowercase. The composite primary key (CiuCod, PaiCod) found, that is not supported. The first column is selected.
    ciudes = models.CharField(db_column='CiuDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    ciuestreg = models.CharField(db_column='CiuEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    paicod = models.ForeignKey('Pais', models.DO_NOTHING, db_column='PaiCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'CIUDAD'
        unique_together = (('ciucod', 'paicod'),)


class DetallesDePedido(models.Model):
    detpedcod = models.IntegerField(db_column='DetPedCod', primary_key=True)  # Field name made lowercase. The composite primary key (DetPedCod, CabPedCod) found, that is not supported. The first column is selected.
    detpedhorlle = models.TimeField(db_column='DetPedHorLle', blank=True, null=True)  # Field name made lowercase.
    detpeddialle = models.IntegerField(db_column='DetPedDiaLle', blank=True, null=True)  # Field name made lowercase.
    detpedmeslle = models.IntegerField(db_column='DetPedMesLle', blank=True, null=True)  # Field name made lowercase.
    detpedañolle = models.IntegerField(db_column='DetPedAñoLle', blank=True, null=True)  # Field name made lowercase.
    detpeddes = models.TextField(db_column='DetPedDes', blank=True, null=True)  # Field name made lowercase.
    detpedestreg = models.CharField(db_column='DetPedEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    cabpedcod = models.ForeignKey(CabeceraPedido, models.DO_NOTHING, db_column='CabPedCod')  # Field name made lowercase.
    alicod = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliCod', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'DETALLES DE PEDIDO'
        unique_together = (('detpedcod', 'cabpedcod'),)


class Dieta(models.Model):
    diecod = models.CharField(db_column='DieCod', primary_key=True, max_length=10)  # Field name made lowercase.
    diefin = models.CharField(db_column='DieFin', max_length=60, blank=True, null=True)  # Field name made lowercase.
    dieotrdat = models.TextField(db_column='DieOtrDat', blank=True, null=True)  # Field name made lowercase.
    dieestreg = models.CharField(db_column='DieEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'DIETA'


class DietaAnimalFechaInicio(models.Model):
    dieanifecdesrel = models.TextField(db_column='DieAniFecDesRel', blank=True, null=True)  # Field name made lowercase.
    dieanifecestreg = models.CharField(db_column='DieAniFecEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    anicod = models.ForeignKey(Animal, models.DO_NOTHING, db_column='AniCod')  # Field name made lowercase.
    fecinicod = models.OneToOneField('FechaInicio', models.DO_NOTHING, db_column='FecIniCod', primary_key=True)  # Field name made lowercase. The composite primary key (FecIniCod, DieCod, AniCod) found, that is not supported. The first column is selected.
    diecod = models.ForeignKey(Dieta, models.DO_NOTHING, db_column='DieCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'DIETA ANIMAL FECHA INICIO'
        unique_together = (('fecinicod', 'diecod', 'anicod'),)


class Empresa(models.Model):
    empcod = models.IntegerField(db_column='EmpCod', primary_key=True)  # Field name made lowercase.
    empnom = models.CharField(db_column='EmpNom', max_length=60, blank=True, null=True)  # Field name made lowercase.
    detpetcod = models.CharField(db_column='DetPetCod', max_length=1, blank=True, null=True)  # Field name made lowercase.
    ciucod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='CiuCod', blank=True, null=True)  # Field name made lowercase.
    paicod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='PaiCod', related_name='empresa_paicod_set')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'EMPRESA'


class Estado(models.Model):
    estcod = models.CharField(db_column='EstCod', primary_key=True, max_length=1)  # Field name made lowercase.
    estdes = models.CharField(db_column='EstDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    estestreg = models.CharField(db_column='EstEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ESTADO'


class FechaInicio(models.Model):
    fecinicod = models.IntegerField(db_column='FecIniCod', primary_key=True)  # Field name made lowercase.
    fecinidia = models.IntegerField(db_column='FecIniDia', blank=True, null=True)  # Field name made lowercase.
    fecinimes = models.IntegerField(db_column='FecIniMes', blank=True, null=True)  # Field name made lowercase.
    feciniaño = models.IntegerField(db_column='FecIniAño', blank=True, null=True)  # Field name made lowercase.
    feciniestreg = models.CharField(db_column='FecIniEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'FECHA INICIO'


class Granja(models.Model):
    gracod = models.CharField(db_column='GraCod', primary_key=True, max_length=10)  # Field name made lowercase. The composite primary key (GraCod, EmpCod) found, that is not supported. The first column is selected.
    granom = models.CharField(db_column='GraNom', max_length=60, blank=True, null=True)  # Field name made lowercase.
    granot = models.TextField(db_column='GraNot', blank=True, null=True)  # Field name made lowercase.
    graestreg = models.CharField(db_column='GraEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    ciucod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='CiuCod', blank=True, null=True)  # Field name made lowercase.
    empcod = models.ForeignKey(Empresa, models.DO_NOTHING, db_column='EmpCod')  # Field name made lowercase.
    paicod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='PaiCod', related_name='granja_paicod_set', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'GRANJA'
        unique_together = (('gracod', 'empcod'),)


class Magnitud(models.Model):
    magcod = models.CharField(db_column='MagCod', primary_key=True, max_length=2)  # Field name made lowercase.
    magdes = models.CharField(db_column='MagDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    magestreg = models.CharField(db_column='MagEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'MAGNITUD'


class Nutriente(models.Model):
    nutnom = models.CharField(db_column='NutNom', unique=True, max_length=10)  # Field name made lowercase.
    nutinfrel = models.TextField(db_column='NutInfRel', blank=True, null=True)  # Field name made lowercase.
    nutestreg = models.CharField(db_column='NutEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    estcod = models.ForeignKey(Estado, models.DO_NOTHING, db_column='EstCod')  # Field name made lowercase.
    magcod = models.ForeignKey(Magnitud, models.DO_NOTHING, db_column='MagCod', blank=True, null=True)  # Field name made lowercase.
    nutcod = models.CharField(db_column='NutCod', primary_key=True, max_length=8)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'NUTRIENTE'


class NutrienteAlimento(models.Model):
    nutalicancon = models.IntegerField(db_column='NutAliCanCon', blank=True, null=True)  # Field name made lowercase.
    nutaliestreg = models.CharField(db_column='NutAliEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    nutcod = models.OneToOneField(Nutriente, models.DO_NOTHING, db_column='NutCod', primary_key=True)  # Field name made lowercase. The composite primary key (NutCod, AliCod) found, that is not supported. The first column is selected.
    alicod = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'NUTRIENTE ALIMENTO'
        unique_together = (('nutcod', 'alicod'),)


class Pais(models.Model):
    paicod = models.IntegerField(db_column='PaiCod', primary_key=True)  # Field name made lowercase.
    paides = models.CharField(db_column='PaiDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    paiestreg = models.CharField(db_column='PaiEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'PAIS'


class Proveedores(models.Model):
    procod = models.CharField(db_column='ProCod', primary_key=True, max_length=10)  # Field name made lowercase.
    pronom = models.CharField(db_column='ProNom', max_length=30, blank=True, null=True)  # Field name made lowercase.
    procon = models.CharField(db_column='ProCon', max_length=9, blank=True, null=True)  # Field name made lowercase.
    proinffis = models.CharField(db_column='ProInfFis', unique=True, max_length=8)  # Field name made lowercase.
    prodes = models.TextField(db_column='ProDes', blank=True, null=True)  # Field name made lowercase.
    proestreg = models.CharField(db_column='ProEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    ciucod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='CiuCod', blank=True, null=True)  # Field name made lowercase.
    paicod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='PaiCod', related_name='proveedores_paicod_set', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'PROVEEDORES'


class Stock(models.Model):
    almcod = models.OneToOneField(Almacen, models.DO_NOTHING, db_column='AlmCod', primary_key=True)  # Field name made lowercase. The composite primary key (AlmCod, GraCod, EmpCod, AliCod) found, that is not supported. The first column is selected.
    stoest = models.CharField(db_column='StoEst', max_length=1, blank=True, null=True)  # Field name made lowercase.
    stocandis = models.IntegerField(db_column='StoCanDis', blank=True, null=True)  # Field name made lowercase.
    stoestreg = models.CharField(db_column='StoEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    gracod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='GraCod', related_name='stock_gracod_set')  # Field name made lowercase.
    empcod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='EmpCod', related_name='stock_empcod_set')  # Field name made lowercase.
    alicod = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'STOCK'
        unique_together = (('almcod', 'gracod', 'empcod', 'alicod'),)


class Toma(models.Model):
    tomcod = models.IntegerField(db_column='TomCod', primary_key=True)  # Field name made lowercase.
    tomnom = models.CharField(db_column='TomNom', max_length=20, blank=True, null=True)  # Field name made lowercase.
    tomhorini = models.TimeField(db_column='TomHorIni', blank=True, null=True)  # Field name made lowercase.
    tomhorfin = models.TimeField(db_column='TomHorFin', blank=True, null=True)  # Field name made lowercase.
    tomotrdat = models.TextField(db_column='TomOtrDat', blank=True, null=True)  # Field name made lowercase.
    tomestreg = models.CharField(db_column='TomEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'TOMA'
