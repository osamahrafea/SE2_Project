package com.example.demo.appUser.dataaccess.api.repo;

import com.example.demo.appUser.dataaccess.api.entity.AppUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly=true)
//@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findBYEmail(String email);
}
