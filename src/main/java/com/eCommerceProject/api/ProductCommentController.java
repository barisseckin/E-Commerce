package com.eCommerceProject.api;

import com.eCommerceProject.model.ProductComment;
import com.eCommerceProject.service.product.ProductCommentService;
import com.eCommerceProject.shared.ECommerceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/products/comments/")
@CrossOrigin
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody ProductComment productComment) {
        productCommentService.add(new ProductComment(productComment.getTitle(), productComment.getBody(), productComment.getRating(), new Date()));
        return ResponseEntity.ok(ECommerceMessage.PRODUCT_COMMENT_CREATED);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        productCommentService.deleteById(id);
        return ResponseEntity.ok(ECommerceMessage.PRODUCT_COMMENT_DELETED);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productCommentService.getAll());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(productCommentService.getById(id));
    }

    @GetMapping("getCommentsByProduct")
    public ResponseEntity<?> getCommentsByProduct(@PathVariable int id) {
        return ResponseEntity.ok(productCommentService.getCommentsByProduct(id));
    }
}