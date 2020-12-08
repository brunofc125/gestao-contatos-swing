package com.contatos.revisao.command;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.service.ContatoService;
import javax.swing.JOptionPane;

public class EditarContatoCommand extends ContatoCommand {
    
    public EditarContatoCommand(Contato contato, ContatoService service) {
        super(contato, service);
    }

    @Override
    public void executar() {
        if (valido()) {
            try {
                service.update(contato);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public boolean valido() {
        if (contato == null || contato.getId() == null) {
            JOptionPane.showMessageDialog(null, "Contato inválido para atualização", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (contato.getNome() == null || contato.getNome().isBlank()) {
            JOptionPane.showMessageDialog(null, "O contato deve possuir o campo nome preenchido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (contato.getTelefone() == null || contato.getTelefone().isBlank()) {
            JOptionPane.showMessageDialog(null, "O contato deve possuir o campo telefone preenchido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
    }
    
}
