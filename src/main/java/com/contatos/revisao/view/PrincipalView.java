/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contatos.revisao.view;

import com.contatos.revisao.presenter.ConsultarContatosPresenter;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author clayton
 */
public class PrincipalView extends JFrame {

    /**
     * Creates new form Principal
     */

    public PrincipalView() {
        initComponents();

        setState(JFrame.ICONIFIED);
        this.setLocationRelativeTo(this.getParent());
        this.setExtendedState(MAXIMIZED_BOTH);

        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        mbPrincipal = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        itemIncluirContatos = new javax.swing.JMenuItem();
        itemConsultarContatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Contatos");

        menuOpcoes.setText("Opções");

        itemIncluirContatos.setText("Incluir contatos");
        itemIncluirContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIncluirContatosActionPerformed(evt);
            }
        });
        menuOpcoes.add(itemIncluirContatos);

        itemConsultarContatos.setText("Consultar contatos");
        itemConsultarContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarContatosActionPerformed(evt);
            }
        });
        menuOpcoes.add(itemConsultarContatos);

        mbPrincipal.add(menuOpcoes);

        setJMenuBar(mbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemConsultarContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarContatosActionPerformed
        new ConsultarContatosPresenter(getDesktop());
    }//GEN-LAST:event_itemConsultarContatosActionPerformed

    private void itemIncluirContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIncluirContatosActionPerformed

        new ManterContatoPresenter(new ContatoService(), getDesktop());

    }//GEN-LAST:event_itemIncluirContatosActionPerformed

    
    
    /**
     * @param args the command line arguments
     */

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public JMenuItem getItemConsultarContatos() {
        return itemConsultarContatos;
    }

    public JMenuItem getItemIncluirContatos() {
        return itemIncluirContatos;
    }

    public JMenuBar getMbPrincipal() {
        return mbPrincipal;
    }

    public JMenu getMenuOpcoes() {
        return menuOpcoes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem itemConsultarContatos;
    private javax.swing.JMenuItem itemIncluirContatos;
    private javax.swing.JMenuBar mbPrincipal;
    private javax.swing.JMenu menuOpcoes;
    // End of variables declaration//GEN-END:variables
}
