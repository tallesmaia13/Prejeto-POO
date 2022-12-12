package com.ifpb.projeto.visao;

import com.ifpb.projeto.controle.Cadastro;
import com.ifpb.projeto.modelo.Usuario;
import com.ifpb.projeto.modelo.Movimentacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Cadastro cadastro = new Cadastro();
        int selecao = 0;
        Scanner scanner = new Scanner(System.in);
        while (selecao != 5) {

            System.out.println("Deseja se cadastrar? digite 1.");
            System.out.println("Deseja fazer login? digite 2.");
            System.out.println("Deseja remover algum usuário? digite 3.");
            System.out.println("Deseja atualizar o perfil de usuário? digite 4.");
            System.out.println("Deseja fechar o sistema? digite 5.");

            selecao = scanner.nextInt();

            switch (selecao) {
                case 1: {

                    Usuario usuario = new Usuario();
                    boolean teste = true;
                    while (teste == true) {
                        System.out.println("Digite o email: ");
                        String testeEmail = scanner.next();
                        teste = cadastro.buscaEmail(testeEmail);
                        if (teste == true) {
                            System.out.println("Este email já está sendo utilizado! ");
                        } else {
                            usuario.setEmail(testeEmail);
                        }
                    }
                    boolean confirma = false;
                    while (confirma == false) {
                        System.out.println("Digite a sua senha: ");
                        String senha = scanner.next();
                        System.out.println("Confirme sua senha: ");
                        String confirmacao = scanner.next();
                        confirma = usuario.confirmaSenha(senha, confirmacao);
                        if (confirma == false) {
                            System.out.println("Senha incorreta!");
                        } else {
                            usuario.setSenha(senha);
                        }
                    }
                    System.out.println("Digite o nome: ");
                    usuario.setNome(scanner.next());
                    System.out.println("Digite a data de nascimento: ");
                    String nascimento = scanner.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate data = LocalDate.parse(nascimento, formatter);
                    usuario.setNascimento(data);
                    System.out.println("Digite seu sexo, 'f' se for feminino ou 'm' se for masculino:  ");
                    usuario.setSexo(scanner.next().charAt(0));

                    if (cadastro.salvar(usuario)) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    }

                    break;
                }
                case 2: {

                    if (cadastro.getUsuarios().isEmpty()) {
                        System.out.println("Ainda não há usuários cadastrados no sistema!");

                        break;
                    }

                    System.out.println("Digite o email: ");
                    String email = scanner.next();;
                    System.out.println("Digite a sua senha: ");
                    String senha = scanner.next();

                    if (cadastro.autenticar(email, senha) == true) {
                        System.out.println("Usuário cadastrado no sistema.");
                        System.out.println("Bem vindo, " + cadastro.localizar(email, senha).getNome() + "!");
                        int escolha = 0;

                        while (escolha != 3) {

                            System.out.println("Deseja cadastrar alguma movimentação? Digite 1.");
                            System.out.println("Deseja listar suas movimentações? Digite 2.");
                            System.out.println("Deseja sair do sistema? Digite 3.");
                            escolha = scanner.nextInt();

                            switch (escolha) {

                                case 1: {

                                    Movimentacao movimentacao = new Movimentacao();
                                    System.out.println("Digite a descrição: ");
                                    movimentacao.setDescricao(scanner.next());
                                    System.out.println("Digite a data: ");
                                    String dataMovimentacao = scanner.next();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate data = LocalDate.parse(dataMovimentacao, formatter);
                                    movimentacao.setData(data);
                                    System.out.println("Digite o valor: ");
                                    System.out.print("R$ ");
                                    movimentacao.setValor(scanner.nextFloat());
                                    char tipo = 'n';

                                    while (tipo != 's' || tipo != 'e') {
                                        System.out.println("Digite S se for do tipo saída ou E se for do tipo entrada: ");
                                        tipo = scanner.next().charAt(0);
                                        if (tipo == 'e' || tipo == 's') {
                                            movimentacao.setTipo(tipo);
                                            break;
                                        } else {
                                            System.out.println("Tipo inválido.");
                                        }
                                    }

                                    System.out.println("Selecione a categoria: ");
                                    System.out.println("Caso seja alimentação, digite 'a':");
                                    System.out.println("Caso seja cartão de crédtio, digite 'c': ");
                                    System.out.println("Caso seja despesa doméstica, digite 'd': ");
                                    System.out.println("Caso seja saúde, digite 's': ");
                                    System.out.println("Caso seja pessoal, digite 'p': ");
                                    char categoria = scanner.next().charAt(0);
                                    movimentacao.setCategoria(categoria);
                                    cadastro.movimentacao(cadastro.localizar(email, senha), movimentacao);
                                    System.out.println("Movimentação cadastrada com sucesso !");
                                    break;
                                }
                                case 2: {
                                    cadastro.listar(email, senha);
                                    break;
                                }
                                case 3:
                                    escolha = 3;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Usuário não cadastrado.");
                        break;
                    }

                    break;
                }
                case 3: {
                    if (cadastro.getUsuarios().isEmpty()) {
                        System.out.println("Ainda não há usuários cadastrados no sistema!");
                        break;

                    }
                    System.out.println("Digite o email do usuário: ");
                    String email = scanner.next();
                    System.out.println("Digite a senha do usuário: ");
                    String senha = scanner.next();
                    if (cadastro.removerUsuario(email, senha)) {
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                }
                case 4: {
                    if (cadastro.getUsuarios().isEmpty()) {
                        System.out.println("Ainda não há usuários cadastrados no sistema!");
                        break;
                    }
                    System.out.println("Digite o email do usuário: ");
                    String email = scanner.next();
                    System.out.println("Digite a senha do usuário: ");
                    String senha = scanner.next();
                    if (!cadastro.autenticar(email, senha)) {
                        System.out.println("Usuário não cadastrado.");
                        break;
                    } else {

                        Usuario usuario = new Usuario();
                        boolean teste = true;
                        while (teste == true) {
                            System.out.println("Digite o email: ");
                            String testeEmail = scanner.next();
                            teste = cadastro.buscaEmail(testeEmail);
                            if (teste == true) {
                                System.out.println("Este email já está sendo utilizado! ");
                            } else {
                                usuario.setEmail(testeEmail);
                            }
                        }
                        System.out.println("Digite a senha: ");
                        usuario.setSenha(scanner.next());
                        System.out.println("Digite o nome: ");
                        usuario.setNome(scanner.next());
                        System.out.println("Digite a data de nascimento: ");
                        String nascimento = scanner.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate data = LocalDate.parse(nascimento, formatter);
                        usuario.setNascimento(data);
                        System.out.println("Digite seu sexo, 'f' se for feminino ou 'm' se for masculino:  ");
                        usuario.setSexo(scanner.next().charAt(0));
                        cadastro.atualizarUsuario(cadastro.localizar(email, senha), usuario);
                        System.out.println(usuario.toString());
                        System.out.println("As informações do usuário foram atualizadas!");
                    }
                    break;
                }
                case 5: {
                    selecao = 5;
                    break;
                }
                default: {
                    selecao = 0;
                }
            }
        }
    }
}
