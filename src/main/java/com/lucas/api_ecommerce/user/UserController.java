package com.lucas.api_ecommerce.user;

import com.lucas.api_ecommerce.user.dto.CreateUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> create(@RequestBody @Valid CreateUserDto user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Usuário criado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro interno no servidor.");
        }
    }

}
