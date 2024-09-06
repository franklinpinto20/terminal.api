package com.terminal.api.exeption;



/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public class SavingMediaExcption extends ApiException {


	/**
	 * Serial Version
	 */
	
	private static final long serialVersionUID = 5355582210022483640L;

	
	public SavingMediaExcption() {
    }

    public SavingMediaExcption(String mensaje) {
        super(mensaje);
    }

    public SavingMediaExcption(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public SavingMediaExcption(Throwable cause) {
        super(cause);
    }

}
