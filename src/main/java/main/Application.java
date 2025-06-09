package main;

import controller.AtualizarTabelaController;
import gui.MenuGUI;
import java.util.Locale;
import db.Conexao;
import gui.CadastroBaseGUI;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Application {

    public static void main(String args[]) {
        Locale.setDefault(new Locale("pt", "BR"));
        String caminhoArquivo = "C:\\ProjetoDevVR\\config.properties";
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            try {
                AtualizarTabelaController controller = new AtualizarTabelaController();
                controller.atualizarTabelas();
                Conexao conexao = new Conexao();
                conexao.getConnection();
                MenuGUI menu = new MenuGUI();
                menu.setVisible(true);
            } catch (SQLException e) {
                if (e.getMessage().contains("O banco de dados não existe")) {
                    JOptionPane.showMessageDialog(null,
                            "Erro: O banco de dados não existe.",
                            "Erro de Conexão",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Erro de Conexão: " + e.getMessage(),
                            "Erro de Conexão",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro inesperado: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            CadastroBaseGUI cadastroBase = new CadastroBaseGUI();
            cadastroBase.setVisible(true);
        }
    }
}
