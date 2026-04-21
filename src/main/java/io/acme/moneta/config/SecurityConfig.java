package io.acme.moneta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //Desactivamos el CSRF (esto es crucial para que funcionen los POST desde intelliJ o Postman)
                .csrf(AbstractHttpConfigurer::disable)
                //Configuracion de las reglas de las rutas
                .authorizeHttpRequests(auth -> auth.
                        // Permitimos que cualquiera pueda entrar a la ruta de registrar
                        requestMatchers("/api/v1/usuarios").permitAll().
                        //Cualquier otra ruta requerira autenticación
                        anyRequest().authenticated()
                );

            return http.build();

    }

}
