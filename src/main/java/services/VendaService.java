package services;

import dao.ClienteDAO;
import dao.VendaDAO;
import dao.VendaItemDAO;
import vo.ClienteVO;
import vo.VendaItemVO;
import vo.VendaVO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class VendaService {

    VendaDAO vendaDAO = new VendaDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    VendaItemDAO vendaItemDAO = new VendaItemDAO();

    public VendaVO consultarVenda(Integer idVenda) {
        try {
            return vendaDAO.consultarVenda(idVenda);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VendaVO> consultarVendas(VendaVO filtroVenda, VendaItemVO filtroProduto) {
        return vendaDAO.consultarVendas(filtroVenda, filtroProduto);
    }

    public List<VendaVO> consultarVendasCliente(VendaVO filtro) {
        return vendaDAO.consultarVendasCliente(filtro);
    }

    public List<VendaItemVO> consultarVendasProduto(VendaItemVO filtro, VendaVO filtroVenda) {
        return vendaDAO.consultarVendasProduto(filtro, filtroVenda);
    }

    public void salvar(VendaVO vendaVO, List<VendaItemVO> itens, List<VendaItemVO> itensRemover) throws SQLException {
        String mensagem = validarLimiteCliente(vendaVO);
        if (mensagem != null) {
            throw new RuntimeException(mensagem);
        }
        if (vendaVO.getId() > 0) {
            vendaDAO.alterarVenda(vendaVO);
            for (VendaItemVO itemRemovido : itensRemover) {
                vendaItemDAO.removerVendaItem(itemRemovido.getId_produto(), vendaVO.getId());
            }
            for (VendaItemVO item : itens) {
                item.setId_venda(vendaVO.getId());
                if (vendaItemDAO.verificarVendaItem(item.getId_produto(), vendaVO.getId())) {
                    vendaItemDAO.alterarVendaItem(item);
                } else {
                    vendaItemDAO.cadastrarVendaItem(item);
                }
            }
        } else {
            int idVenda = vendaDAO.cadastrarVenda(vendaVO);
            vendaVO.setId(idVenda);
            for (VendaItemVO item : itens) {
                item.setId_venda(idVenda);
                vendaItemDAO.cadastrarVendaItem(item);
            }
        }
    }

    public String validarLimiteCliente(VendaVO vendaVO) {
        try {
            ClienteVO clienteVO = clienteDAO.consultarCliente(vendaVO.getId_cliente());
            LocalDate inicioPeriodo, fimPeriodo;
            if (vendaVO.getData().getDayOfMonth() <= clienteVO.getDiafechamento()) {
                fimPeriodo = LocalDate.of(vendaVO.getData().getYear(), vendaVO.getData().getMonth(), clienteVO.getDiafechamento());
                inicioPeriodo = fimPeriodo.minusMonths(1).plusDays(1);
            } else {
                inicioPeriodo = LocalDate.of(vendaVO.getData().getYear(), vendaVO.getData().getMonth(), clienteVO.getDiafechamento()).plusDays(1);
                fimPeriodo = inicioPeriodo.plusMonths(1).minusDays(1);
            }
            double valorVendaPeriodo = vendaDAO.valorVendaPeriodo(clienteVO.getId(), inicioPeriodo, fimPeriodo);
            double valorDpsEdicao = vendaVO.getValor();
            LocalDate dataDpsEdicao = vendaVO.getData();
            double totalComVendaAtual = 0;
            if (vendaVO.getId() != 0) {
                VendaVO vendaAntesEdicao = vendaDAO.consultarVenda(vendaVO.getId());
                if (vendaAntesEdicao != null) {
                    if (vendaAntesEdicao.getData().equals(dataDpsEdicao)) {
                        totalComVendaAtual = valorVendaPeriodo + valorDpsEdicao - vendaAntesEdicao.getValor();
                    } else {
                        totalComVendaAtual = valorVendaPeriodo + valorDpsEdicao ;
                    }
                    double limiteDisponivel = clienteVO.getLimitecompra() - valorVendaPeriodo;
                    if (totalComVendaAtual > clienteVO.getLimitecompra()) {
                        return "O valor R$ " + String.format("%.2f", vendaVO.getValor()) + " da venda ultrapassa o limite do cliente " + clienteVO.getNome() + ", limite disponivel R$ " + String.format("%.2f", limiteDisponivel) + " ,data de fechamento: dia " + clienteVO.getDiafechamento();
                    }
                }
            } else {
                totalComVendaAtual = valorVendaPeriodo + valorDpsEdicao;
                double limiteDisponivel = clienteVO.getLimitecompra() - valorVendaPeriodo;
                if (totalComVendaAtual > clienteVO.getLimitecompra()) {
                    return "O valor R$ " + String.format("%.2f", vendaVO.getValor()) + " da venda ultrapassa o limite do cliente " + clienteVO.getNome() + ", limite disponivel R$ " + String.format("%.2f", limiteDisponivel) + " ,data de fechamento: dia " + clienteVO.getDiafechamento();
                }
            }
        } catch (Exception e) {
            return "Erro ao validar limite: " + e.getMessage();
        }
        return null;
    }
}
