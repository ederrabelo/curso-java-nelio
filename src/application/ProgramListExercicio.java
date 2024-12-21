package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Employee;

public class ProgramListExercicio {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee funcionario;
        List<Employee> listaFuncionarios = new ArrayList<>();

        System.out.print("Quantos funcionários serão registrados?");
        int qtdFuncionarios = sc.nextInt();

        for (int i = 0; i < qtdFuncionarios; i++) {
            System.out.println();
            System.out.println("Funcionário #" + (i + 1));
            System.out.print("Id: ");
            int id = sc.nextInt();
            while (temId(id, listaFuncionarios)) {
                System.out.print("Este Id já existe! Digite novamente um id não cadastrado: ");
                id = sc.nextInt();
            }

            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Salário: ");
            double salario = sc.nextDouble();
            funcionario = new Employee(id, nome, salario);

            listaFuncionarios.add(funcionario);
        }

        System.out.println();

        System.out.print("Digite o id do funcionário que terá o aumento salarial: ");
        int idFuncionarioAumento = sc.nextInt();

        if (temId(idFuncionarioAumento, listaFuncionarios) == true) {
            System.out.print("Digite a porcentagem: ");
            int percentage = sc.nextInt();

            for (Employee x : listaFuncionarios) {
                if (x.getId() == idFuncionarioAumento) {
                    x.salaryIncrease(percentage);
                }
            }
        } else {
            System.out.println("Esse id não existe!");
        }

        System.out.println();

        System.out.println("Lista de funcionários: ");

        for (Employee x : listaFuncionarios) {
            System.out.println(x);
        }

        sc.close();
    }

    public static boolean temId(Integer id, List<Employee> lista) {
        List<Employee> listaVerificada = lista.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList());

        return listaVerificada.isEmpty() ? false : true;
    }
}
