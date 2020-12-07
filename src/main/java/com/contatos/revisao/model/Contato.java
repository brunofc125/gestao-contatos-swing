package com.contatos.revisao.model;

/**
 *
 * @author clayton
 */
public class Contato {

    private Long id;
    private String nome;
    private String telefone;

    public Contato() {
    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   
    
    

}
