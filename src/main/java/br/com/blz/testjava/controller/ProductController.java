package br.com.blz.testjava.controller;

import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<Product> findProduct(@RequestParam Integer sku) {
        Product product = productService.findProduct(sku);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Product> deleteProduct(@RequestParam Integer sku) {
        productService.deleteProduct(sku);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Product> editProduct(@RequestParam Integer sku, @RequestBody ProductDto productDto) {
        productService.editProduct(sku, productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
