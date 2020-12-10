package hospital.management.system.telas;

import hospital.management.system.entidades.Internacao;
import hospital.management.system.entidades.Leito;
import hospital.management.system.entidades.Paciente;
import hospital.management.system.persistencia.InternacaoDAO;
import hospital.management.system.persistencia.LeitoDAO;
import hospital.management.system.persistencia.PacienteDAO;
import hospital.management.system.utils.DAOFactory;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JPanelInternacao extends javax.swing.JPanel {
    InternacaoDAO internacaoDAO = DAOFactory.createInternacaoDAO();
    PacienteDAO pacienteDAO = DAOFactory.createPacienteDAO();
    LeitoDAO leitoDAO = DAOFactory.createLeitoDAO();

    public JPanelInternacao() {
        initComponents();
        carregarTabelaInternacao();
        carregarTabelaPaciente();
        carregarTabelaLeito();
    }
    
     private void carregarTabelaInternacao(){
        List<Internacao> internacoes = internacaoDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableInternacao.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (Internacao internacao: internacoes){
          Object[] linha = new Object[9];
          linha[0]= internacao.getId();
          linha[1]= internacao.getDataEntrada();
          linha[2]= internacao.getHorarioEntrada();
          linha[3]= internacao.getDataSaida();
          linha[4]= internacao.getHorarioSaida();
          linha[5]= internacao.getIdPaciente();
          linha[6]= pacienteDAO.getById(internacao.getIdPaciente()).getNome();
          linha[7]= internacao.getIdLeito();
          linha[8]= leitoDAO.getById(internacao.getIdLeito()).getNumero();
          
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
     private void carregarTabelaLeito(){
        List<Leito> internacaos = leitoDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableLeito.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (Leito internacao: internacaos){
          Object[] linha = new Object[2];
          linha[0]= internacao.getId();
          linha[1]= internacao.getNumero();
          
          modeloTabela.addRow(linha);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelHorario_de_entradaa = new javax.swing.JLabel();
        jLabelData_de_saida = new javax.swing.JLabel();
        jLabelHorario_de_saida = new javax.swing.JLabel();
        jLabelMedicacao = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldData_de_entrada = new javax.swing.JTextField();
        jTextFieldHorario_de_entrada = new javax.swing.JTextField();
        jTextFieldData_de_saida = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMedicacao = new javax.swing.JTextArea();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInternacao = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldHorario_de_saida = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableLeito = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jLabelLeito = new javax.swing.JLabel();
        jLabelPaciente = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();

        jLabelId.setText("ID:");

        jLabel2.setText("Data de Entrada:");

        jLabelHorario_de_entradaa.setText("Horário de entrada:");

        jLabelData_de_saida.setText("Data de Saída");

        jLabelHorario_de_saida.setText("Horário de Saída");

        jLabelMedicacao.setText("Medicação:");

        jTextFieldId.setEditable(false);

        jTextFieldData_de_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldData_de_entradaActionPerformed(evt);
            }
        });

        jTextFieldHorario_de_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorario_de_entradaActionPerformed(evt);
            }
        });

        jTextFieldData_de_saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldData_de_saidaActionPerformed(evt);
            }
        });

        jTextAreaMedicacao.setColumns(20);
        jTextAreaMedicacao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMedicacao);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar campos");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jTableInternacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data de Entrada", "Horario de Entrada", "Data de Saida", "Horario de Saida", "ID Paciente", "Nome Paciente", "ID Leitol", "Número Leito"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInternacao.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableInternacao);
        if (jTableInternacao.getColumnModel().getColumnCount() > 0) {
            jTableInternacao.getColumnModel().getColumn(0).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(1).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(2).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(3).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(4).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(5).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(6).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(7).setResizable(false);
            jTableInternacao.getColumnModel().getColumn(8).setResizable(false);
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

        jTextFieldHorario_de_saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorario_de_saidaActionPerformed(evt);
            }
        });

        jTableLeito.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableLeito.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableLeito);
        if (jTableLeito.getColumnModel().getColumnCount() > 0) {
            jTableLeito.getColumnModel().getColumn(0).setResizable(false);
            jTableLeito.getColumnModel().getColumn(1).setResizable(false);
        }

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Nome"
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
        jScrollPane4.setViewportView(jTablePaciente);
        if (jTablePaciente.getColumnModel().getColumnCount() > 0) {
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelLeito.setText("Leito");

        jLabelPaciente.setText("Paciente");

        jButtonAtualizar.setText("Atualizar tabelas");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtualizar)
                        .addGap(383, 383, 383))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMedicacao)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(jLabelPaciente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelLeito)
                                        .addGap(124, 124, 124))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHorario_de_entradaa)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldHorario_de_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelHorario_de_saida)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldHorario_de_saida, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldData_de_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelData_de_saida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldData_de_saida, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelId)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldData_de_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData_de_saida)
                    .addComponent(jTextFieldData_de_saida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHorario_de_entradaa)
                    .addComponent(jTextFieldHorario_de_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorario_de_saida)
                    .addComponent(jTextFieldHorario_de_saida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPaciente)
                            .addComponent(jLabelLeito)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMedicacao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldData_de_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldData_de_entradaActionPerformed

    }//GEN-LAST:event_jTextFieldData_de_entradaActionPerformed

    private void jTextFieldHorario_de_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorario_de_entradaActionPerformed

    }//GEN-LAST:event_jTextFieldHorario_de_entradaActionPerformed

    private void jTextFieldData_de_saidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldData_de_saidaActionPerformed

    }//GEN-LAST:event_jTextFieldData_de_saidaActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Internacao internacao = new Internacao();
        int linhaP, linhaL, id;
        
        linhaP = jTablePaciente.getSelectedRow();
        if( linhaP!=-1){
          id = (int)jTablePaciente.getValueAt(linhaP, 0);
          internacao.setIdPaciente(id);
        }
        linhaL = jTableLeito.getSelectedRow();
        if( linhaL!=-1){
          id = (int)jTableLeito.getValueAt(linhaL, 0);
          internacao.setIdLeito(id);
        }
        
        int idInt = 0;
        try {
        idInt = Integer.parseInt(jTextFieldId.getText());
        } catch(NumberFormatException ex) {
            idInt = 0;
        }
        internacao.setId(idInt);
        internacao.setDataEntrada(jTextFieldData_de_entrada.getText());
        internacao.setHorarioEntrada(jTextFieldHorario_de_entrada.getText());
        internacao.setDataSaida(jTextFieldData_de_saida.getText());
        internacao.setHorarioSaida(jTextFieldHorario_de_saida.getText());
        internacao.setMedicacao(jTextAreaMedicacao.getText());
        if(internacaoDAO.getById(internacao.getId())==null){
            internacaoDAO.inserir(internacao);
        } else {
            internacaoDAO.editar(internacao);
        }
        jButtonLimparActionPerformed(evt);
        carregarTabelaInternacao();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldId.setText("");
        jTextFieldData_de_entrada.setText("");
        jTextFieldHorario_de_entrada.setText("");
        jTextFieldData_de_saida.setText("");
        jTextFieldHorario_de_saida.setText("");
        jTextAreaMedicacao.setText("");
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int linha = jTableInternacao.getSelectedRow();
        if (linha!=-1){
            int id = (int)jTableInternacao.getValueAt(linha, 0);
            Internacao internacao = internacaoDAO.getById(id);
            
            jTextFieldId.setText(internacao.getId()+"");
            jTextFieldData_de_entrada.setText(internacao.getDataEntrada());
            jTextFieldHorario_de_entrada.setText(internacao.getHorarioEntrada());
            jTextFieldData_de_saida.setText(internacao.getDataSaida());
            jTextFieldHorario_de_saida.setText(internacao.getHorarioSaida());
            jTextAreaMedicacao.setText(internacao.getMedicacao());
            
            for(int i=0;i<jTablePaciente.getRowCount();i++){ 
                int idD = (int)jTablePaciente.getValueAt(i, 0);
                if(internacao.getIdPaciente()==idD){
                    linha = i; 
                    break;
                }
            }
            jTablePaciente.setRowSelectionInterval(linha, linha);
            
            for(int i=0;i<jTableLeito.getRowCount();i++){ 
                int idD = (int)jTableLeito.getValueAt(i, 0);
                if(internacao.getIdLeito()==idD){
                    linha = i; 
                    break;
                }
            }
            jTableLeito.setRowSelectionInterval(linha, linha);
        } 
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linhas = jTableInternacao.getSelectedRows();
        for (int pos: linhas) {
            int id = (int) jTableInternacao.getValueAt(pos, 0);
            internacaoDAO.remover(id);
        }
        carregarTabelaInternacao();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldHorario_de_saidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorario_de_saidaActionPerformed

    }//GEN-LAST:event_jTextFieldHorario_de_saidaActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        carregarTabelaInternacao();
        carregarTabelaPaciente();
        carregarTabelaLeito();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelData_de_saida;
    private javax.swing.JLabel jLabelHorario_de_entradaa;
    private javax.swing.JLabel jLabelHorario_de_saida;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelLeito;
    private javax.swing.JLabel jLabelMedicacao;
    private javax.swing.JLabel jLabelPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableInternacao;
    private javax.swing.JTable jTableLeito;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextArea jTextAreaMedicacao;
    private javax.swing.JTextField jTextFieldData_de_entrada;
    private javax.swing.JTextField jTextFieldData_de_saida;
    private javax.swing.JTextField jTextFieldHorario_de_entrada;
    private javax.swing.JTextField jTextFieldHorario_de_saida;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
