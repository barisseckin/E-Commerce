package com.eCommerceProject.repository;

import com.eCommerceProject.model.ConfirmedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmedOrderRepository extends JpaRepository<ConfirmedOrder, Integer> {
    ConfirmedOrder findConfirmedOrderByOrderNumber(Long orderNumber);
}
