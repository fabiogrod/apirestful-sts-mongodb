package com.ws.apirestfulstsmongodb.recursos.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static String decodificarParam(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF8");
		}
		catch (UnsupportedEncodingException e) {			
			return "";
		}
	}
	
	public static Date converterData (String textoData, Date padrao) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone( TimeZone.getTimeZone("GMT") );
		
		try {
			return sdf.parse(textoData);
		}
		catch (ParseException e) {			
			return padrao;
		}
	}
	
	public static Date sdf (String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("Brazil/East"));	
		try {			
			return sdf.parse(data);
		}
		catch (ParseException e) {			
			return null;
		}
	}
}
