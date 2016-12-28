package de.heinemann.config;

import static com.stormpath.spring.config.StormpathWebSecurityConfigurer.stormpath;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .apply(stormpath())
            .and().authorizeRequests().antMatchers("/").permitAll()
            .and().authorizeRequests().antMatchers("/schedule").permitAll()
            .and().authorizeRequests().antMatchers("/teams/**").permitAll()
            .and().authorizeRequests().antMatchers("/anyUser").fullyAuthenticated();
    }
    
}