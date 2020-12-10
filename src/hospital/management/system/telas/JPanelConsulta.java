package hospital.management.system.telas;

import hospital.management.system.entidades.Consulta;
import hospital.management.system.entidades.Consultorio;
import hospital.management.system.entidades.Medico;
import hospital.management.system.entidades.Paciente;
import hospital.management.system.persistencia.ConsultaDAO;
import hospital.management.system.persistencia.ConsultorioDAO;
import hospital.management.system.persistencia.MedicoDAO;
import hospital.management.system.persistencia.PacienteDAO;
import hospital.management.system.utils.DAOFactory;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JPanelConsulta extends javax.swing.JPanel {
    private ConsultaDAO consultaDAO = DAOFactory.createConsultaDAO();
    private PacienteDAO pacienteDAO = DAOFactory.createPacienteDAO();
    private MedicoDAO medicoDAO = DAOFactory.createMedicoDAO();
    private ConsultorioDAO consultorioDAO = DAOFactory.createConsultorioDAO();

    public JPanelConsulta() {
        initComponents();
        carregarTabelaConsulta();
        carregarTabelaConsultorio();
        carregarTabelaMedico();
        carregarTabelaPaciente();
    }

    private void carregarTabelaConsulta(){
        List<Consulta> consultas = consultaDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableConsulta.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (Consulta consulta: consultas){
          Object[] linha = new Object[9];
          linha[0]= consulta.getId();
          linha[1]= consulta.getPeriodoDeExames();
          linha[2]= consulta.getTratamento();
          linha[3]= consulta.getIdPaciente();
          linha[4]= pacienteDAO.getById(consulta.getIdPaciente()).getNome();
          linha[5]= consulta.getIdMedico();
          linha[6]= medicoDAO.getById(consulta.getIdMedico()).getNome();
          linha[7]= consulta.getIdConsultorio();
          linha[8]= consultorioDAO.getById(consulta.getIdConsultorio()).getNumero();
          
          modeloTabela.addRow(linha);
        }
    }
        
    public void carregarTabelaPaciente() {
        List<Paciente> pacientes = pacienteDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTablePaciente.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        
        for (Paciente paciente: pacientes) {
            Object[] linha = new Object[2];
            linha[0] = paciente.getId();
            linha[1] = paciente.getNome();
            
            modeloTabela.addRow(linha);
        }
    }
    
    public void carregarTabelaMedico() {
        List<Medico> medicos = medicoDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableMedico.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        
        for (Medico medico: medicos) {
            Object[] linha = new Object[2];
            linha[0] = medico.getId();
            linha[1] = medico.getNome();
            
            modeloTabela.addRow(linha);
        }
    }
    
    public void carregarTabelaConsultorio() {
        List<Consultorio> consultorios = consultorioDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableConsultorio.getModel();

        int qntdLinhas = modeloTabela.getRowCount();
        for (int i = 0; i < qntdLinhas; i++) {
            modeloTabela.removeRow(0);
        }   
        
        for (Consultorio consultorio: consultorios) {
            Object[] linha = new Object[2];
            linha[0] = consultorio.getId();
            linha[1] = consultorio.getNumero();
            modeloTabela.addRow(linha);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelRelatorio = new javax.swing.JLabel();
        jLabelTratamento = new javax.swing.JLabel();
        jLabelPeriodo = new javax.swing.JLabel();
        jTextFieldPeriodo = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaRelatorio = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaTratamento = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableConsultorio = new javax.swing.JTable();
        jLabelMedico = new javax.swing.JLabel();
        jLabelConsultorio = new javax.swing.JLabel();
        jButtonAtualizarTabelas = new javax.swing.JButton();

        jLabelId.setText("ID:");

        jTextFieldId.setEditable(false);
        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jLabelRelatorio.setText("Relatório:");

        jLabelTratamento.setText("Tratamento");

        jLabelPeriodo.setText("Período  de exames");

        jTextFieldPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPeriodoActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar campos");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Período de exames", "Tratamento", "ID Paciente", "Paciente", "ID Médico", "Médico", "ID Consultorio", "Consultorio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableConsulta);
        if (jTableConsulta.getColumnModel().getColumnCount() > 0) {
            jTableConsulta.getColumnModel().getColumn(0).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(1).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(2).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(3).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(4).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(5).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(6).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(7).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(8).setResizable(false);
        }

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jTextAreaRelatorio.setColumns(20);
        jTextAreaRelatorio.setRows(5);
        jScrollPane3.setViewportView(jTextAreaRelatorio);

        jTextAreaTratamento.setColumns(20);
        jTextAreaTratamento.setRows(5);
        jScrollPane4.setViewportView(jTextAreaTratamento);

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTablePaciente.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTablePaciente);
        if (jTablePaciente.getColumnModel().getColumnCount() > 0) {
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMedico.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTableMedico);
        if (jTableMedico.getColumnModel().getColumnCount() > 0) {
            jTableMedico.getColumnModel().getColumn(0).setResizable(false);
            jTableMedico.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Paciente");

        jTableConsultorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Número"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsultorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTableConsultorio);
        if (jTableConsultorio.getColumnModel().getColumnCount() > 0) {
            jTableConsultorio.getColumnModel().getColumn(0).setResizable(false);
            jTableConsultorio.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelMedico.setText("Médico");

        jLabelConsultorio.setText("Consultório");

        jButtonAtualizarTabelas.setText("Atualizar Tabelas");
        jButtonAtualizarTabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarTabelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPeriodo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelRelatorio)
                                .addGap(186, 186, 186)
                                .addComponent(jLabelTratamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonSalvar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonLimpar)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonAtualizarTabelas)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addGap(183, 183, 183)
                                        .addComponent(jLabelMedico)
                                        .addGap(198, 198, 198)
                                        .addComponent(jLabelConsultorio)
                                        .addGap(69, 69, 69)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelId))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelPeriodo)
                                .addComponent(jTextFieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelConsultorio)
                                    .addComponent(jLabelMedico)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelRelatorio)
                                    .addComponent(jLabelTratamento)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonSalvar)
                                    .addComponent(jButtonLimpar)
                                    .addComponent(jButtonAtualizarTabelas))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonEditar)
                        .addGap(341, 341, 341))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPeriodoActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextAreaRelatorio.setText("");
        jTextAreaTratamento.setText("");
        jTextFieldId.setText("");
        jTextFieldPeriodo.setText("");
        jTableConsultorio.clearSelection();
        jTableMedico.clearSelection();
        jTablePaciente.clearSelection();
        jTableConsulta.clearSelection();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Consulta consulta = new Consulta();
        int linhaP,linhaM,linhaC;
        
        int id = 0;
        try {
        id = Integer.parseInt(jTextFieldId.getText());
        } catch(NumberFormatException ex) {
            id = 0;
        }
        consulta.setId(id);
        consulta.setTratamento(jTextAreaTratamento.getText());
        consulta.setRelatorioPaciente(jTextAreaRelatorio.getText());
        consulta.setPeriodoDeExames(jTextFieldPeriodo.getText());
        linhaP = jTablePaciente.getSelectedRow();
        if( linhaP!=-1){
          id = (int)jTablePaciente.getValueAt(linhaP, 0);
          consulta.setIdPaciente(id);
        }
        linhaM = jTableMedico.getSelectedRow();
        if( linhaM!=-1){
          id = (int)jTableMedico.getValueAt(linhaM, 0);
          consulta.setIdMedico(id);
        }
        linhaC = jTableConsultorio.getSelectedRow();
        if( linhaC!=-1){
          id = (int)jTableConsultorio.getValueAt(linhaC, 0);
          consulta.setIdConsultorio(id);
        }
        if(linhaP!=-1 && linhaM!=-1 && linhaC!=-1){
            if (consultaDAO.getById(consulta.getId())==null){
                consultaDAO.inserir(consulta);
            } else {
                consultaDAO.editar(consulta);
            }
            jButtonLimparActionPerformed(evt);   
        }
        carregarTabelaConsulta();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linhas = jTableConsulta.getSelectedRows();
        for (int pos: linhas) {
            int id = (int) jTableConsulta.getValueAt(pos, 0);
            consultaDAO.remover(id);
        }
        carregarTabelaConsulta();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int linha= jTableConsulta.getSelectedRow();
        if(linha!= -1){
            int id =(int) jTableConsulta.getValueAt(linha, 0);
            Consulta consulta = consultaDAO.getById(id);
            jTextAreaRelatorio.setText(consulta.getRelatorioPaciente());
            jTextAreaTratamento.setText(consulta.getTratamento());
            jTextFieldId.setText(consulta.getId()+"");
            jTextFieldPeriodo.setText(consulta.getPeriodoDeExames()); 
            for(int i=0;i<jTablePaciente.getRowCount();i++){ 
                int idD = (int)jTablePaciente.getValueAt(i, 0);
                if(consulta.getIdPaciente()==idD){
                    linha = i; 
                    break;
                }
            }
            jTablePaciente.setRowSelectionInterval(linha, linha);
            
            for(int i=0;i<jTableMedico.getRowCount();i++){ 
                int idD = (int)jTableMedico.getValueAt(i, 0);
                if(consulta.getIdMedico()==idD){
                    linha = i; 
                    break;
                }
            }
            jTableMedico.setRowSelectionInterval(linha, linha);
            
            for(int i=0;i<jTableConsultorio.getRowCount();i++){ 
                int idD = (int)jTableConsultorio.getValueAt(i, 0);
                if(consulta.getIdConsultorio()==idD){
                    linha = i; 
                    break;
                }
            }
            jTableConsultorio.setRowSelectionInterval(linha, linha);
        }
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jButtonAtualizarTabelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarTabelasActionPerformed
        carregarTabelaConsulta();
        carregarTabelaConsultorio();
        carregarTabelaMedico();
        carregarTabelaPaciente();
    }//GEN-LAST:event_jButtonAtualizarTabelasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizarTabelas;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConsultorio;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelPeriodo;
    private javax.swing.JLabel jLabelRelatorio;
    private javax.swing.JLabel jLabelTratamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTable jTableConsultorio;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextArea jTextAreaRelatorio;
    private javax.swing.JTextArea jTextAreaTratamento;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldPeriodo;
    // End of variables declaration//GEN-END:variables
}
