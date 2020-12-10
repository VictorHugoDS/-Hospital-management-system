package hospital.management.system.telas;

import hospital.management.system.entidades.Medico;
import hospital.management.system.persistencia.MedicoDAO;
import hospital.management.system.utils.DAOFactory;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JPanelMedico extends javax.swing.JPanel {
    private MedicoDAO medicoDAO = DAOFactory.createMedicoDAO();

    public JPanelMedico() {
        initComponents();
        carregarTabela();
    }
    
    public void carregarTabela() {
        List<Medico> medicos = medicoDAO.listar();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        
        for (Medico medico: medicos) {
            Object[] linha = new Object[10];
            linha[0] = medico.getId();
            linha[1] = medico.getNome();
            linha[2] = medico.getFuncao();
            linha[3] = medico.getCpf();
            linha[4] = medico.getSalario();
            linha[5] = medico.getHorario();
            linha[6] = medico.getTelefone();
            linha[7] = medico.getHorarioPlantao();
            linha[8] = medico.getCrm();
            linha[9] = medico.getEspecialidade();
            
            modeloTabela.addRow(linha);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelFuncao = new javax.swing.JLabel();
        jTextFieldFuncao = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jLabelSalario = new javax.swing.JLabel();
        jTextFieldSalario = new javax.swing.JTextField();
        jLabelHorario = new javax.swing.JLabel();
        jTextFieldHorario = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabelHorarioPlantao = new javax.swing.JLabel();
        jTextFieldHorarioPlantao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCrm = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelEspecialidade = new javax.swing.JLabel();
        jTextFieldEspecialidade = new javax.swing.JTextField();
        jLabelEnfermeiro1 = new javax.swing.JLabel();

        jLabelNome.setText("Nome:");

        jLabelFuncao.setText("Função:");

        jLabelId.setText("ID:");

        jTextFieldId.setEditable(false);

        jLabelCpf.setText("CPF:");

        jTextFieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCpfActionPerformed(evt);
            }
        });

        jLabelSalario.setText("Salário:");

        jLabelHorario.setText("Horário:");

        jTextFieldHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorarioActionPerformed(evt);
            }
        });

        jLabelTelefone.setText("Telefone:");

        jLabelHorarioPlantao.setText("Horário do Plantão:");

        jTextFieldHorarioPlantao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorarioPlantaoActionPerformed(evt);
            }
        });

        jLabel1.setText("CRM:");

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

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Função", "CPF", "Salário", "Horário", "Telefone", "Horário do Plantão", "CRM", "Especialidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabelEspecialidade.setText("Especialidade:");

        jLabelEnfermeiro1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEnfermeiro1.setText("Enfermeiros");
        jLabelEnfermeiro1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonEditar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCrm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonSalvar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonLimpar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelHorarioPlantao)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldHorarioPlantao, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelHorario)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextFieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelSalario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelEspecialidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 636, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFuncao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelEnfermeiro1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelId))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNome)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelFuncao)
                        .addComponent(jTextFieldFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTelefone)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCpf)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHorarioPlantao)
                    .addComponent(jTextFieldHorarioPlantao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorario)
                    .addComponent(jTextFieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalario)
                    .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEspecialidade)
                    .addComponent(jTextFieldEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonLimpar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelEnfermeiro1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCpfActionPerformed

    }//GEN-LAST:event_jTextFieldCpfActionPerformed

    private void jTextFieldHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorarioActionPerformed

    }//GEN-LAST:event_jTextFieldHorarioActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Medico medico = new Medico();
        
        int id = 0;
        try {
        id = Integer.parseInt(jTextFieldId.getText());
        } catch(NumberFormatException ex) {
            id = 0;
        }
        medico.setId(id);
        medico.setNome(jTextFieldNome.getText());
        medico.setFuncao(jTextFieldFuncao.getText());
        medico.setCpf(jTextFieldCpf.getText());
        medico.setHorario(jTextFieldHorario.getText());
        medico.setSalario(Double.parseDouble(jTextFieldSalario.getText()));
        medico.setTelefone(jTextFieldTelefone.getText());
        medico.setHorarioPlantao(jTextFieldHorarioPlantao.getText());
        medico.setCrm(Integer.parseInt(jTextFieldCrm.getText()));
        medico.setEspecialidade(jTextFieldEspecialidade.getText());
        
        if (medicoDAO.getById(medico.getId()) == null) {
            medicoDAO.inserir(medico);
        } else {
            medicoDAO.editar(medico);
        }
        
        carregarTabela();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldId.setText("");
        jTextFieldNome.setText("");
        jTextFieldCpf.setText("");
        jTextFieldFuncao.setText("");
        jTextFieldSalario.setText("");
        jTextFieldHorario.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldHorarioPlantao.setText("");
        jTextFieldCrm.setText("");
        jTextFieldEspecialidade.setText("");
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int linha = jTable.getSelectedRow();

        if (linha >= 0) {
            jTextFieldId.setText(jTable.getValueAt(linha, 0) + "");
            jTextFieldNome.setText(jTable.getValueAt(linha, 1) + "");
            jTextFieldFuncao.setText(jTable.getValueAt(linha, 2) + "");
            jTextFieldCpf.setText(jTable.getValueAt(linha, 3) + "");
            jTextFieldSalario.setText(jTable.getValueAt(linha, 4) + "");
            jTextFieldHorario.setText(jTable.getValueAt(linha, 5) + "");
            jTextFieldTelefone.setText(jTable.getValueAt(linha, 6) + "");
            jTextFieldHorarioPlantao.setText(jTable.getValueAt(linha, 7) + "");
            jTextFieldCrm.setText(jTable.getValueAt(linha, 8) + "");
            jTextFieldEspecialidade.setText(jTable.getValueAt(linha, 9) + "");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linhas = jTable.getSelectedRows();
        for (int pos: linhas) {
            medicoDAO.remover((int) jTable.getValueAt(pos, 0));
        }
        carregarTabela();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldHorarioPlantaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorarioPlantaoActionPerformed

    }//GEN-LAST:event_jTextFieldHorarioPlantaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelEnfermeiro1;
    private javax.swing.JLabel jLabelEspecialidade;
    private javax.swing.JLabel jLabelFuncao;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelHorarioPlantao;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldCrm;
    private javax.swing.JTextField jTextFieldEspecialidade;
    private javax.swing.JTextField jTextFieldFuncao;
    private javax.swing.JTextField jTextFieldHorario;
    private javax.swing.JTextField jTextFieldHorarioPlantao;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSalario;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
