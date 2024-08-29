package com.terminal.api.client;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.math.BigInteger;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//TerminalesSuperTransporte t = new TerminalesSuperTransporte();
	
		
		try {
			TerminalesSuperTransportePortType iTerminal = null;
			
			
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
			
			
			
			List<EntryDispatchRequest> lst= new ArrayList<>();
			
			
			System.out.println("Respuesa a"+res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}

}
