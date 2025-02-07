package br.com.eikefab;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Principal {

    private static final List<Funcionario> FUNCIONARIOS = new ArrayList<>(DadosSeed.FUNCIONARIOS);
    private static final double SALARIO_MINIMO = 1212D;

    public static void main(String[] args) {
        removerJoao();

        final Map<Funcao, List<Funcionario>> map = DadosSeed.generateMap(FUNCIONARIOS);

        mostrarSalarios();
        mostrarFuncionariosAgrupadosPorFuncao(map);
        mostrarFuncionariosAniversariantesMes10e12();
        mostrarFuncionarioMaisVelho();
        mostrarFuncionariosEmOrdemAlfabetica();
        mostrarTotalSalarios();
    }

    public static void removerJoao() {
        FUNCIONARIOS.removeIf(funcionario -> funcionario.getNome().equals("João"));
    }

    public static void mostrarSalarios() {
         for (Funcionario funcionario : FUNCIONARIOS) {
             System.out.format(
                     "%s recebe %.2f salários mínimos",
                     funcionario.getNome(),
                     funcionario.getSalario().doubleValue() / SALARIO_MINIMO
             ).println();
         }
    }

    public static void mostrarFuncionariosAgrupadosPorFuncao(Map<Funcao, List<Funcionario>> funcaoMap) {
        for (Funcao funcao : funcaoMap.keySet()) {
            System.out.println(funcao.getNome() + ":");

            for (Funcionario funcionario : funcaoMap.get((funcao))) {
                System.out.println("- " + funcionario.getNome());
            }
        }
    }

    public static void mostrarFuncionariosAniversariantesMes10e12() {
        System.out.println("Funcionários aniversariantes em OUTUBRO e DEZEMBRO:");

        for (Funcionario funcionario : FUNCIONARIOS) {
            final Month month = funcionario.getDataNascimento().getMonth();

            if (Month.of(10) != month && Month.of(12) != month) {
                continue;
            }

            System.out.println("- " + funcionario.getNome());
        }
    }

    public static void mostrarFuncionarioMaisVelho() {
        final Funcionario funcionario = FUNCIONARIOS.stream()
                .sorted(Comparator.comparing(Pessoa::getDataNascimento))
                .toList()
                .get(0);

        System.out.println(funcionario.getNome() + " nasceu em " + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static void mostrarFuncionariosEmOrdemAlfabetica() {
        FUNCIONARIOS.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach((funcionario -> System.out.println("- " + funcionario.getNome())));
    }

    public static void mostrarTotalSalarios() {
        final double soma = FUNCIONARIOS.stream()
                .map((funcionario) -> funcionario.getSalario().doubleValue())
                .reduce(0D, Double::sum);

        System.out.format("Soma de todos os salários é %.2f R$", soma).println();
    }

}
