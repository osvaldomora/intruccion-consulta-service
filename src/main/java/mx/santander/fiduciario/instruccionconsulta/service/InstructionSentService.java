package mx.santander.fiduciario.instruccionconsulta.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsDataDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsResDto;
import mx.santander.fiduciario.instruccionconsulta.mapper.InstructionMapper;
import mx.santander.fiduciario.instruccionconsulta.model.InstruccionEnviada;
import mx.santander.fiduciario.instruccionconsulta.repository.IInstructionSendRepository;
import mx.santander.fiduciario.instruccionconsulta.util.DateTool;

@Setter
@Service
public class InstructionSentService implements IInstructionSentService{

	//La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(InstructionSentService.class);
	
	@Autowired
	private IInstructionSendRepository instructionSendRepository;
	
	@Override
	public List<InstruccionEnviada> findByBucAndNoContrAndNoSubContr(String idBuc, Long idNoContr, Long idNoSubContr) {
		//Se crea instancia
		List<InstruccionEnviada> listInstructionSend = new ArrayList<>();
		//Fecha hasta 3 meses anteriores
		Calendar date3monthLast = DateTool.getDateMinusOrSumMonth(new Date(), -3);
		LOGGER.info("Fecha 3 meses antes consulta-instrucciones: {}",date3monthLast.getTime());
		
		//Consulta a la BD
		listInstructionSend = this.instructionSendRepository.findByIdFkBucAndIdNoContrAndIdNoSubContrAndFchRegisInsctAfter(idBuc, idNoContr, idNoSubContr, date3monthLast.getTime());
		LOGGER.info("Tamaño de lista de instrucciones: {}",listInstructionSend.size());
				
		return listInstructionSend;
	}

	@Override
	public InstructionsResDto findAll(String idBuc, Long idNoContr, Long idNoSubContr) {
		//Instancia respuesta 
		InstructionsResDto instructionsResDto = InstructionsResDto.builder()
													.data(InstructionsDataDto.builder()
															.build())
													.build();
		//Se realiza consulta
		List<InstruccionEnviada> listInstrSent = this.findByBucAndNoContrAndNoSubContr(idBuc, idNoContr, idNoSubContr);
		if(listInstrSent.isEmpty()) {
			LOGGER.warn("Operacion: listarInstrucciones, method: findAll, buc: {}, business: {}, subBusiness: {}, no se contraron instruciones");
			//Regresa instancia con lista de intrucciones vacia
			return instructionsResDto;
		}
		
		//Se procesa instrucciones model a DTO
		List<InstructionsDto> instructions = new ArrayList<>();
		for(InstruccionEnviada instrSent : listInstrSent) {
			//Se mapea model a DTO
			InstructionsDto instructionDto = InstructionMapper.toDto(instrSent);
			
			/* Inicio
			 * Se setean datos de autorizacion y cause de estatus, url instruccion
			 * ya que no se cuenta por el momento, se realizara en sprint siguientes
			 */
			instructionDto.getFile().setUrl("localhost");
			instructionDto.getTypeInstruction().setAuthorization(false);	//No renecesita autorizacion, por le momento (instruccion sin comite tecnico)
			//Se crea mensaje de causa
			instructionDto.getStatus().setCause("Sin motivo");
			if("RECHAZADA".equalsIgnoreCase(instructionDto.getStatus().getDescription())) {
				instructionDto.getStatus().setCause("No se define la instrucción a detalle");
			}
			/*
			 * Fin 
			 */
			
			//Agrega instruccion a lista
			instructions.add(instructionDto);
		}	
		//Se agrega lista de Instrucciones DTO a respuesta final
		instructionsResDto.getData().setInstructions(instructions);
		return instructionsResDto;
	}

}
