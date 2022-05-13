package com.example.demo.appUser;

import com.example.demo.appUser.AppUser;
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
