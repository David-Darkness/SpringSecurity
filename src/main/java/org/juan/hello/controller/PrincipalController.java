package org.juan.hello.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.juan.hello.controller.request.CreateUserDTO;
import org.juan.hello.model.ERole;
import org.juan.hello.model.RoleEntity;
import org.juan.hello.model.UserEntity;
import org.juan.hello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @Autowired
    private PasswordEncoder passwordEncoder; //CREAMOS LA SEGURIDAD DE LA CONTRASEÑA

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/hello")
    public String hello(){
        return "Hello World NOT SECURED";
    }

    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello World SECURED";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createdUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                        .map(role -> RoleEntity.builder()
                                .name(ERole.valueOf(role))
                                .build())
                        .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword())) //se inserta encriptada
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado el usuario"+ id;
    }


}
