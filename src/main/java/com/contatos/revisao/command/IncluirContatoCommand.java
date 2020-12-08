package com.contatos.revisao.command;

import com.contatos.revisao.model.Contato;
import com.contatos.revisao.service.ContatoService;
import javax.swing.JOptionPane;

public class IncluirContatoCommand extends ContatoCommand {
    
    public IncluirContatoCommand(Contato contato, ContatoService service) {
        super(contato, service);
    }

    @Override
    public boolean executar() {
        if (valido()) {
            try {
                service.insert(contato);
                JOptionPane.showMessageDialog(null, "Contato incluído com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return false;
    }

    @Override
    public boolean valido() {
        if (contato == null || contato.getId() != null) {
            JOptionPane.showMessageDialog(null, "Contato inválido para inserção", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (contato.getNome() == null || contato.getNome().isBlank()) {
            JOptionPane.showMessageDialog(null, "O contato deve possuir o campo nome preenchido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (contato.getTelefone() == null || contato.getTelefone().isBlank() || contato.getTelefone().replaceAll("[()-]*", "").isBlank()) {
            JOptionPane.showMessageDialog(null, "O contato deve possuir o campo telefone preenchido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
    }
    
}
