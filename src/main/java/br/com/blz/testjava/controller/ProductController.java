package br.com.blz.testjava.controller;

import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody @Valid ProductDto productDto) {
        productService.createProduct(productDto);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public Product findProduct(@RequestParam Integer sku) {
        return productService.findProduct(sku);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@RequestParam Integer sku) {
        productService.deleteProduct(sku);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editProduct(@RequestParam Integer sku, @RequestBody ProductDto productDto) {
        productService.editProduct(sku, productDto);
    }
}
