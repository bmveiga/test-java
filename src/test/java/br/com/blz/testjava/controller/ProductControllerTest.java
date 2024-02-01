package br.com.blz.testjava.controller;

import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.blz.testjava.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Mock
    private ProductService productService;
    private ProductController productController;

    @BeforeEach
    void setUp() {
        this.productController = new ProductController(productService);
    }

    @Test
    void shouldSaveProduct() {
        productController.saveProduct(getProductDto());

        verify(productService).createProduct(any(ProductDto.class));
    }

    @Test
    void shouldFindProduct() {
        when(productService.findProduct(anyInt())).thenReturn(getProduct());
        Product product = productController.findProduct(SKU);

        assertNotNull(product);

        verify(productService).findProduct(anyInt());
    }

    @Test
    void shouldDeleteProduct() {
        productController.deleteProduct(SKU);

        verify(productService).deleteProduct(anyInt());
    }

    @Test
    void shouldEditProduct() {
        productController.editProduct(SKU, getNewProductDto());

        verify(productService).editProduct(anyInt(), any(ProductDto.class));
    }
}
