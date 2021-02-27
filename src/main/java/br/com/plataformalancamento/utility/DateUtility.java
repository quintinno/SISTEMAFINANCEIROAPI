package br.com.plataformalancamento.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtility {

	private static final String FORMAT_AAAA = "yyyy";
	private static final String FORMAT_MM = "MM";
	private static final String FORMAT_DD = "dd";
	private static final String FORMAT_HORA = "H";
	private static final String FORMAT_MINUTO = "mm";
	private static final String FORMAT_SEGUNDO = "s";
	private static final String FORMAT_DDMMAAAA = FORMAT_DD.concat(FORMAT_MM).concat(FORMAT_AAAA);
	private static final String FORMAT_DDMMAAAA_HHMMSS = FORMAT_DD.concat("/").concat(FORMAT_MM).concat("/").concat(FORMAT_AAAA).concat(" - ").concat(FORMAT_HORA).concat(":").concat(FORMAT_MINUTO).concat(":").concat(FORMAT_SEGUNDO);
	
	public static String extrairAnoData(java.util.Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = configurarFormatoData(DateUtility.FORMAT_AAAA);
		return simpleDateFormat.format(date);
	}
	
	public static String extrairMesData(java.util.Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = configurarFormatoData(DateUtility.FORMAT_MM);
		return simpleDateFormat.format(date);
	}

	public static String extrairDiaData(java.util.Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = configurarFormatoData(DateUtility.FORMAT_DD);
		return simpleDateFormat.format(date);
	}

	public static Date gerarDataVencimentoPorNumeroDias(Integer numeroDias, Date dataReferencia) {
		Calendar dataCalculada = Calendar.getInstance();
			dataCalculada.setTime(dataReferencia);
			dataCalculada.add(Calendar.DAY_OF_MONTH, 1);
			dataCalculada.add(Calendar.MONTH, numeroDias);
		return dataCalculada.getTime();
	}

	public static Date acrescentarDiasData(Integer numeroDias, Date dataReferencia) {
		Calendar calendar = new GregorianCalendar();
			calendar.setTime(dataReferencia);
			calendar.add(Calendar.DAY_OF_MONTH, numeroDias);
		return calendar.getTime();
	}

	private static SimpleDateFormat configurarFormatoData(String formatoDataHora) {
		return new SimpleDateFormat(formatoDataHora);
	}

	public static String gerarDataHoraAtualFormatoDDMMAAAAHHMMSS() {
		SimpleDateFormat simpleDateFormat = configurarFormatoData(FORMAT_DDMMAAAA_HHMMSS);
		return simpleDateFormat.format(new Date());
	}
	
}
