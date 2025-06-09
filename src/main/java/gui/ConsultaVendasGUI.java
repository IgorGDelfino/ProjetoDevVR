package gui;

import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import util.AtalhoTecladoUtils;
import util.FormUtils;
import vo.ClienteVO;
import vo.ProdutoVO;
import vo.VendaItemVO;
import vo.VendaVO;

import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConsultaVendasGUI extends javax.swing.JInternalFrame {

    VendaController vendaController = new VendaController();
    private String tipoUltimaConsulta = null;
    ProdutoVO produtoVO = new ProdutoVO();
    ProdutoController produtoController = new ProdutoController();
    ClienteVO clienteVO = new ClienteVO();
    ClienteController clienteController = new ClienteController();

    public ConsultaVendasGUI() {
        initComponents();
        atalhoTeclado();
        jScrollPane1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jNumeroVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jExibicao = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCodigoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jConsultarCliente = new javax.swing.JButton();
        jNome = new javax.swing.JLabel();
        jCodigoProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jConsultarProduto = new javax.swing.JButton();
        jProduto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDataInicial = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jDataFinal = new javax.swing.JFormattedTextField();
        jConsultar = new javax.swing.JButton();
        jAdicionar = new javax.swing.JToggleButton();
        jEditar = new javax.swing.JToggleButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Venda");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pedidoCompra.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setFocusable(false);

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
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setFocusable(false);
        jPanel3.setMaximumSize(new java.awt.Dimension(0, 0));

        jScrollPane1.setBackground(new java.awt.Color(224, 224, 224));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusable(false);
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
                        "Código", "Cliente", "Data"
                }
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.getTableHeader().repaint();
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
                        .addGap(0, 379, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        javax.swing.JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setPreferredSize(new java.awt.Dimension(15, 30)); // Define a largura da barra de rolagem vertical

        jScrollPane1.setBounds(50, 50, 300, 300);

        jPanel3.add(jScrollPane1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setFocusable(false);

        jLabel2.setText("Número Venda");
        jLabel2.setFocusable(false);

        jExibicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"VENDA", "CLIENTE", "PRODUTO"}));
        jExibicao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jExibicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExibicaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Exibição");
        jLabel3.setFocusable(false);

        jCodigoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jCodigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCodigoClienteFocusLost(evt);
            }
        });

        jLabel4.setText("Cliente");

        jConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jConsultarCliente.setFocusable(false);
        jConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarClienteActionPerformed(evt);
            }
        });

        jNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jNome.setEnabled(false);

        jCodigoProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jCodigoProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCodigoProdutoFocusLost(evt);
            }
        });

        jLabel5.setText("Produto");

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

        jProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setText("Data Inicial");

        jDataInicial.setColumns(8);
        try {
            jDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jDataInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDataInicialFocusLost(evt);
            }
        });

        jLabel7.setText("Data Final");

        jDataFinal.setColumns(8);
        try {
            jDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jDataFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDataFinalFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jNumeroVenda)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jExibicao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addGap(21, 21, 21)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(21, 21, 21)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jConsultarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(1, 1, 1)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel3))
                                                        .addGap(1, 1, 1)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jExibicao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(7, 7, 7))
        );

        jConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jConsultar.setToolTipText("Consultar ( F1 )");
        jConsultar.setContentAreaFilled(false);
        jConsultar.setFocusPainted(false);
        jConsultar.setFocusable(false);
        jConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarActionPerformed(evt);
            }
        });

        jAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incluir.png"))); // NOI18N
        jAdicionar.setContentAreaFilled(false);
        jAdicionar.setFocusPainted(false);
        jAdicionar.setFocusable(false);
        jAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarActionPerformed(evt);
            }
        });

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
        jEditar.setContentAreaFilled(false);
        jEditar.setFocusPainted(false);
        jEditar.setFocusable(false);
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
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
                                        .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
        );

        setBounds(390, 80, 1050, 539);
    }// </editor-fold>//GEN-END:initComponents

    //Adicionar apertando botão
    private void jAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_jAdicionarActionPerformed

    //Consultar apertando botão
    private void jConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_jConsultarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) throws HeadlessException {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            editar();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jCodigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCodigoClienteFocusLost
        retornarcliente();
    }//GEN-LAST:event_jCodigoClienteFocusLost

    private void jConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarClienteActionPerformed
        consultarCliente();
    }//GEN-LAST:event_jConsultarClienteActionPerformed

    private void jCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCodigoProdutoFocusLost
        retornarproduto();
    }//GEN-LAST:event_jCodigoProdutoFocusLost

    private void jConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarProdutoActionPerformed
        consultarProduto();
    }//GEN-LAST:event_jConsultarProdutoActionPerformed

    private void jDataInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDataInicialFocusLost
        formatarDataInicial();
    }//GEN-LAST:event_jDataInicialFocusLost

    private void jDataFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDataFinalFocusLost
        formatarDataFinal();
    }//GEN-LAST:event_jDataFinalFocusLost

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed
        editar();
    }//GEN-LAST:event_jEditarActionPerformed

    private void jExibicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExibicaoActionPerformed
        if (jExibicao.getSelectedItem().equals("VENDA")) {
            jCodigoCliente.setEnabled(true);
            jCodigoProduto.setEnabled(true);
            jNumeroVenda.setEnabled(true);
            jConsultarCliente.setEnabled(true);
            jConsultarProduto.setEnabled(true);
        } else if (jExibicao.getSelectedItem().equals("CLIENTE")) {
            jCodigoCliente.setEnabled(true);
            jCodigoProduto.setEnabled(false);
            jNumeroVenda.setEnabled(false);
            jConsultarProduto.setEnabled(false);
            jConsultarCliente.setEnabled(true);
        } else if (jExibicao.getSelectedItem().equals("PRODUTO")) {
            jCodigoCliente.setEnabled(false);
            jCodigoProduto.setEnabled(true);
            jNumeroVenda.setEnabled(false);
            jConsultarProduto.setEnabled(true);
            jConsultarCliente.setEnabled(false);
        }
    }//GEN-LAST:event_jExibicaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jAdicionar;
    private javax.swing.JTextField jCodigoCliente;
    private javax.swing.JTextField jCodigoProduto;
    private javax.swing.JButton jConsultar;
    private javax.swing.JButton jConsultarCliente;
    private javax.swing.JButton jConsultarProduto;
    private javax.swing.JFormattedTextField jDataFinal;
    private javax.swing.JFormattedTextField jDataInicial;
    private javax.swing.JToggleButton jEditar;
    private javax.swing.JComboBox<String> jExibicao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jNome;
    private javax.swing.JTextField jNumeroVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jProduto;
    private javax.swing.JButton jSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void adicionar() throws HeadlessException {
        VendaGUI form = new VendaGUI();
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public class VendaTableModel extends DefaultTableModel {

        public VendaTableModel() {
            super(new Object[][]{},
                    new String[]{"Venda", "Cliente", "Data", "Valor"});
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public class ClienteTableModel extends DefaultTableModel {

        public ClienteTableModel() {
            super(new Object[][]{},
                    new String[]{"Cliente", "Nome", "Data", "Valor"});
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public class ProdutoTableModel extends DefaultTableModel {

        public ProdutoTableModel() {
            super(new Object[][]{},
                    new String[]{"Produto", "Descricao", "Data", "Valor"});
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void consultar() {
        jScrollPane1.setVisible(true);
        revalidate();
        repaint();
        String tipo = (String) jExibicao.getSelectedItem();
        VendaVO filtroVenda = new VendaVO();
        VendaItemVO filtroProduto = new VendaItemVO();
        if (!jCodigoCliente.getText().isEmpty()) {
            filtroVenda.setId_cliente(Integer.parseInt(jCodigoCliente.getText()));
        }
        if (!jCodigoProduto.getText().isEmpty()) {
            filtroProduto.setId_produto(Integer.parseInt(jCodigoProduto.getText()));
        }
        if (!jNumeroVenda.getText().isEmpty()) {
            filtroVenda.setId(Integer.parseInt(jNumeroVenda.getText()));
        }
        if (jDataInicial.getText().trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
            filtroVenda.setDataInicial(LocalDate.parse(jDataInicial.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        if (jDataFinal.getText().trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
            filtroVenda.setDataFinal(LocalDate.parse(jDataFinal.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        List<?> resultados = vendaController.consultarVendasPorTipo(tipo, filtroVenda, filtroProduto);
        switch (tipo) {
            case "VENDA":
                mostrarVendas((List<VendaVO>) resultados);
                break;
            case "PRODUTO":
                mostrarVendaItens((List<VendaItemVO>) resultados);
                break;
            case "CLIENTE":
                mostrarVendasCliente((List<VendaVO>) resultados);
                break;
        }

        tipoUltimaConsulta = tipo;
    }

    private void mostrarVendas(List<VendaVO> vendas) {
        DefaultTableModel model = new VendaTableModel();
        jTable1.setModel(model);
        model.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (VendaVO venda : vendas) {
            String data = venda.getData().format(formatter);
            model.addRow(new Object[]{venda.getId(), venda.getNomeCliente(), data, venda.getValor()});
        }
    }

    private void mostrarVendaItens(List<VendaItemVO> vendaItens) {
        DefaultTableModel model = new ProdutoTableModel();
        jTable1.setModel(model);
        model.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (VendaItemVO item : vendaItens) {
            String data = item.getVenda().getData().format(formatter);
            model.addRow(new Object[]{item.getId_produto(), item.getDescricao(), data, item.getValortotal()});
        }
    }

    private void mostrarVendasCliente(List<VendaVO> vendas) {
        DefaultTableModel model = new ClienteTableModel(); // Model diferente para cliente
        jTable1.setModel(model);
        model.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (VendaVO venda : vendas) {
            String data = venda.getData().format(formatter);
            model.addRow(new Object[]{venda.getId_cliente(), venda.getNomeCliente(), data, venda.getValor()});
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

    private void editar() throws HeadlessException {
        try {
            if (!"VENDA".equals(tipoUltimaConsulta)) {
                JOptionPane.showMessageDialog(this,
                        "A edição está disponível apenas para vendas.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            int row = jTable1.getSelectedRow();
            int idVenda = (Integer) jTable1.getValueAt(row, 0);
            VendaGUI form = new VendaGUI();
            FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
            form.carregarVenda(idVenda);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void consultarProduto() throws HeadlessException {
        ConsultaProdutoGUI form = new ConsultaProdutoGUI(this);
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public void setCodigoProduto(int id) {
        jCodigoProduto.setText(String.valueOf(id));
        retornarproduto();
    }

    private void retornarproduto() throws HeadlessException {
        if (jCodigoProduto.getText().isEmpty()) {
            return;
        }
        try {
            produtoVO = produtoController.consultarProduto(Integer.parseInt(jCodigoProduto.getText()));
            if (produtoVO == null || produtoVO.getDescricao() == null || produtoVO.getDescricao().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Produto não encontrado");
                jCodigoProduto.setText("");
            } else {
                jProduto.setText(produtoVO.getDescricao());
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultarCliente() throws HeadlessException {
        ConsultaClienteGUI form = new ConsultaClienteGUI(this);
        FormUtils.abrirFormulario(MenuGUI.jDesktopMenu, form);
    }

    public void setCodigoCliente(int id) {
        jCodigoCliente.setText(String.valueOf(id));
        retornarcliente();
    }

    private void retornarcliente() throws HeadlessException {
        if (jCodigoCliente.getText().isEmpty()) {
            return;
        }
        try {
            clienteVO = clienteController.consultarCliente(Integer.valueOf(jCodigoCliente.getText()));
            if (!clienteVO.getNome().isEmpty()) {
                jNome.setText(clienteVO.getNome());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado");
                jNome.setText("");
                jCodigoCliente.setText("");
            }
        } catch (NumberFormatException ex) {
        }
    }

    public void formatarDataInicial() throws HeadlessException {
        String data = jDataInicial.getText().trim().replaceAll("\\s+", "");
        if (data.isEmpty() || data.replace("/", "").isEmpty()) {
            jDataInicial.setText("");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        String dataFormatada;
        if (data.length() == 10 && data.charAt(2) == '/' && data.charAt(5) == '/') {
            dataFormatada = data;
        } else if (data.length() == 8 && data.charAt(2) == '/' && data.charAt(5) == '/') {
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = "20" + data.substring(6, 8);
            dataFormatada = dia + "/" + mes + "/" + ano;
        } else {
            JOptionPane.showMessageDialog(null, "Formato inválido. Use dd/MM/yy ou dd/MM/yyyy.");
            jDataInicial.setText("");
            jDataInicial.requestFocusInWindow();
            return;
        }
        try {
            LocalDate.parse(dataFormatada, formatter);
            jDataInicial.setText(dataFormatada);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida: " + dataFormatada);
            jDataInicial.setText("");
            jDataInicial.requestFocusInWindow();
        }
    }

    public void formatarDataFinal() throws HeadlessException {
        String data = jDataFinal.getText().trim().replaceAll("\\s+", "");
        if (data.isEmpty() || data.replace("/", "").isEmpty()) {
            jDataFinal.setText("");
            return;
        }
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
            jDataFinal.setText("");
            jDataFinal.requestFocusInWindow();
            return;
        }
        try {
            LocalDate.parse(dataFormatada, formatter);
            jDataFinal.setText(dataFormatada);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida: " + dataFormatada);
            jDataFinal.setText("");
            jDataFinal.requestFocusInWindow();
        }
    }

}
