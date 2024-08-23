package com.terminal.api.constant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

/**
 * 
 * @author gildardoortiz
 * @cad lite API 
 * @Seguritech
 * 16 jun. 2021
 * @version 1.0.0
 */
public class ContentTypeConstants {

	protected static Map<String, MediaType> s_mapMimeTypes = null;

	static {
		s_mapMimeTypes = new HashMap<String, MediaType>();
		s_mapMimeTypes.put("png", MediaType.IMAGE_PNG);
		s_mapMimeTypes.put("jpeg", MediaType.IMAGE_JPEG);
		s_mapMimeTypes.put("jpg", MediaType.IMAGE_JPEG);
		s_mapMimeTypes.put("rar", MediaType.APPLICATION_OCTET_STREAM);
	}

	public static MediaType getMimeType(String strKey) {
		return s_mapMimeTypes.get(strKey);
	}
}
