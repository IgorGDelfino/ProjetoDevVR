package gui;

import controller.ProdutoController;
import controller.VendaItemController;
import util.AtalhoTecladoUtils;
import util.CampoUtils;
import util.FormUtils;
import vo.ProdutoVO;
import vo.VendaItemVO;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class VendaItemGUI extends javax.swing.JInternalFrame {

    VendaGUI parentFrame;
    public boolean isAtualizacao = false;
    ProdutoVO produtoVO = new ProdutoVO();
    ProdutoController produtoController = new ProdutoController();
    VendaItemVO vendaItemVO = new VendaItemVO();
    VendaItemController vendaItemController = new VendaItemController();

    public VendaItemGUI(VendaGUI parentFrame) {
        initComponents();
        formatarCampos();
        atalhoTeclado();
        this.parentFrame = parentFrame;
    }

    public void carregarVendaItem(Integer idProduto, Integer idVenda) throws Exception {
        vendaItemVO = vendaItemController.consultarVendaItem(idProduto, idVenda);
        jCodigoProduto.setText(String.valueOf(vendaItemVO.getId_produto()));
        jProduto.setText(vendaItemVO.getDescricao());
        jQuantidade.setText(String.valueOf(vendaItemVO.getQuantidade()));
        jValorTotal.setText(String.valueOf(vendaItemVO.getValortotal()));
        jValorUnitario.setText(String.valueOf(vendaItemVO.getValorunitario()));
    }

    public void carregarVendaItem(VendaItemVO item) {
        this.vendaItemVO = item;
        jCodigoProduto.setText(String.valueOf(item.getId_produto()));
        jProduto.setText(item.getDescricao());
        jQuantidade.setText(String.valueOf(item.getQuantidade()));
        jValorTotal.setText(String.valueOf(item.getValortotal()));
        jValorUnitario.setText(String.valueOf(item.getValorunitario()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jQuantidade = new javax.swing.JTextField();
        jCodigoProduto = new javax.swing.JTextField();
        jValorUnitario = new javax.swing.JTextField();
        jValorTotal = new javax.swing.JTextField();
        jConsultarProduto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jProduto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSalvar2 = new javax.swing.JButton();
        jSair = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Venda Item");
        setDoubleBuffered(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/produto.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jQuantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jQuantidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jQuantidadeFocusLost(evt);
            }
        });

        jCodigoProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jCodigoProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCodigoProdutoFocusLost(evt);
            }
        });

        jValorUnitario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jValorUnitario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jValorUnitarioFocusLost(evt);
            }
        });

        jValorTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jValorTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotal.setEnabled(false);

        jConsultarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jConsultarProduto.setFocusPainted(false);
        jConsultarProduto.setFocusable(false);
        jConsultarProduto.setRequestFocusEnabled(false);
        jConsultarProduto.setRolloverEnabled(false);
        jConsultarProduto.setVerifyInputWhenFocusTarget(false);
        jConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarProdutoActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        jLabel1.setText("Produto");

        jProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel2.setText("Valor Unitário");

        jLabel3.setText("ValorTotal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(151, 151, 151))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(2, 2, 2)
                                                                .addComponent(jConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 24, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jConsultarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(28, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSalvar)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        setBounds(614, 200, 341, 220);
    }// </editor-fold>//GEN-END:initComponents

    // Salvar apertando o botão
    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jSalvarActionPerformed

    private void jSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvar2ActionPerformed
        salvar();
    }//GEN-LAST:event_jSalvar2ActionPerformed

    // Retornar Produto
    private void jCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCodigoProdutoFocusLost
        retornarproduto();
    }//GEN-LAST:event_jCodigoProdutoFocusLost

    private void jQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jQuantidadeFocusLost
        calcularValorTotal();
    }//GEN-LAST:event_jQuantidadeFocusLost

    private void jValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jValorUnitarioFocusLost
        calcularValorTotal();
    }//GEN-LAST:event_jValorUnitarioFocusLost

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarProdutoActionPerformed
        consultarProduto();
    }//GEN-LAST:event_jConsultarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jCodigoProduto;
    private javax.swing.JButton jConsultarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jProduto;
    private javax.swing.JTextField jQuantidade;
    private javax.swing.JButton jSair;
    private javax.swing.JButton jSalvar;
    private javax.swing.JButton jSalvar2;
    private javax.swing.JTextField jValorTotal;
    private javax.swing.JTextField jValorUnitario;
    // End of variables declaration//GEN-END:variables

    private void salvar() throws HeadlessException {
        VendaItemVO pVendaItemVO = new VendaItemVO();
        pVendaItemVO.setId_produto(Integer.parseInt(jCodigoProduto.getText()));
        pVendaItemVO.setDescricao(jProduto.getText());
        pVendaItemVO.setQuantidade(Integer.parseInt(jQuantidade.getText()));
        pVendaItemVO.setValortotal(Double.parseDouble(jValorTotal.getText()));
        pVendaItemVO.setValorunitario(Double.parseDouble(jValorUnitario.getText()));
        boolean existe = false;
        for (VendaItemVO vendaItemVO : parentFrame.vVenda) {
            if (vendaItemVO.getId_produto() == pVendaItemVO.getId_produto()) {
                vendaItemVO.setQuantidade(pVendaItemVO.getQuantidade());
                vendaItemVO.setValorunitario(pVendaItemVO.getValorunitario());
                vendaItemVO.setValortotal(pVendaItemVO.getValortotal());
                existe = true;
                break;
            }
            JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
        }
        if (!existe || parentFrame.vVenda.isEmpty()) {
            parentFrame.vVenda.add(pVendaItemVO);
        }
        parentFrame.revalidate();
        parentFrame.repaint();
        parentFrame.exibirProdutos();
        this.dispose();
    }


    private void calcularValorTotal() throws HeadlessException {
        if (!jQuantidade.getText().isEmpty()) {
            double valorunitario = Double.parseDouble(jValorUnitario.getText());
            int quantidade = Integer.parseInt(jQuantidade.getText());
            jValorTotal.setText(String.valueOf(valorunitario * quantidade));
        } else {
            jValorTotal.setText("");
        }
    }

    private void retornarproduto() throws HeadlessException {
        if (jCodigoProduto.getText().isEmpty()) {
            return;
        }
        try {
            produtoVO = produtoController.consultarProduto(Integer.parseInt(jCodigoProduto.getText()));
            if (produtoVO == null || produtoVO.getDescricao() == null || produtoVO.getDescricao().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Produto não encontrado");
                limparCamposProduto();
                return;
            }
            if (produtoVO.getSituacaocadastro() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Este produto está excluído.");
                limparCamposProduto();
                return;
            }
            isAtualizacao = false;
            for (VendaItemVO item : parentFrame.vVenda) {
                if (item.getId_produto() == Integer.parseInt(jCodigoProduto.getText())) {
                    jProduto.setText(item.getDescricao());
                    jValorUnitario.setText(String.valueOf(item.getValorunitario()));
                    jQuantidade.setText(String.valueOf(item.getQuantidade()));
                    isAtualizacao = true;
                    calcularValorTotal();
                    return;
                }
            }
            jProduto.setText(produtoVO.getDescricao());
            jValorUnitario.setText(String.valueOf(produtoVO.getValorunitario()));
            jQuantidade.setText("1");
            calcularValorTotal();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Código do produto inválido");
            limparCamposProduto();
        }
        isAtualizacao = false;
    }

    private void limparCamposProduto() {
        jCodigoProduto.setText("");
        jProduto.setText("");
        jValorUnitario.setText("");
        jQuantidade.setText("");
        jValorTotal.setText("");
    }

    public void consultarProduto() throws HeadlessException {
        ConsultaProdutoGUI form = new ConsultaProdutoGUI(this);
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public void setCodigoProduto(int id) {
        jCodigoProduto.setText(String.valueOf(id));
        retornarproduto();
    }

    private void formatarCampos() {
        CampoUtils.aceitaInteiro(jQuantidade);
        CampoUtils.aceitaDecimal(jValorUnitario);
        CampoUtils.setTamanhoMaximo(jQuantidade, 8);
        CampoUtils.setTamanhoMaximo(jValorUnitario, 8);
        CampoUtils.aceitaInteiro(jCodigoProduto);
        CampoUtils.setTamanhoMaximo(jCodigoProduto, 6);
    }

    private void focusNextComponent(ActionEvent actionEvent) {
        AtalhoTecladoUtils.focusNext(jSair, () -> jSairActionPerformed(null),
                jSalvar2, () -> jSalvar2ActionPerformed(null),
                null, null);
    }

    private void atalhoTeclado() {
        AtalhoTecladoUtils.funcaoTeclado(this,
                false, null,
                true, this::jSairActionPerformed,
                true, this::focusNextComponent,
                true, this::jSalvarActionPerformed);
    }


}
