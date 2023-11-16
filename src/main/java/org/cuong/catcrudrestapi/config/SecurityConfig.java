package org.cuong.catcrudrestapi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // add support for JDBC, get users from db
    // spring will auto inject datasource
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        // use custom tables (members and roles vs authorities and users)
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");
        return jdbcUserDetailsManager;
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
            configure
                .requestMatchers(HttpMethod.GET, "api/cats").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "api/cats/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.PUT, "api/cats/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.POST, "api/cats").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "api/cats/**").hasRole("ADMIN")  
        );

        // user HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable cross site request forgery
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    // hard code users with plain text password
    /* @Bean
    InMemoryUserDetailsManager userDetailsManager() {

        UserDetails ana = User.builder()
            .username("ana")
            .password("{noop}ana123")
            .roles("EMPLOYEE")
            .build();
        UserDetails topson = User.builder()
            .username("topson")
            .password("{noop}topson123")
            .roles("EMPLOYEE", "MANAGER")
            .build();
        UserDetails notail = User.builder()
            .username("notail")
            .password("{noop}notail123")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(ana, topson, notail);
    } */
}
