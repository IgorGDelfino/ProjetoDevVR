package gui;

import controller.ProdutoController;
import util.CampoUtils;
import util.FormUtils;
import vo.ProdutoVO;
import util.AtalhoTecladoUtils;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ProdutoGUI extends javax.swing.JInternalFrame {

    private boolean isSair = false;
    private boolean isAdicionar;
    private ProdutoVO produtoVO = new ProdutoVO();
    private ProdutoController produtoController = new ProdutoController();
    private String descricaoOriginal;
    private String situacaoOriginal;


    public ProdutoGUI() {
        initComponents();
        atalhoTeclado();
        formatarCampos();
    }

    public void carregarProduto(Integer id) throws Exception {
        ProdutoVO produtoVO = produtoController.consultarProduto(id);
        jLabelID.setText(String.valueOf(produtoVO.getId()));
        jDescricao.setText(produtoVO.getDescricao());
        jValorUnitario.setText(String.valueOf(produtoVO.getValorunitario()).replace(".",","));
        jSituacao.setSelectedItem(produtoVO.getSituacaocadastro() == 1 ? "ATIVO" : "EXCLUIDO");
        descricaoOriginal = jDescricao.getText();
        situacaoOriginal = jSituacao.getSelectedItem().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTelaProduto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSituacao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jValorUnitario = new javax.swing.JFormattedTextField();
        jSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSalvar2 = new javax.swing.JButton();
        jSair = new javax.swing.JButton();
        jAdicionar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/produto.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel3.setText("Descrição");

        jLabel1.setText("Código Item");

        jLabelID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel2.setText("Valor Unitário");

        jSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "EXCLUIDO" }));
        jSituacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setText("Situação");

        jValorUnitario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jValorUnitario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
        jSalvar.setToolTipText("Salvar ( F3 )");
        jSalvar.setBorderPainted(false);
        jSalvar.setContentAreaFilled(false);
        jSalvar.setFocusPainted(false);
        jSalvar.setFocusable(false);
        jSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jSalvar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
        jSalvar2.setText("Salvar");
        jSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvar2ActionPerformed(evt);
            }
        });

        jSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSalvar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSair)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalvar2)
                    .addComponent(jSair))
                .addGap(2, 2, 2))
        );

        jAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incluir.png"))); // NOI18N
        jAdicionar.setContentAreaFilled(false);
        jAdicionar.setFocusPainted(false);
        jAdicionar.setFocusTraversalPolicyProvider(true);
        jAdicionar.setFocusable(false);
        jAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jTelaProdutoLayout = new javax.swing.GroupLayout(jTelaProduto);
        jTelaProduto.setLayout(jTelaProdutoLayout);
        jTelaProdutoLayout.setHorizontalGroup(
            jTelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTelaProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jTelaProdutoLayout.createSequentialGroup()
                        .addComponent(jSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jTelaProdutoLayout.setVerticalGroup(
            jTelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTelaProdutoLayout.createSequentialGroup()
                .addGroup(jTelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSalvar)
                    .addComponent(jAdicionar))
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTelaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTelaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jSalvarActionPerformed

    private void jSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvar2ActionPerformed
        salvar();
    }//GEN-LAST:event_jSalvar2ActionPerformed

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        sair();
    }//GEN-LAST:event_jSairActionPerformed

    private void jAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_jAdicionarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        sair();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdicionar;
    private javax.swing.JTextField jDescricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jSair;
    private javax.swing.JButton jSalvar;
    private javax.swing.JButton jSalvar2;
    private javax.swing.JComboBox<String> jSituacao;
    private javax.swing.JPanel jTelaProduto;
    private javax.swing.JFormattedTextField jValorUnitario;
    // End of variables declaration//GEN-END:variables

    private void salvar() throws HeadlessException {
        if (jDescricao.getText().isEmpty() || jValorUnitario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
            isAdicionar = false;
            isSair = false;
            return;
        }

        try {
            produtoVO.setDescricao(jDescricao.getText());
            produtoVO.setSituacaocadastro("ATIVO".equals(jSituacao.getSelectedItem()) ? 1 : 0);
            String valorFormatado = jValorUnitario.getText().replace(",", ".");
            produtoVO.setValorunitario(Double.parseDouble(valorFormatado));
            boolean isNovo = jLabelID.getText().isEmpty();
            if (!isNovo) {
                produtoVO.setId(Integer.parseInt(jLabelID.getText()));
            }
            int idGerado = produtoController.salvarProduto(produtoVO);
            produtoVO.setId(idGerado);
            jLabelID.setText(String.valueOf(idGerado));
            String mensagem = isNovo ? "Cadastro realizado com sucesso!" : "Alterado com sucesso!";
            JOptionPane.showMessageDialog(rootPane, mensagem);
            descricaoOriginal = produtoVO.getDescricao();
            situacaoOriginal = jSituacao.getSelectedItem().toString();
            if (isSair) dispose();
            if (isAdicionar) limpar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Valor unitário inválido.");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar o produto: " + ex.getMessage());
        }
    }

    private void limpar() {
        dispose();
        ProdutoGUI form = new ProdutoGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    private void sair() throws HeadlessException {
        isSair = true;
        boolean valoresNaoAlterados = Objects.equals(descricaoOriginal, jDescricao.getText()) && Objects.equals(situacaoOriginal, jSituacao.getSelectedItem().toString());
        if (jLabelID.getText().isEmpty() && jDescricao.getText().isEmpty()) {
            dispose();
        } else if (valoresNaoAlterados) {
            dispose();
        } else if (!jDescricao.getText().isEmpty() && jLabelID.getText().isEmpty()) {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja salvar informações?", "Cadastro de Produto", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                salvar();
            } else if (resposta == JOptionPane.NO_OPTION) {
                dispose();
            }
        } else if (!jLabelID.getText()
                .isEmpty()) {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja salvar informações?", "Cadastro de Produto", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                salvar();
            } else if (resposta == JOptionPane.NO_OPTION) {
                dispose();
            }
        }
        isSair = false;
    }

    private void adicionar() throws HeadlessException {
        isAdicionar = true;
        boolean valoresNaoAlterados = Objects.equals(descricaoOriginal, jDescricao.getText()) && Objects.equals(situacaoOriginal, jSituacao.getSelectedItem().toString());
        if (!valoresNaoAlterados) {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja salvar informações?", "Cadastro de Produto", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                salvar();
            } else if (resposta == JOptionPane.NO_OPTION) {
                limpar();
            }

        } else {
            limpar();
        }
        isAdicionar = false;
    }


    private void focusNextComponent(ActionEvent actionEvent) {
        AtalhoTecladoUtils.focusNext(jSair, () -> jSairActionPerformed(null),
                jSalvar2, () -> jSalvar2ActionPerformed(null),
                null , null);
    }

    private void atalhoTeclado() {
        AtalhoTecladoUtils.funcaoTeclado(this,
                false, null,
                true, this::jSairActionPerformed,
                true, this::focusNextComponent,
                true, this::jSalvarActionPerformed);
    }

    private void formatarCampos(){
        CampoUtils.aceitaDecimal(jValorUnitario);
        CampoUtils.setTamanhoMaximo(jValorUnitario,8);
    }
}

