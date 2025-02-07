package br.com.eikefab;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe criada apenas a fim de alimentar os dados-base ao programa.
 */
public final class DadosSeed {

    public static final List<Funcionario> FUNCIONARIOS = new ArrayList<>();

    static {
        FUNCIONARIOS.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), Funcao.OPERADOR));
        FUNCIONARIOS.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), Funcao.OPERADOR));
        FUNCIONARIOS.add(new Funcionario("Caio", LocalDate.of(1961, 2, 2), new BigDecimal("9836.14"), Funcao.COORDENADOR));
        FUNCIONARIOS.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), Funcao.DIRETOR));
        FUNCIONARIOS.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), Funcao.RECEPCIONISTA));
        FUNCIONARIOS.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), Funcao.OPERADOR));
        FUNCIONARIOS.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), Funcao.CONTADOR));
        FUNCIONARIOS.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), Funcao.GERENTE));
        FUNCIONARIOS.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), Funcao.ELETRICISTA));
        FUNCIONARIOS.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), Funcao.GERENTE));
    }

    private DadosSeed() {}

    public static Map<Funcao, List<Funcionario>> generateMap(List<Funcionario> funcionarios) {
        final Map<Funcao, List<Funcionario>> funcionarioMap = new HashMap<>();

        for (Funcao funcao : Funcao.values()) {
            final List<Funcionario> funcionariosFiltrados = funcionarios
                    .stream()
                    .filter(funcionario -> funcionario.getFuncao() == funcao)
                    .toList();

            funcionarioMap.put(funcao, funcionariosFiltrados);
        }

        return funcionarioMap;
    }

}
