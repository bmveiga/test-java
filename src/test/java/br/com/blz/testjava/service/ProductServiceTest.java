package br.com.blz.testjava.service;

import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.exception.NotFoundException;
import br.com.blz.testjava.exception.ProductAlreadyExistsException;
import br.com.blz.testjava.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static br.com.blz.testjava.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        this.productService = new ProductService(productRepository);
    }

    @Test
    void shouldCreateProduct() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        productService.createProduct(getProductDto());

        verify(productRepository).save(any(Product.class));
    }

    @Test
    void shouldThrowExceptionWithDuplicatedSkuOnCreateProduct() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));
        assertThrows(ProductAlreadyExistsException.class, () -> productService.createProduct(getProductDto()));
    }

    @Test
    void shouldEditExistingProduct() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));
        productService.editProduct(SKU, getNewProductDto());

        Product product = productService.findProduct(SKU);
        assertEquals(product.getSku(), SKU);
        assertEquals(product.getName(), getNewProductDto().getName());
    }

    @Test
    void shouldThrowErrorWhenInformedSkuDoesNotExist() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> productService.editProduct(SKU, getNewProductDto()));
    }

    @Test
    void shouldDeleteProduct() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));
        productService.deleteProduct(SKU);

        verify(productRepository).delete(any(Product.class));
    }

    @Test
    void shouldThrowErrorWhenDeletingInvalidSku() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> productService.deleteProduct(SKU));
    }

    @Test
    void shouldFindProduct() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));
        Product product = productService.findProduct(SKU);

        assertNotNull(product);

        verify(productRepository).findById(anyInt());
    }

    @Test
    void shouldThrowErrorWhenSearchingForInvalidSku() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> productService.findProduct(SKU));
    }
}
