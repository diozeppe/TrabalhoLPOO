/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Tapete;
import Model.Material;
import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Giuseppe
 */
public class TapeteDAO {
    
    private final String stmtInserir = "INSERT INTO tapete (id_material) values(?);";
    private final String stmtInserirClintePedido = "INSERT INTO tapete_material (id_tapete, id_material) values(?, ?);";
    private final String stmtDelete = "DELETE FROM tapete WHERE id = ?;";
    private final String stmtGetMaterialTapete = "SELECT * FROM material INNER JOIN tapete_material ON material.id = tapete_material.id_material WHERE tapete.id = ?";

    public Material getMaterialDoTapete(Tapete tapete) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Material m = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetMaterialTapete);
            stmt.setInt(1, tapete.getId());
            rs = stmt.executeQuery();
            stmt.close();
            while (rs.next()) {
                Material material = new Material(rs.getInt("id"));
                m = ;
            }
            return p;
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
    
        public void excluiTapete(Tapete tapete) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtDelete);
            stmt.setInt(1, tapete.getId());
            stmt.execute();
            stmt.close();
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
