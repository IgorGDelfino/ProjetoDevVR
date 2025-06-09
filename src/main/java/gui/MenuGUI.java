package gui;

import javax.swing.*;
import util.FormUtils;

public class MenuGUI extends javax.swing.JFrame {

    public MenuGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("ProjetoDevVR");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopMenu = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastro = new javax.swing.JMenu();
        Produto = new javax.swing.JMenuItem();
        Cliente = new javax.swing.JMenuItem();
        Venda = new javax.swing.JMenu();
        Vendas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("ProjetoDevVR"); // NOI18N

        jDesktopMenu.setBackground(new java.awt.Color(232, 232, 232));

        javax.swing.GroupLayout jDesktopMenuLayout = new javax.swing.GroupLayout(jDesktopMenu);
        jDesktopMenu.setLayout(jDesktopMenuLayout);
        jDesktopMenuLayout.setHorizontalGroup(
            jDesktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jDesktopMenuLayout.setVerticalGroup(
            jDesktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );

        Cadastro.setText("Cadastro");

        Produto.setText("Produto");
        Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutoActionPerformed(evt);
            }
        });
        Cadastro.add(Produto);

        Cliente.setText("Cliente");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        Cadastro.add(Cliente);

        jMenuBar1.add(Cadastro);

        Venda.setText("Venda");

        Vendas.setText("Vendas");
        Vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendasActionPerformed(evt);
            }
        });
        Venda.add(Vendas);

        jMenuBar1.add(Venda);

        setJMenuBar(jMenuBar1);

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

    private void VendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendasActionPerformed
        ConsultaVendasGUI form = new ConsultaVendasGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }//GEN-LAST:event_VendasActionPerformed

    private void ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutoActionPerformed
        ConsultaProdutoGUI form = new ConsultaProdutoGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }//GEN-LAST:event_ProdutoActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        ConsultaClienteGUI form = new ConsultaClienteGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }//GEN-LAST:event_ClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cadastro;
    private javax.swing.JMenuItem Cliente;
    private javax.swing.JMenuItem Produto;
    private javax.swing.JMenu Venda;
    private javax.swing.JMenuItem Vendas;
    public static javax.swing.JDesktopPane jDesktopMenu;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
