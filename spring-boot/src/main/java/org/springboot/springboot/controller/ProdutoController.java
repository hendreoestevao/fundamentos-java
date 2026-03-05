package org.springboot.springboot.controller;

import jakarta.validation.Valid;
import org.springboot.springboot.model.entities.Produto;
import org.springboot.springboot.model.repositories.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {


    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

//    @PostMapping
//    public @ResponseBody Produto novoProduto(
//            @RequestParam String nome,
//            @RequestParam double preco,
//            @RequestParam double desconto) {
//        Produto produto = new Produto(nome,preco,desconto);
//        produtoRepository.save(produto);
//        return produto;
//    }

    @PostMapping
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }


//    @GetMapping
//    public List<Produto> obterTodosOsProdutos() {
//
//        List<Produto> produtos = new ArrayList<>();
//        produtoRepository.findAll().forEach(produto -> produtos.add(produto));
//        return produtos;
//    }

    @GetMapping
    public Iterable<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
       return produtoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable int id) {

        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return "Produto deletado com sucesso";
        }

        return "Produto não encontrado";
    }

    @GetMapping("/pagina")
    public Page<Produto> obterProdutosPaginados(
            @RequestParam int pagina,
            @RequestParam int tamanho) {

        Pageable pageable = PageRequest.of(pagina, tamanho);

        return produtoRepository.findAll(pageable);
    }
}
