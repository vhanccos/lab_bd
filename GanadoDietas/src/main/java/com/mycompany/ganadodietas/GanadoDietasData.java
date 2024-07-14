/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ganadodietas;

/**
 *
 * @author Usuario
 */
import java.util.*;

public class GanadoDietasData {

    private static final Map<String, List<String>> tablasYColumnas = new LinkedHashMap<>();
    private static final Map<String, String> nombresColumnasLegibles = new HashMap<>();

    static {
        tablasYColumnas.put("nutriente alimento", Arrays.asList("NutAliCanCon", "NutAliEstReg", "AliCod", "NutCod"));
        tablasYColumnas.put("alimento tipo", Arrays.asList("AliTipCod", "AliTipDes", "AliEstReg"));
        tablasYColumnas.put("estado", Arrays.asList("EstCod", "EstDes", "EstEstReg"));
        tablasYColumnas.put("alimento dieta toma", Arrays.asList("DieCod", "TomCod", "AliDieTomCan", "AliCod", "AliDieTomEstReg"));
        tablasYColumnas.put("animal utilidad", Arrays.asList("AniUtiCod", "AniUtiDes", "AniUtiEstReg"));
        tablasYColumnas.put("magnitud", Arrays.asList("MagCod", "MagDes", "MagEstReg"));
        tablasYColumnas.put("detalles de pedido", Arrays.asList("DetPedHorLle", "DetPedDiaLle", "DetPedMesLle", "DetPedAnioLle", "DetPedDes", "CabPedCod", "AliCod", "DetPedEstReg"));
        tablasYColumnas.put("dieta animal fecha inicio", Arrays.asList("DieAniFecDesRel", "DieAniFecEstReg", "AniCod", "FecIniCod", "DieCod"));
        tablasYColumnas.put("cabecera pedido", Arrays.asList("CabPedCod", "ProCod", "AlmCod", "GraCod", "EmpCod", "CabPedEstReg"));
        tablasYColumnas.put("pais", Arrays.asList("PaiCod", "PaiDes", "PaiEstReg"));
        tablasYColumnas.put("animal nutriente", Arrays.asList("AniCod", "AniNutCanNes", "NutCod", "AniNutEstReg"));
        tablasYColumnas.put("animal tipo", Arrays.asList("AniTipCod", "AniUtiDes", "AniUtiEstReg"));
        tablasYColumnas.put("proveedores", Arrays.asList("ProCod", "ProNom", "ProCon", "ProInfFis", "ProDes", "ProEstReg", "CiuCod", "PaiCod"));
        tablasYColumnas.put("fecha inicio", Arrays.asList("FecIniCod", "FecIniDia", "FecIniMes", "FecIniAnio", "FecIniEstReg"));
        tablasYColumnas.put("ciudad", Arrays.asList("CiuCod", "CiuDes", "PaiCod", "CiuEstReg"));
        tablasYColumnas.put("almacen", Arrays.asList("AlmCod", "AlmNot", "GraCod", "EmpCod", "AlmCapMax", "AlmCapMin", "AlmEstReg"));
        tablasYColumnas.put("granja", Arrays.asList("GraCod", "GraNom", "GraNot", "GraEstReg", "CiuCod", "EmpCod", "PaiCod"));
        tablasYColumnas.put("animal", Arrays.asList("AniCod", "AniPes", "AniAnioNac", "AniPro", "AniDesDie", "AniUtiCod", "AniTipCod", "AniEstReg"));
        tablasYColumnas.put("toma", Arrays.asList("TomCod", "TomNom", "TomHorIni", "TomHorFin", "TomOtrDat", "TomEstReg"));
        tablasYColumnas.put("alimento", Arrays.asList("AliNom", "AliCos", "AliInfAnio", "MagCod", "AliTipCod", "AliCod", "AliEstReg"));
        tablasYColumnas.put("empresa", Arrays.asList("EmpCod", "EmpNom", "EmpEstReg", "CiuCod", "PaiCod"));
        tablasYColumnas.put("stock", Arrays.asList("AlmCod", "StoEst", "StoCanDis", "StoEstReg", "GraCod", "EmpCod", "AliCod"));
        tablasYColumnas.put("nutriente", Arrays.asList("NutNom", "NutInfRel", "NutEstReg", "EstCod", "MagCod", "NutCod"));
        tablasYColumnas.put("dieta", Arrays.asList("DieCod", "DieFin", "DieOtrDat", "DieEstReg"));

        nombresColumnasLegibles.put("NutAliCanCon", "Cantidad de Nutriente en Alimento");
        nombresColumnasLegibles.put("NutAliEstReg", "Estado del Registro de Nutriente en Alimento");
        nombresColumnasLegibles.put("AliCod", "Código de Alimento");
        nombresColumnasLegibles.put("NutCod", "Código de Nutriente");
        nombresColumnasLegibles.put("AliTipCod", "Código de Tipo de Alimento");
        nombresColumnasLegibles.put("AliTipDes", "Descripción de Tipo de Alimento");
        nombresColumnasLegibles.put("AliEstReg", "Estado del Registro de Alimento");
        nombresColumnasLegibles.put("EstCod", "Código de Estado");
        nombresColumnasLegibles.put("EstDes", "Descripción de Estado");
        nombresColumnasLegibles.put("EstEstReg", "Estado del Registro de Estado");
        nombresColumnasLegibles.put("DieCod", "Código de Dieta");
        nombresColumnasLegibles.put("TomCod", "Código de Toma");
        nombresColumnasLegibles.put("AliDieTomCan", "Cantidad de Alimento en Toma de Dieta");
        nombresColumnasLegibles.put("AliDieTomEstReg", "Estado del Registro de Alimento en Toma de Dieta");
        nombresColumnasLegibles.put("AniUtiCod", "Código de Utilidad de Animal");
        nombresColumnasLegibles.put("AniUtiDes", "Descripción de Utilidad de Animal");
        nombresColumnasLegibles.put("AniUtiEstReg", "Estado del Registro de Utilidad de Animal");
        nombresColumnasLegibles.put("MagCod", "Código de Magnitud");
        nombresColumnasLegibles.put("MagDes", "Descripción de Magnitud");
        nombresColumnasLegibles.put("MagEstReg", "Estado del Registro de Magnitud");
        nombresColumnasLegibles.put("DetPedHorLle", "Hora de Llegada del Detalle de Pedido");
        nombresColumnasLegibles.put("DetPedDiaLle", "Día de Llegada del Detalle de Pedido");
        nombresColumnasLegibles.put("DetPedMesLle", "Mes de Llegada del Detalle de Pedido");
        nombresColumnasLegibles.put("DetPedAnioLle", "Año de Llegada del Detalle de Pedido");
        nombresColumnasLegibles.put("DetPedDes", "Descripción del Detalle de Pedido");
        nombresColumnasLegibles.put("CabPedCod", "Código de Cabecera de Pedido");
        nombresColumnasLegibles.put("DetPedEstReg", "Estado del Registro del Detalle de Pedido");
        nombresColumnasLegibles.put("DieAniFecDesRel", "Descripción Relacionada de Fecha de Inicio de Dieta Animal");
        nombresColumnasLegibles.put("DieAniFecEstReg", "Estado del Registro de Fecha de Inicio de Dieta Animal");
        nombresColumnasLegibles.put("AniCod", "Código de Animal");
        nombresColumnasLegibles.put("FecIniCod", "Código de Fecha de Inicio");
        nombresColumnasLegibles.put("ProCod", "Código de Proveedor");
        nombresColumnasLegibles.put("AlmCod", "Código de Almacén");
        nombresColumnasLegibles.put("GraCod", "Código de Granja");
        nombresColumnasLegibles.put("EmpCod", "Código de Empresa");
        nombresColumnasLegibles.put("CabPedEstReg", "Estado del Registro de Cabecera de Pedido");
        nombresColumnasLegibles.put("PaiCod", "Código de País");
        nombresColumnasLegibles.put("PaiDes", "Descripción de País");
        nombresColumnasLegibles.put("PaiEstReg", "Estado del Registro de País");
        nombresColumnasLegibles.put("AniNutCanNes", "Cantidad Necesaria de Nutriente para Animal");
        nombresColumnasLegibles.put("AniNutEstReg", "Estado del Registro de Nutriente para Animal");
        nombresColumnasLegibles.put("AniTipCod", "Código de Tipo de Animal");
        nombresColumnasLegibles.put("ProNom", "Nombre del Proveedor");
        nombresColumnasLegibles.put("ProCon", "Contacto del Proveedor");
        nombresColumnasLegibles.put("ProInfFis", "Información Fiscal del Proveedor");
        nombresColumnasLegibles.put("ProDes", "Descripción del Proveedor");
        nombresColumnasLegibles.put("ProEstReg", "Estado del Registro del Proveedor");
        nombresColumnasLegibles.put("CiuCod", "Código de Ciudad");
        nombresColumnasLegibles.put("FecIniDia", "Día de Fecha de Inicio");
        nombresColumnasLegibles.put("FecIniMes", "Mes de Fecha de Inicio");
        nombresColumnasLegibles.put("FecIniAnio", "Año de Fecha de Inicio");
        nombresColumnasLegibles.put("FecIniEstReg", "Estado del Registro de Fecha de Inicio");
        nombresColumnasLegibles.put("CiuDes", "Descripción de Ciudad");
        nombresColumnasLegibles.put("CiuEstReg", "Estado del Registro de Ciudad");
        nombresColumnasLegibles.put("AlmNot", "Nota de Almacén");
        nombresColumnasLegibles.put("AlmCapMax", "Capacidad Máxima de Almacén");
        nombresColumnasLegibles.put("AlmCapMin", "Capacidad Mínima de Almacén");
        nombresColumnasLegibles.put("AlmEstReg", "Estado del Registro de Almacén");
        nombresColumnasLegibles.put("GraNom", "Nombre de Granja");
        nombresColumnasLegibles.put("GraNot", "Nota de Granja");
        nombresColumnasLegibles.put("GraEstReg", "Estado del Registro de Granja");
        nombresColumnasLegibles.put("AniPes", "Peso de Animal");
        nombresColumnasLegibles.put("AniAnioNac", "Año de Nacimiento de Animal");
        nombresColumnasLegibles.put("AniPro", "Producción de Animal");
        nombresColumnasLegibles.put("AniDesDie", "Descripción de Dieta de Animal");
        nombresColumnasLegibles.put("AniEstReg", "Estado del Registro de Animal");
        nombresColumnasLegibles.put("TomNom", "Nombre de Toma");
        nombresColumnasLegibles.put("TomHorIni", "Hora de Inicio de Toma");
        nombresColumnasLegibles.put("TomHorFin", "Hora de Fin de Toma");
        nombresColumnasLegibles.put("TomOtrDat", "Otros Datos de Toma");
        nombresColumnasLegibles.put("TomEstReg", "Estado del Registro de Toma");
        nombresColumnasLegibles.put("AliNom", "Nombre de Alimento");
        nombresColumnasLegibles.put("AliCos", "Costo de Alimento");
        nombresColumnasLegibles.put("AliInfAnio", "Información del Año de Alimento");
        nombresColumnasLegibles.put("AliTipCod", "Código de Tipo de Alimento");
        nombresColumnasLegibles.put("AliCod", "Código de Alimento");
        nombresColumnasLegibles.put("AliEstReg", "Estado del Registro de Alimento");
        nombresColumnasLegibles.put("EmpNom", "Nombre de Empresa");
        nombresColumnasLegibles.put("EmpEstReg", "Estado del Registro de Empresa");
        nombresColumnasLegibles.put("StoEst", "Estado de Stock");
        nombresColumnasLegibles.put("StoCanDis", "Cantidad Disponible de Stock");
        nombresColumnasLegibles.put("StoEstReg", "Estado del Registro de Stock");
        nombresColumnasLegibles.put("NutNom", "Nombre de Nutriente");
        nombresColumnasLegibles.put("NutInfRel", "Información Relacionada de Nutriente");
        nombresColumnasLegibles.put("NutEstReg", "Estado del Registro de Nutriente");
        nombresColumnasLegibles.put("DieFin", "Fin de Dieta");
        nombresColumnasLegibles.put("DieOtrDat", "Otros Datos de Dieta");
        nombresColumnasLegibles.put("DieEstReg", "Estado del Registro de Dieta");
    }

    public static Map<String, List<String>> getTablasYColumnas() {
        return tablasYColumnas;
    }

    public static Map<String, String> getNombresColumnasLegibles() {
        return nombresColumnasLegibles;
    }

    public static List<String> getColumnsForTable(String tableName) {
        return tablasYColumnas.get(tableName);
    }
}
