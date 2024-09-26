import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        double salarioBase = 2000;
        String[] LigandoParaCandidato = {"Sim", "Não"};

        analisarCandidato(salarioBase);
        List<String> candidatosAprovados = selecionarCandidato(salarioBase);
        LigarParaCandidato(LigandoParaCandidato[1], candidatosAprovados);
    }

    public static void analisarCandidato(Double salarioBase) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("TESTE 1\n");

        for (int i = 0; i <= 3; i++) {

            double salarioPret = valorPretendido();

            System.out.println("Salario Pretendido: " + salarioPret);

            if (salarioBase > salarioPret) {
                System.out.println("Ligar para o candidato");
            } else if (salarioBase == salarioPret) {
                System.out.println("Ligar para o candidato com contra proposta");
            } else {
                System.out.println("Aguardar mais candidatos");
            }

            System.out.println("");
        }

        System.out.println("----------------------------------------------------------------------");
    }

    public static List<String> selecionarCandidato(Double salarioBase) {

        System.out.println("TESTE 2 e 3");

        String[] candidatos = {"Alice", "Bruno", "Carla", "Diego", "Eduarda", "Fernando", "Gabriela", "Hugo", "Isabela", "João"};

        List<Double> pretensaoSalarial = new ArrayList<>();
        List<String> candidatosAprovados = new ArrayList<>();

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;

        while (candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            pretensaoSalarial.add(salarioPretendido);

            if (salarioBase >= salarioPretendido && candidatosSelecionados < 5) {
                candidatosAprovados.add(candidato);
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

        System.out.println("\nLista de Pretensão Salarial:");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println(candidatos[i] + ": " + pretensaoSalarial.get(i));
        }

        System.out.println("\nCandidatos Aprovados:");
        for (String candidato : candidatosAprovados) {
            System.out.println(candidato);
        }

        if (candidatosSelecionados < 5) {
            System.out.println("\nNem todos os candidatos foram selecionados. Restam vagas disponíveis.");
        }

        System.out.println("");
        System.out.println("----------------------------------------------------------------------");

        return candidatosAprovados;
    }

    public static void LigarParaCandidato(String LigandoParaCandidato, List<String> candidatosAprovados) {

        System.out.println("TESTE 4\n");

        System.out.println("Ligando para os candidatos aprovados...\n");

            List<String> naoAtenderam = new ArrayList<>();

        for (String candidato : candidatosAprovados) {
            System.out.println("Ligando para " + candidato);

            boolean atendeu = false;

            for (int i = 0; i < 3; i++) {
                boolean status = ligarStatus();

                if (status) {
                    System.out.println(candidato + " atendeu na " + (i + 1) + " tentativas" );
                    atendeu = true;
                    break;
                } else if (i > 1) {
                    System.out.println("Não atendeu");
                }
            }

            if (!atendeu) {
                naoAtenderam.add(candidato);
            }
            System.out.println("");
        }

        if (!naoAtenderam.isEmpty()) {
            System.out.println("Candidatos que não atenderam após 3 tentativas:");
            for (String candidato : naoAtenderam) {
                System.out.println(candidato);
            }
        } else {
            System.out.println("Todos os candidatos atenderam.");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean ligarStatus() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
