package mx.santander.fiduciario.instruccionconsulta.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.santander.fiduciario.instruccionconsulta.exception.InstruccionConsultaInexistenteException;
import mx.santander.fiduciario.instruccionconsulta.config.InstruccionConsultaConfig;

import java.util.Optional;

import mx.santander.fiduciario.instruccionconsulta.util.ErrorEnum;
import mx.santander.fiduciario.instruccionconsulta.repository.IInstruccionConsultaRepository;



import mx.santander.fiduciario.instruccionconsulta.model.InstruccionConsulta;

import org.owasp.encoder.Encode;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Esta es la clase principal de este microservicio, encargada de orquestador la logica de negocio relacionada 
 * solamente a instruccionConsulta y sus datos (persistencia)
 * 
 * En esta clase puede haber invocacion a otros componentes con sufijo *Service,
 * los cuales a su vez pudieran invocar a otros microservicios o APIs, pero sin contener logica de negocio.
 */
@Service
public class InstruccionConsultaService implements IInstruccionConsultaService {


	/** La Constante LOGGER. Obtiene el Logger de la clase */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstruccionConsultaService.class);
	
	@Autowired
	private IInstruccionConsultaRepository instruccionConsultaRepository;

	@Autowired
	private InstruccionConsultaConfig config;






	@Override
	public InstruccionConsulta consultarInstruccionConsulta(Long id) 
								throws InstruccionConsultaInexistenteException{

		Optional<InstruccionConsulta> instruccionconsulta;
						

		//Consulta repositorio por id de la entidad
		instruccionconsulta = instruccionConsultaRepository.findById(id);
		
		//En caso de no encontrarlo, arroja excepcion especifica
		if(!instruccionconsulta.isPresent()){
			throw new InstruccionConsultaInexistenteException(ErrorEnum.EXC_INEXISTENTE);
		}
		
		LOGGER.info("Consulta realizada: {}", Encode.forJava(instruccionconsulta.toString()));

		
		

		//TODO: Colocar logica de negocio relacionada al dominio funcional de InstruccionConsulta


		return instruccionconsulta.get();

	}
		
								


	@Override
	public InstruccionConsulta crearInstruccionConsulta(InstruccionConsulta instruccionconsulta) {

		//Realiza creacion de entidad en el repositorio
		InstruccionConsulta instruccionconsultaGen = instruccionConsultaRepository.save(instruccionconsulta);
		LOGGER.info("Creacion realizada: {}", Encode.forJava(instruccionconsultaGen.toString()));


	
		return instruccionconsultaGen;

	}

	


	@Override
	public InstruccionConsulta actualizarInstruccionConsulta(InstruccionConsulta instruccionconsulta) 
							throws InstruccionConsultaInexistenteException{

		//Consulta repositorio por id, y en caso de no encontrarlo, arroja excepcion especifica
		if(!instruccionConsultaRepository.findById(instruccionconsulta.getId()).isPresent()){
			throw new InstruccionConsultaInexistenteException(ErrorEnum.EXC_INEXISTENTE);
		}

		//Realiza actualizacion de entidad en el repositorio
		InstruccionConsulta instruccionconsultaGen = instruccionConsultaRepository.save(instruccionconsulta);
		LOGGER.info("Actualizacion realizada: {}", Encode.forJava(instruccionconsultaGen.toString()));



		return instruccionconsultaGen;

	}

		


	@Override
	public void eliminarInstruccionConsulta(Long id) 
							throws InstruccionConsultaInexistenteException{

		//Consulta repositorio por id, y en caso de no encontrarlo, arroja excepcion especifica
		if(!instruccionConsultaRepository.findById(id).isPresent()){
			throw new InstruccionConsultaInexistenteException(ErrorEnum.EXC_INEXISTENTE);
		}

		//Realiza eliminacion de entidad en el repositorio
		instruccionConsultaRepository.deleteById(id);
		LOGGER.info("Eliminacion realizada");

		


	}
		

}
