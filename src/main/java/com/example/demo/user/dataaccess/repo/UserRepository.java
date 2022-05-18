package com.example.demo.user.dataaccess.repo;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    @Override
    <S extends User> List<S> findAll(Example<S> example);
}
