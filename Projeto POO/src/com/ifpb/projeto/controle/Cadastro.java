package com.ifpb.projeto.controle;

import com.ifpb.projeto.modelo.Movimentacao;
import com.ifpb.projeto.modelo.Usuario;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cadastro {

    private List<Usuario> usuarios;

    public Cadastro() {
        usuarios = new LinkedList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean salvar(Usuario u) {
        
        usuarios.add(u);
        return true;
    }

    public boolean removerUsuario(String email, String senha) {
        if (usuarios.remove(localizar(email, senha))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean autenticar(String email, String senha) {
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public Usuario localizar(String email, String senha) {

        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }

    public void movimentacao(Usuario u, Movimentacao m) {
        for (Usuario user : usuarios) {
            if (user.equals(u)) {
                user.salvarMovimentacao(m);
            }
        }
    }

    public void listar(String email, String senha) {
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                user.listarMovimentacoes();
            }
        }
    }

    public void atualizarUsuario(Usuario antigo, Usuario novo) {
        for (int k = 0; k < usuarios.size(); k++) {
            if (usuarios.get(k).equals(antigo)) {
                novo.setMovimentacoes(usuarios.get(k).getMovimentacoes());
                usuarios.set(k, novo);
            }
        }
    }

    public boolean buscaEmail(String email) {
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.usuarios);
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
        final Cadastro other = (Cadastro) obj;
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        return true;
    }

}
