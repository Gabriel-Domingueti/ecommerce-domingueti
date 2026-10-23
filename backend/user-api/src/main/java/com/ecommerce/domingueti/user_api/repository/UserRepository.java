package com.ecommerce.domingueti.user_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domingueti.user_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);

    List<User> queryByNomeLike(String name);

    List<User> findByNome(String userName);
}
