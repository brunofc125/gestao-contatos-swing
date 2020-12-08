package com.contatos.revisao.presenter;

import com.contatos.revisao.view.PrincipalView;

public class PrincipalPresenter {

    private PrincipalView view;
    private ConsultarContatosPresenter consultarContatosPresenter = null;
    private ManterContatoPresenter manterContatoPresenter = null;
    
    public PrincipalPresenter() {
        this.view = new PrincipalView();
        
        this.view.getItemConsultarContatos().addActionListener((ae) -> {
            this.consultarContatosPresenter = new ConsultarContatosPresenter(this.view.getDesktop());
            if (manterContatoPresenter != null) {
                this.manterContatoPresenter.attachObserver(this.consultarContatosPresenter);
            }
        });
        
        this.view.getItemIncluirContatos().addActionListener((ae) -> {
            this.manterContatoPresenter = new ManterContatoPresenter(this.view.getDesktop());
            if (this.consultarContatosPresenter != null) {
                this.manterContatoPresenter.attachObserver(this.consultarContatosPresenter);
            }
        });
        
        this.view.setVisible(true);
    } 
    
}
