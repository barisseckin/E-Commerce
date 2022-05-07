package com.eCommerceProject.dataAccess.abstracts;

import com.eCommerceProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getById(int id);
    User findByUserName(String username);
}
