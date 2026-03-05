package org.springboot.springboot.model.repositories;

import org.springboot.springboot.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
