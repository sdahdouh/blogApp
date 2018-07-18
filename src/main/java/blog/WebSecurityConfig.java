package blog;

import blog.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests().antMatchers("/css/**","/img/**","/js/**","/users/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .httpBasic();
    }

 /*   @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
    return new BCryptPasswordEncoder();
    .passwordEncoder(passwordencoder())
*/



    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("miami").password("vice").roles("USER");

    }*/

    /*    @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests().
                    antMatchers("/","/home","/css/**","/img/**","/js/**").permitAll().
                    anyRequest().authenticated().
                    and().
                    formLogin().
                    loginPage("/login").usernameParameter("username").passwordParameter("password").
                    permitAll().
                    and().
                    logout().
                    permitAll();


                    http.authorizeRequests().
                antMatchers("/","/home","/posts/allposts").access("hasRole('ROLE_ADMIN')").
                anyRequest().permitAll().
                and().
                formLogin().
                loginPage("/login").usernameParameter("username").passwordParameter("password").
                permitAll().
                and().
                logout().
                permitAll();
        }*/
}
