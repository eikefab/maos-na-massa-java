package br.com.eikefab;

public enum Funcao {

    OPERADOR("Operador"),
    COORDENADOR("Coordenador"),
    DIRETOR("Diretor"),
    RECEPCIONISTA("Recepcionista"),
    CONTADOR("Contador"),
    GERENTE("Gerente"),
    ELETRICISTA("Eletricista");

    private final String nome;

    Funcao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
