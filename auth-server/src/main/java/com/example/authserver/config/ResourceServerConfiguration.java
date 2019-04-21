package com.example.authserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Esta clase define las rutas accessibles como recursos de este server.<br>
 *   Es la contraparte del {@link AuthorizationServerConfiguration}
 *
 * Date: 21/04/19 - 20:07
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

//  @Autowired
//  private AuthenticationProvider authenticationProvider;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
//      .authenticationProvider(authenticationProvider)
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .httpBasic()
      .and()
      .csrf().disable();
  }

}
