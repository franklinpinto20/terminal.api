package com.terminal.api.constant;

/**
 * 
 * 
 * @author gildardoortiz
 * Event note management API 
 * @Seguritech
 * 30 jun. 2021
 * @version 1.0.0
 */
public class ErrorConstant {

	public static final Integer ERROR_CODE_CONSTRAINT_ID_NULL_CODE = 89;

	/*COMMON ERRORS*/
	public static final Integer RECORD_NOT_FOUND_CODE = 90;
	public static final String RECORD_NOT_FOUND_MESSAGE = "No se encontró el registro";
	
	public static final Integer BAD_REQUEST_CODE = 91;
	public static final String BAD_REQUEST_MESSAGE = "Parametros incompletos, favor de revisar";
	
	public static final Integer ERROR_CODE_NO_RESULTS_CODE = 92;
	public static final String ERROR_CODE_NO_RESULTS_MESSAGE = "Sin resultado para la búsqueda";
	
	public static final Integer DATABASE_CONECTION_CODE = 93;
	public static final String DATABASE_CONECTION_MESSAGE = "Sin conexión a la base de datos";
	
	public static final Integer SAVING_MULTIMEDIA_ERROR_CODE = 94;
	public static final String SAVING_MULTIMEDIA_ERROR_MESSAGE = "Error al guardar el archivo";

	public static final Integer ERROR_CODE_CONSTRAINT_CODE = 95;
	public static final String ERROR_CODE_CONSTRAINT_MESSAGE = "Existe un elemento duplicado favor de revisar";
	
	public static final Integer ERROR_CODE_ALREADY_EXIST_INFO_CODE = 96;
	public static final String ERROR_CODE_ALREADY_EXIST_INFO_MESSAGE = "No es permitido realizar el registro de la información duplicada";

	/*GENERIC ERROR*/
	public static final Integer GENERIC_ERROR_CODE = 99;
	public static final String GENERIC_ERROR_MESSAGE = "Ocurrió un error desconocido";

	private ErrorConstant() {}

}
