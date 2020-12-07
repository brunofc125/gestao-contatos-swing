/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contatos.revisao.presenter.state;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;

/**
 *
 * @author bruno
 */
public class EdicaoManterPresenter extends ManterPresenterState {
    
    public EdicaoManterPresenter(ManterContatoPresenter presenter, ContatoService contatoService) {
        super(presenter, contatoService);
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
        validate(contato);
        //salvar
        presenter.setState(new EdicaoManterPresenter(presenter, contatoService));
    }
    
    
    private void validate(Contato contato) {
        // validar insercao
    }
    
}
