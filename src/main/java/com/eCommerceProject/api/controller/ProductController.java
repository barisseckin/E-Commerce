package com.eCommerceProject.api.controller;

import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
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
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    private String productsName;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid ProductCreateDto productCreateDto) {
        this.productService.add(productCreateDto);
        return ResponseEntity.ok(new GenericResponse("Saved."));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        final List<Product> products = productService.getAll();

        if(products.size() <= 0) {
            return ResponseEntity.ok(new GenericResponse("Kayitli urun bulunamadi!"));
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("getByProductName/{productName}")
    public ResponseEntity<?> getByproductName(@PathVariable String productName) {
        List<Product> products = this.productService.getByproductName(productName);
        for(Product product: products) {
            this.productsName = product.getProductName();
        }
        if(!productName.equals(this.productsName)) {
            return ResponseEntity.ok(new GenericResponse("Boyle bir urun bulunamadi!"));
        }
        return ResponseEntity.ok(products);

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

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable int id) {
        this.productService.deleteById(id);
        return ResponseEntity.ok(new GenericResponse("Deleted..."));
    }

    @GetMapping("getDto")
    public ResponseEntity<List<ProductViewDto>> getDto() {
        List<ProductViewDto> products = this.productService.getDto();
        return ResponseEntity.ok(products);
    }
}
