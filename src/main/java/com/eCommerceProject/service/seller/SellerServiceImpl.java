package com.eCommerceProject.service.seller;

import com.eCommerceProject.exception.NotFoundException;
import com.eCommerceProject.model.Seller;
import com.eCommerceProject.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public Seller add(Seller seller) {

        if (seller.getName().length() < 1) {
            return null;
        } else {
            return sellerRepository.save(seller);
        }
    }

    @Override
    public void deleteById(int id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getById(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.orElseThrow(() -> new NotFoundException("seller couldn't be found by following id: " + id));
    }
}