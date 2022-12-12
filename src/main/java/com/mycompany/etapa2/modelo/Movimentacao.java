package com.mycompany.etapa2.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe modelo para movimentações financeiras
 *
 * @author Flavio
 */
public class Movimentacao implements Serializable {

    private String descricao;
    private String categoria;
    private float valor;
    private String tipo;
    private LocalDate data;
    private String email;

    /**
     * Construtor de Movimentacao
     *
     * @param descricao é a descrição daquela movimentação
     * @param categoria é a categoria daquela movimentação
     * @param valor é o valor daquela movimentação
     * @param tipo é o tipo da movimentação
     * @param data é a data em que a movimentação ocorreu ou ocorrerá
     * @param email é o email do usuário que registrou a movimentação
     */
    public Movimentacao(String descricao, String categoria, float valor,
            String tipo, LocalDate data, String email) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
        this.email = email;

    }

    public Movimentacao() {
    }

    /**
     * Busca a descrição da movimentação
     *
     * @return retorna a descrição da movimentação
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Modifica ou salva uma descrição para uma movimentação
     *
     * @param descricao é a descrição passada para a movimentação
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Busca a categoria da movimentação
     *
     * @return a categoria da movimentação
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Altera ou salva uma categoria para uma movimentação
     *
     * @param categoria é a categoria passada para a movimentação
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna o valor da movimentação
     *
     * @return retorna o valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * Altera ou salva um valor para uma movimentação
     *
     * @param valor é o valor para aquela movimentação
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * Busca o tipo da movimentação
     *
     * @return retorna o tipo da movimentação
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Salva ou altera o tipo de uma movimentação
     *
     * @param tipo é o tipo passado para aquela movimentação
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Busca a data em que uma movimentação aconteceu
     *
     * @return a data da movimentação
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Altera ou salva a data de uma movimentação
     * @param data é a data que foi passada para uma movimentação
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Busca o email do usuário que realizou a movimentação
     * @return o email do usuário
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /**
     * Transforma a movimentação em uma string com seus atributos
     * @return uma string com os atributos da movimentação
     */
    @Override
    public String toString() {
        return "Movimentacao{" + "descricao=" + descricao + ", categoria=" + categoria + ", valor=" + valor + ", tipo=" + tipo + ", data=" + data + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.descricao);
        hash = 83 * hash + Objects.hashCode(this.categoria);
        hash = 83 * hash + Float.floatToIntBits(this.valor);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        hash = 83 * hash + Objects.hashCode(this.data);
        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     * Compara uma movimentação com outra e determina se são iguais
     * @param obj é a movimentação que será comparada com a atual
     * @return 
     */
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
        final Movimentacao other = (Movimentacao) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

}
