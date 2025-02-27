package lk.ijse.spring_security_14.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customizer->customizer.disable());
        /*httpSecurity.authorizeHttpRequests(customizer->customizer.anyRequest().authenticated());*/
       /* httpSecurity.authorizeHttpRequests(customizer->customizer.requestMatchers("/customer").permitAll()).sessionManagement(
                session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore("","");*/


        return httpSecurity.build();
    }
}
