package com.lucas.api_ecommerce.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
