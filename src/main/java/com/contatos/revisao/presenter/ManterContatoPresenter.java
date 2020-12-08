package com.contatos.revisao.presenter;

import com.contatos.revisao.command.ContatoCommand;
import com.contatos.revisao.model.Contato;
import com.contatos.revisao.observer.IObserverContato;
import com.contatos.revisao.observer.ISubjectContato;
import com.contatos.revisao.presenter.state.InclusaoManterPresenter;
import com.contatos.revisao.presenter.state.ManterPresenterState;
import com.contatos.revisao.presenter.state.VisualizacaoManterPresenter;
import com.contatos.revisao.service.ContatoService;
import com.contatos.revisao.view.ManterContatoView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ManterContatoPresenter extends BaseInternalFramePresenter<ManterContatoView> implements ISubjectContato {

    private ManterPresenterState state;
    private Contato contato;
    private ContatoCommand command;
    private ContatoService contatoService;
    private List<IObserverContato> observers;

    public ManterContatoPresenter(JDesktopPane desktop) {
        super(desktop, new ManterContatoView());
        ManterContatoView view = getView();
        observers = new ArrayList<>();

        this.contato = new Contato();
        this.setState(new InclusaoManterPresenter(this));
        view.setVisible(true);
    }

    public ManterContatoPresenter(Contato contato, JDesktopPane desktop) {
        super(desktop, new ManterContatoView());
        if (contato == null) {
            throw new RuntimeException("Contato não informado");
        }
        
        observers = new ArrayList<>();
        
        this.contatoService = new ContatoService();
        
        try {
            this.contato = contatoService.get(contato.getId());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        this.setState(new VisualizacaoManterPresenter(this, this.contato));
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

    @Override
    public void attachObserver(IObserverContato observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(IObserverContato observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserverContato observer : observers) {
            observer.update();
        }
    }

}
