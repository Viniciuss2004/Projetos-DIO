package Aplicativos;

import Celular.MultiplaFuncao;
import Navegar.UsarInternet;
import Reproduzir.OuvirMusica;
import Telefonar.UsarTelefone;

public class Tela {
    public static void main(String[] args) {

        MultiplaFuncao celular = new MultiplaFuncao();
        UsarInternet navegar = new UsarInternet();
        OuvirMusica reproduzir = new OuvirMusica();
        UsarTelefone telefonar = new UsarTelefone();

        // Navegar (Google no Computador)
        System.out.println("NAVEGANDO\n");
        navegar.exibirPagina();
        navegar.adicionarNovaAba();
        navegar.atualizarPagina();
        System.out.println("");

        // Reproduzir (Pendrive na Caixa de Som)
        System.out.println("REPRODUZINDO\n");
        reproduzir.tocar();
        reproduzir.pausar();
        reproduzir.selecionarMusica();
        System.out.println("");

        // Telefonar (Telefone Fixo)
        System.out.println("TELEFONANDO\n");
        telefonar.ligar();
        telefonar.atender();
        telefonar.iniciarCorreioVoz();
        System.out.println("");

        // Celular

        // Navegar (Google do Celular)
        System.out.println("PELO CELULAR\n");
        celular.exibirPagina();
        celular.adicionarNovaAba();
        celular.atualizarPagina();
        System.out.println("---------------------------------------------------");

        // Reproduzir (Spotify no Celular)
        celular.tocar();
        celular.pausar();
        celular.selecionarMusica();
        System.out.println("---------------------------------------------------");

        // Telefonar (Telefonar no Celular)
        celular.ligar();
        celular.atender();
        celular.iniciarCorreioVoz();
    }
}