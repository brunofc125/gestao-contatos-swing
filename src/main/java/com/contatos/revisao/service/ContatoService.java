package com.contatos.revisao.service;

import com.contatos.revisao.model.Contato;
import java.util.List;

public class ContatoService extends BaseService<Contato, Long> {
    
    public Contato insert(Contato contato) throws Exception {
        return super.insert(contato, Contato.class);
    }
    
    public Contato update(Contato contato) throws Exception {
        return super.update(contato, Contato.class);
    }
    
    public Contato get(Long id) throws Exception {
        return super.get(id, Contato.class);
    }
    
    public List<Contato> getAll() throws Exception {
        return super.getAll(Contato.class);
    }
    
    public void delete(Long id) throws Exception {
        super.delete(id);
    }
    
}
