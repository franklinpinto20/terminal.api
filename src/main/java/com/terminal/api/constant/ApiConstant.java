package com.terminal.api.constant;


/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public abstract class ApiConstant {
	
	/*FEIGN CONSTANTS*/
	public static final String ERROR_CODE_FEIGN = "error code {}";
	public static final String ERROR_BODY_PARSE = "Falló la conversión de la respuesta, el formato de la capa de datos no corresponde al predefinido";
	public static final String TIME_REQ_ATTRIBUTE = "req.time";
	public static final String UUID_MDC_LABEL = "mdc.uuid";
	public static final String HEADER_UUID = "uuid";
	public static final String START_REQUEST = "Inicia Llamado [{}]";
	public static final String TIME_ELAPSED_MESSAGE = "Time elapsed for request round trip [{}]: {} ms";
	
	public static final String CORPORATION_FOLDER = "corporation/";
	public static final String CALL_TYPE_UNPRECEDENTED_FOLDER = "call_type_unprecedented/";
	public static final String INFORMATION_PANEL_SOURCE_FOLDER = "/";
	public static final String IMAGE_LOGIN_FOLDER = "login/";
	public static final String IMAGE_FONT_TYPE_FOLDER = "font-type/";
	public static final String STAGE_FOLDER = "stage/";
	public static final String TRANSPORT_TYPE_FOLDER = "transport/transport-type/";
	public static final String TRANSPORT_FOLDER = "transport/";
	public static final String USER_FOLDER = "user/";
	
	public static final String KEY_ADMIN_LOGIN_IMAGE = "login_image";
	public static final String KEY_ADMIN_LOGIN_IMAGE_DESCRIPTION = "imagen que se muestra en login";
	
	private ApiConstant() {} 
}
