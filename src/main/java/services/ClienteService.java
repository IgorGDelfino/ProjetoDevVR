package services;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;
import vo.ClienteVO;
import vo.ProdutoVO;

import javax.swing.*;

public class ClienteService {

    ClienteDAO clienteDAO = new ClienteDAO();

    public int salvarCliente(ClienteVO cliente) throws SQLException {
        if (cliente.getId() == -1) {
            return clienteDAO.cadastrarCliente(cliente);
        } else {
            clienteDAO.atualizarCliente(cliente);
            return cliente.getId();
        }
    }

    public void excluirCliente(ClienteVO clienteVO) throws SQLException {
        if (clienteVO.getSituacaocadastro() == 1) {
            clienteDAO.excluirCliente(clienteVO);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "O cliente já está excluído.");
        }
    }

    public List<ClienteVO> consultarClientes(ClienteVO clienteVO) {
        return clienteDAO.consultarClientes(clienteVO);
    }

    public ClienteVO consultarCliente(Integer idCliente) {
        try {
            return clienteDAO.consultarCliente(idCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
