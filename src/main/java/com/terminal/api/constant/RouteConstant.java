package com.terminal.api.constant;

/**
 * 
 * @author Franklin pinto
 * @Project Information Panel Management
 * @Seguritech
 * 9/09/2021
 * @version 1.0.0
 */
public class RouteConstant {
	
	public static final String BASE_PATH = "${api.uri.basePath}";
	public static final String API_VERSION = "${api.version}";
	
	/**
	 * URL FAILURE TYPE 
	**/
	public static final String FAILURE_TYPE_SAVE_PATH = "${api.uri.failure.type.save.mapping}";
	public static final String FAILURE_TYPE_RETRIEVE_PATH = "${api.uri.failure.type.retrieve.mapping}";
	public static final String FAILURE_TYPE_GET_BY_ID_PATH = "${api.uri.failure.type.get.mapping}";
	public static final String FAILURE_TYPE_UPDATE_PATH = "${api.uri.failure.type.update.mapping}";
	public static final String FAILURE_TYPE_DELETE_PATH = "${api.uri.failure.type.delete.mapping}";
	public static final String FAILURE_TYPE_RETRIEVE_FILTER_PATH = "${api.uri.failure.type.retrieve.filter.mapping}";
	public static final String FAILURE_TYPE_GET_BY_NAME_PATH = "${api.uri.failure.type.get.by.name.mapping}";

	/**
	 * URL FONT TYPE 
	**/
	public static final String FONT_TYPE_SAVE_PATH = "${api.uri.font.type.save.mapping}";
	public static final String FONT_TYPE_RETRIEVE_PATH = "${api.uri.font.type.retrieve.mapping}";
	public static final String FONT_TYPE_GET_BY_ID_PATH = "${api.uri.font.type.get.mapping}";
	public static final String FONT_TYPE_UPDATE_PATH = "${api.uri.font.type.update.mapping}";
	public static final String FONT_TYPE_DELETE_PATH = "${api.uri.font.type.delete.mapping}";
	public static final String FONT_TYPE_RETRIEVE_FILTER_PATH = "${api.uri.font.type.retrieve.filter.mapping}";
	public static final String FONT_TYPE_GET_BY_NAME_PATH = "${api.uri.font.type.get.by.name.mapping}";
	public static final String FONT_TYPE_IMAGE_GET_PATH = "${api.uri.font.type.image.get.mapping}";
	
	/**
	 * URL PANEL IMAGE 
	**/
	public static final String PANEL_IMAGE_SAVE_PATH = "${api.uri.panel.image.save.mapping}";
	public static final String PANEL_IMAGE_RETRIEVE_PATH = "${api.uri.panel.image.retrieve.mapping}";
	public static final String PANEL_IMAGE_GET_BY_ID_PATH = "${api.uri.panel.image.get.mapping}";
	public static final String PANEL_IMAGE_UPDATE_PATH = "${api.uri.panel.image.update.mapping}";
	public static final String PANEL_IMAGE_DELETE_PATH = "${api.uri.panel.image.delete.mapping}";
	public static final String PANEL_IMAGE_RETRIEVE_FILTER_PATH = "${api.uri.panel.image.retrieve.filter.mapping}";
	public static final String PANEL_IMAGE_GET_BY_NAME_PATH = "${api.uri.panel.image.get.by.name.mapping}";
	public static final String PANEL_IMAGE_IMAGE_GET_PATH = "${api.uri.panel.image.image.get.mapping}";

    /**
     * URL MESSAGE TYPE VALUE
     **/
    public static final String MESSAGE_TYPE_VALUE_SAVE_PATH = "${api.uri.message.type.value.save.mapping}";
    public static final String MESSAGE_TYPE_VALUE_UPDATE_PATH = "${api.uri.message.type.value.update.mapping}";
    public static final String MESSAGE_TYPE_VALUE_GET_PATH = "${api.uri.message.type.value.get.mapping}";
    public static final String MESSAGE_TYPE_VALUE_RETRIEVE_PATH = "${api.uri.message.type.value.retrieve.mapping}";
    public static final String MESSAGE_TYPE_VALUE_RETRIEVE_FILTER_PATH = "${api.uri.message.type.value.retrieve.filter.mapping}";
    public static final String MESSAGE_TYPE_VALUE_RETRIEVE_FILTER_BY_NAME_PATH = "${api.uri.message.type.value.retrieve.filter.by.name.mapping}";

    
    /**
     * URL ABBREVIATION VALUE
     **/
    public static final String ABBREVIATION_VALUE_SAVE_PATH = "${api.uri.abbreviation.value.save.mapping}";
    public static final String ABBREVIATION_VALUE_UPDATE_PATH = "${api.uri.abbreviation.value.update.mapping}";
    public static final String ABBREVIATION_VALUE_GET_PATH = "${api.uri.abbreviation.value.get.mapping}";
    public static final String ABBREVIATION_VALUE_RETRIEVE_PATH = "${api.uri.abbreviation.value.retrieve.mapping}";
    public static final String ABBREVIATION_VALUE_RETRIEVE_FILTER_PATH = "${api.uri.abbreviation.value.retrieve.filter.mapping}";
	
    /**
     * URL MESSAGE VALUE
     **/
    public static final String MESSAGE_VALUE_SAVE_PATH = "${api.uri.message.value.save.mapping}";
    public static final String MESSAGE_VALUE_UPDATE_PATH = "${api.uri.message.value.update.mapping}";
    public static final String MESSAGE_VALUE_GET_PATH = "${api.uri.message.value.get.mapping}";
    public static final String MESSAGE_VALUE_GET_BY_ID_TYPE_MESSAGE_PATH = "${api.uri.message.value.get.by.idType.message.mapping}";
    public static final String MESSAGE_VALUE_RETRIEVE_PATH = "${api.uri.message.value.retrieve.mapping}";
    public static final String MESSAGE_VALUE_RETRIEVE_LINES_PATH = "${api.uri.message.value.retrieve.lines.mapping}";
    public static final String MESSAGE_VALUE_RETRIEVE_FILTER_PATH = "${api.uri.message.value.retrieve.filter.mapping}";
    
    
    /**
     * URL PANEL DE MENSAJERIA VARIABLE VALUE
     **/
    public static final String PMV_SAVE_PATH = "${api.uri.pmv.save.mapping}";
    public static final String PMV_UPDATE_PATH = "${api.uri.pmv.update.mapping}";
    public static final String PMV_DELETE_PATH = "${api.uri.pmv.delete.mapping}";
    public static final String PMV_GET_PATH = "${api.uri.pmv.get.mapping}";
    public static final String PMV_RETRIEVE_PATH = "${api.uri.pmv.retrieve.mapping}";
    public static final String PMV_RETRIEVE_FILTER_PATH = "${api.uri.pmv.retrieve.filter.mapping}";
    public static final String PMV_AUDIT_RETRIEVE_FILTER_PATH = "${api.uri.pmv.audit.retrieve.filter.mapping}";
    public static final String PMV_RETRIEVE_FILTER_ADVANCE_PATH = "${api.uri.pmv.retrieve.filter.advance.mapping}";
    
    
    
    
    
	public static final String APPLICATION_FILE_STORAGE_BASE_PATH="${application.file.storage.base.path}";

	private RouteConstant() {}
}
