package hospital.management.system.telas;

import hospital.management.system.entidades.Ambulatorio;
import hospital.management.system.entidades.Observacao;
import hospital.management.system.entidades.Paciente;
import hospital.management.system.persistencia.AmbulatorioDAO;
import hospital.management.system.persistencia.ObservacaoDAO;
import hospital.management.system.persistencia.PacienteDAO;
import hospital.management.system.utils.DAOFactory;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class JPanelObservacao extends javax.swing.JPanel {
    ObservacaoDAO observacaoDAO = DAOFactory.createObservacaoDAO();
    AmbulatorioDAO ambulatorioDAO = DAOFactory.createAmbulatorioDAO();
    PacienteDAO pacienteDAO = DAOFactory.createPacienteDAO();

    public JPanelObservacao() {
        initComponents();
        carregarTabelaObservacao();
        carregarTabelaAmbulatorio();
        carregarTabelaPaciente();
    }
    
    private void carregarTabelaObservacao(){
        List<Observacao> observacoes = observacaoDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableObservacao.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (Observacao observacao: observacoes){
          Object[] linha = new Object[9];
          linha[0]= observacao.getId();
          linha[1]= observacao.getDataEntrada();
          linha[2]= observacao.getDataSaida();
          linha[3]= observacao.getHorarioEntrada();
          linha[4]= observacao.getHorarioSaida();
          linha[5]= observacao.getIdPaciente();
          linha[6]= "";
          linha[7]= observacao.getIdAmbulatorio();
          linha[8]="" ;
          
          modeloTabela.addRow(linha);
        }
    }
    public void carregarTabelaAmbulatorio() {
        List<Ambulatorio> ambulatorios = ambulatorioDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableAmbulatorio.getModel();
        
        int qntdLinhas = modeloTabela.getRowCount();
        for (int i = 0; i < qntdLinhas; i++) {
            modeloTabela.removeRow(0);
        }   
        
        for (Ambulatorio ambulatorio: ambulatorios) {
            Object[] linha = new Object[2];
            linha[0] = ambulatorio.getId();
            linha[1] = ambulatorio.getNumero();
            modeloTabela.addRow(linha);
        }
    }
    public void carregarTabelaPaciente() {
        List<Paciente> medicos = pacienteDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTablePaciente.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        
        for (Paciente medico: medicos) {
            Object[] linha = new Object[2];
            linha[0] = medico.getId();
            linha[1] = medico.getNome();
            
            modeloTabela.addRow(linha);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelDataEntrada = new javax.swing.JLabel();
        jLabelDataSaida = new javax.swing.JLabel();
        jTextFieldDataEntrada = new javax.swing.JTextField();
        jTextFieldDataSaida = new javax.swing.JTextField();
        jLabelHorarioEntrada = new javax.swing.JLabel();
        jTextFieldHorarioEntrada = new javax.swing.JTextField();
        jLabelHorarioSaida = new javax.swing.JLabel();
        jTextFieldHorarioSaida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMedicacao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAmbulatorio = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableObservacao = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabelPaciente = new javax.swing.JLabel();
        jLabelAmbulatorio = new javax.swing.JLabel();

        jLabel1.setText("Id:");

        jTextFieldId.setEditable(false);

        jLabelDataEntrada.setText("Data de Entrada:");

        jLabelDataSaida.setText("Data de Entrada:");

        jTextFieldDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataEntradaActionPerformed(evt);
            }
        });

        jTextFieldDataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataSaidaActionPerformed(evt);
            }
        });

        jLabelHorarioEntrada.setText("Horário de Entrada:");

        jLabelHorarioSaida.setText("Horário de Saida:");

        jTextFieldHorarioSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorarioSaidaActionPerformed(evt);
            }
        });

        jLabel6.setText("Medicação:");

        jTextAreaMedicacao.setColumns(20);
        jTextAreaMedicacao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMedicacao);

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePaciente.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTablePaciente);
        if (jTablePaciente.getColumnModel().getColumnCount() > 0) {
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableAmbulatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Número"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAmbulatorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableAmbulatorio);
        if (jTableAmbulatorio.getColumnModel().getColumnCount() > 0) {
            jTableAmbulatorio.getColumnModel().getColumn(0).setResizable(false);
            jTableAmbulatorio.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar Campos");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar tabelas");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jTableObservacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data Entrada", "Data Saída", "Horário Entrada", "Horário Saída", "ID Paciente", "Nome Paciente", "ID Ambulatório", "Nmr. Ambulatório"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableObservacao.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableObservacao);
        if (jTableObservacao.getColumnModel().getColumnCount() > 0) {
            jTableObservacao.getColumnModel().getColumn(0).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(1).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(2).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(3).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(4).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(5).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(6).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(7).setResizable(false);
            jTableObservacao.getColumnModel().getColumn(8).setResizable(false);
        }

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabelPaciente.setText("Paciente");

        jLabelAmbulatorio.setText("Ambulatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHorarioEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldHorarioEntrada))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDataEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDataSaida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHorarioSaida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabelPaciente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelAmbulatorio)
                                .addGap(81, 81, 81))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButtonExcluir)
                                    .addGap(4, 4, 4)))
                            .addComponent(jButtonEditar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(426, 426, 426))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addGap(34, 34, 34)
                .addComponent(jButtonLimpar)
                .addGap(18, 18, 18)
                .addComponent(jButtonAtualizar)
                .addGap(306, 306, 306))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPaciente)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelAmbulatorio)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelDataEntrada)
                                .addComponent(jLabelDataSaida)
                                .addComponent(jTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelHorarioEntrada)
                                .addComponent(jTextFieldHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelHorarioSaida)
                                .addComponent(jTextFieldHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonAtualizar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButtonEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataEntradaActionPerformed
 
    }//GEN-LAST:event_jTextFieldDataEntradaActionPerformed

    private void jTextFieldDataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataSaidaActionPerformed

    }//GEN-LAST:event_jTextFieldDataSaidaActionPerformed

    private void jTextFieldHorarioSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorarioSaidaActionPerformed

    }//GEN-LAST:event_jTextFieldHorarioSaidaActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Observacao observacao = new Observacao();
        int linhaP, linhaL, id;
        
        linhaP = jTablePaciente.getSelectedRow();
        if( linhaP!=-1){
          id = (int)jTablePaciente.getValueAt(linhaP, 0);
          observacao.setIdPaciente(id);
        }
        linhaL = jTableAmbulatorio.getSelectedRow();
        if( linhaL!=-1){
          id = (int)jTableAmbulatorio.getValueAt(linhaL, 0);
          observacao.setIdAmbulatorio(id);
        }
        
        int idObs = 0;
        try {
            idObs = Integer.parseInt(jTextFieldId.getText());
        } catch(NumberFormatException ex) {
            idObs = 0;
        }
        observacao.setId(idObs);
        observacao.setDataEntrada(jTextFieldDataEntrada.getText());
        observacao.setHorarioEntrada(jTextFieldHorarioEntrada.getText());
        observacao.setDataSaida(jTextFieldDataSaida.getText());
        observacao.setHorarioSaida(jTextFieldHorarioSaida.getText());
        observacao.setMedicacao(jTextAreaMedicacao.getText());
        if(observacaoDAO.getById(observacao.getId())==null){
            observacaoDAO.inserir(observacao);
        } else {
            observacaoDAO.editar(observacao);
        }
        jButtonLimparActionPerformed(evt);
        carregarTabelaObservacao();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldId.setText("");
        jTextFieldDataEntrada.setText("");
        jTextFieldHorarioEntrada.setText("");
        jTextFieldDataSaida.setText("");
        jTextFieldHorarioSaida.setText("");
        jTextAreaMedicacao.setText("");
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        carregarTabelaObservacao();
        carregarTabelaAmbulatorio();
        carregarTabelaPaciente();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int linha = jTableObservacao.getSelectedRow();
        if (linha!=-1){
            int id = (int)jTableObservacao.getValueAt(linha, 0);
            Observacao observacao = observacaoDAO.getById(id);
            jTextFieldId.setText(observacao.getId()+"");
            jTextFieldDataEntrada.setText(observacao.getDataEntrada());
            jTextFieldHorarioEntrada.setText(observacao.getHorarioEntrada());
            jTextFieldDataSaida.setText(observacao.getDataSaida());
            jTextFieldHorarioSaida.setText(observacao.getHorarioSaida());
            jTextAreaMedicacao.setText(observacao.getMedicacao());
            
            for(int i=0;i<jTablePaciente.getRowCount();i++){ 
                int idD = (int)jTablePaciente.getValueAt(i, 0);
                if(observacao.getIdPaciente()==idD){
                    linha = i; 
                    break;
                }
            }
            jTablePaciente.setRowSelectionInterval(linha, linha);
            
            for(int i=0;i<jTableAmbulatorio.getRowCount();i++){ 
                int idD = (int)jTableAmbulatorio.getValueAt(i, 0);
                if(observacao.getIdAmbulatorio()==idD){
                    linha = i; 
                    break;
                }
            }
            jTableAmbulatorio.setRowSelectionInterval(linha, linha);
        } 
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linhas = jTableObservacao.getSelectedRows();
        for (int pos: linhas) {
            int id = (int) jTableObservacao.getValueAt(pos, 0);
            observacaoDAO.remover(id);
        }
        carregarTabelaObservacao();
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAmbulatorio;
    private javax.swing.JLabel jLabelDataEntrada;
    private javax.swing.JLabel jLabelDataSaida;
    private javax.swing.JLabel jLabelHorarioEntrada;
    private javax.swing.JLabel jLabelHorarioSaida;
    private javax.swing.JLabel jLabelPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAmbulatorio;
    private javax.swing.JTable jTableObservacao;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextArea jTextAreaMedicacao;
    private javax.swing.JTextField jTextFieldDataEntrada;
    private javax.swing.JTextField jTextFieldDataSaida;
    private javax.swing.JTextField jTextFieldHorarioEntrada;
    private javax.swing.JTextField jTextFieldHorarioSaida;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
