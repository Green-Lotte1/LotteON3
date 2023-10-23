package co.kr.lotteon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // 사이트 위변조 방지 비활성
                .csrf(CsrfConfigurer::disable) // 메서드 참조 연산자로 람다식을 간결하게 표현
                // 폼 로그인 설정
                .formLogin(config -> config.loginPage("/member/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/member/login?success=100")
                        .usernameParameter("uid")
                        .passwordParameter("pass"))

                // 로그아웃 설정
                .logout(config -> config
                        .logoutUrl("/member/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutSuccessUrl("/member/login?success=200"))

                // 인가 권한 설정
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/member/**").permitAll()
                        //.requestMatchers("/admin/**").hasAnyRole("ADMIN", "SELLER")
                        .requestMatchers("/admin/**").permitAll()
                        .requestMatchers("/cs/**").permitAll()
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/thumb/**", "/upload/**").permitAll()
                        .anyRequest().permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


}