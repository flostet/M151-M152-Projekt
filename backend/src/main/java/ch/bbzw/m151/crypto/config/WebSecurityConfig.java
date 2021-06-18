package ch.bbzw.m151.crypto.config;

import ch.bbzw.m151.crypto.auth.PgAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private final PgAuthenticationProvider authenticationProvider;

    @Autowired
    public WebSecurityConfig(final PgAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .regexMatchers("/coins/.*", "/wallets/.*", "/auth/login", "/auth/register", "/trades/.*", "/user/.*", "/coins/delete/.*", "/wallets/delete/id/.*")
                .permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf()
                .disable();
    }

    @Autowired
    public void globalSecurityConfiguration(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}
