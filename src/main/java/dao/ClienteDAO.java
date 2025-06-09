package dao;

import db.Conexao;
import vo.ClienteVO;
import vo.ProdutoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public int cadastrarCliente(ClienteVO clienteVO) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("INSERT INTO cliente (nome, id_situacaocadastro, limitecompra, diafechamento) VALUES ('"+ clienteVO.getNome() +"', '"+ clienteVO.getSituacaocadastro()+"', '"+ clienteVO.getLimitecompra()+"', '"+ clienteVO.getDiafechamento()+"') returning id");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public void atualizarCliente(ClienteVO clienteVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE cliente SET nome = '"+ clienteVO.getNome() +"', id_situacaocadastro = '"+ clienteVO.getSituacaocadastro() +"', limitecompra = '"+ clienteVO.getLimitecompra() +"', diafechamento = '"+ clienteVO.getDiafechamento() +"' WHERE id = " + clienteVO.getId());
            st = conexao.prepareStatement(sql.toString());
            st.executeUpdate();
        }
    }

    public List<ClienteVO> consultarClientes(ClienteVO clienteVO) {
        List<ClienteVO> clientes = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM cliente WHERE 1=1");
            if (clienteVO.getNome() != null && !clienteVO.getNome().isEmpty()) {
                sql.append(" AND nome ILIKE '%").append(clienteVO.getNome()).append("%'");
            }
            if (clienteVO.getId() != null && !clienteVO.getId().equals(0)) {
                sql.append(" AND id = ").append(clienteVO.getId());
            }
            sql.append(" ORDER BY id ASC");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                ClienteVO model = new ClienteVO();
                model.setId(rs.getInt("id"));
                model.setNome(rs.getString("nome"));
                model.setLimitecompra(rs.getDouble("limitecompra"));
                model.setDiafechamento(rs.getInt("diafechamento"));
                clientes.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public ClienteVO consultarCliente(Integer idCliente) throws Exception {
        ClienteVO clienteVO = new ClienteVO();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM cliente WHERE id = " + idCliente);
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                clienteVO.setId(rs.getInt("id"));
                clienteVO.setNome(rs.getString("nome"));
                clienteVO.setSituacaocadastro(rs.getInt("id_situacaocadastro"));
                clienteVO.setDiafechamento(rs.getInt("diafechamento"));
                clienteVO.setLimitecompra(rs.getDouble("limitecompra"));
            }
        }
        return clienteVO;
    }

    public void excluirCliente(ClienteVO clienteVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE cliente SET id_situacaocadastro = '0' WHERE id = " + clienteVO.getId());
            st = conexao.prepareStatement(sql.toString());
            st.executeUpdate();
        }
    }
}
