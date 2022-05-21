package ru.ksenideni.fitnesscenter.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final DataSource dataSource;

    //Аутентификация - проверка подлинности путем сравнения пароля и логина с данными в бд
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder());
    }

    //Авторизация - проверка разрешений на доступ к ресурсам
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().hasRole(UserRole.ADMIN.name())
                .and()
                .httpBasic();
    }

    //password configuration
    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsManager configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        JdbcUserDetailsManagerConfigurer jdbcUserDetailsManagerConfigurer = auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder());
        return jdbcUserDetailsManagerConfigurer.getUserDetailsService();
    }
}
