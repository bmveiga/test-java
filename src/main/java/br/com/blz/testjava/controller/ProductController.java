package br.com.blz.testjava.controller;

import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/products/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProduct(@PathVariable(name = "sku") Integer sku) {
        return productService.findProduct(sku);
    }

    @DeleteMapping("/products/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable(name = "sku") Integer sku) {
        productService.deleteProduct(sku);
    }

    @PutMapping("/products/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Product editProduct(@PathVariable(name = "sku") Integer sku, @RequestBody @Valid ProductDto productDto) {
        return productService.editProduct(sku, productDto);
    }
}
