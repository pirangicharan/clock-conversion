package com.ramcharan.Alien_Clock.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsService authentication(){
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("1234"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(admin);
//    }

    /*
    public SecurityFilterChain authorization(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        //.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(HttpMethod.GET,"/clock/alien-clock").permitAll()
                        .requestMatchers(HttpMethod.GET,"/clock/alien-date").permitAll()
                        .requestMatchers(HttpMethod.GET,"/clock/earth-clock").permitAll()
                        .requestMatchers(HttpMethod.GET,"/clock/earth-date").permitAll()
                );
        return httpSecurity.build();
    }
    @Bean
    WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

*/

}
