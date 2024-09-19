package dio.digitalinnovation.gof.Facade;

import dio.digitalinnovation.gof.SubSistema1.crm.CrmService;
import dio.digitalinnovation.gof.Subsistema2.cep.CepService;

public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = CepService.getInstancia().recuperarCidade(cep);
        String estado = CepService.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);

    }
}
