package mx.santander.fiduciario.instruccionconsulta.dto.instruction.list;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstructionsFileDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String url;

}
