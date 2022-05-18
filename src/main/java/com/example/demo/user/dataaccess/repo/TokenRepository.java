package com.example.demo.user.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<AuthenticationToken,Long> {

    Optional<AuthenticationToken> findByUser(User user);
}
