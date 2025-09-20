import controllers.ListaConta;
import models.Conta;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ListaConta listaDeContas = new ListaConta();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar nova conta");
            System.out.println("2. Listar todas as contas ativas");
            System.out.println("3. Buscar conta por número");
            System.out.println("4. Remover uma conta");
            System.out.println("5. Depositar em uma conta");
            System.out.println("6. Sacar de uma conta");
            System.out.println("7. Encerrar conta");
            System.out.println("8. Sair do sistema");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    // Lógica para cadastrar conta
                    break;
                case 2:
                    listaDeContas.listar();
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada: Buscar conta por número.");
                    System.out.print("Digite o número da conta que deseja buscar: ");
                    int numeroContaBusca = scanner.nextInt();
                    scanner.nextLine();

                    Conta contaEncontrada = listaDeContas.buscarConta(numeroContaBusca);

                    if (contaEncontrada != null) {
                        System.out.println(contaEncontrada);
                    } else {
                        System.out.println("Conta não encontrada. Verifique o número e tente novamente.");
                    }
                    break;
                case 4:
                    // Lógica para remover conta
                    break;
                case 5:
                    System.out.print("Digite o número da conta: ");
                    int numeroContaDeposito = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    Conta contaParaDepositar = listaDeContas.buscarConta(numeroContaDeposito);

                    if (contaParaDepositar != null) {
                        contaParaDepositar.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada. Verifique o número e tente novamente.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o número da conta para saque: ");
                    int numeroContaSaque = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();

                    Conta contaParaSacar = listaDeContas.buscarConta(numeroContaSaque);

                    if (contaParaSacar != null) {
                        contaParaSacar.saque(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada. Verifique o número e tente novamente.");
                    }
                    break;
                case 7:
                    System.out.print("Digite o número da conta que deseja encerrar: ");
                    int numeroContaEncerrar = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha

                    // Chama o método da ListaConta para encerrar a conta
                    listaDeContas.encerrarConta(numeroContaEncerrar);
                    break;
                case 8:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }
}