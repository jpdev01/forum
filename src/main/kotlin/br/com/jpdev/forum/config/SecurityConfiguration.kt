package br.com.jpdev.forum.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService
    ) : WebSecurityConfigurerAdapter() {

    override fun configure(web: HttpSecurity?) {
        http?.authorizeRequests()?.anyRequest()?.authenticated()?. // qualquer requisição precisa estar autenticada
        and()?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)?. // Nao quero que minha app nao guarde estado de autenticação
        and()?.formLogin()?.disable()?.httpBasic() // sem tela de login
    }

    @Bean // para ser gerenciado pelo Spring
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
    }
}