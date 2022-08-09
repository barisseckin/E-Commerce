package com.eCommerceProject.api;

import com.eCommerceProject.model.SellerComment;
import com.eCommerceProject.request.SellerCommentCreateRequest;
import com.eCommerceProject.service.seller.SellerCommentService;
import com.eCommerceProject.shared.ECommerceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/seller/comments/")
@CrossOrigin
@RequiredArgsConstructor
public class SellerCommentController {

    private final SellerCommentService sellerCommentService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody SellerCommentCreateRequest sellerComment) {
        sellerCommentService.add(new SellerComment(sellerComment.getTitle(), sellerComment.getBody(), sellerComment.getRating(), new Date()));
        return ResponseEntity.ok(ECommerceMessage.SELLER_COMMENT_CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(sellerCommentService.getAll());
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        sellerCommentService.deleteById(id);
        return ResponseEntity.ok(ECommerceMessage.SELLER_COMMENT_DELETED);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(sellerCommentService.getById(id));
    }

    @GetMapping("getSellerCommentsBySeller/{id}")
    public ResponseEntity<?> getSellerCommentsBySeller(@PathVariable int id) {
        return ResponseEntity.ok(sellerCommentService.getSellerCommentsBySeller(id));
    }
}