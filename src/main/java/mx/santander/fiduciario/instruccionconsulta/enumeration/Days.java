package mx.santander.fiduciario.instruccionconsulta.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Days {
	
	DOMINGO(1, "Domingo"),
	LUNES(2, "Lunes"),
	MARTES(3, "Martes"),
	MIERCOLES(4, "MiÃ©rcoles"),
	JUEVES(5, "Jueves"),
	VIERNES(6, "Viernes"),
	SABADO(7, "SÃ¡bado");
	
	private int id;
	private String name;

}