package dio.digitalinnovation.gof.Singleton;

/**
 * Singleton "Preguiçoso"
 * @author Viniciuss2004
 */

public class SingletonLazy {

    private static SingletonLazy instancia;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstancia() {
        if (instancia == null) {
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}