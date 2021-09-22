package mx.santander.fiduciario.instruccionconsulta.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import mx.santander.fiduciario.instruccionconsulta.exception.InstruccionConsultaInexistenteException;

import org.springframework.web.bind.annotation.GetMapping;
import java.net.URI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import mx.santander.fiduciario.instruccionconsulta.model.InstruccionConsulta;
import mx.santander.fiduciario.instruccionconsulta.service.IInstruccionConsultaService;

import org.owasp.encoder.Encode;


/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Esta clase se encarga de exponer los endpoints de acceso basado principios REST
 * Existen ciertas consultas, bajas, altas y actualizaciones a una coleccion de recursos de instruccionConsulta
 */
@RestController
@RequestMapping("/instruccionconsulta")
public class InstruccionConsultaController {
	 
	/** La Constante LOGGER. Obtiene el Logger de la clase */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstruccionConsultaController.class);
	
	@Autowired
	private IInstruccionConsultaService instruccionConsultaService;
	

	
    /**
     * Este es un ejemplo de un metodo HTTP GET consultando por id del recurso de tipo InstruccionConsulta
	 * y en la implementacion de la interfaz de negocio instruccionConsultaService 
	 * puede realizar ciertas transformaciones/agregaciones a la consulta para enriquecer la presentacion.
	 * 
	 * Este metodo es idempotente, y sus procesos derivados NUNCA deben modificar el estado de algun recurso en el servidor. 
	 * TODOS los procesos desencadenados deben ser solo de consulta.
	 * 
     * @param id Id de instruccionconsulta a dar de alta
     * @return Codigo de la operacion y objeto JSON obtenido
     * @throws InstruccionConsultaInexistenteException Excepcion de recurso inexistente
     */
	@ApiOperation(value = "Listar los InstruccionConsulta disponibles", notes = "Lista de InstruccionConsulta", response=ResponseEntity.class, httpMethod="GET", authorizations = {@Authorization(value="apiKey")})
		@GetMapping(value = "/{id}",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<InstruccionConsulta> consultarInstruccionConsultaPorId(@PathVariable("id") Long id) 
							throws InstruccionConsultaInexistenteException{
								
        LOGGER.debug("Entra a controller para consulta de la entidad");
        InstruccionConsulta instruccionconsulta;
        
		instruccionconsulta = instruccionConsultaService.consultarInstruccionConsulta(id);
        return new ResponseEntity<>(instruccionconsulta, HttpStatus.OK);
		
    }

    

    /**
     * Este es un ejemplo de un metodo HTTP POST, el cual en la implementacion de la interfaz de negocio instruccionConsultaService 
	 * crea un nuevo recurso bajo la coleccion /instruccionconsulta y puede realizar cierta logica de negocio adicional
	 * 
 	 * Este metodo es non-safe y NO es idempotente, por lo cual sus procesos derivados SIEMPRE afectaran el estado de un recurso en el servidor.
	 * En conjunto con un mecanismo de control de transaccionalidad en repositorios con estado, 
	 * puede es usado por ejemplo para orquestar transacciones financieras o de otro tipo
	 * 
     * @param instruccionconsulta InstruccionConsulta a dar de alta
     * @param ucBuilder Generador de URIs
     * @return Codigo de la operacion, y header con la URI de la ubicacion de nuevo recurso
     */
	@ApiOperation(value = "Alta de InstruccionConsulta", notes = "En el header Location devuelve el recurso que fue registrado", response=ResponseEntity.class, httpMethod="POST", authorizations = {@Authorization(value="apiKey")})				    
		@PostMapping(value = "",
						consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<Long> crearInstruccionConsulta(@Valid @RequestBody InstruccionConsulta instruccionconsulta, 
								UriComponentsBuilder ucBuilder) {

    	LOGGER.debug("Entra a controller, creacion : {}", Encode.forJava(instruccionconsulta.toString()));
    	InstruccionConsulta instruccionconsultaGen;
    
    	instruccionconsultaGen = instruccionConsultaService.crearInstruccionConsulta(instruccionconsulta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(instruccionconsultaGen.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
    }



    /**
     * Este es un ejemplo de un metodo HTTP PUT, el cual en la implementacion de la interfaz de negocio instruccionConsultaService 
	 * se encarga de actualizar el estado de un recurso en particular de la coleccion /instruccionconsulta
	 * 
	 * Este metodo es idempotente y sus procesos derivados son idoneos para actualizar el estado de algun recurso EXISTENTE en el servidor
     * 
     * @param id Id de instruccionconsulta
     * @param instruccionconsulta InstruccionConsulta a dar de alta
     * @return Codigo http indicando si la actualizacion fue exitosa
     * @throws InstruccionConsultaInexistenteException Excepcion de recurso inexistente
     */
	@ApiOperation(value = "Actualizacion de InstruccionConsulta", notes = "Actualizacion de InstruccionConsulta", response=ResponseEntity.class, httpMethod="PUT", authorizations = {@Authorization(value="apiKey")})					    
		@PutMapping(value = "/{id}",
					consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<InstruccionConsulta> actualizarInstruccionConsulta(@PathVariable("id") Long id, 
				@Valid @RequestBody InstruccionConsulta instruccionconsulta) throws InstruccionConsultaInexistenteException{
		
    	LOGGER.debug("Entra a controller, actualizacion : {}", Encode.forJava(instruccionconsulta.toString()));
        
    	instruccionconsulta.setId(id);
		instruccionConsultaService.actualizarInstruccionConsulta(instruccionconsulta);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
    }


    /**
     * Este es un ejemplo de un metodo HTTP DELETE, el cual en la implementacion de la interfaz de negocio instruccionConsultaService 
	 * se encarga de eliminar un recurso en particular de la coleccion /instruccionconsulta
	 * 
	 * Este metodo es idempotente, y sus procesos derivados son idoneos para eliminar algun recurso existente en el servidor
	 * 
     * @param id Id de instruccionconsulta
     * @param instruccionconsulta InstruccionConsulta a dar de alta
     * @return Codigo http indicando si la eliminacion fue exitosa
     * @throws InstruccionConsultaInexistenteException Excepcion de recurso inexistente
     */
	@ApiOperation(value = "Eliminacion de InstruccionConsulta", notes = "Eliminacion de InstruccionConsulta", response=ResponseEntity.class, httpMethod="DELETE", authorizations = {@Authorization(value="apiKey")})    
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<InstruccionConsulta> eliminarInstruccionConsulta(@PathVariable("id") Long id) 
    						throws InstruccionConsultaInexistenteException{
					
    	LOGGER.debug("Entra a controller, eliminacion de instruccionconsulta");
        
		instruccionConsultaService.eliminarInstruccionConsulta(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
    }





}