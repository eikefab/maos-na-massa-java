package br.com.eikefab;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Funcionario extends Pessoa {

    // Possível melhoria: criação de campo de índice, a fim de indexar e melhorar a performance da exclusão de determinados
    // funcionários.

    // Valores e função não são valores finais, vide que o funcionário pode, ao decorrer de sua jornada,
    // mudar de salário e função.
    private BigDecimal salario;

    // Função não é uma string, mas um enum, pois isso facilita e padroniza no futuro, por exemplo,
    // verificar e comparar funções sem ter de lidar com textos.
    private Funcao funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, Funcao funcao) {
        super(nome, dataNascimento);

        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

}
