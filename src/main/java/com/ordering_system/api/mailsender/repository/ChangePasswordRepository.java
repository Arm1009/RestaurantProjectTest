package com.ordering_system.api.mailsender.repository;

import com.ordering_system.api.mailsender.model.ChangePassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangePasswordRepository extends JpaRepository<ChangePassword,Long> {
    ChangePassword findByUserEmail(String email);
    void deleteByUserEmail(String email);
}
