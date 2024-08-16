package pe.gob.mef.registramef.bs.dao.imp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import pe.gob.mef.registramef.bs.dao.ReporteServicioDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.ReporteAsistencia;
import pe.gob.mef.registramef.bs.domain.ReporteAsistenciaDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacion;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacionDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteConsulta;
import pe.gob.mef.registramef.bs.domain.ReporteVisita;
import pe.gob.mef.registramef.bs.domain.ReporteVisitaDetalle;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

@Repository
public class ReporteServicioDaoImp extends AbstractJpaCRUDDao<Object, Long>
		implements ReporteServicioDao, Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -5986693697314803124L;

	private static final Logger log = Logger.getLogger(ReporteServicioDaoImp.class.getName());

	private Long estadoNuevo = 3L;
	private Long estadoEliminado = 2L;
	private Long estadoFinalizado = 148L; // SPRINT_9.7

	public ReporteServicioDaoImp() {
//SPRINT_9.7 INICIO
		this.estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
//SPRINT_9.7 FIN
		this.estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
		this.estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
		log.log(Level.INFO, "INICIALIZANDO JPA TEMPLATE PARA MsUbigeoDaoImp " + "Nuevo: " + estadoNuevo + " Eliminado:"
				+ estadoEliminado);
	}

//SPRINT_9.7 INICIO
	public Long getEstadoFinalizado() {
		return estadoFinalizado;
	}

	public void setEstadoFinalizado(Long estadoFinalizado) {
		this.estadoFinalizado = estadoFinalizado;
	}

//SPRINT_9.7 FIN

	public Long getEstadoNuevo() {
		return estadoNuevo;
	}

	public void setEstadoNuevo(Long estadoNuevo) {
		this.estadoNuevo = estadoNuevo;
	}

	public Long getEstadoEliminado() {
		return estadoEliminado;
	}

	public void setEstadoEliminado(Long estadoEliminado) {
		this.estadoEliminado = estadoEliminado;
	}

	@Override
	public Class<Object> getDomainClass() {
// TODO Auto-generated method stub
		return null;
	}

	private static final String TABLESPACE = "REGISTRAMEF.";
	private static final String QUERY_ASISTENCIA = "SELECT " + "A.ID_ASISTENCIA, " + "A.FECHA_ASISTENCIA, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_MODALIDAD) AS MODALIDAD, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_ORIGEN) AS ORIGEN, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_PROGRAMACION) AS PROGRAMACION, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_FINANCIA) AS FINANCIAMIENTO, "
			+ "(SELECT ENT.COD_EJEC FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS COD_EJECUTORA, "
			+ "(SELECT ENT.RAZ_SOCIAL FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS ENTIDAD, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=(SELECT ENT.ID_TIPO FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD)) AS TIPO_ENTIDAD, "
			+ "(SELECT TEM.DESCRIPCION FROM MS_TEMA TEM WHERE TEM.ID_TEMA=B.ID_TEMA) AS TEMA, "
			+ "(SELECT SUBT.DESCRIPCION FROM MS_SUBTEMA SUBT WHERE SUBT.ID_SUBTEMA=B.ID_SUBTEMA) AS SUBTEMA, "
			+ "B.DETALLE, "
//+ "B.ID_ASIST_TEMA, "//--
			+ "CASE WHEN B.ID_ASIST_TEMA IS NULL THEN 0 ELSE B.ID_ASIST_TEMA END ID_ASIST_TEMA, "
//+ "C.ID_ASIST_USUEXT, "//--
			+ "CASE WHEN C.ID_ASIST_USUEXT IS NULL THEN 0 ELSE C.ID_ASIST_USUEXT END ID_ASIST_USUEXT, "
			+ "(SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA, "
			+ "(SELECT SED.SEDE FROM MS_SEDES SED WHERE SED.ID_SEDE=A.ID_SEDE) AS SEDE, "
			+ "(SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE SAD.ID_SIST_ADMI=A.ID_SIST_ADM) AS SIST_ADMIN, "
			+ "A.FECHA_CREA, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ESTADO) AS ESTADO, "
			+ "(SELECT UEX.A_PATERNO||' '||UEX.A_MATERNO||', '||UEX.NOMBRE FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=C.ID_USUEXTERNO) AS PARTICIPANTE, "
			+ "CASE WHEN EXISTS (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=C.ID_USUEXTERNO)  "
			+ "THEN (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=C.ID_USUEXTERNO) "
			+ "WHEN EXISTS (SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=C.ID_USUEXTERNO) "
			+ "THEN '(SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=C.ID_USUEXTERNO)' "
			+ "END DNI, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=C.ID_CARGO_USUEXT) AS CARGO, "
			+ "(SELECT UEX.CORREO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=C.ID_USUEXTERNO) AS CORREO "
			+ "FROM REGISTRAMEF.DT_ASISTENCIA A "
			+ "LEFT JOIN DT_ASISTENCIA_TEMAS B ON A.ID_ASISTENCIA=B.ID_ASISTENCIA AND B.ESTADO=3 "
			+ "LEFT JOIN DT_ASISTENCIA_USUEXTERNOS C ON A.ID_ASISTENCIA=C.ID_ASISTENCIA AND C.ESTADO=3 ";

//SPRINT22 INICIO
	private static final String QUERY_ASISTENCIA_V2 = "SELECT " + " ROWNUM AS ID, A.id_asistencia AS ID_ASISTENCIA, "
//+ " a.fecha_asistencia AS FECHA_SERVICIO, "
			+ " a.FECHA_SOLI  AS FECHA_SOLI, "// SPRINT01
			+ " (select MUSI.apellido_paterno||' '||MUSI.apellido_materno||', '||MUSI.nombres from ms_usuarios MUSI where MUSI.idusuario=B.id_usuinterno) as GEST_ESP_IMPL," // SPRINT01
																																												// usuario
																																												// interno
			+ " a.FECHA_ASISTENCIA  AS FECHA_SERVICIO, "// SPRINT_4
			+ " a.FECHA_PROGRAMADA as FECHA_PROGRAMADA, "// SPRINT_4
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_modalidad) as MODALIDAD, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_origen) as ORIGEN, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_programacion) as PROGRAMACION, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_financia) as FINANCIAMIENTO, "
			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad " // SPRINT_4
			+ "		AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=0 AND U.COD_DISTR=0 )DEPARTAMENTO_ENTIDAD, " // SPRINT_4
			+ "		(SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad " // SPRINT_4
			+ "		AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=0 )PROVINCIA_ENTIDAD, " // SPRINT_4
			+ "		(SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad " // SPRINT_4
			+ "		AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=E.COD_DISTR )DISTRITO_ENTIDAD, " // SPRINT_4

			+ " (select ENT.cod_ejec from dt_entidades ENT where ENT.id_entidad=A.id_entidad) as COD_EJECUTORA, "
			+ " (select ENT.raz_social from dt_entidades ENT where ENT.id_entidad=A.id_entidad) as ENTIDAD, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=(select ENT.id_tipo from dt_entidades ENT where ENT.id_entidad=A.id_entidad)) as TIPO_ENTIDAD, "
			+ " (select TEM.descripcion from ms_tema TEM where TEM.id_tema=B.id_tema) as TEMA, "
			+ " (select SUBT.descripcion from ms_subtema SUBT where SUBT.id_subtema=B.id_subtema) as SUBTEMA, "
//+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=B.estado) as ESTADO_TEMA, "
			+ " B.detalle,  "
			+ " (select MU.apellido_paterno||' '||MU.apellido_materno||', '||MU.nombres from ms_usuarios MU where MU.idusuario=a.idusser_crea) as USUARIO_CREA, "
			+ " (select SED.SEDE from ms_sedes SED where SED.id_sede=A.id_sede) as SEDE, "
			+ " (select SAD.descripcion from ms_sis_admistrativo SAD where SAD.id_sist_admi=b.id_sist_admi) as SIST_ADMIN, "// SPRINT02
//+ " (select SAD.descripcion from ms_sis_admistrativo SAD where SAD.id_sist_admi=a.id_sist_adm) as SIST_ADMIN, "
			+ " A.fecha_crea AS FECHA_CREA, "
//+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=C.estado) as ESTADO_PARTI, "
			+ " (select UEX.a_paterno||' '||UEX.a_materno||', '||UEX.nombre from dt_usuario_externo UEX where UEX.id_usuexterno=C.id_usuexterno) as PARTICIPANTE, "
			+ " CASE WHEN EXISTS (select UEX.num_docum from dt_usuario_externo UEX where UEX.id_usuexterno=C.id_usuexterno)  "
			+ " THEN (select UEX.num_docum from dt_usuario_externo UEX where UEX.id_usuexterno=C.id_usuexterno) "
			+ " WHEN EXISTS (select UEX.num_docu from dt_usuario_externo UEX where UEX.id_usuexterno=C.id_usuexterno)  "
			+ " THEN '(select UEX.num_docu from dt_usuario_externo UEX where UEX.id_usuexterno=C.id_usuexterno)' "
			+ " END DNI, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=C.id_cargo_usuext) as CARGO, "
			+ " (select UEX.correo from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as CORREO, "
			+ " (select UEX.TELEF_FIJO from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as TELEFONO_FIJO, "
			+ " (select UEX.TELEF_CELL from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as TELEFONO_CELULAR, "
			+ " (select UEX.OTRO_CELULAR from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as OTRO_CELULAR, "
			+ " (select UEX.OTRO_TELEFONO from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as OTRO_TELEFONO, "
//+ " (select UEX.TELEF_FIJO from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as OTRO_TELEFONO, "
//+ " (select UEX.TELEF_CELL from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as OTRO_CELULAR, "
//+ " (select UEX.OTRO_CELULAR from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as TELEFONO_CELULAR, "
//+ " (select UEX.OTRO_TELEFONO from dt_usuario_externo UEX where UEX.id_usuexterno=c.id_usuexterno) as TELEFONO_FIJO, "
////+ " A.fecha_modif AS FECHA_FINALIZACION, " //SPRINT_4
			+ " case  WHEN (A.estado =148 and A.Fecha_Finalizacion is null  ) THEN  A.fecha_modif		 " // SPRINT_4
			+ "    WHEN (A.estado =148 and A.Fecha_Finalizacion is not null  ) THEN A.Fecha_Finalizacion   " // SPRINT_4
			+ "    when (a.estado=2 and a.fecha_finalizacion is not null ) THEN A.Fecha_Finalizacion   " // SPRINT_4
			+ "    ELSE null		  " // SPRINT_4
			+ "   END FECHA_FINALIZACION,  " // SPRINT_4
//+ " A.estado as ESTADO_1, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.estado) as ESTADO, "
//SPRINT02 INICIO
			+ " CASE  " + " WHEN C.ctrl_confirmacion=2 THEN 'SÍ'  " + " ELSE ''  " + " END CTRL_CONFIRMACION, "
			// SPRINT02 FIN
			+ "  CASE WHEN C.ID_ASIST_USUEXT IS NULL THEN 0 ELSE C.ID_ASIST_USUEXT END ID_ASIST_USUEXT "
			+ " FROM dt_asistencia a "
//+ " left join dt_asistencia_temas b on a.id_asistencia=b.id_asistencia  "
//+ " left join dt_asistencia_usuexternos c on a.id_asistencia=c.id_asistencia  "
			+ " left join dt_asistencia_temas b on a.id_asistencia=b.id_asistencia  and b.estado=3 " // SPRINT30 SE
																										// AGREGÓ LOS
																										// ESTADOS
			+ " left join dt_asistencia_usuexternos c on a.id_asistencia=c.id_asistencia and c.estado=3 "// SPRINT30 SE
																											// AGREGÓ
																											// LOS
																											// ESTADOS
	;

//SPRINT24 SE AGREGÓ LA FILTRO DE ESTADO and b.estado=3 Y and c.estado=3
	private static final String QUERY_CAPACITACION_V2 = "SELECT " + " rownum as id, "
			+ " a.id_capacitacion as id_capacitacion, " + " A.nom_evento, " + " A.FECHA_SOLI, " // SPRINT01
			+ " A.STD_NUMERO_SID || '-'||A.STD_NUMERO_ANIO AS HOJA_RUTA  , " // SPRINT02
			+ " CASE  "// SPRINT02
			+ " WHEN A.FLAG_EJEC=2 THEN 'NO'  "// SPRINT02
			+ " WHEN A.FLAG_EJEC=1 THEN 'SÍ'  "// SPRINT02
			+ " END FLAG_EJEC, " // SPRINT02
			+ " A.MOTIVO_EJEC as MOTIVO, " // SPRINT02
			+ " A.STD_MODALIDAD_ING as MODALIDAD_INGRESO, " // SPRINT02
			+ "  A.fecha_inic AS FECHA_INIC, " // SPRINT_4
			+ "  A.fecha_fin AS FECHA_FIN, " // SPRINT_4
			+ " A.FECHA_INI_PROGRAMADA AS FECHA_INI_PROGRAMADA, " // SPRINT_4
			+ " A.FECHA_FIN_PROGRAMADA AS FECHA_FIN_PROGRAMADA, " // SPRINT_4
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_origen) as ORIGEN, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_modo) as MODO, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_programacion) as PROGRAMACION, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_financia) as FINANCIAMIENTO, "
			+ " (select LOC.descripcion from ms_local LOC where LOC.ID_LOCAL=A.id_local) as LOCAL, "
			+ " A.cant_partic AS PARTIC_PROGRAMADOS, " + " A.cant_partic_asist AS PARTIC_ASISTENTES, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_nivel) as NIVEL, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_prestacion) as PRESTACION, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_tipo) as TIPO, "
			+ " (select MUSI.apellido_paterno||' '||MUSI.apellido_materno||', '||MUSI.nombres from ms_usuarios MUSI where MUSI.idusuario=B.id_usuinterno) as GEST_ESP_IMPL, "
			+ " (select SAD.DESCRIPCION from ms_sis_admistrativo SAD where B.id_sist_admi=SAD.id_sist_admi) as SIST_ADMIN_PONENTE, "
			+ " (select TEM.descripcion from ms_tema TEM where TEM.id_tema=B.id_tema) as TEMA, "
			+ " (select SUBT.descripcion from ms_subtema SUBT where SUBT.id_subtema=B.id_subtema) as SUBTEMA, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=B.estado) as ESTADO_TEMA, "
			+ " (SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA,  "
			+ " (select SED.SEDE from ms_sedes SED where SED.id_sede=A.id_sede) as SEDE, "
			+ " (select SAD.DESCRIPCION from ms_sis_admistrativo SAD where A.id_sist_adm=SAD.id_sist_admi) as SIST_ADMIN_CREA, "
			+ " A.fecha_crea AS FECHA_CREA, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.ESTADO) as ESTADO, "
			+ " A.ESTADO AS ESTADO_ID, " + " A.idcapa_padre, "
			+ " (select UEX.a_paterno||' '||UEX.a_materno||', '||UEX.nombre from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as PARTICIPANTE, "
			+ " (select UEX.num_docum from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as DNI, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=VUEX.id_cargo_usuext) as CARGO, "
			+ " (select UEX.TELEF_FIJO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_FIJO, "
			+ " (select UEX.TELEF_CELL from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_CELULAR, "
			+ " (select UEX.OTRO_CELULAR from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_CELULAR, "
			+ " (select UEX.OTRO_TELEFONO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_TELEFONO, "
//+ " (select UEX.TELEF_FIJO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_TELEFONO, "
//+ " (select UEX.TELEF_CELL from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_CELULAR, "
//+ " (select UEX.OTRO_CELULAR from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_CELULAR, "
//+ " (select UEX.OTRO_TELEFONO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_FIJO, "
			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=VUEX.id_entidad  " // SPRINT_4
			+ " AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=0 AND U.COD_DISTR=0 )DEPARTAMENTO_ENTIDAD,  " // SPRINT_4
			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=VUEX.id_entidad  " // SPRINT_4
			+ " AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=0 )PROVINCIA_ENTIDAD,  " // SPRINT_4
			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=VUEX.id_entidad  " // SPRINT_4
			+ " AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=E.COD_DISTR )DISTRITO_ENTIDAD , " // SPRINT_4
			+ " (select ENT.raz_social from dt_entidades ENT where ENT.id_entidad=VUEX.id_entidad) as ENTIDAD, "
			+ " (select ENT.cod_ejec from dt_entidades ENT where ENT.id_entidad=VUEX.id_entidad) as CODIGO_EJECUTORA, "
			+ " VUEX.id_usuexterno, " + " VUEX.correo_usuext as CORREO_PARTICIPANTE, " + " CASE  "
			+ " WHEN VUEX.FLAG_ASISTENCIA=0 THEN 'NO'  " + " WHEN VUEX.FLAG_ASISTENCIA=1 THEN 'SI'  "
			+ " WHEN VUEX.FLAG_ASISTENCIA='' THEN 'NO'  " + " END ASISTIO, " + " CASE  "
			+ " WHEN VUEX.FLAG_CONFIR_REG=0 THEN 'NO'  " + " WHEN VUEX.FLAG_CONFIR_REG=1 THEN 'SI'  "
			+ " WHEN VUEX.FLAG_CONFIR_REG='' THEN 'NO'  " + " END CONFIRMAR, " + " CASE  "
			+ " WHEN VUEX.FLAG_MEDIOREG=0 THEN 'NO'  " + " WHEN VUEX.FLAG_MEDIOREG=1 THEN 'SI'  "
			+ " WHEN VUEX.FLAG_MEDIOREG='' THEN 'NO'  " + " END INSCRIPCION_VIRTUAL, "
			+ " a.detalle_capa_virtual as ENLACE_CONECCION_VIRTUAL, " + " CASE  " + " WHEN a.flag_publi=0 THEN 'NO'  "
			+ " WHEN a.flag_publi=1 THEN 'SI'  " + " WHEN a.flag_publi='' THEN 'NO'  " + " END PUBLICADO, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=A.id_modalidad) as MODALIDAD, "
//+ " A.fecha_modif AS FECHA_FINALIZACION, " SPRINT_4
			+ " case WHEN (A.estado =148 and A.Fecha_Finalizacion is null  ) THEN  A.fecha_modif	  " // SPRINT_4
			+ "    WHEN (A.estado =148 and A.Fecha_Finalizacion is not null  ) THEN A.Fecha_Finalizacion   " // SPRINT_4
			+ "    when (a.estado=2 and a.fecha_finalizacion is not null ) THEN A.Fecha_Finalizacion   " // SPRINT_4
			+ "   when (a.estado=149 and a.fecha_finalizacion is not null ) THEN A.Fecha_Finalizacion  " // SPRINT_4
			+ "    ELSE null		 " // SPRINT_4
			+ " END FECHA_FINALIZACION,  " // SPRINT_4

			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=VUEX.ESTADO) as ESTADO_PARTI "
			+ " FROM registramef.dt_capacitacion a "
			+ " LEFT JOIN dt_capa_temas b on a.id_capacitacion=b.id_capacitacion AND B.estado=3 "
			+ " LEFT JOIN dt_capa_usuexternos VUEX ON A.id_capacitacion=VUEX.id_capacitacion AND VUEX.ESTADO=3 ";

//SPRINT24 INICIO
	private static final String QUERY_CAPACITACION_TOTAL_V2 = " SELECT COUNT(*) "
			+ " FROM registramef.dt_capacitacion a "
			+ " LEFT JOIN dt_capa_temas b on a.id_capacitacion=b.id_capacitacion AND B.estado=3 "
			+ " LEFT JOIN dt_capa_usuexternos VUEX ON A.id_capacitacion=VUEX.id_capacitacion AND VUEX.ESTADO=3 ";
	private static final String QUERY_CONSULTA_TOTAL_V2 = "SELECT COUNT(*)  " + "  FROM REGISTRAMEF.DT_CONSULTAS A ";

	private static final String QUERY_ASISTENCIA_TOTAL_V2 = "SELECT COUNT(*) " + " FROM dt_asistencia a "
			+ " left join dt_asistencia_temas b on a.id_asistencia=b.id_asistencia  and b.estado=3 "
			+ " left join dt_asistencia_usuexternos c on a.id_asistencia=c.id_asistencia and c.estado=3 "

	;
	private static final String QUERY_VISITAS_TOTAL_V2 = "SELECT COUNT(*) " + "   FROM REGISTRAMEF.DT_VISITAS A "
			+ "   LEFT JOIN DT_VISITAS_USUINTERNOS UI ON A.ID_VISITA=UI.ID_VISITA AND UI.ESTADO=3 "
			+ " LEFT JOIN DT_VISITAS_USUEXTERNOS VUEX ON A.ID_VISITA=VUEX.ID_VISITA AND VUEX.ESTADO=3 ";

//SPRINT24 FIN

	private static final String QUERY_CONSULTA_V2 = "SELECT " + " A.ID_CONSULTA, "
			+ " (SELECT ENT.RAZ_SOCIAL FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS ENTIDAD, "
			+ " (SELECT ENT.COD_EJEC FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS EJECUTORA, "
			+ " A.FECHA_SOLI, " // SPRINT01
			+ " A.FECHA_CONSU, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_MODALIDAD) AS MODALIDAD, "
			+ " (SELECT TEM.DESCRIPCION FROM MS_TEMA TEM WHERE TEM.ID_TEMA=A.ID_TEMA) AS TEMA, "
			+ " (SELECT SUBT.DESCRIPCION FROM MS_SUBTEMA SUBT WHERE SUBT.ID_SUBTEMA=A.ID_SUBTEMA) AS SUBTEMA, "
			+ " A.RESPUESTA, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ESTADO) AS ESTADO, "
			+ " (SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA,  "
			+ " A.FECHA_CREA AS FECHA_CREA, "
			+ " (SELECT SED.SEDE FROM MS_SEDES SED WHERE SED.ID_SEDE=A.ID_SEDE) AS SEDE_CREA, "
			+ " (SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE A.ID_SIST_ADM=SAD.ID_SIST_ADMI) AS SIST_ADMIN, "
			+ " (SELECT UEX.A_PATERNO||' '||UEX.A_MATERNO||', '||UEX.NOMBRE FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS PARTICIPANTE, "
			+ " CASE WHEN EXISTS (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO)  "
			+ " THEN (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) "
			+ " WHEN EXISTS (SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO)  "
			+ " THEN '(SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO)' "
			+ " END DNI, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_CARGO) AS CARGO, "
			+ " (SELECT UEX.CORREO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS CORREO, "
			+ " (SELECT UEX.TELEF_FIJO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS TELEFONO_FIJO, "
			+ " (SELECT UEX.TELEF_CELL FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS TELEFONO_CELULAR, "
			+ " (SELECT UEX.OTRO_CELULAR FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS OTRO_CELULAR, "
			+ " (SELECT UEX.OTRO_TELEFONO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS OTRO_TELEFONO, "
//+ " (SELECT UEX.TELEF_FIJO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS OTRO_TELEFONO, "
//+ " (SELECT UEX.TELEF_CELL FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS OTRO_CELULAR, "
//+ " (SELECT UEX.OTRO_CELULAR FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS TELEFONO_CELULAR, "
//+ " (SELECT UEX.OTRO_TELEFONO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS TELEFONO_FIJO, "
//+ " A.FECHA_MODIF AS FECHA_FINALIZACION "
			+ " case WHEN (A.estado =148 and A.Fecha_Finalizacion is null  ) THEN  A.fecha_modif  " // SPRINT_4
			+ "   WHEN (A.estado =148 and A.Fecha_Finalizacion is not null  ) THEN A.Fecha_Finalizacion   " // SPRINT_4
			+ "    when (a.estado=2 and a.fecha_finalizacion is not null ) THEN A.Fecha_Finalizacion   " // SPRINT_4
			+ "    ELSE null		 " // SPRINT_4
			+ " END FECHA_FINALIZACION,  " // SPRINT_4

			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad  " // SPRINT_4
			+ " 		AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=0 AND U.COD_DISTR=0 )DEPARTAMENTO_ENTIDAD,  " // SPRINT_4
			+ " 		(SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad  " // SPRINT_4
			+ " 		AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=0 )PROVINCIA_ENTIDAD,  " // SPRINT_4
			+ " 		(SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad  " // SPRINT_4
			+ " 		AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=E.COD_DISTR )DISTRITO_ENTIDAD  " // SPRINT_4
			+ "  FROM REGISTRAMEF.DT_CONSULTAS A "

	;

	private static final String QUERY_VISITAS_V2 = "SELECT " + " ROWNUM AS ID, " + " A.ID_VISITA AS ID_VISITA, "
			+ " (SELECT ENT.COD_EJEC FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS COD_EJECUTORA, "
			+ " (SELECT ENT.RAZ_SOCIAL FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS ENTIDAD, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=(SELECT ENT.ID_TIPO FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD)) AS TIPO_ENTIDAD, "
			+ " (SELECT ENT.GEOZONA FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS GEOZONA, "
			+ " A.FECHA_VISITA AS FECHA_VISITA, "// SPRINT_4
			+ "  A.FECHA_PROGRAMADA AS FECHA_PROGRAMADA, " // SPRINT_4
//+ " A.FECHA_VISITA AS FECHA_VISITA, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_LUGAR) AS LUGAR_REU, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_ORIGEN) AS ORIGEN, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_PROGRAMACION) AS PROGRAMACION, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_FINANCIA) AS FINANCIAMIENTO, "
			+ " (SELECT US.APELLIDO_PATERNO||' '||US.APELLIDO_MATERNO||', '||US.NOMBRES FROM MS_USUARIOS US WHERE US.IDUSUARIO=UI.ID_USUINTERNO) AS GESTOR_ESP_IMPLAN, "
			+ " (SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE SAD.ID_SIST_ADMI=A.ID_SIST_ADM) AS SIST_ADMIN_CREA, "
			+ " (SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE SAD.ID_SIST_ADMI=(SELECT US.ID_SIST_ADMI FROM MS_USUARIOS US WHERE US.IDUSUARIO=UI.ID_USUINTERNO)) AS SIST_ADMIN_GEST, "
			+ " (SELECT TEM.DESCRIPCION FROM MS_TEMA TEM WHERE TEM.ID_TEMA=UI.ID_TEMA) AS TEMA, "
			+ " (select PRT.descripcion from prt_parametros PRT where PRT.IDPARAMETRO=UI.estado) as ESTADO_TEMA, "
			+ " (SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA, "
			+ " (SELECT SED.SEDE FROM MS_SEDES SED WHERE SED.ID_SEDE=A.ID_SEDE) AS SEDE, "
			+ " A.FECHA_CREA AS FECHA_CREA, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ESTADO) AS ESTADO, "
			+ " A.ESTADO AS ESTADO_ID, "
			+ " (SELECT UEX.A_PATERNO||' '||UEX.A_MATERNO||', '||UEX.NOMBRE FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) AS PARTICIPANTE, "
			+ " CASE WHEN EXISTS (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO)  "
			+ " THEN (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) "
			+ " WHEN EXISTS (SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO)  "
			+ " THEN '(SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO)' "
			+ " END DNI, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=VUEX.ID_CARGO_USUEXT) AS CARGO, "
			+ " (SELECT UEX.CORREO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) AS CORREO, "
			+ " (select UEX.TELEF_FIJO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_FIJO, "
			+ " (select UEX.TELEF_CELL from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_CELULAR, "
			+ " (select UEX.OTRO_CELULAR from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_CELULAR, "
			+ " (select UEX.OTRO_TELEFONO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_TELEFONO,  "
//+ " (select UEX.TELEF_FIJO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_TELEFONO, "
//+ " (select UEX.TELEF_CELL from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as OTRO_CELULAR, "
//+ " (select UEX.OTRO_CELULAR from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_CELULAR, "
//+ " (select UEX.OTRO_TELEFONO from dt_usuario_externo UEX where UEX.id_usuexterno=VUEX.id_usuexterno) as TELEFONO_FIJO,  "
			+ " A.fecha_modif AS FECHA_FINALIZACION, "
			+ " (SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=VUEX.ESTADO) AS ESTADO_PARTI,  "// SPRINT_4
																														// LA
																														// COMA

			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.ID_ENTIDAD  "// SPRINT_4
			+ " AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=0 AND U.COD_DISTR=0 )DEPARTAMENTO_ENTIDAD,  "// SPRINT_4
			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad  "// SPRINT_4
			+ " AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=0 )PROVINCIA_ENTIDAD,  "// SPRINT_4
			+ " (SELECT DESCRIPCION FROM MS_UBIGEO U,  dt_entidades E WHERE  E.id_entidad=A.id_entidad  "// SPRINT_4
			+ " AND U.COD_DPTO=E.COD_DPTO AND U.COD_PROV=E.COD_PROV AND U.COD_DISTR=E.COD_DISTR )DISTRITO_ENTIDAD  "// SPRINT_4

			+ "   FROM REGISTRAMEF.DT_VISITAS A "
			+ "   LEFT JOIN DT_VISITAS_USUINTERNOS UI ON A.ID_VISITA=UI.ID_VISITA AND UI.ESTADO=3 "
			+ " LEFT JOIN DT_VISITAS_USUEXTERNOS VUEX ON A.ID_VISITA=VUEX.ID_VISITA AND VUEX.ESTADO=3 ";
//SPRINT22 FIN

	private static final String QUERY_CONSULTA = "SELECT " + "A.ID_CONSULTA, "
			+ "(SELECT ENT.RAZ_SOCIAL FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS ENTIDAD, "
			+ "(SELECT ENT.COD_EJEC FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS EJECUTORA, "
			+ "A.FECHA_CONSU, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_MODALIDAD) AS MODALIDAD, "
			+ "(SELECT TEM.DESCRIPCION FROM MS_TEMA TEM WHERE TEM.ID_TEMA=A.ID_TEMA) AS TEMA, "
			+ "(SELECT SUBT.DESCRIPCION FROM MS_SUBTEMA SUBT WHERE SUBT.ID_SUBTEMA=A.ID_SUBTEMA) AS SUBTEMA, "
			+ "A.RESPUESTA, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ESTADO) AS ESTADO, "
			+ "(SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA, "
			+ "A.FECHA_CREA, " + "(SELECT SED.SEDE FROM MS_SEDES SED WHERE SED.ID_SEDE=A.ID_SEDE) AS SEDE, "
			+ "(SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE A.ID_SIST_ADM=SAD.ID_SIST_ADMI) AS SIST_ADMIN, "
			+ "(SELECT UEX.A_PATERNO||' '||UEX.A_MATERNO||', '||UEX.NOMBRE FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS PARTICIPANTE, "
			+ "CASE WHEN EXISTS (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO)  "
			+ "THEN (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) "
			+ "WHEN EXISTS (SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) "
			+ "THEN '(SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO)' "
			+ "END DNI, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_CARGO) AS CARGO, "
			+ "(SELECT UEX.CORREO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=A.ID_USUEXTERNO) AS CORREO "
			+ "FROM REGISTRAMEF.DT_CONSULTAS A ";

	private static final String QUERY_VISITAS = "SELECT " + "A.ID_VISITA, "
			+ "(SELECT ENT.COD_EJEC FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS COD_EJECUTORA, "
			+ "(SELECT ENT.RAZ_SOCIAL FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS ENTIDAD, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=(SELECT ENT.ID_TIPO FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD)) AS TIPO_ENTIDAD, "
			+ "(SELECT ENT.GEOZONA FROM DT_ENTIDADES ENT WHERE ENT.ID_ENTIDAD=A.ID_ENTIDAD) AS GEOZONA, "
			+ "A.FECHA_VISITA, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_LUGAR) AS LUGAR_REU, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_ORIGEN) AS ORIGEN, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_PROGRAMACION) AS PROGRAMACION, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_FINANCIA) AS FINANCIAMIENTO, "
			+ "(SELECT US.APELLIDO_PATERNO||' '||US.APELLIDO_MATERNO||', '||US.NOMBRES FROM MS_USUARIOS US WHERE US.IDUSUARIO=UI.ID_USUINTERNO) AS GESTOR_ESP_IMPLAN, "
			+ "(SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE SAD.ID_SIST_ADMI=A.ID_SIST_ADM) AS SIST_ADMIN_CREA, "
			+ "(SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE SAD.ID_SIST_ADMI=(SELECT US.ID_SIST_ADMI FROM MS_USUARIOS US WHERE US.IDUSUARIO=UI.ID_USUINTERNO)) AS SIST_ADMIN_GEST, "
			+ "(SELECT TEM.DESCRIPCION FROM MS_TEMA TEM WHERE TEM.ID_TEMA=UI.ID_TEMA) AS TEMA, "
			+ "(SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA, "
			+ "(SELECT SED.SEDE FROM MS_SEDES SED WHERE SED.ID_SEDE=A.ID_SEDE) AS SEDE, " + "A.FECHA_CREA, "
//+ "UI.ID_VISIT_USUINT, "//--
			+ "CASE WHEN UI.ID_VISIT_USUINT IS NULL THEN 0 ELSE UI.ID_VISIT_USUINT END ID_VISIT_USUINT, "
//+ "VUEX.ID_VISIT_USUEXT, "//--
			+ "CASE WHEN VUEX.ID_VISIT_USUEXT IS NULL THEN 0 ELSE VUEX.ID_VISIT_USUEXT END ID_VISIT_USUEXT, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ESTADO) AS ESTADO, "
			+ "(SELECT UEX.A_PATERNO||' '||UEX.A_MATERNO||', '||UEX.NOMBRE FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) AS PARTICIPANTE, "
			+ "CASE WHEN EXISTS (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO)  "
			+ "THEN (SELECT UEX.NUM_DOCUM FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) "
			+ "WHEN EXISTS (SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) "
			+ "THEN '(SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO)' "
			+ "END DNI, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=VUEX.ID_CARGO_USUEXT) AS CARGO, "
			+ "(SELECT UEX.CORREO FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) AS CORREO "
			+ "FROM REGISTRAMEF.DT_VISITAS A "
			+ "LEFT JOIN DT_VISITAS_USUINTERNOS UI ON A.ID_VISITA=UI.ID_VISITA AND UI.ESTADO=3 "
			+ "LEFT JOIN DT_VISITAS_USUEXTERNOS VUEX ON A.ID_VISITA=VUEX.ID_VISITA AND VUEX.ESTADO=3 "

	;

	private static final String QUERY_CAPACITACION = "SELECT " + "A.ID_CAPACITACION, " + "A.NOM_EVENTO, "
			+ "A.FECHA_INIC, " + "A.FECHA_FIN, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_ORIGEN) AS ORIGEN, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_MODO) AS MODO, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_PROGRAMACION) AS PROGRAMACION, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_FINANCIA) AS FINANCIAMIENTO, "
			+ "(SELECT LOC.DESCRIPCION FROM MS_LOCAL LOC WHERE LOC.ID_LOCAL=A.ID_LOCAL) AS LOCAL, " + "A.CANT_PARTIC, "
			+ "A.CANT_PARTIC_ASIST, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_NIVEL) AS NIVEL, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_PRESTACION) AS PRESTACION, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ID_TIPO) AS TIPO, "
			+ "(SELECT MUSI.APELLIDO_PATERNO||' '||MUSI.APELLIDO_MATERNO||', '||MUSI.NOMBRES FROM MS_USUARIOS MUSI WHERE MUSI.IDUSUARIO=B.ID_USUINTERNO) AS GEST_ESP_IMPL, "
			+ "(SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE B.ID_SIST_ADMI=SAD.ID_SIST_ADMI) AS SIST_ADMIN_PONENTE, "
			+ "(SELECT TEM.DESCRIPCION FROM MS_TEMA TEM WHERE TEM.ID_TEMA=B.ID_TEMA) AS TEMA, "
			+ "(SELECT SUBT.DESCRIPCION FROM MS_SUBTEMA SUBT WHERE SUBT.ID_SUBTEMA=B.ID_SUBTEMA) AS SUBTEMA, "
			+ "(SELECT MU.APELLIDO_PATERNO||' '||MU.APELLIDO_MATERNO||', '||MU.NOMBRES FROM MS_USUARIOS MU WHERE MU.IDUSUARIO=A.IDUSSER_CREA) AS USUARIO_CREA, "
			+ "(SELECT SED.SEDE FROM MS_SEDES SED WHERE SED.ID_SEDE=A.ID_SEDE) AS SEDE, "
			+ "(SELECT SAD.DESCRIPCION FROM MS_SIS_ADMISTRATIVO SAD WHERE A.ID_SIST_ADM=SAD.ID_SIST_ADMI) AS SIST_ADMIN_CREA, "
			+ "A.FECHA_CREA, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=A.ESTADO) AS ESTADO, "
			+ "A.IDCAPA_PADRE, " + "VUEX.ID_USUEXTERNO, "
//+ "VUEX.ID_CAPA_USUEXT, "
			+ "CASE WHEN VUEX.ID_CAPA_USUEXT IS NULL THEN 0 ELSE VUEX.ID_CAPA_USUEXT END ID_CAPA_USUEXT, "
//+ "B.ID_CAPA_TEM_AGEN, "
			+ "CASE WHEN B.ID_CAPA_TEM_AGEN IS NULL THEN 0 ELSE B.ID_CAPA_TEM_AGEN END ID_CAPA_TEM_AGEN, "
			+ "(SELECT UEX.A_PATERNO||' '||UEX.A_MATERNO||', '||UEX.NOMBRE FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) AS PARTICIPANTE, "
			+ "(SELECT UEX.NUM_DOCU FROM DT_USUARIO_EXTERNO UEX WHERE UEX.ID_USUEXTERNO=VUEX.ID_USUEXTERNO) AS DNI, "
			+ "(SELECT PRT.DESCRIPCION FROM PRT_PARAMETROS PRT WHERE PRT.IDPARAMETRO=VUEX.ID_CARGO_USUEXT) AS CARGO, "
			+ "(SELECT COD.COD_EJEC FROM DT_ENTIDADES COD WHERE COD.ID_ENTIDAD=VUEX.ID_ENTIDAD) AS COD_EJECUTOR, "
			+ "(SELECT COD.RAZ_SOCIAL FROM DT_ENTIDADES COD WHERE COD.ID_ENTIDAD=VUEX.ID_ENTIDAD) AS ENTIDAD "
			+ "FROM REGISTRAMEF.DT_CAPACITACION A "
			+ "LEFT JOIN DT_CAPA_TEMAS B ON A.ID_CAPACITACION=B.ID_CAPACITACION AND B.ESTADO=3 "
			+ "LEFT JOIN DT_CAPA_USUEXTERNOS VUEX ON A.ID_CAPACITACION=VUEX.ID_CAPACITACION AND VUEX.ESTADO=3 ";

	public List<ReporteAsistencia> getResumenAsistencias(Date fechaInicio, Date fechaFin, Long idSistAdmin,
			Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append(QUERY_ASISTENCIA);

		if (fechaInicio != null && fechaFin != null) {
			sb.append(" WHERE A.FECHA_ASISTENCIA >= ? and A.FECHA_ASISTENCIA < ? ");
			hs.add(fechaInicio);
			hs.add(fechaFin);
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

		sb.append(" ORDER BY A.ID_ASISTENCIA ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<ReporteAsistencia> lista = super.findNaviteQueryEdtidad(sb.toString(), param, ReporteAsistencia.class);

		return lista;
	}

	public List<ReporteCapacitacion> getResumenCapacitaciones(Date fechaInicio, Date fechaFin, Long idSistAdmin,
			Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append(QUERY_CAPACITACION);

		if (fechaInicio != null && fechaFin != null) {
			sb.append(" WHERE A.FECHA_INIC >= ? and A.FECHA_INIC < ? ");
			hs.add(fechaInicio);
			hs.add(fechaFin);
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

		sb.append(" ORDER BY A.ID_CAPACITACION ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<ReporteCapacitacion> lista = super.findNaviteQueryEdtidad(sb.toString(), param, ReporteCapacitacion.class);

		return lista;
	}

	public List<ReporteConsulta> getResumenConsultas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append(QUERY_CONSULTA);

		if (fechaInicio != null && fechaFin != null) {
			sb.append(" WHERE A.FECHA_CONSU >= ? and A.FECHA_CONSU < ? ");
			hs.add(fechaInicio);
			hs.add(fechaFin);
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

		sb.append(" ORDER BY A.ID_CONSULTA ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<ReporteConsulta> lista = super.findNaviteQueryEdtidad(sb.toString(), param, ReporteConsulta.class);

		return lista;
	}

	public List<ReporteVisita> getResumenVisitas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append(QUERY_VISITAS);

		if (fechaInicio != null && fechaFin != null) {
			sb.append(" WHERE A.FECHA_VISITA >= ? and A.FECHA_VISITA < ? ");
			hs.add(fechaInicio);
			hs.add(fechaFin);
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

		sb.append(" ORDER BY A.ID_VISITA ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<ReporteVisita> lista = super.findNaviteQueryEdtidad(sb.toString(), param, ReporteVisita.class);

		return lista;
	}

//SPRINT22 INICIO
//public List<ReporteAsistenciaDetallado> getResumenAsistenciasDetallado(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro , Integer minRegistro)throws Validador  {//SPRINT_8
	public List<ReporteAsistenciaDetallado> getResumenAsistenciasDetallado(Long idEstado, Long idUserInt,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador {// SPRINT_8.3

		StringBuffer sb = new StringBuffer(400);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(QUERY_ASISTENCIA_V2);
		sb.append(" where a.estado>0 ");

		if (fechaInicio != null && fechaFin != null) {
//	sb.append(" AND TRUNC(A.FECHA_ASISTENCIA) BETWEEN TO_DATE('" + sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");
			sb.append(" AND TRUNC(A.FECHA_ASISTENCIA) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");// SPRINT_4
			// sb.append(" AND TRUNC(A.FECHA_PROGRAMADA) BETWEEN TO_DATE('" +
			// sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" +
			// sdf.format(fechaFin) + "','DD/MM/YYYY') ");//SPRINT_4
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and ( A.ID_SIST_ADM = ? or B.ID_SIST_ADMI = ?)");// SPRINT02
			hs.add(idSistAdmin);
			hs.add(idSistAdmin);// SPRINT02
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" and ( a.ID_USUINTERNO = ? OR b.ID_USUINTERNO= ? ) ");
			hs.add(idUserInt);
			hs.add(idUserInt);
		}
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and a.estado = ?  ");
			hs.add(idEstado);
		}

		sb.append(" ORDER BY A.ID_ASISTENCIA ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		
		List<ReporteAsistenciaDetallado> lista = super.findNativeQueryEntidadLimit(sb.toString(), param,
				ReporteAsistenciaDetallado.class, minRegistro, maxRegistro);
		
		
		return lista;
	}

//public List<ReporteCapacitacionDetallado> getResumenCapacitacionDetallado(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)throws Validador { //SPRINT_8
	public List<ReporteCapacitacionDetallado> getResumenCapacitacionDetallado(Long idUserInt, Long idEstado,
			boolean flagAsis, Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro,
			Integer minRegistro) throws Validador {// SPRINT_8

		StringBuffer sb = new StringBuffer(400);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(QUERY_CAPACITACION_V2);
		sb.append(" WHERE A.ESTADO>0  ");

		if (fechaInicio != null && fechaFin != null) {
//	sb.append(" AND TRUNC(A.FECHA_INIC) BETWEEN TO_DATE('" + sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");
			sb.append(" AND TRUNC(A.FECHA_INIC) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");// SPRINT_4
			// sb.append(" AND TRUNC(A.FECHA_INI_PROGRAMADA) BETWEEN TO_DATE('" +
			// sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" +
			// sdf.format(fechaFin) + "','DD/MM/YYYY') ");//SPRINT_4
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			// sb.append(" and A.ID_SIST_ADM = ? ");//SPRINT_8
			sb.append(" and b.ID_SIST_ADMI = ? ");// SPRINT_8
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append(" and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" and   b.ID_USUINTERNO=?  ");
			hs.add(idUserInt);
		}
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and A.ESTADO = ? ");
			hs.add(idEstado);
		}
		if (flagAsis) {
			sb.append(" and VUEX.FLAG_ASISTENCIA = 1 ");

		}

//SPRINT_8 FIN 

		sb.append(" ORDER BY A.ID_CAPACITACION , VUEX.id_usuexterno"); // SPRINT56

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<ReporteCapacitacionDetallado> lista = super.findNativeQueryEntidadLimit(sb.toString(), param,
				ReporteCapacitacionDetallado.class, minRegistro, maxRegistro);// SPRINT24
//if (lista!=null && lista.size()>maxRegistro) //SPRINT24
//	throw new Validador(2,1,"EXCESO DE CANTIDAD DE REGISTRO."); //SPRINT24
		return lista;
	}

//
//public List<ReporteConsulta> getResumenConsultas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)throws Validador  {//SPRINT_8
	public List<ReporteConsulta> getResumenConsultas(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador {// SPRINT_8.3

		StringBuffer sb = new StringBuffer(400);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		sb.append(QUERY_CONSULTA_V2);
		sb.append("WHERE  A.ESTADO>0 ");

		if (fechaInicio != null && fechaFin != null) {
			sb.append(" AND TRUNC(A.FECHA_CONSU) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");

		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}
//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" and A.IDUSSER_CREA = ? ");
			hs.add(idUserInt);
		}
//SPRINT_8 FIN
//SPRINT_8.3 INICIO
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and a.estado = ?  ");
			hs.add(idEstado);
		}
//SPRINT_8.3 FIN

		sb.append(" ORDER BY A.ID_CONSULTA ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<ReporteConsulta> lista = super.findNativeQueryEntidadLimit(sb.toString(), param, ReporteConsulta.class,
				minRegistro, maxRegistro);// SPRINT24
//if (lista!=null && lista.size()>maxRegistro) //SPRINT24
//	throw new Validador(2,1,"EXCESO DE CANTIDAD DE REGISTRO."); SPRINT24
		return lista;

	}

//public List<ReporteVisitaDetalle> getResumenVisitas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro,Integer minRegistro)throws Validador   {//SPRINT_8
	public List<ReporteVisitaDetalle> getResumenVisitas(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador {// SPRINT_8.3

		StringBuffer sb = new StringBuffer(500);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(QUERY_VISITAS_V2);
		sb.append(" WHERE A.ESTADO>0 ");

		if (fechaInicio != null && fechaFin != null) {
//	sb.append(" AND TRUNC(A.FECHA_VISITA) BETWEEN TO_DATE('" + sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");
			sb.append(" AND TRUNC(A.FECHA_VISITA) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");// SPRINT_4
			// sb.append(" AND TRUNC(A.FECHA_PROGRAMADA) BETWEEN TO_DATE('" +
			// sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" +
			// sdf.format(fechaFin) + "','DD/MM/YYYY') ");//SPRINT_4

		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append(" AND A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append(" AND A.ID_SEDE = ? ");
			hs.add(idSede);
		}

//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" AND A.IDUSSER_CREA= ? ");
			hs.add(idUserInt);
		}
//SPRINT_8 FIN
//SPRINT_8.3 INICIO
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and a.estado = ?  ");
			hs.add(idEstado);
		}
//SPRINT_8.3 FIN

		sb.append(" ORDER BY A.ID_VISITA ");

		Object param[] = new Object[hs.size()];

		hs.toArray(param);
		List<ReporteVisitaDetalle> lista = super.findNativeQueryEntidadLimit(sb.toString(), param,
				ReporteVisitaDetalle.class, minRegistro, maxRegistro);// SPRINT24

//if (lista!=null && lista.size()>maxRegistro)//SPRINT24
//	throw new Validador(2,1,"EXCESO DE CANTIDAD DE REGISTRO.");	//SPRINT24	

		return lista;
	}

//SPRINT22 FIN

//SPRINT24 INICIO

//public Long getTotalResumenCapacitacionDetallado(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede)throws Validador {//SPRINT_8
	public Long getTotalResumenCapacitacionDetallado(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede,
			Long idUserInt, Long idEstado, boolean flagAsis) throws Validador {// SPRINT_8

		StringBuffer sb = new StringBuffer(400);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(QUERY_CAPACITACION_TOTAL_V2);
		sb.append(" WHERE A.ESTADO>0  ");

		if (fechaInicio != null && fechaFin != null) {
//	sb.append(" AND TRUNC(A.FECHA_INIC) BETWEEN TO_DATE('" + sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");
			sb.append(" AND TRUNC(A.FECHA_INIC) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");// SPRINT_4
			// sb.append(" AND TRUNC(A.FECHA_INI_PROGRAMADA) BETWEEN TO_DATE('" +
			// sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" +
			// sdf.format(fechaFin) + "','DD/MM/YYYY') ");//SPRINT_4
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			// sb.append(" and A.ID_SIST_ADM = ? ");//SPRINT_8
			sb.append(" and B.ID_SIST_ADMI= ? ");// SPRINT_8
			hs.add(idSistAdmin);
		}
		if (idSede != null && idSede.longValue() > 0) {
			sb.append(" and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" and  b.ID_USUINTERNO=?  ");
			hs.add(idUserInt);

		}
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and A.ESTADO = ? ");
			hs.add(idEstado);
		}
		if (flagAsis) {
			sb.append(" and VUEX.FLAG_ASISTENCIA= 1 ");

		}

//SPRINT_8 FIN 

		Object param[] = new Object[hs.size()];
		hs.toArray(param);

		Object o = super.findNaviteUniqueResultObject(sb.toString(), param);
		long retorno = 0;

		if (o instanceof java.lang.Long) {
			retorno = ((Long) o).longValue();
		} else if (o instanceof BigDecimal) {
			retorno = ((BigDecimal) o).longValue();
		}
		return retorno;

	}

//public Long getTotalReporteAsistenciaDetalleBkList(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede)throws Validador  { //SPRINT_8
	public Long getTotalReporteAsistenciaDetalleBkList(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede,
			Long idUserInt, Long idEstado) throws Validador {// SPRINT_8.3

		StringBuffer sb = new StringBuffer(400);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(QUERY_ASISTENCIA_TOTAL_V2);
		sb.append(" where a.estado>0 ");

		if (fechaInicio != null && fechaFin != null) {
//	sb.append(" AND TRUNC(A.FECHA_ASISTENCIA) BETWEEN TO_DATE('" + sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");
			sb.append(" AND TRUNC(A.FECHA_ASISTENCIA) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");// SPRINT_4
			// sb.append(" AND TRUNC(A.FECHA_PROGRAMADA) BETWEEN TO_DATE('" +
			// sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" +
			// sdf.format(fechaFin) + "','DD/MM/YYYY') ");//SPRINT_4
		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}
//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" and ( a.ID_USUINTERNO = ? OR b.ID_USUINTERNO = ? ) ");
			hs.add(idUserInt);
			hs.add(idUserInt);
		}
//SPRINT_8 FI
//SPRINT_8.3 INICIO
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and a.estado = ?  ");
			hs.add(idEstado);
		}
//SPRINT_8.3 FIN

		Object param[] = new Object[hs.size()];
		hs.toArray(param);

		Object o = super.findNaviteUniqueResultObject(sb.toString(), param);
		long retorno = 0;

		if (o instanceof java.lang.Long) {
			retorno = ((Long) o).longValue();
		} else if (o instanceof BigDecimal) {
			retorno = ((BigDecimal) o).longValue();
		}
		return retorno;
	}

//public Long getTotalResumenConsultas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede) throws Validador  {//SPRINT_8
	public Long getTotalResumenConsultas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Long idUserInt,
			Long idEstado) throws Validador {// SPRINT_8.3

		StringBuffer sb = new StringBuffer(400);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		sb.append(QUERY_CONSULTA_TOTAL_V2);
		sb.append("WHERE  A.ESTADO>0 ");

		if (fechaInicio != null && fechaFin != null) {
			sb.append(" AND TRUNC(A.FECHA_CONSU) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");

		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append("and A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append("and A.ID_SEDE = ? ");
			hs.add(idSede);
		}

//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" and A.IDUSSER_CREA = ? ");
			hs.add(idUserInt);
		}
//SPRINT_8 FIN
//SPRINT_8.3 INICIO
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and a.estado = ?  ");
			hs.add(idEstado);
		}
//SPRINT_8.3 FIN

		Object param[] = new Object[hs.size()];
		hs.toArray(param);

		Object o = super.findNaviteUniqueResultObject(sb.toString(), param);
		long retorno = 0;

		if (o instanceof java.lang.Long) {
			retorno = ((Long) o).longValue();
		} else if (o instanceof BigDecimal) {
			retorno = ((BigDecimal) o).longValue();
		}
		return retorno;

	}

//public Long getTotalResumenVisitas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede) throws Validador   {//SPRINT_8
	public Long getTotalResumenVisitas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Long idUserInt,
			Long idEstado) throws Validador {// SPRINT_8.3

		StringBuffer sb = new StringBuffer(500);
		List<Object> hs = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(QUERY_VISITAS_TOTAL_V2);
		sb.append(" WHERE A.ESTADO>0 ");

		if (fechaInicio != null && fechaFin != null) {
//	sb.append(" AND TRUNC(A.FECHA_VISITA) BETWEEN TO_DATE('" + sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");
			sb.append(" AND TRUNC(A.FECHA_VISITA) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
					+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY') ");// SPRINT_4
			// sb.append(" AND TRUNC(A.FECHA_PROGRAMADA) BETWEEN TO_DATE('" +
			// sdf.format(fechaInicio) + "','DD/MM/YYYY') AND TO_DATE('" +
			// sdf.format(fechaFin) + "','DD/MM/YYYY') ");//SPRINT_4

		}

		if (idSistAdmin != null && idSistAdmin.longValue() > 0) {
			sb.append(" AND A.ID_SIST_ADM = ? ");
			hs.add(idSistAdmin);
		}

		if (idSede != null && idSede.longValue() > 0) {
			sb.append(" AND A.ID_SEDE = ? ");
			hs.add(idSede);
		}
//SPRINT_8 INICIO
		if (idUserInt != null && idUserInt.longValue() > 0) {
			sb.append(" AND A.IDUSSER_CREA= ? ");
			hs.add(idUserInt);
		}
//SPRINT_8 FIN
//SPRINT_8.3 INICIO
		if (idEstado != null && idEstado.longValue() > 0) {
			sb.append(" and a.estado = ?  ");
			hs.add(idEstado);
		}
//SPRINT_8.3 FIN

		Object param[] = new Object[hs.size()];

		hs.toArray(param);

		Object o = super.findNaviteUniqueResultObject(sb.toString(), param);
		long retorno = 0;

		if (o instanceof java.lang.Long) {
			retorno = ((Long) o).longValue();
		} else if (o instanceof BigDecimal) {
			retorno = ((BigDecimal) o).longValue();
		}
		return retorno;
	}

//SPRINT24 FIN

//SPRINT_9 INICIO

//SPRINT_9.3 INICIO
//SPRINT_9.3.5 INICIO
	public List<Object> getServicioPorSede(Long idEstado, String idSisAdm, Date fechaInicio, Date fechaFin)
			throws Validador {
		List<Object> lstObject = new ArrayList<Object>();
		StringBuilder query = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//SPRINT_9.6 INICIO
		query.append(
				" select T.SERVICIO, T.ID_SEDE, T.SEDE , SUM(T.TOTALSER) AS TOTALSER, SUM(T.TOTALPARTI) AS TOTALPARTI FROM  (  ");
		query.append(
				"	select 'AT' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,null AS TOTALSER, null as TOTALPARTI ");
		query.append("	FROM MS_SEDES S where estado=3 and s.ID_SEDE !=30 AND S.FLAGVISIBLERPTE=1 "); // SPRINT_9.7
		query.append("	UNION  ");

//SPRINT_9.6 FIN

//ASISTENCIAS TÉCNICAS:
		query.append(
				" SELECT 'AT' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(A.ID_ASISTENCIA) AS TOTALSER, null as TOTALPARTI   ");
		query.append(" FROM DT_ASISTENCIA A  INNER JOIN MS_SEDES S ON (A.ID_SEDE=S.ID_SEDE) ");
		query.append(" WHERE TRUNC(A.FECHA_ASISTENCIA) BETWEEN  TO_DATE('" + sdf.format(fechaInicio)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY')   ");
		if (idSisAdm != null && idSisAdm.length() > 0)
			query.append(" AND A.ID_SIST_ADM IN (" + idSisAdm + ")  ");
		if (idEstado != null && idEstado.intValue() > 0)
			query.append("  AND A.ESTADO=" + idEstado);
		query.append(" AND S.FLAGVISIBLERPTE=1  GROUP BY  S.ID_SEDE, S.SEDE ");// SPRINT_9.7
		query.append(" UNION  ");
//--CONSULTAS
		query.append(
				" SELECT 'C' AS SERVICIO,  S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(C.ID_CONSULTA) AS TOTALSER,null as TOTALPARTI   ");
		query.append(" FROM DT_CONSULTAS C INNER JOIN MS_SEDES S ON (C.ID_SEDE=S.ID_SEDE) ");
		query.append(" WHERE TRUNC(C.FECHA_CONSU) BETWEEN TO_DATE('" + sdf.format(fechaInicio)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY')   ");
		if (idSisAdm != null && idSisAdm.length() > 0)
			query.append(" AND C.ID_SIST_ADM IN (" + idSisAdm + ")  ");
		if (idEstado != null && idEstado.intValue() > 0)
			query.append("  AND C.ESTADO=" + idEstado);
		query.append(" AND S.FLAGVISIBLERPTE=1 GROUP BY  S.ID_SEDE, S.SEDE ");// SPRINT_9.7
		query.append(" UNION ");
//--REUNIONES DE TRABAJO		
		query.append(
				" SELECT 'V' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(V.ID_VISITA)  AS TOTALSER , null as TOTALPARTI   ");
		query.append(" FROM DT_VISITAS V  INNER JOIN MS_SEDES S ON (V.ID_SEDE=S.ID_SEDE)   ");
		query.append(" INNER JOIN (SELECT UNIQUE ID_VISITA  ");
		query.append("             FROM DT_VISITAS_USUINTERNOS VU  ");
		query.append("             LEFT JOIN MS_USUARIOS U ON VU.ID_USUINTERNO=U.IDUSUARIO  ");
		query.append("             WHERE VU.ESTADO=3  ");
		if (idSisAdm != null && idSisAdm.length() > 0)
			query.append("   		AND U.ID_SIST_ADMI IN (" + idSisAdm + ") ");
		query.append(" ) VS ON V.ID_VISITA=VS.ID_VISITA  ");
		query.append(" WHERE  ");
		query.append(" TRUNC(V.FECHA_VISITA)  BETWEEN TO_DATE('" + sdf.format(fechaInicio)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY')   ");
		if (idEstado != null && idEstado.intValue() > 0)
			query.append("  AND  V.ESTADO=" + idEstado);
		query.append(" AND S.FLAGVISIBLERPTE=1  GROUP BY  S.ID_SEDE, S.SEDE   ");// SPRINT_9.7
		query.append(" UNION ");
//--CAPACITACION
		query.append(
				" SELECT 'CAPA' AS SERVICIO, C.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(C.ID_CAPACITACION)  AS TOTALSER,  ");
		query.append(" sum(CP.TOTALPARTI) as TOTALPARTI   ");
		query.append(" FROM DT_CAPACITACION C INNER JOIN MS_SEDES S ON (C.ID_SEDE=S.ID_SEDE)   ");
		query.append(" INNER JOIN (SELECT UNIQUE ID_CAPACITACION FROM DT_CAPA_TEMAS  ");
		query.append("             WHERE ESTADO=3 ");
		if (idSisAdm != null && idSisAdm.length() > 0)
			query.append(" 		AND ID_SIST_ADMI  IN (" + idSisAdm + ")  ");
		query.append(" 			) CT ON  C.ID_CAPACITACION=CT.ID_CAPACITACION ");
		query.append(" LEFT JOIN (SELECT ID_CAPACITACION, COUNT(*)AS TOTALPARTI FROM  DT_CAPA_USUEXTERNOS  ");
		query.append(" 				WHERE ESTADO=3 AND FLAG_ASISTENCIA=1  ");
		query.append(" 				GROUP BY ID_CAPACITACION 	 ");
		query.append("			 ) CP ON (C.ID_CAPACITACION= CP.ID_CAPACITACION )		 ");
		query.append(" WHERE   TRUNC(C.FECHA_INIC )BETWEEN TO_DATE('" + sdf.format(fechaInicio)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaFin) + "','DD/MM/YYYY')   ");
		if (idEstado != null && idEstado.intValue() > 0)
			query.append("  AND  C.ESTADO=" + idEstado);
//SPRINT_9.6 INICIO	
		query.append(" AND S.FLAGVISIBLERPTE=1  GROUP BY  C.ID_SEDE, S.SEDE "); // SPRINT_9.7
		query.append(" ) T GROUP BY T.SERVICIO, T.ID_SEDE, T.SEDE ");
		query.append(" ORDER BY T.SEDE ASC, TOTALSER DESC   ");
//SPRINT_9.6 FIN

//System.out.println("query="+query.toString());
		try {
			lstObject = super.findNative(query.toString());
		} catch (Validador v) {
			v.printStackTrace();

		}
		if (CollectionUtils.isEmpty(lstObject)) {
			return null;
		}

		return lstObject;

	}
//SPRINT_9 FIN

	public List<Object> getServicioPorAvanceMeta(String idSisAdm, Date fechaAvance) throws Validador {
		List<Object> lstObject = new ArrayList<Object>();
		StringBuilder query = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sda = new SimpleDateFormat("yyyy");

//SPRINT02 INICIO ARTIFICIO PARA QUE LISTE TODAS LAS SEDES 
		// --ASISTENCIA META
		query.append(
				" SELECT 'T' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,1 AS TOTALSER, null as TOTALPARTI    ,   ");
		query.append(
				" (select unique valor from ms_meta m where m.estado=3 and m.id_tipo_servicio=132 and  m.id_sede= S.ID_SEDE   and m.annio= "
						+ sda.format(fechaAvance) + " and m.id_sist_admi = " + idSisAdm + ") as totalValor    ");
		query.append(" FROM MS_SEDES S    ");
		query.append(" WHERE S.FLAGVISIBLERPTE=1 AND S.ESTADO=3   ");
		query.append(" GROUP BY  S.ID_SEDE, S.SEDE     ");
		query.append(" UNION   ");
		// --CONSULTA META
		query.append(
				" SELECT 'T' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,2 AS TOTALSER, null as TOTALPARTI    ,   ");
		query.append(
				" (select unique valor from ms_meta m where m.estado=3 and m.id_tipo_servicio=135 and  m.id_sede= S.ID_SEDE   and m.annio= "
						+ sda.format(fechaAvance) + " and m.id_sist_admi = " + idSisAdm + ") as totalValor    ");
		query.append(" FROM MS_SEDES S      ");
		query.append(" WHERE S.FLAGVISIBLERPTE=1 AND S.ESTADO=3   ");
		query.append(" GROUP BY  S.ID_SEDE, S.SEDE     ");
		query.append(" UNION   ");
		// --CAPACITACION META
		query.append(
				" SELECT 'T' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,3 AS TOTALSER, null as TOTALPARTI    ,   ");
		query.append(
				" (select unique valor from ms_meta m where m.estado=3 and m.id_tipo_servicio=133 and  m.id_sede= S.ID_SEDE   and m.annio= "
						+ sda.format(fechaAvance) + " and m.id_sist_admi = " + idSisAdm + ") as totalValor    ");
		query.append(" FROM MS_SEDES S      ");
		query.append(" WHERE S.FLAGVISIBLERPTE=1 AND S.ESTADO=3   ");
		query.append(" GROUP BY  S.ID_SEDE, S.SEDE     ");
		query.append(" UNION   ");
//SPRINT02 FIN

//ASISTENCIAS TÉCNICAS:
		query.append(
				" SELECT 'AT' AS SERVICIO, S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(A.ID_ASISTENCIA) AS TOTALSER, null as TOTALPARTI   ");
		query.append(
				" ,(select unique valor from ms_meta m where m.estado=3 and m.id_tipo_servicio=132 and  m.id_sede= S.ID_SEDE  ");
		query.append(
				" and m.annio= " + sda.format(fechaAvance) + " and m.id_sist_admi = " + idSisAdm + " ) as totalValor");
		query.append(" FROM DT_ASISTENCIA A  INNER JOIN MS_SEDES S ON (A.ID_SEDE=S.ID_SEDE) ");
		query.append(" WHERE TRUNC(A.FECHA_ASISTENCIA) BETWEEN  TO_DATE('" + "01/01/" + sda.format(fechaAvance)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaAvance) + "','DD/MM/YYYY')   ");
		query.append(" AND S.FLAGVISIBLERPTE=1  AND A.ESTADO= " + estadoFinalizado); // SPRINT_9.7
		if (idSisAdm != null && idSisAdm.length() > 0)
			query.append(" AND A.ID_SIST_ADM = " + idSisAdm + " ");
		query.append(" GROUP BY  S.ID_SEDE, S.SEDE ");
		query.append(" UNION  ");
//--CONSULTAS
		query.append(
				" SELECT 'C' AS SERVICIO,  S.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(C.ID_CONSULTA) AS TOTALSER,null as TOTALPARTI   ");
		query.append(
				" ,(select unique valor from ms_meta m where m.estado=3 and m.id_tipo_servicio=135 and  m.id_sede= S.ID_SEDE  ");
		query.append(
				" and m.annio= " + sda.format(fechaAvance) + " and m.id_sist_admi = " + idSisAdm + " ) as totalValor ");
		query.append(" FROM DT_CONSULTAS C INNER JOIN MS_SEDES S ON (C.ID_SEDE=S.ID_SEDE) ");
		query.append(" WHERE TRUNC(C.FECHA_CONSU) BETWEEN TO_DATE('" + "01/01/" + sda.format(fechaAvance)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaAvance) + "','DD/MM/YYYY')   ");
		query.append("  AND S.FLAGVISIBLERPTE=1  AND C.ESTADO=" + estadoFinalizado); // SPRINT_9.7
		if (idSisAdm != null && idSisAdm.length() > 0)
			query.append(" AND C.ID_SIST_ADM = " + idSisAdm + "  ");
		query.append(" GROUP BY  S.ID_SEDE, S.SEDE ");

		query.append(" UNION ");
//--CAPACITACION
		query.append(
				"  SELECT 'CAPA' AS SERVICIO, C.ID_SEDE AS ID_SEDE, S.SEDE AS SEDE,COUNT(C.ID_CAPACITACION)  AS TOTALSER,   ");
		query.append(" sum(CP.TOTALPARTI) as TOTALPARTI ");
		query.append(" ,(select unique valor from ms_meta m where m.estado=3 and m.id_tipo_servicio=133 and  ");
		query.append(" m.id_sede= C.ID_SEDE   and m.annio=  " + sda.format(fechaAvance) + " and m.id_sist_admi =  "
				+ idSisAdm + " ) as totalValor 		 ");
		query.append(" FROM DT_CAPACITACION C INNER JOIN MS_SEDES S ON (C.ID_SEDE=S.ID_SEDE)   ");
		query.append(" INNER JOIN (SELECT UNIQUE ID_CAPACITACION FROM DT_CAPA_TEMAS  ");
		query.append(" 			WHERE ESTADO=3 AND ID_SIST_ADMI =  " + idSisAdm + "  ");
		query.append(" 			) CT ON  C.ID_CAPACITACION=CT.ID_CAPACITACION ");
		query.append(" LEFT JOIN (SELECT ID_CAPACITACION, COUNT(*)AS TOTALPARTI FROM  DT_CAPA_USUEXTERNOS  ");
		query.append("  		WHERE ESTADO=3 AND FLAG_ASISTENCIA=1  ");
		query.append(" 			GROUP BY ID_CAPACITACION             ");
		query.append(" 			) CP ON (C.ID_CAPACITACION= CP.ID_CAPACITACION )  ");
		query.append(" WHERE   TRUNC(C.FECHA_INIC ) BETWEEN TO_DATE('" + "01/01/" + sda.format(fechaAvance)
				+ "','DD/MM/YYYY') AND TO_DATE('" + sdf.format(fechaAvance) + "','DD/MM/YYYY')   ");
		query.append(" AND S.FLAGVISIBLERPTE=1 AND  C.ESTADO=" + estadoFinalizado); // SPRINT_9.7
		query.append(" GROUP BY  C.ID_SEDE, S.SEDE  ORDER BY SEDE ASC, TOTALSER DESC  ");

//System.out.println("query======="+query.toString());
		try {
			lstObject = super.findNative(query.toString());
		} catch (Validador v) {
			v.printStackTrace();

		}
		if (CollectionUtils.isEmpty(lstObject)) {
			return null;
		}

		return lstObject;

	}
//SPRINT_9.3.5 FIN
}
