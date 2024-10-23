public class Cliente {
    private String nome;
    private String senha;
    private String tipoConta;
    private double saldo;

    public Cliente(String nome, String senha, String tipoConta) {
        this.nome = nome;
        this.senha = senha;
        this.tipoConta = tipoConta;
        this.saldo = 0.0; // Saldo inicial 0
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
