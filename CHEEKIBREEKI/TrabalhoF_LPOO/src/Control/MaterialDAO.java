/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Material;
import Model.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Giuseppe
 */
public class MaterialDAO {
    
    
    //public List<Material> listaMateriais(){
    //    return;
    //}
    private final String stmtGetPreco = "SELECT precom2 FROM material WHERE id_material = ?";
    private final String stmtAtualizarPreco = "UPDATE material SET precom2 = ? WHERE id_material = ?;";
    
    public double getPreco(int id){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Modelo m = null;
        double precom2 = 0.0;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetPreco);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                precom2 = (rs.getDouble("precom2"));
            }
            return precom2;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void atualizaPreco(int id, double precom2) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtAtualizarPreco);
            stmt.setDouble(1, precom2);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
