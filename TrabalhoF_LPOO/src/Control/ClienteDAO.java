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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giuseppe
 */
public class ClienteDAO {

    private final String stmtInserir = "INSERT INTO cliente (nome, email, cpf) values( ?,  ?,  ?);";
    private final String stmtAlterar = "UPDATE cliente SET nome = ?, sobrenome = ?, cpf = ? WHERE id = ?;";
    private final String stmtDelete = "DELETE FROM cliente WHERE id = ?;";
    private final String stmtGetClinte = "SELECT * FROM clinte WHERE id = ?";
    private final String stmtGetClintes = "SELECT * FROM clinte";

    public List<Cliente> listaClientes() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> listCliente = new ArrayList<>();
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetClintes);
            rs = stmt.executeQuery();
            stmt.close();
            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("nome"),
                        rs.getString("sobrenome"), rs.getInt("cpf"));
                c.setId(rs.getInt("id"));
                listCliente.add(c);
            }
            return listCliente;
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

    public Cliente getCliente(int id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtGetClinte);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            stmt.close();
            while (rs.next()) {
                c = new Cliente(rs.getString("nome"),
                        rs.getString("sobrenome"), rs.getInt("cpf"));
                c.setId(rs.getInt("id"));
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

    public void insereCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtInserir);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobreNome());
            stmt.setInt(3, cliente.getCpf());
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

    public void atualizaCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtAlterar);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobreNome());
            stmt.setInt(3, cliente.getCpf());
            stmt.setInt(3, cliente.getCpf());
            stmt.setInt(4, cliente.getId());
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

    public void excluiCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(stmtDelete);
            stmt.setInt(1, cliente.getId());
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
