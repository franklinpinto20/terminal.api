package com.terminal.api.constant;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public class FeignConstant {

	/*FEIGN CONSTANTS*/
	public static final String ERROR_CODE_FEIGN = "error code {}";
	public static final String ERROR_BODY_PARSE = "Falló la conversión de la respuesta, el formato de la capa de datos no corresponde al predefinido";
	public static final String TIME_REQ_ATTRIBUTE = "req.time";
	public static final String UUID_MDC_LABEL = "mdc.uuid";
	public static final String HEADER_UUID = "uuid";
	public static final String START_REQUEST = "Inicia Llamado [{}]";
	public static final String TIME_ELAPSED_MESSAGE = "Time elapsed for request round trip [{}]: {} ms";
	
	private FeignConstant() {} 
}
