package dao;

import db.Conexao;
import vo.TabelasVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriarTabelasDAO {

    TabelasVO tabelasVO = new TabelasVO();

    public void criarTabelaProduto() throws SQLException, ClassNotFoundException {
        PreparedStatement st = null;
        tabelasVO.setTabela("public.produto");
        if (!VerificarTabelasDAO.tabelaExiste(tabelasVO)) {
            try (Connection conexao = new Conexao().getConnection()) {
                StringBuilder sql = new StringBuilder();
                sql.append("CREATE TABLE produto (id SERIAL NOT NULL, descricao varchar(50), valorunitario numeric(11,2), id_situacaocadastro int4)");
                st = conexao.prepareStatement(sql.toString());
                st.execute();
            }
        }
    }

    public void criarTabelaCliente() throws SQLException, ClassNotFoundException {
        PreparedStatement st = null;
        tabelasVO.setTabela("public.cliente");
        if (!VerificarTabelasDAO.tabelaExiste(tabelasVO)) {
            try (Connection conexao = new Conexao().getConnection()) {
                StringBuilder sql = new StringBuilder();
                sql.append("CREATE TABLE cliente (id SERIAL NOT NULL, nome varchar(50), diafechamento int4, limitecompra numeric(11,2), id_situacaocadastro int4)");
                st = conexao.prepareStatement(sql.toString());
                st.execute();
            }
        }
    }

    public void criarTabelaVenda() throws SQLException, ClassNotFoundException {
        PreparedStatement st = null;
        tabelasVO.setTabela("public.venda");
        if (!VerificarTabelasDAO.tabelaExiste(tabelasVO)) {
            try (Connection conexao = new Conexao().getConnection()) {
                StringBuilder sql = new StringBuilder();
                sql.append("CREATE TABLE venda (id SERIAL NOT NULL, id_cliente int, data DATE, valor numeric(11,2))");
                st = conexao.prepareStatement(sql.toString());
                st.execute();
            }
        }
    }

    public void criarTabelaVendaItem() throws SQLException, ClassNotFoundException {
        PreparedStatement st = null;
        tabelasVO.setTabela("public.vendaitem");
        if (!VerificarTabelasDAO.tabelaExiste(tabelasVO)) {
            try (Connection conexao = new Conexao().getConnection()) {
                StringBuilder sql = new StringBuilder();
                sql.append("CREATE TABLE vendaitem (id SERIAL NOT NULL,id_venda int ,id_produto int , quantidade int, valorunitario numeric(11,2), valortotal numeric(11,2))");
                st = conexao.prepareStatement(sql.toString());
                st.execute();
            }
        }
    }

    public void criarTabelaSituacaoCadastro() throws SQLException, ClassNotFoundException {
        PreparedStatement st = null;
        tabelasVO.setTabela("public.situacaocadastro");
        if (!VerificarTabelasDAO.tabelaExiste(tabelasVO)) {
            try (Connection conexao = new Conexao().getConnection()) {
                StringBuilder sql = new StringBuilder();
                sql.append("CREATE TABLE situacaocadastro (id INT PRIMARY KEY, descricao VARCHAR(20) NOT NULL);");
                sql.append("INSERT INTO situacaocadastro (id, descricao) VALUES (0, 'Excluido'), (1, 'Ativo')");
                st = conexao.prepareStatement(sql.toString());
                st.execute();
            }
        }
    }

}
