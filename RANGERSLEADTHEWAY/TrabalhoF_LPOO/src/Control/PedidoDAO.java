/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import Model.Pedido;
import Model.Tapete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giuseppe
 */

public class PedidoDAO {
    
    private final String stmtInserir = "INSERT INTO pedido (cpf,forma,material,tamanho,custo) values(?, ?, ? , ? ,?);";
    private final String stmtInserirClientePedido = "INSERT INTO pedido (id_cliente, id_pedido) values(?, ?);";
    private final String stmtAlterar = "UPDATE pedido SET forma = ?, material = ?, tamanho = ?, custo = ? WHERE id_pedido = ?;";
    private final String stmtDelete = "DELETE FROM pedido WHERE id_pedido = ?;";
    private final String stmtGetPedidoCliente = "SELECT pedido.id_pedido, pedido.cpf, pedido.forma, pedido.material, pedido.tamanho ,pedido.custo FROM pedido, cliente WHERE pedido.cpf = ? AND cliente.cpf = ?";
    //SELECT Orders.OrderID, CustomerSs.CustomerName FROM OrdersINNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
    public List<Pedido> getPedidoDoCliente(String cpfCliente) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pedido> listaPedidos = new ArrayList<>();
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetPedidoCliente);
            stmt.setInt(1, Integer.parseInt(cpfCliente));
            stmt.setInt(2, Integer.parseInt(cpfCliente));
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido(rs.getInt("cpf"),
                rs.getString("forma"), rs.getString("material"),rs.getDouble("tamanho"),
                rs.getDouble("custo"));
                p.setId(rs.getInt("id_pedido"));
                listaPedidos.add(p);
                
            }
            return listaPedidos;
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

    public void atualizaPedido(Pedido pedido) {
        //UPDATE pedido SET forma = ?, material = ?, tamanho = ?, custo = ? WHERE id_pedido = ?;
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtAlterar);
            stmt.setString(1, pedido.getForma());
            stmt.setString(2, pedido.getMaterial());
            stmt.setDouble(3, pedido.getTamanho());
            stmt.setDouble(4, pedido.getCusto());
            stmt.setInt(5, pedido.getId());
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

    public void excluiPedido(Pedido pedido) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtDelete);
            stmt.setInt(1, pedido.getId());
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
    
    public void adicionaPedidoAoCliente(String cpfCliente,String tipoForma, String tipoMaterial,double tamanho ,double custo) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtInserir);
            stmt.setInt(1, Integer.parseInt(cpfCliente));
            stmt.setString(2, tipoForma);
            stmt.setString(3, tipoMaterial);
            stmt.setDouble(4, tamanho);
            stmt.setDouble(5, custo);
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

    public void excluiPedidoDoCliente(Pedido pedido) {

    }
}
