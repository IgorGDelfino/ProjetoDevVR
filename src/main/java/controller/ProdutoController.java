package controller;

import java.sql.SQLException;
import java.util.List;
import vo.ProdutoVO;
import services.ProdutoService;

public class ProdutoController {

    ProdutoService produtoService = new ProdutoService();
    
    public int salvarProduto (ProdutoVO produto) throws SQLException, ClassNotFoundException{
        return produtoService.salvarProduto(produto);
    }

    public void excluirProduto (ProdutoVO produto) throws SQLException, ClassNotFoundException{
        produtoService.excluirProduto(produto);
    }

    public List<ProdutoVO> consultarProdutos(ProdutoVO produtoVO) {
        return produtoService.consultarProdutos(produtoVO);
    }

    public ProdutoVO consultarProduto(Integer idProduto) {
        return produtoService.consultarProduto(idProduto);
    }
}
