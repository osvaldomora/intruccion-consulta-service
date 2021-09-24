package mx.santander.fiduciario.instruccionconsulta.service;

import java.util.List;

import mx.santander.fiduciario.instruccionconsulta.dto.typeInstruction.download.TypeInstrFileDownloadDto;
import mx.santander.fiduciario.instruccionconsulta.dto.typeInstruction.list.TypeInstructionsDataResDto;
import mx.santander.fiduciario.instruccionconsulta.model.TipoInstruccionModel;

/**
 * Interfaz publica para las operaciones de negocio de la entidad TipoInstruccionModel
 */
public interface ITypeInstructionService {

	/**
	 * Consulta una lista de entidades  de tipo de instrucciones
	 * @return List<TipoInstruccionModel> Lista de objetos de la entidad consultada.
	 */
	List<TipoInstruccionModel> findAll();
	
	/**
	 * Consulta un tipo de instruccion por id
	 * @param id identificador unico de tipo de instruccion
	 * @return TipoInstruccionModel modelo de tipo de instruccion
	 */
	TipoInstruccionModel findById(Long id);
	
	
	/**
	 * Es la respuesta final del DTO donde se mapeara las entidades con las reglas del negocio.
	 * @return TypeInstructionsDataResDto Regresa objeto final DTO del negocio
	 */
	TypeInstructionsDataResDto findAllListTypInstr();
	
	/**
	 * Consulta la info para generar a descarga de un tipo de instruccion
	 * @param id Identificador del tipo de instruccion
	 * @return TypeInstructionFileDownload info para generar la descarga
	 */
	TypeInstrFileDownloadDto downloadDoc(Long id);
	
}
