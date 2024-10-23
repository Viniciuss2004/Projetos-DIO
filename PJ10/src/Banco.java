import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> contas = new ArrayList<>();

    // Método para adicionar uma nova conta
    public void adicionarConta(Cliente cliente) {
        contas.add(cliente);
    }

    // Buscar cliente por nome
    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : contas) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    // Depósito
    public void deposito(Cliente cliente, double valor) {
        cliente.setSaldo(cliente.getSaldo() + valor);
    }

    // Saque
    public boolean sacar(Cliente cliente, double valor) {
        if (cliente.getSaldo() >= valor) {
            cliente.setSaldo(cliente.getSaldo() - valor);
            return true;
        }
        return false;
    }

    // Transferência
    public boolean transferir(Cliente remetente, Cliente destinatario, double valor) {
        if (remetente.getSaldo() >= valor) {
            remetente.setSaldo(remetente.getSaldo() - valor);
            destinatario.setSaldo(destinatario.getSaldo() + valor);
            return true;
        }
        return false;
    }

    // Mostrar todas as contas
    public List<Cliente> listarContas() {
        return contas;
    }
}
