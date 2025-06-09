package controller;

import services.VendaService;
import vo.VendaItemVO;
import vo.VendaVO;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class VendaController {

    VendaService vendaService = new VendaService();

    public VendaVO consultarVenda(Integer idVenda) {
        return vendaService.consultarVenda(idVenda);
    }

    public List<?> consultarVendasPorTipo(String tipo, VendaVO filtroVenda, VendaItemVO filtroProduto) {
        switch (tipo) {
            case "VENDA":
                return vendaService.consultarVendas(filtroVenda, filtroProduto);
            case "PRODUTO":
                return vendaService.consultarVendasProduto(filtroProduto, filtroVenda);
            case "CLIENTE":
                return vendaService.consultarVendasCliente(filtroVenda);
            default:
                return Collections.emptyList();
        }
    }

    public void salvar(VendaVO vendaVO, List<VendaItemVO> itens, List<VendaItemVO> itensRemover) throws SQLException {
        vendaService.salvar(vendaVO, itens, itensRemover);
    }
}
