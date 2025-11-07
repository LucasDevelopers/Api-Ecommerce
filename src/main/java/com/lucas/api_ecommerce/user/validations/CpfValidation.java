package com.lucas.api_ecommerce.user.validations;

import com.lucas.api_ecommerce.user.dto.CreateUserDto;
import org.springframework.stereotype.Component;

import static com.lucas.api_ecommerce.utils.FunctionsCpf.isValidCpf;

@Component
public class CpfValidation implements Validations{

    @Override
    public void validation(CreateUserDto dto){
        String cpf = dto.getCpf();
        if(!isValidCpf(cpf)){
            throw new IllegalArgumentException("CPF inválido.");
        }
    }
}
