package springhibern.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("R1");
        auth.inMemoryAuthentication().withUser("librarian").password("librarian").roles("R2");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("R3");
    }

    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "balls/**")
                .hasAnyRole("R1", "R2", "R3")
                .mvcMatchers(HttpMethod.POST, "/**")
                .hasAnyRole("R2", "R3")
                .mvcMatchers(HttpMethod.DELETE, "/**")
                .hasAnyRole( "R3")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();

    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
