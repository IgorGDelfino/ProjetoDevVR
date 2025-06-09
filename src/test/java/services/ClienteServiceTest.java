package services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.ClienteDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import vo.ClienteVO;

public class ClienteServiceTest {

    @Mock
    private ClienteDAO pClienteDAO;

    @InjectMocks
    private ClienteService pService;

    @BeforeEach
    void setUpMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarCliente() throws Exception {
        when(pClienteDAO.cadastrarCliente(any(ClienteVO.class))).thenReturn(1);
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(-1);
        int id = pService.salvarCliente(clienteVO);
        assertEquals(1, id);
        verify(pClienteDAO, times(1)).cadastrarCliente(clienteVO);
    }

    @Test
    public void testAtualizarCliente() throws Exception {
        doNothing().when(pClienteDAO).atualizarCliente(any(ClienteVO.class));
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(1);
        int id = pService.salvarCliente(clienteVO);
        assertEquals(1, id);
        verify(pClienteDAO, times(1)).atualizarCliente(clienteVO);
    }

    @Test
    public void testListaCliente() throws SQLException {
        List<ClienteVO> clientesMock = new ArrayList<>();
        clientesMock.add(new ClienteVO());
        when(pClienteDAO.consultarClientes(any(ClienteVO.class))).thenReturn(clientesMock);
        ClienteVO filtro = new ClienteVO();
        List<ClienteVO> resultado = pService.consultarClientes(filtro);
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        verify(pClienteDAO, times(1)).consultarClientes(filtro);
    }
}