package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    public Connection getConnection() throws SQLException {
        Properties propriedades = new Properties();
        String caminhoArquivo = "C:\\ProjetoDevVR\\config.properties";
        try (FileInputStream fis = new FileInputStream(caminhoArquivo)) {
            propriedades.load(fis);
        } catch (IOException e) {
        }
        String servidor = propriedades.getProperty("servidor");
        String porta = propriedades.getProperty("porta");
        String usuario = propriedades.getProperty("usuario");
        String senha = propriedades.getProperty("senha");
        String nomeBase = propriedades.getProperty("nomebase");
        String url = "jdbc:postgresql://" + servidor + ":" + porta + "/" + nomeBase;
        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            return conn;
        } catch (SQLException e) {
            if (e.getMessage().contains("database")) {
                throw new SQLException("O banco de dados não existe ou não foi encontrado.");
            } else {
                throw e;
            }
        }
    }
}
