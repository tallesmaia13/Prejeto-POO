package com.ifpb.projeto.modelo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private String email;
    private String nome;
    private LocalDate nascimento;
    private char sexo;
    private String senha;
    private List<Movimentacao> movimentacoes;

    public Usuario() {
        movimentacoes = new LinkedList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public boolean confirmaSenha(String senha, String confirmacao) {
        if (senha.equals(confirmacao)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nome=" + nome
                + ", nascimento=" + nascimento + ", sexo=" + sexo + ", senha=" + senha + '}';
    }

    public void salvarMovimentacao(Movimentacao m) {
        movimentacoes.add(m);
    }

    public void listarMovimentacoes() {
        if (movimentacoes.isEmpty()) {
            System.out.println("O usuário não registrou nenhuma movimentação.");
        } else {
            for (Movimentacao m : movimentacoes) {
                System.out.println(m.toString());
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.nascimento);
        hash = 67 * hash + this.sexo;
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.movimentacoes);
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
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.movimentacoes, other.movimentacoes)) {
            return false;
        }
        return true;
    }

}
