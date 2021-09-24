package mx.santander.fiduciario.instruccionconsulta.service;

import java.util.List;

import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsResDto;
import mx.santander.fiduciario.instruccionconsulta.model.InstruccionEnviada;

public interface IInstructionSentService {

	List<InstruccionEnviada> findByBucAndNoContrAndNoSubContr(String idBuc, Long idNoContr, Long idNoSubContr);
	
	InstructionsResDto findAll(String idBuc, Long idNoContr, Long idNoSubContr);
	
}
