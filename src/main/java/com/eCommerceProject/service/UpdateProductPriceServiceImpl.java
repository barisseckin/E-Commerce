package com.eCommerceProject.service;

import com.eCommerceProject.model.Product;
import com.eCommerceProject.model.User;
import com.eCommerceProject.repository.ProductRepository;
import com.eCommerceProject.repository.UserRepository;
import com.eCommerceProject.request.CampaignCreateRequest;
import com.eCommerceProject.request.PriceIncreaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductPriceServiceImpl implements UpdateProductPriceService{

    private final ProductRepository productRepository;

    private final SendEmailService emailService;

    private final UserRepository userRepository;

    @Override
    public void createCampaign(CampaignCreateRequest campaignCreateRequest) {
        Optional<Product> product = productRepository.findById(campaignCreateRequest.getProductId());
        List<User> users = userRepository.findAll();

        if (product.isPresent()) {
            product.get().setProductPrice( product.get().getProductPrice() - campaignCreateRequest.getDiscountAmount());
            productRepository.save(product.get());

            for (User user : users) {
                if (user.isNotificationPermission()) {
                    emailService.sendEmails(user.getEMail(), "Big Discount", product.get().getProductBrand() +" "+ product.get().getProductName()
                            + " Big discount on product!");
                }
            }
        }
    }

    @Override
    public void priceIncrease(PriceIncreaseRequest priceIncreaseRequest) {
        Optional<Product> product = productRepository.findById(priceIncreaseRequest.getProductId());

        if (product.isPresent()) {
            product.get().setProductPrice(product.get().getProductPrice() + priceIncreaseRequest.getAmount());
            productRepository.save(product.get());
        }
    }
}
