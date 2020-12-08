package com.contatos.revisao.command;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.service.ContatoService;
import javax.swing.JOptionPane;

public class ExcluirContatoCommand extends ContatoCommand {

    public ExcluirContatoCommand(Contato contato, ContatoService service) {
        super(contato, service);
    }
    
    @Override
    public boolean executar() {
        if (valido()) {
            try {
                service.delete(contato.getId());
                JOptionPane.showMessageDialog(null, "Contato excluído com sucesso", "Sucesso", JOptionPane.OK_OPTION);
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return false;
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
