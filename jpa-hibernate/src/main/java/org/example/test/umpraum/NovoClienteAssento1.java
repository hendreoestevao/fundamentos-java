package org.example.test.umpraum;

import org.example.infra.DAO;
import org.example.model.umpraum.Assento;
import org.example.model.umpraum.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Maria", assento);

        DAO<Object> dao = new DAO<>();

        dao.abrirT().incluir(assento)
                .incluir(cliente)
                .fecharT();

    }
}
