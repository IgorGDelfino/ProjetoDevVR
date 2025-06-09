package controller;

import services.CriarBaseService;

import java.sql.SQLException;

public class CriarBaseController {

    CriarBaseService criarBaseService = new CriarBaseService();

    public void criarBase(String servidor, String usuario, String senha, String porta, String nomeBase) throws SQLException {
        criarBaseService.criarBase(servidor, usuario, senha, porta, nomeBase);
    }
}
