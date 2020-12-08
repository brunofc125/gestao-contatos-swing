package com.contatos.revisao.presenter.state;

import com.contatos.revisao.command.ExcluirContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;

public class VisualizacaoManterPresenter extends ManterPresenterState {
    
    public VisualizacaoManterPresenter(ManterContatoPresenter presenter, Contato contato) {
        super(presenter);
        init(contato);
    }
    
    private void init(Contato contato) {
        setDados(contato);
        disableCampos();
        presenter.getView().getBtnSalvar().setText("Habilitar Edição");
        presenter.getView().getBtnSalvar().addActionListener((ae) -> {
            editar();
        });
        presenter.getView().getBtnFechar().addActionListener((ae) -> {
            cancelar();
        });
    }
    
    @Override
    public void excluir() {
        Contato contato = getDados();
        presenter.setCommand(new ExcluirContatoCommand(contato, new ContatoService()));
        presenter.getCommand().executar();
        cancelar();
    }
    
    @Override
    public void editar() {
        enableCampos();
        presenter.setState(new EdicaoManterPresenter(presenter));
    }
    
}
