package com.contatos.revisao.presenter;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.presenter.state.InclusaoManterPresenter;
import com.contatos.revisao.presenter.state.ManterPresenterState;
import com.contatos.revisao.presenter.state.VisualizacaoManterPresenter;
import com.contatos.revisao.service.ContatoService;
import com.contatos.revisao.view.ConsultarContatosView;
import com.contatos.revisao.view.ManterContatoView;
import javax.swing.JDesktopPane;

/**
 *
 * @author clayton
 */
public class ManterContatoPresenter extends BaseInternalFramePresenter<ManterContatoView> {

    private ManterPresenterState state;
    private Contato contato;
    private final ContatoService contatoService;

    public ManterContatoPresenter(ContatoService contatoService, JDesktopPane desktop) {
        super(desktop, new ManterContatoView());
        ManterContatoView view = getView();

        this.contato = new Contato();
        this.contatoService = new ContatoService();
        this.setState(new InclusaoManterPresenter(this, this.contatoService));
        view.setVisible(true);
    }

    public ManterContatoPresenter(Contato contato, ContatoService contatoService, JDesktopPane desktop) {
        super(desktop, new ManterContatoView());
        if (contato == null) {
            throw new RuntimeException("Contato não informado");
        }
        this.contato = contato;
        this.contatoService = new ContatoService();
        this.setState(new VisualizacaoManterPresenter(this, this.contatoService));
        getView().setVisible(true);
    }

    public ManterPresenterState getState() {
        return state;
    }

    public Contato getContato() {
        return contato;
    }

//    private void fechar() {
//        view.dispose();
//    }
//
//    private void salvar() {
//        String nome = view.getTxtNome().getText();
//        String telefone = view.getTxtTelefone().getText();
//
//        Contato contato = new Contato(nome, telefone);
//
//        contatos.add(contato);
//
//        JOptionPane.showMessageDialog(view,
//                "Contato " + contato.getNome() + " salvo com sucesso!",
//                "Salvo com sucesso",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
    public void setState(ManterPresenterState state) {
        this.state = state;
    }

}
