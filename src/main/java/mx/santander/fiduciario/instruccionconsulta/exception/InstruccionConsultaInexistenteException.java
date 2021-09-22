package mx.santander.fiduciario.instruccionconsulta.exception;

import mx.santander.fiduciario.instruccionconsulta.util.ErrorEnum;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Clase de excepcion de negocio cuando no existe InstruccionConsulta 
 */
public class InstruccionConsultaInexistenteException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    


    /**
     * Constructor
     * @param message Mensaje de error
     */
    public InstruccionConsultaInexistenteException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message Mensaje de error
     * @param causa Causa completa del error
     */
    public InstruccionConsultaInexistenteException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     */
    public InstruccionConsultaInexistenteException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     * @param causa Causa completa del error
     */
    public InstruccionConsultaInexistenteException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}