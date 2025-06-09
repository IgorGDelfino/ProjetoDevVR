package controller;

import java.sql.SQLException;
import java.util.List;
import vo.ClienteVO;
import services.ClienteService;
import vo.ProdutoVO;

public class ClienteController {

    ClienteService clienteService = new ClienteService();

    public int salvarCliente(ClienteVO cliente) throws SQLException, ClassNotFoundException {
        return clienteService.salvarCliente(cliente);
    }

    public void excluirCliente (ClienteVO clienteVO) throws SQLException, ClassNotFoundException{
        clienteService.excluirCliente(clienteVO);
    }

    public List<ClienteVO> consultarClientes(ClienteVO clienteVO) {
        return clienteService.consultarClientes(clienteVO);
    }

    public ClienteVO consultarCliente(Integer idCliente) {
        return clienteService.consultarCliente(idCliente);
    }

}
