package com.contatos.revisao.command;

import com.contatos.revisao.model.Contato;

public abstract class ContatoCommand {
    
    protected Contato contato;
    
    public ContatoCommand(Contato contato) {
        if (contato == null) {
            throw new RuntimeException("Contato inválido");
        }
        this.contato = contato;
    }
    
    public abstract void executar();
    
}
