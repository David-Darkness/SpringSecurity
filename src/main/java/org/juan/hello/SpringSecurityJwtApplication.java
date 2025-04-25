package org.juan.hello;

import org.juan.hello.model.ERole;
import org.juan.hello.model.RoleEntity;
import org.juan.hello.model.UserEntity;
import org.juan.hello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Bean
    CommandLineRunner init(){
        return args -> {
            UserEntity userEntity = UserEntity.builder()
                    .email("hola@gmai.com")
                    .username("david")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(RoleEntity.builder()
                            .name(ERole.valueOf(ERole.ADMIN.name()))
                            .build()))
                    .build();

            UserEntity userEntity2 = UserEntity.builder()
                    .email("hola@gmail.com")
                    .username("juan")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(RoleEntity.builder()
                            .name(ERole.valueOf(ERole.USER.name()))
                            .build()))
                    .build();

            UserEntity userEntity3 = UserEntity.builder()
                    .email("holacreator@gmai.com")
                    .username("CREATOR")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(RoleEntity.builder()
                            .name(ERole.valueOf(ERole.CREATOR.name()))
                            .build()))
                    .build();

            UserEntity userEntity4 = UserEntity.builder()
                    .email("holaeditor@gmai.com")
                    .username("EDITOR")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(RoleEntity.builder()
                            .name(ERole.valueOf(ERole.EDITOR.name()))
                            .build()))
                    .build();


            userRepository.save(userEntity);
            userRepository.save(userEntity2);
            userRepository.save(userEntity3);
        };
    }

}
