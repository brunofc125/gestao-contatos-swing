package com.contatos.revisao.presenter;

import com.contatos.revisao.command.ContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.state.InclusaoManterPresenter;
import com.contatos.revisao.presenter.state.ManterPresenterState;
import com.contatos.revisao.presenter.state.VisualizacaoManterPresenter;
import com.contatos.revisao.view.ManterContatoView;
import javax.swing.JDesktopPane;

public class ManterContatoPresenter extends BaseInternalFramePresenter<ManterContatoView> {

    private ManterPresenterState state;
    private Contato contato;
    private ContatoCommand command;

    public ManterContatoPresenter(JDesktopPane desktop) {
        super(desktop, new ManterContatoView());
        ManterContatoView view = getView();

        this.contato = new Contato();
        this.setState(new InclusaoManterPresenter(this));
        view.setVisible(true);
    }

    public ManterContatoPresenter(Contato contato, JDesktopPane desktop) {
        super(desktop, new ManterContatoView());
        if (contato == null) {
            throw new RuntimeException("Contato não informado");
        }
        this.contato = contato;
        this.setState(new VisualizacaoManterPresenter(this));
        getView().setVisible(true);
    }

    public ManterPresenterState getState() {
        return state;
    }

    public Contato getContato() {
        return contato;
    }

    public void setState(ManterPresenterState state) {
        this.state = state;
    }

    public ContatoCommand getCommand() {
        return command;
    }

    public void setCommand(ContatoCommand command) {
        this.command = command;
    }

}
