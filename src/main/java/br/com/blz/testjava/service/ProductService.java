package br.com.blz.testjava.service;

import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.exception.NotFoundException;
import br.com.blz.testjava.repository.MockRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final MockRepository mockRepository;

    public ProductService(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    public void createProduct(ProductDto productDto) {
        verifyIFProductExists(productDto.sku());
        mockRepository.save(productDto.convertToProduct());
    }

    public void editProduct(Integer sku, ProductDto productDto) {
        Product product = findProduct(sku);
        product.editProduct(productDto);
    }

    public void deleteProduct(Integer sku) {
        Product product = findProduct(sku);
        mockRepository.delete(product);
    }

    public Product findProduct(Integer sku) {
        return mockRepository.findById(sku).orElseThrow(() -> new NotFoundException("Sku {0} not found"));
    }

    private void verifyIFProductExists(Integer sku) {
        mockRepository.findById(sku).ifPresent(p -> {
            throw new RuntimeException();
        });
    }
}
