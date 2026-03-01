package org.example.test.umpramuitos;

import org.example.infra.DAO;
import org.example.model.composicao.Endereco;
import org.example.model.composicao.Funcionario;
import org.example.model.umpramuitos.ItemPedido;
import org.example.model.umpramuitos.Pedido;

public class ObterPedido {
    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterPorId(1L);

        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.getQuantidade());
            System.out.println(item.getProduto().getNome());
        }
        dao.fecharT();
    }
}
