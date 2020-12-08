package com.contatos.revisao.presenter.state;

import com.contatos.revisao.command.ExcluirContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.ManterContatoPresenter;
import com.contatos.revisao.service.ContatoService;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class VisualizacaoManterPresenter extends ManterPresenterState {
    
    public VisualizacaoManterPresenter(ManterContatoPresenter presenter, Contato contato) {
        super(presenter);
        init(contato);
    }
    
    private void init(Contato contato) {
        setDados(contato);
        disableCampos();
        presenter.getView().getBtnSalvar().setText("Habilitar Edição");
        presenter.getView().getBtnExcluir().setVisible(true);
        
        JButton btnSalvar = presenter.getView().getBtnSalvar();
        JButton btnExcluir = presenter.getView().getBtnExcluir();
        JButton btnFechar = presenter.getView().getBtnFechar();
        
        for(ActionListener ae : btnSalvar.getActionListeners()) {
            btnSalvar.removeActionListener(ae);
        }
        
        for(ActionListener ae : btnExcluir.getActionListeners()) {
            btnExcluir.removeActionListener(ae);
        }
        
        for(ActionListener ae : btnFechar.getActionListeners()) {
            btnFechar.removeActionListener(ae);
        }
        
        presenter.getView().getBtnSalvar().addActionListener((ae) -> {
            editar();
        });
        
        presenter.getView().getBtnExcluir().addActionListener((ae) -> {
            excluir();
        });
        
        presenter.getView().getBtnFechar().addActionListener((ae) -> {
            cancelar();
        });
    }
    
    @Override
    public void excluir() {
        Contato contato = getDados();
        presenter.setCommand(new ExcluirContatoCommand(contato, new ContatoService()));
        if (presenter.getCommand().executar()) {
            presenter.notifyObservers();
            cancelar();
        }
    }
    
    @Override
    public void editar() {
        enableCampos();
        presenter.setState(new EdicaoManterPresenter(presenter));
    }
    
}
