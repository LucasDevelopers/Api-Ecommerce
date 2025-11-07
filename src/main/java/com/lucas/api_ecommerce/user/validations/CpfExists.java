package com.lucas.api_ecommerce.user.validations;

import com.lucas.api_ecommerce.user.UserRepository;
import com.lucas.api_ecommerce.user.dto.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.lucas.api_ecommerce.utils.FunctionsCpf.cleanCpf;

@Component
public class CpfExists implements Validations{
    @Autowired
    UserRepository userRepository;

    @Override
    public void validation(CreateUserDto dto){
        String cpf = cleanCpf(dto.getCpf());
        if(userRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
    }
}
