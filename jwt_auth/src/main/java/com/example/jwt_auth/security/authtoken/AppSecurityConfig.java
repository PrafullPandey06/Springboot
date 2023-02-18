package com.example.jwt_auth.security.authtoken;

import com.example.jwt_auth.security.jwt.JwtAuthenticationConverter;
import com.example.jwt_auth.security.jwt.JwtAuthenticationFilter;
import com.example.jwt_auth.security.jwt.JwtAuthenticationManager;
import com.example.jwt_auth.security.jwt.JwtService;
import com.example.jwt_auth.users.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
//        return new JwtAuthenticationFilter(
//                new JwtAuthenticationManager(),
//                new JwtAuthenticationConverter()
//        ); // we need auth manager and auth converter
//    }
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    public AppSecurityConfig(
            JwtService jwtService,
            UserService userService
    ) {
       jwtAuthenticationFilter = new JwtAuthenticationFilter(
               new JwtAuthenticationManager(
                       jwtService, userService
               )
       );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO: in production cors and CSRF shouldn't be blanket diasbled
        http.cors().disable().csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET,"/about").permitAll() // this will allow anyone to access the about page
            .antMatchers((HttpMethod.POST),"/users","/users/login").permitAll() // this will allow anyone to create a user
            .antMatchers("/*/**").authenticated()
            .and()
            .addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class) // so our authentication must happen before anonymous authentication is just a fallback
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        super.configure(http);
    }
}
// we add jwtAuthenticationFilter before AnonymousAuthenticationFilter so that if request is not authenticated than spring will treaat it
// as a anonymous request
//-----------------------------------------------------------------------------------------------------------------------------------------
// this class has @configuration annotation so it is place where dependency injection happens
// whereas ApllicationFilter does not have any annotation so dependency injection can't happen there
// for proper explanation of dependency injection look Applicaation Manager class