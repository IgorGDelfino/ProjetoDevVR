package gui;

import controller.ProdutoController;

import java.awt.Color;
import java.awt.Component;

import util.CampoUtils;
import util.FormUtils;
import vo.ProdutoVO;
import util.AtalhoTecladoUtils;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConsultaProdutoGUI extends javax.swing.JInternalFrame {

    private ProdutoVO produtoVO = new ProdutoVO();
    private ProdutoController produtoController = new ProdutoController();
    private VendaItemGUI vendaItemGUI = null;
    private ConsultaVendasGUI consultaVendasGUI = null;
    private boolean ConsultaProdutoVendaItemGUI;
    private boolean ConsultaProdutoConsultaVendaGUI;


    public ConsultaProdutoGUI() {
        initComponents();
        atalhoTeclado();
        formatarCampos();
        jScrollPane1.setVisible(false);
    }

    public ConsultaProdutoGUI(VendaItemGUI vendaItemGUI) {
        this.vendaItemGUI = vendaItemGUI;
        this.ConsultaProdutoVendaItemGUI = true;
        initComponents();
        atalhoTeclado();
        formatarCampos();
        jScrollPane1.setVisible(false);
    }

    public ConsultaProdutoGUI(ConsultaVendasGUI consultaVendasGUI) {
        this.consultaVendasGUI = consultaVendasGUI;
        this.ConsultaProdutoConsultaVendaGUI = true;
        initComponents();
        atalhoTeclado();
        formatarCampos();
        jScrollPane1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSair = new javax.swing.JButton();
        jEditar = new javax.swing.JToggleButton();
        jConsultar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jAdicionar = new javax.swing.JToggleButton();
        jExcluir = new javax.swing.JToggleButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/produto.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);

        jSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(666, Short.MAX_VALUE)
                                .addComponent(jSair)
                                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSair)
                                .addGap(2, 2, 2))
        );

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
        jEditar.setBorderPainted(false);
        jEditar.setContentAreaFilled(false);
        jEditar.setFocusPainted(false);
        jEditar.setFocusable(false);
        jEditar.setRequestFocusEnabled(false);
        jEditar.setRolloverEnabled(false);
        jEditar.setVerifyInputWhenFocusTarget(false);
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });

        jConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jConsultar.setToolTipText("Consultar ( F1 )");
        jConsultar.setBorderPainted(false);
        jConsultar.setContentAreaFilled(false);
        jConsultar.setDefaultCapable(false);
        jConsultar.setFocusPainted(false);
        jConsultar.setFocusable(false);
        jConsultar.setRequestFocusEnabled(false);
        jConsultar.setRolloverEnabled(false);
        jConsultar.setVerifyInputWhenFocusTarget(false);
        jConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setText("Descrição");

        jLabel2.setText("Código");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setVerifyInputWhenFocusTarget(false);

        jScrollPane1.setBackground(new java.awt.Color(224, 224, 224));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(16, 20));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        jTable1.setBackground(new java.awt.Color(242, 242, 242));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Código", "Descrição", "Valor Unitário"
                }
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(18);
        jTable1.setSelectionBackground(new java.awt.Color(0, 120, 215));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.setShowHorizontalLines(false);
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Alterando a cor de fundo dependendo se a linha é par ou ímpar
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(236, 237, 240));
                }

                // Caso a linha esteja selecionada, mantém a cor de seleção
                if (isSelected) {
                    c.setBackground(new Color(0, 120, 215));
                }

                return c;
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 368, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        javax.swing.JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setPreferredSize(new java.awt.Dimension(15, 30)); // Define a largura da barra de rolagem vertical

        jScrollPane1.setBounds(50, 50, 300, 300);

        jPanel3.add(jScrollPane1);

        jAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incluir.png"))); // NOI18N
        jAdicionar.setToolTipText("Adicionar - F2");
        jAdicionar.setBorderPainted(false);
        jAdicionar.setContentAreaFilled(false);
        jAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jAdicionar.setFocusPainted(false);
        jAdicionar.setFocusable(false);
        jAdicionar.setRequestFocusEnabled(false);
        jAdicionar.setRolloverEnabled(false);
        jAdicionar.setVerifyInputWhenFocusTarget(false);
        jAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarActionPerformed(evt);
            }
        });

        jExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
        jExcluir.setBorderPainted(false);
        jExcluir.setContentAreaFilled(false);
        jExcluir.setFocusPainted(false);
        jExcluir.setFocusable(false);
        jExcluir.setRequestFocusEnabled(false);
        jExcluir.setRolloverEnabled(false);
        jExcluir.setVerifyInputWhenFocusTarget(false);
        jExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(jExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed
        editar();
    }//GEN-LAST:event_jEditarActionPerformed

    private void jConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_jConsultarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();
            int produtoId = (Integer) jTable1.getValueAt(row, 0);
            if (ConsultaProdutoVendaItemGUI) {
                vendaItemGUI.setCodigoProduto(produtoId);
                this.dispose();
            } else if (ConsultaProdutoConsultaVendaGUI) {
                consultaVendasGUI.setCodigoProduto(produtoId);
                this.dispose();
            } else {
                editar();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_jAdicionarActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_jExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jAdicionar;
    private javax.swing.JButton jConsultar;
    private javax.swing.JToggleButton jEditar;
    private javax.swing.JToggleButton jExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextDescricao;
    // End of variables declaration//GEN-END:variables

    private void adicionar() throws HeadlessException {
        ProdutoGUI form = new ProdutoGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public class ProdutoTableModel extends DefaultTableModel {
        public ProdutoTableModel() {
            super(new Object[][]{},
                    new String[]{"Código", "Descricao", "Valor Unitário"});
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void consultar() throws HeadlessException {
        produtoVO.setDescricao(jTextDescricao.getText().isEmpty() ? null : jTextDescricao.getText());
        produtoVO.setId(jTextCodigo.getText().isEmpty() ? null : Integer.parseInt(jTextCodigo.getText()));
        jScrollPane1.setVisible(true);
        revalidate();
        repaint();
        List<ProdutoVO> consultarProdutos = produtoController.consultarProdutos(produtoVO);
        DefaultTableModel model = new ProdutoTableModel();
        jTable1.setModel(model);
        model.setRowCount(0);
        for (ProdutoVO p : consultarProdutos) {
            model.addRow(new Object[]{p.getId(), p.getDescricao(), p.getValorunitario()});
        }
    }

    public void editar() throws HeadlessException {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            int id = (Integer) jTable1.getValueAt(row, 0);
            ProdutoGUI form = new ProdutoGUI();
            FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
            try {
                form.carregarProduto(id);
            } catch (Exception ex) {
                Logger.getLogger(ConsultaProdutoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void excluir() throws HeadlessException {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            int id = (Integer) jTable1.getValueAt(row, 0);
            try {
                produtoVO = produtoController.consultarProduto(id);
                produtoController.excluirProduto(produtoVO);
            } catch (Exception ex) {
                Logger.getLogger(ConsultaProdutoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void focusNextComponent(ActionEvent actionEvent) {
        AtalhoTecladoUtils.focusNext(jSair, () -> jSairActionPerformed(null),
                null, null,
                null, null);
    }

    private void atalhoTeclado() {
        AtalhoTecladoUtils.funcaoTeclado(this,
                true, this::jConsultarActionPerformed,
                true, this::jSairActionPerformed,
                true, this::focusNextComponent,
                false, null);
        AtalhoTecladoUtils.funcaoEnterNaTabela(jTable1, () -> editar());
    }

    private void formatarCampos() {
        CampoUtils.aceitaInteiro(jTextCodigo);
        CampoUtils.setTamanhoMaximo(jTextCodigo, 6);
    }
}
