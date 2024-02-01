package br.com.blz.testjava.service;

import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.exception.NotFoundException;
import br.com.blz.testjava.exception.ProductAlreadyExistsException;
import br.com.blz.testjava.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDto productDto) {
        verifyIFProductExists(productDto.getSku());
        productRepository.save(productDto.convertToProduct());
    }

    public void editProduct(Integer sku, ProductDto productDto) {
        Product product = findProduct(sku);
        product.modify(productDto);
    }

    public void deleteProduct(Integer sku) {
        Product product = findProduct(sku);
        productRepository.delete(product);
    }

    public Product findProduct(Integer sku) {
        return productRepository.findById(sku).orElseThrow(() -> new NotFoundException("3", sku.toString()));
    }

    private void verifyIFProductExists(Integer sku) {
        productRepository.findById(sku).ifPresent(p -> {
            throw new ProductAlreadyExistsException("4", sku.toString());
        });
    }
}
