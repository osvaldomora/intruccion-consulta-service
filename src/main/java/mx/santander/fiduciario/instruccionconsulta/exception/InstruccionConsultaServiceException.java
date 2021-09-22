package mx.santander.fiduciario.instruccionconsulta.exception;

import mx.santander.fiduciario.instruccionconsulta.util.ErrorEnum;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Clase de exception de negocio de los metodos de InstruccionConsulta
 */
public class InstruccionConsultaServiceException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    


    /**
     * Constructor
     * @param message Mensaje de error
     */
    public InstruccionConsultaServiceException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message Mensaje de error
     * @param causa Causa completa del error
     */
    public InstruccionConsultaServiceException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     */
    public InstruccionConsultaServiceException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     * @param causa Causa completa del error
     */
    public InstruccionConsultaServiceException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}