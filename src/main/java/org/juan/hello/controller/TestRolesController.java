package org.juan.hello.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
        return "haz accedido con rol de administrador";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String accessUser(){
        return "haz accedido con rol de usuario";
    }

    @GetMapping("/accessCreator")
    @PreAuthorize("hasRole('CREATOR') or hasRole('ADMIN')")
    public String accessCreator(){
        return "haz accedido con rol de creador";
    }

    @GetMapping("/accessEditor")
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String accessEditor(){
        return "haz accedido con rol de editor";
    }

}
