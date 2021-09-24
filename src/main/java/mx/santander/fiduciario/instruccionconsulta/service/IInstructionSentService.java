package mx.santander.fiduciario.instruccionconsulta.service;

import java.util.List;

import mx.santander.fiduciario.instruccionconsulta.dto.instruction.count.CountInstructionsResDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsResDto;
import mx.santander.fiduciario.instruccionconsulta.model.InstruccionEnviada;

public interface IInstructionSentService {

	List<InstruccionEnviada> findByBucAndNoContrAndNoSubContr(String idBuc, Long idNoContr, Long idNoSubContr);
	
	List<InstruccionEnviada> findByBucAndBusinessAndSubBusinessBetweenDates(String buc, Long business, Long subBusiness);
	
	
	InstructionsResDto findAll(String idBuc, Long idNoContr, Long idNoSubContr);
	
	CountInstructionsResDto countInstructions(String buc, Long business, Long subBusiness);
	
}
