package com.gabrielsousa.prolife.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gabrielsousa.prolife.security.JWTAuthenticationFilter;
import com.gabrielsousa.prolife.security.JWTAuthorizationFilter;
import com.gabrielsousa.prolife.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private JWTUtil jWTUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;;

	private static final String[] PUBLIC_MATCHERS = { 
			"/h2-console/**",
			"/users/**",
			"/user/**",
	};

//	private static final String[] PUBLIC_MATCHERS_GET = {
//	
//};
//
//private static final String[] PUBLIC_MATCHERS_POST = {
//	
//};

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
//		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
//		return http.formLogin(Customizer.withDefaults()).build();
//	}
	
//	@Bean
//	public RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder){
//		
//		RegisteredClient awuserClient = RegisteredClient
//				.withId("1")
//				.clientId("prolife_cli_app")
//				.clientSecret("@321")
//				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//				.scope("users:read")
//				.scope("users:write")
//				.tokenSettings(TokenSettings.builder()
//						.accessTokenTimeToLive(Duration.ofMinutes(10000))
//						.build())
//				.clientSettings(ClientSettings.builder()
//						.requireAuthorizationConsent(false)
//						.build())
//				.build();
//		
//		return new InMemoryRegisteredClientRepository(
//				Arrays.asList(awuserClient)
//		);
//	}
	
//	@Bean
//	public ProviderSettings providerSettings() {
//		return ProviderSettings.builder()
//				.issuer("http://localhost:8080")
//				.build();
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//    	if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
//    		http.headers().frameOptions().disable();
//    	}
	
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
//        	.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
//        	.antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
//          .antMatchers("/requests/**", "/products/**")
//				.hasAnyAuthority("Admin")
//				.hasAnyRole("Admin")
//				.hasAuthority("Admin")
//          .antMatchers("/requests/**").hasAnyAuthority("Admin")
//              .hasAnyAuthority("Admin", "Editor", "Salesperson")
//              .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
				.anyRequest().authenticated()
//	
////			.mvcMatchers("/contacts/**").hasAuthority("SCOPE_contacts")
////			.mvcMatchers("/messages/**").hasAuthority("SCOPE_messages").anyRequest().authenticated()
////		.and()
////			.oauth2ResourceServer(oauth2 -> oauth2
////					.opaqueToken(opaqueToken -> opaqueToken
////							.introspector(introspector())
////							))
//			
//				.opaqueToken()
//				.introspectionClientCredentials("prolife_cli_app", "@321")
//				.introspectionUri("http://localhost:4200/oauth/token")
//						.and().formLogin()
//							.loginPage("/login")
//								.usernameParameter("email")
//								.permitAll()
//						.and()
//							.rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
//						.and()
//							.logout().permitAll()
		;
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(authenticationConfiguration), jWTUtil));
		// TODO-Atenção JWT não está funcionando
//        http.addFilterBefore(new JWTAuthenticationFilter(jWTUtil), UsernamePasswordAuthenticationFilter.class);
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(authenticationConfiguration), jWTUtil,
				userDetailsService));
//        http.authenticationManager(new JWTAuthenticationFilter(authenticationManager(null),jWTUtil));
		http.headers().frameOptions().sameOrigin();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.apply(customDsl());

		return http.build();
	}
	
	// TODO-forma nova
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/**");
			}
		};
	}

}
