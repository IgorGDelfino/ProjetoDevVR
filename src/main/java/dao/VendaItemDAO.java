package dao;

import db.Conexao;
import vo.VendaItemVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaItemDAO {

    public void cadastrarVendaItem(VendaItemVO vendaItemVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO vendaitem (id_venda, id_produto, quantidade, valorunitario, valortotal) VALUES");
            sql.append("('" + vendaItemVO.getId_venda() + "' , ");
            sql.append("'" + vendaItemVO.getId_produto() + "', ");
            sql.append("'" + vendaItemVO.getQuantidade() + "', ");
            sql.append("'" + vendaItemVO.getValorunitario() + "', ");
            sql.append("'" + vendaItemVO.getValortotal() + "') ");
            st = conexao.prepareStatement(sql.toString());
            st.execute();
        }
    }

    public boolean verificarVendaItem(int id_produto, int id_venda) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT id FROM vendaitem ");
            sql.append("WHERE id_produto = '" + id_produto + "' ");
            sql.append("AND id_venda = '" + id_venda + "' ");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
        }
        return rs.next() ? true : false;
    }

    public void removerVendaItem(int idProduto, int idVenda) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM vendaitem ");
            sql.append("WHERE id_produto = '" + idProduto + "' ");
            sql.append("AND id_venda = '" + idVenda + "' ");
            st = conexao.prepareStatement(sql.toString());
            st.execute();
        }
    }

    public void alterarVendaItem(VendaItemVO vendaItemVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE vendaitem SET ");
            sql.append("quantidade = '" + vendaItemVO.getQuantidade() + "' , ");
            sql.append("valorunitario = '" + vendaItemVO.getValorunitario() + "', ");
            sql.append("valortotal = '" + vendaItemVO.getValortotal() + "' ");
            sql.append("WHERE id_produto = '" + vendaItemVO.getId_produto() + "' ");
            sql.append("AND id_venda = " + vendaItemVO.getId_venda());
            st = conexao.prepareStatement(sql.toString());
            st.execute();
        }
    }

    public List<VendaItemVO> consultarVendaItem(int idVenda) {
        List<VendaItemVO> vendasItem = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT vi.id_produto, p.descricao, vi.quantidade, vi.valorunitario, vi.valortotal ");
            sql.append("FROM vendaitem vi ");
            sql.append("JOIN produto p ON vi.id_produto = p.id ");
            sql.append("WHERE vi.id_venda = '" + idVenda + "' ");
            sql.append("ORDER BY vi.id_produto ASC");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                VendaItemVO vendaItem = new VendaItemVO();
                vendaItem.setId_produto(rs.getInt("id_produto"));
                vendaItem.setDescricao(rs.getString("descricao"));
                vendaItem.setQuantidade(rs.getInt("quantidade"));
                vendaItem.setValorunitario(rs.getDouble("valorunitario"));
                vendaItem.setValortotal(rs.getDouble("valortotal"));
                vendasItem.add(vendaItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendasItem;
    }

    public VendaItemVO consultarVendaItem(Integer id_produto, Integer id_venda) throws Exception {
        VendaItemVO vendaItemVO = new VendaItemVO();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT vi.id_produto, vi.quantidade, vi.valorunitario , vi.valortotal, p.descricao FROM vendaitem vi JOIN produto p ON vi.id_produto = p.id  WHERE vi.id_produto = '" + id_produto + "' and vi.id_venda = '" + id_venda + "'");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                vendaItemVO.setId_produto(rs.getInt("id_produto"));
                vendaItemVO.setQuantidade(rs.getInt("quantidade"));
                vendaItemVO.setDescricao(rs.getString("descricao"));
                vendaItemVO.setValorunitario(rs.getDouble("valorunitario"));
                vendaItemVO.setValortotal(rs.getDouble("valortotal"));
            }
        }
        return vendaItemVO;
    }

}
