package mx.santander.fiduciario.instruccionconsulta.config;

import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Esta es la clase que permite por medio de sus anotaciones
 * inyectar las configuraciones personalizadas externalizadas 
 * (ya sea por medio del archivo bootstrap.yml
 * O bien por el servicio de configuracion referenciado por el mismo)
 */
@Configuration
@ConfigurationProperties(prefix="instruccion-consulta-service")
@Validated
public class InstruccionConsultaConfig {

	@NotEmpty
	private String nombreConfig;
	
	
	
	/**
	 * @return La descripcion de la configuracion
	 */
	public String getNombreConfig() {
		return nombreConfig;
	}

	/**
	 * @param nombreConfig La descripcion de la configuracion
	 */
	public void setNombreConfig(String nombreConfig) {
		this.nombreConfig = nombreConfig;
	}
	

}