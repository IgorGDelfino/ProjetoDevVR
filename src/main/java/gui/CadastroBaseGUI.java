package gui;

import controller.CriarBaseController;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import static main.Application.main;

public class CadastroBaseGUI extends javax.swing.JFrame {

    public CadastroBaseGUI() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopMenu = new javax.swing.JDesktopPane();
        Usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Senha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Servidor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Porta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NomeBase = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jDesktopMenu.setBackground(new java.awt.Color(232, 232, 232));

        jLabel1.setText("Database Usuario");

        jLabel2.setText("Database Senha");

        jLabel3.setText("Database IP");

        jLabel4.setText("Database Porta");

        jLabel5.setText("New Database Nome");

        jButton1.setText("Criar Base");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopMenu.setLayer(Usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(Senha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(Servidor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(Porta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(NomeBase, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopMenu.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopMenuLayout = new javax.swing.GroupLayout(jDesktopMenu);
        jDesktopMenu.setLayout(jDesktopMenuLayout);
        jDesktopMenuLayout.setHorizontalGroup(
            jDesktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopMenuLayout.createSequentialGroup()
                        .addGroup(jDesktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Porta)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NomeBase)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(Servidor))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Senha)
                    .addComponent(Usuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jDesktopMenuLayout.setVerticalGroup(
            jDesktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(Servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(Porta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(NomeBase, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopMenu)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        criar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField NomeBase;
    private static javax.swing.JTextField Porta;
    private static javax.swing.JTextField Senha;
    private static javax.swing.JTextField Servidor;
    private static javax.swing.JTextField Usuario;
    private javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    private void criar() {
        if (Servidor.getText().isEmpty() || Usuario.getText().isEmpty() || Senha.getText().isEmpty()
                || Porta.getText().isEmpty() || NomeBase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CriarBaseController controller = new CriarBaseController();
        try {
            controller.criarBase(
                    Servidor.getText(),
                    Usuario.getText(),
                    Senha.getText(),
                    Porta.getText(),
                    NomeBase.getText()
            );
            JOptionPane.showMessageDialog(null, "Banco e configuração criados com sucesso!");
            reiniciarAplicacao();
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private static void reiniciarAplicacao() {
        try {
            Thread.sleep(50);
            main(new String[]{});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
