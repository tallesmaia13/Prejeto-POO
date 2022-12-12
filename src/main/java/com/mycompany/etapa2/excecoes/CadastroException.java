
package com.mycompany.etapa2.excecoes;


public class CadastroException extends Exception {
    
    /**
     * Construtor de CadastroException
     * @param mensagem  é a mensagem que será passada, de acordo com o erro ocorrido
     */
    public CadastroException(String mensagem) {
        super(mensagem);
    }
}
