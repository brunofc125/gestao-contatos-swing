package com.contatos.revisao.presenter.state;

import com.contatos.revisao.command.IncluirContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class InclusaoManterPresenter extends ManterPresenterState {
    
    public InclusaoManterPresenter(ManterContatoPresenter presenter) {
        super(presenter);
        init();
    }
    
    private void init() {
        presenter.getView().getBtnExcluir().setVisible(false);
        presenter.getView().getBtnSalvar().setText("Salvar");
        
        JButton btnSalvar = presenter.getView().getBtnSalvar();
        JButton btnFechar = presenter.getView().getBtnFechar();
        
        for(ActionListener ae : btnSalvar.getActionListeners()) {
            btnSalvar.removeActionListener(ae);
        }
        
        for(ActionListener ae : btnFechar.getActionListeners()) {
            btnFechar.removeActionListener(ae);
        }
        
        presenter.getView().getBtnSalvar().addActionListener((ae) -> {
            salvar();
        });
        
        presenter.getView().getBtnFechar().addActionListener((ae) -> {
            cancelar();
        });
    }
    
    @Override
    public void salvar() {
        Contato contato = getDados();
        presenter.setCommand(new IncluirContatoCommand(contato, new ContatoService()));
        if (presenter.getCommand().executar()) {
            presenter.notifyObservers();
            cancelar();
        }
    }
    
}
