package gui;

import controller.ClienteController;
import controller.VendaController;
import controller.VendaItemController;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import util.AtalhoTecladoUtils;
import util.CampoUtils;
import util.FormUtils;
import vo.ClienteVO;
import vo.VendaItemVO;
import vo.VendaVO;

public class VendaGUI extends javax.swing.JInternalFrame {

    public List<VendaItemVO> vVenda = new ArrayList<>();
    public List<VendaItemVO> vRemoverItem = new ArrayList<>();
    ClienteVO clienteVO = new ClienteVO();
    VendaVO vendaVO = new VendaVO();
    ClienteController clienteController = new ClienteController();
    VendaItemController vendaItemController = new VendaItemController();
    VendaController vendaController = new VendaController();
    double totalValor = 0.0;
    String dataFormatada = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
    private String clientenOriginal;
    private String dataOriginal;
    private String valorOriginal;


    public VendaGUI() {
        initComponents();
        formatarCampos();
        atalhoTeclado();
        jScrollPane1.setVisible(false);
        jData.setText(dataFormatada);
        armazenarEstadoOriginal();
    }

    public void carregarVenda(Integer idVenda) throws Exception {
        vendaVO = vendaController.consultarVenda(idVenda);
        jNumeroVenda.setText(String.valueOf(vendaVO.getId()));
        jNome.setText(vendaVO.getNomeCliente());
        jCliente.setText(String.valueOf(vendaVO.getId_cliente()));
        String data = vendaVO.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        jData.setText(data);
        jValorTotal.setText(String.valueOf(vendaVO.getValor()));
        jScrollPane1.setVisible(true);
        revalidate();
        repaint();
        vVenda = vendaItemController.consultarVendaItem(Integer.parseInt(jNumeroVenda.getText()));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (VendaItemVO vendaItemVO : vVenda) {
            model.addRow(new Object[]{
                    vendaItemVO.getId_produto(),
                    vendaItemVO.getDescricao(),
                    vendaItemVO.getQuantidade(),
                    vendaItemVO.getValorunitario(),
                    vendaItemVO.getValortotal()
            });
        }
        armazenarEstadoOriginal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jNumeroVenda = new javax.swing.JLabel();
        jConsultarCliente = new javax.swing.JButton();
        jNome = new javax.swing.JLabel();
        jData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jValorTotal = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jAdicionarProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRemoverProduto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSalvar2 = new javax.swing.JButton();
        jSair = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Venda");
        setDoubleBuffered(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pedidoCompra.png"))); // NOI18N

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

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jClienteFocusLost(evt);
            }
        });

        jLabel3.setText("Cliente");

        jLabel1.setText("Número Venda");

        jNumeroVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jConsultarCliente.setFocusable(false);
        jConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarClienteActionPerformed(evt);
            }
        });

        jNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jNome.setEnabled(false);

        jData.setColumns(8);
        try {
            jData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDataFocusLost(evt);
            }
        });

        jLabel5.setText("Data Venda");

        jLabel6.setText("Valor Total");

        jValorTotal.setColumns(8);
        jValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        jValorTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jValorTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jNumeroVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(150, 150, 150))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))
                                                .addGap(21, 21, 21))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

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
                        "Código", "Descrição", "Quantidade", "Valor Unitário", "Valor Total"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
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
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 192, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        javax.swing.JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setPreferredSize(new java.awt.Dimension(15, 30)); // Define a largura da barra de rolagem vertical

        jScrollPane1.setBounds(50, 50, 300, 300);

        jPanel3.add(jScrollPane1);

        jAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incluir.png"))); // NOI18N
        jAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarProdutoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Produtos");

        jRemoverProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remover.png"))); // NOI18N
        jRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(1, 1, 1)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSalvar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSair)
                                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        setBounds(500, 150, 672, 406);
    }// </editor-fold>//GEN-END:initComponents

    //Salvar apertando o botão
    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jSalvarActionPerformed

    // Adicionar item
    private void jAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarProdutoActionPerformed
        adicionarProduto();
    }//GEN-LAST:event_jAdicionarProdutoActionPerformed

    //Trazer cliente
    private void jClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jClienteFocusLost
        retornarcliente();
    }//GEN-LAST:event_jClienteFocusLost

    //Salvar apertando o botão
    private void jSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvar2ActionPerformed
        salvar();
    }//GEN-LAST:event_jSalvar2ActionPerformed

    //Sair apertando o botão
    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        sair();
    }//GEN-LAST:event_jSairActionPerformed

    //Consultar Cliente Apertando o Botão
    private void jConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarClienteActionPerformed
        consultarCliente();
    }//GEN-LAST:event_jConsultarClienteActionPerformed

    //Remover Produto Apertando o botão
    private void jRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverProdutoActionPerformed
        removerProduto();
    }//GEN-LAST:event_jRemoverProdutoActionPerformed

    //Edita Produto com duplo clique
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            editar();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDataFocusLost
        formatarData();
    }//GEN-LAST:event_jDataFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdicionarProduto;
    private javax.swing.JTextField jCliente;
    private javax.swing.JButton jConsultarCliente;
    private javax.swing.JFormattedTextField jData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jNumeroVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jRemoverProduto;
    private javax.swing.JButton jSair;
    private javax.swing.JButton jSalvar;
    private javax.swing.JButton jSalvar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField jValorTotal;
    // End of variables declaration//GEN-END:variables

    private boolean salvar() {
        if (jCliente.getText().isEmpty() || jData.getText().isEmpty() || jValorTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos obrigatórios");
            return false;
        }
        try {
            boolean isNovo = jNumeroVenda.getText().isEmpty();
            vendaVO.setId_cliente(Integer.parseInt(jCliente.getText()));
            vendaVO.setData(LocalDate.parse(jData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            vendaVO.setValor(Double.parseDouble(jValorTotal.getText()));
            if (!isNovo) {
                vendaVO.setId(Integer.parseInt(jNumeroVenda.getText()));
            }
            vendaController.salvar(vendaVO, vVenda, vRemoverItem);
            jNumeroVenda.setText(String.valueOf(vendaVO.getId()));
            JOptionPane.showMessageDialog(rootPane, isNovo ? "Cadastro de venda realizado com sucesso!" : "Venda atualizada com sucesso!");
            return true;
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar venda: " + ex.getMessage());
        }
        return false;
    }

    private void sair() {
        if (houveAlteracao()) {
            int opcao = JOptionPane.showConfirmDialog(
                    rootPane,
                    "Deseja salvar as alterações antes de sair?",
                    "Confirmar saída",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (opcao == JOptionPane.YES_OPTION) {
                if (salvar()) {
                    dispose();
                }
            } else if (opcao == JOptionPane.NO_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
    }

    public void exibirProdutos() throws HeadlessException {
        totalValor = 0;
        DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
        model2.setRowCount(0);
        for (VendaItemVO produto : vVenda) {
            model2.addRow(new Object[]{
                    produto.getId_produto(),
                    produto.getDescricao(),
                    produto.getQuantidade(),
                    produto.getValorunitario(),
                    produto.getValortotal()
            });
            totalValor += produto.getValortotal();
        }
        jValorTotal.setText(String.format(Locale.US, "%.2f", totalValor));
        jTable1.revalidate();
        jTable1.repaint();
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setVisible(true);
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
    }

    public void adicionarProduto() throws HeadlessException {
        VendaItemGUI form = new VendaItemGUI(this);
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public void removerProduto() throws HeadlessException {
        try {
            int row = jTable1.getSelectedRow();
            if (row != -1) {
                VendaItemVO pVendaItem = vVenda.get(jTable1.getSelectedRow());
                vVenda.remove(pVendaItem);
                vRemoverItem.add(pVendaItem);
                exibirProdutos();
            }
        } catch (Exception ex) {

        }
    }

    public void consultarCliente() throws HeadlessException {
        ConsultaClienteGUI form = new ConsultaClienteGUI(this);
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public void setCodigoCliente(int id) {
        jCliente.setText(String.valueOf(id));
        retornarcliente();
    }

    private void retornarcliente() throws HeadlessException {
        if (jCliente.getText().isEmpty()) {
            return;
        }
        try {
            clienteVO = clienteController.consultarCliente(Integer.valueOf(jCliente.getText()));
            if (clienteVO == null || clienteVO.getNome() == null || clienteVO.getNome().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado");
                limparCamposCliente();
                return;
            }
            if (clienteVO.getSituacaocadastro() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Este cliente está excluído.");
                limparCamposCliente();
                return;
            }
            if (clienteVO.getSituacaocadastro() == 1) {
                jNome.setText(clienteVO.getNome());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cliente com situação inválida.");
                limparCamposCliente();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Código do cliente inválido.");
            limparCamposCliente();
        }
    }

    private void limparCamposCliente() {
        jNome.setText("");
        jCliente.setText("");
        jCliente.requestFocusInWindow();
    }

    private void formatarCampos() {
        CampoUtils.aceitaInteiro(jCliente);
        CampoUtils.setTamanhoMaximo(jCliente, 6);
    }

    private void focusNextComponent(ActionEvent actionEvent) {
        AtalhoTecladoUtils.focusNext(jSair, () -> jSairActionPerformed(null),
                jSalvar2, () -> jSalvar2ActionPerformed(null),
                jAdicionarProduto, () -> jAdicionarProdutoActionPerformed(null));
    }

    private void atalhoTeclado() {
        AtalhoTecladoUtils.funcaoTeclado(this,
                false, null,
                true, this::jSairActionPerformed,
                true, this::focusNextComponent,
                true, this::jSalvarActionPerformed);
    }

    public void formatarData() throws HeadlessException {
        String data = jData.getText().trim().replaceAll("\\s+", "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        String dataFormatada = null;
        if (data.length() == 10 && data.charAt(2) == '/' && data.charAt(5) == '/') {
            dataFormatada = data;
        } else if (data.length() == 8 && data.charAt(2) == '/' && data.charAt(5) == '/') {
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = "20" + data.substring(6, 8);
            dataFormatada = dia + "/" + mes + "/" + ano;
        } else {
            JOptionPane.showMessageDialog(null, "Formato inválido. Use dd/MM/yy ou dd/MM/yyyy.");
            jData.setText("");
            jData.requestFocusInWindow();
            return;
        }
        try {
            LocalDate.parse(dataFormatada, formatter);
            jData.setText(dataFormatada);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida: " + dataFormatada);
            jData.setText("");
            jData.requestFocusInWindow();
        }
    }

    public void editar() throws HeadlessException {
        try {
            int row = jTable1.getSelectedRow();
            if (row != -1) {
                int id_produto = (Integer) jTable1.getValueAt(row, 0);
                VendaItemVO itemSelecionado = null;
                for (VendaItemVO item : vVenda) {
                    if (item.getId_produto() == id_produto) {
                        itemSelecionado = item;
                        break;
                    }
                }
                if (itemSelecionado != null) {
                    VendaItemGUI form = new VendaItemGUI(this);
                    FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
                    form.carregarVendaItem(itemSelecionado);
                } else if (!jNumeroVenda.getText().isEmpty()) {
                    int id_venda = Integer.parseInt(jNumeroVenda.getText());
                    VendaItemGUI form = new VendaItemGUI(this);
                    FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
                    form.carregarVendaItem(id_produto, id_venda);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void armazenarEstadoOriginal() {
        clientenOriginal = jCliente.getText();
        dataOriginal = jData.getText();
        valorOriginal = jValorTotal.getText();
    }

    private boolean houveAlteracao() {
        return !Objects.equals(jCliente.getText(), clientenOriginal)
                || !Objects.equals(jData.getText(), dataOriginal)
                || !Objects.equals(jValorTotal.getText(), valorOriginal);
    }

}
