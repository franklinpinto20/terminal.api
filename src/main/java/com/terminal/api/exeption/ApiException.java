package com.terminal.api.exeption;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public class ApiException extends RuntimeException {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 4121394588319496276L;

		
	public ApiException() {
    }

    public ApiException(String mensaje) {
        super(mensaje);
    }

    public ApiException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
