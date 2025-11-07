package com.lucas.api_ecommerce.persona;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Persona {

    @NotBlank(message = "Primeiro nome é obrigatório")
    @Size(max = 10, message = "Primeiro nome pode ter no máximo 10 caracteres")
    private String firstName;

    @NotBlank(message = "Sobrenome é obrigatório")
    @Size(max = 40, message = "Sobrenome pode ter no máximo 40 caracteres")
    private String lastName;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter exatamente 11 caracteres")
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 11, max = 11, message = "Telefone deve ter exatamente 11 caracteres")
    private String phone;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String password;
}