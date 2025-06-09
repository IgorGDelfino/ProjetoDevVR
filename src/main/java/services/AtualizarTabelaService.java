package services;

import dao.AtualizarTabelasDAO;

import java.sql.SQLException;

public class AtualizarTabelaService {

    AtualizarTabelasDAO atualizarTabelasDAO = new AtualizarTabelasDAO();

    public void atualizarTabelas() throws SQLException {
        atualizarTabelasDAO.AtualizarTabelas();
    }
}
