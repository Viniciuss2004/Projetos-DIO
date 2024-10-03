package Celular;

import Navegar.Google;
import Reproduzir.Spotify;
import Telefonar.Telefone;

public class MultiplaFuncao implements Google, Spotify, Telefone {

    // Internet (Google)

    @Override
    public void exibirPagina() {
        System.out.println("Exibindo Página no Celular");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando Nova Aba no Celular");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando Página no Celular");
    }

    // Música (Spotify)

    @Override
    public void tocar() {
        System.out.println("Tocando Música no Celular");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando Música no Celular");
    }

    @Override
    public void selecionarMusica() {
        System.out.println("Selecionando Música no Celular");
    }

    //Telefone(Fixo)

    @Override
    public void ligar() {
        System.out.println("Ligando para Alguém no Celular");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo Alguém no Celular");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando Correio de Voz no Celular");
    }
}
