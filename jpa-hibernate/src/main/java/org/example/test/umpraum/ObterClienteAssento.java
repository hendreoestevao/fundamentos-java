package org.example.test.umpraum;

import org.example.infra.DAO;
import org.example.model.umpraum.Assento;
import org.example.model.umpraum.Cliente;

public class ObterClienteAssento {

    public static void main(String[] args) {

        DAO<Cliente> daoCliente = new DAO<Cliente>(Cliente.class);

        Cliente cliente = daoCliente.obterPorId(1L);
        System.out.println(cliente.getAssento().getNome());

        daoCliente.fecharT();

        DAO<Assento> daoAssento = new DAO<Assento>(Assento.class);
        Assento assento = daoAssento.obterPorId(1L);

        System.out.println(assento.getCliente().getNome());

        daoAssento.fecharT();
    }
}
