package com.contatos.revisao.presenter;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.observer.IObserverContato;
import com.contatos.revisao.service.ContatoService;
import com.contatos.revisao.view.ConsultarContatosView;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ConsultarContatosPresenter extends BaseInternalFramePresenter<ConsultarContatosView> implements IObserverContato {

    private DefaultTableModel tmContatos;
    private ContatoService contatoService;
    private ManterContatoPresenter subject;

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
            JOptionPane.showMessageDialog(null, "Erro ao carregar os contatos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        view.getTblContatos().setModel(tmContatos);
        
        view.getBtnVisualizar().addActionListener((ae) -> {
            int linhaSelecionada = view.getTblContatos().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Contato contato = new Contato();
                
                contato.setId((Long) tmContatos.getValueAt(linhaSelecionada, 0));
                
                this.subject = new ManterContatoPresenter(contato, desktop);
                this.subject.attachObserver(this);
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
        if (this.subject != null) {
            this.subject.detachObserver(this);
        }
    }

    @Override
    public void update() {
        try {
            tmContatos.setRowCount(0);
            List<Contato> contatos = contatoService.getAll();
            for(Contato contato : contatos) {
                tmContatos.addRow(new Object[]{ contato.getId(), contato.getNome(), contato.getTelefone() });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os contatos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
