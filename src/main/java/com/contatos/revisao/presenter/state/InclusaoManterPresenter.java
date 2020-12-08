package com.contatos.revisao.presenter.state;

import com.contatos.revisao.command.IncluirContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;

public class InclusaoManterPresenter extends ManterPresenterState {
    
    public InclusaoManterPresenter(ManterContatoPresenter presenter) {
        super(presenter);
        init();
    }
    
    private void init() {
        presenter.getView().getBtnExcluir().setVisible(false);
        presenter.getView().getBtnSalvar().setText("Salvar");
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
        presenter.getCommand().executar();
        cancelar();
    }
    
}
