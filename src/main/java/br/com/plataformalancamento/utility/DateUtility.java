package br.com.plataformalancamento.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtility {

	private static final String FORMAT_AAAA = "yyyy";
	private static final String FORMAT_MM = "MM";
	private static final String FORMAT_DD = "dd";
	
	public static String extrairAnoData(java.util.Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtility.FORMAT_AAAA);
		return simpleDateFormat.format(date);
	}
	
	public static String extrairMesData(java.util.Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtility.FORMAT_MM);
		return simpleDateFormat.format(date);
	}
	
	public static String extrairDiaData(java.util.Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtility.FORMAT_DD);
		return simpleDateFormat.format(date);
	}
	
//	private java.util.Date formatarData(String data) throws ParseException {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtility.FORMAT_AAAA);
//		return simpleDateFormat.parse(data);
//	}
	
}
