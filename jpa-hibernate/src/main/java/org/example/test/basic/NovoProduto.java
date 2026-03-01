package org.example.test.basic;

import org.example.infra.DAO;
import org.example.model.basic.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        Produto produto = new Produto("Monitor 23", 800.99);
        DAO<Produto> dao = new DAO<>(Produto.class);

       // dao.abrirT().incluir(produto).fecharT();
        dao.incluirAtomico(produto);
        System.out.println("Id do produto: " + produto.getId());

    }
}
