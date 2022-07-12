package com.eCommerceProject.repository;

import com.eCommerceProject.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {

    PromoCode findPromoCodeByCode(String code);
}
