package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.IDsValorDto;

/*
 * CLASE PARA EL MANEJO DE LOS ROLES DE LOS USUARIOS
 * 
 * @author  Carlos Aguilar
 * @version 2.0, 21/03/2012 11:09:32 AM
 *
 * 
 *  /----------Nombre----------/----fecha----/-------------Motivo--------------/
 *  Carlos Aguilar Chamochumbi	21/03/2012 11:09:32 AM	  Creación de la clase
 *
 */
public class Roles implements Serializable {

	private static final long serialVersionUID = 873421700604638878L;

	public static final String ADMINISTRADOR = "REGISTRAMEF_ADMINISTRADOR";
	
	//PURIBE 14032024 - INICIO-->

		public static final String REACTIVA = "REGISTRAMEF_REACTIVA_SERV";//
		public static final String ADMINISTRADOR_VISITAS_EDITOR = "REGISTRAMEF_DTVISITAS_EDITOR";
	//PURIBE 14032024 - FIN->

	//// ROLES DTCAPAENTIDADES
	public static final String DTCAPAENTIDADES_CREA = "REGISTRAMEF_DTCAPAENTIDADES_EDITOR";
	public static final String DTCAPAENTIDADES_VE = "REGISTRAMEF_DTCAPAENTIDADES_LECTOR";
	//// ROLES DTCAPAPUBLICO
	public static final String DTCAPAPUBLICO_CREA = "REGISTRAMEF_DTCAPAPUBLICO_EDITOR";
	public static final String DTCAPAPUBLICO_VE = "REGISTRAMEF_DTCAPAPUBLICO_LECTOR";
	//// ROLES MSPAISES
	public static final String MSPAISES_CREA = "REGISTRAMEF_MSPAISES_EDITOR";
	public static final String MSPAISES_VE = "REGISTRAMEF_MSPAISES_LECTOR";
	//// ROLES DTCONSULTASPROYECTO
	public static final String DTCONSULTASPROYECTO_CREA = "REGISTRAMEF_DTCONSULTASPROYECTO_EDITOR";
	public static final String DTCONSULTASPROYECTO_VE = "REGISTRAMEF_DTCONSULTASPROYECTO_LECTOR";
	//// ROLES DTVISITASUSUINTERNOS
	public static final String DTVISITASUSUINTERNOS_CREA = "REGISTRAMEF_DTVISITASUSUINTERNOS_EDITOR";
	public static final String DTVISITASUSUINTERNOS_VE = "REGISTRAMEF_DTVISITASUSUINTERNOS_LECTOR";
	//// ROLES DTASISTENCIA
	public static final String DTASISTENCIA_CREA = "REGISTRAMEF_DTASISTENCIA_EDITOR";
	public static final String DTASISTENCIA_VE = "REGISTRAMEF_DTASISTENCIA_LECTOR";
	//// ROLES DTCAPACITACION
	public static final String DTCAPACITACION_CREA = "REGISTRAMEF_DTCAPACITACION_EDITOR";
	public static final String DTCAPACITACION_VE = "REGISTRAMEF_DTCAPACITACION_LECTOR";
	//// ROLES MSALERTACARGOUSER
	public static final String MSALERTACARGOUSER_CREA = "REGISTRAMEF_MSALERTACARGOUSER_EDITOR";
	public static final String MSALERTACARGOUSER_VE = "REGISTRAMEF_MSALERTACARGOUSER_LECTOR";
	//// ROLES TAFERIADOS
	public static final String TAFERIADOS_CREA = "REGISTRAMEF_TAFERIADOS_EDITOR";
	public static final String TAFERIADOS_VE = "REGISTRAMEF_TAFERIADOS_LECTOR";
	//// ROLES DTENTIDADES
	public static final String DTENTIDADES_CREA = "REGISTRAMEF_DTENTIDADES_EDITOR";
	public static final String DTENTIDADES_VE = "REGISTRAMEF_DTENTIDADES_LECTOR";
	//// ROLES DTENTIDADSISADMIN
	public static final String DTENTIDADSISADMIN_CREA = "REGISTRAMEF_DTENTIDADSISADMIN_EDITOR";
	public static final String DTENTIDADSISADMIN_VE = "REGISTRAMEF_DTENTIDADSISADMIN_LECTOR";
	//// ROLES DTVISITAS
	public static final String DTVISITAS_CREA = "REGISTRAMEF_DTVISITAS_EDITOR";
	public static final String DTVISITAS_VE = "REGISTRAMEF_DTVISITAS_LECTOR";
	//// ROLES MSUSUARIOS
	public static final String MSUSUARIOS_CREA = "REGISTRAMEF_MSUSUARIOS_EDITOR";
	public static final String MSUSUARIOS_VE = "REGISTRAMEF_MSUSUARIOS_LECTOR";
	//// ROLES DTENTIDADESUSUEXTERNOS
	public static final String DTENTIDADESUSUEXTERNOS_CREA = "REGISTRAMEF_DTENTIDADESUSUEXTERNOS_EDITOR";
	public static final String DTENTIDADESUSUEXTERNOS_VE = "REGISTRAMEF_DTENTIDADESUSUEXTERNOS_LECTOR";
	//// ROLES PRTPARAMETROS
	public static final String PRTPARAMETROS_CREA = "REGISTRAMEF_PRTPARAMETROS_EDITOR";
	public static final String PRTPARAMETROS_VE = "REGISTRAMEF_PRTPARAMETROS_LECTOR";
	//// ROLES DTASISTENCIATEMAS
	public static final String DTASISTENCIATEMAS_CREA = "REGISTRAMEF_DTASISTENCIATEMAS_EDITOR";
	public static final String DTASISTENCIATEMAS_VE = "REGISTRAMEF_DTASISTENCIATEMAS_LECTOR";
	//// ROLES DTUSUARIOEXTERNO
	public static final String DTUSUARIOEXTERNO_CREA = "REGISTRAMEF_DTUSUARIOEXTERNO_EDITOR";
	public static final String DTUSUARIOEXTERNO_VE = "REGISTRAMEF_DTUSUARIOEXTERNO_LECTOR";
	//// ROLES MSUBIGEO
	public static final String MSUBIGEO_CREA = "REGISTRAMEF_MSUBIGEO_EDITOR";
	public static final String MSUBIGEO_VE = "REGISTRAMEF_MSUBIGEO_LECTOR";
	//// ROLES MSSISADMISTRATIVO
	public static final String MSSISADMISTRATIVO_CREA = "REGISTRAMEF_MSSISADMISTRATIVO_EDITOR";
	public static final String MSSISADMISTRATIVO_VE = "REGISTRAMEF_MSSISADMISTRATIVO_LECTOR";
	//// ROLES MSSUBTEMA
	public static final String MSSUBTEMA_CREA = "REGISTRAMEF_MSSUBTEMA_EDITOR";
	public static final String MSSUBTEMA_VE = "REGISTRAMEF_MSSUBTEMA_LECTOR";
	//// ROLES DTASISTENCIAUSUEXTERNOS
	public static final String DTASISTENCIAUSUEXTERNOS_CREA = "REGISTRAMEF_DTASISTENCIAUSUEXTERNOS_EDITOR";
	public static final String DTASISTENCIAUSUEXTERNOS_VE = "REGISTRAMEF_DTASISTENCIAUSUEXTERNOS_LECTOR";
	//// ROLES DTCAPAPROYECTO
	public static final String DTCAPAPROYECTO_CREA = "REGISTRAMEF_DTCAPAPROYECTO_EDITOR";
	public static final String DTCAPAPROYECTO_VE = "REGISTRAMEF_DTCAPAPROYECTO_LECTOR";
	//// ROLES MSROLES
	public static final String MSROLES_CREA = "REGISTRAMEF_MSROLES_EDITOR";
	public static final String MSROLES_VE = "REGISTRAMEF_MSROLES_LECTOR";
	//// ROLES MSPROYECTOINVERSION
	public static final String MSPROYECTOINVERSION_CREA = "REGISTRAMEF_MSPROYECTOINVERSION_EDITOR";
	public static final String MSPROYECTOINVERSION_VE = "REGISTRAMEF_MSPROYECTOINVERSION_LECTOR";
	//// ROLES DTAMPLIACIONFECHA
	public static final String DTAMPLIACIONFECHA_CREA = "REGISTRAMEF_DTAMPLIACIONFECHA_EDITOR";
	public static final String DTAMPLIACIONFECHA_VE = "REGISTRAMEF_DTAMPLIACIONFECHA_LECTOR";
	//// ROLES DTENCUESTARESPUESTA
	public static final String DTENCUESTARESPUESTA_CREA = "REGISTRAMEF_DTENCUESTARESPUESTA_EDITOR";
	public static final String DTENCUESTARESPUESTA_VE = "REGISTRAMEF_DTENCUESTARESPUESTA_LECTOR";
	//// ROLES DTASISTENCIAPROYECTO
	public static final String DTASISTENCIAPROYECTO_CREA = "REGISTRAMEF_DTASISTENCIAPROYECTO_EDITOR";
	public static final String DTASISTENCIAPROYECTO_VE = "REGISTRAMEF_DTASISTENCIAPROYECTO_LECTOR";
	//// ROLES MSSEDES
	public static final String MSSEDES_CREA = "REGISTRAMEF_MSSEDES_EDITOR";
	public static final String MSSEDES_VE = "REGISTRAMEF_MSSEDES_LECTOR";
	//// ROLES DTVISITASTEMAS
	public static final String DTVISITASTEMAS_CREA = "REGISTRAMEF_DTVISITASTEMAS_EDITOR";
	public static final String DTVISITASTEMAS_VE = "REGISTRAMEF_DTVISITASTEMAS_LECTOR";
	//// ROLES DTANEXO
	public static final String DTANEXO_CREA = "REGISTRAMEF_DTANEXO_EDITOR";
	public static final String DTANEXO_VE = "REGISTRAMEF_DTANEXO_LECTOR";
	//// ROLES DTCAPATEMAS
	public static final String DTCAPATEMAS_CREA = "REGISTRAMEF_DTCAPATEMAS_EDITOR";
	public static final String DTCAPATEMAS_VE = "REGISTRAMEF_DTCAPATEMAS_LECTOR";
	//// ROLES DTENTIDADSEDES
	public static final String DTENTIDADSEDES_CREA = "REGISTRAMEF_DTENTIDADSEDES_EDITOR";
	public static final String DTENTIDADSEDES_VE = "REGISTRAMEF_DTENTIDADSEDES_LECTOR";
	//// ROLES DTCONSULTAS
	public static final String DTCONSULTAS_CREA = "REGISTRAMEF_DTCONSULTAS_EDITOR";
	public static final String DTCONSULTAS_VE = "REGISTRAMEF_DTCONSULTAS_LECTOR";
	//// ROLES DTVISITASPROYECTO
	public static final String DTVISITASPROYECTO_CREA = "REGISTRAMEF_DTVISITASPROYECTO_EDITOR";
	public static final String DTVISITASPROYECTO_VE = "REGISTRAMEF_DTVISITASPROYECTO_LECTOR";
	//// ROLES DTCAPAUSUEXTERNOS
	public static final String DTCAPAUSUEXTERNOS_CREA = "REGISTRAMEF_DTCAPAUSUEXTERNOS_EDITOR";
	public static final String DTCAPAUSUEXTERNOS_VE = "REGISTRAMEF_DTCAPAUSUEXTERNOS_LECTOR";
	//// ROLES DTVISITASUSUEXTERNOS
	public static final String DTVISITASUSUEXTERNOS_CREA = "REGISTRAMEF_DTVISITASUSUEXTERNOS_EDITOR";
	public static final String DTVISITASUSUEXTERNOS_VE = "REGISTRAMEF_DTVISITASUSUEXTERNOS_LECTOR";
	//// ROLES DTCARGOSUSUEXTER
	public static final String DTCARGOSUSUEXTER_CREA = "REGISTRAMEF_DTCARGOSUSUEXTER_EDITOR";
	public static final String DTCARGOSUSUEXTER_VE = "REGISTRAMEF_DTCARGOSUSUEXTER_LECTOR";
	//// ROLES MSTEMA
	public static final String MSTEMA_CREA = "REGISTRAMEF_MSTEMA_EDITOR";
	public static final String MSTEMA_VE = "REGISTRAMEF_MSTEMA_LECTOR";
	//// ROLES DTUSUARIOSSEDES
	public static final String DTUSUARIOSSEDES_CREA = "REGISTRAMEF_DTUSUARIOSSEDES_EDITOR";
	public static final String DTUSUARIOSSEDES_VE = "REGISTRAMEF_DTUSUARIOSSEDES_LECTOR";
	//// ROLES MSINDICADOR
	public static final String MSINDICADOR_CREA = "REGISTRAMEF_MSINDICADOR_EDITOR";
	public static final String MSINDICADOR_VE = "REGISTRAMEF_MSINDICADOR_LECTOR";
	//// ROLES DTENCUESTA
	public static final String DTENCUESTA_CREA = "REGISTRAMEF_DTENCUESTA_EDITOR";
	public static final String DTENCUESTA_VE = "REGISTRAMEF_DTENCUESTA_LECTOR";
	//// ROLES MSLOCAL
	public static final String MSLOCAL_CREA = "REGISTRAMEF_MSLOCAL_EDITOR";
	public static final String MSLOCAL_VE = "REGISTRAMEF_MSLOCAL_LECTOR";
	//// ROLES MSMETA
	public static final String MSMETA_CREA = "REGISTRAMEF_MSMETA_EDITOR";
	public static final String MSMETA_VE = "REGISTRAMEF_MSMETA_LECTOR";
	//// ROLES MSALERTA
	public static final String MSALERTA_CREA = "REGISTRAMEF_MSALERTA_EDITOR";
	public static final String MSALERTA_VE = "REGISTRAMEF_MSALERTA_LECTOR";

    ////ROLES PRE_PUBLICA_DTCAPACITACION
	public static final String PRE_PUBLICA_DTCAPACITACION_CREA = "REGISTRAMEF_PRE_PUBLICA_DTCAPACITACION_EDITOR";
	public static final String PRE_PUBLICA_DTCAPACITACION_VE = "REGISTRAMEF_PRE_PUBLICA_DTCAPACITACION_LECTOR";
	public static final String PUBLICA_DTCAPACITACION_CREA = "REGISTRAMEF_PUBLICA_DTCAPACITACION_EDITOR";
	public static final String ACUMULAR_DTCAPACITACION_CREA = "REGISTRAMEF_ACUMULAR_DTCAPACITACION_EDITOR";
	
    ////ROLES REACTIVA
	public static final String REACTIVA_ANULADOS = "REGISTRAMEF_REACTIVA_ANULADOS";
	public static final String REACTIVA_FINLIZADOS = "REGISTRAMEF_REACTIVA_FINLIZADOS";
	
    ////ROLES REPORTES
	public static final String REPORTE_SERVICIO_RESUMEN = "REGISTRAMEF_REPORTE_SERVICIO_RESUMEN";
	public static final String REPORTE_SERVICIO_SEDE = "REGISTRAMEF_REPORTE_SERVICIO_SEDE";
	public static final String REPORTE_SERVICIO_REPRESENTANTE = "REGISTRAMEF_REPORTE_SERVICIO_REPRESENTANTE";
	public static final String REPORTE_GENERICO = "REGISTRAMEF_REPORTE_GENERICO";
	public static final String REPORTE_AVANCE_METAS = "REGISTRAMEF_REPORTE_AVANCE_METAS";
	public static final String REPORTE_ENCUESTAS = "REGISTRAMEF_REPORTE_ENCUESTAS";
	public static final String REPORTE_GEOZONA = "REGISTRAMEF_REPORTE_GEOZONA";
	public static final String REPORTE_COBERTURA = "REGISTRAMEF_REPORTE_COBERTURA";
	public static final String REPORTE_DIRECTORIO = "REGISTRAMEF_REPORTE_DIRECTORIO";
	public static final String REPORTE_USU_INTERNO = "REGISTRAMEF_REPORTE_USU_INTERNO";
	public static final String REPORTE_USU_EXTERNO = "REGISTRAMEF_REPORTE_USU_EXTERNO";
	
	////// PERFILES//////
	//PURIBE 14032024 - INICIO-->
	public static final String PERFIL_USU_OGC = "REGISTRAMEF_USUARIO_OGC";
	public static final String PERFIL_GC = "REGISTRAMEF_GESTOR_CENTRO";
	public static final String PERFIL_ADMIN_REPORTES = "REGISTRAMEF_ADMIN_REPORTES";
	public static final String PERFIL_ANALIST_ESPECIALIS_IMPLANT = "REGISTRAMEF_ANALIST_ESPECIALIST_IMPL";
	public static final String PERFIL_USUARIO_EXTERNO_OGC = "REGISTRAMEF_USUARIO_EXTERNO_OGC";
	public static final String PERFIL_ADMINISTRADOR = "REGISTRAMEF_ADMINISTRADOR_OGTI";
	//PURIBE 14032024 - FIN->
	
	public static final String PERFIL_ASIST_GS = "Asistente de Gestión de Servicios";
	public static final String PERFIL_COMISIONADO = "Comisionado";
	public static final String PERFIL_ESPECIALISTA = "Especialista";

//	public static final String ADMINISTRADOR_OGC = "REGISTRAMEF_ADMINISTRADOR_OGC";//MPINARES 24012023 - INICIO
	
	public static final List<String> listaPerfiles = new ArrayList<String>(
			Arrays.asList(new String[] { PERFIL_USU_OGC, PERFIL_GC, PERFIL_ADMIN_REPORTES,
					PERFIL_ANALIST_ESPECIALIS_IMPLANT, PERFIL_USUARIO_EXTERNO_OGC, PERFIL_ADMINISTRADOR }));

	public static Map<String, List<String>> ROLES_POR_PERFIL = new HashMap<String, List<String>>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6850753214439184810L;
		{

			put(PERFIL_USU_OGC,
					new ArrayList<String>(Arrays.asList(new String[] { 
							DTCAPACITACION_CREA,
							DTCAPACITACION_VE,
							DTASISTENCIA_CREA,
							DTASISTENCIA_VE,
							DTVISITAS_CREA,
							DTVISITAS_VE,
							DTCONSULTAS_CREA,
							DTCONSULTAS_VE,
							PRE_PUBLICA_DTCAPACITACION_VE,
							PUBLICA_DTCAPACITACION_CREA,
							ACUMULAR_DTCAPACITACION_CREA,
							MSUSUARIOS_CREA,
							MSUSUARIOS_VE,
							DTUSUARIOEXTERNO_CREA,
							DTUSUARIOEXTERNO_VE,
							MSSISADMISTRATIVO_CREA,
							MSSISADMISTRATIVO_VE,
							MSTEMA_CREA,
							MSTEMA_VE,
							MSSUBTEMA_CREA,
							MSSUBTEMA_VE,
							DTENTIDADES_CREA,
							DTENTIDADES_VE,
							MSLOCAL_CREA,
							MSLOCAL_VE,
							REACTIVA_ANULADOS,
							REACTIVA_FINLIZADOS,
							MSSEDES_CREA,
							MSSEDES_VE,
							MSMETA_CREA,
							MSMETA_VE,
							MSINDICADOR_CREA,
							MSINDICADOR_VE,
							DTENCUESTA_CREA,
							DTENCUESTA_VE,
							MSPROYECTOINVERSION_CREA,
							MSPROYECTOINVERSION_VE,
							DTAMPLIACIONFECHA_CREA,
							DTAMPLIACIONFECHA_VE
					})));
			put(PERFIL_GC, 
					new ArrayList<String>(Arrays.asList(new String[] { 
							DTCAPACITACION_VE,
							DTASISTENCIA_VE,
							DTVISITAS_VE,
							DTCONSULTAS_VE,
							PRE_PUBLICA_DTCAPACITACION_VE,
							ACUMULAR_DTCAPACITACION_CREA,
							DTUSUARIOEXTERNO_CREA,
							DTUSUARIOEXTERNO_VE,
							REPORTE_SERVICIO_RESUMEN
					})));
			put(PERFIL_ADMIN_REPORTES, 
					new ArrayList<String>(Arrays.asList(new String[] { 
							REPORTE_SERVICIO_RESUMEN,
							REPORTE_SERVICIO_SEDE,
							REPORTE_SERVICIO_REPRESENTANTE,
							REPORTE_GENERICO,
							REPORTE_AVANCE_METAS,
							REPORTE_ENCUESTAS,
							REPORTE_GEOZONA,
							REPORTE_COBERTURA,
							REPORTE_DIRECTORIO,
							REPORTE_USU_INTERNO,
							REPORTE_USU_EXTERNO
					})));
			put(PERFIL_ANALIST_ESPECIALIS_IMPLANT, new ArrayList<String>(Arrays.asList(new String[] { 
					DTCAPACITACION_CREA,
					DTCAPACITACION_VE,
					DTASISTENCIA_CREA,
					DTASISTENCIA_VE,
					DTVISITAS_CREA,
					DTVISITAS_VE,
					DTCONSULTAS_CREA,
					DTCONSULTAS_VE,
					PRE_PUBLICA_DTCAPACITACION_VE,
					PUBLICA_DTCAPACITACION_CREA,
					ACUMULAR_DTCAPACITACION_CREA,
					DTUSUARIOEXTERNO_CREA,
					DTUSUARIOEXTERNO_VE,
					DTENTIDADES_CREA,
					DTENTIDADES_VE 
					})));
			put(PERFIL_USUARIO_EXTERNO_OGC, new ArrayList<String>(Arrays.asList(new String[] { 
							DTCONSULTAS_VE,
							PUBLICA_DTCAPACITACION_CREA,
							ACUMULAR_DTCAPACITACION_CREA 
					})));
			put(PERFIL_ADMINISTRADOR, new ArrayList<String>(Arrays.asList(new String[] { 
					DTCAPACITACION_CREA,
					DTCAPACITACION_VE,
					DTASISTENCIA_CREA,
					DTASISTENCIA_VE,
					DTVISITAS_CREA,
					DTVISITAS_VE,
					DTCONSULTAS_CREA,
					DTCONSULTAS_VE,
					PRE_PUBLICA_DTCAPACITACION_VE,
					PUBLICA_DTCAPACITACION_CREA,
					ACUMULAR_DTCAPACITACION_CREA,
					MSUSUARIOS_CREA,
					MSUSUARIOS_VE,
					DTUSUARIOEXTERNO_CREA,
					DTUSUARIOEXTERNO_VE,
					MSSISADMISTRATIVO_CREA,
					MSSISADMISTRATIVO_VE,
					MSTEMA_CREA,
					MSTEMA_VE,
					MSSUBTEMA_CREA,
					MSSUBTEMA_VE,
					DTENTIDADES_CREA,
					DTENTIDADES_VE,
					MSLOCAL_CREA,
					MSLOCAL_VE,
					REACTIVA_ANULADOS,
					REACTIVA_FINLIZADOS,
					MSSEDES_CREA,
					MSSEDES_VE,
					MSMETA_CREA,
					MSMETA_VE,
					MSINDICADOR_CREA,
					MSINDICADOR_VE,
					DTENCUESTA_CREA,
					DTENCUESTA_VE,
					MSPROYECTOINVERSION_CREA,
					MSPROYECTOINVERSION_VE,
					DTAMPLIACIONFECHA_CREA,
					DTAMPLIACIONFECHA_VE,
					REPORTE_SERVICIO_RESUMEN,
					REPORTE_SERVICIO_SEDE,
					REPORTE_SERVICIO_REPRESENTANTE,
					REPORTE_GENERICO,
					REPORTE_AVANCE_METAS,
					REPORTE_ENCUESTAS,
					REPORTE_GEOZONA,
					REPORTE_COBERTURA,
					REPORTE_DIRECTORIO,
					REPORTE_USU_INTERNO,
					REPORTE_USU_EXTERNO,
					PRTPARAMETROS_CREA,
					PRTPARAMETROS_VE,
					MSPAISES_CREA,
					MSPAISES_VE,
					MSALERTACARGOUSER_CREA,
					MSALERTACARGOUSER_VE,
					TAFERIADOS_CREA,
					TAFERIADOS_VE,
					MSUBIGEO_CREA,
					MSUBIGEO_VE,
					MSALERTA_CREA,
					MSALERTA_VE
					})));
		}
	};

	public static Map<String, String> ROLES_DESCRIPCION = new HashMap<String, String>() {
		/**
		 * 
		 */	
		private static final long serialVersionUID = 1730490346280234674L;		
		{
			put(ADMINISTRADOR, "ADMINISTRADOR DEL SISTEMA."); // 1
			put(DTCAPAENTIDADES_CREA, "CREA " + Messages.getStringToKey("dtCapaEntidades.comentariotabla"));
			put(DTCAPAENTIDADES_VE, "VISUALIZA " + Messages.getStringToKey("dtCapaEntidades.comentariotabla"));
			put(DTCAPAPUBLICO_CREA, "CREA " + Messages.getStringToKey("dtCapaPublico.comentariotabla"));
			put(DTCAPAPUBLICO_VE, "VISUALIZA " + Messages.getStringToKey("dtCapaPublico.comentariotabla"));
			put(MSPAISES_CREA, "CREA " + Messages.getStringToKey("msPaises.comentariotabla"));
			put(MSPAISES_VE, "VISUALIZA " + Messages.getStringToKey("msPaises.comentariotabla"));			
			put(DTCONSULTASPROYECTO_CREA, "CREA " + Messages.getStringToKey("dtConsultasProyecto.comentariotabla"));
			put(DTCONSULTASPROYECTO_VE, "VISUALIZA " + Messages.getStringToKey("dtConsultasProyecto.comentariotabla"));
			put(DTVISITASUSUINTERNOS_CREA, "CREA " + Messages.getStringToKey("dtVisitasUsuinternos.comentariotabla"));
			put(DTVISITASUSUINTERNOS_VE,
					"VISUALIZA " + Messages.getStringToKey("dtVisitasUsuinternos.comentariotabla"));
			put(DTASISTENCIA_CREA, "CREA " + Messages.getStringToKey("dtAsistencia.comentariotabla"));
			put(DTASISTENCIA_VE, "VISUALIZA " + Messages.getStringToKey("dtAsistencia.comentariotabla"));
			put(DTCAPACITACION_CREA, "CREA " + Messages.getStringToKey("dtCapacitacion.comentariotabla"));
			put(DTCAPACITACION_VE, "VISUALIZA " + Messages.getStringToKey("dtCapacitacion.comentariotabla"));
			put(PRE_PUBLICA_DTCAPACITACION_CREA, "PRE PUBLICA " + Messages.getStringToKey("predtCapacitacion.comentariotabla"));
			put(PRE_PUBLICA_DTCAPACITACION_VE, "VISUALIZA " + Messages.getStringToKey("predtCapacitacion.comentariotabla"));
			put(PUBLICA_DTCAPACITACION_CREA, "PUBLICA " + Messages.getStringToKey("publicadtCapacitacion.comentariotabla"));
			put(ACUMULAR_DTCAPACITACION_CREA, "ACUMULA " + Messages.getStringToKey("acumuladtCapacitacion.comentariotabla"));			
			put(MSALERTACARGOUSER_CREA, "CREA " + Messages.getStringToKey("msAlertaCargoUser.comentariotabla"));
			put(MSALERTACARGOUSER_VE, "VISUALIZA " + Messages.getStringToKey("msAlertaCargoUser.comentariotabla"));			
			put(TAFERIADOS_CREA, "CREA " + Messages.getStringToKey("taFeriados.comentariotabla"));
			put(TAFERIADOS_VE, "VISUALIZA " + Messages.getStringToKey("taFeriados.comentariotabla"));
			put(DTENTIDADES_CREA, "CREA " + Messages.getStringToKey("dtEntidades.comentariotabla"));
			put(DTENTIDADES_VE, "VISUALIZA " + Messages.getStringToKey("dtEntidades.comentariotabla"));			
			put(DTENTIDADSISADMIN_CREA, "CREA " + Messages.getStringToKey("dtEntidadSisAdmin.comentariotabla"));
			put(DTENTIDADSISADMIN_VE, "VISUALIZA " + Messages.getStringToKey("dtEntidadSisAdmin.comentariotabla"));
			put(DTVISITAS_CREA, "CREA " + Messages.getStringToKey("dtVisitas.comentariotabla"));
			put(DTVISITAS_VE, "VISUALIZA " + Messages.getStringToKey("dtVisitas.comentariotabla"));
			put(MSUSUARIOS_CREA, "CREA " + Messages.getStringToKey("msUsuarios.comentariotabla"));
			put(MSUSUARIOS_VE, "VISUALIZA " + Messages.getStringToKey("msUsuarios.comentariotabla"));			
			put(DTENTIDADESUSUEXTERNOS_CREA,
					"CREA " + Messages.getStringToKey("dtEntidadesUsuexternos.comentariotabla"));
			put(DTENTIDADESUSUEXTERNOS_VE,
					"VISUALIZA " + Messages.getStringToKey("dtEntidadesUsuexternos.comentariotabla"));
			put(PRTPARAMETROS_CREA, "CREA " + Messages.getStringToKey("prtParametros.comentariotabla"));
			put(PRTPARAMETROS_VE, "VISUALIZA " + Messages.getStringToKey("prtParametros.comentariotabla"));
			put(DTASISTENCIATEMAS_CREA, "CREA " + Messages.getStringToKey("dtAsistenciaTemas.comentariotabla"));
			put(DTASISTENCIATEMAS_VE, "VISUALIZA " + Messages.getStringToKey("dtAsistenciaTemas.comentariotabla"));
			put(DTUSUARIOEXTERNO_CREA, "CREA " + Messages.getStringToKey("dtUsuarioExterno.comentariotabla"));
			put(DTUSUARIOEXTERNO_VE, "VISUALIZA " + Messages.getStringToKey("dtUsuarioExterno.comentariotabla"));			
			put(MSUBIGEO_CREA, "CREA " + Messages.getStringToKey("msUbigeo.comentariotabla"));
			put(MSUBIGEO_VE, "VISUALIZA " + Messages.getStringToKey("msUbigeo.comentariotabla"));
			put(MSSISADMISTRATIVO_CREA, "CREA " + Messages.getStringToKey("msSisAdmistrativo.comentariotabla"));
			put(MSSISADMISTRATIVO_VE, "VISUALIZA " + Messages.getStringToKey("msSisAdmistrativo.comentariotabla"));			
			put(MSSUBTEMA_CREA, "CREA " + Messages.getStringToKey("msSubtema.comentariotabla"));
			put(MSSUBTEMA_VE, "VISUALIZA " + Messages.getStringToKey("msSubtema.comentariotabla"));			
			put(DTASISTENCIAUSUEXTERNOS_CREA,
					"CREA " + Messages.getStringToKey("dtAsistenciaUsuexternos.comentariotabla"));
			put(DTASISTENCIAUSUEXTERNOS_VE,
					"VISUALIZA " + Messages.getStringToKey("dtAsistenciaUsuexternos.comentariotabla"));
			put(DTCAPAPROYECTO_CREA, "CREA " + Messages.getStringToKey("dtCapaProyecto.comentariotabla"));
			put(DTCAPAPROYECTO_VE, "VISUALIZA " + Messages.getStringToKey("dtCapaProyecto.comentariotabla"));
			put(MSROLES_CREA, "CREA " + Messages.getStringToKey("msRoles.comentariotabla"));
			put(MSROLES_VE, "VISUALIZA " + Messages.getStringToKey("msRoles.comentariotabla"));
			put(MSPROYECTOINVERSION_CREA, "CREA " + Messages.getStringToKey("msProyectoInversion.comentariotabla"));
			put(MSPROYECTOINVERSION_VE, "VISUALIZA " + Messages.getStringToKey("msProyectoInversion.comentariotabla"));			
			put(DTAMPLIACIONFECHA_CREA, "CREA " + Messages.getStringToKey("dtAmpliacionFecha.comentariotabla"));
			put(DTAMPLIACIONFECHA_VE, "VISUALIZA " + Messages.getStringToKey("dtAmpliacionFecha.comentariotabla"));			
			put(DTENCUESTARESPUESTA_CREA, "CREA " + Messages.getStringToKey("dtEncuestaRespuesta.comentariotabla"));
			put(DTENCUESTARESPUESTA_VE, "VISUALIZA " + Messages.getStringToKey("dtEncuestaRespuesta.comentariotabla"));
			put(DTASISTENCIAPROYECTO_CREA, "CREA " + Messages.getStringToKey("dtAsistenciaProyecto.comentariotabla"));
			put(DTASISTENCIAPROYECTO_VE,
					"VISUALIZA " + Messages.getStringToKey("dtAsistenciaProyecto.comentariotabla"));
			put(MSSEDES_CREA, "CREA " + Messages.getStringToKey("msSedes.comentariotabla"));
			put(MSSEDES_VE, "VISUALIZA " + Messages.getStringToKey("msSedes.comentariotabla"));			
			put(DTVISITASTEMAS_CREA, "CREA " + Messages.getStringToKey("dtVisitasTemas.comentariotabla"));
			put(DTVISITASTEMAS_VE, "VISUALIZA " + Messages.getStringToKey("dtVisitasTemas.comentariotabla"));
			put(DTANEXO_CREA, "CREA " + Messages.getStringToKey("dtAnexo.comentariotabla"));
			put(DTANEXO_VE, "VISUALIZA " + Messages.getStringToKey("dtAnexo.comentariotabla"));
			put(DTCAPATEMAS_CREA, "CREA " + Messages.getStringToKey("dtCapaTemas.comentariotabla"));
			put(DTCAPATEMAS_VE, "VISUALIZA " + Messages.getStringToKey("dtCapaTemas.comentariotabla"));
			put(DTENTIDADSEDES_CREA, "CREA " + Messages.getStringToKey("dtEntidadSedes.comentariotabla"));
			put(DTENTIDADSEDES_VE, "VISUALIZA " + Messages.getStringToKey("dtEntidadSedes.comentariotabla"));
			put(DTCONSULTAS_CREA, "CREA " + Messages.getStringToKey("dtConsultas.comentariotabla"));
			put(DTCONSULTAS_VE, "VISUALIZA " + Messages.getStringToKey("dtConsultas.comentariotabla"));
			put(DTVISITASPROYECTO_CREA, "CREA " + Messages.getStringToKey("dtVisitasProyecto.comentariotabla"));
			put(DTVISITASPROYECTO_VE, "VISUALIZA " + Messages.getStringToKey("dtVisitasProyecto.comentariotabla"));
			put(DTCAPAUSUEXTERNOS_CREA, "CREA " + Messages.getStringToKey("dtCapaUsuexternos.comentariotabla"));
			put(DTCAPAUSUEXTERNOS_VE, "VISUALIZA " + Messages.getStringToKey("dtCapaUsuexternos.comentariotabla"));
			put(DTVISITASUSUEXTERNOS_CREA, "CREA " + Messages.getStringToKey("dtVisitasUsuexternos.comentariotabla"));
			put(DTVISITASUSUEXTERNOS_VE,
					"VISUALIZA " + Messages.getStringToKey("dtVisitasUsuexternos.comentariotabla"));
			put(DTCARGOSUSUEXTER_CREA, "CREA " + Messages.getStringToKey("dtCargosUsuexter.comentariotabla"));
			put(DTCARGOSUSUEXTER_VE, "VISUALIZA " + Messages.getStringToKey("dtCargosUsuexter.comentariotabla"));
			put(MSTEMA_CREA, "CREA " + Messages.getStringToKey("msTema.comentariotabla"));
			put(MSTEMA_VE, "VISUALIZA " + Messages.getStringToKey("msTema.comentariotabla"));			
			put(DTUSUARIOSSEDES_CREA, "CREA " + Messages.getStringToKey("dtUsuariosSedes.comentariotabla"));
			put(DTUSUARIOSSEDES_VE, "VISUALIZA " + Messages.getStringToKey("dtUsuariosSedes.comentariotabla"));
			put(MSINDICADOR_CREA, "CREA " + Messages.getStringToKey("msIndicador.comentariotabla"));
			put(MSINDICADOR_VE, "VISUALIZA " + Messages.getStringToKey("msIndicador.comentariotabla"));			
			put(DTENCUESTA_CREA, "CREA " + Messages.getStringToKey("dtEncuesta.comentariotabla"));
			put(DTENCUESTA_VE, "VISUALIZA " + Messages.getStringToKey("dtEncuesta.comentariotabla"));			
			put(MSLOCAL_CREA, "CREA " + Messages.getStringToKey("msLocal.comentariotabla"));
			put(MSLOCAL_VE, "VISUALIZA " + Messages.getStringToKey("msLocal.comentariotabla"));			
			put(MSMETA_CREA, "CREA " + Messages.getStringToKey("msMeta.comentariotabla"));
			put(MSMETA_VE, "VISUALIZA " + Messages.getStringToKey("msMeta.comentariotabla"));			
			put(MSALERTA_CREA, "CREA " + Messages.getStringToKey("msAlerta.comentariotabla"));
			put(MSALERTA_VE, "VISUALIZA " + Messages.getStringToKey("msAlerta.comentariotabla"));
			put(REACTIVA_ANULADOS, "REACTIVA ANULADOS");
			put(REACTIVA_FINLIZADOS, "REACTIVA FINALIZADOS");
			put(REPORTE_SERVICIO_RESUMEN, "REPORTE DE SERVICIOS RESUMÉN");
			put(REPORTE_SERVICIO_SEDE, "REPORTE DE SERVICIOS POR SEDE");
			put(REPORTE_SERVICIO_REPRESENTANTE, "REPORTE DE SERVICIOS POR REPRESENTANTE");
			put(REPORTE_GENERICO, "REPORTE GENÉRICO");
			put(REPORTE_AVANCE_METAS, "REPORTE DE AVANCES DE METAS");
			put(REPORTE_ENCUESTAS, "REPORTE DE ENCUESTAS");
			put(REPORTE_GEOZONA, "REPORTE DE GEOZONA");
			put(REPORTE_COBERTURA, "REPORTE DE COBERTURA");
			put(REPORTE_DIRECTORIO, "REPORTE DE DIRECTORIO");
			put(REPORTE_USU_INTERNO, "REPORTE DE USUARIO INTERNO");
			put(REPORTE_USU_EXTERNO, "REPORTE DE USUARIO EXTERNO");
			
		}
	};

	public static List<IDsValorDto> getRoles(int opcion) {

		List<IDsValorDto> rolesLista = new ArrayList<IDsValorDto>();
		Map<String, String> rolesMapa = null;
		switch (opcion) {
		case 0: {
			rolesMapa = ROLES_DESCRIPCION;
		}
			break;
		case 1: {

		}
			break;
		case 2: {

		}
			break;
		case 3: {

		}
			break;
		}
		Set<String> roles = rolesMapa.keySet();
		for (String rol : roles) {
			String codigo = rol;
			String descripcion = rolesMapa.get(rol);
			IDsValorDto rolesItemDto = new IDsValorDto(codigo, descripcion);
			rolesLista.add(rolesItemDto);
		}

		if (rolesLista != null && rolesLista.size() > 0) {
			Collections.sort(rolesLista, new Comparator<IDsValorDto>() {
				public int compare(IDsValorDto e1, IDsValorDto e2) {
					return e1.getValor().compareToIgnoreCase(e2.getValor());
				}
			});
		}
		return rolesLista;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HashMap sortValues(Map map) {
		List list = new LinkedList(map.entrySet());
		// Custom Comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		// copying the sorted list in HashMap to preserve the iteration order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static TreeMap sortKeys(Map map) {
		TreeMap tm = new TreeMap(map);
		return tm;
	}

	public static String getDescripcion(String key) {
		if (ROLES_DESCRIPCION.containsKey(key)) {
			return ROLES_DESCRIPCION.get(key);
		} else
			return key;
	}
}
