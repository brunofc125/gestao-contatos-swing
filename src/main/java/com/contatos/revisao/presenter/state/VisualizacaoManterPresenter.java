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
public class VisualizacaoManterPresenter extends ManterPresenterState {
    
    public VisualizacaoManterPresenter(ManterContatoPresenter presenter, ContatoService contatoService, Contato contato) {
        super(presenter, contatoService);
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
        // excluir
    }
    
    @Override
    public void editar() {
        enableCampos();
        presenter.setState(new EdicaoManterPresenter(presenter, contatoService));
    }
    
    
}
