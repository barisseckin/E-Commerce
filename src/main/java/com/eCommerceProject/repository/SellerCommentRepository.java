package com.eCommerceProject.repository;

import com.eCommerceProject.model.SellerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerCommentRepository extends JpaRepository<SellerComment, Integer> {
}
