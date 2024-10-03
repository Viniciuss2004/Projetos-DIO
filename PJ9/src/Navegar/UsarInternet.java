package Navegar;

public class UsarInternet implements Google {

        @Override
        public void exibirPagina() {
            System.out.println("Exibindo Página no Computador");
        }

        @Override
        public void adicionarNovaAba() {
            System.out.println("Adicionando Nova Aba no Computador");
        }

        @Override
        public void atualizarPagina() {
            System.out.println("Atualizando Página no Computador");
        }
}
