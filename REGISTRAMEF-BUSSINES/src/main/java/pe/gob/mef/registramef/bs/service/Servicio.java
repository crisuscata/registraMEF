package pe.gob.mef.registramef.bs.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.mef.registramef.bs.cache.clases.CacheMsUsuariosBk;
import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaTemas;
import pe.gob.mef.registramef.bs.domain.MsUbigeoId;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.transfer.DtEntidadSedesDto;
import pe.gob.mef.registramef.bs.transfer.DtEntidadesDto;
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.bs.transfer.IIDValorDto;
import pe.gob.mef.registramef.bs.transfer.MsProyectoInversionDto;
import pe.gob.mef.registramef.bs.transfer.MsUsuariosDto;
import pe.gob.mef.registramef.bs.transfer.bk.DtAmpliacionFechaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAnexoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaProyectoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaEntidadesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaProyectoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaPublicoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCargosUsuexterBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasProyectoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaRespuestaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSedesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSisAdminBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuariosSedesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasProyectoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuinternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaCargoUserBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsIndicadorBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsLocalBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsMetaBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsPaisesBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsProyectoInversionBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsRolesBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsSedesBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsSisAdmistrativoBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsSubtemaBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsTemaBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsUbigeoBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.transfer.bk.PrtParametrosBk;
import pe.gob.mef.registramef.bs.transfer.bk.TaFeriadosBk;

/**
 * SERVICIO: SERVICIO Y LOGÍCA DEL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 28/05/2023 22:19
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi / 28/05/2023 22:19 / Creación de la
 *          clase /
 * 
 * 
 */
public interface Servicio {

	/**
	 * DT_CAPA_ENTIDADES SERVICIO: ALMACENA A LAS ENTIDADES PROGRAMADAS EN LA
	 * CAPACITACION "ENTIDADES EN LA CAPACITACIÓN"
	 */
	DtCapaEntidadesBk getDtCapaEntidadesBkXid(Long id, Long kyUsuarioMod);

	List<DtCapaEntidadesBk> getAllDtCapaEntidadesActivos(Long kyUsuarioMod);

	List<DtCapaEntidadesBk> getAllDtCapaEntidadesActivosCero(Long kyUsuarioMod);

	DtCapaEntidadesBk saveorupdateDtCapaEntidadesBk(DtCapaEntidadesBk dtCapaEntidadesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	/// ADICIONALES

	public List<DtEntidadesDto> getDtEntidadesCache();

	/**
	 * DT_CAPA_PUBLICO SERVICIO: ALMACENA EL TIPO DE PUBLICO OBJETIVO POR
	 * CAPACITACION "PUBLICO OBJETIVO"
	 */
	DtCapaPublicoBk getDtCapaPublicoBkXid(Long id, Long kyUsuarioMod);

	List<DtCapaPublicoBk> getAllDtCapaPublicoActivos(Long kyUsuarioMod);

	List<DtCapaPublicoBk> getAllDtCapaPublicoActivosCero(Long kyUsuarioMod);

	DtCapaPublicoBk saveorupdateDtCapaPublicoBk(DtCapaPublicoBk dtCapaPublicoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtCapaPublicoBk> getDtCapaPublicoXFiltro(Long idCapacitacion, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtCapaPublicoTotalXFiltro(Long idCapacitacion, Long kyUsuarioMod);

	List<DtCapaPublicoBk> getDtCapaPublicoXFiltro(Long idCapacitacion, Long kyUsuarioMod);
	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdCargo();

	/**
	 * MS_PAISES SERVICIO: ALMACENA A LOS PAISES REGISTRADOS EN EL SISTEMA
	 * "PAÍSES"
	 */
	MsPaisesBk getMsPaisesBkXid(Long id, Long kyUsuarioMod);

	List<MsPaisesBk> getAllMsPaisesActivos(Long kyUsuarioMod);

	List<MsPaisesBk> getAllMsPaisesActivosCero(Long kyUsuarioMod);

	MsPaisesBk saveorupdateMsPaisesBk(MsPaisesBk msPaisesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsPaises(MsPaisesBk msPaisesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	/// ADICIONALES

	/**
	 * DT_CONSULTAS_PROYECTO SERVICIO: ALMACENA LOS DISTINTOS PROYECTOS DE
	 * INVERSIÓN RELACIONADOS A LAS CONSULTAS
	 */
	DtConsultasProyectoBk getDtConsultasProyectoBkXid(Long id, Long kyUsuarioMod);

	List<DtConsultasProyectoBk> getAllDtConsultasProyectoActivos(Long kyUsuarioMod);

	List<DtConsultasProyectoBk> getAllDtConsultasProyectoActivosCero(Long kyUsuarioMod);

	DtConsultasProyectoBk saveorupdateDtConsultasProyectoBk(DtConsultasProyectoBk dtConsultasProyectoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	/// ADICIONALES

	// public List<MsProyectoInversionDto> getMsProyectoInversionCache();

	/**
	 * DT_VISITAS_USUINTERNOS SERVICIO: ALMACENA A LOS PARTICIPANTES DE LA
	 * VISITA "PARTICIPANTES DE LA VISITA"
	 */
	DtVisitasUsuinternosBk getDtVisitasUsuinternosBkXid(Long id, Long kyUsuarioMod);

	List<DtVisitasUsuinternosBk> getAllDtVisitasUsuinternosActivos(Long kyUsuarioMod);

	List<DtVisitasUsuinternosBk> getAllDtVisitasUsuinternosActivosCero(Long kyUsuarioMod);

	DtVisitasUsuinternosBk saveorupdateDtVisitasUsuinternosBk(DtVisitasUsuinternosBk dtVisitasUsuinternosBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

		/// ADICIONALES

	// public List<MsUsuariosDto> getMsUsuariosCache();

	List<IDValorDto> getMsTemaIdTemaIdTema();

	/**
	 * DT_ASISTENCIA SERVICIO: ALMACENA LOS DATOS REGISTRADOS EN UNA ASISTENCIA
	 * TECNICA "ASISTENCIA TÉCNICA"
	 */
	DtAsistenciaBk getDtAsistenciaBkXid(Long id, Long kyUsuarioMod);

	List<DtAsistenciaBk> getAllDtAsistenciaActivos(Long kyUsuarioMod);

	List<DtAsistenciaBk> getAllDtAsistenciaActivosCero(Long kyUsuarioMod);

	DtAsistenciaBk saveorupdateDtAsistenciaBk(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress, List<DtAnexoBk> tdAnexosBkss) throws Validador;
	
	//INICIO CUSCATA - 18062024
		DtAsistenciaBk enviarConstanciaAtencion(DtAsistenciaBk dtAsistenciaBk, String url, String user, Long kyUsuarioMod,
				Long kyAreaMod, String rmtaddress) throws Validador;
		
		DtAsistenciaBk finalizarDtAsistenciaBk(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod,
				Long kyAreaMod, String rmtaddress) throws Validador;

		void enviarEncuestaPorCorreo(final String descpServicio, final Collection<?> participantes, final Long tipoServicio,
				final Long idServicio, final Date fechaServicio, final String url, final Timestamp fechaFinalizacion)
				throws Validador; 		
	//FIN CUSCATA - 18062024

	void deleteDtAsistencia(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;


	List<IDValorDto> getDtEntidadesIdEntidadIdEntidad();

	List<IDValorDto> getPrtParametrosIdparametroIdOrigen();

	List<IDValorDto> getPrtParametrosIdparametroIdModalidad();

	List<IDValorDto> getPrtParametrosIdparametroIdFinancia();

	/**
	 * DT_CAPACITACION SERVICIO: ALMACENA LOS DATOS REGISTRADOS EN UNA
	 * CAPACITACION "CAPACITACIONES"
	 */
	DtCapacitacionBk getDtCapacitacionBkXid(Long id, Long kyUsuarioMod);

	List<DtCapacitacionBk> getAllDtCapacitacionActivos(Long kyUsuarioMod);

	List<DtCapacitacionBk> getAllDtCapacitacionActivosCero(Long kyUsuarioMod);

	DtCapacitacionBk saveorupdateDtCapacitacionBk(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;
	//INICIO CUSCATA - 18072024
	DtCapacitacionBk saveorupdateDtCapacitacionNoProg(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress, List<DtAnexoBk> tdAnexosBkss) throws Validador;
//FIN CUSCATA - 18072024
	
	DtCapacitacionBk confirmardtCapacitacionNoProg(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;
	
	DtCapacitacionBk confirmarAsistenciaCapaNoProg(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;
	
	DtCapacitacionBk confirmarNOAsistenciaCapaNoProg(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;
	
	
	void deleteDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	
	/// ADICIONALES

	List<IDValorDto> getMsLocalIdLocalIdLocal();

	List<IDValorDto> getPrtParametrosIdparametroIdModo();

	List<IDValorDto> getPrtParametrosIdparametroIdNivel();

	// List<IDValorDto> getPrtParametrosIdparametroIdOrigen();

	List<IDValorDto> getPrtParametrosIdparametroIdPrestacion();

	List<IDValorDto> getPrtParametrosIdparametroIdTipo();

	// List<IDValorDto> getPrtParametrosIdparametroIdFinancia();

	// List<IDValorDto> getPrtParametrosIdparametroIdModalidad();

//	List<IDValorDto> getPrtParametrosIdparametroMotivoEjec();

	/**
	 * MS_ALERTA_CARGO_USER SERVICIO:
	 */
	MsAlertaCargoUserBk getMsAlertaCargoUserBkXid(Long id, Long kyUsuarioMod);

	List<MsAlertaCargoUserBk> getAllMsAlertaCargoUserActivos(Long kyUsuarioMod);

	List<MsAlertaCargoUserBk> getAllMsAlertaCargoUserActivosCero(Long kyUsuarioMod);

	MsAlertaCargoUserBk saveorupdateMsAlertaCargoUserBk(MsAlertaCargoUserBk msAlertaCargoUserBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<MsAlertaCargoUserBk> getMsAlertaCargoUserXFiltro(Long idalerta, Long idcargo, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getMsAlertaCargoUserTotalXFiltro(Long idalerta, Long idcargo, Long kyUsuarioMod);

	List<MsAlertaCargoUserBk> getMsAlertaCargoUserXFiltro(Long idalerta, Long idcargo, Long kyUsuarioMod);
	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdcargo();

	/**
	 * TA_FERIADOS SERVICIO: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS
	 * FERIADOS DEL AÑO
	 */
	TaFeriadosBk getTaFeriadosBkXid(Date id, Long kyUsuarioMod);//PURIBE 16012024 - FIN-->

	List<TaFeriadosBk> getAllTaFeriadosActivos(Long kyUsuarioMod);

	List<TaFeriadosBk> getAllTaFeriadosActivosCero(Long kyUsuarioMod);

	TaFeriadosBk saveorupdateTaFeriadosBk(TaFeriadosBk taFeriadosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteTaFeriados(TaFeriadosBk taFeriadosBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	/// ADICIONALES

	/**
	 * DT_ENTIDADES SERVICIO: ALMACENA LAS ENTIDAD REGISTRADAS EN EL SISTEMA
	 * "ENTIDADES"
	 */
	DtEntidadesBk getDtEntidadesBkXid(Long id, Long kyUsuarioMod);

	List<DtEntidadesBk> getAllDtEntidadesActivos(Long kyUsuarioMod);

	List<DtEntidadesBk> getAllDtEntidadesActivosCero(Long kyUsuarioMod);

	DtEntidadesBk saveorupdateDtEntidadesBk(DtEntidadesBk dtEntidadesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtEntidades(DtEntidadesBk dtEntidadesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdTipo();

	List<IDValorDto> getPrtParametrosIdparametroIdCaract();

	List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

//	List<IDValorDto> getPrtParametrosIdparametroGeozona();

	/**
	 * DT_ENTIDAD_SIS_ADMIN SERVICIO:
	 */
	DtEntidadSisAdminBk getDtEntidadSisAdminBkXid(Long id, Long kyUsuarioMod);

	List<DtEntidadSisAdminBk> getAllDtEntidadSisAdminActivos(Long kyUsuarioMod);

	List<DtEntidadSisAdminBk> getAllDtEntidadSisAdminActivosCero(Long kyUsuarioMod);

	DtEntidadSisAdminBk saveorupdateDtEntidadSisAdminBk(DtEntidadSisAdminBk dtEntidadSisAdminBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtEntidadSisAdminBk> getDtEntidadSisAdminXFiltro(Long idEntidad, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtEntidadSisAdminTotalXFiltro(Long idEntidad, Long kyUsuarioMod);

	List<DtEntidadSisAdminBk> getDtEntidadSisAdminXFiltro(Long idEntidad, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

	/**
	 * DT_VISITAS SERVICIO: ALMACENA LOS DATOS REGISTRADOS EN UNA VISITA
	 * "VISITAS"
	 */
	DtVisitasBk getDtVisitasBkXid(Long id, Long kyUsuarioMod);

	List<DtVisitasBk> getAllDtVisitasActivos(Long kyUsuarioMod);

	List<DtVisitasBk> getAllDtVisitasActivosCero(Long kyUsuarioMod);
	List<DtVisitasBk> getAllDtVisitasActivosCero(Long kyUsuarioMod,Timestamp fechaInicio,Timestamp fechaFin,int programada,long sede,int rol,long sistemaadmi);//PURIBE 04042024 - INICIO-->	//PURIBE 14032024 - INICIO-->

	DtVisitasBk saveorupdateDtVisitasBk(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

//	void deleteDtVisitas(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
//			throws Validador;

	//PURIBE 01022024 - INICIO-->
		void deleteDtVisitas(List<DtVisitasBk> dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
				throws Validador;
	//PURIBE 01022024 - FIN-->
		//PURIBE 14032024 - INICIO-->
	void reactivarDtVisitas(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;
	//PURIBE 14032024 - FIN-->
		
	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdOrigen();

	// List<IDValorDto> getPrtParametrosIdparametroIdModalidad();

	// List<IDValorDto> getPrtParametrosIdparametroIdTipo();

	List<IDValorDto> getPrtParametrosIdparametroIdLugar();

	List<IDValorDto> getMsSedesIdSedeIdSede();

	// List<IDValorDto> getPrtParametrosIdparametroIdFinancia();

	/**
	 * MS_USUARIOS SERVICIO: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL
	 * SISTEMA "USUARIOS INTERNOS"
	 */
	MsUsuariosBk getMsUsuariosBkXid(Long id, Long kyUsuarioMod);

	List<MsUsuariosBk> getAllMsUsuariosActivos(Long kyUsuarioMod);

	List<MsUsuariosBk> getAllMsUsuariosActivosCero(Long kyUsuarioMod);

//	MsUsuariosBk saveorupdateMsUsuariosBk(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
//			String rmtaddress) throws Validador;

	void deleteMsUsuarios(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<MsUsuariosBk> getMsUsuariosXFiltro(Long dni, String nombres, String apellidoPaterno, String apellidoMaterno,
			Timestamp fechaInic, Timestamp fechaCese, String direccion, String username, Integer codDpto,
			Integer codProv, Integer codDistr, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsUsuariosTotalXFiltro(Long dni, String nombres, String apellidoPaterno, String apellidoMaterno,
			Timestamp fechaInic, Timestamp fechaCese, String direccion, String username, Integer codDpto,
			Integer codProv, Integer codDistr, Long kyUsuarioMod);

	List<MsUsuariosBk> getMsUsuariosXFiltro(Long dni, String nombres, String apellidoPaterno, String apellidoMaterno,
			Timestamp fechaInic, Timestamp fechaCese, String direccion, String username, Integer codDpto,
			Integer codProv, Integer codDistr, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdCargo();

	// List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	List<IDValorDto> getPrtParametrosIdparametroIdCondlabr();

	/**
	 * DT_ENTIDADES_USUEXTERNOS SERVICIO: ALMACENA LAS ENTIDADES A LA QUE
	 * PERTENECE EL USUARIO EXTERNO "ENTIDAD DEL USUARIO EXTERNO"
	 */
	DtEntidadesUsuexternosBk getDtEntidadesUsuexternosBkXid(Long id, Long kyUsuarioMod);

	List<DtEntidadesUsuexternosBk> getAllDtEntidadesUsuexternosActivos(Long kyUsuarioMod);

	List<DtEntidadesUsuexternosBk> getAllDtEntidadesUsuexternosActivosCero(Long kyUsuarioMod);

	// JPUYEN 14052024 - INICIO
	
		DtVisitasUsuexternosBk saveorupdateDtEntidadesUsuexternosBk(DtVisitasUsuexternosBk dtVisitasUsuexternosBk,			
				String user,
				Long kyUsuarioMod, 
				Long kyAreaMod, 
				String rmtaddress		
				) throws Validador;

		// JPUYEN 14052024 - FIN

	void deleteDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	/// ADICIONALES

	/**
	 * PRT_PARAMETROS SERVICIO: ALMACENA LOS PARAMETROS REGISTRADOS EN EL
	 * SISTEMA "PARÁMETROS"
	 */
	PrtParametrosBk getPrtParametrosBkXid(Long id, Long kyUsuarioMod);

	List<PrtParametrosBk> getAllPrtParametrosActivos(Long kyUsuarioMod);

	List<PrtParametrosBk> getAllPrtParametrosActivosCero(Long kyUsuarioMod);

	PrtParametrosBk saveorupdatePrtParametrosBk(PrtParametrosBk prtParametrosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deletePrtParametros(PrtParametrosBk prtParametrosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdpadre();

	/**
	 * DT_ASISTENCIA_TEMAS SERVICIO: ALMACENA LOS DISTINTOS TEMAS AGENDADOS EN
	 * LA ASISTENCIA TECNICA "TEMAS DE LA ASISTENCIA"
	 */
	DtAsistenciaTemasBk getDtAsistenciaTemasBkXid(Long id, Long kyUsuarioMod);

	List<DtAsistenciaTemasBk> getAllDtAsistenciaTemasActivos(Long kyUsuarioMod);

	List<DtAsistenciaTemasBk> getAllDtAsistenciaTemasActivosCero(Long kyUsuarioMod);

	DtAsistenciaTemasBk saveorupdateDtAsistenciaTemasBk(DtAsistenciaTemasBk dtAsistenciaTemasBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtAsistenciaTemasBk> getDtAsistenciaTemasXFiltro(String detalle, Long idAsistencia, Long idTema,
			Long idSubtema, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtAsistenciaTemasTotalXFiltro(String detalle, Long idAsistencia, Long idTema, Long idSubtema,
			Long kyUsuarioMod);

	List<DtAsistenciaTemasBk> getDtAsistenciaTemasXFiltro(String detalle, Long idAsistencia, Long idTema,
			Long idSubtema, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getMsTemaIdTemaIdTema();

	List<IDValorDto> getMsSubtemaIdSubtemaIdSubtema();

	/**
	 * DT_USUARIO_EXTERNO SERVICIO: ALMACENA A LOS USUARIOS EXTERNOS REGISTRADOS
	 * EN EL SISTEMA "USUARIOS EXTERNOS"
	 */
	DtUsuarioExternoBk getDtUsuarioExternoBkXid(Long id, Long kyUsuarioMod);

	List<DtUsuarioExternoBk> getAllDtUsuarioExternoActivos(Long kyUsuarioMod);

	List<DtUsuarioExternoBk> getAllDtUsuarioExternoActivosCero(Long kyUsuarioMod);

	DtUsuarioExternoBk saveorupdateDtUsuarioExternoBk(DtUsuarioExternoBk dtUsuarioExternoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;
/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdTipodocumento();

	/**
	 * MS_UBIGEO SERVICIO: ALMACENA EL UBIGEO(DEPARTAMENTO
	 */
	MsUbigeoBk getMsUbigeoBkXid(MsUbigeoId id, Long kyUsuarioMod);

	List<MsUbigeoBk> getAllMsUbigeoActivos(Long kyUsuarioMod);

	List<MsUbigeoBk> getAllMsUbigeoActivosCero(Long kyUsuarioMod);

	MsUbigeoBk saveorupdateMsUbigeoBk(MsUbigeoBk msUbigeoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsUbigeo(MsUbigeoBk msUbigeoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	/// ADICIONALES

	/**
	 * MS_SIS_ADMISTRATIVO SERVICIO: ALMACENA LOS SISTEMAS ADMINISTRATIVOS
	 * REGISTRADOS EN EL SISTEMA "SISTEMA ADMINISTRATIVO"
	 */
	MsSisAdmistrativoBk getMsSisAdmistrativoBkXid(Long id, Long kyUsuarioMod);

	List<MsSisAdmistrativoBk> getAllMsSisAdmistrativoActivos(Long kyUsuarioMod);

	List<MsSisAdmistrativoBk> getAllMsSisAdmistrativoActivosCero(Long kyUsuarioMod);

	MsSisAdmistrativoBk saveorupdateMsSisAdmistrativoBk(MsSisAdmistrativoBk msSisAdmistrativoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	/// ADICIONALES

	/**
	 * MS_SUBTEMA SERVICIO: ALMACENA LOS SUBTEMAS REGISTRADOS EN EL SISTEMA
	 * "SUBTEMAS"
	 */
	MsSubtemaBk getMsSubtemaBkXid(Long id, Long kyUsuarioMod);

	List<MsSubtemaBk> getAllMsSubtemaActivos(Long kyUsuarioMod);

	List<MsSubtemaBk> getAllMsSubtemaActivosCero(Long kyUsuarioMod);

	MsSubtemaBk saveorupdateMsSubtemaBk(MsSubtemaBk msSubtemaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsSubtema(MsSubtemaBk msSubtemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

//	List<MsSubtemaBk> getMsSubtemaXFiltro(String descripcion, Long idTema, Long idIndicador, int inicial, int MAX,
//			Long kyUsuarioMod);
//
//	Long getMsSubtemaTotalXFiltro(String descripcion, Long idTema, Long idIndicador, Long kyUsuarioMod);
//
//	List<MsSubtemaBk> getMsSubtemaXFiltro(String descripcion, Long idTema, Long idIndicador, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getMsTemaIdTemaIdTema();

	List<IDValorDto> getMsIndicadorIdIndicadorIdIndicador();

	/**
	 * DT_ASISTENCIA_USUEXTERNOS SERVICIO: ALMACENA LOS USUARIOS QUE BRINDAN LA
	 * ATENCION EN LA ASISTENCIA TECNICA "USUARIOS QUE BRINDAN LA ATENCIÓN"
	 */
	DtAsistenciaUsuexternosBk getDtAsistenciaUsuexternosBkXid(Long id, Long kyUsuarioMod);

	List<DtAsistenciaUsuexternosBk> getAllDtAsistenciaUsuexternosActivos(Long kyUsuarioMod);

	List<DtAsistenciaUsuexternosBk> getAllDtAsistenciaUsuexternosActivosCero(Long kyUsuarioMod);

	DtAsistenciaUsuexternosBk saveorupdateDtAsistenciaUsuexternosBk(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtAsistenciaUsuexternosBk> getDtAsistenciaUsuexternosXFiltro(Long idAsistencia, Long idUsuexterno,
			Long idCargoUsuext, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtAsistenciaUsuexternosTotalXFiltro(Long idAsistencia, Long idUsuexterno, Long idCargoUsuext,
			Long kyUsuarioMod);

	List<DtAsistenciaUsuexternosBk> getDtAsistenciaUsuexternosXFiltro(Long idAsistencia, Long idUsuexterno,
			Long idCargoUsuext, Long kyUsuarioMod);
	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdCargoUsuext();

	/**
	 * DT_CAPA_PROYECTO SERVICIO: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN
	 * RELACIONADOS A LAS CAPACITACIONES
	 */
	DtCapaProyectoBk getDtCapaProyectoBkXid(Long id, Long kyUsuarioMod);

	List<DtCapaProyectoBk> getAllDtCapaProyectoActivos(Long kyUsuarioMod);

	List<DtCapaProyectoBk> getAllDtCapaProyectoActivosCero(Long kyUsuarioMod);

	DtCapaProyectoBk saveorupdateDtCapaProyectoBk(DtCapaProyectoBk dtCapaProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtCapaProyectoBk> getDtCapaProyectoXFiltro(Long idProyecto, String detalle, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtCapaProyectoTotalXFiltro(Long idProyecto, String detalle, Long kyUsuarioMod);

	List<DtCapaProyectoBk> getDtCapaProyectoXFiltro(Long idProyecto, String detalle, Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * MS_ROLES SERVICIO: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
	 */
	MsRolesBk getMsRolesBkXid(Long id, Long kyUsuarioMod);

	List<MsRolesBk> getAllMsRolesActivos(Long kyUsuarioMod);

	List<MsRolesBk> getAllMsRolesActivosCero(Long kyUsuarioMod);

	MsRolesBk saveorupdateMsRolesBk(MsRolesBk msRolesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsRoles(MsRolesBk msRolesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<MsRolesBk> getMsRolesXFiltro(String username, String rol, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsRolesTotalXFiltro(String username, String rol, Long kyUsuarioMod);

	List<MsRolesBk> getMsRolesXFiltro(String username, String rol, Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * MS_PROYECTO_INVERSION SERVICIO: ALMACENA LOS DATOS DE PROYECTOS DE
	 * INVERSIÓN
	 */
	MsProyectoInversionBk getMsProyectoInversionBkXid(Long id, Long kyUsuarioMod);

	List<MsProyectoInversionBk> getAllMsProyectoInversionActivos(Long kyUsuarioMod);

	List<MsProyectoInversionBk> getAllMsProyectoInversionActivosCero(Long kyUsuarioMod);

	MsProyectoInversionBk saveorupdateMsProyectoInversionBk(MsProyectoInversionBk msProyectoInversionBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<MsProyectoInversionBk> getMsProyectoInversionXFiltro(String codigo, String nombre, Long idSede, int inicial,
			int MAX, Long kyUsuarioMod);

	Long getMsProyectoInversionTotalXFiltro(String codigo, String nombre, Long idSede, Long kyUsuarioMod);

	List<MsProyectoInversionBk> getMsProyectoInversionXFiltro(String codigo, String nombre, Long idSede,
			Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	/**
	 * DT_AMPLIACION_FECHA SERVICIO: ALMACENA LAS AMPLIACIONES DE LOS DÍAS DE
	 * PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
	 */
	DtAmpliacionFechaBk getDtAmpliacionFechaBkXid(Long id, Long kyUsuarioMod);

	List<DtAmpliacionFechaBk> getAllDtAmpliacionFechaActivos(Long kyUsuarioMod);

	List<DtAmpliacionFechaBk> getAllDtAmpliacionFechaActivosCero(Long kyUsuarioMod);

	DtAmpliacionFechaBk saveorupdateDtAmpliacionFechaBk(DtAmpliacionFechaBk dtAmpliacionFechaBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	//PURIBE 01022024 - INICIO-->
	DtAmpliacionFechaBk getDtAmpliacionFechaXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
				Long kyUsuarioMod,int mesServicio);
	//PURIBE 01022024 - FIN-->
		
	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroTipoFechaCorte();

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	// List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

	/**
	 * DT_ENCUESTA_RESPUESTA SERVICIO:
	 */
	DtEncuestaRespuestaBk getDtEncuestaRespuestaBkXid(Long id, Long kyUsuarioMod);

	List<DtEncuestaRespuestaBk> getAllDtEncuestaRespuestaActivos(Long kyUsuarioMod);

	List<DtEncuestaRespuestaBk> getAllDtEncuestaRespuestaActivosCero(Long kyUsuarioMod);

	DtEncuestaRespuestaBk saveorupdateDtEncuestaRespuestaBk(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtEncuestaRespuestaBk> getDtEncuestaRespuestaXFiltro(Integer idEncuesta, String pregunta, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtEncuestaRespuestaTotalXFiltro(Integer idEncuesta, String pregunta, Long kyUsuarioMod);

	List<DtEncuestaRespuestaBk> getDtEncuestaRespuestaXFiltro(Integer idEncuesta, String pregunta, Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * DT_ASISTENCIA_PROYECTO SERVICIO: ALMACENA LOS DISTINTOS PROYECTOS DE
	 * INVERSIÓN RELACIONADOS A LA ASISTENCIA TÉCNICA
	 */
	DtAsistenciaProyectoBk getDtAsistenciaProyectoBkXid(Long id, Long kyUsuarioMod);

	List<DtAsistenciaProyectoBk> getAllDtAsistenciaProyectoActivos(Long kyUsuarioMod);

	List<DtAsistenciaProyectoBk> getAllDtAsistenciaProyectoActivosCero(Long kyUsuarioMod);

	DtAsistenciaProyectoBk saveorupdateDtAsistenciaProyectoBk(DtAsistenciaProyectoBk dtAsistenciaProyectoBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtAsistenciaProyectoBk> getDtAsistenciaProyectoXFiltro(Long idAsistencia, Long idProyecto, String detalle,
			int inicial, int MAX, Long kyUsuarioMod);

	Long getDtAsistenciaProyectoTotalXFiltro(Long idAsistencia, Long idProyecto, String detalle, Long kyUsuarioMod);

	List<DtAsistenciaProyectoBk> getDtAsistenciaProyectoXFiltro(Long idAsistencia, Long idProyecto, String detalle,
			Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * MS_SEDES SERVICIO: ALMACENA LAS SEDES REGISTRADAS EN EL SISTEMA "SEDES"
	 */
	MsSedesBk getMsSedesBkXid(Long id, Long kyUsuarioMod);

	List<MsSedesBk> getAllMsSedesActivos(Long kyUsuarioMod);

	List<MsSedesBk> getAllMsSedesActivosCero(Long kyUsuarioMod);

	MsSedesBk saveorupdateMsSedesBk(MsSedesBk msSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsSedes(MsSedesBk msSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

		/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdGrupo();

	List<IDValorDto> getPrtParametrosIdparametroIdMacregion();

	/**
	 * DT_VISITAS_TEMAS SERVICIO: ALAMACENA LOS TEMAS DE LA VISITA "TEMAS DE LA
	 * VISITA"
	 */
	DtVisitasTemasBk getDtVisitasTemasBkXid(Long id, Long kyUsuarioMod);

	List<DtVisitasTemasBk> getAllDtVisitasTemasActivos(Long kyUsuarioMod);

	List<DtVisitasTemasBk> getAllDtVisitasTemasActivosCero(Long kyUsuarioMod);

	DtVisitasTemasBk saveorupdateDtVisitasTemasBk(DtVisitasTemasBk dtVisitasTemasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtVisitasTemasBk> getDtVisitasTemasXFiltro(Long idVisita, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtVisitasTemasTotalXFiltro(Long idVisita, Long kyUsuarioMod);

	List<DtVisitasTemasBk> getDtVisitasTemasXFiltro(Long idVisita, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getMsTemaIdTemaIdTema();

	/**
	 * DT_ANEXO SERVICIO: ALMACENA LOS DOCUMENTOS ANEXADOS EN EL SISTEMA "ANEXO"
	 */
	DtAnexoBk getDtAnexoBkXid(Long id, Long kyUsuarioMod);

	List<DtAnexoBk> getAllDtAnexoActivos(Long kyUsuarioMod);

	List<DtAnexoBk> getAllDtAnexoActivosCero(Long kyUsuarioMod);

	DtAnexoBk saveorupdateDtAnexoBk(DtAnexoBk dtAnexoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteDtAnexo(DtAnexoBk dtAnexoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<DtAnexoBk> getDtAnexoXFiltro(String filename, String filenameoriginal, Long idTiposervicio, Long tipoAnexo,
			Long idmaestro, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtAnexoTotalXFiltro(String filename, String filenameoriginal, Long idTiposervicio, Long tipoAnexo,
			Long idmaestro, Long kyUsuarioMod);

	List<DtAnexoBk> getDtAnexoXFiltro(String filename, String filenameoriginal, Long idTiposervicio, Long tipoAnexo,
			Long idmaestro, Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * DT_CAPA_TEMAS SERVICIO: ALMACENA LOS DIFERENTES TEMAS AGENDADOS EN LA
	 * CAPACITACION "TEMAS DE CAPACITACIÓN"
	 */
	DtCapaTemasBk getDtCapaTemasBkXid(Long id, Long kyUsuarioMod);

	List<DtCapaTemasBk> getAllDtCapaTemasActivos(Long kyUsuarioMod);

	List<DtCapaTemasBk> getAllDtCapaTemasActivosCero(Long kyUsuarioMod);

	DtCapaTemasBk saveorupdateDtCapaTemasBk(DtCapaTemasBk dtCapaTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteDtCapaTemas(DtCapaTemasBk dtCapaTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtCapaTemasBk> getDtCapaTemasXFiltro(Long idCapacitacion, Long idTema, Long idSubtema, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtCapaTemasTotalXFiltro(Long idCapacitacion, Long idTema, Long idSubtema, Long kyUsuarioMod);

	List<DtCapaTemasBk> getDtCapaTemasXFiltro(Long idCapacitacion, Long idTema, Long idSubtema, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getMsTemaIdTemaIdTema();

	// List<IDValorDto> getMsSubtemaIdSubtemaIdSubtema();

	/**
	 * DT_ENTIDAD_SEDES SERVICIO: ALMACENA LAS DISTINTAS SEDES ASIGNADAS A LA
	 * ENTIDAD "SEDES ASIGNADAS A LA ENTIDAD"
	 */
	DtEntidadSedesBk getDtEntidadSedesBkXid(Long id, Long kyUsuarioMod);

	List<DtEntidadSedesBk> getAllDtEntidadSedesActivos(Long kyUsuarioMod);

	List<DtEntidadSedesBk> getAllDtEntidadSedesActivosCero(Long kyUsuarioMod);

	DtEntidadSedesBk saveorupdateDtEntidadSedesBk(DtEntidadSedesBk dtEntidadSedesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtEntidadSedesBk> getDtEntidadSedesXFiltro(Long idEntidad, Long idSede, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtEntidadSedesTotalXFiltro(Long idEntidad, Long idSede, Long kyUsuarioMod);

	List<DtEntidadSedesBk> getDtEntidadSedesXFiltro(Long idEntidad, Long idSede, Long kyUsuarioMod);
	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroEstado();

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	/**
	 * DT_CONSULTAS SERVICIO: ALMACENA LOS DATOS REGISTRADOS EN UNA CONSULTA
	 * "CONSULTAS"
	 */
	DtConsultasBk getDtConsultasBkXid(Long id, Long kyUsuarioMod);

	List<DtConsultasBk> getAllDtConsultasActivos(Long kyUsuarioMod);

	List<DtConsultasBk> getAllDtConsultasActivosCero(Long kyUsuarioMod);

	DtConsultasBk saveorupdateDtConsultasBk(DtConsultasBk dtConsultasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteDtConsultas(DtConsultasBk dtConsultasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdPrestservic();

	// List<IDValorDto> getPrtParametrosIdparametroIdModalidad();

	// List<IDValorDto> getMsTemaIdTemaIdTema();

	// List<IDValorDto> getMsSubtemaIdSubtemaIdSubtema();

	// List<IDValorDto> getPrtParametrosIdparametroIdOrigen();

	// List<IDValorDto> getPrtParametrosIdparametroIdCargo();

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	/**
	 * DT_VISITAS_PROYECTO SERVICIO: ALMACENA LOS DISTINTOS PROYECTOS DE
	 * INVERSIÓN RELACIONADOS A LAS VISITAS
	 */
	DtVisitasProyectoBk getDtVisitasProyectoBkXid(Long id, Long kyUsuarioMod);

	List<DtVisitasProyectoBk> getAllDtVisitasProyectoActivos(Long kyUsuarioMod);

	List<DtVisitasProyectoBk> getAllDtVisitasProyectoActivosCero(Long kyUsuarioMod);

	DtVisitasProyectoBk saveorupdateDtVisitasProyectoBk(DtVisitasProyectoBk dtVisitasProyectoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtVisitasProyectoBk> getDtVisitasProyectoXFiltro(Long idVisita, Long idProyecto, String detalle, int inicial,
			int MAX, Long kyUsuarioMod);

	Long getDtVisitasProyectoTotalXFiltro(Long idVisita, Long idProyecto, String detalle, Long kyUsuarioMod);

	List<DtVisitasProyectoBk> getDtVisitasProyectoXFiltro(Long idVisita, Long idProyecto, String detalle,
			Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * DT_CAPA_USUEXTERNOS SERVICIO: ALMACENA A LOS PARTICIPANTES QUE ASISTEN A
	 * LA CAPACITACION "PARTICIPANTES EN LA CAPACITACIÓN"
	 */
	DtCapaUsuexternosBk getDtCapaUsuexternosBkXid(Long id, Long kyUsuarioMod);

	List<DtCapaUsuexternosBk> getAllDtCapaUsuexternosActivos(Long kyUsuarioMod);

	List<DtCapaUsuexternosBk> getAllDtCapaUsuexternosActivosCero(Long kyUsuarioMod);

	DtCapaUsuexternosBk saveorupdateDtCapaUsuexternosBk(DtCapaUsuexternosBk dtCapaUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;
	
	List<DtCapaUsuexternosBk> getDtCapaUsuarioExtByIdDCapa(Long idCapacitacion);

	void deleteDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtCapaUsuexternosBk> getDtCapaUsuexternosXFiltro(Long idCapacitacion, Long idUsuexterno, Long idCargoUsuext,
			Long idEntidad, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtCapaUsuexternosTotalXFiltro(Long idCapacitacion, Long idUsuexterno, Long idCargoUsuext, Long idEntidad,
			Long kyUsuarioMod);

	List<DtCapaUsuexternosBk> getDtCapaUsuexternosXFiltro(Long idCapacitacion, Long idUsuexterno, Long idCargoUsuext,
			Long idEntidad, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdCargoUsuext();

//	List<DtEntidadesBk> getDtEntidadesIdEntidad(String idEntidad);

	/**
	 * DT_VISITAS_USUEXTERNOS SERVICIO: ALMACENA A LOS PARTICIPANTES DE LA
	 * VISITA "PARTICIPANTES"
	 */
	DtVisitasUsuexternosBk getDtVisitasUsuexternosBkXid(Long id, Long kyUsuarioMod);

	List<DtVisitasUsuexternosBk> getAllDtVisitasUsuexternosActivos(Long kyUsuarioMod);

	List<DtVisitasUsuexternosBk> getAllDtVisitasUsuexternosActivosCero(Long kyUsuarioMod);

	DtVisitasUsuexternosBk saveorupdateDtVisitasUsuexternosBk(DtVisitasUsuexternosBk dtVisitasUsuexternosBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtVisitasUsuexternosBk> getDtVisitasUsuexternosXFiltro(Long idVisita, Long idUsuexterno, Long idCargoUsuext,
			int inicial, int MAX, Long kyUsuarioMod);

	Long getDtVisitasUsuexternosTotalXFiltro(Long idVisita, Long idUsuexterno, Long idCargoUsuext, Long kyUsuarioMod);

	List<DtVisitasUsuexternosBk> getDtVisitasUsuexternosXFiltro(Long idVisita, Long idUsuexterno, Long idCargoUsuext,
			Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdCargoUsuext();

	/**
	 * DT_CARGOS_USUEXTER SERVICIO: ALMACENA LOS CARGOS DE LOS USUARIOS EXTERNOS
	 * "CARGO DE USUARIO EXTERNO"
	 */
	DtCargosUsuexterBk getDtCargosUsuexterBkXid(Long id, Long kyUsuarioMod);

	List<DtCargosUsuexterBk> getAllDtCargosUsuexterActivos(Long kyUsuarioMod);

	List<DtCargosUsuexterBk> getAllDtCargosUsuexterActivosCero(Long kyUsuarioMod);

	DtCargosUsuexterBk saveorupdateDtCargosUsuexterBk(DtCargosUsuexterBk dtCargosUsuexterBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtCargosUsuexterBk> getDtCargosUsuexterXFiltro(Long idUsuextEnti, Long idCargo, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtCargosUsuexterTotalXFiltro(Long idUsuextEnti, Long idCargo, Long kyUsuarioMod);

	List<DtCargosUsuexterBk> getDtCargosUsuexterXFiltro(Long idUsuextEnti, Long idCargo, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdCargo();

	/**
	 * MS_TEMA SERVICIO: ALMACENA LOS TEMAS REGISTRADOS EN EL SISTEMA "TEMAS"
	 */
	MsTemaBk getMsTemaBkXid(Long id, Long kyUsuarioMod);

	List<MsTemaBk> getAllMsTemaActivos(Long kyUsuarioMod);

	List<MsTemaBk> getAllMsTemaActivosCero(Long kyUsuarioMod);

	MsTemaBk saveorupdateMsTemaBk(MsTemaBk msTemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	void deleteMsTema(MsTemaBk msTemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	/// ADICIONALES

	// List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

	List<IDValorDto> getPrtParametrosIdparametroTipoServicio();

	/**
	 * DT_USUARIOS_SEDES SERVICIO: ALMACENA A LAS SEDES A LAS QUE PUEDEN
	 * PERTENECER LOS USUARIOS
	 */
	DtUsuariosSedesBk getDtUsuariosSedesBkXid(Long id, Long kyUsuarioMod);

	List<DtUsuariosSedesBk> getAllDtUsuariosSedesActivos(Long kyUsuarioMod);

	List<DtUsuariosSedesBk> getAllDtUsuariosSedesActivosCero(Long kyUsuarioMod);

	DtUsuariosSedesBk saveorupdateDtUsuariosSedesBk(DtUsuariosSedesBk dtUsuariosSedesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void deleteDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtUsuariosSedesBk> getDtUsuariosSedesXFiltro(Long idSede, Long idusuario, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtUsuariosSedesTotalXFiltro(Long idSede, Long idusuario, Long kyUsuarioMod);

	List<DtUsuariosSedesBk> getDtUsuariosSedesXFiltro(Long idSede, Long idusuario, Long kyUsuarioMod);
	/// ADICIONALES

	/**
	 * MS_INDICADOR SERVICIO: ALMACENA LOS INDICADORES REGISTRADOS EN EL SISTEMA
	 * "INDICADORES"
	 */
	MsIndicadorBk getMsIndicadorBkXid(Long id, Long kyUsuarioMod);

	List<MsIndicadorBk> getAllMsIndicadorActivos(Long kyUsuarioMod);

	List<MsIndicadorBk> getAllMsIndicadorActivosCero(Long kyUsuarioMod);

	MsIndicadorBk saveorupdateMsIndicadorBk(MsIndicadorBk msIndicadorBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsIndicador(MsIndicadorBk msIndicadorBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdObjetvo();

	List<IDValorDto> getPrtParametrosIdparametroIdNivlstrat();

	List<IDValorDto> getPrtParametrosIdparametroIdFactor();

	List<IDValorDto> getPrtParametrosIdparametroIdFuenteinfor();

	/**
	 * DT_ENCUESTA SERVICIO:
	 */
	DtEncuestaBk getDtEncuestaBkXid(Integer id, Long kyUsuarioMod);

	List<DtEncuestaBk> getAllDtEncuestaActivos(Long kyUsuarioMod);

	List<DtEncuestaBk> getAllDtEncuestaActivosCero(Long kyUsuarioMod);

	DtEncuestaBk saveorupdateDtEncuestaBk(DtEncuestaBk dtEncuestaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteDtEncuesta(DtEncuestaBk dtEncuestaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<DtEncuestaBk> getDtEncuestaXFiltro(Long tipoServicio, Timestamp fechaInicio, Timestamp fechaFin, Long idOrigen,
			Long idPrestacion, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtEncuestaTotalXFiltro(Long tipoServicio, Timestamp fechaInicio, Timestamp fechaFin, Long idOrigen,
			Long idPrestacion, Long kyUsuarioMod);

	List<DtEncuestaBk> getDtEncuestaXFiltro(Long tipoServicio, Timestamp fechaInicio, Timestamp fechaFin, Long idOrigen,
			Long idPrestacion, Long kyUsuarioMod);
	/// ADICIONALES

	// List<IDValorDto> getPrtParametrosIdparametroIdOrigen();

	// List<IDValorDto> getPrtParametrosIdparametroIdPrestacion();

	/**
	 * MS_LOCAL SERVICIO: ALMACENA LOS LOCALES REGISTRADOS EN EL SISTEMA
	 * "LOCALES"
	 */
	MsLocalBk getMsLocalBkXid(Long id, Long kyUsuarioMod);

	List<MsLocalBk> getAllMsLocalActivos(Long kyUsuarioMod);

	List<MsLocalBk> getAllMsLocalActivosCero(Long kyUsuarioMod);

	MsLocalBk saveorupdateMsLocalBk(MsLocalBk msLocalBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsLocal(MsLocalBk msLocalBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	
	/// ADICIONALES

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	/**
	 * MS_META SERVICIO: ALMACENA LAS METAS CON SUS VALORES
	 */
	MsMetaBk getMsMetaBkXid(Long id, Long kyUsuarioMod);

	List<MsMetaBk> getAllMsMetaActivos(Long kyUsuarioMod);

	List<MsMetaBk> getAllMsMetaActivosCero(Long kyUsuarioMod);

	MsMetaBk saveorupdateMsMetaBk(MsMetaBk msMetaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	void deleteMsMeta(MsMetaBk msMetaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroIdTipoServicio();

	// List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

	// List<IDValorDto> getMsSedesIdSedeIdSede();

	/**
	 * MS_ALERTA SERVICIO: ALMACENA LAS ALERTAS GENERADAS EN EL SISTMA "ALERTAS"
	 */
	MsAlertaBk getMsAlertaBkXid(Long id, Long kyUsuarioMod);

	List<MsAlertaBk> getAllMsAlertaActivos(Long kyUsuarioMod);

	List<MsAlertaBk> getAllMsAlertaActivosCero(Long kyUsuarioMod);

	MsAlertaBk saveorupdateMsAlertaBk(MsAlertaBk msAlertaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void deleteMsAlerta(MsAlertaBk msAlertaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;
/// ADICIONALES

	List<IDValorDto> getPrtParametrosIdparametroDia();

	List<IDValorDto> getPrtParametrosIdparametroHora();

	List<IDValorDto> getPrtParametrosIdparametroIdCaracterst();

	List<MsProyectoInversionDto> getMsProyectoInversionCache();

	List<MsUsuariosDto> getMsUsuariosCachee();
	List<MsUsuariosDto> getMsUsuariosCache(Long idSede, int pProfile,String sUsername); //PURIBE 22032024 -INICIO-->

	MsUsuariosBk getMsUsuariosBkXUsername(String username);

	MsUsuariosBk saveorupdateMsUsuariosBk(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			Long kySedeMod, String rmtaddress, boolean solocontrasenia) throws Validador;

	Map<String, MsUsuariosBk> getMsUsuariosBkXUseranameCache();
	
	List<DtUsuarioExternoBk> getMsUsuariosExternoBkXnombreapellido(String nombreapellido) throws Validador;//CUSCATA - 18062024

	CacheMsUsuariosBk getCacheMsUsuariosBkActivos();

	List<IDValorDto> getListaAnnio();

	List<IIDValorDto> getDepartamentosV();

	List<IIDValorDto> getProvinciasV(Integer id_dpto);

	List<IIDValorDto> getDistritosV(Integer id_dpto, Integer id_prov);

	void activarMsUsuarios(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

//	Integer getxDefectoCoddpto();
//
//	Integer getxDefectoCodprov();
//
//	Integer getxDefectoCoddist();

	void inicializeCaches();

	void activarDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarMsPaises(MsPaisesBk msPaisesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<MsPaisesBk> getMsPaisesXFiltro(String paisNombre, String acronimo, Long estado, Long kyUsuarioMod);

	List<MsPaisesBk> getMsPaisesXFiltro(String paisNombre, String acronimo, Long estado, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getMsPaisesTotalXFiltro(String paisNombre, String acronimo, Long estado, Long kyUsuarioMod);

	void activarDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtConsultasProyectoBk> getDtConsultasProyectoXFiltro(Long idConsulta, Long idProyecto, String detalle,
			Long kyUsuarioMod);

	List<DtConsultasProyectoBk> getDtConsultasProyectoXFiltro(Long idConsulta, Long idProyecto, String detalle,
			int inicial, int MAX, Long kyUsuarioMod);

	Long getDtConsultasProyectoTotalXFiltro(Long idConsulta, Long idProyecto, String detalle, Long kyUsuarioMod);

	void activarDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

//	List<DtVisitasUsuinternosBk> getDtVisitasUsuinternosXFiltro(Long idVisita, Long idUsuinterno, Long kyUsuarioMod);
	List<DtVisitasUsuinternosBk> getDtVisitasUsuinternosXFiltro(Long idVisita, Long kyUsuarioMod);

	List<DtVisitasUsuinternosBk> getDtVisitasUsuinternosXFiltro(Long idVisita, Long idUsuinterno, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtVisitasUsuinternosTotalXFiltro(Long idVisita, Long idUsuinterno, Long kyUsuarioMod);

	void activarDtAsistencia(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtAsistenciaBk> getDtAsistenciaXFiltro(Long idEntidad, Long idSede, Timestamp fechaAsistencia,
			Long idUsuinterno, Long idSistAdm, Long idOrigen, Long idProgramacion, Long estado, Long kyUsuarioMod);

	void activarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtCapacitacionBk> getDtCapacitacionXFiltro(Timestamp fechaInic, Timestamp fechaFin, String nomEvento,
			Long idSistAdm, Long idUsuinterno, Long flagPubli, Long idModalidad, Long idProgramacion, Long estado,
			Integer cantPartic, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtCapacitacionTotalXFiltro(Timestamp fechaInic, Timestamp fechaFin, String nomEvento, Long idSistAdm,
			Long idUsuinterno, Long flagPubli, Long idModalidad, Long idProgramacion, Long estado, Integer cantPartic,
			Long kyUsuarioMod);

	List<DtCapacitacionBk> getDtCapacitacionXFiltro(Timestamp fechaInic, Timestamp fechaFin, String nomEvento,
			Long idSistAdm, Long idUsuinterno, Long flagPubli, Long idModalidad, Long idProgramacion, Long estado,
			Integer cantPartic, Long kyUsuarioMod);

	void activarTaFeriados(TaFeriadosBk taFeriadosBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

//	List<TaFeriadosBk> getTaFeriadosXFiltro(String feDesc, Timestamp feFchmod, Timestamp feFchcrear, Integer feEstado,
//			Long kyUsuarioMod);
	
	List<TaFeriadosBk> getTaFeriadosXFiltro(String feDesc, Long kyUsuarioMod);
	List<TaFeriadosBk> getTaFeriadosXFiltro(String feDesc, int inicial, int MAX, Long kyUsuarioMod);

//	List<TaFeriadosBk> getTaFeriadosXFiltro(String feDesc, Timestamp feFchmod, Timestamp feFchcrear, Integer feEstado,
//			int inicial, int MAX, Long kyUsuarioMod);

//	Long getTaFeriadosTotalXFiltro(String feDesc, Timestamp feFchmod, Timestamp feFchcrear, Integer feEstado,
//			Long kyUsuarioMod);
	
	Long getTaFeriadosTotalXFiltro(String feDesc, Long kyUsuarioMod);

//	List<DtEntidadesBk> getDtEntidadesXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo, Integer codDpto,
//			Integer codProv, Integer codDistr, Long idCaract, Long idSistAdmi, Long estado, Long kyUsuarioMod);

	List<DtEntidadesBk> getDtEntidadesXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo, Integer codDpto,
			Integer codProv, Integer codDistr, Long idCaract, Long idSistAdmi, Long estado, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtEntidadesTotalXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo, Integer codDpto,
			Integer codProv, Integer codDistr, Long idCaract, Long idSistAdmi, Long estado, Long kyUsuarioMod);

	void activarDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarDtVisitas(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<DtVisitasBk> getDtVisitasXFiltro(Timestamp fechaVisita, Long idSistAdm, Long idSede, Long idOrigen,
			Long idProgramacion, Long estado, Long kyUsuarioMod);

	List<DtVisitasBk> getDtVisitasXFiltro(Timestamp fechaVisita, Long idSistAdm, Long idSede, Long idOrigen,
			Long idProgramacion, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getDtVisitasTotalXFiltro(Timestamp fechaVisita, Long idSistAdm, Long idSede, Long idOrigen,
			Long idProgramacion, Long estado, Long kyUsuarioMod);

	List<DtUsuarioExternoBk> getDtUsuarioExternoNombre(String nombre);

	void activarDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtEntidadesUsuexternosBk> getDtEntidadesUsuexternosXFiltro(Long idEntidad, Long idUsuexterno,
			Long kyUsuarioMod);

	List<DtEntidadesUsuexternosBk> getDtEntidadesUsuexternosXFiltro(Long idEntidad, Long idUsuexterno, int inicial,
			int MAX, Long kyUsuarioMod);

	Long getDtEntidadesUsuexternosTotalXFiltro(Long idEntidad, Long idUsuexterno, Long kyUsuarioMod);

	void activarPrtParametros(PrtParametrosBk prtParametrosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<PrtParametrosBk> getPrtParametrosXFiltro(String descripcion, Long idpadre, Timestamp fechaCrea,
			Timestamp fechaModif, Integer estado, Long kyUsuarioMod);

	List<PrtParametrosBk> getPrtParametrosXFiltro(String descripcion, Long idpadre, Timestamp fechaCrea,
			Timestamp fechaModif, Integer estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getPrtParametrosTotalXFiltro(String descripcion, Long idpadre, Timestamp fechaCrea, Timestamp fechaModif,
			Integer estado, Long kyUsuarioMod);

	void activarDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarMsUbigeo(MsUbigeoBk msUbigeoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<MsUbigeoBk> getMsUbigeoXFiltro(Integer codDpto, Integer codProv, Integer codDistr, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsUbigeoBk> getMsUbigeoXFiltro(Integer codDpto, Integer codProv, Integer codDistr, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsUbigeoTotalXFiltro(Integer codDpto, Integer codProv, Integer codDistr, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsSisAdmistrativoBk> getMsSisAdmistrativoXFiltro(String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsSisAdmistrativoTotalXFiltro(String descripcion, Timestamp fechaCrea, Timestamp fechaModif, Long estado,
			Long kyUsuarioMod);

	List<MsSisAdmistrativoBk> getMsSisAdmistrativoXFiltro(String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod);

	void activarMsSubtema(MsSubtemaBk msSubtemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<MsSubtemaBk> getMsSubtemaXFiltro(Long idTema, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod);

	List<MsSubtemaBk> getMsSubtemaXFiltro(Long idTema, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsSubtemaTotalXFiltro(Long idTema, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod);

	void activarMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<MsProyectoInversionBk> getMsProyectoInversionNombre(String nombre);

	void activarMsSedes(MsSedesBk msSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<MsSedesBk> getMsSedesXFiltro(String sede, Long idGrupo, Long idMacregion, String sigla, Integer codDpto,
			String direccion, Long orden, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsSedesBk> getMsSedesXFiltro(String sede, Long idGrupo, Long idMacregion, String sigla, Integer codDpto,
			String direccion, Long orden, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsSedesTotalXFiltro(String sede, Long idGrupo, Long idMacregion, String sigla, Integer codDpto,
			String direccion, Long orden, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<IDValorDto> getPrtParametrosIdparametroIdEstadoActual();

//	List<IDValorDto> getPrtParametrosIdparametroIdEstadoSeguimiento();

	void activarDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarDtAnexo(DtAnexoBk dtAnexoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	void activarDtCapaTemas(DtCapaTemasBk dtCapaTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<MsIndicadorBk> getMsIndicadorXFiltro(String descripcion, Long idObjetvo, Long idNivlstrat, Long idFactor,
			Long idFuenteinfor, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	Long getMsIndicadorTotalXFiltro(String descripcion, Long idObjetvo, Long idNivlstrat, Long idFactor,
			Long idFuenteinfor, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsIndicadorBk> getMsIndicadorXFiltro(String descripcion, Long idObjetvo, Long idNivlstrat, Long idFactor,
			Long idFuenteinfor, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	void activarDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<MsMetaBk> getMsMetaXFiltro(Integer annio, Long idTipoServicio, Long idSistAdmi, Long idSede, Long valor,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsMetaBk> getMsMetaXFiltro(Integer annio, Long idTipoServicio, Long idSistAdmi, Long idSede, Long valor,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	void activarMsMeta(MsMetaBk msMetaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	void activarDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<MsLocalBk> getMsLocalXFiltro(String descripcion, String direccion, String referencia, Integer codDpto,
			Integer codProv, Integer codDistr, Timestamp fechaModif, Long estado, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getMsLocalTotalXFiltro(String descripcion, String direccion, String referencia, Integer codDpto,
			Integer codProv, Integer codDistr, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsLocalBk> getMsLocalXFiltro(String descripcion, String direccion, String referencia, Integer codDpto,
			Integer codProv, Integer codDistr, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	void activarDtEncuesta(DtEncuestaBk dtEncuestaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	void activarMsIndicador(MsIndicadorBk msIndicadorBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	Long getMsTemaTotalXFiltro(Long idSistAdmi, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod);

	List<MsTemaBk> getMsTemaXFiltro(Long idSistAdmi, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, int inicial, int MAX, Long kyUsuarioMod);

	List<MsTemaBk> getMsTemaXFiltro(Long idSistAdmi, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod);

	void activarMsTema(MsTemaBk msTemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	void activarDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	Long getDtConsultasTotalXFiltro(Timestamp fechaConsu, Long idUsuexterno, Long idSistAdm, Long idTema,
			Long idSubtema, Long estado, Long kyUsuarioMod);

	List<DtConsultasBk> getDtConsultasXFiltro(Timestamp fechaConsu, Long idUsuexterno, Long idSistAdm, Long idTema,
			Long idSubtema, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	List<DtConsultasBk> getDtConsultasXFiltro(Timestamp fechaConsu, Long idUsuexterno, Long idSistAdm, Long idTema,
			Long idSubtema, Long estado, Long kyUsuarioMod);

	void activarDtConsultas(DtConsultasBk dtConsultasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	Long getDtAmpliacionFechaTotalXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi, Timestamp fechaInicio,
			Timestamp fechaFin, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<DtAmpliacionFechaBk> getDtAmpliacionFechaXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
			Timestamp fechaInicio, Timestamp fechaFin, Timestamp fechaModif, Long estado, int inicial, int MAX,
			Long kyUsuarioMod);

	List<DtAmpliacionFechaBk> getDtAmpliacionFechaXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
			Timestamp fechaInicio, Timestamp fechaFin, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	void activarDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	void activarDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;

	Long getMsAlertaTotalXFiltro(Long idCaracterst, String otrosDestin, Integer dia, Integer hora, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsAlertaBk> getMsAlertaXFiltro(Long idCaracterst, String otrosDestin, Integer dia, Integer hora,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<MsAlertaBk> getMsAlertaXFiltro(Long idCaracterst, String otrosDestin, Integer dia, Integer hora,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod);

	void activarMsAlerta(MsAlertaBk msAlertaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	Long getMsMetaTotalXFiltro(Integer annio, Long idTipoServicio, Long idSistAdmi, Long idSede, Long valor,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	void activarMsLocal(MsLocalBk msLocalBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador;

	List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro(String aPaterno, String aMaterno, String nombre, Long numDocu,
			String correo, Long telefFijo, Long telefCell, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro(String aPaterno, String aMaterno, String nombre, Long numDocu,
			String correo, Long telefFijo, Long telefCell, Timestamp fechaModif, Long estado, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtUsuarioExternoTotalXFiltro(String aPaterno, String aMaterno, String nombre, Long numDocu, String correo,
			Long telefFijo, Long telefCell, Timestamp fechaModif, Long estado, Long kyUsuarioMod);

	void activarDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	List<DtEntidadesBk> getDtEntidadesRazSocial(String razSocial);

	void activarDtEntidades(DtEntidadesBk dtEntidadesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador;

	void activarMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador;

	List<DtAsistenciaBk> getDtAsistenciaXFiltro(Long idEntidad, Long idSede, Timestamp fechaAsistencia,
			Long idUsuinterno, Long idSistAdm, Long idOrigen, Long idProgramacion, Long estado, int inicial, int MAX,
			Long kyUsuarioMod);

	Long getDtAsistenciaTotalXFiltro(Long idEntidad, Long idSede, Timestamp fechaAsistencia, Long idUsuinterno,
			Long idSistAdm, Long idOrigen, Long idProgramacion, Long estado, Long kyUsuarioMod);

	Long getDtCapaEntidadesTotalXFiltro(Long idCapacitacion, Long idEntidad, Long kyUsuarioMod);

	List<DtCapaEntidadesBk> getDtCapaEntidadesXFiltro(Long idCapacitacion, Long idEntidad, int inicial, int MAX,
			Long kyUsuarioMod);

	List<DtCapaEntidadesBk> getDtCapaEntidadesXFiltro(Long idCapacitacion, Long idEntidad, Long kyUsuarioMod);

	List<DtEntidadesBk> getDtEntidadesIdEntidadTxt(String idEntidadTxt);

	List<DtEntidadSedesDto> getDtEntidadSedesDtossXIdEntidad(Long idEntidad);
	
	//MPINARES 24012023 - INICIO
		List<DtEntidadesDto> getMsInstitucionesXCodigoEjecutora(String codEjec, Long idSistAdmi) throws Validador ;
		List<DtAsistenciaBk> getDtAsistenciaXFiltroV(Date fechaInicio, Date fechaFin, Long idProgramacion,Long kyUsuarioMod) throws Validador;
		List<DtAsistenciaTemasBk> getDtAsistenciaTemasXIdAsistencia(Long idAsistencia);
		List<IDValorDto> getPrtParametrosIdparametroIdTipoEntidad();
		List<IDValorDto> getListaMsPaisesActivos() ;
		Long getxDefectoCodpais();
		Integer getxDefectoCoddpto();
		Integer getxDefectoCodprov() ;
		Integer getxDefectoCoddist();
		List<IDValorDto> getMsTemaIdTemaIdTemaXSisAdmin(Long idSistAdmi);
		List<IDValorDto> getSubTemaByIdSistemaAdminTema(Long idTema) throws Validador ;
		List<DtEntidadesBk> getMsInstitucionesIdprovee(String rasonsocial, Long idSistAdmi);
		void reactivarDtAsistencia(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
				String rmtaddress) throws Validador;
		void validarreactivarDtAsistencia(DtAsistenciaBk dtAsistenciaBk) throws Validador;
		void validarreactivarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk) throws Validador;
		//MPINARES 24012023 - FIN
		
		//MPINARES 14022024 - INICIO
		List<DtCapacitacionBk> getDtCapacitacionXFiltroV(Date fechaInicio, Date fechaFin, Long idProgramacion,Long kyUsuarioMod);
		List<IDValorDto> getIDValorMsLocalBksssXSede(Long idSede) throws Validador ;
		List<IDValorDto> getIDValorMsLocalBksss() throws Validador;
		List<MsLocalBk> getMsLocalIdLocalListaCache();
		List<IDValorDto> getPrtParametrosIdparametroIdModalidadCapas();
		String getEndpointVentanilla();
		void setEndpointVentanilla(String endpointVentanilla);
		List<IDValorDto> getListaProcedeEjecucion();
		void prepublicarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
				Long kyAreaMod,  String rmtaddress) throws Validador;
		DtCapacitacionBk validDtCapacitacionList(List<DtCapacitacionBk> dtCapacitacionBkList,Long kyUsuarioMod) throws Validador; 
		List<DtCapacitacionBk> getDtCapacitacionXIdPadre(Long idCapaPadre);
		DtCapacitacionBk saveorupdateDtCapacitacionAcumulaBk(DtCapacitacionBk dtCapacitacionBk, String user,
				Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;
		List<DtCapaTemasBk> getDtCapaTemasByIdDCapa(Long idCapacitacion) throws Validador;
		DtAsistenciaBk getDtAsistenciaBkXidV2(Long id);
		void reactivarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod, Long kyAreaMod,
				String rmtaddress) throws Validador;
		//MPINARES 14022024 - FIN
		
		// PURIBE 14032024 - INICIO -->
		List<DtEntidadesBk> getDtEntidadesXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo, Long idCaract,
				Integer codDpto, Integer codProv, Integer codDistr, Long idSistAdmi, String geozona, Long kyUsuarioMod);
		// PURIBE 14032024 - FIN -->
		//PURIBE 14032024 - INICIO-->
		List<DtVisitasBk> getDtVisitasXFiltro(Timestamp fechaVisita, Long idOrigen, Long idProgramacion, Long idModalidad,
				Long idTipo, Long idLugar, Long idEntidad, Long idSede, Long idSistAdm, Long idFinancia,
				Timestamp fechaProgramada, Long kyUsuarioMod);
		//PURIBE 14032024 - FIN-->
		//PURIBE 14032024 - INICIO-->
		List<PrtParametrosBk> getPrtParametrosXFiltro(Long idpadre, String descripcion, Long kyUsuarioMod);
		//PURIBE 14032024 - FIN-->
		//PURIBE 14032024 - INICIO-->
		List<MsTemaBk> getMsTemaXFiltro(String descripcion, Long idSistAdmi, Long tipoServicio, Long kyUsuarioMod);
		//PURIBE 14032024 - FIN-->
		//PURIBE 14032024 - INICIO-->
		List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro(String nombre, String aPaterno, String aMaterno,
				String direccion, Integer codDpto, Integer codProv, Integer codDistr, String numDocum, Long kyUsuarioMod);
		//PURIBE 14032024 - FIN->
		//PURIBE 14032024 - INICIO-->
		Long getDtUsuarioExternoTotalXFiltro(String nombre, String aPaterno, String aMaterno, String direccion,
				Integer codDpto, Integer codProv, Integer codDistr, String numDocum, Long kyUsuarioMod);
		//PURIBE 14032024 - FIN-->
		List<IDValorDto> getMsSedesIdSedeIdSedeExTodas();
		
		//PURIBE 22042024 - INICIO-->
		List<DtEntidadesBk> getMsInstitucionesActivas(String rasonsocial);
		List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro2(String nombre, Long kyUsuarioMod);
		boolean validarFechaEdit(DtVisitasBk dtVisitasBk) throws Validador;
		DtAmpliacionFecha getautorizacionProgramacion2(Long idsede, Long idsisAdmin);
		void updateBloqueoEncuesta(DtEncuestaBk dtEncuestaBk,Long kyUsuarioMod,String rmtaddress)throws Validador;
		DtVisitasBk finalizarDtVisita(DtVisitasBk dtVisitasBk, Long idSistemaAdmin, Long kyUsuarioMod)  throws Validador;
		void validarfinalizarDtVisitas(DtVisitasBk dtVisitasBk,Long kyUsuarioMod) throws Validador; 
		DtEncuestaBk getIdEncuesta (Long idTipoServicio, Long fechaServicio, Long idServicio) throws Validador;
		//PURIBE 22042024 - FIN
		DtUsuarioExternoBk getUsuarioPorDNI(Long numDocum, Long kyUsuarioMod);//CUSCATA - 18062024
		DtUsuarioExternoBk getUsuarioCapacitacionPorDNI(Long numDocum, Long kyUsuarioMod);//CUSCATA - 18062024
		
		List<MsUsuariosDto> getMsUsuariosFilter(Long idSede);//JPUYEN 14052024
		DtUsuarioExternoBk getMsUsuariosExternoBkXDni(String dni) throws Validador ;//JPUYEN 14052024
		DtVisitasUsuexternosBk getDtVisitasUsuexternoBkXid(Long id, Long kyUsuarioMod); // JPUYEN 14052024 - INICIO
		List<DtAsistenciaBk> getDtAsistenciaXFiltroV2(Date fechaInicio, Date fechaFin, Long idProgramacion,
				Long kyUsuarioMod, long sede, int rol, long sistemaadmi) throws Validador;
		List<DtCapacitacionBk> getDtCapacitacionXFiltroV2(Date fechaInicio, Date fechaFin, Long idProgramacion,
				Long kyUsuarioMod, long sede, int rol, long sistemaadmi) ;
		List<DtEntidadesDto> getMsInstitucionesXEjecutoraSisAdminSede(String codEjec, Long idSistAdmi, Long idSede) throws Validador;
		List<DtEntidadesBk> getMsInstitucionesIdSisadminIdsede(String rasonsocial, Long idSistAdmi, Long idSede);
		//INICIO CUSCATA - 10072024
		DtAsistenciaBk validarCambiosAsistencia(DtAsistenciaBk asistenciaJS, Long kyUsuarioMod) throws Validador;
		void deleteDtAsistenciaTema(DtAsistenciaTemas dtAsistenciaTemas) throws Validador;
		void deleteTdAnexos(DtAnexoBk tdAnexosBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
				throws Validador;
		List<DtAsistenciaBk> getDtAsistenciaXFiltro(Date fechaInicio, Date fechaFin, Long idProgramacion,
				Long kyUsuarioMod,long sede,int rol,long sistemaadmi) throws Validador;
		void updateDtAsistenciaUsuexCorreo(Long id) throws Validador ;
		void deleteDtAsistenciaUsuario(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user, Long kyUsuarioMod,
				Long kyAreaMod, String rmtaddress) throws Validador;
		//FIN CUSCATA - 10072024
		// JPUYEN 17062024 - INICIO
		DtVisitasBk finalizarDtVisitasBk(DtVisitasBk dtVisitasBk, List<DtAnexoBk> dtAnexosBkss,// JPUYEN 17062024 - NUEVO PARAMETRO
				String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador;
		DtEncuestaBk getIdEncuesta(Long idTipoServicio, Long fechaServicio) throws Validador;
		Long getParametro(String key, Long defaultValue) throws Validador;
		// JPUYEN 17062024 - FIN
}