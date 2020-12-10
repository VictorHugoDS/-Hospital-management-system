package hospital.management.system.telas;

public class PrincipalJFrame extends javax.swing.JFrame {
    public PrincipalJFrame() {
        initComponents();
        conteudoJPanel.add(new JPanelPaciente());
        jMenu.setText("Pacientes");
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conteudoJPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItemPaciente = new javax.swing.JMenuItem();
        jMenuItemConsulta = new javax.swing.JMenuItem();
        jMenuItemMedicos = new javax.swing.JMenuItem();
        jMenuItemEnfermeiros = new javax.swing.JMenuItem();
        jMenuItemInternacao = new javax.swing.JMenuItem();
        jMenuItemLeitos = new javax.swing.JMenuItem();
        jMenuItemObservacao = new javax.swing.JMenuItem();
        jMenuItemAmbulatorio = new javax.swing.JMenuItem();
        jMenuItemConsultorio = new javax.swing.JMenuItem();
        jMenuItemFuncionarioHospital = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        conteudoJPanel.setLayout(new javax.swing.BoxLayout(conteudoJPanel, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(conteudoJPanel);

        jMenu.setText("Fichas");

        jMenuItemPaciente.setText("Pacientes");
        jMenuItemPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPacienteActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemPaciente);

        jMenuItemConsulta.setText("Consultas");
        jMenuItemConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemConsulta);

        jMenuItemMedicos.setText("Medicos");
        jMenuItemMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMedicosActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemMedicos);

        jMenuItemEnfermeiros.setText("Enfermeiros");
        jMenuItemEnfermeiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnfermeirosActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemEnfermeiros);

        jMenuItemInternacao.setText("Internações");
        jMenuItemInternacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInternacaoActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemInternacao);

        jMenuItemLeitos.setText("Leitos");
        jMenuItemLeitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLeitosActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemLeitos);

        jMenuItemObservacao.setText("Observações");
        jMenuItemObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemObservacaoActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemObservacao);

        jMenuItemAmbulatorio.setText("Ambulatórios");
        jMenuItemAmbulatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAmbulatorioActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemAmbulatorio);

        jMenuItemConsultorio.setText("Consultorios");
        jMenuItemConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultorioActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemConsultorio);

        jMenuItemFuncionarioHospital.setText("Funcionarios do Hospital");
        jMenuItemFuncionarioHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioHospitalActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemFuncionarioHospital);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultorioActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelConsultorio());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Consultórios");
    }//GEN-LAST:event_jMenuItemConsultorioActionPerformed

    private void jMenuItemFuncionarioHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioHospitalActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelFuncionarioHospital());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Funcionários");
    }//GEN-LAST:event_jMenuItemFuncionarioHospitalActionPerformed

    private void jMenuItemEnfermeirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnfermeirosActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelEnfermeiro());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Enfermeiros");
    }//GEN-LAST:event_jMenuItemEnfermeirosActionPerformed

    private void jMenuItemMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMedicosActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelMedico());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Medicos");
    }//GEN-LAST:event_jMenuItemMedicosActionPerformed

    private void jMenuItemLeitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLeitosActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelLeito());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Leitos");
    }//GEN-LAST:event_jMenuItemLeitosActionPerformed

    private void jMenuItemInternacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInternacaoActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelInternacao());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Internações");
    }//GEN-LAST:event_jMenuItemInternacaoActionPerformed

    private void jMenuItemConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaActionPerformed
       conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelConsulta());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Consultas");
    }//GEN-LAST:event_jMenuItemConsultaActionPerformed

    private void jMenuItemPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPacienteActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelPaciente());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Pacientes");
    }//GEN-LAST:event_jMenuItemPacienteActionPerformed

    private void jMenuItemAmbulatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAmbulatorioActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelAmbulatorio());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }//GEN-LAST:event_jMenuItemAmbulatorioActionPerformed

    private void jMenuItemObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemObservacaoActionPerformed
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new JPanelObservacao());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
        jMenu.setText("Observações");
    }//GEN-LAST:event_jMenuItemObservacaoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conteudoJPanel;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAmbulatorio;
    private javax.swing.JMenuItem jMenuItemConsulta;
    private javax.swing.JMenuItem jMenuItemConsultorio;
    private javax.swing.JMenuItem jMenuItemEnfermeiros;
    private javax.swing.JMenuItem jMenuItemFuncionarioHospital;
    private javax.swing.JMenuItem jMenuItemInternacao;
    private javax.swing.JMenuItem jMenuItemLeitos;
    private javax.swing.JMenuItem jMenuItemMedicos;
    private javax.swing.JMenuItem jMenuItemObservacao;
    private javax.swing.JMenuItem jMenuItemPaciente;
    // End of variables declaration//GEN-END:variables
}
