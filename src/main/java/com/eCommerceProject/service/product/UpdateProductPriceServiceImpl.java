package com.eCommerceProject.service.product;

import com.eCommerceProject.model.Product;
import com.eCommerceProject.model.User;
import com.eCommerceProject.repository.ProductRepository;
import com.eCommerceProject.request.CampaignCreateRequest;
import com.eCommerceProject.request.PriceIncreaseRequest;
import com.eCommerceProject.service.SendEmailService;
import com.eCommerceProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductPriceServiceImpl implements UpdateProductPriceService {

    private final ProductRepository productRepository;

    private final SendEmailService emailService;

    private final UserService userService;

    @Override
    public void createCampaign(CampaignCreateRequest campaignCreateRequest) {
        Optional<Product> product = productRepository.findById(campaignCreateRequest.getProductId());
        List<User> users = userService.getAll();

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
