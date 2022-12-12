
package com.mycompany.etapa2.controle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConFactory {

    private final String host;
    private final String user;
    private final String password;

    
    /**
     * Construtor da conexão, conectando ao banco de dados selecionado
     */
    public ConFactory() {

        host = "jdbc:postgresql://127.0.0.1:5432/projetoPOO";
        user = "postgres";
        password = "flavio22";
    }

    /**
     * 
     * @return a conexão com o banco de dados
     * @throws ClassNotFoundException,SQLException
     */
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(host, user, password);
    }
}
