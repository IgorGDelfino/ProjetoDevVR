package controller;

import services.AtualizarTabelaService;

import java.sql.SQLException;

public class AtualizarTabelaController {

    AtualizarTabelaService atualizarTabelaService = new AtualizarTabelaService();

    public void atualizarTabelas() throws SQLException {
        atualizarTabelaService.atualizarTabelas();
    }
}
