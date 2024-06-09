# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Alimento(models.Model):
    alinom = models.CharField(db_column='AliNom', primary_key=True, max_length=30)  # Field name made lowercase.
    alicos = models.IntegerField(db_column='AliCos', blank=True, null=True)  # Field name made lowercase.
    aliinfaña = models.TextField(db_column='AliInfAña', blank=True, null=True)  # Field name made lowercase.
    aliestreg = models.CharField(db_column='AliEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    magcod = models.ForeignKey('Magnitud', models.DO_NOTHING, db_column='MagCod', blank=True, null=True)  # Field name made lowercase.
    alitipcod = models.ForeignKey('AlimentoTipo', models.DO_NOTHING, db_column='AliTipCod', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALIMENTO'


class AlimentoDietaToma(models.Model):
    diecod = models.OneToOneField('Dieta', models.DO_NOTHING, db_column='DieCod', primary_key=True)  # Field name made lowercase. The composite primary key (DieCod, AliNom, TomCod) found, that is not supported. The first column is selected.
    alinom = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliNom')  # Field name made lowercase.
    tomcod = models.ForeignKey('Toma', models.DO_NOTHING, db_column='TomCod')  # Field name made lowercase.
    alidietomcan = models.DecimalField(db_column='AliDieTomCan', max_digits=4, decimal_places=2, blank=True, null=True)  # Field name made lowercase.
    alidietomestreg = models.CharField(db_column='AliDieTomEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALIMENTO DIETA TOMA'
        unique_together = (('diecod', 'alinom', 'tomcod'),)


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
    empcod = models.ForeignKey('Empresa', models.DO_NOTHING, db_column='EmpCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ALMACEN'
        unique_together = (('almcod', 'gracod', 'empcod'),)


class Animal(models.Model):
    anicod = models.CharField(db_column='AniCod', primary_key=True, max_length=10)  # Field name made lowercase.
    anipes = models.IntegerField(db_column='AniPes', blank=True, null=True)  # Field name made lowercase.
    aniañonac = models.IntegerField(db_column='AniAñoNac', blank=True, null=True)  # Field name made lowercase.
    anipro = models.CharField(db_column='AniPro', max_length=20, blank=True, null=True)  # Field name made lowercase.
    anidesdie = models.TextField(db_column='AniDesDie', blank=True, null=True)  # Field name made lowercase.
    aniestreg = models.CharField(db_column='AniEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    aniuticod = models.ForeignKey('AnimalUtilidad', models.DO_NOTHING, db_column='AniUtiCod', blank=True, null=True)  # Field name made lowercase.
    anitipcod = models.ForeignKey('AnimalTipo', models.DO_NOTHING, db_column='AniTipCod', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ANIMAL'


class AnimalNutriente(models.Model):
    anicod = models.OneToOneField(Animal, models.DO_NOTHING, db_column='AniCod', primary_key=True)  # Field name made lowercase. The composite primary key (AniCod, NutNom) found, that is not supported. The first column is selected.
    nutnom = models.ForeignKey('Nutriente', models.DO_NOTHING, db_column='NutNom')  # Field name made lowercase.
    aninutcannes = models.IntegerField(db_column='AniNutCanNes', blank=True, null=True)  # Field name made lowercase.
    aninutestreg = models.CharField(db_column='AniNutEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ANIMAL NUTRIENTE'
        unique_together = (('anicod', 'nutnom'),)


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
    cabpedcod = models.CharField(db_column='CabPedCod', primary_key=True, max_length=1)  # Field name made lowercase. The composite primary key (CabPedCod, ProCod, AlmCod, GraCod, EmpCod) found, that is not supported. The first column is selected.
    procod = models.ForeignKey('Proveedores', models.DO_NOTHING, db_column='ProCod')  # Field name made lowercase.
    cabpedestreg = models.CharField(db_column='CabPedEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    almcod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='AlmCod')  # Field name made lowercase.
    gracod = models.ForeignKey('Granja', models.DO_NOTHING, db_column='GraCod')  # Field name made lowercase.
    empcod = models.ForeignKey('Empresa', models.DO_NOTHING, db_column='EmpCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'CABECERA PEDIDO'
        unique_together = (('cabpedcod', 'procod', 'almcod', 'gracod', 'empcod'),)


class Ciudad(models.Model):
    ciucod = models.CharField(db_column='CiuCod', primary_key=True, max_length=2)  # Field name made lowercase.
    ciudes = models.CharField(db_column='CiuDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    ciuestreg = models.CharField(db_column='CiuEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    painom = models.ForeignKey('Pais', models.DO_NOTHING, db_column='PaiNom', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'CIUDAD'


class DetallesDePedido(models.Model):
    detpedcod = models.CharField(db_column='DetPedCod', primary_key=True, max_length=1)  # Field name made lowercase. The composite primary key (DetPedCod, CabPedCod, ProCod, AlmCod, GraCod, EmpCod, AliNom) found, that is not supported. The first column is selected.
    alinom = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliNom')  # Field name made lowercase.
    detpedhorlle = models.TimeField(db_column='DetPedHorLle', blank=True, null=True)  # Field name made lowercase.
    detpeddialle = models.IntegerField(db_column='DetPedDiaLle', blank=True, null=True)  # Field name made lowercase.
    detpedmeslle = models.IntegerField(db_column='DetPedMesLle', blank=True, null=True)  # Field name made lowercase.
    detpedañolle = models.IntegerField(db_column='DetPedAñoLle', blank=True, null=True)  # Field name made lowercase.
    detpeddes = models.TextField(db_column='DetPedDes', blank=True, null=True)  # Field name made lowercase.
    detpedestreg = models.CharField(db_column='DetPedEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    cabpedcod = models.ForeignKey(CabeceraPedido, models.DO_NOTHING, db_column='CabPedCod')  # Field name made lowercase.
    procod = models.ForeignKey('Proveedores', models.DO_NOTHING, db_column='ProCod')  # Field name made lowercase.
    almcod = models.ForeignKey('Almacen', models.DO_NOTHING, db_column='AlmCod')  # Field name made lowercase.
    gracod = models.ForeignKey('Granja', models.DO_NOTHING, db_column='GraCod')  # Field name made lowercase.
    empcod = models.ForeignKey('Empresa', models.DO_NOTHING, db_column='EmpCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'DETALLES DE PEDIDO'
        unique_together = (('detpedcod', 'cabpedcod', 'procod', 'almcod', 'gracod', 'empcod', 'alinom'),)


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
    empnom = models.CharField(db_column='EmpNom', max_length=20, blank=True, null=True)  # Field name made lowercase.
    detpetcod = models.CharField(db_column='DetPetCod', max_length=1, blank=True, null=True)  # Field name made lowercase.
    ciucod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='CiuCod', blank=True, null=True)  # Field name made lowercase.

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
    gradir = models.CharField(db_column='GraDir', max_length=60, blank=True, null=True)  # Field name made lowercase.
    granot = models.TextField(db_column='GraNot', blank=True, null=True)  # Field name made lowercase.
    graestreg = models.CharField(db_column='GraEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    ciucod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='CiuCod', blank=True, null=True)  # Field name made lowercase.
    empcod = models.ForeignKey(Empresa, models.DO_NOTHING, db_column='EmpCod')  # Field name made lowercase.

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
    nutnom = models.CharField(db_column='NutNom', primary_key=True, max_length=30)  # Field name made lowercase.
    nutinfrel = models.TextField(db_column='NutInfRel', blank=True, null=True)  # Field name made lowercase.
    nutestreg = models.CharField(db_column='NutEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    estcod = models.ForeignKey(Estado, models.DO_NOTHING, db_column='EstCod', blank=True, null=True)  # Field name made lowercase.
    magcod = models.ForeignKey(Magnitud, models.DO_NOTHING, db_column='MagCod', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'NUTRIENTE'


class NutrienteAlimento(models.Model):
    nutnom = models.OneToOneField(Nutriente, models.DO_NOTHING, db_column='NutNom', primary_key=True)  # Field name made lowercase. The composite primary key (NutNom, AliNom) found, that is not supported. The first column is selected.
    alinom = models.ForeignKey(Alimento, models.DO_NOTHING, db_column='AliNom')  # Field name made lowercase.
    nutalicancon = models.IntegerField(db_column='NutAliCanCon', blank=True, null=True)  # Field name made lowercase.
    nutaliestreg = models.CharField(db_column='NutAliEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'NUTRIENTE ALIMENTO'
        unique_together = (('nutnom', 'alinom'),)


class Pais(models.Model):
    painom = models.CharField(db_column='PaiNom', primary_key=True, max_length=10)  # Field name made lowercase.
    paides = models.CharField(db_column='PaiDes', max_length=20, blank=True, null=True)  # Field name made lowercase.
    paiestreg = models.CharField(db_column='PaiEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'PAIS'


class Proveedores(models.Model):
    procod = models.CharField(db_column='ProCod', primary_key=True, max_length=10)  # Field name made lowercase.
    pronom = models.CharField(db_column='ProNom', max_length=30, blank=True, null=True)  # Field name made lowercase.
    prodir = models.CharField(db_column='ProDir', max_length=60, blank=True, null=True)  # Field name made lowercase.
    procon = models.CharField(db_column='ProCon', max_length=8, blank=True, null=True)  # Field name made lowercase.
    proinffis = models.CharField(db_column='ProInfFis', unique=True, max_length=1)  # Field name made lowercase.
    prodes = models.TextField(db_column='ProDes', blank=True, null=True)  # Field name made lowercase.
    proestreg = models.CharField(db_column='ProEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    ciucod = models.ForeignKey(Ciudad, models.DO_NOTHING, db_column='CiuCod', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'PROVEEDORES'


class Stock(models.Model):
    almcod = models.ForeignKey(Almacen, models.DO_NOTHING, db_column='AlmCod')  # Field name made lowercase.
    alinom = models.OneToOneField(Alimento, models.DO_NOTHING, db_column='AliNom', primary_key=True)  # Field name made lowercase. The composite primary key (AliNom, AlmCod, GraCod, EmpCod) found, that is not supported. The first column is selected.
    stoest = models.CharField(db_column='StoEst', max_length=1, blank=True, null=True)  # Field name made lowercase.
    stocandis = models.IntegerField(db_column='StoCanDis', blank=True, null=True)  # Field name made lowercase.
    stoestreg = models.CharField(db_column='StoEstReg', max_length=1, blank=True, null=True)  # Field name made lowercase.
    gracod = models.ForeignKey(Granja, models.DO_NOTHING, db_column='GraCod')  # Field name made lowercase.
    empcod = models.ForeignKey(Empresa, models.DO_NOTHING, db_column='EmpCod')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'STOCK'
        unique_together = (('alinom', 'almcod', 'gracod', 'empcod'),)


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


class AuthGroup(models.Model):
    name = models.CharField(unique=True, max_length=150)

    class Meta:
        managed = False
        db_table = 'auth_group'


class AuthGroupPermissions(models.Model):
    id = models.BigAutoField(primary_key=True)
    group = models.ForeignKey(AuthGroup, models.DO_NOTHING)
    permission = models.ForeignKey('AuthPermission', models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'auth_group_permissions'
        unique_together = (('group', 'permission'),)


class AuthPermission(models.Model):
    name = models.CharField(max_length=255)
    content_type = models.ForeignKey('DjangoContentType', models.DO_NOTHING)
    codename = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'auth_permission'
        unique_together = (('content_type', 'codename'),)


class AuthUser(models.Model):
    password = models.CharField(max_length=128)
    last_login = models.DateTimeField(blank=True, null=True)
    is_superuser = models.IntegerField()
    username = models.CharField(unique=True, max_length=150)
    first_name = models.CharField(max_length=150)
    last_name = models.CharField(max_length=150)
    email = models.CharField(max_length=254)
    is_staff = models.IntegerField()
    is_active = models.IntegerField()
    date_joined = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'auth_user'


class AuthUserGroups(models.Model):
    id = models.BigAutoField(primary_key=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)
    group = models.ForeignKey(AuthGroup, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'auth_user_groups'
        unique_together = (('user', 'group'),)


class AuthUserUserPermissions(models.Model):
    id = models.BigAutoField(primary_key=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)
    permission = models.ForeignKey(AuthPermission, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'auth_user_user_permissions'
        unique_together = (('user', 'permission'),)


class DjangoAdminLog(models.Model):
    action_time = models.DateTimeField()
    object_id = models.TextField(blank=True, null=True)
    object_repr = models.CharField(max_length=200)
    action_flag = models.PositiveSmallIntegerField()
    change_message = models.TextField()
    content_type = models.ForeignKey('DjangoContentType', models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'django_admin_log'


class DjangoContentType(models.Model):
    app_label = models.CharField(max_length=100)
    model = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'django_content_type'
        unique_together = (('app_label', 'model'),)


class DjangoMigrations(models.Model):
    id = models.BigAutoField(primary_key=True)
    app = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    applied = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'django_migrations'


class DjangoSession(models.Model):
    session_key = models.CharField(primary_key=True, max_length=40)
    session_data = models.TextField()
    expire_date = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'django_session'
