package org.example.test.umpraum;

import org.example.infra.DAO;
import org.example.model.umpraum.Assento;
import org.example.model.umpraum.Cliente;

public class NovoClienteAssento2 {

    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("John Doe", assento);

        DAO<Cliente> clienteDAO = new DAO<Cliente>(Cliente.class);

        clienteDAO.incluirAtomico(cliente);
    }
}
