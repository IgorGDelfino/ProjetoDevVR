package services;

import dao.VendaItemDAO;
import vo.VendaItemVO;
import java.sql.SQLException;
import java.util.List;

public class VendaItemService {

    VendaItemDAO vendaItemDAO = new VendaItemDAO();

    public VendaItemVO consultarVendaItem(Integer idProduto, Integer idVenda) {
        try {
            return vendaItemDAO.consultarVendaItem(idProduto, idVenda);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VendaItemVO> consultarVendaItem(Integer idVenda) {
        return vendaItemDAO.consultarVendaItem(idVenda);
    }

    public boolean verificarVendaItem(Integer idProduto, Integer idVenda) {
        try {
            return vendaItemDAO.verificarVendaItem(idProduto, idVenda);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void cadastrarVendaItem(VendaItemVO vendaItemVO) throws SQLException {
        vendaItemDAO.cadastrarVendaItem(vendaItemVO);
    }

    public void alterarVendaItem(VendaItemVO vendaItemVO) throws SQLException {
        vendaItemDAO.alterarVendaItem(vendaItemVO);
    }

    public void removerVendaItem(Integer idProduto, Integer idVenda) throws SQLException {
        vendaItemDAO.removerVendaItem(idProduto, idVenda);
    }
}
