package org.example.test.basic;

import org.example.infra.ProdutoDAO;
import org.example.model.basic.Produto;

import java.util.List;

public class ObterProdutos {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos();

        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + " Preco: " + produto.getPreco());
        }

//        double precoTotal = produtos.stream()
//                .map(p -> p.getPreco())
//                .reduce(0.0, (t, p) -> t + p)
//                .doubleValue();

        // OU POSSO FAZER

        double precoTotal = produtos.stream().map(Produto::getPreco).reduce(0.0, Double::sum);

        System.out.println("O valor total é R$ " + precoTotal);

        dao.fecharT();
    }

}
