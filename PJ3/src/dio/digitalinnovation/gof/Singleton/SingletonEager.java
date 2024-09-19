package dio.digitalinnovation.gof.Singleton;

/**
 * Singleton "Preguiçoso"
 * @author Viniciuss2004
 */

public class SingletonEager {

    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia() {
        return instancia;
    }
}