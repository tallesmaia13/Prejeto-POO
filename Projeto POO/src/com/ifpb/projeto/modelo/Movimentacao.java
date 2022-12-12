package com.ifpb.projeto.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Movimentacao {

    private String descricao;
    private LocalDate data;
    private float valor;
    private char tipo;
    private char categoria;

    public Movimentacao() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        if (tipo == 'e') {
            switch (categoria) {
                case 'a': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "entrada" + ", categoria=" + "alimentação" + '}';

                }
                case 'c': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "entrada" + ", categoria=" + "cartão de crédito" + '}';

                }
                case 'd': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "entrada" + ", categoria=" + "despesa doméstica" + '}';

                }
                case 's': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "entrada" + ", categoria=" + "saúde" + '}';

                }
                case 'p': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "entrada" + ", categoria=" + "pessoal" + '}';

                }
                default: {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "entrada" + ", categoria=" + "outro" + '}';
                }
            }

        } else {
            switch (categoria) {
                case 'a': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "saída" + ", categoria=" + "alimentação" + '}';

                }
                case 'c': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "saída" + ", categoria=" + "cartão de crédito" + '}';

                }
                case 'd': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "saída" + ", categoria=" + "despesa doméstica" + '}';

                }
                case 's': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "saída" + ", categoria=" + "saúde" + '}';

                }
                case 'p': {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "saída" + ", categoria=" + "pessoal" + '}';

                }
                default: {
                    return "Movimentacao{" + "descricao=" + descricao + ", data=" + data
                            + ", valor=" + valor + ", tipo=" + "saída" + ", categoria=" + "outros" + '}';
                }
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.data);
        hash = 17 * hash + Float.floatToIntBits(this.valor);
        hash = 17 * hash + Objects.hashCode(this.tipo);
        hash = 17 * hash + Objects.hashCode(this.categoria);
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
        final Movimentacao other = (Movimentacao) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

}
