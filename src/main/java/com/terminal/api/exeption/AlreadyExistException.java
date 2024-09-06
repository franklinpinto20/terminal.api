package com.terminal.api.exeption;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public class AlreadyExistException extends RuntimeException {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4163647676339193092L;
	
	public AlreadyExistException() {
    }

    public AlreadyExistException(String mensaje) {
        super(mensaje);
    }

    public AlreadyExistException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public AlreadyExistException(Throwable cause) {
        super(cause);
    }
	
}
