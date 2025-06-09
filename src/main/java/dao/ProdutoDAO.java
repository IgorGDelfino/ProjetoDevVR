package dao;

import db.Conexao;
import vo.ProdutoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public int cadastrarProduto(ProdutoVO produtoVO) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("INSERT INTO produto (descricao, id_situacaocadastro, valorunitario) VALUES ('"+ produtoVO.getDescricao() +"', '"+ produtoVO.getSituacaocadastro()+"', '" + produtoVO.getValorunitario() + "') returning id");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public List<ProdutoVO> consultarProdutos(ProdutoVO produtoVO) {
        List<ProdutoVO> produtos = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM produto WHERE 1=1");
            if (produtoVO.getDescricao() != null && !produtoVO.getDescricao().isEmpty()) {
                sql.append(" AND descricao ILIKE '%").append(produtoVO.getDescricao()).append("%'");
            }
            if (produtoVO.getId() != null && !produtoVO.getId().equals(0)) {
                sql.append(" AND id = ").append(produtoVO.getId());
            }
            sql.append(" ORDER BY id ASC");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                ProdutoVO model = new ProdutoVO();
                model.setId(rs.getInt("id"));
                model.setDescricao(rs.getString("descricao"));
                model.setValorunitario(rs.getDouble("valorunitario"));
                produtos.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public ProdutoVO consultarProduto(Integer idProduto) throws Exception {
        ProdutoVO produtoVO = new ProdutoVO();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM produto WHERE id = " + idProduto);
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                produtoVO.setId(rs.getInt("id"));
                produtoVO.setDescricao(rs.getString("descricao"));
                produtoVO.setSituacaocadastro(rs.getInt("id_situacaocadastro"));
                produtoVO.setValorunitario(rs.getDouble("valorunitario"));
            }
        }
        return produtoVO;
    }

    public void atualizarProduto(ProdutoVO produtoVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE produto SET descricao = '" + produtoVO.getDescricao() + "', id_situacaocadastro = '"+ produtoVO.getSituacaocadastro() +"',valorunitario = '"+ produtoVO.getValorunitario() +"' WHERE id = " + produtoVO.getId());
            st = conexao.prepareStatement(sql.toString());
            st.executeUpdate();
        }
    }

    public void excluirProduto(ProdutoVO produtoVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE produto SET id_situacaocadastro = '0' WHERE id = " + produtoVO.getId());
            st = conexao.prepareStatement(sql.toString());
            st.executeUpdate();
        }
    }
}
