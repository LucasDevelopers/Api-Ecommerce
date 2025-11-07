package com.lucas.api_ecommerce.user.dto;

import com.lucas.api_ecommerce.user.User;
import com.lucas.api_ecommerce.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @NotBlank
    @Size(max = 10)
    private String firstName;

    @NotBlank
    @Size(max = 40)
    private String lastName;

    @NotBlank
    private String cpf;

    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "\\d{11}", message = "Telefone deve conter apenas números")
    private String phone;

    @NotBlank
    @Email(message = "E-mail inválido")
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(min = 6, max = 255)
    private String password;

    @NotBlank
    @Size(max = 32)
    private String userType;

    public User toEntity() {
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .cpf(this.cpf)
                .phone(this.phone)
                .email(this.email)
                .password(this.password)
                .userType(UserType.valueOf(this.userType))
                .build();
    }

}
