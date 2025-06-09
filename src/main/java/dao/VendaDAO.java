package dao;

import db.Conexao;
import vo.VendaItemVO;
import vo.VendaVO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public int cadastrarVenda(VendaVO vendaVO) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("INSERT INTO venda (id_cliente, data, valor) VALUES ('" + vendaVO.getId_cliente() + "', '" + vendaVO.getData() + "', '" + vendaVO.getValor() + "') returning id");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public void alterarVenda(VendaVO vendaVO) throws SQLException {
        PreparedStatement st = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE venda set id_cliente = '" + vendaVO.getId_cliente() + "', data ='" + vendaVO.getData() + "', valor = '" + vendaVO.getValor() + "' where id = '" + vendaVO.getId() + "'  ");
            st = conexao.prepareStatement(sql.toString());
            st.execute();
        }
    }

    public List<VendaVO> consultarVendas(VendaVO filtroVenda, VendaItemVO filtroProduto) {
        List<VendaVO> vendas = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT v.id, c.nome, v.data, v.valor ");
            sql.append("FROM venda v ");
            sql.append("JOIN cliente c ON v.id_cliente = c.id ");
            sql.append("JOIN vendaitem vi ON vi.id_venda = v.id ");
            sql.append("WHERE 1=1 ");
            if (filtroVenda != null) {
                if (filtroVenda.getId() != null && filtroVenda.getId() != 0) {
                    sql.append("AND v.id = " + filtroVenda.getId() + " ");
                }
                if (filtroVenda.getId_cliente() != null && filtroVenda.getId_cliente() != 0) {
                    sql.append("AND v.id_cliente = " + filtroVenda.getId_cliente() + " ");
                }
                if (filtroVenda.getDataInicial() != null && filtroVenda.getDataFinal() != null) {
                    sql.append("AND data between '" + filtroVenda.getDataInicial()+"' AND '" + filtroVenda.getDataFinal() + "' ");
                }
            }
            if (filtroProduto != null && filtroProduto.getId_produto() != null && filtroProduto.getId_produto() != 0) {
                sql.append("AND vi.id_produto = " + filtroProduto.getId_produto() + " ");
            }
            sql.append("ORDER BY v.id ASC");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                VendaVO vendaVO = new VendaVO();
                vendaVO.setId(rs.getInt("id"));
                vendaVO.setNomeCliente(rs.getString("nome"));
                vendaVO.setData(rs.getDate("data").toLocalDate());
                vendaVO.setValor(rs.getDouble("valor"));
                vendas.add(vendaVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public List<VendaVO> consultarVendasCliente(VendaVO filtro) {
        List<VendaVO> vendas = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c.id AS idcliente, c.nome, v.data, SUM(v.valor) AS totalvendas ");
            sql.append("FROM venda v ");
            sql.append("JOIN cliente c ON v.id_cliente = c.id ");
            sql.append("WHERE 1=1 ");

            if (filtro.getId_cliente() != null && filtro.getId_cliente() != 0) {
                sql.append("AND c.id = ").append(filtro.getId_cliente()).append(" ");
            }
            if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
                sql.append("AND data between '" + filtro.getDataInicial()+"' AND '" + filtro.getDataFinal() + "' ");
            }

            sql.append("GROUP BY c.id, c.nome, v.data ");
            sql.append("ORDER BY c.id ASC, v.data ASC");

            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();

            while (rs.next()) {
                VendaVO vendaVO = new VendaVO();
                vendaVO.setId_cliente(rs.getInt("idcliente"));
                vendaVO.setNomeCliente(rs.getString("nome"));
                vendaVO.setData(rs.getDate("data").toLocalDate());
                vendaVO.setValor(rs.getDouble("totalvendas"));
                vendas.add(vendaVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public List<VendaItemVO> consultarVendasProduto(VendaItemVO filtro, VendaVO filtroVenda) {
        List<VendaItemVO> itensVendidos = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p.id AS idproduto, p.descricao AS descricao, v.data, v.id_cliente, ");
            sql.append("SUM(vi.valortotal) AS totalvendido ");
            sql.append("FROM vendaitem vi ");
            sql.append("JOIN produto p ON vi.id_produto = p.id ");
            sql.append("JOIN venda v ON vi.id_venda = v.id ");
            sql.append("WHERE 1=1 ");
            if (filtro != null) {
                if (filtro.getId_produto() != null && filtro.getId_produto() != 0) {
                    sql.append("AND p.id = ").append(filtro.getId_produto()).append(" ");
                }
                if (filtroVenda.getDataInicial() != null && filtroVenda.getDataFinal() != null) {
                    sql.append("AND v.data between '" + filtroVenda.getDataInicial()+"' AND '" + filtroVenda.getDataFinal() + "' ");
                }
            }
            sql.append("GROUP BY p.id, p.descricao, v.data, v.id_cliente ");
            sql.append("ORDER BY p.id ASC, v.data ASC");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                VendaItemVO vendaItemVO = new VendaItemVO();
                vendaItemVO.setId_produto(rs.getInt("idproduto"));
                vendaItemVO.setDescricao(rs.getString("descricao"));
                vendaItemVO.setValortotal(rs.getDouble("totalvendido"));
                VendaVO vendaVO = new VendaVO();
                vendaVO.setData(rs.getDate("data").toLocalDate());
                vendaVO.setId_cliente(rs.getInt("id_cliente"));
                vendaItemVO.setVenda(vendaVO);
                itensVendidos.add(vendaItemVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itensVendidos;
    }

    public VendaVO consultarVenda(Integer idVenda) throws Exception {
        VendaVO vendaVO = new VendaVO();
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT v.id, c.nome AS nome, v.id_cliente, v.data, v.valor FROM venda v JOIN cliente c ON v.id_cliente = c.id WHERE v.id = " + idVenda);
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                vendaVO.setId(rs.getInt("id"));
                vendaVO.setNomeCliente(rs.getString("nome"));
                vendaVO.setId_cliente(rs.getInt("id_cliente"));
                vendaVO.setData(rs.getDate("data").toLocalDate());
                vendaVO.setValor(rs.getDouble("valor"));
            }
        }
        return vendaVO;
    }

    public double valorVendaPeriodo(int idCliente, LocalDate inicio, LocalDate fim) throws SQLException {
        double total = 0;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COALESCE(SUM(valor), 0) AS total ");
        sql.append("FROM venda ");
        sql.append("WHERE id_cliente = '" + idCliente + "' ");
        sql.append("AND data >= DATE '" + inicio + "' ");
        sql.append("AND data <= DATE '" + fim + "'");

        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement st = conexao.prepareStatement(sql.toString());
             ResultSet rs = st.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }
        }

        return total;
    }


}
