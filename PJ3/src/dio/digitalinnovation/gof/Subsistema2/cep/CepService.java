package dio.digitalinnovation.gof.Subsistema2.cep;

import dio.digitalinnovation.gof.Singleton.SingletonEager;

public class CepService {

    private static CepService instancia = new CepService();

    private CepService() {
        super();
    }

    public static CepService getInstancia() {
        return instancia;
    }
    public String recuperarCidade(String cep) {
        return "Florianópolis";
    }
    public String recuperarEstado(String cep) {
        return "SC";
    }
}
