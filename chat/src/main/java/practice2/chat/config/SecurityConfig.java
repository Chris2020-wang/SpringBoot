package practice2.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import practice2.chat.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // if the user wants to go to signup page, they don't need to login
        //but if want to go to other page like home.html, they will need to login first
        http.authorizeRequests()
                .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();
        //login page is handled by spring, note we do not have own login for login controller
        //because we are using http.formLogin, spring will use our login templates including the form inside it and create everything for us
        http.formLogin()
                .loginPage("/login")
                .permitAll();
        //after login successful, it will automatically jump to /chat page
        http.formLogin()
                .defaultSuccessUrl("/chat", true);
    }

}
