package com.contatos.revisao.command;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.service.ContatoService;

public abstract class ContatoCommand {
    
    protected Contato contato;
    protected ContatoService service;
    
    public ContatoCommand(Contato contato, ContatoService service) {
        if (contato == null) {
            throw new RuntimeException("Contato inválido");
        }
        
        if (service == null) {
            throw new RuntimeException("Service inválida");
        }
        
        this.contato = contato;
        this.service = service;
    }
    
    public abstract boolean executar();
    public abstract boolean valido();
    
}
