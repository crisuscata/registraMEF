/**
 * 
 */
package pe.gob.mef.registramef.bs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase para el manejo de las constantes del Sistema.
 * 
 * @author Carlos Aguilar
 * @version 2.0, 11/01/2012
 * 
 * 
 *          /----------Nombre----------/----fecha----/-------------Motivo------
 *          --------/ Carlos Aguilar Chamochumbi 11/01/2012 Creación de la
 *          clase
 * 
 * 
 */
public class PropertiesMg implements Serializable {

	private static final long serialVersionUID = -123125970677914710L;

	private static final Log log = LogFactory.getLog(PropertiesMg.class);
	
	private static final String archivo = "pe.gob.mef.registramef.bs.resources.Rutas";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(archivo);
	
	public static final String ESQUEMA = "REGISTRAMEF."; 
	
	private static final String SISTEM_PROPERTIES = "sistema";
	private static final String ALARMA_PROPERTIES = "alarma";
	private static File rootDir = null;
	public static final String ROOT_DIR = "root-registramef";
	public static final String PROPERTIES_DIR = "propiedades-registramef";
	private static final String AUXILIARES_DIR = "auxiliares";
	
	private static boolean imprimirrootsistema = true;
	
	private static Long ELIMINADO = null;
	private static Long CREADO = null;
	public static final String KEY_ELIMINADO = "DTEXPEDIENTES_ELIMINADO";
	public static final String KEY_CREADO = "DTEXPEDIENTES_CREADO";
	public static final Long DEFOULT_ELIMINADO = 0L;
	public static final Long DEFOULT_CREADO = 1L;
	
	public static final String KEY_SMTP_HOST_NAME = "SMTP_HOST";  
	public static final String KEY_SMTP_PORT = "SMTP_PORT";      
	public static final String KEY_SMTP_FROM_ADDRESS = "SMTP_FROM_ADDRESS";
	public static final String KEY_SMTP_FROM_PASSWORD = "SMTP_FROM_PASSWORD";
	public static final String KEY_SMTP_TO_ADDRESS = "SMTP_TO_ADDRESS";
	public static final String KEY_SMTP_SECURITY = "KEY_SMTP_SECURITY";
	public static final String KEY_SMTP_DEBUG = "KEY_SMTP_DEBUG";
	public static final String KEY_FILES = "FILES_TRANSFERENCIA";
	public static final String KEY_ESTADOS_REGISTROS_NUEVO = "ESTADOS_REGISTROS_NUEVO";
	public static final String KEY_ESTADOS_REGISTROS_ELIMINADO = "ESTADOS_REGISTROS_ELIMINADO";	
	
	public static final String DEFOULT_SMTP_HOST_NAME = "192.168.1.2";  
	public static final String DEFOULT_SMTP_PORT = "25";      
	public static final String DEFOULT_SMTP_FROM_ADDRESS = "cafach@hotmail.com";
	public static final String DEFOULT_SMTP_FROM_PASSWORD = "password";
	public static final String DEFOULT_SMTP_TO_ADDRESS = "cafach@hotmail.com";
	public static final String DEFOULT_SMTP_SECURITY = "0";
	public static final String DEFOULT_SMTP_DEBUG = "false";
	public static final String DEFOULT_ESTADOS_REGISTROS_NUEVO = "3";
	public static final String DEFOULT_ESTADOS_REGISTROS_ELIMINADO = "2";
	//MPINARES 12082019 - INICIO
	private static ResourceBundle bundle = null;
	private static String rootfolder = null;
	//MPINARES 12082019 - FIN
	
	public static final String KEY_ESTADOS_REGISTROS_FINALIZADO = "ESTADOS_REGISTROS_FINALIZADO";
	public static final String DEFOULT_ESTADOS_REGISTROS_FINALIZADO = "148";
	
	public static final String KEY_ESTADOS_REGISTROS_ACUMULADO = "ESTADOS_REGISTROS_ACUMULADO";
	public static final String DEFOULT_ESTADOS_REGISTROS_ACUMULADO = "149";
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOCARGO = "PRTPARAMETROS_IDPARAMTIPOCARGO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOCARGO = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOCONDICION = "PRTPARAMETROS_IDPARAMTIPOCONDICION";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOCONDICION = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOOBJETIVOS = "PRTPARAMETROS_IDPARAMTIPOOBJETIVOS";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOOBJETIVOS = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOSEXO = "PRTPARAMETROS_IDPARAMTIPOSEXO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOSEXO = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOCARGOUSEREXT = "PRTPARAMETROS_IDPARAMTIPOCARGOUSEREXT";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOCARGOUSEREXT = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPONIVELSTRATEG = "PRTPARAMETROS_IDPARAMTIPONIVELSTRATEG";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPONIVELSTRATEG = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOFACTOR = "PRTPARAMETROS_IDPARAMTIPOFACTOR";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOFACTOR = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOANIO = "PRTPARAMETROS_IDPARAMTIPOANIO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOANIO = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOFUENTE = "PRTPARAMETROS_IDPARAMTIPOFUENTE";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOFUENTE = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOGRUPO = "PRTPARAMETROS_IDPARAMTIPOGRUPO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOGRUPO = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOMACRO = "PRTPARAMETROS_IDPARAMTIPOMACRO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOMACRO = 0L;
	
	public static final String KEY_IDCOORDINADOR_REGIONAL = "IDCOORDINADOR_REGIONAL";
	public static final Long DEFOULT_IDCOORDINADOR_REGIONAL = 0L;
	
	public static final String KEY_IDSISTEMA_ADMINISTRATIVO_TODOS = "IDSISTEMA_ADMINISTRATIVO_TODOS";
	public static final Long DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS= 1L;
	
	public static final String KEY_IDSEDES_TODAS = "IDSEDES_TODAS";
	public static final Long DEFOULT_IDSEDES_TODAS= 30L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOMODOSCAPACITACION = "PRTPARAMETROS_IDPARAMTIPOMODOSCAPACITACION";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOMODOSCAPACITACION  = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPONIVELCAPACITACION = "PRTPARAMETROS_IDPARAMTIPONIVELCAPACITACION";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPONIVELCAPACITACION  = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOPRESTACIONCAPACITACION = "PRTPARAMETROS_IDPARAMTIPOPRESTACIONCAPACITACION";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOPRESTACIONCAPACITACION  = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOCAPACITACION = "PRTPARAMETROS_IDPARAMTIPOCAPACITACION";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOCAPACITACION  = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOMODALIDADSERVICIO = "PRTPARAMETROS_IDPARAMTIPOMODALIDADSERVICIO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOMODALIDADSERVICIO  = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOFINANCIAMIENTO = "PRTPARAMETROS_IDPARAMTIPOFINANCIAMIENTO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOFINANCIAMIENTO   = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOORIGEN = "PRTPARAMETROS_IDPARAMTIPOORIGEN";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOORIGEN  = 126L;
	
	public static final String KEY_PRTPARAMETROS_IDORIGEN_OFERTA = "PRTPARAMETROS_IDORIGEN_OFERTA";
	public static final Long DEFOULT_PRTPARAMETROS_IDORIGEN_OFERTA = 127L;
	
	public static final String KEY_PRTPARAMETROS_IDORIGEN_DEMANDA = "PRTPARAMETROS_IDORIGEN_DEMANDA";
	public static final Long DEFOULT_PRTPARAMETROS_IDORIGEN_DEMANDA = 140L;
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA = "PRTPARAMETROS_IDTIPO_PROGRAMADA";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA  = 121L;
	
	public static final String KEY_DIASHAB_PROGRAMAR = "DIASHAB_PROGRAMAR";
	public static final Long DEFOULT_DIASHAB_PROGRAMAR  = 3L;
	
	public static final String KEY_DIASHAB_EJECUCION = "DIASHAB_EJECUCION";
	public static final Long DEFOULT_DIASHAB_EJECUCION  = 2L;
	
	public static final String KEY_DIALIMIT_PROGRAMAR = "DIALIMIT_PROGRAMAR";
	public static final Long DEFOULT_DIALIMIT_PROGRAMAR  = 20L;
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_PRESENCIAL = "PRTPARAMETROS_IDTIPO_PRESENCIAL";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_PRESENCIAL  = 138L;
	
	//SPRINT17 INICIO
	public static final String KEY_PRTPARAMETROS_IDTIPO_TELEFONO = "PRTPARAMETROS_IDTIPO_TELEFONO";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_TELEFONO  = 139L;
	//SPRINT17 FIN
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_VIRTUAL = "PRTPARAMETROS_IDTIPO_VIRTUAL";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL  = 137L;
	
	public static final String KEY_PRTPARAMETROS_ID_GESTOR= "PRTPARAMETROS_ID_GESTOR";
	public static final Long DEFOULT_PRTPARAMETROS_ID_GESTOR  = 9L;
	
	public static final String KEY_PRTPARAMETROS_ID_ASISTGEST= "PRTPARAMETROS_ID_ASISTGEST";
	public static final Long DEFOULT_PRTPARAMETROS_ID_ASISTGEST  = 104L;
	
	public static final String KEY_PRTPARAMETROS_ID_TECNICO= "PRTPARAMETROS_ID_TECNICO";
	public static final Long DEFOULT_PRTPARAMETROS_ID_TECNICO  = 255L;
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA = "PRTPARAMETROS_IDTIPO_NOPROGRAMADA";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA  = 122L;
	
	public static final String KEY_PRTPARAMETROS_IDMODO_UNSISTEMA = "PRTPARAMETROS_IDMODO_UNSISTEMA";
	public static final Long DEFOULT_PRTPARAMETROS_IDMODO_UNSISTEMA  = 92L;
	
	public static final String KEY_PRTPARAMETROS_IDMODO_MULTISISTEMA = "PRTPARAMETROS_IDMODO_MULTISISTEMA";
	public static final Long DEFOULT_PRTPARAMETROS_IDMODO_MULTISISTEMA  = 93L;
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA= "PRTPARAMETROS_IDTIPO_SERVICIO_CAPA";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA  = 133L;
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN= "PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN  = 132L;
	
	public static final String KEY_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA= "PRTPARAMETROS_IDTIPO_SERVICIO_VISITA";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA  = 134L;
	public static final String KEY_PRTPARAMETROS_IDTIPO_SERVICIO = "PRTPARAMETROS_IDTIPO_SERVICIO";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO = 131L;
	public static final String KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA = "PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA = 135L;
	public static final String KEY_PRTPARAMETROS_IDTIPO_SERVICIO_SEGUIMIENTO = "PRTPARAMETROS_IDTIPO_SERVICIO_SEGUIMIENTO";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_SEGUIMIENTO = 355L;
	
	public static final String KEY_ESTADOS_REGISTROS_CAMBIO_ACTIVIDAD = "ESTADOS_REGISTROS_CAMBIO_ACTIVIDAD";
	public static final Long DEFOULT_ESTADOS_REGISTROS_CAMBIO_ACTIVIDAD = 354L;
	
	public static final String KEY_PRTPARAMETROS_IDDESTINATARIOCARGO = "PRTPARAMETROS_IDDESTINATARIOCARGO";
	public static final Long DEFOULT_PRTPARAMETROS_IDDESTINATARIOCARGO = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMCARACTERISTICAALERTA = "RTPARAMETROS_IDPARAMCARACTERISTICAALERTA";
	public static final Long DEFOULT_RTPARAMETROS_IDPARAMCARACTERISTICAALERTA = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMCARACTERISTICA = "PRTPARAMETROS_IDPARAMCARACTERISTICA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMCARACTERISTICA = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMDIA = "PRTPARAMETROS_IDPARAMDIA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMDIA = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMHORA = "PRTPARAMETROS_IDPARAMHORA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMHORA = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOENTIDAD = "PRTPARAMETROS_IDPARAMTIPOENTIDAD";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOENTIDAD = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMCOPIACORREO = "PRTPARAMETROS_IDPARAMCOPIACORREO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMCOPIACORREO = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMACTIVIDAD = "PRTPARAMETROS_IDPARAMACTIVIDAD";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMACTIVIDAD = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMLUGARVISITA = "PRTPARAMETROS_IDPARAMLUGARVISITA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMLUGARVISITA = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMORIGENOFERTA = "PRTPARAMETROS_IDPARAMORIGENOFERTA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMORIGENOFERTA = 0L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPOACTIVIDADPROGRAMADO = "PRTPARAMETROS_IDPARAMTIPOACTIVIDADPROGRAMADO";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPOACTIVIDADPROGRAMADO = 0L;
	// End Edner Llacsa
	
	//IVILLAFANA 3112018 - INICIO
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE = "PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE  = 342L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG = "PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG  = 343L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC = "PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC  = 344L;
	//IVILLAFANA 3112018 - FIN
	
	//IVILLAFANA 2112018 - INICIO
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPO_SIST_ADMI_INVERSION_PUBLICA = "PRTPARAMETROS_IDPARAMTIPO_SIST_ADMI_INVERSION_PUBLICA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPO_SIST_ADMI_INVERSION_PUBLICA = 7L;
	
	public static final String KEY_PRTPARAMETROS_IDPARAMTIPO_ESPECIALISTA_INVERSION_PUBLICA = "PRTPARAMETROS_IDPARAMTIPO_ESPECIALISTA_INVERSION_PUBLICA";
	public static final Long DEFOULT_PRTPARAMETROS_IDPARAMTIPO_ESPECIALISTA_INVERSION_PUBLICA = 230L;
	//IVILLAFANA 2112018 - INICIO
	
	//IVILLAFANA 30012019 - INICIO
	public static final String KEY_PRTPARAMETROS_IDTIPO_PROGRAMACION = "PRTPARAMETROS_IDTIPO_PROGRAMACION";
	public static final Long DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMACION = 128L;
	//IVILLAFANA 30012019 - FIN
	//IVILLAFANA 10062019 INICIO
	public static final int LIMITE_REGISTROS_REPORTES = 6500;
	//IVILLAFANA 10062019 FIN
	//MZARATE 27062019 MIGRACION IVAN INICIO
	//IVILLAFANA 23052019 INICIO
	public static final String KEY_PRTPARAMETROS_ESTADOS_ACTUALES_SEGUIMIENTO = "PRTPARAMETROS_ESTADOS_ACTUALES_SEGUIMIENTO";
	public static final Long DEFOULT_PRTPARAMETROS_ESTADOS_ACTUALES_SEGUIMIENTO = 356L;
	public static final String KEY_PRTPARAMETROS_ESTADOS_SEGUIMIENTO = "PRTPARAMETROS_ESTADOS_SEGUIMIENTO";
	public static final Long DEFOULT_PRTPARAMETROS_ESTADOS_SEGUIMIENTO = 360L;
	public static final String KEY_PRTPARAMETROS_TIPO_ACCION_ACTIVIDAD = "PRTPARAMETROS_TIPO_ACCION_ACTIVIDAD";
	public static final Long DEFOULT_PRTPARAMETROS_TIPO_ACCION_ACTIVIDAD = 365L;
	public static final String KEY_PRTPARAMETROS_TIPO_ACCION_ACUERDO = "PRTPARAMETROS_TIPO_ACCION_ACUERDO";
	public static final Long DEFOULT_PRTPARAMETROS_TIPO_ACCION_ACUERDO = 366L;
	//IVILLAFANA 23052019 FIN
	//MZARATE 27062019 MIGRACION IVAN FIN
	//VBALDEONH INICIO
	public static final String KEY_PRTPARAMETROS_TIEMPO_MAXIMO_RESPUESTA = "PRTPARAMETROS_TIEMPO_MAXIMO_RESPUESTA";
	public static final int DEFOULT_PRTPARAMETROS_TIEMPO_MAXIMO_RESPUESTA = 4;
	// VBALDEONH FIN
	//VBALDEONH SPRINT3 INICIO
	public static final String KEY_PRTPARAMETROS_MEDIO_REGISTRO_PORTAL = "PRTPARAMETROS_MEDIO_REGISTRO_PORTAL";
	public static final Long DEFAULT_PRTPARAMETROS_MEDIO_REGISTRO_PORTAL = 2L;
	public static final String KEY_PRTPARAMETROS_ASISTENCIA_SI = "PRTPARAMETROS_PRTPARAMETROS_ASISTENCIA_SI";
	public static final Long DEFAULT_PRTPARAMETROS_ASISTENCIA_SI = 1L;
	public static final String KEY_PRTPARAMETROS_ASISTENCIA_NO = "PRTPARAMETROS_PRTPARAMETROS_ASISTENCIA_NO";
	public static final Long DEFAULT_PRTPARAMETROS_ASISTENCIA_NO = 0L;
	public static final String KEY_PRTPARAMETROS_CONFIRMAR_REGISTRO_SI = "PRTPARAMETROS_PRTPARAMETROS_CONFIRMAR_REGISTRO_SI";
	public static final Long DEFAULT_PRTPARAMETROS_CONFIRMAR_REGISTRO_SI = 1L;
	public static final String KEY_PRTPARAMETROS_CONFIRMAR_REGISTRO_NO = "PRTPARAMETROS_PRTPARAMETROS_CONFIRMAR_REGISTRO_NO";
	public static final Long DEFAULT_PRTPARAMETROS_CONFIRMAR_REGISTRO_NO = 0L;
	// VBALDEONH FIN
	
	//SPRINT5 INICIO
	public static final String KEY_PRTPARAMETROS_CARGO_GESTOR_CENTRO = "PRTPARAMETROS_CARGO_GESTOR_CENTRO";
	public static final Long DEFAULT_PRTPARAMETROS_CARGO_GESTOR_CENTRO = 9L;
	
	//SPRINT5 FIN
	//SPRINT17 INICIO
	public static final String KEY_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI = "PRTPARAMETROS_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI";
	public static final Long DEFAULT_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI = 1L;
	//SPRINT17 FIN
	
	//SPRINT19 INICIO
	public static final String KEY_PRTPARAMETROS_ENCUESTA_BLOQUEADO_NO = "PRTPARAMETROS_PRTPARAMETROS_ENCUESTA_BLOQUEADO_NO";
	public static final Long DEFAULT_PRTPARAMETROS_ENCUESTA_BLOQUEADO_NO = 0L;
	
	//SPRINT19 FIN
	
	//SPRINT26 INICIO
	public static final String KEY_FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO = "FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO";
	public static final Long DEFAULT_FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO = 1L;
	
	
	//SPRINT26 FIN
	//SPRINT27 INICIO

	public static final String KEY_RUTA_REPORTE_RESUMEN = "RUTA_REPORTE_RESUMEN";
	public static final String DEFAULT_RUTA_REPORTE_RESUMEN= "/REPORTE_RESUMEN";

	
	//SPRINT27 FIN
	//SPRINT60 INICIO
	public static final String KEY_PAGINA_ORIGEN_NO_PROGRAMADO = "PAGINA_ORIGEN_NO_PROGRAMADO";
	public static final Long DEFAULT_PAGINA_ORIGEN_NO_PROGRAMADO = 1L;
	
	//SPRINT60 FIN
	//SPRINT_1.2 INICIO
	public static final String KEY_PAGINA_ORIGEN_PROGRAMADO = "PAGINA_ORIGEN_PROGRAMADO";
	public static final Long DEFAULT_PAGINA_ORIGEN_PROGRAMADO = 2L;
	//SPRINT_1.2 FIN
	
	//SPRINT_3 INICIO
	public static final String KEY_PRTPARAMETROS_IDTIPO_FINANCIMIENTO_NO_GASTO = "PRTPARAMETROS_IDTIPO_FINANCIMIENTO_NO_GASTO";
	public static final Long DEFAULT_PRTPARAMETROS_IDTIPO_FINANCIMIENTO_NO_GASTO  = 326L;
	//SPRINT_3 FIN
	
	//MPINARES 31052023 - INICIO
	public static final String KEY_DIASHAB_EJECUCIONALARMA = "DIASHAB_EJECUCIONALARMA";
	public static final Long DEFOULT_DIASHAB_EJECUCIONALARMA  = 2L;
	//MPINARES 31052023 - FIN
	
	//PURIBE 25012024 - INICIO
	public static final String  KEY_PRTPARAMETROS_IDPARAMNOTIFICACION = "NOTIFICACION";
	public static final String DEFOULT_PRTPARAMETROS_IDPARAMTIPONOTIFICACION = "448";
		
	public static final String  KEY_PRTPARAMETROS_IDPARAMTEXTO = "TEXTO";
	public static final String DEFOULT_PRTPARAMETROS_IDPARAMTEXTO= "449";
	//PURIBE 25012024 - FIN
	
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static boolean containsKey(String key) {
		return RESOURCE_BUNDLE.containsKey(key);
	}

	public synchronized static Properties getSistemaProperties() {
		Properties propertieSistema = null;
		File filepropiedadesdir = getPropiedadesDir();
		if (filepropiedadesdir == null)
			return null;

		String propiedades = filepropiedadesdir.getAbsolutePath() + System.getProperty("file.separator")
				+ SISTEM_PROPERTIES;
		File filepropiedades = new File(propiedades + ".properties");
		if (filepropiedades.exists()) {
			FileInputStream input = null;
			propertieSistema = new Properties();
			try {
				input = new FileInputStream(filepropiedades);
				propertieSistema.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (null != input)
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		} else {
			propertieSistema = new Properties();
			// AGREGAR PROPIEDADES POR DEFECTO
			saveSistemaProperties(propertieSistema);
		}
		return propertieSistema;
	}

	public synchronized static void saveSistemaProperties(Properties p) {

		File filepropiedadesdir = getPropiedadesDir();
		if (filepropiedadesdir == null)
			return;

		String propiedades = filepropiedadesdir.getAbsolutePath() + System.getProperty("file.separator")
				+ SISTEM_PROPERTIES;
		File sistemaproriedadesFile = new File(propiedades + ".properties");
		FileOutputStream ouput = null;
		try {
			ouput = new FileOutputStream(sistemaproriedadesFile);
			p.store(ouput, "PARAMETROS DEL SISTEMA");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != ouput)
				try {
					ouput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public synchronized static Properties getAlarmaProperties() {
		Properties propertieSistema = null;

		File filepropiedadesdir = getPropiedadesDir();
		if (filepropiedadesdir == null)
			return null;

		String propiedades = filepropiedadesdir.getAbsolutePath() + System.getProperty("file.separator")
				+ ALARMA_PROPERTIES;
		File filepropiedades = new File(propiedades + ".properties");
		if (filepropiedades.exists()) {
			FileInputStream input = null;
			propertieSistema = new Properties();
			try {
				input = new FileInputStream(filepropiedades);
				propertieSistema.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (null != input)
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		} else {
			propertieSistema = new Properties();

			saveAlarmaProperties(propertieSistema);
		}

		return propertieSistema;
	}

	public synchronized static void saveAlarmaProperties(Properties p) {

		File filepropiedadesdir = getPropiedadesDir();
		if (filepropiedadesdir == null)
			return;

		String propiedades = filepropiedadesdir.getAbsolutePath() + System.getProperty("file.separator")
				+ ALARMA_PROPERTIES;
		File sistemaproriedadesFile = new File(propiedades + ".properties");
		FileOutputStream ouput = null;
		try {
			ouput = new FileOutputStream(sistemaproriedadesFile);
			p.store(ouput, "PARAMETROS DE LAS ALARMAS DEL SISTEMA");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != ouput)
				try {
					ouput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static File getRootFolder() {
		if (rootDir == null) {
			String home = System.getProperty("user.home", ".");
			String os = System.getProperty("os.name").toLowerCase();
			String dirfilename = "/";
			if (os.contains("solaris") || os.contains("sunos") || os.contains("linux") || os.contains("unix")) {
				dirfilename = home + File.separator;
			} else if (os.contains("win")) {
				String appdata = System.getenv("APPDATA");
				dirfilename = (appdata != null ? (appdata + File.separator) : (home + File.separator));
			} else if (os.contains("mac")) {
				dirfilename = (home + "Library/Application Support/minecraft" + File.separator);
			}

			File f = new File(dirfilename);

			String sRAIZ = getString("RAIZ");
			if (f.exists() && sRAIZ != null) {
				String rutaconraiz = f.getAbsolutePath() + File.separator + sRAIZ;
				f = new File(rutaconraiz);
				if (!f.exists()) {
					f.mkdirs();
				}
			}

			if (f.exists()) {
				if (imprimirrootsistema) {
					System.out.println("INICIANDO PROPIEDADES EN DIRECTORIO: " + f.getAbsolutePath());
					imprimirrootsistema = false;
					rootDir = f;
				}
			} else {
				System.out.println("INICIANDO PROPIEDADES EN DIRECTORIO: NO SE ENCUENTRA EL DIRECTORIO" + dirfilename);
			}
		}
		return rootDir;
	}

	private static File getPropiedadesDir() {
		File filesistemroot = getRootFolder();
		if (filesistemroot == null)
			return null;
		String propiedadesdir = filesistemroot.getAbsolutePath() + System.getProperty("file.separator")
				+ PROPERTIES_DIR;
		File filepropiedadesdir = new File(propiedadesdir);
		if (!filepropiedadesdir.exists()) {
			log.info("CREANDO EL DIRECTORIO DE PROPIEDADES " + propiedadesdir);
			if (filepropiedadesdir.mkdir()) {
				log.info("SE CREO EL DIRECTORIO DE PROPIEDADES EN " + propiedadesdir + " CON EXITO...");
			} else {
				log.info("ERROR FATAL CREANDO EL DIRECTORIO DE PROPIEDADES EN " + propiedadesdir + "...");
				return null;
			}
		}

		return filepropiedadesdir;
	}

	public static String getROOTCONTADOR() {
		String contador = null;
		try {
			File filesistemroot = getRootFolder();
			if (filesistemroot == null)
				return null;
			String contadores = getSistemString("RUTA_CONTADORES", "counters");
			contador = filesistemroot.getAbsolutePath() + System.getProperty("file.separator") + contadores;
			File f = new File(contador);
			if(!f.exists())
				f.mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contador;
	}

	public static String getROOTDOCS() {
		String digitales = null;
		try {
			File filesistemroot = getRootFolder();
			if (filesistemroot == null)
				return null;
			String ruta = getSistemString("RUTA_DOCS", "documents");
			digitales = filesistemroot.getAbsolutePath() + System.getProperty("file.separator") + ruta;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return digitales;
	}

	public static String getSistemString(String key, String defoult) {
		String retorno = null;
		try {
			Properties sistemapropiedades = getSistemaProperties();
			if (sistemapropiedades == null)
				return defoult;

			if (defoult != null && defoult.trim().length() > 0) {
				if (sistemapropiedades.getProperty(key) == null) {
					sistemapropiedades.setProperty(key, defoult);
					saveSistemaProperties(sistemapropiedades);
					retorno = defoult;
				} else {
					retorno = sistemapropiedades.getProperty(key, defoult);
				}
			} else {
				retorno = sistemapropiedades.getProperty(key);
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static Boolean getSistemBoolean(String key, Boolean defoult) {
		Boolean retorno = null;
		try {
			Properties sistemapropiedades = getSistemaProperties();
			if (sistemapropiedades == null)
				return defoult;

			if (defoult != null) {
				if (sistemapropiedades.getProperty(key) == null) {
					sistemapropiedades.setProperty(key, defoult.toString());
					saveSistemaProperties(sistemapropiedades);
					retorno = defoult;
				} else {
					try {
						retorno = Boolean.parseBoolean(sistemapropiedades.getProperty(key));
					} catch (NumberFormatException e) {
						log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR BOOLEAN "
								+ sistemapropiedades.getProperty(key));
					}
				}
			} else {
				try {
					retorno = Boolean.parseBoolean(sistemapropiedades.getProperty(key));
				} catch (NumberFormatException e) {
					log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR BOOLEAN "
							+ sistemapropiedades.getProperty(key));
				}
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static Long getSistemLong(String key, Long defoult) {
		Long retorno = null;
		try {
			Properties sistemapropiedades = getSistemaProperties();
			if (sistemapropiedades == null)
				return defoult;

			if (defoult != null) {
				if (sistemapropiedades.getProperty(key) == null) {
					sistemapropiedades.setProperty(key, defoult.toString());
					saveSistemaProperties(sistemapropiedades);
					retorno = defoult;
				} else {
					try {
						retorno = Long.parseLong(sistemapropiedades.getProperty(key));
					} catch (NumberFormatException e) {
						log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR NO NUMERICO "
								+ sistemapropiedades.getProperty(key));
					}
				}
			} else {
				try {
					retorno = Long.parseLong(sistemapropiedades.getProperty(key));
				} catch (NumberFormatException e) {
					log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR NO NUMERICO "
							+ sistemapropiedades.getProperty(key));
				}
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static Long getSistemLong(String key, String defoult) {
		Long retorno = null;
		try {

			Properties sistemapropiedades = getSistemaProperties();
			retorno = Long.parseLong(defoult);
			if (sistemapropiedades == null)
				return retorno;

			if (defoult != null) {
				if (sistemapropiedades.getProperty(key) == null) {
					sistemapropiedades.setProperty(key, defoult);
					saveSistemaProperties(sistemapropiedades);
				} else {
					try {
						retorno = Long.parseLong(sistemapropiedades.getProperty(key));
					} catch (NumberFormatException e) {
						log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR NO NUMERICO "
								+ sistemapropiedades.getProperty(key));
					}
				}
			} else {
				try {
					retorno = Long.parseLong(sistemapropiedades.getProperty(key));
				} catch (NumberFormatException e) {
					log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR NO NUMERICO "
							+ sistemapropiedades.getProperty(key));
				}
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static Integer getSistemInteger(String key, Integer defoult) {
		Integer retorno = null;
		try {
			Properties sistemapropiedades = getSistemaProperties();
			if (sistemapropiedades == null)
				return defoult;

			if (defoult != null) {
				if (sistemapropiedades.getProperty(key) == null) {
					sistemapropiedades.setProperty(key, defoult.toString());
					saveSistemaProperties(sistemapropiedades);
					retorno = defoult;
				} else {
					try {
						retorno = Integer.parseInt(sistemapropiedades.getProperty(key));
					} catch (NumberFormatException e) {
						log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR NO NUMERICO "
								+ sistemapropiedades.getProperty(key));
					}
				}
			} else {
				try {
					retorno = Integer.parseInt(sistemapropiedades.getProperty(key));
				} catch (NumberFormatException e) {
					log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR NO NUMERICO "
							+ sistemapropiedades.getProperty(key));
				}
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static Date getSistemInteger(String key, Date defoult) {
		Date retorno = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Properties sistemapropiedades = getSistemaProperties();
			if (sistemapropiedades == null)
				return defoult;

			if (defoult != null) {
				if (sistemapropiedades.getProperty(key) == null) {
					sistemapropiedades.setProperty(key, sdf.format(defoult));
					saveSistemaProperties(sistemapropiedades);
					try {
						retorno = sdf.parse(sistemapropiedades.getProperty(key));
					} catch (Exception e) {
						log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR FECHA "
								+ sistemapropiedades.getProperty(key));
					}
				} else {
					try {
						retorno = sdf.parse(sistemapropiedades.getProperty(key));
					} catch (Exception e) {
						log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR FECHA "
								+ sistemapropiedades.getProperty(key));
					}
				}
			} else {
				try {
					retorno = sdf.parse(sistemapropiedades.getProperty(key));
				} catch (Exception e) {
					log.info("ERROR OBTENIENDO LA PROPIEDAD DEL SISTEMA " + key + " VALOR FECHA "
							+ sistemapropiedades.getProperty(key));
				}
			}
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static Properties getUsuarioProperties(String usuario) {
		Properties propertieUsuario = null;
		if (propertieUsuario == null) {
			if (getPropiedadesDir() != null) {
				String PROPERTIE_USUARIO = usuario + ".properties";
				File propertiesfile = new File(getPropiedadesDir().getAbsolutePath()
						+ System.getProperty("file.separator") + PROPERTIE_USUARIO);
				if (propertiesfile.exists()) {
					FileInputStream input = null;
					propertieUsuario = new Properties();
					try {
						input = new FileInputStream(propertiesfile);
						propertieUsuario.load(input);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (null != input)
							try {
								input.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				} else {
					propertieUsuario = new Properties();
					// AGREGAR PROPIEDADES POR DEFECTO
					saveUsuarioProperties(propertieUsuario, usuario);
				}
			}
		}
		return propertieUsuario;
	}

	public static void saveUsuarioProperties(Properties p, String usuario) {
		String PROPERTIE_USUARIO = usuario + ".properties";
		File propertiesfile = new File(
				getPropiedadesDir().getAbsolutePath() + System.getProperty("file.separator") + PROPERTIE_USUARIO);
		FileOutputStream ouput = null;
		try {
			System.out.println("CREANDO PREFERENCIAS EN: " + propertiesfile.getAbsolutePath());
			ouput = new FileOutputStream(propertiesfile);
			p.store(ouput, "PREFERENCIAS DEL USUARIO " + usuario);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != ouput)
				try {
					ouput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static long getDEFECTO_PAIS_PERU() {
		long DEFECTO_PAIS_PERU = 173L;
		Properties sistema = getSistemaProperties();
		try {
			DEFECTO_PAIS_PERU = Long.parseLong(sistema.getProperty("DEFECTO_PAIS_PERU", "173"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DEFECTO_PAIS_PERU;
	}

	public static int getDEFECTO_DEPARTAMENTO() {
		int DEFECTO_DEPARTAMENTO = 15;
		Properties sistema = getSistemaProperties();
		try {
			DEFECTO_DEPARTAMENTO = Integer.parseInt(sistema.getProperty("DEFECTO_DEPARTAMENTO", "15"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DEFECTO_DEPARTAMENTO;
	}

	public static int getDEFECTO_PROVINCIA() {
		int DEFECTO_PROVINCIA = 1;
		Properties sistema = getSistemaProperties();
		try {
			DEFECTO_PROVINCIA = Integer.parseInt(sistema.getProperty("DEFECTO_PROVINCIA", "1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DEFECTO_PROVINCIA;
	}

	public static int getDEFECTO_DISTRITO() {
		int DEFECTO_DISTRITO = 1;
		Properties sistema = getSistemaProperties();
		try {
			DEFECTO_DISTRITO = Integer.parseInt(sistema.getProperty("DEFECTO_DISTRITO", "1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DEFECTO_DISTRITO;
	}

	public static long getDEFECTO_USUARIO_UO() {
		long DEFECTO_USUARIO_UO = 589L;
		Properties sistema = getSistemaProperties();
		try {
			DEFECTO_USUARIO_UO = Long.parseLong(sistema.getProperty("DEFECTO_USUARIO_UO", "589"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DEFECTO_USUARIO_UO;
	}

	public static List<String> getListaDefaultsClass(Class<?> a) {
		List<String> resultados = new ArrayList<String>();
		try {
			if (a != null) {
				String dirfilename = getRootFolder() + File.separator + AUXILIARES_DIR;
				File retorno = new File(dirfilename);
				if (!retorno.exists()) {
					retorno.mkdirs();
					System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
				}

				String nameclass = a.getName();
				String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
				File retorno2 = new File(dirfilenameclass);
				if (!retorno2.exists()) {
					retorno2.mkdirs();
					System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
				}

				if (retorno2.exists() && retorno2.isDirectory()) {
					File[] files = retorno2.listFiles();
					if (files != null && files.length > 0) {
						for (int i = 0; i < files.length; i++) {
							if (files[i].isFile()) {
								String namefile = files[i].getName();
								resultados.add(namefile);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
		return resultados;
	}

	public static List<String> getListaPerfiles() {
		List<String> resultados = new ArrayList<String>();
		try {
			String dirfilename = getRootFolder() + File.separator + AUXILIARES_DIR;
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = "PERFILES";
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}

			if (retorno2.exists() && retorno2.isDirectory()) {
				File[] files = retorno2.listFiles();
				if (files != null && files.length > 0) {
					for (int i = 0; i < files.length; i++) {
						if (files[i].isFile()) {
							String namefile = files[i].getName();
							resultados.add(namefile);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
		return resultados;
	}

	public static void saveDefoultClass(String username, String plantilla, Object a) {
		try {
			if (a == null)
				return;

			String dirfilename = getRootFolder() + File.separator + username + ".class";
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = a.getClass().getName();
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}
			String dirFileName = retorno2.getAbsolutePath() + System.getProperty("file.separator") + plantilla;

			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(dirFileName));
			salida.writeObject(a);
			salida.close();
		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void savePerfil(String plantilla, Object a) {
		try {
			if (a == null)
				return;

			String dirfilename = getRootFolder() + File.separator + AUXILIARES_DIR;
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = "PERFILES";
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}
			String dirFileName = retorno2.getAbsolutePath() + System.getProperty("file.separator") + plantilla;

			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(dirFileName));
			salida.writeObject(a);
			salida.close();
		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void removerDefoultClass(String username, String plantilla, Class<?> a) {
		try {
			if (a == null)
				return;

			String dirfilename = getRootFolder() + File.separator + username + ".class";
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = a.getName();
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}

			String dirFileName = retorno2.getAbsolutePath() + System.getProperty("file.separator") + plantilla;

			File f = new File(dirFileName);
			if (!f.exists())
				return;

			f.delete();

		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void removerPerfil(String plantilla) {
		try {
			String dirfilename = getRootFolder() + File.separator + AUXILIARES_DIR;
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = "PERFILES";
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}

			String dirFileName = retorno2.getAbsolutePath() + System.getProperty("file.separator") + plantilla;

			File f = new File(dirFileName);
			if (!f.exists())
				return;

			f.delete();

		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getDefoultClass(String username, String plantilla, Class<T> a) {
		T b = null;
		try {
			if (a == null)
				return null;

			String dirfilename = getRootFolder() + File.separator + username + ".class";
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = a.getName();
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}

			String dirFileName = retorno2.getAbsolutePath() + System.getProperty("file.separator") + plantilla;

			File f = new File(dirFileName);
			if (!f.exists())
				return null;

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(dirFileName));
			b = (T) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getPerfil(String plantilla) {
		T b = null;
		try {
			String dirfilename = getRootFolder() + File.separator + AUXILIARES_DIR;
			File retorno = new File(dirfilename);
			if (!retorno.exists()) {
				retorno.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno.getAbsolutePath());
			}

			String nameclass = "PERFILES";
			String dirfilenameclass = retorno.getAbsolutePath() + File.separator + nameclass;
			File retorno2 = new File(dirfilenameclass);
			if (!retorno2.exists()) {
				retorno2.mkdirs();
				System.out.println("CREANDO EL DIRECTORIO DE CLASES: " + retorno2.getAbsolutePath());
			}

			String dirFileName = retorno2.getAbsolutePath() + System.getProperty("file.separator") + plantilla;

			File f = new File(dirFileName);
			if (!f.exists())
				return null;

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(dirFileName));
			b = (T) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
		return b;
	}
	
	//MPINARES 29092023 - INICIO
		public static Long getELIMINADO() {
			if(ELIMINADO==null){
				ELIMINADO = PropertiesMg.getSistemLong(PropertiesMg.KEY_ELIMINADO,PropertiesMg.DEFOULT_ELIMINADO);
			}
			return ELIMINADO;
		}

		public static void setELIMINADO(Long eLIMINADO) {
			ELIMINADO = eLIMINADO;
		}
		
		public static Long getCREADO() {
			if(CREADO==null){
				CREADO = PropertiesMg.getSistemLong(PropertiesMg.KEY_CREADO,PropertiesMg.DEFOULT_CREADO);
			}
			return CREADO;
		}

		public static void setCREADO(Long cREADO) {
			CREADO = cREADO;
		}
		//MPINARES 29092023 - FIN
		
		public enum Modulo{
			PROGRAMACION, 
			REGISTRO,
			REPORTES
		}
		
}
