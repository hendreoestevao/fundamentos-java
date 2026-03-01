package org.example.test.umpramuitos;

import org.example.infra.DAO;
import org.example.model.basic.Produto;
import org.example.model.umpramuitos.ItemPedido;
import org.example.model.umpramuitos.Pedido;

import java.util.Date;

public class NovoPedido {
    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>(Object.class);

        Pedido pedido = new Pedido();
        Produto produto = new Produto("Geladeira", 2789.99);
        ItemPedido item = new ItemPedido(pedido, produto, 10);

        dao.abrirT().incluir(produto).incluir(pedido).incluir(item).commitT().fecharT();
    }
}
