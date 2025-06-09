package services;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import vo.ProdutoVO;

import javax.swing.*;

public class ProdutoService {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public int salvarProduto(ProdutoVO produto) throws SQLException {
        if (produto.getId() == -1) {
            return produtoDAO.cadastrarProduto(produto);
        } else {
            produtoDAO.atualizarProduto(produto);
            return produto.getId();
        }
    }

    public void excluirProduto(ProdutoVO produto) throws SQLException {
        if (produto.getSituacaocadastro() == 1) {
            produtoDAO.excluirProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "O produto já está excluído.");
        }
    }

    public List<ProdutoVO> consultarProdutos(ProdutoVO produtoVO) {
        return produtoDAO.consultarProdutos(produtoVO);
    }

    public ProdutoVO consultarProduto(Integer idProduto) {
        try {
            return produtoDAO.consultarProduto(idProduto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
