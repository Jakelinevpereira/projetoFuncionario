package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;
import entities.FuncionarioTerceirizado;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.println("Digite o numero de funcionários: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Funcionário #" + i + "data: ");
			System.out.println("Esse funcionário é terceirizado (S/N)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Horas: ");
			int horas = sc.nextInt();
			System.out.println("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			if (ch == 'S') {
				System.out.println("Valor Adicional: ");
				double valorAdicional = sc.nextDouble();
				Funcionario func = new FuncionarioTerceirizado(nome, horas, valorPorHora, valorAdicional);
				list.add(func);
			} else {
				Funcionario func = new Funcionario(nome, horas, valorPorHora);
				list.add(func);
			}
		}
		System.out.println("--------------------------");
		System.out.println("Pagamento: ");
		for (Funcionario func : list) {
			System.out.println(func.getNome() + " - $" + String.format("%.2f", func.pagamento()));
		}

		sc.close();
	}

}
