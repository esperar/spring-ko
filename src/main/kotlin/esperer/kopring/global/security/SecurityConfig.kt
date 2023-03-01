package esperer.kopring.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.kopring.global.filter.config.FilterConfig
import esperer.kopring.global.security.handler.CustomAuthenticationEntryPoint
import esperer.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            // Auth
            .mvcMatchers(HttpMethod.POST, "/auth").permitAll()
            .mvcMatchers(HttpMethod.PATCH, "/auth").permitAll()
            .mvcMatchers(HttpMethod.DELETE, "/auth").authenticated()
            .mvcMatchers(HttpMethod.POST, "/auth/signup").permitAll()
            .mvcMatchers(HttpMethod.PATCH, "/auth/password/initialize").permitAll()
            .mvcMatchers(HttpMethod.PATCH, "/auth/image").permitAll()
            .mvcMatchers(HttpMethod.DELETE, "/auth/image").permitAll()

            // Email
            .mvcMatchers(HttpMethod.POST, "/email").permitAll()
            .mvcMatchers(HttpMethod.GET, "/email/authentication").permitAll()
            .mvcMatchers(HttpMethod.GET, "/email").permitAll()

            // Admin
            .mvcMatchers("/admin/**").hasRole("ADMIN")

            // User
            .mvcMatchers("/user/**").authenticated()

            // Post
            .mvcMatchers(HttpMethod.POST,"/post").authenticated()
            .mvcMatchers(HttpMethod.GET, "/post/**").authenticated()
            .mvcMatchers(HttpMethod.PATCH, "/post/**").authenticated()
            .mvcMatchers(HttpMethod.DELETE, "post/**").authenticated()

            .anyRequest().permitAll()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

            .and()
            .apply(FilterConfig(jwtTokenProvider, objectMapper))

            .and()
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
