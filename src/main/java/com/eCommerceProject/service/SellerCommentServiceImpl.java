package com.eCommerceProject.service;

import com.eCommerceProject.model.Seller;
import com.eCommerceProject.model.SellerComment;
import com.eCommerceProject.repository.SellerCommentRepository;
import com.eCommerceProject.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerCommentServiceImpl implements SellerCommentService{

    private final SellerCommentRepository sellerCommentRepository;

    private final SellerRepository sellerRepository;

    @Override
    public SellerComment add(SellerComment sellerComment) {

        if (sellerComment.getRating() < 1) {
            return null;
        } else {
            return sellerCommentRepository.save(sellerComment);
        }
    }

    @Override
    public void deleteById(int id) {
        sellerCommentRepository.deleteById(id);
    }

    @Override
    public List<SellerComment> getAll() {
        List<SellerComment> responseSellerComments = sellerCommentRepository.findAll();
        return responseSellerComments;
    }

    @Override
    public SellerComment getById(int id) {
        Optional<SellerComment> sellerComment = sellerCommentRepository.findById(id);
        if (sellerComment.isPresent()) {
            return sellerComment.get();
        }
        return null;
    }

    @Override
    public List<SellerComment> getSellerCommentsBySeller(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        List<SellerComment> responseSellerComments = new ArrayList<>();

        if (seller.isPresent()) {
            for (SellerComment sellerComment : seller.get().getSellerComment()) {
                responseSellerComments.add(sellerComment);
                return responseSellerComments;
            }
        }
        return null;
    }
}
