package controller;

import services.VendaItemService;
import vo.VendaItemVO;
import java.sql.SQLException;
import java.util.List;

public class VendaItemController {

    VendaItemService vendaItemService = new VendaItemService();

    public VendaItemVO consultarVendaItem(Integer idProduto, Integer idVenda){
        return vendaItemService.consultarVendaItem(idProduto, idVenda);
    }

    public List<VendaItemVO> consultarVendaItem(Integer idVenda) {
        return vendaItemService.consultarVendaItem(idVenda);
    }

    public boolean verificarVendaItem(Integer idProduto, Integer idVenda){
        return vendaItemService.verificarVendaItem(idProduto, idVenda);
    }

    public void cadastrarVendaItem (VendaItemVO vendaItemVO) throws SQLException{
        vendaItemService.cadastrarVendaItem(vendaItemVO);
    }

    public void alterarVendaItem (VendaItemVO vendaItemVO) throws SQLException{
        vendaItemService.alterarVendaItem(vendaItemVO);
    }

    public void removerVendaItem(Integer idProduto, Integer idVenda) throws SQLException {
        vendaItemService.removerVendaItem(idProduto, idVenda);
    }

}
