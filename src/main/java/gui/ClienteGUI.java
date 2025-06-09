package gui;

import controller.ClienteController;
import util.CampoUtils;
import vo.ClienteVO;
import util.AtalhoTecladoUtils;
import util.FormUtils;
import vo.TabelasVO;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

public class ClienteGUI extends javax.swing.JInternalFrame {

    private boolean isSair;
    private boolean isAdicionar;
    private String nomeOriginal;
    private String situacaoOriginal;
    private ClienteVO clienteVO = new ClienteVO();
    private TabelasVO tabelasVO = new TabelasVO();
    private ClienteController clienteController = new ClienteController();


    public ClienteGUI() {
        initComponents();
        formatarCampos();
        atalhoTeclado();
    }

    public void carregarCliente(Integer pId) throws Exception {
        clienteVO = clienteController.consultarCliente(pId);
        jLabelID.setText(String.valueOf(clienteVO.getId()));
        jNome.setText(clienteVO.getNome());
        jSituacao.setSelectedItem(clienteVO.getSituacaocadastro() == 1 ? "ATIVO" : "EXCLUIDO");
        jDiaFechamento.setText(String.valueOf(clienteVO.getDiafechamento()));
        jLimiteCompra.setText(String.valueOf(clienteVO.getLimitecompra()).replace(".", ","));
        nomeOriginal = jNome.getText();
        situacaoOriginal = jSituacao.getSelectedItem().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTelaProduto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jSituacao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDiaFechamento = new javax.swing.JTextField();
        jLimiteCompra = new javax.swing.JFormattedTextField();
        jSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSalvar2 = new javax.swing.JButton();
        jSair = new javax.swing.JButton();
        jAdicionar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Cliente");
        setDoubleBuffered(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/clientePreferencial.png"))); // NOI18N
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

        jNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel4.setText("Limite de Compra");

        jLabel3.setText("Nome");

        jLabel1.setText("Código Cliente");

        jLabelID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"ATIVO", "EXCLUIDO"}));
        jSituacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setText("Situação");

        jLabel2.setText("Dia de Fechamento");

        jDiaFechamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLimiteCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLimiteCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                        .addComponent(jLimiteCompra))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jDiaFechamento))))
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(1, 1, 1)
                                                .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jDiaFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLimiteCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(147, Short.MAX_VALUE))
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
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jTelaProdutoLayout.createSequentialGroup()
                                                .addComponent(jSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jTelaProdutoLayout.setVerticalGroup(
                jTelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTelaProdutoLayout.createSequentialGroup()
                                .addGroup(jTelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSalvar)
                                        .addComponent(jAdicionar))
                                .addGap(2, 2, 2)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
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
    private javax.swing.JTextField jDiaFechamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JFormattedTextField jLimiteCompra;
    private javax.swing.JTextField jNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jSair;
    private javax.swing.JButton jSalvar;
    private javax.swing.JButton jSalvar2;
    private javax.swing.JComboBox<String> jSituacao;
    private javax.swing.JPanel jTelaProduto;
    // End of variables declaration//GEN-END:variables

    private void salvar() throws HeadlessException {
        if (jNome.getText().isEmpty() || jLimiteCompra.getText().isEmpty() || jDiaFechamento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
            isAdicionar = false;
            isSair = false;
            return;
        }
        try {
            clienteVO.setNome(jNome.getText());
            clienteVO.setSituacaocadastro("ATIVO".equals(jSituacao.getSelectedItem()) ? 1 : 0);
            clienteVO.setLimitecompra(Double.parseDouble(jLimiteCompra.getText().replace(",", ".")));
            int diaFechamento = Integer.parseInt(jDiaFechamento.getText());
            if (diaFechamento < 1 || diaFechamento > 31) {
                JOptionPane.showMessageDialog(rootPane, "Dia de fechamento inválido");
                return;
            }
            clienteVO.setDiafechamento(diaFechamento);
            boolean isNovo = jLabelID.getText().isEmpty();
            if (!isNovo) {
                clienteVO.setId(Integer.parseInt(jLabelID.getText()));
            }
            tabelasVO.setTabela("cliente");
            Integer id = clienteController.salvarCliente(clienteVO);
            if (id != null) {
                clienteVO.setId(id);
                jLabelID.setText(String.valueOf(id));
            }
            String mensagem = isNovo ? "Cadastro realizado com sucesso!" : "Alterado com sucesso!";
            JOptionPane.showMessageDialog(rootPane, mensagem);
            nomeOriginal = clienteVO.getNome();
            situacaoOriginal = jSituacao.getSelectedItem().toString();
            if (isSair) {
                dispose();
            }
            if (isAdicionar) {
                limpar();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Número inválido em algum campo.");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void sair() throws HeadlessException {
        isSair = true;
        boolean valoresNaoAlterados = Objects.equals(nomeOriginal, jNome.getText()) && Objects.equals(situacaoOriginal, jSituacao.getSelectedItem().toString());
        if (jNome.getText().isEmpty() && jLabelID.getText().isEmpty()) {
            dispose();
        } else if (valoresNaoAlterados) {
            dispose();
        } else if (!jNome.getText().isEmpty() && jLabelID.getText().isEmpty()) {
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
        boolean valoresNaoAlterados = Objects.equals(nomeOriginal, jNome.getText()) && Objects.equals(situacaoOriginal, jSituacao.getSelectedItem().toString());
        if (!valoresNaoAlterados) {
            if (!jNome.getText().isEmpty()) {
                int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja salvar informações?", "Cadastro de Produto", JOptionPane.YES_NO_CANCEL_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    salvar();
                } else if (resposta == JOptionPane.NO_OPTION) {
                    limpar();
                }
            }
        } else {
            limpar();
        }
        isAdicionar = false;
    }

    private void limpar() {
        dispose();
        ClienteGUI form = new ClienteGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    private void focusNextComponent(ActionEvent actionEvent) {
        AtalhoTecladoUtils.focusNext(jSair, () -> jSairActionPerformed(null),
                jSalvar2, () -> jSalvar2ActionPerformed(null),
                null , null);
    }

    private void atalhoTeclado() {
        setBounds(500, 150, 536, 352);
        AtalhoTecladoUtils.funcaoTeclado(this,
                false, null,
                true, this::jSairActionPerformed,
                true, this::focusNextComponent,
                true, this::jSalvarActionPerformed);
    }

    private void formatarCampos(){
        CampoUtils.aceitaInteiro(jDiaFechamento);
        CampoUtils.aceitaDecimal(jLimiteCompra);
        CampoUtils.setTamanhoMaximo(jDiaFechamento, 2);
        CampoUtils.setTamanhoMaximo(jLimiteCompra, 8);
    }
}
