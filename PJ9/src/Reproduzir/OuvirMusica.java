package Reproduzir;

public class OuvirMusica implements Spotify {
    @Override
    public void tocar() {
    System.out.println("Tocar música na Caixa de Som");
    }
    @Override
    public void pausar() {
        System.out.println("Pausar música na Caixa de Som");
    }
    @Override
    public void selecionarMusica() {
        System.out.println("Selecionar música na Caixa de Som");
    }
}
