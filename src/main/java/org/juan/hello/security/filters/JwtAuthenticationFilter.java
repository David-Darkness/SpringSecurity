/*
package org.juan.hello.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.juan.hello.model.UserEntity;
import org.juan.hello.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //inyectar la dependencia de jwtUtils por constructor
    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    //generar metodos principales

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        // Si la solicitud es para el login tradicional
        if (request.getRequestURI().equals("/login") && request.getMethod().equals("POST")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Autenticamos con el AuthenticationManager de Spring
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            return getAuthenticationManager().authenticate(authenticationToken);
        }

        // Si no es login tradicional, se maneja como un login con JWT (esto es tu configuración actual)
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        // Aquí es donde emitimos el JWT si la autenticación es exitosa
        User user = (User) authResult.getPrincipal();

        // Generamos el token
        String token = jwtUtils.generateAccessToken(user.getUsername());

        // Lo agregamos al header de la respuesta
        response.addHeader("Authorization", "Bearer " + token);

        // Preparamos una respuesta JSON con el token
        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
        httpResponse.put("message", "Autenticación correcta");
        httpResponse.put("username", user.getUsername());

        // Enviamos la respuesta
        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }

}
*/