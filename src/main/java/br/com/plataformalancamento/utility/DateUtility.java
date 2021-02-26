package br.com.plataformalancamento.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	public static Date gerarDataVencimentoPorNumeroDias(Integer numeroDias, Date dataReferencia) {
		Calendar dataCalculada = Calendar.getInstance();
			dataCalculada.setTime(dataReferencia);
			dataCalculada.add(Calendar.DAY_OF_MONTH, 1);
			dataCalculada.add(Calendar.MONTH, numeroDias);
		return dataCalculada.getTime();
	}
	
}
