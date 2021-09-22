package mx.santander.fiduciario.instruccionconsulta.service;

import mx.santander.fiduciario.instruccionconsulta.model.InstruccionConsulta;
import mx.santander.fiduciario.instruccionconsulta.exception.InstruccionConsultaInexistenteException;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Interfaz publica para las operaciones de negocio de la entidad InstruccionConsulta
 */
public interface IInstruccionConsultaService {


	/**
	 * Consulta de entidad de negocio
	 * 
	 * @param id El id de la entidad a consultar
	 * @return Objeto de la entidad consultada
	 * @throws InstruccionConsultaInexistenteException Excepcion de entidad inexistente
	 */
	InstruccionConsulta consultarInstruccionConsulta(Long id) throws InstruccionConsultaInexistenteException;




	/**
	 * Creacion de entidad de negocio
	 * @param instruccionconsulta El objeto de la entidad a crear
	 * @return Entidad creada
	 */
	 InstruccionConsulta crearInstruccionConsulta(InstruccionConsulta instruccionconsulta);



	/**
	 * Actualizacion de entidad de negocio
	 * 
	 * @param instruccionconsulta El objeto de la entidad a actualizar
	 * @return instruccionconsulta El objeto en su estado actual
	 * @throws InstruccionConsultaInexistenteException Excepcion de entidad inexistente
	 */
	 InstruccionConsulta actualizarInstruccionConsulta(InstruccionConsulta instruccionconsulta) throws InstruccionConsultaInexistenteException;




	/**
	 * Eliminacion de entidad de negocio
	 * 
	 * @param id El id de la entidad a eliminar
	 * @throws InstruccionConsultaInexistenteException Excepcion de entidad inexistente
	 */
	void eliminarInstruccionConsulta(Long id) throws InstruccionConsultaInexistenteException;


}
