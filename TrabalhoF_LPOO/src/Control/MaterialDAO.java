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
    
    
    public List<Material> listaMateriais(){
        return;
    }
    
    public Modelo getModelo(Material material){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Modelo m = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetClinte);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            stmt.close();
            while (rs.next()) {
                c = new Cliente(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("sobrenome"), rs.getInt("cpf"));
            }
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
