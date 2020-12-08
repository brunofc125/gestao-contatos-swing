package com.contatos.revisao.presenter.state;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;

public abstract class ManterPresenterState {
    
    protected ManterContatoPresenter presenter;
    protected ContatoService contatoService;
    
    public ManterPresenterState(ManterContatoPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void salvar() {
        
    }
    
    public void editar() {
        
    }
    
    public void excluir() {
        
    }
    
    public void cancelar() {
       presenter.getView().setVisible(false);
       presenter.getView().dispose();
    }
    
    protected Contato getDados() {
        String nome = presenter.getView().getTxtNome().getText();
        String telefone = presenter.getView().getTxtTelefone().getText();
        Contato contato = presenter.getContato();
        contato.setNome(nome);
        contato.setTelefone(telefone);
        return contato;
    }
    
    protected void setDados(Contato contato) {
        presenter.getView().getTxtNome().setText(contato.getNome());
        presenter.getView().getTxtTelefone().setText(contato.getTelefone());
    }
    
    protected void disableCampos() {
        presenter.getView().getTxtNome().setEditable(false);
        presenter.getView().getTxtTelefone().setEditable(false);
    }
    
    protected void enableCampos() {
        presenter.getView().getTxtNome().setEditable(true);
        presenter.getView().getTxtTelefone().setEditable(true);
    }
    
}
