import java.util.List;
import java.util.Scanner;

public class Aplicativo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();
        MySQL conexao = new MySQL();

        while (true) {
            System.out.println("1- Acessar conta\n2- Criar conta\n3- Sair");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Acessar conta
                    System.out.println("Digite seu nome: ");
                    String nomeAcesso = sc.next();
                    Cliente cliente = banco.buscarCliente(nomeAcesso);

                    if (cliente != null) {
                        System.out.println("Digite sua senha: ");
                        String senhaAcesso = sc.next();
                        if (cliente.getSenha().equals(senhaAcesso)) {
                            System.out.println("Bem-vindo(a) " + cliente.getNome() + "!\n");

                            boolean sair = false;
                            while (!sair) {
                                System.out.println("1- Depósito\n2- Saque\n3- Transferência\n4- Sair");
                                int opcoesConta = sc.nextInt();

                                switch (opcoesConta) {
                                    case 1:
                                        // Depósito
                                        System.out.println("Quanto você deseja depositar? ");
                                        double valorDeposito = sc.nextDouble();
                                        banco.deposito(cliente, valorDeposito);
                                        System.out.println("Saldo Atualizado: " + cliente.getSaldo());
                                        break;

                                    case 2:
                                        // Saque
                                        System.out.println("Quanto você deseja sacar? ");
                                        double valorSaque = sc.nextDouble();
                                        if (banco.sacar(cliente, valorSaque)) {
                                            System.out.println("Saque realizado com sucesso. Saldo Atualizado: " + cliente.getSaldo());
                                        } else {
                                            System.out.println("Saldo insuficiente.");
                                        }
                                        break;

                                    case 3:
                                        // Transferência
                                        System.out.println("Para quem você vai transferir?");
                                        List<Cliente> contas = banco.listarContas();
                                        for (Cliente c : contas) {
                                            System.out.println(c.getNome());
                                        }
                                        String nomeTransferencia = sc.next();
                                        Cliente destinatario = banco.buscarCliente(nomeTransferencia);

                                        if (destinatario != null) {
                                            System.out.println("Quanto você deseja transferir?");
                                            double valorTransferencia = sc.nextDouble();

                                            if (banco.transferir(cliente, destinatario, valorTransferencia)) {
                                                System.out.println("Transferência realizada com sucesso. Saldo Atualizado: " + cliente.getSaldo());
                                            } else {
                                                System.out.println("Saldo insuficiente.");
                                            }
                                        } else {
                                            System.out.println("Destinatário não encontrado.");
                                        }
                                        break;

                                    case 4:
                                        sair = true;
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Senha incorreta!");
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 2:
                    System.out.println("Você deseja criar uma conta corrente ou poupança?");
                    String tipoConta = sc.next();

                    System.out.println("Digite seu nome:");
                    String nomeCriando = sc.next();

                    System.out.println("Digite sua senha:");
                    String senhaCriando = sc.next();

                    Cliente novaConta = new Cliente(nomeCriando, senhaCriando, tipoConta);
                    banco.adicionarConta(novaConta);
                    conexao.insertNameAndPassword(nomeCriando, senhaCriando);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 3:
                    // Sair do aplicativo
                    System.out.println("Saindo...");
                    return;
            }
        }
    }
}
