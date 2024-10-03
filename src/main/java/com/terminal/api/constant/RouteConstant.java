package com.terminal.api.constant;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public class RouteConstant {
	
	public static final String BASE_PATH = "${api.uri.basePath}";
	public static final String API_VERSION = "${api.version}";
	
	
    /**
     * URL PROCESS CONTROL
     **/
    public static final String PROCESS_CONTROL_SAVE_PATH = "${api.uri.process.control.save.mapping}";
    public static final String PROCESS_CONTROL_UPDATE_PATH = "${api.uri.process.control.update.mapping}";
    public static final String PROCESS_CONTROL_GET_PATH = "${api.uri.process.control.get.mapping}";
    public static final String PROCESS_CONTROL_GET_BY_ID = "${api.uri.process.control.get.by.id.mapping}";
    public static final String PROCESS_CONTROL_RETRIEVE_PATH = "${api.uri.process.control.retrieve.mapping}";
    public static final String PROCESS_CONTROL_RETRIEVE_FILTER_PATH = "${api.uri.process.control.retrieve.filter.mapping}";
    
      
    /**
     * URL DISPATCH ENTRY
     **/
    public static final String DISPATCH_ENTRY_SAVE_PATH = "${api.uri.dispatch.entry.save.mapping}";
    public static final String DISPATCH_ENTRY_UPDATE_PATH = "${api.uri.dispatch.entry.update.mapping}";
    public static final String DISPATCH_ENTRY_GET_PATH = "${api.uri.dispatch.entry.get.mapping}";
    public static final String DISPATCH_ENTRY_GET_BY_ID = "${api.uri.dispatch.entry.get.by.id.mapping}";
    public static final String DISPATCH_ENTRY_RETRIEVE_PATH = "${api.uri.dispatch.entry.retrieve.mapping}";
    public static final String DISPATCH_ENTRY_RETRIEVE_FILTER_PATH = "${api.uri.dispatch.entry.retrieve.filter.mapping}";
    
    
	public static final String APPLICATION_FILE_STORAGE_BASE_PATH="${application.file.storage.base.path}";

	private RouteConstant() {}
}
