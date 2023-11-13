<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7

/*package com.example.musiclist2.jwt;
=======
/*
package com.example.musiclist2.jwt;
>>>>>>> efc5e56fe123792de05c875cb66d723342f6539b

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/private/**").authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}*/



<<<<<<< HEAD
=======
=======

/*package com.example.musiclist2.jwt;
=======
/*
package com.example.musiclist2.jwt;
>>>>>>> efc5e56fe123792de05c875cb66d723342f6539b

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/private/**").authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}*/



>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7
