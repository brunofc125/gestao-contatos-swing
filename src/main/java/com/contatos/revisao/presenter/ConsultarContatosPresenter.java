package com.contatos.revisao.presenter;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.service.ContatoService;
import com.contatos.revisao.view.ConsultarContatosView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ConsultarContatosPresenter extends BaseInternalFramePresenter<ConsultarContatosView> {

    private DefaultTableModel tmContatos;
    private ContatoService contatoService;

    public ConsultarContatosPresenter(JDesktopPane desktop) {
        super(desktop, new ConsultarContatosView());
        ConsultarContatosView view = getView();
        contatoService = new ContatoService();

        tmContatos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tmContatos.setDataVector(new Object[][]{}, new String[]{"Identificador", "Nome", "Telefone"});

        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tmContatos.setNumRows(0);
        
        try {
            List<Contato> contatos = contatoService.getAll();
            for(Contato contato : contatos) {
                tmContatos.addRow(new Object[]{ contato.getId(), contato.getNome(), contato.getTelefone() });
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsultarContatosPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        view.getTblContatos().setModel(tmContatos);
        
        view.getBtnVisualizar().addActionListener((ae) -> {
            int linhaSelecionada = view.getTblContatos().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Contato contato = new Contato();
                
                contato.setId((Long) tmContatos.getValueAt(linhaSelecionada, 0));
                
                new ManterContatoPresenter(contato, desktop);
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar um contato", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        view.getBtnFechar().addActionListener((ae) -> {
            fechar();
        });

        view.setVisible(true);
    }

    private void fechar() {
        getView().dispose();
    }

}
