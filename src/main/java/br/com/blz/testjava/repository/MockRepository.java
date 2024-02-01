package br.com.blz.testjava.repository;

import br.com.blz.testjava.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockRepository {

    private final List<Product> products;

    private MockRepository() {
        this.products = new ArrayList<>();
    }

    public void save(Product product) {
        products.add(product);
    }

    public Optional<Product> findById(Integer sku) {
        return products.stream().filter(p -> sku.equals(p.getSku())).findFirst();
    }

    public void delete(Product product) {
        products.remove(product);
    }



}
