package com.contatos.revisao.presenter.state;

import com.contatos.revisao.command.EditarContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;
import java.awt.event.ActionListener;

public class EdicaoManterPresenter extends ManterPresenterState {
    
    public EdicaoManterPresenter(ManterContatoPresenter presenter) {
        super(presenter);
        init();
    }
    
    private void init() {
        presenter.getView().getBtnExcluir().setVisible(false);
        presenter.getView().getBtnSalvar().setText("Salvar");
        
        for(ActionListener ae : presenter.getView().getBtnSalvar().getActionListeners()) {
           presenter.getView().getBtnSalvar().removeActionListener(ae);
        }
        
        for(ActionListener ae : presenter.getView().getBtnFechar().getActionListeners()) {
            presenter.getView().getBtnFechar().removeActionListener(ae);
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
        presenter.setCommand(new EditarContatoCommand(contato, new ContatoService()));
        if(presenter.getCommand().executar()) {
            presenter.setState(new VisualizacaoManterPresenter(presenter, contato));
        }
    }
    
}
