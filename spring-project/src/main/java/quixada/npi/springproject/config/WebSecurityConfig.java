package quixada.npi.springproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import quixada.npi.springproject.model.Papel;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers("public/**/**").permitAll()
                    .antMatchers("/webjars/**").permitAll()
                    .antMatchers("/swagger-ui.html").permitAll()
                    .antMatchers("/v2/api-docs").permitAll()
                    .antMatchers("/swagger-resources/**").permitAll()
                    .antMatchers("/usuarios").permitAll()
                    .antMatchers(HttpMethod.POST, "/cursos").hasAnyAuthority(Papel.ADMIN.getAuthority())
                    .antMatchers(HttpMethod.PUT, "/cursos/*").hasAnyAuthority(Papel.COORDENADOR.getAuthority())
                    .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }

}
