    package dio.digitalinnovation.gof;

    import dio.digitalinnovation.gof.Facade.Facade;
    import dio.digitalinnovation.gof.Singleton.SingletonEager;
    import dio.digitalinnovation.gof.Singleton.SingletonLazy;
    import dio.digitalinnovation.gof.Singleton.SingletonLazyHolder;
    import dio.digitalinnovation.gof.Strategy.*;

    /**
 * Singleton "Preguiçoso"
 * @author Viniciuss2004
 */

public class Teste {

    public static void main(String[] args) {

        // Teste relacionados ao Desing Pattern Singleton

        // Singleton

        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

        // Strategy

        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();
        Comportamento defensivo = new ComportamentoDefensivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);

        robo.mover();
        robo.mover();

        // Facade

        Facade facade = new Facade();
        facade.migrarCliente("Vinicius","88052300");

    }
}