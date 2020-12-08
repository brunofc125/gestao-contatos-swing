package com.contatos.revisao.presenter;

import com.contatos.revisao.service.ContatoService;

public class PrincipalPresenter {

    public static void main(String[] args) {
        ContatoService cs = new ContatoService();
        
        try {
            cs.delete(6L);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
