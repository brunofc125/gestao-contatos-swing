package com.contatos.revisao.command;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.service.ContatoService;
import javax.swing.JOptionPane;

public class ExcluirContatoCommand extends ContatoCommand {

    public ExcluirContatoCommand(Contato contato, ContatoService service) {
        super(contato, service);
    }
    
    @Override
    public void executar() {
        if (valido()) {
            try {
                service.delete(contato.getId());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public boolean valido() {
        if (contato == null || contato.getId() == null) {
            JOptionPane.showMessageDialog(null, "Contato inválido para exclusão", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
}
