package com.gabrielsousa.prolife.config;

//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig 
//extends AuthorizationServerConfigurerAdapter 
{

//	@Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Value("${security.jwt.signing-key}")
//    private String signingKey;
//
//    @Bean
//    public TokenStore tokenStore(){
//        return new JwtTokenStore(accessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter(){
//        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
//        tokenConverter.setSigningKey(signingKey);
//        return tokenConverter;
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//            .tokenStore(tokenStore())
//            .accessTokenConverter(accessTokenConverter())
//            .authenticationManager(authenticationManager);
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//            .inMemory()
//            .withClient("my-angular-app")
//            .secret("@321")
//            .scopes("read", "write")
//            .authorizedGrantTypes("password")
//            .accessTokenValiditySeconds(1800);
//    }
}
