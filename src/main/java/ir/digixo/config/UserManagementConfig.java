package ir.digixo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class UserManagementConfig {


    private final ProductPermissionEvaluator productPermissionEvaluator;


    public UserManagementConfig(ProductPermissionEvaluator bookPermissionEvaluator) {
        this.productPermissionEvaluator = bookPermissionEvaluator;
    }

    @Bean
    //Makes the returned MethodSecurityExpressionHandler object a bean in the Spring context
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        //Creates a default security expression handler to set up the custom permission evaluator
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        //Sets up the custom permission evaluator
        expressionHandler.setPermissionEvaluator(productPermissionEvaluator);
        //Returns the custom expression handler to be added to the Spring context
        return expressionHandler;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var service = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("mahsa") .password("1234") .roles("manager") .build();
        var u2 = User.withUsername("ashkan") .password("1234") .roles("admin") .build();
        var u3 = User.withUsername("nader") .password("1234") .authorities("user") .build();

        service.createUser(u1);
        service.createUser(u2);
        service.createUser(u3);
        return service;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
