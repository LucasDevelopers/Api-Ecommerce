package com.lucas.api_ecommerce.user;

import com.lucas.api_ecommerce.user.dto.CreateUserDto;
import com.lucas.api_ecommerce.user.validations.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private List<Validations> validationsList;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public void createUser(CreateUserDto dto){
        validationsList.forEach(v -> v.validation(dto));

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);

        userRepository.save(dto.toEntity());
    }
}
