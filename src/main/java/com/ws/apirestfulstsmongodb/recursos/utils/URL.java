package com.ws.apirestfulstsmongodb.recursos.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodificarParam(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF8");
		}
		catch (UnsupportedEncodingException e) {			
			return "";
		}
	}
}
