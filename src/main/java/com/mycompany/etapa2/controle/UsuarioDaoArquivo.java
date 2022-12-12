
package com.mycompany.etapa2.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.etapa2.excecoes.CadastroException;
import com.mycompany.etapa2.excecoes.EmailException;
import com.mycompany.etapa2.modelo.Usuario;

public class UsuarioDaoArquivo {

    private File arquivo;

    /**
     * Construtor de UsuarioDaoArquivo
     *Determina que o arquivo utilizado é o usuarios.bin e instancia um novo 
     * arquivo caso ainda não exista.
     * @throws IOException
     * @throws SQLException 
     */
    public UsuarioDaoArquivo() throws IOException,SQLException {
        arquivo = new File("usuarios.bin");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    /**
     * Realiza a listagem de usuários persistidos no arquivo
     * @return uma lista com os usuários salvos no arquivo
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    
    public List<Usuario> listar() throws ClassNotFoundException, IOException {

        List<Usuario> usuarios;
        if (arquivo.length() > 0) {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(arquivo));
            usuarios = (List<Usuario>) reader.readObject();
            reader.close();
            return usuarios;

        } else {
            usuarios = new ArrayList<>();
        }
        return usuarios;
    }

    /**
     * Atualiza um usuário existente no arquivo
     * @param u o usuário que será atualizado
     * @return verdadeiro ou falso, dependendo da atualização 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws EmailException
     * @throws CadastroException
     * @throws SQLException 
     */
    public boolean atualizar(Usuario u) throws FileNotFoundException, IOException,
            ClassNotFoundException, EmailException, CadastroException,SQLException {

        List<Usuario> usuarios = listar();
        if (u.getEmail().equals("") || u.getNascimento() == null
                || u.getNome().equals("") || u.getSenha().equals("") || u.getSexo().equals("")) {
            throw new CadastroException("Preencha todos os campos!");
        }
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(arquivo));
        for (int k = 0; k < usuarios.size(); k++) {
            if (usuarios.get(k).getEmail().equals(u.getEmail())) {
                usuarios.remove(k);
                usuarios.add(u);
                writer.writeObject(usuarios);
                writer.close();
                return true;
            }
        }
        writer.close();
        return false;
    }
    
    /**
     * Realiza a autenticação de usuário no arquivo
     * @param email é o email digitado pelo usuário
     * @param senha é a senha digitada pelo usuário
     * @return null caso o usuário com este email e senha não exista ou retorna o
     * usuário, caso ele exista.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws EmailException
     * @throws SQLException 
     */
    public Usuario autenticar(String email, String senha) throws IOException, 
            FileNotFoundException, ClassNotFoundException, EmailException,SQLException {
        List<Usuario> usuarios = listar();
        if (email.equals("") && senha.equals("")) {
            throw new EmailException("Preencha todos os campos!");
        } else if (senha.equals("")) {
            throw new EmailException("Preencha o campo senha!");
        } else if (email.equals("")) {
            throw new EmailException("Preencha o campo email!");
        }
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Salva um usuário no arquivo
     * @param u é o usuário que será salvo no arquivo
     * @return verdadeiro ou falso, caso seja salvo no arquivo ou não.
     * @throws EmailException
     * @throws CadastroException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    
    public boolean salvar(Usuario u) throws EmailException, CadastroException,
            FileNotFoundException, IOException, ClassNotFoundException,SQLException {
        List<Usuario> usuarios = listar();
        if (buscar(u.getEmail()) != null) {
            throw new EmailException("Este email está sendo utilizado!");
        }
        if (u.getEmail().equals("") || u.getNascimento() == null
                || u.getNome().equals("") || u.getSenha().equals("") || u.getSexo().equals("")) {
            throw new CadastroException("Preencha todos os campos!");
        }
        usuarios.add(u);
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(arquivo));
        writer.writeObject(usuarios);
        writer.close();
        return true;
    }

    /**
     * Remove um usuário do arquivo
     * @param u é o usuário que será removido
     * @return verdadeiro ou falso, caso o usuário seja removido ou não
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    
    public boolean remover(Usuario u) throws IOException, ClassNotFoundException {
        List<Usuario> usuarios = listar();
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(arquivo));
        if (usuarios.remove(u)) {
            writer.writeObject(usuarios);
            writer.close();
            return true;
        } else {
            writer.writeObject(usuarios);
            writer.close();
            return false;
        }
    }
    
    /**
     * Realiza a confirmação de senha no cadastro de usuário
     * @param senha é a senha digitada pelo usuário no campo 'senha'
     * @param confirma é a confirmação de senha digitada no campo 'confirma senha'
     * @return verdadeiro ou falso, caso as duas sejam iguais ou não.
     * @throws CadastroException 
     */
    public boolean confirmaSenha(String senha, String confirma) throws CadastroException {

        if (confirma.equals("")) {
            throw new CadastroException("Digite a confirmação de senha!");
        }
        return senha.equals(confirma);
    }

    /**
     * Realiza a busca de um usuário a partir do email
     * @param email´é o email do usuário que está sendo buscado
     * @return retorna o usuário, caso seja encontrado, ou null, caso não exista
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public Usuario buscar(String email) throws ClassNotFoundException, IOException {
        List<Usuario> usuarios = listar();
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

}
