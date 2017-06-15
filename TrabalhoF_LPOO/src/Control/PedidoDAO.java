/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Giuseppe
 */

public class PedidoDAO {

    private final String stmtInserir = "INSERT INTO pedido (valor) values(?);";
    private final String stmtInserirClintePedido = "INSERT INTO cliente_pedido (id_cliente, id_pedido) values(?, ?);";
    private final String stmtAlterar = "UPDATE pedido SET valor = ?  WHERE id = ?;";
    private final String stmtDelete = "DELETE FROM pedido WHERE id = ?;";
    private final String stmtGetPedidoCliente = "SELECT * FROM livro INNER JOIN livro_autor ON livro.id = livro_autor.idLivro WHERE livro_autor.idAutor = ?";

    public Pedido getPedidoDoCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido p = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetPedidoCliente);
            stmt.setInt(1, cliente.getId());
            rs = stmt.executeQuery();
            stmt.close();
            while (rs.next()) {
                p = new Pedido(rs.getInt("id"));
                p.setValor(rs.getDouble("valor"));
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

    public void atualizaPedido(Pedido pedido) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtAlterar);
            stmt.setDouble(1, pedido.getValor());
            stmt.setInt(2, pedido.getId());
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
    
    public void adicionaPedidoAoCliente(Pedido pedido, String cpfCliente) {

    }

    public void excluiPedidoDoCliente(Pedido pedido) {

    }
}
