package br.com.blz.testjava.repository;

import br.com.blz.testjava.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(Integer sku);

    void delete(Product product);
}
