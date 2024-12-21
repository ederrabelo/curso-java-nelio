package application;

import model.entities.Pessoa;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MetodosAbstratosExercicio {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> lista = new ArrayList<>();

        System.out.print("Digite a quantidade de pessoas: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Pessoa #" + i + " data: ");
            System.out.print("PF ou PJ? ");
            String tipoPessoa = sc.next();
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Renda anual: ");
            Double rendaAnual = sc.nextDouble();

            if (tipoPessoa.equals("PF")) {
                System.out.print("Gastos com saúde: ");
                Double gastosSaude = sc.nextDouble();
                lista.add(new PessoaFisica(rendaAnual, nome, gastosSaude));
            } else {
                System.out.print("Quantidade de funcionários: ");
                Integer qtdFuncionarios = sc.nextInt();
                lista.add(new PessoaJuridica(rendaAnual, nome, qtdFuncionarios));
            }
        }

        System.out.println();
        System.out.println("Taxas pagas: ");

        double somaTaxas = 0;
        for (Pessoa pessoa : lista) {
            System.out.println(pessoa);
            somaTaxas += pessoa.calculaTaxas();
        }

        System.out.println();
        System.out.print("Total taxas pagas: " + somaTaxas);

        sc.close();
    }
}
