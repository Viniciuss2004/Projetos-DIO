package dio.digitalinnovation.gof.Singleton;

/**
 * Singleton "Preguiçoso"
 * @author Viniciuss2004
 */

public class SingletonLazyHolder {

    private static class InstanceHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.instancia;
    }
}