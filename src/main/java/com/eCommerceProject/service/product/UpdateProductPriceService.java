package com.eCommerceProject.service.product;

import com.eCommerceProject.request.CampaignCreateRequest;
import com.eCommerceProject.request.PriceIncreaseRequest;

public interface UpdateProductPriceService {
    void createCampaign(CampaignCreateRequest campaignCreateRequest);
    void priceIncrease(PriceIncreaseRequest priceIncreaseRequest);
}
