package com.eCommerceProject.api.controller;

import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.dto.ProductViewDto;
import com.eCommerceProject.dto.UserViewDto;
import com.eCommerceProject.model.Product;
import com.eCommerceProject.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid Product product) {
        this.productService.add(product);
        return ResponseEntity.ok(new GenericResponse("Saved."));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAll() {
        final List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("getByProductName/{productName}")
    public List<Product> getByproductName(@PathVariable String productName) {
        return this.productService.getByproductName(productName);
    }

    @GetMapping("getByProductBrand/{productBrand}")
    public List<Product> getByproductBrand(@PathVariable String productBrand) {
        return this.productService.getByproductBrand(productBrand);
    }

    @GetMapping("slice")
    public ResponseEntity<List<Product>> slice(Pageable pageable) {
        final List<Product> products = this.productService.slice(pageable);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("deleteByid/{id}")
    public void deleteByid(@PathVariable int id) {
        this.productService.deleteById(id);
    }

    @GetMapping("getDto")
    public ResponseEntity<List<ProductViewDto>> getDto() {
        List<ProductViewDto> products = this.productService.getDto();
        return ResponseEntity.ok(products);
    }


}
