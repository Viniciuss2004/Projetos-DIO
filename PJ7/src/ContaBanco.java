import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Model model = new Model();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1: Criar conta");
            System.out.println("2: Entrar na conta");
            System.out.println("3: Fechar programa");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    inserirDados(sc, model);
                    break;
                case 2:
                    entrarNaConta(sc, model);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    sc.close();
                    return; // Sai do programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void inserirDados(Scanner sc, Model model) {
        System.out.println("Digite seu Nome: ");
        String nom = sc.next();

        System.out.println("Digite o número da Agência: ");
        String age = sc.next();

        System.out.println("Digite o número da conta: ");
        int num = sc.nextInt();

        System.out.println("Digite o Saldo da sua conta: ");
        double salI = sc.nextDouble();

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String salF = formatoMoeda.format(salI);

        // Informar ao usuário
        System.out.println("Olá " + nom + ", obrigado por criar uma conta em nosso banco, sua agência é " + age + ", conta " + num + " e seu saldo " + salF + " já está disponível para saque");

        // Inserir dados
        model.inserirDados(nom, age, num, salI);
    }

    private static void entrarNaConta(Scanner sc, Model model) {
        System.out.println("Digite o número da Agência: ");
        String agencia = sc.next();

        System.out.println("Digite o número da conta: ");
        int numero = sc.nextInt();

        // Recuperar dados do cliente
        if (model.recuperarDadosPorAgenciaENumero(agencia, numero)) {
            // Opções após entrar na conta
            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1: Sacar saldo");
                System.out.println("2: Transferir para outra conta");
                System.out.println("3: Sair da conta");
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o valor que deseja sacar: ");
                        double valorSaque = sc.nextDouble();
                        model.sacarSaldo(agencia, numero, valorSaque);
                        break;
                    case 2:
                        realizarTransferencia(sc, model, agencia, numero);
                        break;
                    case 3:
                        System.out.println("Saindo da conta...");
                        return; // Sai da conta
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarTransferencia(Scanner sc, Model model, String agenciaOrigem, int numeroOrigem) {
        System.out.println("Digite a agência da conta destino: ");
        String agenciaDestino = sc.next();

        System.out.println("Digite o número da conta destino: ");
        int numeroDestino = sc.nextInt();

        // Verificar se a conta destino existe antes de solicitar o valor da transferência
        if (model.contaExiste(agenciaDestino, numeroDestino)) {
            System.out.println("Digite o valor da transferência: ");
            double valorTransferencia = sc.nextDouble();

            // Realizar a transferência
            model.transferirSaldo(agenciaOrigem, numeroOrigem, agenciaDestino, numeroDestino, valorTransferencia);
        } else {
            System.out.println("Conta destino não encontrada. Verifique a agência e o número.");
        }
    }
}
