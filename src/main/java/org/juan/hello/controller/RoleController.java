package org.juan.hello.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    public class RoleController {

        @GetMapping("/home")
        public String home() {
            return "home";
        }

        @GetMapping("/access-denied")
        public String accessDenied() {
            return "access-denied"; // Nombre del archivo access-denied.html en /templates
        }



        @PreAuthorize("hasRole('ADMIN')")
        @GetMapping("/admin")
        public String adminPage() {
            return "roles/admin";
        }

        @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
        @GetMapping("/user")
        public String userPage() {
            return "roles/user";
        }

        @PreAuthorize("hasRole('CREATOR') or hasRole('ADMIN')")
        @GetMapping("/creator")
        public String creatorPage() {
            return "roles/creator";
        }

        @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
        @GetMapping("/editor")
        public String editorPage() {
            return "roles/editor";
        }
    }


