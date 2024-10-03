package Telefonar;

public class UsarTelefone implements Telefone {
    @Override
    public void ligar() {
        System.out.println("Ligando por Telefone Fixo");
    }
    @Override
    public void atender() {
        System.out.println("Atendendo por Telefone Fixo");
    }
    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando Correio Voz por Telefone Fixo");
    }
}
