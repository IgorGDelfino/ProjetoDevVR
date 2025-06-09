package services;

import dao.CriarBaseDAO;

import java.sql.SQLException;

public class CriarBaseService {

    CriarBaseDAO criarBaseDAO = new CriarBaseDAO();

    public void criarBase(String servidor, String usuario, String senha, String porta, String nomeBase) throws SQLException {
        criarBaseDAO.criarArquivoProperties(servidor, usuario, porta, nomeBase);
        criarBaseDAO.criarBancoDeDados(servidor, usuario, senha, porta, nomeBase);
    }
}
