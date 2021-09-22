package mx.santander.fiduciario.instruccionconsulta.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import mx.santander.fiduciario.instruccionconsulta.config.InstruccionConsultaConfig;
import mx.santander.fiduciario.instruccionconsulta.exception.InstruccionConsultaInexistenteException;
import mx.santander.fiduciario.instruccionconsulta.model.InstruccionConsulta;
import mx.santander.fiduciario.instruccionconsulta.service.IInstruccionConsultaService;
import mx.santander.fiduciario.instruccionconsulta.service.InstruccionConsultaService;
import mx.santander.fiduciario.instruccionconsulta.repository.IInstruccionConsultaRepository;


@RunWith(SpringRunner.class)
public class InstruccionConsultaServiceTest {


	@TestConfiguration
    static class InstruccionConsultaServiceConfig {
        @Bean
        public IInstruccionConsultaService instruccionconsultaService() {
            return new InstruccionConsultaService();
        }
    }


	/** La Constante LOGGER. Obtiene el Logger de la clase */
	private static final Logger LOGGER = LoggerFactory.getLogger(InstruccionConsultaServiceTest.class);	

	private static final Long ID = 1L;
	
	private static final String NOMBRE = "NOMBRE";


    @Autowired
    private IInstruccionConsultaService service;

    @MockBean
	private InstruccionConsultaConfig config;
    
    @MockBean
    private IInstruccionConsultaRepository instruccionconsultaRepository;
    





    @Test
    public void consultarInstruccionConsulta() throws InstruccionConsultaInexistenteException {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionConsulta> instruccionconsultaMock = Optional.of(new InstruccionConsulta(ID, NOMBRE));
    	when(instruccionconsultaRepository.findById(ID)).thenReturn(instruccionconsultaMock);
    	
    	//ejecuta service
    	InstruccionConsulta instruccionconsulta = service.consultarInstruccionConsulta(ID);
    	
    	LOGGER.info("Se ejecuta service");
    	//En este caso, solamente valida que el objeto retornado por el repository sea igual que el objeto devuelto por el service
    	assertThat(instruccionconsulta).isEqualToComparingFieldByField(instruccionconsultaMock.get());
    }
    
    
    @Test
    (expected = InstruccionConsultaInexistenteException.class)
    public void consultarInstruccionConsultaInexistenteException() throws InstruccionConsultaInexistenteException{

    	//mock de bean no existente al consultar el repositorio
    	Optional<InstruccionConsulta> instruccionconsultaMock = Optional.ofNullable(null);
    	when(instruccionconsultaRepository.findById(ID)).thenReturn(instruccionconsultaMock);

    	LOGGER.info("Se ejecuta service");
    	//en este caso, debe arrojarse una excepcion de InstruccionConsultaInexistenteException
    	service.consultarInstruccionConsulta(ID);
    	
    }





	@Test
	public void crearInstruccionConsulta() {

		//mock de bean encontrado al consultar el repositorio
		InstruccionConsulta instruccionconsultaMockEntrada = new InstruccionConsulta();
		instruccionconsultaMockEntrada.setNombre(NOMBRE);
		InstruccionConsulta instruccionconsultaMockSalida = new InstruccionConsulta(ID, instruccionconsultaMockEntrada.getNombre());
		when(instruccionconsultaRepository.save(instruccionconsultaMockEntrada)).thenReturn(instruccionconsultaMockSalida);
		
		//ejecuta service
		InstruccionConsulta instruccionconsulta = service.crearInstruccionConsulta(instruccionconsultaMockEntrada);


    	LOGGER.info("Se ejecuta service");
		//En este caso, solamente valida que el id del objeto retornado por el repository sea igual que el id objeto devuelto por el service
		assertThat(instruccionconsulta).isEqualTo(instruccionconsultaMockSalida);

	}






    @Test
    public void actualizarInstruccionConsulta() throws InstruccionConsultaInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionConsulta> instruccionconsultaMock = Optional.of(new InstruccionConsulta(ID, NOMBRE));
    	when(instruccionconsultaRepository.findById(ID)).thenReturn(instruccionconsultaMock);
    	when(instruccionconsultaRepository.save(instruccionconsultaMock.get())).thenReturn(new InstruccionConsulta(ID, NOMBRE));

    	LOGGER.info("Se ejecuta service");
    	service.actualizarInstruccionConsulta(instruccionconsultaMock.get());
    }

    
    @Test
	(expected = InstruccionConsultaInexistenteException.class)
    public void actualizarInstruccionConsultaInexistenteException() throws InstruccionConsultaInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionConsulta> instruccionconsultaMock = Optional.ofNullable(null);
    	when(instruccionconsultaRepository.findById(ID)).thenReturn(instruccionconsultaMock);

    	LOGGER.info("Se ejecuta service");
    	service.actualizarInstruccionConsulta(new InstruccionConsulta(ID, NOMBRE));
    }

    
    
    
   

    @Test
    public void eliminarInstruccionConsulta() throws InstruccionConsultaInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionConsulta> instruccionconsultaMock = Optional.of(new InstruccionConsulta(ID, NOMBRE));
    	when(instruccionconsultaRepository.findById(ID)).thenReturn(instruccionconsultaMock);

    	LOGGER.info("Se ejecuta service");
    	service.eliminarInstruccionConsulta(ID);
    }

    
    @Test
    (expected = InstruccionConsultaInexistenteException.class)
    public void eliminarInstruccionConsultaInexistenteException() throws InstruccionConsultaInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionConsulta> instruccionconsultaMock = Optional.ofNullable(null);
    	when(instruccionconsultaRepository.findById(ID)).thenReturn(instruccionconsultaMock);

    	LOGGER.info("Se ejecuta service");
    	service.eliminarInstruccionConsulta(ID);
    }



}