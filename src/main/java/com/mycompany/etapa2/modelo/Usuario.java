package com.mycompany.etapa2.modelo;

import com.mycompany.etapa2.excecoes.CadastroException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

/**
 * Classe modelo para usuários da aplicação
 * @author Flavio
 */

public class Usuario implements Serializable {

    private String nome;
    private String sexo;
    private LocalDate nascimento;
    private String email;
    private String senha;
    private List<Movimentacao> movimentacoes;

    /**
     * Construtor de Usuario
     * @param nome nome do usuário
     * @param sexo sexo do usuário
     * @param nascimento Data de nascimento do usuário
     * @param email Email do usuário
     * @param senha  Senha do usuário
     */
    public Usuario(String nome, String sexo, LocalDate nascimento, String email, String senha) {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.email = email;
        this.senha = senha;
        movimentacoes = new ArrayList<>();
    }

    /**
     * Constutor sem parâmetros de usuário, apenas instancia a lista de movimentações
     */
    public Usuario() {
        movimentacoes = new ArrayList<>();
    }
    
    /**
     * Busca o nome de um usuário
     * @return retorna o nome do usuário
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Altera ou salva o nome do usuário
     * @param nome é o nome passado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Busca o sexo do usuário
     * @return  retorna o sexo
     */
    public String getSexo() {
        return sexo;
    }
    
    /**
     * Altera ou salva o sexo do usuário
     * @param sexo é o sexo do usuário
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Busca a data de nascimento do usuário
     * @return retorna a data de nascimento do usuário
     */
    public LocalDate getNascimento() {
        return nascimento;
    }
    
    /**
     * Altera ou salva a data de nascimento de um usuário
     * @param nascimento data de nascimento passada
     */
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    /**
     * Busca o email do usuário
     * @return retorna o email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Altera ou salva o email de um usuário
     * @param email é o email passado
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Busca a senha do usuário
     * @return retorna a senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Altera ou salva a senha de um usuário
     * @param senha é a senha informada
     */    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Busca as movimentações daquele usuário
     * @return retorna uma lista de movimentações
     */
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }
    
    /**
     * Salva as movimentações daquele usuário
     * @param movimentacoes é a lista de movimentações que serão salvas
     */
    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
    
    /**
     * Salva uma movimentação na lista de movimentações
     * @param m é a movimentação que será salva
     * @return retorna verdadeiro ou falso de acordo com o resultado do método 'add'
     */
    public boolean salvarMov(Movimentacao m) {

        return movimentacoes.add(m);
    }
    
    /**
     * Deleta uma movimentação específica
     * @param m é a movimentação que será deletada
     * @return retorna o resultado do metodo 'remove', verdadeiro ou falso.
     */
    public boolean deletarMov(Movimentacao m){
        return movimentacoes.remove(m);
    }
    
    /**
     * Atualiza uma determinada movimentação
     * @param atual é a movimentação que está salva na lista
     * @param nova é a movimentação que será salva no lugar da atual
     * @return retorna verdadeiro ou falso, caso seja salva ou não
     * @throws CadastroException 
     */
    public boolean atualizarMov(Movimentacao atual, Movimentacao nova) throws CadastroException {

        if (nova.getDescricao().equals("")) {
            throw new CadastroException("Preencha todos os campos!");
        } else {
            for (int k = 0; k < movimentacoes.size(); k++) {
                if (movimentacoes.get(k).equals(atual)) {
                    movimentacoes.set(k, nova);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.sexo);
        hash = 89 * hash + Objects.hashCode(this.nascimento);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.senha);
        hash = 89 * hash + Objects.hashCode(this.movimentacoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.movimentacoes, other.movimentacoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", sexo=" + sexo + ", nascimento=" + nascimento + ", email=" + email + ", senha=" + senha + ", movimentacoes=" + movimentacoes + '}';
    }

}
