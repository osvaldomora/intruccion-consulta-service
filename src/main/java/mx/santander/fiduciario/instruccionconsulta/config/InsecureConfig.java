package mx.santander.fiduciario.instruccionconsulta.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Esta es la clase que permite agregar un perfil 
 * con ninguna validacion de seguridad para el consumo del servicio
 * Util solo para comenzar a desarrollar rapidamente en ambientes locales
 */
@Configuration
@Order(2147483627)
@Profile("local-insecure")
//Este perfil sirve unicamente para probar el servicio sin la validacion de JWT, CSRF y habilitando Swagger. 
//Se aconseja su uso solamente para ambientes locales
public class InsecureConfig extends WebSecurityConfigurerAdapter {

    /**
     * Permit all requests
     * @param http {@link HttpSecurity}
     * @throws Exception when error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();
    }
    
    
    /**
     * Ignore security for Swagger resources
     *
     * @param web WebSecurity
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-resources/**");
        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/webjars/**");
    }

}

