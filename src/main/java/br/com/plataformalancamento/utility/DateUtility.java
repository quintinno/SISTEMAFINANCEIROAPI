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
	private static final String FORMAT_MMAAAA = "MMyyyy";
	private static final String FORMAT_HORA = "H";
	private static final String FORMAT_MINUTO = "mm";
	private static final String FORMAT_SEGUNDO = "s";
	private static final String FORMAT_DDMMAAAA_HHMMSS = FORMAT_DD.concat("/").concat(FORMAT_MM).concat("/").concat(FORMAT_AAAA).concat(" à's' ").concat(FORMAT_HORA).concat(":").concat(FORMAT_MINUTO).concat(":").concat(FORMAT_SEGUNDO);
	private static final String FORMAT_AAAAMMDD = FORMAT_AAAA.concat("-").concat(FORMAT_MM).concat("-").concat(FORMAT_DD);

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

	// TODO --
	public static Date gerarDataVencimentoPorNumeroDiaVencimento(Integer numeroDiaVencimento, Date dataReferencia, Integer numeroMes) {
		Calendar dataCalculada = Calendar.getInstance();
			dataCalculada.setTime(dataReferencia);
			dataCalculada.add(Calendar.DAY_OF_MONTH, numeroDiaVencimento);
			dataCalculada.add(Calendar.MONTH, numeroMes);
		return dataCalculada.getTime();
	}

	public static Date acrescentarDiasData(Integer numeroDias, Date dataReferencia) {
		Calendar calendar = new GregorianCalendar();
			calendar.setTime(dataReferencia);
			calendar.add(Calendar.DAY_OF_MONTH, numeroDias);
		return calendar.getTime();
	}

	public static Date acrescentarMesData(Integer numeroDias, Date dataReferencia) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dataReferencia);
		calendar.add(Calendar.MONTH, numeroDias);
		return calendar.getTime();
	}

	private static SimpleDateFormat configurarFormatoData(String formatoDataHora) {
		return new SimpleDateFormat(formatoDataHora);
	}

	public static String gerarDataHoraAtualFormatoDDMMAAAAHHMMSS() {
		SimpleDateFormat simpleDateFormat = configurarFormatoData(FORMAT_DDMMAAAA_HHMMSS);
		return simpleDateFormat.format(new Date());
	}

	public static String gerarDataFormato(Date dataFormatar, String formato) {
		SimpleDateFormat simpleDateFormat = configurarFormatoData(formato);
		return simpleDateFormat.format(dataFormatar);
	}
	
	public static Date gerarDataFormatoDate(Integer anoReferencia, Integer mesReferencia, Integer diaMesReferencia) {
		return new GregorianCalendar(anoReferencia, mesReferencia-1, diaMesReferencia).getTime();
	}
	
	public static Date gerarDataVencimentoPorNumeroMesses(Date dataInicioVigenciaContrato, Integer numeroMesesVigenciaContrato) {
		Calendar dataVencimento = Calendar.getInstance();
			dataVencimento.setTime(corrigirData(dataInicioVigenciaContrato));
			dataVencimento.add(Calendar.MONTH, numeroMesesVigenciaContrato);
		return dataVencimento.getTime();
	}
	
	public static Date corrigirData(Date dataCorrecao) {
		return acrescentarDiasData(1, dataCorrecao);
	}
	
	public static Date converterDataStringEmDate(String dataString) throws ParseException {
		return DateUtility.configurarFormatoData(FORMAT_MMAAAA).parse(dataString);
	}
	
	public static Integer recuperarPrimeiroDiaMesCorrente() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, DateUtility.extrairNumeroMesData(new Date()));
		return calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
	}
	
	public static Integer recuperarUltimoDiaMesCorrente() {
		Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH, DateUtility.extrairNumeroMesData(new Date()));
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static Integer extrairNumeroMesData(Date dataExtrairNumeroMes) {
		GregorianCalendar dataGregorianCalendar = new GregorianCalendar();
			dataGregorianCalendar.setTime(dataExtrairNumeroMes);
		return dataGregorianCalendar.get(Calendar.MONTH);
	}
	
	public static Date converterNumeroDiaMesEmDataDoMesAnoParametro(Integer numeroMesCorrente, Integer numeroDiaMesCorrente) {
		return DateUtility.gerarDataFormatoDate(recuperarAnoCorrente(), (numeroMesCorrente + 1), (numeroDiaMesCorrente + 1));
	}
	
	public static Integer recuperarAnoCorrente() {
		Calendar gregoriaCalendar = GregorianCalendar.getInstance();
		return gregoriaCalendar.get(Calendar.YEAR);
	}
	
	public static Integer recuperarMesCorrente() {
		Calendar gregoriaCalendar = GregorianCalendar.getInstance();
			gregoriaCalendar.add(Calendar.DAY_OF_MONTH, 1);
			gregoriaCalendar.add(Calendar.MONTH, 1);
		return gregoriaCalendar.get(Calendar.MONTH);
	}
	
	public static Integer recuperarDiaCorrente() {
		Calendar gregoriaCalendar = GregorianCalendar.getInstance();
		return gregoriaCalendar.get(Calendar.DAY_OF_MONTH);
	}

	public static Date primeiroDiaMesCorrente() {
		return gerarDataFormatoDate(recuperarAnoCorrente(), recuperarMesCorrente(), recuperarPrimeiroDiaMesCorrente());
	}

	public static Date ultimoDiaMesCorrente() {
		return gerarDataFormatoDate(recuperarAnoCorrente(), recuperarMesCorrente(), recuperarUltimoDiaMesCorrente());
	}
	
}
