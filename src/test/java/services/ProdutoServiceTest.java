package services;

import dao.ProdutoDAO;
import vo.ProdutoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {

    @Mock
    private ProdutoDAO produtoDAO;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvarNovoProduto() throws SQLException {
        ProdutoVO novoProduto = new ProdutoVO();
        novoProduto.setId(-1);
        when(produtoDAO.cadastrarProduto(any(ProdutoVO.class))).thenReturn(100);
        int result = produtoService.salvarProduto(novoProduto);
        assertEquals(100, result);
        verify(produtoDAO, times(1)).cadastrarProduto(novoProduto);
    }

    @Test
    void testAtualizarProduto() throws SQLException {
        ProdutoVO produtoExistente = new ProdutoVO();
        produtoExistente.setId(10);
        doNothing().when(produtoDAO).atualizarProduto(any(ProdutoVO.class));
        int result = produtoService.salvarProduto(produtoExistente);
        assertEquals(10, result);
        verify(produtoDAO, times(1)).atualizarProduto(produtoExistente);
    }

    @Test
    void testConsultarProdutos() {
        ProdutoVO filtro = new ProdutoVO();
        List<ProdutoVO> mockLista = new ArrayList<>();
        mockLista.add(new ProdutoVO());
        when(produtoDAO.consultarProdutos(any(ProdutoVO.class))).thenReturn(mockLista);
        List<ProdutoVO> resultado = produtoService.consultarProdutos(filtro);
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(produtoDAO, times(1)).consultarProdutos(filtro);
    }

    @Test
    void testConsultarProdutoPorId() throws Exception {
        ProdutoVO mockProduto = new ProdutoVO();
        mockProduto.setId(5);
        when(produtoDAO.consultarProduto(5)).thenReturn(mockProduto);
        ProdutoVO result = produtoService.consultarProduto(5);
        assertNotNull(result);
        assertEquals(5, result.getId());
        verify(produtoDAO, times(1)).consultarProduto(5);
    }

    @Test
    void testConsultarProdutoPorIdComErro() throws Exception {
        when(produtoDAO.consultarProduto(anyInt())).thenThrow(new RuntimeException("DB error"));
        ProdutoVO result = produtoService.consultarProduto(999);
        assertNull(result);
        verify(produtoDAO, times(1)).consultarProduto(999);
    }
}
