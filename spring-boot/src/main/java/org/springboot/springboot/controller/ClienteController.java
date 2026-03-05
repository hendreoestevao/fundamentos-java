package org.springboot.springboot.controller;

import org.springboot.springboot.model.entities.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {


//    @RequestMapping(method = RequestMethod.GET)
//    public Cliente obterCliente() {
//        return new Cliente(28,"Pedro","111.111.111-11");
//    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable int id) {
        return new Cliente(id,"Maria","111.111.111-11");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Cliente obterClientePorId2(
            @RequestParam(name = "id") int id) {
        return new Cliente(id,"João","111.111.111-11");
    }

}
