package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CriarBaseDAO {

    public void criarBancoDeDados(String servidor, String usuario, String senha, String porta, String nomeBase) throws SQLException {
        Connection conexao = null;
        Statement stmt = null;
        try {
            String url = "jdbc:postgresql://" + servidor + ":" + porta + "/postgres"; 
            conexao = DriverManager.getConnection(url, usuario, senha);
            stmt = conexao.createStatement();
            String sql = "CREATE DATABASE \"" + nomeBase + "\"";
            try {
                stmt.executeUpdate(sql);
                System.out.println("Banco de dados " + nomeBase + " criado com sucesso!");
            } catch (SQLException e) {
                if (e.getMessage().contains("already exists")) {
                    System.out.println("O banco de dados " + nomeBase + " já existe.");
                } else {
                    throw e;
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao criar o banco de dados: " + ex.getMessage(), ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    public void criarArquivoProperties(String servidor, String usuario, String porta, String nomeBase) {
        String caminhoPasta = "C:\\ProjetoDevVR";
        String caminhoArquivo = caminhoPasta + "\\config.properties";
        File pasta = new File(caminhoPasta);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
        Properties propriedades = new Properties();
        propriedades.setProperty("servidor", servidor);
        propriedades.setProperty("usuario", usuario);
        propriedades.setProperty("porta", porta);
        propriedades.setProperty("nomebase", nomeBase);
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            return;
        }
        try (FileOutputStream fos = new FileOutputStream(caminhoArquivo)) {
            propriedades.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
