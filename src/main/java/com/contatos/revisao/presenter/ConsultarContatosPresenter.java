package com.contatos.revisao.presenter;

import com.contatos.revisao.view.ConsultarContatosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clayton
 */
public class ConsultarContatosPresenter extends BaseInternalFramePresenter<ConsultarContatosView> {
    private DefaultTableModel tmContatos;

    public ConsultarContatosPresenter(JDesktopPane desktop) {
        super(desktop, new ConsultarContatosView());
        ConsultarContatosView view = getView();
        
        tmContatos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}
        );

        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tmContatos.setNumRows(0);
        //ListIterator<Contato> it = contatos.getContatos().listIterator();

        /*while (it.hasNext()) {
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()});
        }*/

        view.getTblContatos().setModel(tmContatos);

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

      
        view.setVisible(true);

    }

    private void fechar() {
        getView().dispose();
    }

}
