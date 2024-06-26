/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ganadodietas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class AnimalGan {
    
    private Connection connection;

    public AnimalGan(Connection connection) {
        this.connection = connection;
    }

    public void createAnimal(String aniCod, int aniPes, int aniAñoNac, String aniPro, String aniDesDie, String aniEstReg, String aniUtiCod, String aniTipCod) {
        String query = "INSERT INTO ANIMAL (AniCod, AniPes, AniAñoNac, AniPro, AniDesDie, AniEstReg, AniUtiCod, AniTipCod) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, aniCod);
            ps.setInt(2, aniPes);
            ps.setInt(3, aniAñoNac);
            ps.setString(4, aniPro);
            ps.setString(5, aniDesDie);
            ps.setString(6, aniEstReg);
            ps.setString(7, aniUtiCod);
            ps.setString(8, aniTipCod);
            ps.executeUpdate();
            System.out.println("Animal created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readAnimal(String aniCod) {
        String query = "SELECT * FROM ANIMAL WHERE AniCod = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, aniCod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("AniCod: " + rs.getString("AniCod"));
                System.out.println("AniPes: " + rs.getInt("AniPes"));
                System.out.println("AniAñoNac: " + rs.getInt("AniAñoNac"));
                System.out.println("AniPro: " + rs.getString("AniPro"));
                System.out.println("AniDesDie: " + rs.getString("AniDesDie"));
                System.out.println("AniEstReg: " + rs.getString("AniEstReg"));
                System.out.println("AniUtiCod: " + rs.getString("AniUtiCod"));
                System.out.println("AniTipCod: " + rs.getString("AniTipCod"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAnimal(String aniCod, int aniPes, int aniAñoNac, String aniPro, String aniDesDie, String aniEstReg, String aniUtiCod, String aniTipCod) {
        String query = "UPDATE ANIMAL SET AniPes = ?, AniAñoNac = ?, AniPro = ?, AniDesDie = ?, AniEstReg = ?, AniUtiCod = ?, AniTipCod = ? WHERE AniCod = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, aniPes);
            ps.setInt(2, aniAñoNac);
            ps.setString(3, aniPro);
            ps.setString(4, aniDesDie);
            ps.setString(5, aniEstReg);
            ps.setString(6, aniUtiCod);
            ps.setString(7, aniTipCod);
            ps.setString(8, aniCod);
            ps.executeUpdate();
            System.out.println("Animal updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAnimal(String aniCod) {
        String query = "DELETE FROM ANIMAL WHERE AniCod = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, aniCod);
            ps.executeUpdate();
            System.out.println("Animal deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
