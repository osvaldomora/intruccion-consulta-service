package mx.santander.fiduciario.instruccionconsulta.mapper;

import mx.santander.fiduciario.instruccionconsulta.dto.typeInstruction.download.TypeInstrFileDownloadDto;
import mx.santander.fiduciario.instruccionconsulta.enumeration.FileInstruction;
import mx.santander.fiduciario.instruccionconsulta.model.TipoInstruccionModel;

public class TypeInstrFIleDownloadMapper {
	
	/**
	 * Constructor privado para evitar instancia
	 */
	private TypeInstrFIleDownloadMapper() {}
	
	public static TypeInstrFileDownloadDto toDto (TipoInstruccionModel tipoInstrModel) {
		TypeInstrFileDownloadDto typeInsFileDownloadDto = null;
		//Se crea nombre de archivo con extension
		StringBuffer fullNameDoc = new StringBuffer();
		fullNameDoc.append(tipoInstrModel.getDscTpoInstr())
					.append(".")
					.append(FileInstruction.PLANTILLA_DOCX.getFileExtension().getExtension());
		//Se mapea modelo a dto
		typeInsFileDownloadDto = TypeInstrFileDownloadDto.builder()
									.name(tipoInstrModel.getDscTpoInstr())
									.extension(FileInstruction.PLANTILLA_DOCX.getFileExtension().getExtension())
									.mimeType(FileInstruction.PLANTILLA_DOCX.getFileExtension().getMimeType())
									.docBase64(tipoInstrModel.getValInstr())
									.fullName(fullNameDoc.toString())
									.build();
		
		return typeInsFileDownloadDto;
	}
}
