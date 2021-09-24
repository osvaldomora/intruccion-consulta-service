package mx.santander.fiduciario.instruccionconsulta.mapper;

import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsBusinessDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsFileDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsStatusDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsSubBusinessDto;
import mx.santander.fiduciario.instruccionconsulta.dto.instruction.list.InstructionsTypeInstructionDto;
import mx.santander.fiduciario.instruccionconsulta.model.InstruccionEnviada;

/**
 * Clase que permite mapear instrucciones de model a DTO o vicerversa
 */
public final class InstructionMapper {
	
	/**
	 * Constructor que evita que la clase sea instanciada
	 */
	private InstructionMapper() {}
	
	public static InstructionsDto toDto(InstruccionEnviada instrModel) {
		InstructionsDto instructionsDto = null;
		
		instructionsDto= InstructionsDto.builder()
							.folio(instrModel.getIdFkBuc())
							.business(InstructionsBusinessDto.builder()
											.id(instrModel.getIdNoContr())
											.build())
							.subBusiness(InstructionsSubBusinessDto.builder()
											.id(instrModel.getIdNoSubContr())
											.build())
							.file(InstructionsFileDto.builder()
									.build())
							.typeInstruction(InstructionsTypeInstructionDto.builder()
												.id(instrModel.getTipoInstr().getIdList())
												.name(instrModel.getTipoInstr().getDscTpoInstr())
												.codeDoc(instrModel.getTipoInstr().getCodDoc().intValue())
												.build())
							.status(InstructionsStatusDto.builder()
										.description(instrModel.getEstatusInstr().getDscNombr())
										.build())
							.createdAt(instrModel.getFchRegisInsct())
							.build();
		
		return instructionsDto;
	}

}
