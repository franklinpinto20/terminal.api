package com.terminal.api.exeption;



/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public class NotFoundException extends ApiException{
	
	/**
	 * Serial Version 
	 */
	private static final long serialVersionUID = 8170095564684044452L;

	public NotFoundException() {
    }

    public NotFoundException(String mensaje) {
        super(mensaje);
    }

    public NotFoundException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
