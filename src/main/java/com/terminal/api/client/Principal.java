package com.terminal.api.client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */


public class Principal {
	// Crear un logger para esta clase
    private static final Logger logger = LoggerFactory.getLogger(Principal.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//TerminalesSuperTransporte t = new TerminalesSuperTransporte();
		logger.trace("Este es un mensaje TRACE");
        logger.debug("Este es un mensaje DEBUG");
        logger.info("Este es un mensaje INFO");
        logger.warn("Este es un mensaje WARN");
        logger.error("Este es un mensaje ERROR");
		
		try {
			/*
			 * 
			 * TerminalesSuperTransportePortType iTerminal = null;
			
			
			TerminalesSuperTransporte service = new TerminalesSuperTransporte();

			
			TerminalesSuperTransportePortType port = service.getTerminalesSuperTransportePort();
			
			String res=port.ingresoDespacho("830509855",
					"830509855", 
					"6781721", 
					new BigInteger("15"),
					"800152028", 
					new BigInteger("7"),
					new BigInteger("1"),
					"WLS933"
					,"54",
					"54001000",
					"54", 
					"54001000", 
					"NO ESPECIFICA", 
					"10/08/2024", 
					"5",
					"6", 
					new BigInteger("4"),
					new BigInteger("1"), 
					new BigInteger("1"), 
					null, null, null, 
					new BigInteger("2"), 
					new BigInteger("17700"), 
					new BigInteger("0"));
			
						System.out.println("Respuesa a"+res);
			*/
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}

}
