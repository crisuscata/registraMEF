package pe.gob.mef.registramef.bs.service.imp;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import pe.gob.mef.registramef.bs.cache.clases.CacheMsUsuariosBk;
import pe.gob.mef.registramef.bs.ctlracceso.DtAmpliacionFechaACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtAnexoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaProyectoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaTemasACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaUsuexternosACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaEntidadesACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaProyectoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaPublicoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaTemasACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaUsuexternosACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapacitacionACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCargosUsuexterACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtConsultasACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtConsultasProyectoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtEncuestaACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtEncuestaRespuestaACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadSedesACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadSisAdminACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadesACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadesUsuexternosACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtUsuarioExternoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtUsuariosSedesACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasProyectoACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasTemasACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasUsuexternosACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasUsuinternosACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsAlertaACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsAlertaCargoUserACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsIndicadorACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsLocalACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsMetaACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsPaisesACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsProyectoInversionACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsRolesACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsSedesACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsSisAdmistrativoACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsSubtemaACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsTemaACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsUbigeoACL;
import pe.gob.mef.registramef.bs.ctlracceso.MsUsuariosACL;
import pe.gob.mef.registramef.bs.ctlracceso.PrtParametrosACL;
import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.ctlracceso.TaFeriadosACL;
import pe.gob.mef.registramef.bs.dao.DtAmpliacionFechaDao;
import pe.gob.mef.registramef.bs.dao.DtAnexoDao;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaDao;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaProyectoDao;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaTemasDao;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.DtCapaEntidadesDao;
import pe.gob.mef.registramef.bs.dao.DtCapaProyectoDao;
import pe.gob.mef.registramef.bs.dao.DtCapaPublicoDao;
import pe.gob.mef.registramef.bs.dao.DtCapaTemasDao;
import pe.gob.mef.registramef.bs.dao.DtCapaUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.DtCapacitacionDao;
import pe.gob.mef.registramef.bs.dao.DtCargosUsuexterDao;
import pe.gob.mef.registramef.bs.dao.DtConsultasDao;
import pe.gob.mef.registramef.bs.dao.DtConsultasProyectoDao;
import pe.gob.mef.registramef.bs.dao.DtEncuestaDao;
import pe.gob.mef.registramef.bs.dao.DtEncuestaRespuestaDao;
import pe.gob.mef.registramef.bs.dao.DtEntidadSedesDao;
import pe.gob.mef.registramef.bs.dao.DtEntidadSisAdminDao;
import pe.gob.mef.registramef.bs.dao.DtEntidadesDao;
import pe.gob.mef.registramef.bs.dao.DtEntidadesUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.DtUsuarioExternoDao;
import pe.gob.mef.registramef.bs.dao.DtUsuariosSedesDao;
import pe.gob.mef.registramef.bs.dao.DtVisitasDao;
import pe.gob.mef.registramef.bs.dao.DtVisitasProyectoDao;
import pe.gob.mef.registramef.bs.dao.DtVisitasTemasDao;
import pe.gob.mef.registramef.bs.dao.DtVisitasUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.DtVisitasUsuinternosDao;
import pe.gob.mef.registramef.bs.dao.MsAlertaCargoUserDao;
import pe.gob.mef.registramef.bs.dao.MsAlertaDao;
import pe.gob.mef.registramef.bs.dao.MsIndicadorDao;
import pe.gob.mef.registramef.bs.dao.MsLocalDao;
import pe.gob.mef.registramef.bs.dao.MsMetaDao;
import pe.gob.mef.registramef.bs.dao.MsPaisesDao;
import pe.gob.mef.registramef.bs.dao.MsProyectoInversionDao;
import pe.gob.mef.registramef.bs.dao.MsRolesDao;
import pe.gob.mef.registramef.bs.dao.MsSedesDao;
import pe.gob.mef.registramef.bs.dao.MsSisAdmistrativoDao;
import pe.gob.mef.registramef.bs.dao.MsSubtemaDao;
import pe.gob.mef.registramef.bs.dao.MsTemaDao;
import pe.gob.mef.registramef.bs.dao.MsUbigeoDao;
import pe.gob.mef.registramef.bs.dao.MsUsuariosDao;
import pe.gob.mef.registramef.bs.dao.PrtParametrosDao;
import pe.gob.mef.registramef.bs.dao.TaFeriadosDao;
import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.domain.DtAnexo;
import pe.gob.mef.registramef.bs.domain.DtAsistencia;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaProyecto;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaTemas;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaUsuexternos;
import pe.gob.mef.registramef.bs.domain.DtCapaEntidades;
import pe.gob.mef.registramef.bs.domain.DtCapaProyecto;
import pe.gob.mef.registramef.bs.domain.DtCapaPublico;
import pe.gob.mef.registramef.bs.domain.DtCapaTemas;
import pe.gob.mef.registramef.bs.domain.DtCapaUsuexternos;
import pe.gob.mef.registramef.bs.domain.DtCapacitacion;
import pe.gob.mef.registramef.bs.domain.DtCargosUsuexter;
import pe.gob.mef.registramef.bs.domain.DtConsultas;
import pe.gob.mef.registramef.bs.domain.DtConsultasProyecto;
import pe.gob.mef.registramef.bs.domain.DtEncuesta;
import pe.gob.mef.registramef.bs.domain.DtEncuestaRespuesta;
import pe.gob.mef.registramef.bs.domain.DtEntidadSedes;
import pe.gob.mef.registramef.bs.domain.DtEntidadSisAdmin;
import pe.gob.mef.registramef.bs.domain.DtEntidades;
import pe.gob.mef.registramef.bs.domain.DtEntidadesUsuexternos;
import pe.gob.mef.registramef.bs.domain.DtUsuarioExterno;
import pe.gob.mef.registramef.bs.domain.DtUsuariosSedes;
import pe.gob.mef.registramef.bs.domain.DtVisitas;
import pe.gob.mef.registramef.bs.domain.DtVisitasProyecto;
import pe.gob.mef.registramef.bs.domain.DtVisitasTemas;
import pe.gob.mef.registramef.bs.domain.DtVisitasUsuexternos;
import pe.gob.mef.registramef.bs.domain.DtVisitasUsuinternos;
import pe.gob.mef.registramef.bs.domain.MsAlerta;
import pe.gob.mef.registramef.bs.domain.MsAlertaCargoUser;
import pe.gob.mef.registramef.bs.domain.MsIndicador;
import pe.gob.mef.registramef.bs.domain.MsLocal;
import pe.gob.mef.registramef.bs.domain.MsMeta;
import pe.gob.mef.registramef.bs.domain.MsPaises;
import pe.gob.mef.registramef.bs.domain.MsProyectoInversion;
import pe.gob.mef.registramef.bs.domain.MsRoles;
import pe.gob.mef.registramef.bs.domain.MsSedes;
import pe.gob.mef.registramef.bs.domain.MsSisAdmistrativo;
import pe.gob.mef.registramef.bs.domain.MsSubtema;
import pe.gob.mef.registramef.bs.domain.MsTema;
import pe.gob.mef.registramef.bs.domain.MsUbigeo;
import pe.gob.mef.registramef.bs.domain.MsUbigeoId;
import pe.gob.mef.registramef.bs.domain.MsUsuarios;
import pe.gob.mef.registramef.bs.domain.PrtParametros;
import pe.gob.mef.registramef.bs.domain.TaFeriados;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.service.Servicio;
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
import pe.gob.mef.registramef.bs.transfer.bk.DtServicioBk;
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
import pe.gob.mef.registramef.bs.utils.EmailUtil;
import pe.gob.mef.registramef.bs.utils.Estado;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;//PURIBE 01022024 - INICIO-->
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtAmpliacionFechaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtAnexoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtAsistenciaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtAsistenciaProyectoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtAsistenciaTemasMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtAsistenciaUsuexternosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCapaEntidadesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCapaProyectoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCapaPublicoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCapaTemasMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCapaUsuexternosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCapacitacionMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtCargosUsuexterMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtConsultasMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtConsultasProyectoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtEncuestaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtEncuestaRespuestaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtEntidadSedesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtEntidadSisAdminMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtEntidadesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtEntidadesUsuexternosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtUsuarioExternoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtUsuariosSedesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtVisitasMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtVisitasProyectoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtVisitasTemasMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtVisitasUsuexternosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaDtVisitasUsuinternosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsAlertaCargoUserMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsAlertaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsIndicadorMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsLocalMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsMetaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsPaisesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsProyectoInversionMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsRolesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsSedesMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsSisAdmistrativoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsSubtemaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsTemaMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsUbigeoMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaMsUsuariosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaPrtParametrosMng;
import pe.gob.mef.registramef.bs.val.audi.AuditoriaTaFeriadosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtAmpliacionFechaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtAnexoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtAsistenciaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtAsistenciaProyectoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtAsistenciaTemasMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtAsistenciaUsuexternosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCapaEntidadesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCapaProyectoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCapaPublicoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCapaTemasMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCapaUsuexternosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCapacitacionMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtCargosUsuexterMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtConsultasMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtConsultasProyectoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtEncuestaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtEncuestaRespuestaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtEntidadSedesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtEntidadSisAdminMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtEntidadesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtEntidadesUsuexternosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtUsuarioExternoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtUsuariosSedesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtVisitasMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtVisitasProyectoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtVisitasTemasMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtVisitasUsuexternosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionDtVisitasUsuinternosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsAlertaCargoUserMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsAlertaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsIndicadorMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsLocalMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsMetaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsPaisesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsProyectoInversionMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsRolesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsSedesMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsSisAdmistrativoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsSubtemaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsTemaMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsUbigeoMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionMsUsuariosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionPrtParametrosMng;
import pe.gob.mef.registramef.bs.val.validator.ValidacionTaFeriadosMng;
import pe.gob.mef.web.security.Encriptar;

/**
 * SERVICIO: SERVICIO PRINCIPAL DE FACADE PATTERN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 26/11/2020 00:02
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi / 26/11/2020 00:02 / Creación de la
 *          clase /
 * 
 */
@Service
public class ServicioImp implements Servicio, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3009303434143108208L;

	private static final Logger log = Logger.getLogger(ServicioImp.class.getName());

	@Autowired
	private DtCapaEntidadesDao dtCapaEntidadesDao = null;

	@Autowired
	private DtCapacitacionDao dtCapacitacionDao = null;

	@Autowired
	private DtEntidadesDao dtEntidadesDao = null;

	@Autowired
	private PrtParametrosDao prtParametrosDao = null;

	@Autowired
	private DtCapaPublicoDao dtCapaPublicoDao = null;

	@Autowired
	private MsPaisesDao msPaisesDao = null;

	@Autowired
	private DtConsultasProyectoDao dtConsultasProyectoDao = null;

	@Autowired
	private DtConsultasDao dtConsultasDao = null;

	@Autowired
	private MsProyectoInversionDao msProyectoInversionDao = null;

	@Autowired
	private DtVisitasUsuinternosDao dtVisitasUsuinternosDao = null;

	@Autowired
	private DtVisitasDao dtVisitasDao = null;

	@Autowired
	private MsUsuariosDao msUsuariosDao = null;

	@Autowired
	private MsTemaDao msTemaDao = null;

	@Autowired
	private DtAsistenciaDao dtAsistenciaDao = null;

	@Autowired
	private MsSedesDao msSedesDao = null;

	@Autowired
	private MsSisAdmistrativoDao msSisAdmistrativoDao = null;

	@Autowired
	private MsLocalDao msLocalDao = null;

	// INICIO CUSCATA - 18062024
	@Autowired
	private MsTemaDao msTemasDao = null;
	// FIN CUSCATA - 18062024

	@Autowired
	private MsAlertaCargoUserDao msAlertaCargoUserDao = null;

	@Autowired
	private MsAlertaDao msAlertaDao = null;

	@Autowired
	private TaFeriadosDao taFeriadosDao = null;

	@Autowired
	private MsUbigeoDao msUbigeoDao = null;

	@Autowired
	private DtEntidadSisAdminDao dtEntidadSisAdminDao = null;

	@Autowired
	private DtEntidadesUsuexternosDao dtEntidadesUsuexternosDao = null;

	@Autowired
	private DtUsuarioExternoDao dtUsuarioExternoDao = null;

	@Autowired
	private DtAsistenciaTemasDao dtAsistenciaTemasDao = null;

	@Autowired
	private MsSubtemaDao msSubtemaDao = null;

	@Autowired
	private MsIndicadorDao msIndicadorDao = null;

	@Autowired
	private DtAsistenciaUsuexternosDao dtAsistenciaUsuexternosDao = null;

	@Autowired
	private DtCapaProyectoDao dtCapaProyectoDao = null;

	@Autowired
	private MsRolesDao msRolesDao = null;

	@Autowired
	private DtAmpliacionFechaDao dtAmpliacionFechaDao = null;

	@Autowired
	private DtEncuestaRespuestaDao dtEncuestaRespuestaDao = null;

	@Autowired
	private DtEncuestaDao dtEncuestaDao = null;

	@Autowired
	private DtAsistenciaProyectoDao dtAsistenciaProyectoDao = null;

	@Autowired
	private DtVisitasTemasDao dtVisitasTemasDao = null;

	@Autowired
	private DtAnexoDao dtAnexoDao = null;

	@Autowired
	private DtCapaTemasDao dtCapaTemasDao = null;

	@Autowired
	private DtEntidadSedesDao dtEntidadSedesDao = null;

	@Autowired
	private DtVisitasProyectoDao dtVisitasProyectoDao = null;

	@Autowired
	private DtCapaUsuexternosDao dtCapaUsuexternosDao = null;

	@Autowired
	private DtVisitasUsuexternosDao dtVisitasUsuexternosDao = null;

	@Autowired
	private DtCargosUsuexterDao dtCargosUsuexterDao = null;

	@Autowired
	private DtUsuariosSedesDao dtUsuariosSedesDao = null;

	@Autowired
	private MsMetaDao msMetaDao = null;
	
	@Autowired
	private DtAmpliacionFechaDao ampliacionFechaDao = null;

	/// ADICIONALES
	private List<IDValorDto> prtParametrosIdparametroIdGrupoListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdMacregionListaCache = null;

	private List<IDValorDto> prtParametrosIdparametroEstadoListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdPrestservicListaCache = null;

	private List<DtEntidadesBk> dtEntidadesIdEntidadListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroTipoServicioListaCache = null;

	private List<IDValorDto> prtParametrosIdparametroIdEstadoActualListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdObjetvoListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdNivlstratListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdFactorListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdFuenteinforListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdTipoServicioListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroDiaListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroHoraListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdCaracterstListaCache = null;
	// MPINARES 24012023 - INICIO
	private List<IDValorDto> prtParametrosIdparametroIdTipoEntidadListaCache = null;
	private List<IDValorDto> prtParametrosIdCaracteristicaListaCache = null;
	// MPINARES 24012023 - FIN
	private List<MsProyectoInversionDto> msProyectoInversionListaCache = null;
	private List<MsUsuariosDto> msUsuariosListaCache = null;
	private Map<Long, MsUsuariosBk> msUsuariosBkCache = null;
	private Map<String, MsUsuariosBk> msUsuariosBkXUseranameCache = null;
	private CacheMsUsuariosBk cacheMsUsuariosBkActivos = null;
	private List<IDValorDto> msIndicadorIdIndicadorIdIndicadorListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdCargoUsuextListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroTipoFechaCorteListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdTipodocumentoListaCache = null;

	private List<IDValorDto> msSubtemaIdSubtemaIdSubtemaListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdpadreListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdLugarListaCache = null;
	private List<IDValorDto> msSedesIdSedeIdSedeListaCache = null;

	private List<IDValorDto> prtParametrosIdparametroIdCondlabrListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdCaractListaCache = null;
	private List<IDValorDto> msSisAdmistrativoIdSistAdmiIdSistAdmiListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroGeozonaListaCache = null;
	private Integer xDefectoCoddpto = null;
	private Integer xDefectoCodprov = null;
	private Integer xDefectoCoddist = null;
	private Long xDefectoCodpais = null;
	private List<IDValorDto> prtParametrosIdparametroIdcargoListaCache = null;
	private List<IDValorDto> msLocalIdLocalIdLocalListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdModoListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdNivelListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdPrestacionListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdTipoListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroMotivoEjecListaCache = null;

	private List<IDValorDto> dtEntidadesIdEntidadIdEntidadListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdOrigenListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdModalidadListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdFinanciaListaCache = null;

	private List<IDValorDto> msTemaIdTemaIdTemaListaCache = null;
	private List<IDValorDto> prtParametrosIdparametroIdCargoListaCache = null;
	private List<DtEntidadesDto> dtEntidadesListaCache = null;

	private List<MsLocalBk> msLocalIdLocalListaCache = null;// MPINARES 14022024
															// - INICIO
	// MPINARES 14022024 - INICIO
	private String endpointVentanilla = null;
	private List<IDValorDto> listaProcedeEjecucion = null;
	// MPINARES 14022024 - FIN

	private Integer perfilcache = null; // PURIBE 22032024 - INICIO

	// PURIBE 01022024 - INICIO-->
	Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS, PropertiesMg.DEFOULT_IDSEDES_TODAS);
	Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
			PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
	// PURIBE 01022024 - FIN-->

	public ServicioImp() {
		super();
	}

	@PostConstruct
	private void inicialice() {
		log.info("Inicilizando el servicio [[jtable]]Service Implementación");
		msLocalIdLocalListaCache = null;// MPINARES 14022024 - INICIO
	}

	@Override
	@Async
	public void inicializeCaches() {
		prtParametrosIdparametroIdCargoListaCache = null;
		getPrtParametrosIdparametroIdCargo();

		prtParametrosIdparametroIdCondlabrListaCache = null;
		getPrtParametrosIdparametroIdCondlabr();

		msSisAdmistrativoIdSistAdmiIdSistAdmiListaCache = null;
		getMsSisAdmistrativoIdSistAdmiIdSistAdmi();

		xDefectoCoddpto = null;
		getxDefectoCoddpto();
		xDefectoCodprov = null;
		getxDefectoCodprov();
		xDefectoCoddist = null;
		getxDefectoCoddist();

		msSedesIdSedeIdSedeListaCache = null;
		getMsSedesIdSedeIdSede();

		prtParametrosIdparametroIdpadreListaCache = null;
		getPrtParametrosIdparametroIdpadre();
	}

	/**
	 * DT_CAPA_ENTIDADES SERVICIO: LISTA DE LAS ENTIDADES PROGRAMADAS EN LA
	 * CAPACITACION
	 */
	@Override
	public DtCapaEntidadesBk getDtCapaEntidadesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCapaEntidades dtCapaEntidades = dtCapaEntidadesDao.getDtCapaEntidades(id);
		DtCapaEntidadesBk dtCapaEntidadesBk = null;
		if (dtCapaEntidades != null) {
			dtCapaEntidadesBk = new DtCapaEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesBk, dtCapaEntidades);
			completarDtCapaEntidades(dtCapaEntidadesBk);
			if (kyUsuarioMod != null)
				setACLDtCapaEntidadesBk(dtCapaEntidadesBk, kyUsuarioMod);
		}
		return dtCapaEntidadesBk;
	}

	@Override
	public List<DtCapaEntidadesBk> getAllDtCapaEntidadesActivos(Long kyUsuarioMod) {
		List<DtCapaEntidadesBk> dtCapaEntidadesBkss = new ArrayList<DtCapaEntidadesBk>();
		try {
			List<DtCapaEntidades> dtCapaEntidadess = dtCapaEntidadesDao.getActivasDtCapaEntidades();
			for (DtCapaEntidades dtCapaEntidades : dtCapaEntidadess) {
				DtCapaEntidadesBk dtCapaEntidadesBk = new DtCapaEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesBk, dtCapaEntidades);
				completarDtCapaEntidades(dtCapaEntidadesBk);
				setACLDtCapaEntidadesBk(dtCapaEntidadesBk, kyUsuarioMod);
				dtCapaEntidadesBkss.add(dtCapaEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaEntidadesBkss;
	}

	@Override
	public List<DtCapaEntidadesBk> getAllDtCapaEntidadesActivosCero(Long kyUsuarioMod) {
		List<DtCapaEntidadesBk> dtCapaEntidadesBkss = new ArrayList<DtCapaEntidadesBk>();
		try {
			List<DtCapaEntidades> dtCapaEntidadess = dtCapaEntidadesDao.getActivasDtCapaEntidadesCero();
			for (DtCapaEntidades dtCapaEntidades : dtCapaEntidadess) {
				DtCapaEntidadesBk dtCapaEntidadesBk = new DtCapaEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesBk, dtCapaEntidades);
				completarDtCapaEntidades(dtCapaEntidadesBk);
				setACLDtCapaEntidadesBk(dtCapaEntidadesBk, kyUsuarioMod);
				dtCapaEntidadesBkss.add(dtCapaEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaEntidadesBkss;
	}

	private void completarDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk) {
		try {
			if (dtCapaEntidadesBk.getIdCapacitacion() != null
					&& dtCapaEntidadesBk.getIdCapacitacion().longValue() > 0) {
				DtCapacitacion dtCapacitacion = dtCapacitacionDao
						.getDtCapacitacion(dtCapaEntidadesBk.getIdCapacitacion());
				if (dtCapacitacion != null)
					dtCapaEntidadesBk.setIdCapacitacionTxt(dtCapacitacion.getDetalleCapa());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaEntidadesBk.getIdEntidad() != null && dtCapaEntidadesBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtCapaEntidadesBk.getIdEntidad());
				// MPINARES 14022024 - INICIO
				if (dtEntidades != null) {
					dtCapaEntidadesBk.setIdEntidadTxt(dtEntidades.getRazSocial());
					dtCapaEntidadesBk.setCodEjecutora(dtEntidades.getCodEjec());
				}
				// MPINARES 14022024 - FIN
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtCapaEntidadesBk.getEstado()!=null &&
		// dtCapaEntidadesBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtCapaEntidadesBk.getEstado());
		// if(prtParametros!=null)
		// dtCapaEntidadesBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtCapaEntidadesBk saveorupdateDtCapaEntidadesBk(DtCapaEntidadesBk dtCapaEntidadesBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtCapaEntidadesMng.validarDtCapaEntidadesBk(dtCapaEntidadesBk);

		DtCapaEntidades dtCapaEntidades = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapaEntidadesBk.getIdCapaEnti() != null && dtCapaEntidadesBk.getIdCapaEnti().longValue() > 0) {

				dtCapaEntidades = dtCapaEntidadesDao.getDtCapaEntidades(dtCapaEntidadesBk.getIdCapaEnti());

				boolean cambios = AuditoriaDtCapaEntidadesMng.auditarCambiosDtCapaEntidades(dtCapaEntidadesBk,
						dtCapaEntidades, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapaEntidades.setRtmaddressrst(rmtaddress);
					dtCapaEntidades.setIdusserModif(kyUsuarioMod);
					dtCapaEntidades.setFechaModif(hoy);
					dtCapaEntidadesDao.updateDtCapaEntidades(dtCapaEntidades);
				}
			} else {
				dtCapaEntidadesBk.setRtmaddress(rmtaddress);
				dtCapaEntidadesBk.setRtmaddressrst(rmtaddress);

				dtCapaEntidadesBk.setFechaCrea(hoy);
				dtCapaEntidadesBk.setIdusserCrea(kyUsuarioMod);
				dtCapaEntidadesBk.setIdusserModif(kyUsuarioMod);
				dtCapaEntidadesBk.setFechaModif(hoy);
				dtCapaEntidadesBk.setEstado(Estado.ACTIVO.getValor());

				dtCapaEntidades = new DtCapaEntidades();

				FuncionesStaticas.copyPropertiesObject(dtCapaEntidades, dtCapaEntidadesBk);
				dtCapaEntidadesDao.saveDtCapaEntidades(dtCapaEntidades);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapaEntidades" + " :: " + dtCapaEntidades.getIdCapaEnti().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtCapaEntidadesBk = getDtCapaEntidadesBkXid(dtCapaEntidades.getIdCapaEnti(), kyUsuarioMod);
		return dtCapaEntidadesBk;
	}

	@Override
	public void deleteDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCapaEntidades dtCapaEntidades = null;
			if (dtCapaEntidadesBk.getIdCapaEnti() != null && dtCapaEntidadesBk.getIdCapaEnti().longValue() > 0) {

				dtCapaEntidades = dtCapaEntidadesDao.getDtCapaEntidades(dtCapaEntidadesBk.getIdCapaEnti());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaEntidades.setRtmaddressrst(rmtaddress);
				dtCapaEntidades.setIdusserModif(kyUsuarioMod);
				dtCapaEntidades.setFechaModif(hoy);
				Long estadoanterior = dtCapaEntidades.getEstado();
				dtCapaEntidades.setEstado(Estado.ELIMINADO.getValor());

				dtCapaEntidadesDao.updateDtCapaEntidades(dtCapaEntidades);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaEntidades" + " :: " + dtCapaEntidades.getIdCapaEnti().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCapaEntidades dtCapaEntidades = null;
			if (dtCapaEntidadesBk.getIdCapaEnti() != null && dtCapaEntidadesBk.getIdCapaEnti().longValue() > 0) {

				dtCapaEntidades = dtCapaEntidadesDao.getDtCapaEntidades(dtCapaEntidadesBk.getIdCapaEnti());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaEntidades.setRtmaddressrst(rmtaddress);
				dtCapaEntidades.setIdusserModif(kyUsuarioMod);
				dtCapaEntidades.setFechaModif(hoy);
				Long estadoanterior = dtCapaEntidades.getEstado();
				dtCapaEntidades.setEstado(Estado.ACTIVO.getValor());

				dtCapaEntidadesDao.updateDtCapaEntidades(dtCapaEntidades);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaEntidades" + " :: " + dtCapaEntidades.getIdCapaEnti().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCapaEntidadesBk> getDtCapaEntidadesXFiltro(Long idCapacitacion, Long idEntidad, Long kyUsuarioMod) {
		List<DtCapaEntidadesBk> dtCapaEntidadesBkss = new ArrayList<DtCapaEntidadesBk>();
		try {
			List<DtCapaEntidades> dtCapaEntidadessss = dtCapaEntidadesDao.getXFiltro(idCapacitacion, idEntidad);
			for (DtCapaEntidades dtCapaEntidades : dtCapaEntidadessss) {
				DtCapaEntidadesBk dtCapaEntidadesBk = new DtCapaEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesBk, dtCapaEntidades);
				completarDtCapaEntidades(dtCapaEntidadesBk);
				setACLDtCapaEntidadesBk(dtCapaEntidadesBk, kyUsuarioMod);
				dtCapaEntidadesBkss.add(dtCapaEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaEntidadesBkss;
	}

	@Override
	public List<DtCapaEntidadesBk> getDtCapaEntidadesXFiltro(Long idCapacitacion, Long idEntidad, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtCapaEntidadesBk> dtCapaEntidadesBkss = new ArrayList<DtCapaEntidadesBk>();
		try {
			List<DtCapaEntidades> dtCapaEntidadessss = dtCapaEntidadesDao.getXFiltro(idCapacitacion, idEntidad, inicial,
					MAX);
			for (DtCapaEntidades dtCapaEntidades : dtCapaEntidadessss) {
				DtCapaEntidadesBk dtCapaEntidadesBk = new DtCapaEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesBk, dtCapaEntidades);
				completarDtCapaEntidades(dtCapaEntidadesBk);
				setACLDtCapaEntidadesBk(dtCapaEntidadesBk, kyUsuarioMod);
				dtCapaEntidadesBkss.add(dtCapaEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaEntidadesBkss;
	}

	@Override
	public Long getDtCapaEntidadesTotalXFiltro(Long idCapacitacion, Long idEntidad, Long kyUsuarioMod) {
		try {
			Long totalDtCapaEntidadessss = dtCapaEntidadesDao.getTotalXFiltro(idCapacitacion, idEntidad);

			return totalDtCapaEntidadessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCapaEntidadesBk(DtCapaEntidadesBk dtCapaEntidadesBk, Long kyUsuarioMod) {
		DtCapaEntidadesACL dtCapaEntidadesACL = new DtCapaEntidadesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAENTIDADES_CREA)) {
					dtCapaEntidadesACL.setEsEditable(true);
					dtCapaEntidadesACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCAPAENTIDADES_VE)) {
					dtCapaEntidadesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAENTIDADES_CREA)) {
					dtCapaEntidadesACL.setEditopcion(1);
				} else {
					dtCapaEntidadesACL.setEditopcion(2);
				}
			} else {
				dtCapaEntidadesACL.setEditopcion(2);
			}
		} else {
			dtCapaEntidadesACL.setEditopcion(2);
		}
		dtCapaEntidadesBk.setDtCapaEntidadesACL(dtCapaEntidadesACL);
	}

	/// ADICIONALES

	@Override
	public List<DtEntidadesDto> getDtEntidadesCache() {
		if (dtEntidadesListaCache == null) {
			List<DtEntidades> dtEntidadessss = dtEntidadesDao.getActivasDtEntidades();
			dtEntidadesListaCache = new ArrayList<DtEntidadesDto>();
			for (DtEntidades dtEntidades : dtEntidadessss) {
				DtEntidadesDto dtEntidadesDto = new DtEntidadesDto();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesDto, dtEntidades);
				dtEntidadesListaCache.add(dtEntidadesDto);
			}
		}
		return dtEntidadesListaCache;
	}

	/**
	 * DT_CAPA_PUBLICO SERVICIO: LISTA DE LOS TIPOS DE PUBLICO OBJETIVO POR
	 * CAPACITACIÓN
	 */
	@Override
	public DtCapaPublicoBk getDtCapaPublicoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCapaPublico dtCapaPublico = dtCapaPublicoDao.getDtCapaPublico(id);
		DtCapaPublicoBk dtCapaPublicoBk = null;
		if (dtCapaPublico != null) {
			dtCapaPublicoBk = new DtCapaPublicoBk();
			FuncionesStaticas.copyPropertiesObject(dtCapaPublicoBk, dtCapaPublico);
			completarDtCapaPublico(dtCapaPublicoBk);
			if (kyUsuarioMod != null)
				setACLDtCapaPublicoBk(dtCapaPublicoBk, kyUsuarioMod);
		}
		return dtCapaPublicoBk;
	}

	@Override
	public List<DtCapaPublicoBk> getAllDtCapaPublicoActivos(Long kyUsuarioMod) {
		List<DtCapaPublicoBk> dtCapaPublicoBkss = new ArrayList<DtCapaPublicoBk>();
		try {
			List<DtCapaPublico> dtCapaPublicos = dtCapaPublicoDao.getActivasDtCapaPublico();
			for (DtCapaPublico dtCapaPublico : dtCapaPublicos) {
				DtCapaPublicoBk dtCapaPublicoBk = new DtCapaPublicoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaPublicoBk, dtCapaPublico);
				completarDtCapaPublico(dtCapaPublicoBk);
				setACLDtCapaPublicoBk(dtCapaPublicoBk, kyUsuarioMod);
				dtCapaPublicoBkss.add(dtCapaPublicoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaPublicoBkss;
	}

	@Override
	public List<DtCapaPublicoBk> getAllDtCapaPublicoActivosCero(Long kyUsuarioMod) {
		List<DtCapaPublicoBk> dtCapaPublicoBkss = new ArrayList<DtCapaPublicoBk>();
		try {
			List<DtCapaPublico> dtCapaPublicos = dtCapaPublicoDao.getActivasDtCapaPublicoCero();
			for (DtCapaPublico dtCapaPublico : dtCapaPublicos) {
				DtCapaPublicoBk dtCapaPublicoBk = new DtCapaPublicoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaPublicoBk, dtCapaPublico);
				completarDtCapaPublico(dtCapaPublicoBk);
				setACLDtCapaPublicoBk(dtCapaPublicoBk, kyUsuarioMod);
				dtCapaPublicoBkss.add(dtCapaPublicoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaPublicoBkss;
	}

	private void completarDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk) {
		try {
			if (dtCapaPublicoBk.getIdCapacitacion() != null && dtCapaPublicoBk.getIdCapacitacion().longValue() > 0) {
				DtCapacitacion dtCapacitacion = dtCapacitacionDao
						.getDtCapacitacion(dtCapaPublicoBk.getIdCapacitacion());
				if (dtCapacitacion != null)
					dtCapaPublicoBk.setIdCapacitacionTxt(dtCapacitacion.getDetalleCapa());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaPublicoBk.getIdCargo() != null && dtCapaPublicoBk.getIdCargo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapaPublicoBk.getIdCargo());
				if (prtParametros != null)
					dtCapaPublicoBk.setIdCargoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtCapaPublicoBk.getEstado()!=null &&
		// dtCapaPublicoBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtCapaPublicoBk.getEstado());
		// if(prtParametros!=null)
		// dtCapaPublicoBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtCapaPublicoBk saveorupdateDtCapaPublicoBk(DtCapaPublicoBk dtCapaPublicoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtCapaPublicoMng.validarDtCapaPublicoBk(dtCapaPublicoBk);

		DtCapaPublico dtCapaPublico = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapaPublicoBk.getIdCapaPublico() != null && dtCapaPublicoBk.getIdCapaPublico().longValue() > 0) {

				dtCapaPublico = dtCapaPublicoDao.getDtCapaPublico(dtCapaPublicoBk.getIdCapaPublico());

				boolean cambios = AuditoriaDtCapaPublicoMng.auditarCambiosDtCapaPublico(dtCapaPublicoBk, dtCapaPublico,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapaPublico.setRtmaddressrst(rmtaddress);
					dtCapaPublico.setIduserModif(kyUsuarioMod);
					dtCapaPublico.setFechaModif(hoy);
					dtCapaPublicoDao.updateDtCapaPublico(dtCapaPublico);
				}
			} else {
				dtCapaPublicoBk.setRtmaddress(rmtaddress);
				dtCapaPublicoBk.setRtmaddressrst(rmtaddress);

				dtCapaPublicoBk.setFechaCrea(hoy);
				dtCapaPublicoBk.setIduserCrea(kyUsuarioMod);
				dtCapaPublicoBk.setIduserModif(kyUsuarioMod);
				dtCapaPublicoBk.setFechaModif(hoy);
				dtCapaPublicoBk.setEstado(Estado.ACTIVO.getValor());

				dtCapaPublico = new DtCapaPublico();

				FuncionesStaticas.copyPropertiesObject(dtCapaPublico, dtCapaPublicoBk);
				dtCapaPublicoDao.saveDtCapaPublico(dtCapaPublico);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapaPublico" + " :: " + dtCapaPublico.getIdCapaPublico().toString() + " :: "
								+ "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtCapaPublicoBk = getDtCapaPublicoBkXid(dtCapaPublico.getIdCapaPublico(), kyUsuarioMod);
		return dtCapaPublicoBk;
	}

	@Override
	public void deleteDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapaPublico dtCapaPublico = null;
			if (dtCapaPublicoBk.getIdCapaPublico() != null && dtCapaPublicoBk.getIdCapaPublico().longValue() > 0) {

				dtCapaPublico = dtCapaPublicoDao.getDtCapaPublico(dtCapaPublicoBk.getIdCapaPublico());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaPublico.setRtmaddressrst(rmtaddress);
				dtCapaPublico.setIduserModif(kyUsuarioMod);
				dtCapaPublico.setFechaModif(hoy);
				Long estadoanterior = dtCapaPublico.getEstado();
				dtCapaPublico.setEstado(Estado.ELIMINADO.getValor());

				dtCapaPublicoDao.updateDtCapaPublico(dtCapaPublico);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaPublico" + " :: " + dtCapaPublico.getIdCapaPublico().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapaPublico dtCapaPublico = null;
			if (dtCapaPublicoBk.getIdCapaPublico() != null && dtCapaPublicoBk.getIdCapaPublico().longValue() > 0) {

				dtCapaPublico = dtCapaPublicoDao.getDtCapaPublico(dtCapaPublicoBk.getIdCapaPublico());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaPublico.setRtmaddressrst(rmtaddress);
				dtCapaPublico.setIduserModif(kyUsuarioMod);
				dtCapaPublico.setFechaModif(hoy);
				Long estadoanterior = dtCapaPublico.getEstado();
				dtCapaPublico.setEstado(Estado.ACTIVO.getValor());

				dtCapaPublicoDao.updateDtCapaPublico(dtCapaPublico);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaPublico" + " :: " + dtCapaPublico.getIdCapaPublico().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCapaPublicoBk> getDtCapaPublicoXFiltro(Long idCapacitacion, Long kyUsuarioMod) {
		List<DtCapaPublicoBk> dtCapaPublicoBkss = new ArrayList<DtCapaPublicoBk>();
		try {
			List<DtCapaPublico> dtCapaPublicosss = dtCapaPublicoDao.getXFiltro(idCapacitacion);
			for (DtCapaPublico dtCapaPublico : dtCapaPublicosss) {
				DtCapaPublicoBk dtCapaPublicoBk = new DtCapaPublicoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaPublicoBk, dtCapaPublico);
				completarDtCapaPublico(dtCapaPublicoBk);
				setACLDtCapaPublicoBk(dtCapaPublicoBk, kyUsuarioMod);
				dtCapaPublicoBkss.add(dtCapaPublicoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaPublicoBkss;
	}

	@Override
	public List<DtCapaPublicoBk> getDtCapaPublicoXFiltro(Long idCapacitacion, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtCapaPublicoBk> dtCapaPublicoBkss = new ArrayList<DtCapaPublicoBk>();
		try {
			List<DtCapaPublico> dtCapaPublicosss = dtCapaPublicoDao.getXFiltro(idCapacitacion, inicial, MAX);
			for (DtCapaPublico dtCapaPublico : dtCapaPublicosss) {
				DtCapaPublicoBk dtCapaPublicoBk = new DtCapaPublicoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaPublicoBk, dtCapaPublico);
				completarDtCapaPublico(dtCapaPublicoBk);
				setACLDtCapaPublicoBk(dtCapaPublicoBk, kyUsuarioMod);
				dtCapaPublicoBkss.add(dtCapaPublicoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaPublicoBkss;
	}

	@Override
	public Long getDtCapaPublicoTotalXFiltro(Long idCapacitacion, Long kyUsuarioMod) {
		try {
			Long totalDtCapaPublicosss = dtCapaPublicoDao.getTotalXFiltro(idCapacitacion);

			return totalDtCapaPublicosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCapaPublicoBk(DtCapaPublicoBk dtCapaPublicoBk, Long kyUsuarioMod) {
		DtCapaPublicoACL dtCapaPublicoACL = new DtCapaPublicoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAPUBLICO_CREA)) {
					dtCapaPublicoACL.setEsEditable(true);
					dtCapaPublicoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCAPAPUBLICO_VE)) {
					dtCapaPublicoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAPUBLICO_CREA)) {
					dtCapaPublicoACL.setEditopcion(1);
				} else {
					dtCapaPublicoACL.setEditopcion(2);
				}
			} else {
				dtCapaPublicoACL.setEditopcion(2);
			}
		} else {
			dtCapaPublicoACL.setEditopcion(2);
		}
		dtCapaPublicoBk.setDtCapaPublicoACL(dtCapaPublicoACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdCargo() {
		if (prtParametrosIdparametroIdCargoListaCache == null) {
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("CARGO DE USUARIO EXTERNO");
			prtParametrosIdparametroIdCargoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdCargoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdCargoListaCache;
	}

	/**
	 * ADICIONAR EN EL msTemaDao
	 * 
	 **/
	@Override
	public List<IDValorDto> getMsTemaIdTemaIdTema() {
		if (msTemaIdTemaIdTemaListaCache == null) {
			List<MsTema> msTemasss = msTemaDao.getListaIdTema();
			msTemaIdTemaIdTemaListaCache = new ArrayList<IDValorDto>();
			for (MsTema msTema : msTemasss) {
				IDValorDto idTemaDto = new IDValorDto(msTema.getIdTema(), msTema.getDescripcion());
				msTemaIdTemaIdTemaListaCache.add(idTemaDto);
			}
		}
		return msTemaIdTemaIdTemaListaCache;
	}

	/**
	 * MS_PAISES SERVICIO: LISTA DE LOS PAÍSES REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public MsPaisesBk getMsPaisesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsPaises msPaises = msPaisesDao.getMsPaises(id);
		MsPaisesBk msPaisesBk = null;
		if (msPaises != null) {
			msPaisesBk = new MsPaisesBk();
			FuncionesStaticas.copyPropertiesObject(msPaisesBk, msPaises);
			completarMsPaises(msPaisesBk);
			if (kyUsuarioMod != null)
				setACLMsPaisesBk(msPaisesBk, kyUsuarioMod);
		}
		return msPaisesBk;
	}

	@Override
	public List<MsPaisesBk> getAllMsPaisesActivos(Long kyUsuarioMod) {
		List<MsPaisesBk> msPaisesBkss = new ArrayList<MsPaisesBk>();
		try {
			List<MsPaises> msPaisess = msPaisesDao.getActivasMsPaises();
			for (MsPaises msPaises : msPaisess) {
				MsPaisesBk msPaisesBk = new MsPaisesBk();
				FuncionesStaticas.copyPropertiesObject(msPaisesBk, msPaises);
				completarMsPaises(msPaisesBk);
				setACLMsPaisesBk(msPaisesBk, kyUsuarioMod);
				msPaisesBkss.add(msPaisesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msPaisesBkss;
	}

	@Override
	public List<MsPaisesBk> getAllMsPaisesActivosCero(Long kyUsuarioMod) {
		List<MsPaisesBk> msPaisesBkss = new ArrayList<MsPaisesBk>();
		try {
			List<MsPaises> msPaisess = msPaisesDao.getActivasMsPaisesCero();
			for (MsPaises msPaises : msPaisess) {
				MsPaisesBk msPaisesBk = new MsPaisesBk();
				FuncionesStaticas.copyPropertiesObject(msPaisesBk, msPaises);
				completarMsPaises(msPaisesBk);
				setACLMsPaisesBk(msPaisesBk, kyUsuarioMod);
				msPaisesBkss.add(msPaisesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msPaisesBkss;
	}

	private void completarMsPaises(MsPaisesBk msPaisesBk) {
		// try{
		// if(msPaisesBk.getEstado()!=null &&
		// msPaisesBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msPaisesBk.getEstado());
		// if(prtParametros!=null)
		// msPaisesBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsPaisesBk saveorupdateMsPaisesBk(MsPaisesBk msPaisesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsPaisesMng.validarMsPaisesBk(msPaisesBk);

		MsPaises msPaises = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msPaisesBk.getIdpais() != null && msPaisesBk.getIdpais().longValue() > 0) {

				msPaises = msPaisesDao.getMsPaises(msPaisesBk.getIdpais());

				boolean cambios = AuditoriaMsPaisesMng.auditarCambiosMsPaises(msPaisesBk, msPaises, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msPaises.setRtmaddressrst(rmtaddress);
					msPaises.setIdusserModif(kyUsuarioMod);
					msPaises.setFechaModif(hoy);
					msPaisesDao.updateMsPaises(msPaises);
				}
			} else {
				msPaisesBk.setRtmaddress(rmtaddress);
				msPaisesBk.setRtmaddressrst(rmtaddress);

				msPaisesBk.setFechaCrea(hoy);
				msPaisesBk.setIdusserCrea(kyUsuarioMod);
				msPaisesBk.setIdusserModif(kyUsuarioMod);
				msPaisesBk.setFechaModif(hoy);
				msPaisesBk.setEstado(Estado.ACTIVO.getValor());

				msPaises = new MsPaises();

				FuncionesStaticas.copyPropertiesObject(msPaises, msPaisesBk);
				msPaisesDao.saveMsPaises(msPaises);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msPaises" + " :: " + msPaises.getIdpais().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msPaisesBk = getMsPaisesBkXid(msPaises.getIdpais(), kyUsuarioMod);
		return msPaisesBk;
	}

	@Override
	public void deleteMsPaises(MsPaisesBk msPaisesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsPaises msPaises = null;
			if (msPaisesBk.getIdpais() != null && msPaisesBk.getIdpais().longValue() > 0) {

				msPaises = msPaisesDao.getMsPaises(msPaisesBk.getIdpais());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msPaises.setRtmaddressrst(rmtaddress);
				msPaises.setIdusserModif(kyUsuarioMod);
				msPaises.setFechaModif(hoy);
				Long estadoanterior = msPaises.getEstado();
				msPaises.setEstado(Estado.ELIMINADO.getValor());

				msPaisesDao.updateMsPaises(msPaises);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msPaises" + " :: " + msPaises.getIdpais().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsPaises(MsPaisesBk msPaisesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsPaises msPaises = null;
			if (msPaisesBk.getIdpais() != null && msPaisesBk.getIdpais().longValue() > 0) {

				msPaises = msPaisesDao.getMsPaises(msPaisesBk.getIdpais());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msPaises.setRtmaddressrst(rmtaddress);
				msPaises.setIdusserModif(kyUsuarioMod);
				msPaises.setFechaModif(hoy);
				Long estadoanterior = msPaises.getEstado();
				msPaises.setEstado(Estado.ACTIVO.getValor());

				msPaisesDao.updateMsPaises(msPaises);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msPaises" + " :: " + msPaises.getIdpais().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsPaisesBk> getMsPaisesXFiltro(String paisNombre, String acronimo, Long estado, Long kyUsuarioMod) {
		List<MsPaisesBk> msPaisesBkss = new ArrayList<MsPaisesBk>();
		try {
			List<MsPaises> msPaisessss = msPaisesDao.getXFiltro(paisNombre, acronimo, estado);
			for (MsPaises msPaises : msPaisessss) {
				MsPaisesBk msPaisesBk = new MsPaisesBk();
				FuncionesStaticas.copyPropertiesObject(msPaisesBk, msPaises);
				completarMsPaises(msPaisesBk);
				setACLMsPaisesBk(msPaisesBk, kyUsuarioMod);
				msPaisesBkss.add(msPaisesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msPaisesBkss;
	}

	@Override
	public List<MsPaisesBk> getMsPaisesXFiltro(String paisNombre, String acronimo, Long estado, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<MsPaisesBk> msPaisesBkss = new ArrayList<MsPaisesBk>();
		try {
			List<MsPaises> msPaisessss = msPaisesDao.getXFiltro(paisNombre, acronimo, estado, inicial, MAX);
			for (MsPaises msPaises : msPaisessss) {
				MsPaisesBk msPaisesBk = new MsPaisesBk();
				FuncionesStaticas.copyPropertiesObject(msPaisesBk, msPaises);
				completarMsPaises(msPaisesBk);
				setACLMsPaisesBk(msPaisesBk, kyUsuarioMod);
				msPaisesBkss.add(msPaisesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msPaisesBkss;
	}

	@Override
	public Long getMsPaisesTotalXFiltro(String paisNombre, String acronimo, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsPaisessss = msPaisesDao.getTotalXFiltro(paisNombre, acronimo, estado);

			return totalMsPaisessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsPaisesBk(MsPaisesBk msPaisesBk, Long kyUsuarioMod) {
		MsPaisesACL msPaisesACL = new MsPaisesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSPAISES_CREA)) {
					msPaisesACL.setEsEditable(true);
					msPaisesACL.setEliminar(true);
				} else if (roles.contains(Roles.MSPAISES_VE)) {
					msPaisesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSPAISES_CREA)) {
					msPaisesACL.setEditopcion(1);
				} else {
					msPaisesACL.setEditopcion(2);
				}
			} else {
				msPaisesACL.setEditopcion(2);
			}
		} else {
			msPaisesACL.setEditopcion(2);
		}
		msPaisesBk.setMsPaisesACL(msPaisesACL);
	}

	/// ADICIONALES

	/**
	 * DT_CONSULTAS_PROYECTO SERVICIO: LISTA DE LOS DISTINTOS PROYECTOS DE
	 * INVERSIÓN RELACIONADOS A LAS CONSULTAS
	 */
	@Override
	public DtConsultasProyectoBk getDtConsultasProyectoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtConsultasProyecto dtConsultasProyecto = dtConsultasProyectoDao.getDtConsultasProyecto(id);
		DtConsultasProyectoBk dtConsultasProyectoBk = null;
		if (dtConsultasProyecto != null) {
			dtConsultasProyectoBk = new DtConsultasProyectoBk();
			FuncionesStaticas.copyPropertiesObject(dtConsultasProyectoBk, dtConsultasProyecto);
			completarDtConsultasProyecto(dtConsultasProyectoBk);
			if (kyUsuarioMod != null)
				setACLDtConsultasProyectoBk(dtConsultasProyectoBk, kyUsuarioMod);
		}
		return dtConsultasProyectoBk;
	}

	@Override
	public List<DtConsultasProyectoBk> getAllDtConsultasProyectoActivos(Long kyUsuarioMod) {
		List<DtConsultasProyectoBk> dtConsultasProyectoBkss = new ArrayList<DtConsultasProyectoBk>();
		try {
			List<DtConsultasProyecto> dtConsultasProyectos = dtConsultasProyectoDao.getActivasDtConsultasProyecto();
			for (DtConsultasProyecto dtConsultasProyecto : dtConsultasProyectos) {
				DtConsultasProyectoBk dtConsultasProyectoBk = new DtConsultasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasProyectoBk, dtConsultasProyecto);
				completarDtConsultasProyecto(dtConsultasProyectoBk);
				setACLDtConsultasProyectoBk(dtConsultasProyectoBk, kyUsuarioMod);
				dtConsultasProyectoBkss.add(dtConsultasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasProyectoBkss;
	}

	@Override
	public List<DtConsultasProyectoBk> getAllDtConsultasProyectoActivosCero(Long kyUsuarioMod) {
		List<DtConsultasProyectoBk> dtConsultasProyectoBkss = new ArrayList<DtConsultasProyectoBk>();
		try {
			List<DtConsultasProyecto> dtConsultasProyectos = dtConsultasProyectoDao.getActivasDtConsultasProyectoCero();
			for (DtConsultasProyecto dtConsultasProyecto : dtConsultasProyectos) {
				DtConsultasProyectoBk dtConsultasProyectoBk = new DtConsultasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasProyectoBk, dtConsultasProyecto);
				completarDtConsultasProyecto(dtConsultasProyectoBk);
				setACLDtConsultasProyectoBk(dtConsultasProyectoBk, kyUsuarioMod);
				dtConsultasProyectoBkss.add(dtConsultasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasProyectoBkss;
	}

	private void completarDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk) {
		try {
			if (dtConsultasProyectoBk.getIdConsulta() != null
					&& dtConsultasProyectoBk.getIdConsulta().longValue() > 0) {
				DtConsultas dtConsultas = dtConsultasDao.getDtConsultas(dtConsultasProyectoBk.getIdConsulta());
				if (dtConsultas != null)
					dtConsultasProyectoBk.setIdConsultaTxt(dtConsultas.getDetalle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasProyectoBk.getIdProyecto() != null
					&& dtConsultasProyectoBk.getIdProyecto().longValue() > 0) {
				MsProyectoInversion msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(dtConsultasProyectoBk.getIdProyecto());
				if (msProyectoInversion != null)
					dtConsultasProyectoBk.setIdProyectoTxt(msProyectoInversion.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtConsultasProyectoBk.getEstado()!=null &&
		// dtConsultasProyectoBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtConsultasProyectoBk.getEstado());
		// if(prtParametros!=null)
		// dtConsultasProyectoBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtConsultasProyectoBk saveorupdateDtConsultasProyectoBk(DtConsultasProyectoBk dtConsultasProyectoBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtConsultasProyectoMng.validarDtConsultasProyectoBk(dtConsultasProyectoBk);

		DtConsultasProyecto dtConsultasProyecto = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtConsultasProyectoBk.getIdConsProyecto() != null
					&& dtConsultasProyectoBk.getIdConsProyecto().longValue() > 0) {

				dtConsultasProyecto = dtConsultasProyectoDao
						.getDtConsultasProyecto(dtConsultasProyectoBk.getIdConsProyecto());

				boolean cambios = AuditoriaDtConsultasProyectoMng.auditarCambiosDtConsultasProyecto(
						dtConsultasProyectoBk, dtConsultasProyecto, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtConsultasProyecto.setRtmaddressrst(rmtaddress);
					dtConsultasProyecto.setIdusserModif(kyUsuarioMod);
					dtConsultasProyecto.setFechaModif(hoy);
					dtConsultasProyectoDao.updateDtConsultasProyecto(dtConsultasProyecto);
				}
			} else {
				dtConsultasProyectoBk.setRtmaddress(rmtaddress);
				dtConsultasProyectoBk.setRtmaddressrst(rmtaddress);

				dtConsultasProyectoBk.setFechaCrea(hoy);
				dtConsultasProyectoBk.setIdusserCrea(kyUsuarioMod);
				dtConsultasProyectoBk.setIdusserModif(kyUsuarioMod);
				dtConsultasProyectoBk.setFechaModif(hoy);
				dtConsultasProyectoBk.setEstado(Estado.ACTIVO.getValor());

				dtConsultasProyecto = new DtConsultasProyecto();

				FuncionesStaticas.copyPropertiesObject(dtConsultasProyecto, dtConsultasProyectoBk);
				dtConsultasProyectoDao.saveDtConsultasProyecto(dtConsultasProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtConsultasProyecto" + " :: "
								+ dtConsultasProyecto.getIdConsProyecto().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtConsultasProyectoBk = getDtConsultasProyectoBkXid(dtConsultasProyecto.getIdConsProyecto(), kyUsuarioMod);
		return dtConsultasProyectoBk;
	}

	@Override
	public void deleteDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtConsultasProyecto dtConsultasProyecto = null;
			if (dtConsultasProyectoBk.getIdConsProyecto() != null
					&& dtConsultasProyectoBk.getIdConsProyecto().longValue() > 0) {

				dtConsultasProyecto = dtConsultasProyectoDao
						.getDtConsultasProyecto(dtConsultasProyectoBk.getIdConsProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtConsultasProyecto.setRtmaddressrst(rmtaddress);
				dtConsultasProyecto.setIdusserModif(kyUsuarioMod);
				dtConsultasProyecto.setFechaModif(hoy);
				Long estadoanterior = dtConsultasProyecto.getEstado();
				dtConsultasProyecto.setEstado(Estado.ELIMINADO.getValor());

				dtConsultasProyectoDao.updateDtConsultasProyecto(dtConsultasProyecto);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtConsultasProyecto" + " :: " + dtConsultasProyecto.getIdConsProyecto().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtConsultasProyecto dtConsultasProyecto = null;
			if (dtConsultasProyectoBk.getIdConsProyecto() != null
					&& dtConsultasProyectoBk.getIdConsProyecto().longValue() > 0) {

				dtConsultasProyecto = dtConsultasProyectoDao
						.getDtConsultasProyecto(dtConsultasProyectoBk.getIdConsProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtConsultasProyecto.setRtmaddressrst(rmtaddress);
				dtConsultasProyecto.setIdusserModif(kyUsuarioMod);
				dtConsultasProyecto.setFechaModif(hoy);
				Long estadoanterior = dtConsultasProyecto.getEstado();
				dtConsultasProyecto.setEstado(Estado.ACTIVO.getValor());

				dtConsultasProyectoDao.updateDtConsultasProyecto(dtConsultasProyecto);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtConsultasProyecto" + " :: " + dtConsultasProyecto.getIdConsProyecto().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtConsultasProyectoBk> getDtConsultasProyectoXFiltro(Long idConsulta, Long idProyecto, String detalle,
			Long kyUsuarioMod) {
		List<DtConsultasProyectoBk> dtConsultasProyectoBkss = new ArrayList<DtConsultasProyectoBk>();
		try {
			List<DtConsultasProyecto> dtConsultasProyectosss = dtConsultasProyectoDao.getXFiltro(idConsulta, idProyecto,
					detalle);
			for (DtConsultasProyecto dtConsultasProyecto : dtConsultasProyectosss) {
				DtConsultasProyectoBk dtConsultasProyectoBk = new DtConsultasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasProyectoBk, dtConsultasProyecto);
				completarDtConsultasProyecto(dtConsultasProyectoBk);
				setACLDtConsultasProyectoBk(dtConsultasProyectoBk, kyUsuarioMod);
				dtConsultasProyectoBkss.add(dtConsultasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasProyectoBkss;
	}

	@Override
	public List<DtConsultasProyectoBk> getDtConsultasProyectoXFiltro(Long idConsulta, Long idProyecto, String detalle,
			int inicial, int MAX, Long kyUsuarioMod) {
		List<DtConsultasProyectoBk> dtConsultasProyectoBkss = new ArrayList<DtConsultasProyectoBk>();
		try {
			List<DtConsultasProyecto> dtConsultasProyectosss = dtConsultasProyectoDao.getXFiltro(idConsulta, idProyecto,
					detalle, inicial, MAX);
			for (DtConsultasProyecto dtConsultasProyecto : dtConsultasProyectosss) {
				DtConsultasProyectoBk dtConsultasProyectoBk = new DtConsultasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasProyectoBk, dtConsultasProyecto);
				completarDtConsultasProyecto(dtConsultasProyectoBk);
				setACLDtConsultasProyectoBk(dtConsultasProyectoBk, kyUsuarioMod);
				dtConsultasProyectoBkss.add(dtConsultasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasProyectoBkss;
	}

	@Override
	public Long getDtConsultasProyectoTotalXFiltro(Long idConsulta, Long idProyecto, String detalle,
			Long kyUsuarioMod) {
		try {
			Long totalDtConsultasProyectosss = dtConsultasProyectoDao.getTotalXFiltro(idConsulta, idProyecto, detalle);

			return totalDtConsultasProyectosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtConsultasProyectoBk(DtConsultasProyectoBk dtConsultasProyectoBk, Long kyUsuarioMod) {
		DtConsultasProyectoACL dtConsultasProyectoACL = new DtConsultasProyectoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCONSULTASPROYECTO_CREA)) {
					dtConsultasProyectoACL.setEsEditable(true);
					dtConsultasProyectoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCONSULTASPROYECTO_VE)) {
					dtConsultasProyectoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCONSULTASPROYECTO_CREA)) {
					dtConsultasProyectoACL.setEditopcion(1);
				} else {
					dtConsultasProyectoACL.setEditopcion(2);
				}
			} else {
				dtConsultasProyectoACL.setEditopcion(2);
			}
		} else {
			dtConsultasProyectoACL.setEditopcion(2);
		}
		dtConsultasProyectoBk.setDtConsultasProyectoACL(dtConsultasProyectoACL);
	}

	/// ADICIONALES

	@Override
	public List<MsProyectoInversionDto> getMsProyectoInversionCache() {
		if (msProyectoInversionListaCache == null) {
			List<MsProyectoInversion> msProyectoInversionsss = msProyectoInversionDao.getActivasMsProyectoInversion();
			msProyectoInversionListaCache = new ArrayList<MsProyectoInversionDto>();
			for (MsProyectoInversion msProyectoInversion : msProyectoInversionsss) {
				MsProyectoInversionDto msProyectoInversionDto = new MsProyectoInversionDto();
				FuncionesStaticas.copyPropertiesObject(msProyectoInversionDto, msProyectoInversion);
				msProyectoInversionListaCache.add(msProyectoInversionDto);
			}
		}
		return msProyectoInversionListaCache;
	}

	/**
	 * DT_VISITAS_USUINTERNOS SERVICIO: LISTA DE LOS PARTICIPANTES DE LA VISITA
	 */
	@Override
	public DtVisitasUsuinternosBk getDtVisitasUsuinternosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtVisitasUsuinternos dtVisitasUsuinternos = dtVisitasUsuinternosDao.getDtVisitasUsuinternos(id);
		DtVisitasUsuinternosBk dtVisitasUsuinternosBk = null;
		if (dtVisitasUsuinternos != null) {
			dtVisitasUsuinternosBk = new DtVisitasUsuinternosBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternosBk, dtVisitasUsuinternos);
			completarDtVisitasUsuinternos(dtVisitasUsuinternosBk);
			if (kyUsuarioMod != null)
				setACLDtVisitasUsuinternosBk(dtVisitasUsuinternosBk, kyUsuarioMod);
		}
		return dtVisitasUsuinternosBk;
	}

	@Override
	public List<DtVisitasUsuinternosBk> getAllDtVisitasUsuinternosActivos(Long kyUsuarioMod) {
		List<DtVisitasUsuinternosBk> dtVisitasUsuinternosBkss = new ArrayList<DtVisitasUsuinternosBk>();
		try {
			List<DtVisitasUsuinternos> dtVisitasUsuinternoss = dtVisitasUsuinternosDao.getActivasDtVisitasUsuinternos();
			for (DtVisitasUsuinternos dtVisitasUsuinternos : dtVisitasUsuinternoss) {
				DtVisitasUsuinternosBk dtVisitasUsuinternosBk = new DtVisitasUsuinternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternosBk, dtVisitasUsuinternos);
				completarDtVisitasUsuinternos(dtVisitasUsuinternosBk);
				setACLDtVisitasUsuinternosBk(dtVisitasUsuinternosBk, kyUsuarioMod);
				dtVisitasUsuinternosBkss.add(dtVisitasUsuinternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuinternosBkss;
	}

	@Override
	public List<DtVisitasUsuinternosBk> getAllDtVisitasUsuinternosActivosCero(Long kyUsuarioMod) {
		List<DtVisitasUsuinternosBk> dtVisitasUsuinternosBkss = new ArrayList<DtVisitasUsuinternosBk>();
		try {
			List<DtVisitasUsuinternos> dtVisitasUsuinternoss = dtVisitasUsuinternosDao
					.getActivasDtVisitasUsuinternosCero();
			for (DtVisitasUsuinternos dtVisitasUsuinternos : dtVisitasUsuinternoss) {
				DtVisitasUsuinternosBk dtVisitasUsuinternosBk = new DtVisitasUsuinternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternosBk, dtVisitasUsuinternos);
				completarDtVisitasUsuinternos(dtVisitasUsuinternosBk);
				setACLDtVisitasUsuinternosBk(dtVisitasUsuinternosBk, kyUsuarioMod);
				dtVisitasUsuinternosBkss.add(dtVisitasUsuinternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuinternosBkss;
	}

	// private void completarDtVisitasUsuinternos(DtVisitasUsuinternosBk
	// dtVisitasUsuinternosBk){
	// try{
	// if(dtVisitasUsuinternosBk.getIdVisita()!=null &&
	// dtVisitasUsuinternosBk.getIdVisita().longValue()>0){
	// DtVisitas dtVisitas =
	// dtVisitasDao.getDtVisitas(dtVisitasUsuinternosBk.getIdVisita());
	// if(dtVisitas!=null)
	// dtVisitasUsuinternosBk.setIdVisitaTxt(dtVisitas.getConclusion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }try{
	// if(dtVisitasUsuinternosBk.getIdUsuinterno()!=null &&
	// dtVisitasUsuinternosBk.getIdUsuinterno().longValue()>0){
	// MsUsuarios msUsuarios =
	// msUsuariosDao.getMsUsuarios(dtVisitasUsuinternosBk.getIdUsuinterno());
	// if(msUsuarios!=null)
	// dtVisitasUsuinternosBk.setIdUsuinternoTxt(msUsuarios.getNombres());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//// try{
	//// if(dtVisitasUsuinternosBk.getEstado()!=null &&
	// dtVisitasUsuinternosBk.getEstado().longValue()>0){
	//// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasUsuinternosBk.getEstado());
	//// if(prtParametros!=null)
	//// dtVisitasUsuinternosBk.setEstadoTxt(prtParametros.getDescripcion());
	//// }
	//// } catch (Exception e) {
	//// e.printStackTrace();
	//// }
	// try{
	// if(dtVisitasUsuinternosBk.getIdTema()!=null &&
	// dtVisitasUsuinternosBk.getIdTema().longValue()>0){
	// MsTema msTema = msTemaDao.getMsTema(dtVisitasUsuinternosBk.getIdTema());
	// if(msTema!=null)
	// dtVisitasUsuinternosBk.setIdTemaTxt(msTema.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	//
	// }

	@Override
	public DtVisitasUsuinternosBk saveorupdateDtVisitasUsuinternosBk(DtVisitasUsuinternosBk dtVisitasUsuinternosBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtVisitasUsuinternosMng.validarDtVisitasUsuinternosBk(dtVisitasUsuinternosBk);

		DtVisitasUsuinternos dtVisitasUsuinternos = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasUsuinternosBk.getIdVisitUsuint() != null
					&& dtVisitasUsuinternosBk.getIdVisitUsuint().longValue() > 0) {

				dtVisitasUsuinternos = dtVisitasUsuinternosDao
						.getDtVisitasUsuinternos(dtVisitasUsuinternosBk.getIdVisitUsuint());

				boolean cambios = AuditoriaDtVisitasUsuinternosMng.auditarCambiosDtVisitasUsuinternos(
						dtVisitasUsuinternosBk, dtVisitasUsuinternos, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtVisitasUsuinternos.setRtmaddressrst(rmtaddress);
					dtVisitasUsuinternos.setIdusserModif(kyUsuarioMod);
					dtVisitasUsuinternos.setFechaModif(hoy);
					dtVisitasUsuinternosDao.updateDtVisitasUsuinternos(dtVisitasUsuinternos);
				}
			} else {
				// PURIBE 22032024 - INICIO-->
				if (dtVisitasUsuinternosBk.getEstado() == Estado.ACTIVO.getValor()) {

					dtVisitasUsuinternosBk.setRtmaddress(rmtaddress);
					dtVisitasUsuinternosBk.setRtmaddressrst(rmtaddress);

					dtVisitasUsuinternosBk.setFechaCrea(hoy);
					dtVisitasUsuinternosBk.setIdusserCrea(kyUsuarioMod);
					dtVisitasUsuinternosBk.setIdusserModif(kyUsuarioMod);
					dtVisitasUsuinternosBk.setFechaModif(hoy);
					dtVisitasUsuinternosBk.setEstado(Estado.ACTIVO.getValor());

					dtVisitasUsuinternos = new DtVisitasUsuinternos();

					FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternos, dtVisitasUsuinternosBk);
					dtVisitasUsuinternosDao.saveDtVisitasUsuinternos(dtVisitasUsuinternos);

					// log.log(Level.INFO,"CAMBIO :: "+kyUsuarioMod+" :: "+ user
					// + " :: "+ rmtaddress+" :: "+"CREADO
					// dtVisitasUsuinternos"+" ::
					// "+dtVisitasUsuinternos.getIdVisitUsuint().toString()+" ::
					// "+ "0" + " :: "+ Estado.ACTIVO.getValor());
					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "CREADO dtVisitasUsuinternos" + " :: "
									+ dtVisitasUsuinternos.getIdVisitUsuint().toString() + " :: " + "0" + " :: "
									+ Estado.ACTIVO.getValor());// PURIBE
																// 29032024 -
																// INICIO-->
				}
				// PURIBE 22032024 - FIN-->
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		// dtVisitasUsuinternosBk =
		// getDtVisitasUsuinternosBkXid(dtVisitasUsuinternos.getIdVisitUsuint(),kyUsuarioMod);
		// PURIBE 22032024 - INICIO-->
		if (dtVisitasUsuinternosBk.getEstado() == Estado.ACTIVO.getValor()) {
			dtVisitasUsuinternosBk = getDtVisitasUsuinternosBkXid(dtVisitasUsuinternos.getIdVisitUsuint(),
					kyUsuarioMod);
		}
		// PURIBE 22032024 - FIN-->
		return dtVisitasUsuinternosBk;
	}

	@Override
	public void deleteDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtVisitasUsuinternos dtVisitasUsuinternos = null;
			if (dtVisitasUsuinternosBk.getIdVisitUsuint() != null
					&& dtVisitasUsuinternosBk.getIdVisitUsuint().longValue() > 0) {

				dtVisitasUsuinternos = dtVisitasUsuinternosDao
						.getDtVisitasUsuinternos(dtVisitasUsuinternosBk.getIdVisitUsuint());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasUsuinternos.setRtmaddressrst(rmtaddress);
				dtVisitasUsuinternos.setIdusserModif(kyUsuarioMod);
				dtVisitasUsuinternos.setFechaModif(hoy);
				Long estadoanterior = dtVisitasUsuinternos.getEstado();
				dtVisitasUsuinternos.setEstado(Estado.ELIMINADO.getValor());

				dtVisitasUsuinternosDao.updateDtVisitasUsuinternos(dtVisitasUsuinternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtVisitasUsuinternos" + " :: " + dtVisitasUsuinternos.getIdVisitUsuint().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtVisitasUsuinternos dtVisitasUsuinternos = null;
			if (dtVisitasUsuinternosBk.getIdVisitUsuint() != null
					&& dtVisitasUsuinternosBk.getIdVisitUsuint().longValue() > 0) {

				dtVisitasUsuinternos = dtVisitasUsuinternosDao
						.getDtVisitasUsuinternos(dtVisitasUsuinternosBk.getIdVisitUsuint());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasUsuinternos.setRtmaddressrst(rmtaddress);
				dtVisitasUsuinternos.setIdusserModif(kyUsuarioMod);
				dtVisitasUsuinternos.setFechaModif(hoy);
				Long estadoanterior = dtVisitasUsuinternos.getEstado();
				dtVisitasUsuinternos.setEstado(Estado.ACTIVO.getValor());

				dtVisitasUsuinternosDao.updateDtVisitasUsuinternos(dtVisitasUsuinternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtVisitasUsuinternos" + " :: " + dtVisitasUsuinternos.getIdVisitUsuint().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	// @Override
	// public List<DtVisitasUsuinternosBk> getDtVisitasUsuinternosXFiltro(Long
	// idVisita,Long idUsuinterno, Long kyUsuarioMod) {
	// List<DtVisitasUsuinternosBk> dtVisitasUsuinternosBkss = new
	// ArrayList<DtVisitasUsuinternosBk>();
	// try {
	// List<DtVisitasUsuinternos> dtVisitasUsuinternossss =
	// dtVisitasUsuinternosDao.getXFiltro(idVisita,idUsuinterno);
	// for (DtVisitasUsuinternos dtVisitasUsuinternos : dtVisitasUsuinternossss)
	// {
	// DtVisitasUsuinternosBk dtVisitasUsuinternosBk = new
	// DtVisitasUsuinternosBk();
	// FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternosBk,
	// dtVisitasUsuinternos);
	// completarDtVisitasUsuinternos(dtVisitasUsuinternosBk);
	// setACLDtVisitasUsuinternosBk(dtVisitasUsuinternosBk,kyUsuarioMod);
	// dtVisitasUsuinternosBkss.add(dtVisitasUsuinternosBk);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return dtVisitasUsuinternosBkss;
	// }

	@Override
	public List<DtVisitasUsuinternosBk> getDtVisitasUsuinternosXFiltro(Long idVisita, Long idUsuinterno, int inicial,
			int MAX, Long kyUsuarioMod) {
		List<DtVisitasUsuinternosBk> dtVisitasUsuinternosBkss = new ArrayList<DtVisitasUsuinternosBk>();
		try {
			List<DtVisitasUsuinternos> dtVisitasUsuinternossss = dtVisitasUsuinternosDao.getXFiltro(idVisita,
					idUsuinterno, inicial, MAX);
			for (DtVisitasUsuinternos dtVisitasUsuinternos : dtVisitasUsuinternossss) {
				DtVisitasUsuinternosBk dtVisitasUsuinternosBk = new DtVisitasUsuinternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternosBk, dtVisitasUsuinternos);
				completarDtVisitasUsuinternos(dtVisitasUsuinternosBk);
				setACLDtVisitasUsuinternosBk(dtVisitasUsuinternosBk, kyUsuarioMod);
				dtVisitasUsuinternosBkss.add(dtVisitasUsuinternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuinternosBkss;
	}

	@Override
	public Long getDtVisitasUsuinternosTotalXFiltro(Long idVisita, Long idUsuinterno, Long kyUsuarioMod) {
		try {
			Long totalDtVisitasUsuinternossss = dtVisitasUsuinternosDao.getTotalXFiltro(idVisita, idUsuinterno);

			return totalDtVisitasUsuinternossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtVisitasUsuinternosBk(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, Long kyUsuarioMod) {
		DtVisitasUsuinternosACL dtVisitasUsuinternosACL = new DtVisitasUsuinternosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASUSUINTERNOS_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
					// PURIBE 22032024 - FIN
					dtVisitasUsuinternosACL.setEsEditable(true);
					dtVisitasUsuinternosACL.setEliminar(true);
				} else if (roles.contains(Roles.DTVISITASUSUINTERNOS_VE)) {
					dtVisitasUsuinternosACL.setEsEditable(true);
				}
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASUSUINTERNOS_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
					// PURIBE 22032024 - FIN
					dtVisitasUsuinternosACL.setEditopcion(1);
				} else {
					dtVisitasUsuinternosACL.setEditopcion(2);
				}
			} else {
				dtVisitasUsuinternosACL.setEditopcion(2);
			}
		} else {
			dtVisitasUsuinternosACL.setEditopcion(2);
		}
		dtVisitasUsuinternosBk.setDtVisitasUsuinternosACL(dtVisitasUsuinternosACL);
	}

	/// ADICIONALES

	// @Override
	// public List<MsUsuariosDto> getMsUsuariosCache() {
	// if (msUsuariosListaCache == null) {
	// List<MsUsuarios> msUsuariossss = msUsuariosDao.getActivasMsUsuarios();
	// msUsuariosListaCache = new ArrayList<MsUsuariosDto>();
	// for (MsUsuarios msUsuarios : msUsuariossss) {
	// MsUsuariosDto msUsuariosDto = new MsUsuariosDto();
	// FuncionesStaticas.copyPropertiesObject(msUsuariosDto, msUsuarios);
	// msUsuariosListaCache.add(msUsuariosDto);
	// }
	// }
	// return msUsuariosListaCache;
	// }

	/**
	 * DT_ASISTENCIA SERVICIO: LISTA DE LOS DATOS REGISTRADOS EN UNA ASISTENCIA
	 * TECNICA
	 */
	@Override
	public DtAsistenciaBk getDtAsistenciaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtAsistencia dtAsistencia = dtAsistenciaDao.getDtAsistencia(id);
		DtAsistenciaBk dtAsistenciaBk = null;
		if (dtAsistencia != null) {
			dtAsistenciaBk = new DtAsistenciaBk();
			FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
			// completarDtAsistencia(dtAsistenciaBk);
			completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																// 18062024
			if (kyUsuarioMod != null)
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
		}
		return dtAsistenciaBk;
	}

	@Override
	public List<DtAsistenciaBk> getAllDtAsistenciaActivos(Long kyUsuarioMod) {
		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistencias = dtAsistenciaDao.getActivasDtAsistencia();
			for (DtAsistencia dtAsistencia : dtAsistencias) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				// completarDtAsistencia(dtAsistenciaBk);
				completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																	// 18062024
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}

	@Override
	public List<DtAsistenciaBk> getAllDtAsistenciaActivosCero(Long kyUsuarioMod) {
		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistencias = dtAsistenciaDao.getActivasDtAsistenciaCero();
			for (DtAsistencia dtAsistencia : dtAsistencias) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				// completarDtAsistencia(dtAsistenciaBk);
				completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																	// 18062024
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}

	// INICIO CUSCATA - 18062024
	private void completarDtAsistencia(DtAsistenciaBk dtAsistenciaBk, Long kyUsuarioMod) {
		// MPINARES 24012023 - INICIO
		try {
			// MPINARES 14022024 - INICIO - SE COMENTA
			// if (dtAsistenciaBk.getEstado() != null &&
			// dtAsistenciaBk.getEstado().longValue() > 0) {
			// PrtParametros prtParametros =
			// prtParametrosDao.getPrtParametros(dtAsistenciaBk.getEstado());
			// if (prtParametros != null)
			// dtAsistenciaBk.setEstadoTxt(prtParametros.getDescripcion());
			// }
			// MPINARES 14022024 - FIN

			if (dtAsistenciaBk.getEstado() != null && dtAsistenciaBk.getEstado().longValue() > 0) {
				Long estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
				Long estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
				if (dtAsistenciaBk.getEstado().longValue() == estadoNuevo) {
					dtAsistenciaBk.setEstadoTxt("EN PROCESO");
				} else if (dtAsistenciaBk.getEstado().longValue() == estadoEliminado) {
					dtAsistenciaBk.setEstadoTxt("ANULADO");
				} else {
					PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAsistenciaBk.getEstado());
					if (prtParametros != null)
						dtAsistenciaBk.setEstadoTxt(prtParametros.getDescripcion());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// MPINARES 24012023 - FIN
		try {
			if (dtAsistenciaBk.getIdEntidad() != null && dtAsistenciaBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtAsistenciaBk.getIdEntidad());
				DtEntidadesBk msInstitucionesBk = new DtEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(msInstitucionesBk, dtEntidades);
				completarDtEntidadesUbi(msInstitucionesBk);
				if (msInstitucionesBk != null)
					dtAsistenciaBk.setIdEntidadTxt(msInstitucionesBk.getRazSocialUbigeo());
				dtAsistenciaBk.setCodEjecutora(msInstitucionesBk.getCodEjec());// MPINARES
																				// 24012023
																				// -
																				// INICIO
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdSede() != null && dtAsistenciaBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtAsistenciaBk.getIdSede());
				if (msSedes != null)
					dtAsistenciaBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdUsuinterno() != null && dtAsistenciaBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtAsistenciaBk.getIdUsuinterno());
				if (msUsuarios != null)
					// dtAsistenciaBk.setIdUsuinternoTxt(msUsuarios.getNombres());
					dtAsistenciaBk.setIdUsuinternoTxt(msUsuarios.getNombres() + " " + msUsuarios.getApellidoPaterno()
							+ " " + msUsuarios.getApellidoMaterno());// MPINARES
																		// 14022024
																		// -
																		// INICIO
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdSistAdm() != null && dtAsistenciaBk.getIdSistAdm().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtAsistenciaBk.getIdSistAdm());
				if (msSisAdmistrativo != null)
					dtAsistenciaBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdOrigen() != null && dtAsistenciaBk.getIdOrigen().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAsistenciaBk.getIdOrigen());
				if (prtParametros != null)
					dtAsistenciaBk.setIdOrigenTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdProgramacion() != null && dtAsistenciaBk.getIdProgramacion().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAsistenciaBk.getIdProgramacion());
				if (prtParametros != null)
					dtAsistenciaBk.setIdProgramacionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try{
		// if(dtAsistenciaBk.getEstado()!=null &&
		// dtAsistenciaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtAsistenciaBk.getEstado());
		// if(prtParametros!=null)
		// dtAsistenciaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			if (dtAsistenciaBk.getIdModalidad() != null && dtAsistenciaBk.getIdModalidad().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAsistenciaBk.getIdModalidad());
				if (prtParametros != null)
					dtAsistenciaBk.setIdModalidadTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdFinancia() != null && dtAsistenciaBk.getIdFinancia().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAsistenciaBk.getIdFinancia());
				if (prtParametros != null)
					dtAsistenciaBk.setIdFinanciaTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// MPINARES 24012023 - INICIO
		// // PARA USUARIOS EXTERNOS
		// DtAsistenciaUsuexternosBk
		List<DtAsistenciaUsuexternos> DtAsistenciaUsuexternosList = dtAsistenciaUsuexternosDao
				.getByIdAsistDtAsisteUsuariosExt(dtAsistenciaBk.getIdAsistencia());

		if (DtAsistenciaUsuexternosList != null && DtAsistenciaUsuexternosList.size() > 0) {
			List<String> usueExt = new ArrayList<String>();
			List<String> dniExt = new ArrayList<String>();
			for (DtAsistenciaUsuexternos dtObjetc : DtAsistenciaUsuexternosList) {
				if (dtObjetc.getIdUsuexterno() != null && dtObjetc.getIdUsuexterno().longValue() > 0) {

					DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
							.getDtUsuarioExterno(dtObjetc.getIdUsuexterno());

					if (dtUsuarioExterno != null) {
						usueExt.add(dtUsuarioExterno.getApaterno() + " " + dtUsuarioExterno.getAmaterno() + " "
								+ dtUsuarioExterno.getNombre());
						if (dtUsuarioExterno.getNumDocum() != null)
							dniExt.add(dtUsuarioExterno.getNumDocum() + "");
					}
				}

			}
			dtAsistenciaBk.setUsuExt(usueExt);
			dtAsistenciaBk.setDniUser(dniExt);
		}

		if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {
			List<DtAsistenciaTemasBk> dtAsistenciaTemasList = getDtAsistenciaTemasXIdAsistencia(
					dtAsistenciaBk.getIdAsistencia());
			dtAsistenciaBk.setDtAsistenciaTemasBkJSss(dtAsistenciaTemasList);
		}

		// MPINARES 24012023 - FIN
		if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {
			List<DtAsistenciaUsuexternosBk> listaDtAsistenciaUsuexternosBk = this
					.getAllDtAsistenciaUsuexternosByIdAsistencia(dtAsistenciaBk.getIdAsistencia(), kyUsuarioMod);
			dtAsistenciaBk.setDtAsistenciaUsuariosBkJSss(listaDtAsistenciaUsuexternosBk);
		}
		// INICIO CUSCATA - 10072024
		if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {
			Long idTipoServicio = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN);
			List<DtAnexoBk> lstAnexos = this.getDtAnexoXFiltro(null, null, idTipoServicio, null,
					dtAsistenciaBk.getIdAsistencia(), null);
			if (lstAnexos != null && !lstAnexos.isEmpty()) {
				dtAsistenciaBk.setDtAnexosBKJSss(lstAnexos);
			}
		}
		// FIN CUSCATA - 10072024

	}

	// INICIO CUSCATA - 10072024
	@Override
	public DtAsistenciaBk validarCambiosAsistencia(DtAsistenciaBk asistenciaJS, Long kyUsuarioMod) throws Validador {

		DtAsistenciaBk dtAsistenciaBk = this.getDtAsistenciaBkXid(asistenciaJS.getIdAsistencia(), kyUsuarioMod);

		if (asistenciaJS.getDtAsistenciaTemasBkJSss() != null && asistenciaJS.getDtAsistenciaTemasBkJSss() != null
				&& asistenciaJS.getDtAsistenciaTemasBkJSss().size() != dtAsistenciaBk.getDtAsistenciaTemasBkJSss()
						.size()) {
			throw new Validador(MessageFormat.format("DEBE DE GUARDAR PRIMERO",
					Messages.getStringToKey("dtAsistencias.titulotabla")));
		}

		if (asistenciaJS.getDtAsistenciaUsuariosBkJSss() != null
				&& dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss() != null
				&& asistenciaJS.getDtAsistenciaUsuariosBkJSss().size() != dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss()
						.size()) {
			throw new Validador(MessageFormat.format("DEBE DE GUARDAR PRIMERO",
					Messages.getStringToKey("dtAsistencias.titulotabla")));
		}

		if (asistenciaJS.getCodEjecutora() != null && dtAsistenciaBk.getCodEjecutora() != null
				&& !asistenciaJS.getCodEjecutora().equals(dtAsistenciaBk.getCodEjecutora())) {
			throw new Validador(MessageFormat.format("DEBE DE GUARDAR PRIMERO",
					Messages.getStringToKey("dtAsistencias.titulotabla")));
		}

		return dtAsistenciaBk;
	}

	public void deleteDtAsistenciaTema(DtAsistenciaTemas dtAsistenciaTemas) throws Validador {
		try {
			DtAsistenciaTemas msObject = null;
			if (dtAsistenciaTemas.getIdAsistencia() != null && dtAsistenciaTemas.getIdAsistencia().longValue() > 0) {

				msObject = dtAsistenciaTemasDao.getDtAsistenciaTemas(dtAsistenciaTemas.getIdAsistTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());
				Long estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);

				msObject.setFechaModif(hoy);
				msObject.setEstado(estadoEliminado);
				Long estadoanterior = msObject.getEstado();

				dtAsistenciaTemasDao.updateDtAsistenciaTemas(msObject);

				log.log(Level.INFO,
						"CAMBIO :: " + msObject.getIdusserModif() + " :: " + " :: " + msObject.getRtmaddress() + " :: "
								+ "ELIMINADO DtEntidadSede" + " :: " + msObject.getIdAsistTema().toString() + " :: "
								+ estadoanterior + " :: " + "0");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	private void cargarAnexos(List<DtAnexoBk> tdAnexosBkss, Long idmaestro, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress, Long idTiposervicio) throws Validador {

		// List<DtAnexoBk> TdAnexosBksssActuales = getTdAnexosXFiltro(idmaestro,
		// idTiposervicio, kyUsuarioMod);
		List<DtAnexoBk> TdAnexosBksssActuales = this.getDtAnexoXFiltro(null, null, idTiposervicio, null, idmaestro,
				null);

		if (tdAnexosBkss != null && !tdAnexosBkss.isEmpty()) {
			for (DtAnexoBk tdAnexosBkAct : TdAnexosBksssActuales) {
				if (!tdAnexosBkss.contains(tdAnexosBkAct)) {
					deleteTdAnexos(tdAnexosBkAct, user, kyUsuarioMod, kyAreaMod, rmtaddress);
				}
			}
			for (DtAnexoBk tdAnexosBk : tdAnexosBkss) {
				if (tdAnexosBk.getIdmaestro() == null || tdAnexosBk.getIdmaestro().longValue() <= 0) {
					tdAnexosBk.setIdmaestro(idmaestro);
					tdAnexosBk.setIdTiposervicio(idTiposervicio);
					tdAnexosBk = saveorupdateDtAnexoBk(tdAnexosBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
					if (tdAnexosBk.getFilename() != null) {
						if (tdAnexosBk.getFilename().startsWith("TEMP")) {
							File file_tdAnexosBk = FuncionesStaticas
									.getFileSistemaCompletoSearch(tdAnexosBk.getFilename(), tdAnexosBk.getFechaCrea());
							if (file_tdAnexosBk != null && file_tdAnexosBk.exists()) {
								String nuevonombre = FuncionesStaticas.getFileNameSistema(tdAnexosBk.getIdmaestro(),
										tdAnexosBk.getIdAnexo(), kyUsuarioMod, kyAreaMod);
								String nuevaruta = FuncionesStaticas.getFileNameRutaSistema(nuevonombre);
								if (FuncionesStaticas.moveTo(file_tdAnexosBk, nuevaruta)) {
									tdAnexosBk.setFilename(nuevonombre);
									tdAnexosBk = saveorupdateDtAnexoBk(tdAnexosBk, user, kyUsuarioMod, kyAreaMod,
											rmtaddress);
								} else {
									log.info("NO SE PUDO MOVER EL ARCHIVO DE: " + file_tdAnexosBk.getAbsolutePath()
											+ " A " + nuevaruta);
								}
							} else {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm");
								log.info("ARCHIVO NO ENCONTRADO: " + tdAnexosBk.getFilename() + " en " + sdf);
							}
						}
					}
				} else {
					saveorupdateDtAnexoBk(tdAnexosBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
				}
			}
		} else {
			for (DtAnexoBk tdAnexosBkAct : TdAnexosBksssActuales) {
				deleteTdAnexos(tdAnexosBkAct, user, kyUsuarioMod, kyAreaMod, rmtaddress);
			}
		}
	}

	public void deleteTdAnexos(DtAnexoBk tdAnexosBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			DtAnexo tdAnexos = null;
			if (tdAnexosBk.getIdAnexo() != null && tdAnexosBk.getIdAnexo().longValue() != 0L) {

				tdAnexos = dtAnexoDao.getDtAnexo(tdAnexosBk.getIdAnexo());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				tdAnexos.setRtmaddressrst(rmtaddress);
				tdAnexos.setIdusserModif(kyUsuarioMod);
				tdAnexos.setFechaModif(hoy);
				Long estadoanterior = tdAnexos.getEstado();
				tdAnexos.setEstado(Estado.ELIMINADO.getValor());

				dtAnexoDao.updateDtAnexo(tdAnexos);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO tdAnexos" + " :: " + tdAnexos.getIdAnexo().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}
	
	@Override
	public List<DtAsistenciaBk> getDtAsistenciaXFiltro(Date fechaInicio, Date fechaFin, Long idProgramacion,
														Long kyUsuarioMod,long sede,int rol,long sistemaadmi) throws Validador {


		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.after(fechaFin)) {
				Date fechatmp = fechaInicio;
				fechaInicio = fechaFin;
				fechaFin = fechatmp;
			}
		} else if (fechaInicio != null) {
			fechaFin = fechaInicio;
		} else if (fechaFin != null) {
			fechaInicio = fechaFin;
			fechaFin = fechaInicio;
		}

		if (fechaFin != null) {
			Timestamp fechFin = new Timestamp(fechaFin.getTime());
			fechaFin = FuncionesStaticas.getDiaMasUno(fechFin);
		}

		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistenciasss = null;
			int rolAdminAndOGC = 0;
			int rolGC = 1;
			int rolImplantador = 2;
			
			System.out.println("fechaInicio: " + fechaInicio);
			System.out.println("fechaFin: " + fechaFin);
			System.out.println("idProgramacion: " + idProgramacion);
			System.out.println("sede: " + sede);
			System.out.println("sistemaadmi: " + sistemaadmi);
			System.out.println("kyUsuarioMod: " + kyUsuarioMod);
			System.out.println("rol: " + rol);
			
			if (rol == rolAdminAndOGC) {
				 dtAsistenciasss = dtAsistenciaDao.getXFiltroV(fechaInicio, fechaFin, null);
			} else if(rol == rolGC) {
				dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, null, sede, null, null);
			} else if(rol == rolImplantador) {
				dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, sede, sistemaadmi, kyUsuarioMod);
			}
			
			System.out.println("dtAsistenciasss.size(): " + dtAsistenciasss.size());
			//PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAsistenciaBk.getIdOrigen());
			List<PrtParametros> lstPrtParametros = prtParametrosDao.getAllPrtParametros();
			//List<DtUsuarioExterno> lstDtUsuarioExterno = dtUsuarioExternoDao.getAllDtUsuarioExterno();
			System.out.println("param loaded...");
			
			for (DtAsistencia dtAsistencia : dtAsistenciasss) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				completarDtAsistenciaBandeja(dtAsistenciaBk, kyUsuarioMod, lstPrtParametros);
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
			
			System.out.println("completed dtAsistenciaBkss.size(): " + dtAsistenciaBkss.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}
	
	private PrtParametros getPrtParametros(List<PrtParametros> lstPrtParametros, Long idParam) {
		return lstPrtParametros.stream().filter(c->String.valueOf(c.getIdparametro()).equals(String.valueOf(idParam))).findFirst().orElse(null);
	}
	
	private void completarDtAsistenciaBandeja(DtAsistenciaBk dtAsistenciaBk, Long kyUsuarioMod, List<PrtParametros> lstPrtParametros) {

		try {

			if (dtAsistenciaBk.getEstado() != null && dtAsistenciaBk.getEstado().longValue() > 0) {
				Long estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
				Long estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
				if (dtAsistenciaBk.getEstado().longValue() == estadoNuevo) {
					dtAsistenciaBk.setEstadoTxt("EN PROCESO");
				} else if (dtAsistenciaBk.getEstado().longValue() == estadoEliminado) {
					dtAsistenciaBk.setEstadoTxt("ANULADO");
				} else {
					PrtParametros prtParametros = this.getPrtParametros(lstPrtParametros, dtAsistenciaBk.getEstado());
					if (prtParametros != null)
						dtAsistenciaBk.setEstadoTxt(prtParametros.getDescripcion());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdEntidad() != null && dtAsistenciaBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtAsistenciaBk.getIdEntidad());
				if (dtEntidades != null)
					dtAsistenciaBk.setIdEntidadTxt(dtEntidades.getRazSocial());
				dtAsistenciaBk.setCodEjecutora(dtEntidades.getCodEjec());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdSede() != null && dtAsistenciaBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtAsistenciaBk.getIdSede());
				if (msSedes != null)
					dtAsistenciaBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdUsuinterno() != null && dtAsistenciaBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtAsistenciaBk.getIdUsuinterno());
				if (msUsuarios != null)
					dtAsistenciaBk.setIdUsuinternoTxt(msUsuarios.getNombres() + " " + msUsuarios.getApellidoPaterno()
							+ " " + msUsuarios.getApellidoMaterno());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdSistAdm() != null && dtAsistenciaBk.getIdSistAdm().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtAsistenciaBk.getIdSistAdm());
				if (msSisAdmistrativo != null)
					dtAsistenciaBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdOrigen() != null && dtAsistenciaBk.getIdOrigen().longValue() > 0) {
				PrtParametros prtParametros = this.getPrtParametros(lstPrtParametros, dtAsistenciaBk.getIdOrigen());
				if (prtParametros != null)
					dtAsistenciaBk.setIdOrigenTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdProgramacion() != null && dtAsistenciaBk.getIdProgramacion().longValue() > 0) {
				PrtParametros prtParametros = this.getPrtParametros(lstPrtParametros, dtAsistenciaBk.getIdProgramacion());
				if (prtParametros != null)
					dtAsistenciaBk.setIdProgramacionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (dtAsistenciaBk.getIdModalidad() != null && dtAsistenciaBk.getIdModalidad().longValue() > 0) {
				PrtParametros prtParametros = this.getPrtParametros(lstPrtParametros, dtAsistenciaBk.getIdModalidad());
				if (prtParametros != null)
					dtAsistenciaBk.setIdModalidadTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaBk.getIdFinancia() != null && dtAsistenciaBk.getIdFinancia().longValue() > 0) {
				PrtParametros prtParametros = this.getPrtParametros(lstPrtParametros, dtAsistenciaBk.getIdFinancia());
				if (prtParametros != null)
					dtAsistenciaBk.setIdFinanciaTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DtAsistenciaUsuexternos> DtAsistenciaUsuexternosList = dtAsistenciaUsuexternosDao
				.getByIdAsistDtAsisteUsuariosExt(dtAsistenciaBk.getIdAsistencia());

		if (DtAsistenciaUsuexternosList != null && DtAsistenciaUsuexternosList.size() > 0) {
			List<String> usueExt = new ArrayList<String>();
			List<String> dniExt = new ArrayList<String>();
			for (DtAsistenciaUsuexternos dtObjetc : DtAsistenciaUsuexternosList) {
				if (dtObjetc.getIdUsuexterno() != null && dtObjetc.getIdUsuexterno().longValue() > 0) {

					DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
							.getDtUsuarioExterno(dtObjetc.getIdUsuexterno());

					if (dtUsuarioExterno != null) {
						usueExt.add(dtUsuarioExterno.getApaterno() + " " + dtUsuarioExterno.getAmaterno() + " "
								+ dtUsuarioExterno.getNombre());
						if (dtUsuarioExterno.getNumDocum() != null)
							dniExt.add(dtUsuarioExterno.getNumDocum() + "");
					}
				}

			}
			dtAsistenciaBk.setUsuExt(usueExt);
			dtAsistenciaBk.setDniUser(dniExt);
		}

	}
	
	@Override
	public void updateDtAsistenciaUsuexCorreo(Long id) throws Validador {
		dtAsistenciaUsuexternosDao.updateDtAsistenciaUsuexCorreo(id);
		
	}
	
	@Override
	public void deleteDtAsistenciaUsuario(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		
		DtAsistenciaUsuexternos dtAsistenciaUsuexternos = null;
		
		try {
			if (dtAsistenciaUsuexternosBk.getIdAsistUsuext() != null
					&& dtAsistenciaUsuexternosBk.getIdAsistUsuext().longValue() > 0) {
				dtAsistenciaUsuexternos = dtAsistenciaUsuexternosDao
						.getDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk.getIdAsistUsuext());
				
				Timestamp hoy = new Timestamp(System.currentTimeMillis());
				
				dtAsistenciaUsuexternos.setRtmaddressrst(rmtaddress);
				dtAsistenciaUsuexternos.setIdusserModif(kyUsuarioMod);
				dtAsistenciaUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaUsuexternos.getEstado();
				dtAsistenciaUsuexternos.setEstado(Estado.ELIMINADO.getValor());

				dtAsistenciaUsuexternosDao.updateDtAsistenciaUsuexternos(dtAsistenciaUsuexternos);
				
				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO DtAsistenciaUsuexternos" + " :: " + dtAsistenciaUsuexternos.getIdAsistUsuext().toString()
								+ " :: " + estadoanterior + " :: " + "0");
				
			}
		} catch (Exception e) {
			throw new Validador(e.getMessage());
		}
			
		
	}
	
	@Override
	public DtAsistenciaUsuexternosBk saveorupdateDtAsistenciaUsuexternosBk(
			DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionDtAsistenciaUsuexternosMng.validarDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk);

		DtAsistenciaUsuexternos dtAsistenciaUsuexternos = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtAsistenciaUsuexternosBk.getIdAsistUsuext() != null
					&& dtAsistenciaUsuexternosBk.getIdAsistUsuext().longValue() > 0) {

				dtAsistenciaUsuexternos = dtAsistenciaUsuexternosDao
						.getDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk.getIdAsistUsuext());

				boolean cambios = AuditoriaDtAsistenciaUsuexternosMng.auditarCambiosDtAsistenciaUsuexternos(
						dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtAsistenciaUsuexternos.setRtmaddressrst(rmtaddress);
					dtAsistenciaUsuexternos.setIdusserModif(kyUsuarioMod);
					dtAsistenciaUsuexternos.setFechaModif(hoy);
					dtAsistenciaUsuexternosDao.updateDtAsistenciaUsuexternos(dtAsistenciaUsuexternos);
				}
			} else {
				dtAsistenciaUsuexternosBk.setRtmaddress(rmtaddress);
				dtAsistenciaUsuexternosBk.setRtmaddressrst(rmtaddress);

				dtAsistenciaUsuexternosBk.setFechaCrea(hoy);
				dtAsistenciaUsuexternosBk.setIdusserCrea(kyUsuarioMod);
				dtAsistenciaUsuexternosBk.setIdusserModif(kyUsuarioMod);
				dtAsistenciaUsuexternosBk.setFechaModif(hoy);
				dtAsistenciaUsuexternosBk.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaUsuexternos = new DtAsistenciaUsuexternos();

				FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternos, dtAsistenciaUsuexternosBk);
				dtAsistenciaUsuexternosDao.saveDtAsistenciaUsuexternos(dtAsistenciaUsuexternos);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtAsistenciaUsuexternos" + " :: "
								+ dtAsistenciaUsuexternos.getIdAsistUsuext().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtAsistenciaUsuexternosBk = getDtAsistenciaUsuexternosBkXid(dtAsistenciaUsuexternos.getIdAsistUsuext(),
				kyUsuarioMod);
		return dtAsistenciaUsuexternosBk;
	}

	// FIN CUSCATA - 10072024

	@Override
	public DtAsistenciaBk saveorupdateDtAsistenciaBk(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress, List<DtAnexoBk> tdAnexosBkss) throws Validador {

		// ValidacionDtAsistenciaMng.validarDtAsistenciaBk(dtAsistenciaBk);
		// MPINARES 24012023 - INICIO

		// dtAsistenciaBk.setVistaProgramado(false);
		// if(dtAsistenciaBk.isVistaProgramado()){
		// dtAsistenciaBk.setFechaAsistencia(dtAsistenciaBk.getFechaProgramada());
		// }else{
		// dtAsistenciaBk.setFechaAsistencia(dtAsistenciaBk.getFech);
		// }
		// INICIO CUSCATA - 10072024
		Long idProgramacion = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);

		if (String.valueOf(idProgramacion).equals(String.valueOf(dtAsistenciaBk.getIdProgramacion()))) {
			dtAsistenciaBk.setFechaAsistencia(dtAsistenciaBk.getFechaProgramada());
		}
		// FIN CUSCATA - 10072024

		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);

		Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);
		DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada,
				dtAsistenciaBk.getIdSede(), dtAsistenciaBk.getIdSistAdm(), FuncionesStaticas.getMonth());

		Long idModalidadVirtual = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_VIRTUAL,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL);
		Long idProgram = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
		Long idFinancimientoNoGasto = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_FINANCIMIENTO_NO_GASTO,
				PropertiesMg.DEFAULT_PRTPARAMETROS_IDTIPO_FINANCIMIENTO_NO_GASTO);
		Long idModalidadTel = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_TELEFONO,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_TELEFONO);

		// ***********************************************************************************************************
		DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada, idSedeTodas,
				dtAsistenciaBk.getIdSistAdm(), FuncionesStaticas.getMonth());
		if (autorizacionProgramacion2 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion2;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion2;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada,
				dtAsistenciaBk.getIdSede(), idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion3 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion3;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion3;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada, idSedeTodas,
				idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion4 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion4;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion4;
			}
		}

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);
		// Integer mesServicio=dtAsistenciaBk.getFechaAsistencia().getMonth()+1;

		Integer mesServicio = dtAsistenciaBk.getFechaAsistencia().getMonth() + 1;

		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}

		DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
				dtAsistenciaBk.getIdSede(), dtAsistenciaBk.getIdSistAdm(), mesServicio + 1);// Ahora,
																							// Mes
																							// Actual,
																							// por
																							// confirmar

		if (autorizacionEjecucion == null) {
			autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
					dtAsistenciaBk.getIdSistAdm(), mesServicio + 1);// Ahora,
																	// Mes
																	// Actual,
																	// por
																	// confirmar

			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, dtAsistenciaBk.getIdSede(),
						idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual, por
														// confirmar

				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
							idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual,
															// por confirmar
				}
			}
		}

		DtAsistencia dtAsistenciaOrig = null;
		if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {
			dtAsistenciaOrig = dtAsistenciaDao.getDtAsistencia(dtAsistenciaBk.getIdAsistencia());
		}

		ValidacionDtAsistenciaMng.validarDtAsistenciaBk(dtAsistenciaBk, autorizacionProgramacion, autorizacionEjecucion,
				msRolesDao.isRolAdministradorOGC(kyUsuarioMod), dtAsistenciaOrig);

		if (dtAsistenciaBk.getIdProgramacion().compareTo(idProgram) == 0) {
			if ((dtAsistenciaBk.getIdModalidad().compareTo(idModalidadVirtual) == 0
					|| dtAsistenciaBk.getIdModalidad().compareTo(idModalidadTel) == 0)
					&& dtAsistenciaBk.getIdFinancia().compareTo(idFinancimientoNoGasto) != 0) {
				throw new Validador(
						MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoFinanciamCorrect"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
			}
		}

		// VALIDADOR DE TEMAS
		List<DtAsistenciaTemasBk> asiatenciasTemas = new ArrayList<DtAsistenciaTemasBk>();
		if (dtAsistenciaBk.getDtAsistenciaTemasBkJSss() != null
				&& dtAsistenciaBk.getDtAsistenciaTemasBkJSss().size() > 0) {

			for (DtAsistenciaTemasBk dtAsistenciaTemasBka : dtAsistenciaBk.getDtAsistenciaTemasBkJSss()) {
				if (dtAsistenciaTemasBka.getIdTema() != null && dtAsistenciaTemasBka.getIdSubtema() != null
						&& (dtAsistenciaTemasBka.getDetalle() != null
								&& dtAsistenciaTemasBka.getDetalle().length() > 2)) {
					asiatenciasTemas.add(dtAsistenciaTemasBka);
				} else {
					throw new Validador(MessageFormat.format("EL DETALLE DEL TEMA DEBE SER MAYOR A 3 CARACTERES",
							Messages.getStringToKey("dtAsistencias.titulotabla")));
				}
			}

			if (asiatenciasTemas != null && asiatenciasTemas.size() > 0) {
				dtAsistenciaBk.setDtAsistenciaTemasBkJSss(asiatenciasTemas);
			} else {
				throw new Validador(MessageFormat.format("NO SE HAN AGENDADO LOS TEMAS",
						Messages.getStringToKey("dtAsistencias.titulotabla")));
			}
		} else {
			throw new Validador(MessageFormat.format("NO SE HAN AGENDADO LOS TEMAS",
					Messages.getStringToKey("dtAsistencias.titulotabla")));
		}
		// MPINARES 24012023 - FIN

		// VALIDAR USUARIO
		/*
		 * if(dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss()==null &&
		 * dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss().isEmpty()) { throw new
		 * Validador(MessageFormat.format("DEBE SELECCIONAR UN USUARIO",
		 * Messages.getStringToKey("dtAsistencias.titulotabla"))); }
		 */

		DtAsistencia dtAsistencia = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {

				dtAsistencia = dtAsistenciaDao.getDtAsistencia(dtAsistenciaBk.getIdAsistencia());

				boolean cambios = AuditoriaDtAsistenciaMng.auditarCambiosDtAsistencia(dtAsistenciaBk, dtAsistencia,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtAsistencia.setRtmaddressrst(rmtaddress);
					dtAsistencia.setIdusserModif(kyUsuarioMod);
					dtAsistencia.setFechaModif(hoy);
					dtAsistenciaDao.updateDtAsistencia(dtAsistencia);
				}
			} else {
				dtAsistenciaBk.setRtmaddress(rmtaddress);
				dtAsistenciaBk.setRtmaddressrst(rmtaddress);

				dtAsistenciaBk.setFechaCrea(hoy);
				dtAsistenciaBk.setIdusserCrea(kyUsuarioMod);
				dtAsistenciaBk.setIdusserModif(kyUsuarioMod);
				dtAsistenciaBk.setFechaModif(hoy);
				dtAsistenciaBk.setEstado(Estado.ACTIVO.getValor());

				dtAsistencia = new DtAsistencia();

				FuncionesStaticas.copyPropertiesObject(dtAsistencia, dtAsistenciaBk);
				dtAsistenciaDao.saveDtAsistencia(dtAsistencia);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtAsistencia" + " :: " + dtAsistencia.getIdAsistencia().toString() + " :: "
								+ "0" + " :: " + Estado.ACTIVO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		// MPINARES 24012023 - INICIO
		DtAsistenciaTemas dtAsistenciaTemas = null;
		if (dtAsistenciaBk.getDtAsistenciaTemasBkJSss() != null
				&& dtAsistenciaBk.getDtAsistenciaTemasBkJSss().size() > 0) {
			for (DtAsistenciaTemasBk dtAsistenciaTemasBk : dtAsistenciaBk.getDtAsistenciaTemasBkJSss()) {
				if (dtAsistenciaTemasBk.getIdAsistTema() != null
						&& dtAsistenciaTemasBk.getIdAsistTema().longValue() > 0) {
					// ACTUALIZAR
					DtAsistenciaTemas asistenciaTema = dtAsistenciaTemasDao
							.getDtAsistenciaTemas(dtAsistenciaTemasBk.getIdAsistTema().longValue());
					asistenciaTema.setDetalle(dtAsistenciaTemasBk.getDetalle());
					asistenciaTema.setIdTema(dtAsistenciaTemasBk.getIdTema());
					asistenciaTema.setIdSubtema(dtAsistenciaTemasBk.getIdSubtema());
					dtAsistenciaTemasDao.updateDtAsistenciaTemas(asistenciaTema);

				} else {
					// NUEVO
					dtAsistenciaTemasBk.setIdAsistTema(null);
					dtAsistenciaTemasBk.setIdAsistencia(dtAsistencia.getIdAsistencia());
					dtAsistenciaTemasBk.setIdUsuinterno(kyUsuarioMod);
					dtAsistenciaTemasBk.setEstado(Estado.ACTIVO.getValor());
					dtAsistenciaTemasBk.setFechaCrea(hoy);
					dtAsistenciaTemasBk.setFechaModif(hoy);
					dtAsistenciaTemasBk.setIdusserCrea(kyUsuarioMod);
					dtAsistenciaTemasBk.setIdusserModif(kyUsuarioMod);
					dtAsistenciaTemasBk.setRtmaddress(rmtaddress);
					dtAsistenciaTemasBk.setRtmaddressrst(rmtaddress);

					dtAsistenciaTemas = new DtAsistenciaTemas();

					FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemas, dtAsistenciaTemasBk);
					dtAsistenciaTemasDao.saveDtAsistenciaTemas(dtAsistenciaTemas);

					log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
							+ "CREADO dtAsistenciaTemas" + " :: " + dtAsistenciaTemas.getIdAsistTema().toString()
							+ " :: " + "0" + " :: " + "" + Estado.ACTIVO.getValor());
				}
			}
		}
		// MPINARES 24012023 - FIN
		this.saveOrUpdateAsistenciaUsuarioExt(dtAsistenciaBk, dtAsistencia, hoy, kyUsuarioMod, rmtaddress, user);
		// INICIO CUSCATA - 10072024
		Long idTiposervicio = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN);

		this.cargarAnexos(tdAnexosBkss, dtAsistencia.getIdAsistencia(), user, kyUsuarioMod, kyAreaMod, rmtaddress,
				idTiposervicio);
		// FIN CUSCATA - 10072024
		dtAsistenciaBk = getDtAsistenciaBkXid(dtAsistencia.getIdAsistencia(), kyUsuarioMod);
		return dtAsistenciaBk;
	}

	@Override
	public DtAsistenciaBk enviarConstanciaAtencion(DtAsistenciaBk dtAsistenciaBk, String url, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia() != 0L) {

			Long idVirtual = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_VIRTUAL,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL);

			if (dtAsistenciaBk.getIdModalidad() != null && idVirtual != null
					&& dtAsistenciaBk.getIdModalidad() != idVirtual.intValue()) {
				throw new Validador(MessageFormat.format(
						Messages.getStringToKey("dtasistencia.enviar.const.atencion.validacion.virtual"),
						Messages.getStringToKey("dtEntidades.titulotabla")));
			}

			List<DtAsistenciaTemasBk> lstAsistTema = this
					.getDtAsistenciaTemasXIdAsistencia(dtAsistenciaBk.getIdAsistencia());

			if (lstAsistTema == null && lstAsistTema.isEmpty()) {
				throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTema.listaTemasVaciaa"),
						Messages.getStringToKey("dtEntidades.titulotabla")));
			}

			Timestamp hoy = new Timestamp(System.currentTimeMillis());
			dtAsistenciaBk.getDtAsistenciaUsuexternosBk().setCtrlConfirmacion(1L);
			dtAsistenciaBk.setDtAsistenciaUsuariosBkJSss(new ArrayList<>());
			dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss().add(dtAsistenciaBk.getDtAsistenciaUsuexternosBk());

			this.saveorupdateDtAsistenciaBk(dtAsistenciaBk, user, kyUsuarioMod, kyAreaMod, rmtaddress, null);

			// String url = "HTTP://AAAAAAAA";
			List<DtAsistenciaUsuexternosBk> participantes = new ArrayList<>();
			participantes.add(dtAsistenciaBk.getDtAsistenciaUsuexternosBk());
			// enviarConstanAtenPorCorreo(dtAsistenciaBk,
			// dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss(), lstAsistTema,
			// url, hoy);
			enviarConstanAtenPorCorreo(dtAsistenciaBk, participantes, lstAsistTema, url, hoy);

		}

		return dtAsistenciaBk;
	}

	private void enviarConstanAtenPorCorreo(DtAsistenciaBk dtAsistenciaBke,
			List<DtAsistenciaUsuexternosBk> participantes, List<DtAsistenciaTemasBk> temas, String url,
			Timestamp fechaFinalizacion) {

		log.log(Level.INFO, "INICIO DE  enviarConstanAtenPorCorreo");

		Thread myThread = new Thread() {
			public void run() {
				try {

					List<String> recipients = new ArrayList<String>();
					Long idUsuarioAsisExterno = null;
					String nombre = "";
					DtUsuarioExterno usuarioExterno = new DtUsuarioExterno();
					StringBuilder msg = null;
					EmailUtil email = new EmailUtil();
					String strAsunto = "CONFIRMACIÓN DE ATENCIÓN DEL SERVICIO DE ASISTENCIA TÉCNICA DEL CONECTAMEF";// MPINARES
																													// 17052023
																													// -
																													// INICIO
					String temaTotal = "";
					String especialistaSisAdmTotal = "";

					for (DtAsistenciaUsuexternosBk participanteAsis : participantes) {
						if (participanteAsis.getCorreoUsuext() != null && !participanteAsis.getCorreoUsuext().isEmpty())
							recipients.add(participanteAsis.getCorreoUsuext());
						idUsuarioAsisExterno = participanteAsis.getIdAsistUsuext();
						for (DtAsistenciaTemasBk dtAsisTema : temas) {
							if (!temaTotal.trim().toUpperCase()
									.contains(dtAsisTema.getIdTemaTxt().trim().toUpperCase())) {
								temaTotal = temaTotal + " " + dtAsisTema.getIdTemaTxt().trim() + ", ";
							}
							if (!especialistaSisAdmTotal.trim().toUpperCase().contains(
									(dtAsistenciaBke.getIdUsuinternoTxt().trim().toLowerCase()).trim().toUpperCase())) {
								especialistaSisAdmTotal = especialistaSisAdmTotal + " "
										+ FuncionesStaticas.convertirFrasePrimerCaracMayúscula(
												dtAsistenciaBke.getIdUsuinternoTxt().trim().toLowerCase())
										+ ".";
							}
						}
						if (temaTotal != null && !temaTotal.isEmpty()) {
							temaTotal = FuncionesStaticas
									.convertirFrasePrimerCaracMayúscula(temaTotal.trim().toLowerCase());
							especialistaSisAdmTotal = especialistaSisAdmTotal.trim();

						}
						if (recipients != null && !recipients.isEmpty()) {

							usuarioExterno = dtUsuarioExternoDao
									.getDtUsuarioExterno(participanteAsis.getIdUsuexterno());
							if (usuarioExterno != null)
								nombre = FuncionesStaticas
										.convertirFrasePrimerCaracMayúscula(usuarioExterno.getNombre().toLowerCase())
										+ " " + FuncionesStaticas.convertirFrasePrimerCaracMayúscula(
												usuarioExterno.getApaterno().toLowerCase());

							msg = new StringBuilder();

							// MPINARES 17052023 - INICIO
							msg.append("<table align='center' width='100%'>");
							msg.append("<tr><td width='50%' align='left'><img src='" + url + "/images/u2.png'></td>");
							msg.append("<td width='50%' align='right'><img src='" + url + "/images/u0.png'></td></tr>");
							msg.append("</table> </br>");
							msg.append(
									"<div style='padding:11px;line-height:50px;background:#FFFFFF;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-ms-border-radius:5px; width:100%'>");
							msg.append(
									"<div valign='middle' height='28px' style='line-height:28px;font-size:20px;background-color:#FFFFFF;'>Estimado(a),  <b>"
											+ nombre + ":</b></br></br></div>");
							msg.append(
									"<div valign='middle' height='28px' style='line-height:28px;font-size:20px;background-color:#FFFFFF;'>Para corroborar que ha recibido <b>Asistencia Técnica Virtual</b> sobre <b>"
											+ temaTotal.toUpperCase() + "</b> el día <b>"
											+ (dtAsistenciaBke.getFechaAsistencia() != null
													? FuncionesStaticas
															.getfechaLargaFormateadaSinHoraAnio(new Timestamp(
																	dtAsistenciaBke.getFechaAsistencia().getTime()))
													: "")
											+ "</b>, por el/la servidor/a del CONECTAMEF, <b>"
											+ especialistaSisAdmTotal.toUpperCase()
											+ "</b></br></br>Agradeceremos pueda confirmar la atención de este servicio dando clic en el botón de líneas abajo. "
											+ " </div>");

							msg.append(
									"<div valign='middle' height='28px' style='line-height:28px;font-size:19px;background-color:#FFFFFF;'></br>¡Gracias!</div>");
							msg.append(
									"<div valign='middle' height='50px' style='line-height:50px; font-size:19px;background-color:#FFFFFF;color:red;font-weight:bold'>Equipo CONECTAMEF</br></br></div>");
							msg.append("</div>");
							msg.append(
									"<div align='center' valign='middle' height='28px' style='font-size:20px;line-height:28px;align:center !important;valign:middle;background:#C8000E;-webkit-border-radius:1px;-moz-border-radius:1px;border-radius:1px;-ms-border-radius:1px; width:80%'>");
							msg.append("<a style=text-decoration:none; width: 210px;  href='" + url + "?idu="
									+ idUsuarioAsisExterno + "&ids=" + dtAsistenciaBke.getIdAsistencia()
									+ "'><font color=white><b>CLIC AQUÍ PARA CONFIRMAR ATENCIÓN</b></font></a>");
							msg.append("</div>");
							// MPINARES 17052023 - FIN
							log.log(Level.INFO,
									" INICIO INSTANCIANDO EL ENVIO AL SERVIDOR DE CORREO: idUsuarioExterno= "
											+ idUsuarioAsisExterno + " nombre= " + nombre
											+ " tipoServicio= ASISTENCIA TÉCNICA " + " idServicio= "
											+ dtAsistenciaBke.getIdAsistencia() + " fechaServicio="
											+ dtAsistenciaBke.getFechaAsistencia());
							email = new EmailUtil();
							email.sendEmail(recipients, null, null, strAsunto, msg.toString());

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		myThread.start();

	}

	public DtAsistenciaBk finalizarDtAsistenciaBk(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);

		dtAsistenciaBk.setIdusserModif(kyUsuarioMod);
		dtAsistenciaBk.setFechaFinalizacion(hoy);
		dtAsistenciaBk.setEstado(estadoFinalizado);

		this.saveorupdateDtAsistenciaBk(dtAsistenciaBk, user, kyUsuarioMod, kyAreaMod, rmtaddress, null);

		if (dtAsistenciaBk != null) {
			Long idTipoServicioAsistencia = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN);

			System.out.println("idTipoServicioAsistencia: " + idTipoServicioAsistencia);

			this.enviarEncuestaPorCorreo((dtAsistenciaBk.getDetalle() != null ? dtAsistenciaBk.getDetalle() : ""),
					dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss(), idTipoServicioAsistencia,
					dtAsistenciaBk.getIdAsistencia(), dtAsistenciaBk.getFechaAsistencia(), "HTTP://URL", hoy);

			this.encuesta(dtAsistenciaBk, kyUsuarioMod, idTipoServicioAsistencia);

		}

		return dtAsistenciaBk;
	}

	private void encuesta(DtAsistenciaBk dtAsistenciaBk, Long kyUsuarioMod, Long idTipoServicioAsistencia)
			throws Validador {
		DtEncuestaBk encuesta = new DtEncuestaBk();
		encuesta = this.getIdEncuesta(idTipoServicioAsistencia, dtAsistenciaBk.getFechaAsistencia().getTime(),
				dtAsistenciaBk.getIdAsistencia());// SPRINT_6

		// INICIO CUSCATA - 10072024
		if (encuesta != null) {
			encuesta.setIdusserModif(kyUsuarioMod);
		}
		// FIN CUSCATA - 10072024

		if (encuesta == null || encuesta.getIdEncuesta() == null || encuesta.getIdEncuesta().longValue() < 1) {
			System.out.println(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo") + " IdTipoServicio="
					+ idTipoServicioAsistencia + " idServicio=" + dtAsistenciaBk.getIdAsistencia() + " fechaServicio="
					+ dtAsistenciaBk.getFechaAsistencia());
		}

		if (encuesta != null) {
			this.updateBloqueoEncuesta(encuesta);
		}
	}

	public void updateBloqueoEncuesta(DtEncuestaBk dtEncuestaBk) throws Validador {

		if (dtEncuestaBk.getIdEncuesta() != null) {
			Long flagBloqueado = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI,
					PropertiesMg.DEFAULT_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI);

			DtEncuesta encuesta = dtEncuestaDao.getDtEncuesta(dtEncuestaBk.getIdEncuesta());

			encuesta.setFlagBloqueo(flagBloqueado);

			encuesta.setIdusserModif(dtEncuestaBk.getIdusserModif());
			encuesta.setFechaModif(new Timestamp(System.currentTimeMillis()));
			encuesta.setRtmaddressrst(dtEncuestaBk.getRtmaddress());
			dtEncuestaDao.updateDtEncuesta(encuesta);
		}

	}

	// INICIO CUSCATA - 10072024
	public void enviarEncuestaPorCorreo(String descpServicio, Collection<?> participantes, Long tipoServicio,
			Long idServicio, Date fechaServicio, String url, Timestamp fechaFinalizacion) throws Validador { // VBALDEONH

		// FIN CUSCATA - 10072024
		// SPRINT5 INICIO
		log.log(Level.INFO, "INICIO DE  enviarEncuestaPorCorreo");// SPRINT53
		String formatoJson = null;
		DtEncuestaBk encuesta = new DtEncuestaBk();// SPRINT17
		try {

			// DtEncuestaBk encuesta = getIdEncuesta(tipoServicio,
			// fechaServicio.getTime());
			encuesta = getIdEncuesta(tipoServicio, fechaServicio.getTime(), idServicio);// SPRINT_6
			if (encuesta == null || encuesta.getIdEncuesta() == null || encuesta.getIdEncuesta().longValue() < 1) {
				System.out.println(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo") + " IdTipoServicio="
						+ tipoServicio + " idServicio=" + idServicio + " fechaServicio=" + fechaServicio);
				return;
			} else {
				formatoJson = FuncionesStaticas.getTextFromFile(
						FuncionesStaticas.getServerFile("encuesta-" + encuesta.getIdEncuesta() + ".json"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo") + " IdTipoServicio="
					+ tipoServicio + " idServicio=" + idServicio + " fechaServicio=" + fechaServicio);
			System.out.println(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo") + " IdTipoServicio="
					+ tipoServicio + " idServicio=" + idServicio + " fechaServicio=" + fechaServicio);
		}

		if (formatoJson == null || formatoJson.trim().length() <= 1) {
			System.out.println(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo") + " IdTipoServicio="
					+ tipoServicio + " idServicio=" + idServicio + " fechaServicio=" + fechaServicio);
			System.out.println(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo") + " IdTipoServicio="
					+ tipoServicio + " idServicio=" + idServicio + " fechaServicio=" + fechaServicio);
			return;
		}

		// VBALDEONH SPRINT2 INCIO
		Thread myThread = new Thread() {
			public void run() {
				try {

					List<String> recipients = new ArrayList<String>();
					Long idUsuarioExterno = null;

					// SPRINT6 INICIO
					PrtParametrosBk parametroBk = getParametro(tipoServicio);
					String descripcionTipoServicio = parametroBk == null ? "" : parametroBk.getDescripcion();

					String nombre = "";

					DtUsuarioExterno usuarioExterno = new DtUsuarioExterno();
					StringBuilder msg = null;
					EmailUtil email = new EmailUtil();

					Long idAsisteSi = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ASISTENCIA_SI,
							PropertiesMg.DEFAULT_PRTPARAMETROS_ASISTENCIA_SI);
					String strAsunto = "ENCUESTA DE CALIDAD DE LOS SERVICIOS DE LOS CONECTAMEF ─ "
							+ descripcionTipoServicio;// SPRINT_8

					for (Object participante : participantes) {
						recipients = new ArrayList<String>(); // SPRINT6
						if (participante instanceof DtAsistenciaUsuexternosBk) {
							DtAsistenciaUsuexternosBk participanteDeAsistencia = (DtAsistenciaUsuexternosBk) participante;
							if (participanteDeAsistencia.getCorreoUsuext() != null
									&& !participanteDeAsistencia.getCorreoUsuext().isEmpty())// SPRINT6
								recipients.add(participanteDeAsistencia.getCorreoUsuext());
							idUsuarioExterno = participanteDeAsistencia.getIdUsuexterno();
						} else if (participante instanceof DtCapaUsuexternosBk) {
							DtCapaUsuexternosBk participanteDeCapacitacion = (DtCapaUsuexternosBk) participante;
							if (participanteDeCapacitacion.getFlagAsistencia() != null
									&& participanteDeCapacitacion.getFlagAsistencia().intValue() == idAsisteSi
											.intValue()
									&& participanteDeCapacitacion.getCorreoUsuext() != null
									&& !participanteDeCapacitacion.getCorreoUsuext().isEmpty())
								recipients.add(participanteDeCapacitacion.getCorreoUsuext());
							idUsuarioExterno = participanteDeCapacitacion.getIdUsuexterno();
							strAsunto = "ENCUESTA Y DESCARGA DE MATERIAL DEL SERVICIO DE CAPACITACIÓN DE LOS CONECTAMEF";// SPRINT_8
						} else if (participante instanceof DtVisitasUsuexternosBk) {
							DtVisitasUsuexternosBk participanteDeVisita = (DtVisitasUsuexternosBk) participante;
							if (participanteDeVisita.getCorreoUsuext() != null
									&& !participanteDeVisita.getCorreoUsuext().isEmpty())// SPRINT6
								recipients.add(participanteDeVisita.getCorreoUsuext());
							idUsuarioExterno = participanteDeVisita.getIdUsuexterno();
						} else if (participante instanceof DtConsultasBk) {
							DtConsultasBk participanteDeConsulta = (DtConsultasBk) participante;
							if (participanteDeConsulta.getCorreoUsuext() != null
									&& !participanteDeConsulta.getCorreoUsuext().isEmpty())// SPRINT6
								recipients.add(participanteDeConsulta.getCorreoUsuext());
							idUsuarioExterno = participanteDeConsulta.getIdUsuexterno();
						}
						// SPRINT6 INICIO

						if (recipients != null && !recipients.isEmpty()) {

							usuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(idUsuarioExterno);
							if (usuarioExterno != null)
								nombre = StringUtils.capitalize(usuarioExterno.getNombre().toLowerCase()) + " "
										+ StringUtils.capitalize(usuarioExterno.getApaterno().toLowerCase());

							msg = new StringBuilder();
							msg.append("<table align='center' width='100%'>");
							msg.append("<tr><td width='50%' align='left'><img src='" + url + "/images/u2.png'></td>");// SPRINT13
							msg.append("<td width='50%' align='right'><img src='" + url + "/images/u0.png'></td></tr>");// SPRINT13
							msg.append("</table>");
							msg.append(
									"<div style='padding:11px;line-height:50px;background:#FFFFFF;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-ms-border-radius:5px; width:100%'>");// SPRINT17
							msg.append(
									"<div align='center' valign='middle' height='28px' style='background-color:#FFFFFF;'><h2><b>Nos encantaría conocer tu opinión sobre nuestro servicio de "
											+ descripcionTipoServicio.toUpperCase() + "</b></h2></div>"); // SPRINT_3
							msg.append(
									"<div valign='middle' height='28px' style='line-height:28px;font-size:20px;background-color:#FFFFFF;'>Estimado(a),  <b>"
											+ nombre + ":</b></div>");// SPRINT13
							msg.append(
									"<div valign='middle' height='28px' style='line-height:28px;font-size:20px;background-color:#FFFFFF;'>Con la finalidad de continuar mejorando el servicio de "
											+ descripcionTipoServicio.toLowerCase()
											+ " que brindan los CONECTAMEF a  nivel nacional, agradeceríamos puedas responder una breve encuesta sobre tu experiencia como participante en la  "
											+ descripcionTipoServicio.toLowerCase()
											+ (descpServicio.length() < 1 ? "" : " \"<b>" + descpServicio + "\" </b>")
											+ " realizada el  "
											+ (fechaServicio != null ? (descripcionTipoServicio.contains("CAPACITAC")
													? FuncionesStaticas.getfechaLargaFormateadaConEstilo(
															new Timestamp(fechaServicio.getTime()))
													: FuncionesStaticas.getfechaLargaFormateadaSinHora(
															new Timestamp(fechaServicio.getTime())))
													: "")
											+ " </div>"); // SPRINT_3
							msg.append(
									"<div valign='middle' height='28px' style='line-height:28px;font-size:19px;background-color:#FFFFFF;'></br>¡Gracias por participar!</div>");// SPRINT17
							msg.append(
									"<div valign='middle' height='50px' style='line-height:50px; font-size:19px;background-color:#FFFFFF;color:red;font-weight:bold'>Equipo CONECTAMEF</br></br></div>"); // SPRINT17
							msg.append("</div>");
							msg.append(
									"<div align='center' valign='middle' height='28px' style='font-size:20px;line-height:28px;align:center !important;valign:middle;background:#C8000E;-webkit-border-radius:1px;-moz-border-radius:1px;border-radius:1px;-ms-border-radius:1px; width:80%'>"); // SPRINT17
							msg.append("<a style=text-decoration:none; width: 210px;  href='" + url
									+ "/encuesta/formPreguntas.htm?tps=" + tipoServicio + "&fcf="
									+ fechaFinalizacion.getTime() + "&idu=" + idUsuarioExterno + "&ids=" + idServicio
									+ "&fcs=" + fechaServicio.getTime()
									+ "'><font color=white><b>CLIC AQUÍ PARA TOMAR ENCUESTA</b></font></a>"); // VBALDEONH
																												// SPRINT2
																												// //VBALDEONH
																												// SPRINT4
							msg.append("</div>");

							log.log(Level.INFO,
									" INICIO INSTANCIANDO EL ENVIO AL SERVIDOR DE CORREO: idUsuarioExterno= "
											+ idUsuarioExterno + " nombre= " + nombre + " tipoServicio= " + tipoServicio
											+ " idServicio= " + idServicio + " fechaServicio=" + fechaServicio);// SPRINT53

							email = new EmailUtil();
							email.sendEmail(recipients, null, null, strAsunto, msg.toString()); // SPRINT_8

						}
					}
					// SPRINT6 FIN
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		myThread.start();

	}

	public Long getParametro(String key, Long defaultValue) throws Validador {
		try {
			return PropertiesMg.getSistemLong(key, defaultValue);
		} catch (Exception e) {
			throw new Validador(
					"ERROR: INESPERADO: POR FAVOR ENVIE ESTE MENSAJE AL ADMINISTRADOR DEL SISTEMA, GRACIAS.\n"
							+ e.getMessage());
		}
	}

	public DtEncuestaBk getIdEncuesta(Long idTipoServicio, Long fechaServicio, Long idServicio) throws Validador {
		DtEncuesta encuestaResultante = null;
		Long idOrigen = 0L;
		Long idPresta = 0L;
		Long idTipoServicioAsistencia = getParametro(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN);
		Long idTipoServicioCapacitacion = getParametro(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA);
		Long idTipoServicioVisita = getParametro(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA);
		Long idTipoServicioConsulta = getParametro(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA);

		// if (idTipoServicio.longValue() ==
		// idTipoServicioAsistencia.longValue()) {
		if (String.valueOf(idTipoServicio).equals(String.valueOf(idTipoServicioAsistencia))) {
			DtAsistencia dtAsistencia = dtAsistenciaDao.getDtAsistencia(idServicio);
			if (dtAsistencia != null)
				idOrigen = dtAsistencia.getIdOrigen();
			// } else if (idTipoServicio.longValue() ==
			// idTipoServicioCapacitacion.longValue()) {
		} else if (String.valueOf(idTipoServicio).equals(String.valueOf(idTipoServicioCapacitacion))) {
			DtCapacitacion dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(idServicio);
			if (dtCapacitacion != null) {
				idOrigen = dtCapacitacion.getIdOrigen();
				idPresta = dtCapacitacion.getIdPrestacion();
			}
			// } else if (idTipoServicio.longValue() ==
			// idTipoServicioVisita.longValue()) {
		} else if (String.valueOf(idTipoServicio).equals(String.valueOf(idTipoServicioVisita))) {
			DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(idServicio);
			if (dtVisitas != null)
				idOrigen = dtVisitas.getIdOrigen();
			// } else if (idTipoServicio.longValue() ==
			// idTipoServicioConsulta.longValue()) {
		} else if (String.valueOf(idTipoServicio).equals(String.valueOf(idTipoServicioConsulta))) {
			DtConsultas dtConsultas = dtConsultasDao.getDtConsultas(idServicio);
			if (dtConsultas != null)
				idOrigen = dtConsultas.getIdOrigen();
		}

		List<DtEncuesta> lstEncuesta = dtEncuestaDao.findListPeriodo(idTipoServicio, new Date(fechaServicio));
		if (lstEncuesta != null && lstEncuesta.size() > 0) {

			// SPRINT_6.2 INICIO
			for (DtEncuesta encuesta : lstEncuesta) {
				if (encuesta.getIdEncuesta() != null) {

					if (encuesta.getIdOrigen() != null && encuesta.getIdPrestacion() != null) {
						if (idPresta != null && idOrigen != null && idOrigen.compareTo(encuesta.getIdOrigen()) == 0
								&& idPresta.compareTo(encuesta.getIdPrestacion()) == 0) {
							encuestaResultante = encuesta;
							break;
						}
					} else if (encuesta.getIdOrigen() != null) {
						if (idOrigen != null && idOrigen.compareTo(encuesta.getIdOrigen()) == 0) {
							encuestaResultante = encuesta;
						}
					} else if (encuesta.getIdPrestacion() != null) {
						if (idPresta != null && idPresta.compareTo(encuesta.getIdPrestacion()) == 0) {
							encuestaResultante = encuesta;
						}
					}

					if (encuesta == null && (encuesta.getIdOrigen() == null || encuesta.getIdOrigen().intValue() == 0)
							&& (encuesta.getIdPrestacion() == null || encuesta.getIdPrestacion().intValue() == 0)) {// SPRINT_6.3
						encuestaResultante = encuesta;
					}

					/*
					 * if(idOrigen==encuesta.getIdOrigen() &&
					 * idTipoServicioAsistencia == idTipoServicio) {
					 * encuestaResultante = encuesta; break; }
					 */
					// PARA PROBAR
					if (String.valueOf(idTipoServicioAsistencia).equals(String.valueOf(idTipoServicio))) {
						encuestaResultante = encuesta;
					}

				}

			}

		}

		DtEncuestaBk encuestaBk = toBeanBk(encuestaResultante, DtEncuestaBk.class);
		/*
		 * if (encuestaBk == null) { PrtParametrosBk parametro =
		 * getParametro(idTipoServicio); if (parametro == null) return
		 * encuestaBk; // throw new Validador("No se encontró el // tipo de
		 * servicio"); else return encuestaBk; // throw new Validador("No se
		 * encontró
		 * 
		 * } else { return encuestaBk; }
		 */
		return encuestaBk;

	}
	// INICIO CUSCATA - 10072024

	public PrtParametrosBk getParametro(Long idParametro) throws Validador {
		PrtParametrosBk prtParametrosBk = new PrtParametrosBk();
		PrtParametros prtParametro = prtParametrosDao.getPrtParametros(idParametro);
		FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametro);
		return prtParametrosBk;
	}

	public <T> T toBeanBk(Object objDomain, Class<T> classBk) throws Validador {
		if (objDomain == null)
			return null;
		try {
			Object objBk = classBk.newInstance();
			BeanUtils.copyProperties(objDomain, objBk);
			PropertyDescriptor[] atributos = Introspector.getBeanInfo(objDomain.getClass()).getPropertyDescriptors();
			for (PropertyDescriptor atributo : atributos) {
				try {
					if (!DtServicioBk.esCampoSinDescripcion(atributo.getName())) {
						BeanWrapper bwDomain = new BeanWrapperImpl(objDomain);
						BeanWrapper bwBk = new BeanWrapperImpl(objBk);
						Long valorId = Long.parseLong((bwDomain.getPropertyValue(atributo.getName()).toString()));
						// if(atributo.getName().startsWith("tipo")) {
						if (DtServicioBk.esCampoDePrtParametro(atributo.getName())) {
							PrtParametros parametro = prtParametrosDao.getPrtParametros(valorId);
							try {
								String descripcionParametro = parametro.getDescripcion() != null
										&& parametro.getDescripcion().equalsIgnoreCase("Eliminado") ? "ANULADO"
												: parametro.getDescripcion();
								bwBk.setPropertyValue(atributo.getName() + "_txt", descripcionParametro);
							} catch (NotWritablePropertyException nwpe) {
								bwBk.setPropertyValue("descripcion" + StringUtils.capitalize(atributo.getName()),
										parametro.getDescripcion());
							}
						}
						if (atributo.getName().equals("idUsuexterno")) {
							DtUsuarioExterno usuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(valorId);
							bwBk.setPropertyValue("dniUser", usuarioExterno.getNumDocu());
							bwBk.setPropertyValue("idUsuexterno_txt",
									StringUtils.defaultString(usuarioExterno.getNombre(), "") + " "
											+ StringUtils.defaultString(usuarioExterno.getApaterno(), "") + " "
											+ StringUtils.defaultString(usuarioExterno.getAmaterno(), ""));
							bwBk.setPropertyValue("correoUsuext", usuarioExterno.getCorreo());
							bwBk.setPropertyValue("fijoUsuext", usuarioExterno.getOtroTelefono());
							bwBk.setPropertyValue("celularUsuext", usuarioExterno.getOtroCelular());
						}
						if (atributo.getName().equals("idSede")) {
							MsSedes sede = msSedesDao.getMsSedes(valorId);
							try {
								bwBk.setPropertyValue("idSede_txt", sede.getSede());
							} catch (NotWritablePropertyException nwpe) {
								bwBk.setPropertyValue("nombreSede", sede.getSede());
							}
						}
						if (atributo.getName().contains("idSistAdm") || atributo.getName().contains("idSistAdmi")
								|| atributo.getName().contains("id_sist_admi")) {
							MsSisAdmistrativo sistemaAdministrativo = msSisAdmistrativoDao
									.getMsSisAdmistrativo(valorId);
							try {
								bwBk.setPropertyValue("nombreSistAdmi", sistemaAdministrativo.getDescripcion());
							} catch (NotWritablePropertyException nwpe) {
								try {
									bwBk.setPropertyValue("idSistAdm_txt", sistemaAdministrativo.getDescripcion());
								} catch (NotWritablePropertyException nwpe2) {
									try {
										bwBk.setPropertyValue("idSistAdmi_txt", sistemaAdministrativo.getDescripcion());
									} catch (NotWritablePropertyException nwpe3) {
										bwBk.setPropertyValue("id_sist_admi_txt",
												sistemaAdministrativo.getDescripcion());
									}
								}
							}
						}
						if (atributo.getName().equals("idProyecto")) {
							MsProyectoInversion proyecto = msProyectoInversionDao.findByPk(valorId);
							bwBk.setPropertyValue("codigo", proyecto.getCodigo());
							bwBk.setPropertyValue("nombre", proyecto.getNombre());
						}
						if (atributo.getName().equals("idEntidad")) {
							DtEntidades entidad = dtEntidadesDao.getDtEntidades(valorId);
							bwBk.setPropertyValue("idEntidad_txt", entidad.getRazSocial());
							try {
								bwBk.setPropertyValue("codEjec", entidad.getCodEjec());
							} catch (NotWritablePropertyException nwpe) {
								bwBk.setPropertyValue("codEjecutora", entidad.getCodEjec());
							}
							bwBk.setPropertyValue("codEntidad_txt",
									entidad.getCodEjec() + " " + entidad.getRazSocial());
						}
						if (atributo.getName().equals("idLocal")) {
							MsLocal local = msLocalDao.getMsLocal(valorId);
							bwBk.setPropertyValue("idLocal_txt", local.getDescripcion());
						}
						if (atributo.getName().equals("idTema") || atributo.getName().equals("id_tema")) {
							MsTema tema = msTemasDao.getMsTema(valorId);
							bwBk.setPropertyValue("idTema_txt", tema.getDescripcion());
						}
						bwDomain = null;
						bwBk = null;
					}
				} catch (Exception e) {
					// e.printStackTrace();
					System.out
							.println("WARNING: [toBeanBk] No se pudo obtener la descripción de " + atributo.getName());
				}
			}
			return (T) objBk;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		// IVILLAFANA 23052019 FIN

	}
	// FIN CUSCATA - 18062024

	@Override
	public void deleteDtAsistencia(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtAsistencia dtAsistencia = null;
			if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {

				// MPINARES 13022024 - INICIO
				// dtAsistenciaBk =
				// getDtAsistenciaBkXidV2(dtAsistenciaBk.getIdAsistencia());

				if (dtAsistenciaBk.isFinalizado()) {
					throw new Validador(MessageFormat.format(
							"NO ES POSIBLE ANULAR UN REGISTRO FINALIZADO, ID: " + dtAsistenciaBk.getIdAsistencia(),
							Messages.getStringToKey("dtAsistencias.titulotabla")));
				}

				if (dtAsistenciaBk.isAnulado()) {
					throw new Validador(MessageFormat.format(
							"LA ASISTENCIA TÉCNICA DE ID: " + dtAsistenciaBk.getIdAsistencia()
									+ " YA SE ENCUENTRA ANULADA",
							Messages.getStringToKey("dtAsistencias.titulotabla")));
				}
				// MPINARES 13022024 - FIN

				dtAsistencia = dtAsistenciaDao.getDtAsistencia(dtAsistenciaBk.getIdAsistencia());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistencia.setRtmaddressrst(rmtaddress);
				dtAsistencia.setIdusserModif(kyUsuarioMod);
				dtAsistencia.setFechaModif(hoy);
				Long estadoanterior = dtAsistencia.getEstado();
				dtAsistencia.setEstado(Estado.ELIMINADO.getValor());

				dtAsistenciaDao.updateDtAsistencia(dtAsistencia);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistencia" + " :: " + dtAsistencia.getIdAsistencia().toString() + " :: "
								+ estadoanterior + " :: " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtAsistencia(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtAsistencia dtAsistencia = null;
			if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {

				dtAsistencia = dtAsistenciaDao.getDtAsistencia(dtAsistenciaBk.getIdAsistencia());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistencia.setRtmaddressrst(rmtaddress);
				dtAsistencia.setIdusserModif(kyUsuarioMod);
				dtAsistencia.setFechaModif(hoy);
				Long estadoanterior = dtAsistencia.getEstado();
				dtAsistencia.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaDao.updateDtAsistencia(dtAsistencia);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistencia" + " :: " + dtAsistencia.getIdAsistencia().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtAsistenciaBk> getDtAsistenciaXFiltro(Long idEntidad, Long idSede, Timestamp fechaAsistencia,
			Long idUsuinterno, Long idSistAdm, Long idOrigen, Long idProgramacion, Long estado, Long kyUsuarioMod) {
		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistenciasss = dtAsistenciaDao.getXFiltro(idEntidad, idSede, fechaAsistencia,
					idUsuinterno, idSistAdm, idOrigen, idProgramacion, estado);
			for (DtAsistencia dtAsistencia : dtAsistenciasss) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																	// 18062024
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}

	@Override
	public List<DtAsistenciaBk> getDtAsistenciaXFiltro(Long idEntidad, Long idSede, Timestamp fechaAsistencia,
			Long idUsuinterno, Long idSistAdm, Long idOrigen, Long idProgramacion, Long estado, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistenciasss = dtAsistenciaDao.getXFiltro(idEntidad, idSede, fechaAsistencia,
					idUsuinterno, idSistAdm, idOrigen, idProgramacion, estado, inicial, MAX);
			for (DtAsistencia dtAsistencia : dtAsistenciasss) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																	// 18062024
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}

	@Override
	public Long getDtAsistenciaTotalXFiltro(Long idEntidad, Long idSede, Timestamp fechaAsistencia, Long idUsuinterno,
			Long idSistAdm, Long idOrigen, Long idProgramacion, Long estado, Long kyUsuarioMod) {
		try {
			Long totalDtAsistenciasss = dtAsistenciaDao.getTotalXFiltro(idEntidad, idSede, fechaAsistencia,
					idUsuinterno, idSistAdm, idOrigen, idProgramacion, estado);

			return totalDtAsistenciasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtAsistenciaBk(DtAsistenciaBk dtAsistenciaBk, Long kyUsuarioMod) {
		DtAsistenciaACL dtAsistenciaACL = new DtAsistenciaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIA_CREA)) {
					dtAsistenciaACL.setEsEditable(true);
					dtAsistenciaACL.setEliminar(true);
				} else if (roles.contains(Roles.DTASISTENCIA_VE)) {
					dtAsistenciaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIA_CREA)) {
					dtAsistenciaACL.setEditopcion(1);
				} else {
					dtAsistenciaACL.setEditopcion(2);
				}

				if (roles.contains(Roles.DTENTIDADES_CREA) || roles.contains(Roles.ADMINISTRADOR)
						|| roles.contains(Roles.PERFIL_USU_OGC)) {
					dtAsistenciaACL.setAddEntidad(true);
				}
				// MPINARES 24012023 - INICIO
				if (((roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_USU_OGC))
						&& (dtAsistenciaBk.isFinalizado() || dtAsistenciaBk.isAnulado()))
						|| (roles.contains(Roles.REACTIVA_FINLIZADOS) && dtAsistenciaBk.isFinalizado())
						|| (roles.contains(Roles.REACTIVA_ANULADOS) && dtAsistenciaBk.isAnulado())) {
					dtAsistenciaACL.setReactivar(true);
				}
				// MPINARES 24012023 - FIN
			} else {
				dtAsistenciaACL.setEditopcion(2);
			}
		} else {
			dtAsistenciaACL.setEditopcion(2);
		}
		dtAsistenciaBk.setDtAsistenciaACL(dtAsistenciaACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL dtEntidadesDao
	 * 
	 **/
	@Override
	public List<IDValorDto> getDtEntidadesIdEntidadIdEntidad() {
		if (dtEntidadesIdEntidadIdEntidadListaCache == null) {
			List<DtEntidades> dtEntidadessss = dtEntidadesDao.getListaIdEntidad();
			dtEntidadesIdEntidadIdEntidadListaCache = new ArrayList<IDValorDto>();
			for (DtEntidades dtEntidades : dtEntidadessss) {
				IDValorDto idEntidadDto = new IDValorDto(dtEntidades.getIdEntidad(), dtEntidades.getRazSocial());
				dtEntidadesIdEntidadIdEntidadListaCache.add(idEntidadDto);
			}
		}
		return dtEntidadesIdEntidadIdEntidadListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdOrigen() {
		if (prtParametrosIdparametroIdOrigenListaCache == null) {
			// MPINARES 24012023 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("ORIGEN");
			// MPINARES 24012023 - FIN
			prtParametrosIdparametroIdOrigenListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdOrigenListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdOrigenListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdModalidad() {
		if (prtParametrosIdparametroIdModalidadListaCache == null) {
			// MPINARES 24012023 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("MODALIDAD DE SERVICIO");
			// MPINARES 24012023 - FIN
			prtParametrosIdparametroIdModalidadListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdModalidadListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdModalidadListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdFinancia() {
		if (prtParametrosIdparametroIdFinanciaListaCache == null) {
			// MPINARES 24012023 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("TIPO DE FINANCIAMIENTO");
			// MPINARES 24012023 - FIN
			prtParametrosIdparametroIdFinanciaListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdFinanciaListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdFinanciaListaCache;
	}

	/**
	 * DT_CAPACITACION SERVICIO: LISTA DE LOS DATOS REGISTRADOS EN UNA
	 * CAPACITACIÓN
	 */
	@Override
	public DtCapacitacionBk getDtCapacitacionBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCapacitacion dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(id);
		DtCapacitacionBk dtCapacitacionBk = null;
		if (dtCapacitacion != null) {
			dtCapacitacionBk = new DtCapacitacionBk();
			FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
			completarDtCapacitacion(dtCapacitacionBk);
			if (kyUsuarioMod != null)
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
		}
		return dtCapacitacionBk;
	}

	@Override
	public List<DtCapacitacionBk> getAllDtCapacitacionActivos(Long kyUsuarioMod) {
		List<DtCapacitacionBk> dtCapacitacionBkss = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacions = dtCapacitacionDao.getActivasDtCapacitacion();
			for (DtCapacitacion dtCapacitacion : dtCapacitacions) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
				dtCapacitacionBkss.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBkss;
	}

	@Override
	public List<DtCapacitacionBk> getAllDtCapacitacionActivosCero(Long kyUsuarioMod) {
		List<DtCapacitacionBk> dtCapacitacionBkss = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacions = dtCapacitacionDao.getActivasDtCapacitacionCero();
			for (DtCapacitacion dtCapacitacion : dtCapacitacions) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
				dtCapacitacionBkss.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBkss;
	}

	private void completarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk) {
		try {
			if (dtCapacitacionBk.getIdSistAdm() != null && dtCapacitacionBk.getIdSistAdm().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtCapacitacionBk.getIdSistAdm());
				if (msSisAdmistrativo != null)
					dtCapacitacionBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdUsuinterno() != null && dtCapacitacionBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtCapacitacionBk.getIdUsuinterno());
				if (msUsuarios != null)
					// dtCapacitacionBk.setIdUsuinternoTxt(msUsuarios.getNombres());
					dtCapacitacionBk.setIdUsuinternoTxt(msUsuarios.getNombres() + " " + msUsuarios.getApellidoPaterno()
							+ " " + msUsuarios.getApellidoMaterno());// MPINARES
																		// 14022024
																		// -
																		// INICIO
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdModalidad() != null && dtCapacitacionBk.getIdModalidad().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdModalidad());
				if (prtParametros != null)
					dtCapacitacionBk.setIdModalidadTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdProgramacion() != null && dtCapacitacionBk.getIdProgramacion().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdProgramacion());
				if (prtParametros != null)
					dtCapacitacionBk.setIdProgramacionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try{
		// if(dtCapacitacionBk.getEstado()!=null &&
		// dtCapacitacionBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtCapacitacionBk.getEstado());
		// if(prtParametros!=null)
		// dtCapacitacionBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// MPINARES 14022024 - INICIO

		try {
			if (dtCapacitacionBk.getEstado() != null && dtCapacitacionBk.getEstado().longValue() > 0) {
				Long estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
				Long estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
				if (dtCapacitacionBk.getEstado().longValue() == estadoNuevo) {
					dtCapacitacionBk.setEstadoTxt("EN PROCESO");
				} else if (dtCapacitacionBk.getEstado().longValue() == estadoEliminado) {
					dtCapacitacionBk.setEstadoTxt("ANULADO");
				} else {
					PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getEstado());
					if (prtParametros != null)
						dtCapacitacionBk.setEstadoTxt(prtParametros.getDescripcion());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// MPINARES 14022024 - FIN

		try {
			if (dtCapacitacionBk.getIdLocal() != null && dtCapacitacionBk.getIdLocal().longValue() > 0) {
				MsLocal msLocal = msLocalDao.getMsLocal(dtCapacitacionBk.getIdLocal());
				if (msLocal != null)
					dtCapacitacionBk.setIdLocalTxt(msLocal.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdModo() != null && dtCapacitacionBk.getIdModo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdModo());
				if (prtParametros != null)
					dtCapacitacionBk.setIdModoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdNivel() != null && dtCapacitacionBk.getIdNivel().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdNivel());
				if (prtParametros != null)
					dtCapacitacionBk.setIdNivelTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdOrigen() != null && dtCapacitacionBk.getIdOrigen().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdOrigen());
				if (prtParametros != null)
					dtCapacitacionBk.setIdOrigenTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdPrestacion() != null && dtCapacitacionBk.getIdPrestacion().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdPrestacion());
				if (prtParametros != null)
					dtCapacitacionBk.setIdPrestacionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdTipo() != null && dtCapacitacionBk.getIdTipo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdTipo());
				if (prtParametros != null)
					dtCapacitacionBk.setIdTipoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdSede() != null && dtCapacitacionBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtCapacitacionBk.getIdSede());
				if (msSedes != null)
					dtCapacitacionBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapacitacionBk.getIdFinancia() != null && dtCapacitacionBk.getIdFinancia().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapacitacionBk.getIdFinancia());
				if (prtParametros != null)
					dtCapacitacionBk.setIdFinanciaTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// MPINARES 14022024 - INICIO
		if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {
			// DTCAPATEMAS
			List<DtCapaTemas> dtCapaTemasList = dtCapaTemasDao
					.getByIdCapacDtCapaTemas(dtCapacitacionBk.getIdCapacitacion());
			List<DtCapaTemasBk> dtCapaTemasBkLista = new ArrayList<DtCapaTemasBk>();
			if (dtCapaTemasList != null && dtCapaTemasList.size() > 0) {
				List<String> temas = new ArrayList<String>();
				for (DtCapaTemas dtCapaTemas : dtCapaTemasList) {
					DtCapaTemasBk dtCapaTemasBk = new DtCapaTemasBk();
					FuncionesStaticas.copyPropertiesObject(dtCapaTemasBk, dtCapaTemas);
					completarDtCapaTemas(dtCapaTemasBk);
					dtCapaTemasBkLista.add(dtCapaTemasBk);

					MsTema msTema = msTemaDao.getMsTema(dtCapaTemas.getIdTema());
					if (msTema != null) {
						temas.add(msTema.getDescripcion());
					}
				}
				dtCapacitacionBk.setTemas(temas);
				dtCapacitacionBk.setDtCapaTemasBkJSss(dtCapaTemasBkLista);
			}

			// DTCAPAPUBLICO
			List<DtCapaPublico> dtCapaPublicoList = dtCapaPublicoDao
					.getByIdCapacDtCapaPublico(dtCapacitacionBk.getIdCapacitacion());
			List<DtCapaPublicoBk> dtCapaPublicoBkLista = new ArrayList<DtCapaPublicoBk>();
			if (dtCapaPublicoList != null && dtCapaPublicoList.size() > 0) {
				for (DtCapaPublico dtCapaPublicoo : dtCapaPublicoList) {
					DtCapaPublicoBk dtCapaPublicoBk = new DtCapaPublicoBk();
					FuncionesStaticas.copyPropertiesObject(dtCapaPublicoBk, dtCapaPublicoo);
					completarDtCapaPublico(dtCapaPublicoBk);
					dtCapaPublicoBkLista.add(dtCapaPublicoBk);
				}
				dtCapacitacionBk.setDtCapaPublicoBkJSss(dtCapaPublicoBkLista);
			}

			// DTCAPAENTIDADES
			List<DtCapaEntidades> dtCapaEntidadesList = dtCapaEntidadesDao
					.getByIdCapacDtCapaEntidades(dtCapacitacionBk.getIdCapacitacion());
			List<DtCapaEntidadesBk> dtCapaEntidadesBkLista = new ArrayList<DtCapaEntidadesBk>();
			if (dtCapaEntidadesList != null && dtCapaEntidadesList.size() > 0) {
				List<String> entidadss = new ArrayList<String>();
				for (DtCapaEntidades dtCapaEntidadesa : dtCapaEntidadesList) {
					DtCapaEntidadesBk dtCapaEntidadesBk = new DtCapaEntidadesBk();
					FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesBk, dtCapaEntidadesa);
					completarDtCapaEntidades(dtCapaEntidadesBk);
					dtCapaEntidadesBkLista.add(dtCapaEntidadesBk);

					DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtCapaEntidadesa.getIdEntidad());
					if (dtEntidades != null) {
						entidadss.add(dtEntidades.getRazSocial());
					}
				}
				dtCapacitacionBk.setEntidades(entidadss);
				dtCapacitacionBk.setDtCapaEntidadesBkJSss(dtCapaEntidadesBkLista);
			}

		}

		try {
			if (dtCapacitacionBk.getFlagPubli() != null && dtCapacitacionBk.getFlagPubli().longValue() > 0
					&& dtCapacitacionBk.getFlagPubli().longValue() == 1L) {
				dtCapacitacionBk.setFlagPubliTxt("SI");
			} else {
				dtCapacitacionBk.setFlagPubliTxt("NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// MPINARES 14022024 - FIN
		
		if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {
			Long idTiposervicio=PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA, PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA);
			List<DtAnexoBk> lstAnexos = this.getDtAnexoXFiltro(null, null, idTiposervicio, null,
					dtCapacitacionBk.getIdCapacitacion(), null);
			if (lstAnexos != null && !lstAnexos.isEmpty()) {
				dtCapacitacionBk.setDtAnexosBKJSss(lstAnexos);
			}
		}

	}

	@Override
	public DtCapacitacionBk saveorupdateDtCapacitacionBk(DtCapacitacionBk dtCapacitacionBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		// ValidacionDtCapacitacionMng.validarDtCapacitacionBk(dtCapacitacionBk);
		// MPINARES 14022024 - INICIO

		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);

		Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);
		DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada,
				dtCapacitacionBk.getIdSede(), dtCapacitacionBk.getIdSistAdm(), FuncionesStaticas.getMonth());
		// ***************************************************************************************************************************
		DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada, idSedeTodas,
				dtCapacitacionBk.getIdSistAdm(), FuncionesStaticas.getMonth());
		if (autorizacionProgramacion2 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion2;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion2;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada,
				dtCapacitacionBk.getIdSede(), idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion3 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion3;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion3;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada, idSedeTodas,
				idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion4 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion4;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion4;
			}
		}
		// ***************************************************************************************************************************

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);

		ValidacionDtCapacitacionMng.validarFechaInic(dtCapacitacionBk.getFechaInic());

		Integer mesServicio = dtCapacitacionBk.getFechaInic().getMonth() + 1;
		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}

		DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
				dtCapacitacionBk.getIdSede(), dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora,
																								// Mes
																								// Actual,
																								// por
																								// confirmar

		if (autorizacionEjecucion == null) {
			autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
					dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora,
																		// Mes
																		// Actual,
																		// por
																		// confirmar
			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
						dtCapacitacionBk.getIdSede(), idSisAdmTodos, mesServicio + 1);// Ahora,
																						// Mes
																						// Actual,
																						// por
																						// confirmar
				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
							idSisAdmTodos, mesServicio + 1);// Ahora, Mes
															// Actual, por
															// confirmar
				}
			}
		}

		DtCapacitacion dtCapacitacionOrig = null;
		if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {
			dtCapacitacionOrig = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());
		}

		ValidacionDtCapacitacionMng.validarDtCapacitacionBk(dtCapacitacionBk, autorizacionProgramacion,
				autorizacionEjecucion, msRolesDao.isRolAdministradorOGC(kyUsuarioMod), dtCapacitacionOrig);

		List<DtCapaPublicoBk> capaPublicos = new ArrayList<DtCapaPublicoBk>();
		Long idModoUnSistema = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDMODO_UNSISTEMA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDMODO_UNSISTEMA);
		if (dtCapacitacionBk.getDtCapaPublicoBkJSss() != null && dtCapacitacionBk.getDtCapaPublicoBkJSss().size() > 0) {

			for (DtCapaPublicoBk dtCapaPublicoBka : dtCapacitacionBk.getDtCapaPublicoBkJSss()) {
				if (dtCapaPublicoBka.getIdCargo() != null && dtCapaPublicoBka.getIdCargo().longValue() > 0) {
					capaPublicos.add(dtCapaPublicoBka);
				}
			}

			if (capaPublicos != null && capaPublicos.size() > 0) {
				dtCapacitacionBk.setDtCapaPublicoBkJSss(capaPublicos);
			} else {
				if (dtCapacitacionBk.getIdModo().longValue() == idModoUnSistema) {
					throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL PUBLICO OBJETIVO DE LA CAPACITACIÓN",
							Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}
			}
		} else {

			if (dtCapacitacionBk.getIdModo().longValue() == idModoUnSistema) {
				throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL PUBLICO OBJETIVO DE LA CAPACITACIÓN",
						Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}
		}

		if (dtCapacitacionBk.getDtCapaTemasBkJSss() == null || dtCapacitacionBk.getDtCapaTemasBkJSss().size() < 1) {
			throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL TEMA Y SUBTEMA DE LA CAPACITACIÓN",
					Messages.getStringToKey("dtCapacitacion.titulotabla")));
		}

		if (dtCapacitacionBk.getDtCapaEntidadesBkJSss() == null
				|| dtCapacitacionBk.getDtCapaEntidadesBkJSss().size() < 1) {
			throw new Validador(MessageFormat.format("DEBE SELECCIONAR LA ENTIDAD VINCULADA LA CAPACITACIÓN",
					Messages.getStringToKey("dtCapacitacion.titulotabla")));
		}

		// MPINARES 14022024 - FIN

		DtCapacitacion dtCapacitacion = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

				dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());

				boolean cambios = AuditoriaDtCapacitacionMng.auditarCambiosDtCapacitacion(dtCapacitacionBk,
						dtCapacitacion, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapacitacion.setRtmaddressrst(rmtaddress);
					dtCapacitacion.setIdusserModif(kyUsuarioMod);
					dtCapacitacion.setFechaModif(hoy);
					dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);
				}
			} else {
				dtCapacitacionBk.setRtmaddress(rmtaddress);
				dtCapacitacionBk.setRtmaddressrst(rmtaddress);

				dtCapacitacionBk.setFechaCrea(hoy);
				dtCapacitacionBk.setIdusserCrea(kyUsuarioMod);
				dtCapacitacionBk.setIdusserModif(kyUsuarioMod);
				dtCapacitacionBk.setFechaModif(hoy);
				dtCapacitacionBk.setEstado(Estado.ACTIVO.getValor());

				dtCapacitacion = new DtCapacitacion();

				FuncionesStaticas.copyPropertiesObject(dtCapacitacion, dtCapacitacionBk);
				dtCapacitacionDao.saveDtCapacitacion(dtCapacitacion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapacitacion" + " :: " + dtCapacitacion.getIdCapacitacion().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		// MPINARES 14022024 - INICIO
		DtCapaPublico dtCapaPublico = null;
		if (dtCapacitacionBk.getDtCapaPublicoBkJSss() != null && dtCapacitacionBk.getDtCapaPublicoBkJSss().size() > 0) {
			for (DtCapaPublicoBk dtCapaPublicoBka : dtCapacitacionBk.getDtCapaPublicoBkJSss()) {
				if (dtCapaPublicoBka.getIdCapaPublico() != null
						&& dtCapaPublicoBka.getIdCapaPublico().longValue() > 0) {
					// ACTUALIZAR
				} else {
					if (dtCapaPublicoBka.getIdCargo() != null && dtCapaPublicoBka.getIdCargo().longValue() > 0) {
						// NUEVO
						dtCapaPublicoBka.setIdCapaPublico(null);
						dtCapaPublicoBka.setIdCapacitacion(dtCapacitacion.getIdCapacitacion());
						dtCapaPublicoBka.setEstado(Estado.ACTIVO.getValor());
						dtCapaPublicoBka.setFechaCrea(hoy);
						dtCapaPublicoBka.setFechaModif(hoy);
						dtCapaPublicoBka.setIduserCrea(kyUsuarioMod);
						dtCapaPublicoBka.setIduserModif(kyUsuarioMod);
						dtCapaPublicoBka.setRtmaddress(rmtaddress);
						dtCapaPublicoBka.setRtmaddressrst(rmtaddress);

						dtCapaPublico = new DtCapaPublico();

						FuncionesStaticas.copyPropertiesObject(dtCapaPublico, dtCapaPublicoBka);
						dtCapaPublicoDao.saveDtCapaPublico(dtCapaPublico);

						log.log(Level.INFO,
								"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
										+ "CREADO dtCapaPublico" + " :: " + dtCapaPublico.getIdCapaPublico().toString()
										+ " :: " + "0" + " :: " + "" + Estado.ACTIVO.getValor());
					}

				}
			}
		}

		DtCapaTemas dtCapaTemas = null;
		if (dtCapacitacionBk.getDtCapaTemasBkJSss() != null && dtCapacitacionBk.getDtCapaTemasBkJSss().size() > 0) {
			for (DtCapaTemasBk dtCapaTemasBka : dtCapacitacionBk.getDtCapaTemasBkJSss()) {
				if (dtCapaTemasBka.getIdCapaTemAgen() != null && dtCapaTemasBka.getIdCapaTemAgen().longValue() > 0) {
					// ACTUALIZAR
				} else {
					// NUEVO
					dtCapaTemasBka.setIdCapaTemAgen(null);
					dtCapaTemasBka.setIdSistAdmi(kyAreaMod);
					dtCapaTemasBka.setIdUsuinterno(kyUsuarioMod);
					dtCapaTemasBka.setIdCapacitacion(dtCapacitacion.getIdCapacitacion());
					dtCapaTemasBka.setEstado(Estado.ACTIVO.getValor());
					dtCapaTemasBka.setFechaCrea(hoy);
					dtCapaTemasBka.setFechaModif(hoy);
					dtCapaTemasBka.setIdusserCrea(kyUsuarioMod);
					dtCapaTemasBka.setIdusserModif(kyUsuarioMod);
					dtCapaTemasBka.setRtmaddress(rmtaddress);
					dtCapaTemasBka.setRtmaddressrst(rmtaddress);

					dtCapaTemas = new DtCapaTemas();

					FuncionesStaticas.copyPropertiesObject(dtCapaTemas, dtCapaTemasBka);
					dtCapaTemasDao.saveDtCapaTemas(dtCapaTemas);

					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "CREADO dtCapaTemas" + " :: " + dtCapaTemas.getIdCapaTemAgen().toString() + " :: "
									+ "0" + " :: " + "" + Estado.ACTIVO.getValor());
				}
			}
		}

		DtCapaEntidades dtCapaEntidades = null;
		if (dtCapacitacionBk.getDtCapaEntidadesBkJSss() != null
				&& dtCapacitacionBk.getDtCapaEntidadesBkJSss().size() > 0) {
			for (DtCapaEntidadesBk dtCapaEntidadesBka : dtCapacitacionBk.getDtCapaEntidadesBkJSss()) {
				if (dtCapaEntidadesBka.getIdCapaEnti() != null && dtCapaEntidadesBka.getIdCapaEnti().longValue() > 0) {
					// ACTUALIZAR
				} else {
					// NUEVO
					dtCapaEntidadesBka.setIdCapaEnti(null);
					dtCapaEntidadesBka.setIdCapacitacion(dtCapacitacion.getIdCapacitacion());
					dtCapaEntidadesBka.setEstado(Estado.ACTIVO.getValor());
					dtCapaEntidadesBka.setFechaCrea(hoy);
					dtCapaEntidadesBka.setFechaModif(hoy);
					dtCapaEntidadesBka.setIdusserCrea(kyUsuarioMod);
					dtCapaEntidadesBka.setIdusserModif(kyUsuarioMod);
					dtCapaEntidadesBka.setRtmaddress(rmtaddress);
					dtCapaEntidadesBka.setRtmaddressrst(rmtaddress);

					dtCapaEntidades = new DtCapaEntidades();

					FuncionesStaticas.copyPropertiesObject(dtCapaEntidades, dtCapaEntidadesBka);
					dtCapaEntidadesDao.saveDtCapaEntidades(dtCapaEntidades);

					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "CREADO dtCapaEntidades" + " :: " + dtCapaEntidades.getIdCapaEnti().toString()
									+ " :: " + "0" + " :: " + "" + Estado.ACTIVO.getValor());
				}
			}
		}
		// MPINARES 14022024 - FIN

		dtCapacitacionBk = getDtCapacitacionBkXid(dtCapacitacion.getIdCapacitacion(), kyUsuarioMod);
		return dtCapacitacionBk;
	}

//INICIO CUSCATA - 18072024
	@Override
	public DtCapacitacionBk saveorupdateDtCapacitacionNoProg(DtCapacitacionBk dtCapacitacionBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress, List<DtAnexoBk> tdAnexosBkss) throws Validador {

		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);

		Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);
		DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada,
				dtCapacitacionBk.getIdSede(), dtCapacitacionBk.getIdSistAdm(), FuncionesStaticas.getMonth());
		// ***************************************************************************************************************************
		DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada, idSedeTodas,
				dtCapacitacionBk.getIdSistAdm(), FuncionesStaticas.getMonth());
		if (autorizacionProgramacion2 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion2;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion2;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada,
				dtCapacitacionBk.getIdSede(), idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion3 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion3;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion3;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.find(idTipoFechaCorteProgramada, idSedeTodas,
				idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion4 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion4;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion4;
			}
		}
		// ***************************************************************************************************************************

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);

		ValidacionDtCapacitacionMng.validarFechaInic(dtCapacitacionBk.getFechaInic());

		Integer mesServicio = dtCapacitacionBk.getFechaInic().getMonth() + 1;
		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}

		DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
				dtCapacitacionBk.getIdSede(), dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora,
																								// Mes
																								// Actual,
																								// por
																								// confirmar

		if (autorizacionEjecucion == null) {
			autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
					dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora,
																		// Mes
																		// Actual,
																		// por
																		// confirmar
			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
						dtCapacitacionBk.getIdSede(), idSisAdmTodos, mesServicio + 1);// Ahora,
																						// Mes
																						// Actual,
																						// por
																						// confirmar
				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
							idSisAdmTodos, mesServicio + 1);// Ahora, Mes
															// Actual, por
															// confirmar
				}
			}
		}

		DtCapacitacion dtCapacitacionOrig = null;
		if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {
			dtCapacitacionOrig = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());
		}

		ValidacionDtCapacitacionMng.validarDtCapacitacionBk(dtCapacitacionBk, autorizacionProgramacion,
				autorizacionEjecucion, msRolesDao.isRolAdministradorOGC(kyUsuarioMod), dtCapacitacionOrig);

		List<DtCapaPublicoBk> capaPublicos = new ArrayList<DtCapaPublicoBk>();
		Long idModoUnSistema = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDMODO_UNSISTEMA,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDMODO_UNSISTEMA);
		if (dtCapacitacionBk.getDtCapaPublicoBkJSss() != null && dtCapacitacionBk.getDtCapaPublicoBkJSss().size() > 0) {

			for (DtCapaPublicoBk dtCapaPublicoBka : dtCapacitacionBk.getDtCapaPublicoBkJSss()) {
				if (dtCapaPublicoBka.getIdCargo() != null && dtCapaPublicoBka.getIdCargo().longValue() > 0) {
					capaPublicos.add(dtCapaPublicoBka);
				}
			}

			if (capaPublicos != null && capaPublicos.size() > 0) {
				dtCapacitacionBk.setDtCapaPublicoBkJSss(capaPublicos);
			} else {
				if (dtCapacitacionBk.getIdModo().longValue() == idModoUnSistema) {
					throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL PUBLICO OBJETIVO DE LA CAPACITACIÓN",
							Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}
			}
		} else {

			if (dtCapacitacionBk.getIdModo().longValue() == idModoUnSistema) {
				throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL PUBLICO OBJETIVO DE LA CAPACITACIÓN",
						Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}
		}
		/*
		if (dtCapacitacionBk.getDtCapaTemasBkJSss() == null || dtCapacitacionBk.getDtCapaTemasBkJSss().size() < 1) {
			throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL TEMA Y SUBTEMA DE LA CAPACITACIÓN",
					Messages.getStringToKey("dtCapacitacion.titulotabla")));
		}

		if (dtCapacitacionBk.getDtCapaEntidadesBkJSss() == null
				|| dtCapacitacionBk.getDtCapaEntidadesBkJSss().size() < 1) {
			throw new Validador(MessageFormat.format("DEBE SELECCIONAR LA ENTIDAD VINCULADA LA CAPACITACIÓN",
					Messages.getStringToKey("dtCapacitacion.titulotabla")));
		}
		*/

		// MPINARES 14022024 - FIN

		DtCapacitacion dtCapacitacion = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

				dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());

				boolean cambios = AuditoriaDtCapacitacionMng.auditarCambiosDtCapacitacion(dtCapacitacionBk,
						dtCapacitacion, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapacitacion.setRtmaddressrst(rmtaddress);
					dtCapacitacion.setIdusserModif(kyUsuarioMod);
					dtCapacitacion.setFechaModif(hoy);
					dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);
				}
			} else {
				dtCapacitacionBk.setRtmaddress(rmtaddress);
				dtCapacitacionBk.setRtmaddressrst(rmtaddress);

				dtCapacitacionBk.setFechaCrea(hoy);
				dtCapacitacionBk.setIdusserCrea(kyUsuarioMod);
				dtCapacitacionBk.setIdusserModif(kyUsuarioMod);
				dtCapacitacionBk.setFechaModif(hoy);
				dtCapacitacionBk.setEstado(Estado.ACTIVO.getValor());

				dtCapacitacion = new DtCapacitacion();

				FuncionesStaticas.copyPropertiesObject(dtCapacitacion, dtCapacitacionBk);
				dtCapacitacionDao.saveDtCapacitacion(dtCapacitacion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapacitacion" + " :: " + dtCapacitacion.getIdCapacitacion().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		// MPINARES 14022024 - INICIO
		DtCapaPublico dtCapaPublico = null;
		if (dtCapacitacionBk.getDtCapaPublicoBkJSss() != null && dtCapacitacionBk.getDtCapaPublicoBkJSss().size() > 0) {
			for (DtCapaPublicoBk dtCapaPublicoBka : dtCapacitacionBk.getDtCapaPublicoBkJSss()) {
				if (dtCapaPublicoBka.getIdCapaPublico() != null
						&& dtCapaPublicoBka.getIdCapaPublico().longValue() > 0) {
					// ACTUALIZAR
				} else {
					// NUEVO
					dtCapaPublicoBka.setIdCapacitacion(dtCapacitacion.getIdCapacitacion());
					dtCapaPublicoBka.setEstado(Estado.ACTIVO.getValor());
					dtCapaPublicoBka.setFechaCrea(hoy);
					dtCapaPublicoBka.setFechaModif(hoy);
					dtCapaPublicoBka.setIduserCrea(kyUsuarioMod);
					dtCapaPublicoBka.setIduserModif(kyUsuarioMod);
					dtCapaPublicoBka.setRtmaddress(rmtaddress);
					dtCapaPublicoBka.setRtmaddressrst(rmtaddress);

					dtCapaPublico = new DtCapaPublico();

					FuncionesStaticas.copyPropertiesObject(dtCapaPublico, dtCapaPublicoBka);
					dtCapaPublicoDao.saveDtCapaPublico(dtCapaPublico);

					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "CREADO dtCapaPublico" + " :: " + dtCapaPublico.getIdCapaPublico().toString()
									+ " :: " + "0" + " :: " + "" + Estado.ACTIVO.getValor());
				}
			}
		}

		DtCapaTemas dtCapaTemas = null;
		if (dtCapacitacionBk.getDtCapaTemasBkJSss() != null && dtCapacitacionBk.getDtCapaTemasBkJSss().size() > 0) {
			for (DtCapaTemasBk dtCapaTemasBka : dtCapacitacionBk.getDtCapaTemasBkJSss()) {
				if (dtCapaTemasBka.getIdCapaTemAgen() != null && dtCapaTemasBka.getIdCapaTemAgen().longValue() > 0) {
					// ACTUALIZAR
				} else {
					// NUEVO
					dtCapaTemasBka.setIdCapaTemAgen(null);
					dtCapaTemasBka.setIdSistAdmi(kyAreaMod);
					dtCapaTemasBka.setIdUsuinterno(kyUsuarioMod);
					dtCapaTemasBka.setIdCapacitacion(dtCapacitacion.getIdCapacitacion());
					dtCapaTemasBka.setEstado(Estado.ACTIVO.getValor());
					dtCapaTemasBka.setFechaCrea(hoy);
					dtCapaTemasBka.setFechaModif(hoy);
					dtCapaTemasBka.setIdusserCrea(kyUsuarioMod);
					dtCapaTemasBka.setIdusserModif(kyUsuarioMod);
					dtCapaTemasBka.setRtmaddress(rmtaddress);
					dtCapaTemasBka.setRtmaddressrst(rmtaddress);

					dtCapaTemas = new DtCapaTemas();

					FuncionesStaticas.copyPropertiesObject(dtCapaTemas, dtCapaTemasBka);
					dtCapaTemasDao.saveDtCapaTemas(dtCapaTemas);

					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "CREADO dtCapaTemas" + " :: " + dtCapaTemas.getIdCapaTemAgen().toString() + " :: "
									+ "0" + " :: " + "" + Estado.ACTIVO.getValor());
				}
			}
		}

		DtCapaEntidades dtCapaEntidades = null;
		if (dtCapacitacionBk.getDtCapaEntidadesBkJSss() != null
				&& dtCapacitacionBk.getDtCapaEntidadesBkJSss().size() > 0) {
			for (DtCapaEntidadesBk dtCapaEntidadesBka : dtCapacitacionBk.getDtCapaEntidadesBkJSss()) {
				if (dtCapaEntidadesBka.getIdCapaEnti() != null && dtCapaEntidadesBka.getIdCapaEnti().longValue() > 0) {
					// ACTUALIZAR
				} else {
					// NUEVO
					dtCapaEntidadesBka.setIdCapaEnti(null);
					dtCapaEntidadesBka.setIdCapacitacion(dtCapacitacion.getIdCapacitacion());
					dtCapaEntidadesBka.setEstado(Estado.ACTIVO.getValor());
					dtCapaEntidadesBka.setFechaCrea(hoy);
					dtCapaEntidadesBka.setFechaModif(hoy);
					dtCapaEntidadesBka.setIdusserCrea(kyUsuarioMod);
					dtCapaEntidadesBka.setIdusserModif(kyUsuarioMod);
					dtCapaEntidadesBka.setRtmaddress(rmtaddress);
					dtCapaEntidadesBka.setRtmaddressrst(rmtaddress);

					dtCapaEntidades = new DtCapaEntidades();

					FuncionesStaticas.copyPropertiesObject(dtCapaEntidades, dtCapaEntidadesBka);
					dtCapaEntidadesDao.saveDtCapaEntidades(dtCapaEntidades);

					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "CREADO dtCapaEntidades" + " :: " + dtCapaEntidades.getIdCapaEnti().toString()
									+ " :: " + "0" + " :: " + "" + Estado.ACTIVO.getValor());
				}
			}
		}
		// MPINARES 14022024 - FIN
		
		Long idTiposervicio=PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA, PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA);
		
		this.cargarAnexos(tdAnexosBkss, dtCapacitacion.getIdCapacitacion(), user, kyUsuarioMod, kyAreaMod, rmtaddress, idTiposervicio);
		
		this.cargarCapaUsuexternos(dtCapacitacionBk, dtCapacitacion.getIdCapacitacion(), user, kyUsuarioMod, kyAreaMod, rmtaddress);

		dtCapacitacionBk = getDtCapacitacionBkXid(dtCapacitacion.getIdCapacitacion(), kyUsuarioMod);
		
		return dtCapacitacionBk;
	}
//FIN CUSCATA - 18072024
	
	
	private void cargarCapaUsuexternos(DtCapacitacionBk dtCapacitacionBk, Long idCapacitacion, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		
		List<DtCapaUsuexternosBk> dtCapaUsuexternosBkList =  dtCapacitacionBk.getDtCapacitacionUsuariosBkJSss();
		
		
		if(dtCapaUsuexternosBkList!=null){
			//********************************************************************************************
			//TRAE LISTA DE usuarios DE BD Y VERIFICA QUE EXISTAN EN LISTA ACTUAL
			List<DtCapaUsuexternosBk> listausuarios = getDtCapaUsuarioExtByIdDCapa(idCapacitacion);
			if(listausuarios!=null && listausuarios.size()>0){
				for (DtCapaUsuexternosBk object : listausuarios) {
					if(!dtCapaUsuexternosBkList.contains(object)){
						deleteDtCapaUsuexternos(object,user,kyUsuarioMod,kyAreaMod,rmtaddress);
					}
				}
			}
			
			//********************************************************************************************
			// para dtcapaUsuario
			if (dtCapaUsuexternosBkList != null
					&& dtCapaUsuexternosBkList.size() > 0) {
				for (DtCapaUsuexternosBk dtCapaUsuexternosBkka : dtCapaUsuexternosBkList) {
					
					if(dtCapaUsuexternosBkka.getIdCapaUsuext()==null){
						dtCapaUsuexternosBkka.setIdCapacitacion(idCapacitacion);
						
						saveorupdateDtCapaUsuexternosBk(dtCapaUsuexternosBkka,user,kyUsuarioMod, kyAreaMod, rmtaddress);
						
						//BUSCAR Y ACTUALIZAR DTUSEREXT CON ENTIDAD VINCULADA
						if(dtCapaUsuexternosBkka.getIdEntidad()!=null && dtCapaUsuexternosBkka.getIdEntidad().longValue()>0){
							if(dtCapaUsuexternosBkka.getIdUsuexterno()!=null && dtCapaUsuexternosBkka.getIdUsuexterno().longValue()>0){
									List<DtEntidadesUsuexternosBk> dtEntidadesUsuexternosBkList=getDtEntidadUsuarioByUser(dtCapaUsuexternosBkka.getIdUsuexterno());
									if (dtEntidadesUsuexternosBkList!=null && dtEntidadesUsuexternosBkList.size()>0){
										DtEntidadesUsuexternosBk dtEntidadesUsuexternosBka=dtEntidadesUsuexternosBkList.get(0);
										if(dtCapaUsuexternosBkka.getIdEntidad().longValue()!=dtEntidadesUsuexternosBka.getIdEntidad().longValue()){
											dtEntidadesUsuexternosBka.setIdEntidad(dtCapaUsuexternosBkka.getIdEntidad());
											saveOrUpdateDtEntidadUsuario(dtEntidadesUsuexternosBka, rmtaddress,kyUsuarioMod);
										}
									}else{
										DtEntidadesUsuexternosBk dtEntidadesUsuexternosBkNew=new DtEntidadesUsuexternosBk();
										dtEntidadesUsuexternosBkNew.setIdUsuexterno(dtCapaUsuexternosBkka.getIdUsuexterno());
										dtEntidadesUsuexternosBkNew.setIdEntidad(dtCapaUsuexternosBkka.getIdEntidad());
										saveOrUpdateDtEntidadUsuario(dtEntidadesUsuexternosBkNew, rmtaddress,kyUsuarioMod);
									}
							}
						}
						
						
						//ACTUALIZAR DATOS DE CORREO Y TELEFONO EN TABLA DTUSUARIOS
						if(dtCapaUsuexternosBkka.getIdUsuexterno()!=null && dtCapaUsuexternosBkka.getIdUsuexterno().longValue()>0){
							DtUsuarioExternoBk dtUsuarioExternoBka=new DtUsuarioExternoBk();
							dtUsuarioExternoBka=getDtUsuarioExternoBkXid(dtCapaUsuexternosBkka.getIdUsuexterno());
							if(dtUsuarioExternoBka!=null){
								dtUsuarioExternoBka.setCorreo(dtCapaUsuexternosBkka.getCorreoUsuext());
								dtUsuarioExternoBka.setOtroTelefono(dtCapaUsuexternosBkka.getFijoUsuext());
								dtUsuarioExternoBka.setOtroCelular(dtCapaUsuexternosBkka.getCelularUsuext());
								saveorupdateDtUsuarioExternoBk(dtUsuarioExternoBka, user,kyUsuarioMod, kyAreaMod, rmtaddress);
							}
						}
					}

					
				}
			}
		}
		
		
	}
	
	private DtUsuarioExternoBk getDtUsuarioExternoBkXid(Long id) {
		if (id == null)
			return null;
		DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(id);
		DtUsuarioExternoBk dtUsuarioExternoBk = null;
		if (dtUsuarioExterno != null) {
			dtUsuarioExternoBk = new DtUsuarioExternoBk();
			FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
			completarDtUsuarioExterno(dtUsuarioExternoBk);
		} else { 
			return null;
		} 

		return dtUsuarioExternoBk;
	}
	
	public DtEntidadesUsuexternosBk saveOrUpdateDtEntidadUsuario(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk,
			String rmtaddress, Long kyUsuarioMod) throws Validador {

		ValidacionDtEntidadesUsuexternosMng.validarDtEntidadesUsuexternosBk(dtEntidadesUsuexternosBk);

		DtEntidadesUsuexternos dtEntidadesUsuexternos = null;
		// Date hoy = new Date(System.currentTimeMillis());
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtEntidadesUsuexternosBk.getIdUsuextEnti() != null
					&& dtEntidadesUsuexternosBk.getIdUsuextEnti().longValue() > 0) {

				dtEntidadesUsuexternos = dtEntidadesUsuexternosDao
						.getDtEntidadesUsuexternos(dtEntidadesUsuexternosBk.getIdUsuextEnti());

				boolean cambios = AuditoriaDtEntidadesUsuexternosMng.auditarCambiosDtEntidadesUsuexternos(
						dtEntidadesUsuexternosBk, dtEntidadesUsuexternos, dtEntidadesUsuexternos.getIdusserCrea(),
						dtEntidadesUsuexternos.getIdusserCrea().toString(), dtEntidadesUsuexternos.getRtmaddress(),
						nivel);

				if (cambios) {
					FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternos, dtEntidadesUsuexternosBk);
					dtEntidadesUsuexternos.setIdusserModif(kyUsuarioMod);
					dtEntidadesUsuexternos.setFechaModif(hoy);
					dtEntidadesUsuexternos.setRtmaddressrst(rmtaddress);
					dtEntidadesUsuexternosDao.updateDtEntidadesUsuexternos(dtEntidadesUsuexternos);
				}
			} else {

				dtEntidadesUsuexternosBk.setFechaCrea(hoy);
				dtEntidadesUsuexternosBk.setFechaModif(hoy);
				dtEntidadesUsuexternosBk.setIdusserCrea(kyUsuarioMod);
				dtEntidadesUsuexternosBk.setIdusserModif(kyUsuarioMod);
				dtEntidadesUsuexternosBk.setRtmaddress(rmtaddress);
				dtEntidadesUsuexternosBk.setRtmaddressrst(rmtaddress);
				dtEntidadesUsuexternosBk.setEstado(Estado.ACTIVO.getValor());

				dtEntidadesUsuexternos = new DtEntidadesUsuexternos();

				FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternos, dtEntidadesUsuexternosBk);
				dtEntidadesUsuexternosDao.saveDtEntidadesUsuexternos(dtEntidadesUsuexternos);

				log.log(Level.INFO,
						"CAMBIO :: " + dtEntidadesUsuexternos.getIdusserModif() + " :: " + " :: "
								+ dtEntidadesUsuexternos.getRtmaddress() + " :: " + " CREADO " + " :: "
								+ dtEntidadesUsuexternos.getIdUsuextEnti().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Validador(e.getMessage());
		}

		dtEntidadesUsuexternosBk = getDtEntidadUsuarioById(dtEntidadesUsuexternos.getIdUsuextEnti());
		return dtEntidadesUsuexternosBk;
	}
	
	public DtEntidadesUsuexternosBk getDtEntidadUsuarioById(Long id) {
		if (id == null)
			return null;
		DtEntidadesUsuexternos msObject = dtEntidadesUsuexternosDao.getDtEntidadesUsuexternos(id);
		DtEntidadesUsuexternosBk msObjectBk = null;
		if (msObject != null) {
			msObjectBk = new DtEntidadesUsuexternosBk();
			FuncionesStaticas.copyPropertiesObject(msObjectBk, msObject);
			completarDtEntidadUsuario(msObjectBk);
		}
		return msObjectBk;
	}
	
	
	private List<DtEntidadesUsuexternosBk> getDtEntidadUsuarioByUser(Long idUsuexterno) {
		List<DtEntidadesUsuexternosBk> msObjectBks = new ArrayList<DtEntidadesUsuexternosBk>();
		try {
			// List<DtEntidadesUsuexternos> msObjectDoms =
			// dtEntidadSedeDao.getDtEntidadSedeByEntity(idUsuexterno);
			List<DtEntidadesUsuexternos> msObjectDom = dtEntidadesUsuexternosDao
					.getDtEntidadUsuarioByUser(idUsuexterno);
			for (DtEntidadesUsuexternos msObject : msObjectDom) {
				DtEntidadesUsuexternosBk oObjectBk = new DtEntidadesUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(oObjectBk, msObject);
				completarDtEntidadUsuario(oObjectBk);
				msObjectBks.add(oObjectBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msObjectBks;
	}
	
	private void completarDtEntidadUsuario(DtEntidadesUsuexternosBk msObjectBks) {
		try {
			if (msObjectBks.getEstado() != null && msObjectBks.getEstado().intValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msObjectBks.getEstado());
				if (prtParametros != null)
					msObjectBks.setEstadoTxt(prtParametros.getDescripcion());
			}

			if (msObjectBks.getIdEntidad() != null && msObjectBks.getIdEntidad().intValue() > 0) {
				DtEntidades objectEntidad = dtEntidadesDao.getDtEntidades(msObjectBks.getIdEntidad());
				if (objectEntidad != null) {
					msObjectBks.setIdEntidadTxt(objectEntidad.getRazSocial());
					msObjectBks.setCodEjecutora(objectEntidad.getCodEjec());
				}
			}

			if (msObjectBks.getIdUsuexterno() != null && msObjectBks.getIdUsuexterno().intValue() > 0) {
				DtUsuarioExterno objectUsuario = dtUsuarioExternoDao.getDtUsuarioExterno(msObjectBks.getIdUsuexterno());
				if (objectUsuario != null) {
					DtUsuarioExternoBk msObjectBk = new DtUsuarioExternoBk();
					FuncionesStaticas.copyPropertiesObject(msObjectBk, objectUsuario);
					msObjectBks.setIdUsuexternoTxt(msObjectBk.getNombreCompleto());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapacitacion dtCapacitacion = null;
			if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

				if (dtCapacitacionBk.isFinalizado()) {
					throw new Validador(MessageFormat.format(
							"NO ES POSIBLE ANULAR UN REGISTRO FINALIZADO, ID: " + dtCapacitacionBk.getIdCapacitacion(),
							Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}

				if (dtCapacitacionBk.isAnulado()) {
					throw new Validador(MessageFormat.format(
							"LA CAPACITACIÓN DE ID: " + dtCapacitacionBk.getIdCapacitacion()
									+ " YA SE ENCUENTRA ANULADA",
							Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}

				dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapacitacion.setRtmaddressrst(rmtaddress);
				dtCapacitacion.setIdusserModif(kyUsuarioMod);
				dtCapacitacion.setFechaModif(hoy);
				Long estadoanterior = dtCapacitacion.getEstado();
				dtCapacitacion.setEstado(Estado.ELIMINADO.getValor());

				dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapacitacion" + " :: " + dtCapacitacion.getIdCapacitacion().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapacitacion dtCapacitacion = null;
			if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

				dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapacitacion.setRtmaddressrst(rmtaddress);
				dtCapacitacion.setIdusserModif(kyUsuarioMod);
				dtCapacitacion.setFechaModif(hoy);
				Long estadoanterior = dtCapacitacion.getEstado();
				dtCapacitacion.setEstado(Estado.ACTIVO.getValor());

				dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapacitacion" + " :: " + dtCapacitacion.getIdCapacitacion().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCapacitacionBk> getDtCapacitacionXFiltro(Timestamp fechaInic, Timestamp fechaFin, String nomEvento,
			Long idSistAdm, Long idUsuinterno, Long flagPubli, Long idModalidad, Long idProgramacion, Long estado,
			Integer cantPartic, Long kyUsuarioMod) {
		List<DtCapacitacionBk> dtCapacitacionBkss = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacionsss = dtCapacitacionDao.getXFiltro(fechaInic, fechaFin, nomEvento,
					idSistAdm, idUsuinterno, flagPubli, idModalidad, idProgramacion, estado, cantPartic);
			for (DtCapacitacion dtCapacitacion : dtCapacitacionsss) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
				dtCapacitacionBkss.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBkss;
	}

	@Override
	public List<DtCapacitacionBk> getDtCapacitacionXFiltro(Timestamp fechaInic, Timestamp fechaFin, String nomEvento,
			Long idSistAdm, Long idUsuinterno, Long flagPubli, Long idModalidad, Long idProgramacion, Long estado,
			Integer cantPartic, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtCapacitacionBk> dtCapacitacionBkss = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacionsss = dtCapacitacionDao.getXFiltro(fechaInic, fechaFin, nomEvento,
					idSistAdm, idUsuinterno, flagPubli, idModalidad, idProgramacion, estado, cantPartic, inicial, MAX);
			for (DtCapacitacion dtCapacitacion : dtCapacitacionsss) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
				dtCapacitacionBkss.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBkss;
	}

	@Override
	public Long getDtCapacitacionTotalXFiltro(Timestamp fechaInic, Timestamp fechaFin, String nomEvento, Long idSistAdm,
			Long idUsuinterno, Long flagPubli, Long idModalidad, Long idProgramacion, Long estado, Integer cantPartic,
			Long kyUsuarioMod) {
		try {
			Long totalDtCapacitacionsss = dtCapacitacionDao.getTotalXFiltro(fechaInic, fechaFin, nomEvento, idSistAdm,
					idUsuinterno, flagPubli, idModalidad, idProgramacion, estado, cantPartic);

			return totalDtCapacitacionsss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCapacitacionBk(DtCapacitacionBk dtCapacitacionBk, Long kyUsuarioMod) {
		DtCapacitacionACL dtCapacitacionACL = new DtCapacitacionACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPACITACION_CREA)) {
					dtCapacitacionACL.setEsEditable(true);
					dtCapacitacionACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCAPACITACION_VE)) {
					dtCapacitacionACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPACITACION_CREA)) {
					dtCapacitacionACL.setEditopcion(1);
				} else {
					dtCapacitacionACL.setEditopcion(2);
				}
				if (roles.contains(Roles.DTENTIDADES_CREA) || roles.contains(Roles.ADMINISTRADOR)
						|| roles.contains(Roles.PERFIL_USU_OGC)) {
					dtCapacitacionACL.setAddEntidad(true);
				}
				// MPINARES 14022024 - INICIO
				if (((roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_USU_OGC))
						&& (dtCapacitacionBk.isFinalizado() || dtCapacitacionBk.isAnulado()))
						|| (roles.contains(Roles.REACTIVA_FINLIZADOS) && dtCapacitacionBk.isFinalizado())
						|| (roles.contains(Roles.REACTIVA_ANULADOS) && dtCapacitacionBk.isAnulado())) {
					dtCapacitacionACL.setReactivar(true);
				}
				// MPINARES 14022024 - FIN
			} else {
				dtCapacitacionACL.setEditopcion(2);
			}
		} else {
			dtCapacitacionACL.setEditopcion(2);
		}
		dtCapacitacionBk.setDtCapacitacionACL(dtCapacitacionACL);
	}

	/// ADICIONALES

	// MPINARES 14022024 - INICIO
	@Override
	public List<IDValorDto> getMsLocalIdLocalIdLocal() {
		if (msLocalIdLocalIdLocalListaCache == null) {
			// List<MsLocal> msLocalsss = msLocalDao.getListaIdLocal();
			List<MsLocal> msLocalsss = msLocalDao.getActivasMsLocal();
			msLocalIdLocalIdLocalListaCache = new ArrayList<IDValorDto>();
			for (MsLocal msLocal : msLocalsss) {
				String sedeTxt = "";
				String depart = "";
				String prov = "";
				if (msLocal.getIdSede() != null && msLocal.getIdSede().intValue() > 0) {
					MsSedes msSedes = msSedesDao.getMsSedes(msLocal.getIdSede());
					sedeTxt = msSedes.getSede();
				}
				depart = msUbigeoDao.getMsUbigeoByCodes(msLocal.getCodDpto().longValue(), 0L, 0L).getDescripcion();
				prov = msUbigeoDao
						.getMsUbigeoByCodes(msLocal.getCodDpto().longValue(), msLocal.getCodProv().longValue(), 0L)
						.getDescripcion();
				IDValorDto idLocalDto = new IDValorDto(msLocal.getIdLocal(),
						msLocal.getDescripcion() + "-SEDE " + sedeTxt + " DEPART:" + depart + " PROV:" + prov);
				msLocalIdLocalIdLocalListaCache.add(idLocalDto);
			}
		}
		return msLocalIdLocalIdLocalListaCache;
	}
	// MPINARES 14022024 - FIN

	/**
	 * ADICIONAR EN EL msLocalDao
	 * 
	 **/
	// @Override
	// public List<IDValorDto> getMsLocalIdLocalIdLocal(){
	// if (msLocalIdLocalIdLocalListaCache == null) {
	// List<MsLocal> msLocalsss = msLocalDao.getListaIdLocal();
	// msLocalIdLocalIdLocalListaCache = new ArrayList<IDValorDto>();
	// for (MsLocal msLocal : msLocalsss) {
	// IDValorDto idLocalDto = new IDValorDto(msLocal.getIdLocal(),
	// msLocal.getDescripcion());
	// msLocalIdLocalIdLocalListaCache.add(idLocalDto);
	// }
	// }
	// return msLocalIdLocalIdLocalListaCache;
	// }
	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdModo() {
		if (prtParametrosIdparametroIdModoListaCache == null) {
			// MPINARES 14022024 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("MODO DE CAPACITACIÓN");
			// MPINARES 14022024 - FIN
			prtParametrosIdparametroIdModoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdModoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdModoListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdNivel() {
		if (prtParametrosIdparametroIdNivelListaCache == null) {
			// MPINARES 14022024 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("NIVEL DE CAPACITACIÓN");
			// MPINARES 14022024 - FIN
			prtParametrosIdparametroIdNivelListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdNivelListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdNivelListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdPrestacion() {
		if (prtParametrosIdparametroIdPrestacionListaCache == null) {
			// MPINARES 14022024 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao
					.getHijosXDescripcion("PRESTACIONES DE SERVICIO DE CAPACITACIÓN");
			// MPINARES 14022024 - FIN
			prtParametrosIdparametroIdPrestacionListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdPrestacionListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdPrestacionListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdTipo() {
		if (prtParametrosIdparametroIdTipoListaCache == null) {
			// MPINARES 14022024 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("TIPO DE CAPACITACIÓN");
			// MPINARES 14022024 - FIN
			prtParametrosIdparametroIdTipoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdTipoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdTipoListaCache;
	}

	/**
	 * MS_ALERTA_CARGO_USER SERVICIO: LISTA DE LOS CARGOS DE LOS USUARIOS EN LAS
	 * ALERTAS
	 */
	@Override
	public MsAlertaCargoUserBk getMsAlertaCargoUserBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsAlertaCargoUser msAlertaCargoUser = msAlertaCargoUserDao.getMsAlertaCargoUser(id);
		MsAlertaCargoUserBk msAlertaCargoUserBk = null;
		if (msAlertaCargoUser != null) {
			msAlertaCargoUserBk = new MsAlertaCargoUserBk();
			FuncionesStaticas.copyPropertiesObject(msAlertaCargoUserBk, msAlertaCargoUser);
			completarMsAlertaCargoUser(msAlertaCargoUserBk);
			if (kyUsuarioMod != null)
				setACLMsAlertaCargoUserBk(msAlertaCargoUserBk, kyUsuarioMod);
		}
		return msAlertaCargoUserBk;
	}

	@Override
	public List<MsAlertaCargoUserBk> getAllMsAlertaCargoUserActivos(Long kyUsuarioMod) {
		List<MsAlertaCargoUserBk> msAlertaCargoUserBkss = new ArrayList<MsAlertaCargoUserBk>();
		try {
			List<MsAlertaCargoUser> msAlertaCargoUsers = msAlertaCargoUserDao.getActivasMsAlertaCargoUser();
			for (MsAlertaCargoUser msAlertaCargoUser : msAlertaCargoUsers) {
				MsAlertaCargoUserBk msAlertaCargoUserBk = new MsAlertaCargoUserBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaCargoUserBk, msAlertaCargoUser);
				completarMsAlertaCargoUser(msAlertaCargoUserBk);
				setACLMsAlertaCargoUserBk(msAlertaCargoUserBk, kyUsuarioMod);
				msAlertaCargoUserBkss.add(msAlertaCargoUserBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaCargoUserBkss;
	}

	@Override
	public List<MsAlertaCargoUserBk> getAllMsAlertaCargoUserActivosCero(Long kyUsuarioMod) {
		List<MsAlertaCargoUserBk> msAlertaCargoUserBkss = new ArrayList<MsAlertaCargoUserBk>();
		try {
			List<MsAlertaCargoUser> msAlertaCargoUsers = msAlertaCargoUserDao.getActivasMsAlertaCargoUserCero();
			for (MsAlertaCargoUser msAlertaCargoUser : msAlertaCargoUsers) {
				MsAlertaCargoUserBk msAlertaCargoUserBk = new MsAlertaCargoUserBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaCargoUserBk, msAlertaCargoUser);
				completarMsAlertaCargoUser(msAlertaCargoUserBk);
				setACLMsAlertaCargoUserBk(msAlertaCargoUserBk, kyUsuarioMod);
				msAlertaCargoUserBkss.add(msAlertaCargoUserBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaCargoUserBkss;
	}

	private void completarMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk) {
		try {
			if (msAlertaCargoUserBk.getIdalerta() != null && msAlertaCargoUserBk.getIdalerta().longValue() > 0) {
				MsAlerta msAlerta = msAlertaDao.getMsAlerta(msAlertaCargoUserBk.getIdalerta());
				if (msAlerta != null)
					msAlertaCargoUserBk.setIdalertaTxt(msAlerta.getOtrosDestin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msAlertaCargoUserBk.getIdcargo() != null && msAlertaCargoUserBk.getIdcargo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msAlertaCargoUserBk.getIdcargo());
				if (prtParametros != null)
					msAlertaCargoUserBk.setIdcargoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msAlertaCargoUserBk.getEstado()!=null &&
		// msAlertaCargoUserBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msAlertaCargoUserBk.getEstado());
		// if(prtParametros!=null)
		// msAlertaCargoUserBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsAlertaCargoUserBk saveorupdateMsAlertaCargoUserBk(MsAlertaCargoUserBk msAlertaCargoUserBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionMsAlertaCargoUserMng.validarMsAlertaCargoUserBk(msAlertaCargoUserBk);

		MsAlertaCargoUser msAlertaCargoUser = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msAlertaCargoUserBk.getIdalertaCargo() != null
					&& msAlertaCargoUserBk.getIdalertaCargo().longValue() > 0) {

				msAlertaCargoUser = msAlertaCargoUserDao.getMsAlertaCargoUser(msAlertaCargoUserBk.getIdalertaCargo());

				boolean cambios = AuditoriaMsAlertaCargoUserMng.auditarCambiosMsAlertaCargoUser(msAlertaCargoUserBk,
						msAlertaCargoUser, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					msAlertaCargoUser.setRtmaddressrst(rmtaddress);
					msAlertaCargoUser.setIdusserModif(kyUsuarioMod);
					msAlertaCargoUser.setFechaModif(hoy);
					msAlertaCargoUserDao.updateMsAlertaCargoUser(msAlertaCargoUser);
				}
			} else {
				msAlertaCargoUserBk.setRtmaddress(rmtaddress);
				msAlertaCargoUserBk.setRtmaddressrst(rmtaddress);

				msAlertaCargoUserBk.setFechaCrea(hoy);
				msAlertaCargoUserBk.setIdusserCrea(kyUsuarioMod);
				msAlertaCargoUserBk.setIdusserModif(kyUsuarioMod);
				msAlertaCargoUserBk.setFechaModif(hoy);
				msAlertaCargoUserBk.setEstado(Estado.ACTIVO.getValor());

				msAlertaCargoUser = new MsAlertaCargoUser();

				FuncionesStaticas.copyPropertiesObject(msAlertaCargoUser, msAlertaCargoUserBk);
				msAlertaCargoUserDao.saveMsAlertaCargoUser(msAlertaCargoUser);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO msAlertaCargoUser" + " :: " + msAlertaCargoUser.getIdalertaCargo().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msAlertaCargoUserBk = getMsAlertaCargoUserBkXid(msAlertaCargoUser.getIdalertaCargo(), kyUsuarioMod);
		return msAlertaCargoUserBk;
	}

	@Override
	public void deleteMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			MsAlertaCargoUser msAlertaCargoUser = null;
			if (msAlertaCargoUserBk.getIdalertaCargo() != null
					&& msAlertaCargoUserBk.getIdalertaCargo().longValue() > 0) {

				msAlertaCargoUser = msAlertaCargoUserDao.getMsAlertaCargoUser(msAlertaCargoUserBk.getIdalertaCargo());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msAlertaCargoUser.setRtmaddressrst(rmtaddress);
				msAlertaCargoUser.setIdusserModif(kyUsuarioMod);
				msAlertaCargoUser.setFechaModif(hoy);
				Long estadoanterior = msAlertaCargoUser.getEstado();
				msAlertaCargoUser.setEstado(Estado.ELIMINADO.getValor());

				msAlertaCargoUserDao.updateMsAlertaCargoUser(msAlertaCargoUser);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO msAlertaCargoUser" + " :: " + msAlertaCargoUser.getIdalertaCargo().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			MsAlertaCargoUser msAlertaCargoUser = null;
			if (msAlertaCargoUserBk.getIdalertaCargo() != null
					&& msAlertaCargoUserBk.getIdalertaCargo().longValue() > 0) {

				msAlertaCargoUser = msAlertaCargoUserDao.getMsAlertaCargoUser(msAlertaCargoUserBk.getIdalertaCargo());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msAlertaCargoUser.setRtmaddressrst(rmtaddress);
				msAlertaCargoUser.setIdusserModif(kyUsuarioMod);
				msAlertaCargoUser.setFechaModif(hoy);
				Long estadoanterior = msAlertaCargoUser.getEstado();
				msAlertaCargoUser.setEstado(Estado.ACTIVO.getValor());

				msAlertaCargoUserDao.updateMsAlertaCargoUser(msAlertaCargoUser);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO msAlertaCargoUser" + " :: " + msAlertaCargoUser.getIdalertaCargo().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsAlertaCargoUserBk> getMsAlertaCargoUserXFiltro(Long idalerta, Long idcargo, Long kyUsuarioMod) {
		List<MsAlertaCargoUserBk> msAlertaCargoUserBkss = new ArrayList<MsAlertaCargoUserBk>();
		try {
			List<MsAlertaCargoUser> msAlertaCargoUsersss = msAlertaCargoUserDao.getXFiltro(idalerta, idcargo);
			for (MsAlertaCargoUser msAlertaCargoUser : msAlertaCargoUsersss) {
				MsAlertaCargoUserBk msAlertaCargoUserBk = new MsAlertaCargoUserBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaCargoUserBk, msAlertaCargoUser);
				completarMsAlertaCargoUser(msAlertaCargoUserBk);
				setACLMsAlertaCargoUserBk(msAlertaCargoUserBk, kyUsuarioMod);
				msAlertaCargoUserBkss.add(msAlertaCargoUserBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaCargoUserBkss;
	}

	@Override
	public List<MsAlertaCargoUserBk> getMsAlertaCargoUserXFiltro(Long idalerta, Long idcargo, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<MsAlertaCargoUserBk> msAlertaCargoUserBkss = new ArrayList<MsAlertaCargoUserBk>();
		try {
			List<MsAlertaCargoUser> msAlertaCargoUsersss = msAlertaCargoUserDao.getXFiltro(idalerta, idcargo, inicial,
					MAX);
			for (MsAlertaCargoUser msAlertaCargoUser : msAlertaCargoUsersss) {
				MsAlertaCargoUserBk msAlertaCargoUserBk = new MsAlertaCargoUserBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaCargoUserBk, msAlertaCargoUser);
				completarMsAlertaCargoUser(msAlertaCargoUserBk);
				setACLMsAlertaCargoUserBk(msAlertaCargoUserBk, kyUsuarioMod);
				msAlertaCargoUserBkss.add(msAlertaCargoUserBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaCargoUserBkss;
	}

	@Override
	public Long getMsAlertaCargoUserTotalXFiltro(Long idalerta, Long idcargo, Long kyUsuarioMod) {
		try {
			Long totalMsAlertaCargoUsersss = msAlertaCargoUserDao.getTotalXFiltro(idalerta, idcargo);

			return totalMsAlertaCargoUsersss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsAlertaCargoUserBk(MsAlertaCargoUserBk msAlertaCargoUserBk, Long kyUsuarioMod) {
		MsAlertaCargoUserACL msAlertaCargoUserACL = new MsAlertaCargoUserACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSALERTACARGOUSER_CREA)) {
					msAlertaCargoUserACL.setEsEditable(true);
					msAlertaCargoUserACL.setEliminar(true);
				} else if (roles.contains(Roles.MSALERTACARGOUSER_VE)) {
					msAlertaCargoUserACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSALERTACARGOUSER_CREA)) {
					msAlertaCargoUserACL.setEditopcion(1);
				} else {
					msAlertaCargoUserACL.setEditopcion(2);
				}
			} else {
				msAlertaCargoUserACL.setEditopcion(2);
			}
		} else {
			msAlertaCargoUserACL.setEditopcion(2);
		}
		msAlertaCargoUserBk.setMsAlertaCargoUserACL(msAlertaCargoUserACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdcargo() {
		if (prtParametrosIdparametroIdcargoListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdcargoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdcargoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdcargoListaCache;
	}

	/**
	 * TA_FERIADOS SERVICIO: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS
	 * FERIADOS DEL AÑO
	 */
	// PURIBE 16012024 - INICIO-
	@Override
	public TaFeriadosBk getTaFeriadosBkXid(java.util.Date id, Long kyUsuarioMod) {
		if (id == null)
			return null;

		// TaFeriados taFeriados = taFeriadosDao.getTaFeriados(id);
		List<TaFeriados> LstaFeriados = taFeriadosDao.getByIdTaFeriados(id);

		TaFeriadosBk taFeriadosBk = null;
		if (LstaFeriados.get(0) != null) {
			taFeriadosBk = new TaFeriadosBk();
			FuncionesStaticas.copyPropertiesObject(taFeriadosBk, LstaFeriados.get(0));
			completarTaFeriados(taFeriadosBk);
			if (kyUsuarioMod != null)
				setACLTaFeriadosBk(taFeriadosBk, kyUsuarioMod);
		}
		return taFeriadosBk;
	}
	// PURIBE 16012024 - FIN-

	@Override
	public List<TaFeriadosBk> getAllTaFeriadosActivos(Long kyUsuarioMod) {
		List<TaFeriadosBk> taFeriadosBkss = new ArrayList<TaFeriadosBk>();
		try {
			List<TaFeriados> taFeriadoss = taFeriadosDao.getActivasTaFeriados();
			for (TaFeriados taFeriados : taFeriadoss) {
				TaFeriadosBk taFeriadosBk = new TaFeriadosBk();
				FuncionesStaticas.copyPropertiesObject(taFeriadosBk, taFeriados);
				completarTaFeriados(taFeriadosBk);
				setACLTaFeriadosBk(taFeriadosBk, kyUsuarioMod);
				taFeriadosBkss.add(taFeriadosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taFeriadosBkss;
	}

	@Override
	public List<TaFeriadosBk> getAllTaFeriadosActivosCero(Long kyUsuarioMod) {
		List<TaFeriadosBk> taFeriadosBkss = new ArrayList<TaFeriadosBk>();
		try {
			List<TaFeriados> taFeriadoss = taFeriadosDao.getActivasTaFeriadosCero();
			for (TaFeriados taFeriados : taFeriadoss) {
				TaFeriadosBk taFeriadosBk = new TaFeriadosBk();
				FuncionesStaticas.copyPropertiesObject(taFeriadosBk, taFeriados);
				completarTaFeriados(taFeriadosBk);
				setACLTaFeriadosBk(taFeriadosBk, kyUsuarioMod);
				taFeriadosBkss.add(taFeriadosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taFeriadosBkss;
	}

	private void completarTaFeriados(TaFeriadosBk taFeriadosBk) {
		// try{
		// if(taFeriadosBk.getFeEstado()!=null &&
		// taFeriadosBk.getFeEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(taFeriadosBk.getFeEstado().longValue());
		// if(prtParametros!=null)
		// taFeriadosBk.setFeEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public TaFeriadosBk saveorupdateTaFeriadosBk(TaFeriadosBk taFeriadosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionTaFeriadosMng.validarTaFeriadosBk(taFeriadosBk);

		TaFeriados taFeriados = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;
		// PURIBE 16012024 - INICIO-
		try {

			taFeriados = taFeriadosDao.getTaFeriados(taFeriadosBk.getFeFecha());
			boolean cambios = false;
			if (taFeriados != null) {
				cambios = AuditoriaTaFeriadosMng.auditarCambiosTaFeriados(taFeriadosBk, taFeriados, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					// taFeriados.setRtmaddressrst(rmtaddress);
					taFeriados.setFeIdusumod(kyUsuarioMod);
					taFeriados.setFeFchmod(hoy);
					taFeriadosDao.updateTaFeriados(taFeriados);
				}
			} else {
				// taFeriadosBk.setRtmaddress(rmtaddress);
				// taFeriadosBk.setRtmaddressrst(rmtaddress);

				taFeriadosBk.setFeFchcrear(hoy);
				taFeriadosBk.setFeIdusu(kyUsuarioMod);
				taFeriadosBk.setFeIdusumod(kyUsuarioMod);
				taFeriadosBk.setFeFchmod(hoy);
				taFeriadosBk.setFeEstado(1);

				taFeriados = new TaFeriados();

				FuncionesStaticas.copyPropertiesObject(taFeriados, taFeriadosBk);
				taFeriadosDao.saveTaFeriados(taFeriados);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "CREADO taFeriados"
								+ " :: " + taFeriados.getFeFecha().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		taFeriadosBk = getTaFeriadosBkXid(taFeriados.getFeFecha(), kyUsuarioMod);
		return taFeriadosBk;
	}
	// PURIBE 16012024 - FIN-

	@Override
	public void deleteTaFeriados(TaFeriadosBk taFeriadosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			TaFeriados taFeriados = null;
			if (taFeriadosBk.getFeFecha() != null) {

				taFeriados = taFeriadosDao.getTaFeriados(taFeriadosBk.getFeFecha());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				// taFeriados.setRtmaddressrst(rmtaddress);
				taFeriados.setFeIdusumod(kyUsuarioMod);
				taFeriados.setFeFchmod(hoy);
				Integer estadoanterior = taFeriados.getFeEstado();
				taFeriados.setFeEstado((int) Estado.ELIMINADO.getValor());

				taFeriadosDao.updateTaFeriados(taFeriados);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO taFeriados" + " :: " + taFeriados.getFeFecha().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarTaFeriados(TaFeriadosBk taFeriadosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			TaFeriados taFeriados = null;
			if (taFeriadosBk.getFeFecha() != null) {

				taFeriados = taFeriadosDao.getTaFeriados(taFeriadosBk.getFeFecha());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				// taFeriados.setRtmaddressrst(rmtaddress);
				taFeriados.setFeIdusumod(kyUsuarioMod);
				taFeriados.setFeFchmod(hoy);
				Integer estadoanterior = taFeriados.getFeEstado();
				taFeriados.setFeEstado((int) Estado.ACTIVO.getValor());

				taFeriadosDao.updateTaFeriados(taFeriados);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO taFeriados" + " :: " + taFeriados.getFeFecha().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<TaFeriadosBk> getTaFeriadosXFiltro(String feDesc, Long kyUsuarioMod) {
		List<TaFeriadosBk> taFeriadosBkss = new ArrayList<TaFeriadosBk>();
		try {
			List<TaFeriados> taFeriadossss = taFeriadosDao.getXFiltro(feDesc);
			for (TaFeriados taFeriados : taFeriadossss) {
				TaFeriadosBk taFeriadosBk = new TaFeriadosBk();
				FuncionesStaticas.copyPropertiesObject(taFeriadosBk, taFeriados);
				completarTaFeriados(taFeriadosBk);
				setACLTaFeriadosBk(taFeriadosBk, kyUsuarioMod);
				taFeriadosBkss.add(taFeriadosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taFeriadosBkss;
	}

	@Override
	public List<TaFeriadosBk> getTaFeriadosXFiltro(String feDesc, int inicial, int MAX, Long kyUsuarioMod) {
		List<TaFeriadosBk> taFeriadosBkss = new ArrayList<TaFeriadosBk>();
		try {
			List<TaFeriados> taFeriadossss = taFeriadosDao.getXFiltro(feDesc, inicial, MAX);
			for (TaFeriados taFeriados : taFeriadossss) {
				TaFeriadosBk taFeriadosBk = new TaFeriadosBk();
				FuncionesStaticas.copyPropertiesObject(taFeriadosBk, taFeriados);
				completarTaFeriados(taFeriadosBk);
				setACLTaFeriadosBk(taFeriadosBk, kyUsuarioMod);
				taFeriadosBkss.add(taFeriadosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taFeriadosBkss;
	}

	@Override
	public Long getTaFeriadosTotalXFiltro(String feDesc, Long kyUsuarioMod) {
		try {
			Long totalTaFeriadossss = taFeriadosDao.getTotalXFiltro(feDesc);

			return totalTaFeriadossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLTaFeriadosBk(TaFeriadosBk taFeriadosBk, Long kyUsuarioMod) {
		TaFeriadosACL taFeriadosACL = new TaFeriadosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.TAFERIADOS_CREA)) {
					taFeriadosACL.setEsEditable(true);
					taFeriadosACL.setEliminar(true);
				} else if (roles.contains(Roles.TAFERIADOS_VE)) {
					taFeriadosACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.TAFERIADOS_CREA)) {
					taFeriadosACL.setEditopcion(1);
				} else {
					taFeriadosACL.setEditopcion(2);
				}
			} else {
				taFeriadosACL.setEditopcion(2);
			}
		} else {
			taFeriadosACL.setEditopcion(2);
		}
		taFeriadosBk.setTaFeriadosACL(taFeriadosACL);
	}

	/// ADICIONALES

	/**
	 * DT_ENTIDADES SERVICIO: LISTA DE LAS ENTIDADES REGISTRADAS EN EL SISTEMA
	 */
	@Override
	public DtEntidadesBk getDtEntidadesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(id);
		DtEntidadesBk dtEntidadesBk = null;
		if (dtEntidades != null) {
			dtEntidadesBk = new DtEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
			completarDtEntidades(dtEntidadesBk);
			if (kyUsuarioMod != null)
				setACLDtEntidadesBk(dtEntidadesBk, kyUsuarioMod);
		}
		return dtEntidadesBk;
	}

	@Override
	public List<DtEntidadesBk> getAllDtEntidadesActivos(Long kyUsuarioMod) {
		List<DtEntidadesBk> dtEntidadesBkss = new ArrayList<DtEntidadesBk>();
		try {
			List<DtEntidades> dtEntidadess = dtEntidadesDao.getActivasDtEntidades();
			for (DtEntidades dtEntidades : dtEntidadess) {
				DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
				completarDtEntidades(dtEntidadesBk);
				setACLDtEntidadesBk(dtEntidadesBk, kyUsuarioMod);
				dtEntidadesBkss.add(dtEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesBkss;
	}

	@Override
	public List<DtEntidadesBk> getAllDtEntidadesActivosCero(Long kyUsuarioMod) {
		List<DtEntidadesBk> dtEntidadesBkss = new ArrayList<DtEntidadesBk>();
		try {
			List<DtEntidades> dtEntidadess = dtEntidadesDao.getActivasDtEntidadesCero();
			for (DtEntidades dtEntidades : dtEntidadess) {
				DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
				completarDtEntidades(dtEntidadesBk);
				setACLDtEntidadesBk(dtEntidadesBk, kyUsuarioMod);
				dtEntidadesBkss.add(dtEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesBkss;
	}

	private void completarDtEntidades(DtEntidadesBk dtEntidadesBk) {
		try {
			if (dtEntidadesBk.getIdTipo() != null && dtEntidadesBk.getIdTipo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtEntidadesBk.getIdTipo());
				if (prtParametros != null)
					dtEntidadesBk.setIdTipoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0
					&& dtEntidadesBk.getCodProv() != null && dtEntidadesBk.getCodProv().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = dtEntidadesBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0
					&& dtEntidadesBk.getCodProv() != null && dtEntidadesBk.getCodProv().intValue() > 0
					&& dtEntidadesBk.getCodDistr() != null && dtEntidadesBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = dtEntidadesBk.getCodProv().intValue();
				int iiCodDistr = dtEntidadesBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getIdCaract() != null && dtEntidadesBk.getIdCaract().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtEntidadesBk.getIdCaract());
				if (prtParametros != null)
					dtEntidadesBk.setIdCaractTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getIdSistAdmi() != null && dtEntidadesBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtEntidadesBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					dtEntidadesBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtEntidadesBk.getEstado()!=null &&
		// dtEntidadesBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEntidadesBk.getEstado());
		// if(prtParametros!=null)
		// dtEntidadesBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			if (dtEntidadesBk.getIdpais() != null && dtEntidadesBk.getIdpais().longValue() > 0) {
				MsPaises msPaises = msPaisesDao.getMsPaises(dtEntidadesBk.getIdpais());
				if (msPaises != null)
					dtEntidadesBk.setIdpaisTxt(msPaises.getPaisNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			List<DtEntidadSedesDto> dtEntidadSedesDtoss = getDtEntidadSedesDtossXIdEntidad(
					dtEntidadesBk.getIdEntidad());
			dtEntidadesBk.setDtEntidadSedesss(dtEntidadSedesDtoss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void completarDtEntidadesDtoo(DtEntidadesDto dtEntidadesBk) {
		// try {
		// if (dtEntidadesBk.getIdTipo() != null &&
		// dtEntidadesBk.getIdTipo().longValue() > 0) {
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEntidadesBk.getIdTipo());
		// if (prtParametros != null)
		// dtEntidadesBk.setIdTipoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0
					&& dtEntidadesBk.getCodProv() != null && dtEntidadesBk.getCodProv().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = dtEntidadesBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0
					&& dtEntidadesBk.getCodProv() != null && dtEntidadesBk.getCodProv().intValue() > 0
					&& dtEntidadesBk.getCodDistr() != null && dtEntidadesBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = dtEntidadesBk.getCodProv().intValue();
				int iiCodDistr = dtEntidadesBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try {
		// if (dtEntidadesBk.getIdCaract() != null &&
		// dtEntidadesBk.getIdCaract().longValue() > 0) {
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEntidadesBk.getIdCaract());
		// if (prtParametros != null)
		// dtEntidadesBk.setIdCaractTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// try {
		// if (dtEntidadesBk.getIdSistAdmi() != null &&
		// dtEntidadesBk.getIdSistAdmi().longValue() > 0) {
		// MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
		// .getMsSisAdmistrativo(dtEntidadesBk.getIdSistAdmi());
		// if (msSisAdmistrativo != null)
		// dtEntidadesBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// try {
		// if (dtEntidadesBk.getIdpais() != null &&
		// dtEntidadesBk.getIdpais().longValue() > 0) {
		// MsPaises msPaises =
		// msPaisesDao.getMsPaises(dtEntidadesBk.getIdpais());
		// if (msPaises != null)
		// dtEntidadesBk.setIdpaisTxt(msPaises.getPaisNombre());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			if (dtEntidadesBk.getRazSocial() != null && dtEntidadesBk.getRazSocial().length() > 0) {
				dtEntidadesBk.setRazSocialUbigeo(dtEntidadesBk.getRazSocial() + " DPTO:" + dtEntidadesBk.getCodDptoTxt()
						+ " PROV:" + dtEntidadesBk.getCodProvTxt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void completarDtEntidadesUbi(DtEntidadesBk dtEntidadesBk) {

		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0
					&& dtEntidadesBk.getCodProv() != null && dtEntidadesBk.getCodProv().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = dtEntidadesBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesBk.getCodDpto() != null && dtEntidadesBk.getCodDpto().intValue() > 0
					&& dtEntidadesBk.getCodProv() != null && dtEntidadesBk.getCodProv().intValue() > 0
					&& dtEntidadesBk.getCodDistr() != null && dtEntidadesBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = dtEntidadesBk.getCodDpto().intValue();
				int iiCodProv = dtEntidadesBk.getCodProv().intValue();
				int iiCodDistr = dtEntidadesBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtEntidadesBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (dtEntidadesBk.getRazSocial() != null && dtEntidadesBk.getRazSocial().length() > 0) {
				dtEntidadesBk.setRazSocialUbigeo(dtEntidadesBk.getRazSocial() + " DPTO:" + dtEntidadesBk.getCodDptoTxt()
						+ " PROV:" + dtEntidadesBk.getCodProvTxt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// public DtEntidadesBk saveorupdateDtEntidadesBk(
	// DtEntidadesBk dtEntidadesBk,
	// String user,
	// Long kyUsuarioMod,
	// Long kyAreaMod,
	// String rmtaddress
	// , List<DtEntidadSedesBk> dtEntidadSedesBkss
	// ) throws Validador{
	// INICIO CUSCATA - 18062024
	public DtEntidadesBk saveorupdateDtEntidadesBk(DtEntidadesBk dtEntidadesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		// FIN CUSCATA - 18062024
		// MPINARES 24012023 - INICIO
		if (dtEntidadesBk.getGeozona() != null && dtEntidadesBk.getGeozona().toString().equals("1")) {
			dtEntidadesBk.setGeozona("SI");
		} else {
			dtEntidadesBk.setGeozona("NO");
		}
		// MPINARES 24012023 - FIN

		ValidacionDtEntidadesMng.validarDtEntidadesBk(dtEntidadesBk);

		// MPINARES 24012023 - INICIO
		List<DtEntidadSisAdminBk> entidadesSisAdminList = new ArrayList<DtEntidadSisAdminBk>();
		if (dtEntidadesBk.getDtEntidadSisAdminBkJSss() != null
				&& dtEntidadesBk.getDtEntidadSisAdminBkJSss().size() > 0) {

			for (DtEntidadSisAdminBk dtEntidadSisAdminBka : dtEntidadesBk.getDtEntidadSisAdminBkJSss()) {
				if (dtEntidadSisAdminBka.getIdSistAdmi() != null && dtEntidadSisAdminBka.getIdSede() != null) {
					entidadesSisAdminList.add(dtEntidadSisAdminBka);
				} else {
					throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL SISTEMA ADMINISTRATIVO Y LA SEDE",
							Messages.getStringToKey("dtEntidades.titulotabla")));
				}
			}

			if (entidadesSisAdminList != null && entidadesSisAdminList.size() > 0) {
				dtEntidadesBk.setDtEntidadSisAdminBkJSss(entidadesSisAdminList);
			} else {
				throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL SISTEMA ADMINISTRATIVO Y LA SEDE",
						Messages.getStringToKey("dtEntidades.titulotabla")));
			}
		} else {
			throw new Validador(MessageFormat.format("DEBE SELECCIONAR EL SISTEMA ADMINISTRATIVO Y LA SEDE",
					Messages.getStringToKey("dtEntidades.titulotabla")));
		}
		// MPINARES 24012023 - FIN

		DtEntidades dtEntidades = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtEntidadesBk.getIdEntidad() != null && dtEntidadesBk.getIdEntidad().longValue() > 0) {

				dtEntidades = dtEntidadesDao.getDtEntidades(dtEntidadesBk.getIdEntidad());

				boolean cambios = AuditoriaDtEntidadesMng.auditarCambiosDtEntidades(dtEntidadesBk, dtEntidades,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtEntidades.setRtmaddressrst(rmtaddress);
					dtEntidades.setIdusserModif(kyUsuarioMod);
					dtEntidades.setFechaModif(hoy);
					dtEntidadesDao.updateDtEntidades(dtEntidades);
				}
			} else {
				dtEntidadesBk.setRtmaddress(rmtaddress);
				dtEntidadesBk.setRtmaddressrst(rmtaddress);

				dtEntidadesBk.setFechaCrea(hoy);
				dtEntidadesBk.setIdusserCrea(kyUsuarioMod);
				dtEntidadesBk.setIdusserModif(kyUsuarioMod);
				dtEntidadesBk.setFechaModif(hoy);
				dtEntidadesBk.setEstado(Estado.ACTIVO.getValor());

				dtEntidades = new DtEntidades();

				FuncionesStaticas.copyPropertiesObject(dtEntidades, dtEntidadesBk);
				dtEntidadesDao.saveDtEntidades(dtEntidades);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtEntidades" + " :: " + dtEntidades.getIdEntidad().toString() + " :: " + "0"
								+ " :: " + Estado.ACTIVO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		// MPINARES 24012023 - INICIO
		DtEntidadSisAdmin dtEntidadSisAdmin = null;
		if (dtEntidadesBk.getDtEntidadSisAdminBkJSss() != null
				&& dtEntidadesBk.getDtEntidadSisAdminBkJSss().size() > 0) {
			for (DtEntidadSisAdminBk dtEntidadSisAdminBk : dtEntidadesBk.getDtEntidadSisAdminBkJSss()) {
				if (dtEntidadSisAdminBk.getIdentidadSisadm() != null
						&& dtEntidadSisAdminBk.getIdentidadSisadm().longValue() > 0) {
					// ACTUALIZAR
				} else {
					// NUEVO
					dtEntidadSisAdminBk.setIdEntidad(dtEntidades.getIdEntidad());
					dtEntidadSisAdminBk.setEstado(Estado.ACTIVO.getValor());
					dtEntidadSisAdminBk.setFechaCrea(hoy);
					dtEntidadSisAdminBk.setFechaModif(hoy);
					dtEntidadSisAdminBk.setIdusserCrea(kyUsuarioMod);
					dtEntidadSisAdminBk.setIdusserModif(kyUsuarioMod);
					dtEntidadSisAdminBk.setRtmaddress(rmtaddress);
					dtEntidadSisAdminBk.setRtmaddressrst(rmtaddress);

					dtEntidadSisAdmin = new DtEntidadSisAdmin();

					FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdmin, dtEntidadSisAdminBk);
					dtEntidadSisAdminDao.saveDtEntidadSisAdmin(dtEntidadSisAdmin);

					log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
							+ "CREADO dtEntidadSisAdmin" + " :: " + dtEntidadSisAdmin.getIdentidadSisadm().toString()
							+ " :: " + "0" + " :: " + "" + Estado.ACTIVO.getValor());

				}
			}
		}
		// MPINARES 24012023 - FIN
		// cargarDtEntidadSedes(dtEntidadSedesBkss, dtEntidades.getIdEntidad(),
		// user, kyUsuarioMod, kyAreaMod, rmtaddress);
		dtEntidadesBk = getDtEntidadesBkXid(dtEntidades.getIdEntidad(), kyUsuarioMod);
		return dtEntidadesBk;
	}

	@Override
	public void deleteDtEntidades(DtEntidadesBk dtEntidadesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtEntidades dtEntidades = null;
			if (dtEntidadesBk.getIdEntidad() != null && dtEntidadesBk.getIdEntidad().longValue() > 0) {

				dtEntidades = dtEntidadesDao.getDtEntidades(dtEntidadesBk.getIdEntidad());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidades.setRtmaddressrst(rmtaddress);
				dtEntidades.setIdusserModif(kyUsuarioMod);
				dtEntidades.setFechaModif(hoy);
				Long estadoanterior = dtEntidades.getEstado();
				dtEntidades.setEstado(Estado.ELIMINADO.getValor());

				dtEntidadesDao.updateDtEntidades(dtEntidades);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtEntidades" + " :: " + dtEntidades.getIdEntidad().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtEntidades(DtEntidadesBk dtEntidadesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtEntidades dtEntidades = null;
			if (dtEntidadesBk.getIdEntidad() != null && dtEntidadesBk.getIdEntidad().longValue() > 0) {

				dtEntidades = dtEntidadesDao.getDtEntidades(dtEntidadesBk.getIdEntidad());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidades.setRtmaddressrst(rmtaddress);
				dtEntidades.setIdusserModif(kyUsuarioMod);
				dtEntidades.setFechaModif(hoy);
				Long estadoanterior = dtEntidades.getEstado();
				dtEntidades.setEstado(Estado.ACTIVO.getValor());

				dtEntidadesDao.updateDtEntidades(dtEntidades);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtEntidades" + " :: " + dtEntidades.getIdEntidad().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	// @Override
	// public List<DtEntidadesBk> getDtEntidadesXFiltro(String codEjec,String
	// razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer
	// codDistr,Long idCaract,Long idSistAdmi,Long estado, Long kyUsuarioMod) {
	// List<DtEntidadesBk> dtEntidadesBkss = new ArrayList<DtEntidadesBk>();
	// try {
	// List<DtEntidades> dtEntidadessss =
	// dtEntidadesDao.getXFiltro2(codEjec,razSocial,ruc,idTipo,codDpto,codProv,codDistr,idCaract,idSistAdmi,estado);
	// for (DtEntidades dtEntidades : dtEntidadessss) {
	// DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
	// FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
	// completarDtEntidades(dtEntidadesBk);
	// setACLDtEntidadesBk(dtEntidadesBk,kyUsuarioMod);
	// dtEntidadesBkss.add(dtEntidadesBk);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return dtEntidadesBkss;
	// }

	@Override
	public List<DtEntidadesBk> getDtEntidadesXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo,
			Integer codDpto, Integer codProv, Integer codDistr, Long idCaract, Long idSistAdmi, Long estado,
			int inicial, int MAX, Long kyUsuarioMod) {
		List<DtEntidadesBk> dtEntidadesBkss = new ArrayList<DtEntidadesBk>();
		try {
			List<DtEntidades> dtEntidadessss = dtEntidadesDao.getXFiltro(codEjec, razSocial, ruc, idTipo, codDpto,
					codProv, codDistr, idCaract, idSistAdmi, estado, inicial, MAX);
			for (DtEntidades dtEntidades : dtEntidadessss) {
				DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
				completarDtEntidades(dtEntidadesBk);
				setACLDtEntidadesBk(dtEntidadesBk, kyUsuarioMod);
				dtEntidadesBkss.add(dtEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesBkss;
	}

	@Override
	public Long getDtEntidadesTotalXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo, Integer codDpto,
			Integer codProv, Integer codDistr, Long idCaract, Long idSistAdmi, Long estado, Long kyUsuarioMod) {
		try {
			Long totalDtEntidadessss = dtEntidadesDao.getTotalXFiltro(codEjec, razSocial, ruc, idTipo, codDpto, codProv,
					codDistr, idCaract, idSistAdmi, estado);

			return totalDtEntidadessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtEntidadesBk(DtEntidadesBk dtEntidadesBk, Long kyUsuarioMod) {
		DtEntidadesACL dtEntidadesACL = new DtEntidadesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADES_CREA)) {
					dtEntidadesACL.setEsEditable(true);
					dtEntidadesACL.setEliminar(true);
				} else if (roles.contains(Roles.DTENTIDADES_VE)) {
					dtEntidadesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADES_CREA)) {
					dtEntidadesACL.setEditopcion(1);
				} else {
					dtEntidadesACL.setEditopcion(2);
				}
			} else {
				dtEntidadesACL.setEditopcion(2);
			}
		} else {
			dtEntidadesACL.setEditopcion(2);
		}
		dtEntidadesBk.setDtEntidadesACL(dtEntidadesACL);
	}

	/// ADICIONALES
	@Override
	public List<DtEntidadesBk> getDtEntidadesIdEntidadTxt(String idEntidadTxt) {
		List<DtEntidadesBk> dtEntidadesLista = new ArrayList<DtEntidadesBk>();
		if (idEntidadTxt == null)
			return dtEntidadesLista;
		if (idEntidadTxt.length() < 3)
			return dtEntidadesLista;
		List<DtEntidades> dtEntidadessss = dtEntidadesDao.getListaRazSocial(idEntidadTxt.toUpperCase());
		for (DtEntidades dtEntidades : dtEntidadessss) {
			DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
			dtEntidadesLista.add(dtEntidadesBk);
		}

		return dtEntidadesLista;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdCaract() {
		if (prtParametrosIdparametroIdCaractListaCache == null) {
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			// MPINARES 24012023 - INICIO
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("CARACTERÍSTICA ENTIDAD");
			// MPINARES 24012023 - FIN
			prtParametrosIdparametroIdCaractListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdCaractListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdCaractListaCache;
	}

	/**
	 * ADICIONAR EN EL msSisAdmistrativoDao
	 * 
	 **/
	@Override
	public List<IDValorDto> getMsSisAdmistrativoIdSistAdmiIdSistAdmi() {
		if (msSisAdmistrativoIdSistAdmiIdSistAdmiListaCache == null) {
			// MPINARES 24012023 - INICIO
			// List<MsSisAdmistrativo> msSisAdmistrativosss =
			// msSisAdmistrativoDao.getListaIdSistAdmi();
			List<MsSisAdmistrativo> msSisAdmistrativosss = msSisAdmistrativoDao.getActivasMsSisAdmistrativoCero();
			// MPINARES 24012023 - FIN
			msSisAdmistrativoIdSistAdmiIdSistAdmiListaCache = new ArrayList<IDValorDto>();
			for (MsSisAdmistrativo msSisAdmistrativo : msSisAdmistrativosss) {
				IDValorDto idSistAdmiDto = new IDValorDto(msSisAdmistrativo.getIdSistAdmi(),
						msSisAdmistrativo.getDescripcion());
				msSisAdmistrativoIdSistAdmiIdSistAdmiListaCache.add(idSistAdmiDto);
			}
		}
		return msSisAdmistrativoIdSistAdmiIdSistAdmiListaCache;
	}

	@Override
	public List<DtEntidadSedesDto> getDtEntidadSedesDtossXIdEntidad(Long idEntidad) {
		List<DtEntidadSedesDto> dtEntidadSedesDtoss = new ArrayList<DtEntidadSedesDto>();
		try {
			List<DtEntidadSedes> dtEntidadSedesssss = dtEntidadSedesDao.getXFiltro(idEntidad, null);
			for (DtEntidadSedes dtEntidadSedes : dtEntidadSedesssss) {
				DtEntidadSedesDto dtEntidadSedesDto = new DtEntidadSedesDto();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesDto, dtEntidadSedes);
				dtEntidadSedesDtoss.add(dtEntidadSedesDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSedesDtoss;
	}

	private void cargarDtEntidadSedes(List<DtEntidadSedesBk> dtEntidadSedesBkss, Long idEntidad, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		List<DtEntidadSedesDto> dtEntidadSedesDtosss = getDtEntidadSedesDtossXIdEntidad(idEntidad);

		if (dtEntidadSedesBkss != null && !dtEntidadSedesBkss.isEmpty()) {
			for (DtEntidadSedesDto dtEntidadSedesDto : dtEntidadSedesDtosss) {
				DtEntidadSedesBk dtEntidadSedesBk = new DtEntidadSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedesDto);
				if (!dtEntidadSedesBkss.contains(dtEntidadSedesBk))
					deleteDtEntidadSedes(dtEntidadSedesBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
			}
			for (DtEntidadSedesBk dtEntidadSedesBk : dtEntidadSedesBkss) {
				if (dtEntidadSedesBk.getIdEntidad() == null || dtEntidadSedesBk.getIdEntidad().longValue() <= 0) {
					dtEntidadSedesBk.setIdEntidad(idEntidad);
				}
				saveorupdateDtEntidadSedesBk(dtEntidadSedesBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
			}
		} else {
			for (DtEntidadSedesDto dtEntidadSedesDto : dtEntidadSedesDtosss) {
				DtEntidadSedesBk dtEntidadSedesBk = new DtEntidadSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedesDto);
				deleteDtEntidadSedes(dtEntidadSedesBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
			}
		}
	}

	/**
	 * DT_ENTIDAD_SIS_ADMIN SERVICIO: LISTA DE LOS SISTEMAS ADMINISTRATIVOS
	 * ASIGNADOS A LA ENTIDAD
	 */
	@Override
	public DtEntidadSisAdminBk getDtEntidadSisAdminBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtEntidadSisAdmin dtEntidadSisAdmin = dtEntidadSisAdminDao.getDtEntidadSisAdmin(id);
		DtEntidadSisAdminBk dtEntidadSisAdminBk = null;
		if (dtEntidadSisAdmin != null) {
			dtEntidadSisAdminBk = new DtEntidadSisAdminBk();
			FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdminBk, dtEntidadSisAdmin);
			completarDtEntidadSisAdmin(dtEntidadSisAdminBk);
			if (kyUsuarioMod != null)
				setACLDtEntidadSisAdminBk(dtEntidadSisAdminBk, kyUsuarioMod);
		}
		return dtEntidadSisAdminBk;
	}

	@Override
	public List<DtEntidadSisAdminBk> getAllDtEntidadSisAdminActivos(Long kyUsuarioMod) {
		List<DtEntidadSisAdminBk> dtEntidadSisAdminBkss = new ArrayList<DtEntidadSisAdminBk>();
		try {
			List<DtEntidadSisAdmin> dtEntidadSisAdmins = dtEntidadSisAdminDao.getActivasDtEntidadSisAdmin();
			for (DtEntidadSisAdmin dtEntidadSisAdmin : dtEntidadSisAdmins) {
				DtEntidadSisAdminBk dtEntidadSisAdminBk = new DtEntidadSisAdminBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdminBk, dtEntidadSisAdmin);
				completarDtEntidadSisAdmin(dtEntidadSisAdminBk);
				setACLDtEntidadSisAdminBk(dtEntidadSisAdminBk, kyUsuarioMod);
				dtEntidadSisAdminBkss.add(dtEntidadSisAdminBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSisAdminBkss;
	}

	@Override
	public List<DtEntidadSisAdminBk> getAllDtEntidadSisAdminActivosCero(Long kyUsuarioMod) {
		List<DtEntidadSisAdminBk> dtEntidadSisAdminBkss = new ArrayList<DtEntidadSisAdminBk>();
		try {
			List<DtEntidadSisAdmin> dtEntidadSisAdmins = dtEntidadSisAdminDao.getActivasDtEntidadSisAdminCero();
			for (DtEntidadSisAdmin dtEntidadSisAdmin : dtEntidadSisAdmins) {
				DtEntidadSisAdminBk dtEntidadSisAdminBk = new DtEntidadSisAdminBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdminBk, dtEntidadSisAdmin);
				completarDtEntidadSisAdmin(dtEntidadSisAdminBk);
				setACLDtEntidadSisAdminBk(dtEntidadSisAdminBk, kyUsuarioMod);
				dtEntidadSisAdminBkss.add(dtEntidadSisAdminBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSisAdminBkss;
	}

	private void completarDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk) {
		try {
			if (dtEntidadSisAdminBk.getIdEntidad() != null && dtEntidadSisAdminBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtEntidadSisAdminBk.getIdEntidad());
				if (dtEntidades != null)
					dtEntidadSisAdminBk.setIdEntidadTxt(dtEntidades.getRazSocial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadSisAdminBk.getIdSistAdmi() != null && dtEntidadSisAdminBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtEntidadSisAdminBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					dtEntidadSisAdminBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtEntidadSisAdminBk.getEstado()!=null &&
		// dtEntidadSisAdminBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEntidadSisAdminBk.getEstado());
		// if(prtParametros!=null)
		// dtEntidadSisAdminBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtEntidadSisAdminBk saveorupdateDtEntidadSisAdminBk(DtEntidadSisAdminBk dtEntidadSisAdminBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtEntidadSisAdminMng.validarDtEntidadSisAdminBk(dtEntidadSisAdminBk);

		DtEntidadSisAdmin dtEntidadSisAdmin = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtEntidadSisAdminBk.getIdentidadSisadm() != null
					&& dtEntidadSisAdminBk.getIdentidadSisadm().longValue() > 0) {

				dtEntidadSisAdmin = dtEntidadSisAdminDao.getDtEntidadSisAdmin(dtEntidadSisAdminBk.getIdentidadSisadm());

				boolean cambios = AuditoriaDtEntidadSisAdminMng.auditarCambiosDtEntidadSisAdmin(dtEntidadSisAdminBk,
						dtEntidadSisAdmin, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtEntidadSisAdmin.setRtmaddressrst(rmtaddress);
					dtEntidadSisAdmin.setIdusserModif(kyUsuarioMod);
					dtEntidadSisAdmin.setFechaModif(hoy);
					dtEntidadSisAdminDao.updateDtEntidadSisAdmin(dtEntidadSisAdmin);
				}
			} else {
				dtEntidadSisAdminBk.setRtmaddress(rmtaddress);
				dtEntidadSisAdminBk.setRtmaddressrst(rmtaddress);

				dtEntidadSisAdminBk.setFechaCrea(hoy);
				dtEntidadSisAdminBk.setIdusserCrea(kyUsuarioMod);
				dtEntidadSisAdminBk.setIdusserModif(kyUsuarioMod);
				dtEntidadSisAdminBk.setFechaModif(hoy);
				dtEntidadSisAdminBk.setEstado(Estado.ACTIVO.getValor());

				dtEntidadSisAdmin = new DtEntidadSisAdmin();

				FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdmin, dtEntidadSisAdminBk);
				dtEntidadSisAdminDao.saveDtEntidadSisAdmin(dtEntidadSisAdmin);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtEntidadSisAdmin" + " :: "
								+ dtEntidadSisAdmin.getIdentidadSisadm().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtEntidadSisAdminBk = getDtEntidadSisAdminBkXid(dtEntidadSisAdmin.getIdentidadSisadm(), kyUsuarioMod);
		return dtEntidadSisAdminBk;
	}

	@Override
	public void deleteDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtEntidadSisAdmin dtEntidadSisAdmin = null;
			if (dtEntidadSisAdminBk.getIdentidadSisadm() != null
					&& dtEntidadSisAdminBk.getIdentidadSisadm().longValue() > 0) {

				dtEntidadSisAdmin = dtEntidadSisAdminDao.getDtEntidadSisAdmin(dtEntidadSisAdminBk.getIdentidadSisadm());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidadSisAdmin.setRtmaddressrst(rmtaddress);
				dtEntidadSisAdmin.setIdusserModif(kyUsuarioMod);
				dtEntidadSisAdmin.setFechaModif(hoy);
				Long estadoanterior = dtEntidadSisAdmin.getEstado();
				dtEntidadSisAdmin.setEstado(Estado.ELIMINADO.getValor());

				dtEntidadSisAdminDao.updateDtEntidadSisAdmin(dtEntidadSisAdmin);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtEntidadSisAdmin" + " :: " + dtEntidadSisAdmin.getIdentidadSisadm().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtEntidadSisAdmin dtEntidadSisAdmin = null;
			if (dtEntidadSisAdminBk.getIdentidadSisadm() != null
					&& dtEntidadSisAdminBk.getIdentidadSisadm().longValue() > 0) {

				dtEntidadSisAdmin = dtEntidadSisAdminDao.getDtEntidadSisAdmin(dtEntidadSisAdminBk.getIdentidadSisadm());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidadSisAdmin.setRtmaddressrst(rmtaddress);
				dtEntidadSisAdmin.setIdusserModif(kyUsuarioMod);
				dtEntidadSisAdmin.setFechaModif(hoy);
				Long estadoanterior = dtEntidadSisAdmin.getEstado();
				dtEntidadSisAdmin.setEstado(Estado.ACTIVO.getValor());

				dtEntidadSisAdminDao.updateDtEntidadSisAdmin(dtEntidadSisAdmin);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtEntidadSisAdmin" + " :: " + dtEntidadSisAdmin.getIdentidadSisadm().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtEntidadSisAdminBk> getDtEntidadSisAdminXFiltro(Long idEntidad, Long kyUsuarioMod) {
		List<DtEntidadSisAdminBk> dtEntidadSisAdminBkss = new ArrayList<DtEntidadSisAdminBk>();
		try {
			List<DtEntidadSisAdmin> dtEntidadSisAdminsss = dtEntidadSisAdminDao.getXFiltro(idEntidad);
			for (DtEntidadSisAdmin dtEntidadSisAdmin : dtEntidadSisAdminsss) {
				DtEntidadSisAdminBk dtEntidadSisAdminBk = new DtEntidadSisAdminBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdminBk, dtEntidadSisAdmin);
				completarDtEntidadSisAdmin(dtEntidadSisAdminBk);
				setACLDtEntidadSisAdminBk(dtEntidadSisAdminBk, kyUsuarioMod);
				dtEntidadSisAdminBkss.add(dtEntidadSisAdminBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSisAdminBkss;
	}

	@Override
	public List<DtEntidadSisAdminBk> getDtEntidadSisAdminXFiltro(Long idEntidad, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtEntidadSisAdminBk> dtEntidadSisAdminBkss = new ArrayList<DtEntidadSisAdminBk>();
		try {
			List<DtEntidadSisAdmin> dtEntidadSisAdminsss = dtEntidadSisAdminDao.getXFiltro(idEntidad, inicial, MAX);
			for (DtEntidadSisAdmin dtEntidadSisAdmin : dtEntidadSisAdminsss) {
				DtEntidadSisAdminBk dtEntidadSisAdminBk = new DtEntidadSisAdminBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSisAdminBk, dtEntidadSisAdmin);
				completarDtEntidadSisAdmin(dtEntidadSisAdminBk);
				setACLDtEntidadSisAdminBk(dtEntidadSisAdminBk, kyUsuarioMod);
				dtEntidadSisAdminBkss.add(dtEntidadSisAdminBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSisAdminBkss;
	}

	@Override
	public Long getDtEntidadSisAdminTotalXFiltro(Long idEntidad, Long kyUsuarioMod) {
		try {
			Long totalDtEntidadSisAdminsss = dtEntidadSisAdminDao.getTotalXFiltro(idEntidad);

			return totalDtEntidadSisAdminsss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtEntidadSisAdminBk(DtEntidadSisAdminBk dtEntidadSisAdminBk, Long kyUsuarioMod) {
		DtEntidadSisAdminACL dtEntidadSisAdminACL = new DtEntidadSisAdminACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADSISADMIN_CREA)) {
					dtEntidadSisAdminACL.setEsEditable(true);
					dtEntidadSisAdminACL.setEliminar(true);
				} else if (roles.contains(Roles.DTENTIDADSISADMIN_VE)) {
					dtEntidadSisAdminACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADSISADMIN_CREA)) {
					dtEntidadSisAdminACL.setEditopcion(1);
				} else {
					dtEntidadSisAdminACL.setEditopcion(2);
				}
			} else {
				dtEntidadSisAdminACL.setEditopcion(2);
			}
		} else {
			dtEntidadSisAdminACL.setEditopcion(2);
		}
		dtEntidadSisAdminBk.setDtEntidadSisAdminACL(dtEntidadSisAdminACL);
	}

	/// ADICIONALES

	/**
	 * DT_VISITAS SERVICIO: LISTA DE LOS DATOS REGISTRADOS EN UNA VISITA
	 */
	@Override
	public DtVisitasBk getDtVisitasBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(id);
		DtVisitasBk dtVisitasBk = null;
		if (dtVisitas != null) {
			dtVisitasBk = new DtVisitasBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
			completarDtVisitas(dtVisitasBk);
			if (kyUsuarioMod != null)
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
		}
		return dtVisitasBk;
	}

	@Override
	public List<DtVisitasBk> getAllDtVisitasActivos(Long kyUsuarioMod) {
		List<DtVisitasBk> dtVisitasBkss = new ArrayList<DtVisitasBk>();
		try {
			List<DtVisitas> dtVisitass = dtVisitasDao.getActivasDtVisitas();
			for (DtVisitas dtVisitas : dtVisitass) {
				DtVisitasBk dtVisitasBk = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
				completarDtVisitas(dtVisitasBk);
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
				dtVisitasBkss.add(dtVisitasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasBkss;
	}

	@Override
	public List<DtVisitasBk> getAllDtVisitasActivosCero(Long kyUsuarioMod) {
		List<DtVisitasBk> dtVisitasBkss = new ArrayList<DtVisitasBk>();
		try {
			List<DtVisitas> dtVisitass = dtVisitasDao.getActivasDtVisitasCero();
			for (DtVisitas dtVisitas : dtVisitass) {
				DtVisitasBk dtVisitasBk = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
				completarDtVisitas(dtVisitasBk);
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
				dtVisitasBkss.add(dtVisitasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasBkss;
	}

	// private void completarDtVisitas(DtVisitasBk dtVisitasBk){
	// try{
	// if(dtVisitasBk.getIdSistAdm()!=null &&
	// dtVisitasBk.getIdSistAdm().longValue()>0){
	// MsSisAdmistrativo msSisAdmistrativo =
	// msSisAdmistrativoDao.getMsSisAdmistrativo(dtVisitasBk.getIdSistAdm());
	// if(msSisAdmistrativo!=null)
	// dtVisitasBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }try{
	// if(dtVisitasBk.getIdSede()!=null &&
	// dtVisitasBk.getIdSede().longValue()>0){
	// MsSedes msSedes = msSedesDao.getMsSedes(dtVisitasBk.getIdSede());
	// if(msSedes!=null)
	// dtVisitasBk.setIdSedeTxt(msSedes.getSede());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try{
	// if(dtVisitasBk.getIdOrigen()!=null &&
	// dtVisitasBk.getIdOrigen().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getIdOrigen());
	// if(prtParametros!=null)
	// dtVisitasBk.setIdOrigenTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try{
	// if(dtVisitasBk.getIdProgramacion()!=null &&
	// dtVisitasBk.getIdProgramacion().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getIdProgramacion());
	// if(prtParametros!=null)
	// dtVisitasBk.setIdProgramacionTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//// try{
	//// if(dtVisitasBk.getEstado()!=null &&
	// dtVisitasBk.getEstado().longValue()>0){
	//// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getEstado());
	//// if(prtParametros!=null)
	//// dtVisitasBk.setEstadoTxt(prtParametros.getDescripcion());
	//// }
	//// } catch (Exception e) {
	//// e.printStackTrace();
	//// }
	// try{
	// if(dtVisitasBk.getIdModalidad()!=null &&
	// dtVisitasBk.getIdModalidad().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getIdModalidad());
	// if(prtParametros!=null)
	// dtVisitasBk.setIdModalidadTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try{
	// if(dtVisitasBk.getIdTipo()!=null &&
	// dtVisitasBk.getIdTipo().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getIdTipo());
	// if(prtParametros!=null)
	// dtVisitasBk.setIdTipoTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try{
	// if(dtVisitasBk.getIdLugar()!=null &&
	// dtVisitasBk.getIdLugar().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getIdLugar());
	// if(prtParametros!=null)
	// dtVisitasBk.setIdLugarTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try{
	// if(dtVisitasBk.getIdEntidad()!=null &&
	// dtVisitasBk.getIdEntidad().longValue()>0){
	// DtEntidadesBk dtEntidades =
	// getDtEntidadesBkXid(dtVisitasBk.getIdEntidad(),null);
	// if(dtEntidades!=null){
	// dtVisitasBk.setIdEntidadTxt(dtEntidades.getRazSocial());
	// dtVisitasBk.setRazSocial(dtEntidades.getRazSocial());
	// dtVisitasBk.setCodDptoTxt(dtEntidades.getCodDptoTxt());
	// dtVisitasBk.setCodProvTxt(dtEntidades.getCodProvTxt());
	// dtVisitasBk.setCodDistrTxt(dtEntidades.getCodDistrTxt());
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }try{
	// if(dtVisitasBk.getIdFinancia()!=null &&
	// dtVisitasBk.getIdFinancia().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(dtVisitasBk.getIdFinancia());
	// if(prtParametros!=null)
	// dtVisitasBk.setIdFinanciaTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	//
	// }

	@Override
	public DtVisitasBk saveorupdateDtVisitasBk(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		// PURIBE 14032024 -INICIO-->

		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);

		Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);
		DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), FuncionesStaticas.getMonth());

		// ***********************************************************************************************************
		DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), FuncionesStaticas.getMonth());

		if (autorizacionProgramacion2 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion2;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion2;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				dtVisitasBk.getIdSede(), idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion3 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion3;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion3;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				idSedeTodas, idSisAdmTodos, FuncionesStaticas.getMonth());
		if (autorizacionProgramacion4 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion4;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion4;
			}
		}

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);
		// Integer mesServicio=dtVisitasBk.getFechaVisita().getMonth()+1;
		// SPRINT_4.1 INICIO

		Integer mesServicio = dtVisitasBk.getFechaVisita().getMonth() + 1;

		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}
		DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion,
				dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), mesServicio + 1);// Ahora
																						// Mes
																						// Actual,
																						// por
																						// confirmar

		if (autorizacionEjecucion == null) {
			autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion, idSedeTodas,
					dtVisitasBk.getIdSistAdm(), mesServicio + 1);// Ahora Mes
																	// Actual,
																	// por
																	// confirmar
			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion,
						dtVisitasBk.getIdSede(), idSisAdmTodos, mesServicio + 1);// Ahora
																					// Mes
																					// Actual,
																					// por
																					// confirmar
				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion, idSedeTodas,
							idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual,
															// por confirmar
				}
			}
		}

		DtVisitas dtVisitasOrig = null;
		if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {
			dtVisitasOrig = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());
		}
		// PURIBE 14032024 -FIN-->

		// PURIBE 14032024 -INICIO-->
		ValidacionDtVisitasMng.validarDtVisitasBk(dtVisitasBk, autorizacionProgramacion, autorizacionEjecucion,
				msRolesDao.isRolAdministradorOGC(kyUsuarioMod), dtVisitasOrig);
		// PURIBE 14032024 -FIN-->

		DtVisitas dtVisitas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {

				dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());

				boolean cambios = AuditoriaDtVisitasMng.auditarCambiosDtVisitas(dtVisitasBk, dtVisitas, kyUsuarioMod,
						user, rmtaddress, nivel);

				if (cambios) {
					dtVisitas.setRtmaddressrst(rmtaddress);
					dtVisitas.setIdusserModif(kyUsuarioMod);
					dtVisitas.setFechaModif(hoy);
					dtVisitasDao.updateDtVisitas(dtVisitas);
				}
			} else {
				dtVisitasBk.setRtmaddress(rmtaddress);
				dtVisitasBk.setRtmaddressrst(rmtaddress);

				dtVisitasBk.setFechaCrea(hoy);
				dtVisitasBk.setIdusserCrea(kyUsuarioMod);
				dtVisitasBk.setIdusserModif(kyUsuarioMod);
				dtVisitasBk.setFechaModif(hoy);
				dtVisitasBk.setEstado(Estado.ACTIVO.getValor());

				dtVisitas = new DtVisitas();

				FuncionesStaticas.copyPropertiesObject(dtVisitas, dtVisitasBk);
				dtVisitasDao.saveDtVisitas(dtVisitas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "CREADO dtVisitas"
								+ " :: " + dtVisitas.getIdVisita().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtVisitasBk = getDtVisitasBkXid(dtVisitas.getIdVisita(), kyUsuarioMod);
		return dtVisitasBk;
	}

	// @Override
	// public void deleteDtVisitas(
	// DtVisitasBk dtVisitasBk,
	// String user,
	// Long kyUsuarioMod,
	// Long kyAreaMod,
	// String rmtaddress
	// )throws Validador {
	// try {
	// DtVisitas dtVisitas = null;
	// if(dtVisitasBk.getIdVisita()!=null &&
	// dtVisitasBk.getIdVisita().longValue()>0){
	//
	// dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());
	//
	// Timestamp hoy = new Timestamp(System.currentTimeMillis());
	//
	// dtVisitas.setRtmaddressrst(rmtaddress);
	// dtVisitas.setIdusserModif(kyUsuarioMod);
	// dtVisitas.setFechaModif(hoy);
	// Long estadoanterior = dtVisitas.getEstado();
	// dtVisitas.setEstado(Estado.ELIMINADO.getValor());
	//
	// dtVisitasDao.updateDtVisitas(dtVisitas);
	//
	// log.log(Level.INFO,"CAMBIO :: "+ kyUsuarioMod + " :: "+ user + " :: "+
	// rmtaddress+" :: "+"ELIMINADO dtVisitas"+" ::
	// "+dtVisitas.getIdVisita().toString()+" :: "+ estadoanterior + " :: "+
	// "0");
	//
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new Validador(e.getMessage());
	// }
	// }

	@Override
	public void activarDtVisitas(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtVisitas dtVisitas = null;
			if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {

				dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitas.setRtmaddressrst(rmtaddress);
				dtVisitas.setIdusserModif(kyUsuarioMod);
				dtVisitas.setFechaModif(hoy);
				Long estadoanterior = dtVisitas.getEstado();
				dtVisitas.setEstado(Estado.ACTIVO.getValor());

				dtVisitasDao.updateDtVisitas(dtVisitas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtVisitas" + " :: " + dtVisitas.getIdVisita().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtVisitasBk> getDtVisitasXFiltro(Timestamp fechaVisita, Long idSistAdm, Long idSede, Long idOrigen,
			Long idProgramacion, Long estado, Long kyUsuarioMod) {
		List<DtVisitasBk> dtVisitasBkss = new ArrayList<DtVisitasBk>();
		try {
			List<DtVisitas> dtVisitassss = dtVisitasDao.getXFiltro(fechaVisita, idSistAdm, idSede, idOrigen,
					idProgramacion, estado);
			for (DtVisitas dtVisitas : dtVisitassss) {
				DtVisitasBk dtVisitasBk = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
				completarDtVisitas(dtVisitasBk);
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
				dtVisitasBkss.add(dtVisitasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasBkss;
	}

	@Override
	public List<DtVisitasBk> getDtVisitasXFiltro(Timestamp fechaVisita, Long idSistAdm, Long idSede, Long idOrigen,
			Long idProgramacion, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtVisitasBk> dtVisitasBkss = new ArrayList<DtVisitasBk>();
		try {
			List<DtVisitas> dtVisitassss = dtVisitasDao.getXFiltro(fechaVisita, idSistAdm, idSede, idOrigen,
					idProgramacion, estado, inicial, MAX);
			for (DtVisitas dtVisitas : dtVisitassss) {
				DtVisitasBk dtVisitasBk = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
				completarDtVisitas(dtVisitasBk);
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
				dtVisitasBkss.add(dtVisitasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasBkss;
	}

	@Override
	public Long getDtVisitasTotalXFiltro(Timestamp fechaVisita, Long idSistAdm, Long idSede, Long idOrigen,
			Long idProgramacion, Long estado, Long kyUsuarioMod) {
		try {
			Long totalDtVisitassss = dtVisitasDao.getTotalXFiltro(fechaVisita, idSistAdm, idSede, idOrigen,
					idProgramacion, estado);

			return totalDtVisitassss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtVisitasBk(DtVisitasBk dtVisitasBk, Long kyUsuarioMod) {
		DtVisitasACL dtVisitasACL = new DtVisitasACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();

				// PURIBE 22032024 - INICIO--
				// PURIBE 29032024 - INICIO--
				if ((roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REACTIVA_ANULADOS)
						|| roles.contains(Roles.PERFIL_ADMINISTRADOR) || // PURIBE
																			// 04042024
																			// -
																			// INICIO
						roles.contains(Roles.PERFIL_USU_OGC)) && (dtVisitasBk.getEstado() == PropertiesMg.getSistemLong( // PURIBE
																															// 22032024
																															// -
																															// FIN//
																															// PURIBE
																															// 14032024
																															// -
																															// INICIO
																															// -->
								PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
								PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO)
								|| dtVisitasBk.getEstado() == PropertiesMg.getSistemLong(
										PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
										PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO))) {
					dtVisitasACL.setReactivar(true);
					// PURIBE 29032024 - FIN--
				} else {
					dtVisitasACL.setReactivar(false);
				}
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR)
						|| roles.contains(Roles.DTVISITAS_CREA) // PURIBE
																// 04042024 -
																// INICIO
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) { // PURIBE
																						// 22032024
																						// -
																						// FIN--//
																						// PURIBE
																						// 14032024
																						// -
																						// INICIO
																						// -->
					dtVisitasACL.setEliminar(true);
				} else {
					dtVisitasACL.setEliminar(false);
				}
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITAS_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {// PURIBE
																						// 22032024
																						// -
																						// FIN,//PURIBE
																						// 04042024
																						// -
																						// FIN
					dtVisitasACL.setEsEditable(true);
					dtVisitasACL.setEliminar(true);
				} else if (roles.contains(Roles.DTVISITAS_VE)) {
					dtVisitasACL.setEsEditable(true);
				}
				// PURIBE 04042024 - INICIO

				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR)
						|| roles.contains(Roles.DTENTIDADES_CREA) || roles.contains(Roles.PERFIL_USU_OGC)) {
					dtVisitasACL.setEditentidad(2);
				} else {
					dtVisitasACL.setEditentidad(1);
				}
				// PURIBE 04042024 - FIN
				// PURIBE 04042024 - INICIO
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR)
						|| roles.contains(Roles.DTVISITAS_CREA) || roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {// PURIBE
																						// 22032024
																						// -
																						// FIN--
																						// //PURIBE
																						// 04042024
																						// -
																						// FIN
					dtVisitasACL.setEditopcion(1);
				} else {
					dtVisitasACL.setEditopcion(2);
				}
			} else {
				dtVisitasACL.setEditopcion(2);
			}
		} else {
			dtVisitasACL.setEditopcion(2);
		}
		dtVisitasBk.setDtVisitasACL(dtVisitasACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL msSedesDao
	 * 
	 **/
	@Override
	public List<IDValorDto> getMsSedesIdSedeIdSede() {
		if (msSedesIdSedeIdSedeListaCache == null) {
			List<MsSedes> msSedessss = msSedesDao.getListaIdSede();
			msSedesIdSedeIdSedeListaCache = new ArrayList<IDValorDto>();
			for (MsSedes msSedes : msSedessss) {
				IDValorDto idSedeDto = new IDValorDto(msSedes.getIdSede(), msSedes.getSede());
				msSedesIdSedeIdSedeListaCache.add(idSedeDto);
			}
		}
		return msSedesIdSedeIdSedeListaCache;
	}

	@Override
	public List<IDValorDto> getMsSedesIdSedeIdSedeExTodas() {
		getMsSedesIdSedeIdSede();
		List<IDValorDto> msSedesIdSedeIdSedeExTodas = new ArrayList<IDValorDto>();
		if (msSedesIdSedeIdSedeListaCache != null && msSedesIdSedeIdSedeListaCache.size() > 0) {
			Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
					PropertiesMg.DEFOULT_IDSEDES_TODAS);
			for (IDValorDto sedee : msSedesIdSedeIdSedeListaCache) {
				if (sedee.getId().longValue() != idSedeTodas) {
					msSedesIdSedeIdSedeExTodas.add(sedee);
				}
			}
		}
		return msSedesIdSedeIdSedeExTodas;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdLugar() {
		if (prtParametrosIdparametroIdLugarListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdLugarListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdLugarListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdLugarListaCache;
	}

	/**
	 * ADICIONAR EN EL dtEntidadesDao
	 * 
	 **/
	@Override
	public List<DtEntidadesBk> getDtEntidadesRazSocial(String razSocial) {
		List<DtEntidadesBk> dtEntidadesLista = new ArrayList<DtEntidadesBk>();
		if (razSocial == null)
			return dtEntidadesLista;
		if (razSocial.length() < 3)
			return dtEntidadesLista;
		List<DtEntidades> dtEntidadessss = dtEntidadesDao.getListaRazSocial(razSocial);
		for (DtEntidades dtEntidades : dtEntidadessss) {
			DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
			dtEntidadesLista.add(dtEntidadesBk);
		}

		return dtEntidadesLista;
	}

	/**
	 * ADICIONAR EN EL dtUsuarioExternoDao
	 * 
	 **/
	@Override
	public List<DtUsuarioExternoBk> getDtUsuarioExternoNombre(String nombre) {
		List<DtUsuarioExternoBk> dtUsuarioExternoLista = new ArrayList<DtUsuarioExternoBk>();
		if (nombre == null)
			return dtUsuarioExternoLista;
		if (nombre.length() < 3)
			return dtUsuarioExternoLista;
		List<DtUsuarioExterno> dtUsuarioExternosss = dtUsuarioExternoDao.getListaNombre(nombre);
		for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternosss) {
			DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
			FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
			dtUsuarioExternoLista.add(dtUsuarioExternoBk);
		}

		return dtUsuarioExternoLista;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdCargoUsuext() {
		if (prtParametrosIdparametroIdCargoUsuextListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdCargoUsuextListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdCargoUsuextListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdCargoUsuextListaCache;
	}

	/**
	 * DT_ENTIDADES_USUEXTERNOS SERVICIO: LISTA DE LAS ENTIDADES A LA QUE
	 * PERTENECE EL USUARIO EXTERNO
	 */
	@Override
	public DtEntidadesUsuexternosBk getDtEntidadesUsuexternosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtEntidadesUsuexternos dtEntidadesUsuexternos = dtEntidadesUsuexternosDao.getDtEntidadesUsuexternos(id);
		DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk = null;
		if (dtEntidadesUsuexternos != null) {
			dtEntidadesUsuexternosBk = new DtEntidadesUsuexternosBk();
			FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternosBk, dtEntidadesUsuexternos);
			completarDtEntidadesUsuexternos(dtEntidadesUsuexternosBk);
			if (kyUsuarioMod != null)
				setACLDtEntidadesUsuexternosBk(dtEntidadesUsuexternosBk, kyUsuarioMod);
		}
		return dtEntidadesUsuexternosBk;
	}

	@Override
	public List<DtEntidadesUsuexternosBk> getAllDtEntidadesUsuexternosActivos(Long kyUsuarioMod) {
		List<DtEntidadesUsuexternosBk> dtEntidadesUsuexternosBkss = new ArrayList<DtEntidadesUsuexternosBk>();
		try {
			List<DtEntidadesUsuexternos> dtEntidadesUsuexternoss = dtEntidadesUsuexternosDao
					.getActivasDtEntidadesUsuexternos();
			for (DtEntidadesUsuexternos dtEntidadesUsuexternos : dtEntidadesUsuexternoss) {
				DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk = new DtEntidadesUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternosBk, dtEntidadesUsuexternos);
				completarDtEntidadesUsuexternos(dtEntidadesUsuexternosBk);
				setACLDtEntidadesUsuexternosBk(dtEntidadesUsuexternosBk, kyUsuarioMod);
				dtEntidadesUsuexternosBkss.add(dtEntidadesUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesUsuexternosBkss;
	}

	@Override
	public List<DtEntidadesUsuexternosBk> getAllDtEntidadesUsuexternosActivosCero(Long kyUsuarioMod) {
		List<DtEntidadesUsuexternosBk> dtEntidadesUsuexternosBkss = new ArrayList<DtEntidadesUsuexternosBk>();
		try {
			List<DtEntidadesUsuexternos> dtEntidadesUsuexternoss = dtEntidadesUsuexternosDao
					.getActivasDtEntidadesUsuexternosCero();
			for (DtEntidadesUsuexternos dtEntidadesUsuexternos : dtEntidadesUsuexternoss) {
				DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk = new DtEntidadesUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternosBk, dtEntidadesUsuexternos);
				completarDtEntidadesUsuexternos(dtEntidadesUsuexternosBk);
				setACLDtEntidadesUsuexternosBk(dtEntidadesUsuexternosBk, kyUsuarioMod);
				dtEntidadesUsuexternosBkss.add(dtEntidadesUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesUsuexternosBkss;
	}

	private void completarDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk) {
		try {
			if (dtEntidadesUsuexternosBk.getIdEntidad() != null
					&& dtEntidadesUsuexternosBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtEntidadesUsuexternosBk.getIdEntidad());
				if (dtEntidades != null)
					dtEntidadesUsuexternosBk.setIdEntidadTxt(dtEntidades.getRazSocial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadesUsuexternosBk.getIdUsuexterno() != null
					&& dtEntidadesUsuexternosBk.getIdUsuexterno().longValue() > 0) {
				DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
						.getDtUsuarioExterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
				if (dtUsuarioExterno != null) {
					dtEntidadesUsuexternosBk.setIdUsuexternoTxt(dtUsuarioExterno.getNombre());
					dtEntidadesUsuexternosBk.setNombre(dtUsuarioExterno.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtEntidadesUsuexternosBk.getEstado()!=null &&
		// dtEntidadesUsuexternosBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEntidadesUsuexternosBk.getEstado());
		// if(prtParametros!=null)
		// dtEntidadesUsuexternosBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	// JPUYEN 14052024 - INICIO
	@Override
	public DtVisitasUsuexternosBk saveorupdateDtEntidadesUsuexternosBk(DtVisitasUsuexternosBk dtVisitasUsuexternosBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtEntidadesUsuexternosMng.validarDtVisitasUsuexternoBk(dtVisitasUsuexternosBk);

		DtEntidadesUsuexternos dtEntidadesUsuexternos = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasUsuexternosBk.getIdUsuexterno() != null
					&& dtVisitasUsuexternosBk.getIdUsuexterno().longValue() > 0) {

				dtEntidadesUsuexternos = dtEntidadesUsuexternosDao
						.getDtEntidadesUsuexternos(dtVisitasUsuexternosBk.getIdUsuexterno());

				boolean cambios = AuditoriaDtEntidadesUsuexternosMng.auditarCambiosDtVisitasUsuexternos(
						dtVisitasUsuexternosBk, dtEntidadesUsuexternos, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtEntidadesUsuexternos.setRtmaddressrst(rmtaddress);
					dtEntidadesUsuexternos.setIdusserModif(kyUsuarioMod);
					dtEntidadesUsuexternos.setFechaModif(hoy);
					dtEntidadesUsuexternosDao.updateDtEntidadesUsuexternos(dtEntidadesUsuexternos);
				}
			} else {

				if (dtVisitasUsuexternosBk.getEstado() == Estado.ACTIVO.getValor()) {
					dtVisitasUsuexternosBk.setRtmaddress(rmtaddress);
					dtVisitasUsuexternosBk.setRtmaddressrst(rmtaddress);

					dtVisitasUsuexternosBk.setFechaCrea(hoy);
					dtVisitasUsuexternosBk.setIdusserCrea(kyUsuarioMod);
					dtVisitasUsuexternosBk.setIdusserModif(kyUsuarioMod);
					dtVisitasUsuexternosBk.setFechaModif(hoy);
					dtVisitasUsuexternosBk.setEstado(Estado.ACTIVO.getValor());

					dtEntidadesUsuexternos = new DtEntidadesUsuexternos();

					FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternos, dtVisitasUsuexternosBk);
					dtEntidadesUsuexternosDao.saveDtEntidadesUsuexternos(dtEntidadesUsuexternos);

					log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
							+ "CREADO dtEntidadesUsuexternos" + " :: "
							+ dtEntidadesUsuexternos.getIdUsuextEnti().toString() + " :: " + "0" + " :: " + "1");

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtVisitasUsuexternosBk = getDtVisitasUsuexternoBkXid(dtEntidadesUsuexternos.getIdUsuextEnti(), kyUsuarioMod);
		return dtVisitasUsuexternosBk;
	}

	// JPUYEN 14052024 - FIN

	@Override
	public void deleteDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtEntidadesUsuexternos dtEntidadesUsuexternos = null;
			if (dtEntidadesUsuexternosBk.getIdUsuextEnti() != null
					&& dtEntidadesUsuexternosBk.getIdUsuextEnti().longValue() > 0) {

				dtEntidadesUsuexternos = dtEntidadesUsuexternosDao
						.getDtEntidadesUsuexternos(dtEntidadesUsuexternosBk.getIdUsuextEnti());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidadesUsuexternos.setRtmaddressrst(rmtaddress);
				dtEntidadesUsuexternos.setIdusserModif(kyUsuarioMod);
				dtEntidadesUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtEntidadesUsuexternos.getEstado();
				dtEntidadesUsuexternos.setEstado(Estado.ELIMINADO.getValor());

				dtEntidadesUsuexternosDao.updateDtEntidadesUsuexternos(dtEntidadesUsuexternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtEntidadesUsuexternos" + " :: "
						+ dtEntidadesUsuexternos.getIdUsuextEnti().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtEntidadesUsuexternos dtEntidadesUsuexternos = null;
			if (dtEntidadesUsuexternosBk.getIdUsuextEnti() != null
					&& dtEntidadesUsuexternosBk.getIdUsuextEnti().longValue() > 0) {

				dtEntidadesUsuexternos = dtEntidadesUsuexternosDao
						.getDtEntidadesUsuexternos(dtEntidadesUsuexternosBk.getIdUsuextEnti());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidadesUsuexternos.setRtmaddressrst(rmtaddress);
				dtEntidadesUsuexternos.setIdusserModif(kyUsuarioMod);
				dtEntidadesUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtEntidadesUsuexternos.getEstado();
				dtEntidadesUsuexternos.setEstado(Estado.ACTIVO.getValor());

				dtEntidadesUsuexternosDao.updateDtEntidadesUsuexternos(dtEntidadesUsuexternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtEntidadesUsuexternos" + " :: "
						+ dtEntidadesUsuexternos.getIdUsuextEnti().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtEntidadesUsuexternosBk> getDtEntidadesUsuexternosXFiltro(Long idEntidad, Long idUsuexterno,
			Long kyUsuarioMod) {
		List<DtEntidadesUsuexternosBk> dtEntidadesUsuexternosBkss = new ArrayList<DtEntidadesUsuexternosBk>();
		try {
			List<DtEntidadesUsuexternos> dtEntidadesUsuexternossss = dtEntidadesUsuexternosDao.getXFiltro(idEntidad,
					idUsuexterno);
			for (DtEntidadesUsuexternos dtEntidadesUsuexternos : dtEntidadesUsuexternossss) {
				DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk = new DtEntidadesUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternosBk, dtEntidadesUsuexternos);
				completarDtEntidadesUsuexternos(dtEntidadesUsuexternosBk);
				setACLDtEntidadesUsuexternosBk(dtEntidadesUsuexternosBk, kyUsuarioMod);
				dtEntidadesUsuexternosBkss.add(dtEntidadesUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesUsuexternosBkss;
	}

	@Override
	public List<DtEntidadesUsuexternosBk> getDtEntidadesUsuexternosXFiltro(Long idEntidad, Long idUsuexterno,
			int inicial, int MAX, Long kyUsuarioMod) {
		List<DtEntidadesUsuexternosBk> dtEntidadesUsuexternosBkss = new ArrayList<DtEntidadesUsuexternosBk>();
		try {
			List<DtEntidadesUsuexternos> dtEntidadesUsuexternossss = dtEntidadesUsuexternosDao.getXFiltro(idEntidad,
					idUsuexterno, inicial, MAX);
			for (DtEntidadesUsuexternos dtEntidadesUsuexternos : dtEntidadesUsuexternossss) {
				DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk = new DtEntidadesUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesUsuexternosBk, dtEntidadesUsuexternos);
				completarDtEntidadesUsuexternos(dtEntidadesUsuexternosBk);
				setACLDtEntidadesUsuexternosBk(dtEntidadesUsuexternosBk, kyUsuarioMod);
				dtEntidadesUsuexternosBkss.add(dtEntidadesUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesUsuexternosBkss;
	}

	@Override
	public Long getDtEntidadesUsuexternosTotalXFiltro(Long idEntidad, Long idUsuexterno, Long kyUsuarioMod) {
		try {
			Long totalDtEntidadesUsuexternossss = dtEntidadesUsuexternosDao.getTotalXFiltro(idEntidad, idUsuexterno);

			return totalDtEntidadesUsuexternossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtEntidadesUsuexternosBk(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, Long kyUsuarioMod) {
		DtEntidadesUsuexternosACL dtEntidadesUsuexternosACL = new DtEntidadesUsuexternosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADESUSUEXTERNOS_CREA)) {
					dtEntidadesUsuexternosACL.setEsEditable(true);
					dtEntidadesUsuexternosACL.setEliminar(true);
				} else if (roles.contains(Roles.DTENTIDADESUSUEXTERNOS_VE)) {
					dtEntidadesUsuexternosACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADESUSUEXTERNOS_CREA)) {
					dtEntidadesUsuexternosACL.setEditopcion(1);
				} else {
					dtEntidadesUsuexternosACL.setEditopcion(2);
				}
			} else {
				dtEntidadesUsuexternosACL.setEditopcion(2);
			}
		} else {
			dtEntidadesUsuexternosACL.setEditopcion(2);
		}
		dtEntidadesUsuexternosBk.setDtEntidadesUsuexternosACL(dtEntidadesUsuexternosACL);
	}

	/// ADICIONALES

	/**
	 * PRT_PARAMETROS SERVICIO: LISTA LOS PARAMETROS REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public PrtParametrosBk getPrtParametrosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		PrtParametros prtParametros = prtParametrosDao.getPrtParametros(id);
		PrtParametrosBk prtParametrosBk = null;
		if (prtParametros != null) {
			prtParametrosBk = new PrtParametrosBk();
			FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametros);
			completarPrtParametros(prtParametrosBk);
			if (kyUsuarioMod != null)
				setACLPrtParametrosBk(prtParametrosBk, kyUsuarioMod);
		}
		return prtParametrosBk;
	}

	@Override
	public List<PrtParametrosBk> getAllPrtParametrosActivos(Long kyUsuarioMod) {
		List<PrtParametrosBk> prtParametrosBkss = new ArrayList<PrtParametrosBk>();
		try {
			List<PrtParametros> prtParametross = prtParametrosDao.getActivasPrtParametros();
			for (PrtParametros prtParametros : prtParametross) {
				PrtParametrosBk prtParametrosBk = new PrtParametrosBk();
				FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametros);
				completarPrtParametros(prtParametrosBk);
				setACLPrtParametrosBk(prtParametrosBk, kyUsuarioMod);
				prtParametrosBkss.add(prtParametrosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prtParametrosBkss;
	}

	@Override
	public List<PrtParametrosBk> getAllPrtParametrosActivosCero(Long kyUsuarioMod) {
		List<PrtParametrosBk> prtParametrosBkss = new ArrayList<PrtParametrosBk>();
		try {
			List<PrtParametros> prtParametross = prtParametrosDao.getActivasPrtParametrosCero();
			for (PrtParametros prtParametros : prtParametross) {
				PrtParametrosBk prtParametrosBk = new PrtParametrosBk();
				FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametros);
				completarPrtParametros(prtParametrosBk);
				setACLPrtParametrosBk(prtParametrosBk, kyUsuarioMod);
				prtParametrosBkss.add(prtParametrosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prtParametrosBkss;
	}

	private void completarPrtParametros(PrtParametrosBk prtParametrosBk) {
		try {
			if (prtParametrosBk.getIdpadre() != null && prtParametrosBk.getIdpadre().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(prtParametrosBk.getIdpadre());
				if (prtParametros != null)
					prtParametrosBk.setIdpadreTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(prtParametrosBk.getEstado()!=null &&
		// prtParametrosBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(prtParametrosBk.getEstado().longValue());
		// if(prtParametros!=null)
		// prtParametrosBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public PrtParametrosBk saveorupdatePrtParametrosBk(PrtParametrosBk prtParametrosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionPrtParametrosMng.validarPrtParametrosBk(prtParametrosBk);

		PrtParametros prtParametros = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (prtParametrosBk.getIdparametro() != null && prtParametrosBk.getIdparametro().longValue() > 0) {

				prtParametros = prtParametrosDao.getPrtParametros(prtParametrosBk.getIdparametro());

				boolean cambios = AuditoriaPrtParametrosMng.auditarCambiosPrtParametros(prtParametrosBk, prtParametros,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					prtParametros.setRtmaddressmodif(rmtaddress);
					prtParametros.setIduserModif(kyUsuarioMod);
					prtParametros.setFechaModif(hoy);
					prtParametrosDao.updatePrtParametros(prtParametros);
				}
			} else {
				prtParametrosBk.setRtmaddress(rmtaddress);
				prtParametrosBk.setRtmaddressmodif(rmtaddress);

				prtParametrosBk.setFechaCrea(hoy);
				prtParametrosBk.setIduserCrea(kyUsuarioMod);
				prtParametrosBk.setIduserModif(kyUsuarioMod);
				prtParametrosBk.setFechaModif(hoy);
				prtParametrosBk.setEstado((int) Estado.ACTIVO.getValor());

				prtParametros = new PrtParametros();

				FuncionesStaticas.copyPropertiesObject(prtParametros, prtParametrosBk);
				prtParametrosDao.savePrtParametros(prtParametros);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO prtParametros" + " :: " + prtParametros.getIdparametro().toString() + " :: "
								+ "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		prtParametrosBk = getPrtParametrosBkXid(prtParametros.getIdparametro(), kyUsuarioMod);
		return prtParametrosBk;
	}

	@Override
	public void deletePrtParametros(PrtParametrosBk prtParametrosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			PrtParametros prtParametros = null;
			if (prtParametrosBk.getIdparametro() != null && prtParametrosBk.getIdparametro().longValue() > 0) {

				prtParametros = prtParametrosDao.getPrtParametros(prtParametrosBk.getIdparametro());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				prtParametros.setRtmaddressmodif(rmtaddress);
				prtParametros.setIduserModif(kyUsuarioMod);
				prtParametros.setFechaModif(hoy);
				Integer estadoanterior = prtParametros.getEstado();
				prtParametros.setEstado((int) Estado.ELIMINADO.getValor());

				prtParametrosDao.updatePrtParametros(prtParametros);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO prtParametros" + " :: " + prtParametros.getIdparametro().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarPrtParametros(PrtParametrosBk prtParametrosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			PrtParametros prtParametros = null;
			if (prtParametrosBk.getIdparametro() != null && prtParametrosBk.getIdparametro().longValue() > 0) {

				prtParametros = prtParametrosDao.getPrtParametros(prtParametrosBk.getIdparametro());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				prtParametros.setRtmaddressmodif(rmtaddress);
				prtParametros.setIduserModif(kyUsuarioMod);
				prtParametros.setFechaModif(hoy);
				Integer estadoanterior = prtParametros.getEstado();
				prtParametros.setEstado((int) Estado.ACTIVO.getValor());

				prtParametrosDao.updatePrtParametros(prtParametros);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO prtParametros" + " :: " + prtParametros.getIdparametro().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<PrtParametrosBk> getPrtParametrosXFiltro(String descripcion, Long idpadre, Timestamp fechaCrea,
			Timestamp fechaModif, Integer estado, Long kyUsuarioMod) {
		List<PrtParametrosBk> prtParametrosBkss = new ArrayList<PrtParametrosBk>();
		try {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getXFiltro(idpadre, descripcion);
			for (PrtParametros prtParametros : prtParametrossss) {
				PrtParametrosBk prtParametrosBk = new PrtParametrosBk();
				FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametros);
				completarPrtParametros(prtParametrosBk);
				setACLPrtParametrosBk(prtParametrosBk, kyUsuarioMod);
				prtParametrosBkss.add(prtParametrosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prtParametrosBkss;
	}

	@Override
	public List<PrtParametrosBk> getPrtParametrosXFiltro(String descripcion, Long idpadre, Timestamp fechaCrea,
			Timestamp fechaModif, Integer estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<PrtParametrosBk> prtParametrosBkss = new ArrayList<PrtParametrosBk>();
		try {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getXFiltro(idpadre, descripcion, inicial, MAX);
			for (PrtParametros prtParametros : prtParametrossss) {
				PrtParametrosBk prtParametrosBk = new PrtParametrosBk();
				FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametros);
				completarPrtParametros(prtParametrosBk);
				setACLPrtParametrosBk(prtParametrosBk, kyUsuarioMod);
				prtParametrosBkss.add(prtParametrosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prtParametrosBkss;
	}

	@Override
	public Long getPrtParametrosTotalXFiltro(String descripcion, Long idpadre, Timestamp fechaCrea,
			Timestamp fechaModif, Integer estado, Long kyUsuarioMod) {
		try {
			Long totalPrtParametrossss = prtParametrosDao.getTotalXFiltro(idpadre, descripcion);

			return totalPrtParametrossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLPrtParametrosBk(PrtParametrosBk prtParametrosBk, Long kyUsuarioMod) {
		PrtParametrosACL prtParametrosACL = new PrtParametrosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PRTPARAMETROS_CREA)) {
					prtParametrosACL.setEsEditable(true);
					prtParametrosACL.setEliminar(true);
				} else if (roles.contains(Roles.PRTPARAMETROS_VE)) {
					prtParametrosACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PRTPARAMETROS_CREA)) {
					prtParametrosACL.setEditopcion(1);
				} else {
					prtParametrosACL.setEditopcion(2);
				}
			} else {
				prtParametrosACL.setEditopcion(2);
			}
		} else {
			prtParametrosACL.setEditopcion(2);
		}
		prtParametrosBk.setPrtParametrosACL(prtParametrosACL);
	}

	/// ADICIONALES

	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdpadre() {
		if (prtParametrosIdparametroIdpadreListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdpadreListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdpadreListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdpadreListaCache;
	}

	/**
	 * DT_ASISTENCIA_TEMAS SERVICIO: LISTA DE LOS DISTINTOS TEMAS AGENDADOS EN
	 * LA ASISTENCIA TECNICA
	 */
	@Override
	public DtAsistenciaTemasBk getDtAsistenciaTemasBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtAsistenciaTemas dtAsistenciaTemas = dtAsistenciaTemasDao.getDtAsistenciaTemas(id);
		DtAsistenciaTemasBk dtAsistenciaTemasBk = null;
		if (dtAsistenciaTemas != null) {
			dtAsistenciaTemasBk = new DtAsistenciaTemasBk();
			FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasBk, dtAsistenciaTemas);
			completarDtAsistenciaTemas(dtAsistenciaTemasBk);
			if (kyUsuarioMod != null)
				setACLDtAsistenciaTemasBk(dtAsistenciaTemasBk, kyUsuarioMod);
		}
		return dtAsistenciaTemasBk;
	}

	@Override
	public List<DtAsistenciaTemasBk> getAllDtAsistenciaTemasActivos(Long kyUsuarioMod) {
		List<DtAsistenciaTemasBk> dtAsistenciaTemasBkss = new ArrayList<DtAsistenciaTemasBk>();
		try {
			List<DtAsistenciaTemas> dtAsistenciaTemass = dtAsistenciaTemasDao.getActivasDtAsistenciaTemas();
			for (DtAsistenciaTemas dtAsistenciaTemas : dtAsistenciaTemass) {
				DtAsistenciaTemasBk dtAsistenciaTemasBk = new DtAsistenciaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasBk, dtAsistenciaTemas);
				completarDtAsistenciaTemas(dtAsistenciaTemasBk);
				setACLDtAsistenciaTemasBk(dtAsistenciaTemasBk, kyUsuarioMod);
				dtAsistenciaTemasBkss.add(dtAsistenciaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaTemasBkss;
	}

	@Override
	public List<DtAsistenciaTemasBk> getAllDtAsistenciaTemasActivosCero(Long kyUsuarioMod) {
		List<DtAsistenciaTemasBk> dtAsistenciaTemasBkss = new ArrayList<DtAsistenciaTemasBk>();
		try {
			List<DtAsistenciaTemas> dtAsistenciaTemass = dtAsistenciaTemasDao.getActivasDtAsistenciaTemasCero();
			for (DtAsistenciaTemas dtAsistenciaTemas : dtAsistenciaTemass) {
				DtAsistenciaTemasBk dtAsistenciaTemasBk = new DtAsistenciaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasBk, dtAsistenciaTemas);
				completarDtAsistenciaTemas(dtAsistenciaTemasBk);
				setACLDtAsistenciaTemasBk(dtAsistenciaTemasBk, kyUsuarioMod);
				dtAsistenciaTemasBkss.add(dtAsistenciaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaTemasBkss;
	}

	private void completarDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk) {
		try {
			if (dtAsistenciaTemasBk.getIdAsistencia() != null
					&& dtAsistenciaTemasBk.getIdAsistencia().longValue() > 0) {
				DtAsistencia dtAsistencia = dtAsistenciaDao.getDtAsistencia(dtAsistenciaTemasBk.getIdAsistencia());
				if (dtAsistencia != null)
					dtAsistenciaTemasBk.setIdAsistenciaTxt(dtAsistencia.getDetalle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaTemasBk.getIdTema() != null && dtAsistenciaTemasBk.getIdTema().longValue() > 0) {
				MsTema msTema = msTemaDao.getMsTema(dtAsistenciaTemasBk.getIdTema());
				if (msTema != null)
					dtAsistenciaTemasBk.setIdTemaTxt(msTema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaTemasBk.getIdSubtema() != null && dtAsistenciaTemasBk.getIdSubtema().longValue() > 0) {
				MsSubtema msSubtema = msSubtemaDao.getMsSubtema(dtAsistenciaTemasBk.getIdSubtema());
				if (msSubtema != null)
					dtAsistenciaTemasBk.setIdSubtemaTxt(msSubtema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtAsistenciaTemasBk.getEstado()!=null &&
		// dtAsistenciaTemasBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtAsistenciaTemasBk.getEstado());
		// if(prtParametros!=null)
		// dtAsistenciaTemasBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtAsistenciaTemasBk saveorupdateDtAsistenciaTemasBk(DtAsistenciaTemasBk dtAsistenciaTemasBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtAsistenciaTemasMng.validarDtAsistenciaTemasBk(dtAsistenciaTemasBk);

		DtAsistenciaTemas dtAsistenciaTemas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtAsistenciaTemasBk.getIdAsistTema() != null && dtAsistenciaTemasBk.getIdAsistTema().longValue() > 0) {

				dtAsistenciaTemas = dtAsistenciaTemasDao.getDtAsistenciaTemas(dtAsistenciaTemasBk.getIdAsistTema());

				boolean cambios = AuditoriaDtAsistenciaTemasMng.auditarCambiosDtAsistenciaTemas(dtAsistenciaTemasBk,
						dtAsistenciaTemas, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtAsistenciaTemas.setRtmaddressrst(rmtaddress);
					dtAsistenciaTemas.setIdusserModif(kyUsuarioMod);
					dtAsistenciaTemas.setFechaModif(hoy);
					dtAsistenciaTemasDao.updateDtAsistenciaTemas(dtAsistenciaTemas);
				}
			} else {
				dtAsistenciaTemasBk.setRtmaddress(rmtaddress);
				dtAsistenciaTemasBk.setRtmaddressrst(rmtaddress);

				dtAsistenciaTemasBk.setFechaCrea(hoy);
				dtAsistenciaTemasBk.setIdusserCrea(kyUsuarioMod);
				dtAsistenciaTemasBk.setIdusserModif(kyUsuarioMod);
				dtAsistenciaTemasBk.setFechaModif(hoy);
				dtAsistenciaTemasBk.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaTemas = new DtAsistenciaTemas();

				FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemas, dtAsistenciaTemasBk);
				dtAsistenciaTemasDao.saveDtAsistenciaTemas(dtAsistenciaTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtAsistenciaTemas" + " :: " + dtAsistenciaTemas.getIdAsistTema().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtAsistenciaTemasBk = getDtAsistenciaTemasBkXid(dtAsistenciaTemas.getIdAsistTema(), kyUsuarioMod);
		return dtAsistenciaTemasBk;
	}

	@Override
	public void deleteDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaTemas dtAsistenciaTemas = null;
			if (dtAsistenciaTemasBk.getIdAsistTema() != null && dtAsistenciaTemasBk.getIdAsistTema().longValue() > 0) {

				dtAsistenciaTemas = dtAsistenciaTemasDao.getDtAsistenciaTemas(dtAsistenciaTemasBk.getIdAsistTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaTemas.setRtmaddressrst(rmtaddress);
				dtAsistenciaTemas.setIdusserModif(kyUsuarioMod);
				dtAsistenciaTemas.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaTemas.getEstado();
				dtAsistenciaTemas.setEstado(Estado.ELIMINADO.getValor());

				dtAsistenciaTemasDao.updateDtAsistenciaTemas(dtAsistenciaTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaTemas" + " :: " + dtAsistenciaTemas.getIdAsistTema().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaTemas dtAsistenciaTemas = null;
			if (dtAsistenciaTemasBk.getIdAsistTema() != null && dtAsistenciaTemasBk.getIdAsistTema().longValue() > 0) {

				dtAsistenciaTemas = dtAsistenciaTemasDao.getDtAsistenciaTemas(dtAsistenciaTemasBk.getIdAsistTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaTemas.setRtmaddressrst(rmtaddress);
				dtAsistenciaTemas.setIdusserModif(kyUsuarioMod);
				dtAsistenciaTemas.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaTemas.getEstado();
				dtAsistenciaTemas.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaTemasDao.updateDtAsistenciaTemas(dtAsistenciaTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaTemas" + " :: " + dtAsistenciaTemas.getIdAsistTema().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtAsistenciaTemasBk> getDtAsistenciaTemasXFiltro(String detalle, Long idAsistencia, Long idTema,
			Long idSubtema, Long kyUsuarioMod) {
		List<DtAsistenciaTemasBk> dtAsistenciaTemasBkss = new ArrayList<DtAsistenciaTemasBk>();
		try {
			List<DtAsistenciaTemas> dtAsistenciaTemassss = dtAsistenciaTemasDao.getXFiltro(detalle, idAsistencia,
					idTema, idSubtema);
			for (DtAsistenciaTemas dtAsistenciaTemas : dtAsistenciaTemassss) {
				DtAsistenciaTemasBk dtAsistenciaTemasBk = new DtAsistenciaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasBk, dtAsistenciaTemas);
				completarDtAsistenciaTemas(dtAsistenciaTemasBk);
				setACLDtAsistenciaTemasBk(dtAsistenciaTemasBk, kyUsuarioMod);
				dtAsistenciaTemasBkss.add(dtAsistenciaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaTemasBkss;
	}

	@Override
	public List<DtAsistenciaTemasBk> getDtAsistenciaTemasXFiltro(String detalle, Long idAsistencia, Long idTema,
			Long idSubtema, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtAsistenciaTemasBk> dtAsistenciaTemasBkss = new ArrayList<DtAsistenciaTemasBk>();
		try {
			List<DtAsistenciaTemas> dtAsistenciaTemassss = dtAsistenciaTemasDao.getXFiltro(detalle, idAsistencia,
					idTema, idSubtema, inicial, MAX);
			for (DtAsistenciaTemas dtAsistenciaTemas : dtAsistenciaTemassss) {
				DtAsistenciaTemasBk dtAsistenciaTemasBk = new DtAsistenciaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasBk, dtAsistenciaTemas);
				completarDtAsistenciaTemas(dtAsistenciaTemasBk);
				setACLDtAsistenciaTemasBk(dtAsistenciaTemasBk, kyUsuarioMod);
				dtAsistenciaTemasBkss.add(dtAsistenciaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaTemasBkss;
	}

	@Override
	public Long getDtAsistenciaTemasTotalXFiltro(String detalle, Long idAsistencia, Long idTema, Long idSubtema,
			Long kyUsuarioMod) {
		try {
			Long totalDtAsistenciaTemassss = dtAsistenciaTemasDao.getTotalXFiltro(detalle, idAsistencia, idTema,
					idSubtema);

			return totalDtAsistenciaTemassss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtAsistenciaTemasBk(DtAsistenciaTemasBk dtAsistenciaTemasBk, Long kyUsuarioMod) {
		DtAsistenciaTemasACL dtAsistenciaTemasACL = new DtAsistenciaTemasACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIATEMAS_CREA)) {
					dtAsistenciaTemasACL.setEsEditable(true);
					dtAsistenciaTemasACL.setEliminar(true);
				} else if (roles.contains(Roles.DTASISTENCIATEMAS_VE)) {
					dtAsistenciaTemasACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIATEMAS_CREA)) {
					dtAsistenciaTemasACL.setEditopcion(1);
				} else {
					dtAsistenciaTemasACL.setEditopcion(2);
				}
			} else {
				dtAsistenciaTemasACL.setEditopcion(2);
			}
		} else {
			dtAsistenciaTemasACL.setEditopcion(2);
		}
		dtAsistenciaTemasBk.setDtAsistenciaTemasACL(dtAsistenciaTemasACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL msSubtemaDao
	 * 
	 **/
	@Override
	public List<IDValorDto> getMsSubtemaIdSubtemaIdSubtema() {
		if (msSubtemaIdSubtemaIdSubtemaListaCache == null) {
			List<MsSubtema> msSubtemasss = msSubtemaDao.getListaIdSubtema();
			msSubtemaIdSubtemaIdSubtemaListaCache = new ArrayList<IDValorDto>();
			for (MsSubtema msSubtema : msSubtemasss) {
				IDValorDto idSubtemaDto = new IDValorDto(msSubtema.getIdSubtema(), msSubtema.getDescripcion());
				msSubtemaIdSubtemaIdSubtemaListaCache.add(idSubtemaDto);
			}
		}
		return msSubtemaIdSubtemaIdSubtemaListaCache;
	}

	/**
	 * DT_USUARIO_EXTERNO SERVICIO: LISTA DE LOS USUARIOS EXTERNOS REGISTRADOS
	 * EN EL SISTEMA
	 */
	@Override
	public DtUsuarioExternoBk getDtUsuarioExternoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(id);
		DtUsuarioExternoBk dtUsuarioExternoBk = null;
		if (dtUsuarioExterno != null) {
			dtUsuarioExternoBk = new DtUsuarioExternoBk();
			FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
			// completarDtUsuarioExterno(dtUsuarioExternoBk);
			completarDtUsuarioExterno(dtUsuarioExternoBk, kyUsuarioMod); // PURIBE
																			// 14032024
																			// -
																			// INICIO-->);
			if (kyUsuarioMod != null)
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
		}
		return dtUsuarioExternoBk;
	}

	@Override
	public List<DtUsuarioExternoBk> getAllDtUsuarioExternoActivos(Long kyUsuarioMod) {
		List<DtUsuarioExternoBk> dtUsuarioExternoBkss = new ArrayList<DtUsuarioExternoBk>();
		try {
			List<DtUsuarioExterno> dtUsuarioExternos = dtUsuarioExternoDao.getActivasDtUsuarioExterno();
			for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternos) {
				DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
				// completarDtUsuarioExterno(dtUsuarioExternoBk);
				completarDtUsuarioExterno(dtUsuarioExternoBk, kyUsuarioMod); // PURIBE
																				// 14032024
																				// -
																				// INICIO-->);
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
				dtUsuarioExternoBkss.add(dtUsuarioExternoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuarioExternoBkss;
	}

	@Override
	public List<DtUsuarioExternoBk> getAllDtUsuarioExternoActivosCero(Long kyUsuarioMod) {
		List<DtUsuarioExternoBk> dtUsuarioExternoBkss = new ArrayList<DtUsuarioExternoBk>();
		try {
			List<DtUsuarioExterno> dtUsuarioExternos = dtUsuarioExternoDao.getActivasDtUsuarioExternoCero();
			for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternos) {
				DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
				// completarDtUsuarioExterno(dtUsuarioExternoBk);
				completarDtUsuarioExterno(dtUsuarioExternoBk, kyUsuarioMod); // PURIBE
																				// 14032024
																				// -
																				// INICIO-->
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
				dtUsuarioExternoBkss.add(dtUsuarioExternoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuarioExternoBkss;
	}

	private void completarDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk) {
		// try{
		// if(dtUsuarioExternoBk.getEstado()!=null &&
		// dtUsuarioExternoBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtUsuarioExternoBk.getEstado());
		// if(prtParametros!=null)
		// dtUsuarioExternoBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtUsuarioExternoBk.getIdTipodocumento() != null
					&& dtUsuarioExternoBk.getIdTipodocumento().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao
						.getPrtParametros(dtUsuarioExternoBk.getIdTipodocumento());
				if (prtParametros != null)
					dtUsuarioExternoBk.setIdTipodocumentoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getCodDpto() != null && dtUsuarioExternoBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = dtUsuarioExternoBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtUsuarioExternoBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getCodDpto() != null && dtUsuarioExternoBk.getCodDpto().intValue() > 0
					&& dtUsuarioExternoBk.getCodProv() != null && dtUsuarioExternoBk.getCodProv().intValue() > 0) {
				int iiCodDpto = dtUsuarioExternoBk.getCodDpto().intValue();
				int iiCodProv = dtUsuarioExternoBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtUsuarioExternoBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getCodDpto() != null && dtUsuarioExternoBk.getCodDpto().intValue() > 0
					&& dtUsuarioExternoBk.getCodProv() != null && dtUsuarioExternoBk.getCodProv().intValue() > 0
					&& dtUsuarioExternoBk.getCodDistr() != null && dtUsuarioExternoBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = dtUsuarioExternoBk.getCodDpto().intValue();
				int iiCodProv = dtUsuarioExternoBk.getCodProv().intValue();
				int iiCodDistr = dtUsuarioExternoBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtUsuarioExternoBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getIdpais() != null && dtUsuarioExternoBk.getIdpais().longValue() > 0) {
				MsPaises msPaises = msPaisesDao.getMsPaises(dtUsuarioExternoBk.getIdpais());
				if (msPaises != null)
					dtUsuarioExternoBk.setIdpaisTxt(msPaises.getPaisNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// JPUYEN 14052024 - INICIO

		try {
			if (dtUsuarioExternoBk.getIdUsuexterno() != null && dtUsuarioExternoBk.getIdUsuexterno().longValue() > 0) {
				List<DtEntidadesUsuexternos> dtEntidadesUsuexternosList = dtEntidadesUsuexternosDao.getXFiltro(null,
						dtUsuarioExternoBk.getIdUsuexterno());
				if (dtEntidadesUsuexternosList != null && dtEntidadesUsuexternosList.size() > 0) {
					DtEntidadesUsuexternos dtEntidadesUsuexternosCopy = dtEntidadesUsuexternosList.get(0);
					if (dtEntidadesUsuexternosCopy.getIdUsuextEnti() != null
							&& dtEntidadesUsuexternosCopy.getIdUsuextEnti().longValue() > 0) {

						List<DtCargosUsuexter> dtCargosUsuexterList = dtCargosUsuexterDao
								.getXFiltro(dtEntidadesUsuexternosCopy.getIdUsuextEnti(), null);
						if (dtCargosUsuexterList != null && dtCargosUsuexterList.size() > 0) {
							List<DtCargosUsuexterBk> listaCargos = new ArrayList<DtCargosUsuexterBk>();
							for (DtCargosUsuexter dtCargosUsuexteraa : dtCargosUsuexterList) {
								if (dtCargosUsuexteraa.getIdCargo() != null
										&& dtCargosUsuexteraa.getIdCargo().longValue() > 0) {
									PrtParametros prtParametros = prtParametrosDao
											.getPrtParametros(dtCargosUsuexteraa.getIdCargo());
									if (prtParametros != null) {
										DtCargosUsuexterBk cargo = new DtCargosUsuexterBk();
										cargo.setIdCargoTxt(prtParametros.getDescripcion());
										listaCargos.add(cargo);
									}
								}
							}
							dtUsuarioExternoBk.setUsucargos(listaCargos);
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// JPUYEN 14052024 - FIN

	}

	@Override
	public DtUsuarioExternoBk saveorupdateDtUsuarioExternoBk(DtUsuarioExternoBk dtUsuarioExternoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtUsuarioExternoMng.validarDtUsuarioExternoBk(dtUsuarioExternoBk);

		DtUsuarioExterno dtUsuarioExterno = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtUsuarioExternoBk.getIdUsuexterno() != null && dtUsuarioExternoBk.getIdUsuexterno().longValue() > 0) {

				dtUsuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(dtUsuarioExternoBk.getIdUsuexterno());

				boolean cambios = AuditoriaDtUsuarioExternoMng.auditarCambiosDtUsuarioExterno(dtUsuarioExternoBk,
						dtUsuarioExterno, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtUsuarioExterno.setRtmaddressrst(rmtaddress);
					dtUsuarioExterno.setIdusserModif(kyUsuarioMod);
					dtUsuarioExterno.setFechaModif(hoy);
					dtUsuarioExternoDao.updateDtUsuarioExterno(dtUsuarioExterno);
				}
			} else {
				dtUsuarioExternoBk.setRtmaddress(rmtaddress);
				dtUsuarioExternoBk.setRtmaddressrst(rmtaddress);

				dtUsuarioExternoBk.setFechaCrea(hoy);
				dtUsuarioExternoBk.setIdusserCrea(kyUsuarioMod);
				dtUsuarioExternoBk.setIdusserModif(kyUsuarioMod);
				dtUsuarioExternoBk.setFechaModif(hoy);
				dtUsuarioExternoBk.setEstado(Estado.ACTIVO.getValor());

				dtUsuarioExterno = new DtUsuarioExterno();

				FuncionesStaticas.copyPropertiesObject(dtUsuarioExterno, dtUsuarioExternoBk);
				dtUsuarioExternoDao.saveDtUsuarioExterno(dtUsuarioExterno);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtUsuarioExterno" + " :: " + dtUsuarioExterno.getIdUsuexterno().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtUsuarioExternoBk = getDtUsuarioExternoBkXid(dtUsuarioExterno.getIdUsuexterno(), kyUsuarioMod);
		return dtUsuarioExternoBk;
	}

	@Override
	public void deleteDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtUsuarioExterno dtUsuarioExterno = null;
			if (dtUsuarioExternoBk.getIdUsuexterno() != null && dtUsuarioExternoBk.getIdUsuexterno().longValue() > 0) {

				dtUsuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(dtUsuarioExternoBk.getIdUsuexterno());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtUsuarioExterno.setRtmaddressrst(rmtaddress);
				dtUsuarioExterno.setIdusserModif(kyUsuarioMod);
				dtUsuarioExterno.setFechaModif(hoy);
				Long estadoanterior = dtUsuarioExterno.getEstado();
				dtUsuarioExterno.setEstado(Estado.ELIMINADO.getValor());

				dtUsuarioExternoDao.updateDtUsuarioExterno(dtUsuarioExterno);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtUsuarioExterno" + " :: " + dtUsuarioExterno.getIdUsuexterno().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtUsuarioExterno dtUsuarioExterno = null;
			if (dtUsuarioExternoBk.getIdUsuexterno() != null && dtUsuarioExternoBk.getIdUsuexterno().longValue() > 0) {

				dtUsuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(dtUsuarioExternoBk.getIdUsuexterno());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtUsuarioExterno.setRtmaddressrst(rmtaddress);
				dtUsuarioExterno.setIdusserModif(kyUsuarioMod);
				dtUsuarioExterno.setFechaModif(hoy);
				Long estadoanterior = dtUsuarioExterno.getEstado();
				dtUsuarioExterno.setEstado(Estado.ACTIVO.getValor());

				dtUsuarioExternoDao.updateDtUsuarioExterno(dtUsuarioExterno);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtUsuarioExterno" + " :: " + dtUsuarioExterno.getIdUsuexterno().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro(String aPaterno, String aMaterno, String nombre,
			Long numDocu, String correo, Long telefFijo, Long telefCell, Timestamp fechaModif, Long estado,
			Long kyUsuarioMod) {
		List<DtUsuarioExternoBk> dtUsuarioExternoBkss = new ArrayList<DtUsuarioExternoBk>();
		try {
			List<DtUsuarioExterno> dtUsuarioExternosss = dtUsuarioExternoDao.getXFiltro(aPaterno, aMaterno, nombre,
					numDocu, correo, telefFijo, telefCell, fechaModif, estado);
			for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternosss) {
				DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
				// completarDtUsuarioExterno(dtUsuarioExternoBk);
				completarDtUsuarioExterno(dtUsuarioExternoBk, kyUsuarioMod); // PURIBE
																				// 14032024
																				// -
																				// INICIO-->
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
				dtUsuarioExternoBkss.add(dtUsuarioExternoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuarioExternoBkss;
	}

	@Override
	public List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro(String aPaterno, String aMaterno, String nombre,
			Long numDocu, String correo, Long telefFijo, Long telefCell, Timestamp fechaModif, Long estado, int inicial,
			int MAX, Long kyUsuarioMod) {
		List<DtUsuarioExternoBk> dtUsuarioExternoBkss = new ArrayList<DtUsuarioExternoBk>();
		try {
			List<DtUsuarioExterno> dtUsuarioExternosss = dtUsuarioExternoDao.getXFiltro(aPaterno, aMaterno, nombre,
					numDocu, correo, telefFijo, telefCell, fechaModif, estado, inicial, MAX);
			for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternosss) {
				DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
				completarDtUsuarioExterno(dtUsuarioExternoBk);
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
				dtUsuarioExternoBkss.add(dtUsuarioExternoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuarioExternoBkss;
	}

	@Override
	public Long getDtUsuarioExternoTotalXFiltro(String aPaterno, String aMaterno, String nombre, Long numDocu,
			String correo, Long telefFijo, Long telefCell, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalDtUsuarioExternosss = dtUsuarioExternoDao.getTotalXFiltro(aPaterno, aMaterno, nombre, numDocu,
					correo, telefFijo, telefCell, fechaModif, estado);

			return totalDtUsuarioExternosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtUsuarioExternoBk(DtUsuarioExternoBk dtUsuarioExternoBk, Long kyUsuarioMod) {
		DtUsuarioExternoACL dtUsuarioExternoACL = new DtUsuarioExternoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTUSUARIOEXTERNO_CREA)) {
					dtUsuarioExternoACL.setEsEditable(true);
					dtUsuarioExternoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTUSUARIOEXTERNO_VE)) {
					dtUsuarioExternoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTUSUARIOEXTERNO_CREA)) {
					dtUsuarioExternoACL.setEditopcion(1);
				} else {
					dtUsuarioExternoACL.setEditopcion(2);
				}
			} else {
				dtUsuarioExternoACL.setEditopcion(2);
			}
		} else {
			dtUsuarioExternoACL.setEditopcion(2);
		}
		dtUsuarioExternoBk.setDtUsuarioExternoACL(dtUsuarioExternoACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdTipodocumento() {
		if (prtParametrosIdparametroIdTipodocumentoListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdTipodocumentoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdTipodocumentoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdTipodocumentoListaCache;
	}

	/**
	 * MS_UBIGEO SERVICIO: LISTA EL UBIGEO (DEPARTAMENTO
	 */
	@Override
	public MsUbigeoBk getMsUbigeoBkXid(MsUbigeoId id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(id);
		MsUbigeoBk msUbigeoBk = null;
		if (msUbigeo != null) {
			msUbigeoBk = new MsUbigeoBk();
			FuncionesStaticas.copyPropertiesObject(msUbigeoBk, msUbigeo);
			completarMsUbigeo(msUbigeoBk);
			if (kyUsuarioMod != null)
				setACLMsUbigeoBk(msUbigeoBk, kyUsuarioMod);
		}
		return msUbigeoBk;
	}

	@Override
	public List<MsUbigeoBk> getAllMsUbigeoActivos(Long kyUsuarioMod) {
		List<MsUbigeoBk> msUbigeoBkss = new ArrayList<MsUbigeoBk>();
		try {
			List<MsUbigeo> msUbigeos = msUbigeoDao.getActivasMsUbigeo();
			for (MsUbigeo msUbigeo : msUbigeos) {
				MsUbigeoBk msUbigeoBk = new MsUbigeoBk();
				FuncionesStaticas.copyPropertiesObject(msUbigeoBk, msUbigeo);
				completarMsUbigeo(msUbigeoBk);
				setACLMsUbigeoBk(msUbigeoBk, kyUsuarioMod);
				msUbigeoBkss.add(msUbigeoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUbigeoBkss;
	}

	@Override
	public List<MsUbigeoBk> getAllMsUbigeoActivosCero(Long kyUsuarioMod) {
		List<MsUbigeoBk> msUbigeoBkss = new ArrayList<MsUbigeoBk>();
		try {
			List<MsUbigeo> msUbigeos = msUbigeoDao.getActivasMsUbigeoCero();
			for (MsUbigeo msUbigeo : msUbigeos) {
				MsUbigeoBk msUbigeoBk = new MsUbigeoBk();
				FuncionesStaticas.copyPropertiesObject(msUbigeoBk, msUbigeo);
				completarMsUbigeo(msUbigeoBk);
				setACLMsUbigeoBk(msUbigeoBk, kyUsuarioMod);
				msUbigeoBkss.add(msUbigeoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUbigeoBkss;
	}

	// PURIBE 10012024 - INICIO
	private void completarMsUbigeo(MsUbigeoBk msUbigeoBk) {

		try {
			if (msUbigeoBk.getId().getCodDpto() != null && msUbigeoBk.getId().getCodDpto().intValue() > 0) {
				int iiCoddpto = msUbigeoBk.getId().getCodDpto().intValue();
				int iiCodprov = 0;
				int iiCoddist = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCoddpto);
				msUbigeoId.setCodProv(iiCodprov);
				msUbigeoId.setCodDistr(iiCoddist);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msUbigeoBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUbigeoBk.getId().getCodDpto() != null && msUbigeoBk.getId().getCodDpto().intValue() > 0
					&& msUbigeoBk.getId().getCodProv() != null && msUbigeoBk.getId().getCodProv().intValue() > 0) {
				int iiCoddpto = msUbigeoBk.getId().getCodDpto().intValue();
				int iiCodprov = msUbigeoBk.getId().getCodProv().intValue();
				int iiCoddist = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCoddpto);
				msUbigeoId.setCodProv(iiCodprov);
				msUbigeoId.setCodDistr(iiCoddist);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msUbigeoBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUbigeoBk.getId().getCodDpto() != null && msUbigeoBk.getId().getCodDpto().intValue() > 0
					&& msUbigeoBk.getId().getCodProv() != null && msUbigeoBk.getId().getCodProv().intValue() > 0
					&& msUbigeoBk.getId().getCodDistr() != null && msUbigeoBk.getId().getCodDistr().intValue() > 0) {
				int iiCoddpto = msUbigeoBk.getId().getCodDpto().intValue();
				int iiCodprov = msUbigeoBk.getId().getCodProv().intValue();
				int iiCoddist = msUbigeoBk.getId().getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCoddpto);
				msUbigeoId.setCodProv(iiCodprov);
				msUbigeoId.setCodDistr(iiCoddist);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msUbigeoBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// PURIBE 10012024 - FIN
	}
	// PURIBE 10012024 - INICIO

	@Override
	public MsUbigeoBk saveorupdateMsUbigeoBk(MsUbigeoBk msUbigeoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsUbigeoMng.validarMsUbigeoBk(msUbigeoBk);
		MsUbigeo msUbigeo = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;
		int CodDept = 0;
		int CodProv = 0;
		int CodDistr = 0;

		try {

			if (msUbigeoBk.getId().getCodDpto() == 0) {
				CodDept = msUbigeoDao.getMaxIdVAlCodDept();
				msUbigeoBk.getId().setCodDpto(CodDept);
			} else if (msUbigeoBk.getId().getCodProv() == 0) {
				CodProv = msUbigeoDao.getMaxIdVAlCodProv(msUbigeoBk.getId().getCodDpto());
				msUbigeoBk.getId().setCodProv(CodProv);
			} else if (msUbigeoBk.getId().getCodDistr() == 0) {
				CodDistr = msUbigeoDao.getMaxIdVAlCodDistr(msUbigeoBk.getId().getCodDpto(),
						msUbigeoBk.getId().getCodProv());
				msUbigeoBk.getId().setCodDistr(CodDistr);
			}

			// Valida el codigo departamento si lo tiene se edita
			if (msUbigeoBk.getId() != null && msUbigeoBk.getId().getCodDpto() != null
					&& msUbigeoBk.getCodDpto().intValue() > 0) {

				msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoBk.getId());

				boolean cambios = AuditoriaMsUbigeoMng.auditarCambiosMsUbigeo(msUbigeoBk, msUbigeo, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msUbigeo.setRtmaddressrst(rmtaddress);
					msUbigeo.setIdusserModif(kyUsuarioMod);
					msUbigeo.setFechaModif(hoy);
					msUbigeoDao.updateMsUbigeo(msUbigeo);
				}
			} else {

				msUbigeoBk.setRtmaddress(rmtaddress);
				msUbigeoBk.setRtmaddressrst(rmtaddress);

				msUbigeoBk.setFechaCrea(hoy);
				msUbigeoBk.setIdusserCrea(kyUsuarioMod);
				msUbigeoBk.setIdusserModif(kyUsuarioMod);
				msUbigeoBk.setFechaModif(hoy);
				msUbigeoBk.setEstado(1L);

				msUbigeo = new MsUbigeo();

				FuncionesStaticas.copyPropertiesObject(msUbigeo, msUbigeoBk);
				msUbigeoDao.saveMsUbigeo(msUbigeo);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msUbigeo" + " :: " + msUbigeo.getId().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		// PURIBE 15012024 - FIN
		// PURIBE 10012024 - FIN
		msUbigeoBk = getMsUbigeoBkXid(msUbigeo.getId(), kyUsuarioMod);
		return msUbigeoBk;
	}

	@Override
	public void deleteMsUbigeo(MsUbigeoBk msUbigeoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsUbigeo msUbigeo = null;
			if (msUbigeoBk.getId() != null && msUbigeoBk.getId().getCodDpto().longValue() > 0) {

				msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoBk.getId());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msUbigeo.setRtmaddressrst(rmtaddress);
				msUbigeo.setIdusserModif(kyUsuarioMod);
				msUbigeo.setFechaModif(hoy);
				Long estadoanterior = msUbigeo.getEstado();
				msUbigeo.setEstado(Estado.ELIMINADO.getValor());

				msUbigeoDao.updateMsUbigeo(msUbigeo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msUbigeo" + " :: " + msUbigeo.getId().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsUbigeo(MsUbigeoBk msUbigeoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsUbigeo msUbigeo = null;
			if (msUbigeoBk.getId() != null && msUbigeoBk.getId().getCodDpto().longValue() > 0) {

				msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoBk.getId());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msUbigeo.setRtmaddressrst(rmtaddress);
				msUbigeo.setIdusserModif(kyUsuarioMod);
				msUbigeo.setFechaModif(hoy);
				Long estadoanterior = msUbigeo.getEstado();
				msUbigeo.setEstado(Estado.ACTIVO.getValor());

				msUbigeoDao.updateMsUbigeo(msUbigeo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msUbigeo" + " :: " + msUbigeo.getId().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsUbigeoBk> getMsUbigeoXFiltro(Integer codDpto, Integer codProv, Integer codDistr, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsUbigeoBk> msUbigeoBkss = new ArrayList<MsUbigeoBk>();
		try {
			List<MsUbigeo> msUbigeosss = msUbigeoDao.getXFiltro(codDpto, codProv, codDistr, fechaCrea, fechaModif,
					estado);
			for (MsUbigeo msUbigeo : msUbigeosss) {
				MsUbigeoBk msUbigeoBk = new MsUbigeoBk();
				FuncionesStaticas.copyPropertiesObject(msUbigeoBk, msUbigeo);
				completarMsUbigeo(msUbigeoBk);
				setACLMsUbigeoBk(msUbigeoBk, kyUsuarioMod);
				msUbigeoBkss.add(msUbigeoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUbigeoBkss;
	}

	@Override
	public List<MsUbigeoBk> getMsUbigeoXFiltro(Integer codDpto, Integer codProv, Integer codDistr, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsUbigeoBk> msUbigeoBkss = new ArrayList<MsUbigeoBk>();
		try {
			List<MsUbigeo> msUbigeosss = msUbigeoDao.getXFiltro(codDpto, codProv, codDistr, fechaCrea, fechaModif,
					estado, inicial, MAX);
			for (MsUbigeo msUbigeo : msUbigeosss) {
				MsUbigeoBk msUbigeoBk = new MsUbigeoBk();
				FuncionesStaticas.copyPropertiesObject(msUbigeoBk, msUbigeo);
				completarMsUbigeo(msUbigeoBk);
				setACLMsUbigeoBk(msUbigeoBk, kyUsuarioMod);
				msUbigeoBkss.add(msUbigeoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUbigeoBkss;
	}

	@Override
	public Long getMsUbigeoTotalXFiltro(Integer codDpto, Integer codProv, Integer codDistr, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsUbigeosss = msUbigeoDao.getTotalXFiltro(codDpto, codProv, codDistr, fechaCrea, fechaModif,
					estado);

			return totalMsUbigeosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsUbigeoBk(MsUbigeoBk msUbigeoBk, Long kyUsuarioMod) {
		MsUbigeoACL msUbigeoACL = new MsUbigeoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUBIGEO_CREA)) {
					msUbigeoACL.setEsEditable(true);
					msUbigeoACL.setEliminar(true);
				} else if (roles.contains(Roles.MSUBIGEO_VE)) {
					msUbigeoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUBIGEO_CREA)) {
					msUbigeoACL.setEditopcion(1);
				} else {
					msUbigeoACL.setEditopcion(2);
				}
			} else {
				msUbigeoACL.setEditopcion(2);
			}
		} else {
			msUbigeoACL.setEditopcion(2);
		}
		msUbigeoBk.setMsUbigeoACL(msUbigeoACL);
	}

	/// ADICIONALES

	/**
	 * MS_SIS_ADMISTRATIVO SERVICIO: LISTA DE LOS SISTEMAS ADMINISTRATIVOS
	 * REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public MsSisAdmistrativoBk getMsSisAdmistrativoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao.getMsSisAdmistrativo(id);
		MsSisAdmistrativoBk msSisAdmistrativoBk = null;
		if (msSisAdmistrativo != null) {
			msSisAdmistrativoBk = new MsSisAdmistrativoBk();
			FuncionesStaticas.copyPropertiesObject(msSisAdmistrativoBk, msSisAdmistrativo);
			completarMsSisAdmistrativo(msSisAdmistrativoBk);
			if (kyUsuarioMod != null)
				setACLMsSisAdmistrativoBk(msSisAdmistrativoBk, kyUsuarioMod);
		}
		return msSisAdmistrativoBk;
	}

	@Override
	public List<MsSisAdmistrativoBk> getAllMsSisAdmistrativoActivos(Long kyUsuarioMod) {
		List<MsSisAdmistrativoBk> msSisAdmistrativoBkss = new ArrayList<MsSisAdmistrativoBk>();
		try {
			List<MsSisAdmistrativo> msSisAdmistrativos = msSisAdmistrativoDao.getActivasMsSisAdmistrativo();
			for (MsSisAdmistrativo msSisAdmistrativo : msSisAdmistrativos) {
				MsSisAdmistrativoBk msSisAdmistrativoBk = new MsSisAdmistrativoBk();
				FuncionesStaticas.copyPropertiesObject(msSisAdmistrativoBk, msSisAdmistrativo);
				completarMsSisAdmistrativo(msSisAdmistrativoBk);
				setACLMsSisAdmistrativoBk(msSisAdmistrativoBk, kyUsuarioMod);
				msSisAdmistrativoBkss.add(msSisAdmistrativoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSisAdmistrativoBkss;
	}

	@Override
	public List<MsSisAdmistrativoBk> getAllMsSisAdmistrativoActivosCero(Long kyUsuarioMod) {
		List<MsSisAdmistrativoBk> msSisAdmistrativoBkss = new ArrayList<MsSisAdmistrativoBk>();
		try {
			List<MsSisAdmistrativo> msSisAdmistrativos = msSisAdmistrativoDao.getActivasMsSisAdmistrativoCero();
			for (MsSisAdmistrativo msSisAdmistrativo : msSisAdmistrativos) {
				MsSisAdmistrativoBk msSisAdmistrativoBk = new MsSisAdmistrativoBk();
				FuncionesStaticas.copyPropertiesObject(msSisAdmistrativoBk, msSisAdmistrativo);
				completarMsSisAdmistrativo(msSisAdmistrativoBk);
				setACLMsSisAdmistrativoBk(msSisAdmistrativoBk, kyUsuarioMod);
				msSisAdmistrativoBkss.add(msSisAdmistrativoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSisAdmistrativoBkss;
	}

	private void completarMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk) {
		// try{
		// if(msSisAdmistrativoBk.getEstado()!=null &&
		// msSisAdmistrativoBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msSisAdmistrativoBk.getEstado());
		// if(prtParametros!=null)
		// msSisAdmistrativoBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsSisAdmistrativoBk saveorupdateMsSisAdmistrativoBk(MsSisAdmistrativoBk msSisAdmistrativoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionMsSisAdmistrativoMng.validarMsSisAdmistrativoBk(msSisAdmistrativoBk);

		MsSisAdmistrativo msSisAdmistrativo = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msSisAdmistrativoBk.getIdSistAdmi() != null && msSisAdmistrativoBk.getIdSistAdmi().longValue() > 0) {

				msSisAdmistrativo = msSisAdmistrativoDao.getMsSisAdmistrativo(msSisAdmistrativoBk.getIdSistAdmi());

				boolean cambios = AuditoriaMsSisAdmistrativoMng.auditarCambiosMsSisAdmistrativo(msSisAdmistrativoBk,
						msSisAdmistrativo, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					msSisAdmistrativo.setRtmaddressrst(rmtaddress);
					msSisAdmistrativo.setIdusserModif(kyUsuarioMod);
					msSisAdmistrativo.setFechaModif(hoy);
					msSisAdmistrativoDao.updateMsSisAdmistrativo(msSisAdmistrativo);
				}
			} else {
				msSisAdmistrativoBk.setRtmaddress(rmtaddress);
				msSisAdmistrativoBk.setRtmaddressrst(rmtaddress);

				msSisAdmistrativoBk.setFechaCrea(hoy);
				msSisAdmistrativoBk.setIdusserCrea(kyUsuarioMod);
				msSisAdmistrativoBk.setIdusserModif(kyUsuarioMod);
				msSisAdmistrativoBk.setFechaModif(hoy);
				msSisAdmistrativoBk.setEstado(Estado.ACTIVO.getValor());

				msSisAdmistrativo = new MsSisAdmistrativo();

				FuncionesStaticas.copyPropertiesObject(msSisAdmistrativo, msSisAdmistrativoBk);
				msSisAdmistrativoDao.saveMsSisAdmistrativo(msSisAdmistrativo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO msSisAdmistrativo" + " :: " + msSisAdmistrativo.getIdSistAdmi().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msSisAdmistrativoBk = getMsSisAdmistrativoBkXid(msSisAdmistrativo.getIdSistAdmi(), kyUsuarioMod);
		return msSisAdmistrativoBk;
	}

	@Override
	public void deleteMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			MsSisAdmistrativo msSisAdmistrativo = null;
			if (msSisAdmistrativoBk.getIdSistAdmi() != null && msSisAdmistrativoBk.getIdSistAdmi().longValue() > 0) {

				msSisAdmistrativo = msSisAdmistrativoDao.getMsSisAdmistrativo(msSisAdmistrativoBk.getIdSistAdmi());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msSisAdmistrativo.setRtmaddressrst(rmtaddress);
				msSisAdmistrativo.setIdusserModif(kyUsuarioMod);
				msSisAdmistrativo.setFechaModif(hoy);
				Long estadoanterior = msSisAdmistrativo.getEstado();
				msSisAdmistrativo.setEstado(Estado.ELIMINADO.getValor());

				msSisAdmistrativoDao.updateMsSisAdmistrativo(msSisAdmistrativo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msSisAdmistrativo" + " :: " + msSisAdmistrativo.getIdSistAdmi().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			MsSisAdmistrativo msSisAdmistrativo = null;
			if (msSisAdmistrativoBk.getIdSistAdmi() != null && msSisAdmistrativoBk.getIdSistAdmi().longValue() > 0) {

				msSisAdmistrativo = msSisAdmistrativoDao.getMsSisAdmistrativo(msSisAdmistrativoBk.getIdSistAdmi());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msSisAdmistrativo.setRtmaddressrst(rmtaddress);
				msSisAdmistrativo.setIdusserModif(kyUsuarioMod);
				msSisAdmistrativo.setFechaModif(hoy);
				Long estadoanterior = msSisAdmistrativo.getEstado();
				msSisAdmistrativo.setEstado(Estado.ACTIVO.getValor());

				msSisAdmistrativoDao.updateMsSisAdmistrativo(msSisAdmistrativo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msSisAdmistrativo" + " :: " + msSisAdmistrativo.getIdSistAdmi().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsSisAdmistrativoBk> getMsSisAdmistrativoXFiltro(String descripcion, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsSisAdmistrativoBk> msSisAdmistrativoBkss = new ArrayList<MsSisAdmistrativoBk>();
		try {
			List<MsSisAdmistrativo> msSisAdmistrativosss = msSisAdmistrativoDao.getXFiltro(descripcion, fechaCrea,
					fechaModif, estado);
			for (MsSisAdmistrativo msSisAdmistrativo : msSisAdmistrativosss) {
				MsSisAdmistrativoBk msSisAdmistrativoBk = new MsSisAdmistrativoBk();
				FuncionesStaticas.copyPropertiesObject(msSisAdmistrativoBk, msSisAdmistrativo);
				completarMsSisAdmistrativo(msSisAdmistrativoBk);
				setACLMsSisAdmistrativoBk(msSisAdmistrativoBk, kyUsuarioMod);
				msSisAdmistrativoBkss.add(msSisAdmistrativoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSisAdmistrativoBkss;
	}

	@Override
	public List<MsSisAdmistrativoBk> getMsSisAdmistrativoXFiltro(String descripcion, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsSisAdmistrativoBk> msSisAdmistrativoBkss = new ArrayList<MsSisAdmistrativoBk>();
		try {
			List<MsSisAdmistrativo> msSisAdmistrativosss = msSisAdmistrativoDao.getXFiltro(descripcion, fechaCrea,
					fechaModif, estado, inicial, MAX);
			for (MsSisAdmistrativo msSisAdmistrativo : msSisAdmistrativosss) {
				MsSisAdmistrativoBk msSisAdmistrativoBk = new MsSisAdmistrativoBk();
				FuncionesStaticas.copyPropertiesObject(msSisAdmistrativoBk, msSisAdmistrativo);
				completarMsSisAdmistrativo(msSisAdmistrativoBk);
				setACLMsSisAdmistrativoBk(msSisAdmistrativoBk, kyUsuarioMod);
				msSisAdmistrativoBkss.add(msSisAdmistrativoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSisAdmistrativoBkss;
	}

	@Override
	public Long getMsSisAdmistrativoTotalXFiltro(String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsSisAdmistrativosss = msSisAdmistrativoDao.getTotalXFiltro(descripcion, fechaCrea, fechaModif,
					estado);

			return totalMsSisAdmistrativosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsSisAdmistrativoBk(MsSisAdmistrativoBk msSisAdmistrativoBk, Long kyUsuarioMod) {
		MsSisAdmistrativoACL msSisAdmistrativoACL = new MsSisAdmistrativoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSISADMISTRATIVO_CREA)) {
					msSisAdmistrativoACL.setEsEditable(true);
					msSisAdmistrativoACL.setEliminar(true);
				} else if (roles.contains(Roles.MSSISADMISTRATIVO_VE)) {
					msSisAdmistrativoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSISADMISTRATIVO_CREA)) {
					msSisAdmistrativoACL.setEditopcion(1);
				} else {
					msSisAdmistrativoACL.setEditopcion(2);
				}
			} else {
				msSisAdmistrativoACL.setEditopcion(2);
			}
		} else {
			msSisAdmistrativoACL.setEditopcion(2);
		}
		msSisAdmistrativoBk.setMsSisAdmistrativoACL(msSisAdmistrativoACL);
	}

	/// ADICIONALES

	/**
	 * MS_SUBTEMA SERVICIO: LISTA DE LOS SUBTEMAS REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public MsSubtemaBk getMsSubtemaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsSubtema msSubtema = msSubtemaDao.getMsSubtema(id);
		MsSubtemaBk msSubtemaBk = null;
		if (msSubtema != null) {
			msSubtemaBk = new MsSubtemaBk();
			FuncionesStaticas.copyPropertiesObject(msSubtemaBk, msSubtema);
			completarMsSubtema(msSubtemaBk);
			if (kyUsuarioMod != null)
				setACLMsSubtemaBk(msSubtemaBk, kyUsuarioMod);
		}
		return msSubtemaBk;
	}

	@Override
	public List<MsSubtemaBk> getAllMsSubtemaActivos(Long kyUsuarioMod) {
		List<MsSubtemaBk> msSubtemaBkss = new ArrayList<MsSubtemaBk>();
		try {
			List<MsSubtema> msSubtemas = msSubtemaDao.getActivasMsSubtema();
			for (MsSubtema msSubtema : msSubtemas) {
				MsSubtemaBk msSubtemaBk = new MsSubtemaBk();
				FuncionesStaticas.copyPropertiesObject(msSubtemaBk, msSubtema);
				completarMsSubtema(msSubtemaBk);
				setACLMsSubtemaBk(msSubtemaBk, kyUsuarioMod);
				msSubtemaBkss.add(msSubtemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSubtemaBkss;
	}

	@Override
	public List<MsSubtemaBk> getAllMsSubtemaActivosCero(Long kyUsuarioMod) {
		List<MsSubtemaBk> msSubtemaBkss = new ArrayList<MsSubtemaBk>();
		try {
			List<MsSubtema> msSubtemas = msSubtemaDao.getActivasMsSubtemaCero();
			for (MsSubtema msSubtema : msSubtemas) {
				MsSubtemaBk msSubtemaBk = new MsSubtemaBk();
				FuncionesStaticas.copyPropertiesObject(msSubtemaBk, msSubtema);
				completarMsSubtema(msSubtemaBk);
				setACLMsSubtemaBk(msSubtemaBk, kyUsuarioMod);
				msSubtemaBkss.add(msSubtemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSubtemaBkss;
	}

	private void completarMsSubtema(MsSubtemaBk msSubtemaBk) {
		try {
			if (msSubtemaBk.getIdTema() != null && msSubtemaBk.getIdTema().longValue() > 0) {
				MsTema msTema = msTemaDao.getMsTema(msSubtemaBk.getIdTema());
				if (msTema != null)
					msSubtemaBk.setIdTemaTxt(msTema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msSubtemaBk.getEstado()!=null &&
		// msSubtemaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msSubtemaBk.getEstado());
		// if(prtParametros!=null)
		// msSubtemaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (msSubtemaBk.getIdIndicador() != null && msSubtemaBk.getIdIndicador().longValue() > 0) {
				MsIndicador msIndicador = msIndicadorDao.getMsIndicador(msSubtemaBk.getIdIndicador());
				if (msIndicador != null)
					msSubtemaBk.setIdIndicadorTxt(msIndicador.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public MsSubtemaBk saveorupdateMsSubtemaBk(MsSubtemaBk msSubtemaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsSubtemaMng.validarMsSubtemaBk(msSubtemaBk);

		MsSubtema msSubtema = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msSubtemaBk.getIdSubtema() != null && msSubtemaBk.getIdSubtema().longValue() > 0) {

				msSubtema = msSubtemaDao.getMsSubtema(msSubtemaBk.getIdSubtema());

				boolean cambios = AuditoriaMsSubtemaMng.auditarCambiosMsSubtema(msSubtemaBk, msSubtema, kyUsuarioMod,
						user, rmtaddress, nivel);

				if (cambios) {
					msSubtema.setRtmaddressrst(rmtaddress);
					msSubtema.setIdusserModif(kyUsuarioMod);
					msSubtema.setFechaModif(hoy);
					msSubtemaDao.updateMsSubtema(msSubtema);
				}
			} else {
				msSubtemaBk.setRtmaddress(rmtaddress);
				msSubtemaBk.setRtmaddressrst(rmtaddress);

				msSubtemaBk.setFechaCrea(hoy);
				msSubtemaBk.setIdusserCrea(kyUsuarioMod);
				msSubtemaBk.setIdusserModif(kyUsuarioMod);
				msSubtemaBk.setFechaModif(hoy);
				msSubtemaBk.setEstado(Estado.ACTIVO.getValor());

				msSubtema = new MsSubtema();

				FuncionesStaticas.copyPropertiesObject(msSubtema, msSubtemaBk);
				msSubtemaDao.saveMsSubtema(msSubtema);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "CREADO msSubtema"
								+ " :: " + msSubtema.getIdSubtema().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msSubtemaBk = getMsSubtemaBkXid(msSubtema.getIdSubtema(), kyUsuarioMod);
		return msSubtemaBk;
	}

	@Override
	public void deleteMsSubtema(MsSubtemaBk msSubtemaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsSubtema msSubtema = null;
			if (msSubtemaBk.getIdSubtema() != null && msSubtemaBk.getIdSubtema().longValue() > 0) {

				msSubtema = msSubtemaDao.getMsSubtema(msSubtemaBk.getIdSubtema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msSubtema.setRtmaddressrst(rmtaddress);
				msSubtema.setIdusserModif(kyUsuarioMod);
				msSubtema.setFechaModif(hoy);
				Long estadoanterior = msSubtema.getEstado();
				msSubtema.setEstado(Estado.ELIMINADO.getValor());

				msSubtemaDao.updateMsSubtema(msSubtema);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msSubtema" + " :: " + msSubtema.getIdSubtema().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsSubtema(MsSubtemaBk msSubtemaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsSubtema msSubtema = null;
			if (msSubtemaBk.getIdSubtema() != null && msSubtemaBk.getIdSubtema().longValue() > 0) {

				msSubtema = msSubtemaDao.getMsSubtema(msSubtemaBk.getIdSubtema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msSubtema.setRtmaddressrst(rmtaddress);
				msSubtema.setIdusserModif(kyUsuarioMod);
				msSubtema.setFechaModif(hoy);
				Long estadoanterior = msSubtema.getEstado();
				msSubtema.setEstado(Estado.ACTIVO.getValor());

				msSubtemaDao.updateMsSubtema(msSubtema);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msSubtema" + " :: " + msSubtema.getIdSubtema().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsSubtemaBk> getMsSubtemaXFiltro(Long idTema, String descripcion, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsSubtemaBk> msSubtemaBkss = new ArrayList<MsSubtemaBk>();
		try {
			List<MsSubtema> msSubtemasss = msSubtemaDao.getXFiltro(idTema, descripcion, fechaCrea, fechaModif, estado);
			for (MsSubtema msSubtema : msSubtemasss) {
				MsSubtemaBk msSubtemaBk = new MsSubtemaBk();
				FuncionesStaticas.copyPropertiesObject(msSubtemaBk, msSubtema);
				completarMsSubtema(msSubtemaBk);
				setACLMsSubtemaBk(msSubtemaBk, kyUsuarioMod);
				msSubtemaBkss.add(msSubtemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSubtemaBkss;
	}

	@Override
	public List<MsSubtemaBk> getMsSubtemaXFiltro(Long idTema, String descripcion, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsSubtemaBk> msSubtemaBkss = new ArrayList<MsSubtemaBk>();
		try {
			List<MsSubtema> msSubtemasss = msSubtemaDao.getXFiltro(idTema, descripcion, fechaCrea, fechaModif, estado,
					inicial, MAX);
			for (MsSubtema msSubtema : msSubtemasss) {
				MsSubtemaBk msSubtemaBk = new MsSubtemaBk();
				FuncionesStaticas.copyPropertiesObject(msSubtemaBk, msSubtema);
				completarMsSubtema(msSubtemaBk);
				setACLMsSubtemaBk(msSubtemaBk, kyUsuarioMod);
				msSubtemaBkss.add(msSubtemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSubtemaBkss;
	}

	@Override
	public Long getMsSubtemaTotalXFiltro(Long idTema, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsSubtemasss = msSubtemaDao.getTotalXFiltro(idTema, descripcion, fechaCrea, fechaModif, estado);

			return totalMsSubtemasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsSubtemaBk(MsSubtemaBk msSubtemaBk, Long kyUsuarioMod) {
		MsSubtemaACL msSubtemaACL = new MsSubtemaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSUBTEMA_CREA)) {
					msSubtemaACL.setEsEditable(true);
					msSubtemaACL.setEliminar(true);
				} else if (roles.contains(Roles.MSSUBTEMA_VE)) {
					msSubtemaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSUBTEMA_CREA)) {
					msSubtemaACL.setEditopcion(1);
				} else {
					msSubtemaACL.setEditopcion(2);
				}
			} else {
				msSubtemaACL.setEditopcion(2);
			}
		} else {
			msSubtemaACL.setEditopcion(2);
		}
		msSubtemaBk.setMsSubtemaACL(msSubtemaACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL msIndicadorDao
	 * 
	 * @Override public List<MsIndicador> getListaIdIndicador() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           MsIndicador tablaa "); sb.append("WHERE tablaa.estado >= 1 ");
	 *           sb.append("ORDER BY tablaa.idIndicador asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getMsIndicadorIdIndicadorIdIndicador() {
		if (msIndicadorIdIndicadorIdIndicadorListaCache == null) {
			List<MsIndicador> msIndicadorsss = msIndicadorDao.getListaIdIndicador();
			msIndicadorIdIndicadorIdIndicadorListaCache = new ArrayList<IDValorDto>();
			for (MsIndicador msIndicador : msIndicadorsss) {
				IDValorDto idIndicadorDto = new IDValorDto(msIndicador.getIdIndicador(), msIndicador.getDescripcion());
				msIndicadorIdIndicadorIdIndicadorListaCache.add(idIndicadorDto);
			}
		}
		return msIndicadorIdIndicadorIdIndicadorListaCache;
	}

	/**
	 * DT_ASISTENCIA_USUEXTERNOS SERVICIO: LISTA DE LOS USUARIOS QUE BRINDAN LA
	 * ATENCION EN LA ASISTENCIA TECNICA
	 */
	@Override
	public DtAsistenciaUsuexternosBk getDtAsistenciaUsuexternosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtAsistenciaUsuexternos dtAsistenciaUsuexternos = dtAsistenciaUsuexternosDao.getDtAsistenciaUsuexternos(id);
		DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = null;
		if (dtAsistenciaUsuexternos != null) {
			dtAsistenciaUsuexternosBk = new DtAsistenciaUsuexternosBk();
			FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos);
			completarDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk);
			if (kyUsuarioMod != null)
				setACLDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk, kyUsuarioMod);
		}
		return dtAsistenciaUsuexternosBk;
	}

	@Override
	public List<DtAsistenciaUsuexternosBk> getAllDtAsistenciaUsuexternosActivos(Long kyUsuarioMod) {
		List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuexternosBkss = new ArrayList<DtAsistenciaUsuexternosBk>();
		try {
			List<DtAsistenciaUsuexternos> dtAsistenciaUsuexternoss = dtAsistenciaUsuexternosDao
					.getActivasDtAsistenciaUsuexternos();
			for (DtAsistenciaUsuexternos dtAsistenciaUsuexternos : dtAsistenciaUsuexternoss) {
				DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = new DtAsistenciaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos);
				completarDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk);
				setACLDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk, kyUsuarioMod);
				dtAsistenciaUsuexternosBkss.add(dtAsistenciaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaUsuexternosBkss;
	}

	@Override
	public List<DtAsistenciaUsuexternosBk> getAllDtAsistenciaUsuexternosActivosCero(Long kyUsuarioMod) {
		List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuexternosBkss = new ArrayList<DtAsistenciaUsuexternosBk>();
		try {
			List<DtAsistenciaUsuexternos> dtAsistenciaUsuexternoss = dtAsistenciaUsuexternosDao
					.getActivasDtAsistenciaUsuexternosCero();
			for (DtAsistenciaUsuexternos dtAsistenciaUsuexternos : dtAsistenciaUsuexternoss) {
				DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = new DtAsistenciaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos);
				completarDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk);
				setACLDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk, kyUsuarioMod);
				dtAsistenciaUsuexternosBkss.add(dtAsistenciaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaUsuexternosBkss;
	}

	private void completarDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk) {
		try {
			if (dtAsistenciaUsuexternosBk.getIdAsistencia() != null
					&& dtAsistenciaUsuexternosBk.getIdAsistencia().longValue() > 0) {
				DtAsistencia dtAsistencia = dtAsistenciaDao
						.getDtAsistencia(dtAsistenciaUsuexternosBk.getIdAsistencia());
				if (dtAsistencia != null)
					dtAsistenciaUsuexternosBk.setIdAsistenciaTxt(dtAsistencia.getDetalle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaUsuexternosBk.getIdUsuexterno() != null
					&& dtAsistenciaUsuexternosBk.getIdUsuexterno().longValue() > 0) {
				DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
						.getDtUsuarioExterno(dtAsistenciaUsuexternosBk.getIdUsuexterno());
				if (dtUsuarioExterno != null) {
					dtAsistenciaUsuexternosBk.setIdUsuexternoTxt(dtUsuarioExterno.getNombre());
					dtAsistenciaUsuexternosBk.setNombre(dtUsuarioExterno.getNombre());
					dtAsistenciaUsuexternosBk.setaPaterno(dtUsuarioExterno.getApaterno());// CUSCATA
																							// -
																							// 18062024
					dtAsistenciaUsuexternosBk.setaMaterno(dtUsuarioExterno.getAmaterno());// CUSCATA
																							// -
																							// 18062024
					dtAsistenciaUsuexternosBk.setNumDocu(dtUsuarioExterno.getNumDocu());// CUSCATA
																						// -
																						// 18062024
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtAsistenciaUsuexternosBk.getEstado()!=null &&
		// dtAsistenciaUsuexternosBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtAsistenciaUsuexternosBk.getEstado());
		// if(prtParametros!=null)
		// dtAsistenciaUsuexternosBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtAsistenciaUsuexternosBk.getIdCargoUsuext() != null
					&& dtAsistenciaUsuexternosBk.getIdCargoUsuext().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao
						.getPrtParametros(dtAsistenciaUsuexternosBk.getIdCargoUsuext());
				if (prtParametros != null)
					dtAsistenciaUsuexternosBk.setIdCargoUsuextTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void saveOrUpdateAsistenciaUsuarioExt(DtAsistenciaBk dtAsistenciaBk, DtAsistencia dtAsistencia,
			Timestamp hoy, Long kyUsuarioMod, String rmtaddress, String user) {

		DtAsistenciaUsuexternos dtAsistenciaUsuexternos = null;
		try {
			if (dtAsistenciaBk != null && dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss() != null
					&& !dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss().isEmpty()) {

				List<DtAsistenciaUsuexternos> listaAsistenciaUsuexternosBD = dtAsistenciaUsuexternosDao
						.getXFiltro(dtAsistencia.getIdAsistencia(), null, null);
				if (listaAsistenciaUsuexternosBD != null && !listaAsistenciaUsuexternosBD.isEmpty()) {
					for (DtAsistenciaUsuexternos dtAsistenciaUsuexternosBD : listaAsistenciaUsuexternosBD) {
						this.deleteDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBD, user, kyUsuarioMod, rmtaddress);
					}
				}

				for (DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk : dtAsistenciaBk
						.getDtAsistenciaUsuariosBkJSss()) {
					dtAsistenciaUsuexternosBk.setIdAsistUsuext(null);
					dtAsistenciaUsuexternosBk.setIdAsistencia(dtAsistencia.getIdAsistencia());
					dtAsistenciaUsuexternosBk.setRtmaddress(rmtaddress);
					dtAsistenciaUsuexternosBk.setRtmaddressrst(rmtaddress);
					dtAsistenciaUsuexternosBk.setFechaCrea(hoy);
					dtAsistenciaUsuexternosBk.setIdusserCrea(kyUsuarioMod);
					dtAsistenciaUsuexternosBk.setIdusserModif(kyUsuarioMod);
					dtAsistenciaUsuexternosBk.setFechaModif(hoy);
					dtAsistenciaUsuexternosBk.setEstado(Estado.ACTIVO.getValor());

					dtAsistenciaUsuexternos = new DtAsistenciaUsuexternos();

					FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternos, dtAsistenciaUsuexternosBk);
					dtAsistenciaUsuexternosDao.saveDtAsistenciaUsuexternos(dtAsistenciaUsuexternos);
				}
			}

		} catch (Exception e) {
			log.warning("Error: " + e.getMessage());

		}

	}

	private void deleteDtAsistenciaUsuexternos(DtAsistenciaUsuexternos dtAsistenciaUsuexternos, String user,
			Long kyUsuarioMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaUsuexternos dtAsistenciaUsuexternosBD = null;
			if (dtAsistenciaUsuexternos.getIdAsistUsuext() != null
					&& dtAsistenciaUsuexternos.getIdAsistUsuext().longValue() > 0) {

				dtAsistenciaUsuexternosBD = dtAsistenciaUsuexternosDao
						.getDtAsistenciaUsuexternos(dtAsistenciaUsuexternos.getIdAsistUsuext());

				// Date hoy = new Date(System.currentTimeMillis());
				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaUsuexternosBD.setIdusserModif(kyUsuarioMod);
				dtAsistenciaUsuexternosBD.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaUsuexternos.getEstado();
				dtAsistenciaUsuexternosBD.setEstado(Estado.ELIMINADO.getValor());

				dtAsistenciaUsuexternosDao.updateDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBD);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaUsuexternos" + " :: "
								+ dtAsistenciaUsuexternos.getIdAsistUsuext().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaUsuexternos dtAsistenciaUsuexternos = null;
			if (dtAsistenciaUsuexternosBk.getIdAsistUsuext() != null
					&& dtAsistenciaUsuexternosBk.getIdAsistUsuext().longValue() > 0) {

				dtAsistenciaUsuexternos = dtAsistenciaUsuexternosDao
						.getDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk.getIdAsistUsuext());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaUsuexternos.setRtmaddressrst(rmtaddress);
				dtAsistenciaUsuexternos.setIdusserModif(kyUsuarioMod);
				dtAsistenciaUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaUsuexternos.getEstado();
				dtAsistenciaUsuexternos.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaUsuexternosDao.updateDtAsistenciaUsuexternos(dtAsistenciaUsuexternos);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaUsuexternos" + " :: "
								+ dtAsistenciaUsuexternos.getIdAsistUsuext().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtAsistenciaUsuexternosBk> getDtAsistenciaUsuexternosXFiltro(Long idAsistencia, Long idUsuexterno,
			Long idCargoUsuext, Long kyUsuarioMod) {
		List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuexternosBkss = new ArrayList<DtAsistenciaUsuexternosBk>();
		try {
			List<DtAsistenciaUsuexternos> dtAsistenciaUsuexternossss = dtAsistenciaUsuexternosDao
					.getXFiltro(idAsistencia, idUsuexterno, idCargoUsuext);
			for (DtAsistenciaUsuexternos dtAsistenciaUsuexternos : dtAsistenciaUsuexternossss) {
				DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = new DtAsistenciaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos);
				completarDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk);
				setACLDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk, kyUsuarioMod);
				dtAsistenciaUsuexternosBkss.add(dtAsistenciaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaUsuexternosBkss;
	}

	@Override
	public List<DtAsistenciaUsuexternosBk> getDtAsistenciaUsuexternosXFiltro(Long idAsistencia, Long idUsuexterno,
			Long idCargoUsuext, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuexternosBkss = new ArrayList<DtAsistenciaUsuexternosBk>();
		try {
			List<DtAsistenciaUsuexternos> dtAsistenciaUsuexternossss = dtAsistenciaUsuexternosDao
					.getXFiltro(idAsistencia, idUsuexterno, idCargoUsuext, inicial, MAX);
			for (DtAsistenciaUsuexternos dtAsistenciaUsuexternos : dtAsistenciaUsuexternossss) {
				DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = new DtAsistenciaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos);
				completarDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk);
				setACLDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk, kyUsuarioMod);
				dtAsistenciaUsuexternosBkss.add(dtAsistenciaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaUsuexternosBkss;
	}

	@Override
	public Long getDtAsistenciaUsuexternosTotalXFiltro(Long idAsistencia, Long idUsuexterno, Long idCargoUsuext,
			Long kyUsuarioMod) {
		try {
			Long totalDtAsistenciaUsuexternossss = dtAsistenciaUsuexternosDao.getTotalXFiltro(idAsistencia,
					idUsuexterno, idCargoUsuext);

			return totalDtAsistenciaUsuexternossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtAsistenciaUsuexternosBk(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk,
			Long kyUsuarioMod) {
		DtAsistenciaUsuexternosACL dtAsistenciaUsuexternosACL = new DtAsistenciaUsuexternosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIAUSUEXTERNOS_CREA)) {
					dtAsistenciaUsuexternosACL.setEsEditable(true);
					dtAsistenciaUsuexternosACL.setEliminar(true);
				} else if (roles.contains(Roles.DTASISTENCIAUSUEXTERNOS_VE)) {
					dtAsistenciaUsuexternosACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIAUSUEXTERNOS_CREA)) {
					dtAsistenciaUsuexternosACL.setEditopcion(1);
				} else {
					dtAsistenciaUsuexternosACL.setEditopcion(2);
				}
			} else {
				dtAsistenciaUsuexternosACL.setEditopcion(2);
			}
		} else {
			dtAsistenciaUsuexternosACL.setEditopcion(2);
		}
		dtAsistenciaUsuexternosBk.setDtAsistenciaUsuexternosACL(dtAsistenciaUsuexternosACL);
	}

	/// ADICIONALES

	/**
	 * DT_CAPA_PROYECTO SERVICIO: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN
	 * RELACIONADOS A LAS CAPACITACIONES
	 */
	@Override
	public DtCapaProyectoBk getDtCapaProyectoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCapaProyecto dtCapaProyecto = dtCapaProyectoDao.getDtCapaProyecto(id);
		DtCapaProyectoBk dtCapaProyectoBk = null;
		if (dtCapaProyecto != null) {
			dtCapaProyectoBk = new DtCapaProyectoBk();
			FuncionesStaticas.copyPropertiesObject(dtCapaProyectoBk, dtCapaProyecto);
			completarDtCapaProyecto(dtCapaProyectoBk);
			if (kyUsuarioMod != null)
				setACLDtCapaProyectoBk(dtCapaProyectoBk, kyUsuarioMod);
		}
		return dtCapaProyectoBk;
	}

	@Override
	public List<DtCapaProyectoBk> getAllDtCapaProyectoActivos(Long kyUsuarioMod) {
		List<DtCapaProyectoBk> dtCapaProyectoBkss = new ArrayList<DtCapaProyectoBk>();
		try {
			List<DtCapaProyecto> dtCapaProyectos = dtCapaProyectoDao.getActivasDtCapaProyecto();
			for (DtCapaProyecto dtCapaProyecto : dtCapaProyectos) {
				DtCapaProyectoBk dtCapaProyectoBk = new DtCapaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaProyectoBk, dtCapaProyecto);
				completarDtCapaProyecto(dtCapaProyectoBk);
				setACLDtCapaProyectoBk(dtCapaProyectoBk, kyUsuarioMod);
				dtCapaProyectoBkss.add(dtCapaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaProyectoBkss;
	}

	@Override
	public List<DtCapaProyectoBk> getAllDtCapaProyectoActivosCero(Long kyUsuarioMod) {
		List<DtCapaProyectoBk> dtCapaProyectoBkss = new ArrayList<DtCapaProyectoBk>();
		try {
			List<DtCapaProyecto> dtCapaProyectos = dtCapaProyectoDao.getActivasDtCapaProyectoCero();
			for (DtCapaProyecto dtCapaProyecto : dtCapaProyectos) {
				DtCapaProyectoBk dtCapaProyectoBk = new DtCapaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaProyectoBk, dtCapaProyecto);
				completarDtCapaProyecto(dtCapaProyectoBk);
				setACLDtCapaProyectoBk(dtCapaProyectoBk, kyUsuarioMod);
				dtCapaProyectoBkss.add(dtCapaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaProyectoBkss;
	}

	private void completarDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk) {
		try {
			if (dtCapaProyectoBk.getIdProyecto() != null && dtCapaProyectoBk.getIdProyecto().longValue() > 0) {
				MsProyectoInversion msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(dtCapaProyectoBk.getIdProyecto());
				if (msProyectoInversion != null) {
					dtCapaProyectoBk.setIdProyectoTxt(msProyectoInversion.getNombre());
					dtCapaProyectoBk.setNombre(msProyectoInversion.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaProyectoBk.getIdCapacitacion() != null && dtCapaProyectoBk.getIdCapacitacion().longValue() > 0) {
				DtCapacitacion dtCapacitacion = dtCapacitacionDao
						.getDtCapacitacion(dtCapaProyectoBk.getIdCapacitacion());
				if (dtCapacitacion != null)
					dtCapaProyectoBk.setIdCapacitacionTxt(dtCapacitacion.getDetalleCapa());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtCapaProyectoBk saveorupdateDtCapaProyectoBk(DtCapaProyectoBk dtCapaProyectoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtCapaProyectoMng.validarDtCapaProyectoBk(dtCapaProyectoBk);

		DtCapaProyecto dtCapaProyecto = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapaProyectoBk.getIdCapaProyecto() != null && dtCapaProyectoBk.getIdCapaProyecto().longValue() > 0) {

				dtCapaProyecto = dtCapaProyectoDao.getDtCapaProyecto(dtCapaProyectoBk.getIdCapaProyecto());

				boolean cambios = AuditoriaDtCapaProyectoMng.auditarCambiosDtCapaProyecto(dtCapaProyectoBk,
						dtCapaProyecto, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapaProyecto.setRtmaddressrst(rmtaddress);
					dtCapaProyecto.setIdusserModif(kyUsuarioMod);
					dtCapaProyecto.setFechaModif(hoy);
					dtCapaProyectoDao.updateDtCapaProyecto(dtCapaProyecto);
				}
			} else {
				dtCapaProyectoBk.setRtmaddress(rmtaddress);
				dtCapaProyectoBk.setRtmaddressrst(rmtaddress);

				dtCapaProyectoBk.setFechaCrea(hoy);
				dtCapaProyectoBk.setIdusserCrea(kyUsuarioMod);
				dtCapaProyectoBk.setIdusserModif(kyUsuarioMod);
				dtCapaProyectoBk.setFechaModif(hoy);
				dtCapaProyectoBk.setEstado(Estado.ACTIVO.getValor());

				dtCapaProyecto = new DtCapaProyecto();

				FuncionesStaticas.copyPropertiesObject(dtCapaProyecto, dtCapaProyectoBk);
				dtCapaProyectoDao.saveDtCapaProyecto(dtCapaProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapaProyecto" + " :: " + dtCapaProyecto.getIdCapaProyecto().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtCapaProyectoBk = getDtCapaProyectoBkXid(dtCapaProyecto.getIdCapaProyecto(), kyUsuarioMod);
		return dtCapaProyectoBk;
	}

	@Override
	public void deleteDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapaProyecto dtCapaProyecto = null;
			if (dtCapaProyectoBk.getIdCapaProyecto() != null && dtCapaProyectoBk.getIdCapaProyecto().longValue() > 0) {

				dtCapaProyecto = dtCapaProyectoDao.getDtCapaProyecto(dtCapaProyectoBk.getIdCapaProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaProyecto.setRtmaddressrst(rmtaddress);
				dtCapaProyecto.setIdusserModif(kyUsuarioMod);
				dtCapaProyecto.setFechaModif(hoy);
				Long estadoanterior = dtCapaProyecto.getEstado();
				dtCapaProyecto.setEstado(Estado.ELIMINADO.getValor());

				dtCapaProyectoDao.updateDtCapaProyecto(dtCapaProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaProyecto" + " :: " + dtCapaProyecto.getIdCapaProyecto().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapaProyecto dtCapaProyecto = null;
			if (dtCapaProyectoBk.getIdCapaProyecto() != null && dtCapaProyectoBk.getIdCapaProyecto().longValue() > 0) {

				dtCapaProyecto = dtCapaProyectoDao.getDtCapaProyecto(dtCapaProyectoBk.getIdCapaProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaProyecto.setRtmaddressrst(rmtaddress);
				dtCapaProyecto.setIdusserModif(kyUsuarioMod);
				dtCapaProyecto.setFechaModif(hoy);
				Long estadoanterior = dtCapaProyecto.getEstado();
				dtCapaProyecto.setEstado(Estado.ACTIVO.getValor());

				dtCapaProyectoDao.updateDtCapaProyecto(dtCapaProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaProyecto" + " :: " + dtCapaProyecto.getIdCapaProyecto().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCapaProyectoBk> getDtCapaProyectoXFiltro(Long idProyecto, String detalle, Long kyUsuarioMod) {
		List<DtCapaProyectoBk> dtCapaProyectoBkss = new ArrayList<DtCapaProyectoBk>();
		try {
			List<DtCapaProyecto> dtCapaProyectosss = dtCapaProyectoDao.getXFiltro(idProyecto, detalle);
			for (DtCapaProyecto dtCapaProyecto : dtCapaProyectosss) {
				DtCapaProyectoBk dtCapaProyectoBk = new DtCapaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaProyectoBk, dtCapaProyecto);
				completarDtCapaProyecto(dtCapaProyectoBk);
				setACLDtCapaProyectoBk(dtCapaProyectoBk, kyUsuarioMod);
				dtCapaProyectoBkss.add(dtCapaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaProyectoBkss;
	}

	@Override
	public List<DtCapaProyectoBk> getDtCapaProyectoXFiltro(Long idProyecto, String detalle, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtCapaProyectoBk> dtCapaProyectoBkss = new ArrayList<DtCapaProyectoBk>();
		try {
			List<DtCapaProyecto> dtCapaProyectosss = dtCapaProyectoDao.getXFiltro(idProyecto, detalle, inicial, MAX);
			for (DtCapaProyecto dtCapaProyecto : dtCapaProyectosss) {
				DtCapaProyectoBk dtCapaProyectoBk = new DtCapaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaProyectoBk, dtCapaProyecto);
				completarDtCapaProyecto(dtCapaProyectoBk);
				setACLDtCapaProyectoBk(dtCapaProyectoBk, kyUsuarioMod);
				dtCapaProyectoBkss.add(dtCapaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaProyectoBkss;
	}

	@Override
	public Long getDtCapaProyectoTotalXFiltro(Long idProyecto, String detalle, Long kyUsuarioMod) {
		try {
			Long totalDtCapaProyectosss = dtCapaProyectoDao.getTotalXFiltro(idProyecto, detalle);

			return totalDtCapaProyectosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCapaProyectoBk(DtCapaProyectoBk dtCapaProyectoBk, Long kyUsuarioMod) {
		DtCapaProyectoACL dtCapaProyectoACL = new DtCapaProyectoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAPROYECTO_CREA)) {
					dtCapaProyectoACL.setEsEditable(true);
					dtCapaProyectoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCAPAPROYECTO_VE)) {
					dtCapaProyectoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAPROYECTO_CREA)) {
					dtCapaProyectoACL.setEditopcion(1);
				} else {
					dtCapaProyectoACL.setEditopcion(2);
				}
			} else {
				dtCapaProyectoACL.setEditopcion(2);
			}
		} else {
			dtCapaProyectoACL.setEditopcion(2);
		}
		dtCapaProyectoBk.setDtCapaProyectoACL(dtCapaProyectoACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL msProyectoInversionDao
	 * 
	 **/
	@Override
	public List<MsProyectoInversionBk> getMsProyectoInversionNombre(String nombre) {
		List<MsProyectoInversionBk> msProyectoInversionLista = new ArrayList<MsProyectoInversionBk>();
		if (nombre == null)
			return msProyectoInversionLista;
		if (nombre.length() < 3)
			return msProyectoInversionLista;
		List<MsProyectoInversion> msProyectoInversionsss = msProyectoInversionDao.getListaNombre(nombre);
		for (MsProyectoInversion msProyectoInversion : msProyectoInversionsss) {
			MsProyectoInversionBk msProyectoInversionBk = new MsProyectoInversionBk();
			FuncionesStaticas.copyPropertiesObject(msProyectoInversionBk, msProyectoInversion);
			msProyectoInversionLista.add(msProyectoInversionBk);
		}

		return msProyectoInversionLista;
	}

	/**
	 * MS_PROYECTO_INVERSION SERVICIO: LISTA DE LOS DATOS DE PROYECTOS DE
	 * INVERSIÓN
	 */
	@Override
	public MsProyectoInversionBk getMsProyectoInversionBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsProyectoInversion msProyectoInversion = msProyectoInversionDao.getMsProyectoInversion(id);
		MsProyectoInversionBk msProyectoInversionBk = null;
		if (msProyectoInversion != null) {
			msProyectoInversionBk = new MsProyectoInversionBk();
			FuncionesStaticas.copyPropertiesObject(msProyectoInversionBk, msProyectoInversion);
			completarMsProyectoInversion(msProyectoInversionBk);
			if (kyUsuarioMod != null)
				setACLMsProyectoInversionBk(msProyectoInversionBk, kyUsuarioMod);
		}
		return msProyectoInversionBk;
	}

	@Override
	public List<MsProyectoInversionBk> getAllMsProyectoInversionActivos(Long kyUsuarioMod) {
		List<MsProyectoInversionBk> msProyectoInversionBkss = new ArrayList<MsProyectoInversionBk>();
		try {
			List<MsProyectoInversion> msProyectoInversions = msProyectoInversionDao.getActivasMsProyectoInversion();
			for (MsProyectoInversion msProyectoInversion : msProyectoInversions) {
				MsProyectoInversionBk msProyectoInversionBk = new MsProyectoInversionBk();
				FuncionesStaticas.copyPropertiesObject(msProyectoInversionBk, msProyectoInversion);
				completarMsProyectoInversion(msProyectoInversionBk);
				setACLMsProyectoInversionBk(msProyectoInversionBk, kyUsuarioMod);
				msProyectoInversionBkss.add(msProyectoInversionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msProyectoInversionBkss;
	}

	@Override
	public List<MsProyectoInversionBk> getAllMsProyectoInversionActivosCero(Long kyUsuarioMod) {
		List<MsProyectoInversionBk> msProyectoInversionBkss = new ArrayList<MsProyectoInversionBk>();
		try {
			List<MsProyectoInversion> msProyectoInversions = msProyectoInversionDao.getActivasMsProyectoInversionCero();
			for (MsProyectoInversion msProyectoInversion : msProyectoInversions) {
				MsProyectoInversionBk msProyectoInversionBk = new MsProyectoInversionBk();
				FuncionesStaticas.copyPropertiesObject(msProyectoInversionBk, msProyectoInversion);
				completarMsProyectoInversion(msProyectoInversionBk);
				setACLMsProyectoInversionBk(msProyectoInversionBk, kyUsuarioMod);
				msProyectoInversionBkss.add(msProyectoInversionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msProyectoInversionBkss;
	}

	private void completarMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk) {
		try {
			if (msProyectoInversionBk.getIdSede() != null && msProyectoInversionBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(msProyectoInversionBk.getIdSede());
				if (msSedes != null)
					msProyectoInversionBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msProyectoInversionBk.getEstado()!=null &&
		// msProyectoInversionBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msProyectoInversionBk.getEstado());
		// if(prtParametros!=null)
		// msProyectoInversionBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsProyectoInversionBk saveorupdateMsProyectoInversionBk(MsProyectoInversionBk msProyectoInversionBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionMsProyectoInversionMng.validarMsProyectoInversionBk(msProyectoInversionBk);

		MsProyectoInversion msProyectoInversion = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msProyectoInversionBk.getIdProyecto() != null
					&& msProyectoInversionBk.getIdProyecto().longValue() > 0) {

				msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(msProyectoInversionBk.getIdProyecto());

				boolean cambios = AuditoriaMsProyectoInversionMng.auditarCambiosMsProyectoInversion(
						msProyectoInversionBk, msProyectoInversion, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					msProyectoInversion.setRtmaddressrst(rmtaddress);
					msProyectoInversion.setIdusserModif(kyUsuarioMod);
					msProyectoInversion.setFechaModif(hoy);
					msProyectoInversionDao.updateMsProyectoInversion(msProyectoInversion);
				}
			} else {
				msProyectoInversionBk.setRtmaddress(rmtaddress);
				msProyectoInversionBk.setRtmaddressrst(rmtaddress);

				msProyectoInversionBk.setFechaCrea(hoy);
				msProyectoInversionBk.setIdusserCrea(kyUsuarioMod);
				msProyectoInversionBk.setIdusserModif(kyUsuarioMod);
				msProyectoInversionBk.setFechaModif(hoy);
				msProyectoInversionBk.setEstado(Estado.ACTIVO.getValor());

				msProyectoInversion = new MsProyectoInversion();

				FuncionesStaticas.copyPropertiesObject(msProyectoInversion, msProyectoInversionBk);
				msProyectoInversionDao.saveMsProyectoInversion(msProyectoInversion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO msProyectoInversion" + " :: " + msProyectoInversion.getIdProyecto().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msProyectoInversionBk = getMsProyectoInversionBkXid(msProyectoInversion.getIdProyecto(), kyUsuarioMod);
		return msProyectoInversionBk;
	}

	@Override
	public void deleteMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			MsProyectoInversion msProyectoInversion = null;
			if (msProyectoInversionBk.getIdProyecto() != null
					&& msProyectoInversionBk.getIdProyecto().longValue() > 0) {

				msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(msProyectoInversionBk.getIdProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msProyectoInversion.setRtmaddressrst(rmtaddress);
				msProyectoInversion.setIdusserModif(kyUsuarioMod);
				msProyectoInversion.setFechaModif(hoy);
				Long estadoanterior = msProyectoInversion.getEstado();
				msProyectoInversion.setEstado(Estado.ELIMINADO.getValor());

				msProyectoInversionDao.updateMsProyectoInversion(msProyectoInversion);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO msProyectoInversion" + " :: " + msProyectoInversion.getIdProyecto().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			MsProyectoInversion msProyectoInversion = null;
			if (msProyectoInversionBk.getIdProyecto() != null
					&& msProyectoInversionBk.getIdProyecto().longValue() > 0) {

				msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(msProyectoInversionBk.getIdProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msProyectoInversion.setRtmaddressrst(rmtaddress);
				msProyectoInversion.setIdusserModif(kyUsuarioMod);
				msProyectoInversion.setFechaModif(hoy);
				Long estadoanterior = msProyectoInversion.getEstado();
				msProyectoInversion.setEstado(Estado.ACTIVO.getValor());

				msProyectoInversionDao.updateMsProyectoInversion(msProyectoInversion);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO msProyectoInversion" + " :: " + msProyectoInversion.getIdProyecto().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsProyectoInversionBk> getMsProyectoInversionXFiltro(String codigo, String nombre, Long idSede,
			Long kyUsuarioMod) {
		List<MsProyectoInversionBk> msProyectoInversionBkss = new ArrayList<MsProyectoInversionBk>();
		try {
			List<MsProyectoInversion> msProyectoInversionsss = msProyectoInversionDao.getXFiltro(codigo, nombre,
					idSede);
			for (MsProyectoInversion msProyectoInversion : msProyectoInversionsss) {
				MsProyectoInversionBk msProyectoInversionBk = new MsProyectoInversionBk();
				FuncionesStaticas.copyPropertiesObject(msProyectoInversionBk, msProyectoInversion);
				completarMsProyectoInversion(msProyectoInversionBk);
				setACLMsProyectoInversionBk(msProyectoInversionBk, kyUsuarioMod);
				msProyectoInversionBkss.add(msProyectoInversionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msProyectoInversionBkss;
	}

	@Override
	public List<MsProyectoInversionBk> getMsProyectoInversionXFiltro(String codigo, String nombre, Long idSede,
			int inicial, int MAX, Long kyUsuarioMod) {
		List<MsProyectoInversionBk> msProyectoInversionBkss = new ArrayList<MsProyectoInversionBk>();
		try {
			List<MsProyectoInversion> msProyectoInversionsss = msProyectoInversionDao.getXFiltro(codigo, nombre, idSede,
					inicial, MAX);
			for (MsProyectoInversion msProyectoInversion : msProyectoInversionsss) {
				MsProyectoInversionBk msProyectoInversionBk = new MsProyectoInversionBk();
				FuncionesStaticas.copyPropertiesObject(msProyectoInversionBk, msProyectoInversion);
				completarMsProyectoInversion(msProyectoInversionBk);
				setACLMsProyectoInversionBk(msProyectoInversionBk, kyUsuarioMod);
				msProyectoInversionBkss.add(msProyectoInversionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msProyectoInversionBkss;
	}

	@Override
	public Long getMsProyectoInversionTotalXFiltro(String codigo, String nombre, Long idSede, Long kyUsuarioMod) {
		try {
			Long totalMsProyectoInversionsss = msProyectoInversionDao.getTotalXFiltro(codigo, nombre, idSede);

			return totalMsProyectoInversionsss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsProyectoInversionBk(MsProyectoInversionBk msProyectoInversionBk, Long kyUsuarioMod) {
		MsProyectoInversionACL msProyectoInversionACL = new MsProyectoInversionACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSPROYECTOINVERSION_CREA)) {
					msProyectoInversionACL.setEsEditable(true);
					msProyectoInversionACL.setEliminar(true);
				} else if (roles.contains(Roles.MSPROYECTOINVERSION_VE)) {
					msProyectoInversionACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSPROYECTOINVERSION_CREA)) {
					msProyectoInversionACL.setEditopcion(1);
				} else {
					msProyectoInversionACL.setEditopcion(2);
				}
			} else {
				msProyectoInversionACL.setEditopcion(2);
			}
		} else {
			msProyectoInversionACL.setEditopcion(2);
		}
		msProyectoInversionBk.setMsProyectoInversionACL(msProyectoInversionACL);
	}

	/// ADICIONALES

	/**
	 * DT_AMPLIACION_FECHA SERVICIO: LISTA DE AMPLIACIONES DE LOS DÍAS DE
	 * PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
	 */
	@Override
	public DtAmpliacionFechaBk getDtAmpliacionFechaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtAmpliacionFecha dtAmpliacionFecha = dtAmpliacionFechaDao.getDtAmpliacionFecha(id);
		DtAmpliacionFechaBk dtAmpliacionFechaBk = null;
		if (dtAmpliacionFecha != null) {
			dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
			FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk, dtAmpliacionFecha);
			completarDtAmpliacionFecha(dtAmpliacionFechaBk);
			if (kyUsuarioMod != null)
				setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);
		}
		return dtAmpliacionFechaBk;
	}

	@Override
	public List<DtAmpliacionFechaBk> getAllDtAmpliacionFechaActivos(Long kyUsuarioMod) {
		List<DtAmpliacionFechaBk> dtAmpliacionFechaBkss = new ArrayList<DtAmpliacionFechaBk>();
		try {
			List<DtAmpliacionFecha> dtAmpliacionFechas = dtAmpliacionFechaDao.getActivasDtAmpliacionFecha();
			for (DtAmpliacionFecha dtAmpliacionFecha : dtAmpliacionFechas) {
				DtAmpliacionFechaBk dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
				FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk, dtAmpliacionFecha);
				completarDtAmpliacionFecha(dtAmpliacionFechaBk);
				setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);
				dtAmpliacionFechaBkss.add(dtAmpliacionFechaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAmpliacionFechaBkss;
	}

	@Override
	public List<DtAmpliacionFechaBk> getAllDtAmpliacionFechaActivosCero(Long kyUsuarioMod) {
		List<DtAmpliacionFechaBk> dtAmpliacionFechaBkss = new ArrayList<DtAmpliacionFechaBk>();
		try {
			List<DtAmpliacionFecha> dtAmpliacionFechas = dtAmpliacionFechaDao.getActivasDtAmpliacionFechaCero();
			for (DtAmpliacionFecha dtAmpliacionFecha : dtAmpliacionFechas) {
				DtAmpliacionFechaBk dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
				FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk, dtAmpliacionFecha);
				completarDtAmpliacionFecha(dtAmpliacionFechaBk);
				setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);
				dtAmpliacionFechaBkss.add(dtAmpliacionFechaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAmpliacionFechaBkss;
	}

	private void completarDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk) {
		try {
			if (dtAmpliacionFechaBk.getTipoFechaCorte() != null
					&& dtAmpliacionFechaBk.getTipoFechaCorte().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao
						.getPrtParametros(dtAmpliacionFechaBk.getTipoFechaCorte());
				if (prtParametros != null)
					dtAmpliacionFechaBk.setTipoFechaCorteTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAmpliacionFechaBk.getIdSede() != null && dtAmpliacionFechaBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtAmpliacionFechaBk.getIdSede());
				if (msSedes != null)
					dtAmpliacionFechaBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAmpliacionFechaBk.getIdSistAdmi() != null && dtAmpliacionFechaBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtAmpliacionFechaBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					dtAmpliacionFechaBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtAmpliacionFechaBk.getEstado()!=null &&
		// dtAmpliacionFechaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtAmpliacionFechaBk.getEstado());
		// if(prtParametros!=null)
		// dtAmpliacionFechaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtAmpliacionFechaBk saveorupdateDtAmpliacionFechaBk(DtAmpliacionFechaBk dtAmpliacionFechaBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtAmpliacionFechaMng.validarDtAmpliacionFechaBk(dtAmpliacionFechaBk);

		DtAmpliacionFecha dtAmpliacionFecha = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtAmpliacionFechaBk.getIdAutorizacion() != null
					&& dtAmpliacionFechaBk.getIdAutorizacion().longValue() > 0) {

				dtAmpliacionFecha = dtAmpliacionFechaDao.getDtAmpliacionFecha(dtAmpliacionFechaBk.getIdAutorizacion());

				boolean cambios = AuditoriaDtAmpliacionFechaMng.auditarCambiosDtAmpliacionFecha(dtAmpliacionFechaBk,
						dtAmpliacionFecha, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtAmpliacionFecha.setRtmaddressrst(rmtaddress);
					dtAmpliacionFecha.setIdusserModif(kyUsuarioMod);
					dtAmpliacionFecha.setFechaModif(hoy);
					dtAmpliacionFechaDao.updateDtAmpliacionFecha(dtAmpliacionFecha);
				}
			} else {
				dtAmpliacionFechaBk.setRtmaddress(rmtaddress);
				dtAmpliacionFechaBk.setRtmaddressrst(rmtaddress);

				dtAmpliacionFechaBk.setFechaCrea(hoy);
				dtAmpliacionFechaBk.setIdusserCrea(kyUsuarioMod);
				dtAmpliacionFechaBk.setIdusserModif(kyUsuarioMod);
				dtAmpliacionFechaBk.setFechaModif(hoy);
				dtAmpliacionFechaBk.setEstado(Estado.ACTIVO.getValor());

				dtAmpliacionFecha = new DtAmpliacionFecha();

				FuncionesStaticas.copyPropertiesObject(dtAmpliacionFecha, dtAmpliacionFechaBk);
				dtAmpliacionFechaDao.saveDtAmpliacionFecha(dtAmpliacionFecha);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtAmpliacionFecha" + " :: " + dtAmpliacionFecha.getIdAutorizacion().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtAmpliacionFechaBk = getDtAmpliacionFechaBkXid(dtAmpliacionFecha.getIdAutorizacion(), kyUsuarioMod);
		return dtAmpliacionFechaBk;
	}

	@Override
	public void deleteDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAmpliacionFecha dtAmpliacionFecha = null;
			if (dtAmpliacionFechaBk.getIdAutorizacion() != null
					&& dtAmpliacionFechaBk.getIdAutorizacion().longValue() > 0) {

				dtAmpliacionFecha = dtAmpliacionFechaDao.getDtAmpliacionFecha(dtAmpliacionFechaBk.getIdAutorizacion());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAmpliacionFecha.setRtmaddressrst(rmtaddress);
				dtAmpliacionFecha.setIdusserModif(kyUsuarioMod);
				dtAmpliacionFecha.setFechaModif(hoy);
				Long estadoanterior = dtAmpliacionFecha.getEstado();
				dtAmpliacionFecha.setEstado(Estado.ELIMINADO.getValor());

				dtAmpliacionFechaDao.updateDtAmpliacionFecha(dtAmpliacionFecha);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtAmpliacionFecha" + " :: " + dtAmpliacionFecha.getIdAutorizacion().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAmpliacionFecha dtAmpliacionFecha = null;
			if (dtAmpliacionFechaBk.getIdAutorizacion() != null
					&& dtAmpliacionFechaBk.getIdAutorizacion().longValue() > 0) {

				dtAmpliacionFecha = dtAmpliacionFechaDao.getDtAmpliacionFecha(dtAmpliacionFechaBk.getIdAutorizacion());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAmpliacionFecha.setRtmaddressrst(rmtaddress);
				dtAmpliacionFecha.setIdusserModif(kyUsuarioMod);
				dtAmpliacionFecha.setFechaModif(hoy);
				Long estadoanterior = dtAmpliacionFecha.getEstado();
				dtAmpliacionFecha.setEstado(Estado.ACTIVO.getValor());

				dtAmpliacionFechaDao.updateDtAmpliacionFecha(dtAmpliacionFecha);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtAmpliacionFecha" + " :: " + dtAmpliacionFecha.getIdAutorizacion().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtAmpliacionFechaBk> getDtAmpliacionFechaXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
			Timestamp fechaInicio, Timestamp fechaFin, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<DtAmpliacionFechaBk> dtAmpliacionFechaBkss = new ArrayList<DtAmpliacionFechaBk>();
		try {
			List<DtAmpliacionFecha> dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSede,
					idSistAdmi, fechaInicio, fechaFin, fechaModif, estado);
			for (DtAmpliacionFecha dtAmpliacionFecha : dtAmpliacionFechasss) {
				DtAmpliacionFechaBk dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
				FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk, dtAmpliacionFecha);
				completarDtAmpliacionFecha(dtAmpliacionFechaBk);
				setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);
				dtAmpliacionFechaBkss.add(dtAmpliacionFechaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAmpliacionFechaBkss;
	}

	@Override
	public List<DtAmpliacionFechaBk> getDtAmpliacionFechaXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
			Timestamp fechaInicio, Timestamp fechaFin, Timestamp fechaModif, Long estado, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtAmpliacionFechaBk> dtAmpliacionFechaBkss = new ArrayList<DtAmpliacionFechaBk>();
		try {
			List<DtAmpliacionFecha> dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSede,
					idSistAdmi, fechaInicio, fechaFin, fechaModif, estado, inicial, MAX);
			for (DtAmpliacionFecha dtAmpliacionFecha : dtAmpliacionFechasss) {
				DtAmpliacionFechaBk dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
				FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk, dtAmpliacionFecha);
				completarDtAmpliacionFecha(dtAmpliacionFechaBk);
				setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);
				dtAmpliacionFechaBkss.add(dtAmpliacionFechaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAmpliacionFechaBkss;
	}

	@Override
	public Long getDtAmpliacionFechaTotalXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
			Timestamp fechaInicio, Timestamp fechaFin, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalDtAmpliacionFechasss = dtAmpliacionFechaDao.getTotalXFiltro(tipoFechaCorte, idSede, idSistAdmi,
					fechaInicio, fechaFin, fechaModif, estado);

			return totalDtAmpliacionFechasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtAmpliacionFechaBk(DtAmpliacionFechaBk dtAmpliacionFechaBk, Long kyUsuarioMod) {
		DtAmpliacionFechaACL dtAmpliacionFechaACL = new DtAmpliacionFechaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTAMPLIACIONFECHA_CREA)) {
					dtAmpliacionFechaACL.setEsEditable(true);
					dtAmpliacionFechaACL.setEliminar(true);
				} else if (roles.contains(Roles.DTAMPLIACIONFECHA_VE)) {
					dtAmpliacionFechaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTAMPLIACIONFECHA_CREA)) {
					dtAmpliacionFechaACL.setEditopcion(1);
				} else {
					dtAmpliacionFechaACL.setEditopcion(2);
				}
			} else {
				dtAmpliacionFechaACL.setEditopcion(2);
			}
		} else {
			dtAmpliacionFechaACL.setEditopcion(2);
		}
		dtAmpliacionFechaBk.setDtAmpliacionFechaACL(dtAmpliacionFechaACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroTipoFechaCorte() {
		if (prtParametrosIdparametroTipoFechaCorteListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroTipoFechaCorteListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroTipoFechaCorteListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroTipoFechaCorteListaCache;
	}

	/**
	 * DT_ENCUESTA_RESPUESTA SERVICIO: LISTA DE RESPUESTAS A LAS ENCUESTAS
	 */
	@Override
	public DtEncuestaRespuestaBk getDtEncuestaRespuestaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtEncuestaRespuesta dtEncuestaRespuesta = dtEncuestaRespuestaDao.getDtEncuestaRespuesta(id);
		DtEncuestaRespuestaBk dtEncuestaRespuestaBk = null;
		if (dtEncuestaRespuesta != null) {
			dtEncuestaRespuestaBk = new DtEncuestaRespuestaBk();
			FuncionesStaticas.copyPropertiesObject(dtEncuestaRespuestaBk, dtEncuestaRespuesta);
			completarDtEncuestaRespuesta(dtEncuestaRespuestaBk);
			if (kyUsuarioMod != null)
				setACLDtEncuestaRespuestaBk(dtEncuestaRespuestaBk, kyUsuarioMod);
		}
		return dtEncuestaRespuestaBk;
	}

	@Override
	public List<DtEncuestaRespuestaBk> getAllDtEncuestaRespuestaActivos(Long kyUsuarioMod) {
		List<DtEncuestaRespuestaBk> dtEncuestaRespuestaBkss = new ArrayList<DtEncuestaRespuestaBk>();
		try {
			List<DtEncuestaRespuesta> dtEncuestaRespuestas = dtEncuestaRespuestaDao.getActivasDtEncuestaRespuesta();
			for (DtEncuestaRespuesta dtEncuestaRespuesta : dtEncuestaRespuestas) {
				DtEncuestaRespuestaBk dtEncuestaRespuestaBk = new DtEncuestaRespuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaRespuestaBk, dtEncuestaRespuesta);
				completarDtEncuestaRespuesta(dtEncuestaRespuestaBk);
				setACLDtEncuestaRespuestaBk(dtEncuestaRespuestaBk, kyUsuarioMod);
				dtEncuestaRespuestaBkss.add(dtEncuestaRespuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaRespuestaBkss;
	}

	@Override
	public List<DtEncuestaRespuestaBk> getAllDtEncuestaRespuestaActivosCero(Long kyUsuarioMod) {
		List<DtEncuestaRespuestaBk> dtEncuestaRespuestaBkss = new ArrayList<DtEncuestaRespuestaBk>();
		try {
			List<DtEncuestaRespuesta> dtEncuestaRespuestas = dtEncuestaRespuestaDao.getActivasDtEncuestaRespuestaCero();
			for (DtEncuestaRespuesta dtEncuestaRespuesta : dtEncuestaRespuestas) {
				DtEncuestaRespuestaBk dtEncuestaRespuestaBk = new DtEncuestaRespuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaRespuestaBk, dtEncuestaRespuesta);
				completarDtEncuestaRespuesta(dtEncuestaRespuestaBk);
				setACLDtEncuestaRespuestaBk(dtEncuestaRespuestaBk, kyUsuarioMod);
				dtEncuestaRespuestaBkss.add(dtEncuestaRespuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaRespuestaBkss;
	}

	private void completarDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk) {
		// try{
		// if(dtEncuestaRespuestaBk.getIdEncuesta()!=null &&
		// dtEncuestaRespuestaBk.getIdEncuesta().longValue()>0){
		// DtEncuesta dtEncuesta =
		// dtEncuestaDao.getDtEncuesta(dtEncuestaRespuestaBk.getIdEncuesta());
		// if(dtEncuesta!=null)
		// dtEncuestaRespuestaBk.setIdEncuestaTxt(dtEncuesta.get);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// try{
		// if(dtEncuestaRespuestaBk.getEstado()!=null &&
		// dtEncuestaRespuestaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEncuestaRespuestaBk.getEstado());
		// if(prtParametros!=null)
		// dtEncuestaRespuestaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtEncuestaRespuestaBk.getIdExpositor() != null
					&& dtEncuestaRespuestaBk.getIdExpositor().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtEncuestaRespuestaBk.getIdExpositor());
				if (msUsuarios != null)
					dtEncuestaRespuestaBk.setIdExpositorTxt(msUsuarios.getNombres());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtEncuestaRespuestaBk saveorupdateDtEncuestaRespuestaBk(DtEncuestaRespuestaBk dtEncuestaRespuestaBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtEncuestaRespuestaMng.validarDtEncuestaRespuestaBk(dtEncuestaRespuestaBk);

		DtEncuestaRespuesta dtEncuestaRespuesta = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtEncuestaRespuestaBk.getIdRespuesta() != null
					&& dtEncuestaRespuestaBk.getIdRespuesta().longValue() > 0) {

				dtEncuestaRespuesta = dtEncuestaRespuestaDao
						.getDtEncuestaRespuesta(dtEncuestaRespuestaBk.getIdRespuesta());

				boolean cambios = AuditoriaDtEncuestaRespuestaMng.auditarCambiosDtEncuestaRespuesta(
						dtEncuestaRespuestaBk, dtEncuestaRespuesta, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtEncuestaRespuesta.setRtmaddressrst(rmtaddress);
					dtEncuestaRespuesta.setIdusserModif(kyUsuarioMod);
					dtEncuestaRespuesta.setFechaModif(hoy);
					dtEncuestaRespuestaDao.updateDtEncuestaRespuesta(dtEncuestaRespuesta);
				}
			} else {
				dtEncuestaRespuestaBk.setRtmaddress(rmtaddress);
				dtEncuestaRespuestaBk.setRtmaddressrst(rmtaddress);

				dtEncuestaRespuestaBk.setFechaCrea(hoy);
				dtEncuestaRespuestaBk.setIdusserCrea(kyUsuarioMod);
				dtEncuestaRespuestaBk.setIdusserModif(kyUsuarioMod);
				dtEncuestaRespuestaBk.setFechaModif(hoy);
				dtEncuestaRespuestaBk.setEstado(Estado.ACTIVO.getValor());

				dtEncuestaRespuesta = new DtEncuestaRespuesta();

				FuncionesStaticas.copyPropertiesObject(dtEncuestaRespuesta, dtEncuestaRespuestaBk);
				dtEncuestaRespuestaDao.saveDtEncuestaRespuesta(dtEncuestaRespuesta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtEncuestaRespuesta" + " :: "
								+ dtEncuestaRespuesta.getIdRespuesta().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtEncuestaRespuestaBk = getDtEncuestaRespuestaBkXid(dtEncuestaRespuesta.getIdRespuesta(), kyUsuarioMod);
		return dtEncuestaRespuestaBk;
	}

	@Override
	public void deleteDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtEncuestaRespuesta dtEncuestaRespuesta = null;
			if (dtEncuestaRespuestaBk.getIdRespuesta() != null
					&& dtEncuestaRespuestaBk.getIdRespuesta().longValue() > 0) {

				dtEncuestaRespuesta = dtEncuestaRespuestaDao
						.getDtEncuestaRespuesta(dtEncuestaRespuestaBk.getIdRespuesta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEncuestaRespuesta.setRtmaddressrst(rmtaddress);
				dtEncuestaRespuesta.setIdusserModif(kyUsuarioMod);
				dtEncuestaRespuesta.setFechaModif(hoy);
				Long estadoanterior = dtEncuestaRespuesta.getEstado();
				dtEncuestaRespuesta.setEstado(Estado.ELIMINADO.getValor());

				dtEncuestaRespuestaDao.updateDtEncuestaRespuesta(dtEncuestaRespuesta);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtEncuestaRespuesta" + " :: " + dtEncuestaRespuesta.getIdRespuesta().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtEncuestaRespuesta dtEncuestaRespuesta = null;
			if (dtEncuestaRespuestaBk.getIdRespuesta() != null
					&& dtEncuestaRespuestaBk.getIdRespuesta().longValue() > 0) {

				dtEncuestaRespuesta = dtEncuestaRespuestaDao
						.getDtEncuestaRespuesta(dtEncuestaRespuestaBk.getIdRespuesta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEncuestaRespuesta.setRtmaddressrst(rmtaddress);
				dtEncuestaRespuesta.setIdusserModif(kyUsuarioMod);
				dtEncuestaRespuesta.setFechaModif(hoy);
				Long estadoanterior = dtEncuestaRespuesta.getEstado();
				dtEncuestaRespuesta.setEstado(Estado.ACTIVO.getValor());

				dtEncuestaRespuestaDao.updateDtEncuestaRespuesta(dtEncuestaRespuesta);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtEncuestaRespuesta" + " :: " + dtEncuestaRespuesta.getIdRespuesta().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtEncuestaRespuestaBk> getDtEncuestaRespuestaXFiltro(Integer idEncuesta, String pregunta,
			Long kyUsuarioMod) {
		List<DtEncuestaRespuestaBk> dtEncuestaRespuestaBkss = new ArrayList<DtEncuestaRespuestaBk>();
		try {
			List<DtEncuestaRespuesta> dtEncuestaRespuestasss = dtEncuestaRespuestaDao.getXFiltro(idEncuesta, pregunta);
			for (DtEncuestaRespuesta dtEncuestaRespuesta : dtEncuestaRespuestasss) {
				DtEncuestaRespuestaBk dtEncuestaRespuestaBk = new DtEncuestaRespuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaRespuestaBk, dtEncuestaRespuesta);
				completarDtEncuestaRespuesta(dtEncuestaRespuestaBk);
				setACLDtEncuestaRespuestaBk(dtEncuestaRespuestaBk, kyUsuarioMod);
				dtEncuestaRespuestaBkss.add(dtEncuestaRespuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaRespuestaBkss;
	}

	@Override
	public List<DtEncuestaRespuestaBk> getDtEncuestaRespuestaXFiltro(Integer idEncuesta, String pregunta, int inicial,
			int MAX, Long kyUsuarioMod) {
		List<DtEncuestaRespuestaBk> dtEncuestaRespuestaBkss = new ArrayList<DtEncuestaRespuestaBk>();
		try {
			List<DtEncuestaRespuesta> dtEncuestaRespuestasss = dtEncuestaRespuestaDao.getXFiltro(idEncuesta, pregunta,
					inicial, MAX);
			for (DtEncuestaRespuesta dtEncuestaRespuesta : dtEncuestaRespuestasss) {
				DtEncuestaRespuestaBk dtEncuestaRespuestaBk = new DtEncuestaRespuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaRespuestaBk, dtEncuestaRespuesta);
				completarDtEncuestaRespuesta(dtEncuestaRespuestaBk);
				setACLDtEncuestaRespuestaBk(dtEncuestaRespuestaBk, kyUsuarioMod);
				dtEncuestaRespuestaBkss.add(dtEncuestaRespuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaRespuestaBkss;
	}

	@Override
	public Long getDtEncuestaRespuestaTotalXFiltro(Integer idEncuesta, String pregunta, Long kyUsuarioMod) {
		try {
			Long totalDtEncuestaRespuestasss = dtEncuestaRespuestaDao.getTotalXFiltro(idEncuesta, pregunta);

			return totalDtEncuestaRespuestasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtEncuestaRespuestaBk(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, Long kyUsuarioMod) {
		DtEncuestaRespuestaACL dtEncuestaRespuestaACL = new DtEncuestaRespuestaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENCUESTARESPUESTA_CREA)) {
					dtEncuestaRespuestaACL.setEsEditable(true);
					dtEncuestaRespuestaACL.setEliminar(true);
				} else if (roles.contains(Roles.DTENCUESTARESPUESTA_VE)) {
					dtEncuestaRespuestaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENCUESTARESPUESTA_CREA)) {
					dtEncuestaRespuestaACL.setEditopcion(1);
				} else {
					dtEncuestaRespuestaACL.setEditopcion(2);
				}
			} else {
				dtEncuestaRespuestaACL.setEditopcion(2);
			}
		} else {
			dtEncuestaRespuestaACL.setEditopcion(2);
		}
		dtEncuestaRespuestaBk.setDtEncuestaRespuestaACL(dtEncuestaRespuestaACL);
	}

	/// ADICIONALES

	/**
	 * DT_ASISTENCIA_PROYECTO SERVICIO: LISTA DE LOS DISTINTOS PROYECTOS DE
	 * INVERSIÓN RELACIONADOS A LA ASISTENCIA TÉCNICA
	 */
	@Override
	public DtAsistenciaProyectoBk getDtAsistenciaProyectoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtAsistenciaProyecto dtAsistenciaProyecto = dtAsistenciaProyectoDao.getDtAsistenciaProyecto(id);
		DtAsistenciaProyectoBk dtAsistenciaProyectoBk = null;
		if (dtAsistenciaProyecto != null) {
			dtAsistenciaProyectoBk = new DtAsistenciaProyectoBk();
			FuncionesStaticas.copyPropertiesObject(dtAsistenciaProyectoBk, dtAsistenciaProyecto);
			completarDtAsistenciaProyecto(dtAsistenciaProyectoBk);
			if (kyUsuarioMod != null)
				setACLDtAsistenciaProyectoBk(dtAsistenciaProyectoBk, kyUsuarioMod);
		}
		return dtAsistenciaProyectoBk;
	}

	@Override
	public List<DtAsistenciaProyectoBk> getAllDtAsistenciaProyectoActivos(Long kyUsuarioMod) {
		List<DtAsistenciaProyectoBk> dtAsistenciaProyectoBkss = new ArrayList<DtAsistenciaProyectoBk>();
		try {
			List<DtAsistenciaProyecto> dtAsistenciaProyectos = dtAsistenciaProyectoDao.getActivasDtAsistenciaProyecto();
			for (DtAsistenciaProyecto dtAsistenciaProyecto : dtAsistenciaProyectos) {
				DtAsistenciaProyectoBk dtAsistenciaProyectoBk = new DtAsistenciaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaProyectoBk, dtAsistenciaProyecto);
				completarDtAsistenciaProyecto(dtAsistenciaProyectoBk);
				setACLDtAsistenciaProyectoBk(dtAsistenciaProyectoBk, kyUsuarioMod);
				dtAsistenciaProyectoBkss.add(dtAsistenciaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaProyectoBkss;
	}

	@Override
	public List<DtAsistenciaProyectoBk> getAllDtAsistenciaProyectoActivosCero(Long kyUsuarioMod) {
		List<DtAsistenciaProyectoBk> dtAsistenciaProyectoBkss = new ArrayList<DtAsistenciaProyectoBk>();
		try {
			List<DtAsistenciaProyecto> dtAsistenciaProyectos = dtAsistenciaProyectoDao
					.getActivasDtAsistenciaProyectoCero();
			for (DtAsistenciaProyecto dtAsistenciaProyecto : dtAsistenciaProyectos) {
				DtAsistenciaProyectoBk dtAsistenciaProyectoBk = new DtAsistenciaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaProyectoBk, dtAsistenciaProyecto);
				completarDtAsistenciaProyecto(dtAsistenciaProyectoBk);
				setACLDtAsistenciaProyectoBk(dtAsistenciaProyectoBk, kyUsuarioMod);
				dtAsistenciaProyectoBkss.add(dtAsistenciaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaProyectoBkss;
	}

	private void completarDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk) {
		try {
			if (dtAsistenciaProyectoBk.getIdAsistencia() != null
					&& dtAsistenciaProyectoBk.getIdAsistencia().longValue() > 0) {
				DtAsistencia dtAsistencia = dtAsistenciaDao.getDtAsistencia(dtAsistenciaProyectoBk.getIdAsistencia());
				if (dtAsistencia != null)
					dtAsistenciaProyectoBk.setIdAsistenciaTxt(dtAsistencia.getDetalle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtAsistenciaProyectoBk.getIdProyecto() != null
					&& dtAsistenciaProyectoBk.getIdProyecto().longValue() > 0) {
				MsProyectoInversion msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(dtAsistenciaProyectoBk.getIdProyecto());
				if (msProyectoInversion != null) {
					dtAsistenciaProyectoBk.setIdProyectoTxt(msProyectoInversion.getNombre());
					dtAsistenciaProyectoBk.setNombre(msProyectoInversion.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtAsistenciaProyectoBk.getEstado()!=null &&
		// dtAsistenciaProyectoBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtAsistenciaProyectoBk.getEstado());
		// if(prtParametros!=null)
		// dtAsistenciaProyectoBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtAsistenciaProyectoBk saveorupdateDtAsistenciaProyectoBk(DtAsistenciaProyectoBk dtAsistenciaProyectoBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtAsistenciaProyectoMng.validarDtAsistenciaProyectoBk(dtAsistenciaProyectoBk);

		DtAsistenciaProyecto dtAsistenciaProyecto = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtAsistenciaProyectoBk.getIdAsistProyecto() != null
					&& dtAsistenciaProyectoBk.getIdAsistProyecto().longValue() > 0) {

				dtAsistenciaProyecto = dtAsistenciaProyectoDao
						.getDtAsistenciaProyecto(dtAsistenciaProyectoBk.getIdAsistProyecto());

				boolean cambios = AuditoriaDtAsistenciaProyectoMng.auditarCambiosDtAsistenciaProyecto(
						dtAsistenciaProyectoBk, dtAsistenciaProyecto, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtAsistenciaProyecto.setRtmaddressrst(rmtaddress);
					dtAsistenciaProyecto.setIdusserModif(kyUsuarioMod);
					dtAsistenciaProyecto.setFechaModif(hoy);
					dtAsistenciaProyectoDao.updateDtAsistenciaProyecto(dtAsistenciaProyecto);
				}
			} else {
				dtAsistenciaProyectoBk.setRtmaddress(rmtaddress);
				dtAsistenciaProyectoBk.setRtmaddressrst(rmtaddress);

				dtAsistenciaProyectoBk.setFechaCrea(hoy);
				dtAsistenciaProyectoBk.setIdusserCrea(kyUsuarioMod);
				dtAsistenciaProyectoBk.setIdusserModif(kyUsuarioMod);
				dtAsistenciaProyectoBk.setFechaModif(hoy);
				dtAsistenciaProyectoBk.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaProyecto = new DtAsistenciaProyecto();

				FuncionesStaticas.copyPropertiesObject(dtAsistenciaProyecto, dtAsistenciaProyectoBk);
				dtAsistenciaProyectoDao.saveDtAsistenciaProyecto(dtAsistenciaProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtAsistenciaProyecto" + " :: "
								+ dtAsistenciaProyecto.getIdAsistProyecto().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtAsistenciaProyectoBk = getDtAsistenciaProyectoBkXid(dtAsistenciaProyecto.getIdAsistProyecto(), kyUsuarioMod);
		return dtAsistenciaProyectoBk;
	}

	@Override
	public void deleteDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaProyecto dtAsistenciaProyecto = null;
			if (dtAsistenciaProyectoBk.getIdAsistProyecto() != null
					&& dtAsistenciaProyectoBk.getIdAsistProyecto().longValue() > 0) {

				dtAsistenciaProyecto = dtAsistenciaProyectoDao
						.getDtAsistenciaProyecto(dtAsistenciaProyectoBk.getIdAsistProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaProyecto.setRtmaddressrst(rmtaddress);
				dtAsistenciaProyecto.setIdusserModif(kyUsuarioMod);
				dtAsistenciaProyecto.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaProyecto.getEstado();
				dtAsistenciaProyecto.setEstado(Estado.ELIMINADO.getValor());

				dtAsistenciaProyectoDao.updateDtAsistenciaProyecto(dtAsistenciaProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaProyecto" + " :: "
								+ dtAsistenciaProyecto.getIdAsistProyecto().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaProyecto dtAsistenciaProyecto = null;
			if (dtAsistenciaProyectoBk.getIdAsistProyecto() != null
					&& dtAsistenciaProyectoBk.getIdAsistProyecto().longValue() > 0) {

				dtAsistenciaProyecto = dtAsistenciaProyectoDao
						.getDtAsistenciaProyecto(dtAsistenciaProyectoBk.getIdAsistProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaProyecto.setRtmaddressrst(rmtaddress);
				dtAsistenciaProyecto.setIdusserModif(kyUsuarioMod);
				dtAsistenciaProyecto.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaProyecto.getEstado();
				dtAsistenciaProyecto.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaProyectoDao.updateDtAsistenciaProyecto(dtAsistenciaProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaProyecto" + " :: "
								+ dtAsistenciaProyecto.getIdAsistProyecto().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtAsistenciaProyectoBk> getDtAsistenciaProyectoXFiltro(Long idAsistencia, Long idProyecto,
			String detalle, Long kyUsuarioMod) {
		List<DtAsistenciaProyectoBk> dtAsistenciaProyectoBkss = new ArrayList<DtAsistenciaProyectoBk>();
		try {
			List<DtAsistenciaProyecto> dtAsistenciaProyectosss = dtAsistenciaProyectoDao.getXFiltro(idAsistencia,
					idProyecto, detalle);
			for (DtAsistenciaProyecto dtAsistenciaProyecto : dtAsistenciaProyectosss) {
				DtAsistenciaProyectoBk dtAsistenciaProyectoBk = new DtAsistenciaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaProyectoBk, dtAsistenciaProyecto);
				completarDtAsistenciaProyecto(dtAsistenciaProyectoBk);
				setACLDtAsistenciaProyectoBk(dtAsistenciaProyectoBk, kyUsuarioMod);
				dtAsistenciaProyectoBkss.add(dtAsistenciaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaProyectoBkss;
	}

	@Override
	public List<DtAsistenciaProyectoBk> getDtAsistenciaProyectoXFiltro(Long idAsistencia, Long idProyecto,
			String detalle, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtAsistenciaProyectoBk> dtAsistenciaProyectoBkss = new ArrayList<DtAsistenciaProyectoBk>();
		try {
			List<DtAsistenciaProyecto> dtAsistenciaProyectosss = dtAsistenciaProyectoDao.getXFiltro(idAsistencia,
					idProyecto, detalle, inicial, MAX);
			for (DtAsistenciaProyecto dtAsistenciaProyecto : dtAsistenciaProyectosss) {
				DtAsistenciaProyectoBk dtAsistenciaProyectoBk = new DtAsistenciaProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaProyectoBk, dtAsistenciaProyecto);
				completarDtAsistenciaProyecto(dtAsistenciaProyectoBk);
				setACLDtAsistenciaProyectoBk(dtAsistenciaProyectoBk, kyUsuarioMod);
				dtAsistenciaProyectoBkss.add(dtAsistenciaProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaProyectoBkss;
	}

	@Override
	public Long getDtAsistenciaProyectoTotalXFiltro(Long idAsistencia, Long idProyecto, String detalle,
			Long kyUsuarioMod) {
		try {
			Long totalDtAsistenciaProyectosss = dtAsistenciaProyectoDao.getTotalXFiltro(idAsistencia, idProyecto,
					detalle);

			return totalDtAsistenciaProyectosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtAsistenciaProyectoBk(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, Long kyUsuarioMod) {
		DtAsistenciaProyectoACL dtAsistenciaProyectoACL = new DtAsistenciaProyectoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIAPROYECTO_CREA)) {
					dtAsistenciaProyectoACL.setEsEditable(true);
					dtAsistenciaProyectoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTASISTENCIAPROYECTO_VE)) {
					dtAsistenciaProyectoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIAPROYECTO_CREA)) {
					dtAsistenciaProyectoACL.setEditopcion(1);
				} else {
					dtAsistenciaProyectoACL.setEditopcion(2);
				}
			} else {
				dtAsistenciaProyectoACL.setEditopcion(2);
			}
		} else {
			dtAsistenciaProyectoACL.setEditopcion(2);
		}
		dtAsistenciaProyectoBk.setDtAsistenciaProyectoACL(dtAsistenciaProyectoACL);
	}

	/// ADICIONALES

	/**
	 * MS_SEDES SERVICIO: LISTA LAS SEDES REGISTRADAS EN EL SISTEMA
	 */
	@Override
	public MsSedesBk getMsSedesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsSedes msSedes = msSedesDao.getMsSedes(id);
		MsSedesBk msSedesBk = null;
		if (msSedes != null) {
			msSedesBk = new MsSedesBk();
			FuncionesStaticas.copyPropertiesObject(msSedesBk, msSedes);
			completarMsSedes(msSedesBk);
			if (kyUsuarioMod != null)
				setACLMsSedesBk(msSedesBk, kyUsuarioMod);
		}
		return msSedesBk;
	}

	@Override
	public List<MsSedesBk> getAllMsSedesActivos(Long kyUsuarioMod) {
		List<MsSedesBk> msSedesBkss = new ArrayList<MsSedesBk>();
		try {
			List<MsSedes> msSedess = msSedesDao.getActivasMsSedes();
			for (MsSedes msSedes : msSedess) {
				MsSedesBk msSedesBk = new MsSedesBk();
				FuncionesStaticas.copyPropertiesObject(msSedesBk, msSedes);
				completarMsSedes(msSedesBk);
				setACLMsSedesBk(msSedesBk, kyUsuarioMod);
				msSedesBkss.add(msSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSedesBkss;
	}

	@Override
	public List<MsSedesBk> getAllMsSedesActivosCero(Long kyUsuarioMod) {
		List<MsSedesBk> msSedesBkss = new ArrayList<MsSedesBk>();
		try {
			List<MsSedes> msSedess = msSedesDao.getActivasMsSedesCero();
			for (MsSedes msSedes : msSedess) {
				MsSedesBk msSedesBk = new MsSedesBk();
				FuncionesStaticas.copyPropertiesObject(msSedesBk, msSedes);
				completarMsSedes(msSedesBk);
				setACLMsSedesBk(msSedesBk, kyUsuarioMod);
				msSedesBkss.add(msSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSedesBkss;
	}

	private void completarMsSedes(MsSedesBk msSedesBk) {
		try {
			if (msSedesBk.getIdGrupo() != null && msSedesBk.getIdGrupo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msSedesBk.getIdGrupo());
				if (prtParametros != null)
					msSedesBk.setIdGrupoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msSedesBk.getIdMacregion() != null && msSedesBk.getIdMacregion().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msSedesBk.getIdMacregion());
				if (prtParametros != null)
					msSedesBk.setIdMacregionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try{
		// if(msSedesBk.getEstado()!=null &&
		// msSedesBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msSedesBk.getEstado());
		// if(prtParametros!=null)
		// msSedesBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			if (msSedesBk.getCodDpto() != null && msSedesBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = msSedesBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msSedesBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msSedesBk.getCodDpto() != null && msSedesBk.getCodDpto().intValue() > 0
					&& msSedesBk.getCodProv() != null && msSedesBk.getCodProv().intValue() > 0) {
				int iiCodDpto = msSedesBk.getCodDpto().intValue();
				int iiCodProv = msSedesBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msSedesBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msSedesBk.getCodDpto() != null && msSedesBk.getCodDpto().intValue() > 0
					&& msSedesBk.getCodProv() != null && msSedesBk.getCodProv().intValue() > 0
					&& msSedesBk.getCodDistr() != null && msSedesBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = msSedesBk.getCodDpto().intValue();
				int iiCodProv = msSedesBk.getCodProv().intValue();
				int iiCodDistr = msSedesBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msSedesBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msSedesBk.getIdpais() != null && msSedesBk.getIdpais().longValue() > 0) {
				MsPaises msPaises = msPaisesDao.getMsPaises(msSedesBk.getIdpais());
				if (msPaises != null)
					msSedesBk.setIdpaisTxt(msPaises.getPaisNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public MsSedesBk saveorupdateMsSedesBk(MsSedesBk msSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsSedesMng.validarMsSedesBk(msSedesBk);

		MsSedes msSedes = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msSedesBk.getIdSede() != null && msSedesBk.getIdSede().longValue() > 0) {

				msSedes = msSedesDao.getMsSedes(msSedesBk.getIdSede());

				boolean cambios = AuditoriaMsSedesMng.auditarCambiosMsSedes(msSedesBk, msSedes, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msSedes.setRtmaddressrst(rmtaddress);
					msSedes.setIdusserModif(kyUsuarioMod);
					msSedes.setFechaModif(hoy);
					msSedesDao.updateMsSedes(msSedes);
				}
			} else {
				msSedesBk.setRtmaddress(rmtaddress);
				msSedesBk.setRtmaddressrst(rmtaddress);

				msSedesBk.setFechaCrea(hoy);
				msSedesBk.setIdusserCrea(kyUsuarioMod);
				msSedesBk.setIdusserModif(kyUsuarioMod);
				msSedesBk.setFechaModif(hoy);
				msSedesBk.setEstado(Estado.ACTIVO.getValor());

				msSedes = new MsSedes();

				FuncionesStaticas.copyPropertiesObject(msSedes, msSedesBk);
				msSedesDao.saveMsSedes(msSedes);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msSedes" + " :: " + msSedes.getIdSede().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msSedesBk = getMsSedesBkXid(msSedes.getIdSede(), kyUsuarioMod);
		return msSedesBk;
	}

	@Override
	public void deleteMsSedes(MsSedesBk msSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsSedes msSedes = null;
			if (msSedesBk.getIdSede() != null && msSedesBk.getIdSede().longValue() > 0) {

				msSedes = msSedesDao.getMsSedes(msSedesBk.getIdSede());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msSedes.setRtmaddressrst(rmtaddress);
				msSedes.setIdusserModif(kyUsuarioMod);
				msSedes.setFechaModif(hoy);
				Long estadoanterior = msSedes.getEstado();
				msSedes.setEstado(Estado.ELIMINADO.getValor());

				msSedesDao.updateMsSedes(msSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msSedes"
								+ " :: " + msSedes.getIdSede().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsSedes(MsSedesBk msSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsSedes msSedes = null;
			if (msSedesBk.getIdSede() != null && msSedesBk.getIdSede().longValue() > 0) {

				msSedes = msSedesDao.getMsSedes(msSedesBk.getIdSede());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msSedes.setRtmaddressrst(rmtaddress);
				msSedes.setIdusserModif(kyUsuarioMod);
				msSedes.setFechaModif(hoy);
				Long estadoanterior = msSedes.getEstado();
				msSedes.setEstado(Estado.ACTIVO.getValor());

				msSedesDao.updateMsSedes(msSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msSedes"
								+ " :: " + msSedes.getIdSede().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsSedesBk> getMsSedesXFiltro(String sede, Long idGrupo, Long idMacregion, String sigla, Integer codDpto,
			String direccion, Long orden, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsSedesBk> msSedesBkss = new ArrayList<MsSedesBk>();
		try {
			List<MsSedes> msSedessss = msSedesDao.getXFiltro(sede, idGrupo, idMacregion, sigla, codDpto, direccion,
					orden, fechaModif, estado);
			for (MsSedes msSedes : msSedessss) {
				MsSedesBk msSedesBk = new MsSedesBk();
				FuncionesStaticas.copyPropertiesObject(msSedesBk, msSedes);
				completarMsSedes(msSedesBk);
				setACLMsSedesBk(msSedesBk, kyUsuarioMod);
				msSedesBkss.add(msSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSedesBkss;
	}

	@Override
	public List<MsSedesBk> getMsSedesXFiltro(String sede, Long idGrupo, Long idMacregion, String sigla, Integer codDpto,
			String direccion, Long orden, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsSedesBk> msSedesBkss = new ArrayList<MsSedesBk>();
		try {
			List<MsSedes> msSedessss = msSedesDao.getXFiltro(sede, idGrupo, idMacregion, sigla, codDpto, direccion,
					orden, fechaModif, estado, inicial, MAX);
			for (MsSedes msSedes : msSedessss) {
				MsSedesBk msSedesBk = new MsSedesBk();
				FuncionesStaticas.copyPropertiesObject(msSedesBk, msSedes);
				completarMsSedes(msSedesBk);
				setACLMsSedesBk(msSedesBk, kyUsuarioMod);
				msSedesBkss.add(msSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msSedesBkss;
	}

	@Override
	public Long getMsSedesTotalXFiltro(String sede, Long idGrupo, Long idMacregion, String sigla, Integer codDpto,
			String direccion, Long orden, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsSedessss = msSedesDao.getTotalXFiltro(sede, idGrupo, idMacregion, sigla, codDpto, direccion,
					orden, fechaModif, estado);

			return totalMsSedessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsSedesBk(MsSedesBk msSedesBk, Long kyUsuarioMod) {
		MsSedesACL msSedesACL = new MsSedesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSEDES_CREA)) {
					msSedesACL.setEsEditable(true);
					msSedesACL.setEliminar(true);
				} else if (roles.contains(Roles.MSSEDES_VE)) {
					msSedesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSEDES_CREA)) {
					msSedesACL.setEditopcion(1);
				} else {
					msSedesACL.setEditopcion(2);
				}
			} else {
				msSedesACL.setEditopcion(2);
			}
		} else {
			msSedesACL.setEditopcion(2);
		}
		msSedesBk.setMsSedesACL(msSedesACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdGrupo() {
		if (prtParametrosIdparametroIdGrupoListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdGrupoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdGrupoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdGrupoListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdMacregion() {
		if (prtParametrosIdparametroIdMacregionListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdMacregionListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdMacregionListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdMacregionListaCache;
	}

	/**
	 * DT_VISITAS_TEMAS SERVICIO: LISTA DE LOS TEMAS DE LA VISITA
	 */
	@Override
	public DtVisitasTemasBk getDtVisitasTemasBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtVisitasTemas dtVisitasTemas = dtVisitasTemasDao.getDtVisitasTemas(id);
		DtVisitasTemasBk dtVisitasTemasBk = null;
		if (dtVisitasTemas != null) {
			dtVisitasTemasBk = new DtVisitasTemasBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasTemasBk, dtVisitasTemas);
			completarDtVisitasTemas(dtVisitasTemasBk);
			if (kyUsuarioMod != null)
				setACLDtVisitasTemasBk(dtVisitasTemasBk, kyUsuarioMod);
		}
		return dtVisitasTemasBk;
	}

	@Override
	public List<DtVisitasTemasBk> getAllDtVisitasTemasActivos(Long kyUsuarioMod) {
		List<DtVisitasTemasBk> dtVisitasTemasBkss = new ArrayList<DtVisitasTemasBk>();
		try {
			List<DtVisitasTemas> dtVisitasTemass = dtVisitasTemasDao.getActivasDtVisitasTemas();
			for (DtVisitasTemas dtVisitasTemas : dtVisitasTemass) {
				DtVisitasTemasBk dtVisitasTemasBk = new DtVisitasTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasTemasBk, dtVisitasTemas);
				completarDtVisitasTemas(dtVisitasTemasBk);
				setACLDtVisitasTemasBk(dtVisitasTemasBk, kyUsuarioMod);
				dtVisitasTemasBkss.add(dtVisitasTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasTemasBkss;
	}

	@Override
	public List<DtVisitasTemasBk> getAllDtVisitasTemasActivosCero(Long kyUsuarioMod) {
		List<DtVisitasTemasBk> dtVisitasTemasBkss = new ArrayList<DtVisitasTemasBk>();
		try {
			List<DtVisitasTemas> dtVisitasTemass = dtVisitasTemasDao.getActivasDtVisitasTemasCero();
			for (DtVisitasTemas dtVisitasTemas : dtVisitasTemass) {
				DtVisitasTemasBk dtVisitasTemasBk = new DtVisitasTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasTemasBk, dtVisitasTemas);
				completarDtVisitasTemas(dtVisitasTemasBk);
				setACLDtVisitasTemasBk(dtVisitasTemasBk, kyUsuarioMod);
				dtVisitasTemasBkss.add(dtVisitasTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasTemasBkss;
	}

	private void completarDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk) {
		// try{
		// if(dtVisitasTemasBk.getEstado()!=null &&
		// dtVisitasTemasBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtVisitasTemasBk.getEstado());
		// if(prtParametros!=null)
		// dtVisitasTemasBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtVisitasTemasBk.getIdVisita() != null && dtVisitasTemasBk.getIdVisita().longValue() > 0) {
				DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasTemasBk.getIdVisita());
				if (dtVisitas != null)
					dtVisitasTemasBk.setIdVisitaTxt(dtVisitas.getConclusion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasTemasBk.getIdTema() != null && dtVisitasTemasBk.getIdTema().longValue() > 0) {
				MsTema msTema = msTemaDao.getMsTema(dtVisitasTemasBk.getIdTema());
				if (msTema != null)
					dtVisitasTemasBk.setIdTemaTxt(msTema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtVisitasTemasBk saveorupdateDtVisitasTemasBk(DtVisitasTemasBk dtVisitasTemasBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtVisitasTemasMng.validarDtVisitasTemasBk(dtVisitasTemasBk);

		DtVisitasTemas dtVisitasTemas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasTemasBk.getIdVisitaTema() != null && dtVisitasTemasBk.getIdVisitaTema().longValue() > 0) {

				dtVisitasTemas = dtVisitasTemasDao.getDtVisitasTemas(dtVisitasTemasBk.getIdVisitaTema());

				boolean cambios = AuditoriaDtVisitasTemasMng.auditarCambiosDtVisitasTemas(dtVisitasTemasBk,
						dtVisitasTemas, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtVisitasTemas.setRtmaddressrst(rmtaddress);
					dtVisitasTemas.setIduserModif(kyUsuarioMod);
					dtVisitasTemas.setFechaModif(hoy);
					dtVisitasTemasDao.updateDtVisitasTemas(dtVisitasTemas);
				}
			} else {
				dtVisitasTemasBk.setRtmaddress(rmtaddress);
				dtVisitasTemasBk.setRtmaddressrst(rmtaddress);

				dtVisitasTemasBk.setFechaCrea(hoy);
				// dtVisitasTemasBk.setIdusserCrea(kyUsuarioMod);
				dtVisitasTemasBk.setIduserModif(kyUsuarioMod);
				dtVisitasTemasBk.setFechaModif(hoy);
				dtVisitasTemasBk.setEstado(Estado.ACTIVO.getValor());

				dtVisitasTemas = new DtVisitasTemas();

				FuncionesStaticas.copyPropertiesObject(dtVisitasTemas, dtVisitasTemasBk);
				dtVisitasTemasDao.saveDtVisitasTemas(dtVisitasTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtVisitasTemas" + " :: " + dtVisitasTemas.getIdVisitaTema().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtVisitasTemasBk = getDtVisitasTemasBkXid(dtVisitasTemas.getIdVisitaTema(), kyUsuarioMod);
		return dtVisitasTemasBk;
	}

	@Override
	public void deleteDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtVisitasTemas dtVisitasTemas = null;
			if (dtVisitasTemasBk.getIdVisitaTema() != null && dtVisitasTemasBk.getIdVisitaTema().longValue() > 0) {

				dtVisitasTemas = dtVisitasTemasDao.getDtVisitasTemas(dtVisitasTemasBk.getIdVisitaTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasTemas.setRtmaddressrst(rmtaddress);
				dtVisitasTemas.setIduserModif(kyUsuarioMod);
				dtVisitasTemas.setFechaModif(hoy);
				Long estadoanterior = dtVisitasTemas.getEstado();
				dtVisitasTemas.setEstado(Estado.ELIMINADO.getValor());

				dtVisitasTemasDao.updateDtVisitasTemas(dtVisitasTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtVisitasTemas" + " :: " + dtVisitasTemas.getIdVisitaTema().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtVisitasTemas dtVisitasTemas = null;
			if (dtVisitasTemasBk.getIdVisitaTema() != null && dtVisitasTemasBk.getIdVisitaTema().longValue() > 0) {

				dtVisitasTemas = dtVisitasTemasDao.getDtVisitasTemas(dtVisitasTemasBk.getIdVisitaTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasTemas.setRtmaddressrst(rmtaddress);
				dtVisitasTemas.setIduserModif(kyUsuarioMod);
				dtVisitasTemas.setFechaModif(hoy);
				Long estadoanterior = dtVisitasTemas.getEstado();
				dtVisitasTemas.setEstado(Estado.ACTIVO.getValor());

				dtVisitasTemasDao.updateDtVisitasTemas(dtVisitasTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtVisitasTemas" + " :: " + dtVisitasTemas.getIdVisitaTema().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtVisitasTemasBk> getDtVisitasTemasXFiltro(Long idVisita, Long kyUsuarioMod) {
		List<DtVisitasTemasBk> dtVisitasTemasBkss = new ArrayList<DtVisitasTemasBk>();
		try {
			List<DtVisitasTemas> dtVisitasTemassss = dtVisitasTemasDao.getXFiltro(idVisita);
			for (DtVisitasTemas dtVisitasTemas : dtVisitasTemassss) {
				DtVisitasTemasBk dtVisitasTemasBk = new DtVisitasTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasTemasBk, dtVisitasTemas);
				completarDtVisitasTemas(dtVisitasTemasBk);
				setACLDtVisitasTemasBk(dtVisitasTemasBk, kyUsuarioMod);
				dtVisitasTemasBkss.add(dtVisitasTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasTemasBkss;
	}

	@Override
	public List<DtVisitasTemasBk> getDtVisitasTemasXFiltro(Long idVisita, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtVisitasTemasBk> dtVisitasTemasBkss = new ArrayList<DtVisitasTemasBk>();
		try {
			List<DtVisitasTemas> dtVisitasTemassss = dtVisitasTemasDao.getXFiltro(idVisita, inicial, MAX);
			for (DtVisitasTemas dtVisitasTemas : dtVisitasTemassss) {
				DtVisitasTemasBk dtVisitasTemasBk = new DtVisitasTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasTemasBk, dtVisitasTemas);
				completarDtVisitasTemas(dtVisitasTemasBk);
				setACLDtVisitasTemasBk(dtVisitasTemasBk, kyUsuarioMod);
				dtVisitasTemasBkss.add(dtVisitasTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasTemasBkss;
	}

	@Override
	public Long getDtVisitasTemasTotalXFiltro(Long idVisita, Long kyUsuarioMod) {
		try {
			Long totalDtVisitasTemassss = dtVisitasTemasDao.getTotalXFiltro(idVisita);

			return totalDtVisitasTemassss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtVisitasTemasBk(DtVisitasTemasBk dtVisitasTemasBk, Long kyUsuarioMod) {
		DtVisitasTemasACL dtVisitasTemasACL = new DtVisitasTemasACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASTEMAS_CREA)) {
					dtVisitasTemasACL.setEsEditable(true);
					dtVisitasTemasACL.setEliminar(true);
				} else if (roles.contains(Roles.DTVISITASTEMAS_VE)) {
					dtVisitasTemasACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASTEMAS_CREA)) {
					dtVisitasTemasACL.setEditopcion(1);
				} else {
					dtVisitasTemasACL.setEditopcion(2);
				}
			} else {
				dtVisitasTemasACL.setEditopcion(2);
			}
		} else {
			dtVisitasTemasACL.setEditopcion(2);
		}
		dtVisitasTemasBk.setDtVisitasTemasACL(dtVisitasTemasACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdEstadoActual() {
		if (prtParametrosIdparametroIdEstadoActualListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdEstadoActualListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdEstadoActualListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdEstadoActualListaCache;
	}

	/**
	 * DT_ANEXO SERVICIO: LISTA DE LOS DOCUMENTOS ANEXADOS EN EL SISTEMA
	 */
	@Override
	public DtAnexoBk getDtAnexoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtAnexo dtAnexo = dtAnexoDao.getDtAnexo(id);
		DtAnexoBk dtAnexoBk = null;
		if (dtAnexo != null) {
			dtAnexoBk = new DtAnexoBk();
			FuncionesStaticas.copyPropertiesObject(dtAnexoBk, dtAnexo);
			completarDtAnexo(dtAnexoBk);
			if (kyUsuarioMod != null)
				setACLDtAnexoBk(dtAnexoBk, kyUsuarioMod);
		}
		return dtAnexoBk;
	}

	@Override
	public List<DtAnexoBk> getAllDtAnexoActivos(Long kyUsuarioMod) {
		List<DtAnexoBk> dtAnexoBkss = new ArrayList<DtAnexoBk>();
		try {
			List<DtAnexo> dtAnexos = dtAnexoDao.getActivasDtAnexo();
			for (DtAnexo dtAnexo : dtAnexos) {
				DtAnexoBk dtAnexoBk = new DtAnexoBk();
				FuncionesStaticas.copyPropertiesObject(dtAnexoBk, dtAnexo);
				completarDtAnexo(dtAnexoBk);
				setACLDtAnexoBk(dtAnexoBk, kyUsuarioMod);
				dtAnexoBkss.add(dtAnexoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAnexoBkss;
	}

	@Override
	public List<DtAnexoBk> getAllDtAnexoActivosCero(Long kyUsuarioMod) {
		List<DtAnexoBk> dtAnexoBkss = new ArrayList<DtAnexoBk>();
		try {
			List<DtAnexo> dtAnexos = dtAnexoDao.getActivasDtAnexoCero();
			for (DtAnexo dtAnexo : dtAnexos) {
				DtAnexoBk dtAnexoBk = new DtAnexoBk();
				FuncionesStaticas.copyPropertiesObject(dtAnexoBk, dtAnexo);
				completarDtAnexo(dtAnexoBk);
				setACLDtAnexoBk(dtAnexoBk, kyUsuarioMod);
				dtAnexoBkss.add(dtAnexoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAnexoBkss;
	}

	private void completarDtAnexo(DtAnexoBk dtAnexoBk) {
		// try{
		// if(dtAnexoBk.getEstado()!=null &&
		// dtAnexoBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtAnexoBk.getEstado());
		// if(prtParametros!=null)
		// dtAnexoBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtAnexoBk.getIdTiposervicio() != null && dtAnexoBk.getIdTiposervicio().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtAnexoBk.getIdTiposervicio());
				if (prtParametros != null)
					dtAnexoBk.setIdTiposervicioTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtAnexoBk saveorupdateDtAnexoBk(DtAnexoBk dtAnexoBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionDtAnexoMng.validarDtAnexoBk(dtAnexoBk);

		DtAnexo dtAnexo = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtAnexoBk.getIdAnexo() != null && dtAnexoBk.getIdAnexo().longValue() > 0) {

				dtAnexo = dtAnexoDao.getDtAnexo(dtAnexoBk.getIdAnexo());

				boolean cambios = AuditoriaDtAnexoMng.auditarCambiosDtAnexo(dtAnexoBk, dtAnexo, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					dtAnexo.setRtmaddressrst(rmtaddress);
					dtAnexo.setIdusserModif(kyUsuarioMod);
					dtAnexo.setFechaModif(hoy);
					dtAnexoDao.updateDtAnexo(dtAnexo);
				}
			} else {
				dtAnexoBk.setRtmaddress(rmtaddress);
				dtAnexoBk.setRtmaddressrst(rmtaddress);

				dtAnexoBk.setFechaCrea(hoy);
				dtAnexoBk.setIdusserCrea(kyUsuarioMod);
				dtAnexoBk.setIdusserModif(kyUsuarioMod);
				dtAnexoBk.setFechaModif(hoy);
				dtAnexoBk.setEstado(Estado.ACTIVO.getValor());

				dtAnexo = new DtAnexo();

				FuncionesStaticas.copyPropertiesObject(dtAnexo, dtAnexoBk);
				dtAnexoDao.saveDtAnexo(dtAnexo);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO dtAnexo" + " :: " + dtAnexo.getIdAnexo().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtAnexoBk = getDtAnexoBkXid(dtAnexo.getIdAnexo(), kyUsuarioMod);
		return dtAnexoBk;
	}

	@Override
	public void deleteDtAnexo(DtAnexoBk dtAnexoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			DtAnexo dtAnexo = null;
			if (dtAnexoBk.getIdAnexo() != null && dtAnexoBk.getIdAnexo().longValue() > 0) {

				dtAnexo = dtAnexoDao.getDtAnexo(dtAnexoBk.getIdAnexo());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAnexo.setRtmaddressrst(rmtaddress);
				dtAnexo.setIdusserModif(kyUsuarioMod);
				dtAnexo.setFechaModif(hoy);
				Long estadoanterior = dtAnexo.getEstado();
				dtAnexo.setEstado(Estado.ELIMINADO.getValor());

				dtAnexoDao.updateDtAnexo(dtAnexo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO dtAnexo"
								+ " :: " + dtAnexo.getIdAnexo().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtAnexo(DtAnexoBk dtAnexoBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			DtAnexo dtAnexo = null;
			if (dtAnexoBk.getIdAnexo() != null && dtAnexoBk.getIdAnexo().longValue() > 0) {

				dtAnexo = dtAnexoDao.getDtAnexo(dtAnexoBk.getIdAnexo());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAnexo.setRtmaddressrst(rmtaddress);
				dtAnexo.setIdusserModif(kyUsuarioMod);
				dtAnexo.setFechaModif(hoy);
				Long estadoanterior = dtAnexo.getEstado();
				dtAnexo.setEstado(Estado.ACTIVO.getValor());

				dtAnexoDao.updateDtAnexo(dtAnexo);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO dtAnexo"
								+ " :: " + dtAnexo.getIdAnexo().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtAnexoBk> getDtAnexoXFiltro(String filename, String filenameoriginal, Long idTiposervicio,
			Long tipoAnexo, Long idmaestro, Long kyUsuarioMod) {
		List<DtAnexoBk> dtAnexoBkss = new ArrayList<DtAnexoBk>();
		try {
			List<DtAnexo> dtAnexosss = dtAnexoDao.getXFiltro(filename, filenameoriginal, idTiposervicio, tipoAnexo,
					idmaestro);
			for (DtAnexo dtAnexo : dtAnexosss) {
				DtAnexoBk dtAnexoBk = new DtAnexoBk();
				FuncionesStaticas.copyPropertiesObject(dtAnexoBk, dtAnexo);
				completarDtAnexo(dtAnexoBk);
				setACLDtAnexoBk(dtAnexoBk, kyUsuarioMod);
				dtAnexoBkss.add(dtAnexoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAnexoBkss;
	}

	@Override
	public List<DtAnexoBk> getDtAnexoXFiltro(String filename, String filenameoriginal, Long idTiposervicio,
			Long tipoAnexo, Long idmaestro, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtAnexoBk> dtAnexoBkss = new ArrayList<DtAnexoBk>();
		try {
			List<DtAnexo> dtAnexosss = dtAnexoDao.getXFiltro(filename, filenameoriginal, idTiposervicio, tipoAnexo,
					idmaestro, inicial, MAX);
			for (DtAnexo dtAnexo : dtAnexosss) {
				DtAnexoBk dtAnexoBk = new DtAnexoBk();
				FuncionesStaticas.copyPropertiesObject(dtAnexoBk, dtAnexo);
				completarDtAnexo(dtAnexoBk);
				setACLDtAnexoBk(dtAnexoBk, kyUsuarioMod);
				dtAnexoBkss.add(dtAnexoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAnexoBkss;
	}

	@Override
	public Long getDtAnexoTotalXFiltro(String filename, String filenameoriginal, Long idTiposervicio, Long tipoAnexo,
			Long idmaestro, Long kyUsuarioMod) {
		try {
			Long totalDtAnexosss = dtAnexoDao.getTotalXFiltro(filename, filenameoriginal, idTiposervicio, tipoAnexo,
					idmaestro);

			return totalDtAnexosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtAnexoBk(DtAnexoBk dtAnexoBk, Long kyUsuarioMod) {
		DtAnexoACL dtAnexoACL = new DtAnexoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTANEXO_CREA)) {
					dtAnexoACL.setEsEditable(true);
					dtAnexoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTANEXO_VE)) {
					dtAnexoACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTANEXO_CREA)) {
					dtAnexoACL.setEditopcion(1);
				} else {
					dtAnexoACL.setEditopcion(2);
				}
			} else {
				dtAnexoACL.setEditopcion(2);
			}
		} else {
			dtAnexoACL.setEditopcion(2);
		}
		dtAnexoBk.setDtAnexoACL(dtAnexoACL);
	}

	/// ADICIONALES

	/**
	 * DT_CAPA_TEMAS SERVICIO: LISTA DE LOS DIFERENTES TEMAS AGENDADOS EN LA
	 * CAPACITACIÓN
	 */
	@Override
	public DtCapaTemasBk getDtCapaTemasBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCapaTemas dtCapaTemas = dtCapaTemasDao.getDtCapaTemas(id);
		DtCapaTemasBk dtCapaTemasBk = null;
		if (dtCapaTemas != null) {
			dtCapaTemasBk = new DtCapaTemasBk();
			FuncionesStaticas.copyPropertiesObject(dtCapaTemasBk, dtCapaTemas);
			completarDtCapaTemas(dtCapaTemasBk);
			if (kyUsuarioMod != null)
				setACLDtCapaTemasBk(dtCapaTemasBk, kyUsuarioMod);
		}
		return dtCapaTemasBk;
	}

	@Override
	public List<DtCapaTemasBk> getAllDtCapaTemasActivos(Long kyUsuarioMod) {
		List<DtCapaTemasBk> dtCapaTemasBkss = new ArrayList<DtCapaTemasBk>();
		try {
			List<DtCapaTemas> dtCapaTemass = dtCapaTemasDao.getActivasDtCapaTemas();
			for (DtCapaTemas dtCapaTemas : dtCapaTemass) {
				DtCapaTemasBk dtCapaTemasBk = new DtCapaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaTemasBk, dtCapaTemas);
				completarDtCapaTemas(dtCapaTemasBk);
				setACLDtCapaTemasBk(dtCapaTemasBk, kyUsuarioMod);
				dtCapaTemasBkss.add(dtCapaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaTemasBkss;
	}

	@Override
	public List<DtCapaTemasBk> getAllDtCapaTemasActivosCero(Long kyUsuarioMod) {
		List<DtCapaTemasBk> dtCapaTemasBkss = new ArrayList<DtCapaTemasBk>();
		try {
			List<DtCapaTemas> dtCapaTemass = dtCapaTemasDao.getActivasDtCapaTemasCero();
			for (DtCapaTemas dtCapaTemas : dtCapaTemass) {
				DtCapaTemasBk dtCapaTemasBk = new DtCapaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaTemasBk, dtCapaTemas);
				completarDtCapaTemas(dtCapaTemasBk);
				setACLDtCapaTemasBk(dtCapaTemasBk, kyUsuarioMod);
				dtCapaTemasBkss.add(dtCapaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaTemasBkss;
	}

	private void completarDtCapaTemas(DtCapaTemasBk dtCapaTemasBk) {
		try {
			if (dtCapaTemasBk.getIdCapacitacion() != null && dtCapaTemasBk.getIdCapacitacion().longValue() > 0) {
				DtCapacitacion dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapaTemasBk.getIdCapacitacion());
				if (dtCapacitacion != null)
					dtCapaTemasBk.setIdCapacitacionTxt(dtCapacitacion.getNomEvento());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaTemasBk.getIdTema() != null && dtCapaTemasBk.getIdTema().longValue() > 0) {
				MsTema msTema = msTemaDao.getMsTema(dtCapaTemasBk.getIdTema());
				if (msTema != null)
					dtCapaTemasBk.setIdTemaTxt(msTema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaTemasBk.getIdSubtema() != null && dtCapaTemasBk.getIdSubtema().longValue() > 0) {
				MsSubtema msSubtema = msSubtemaDao.getMsSubtema(dtCapaTemasBk.getIdSubtema());
				if (msSubtema != null)
					dtCapaTemasBk.setIdSubtemaTxt(msSubtema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtCapaTemasBk.getEstado()!=null &&
		// dtCapaTemasBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtCapaTemasBk.getEstado());
		// if(prtParametros!=null)
		// dtCapaTemasBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtCapaTemasBk.getIdUsuinterno() != null && dtCapaTemasBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtCapaTemasBk.getIdUsuinterno());
				if (msUsuarios != null)
					dtCapaTemasBk.setIdUsuinternoTxt(msUsuarios.getNombres());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaTemasBk.getIdSistAdmi() != null && dtCapaTemasBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtCapaTemasBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					dtCapaTemasBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtCapaTemasBk saveorupdateDtCapaTemasBk(DtCapaTemasBk dtCapaTemasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtCapaTemasMng.validarDtCapaTemasBk(dtCapaTemasBk);

		DtCapaTemas dtCapaTemas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapaTemasBk.getIdCapaTemAgen() != null && dtCapaTemasBk.getIdCapaTemAgen().longValue() > 0) {

				dtCapaTemas = dtCapaTemasDao.getDtCapaTemas(dtCapaTemasBk.getIdCapaTemAgen());

				boolean cambios = AuditoriaDtCapaTemasMng.auditarCambiosDtCapaTemas(dtCapaTemasBk, dtCapaTemas,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapaTemas.setRtmaddressrst(rmtaddress);
					dtCapaTemas.setIdusserModif(kyUsuarioMod);
					dtCapaTemas.setFechaModif(hoy);
					dtCapaTemasDao.updateDtCapaTemas(dtCapaTemas);
				}
			} else {
				dtCapaTemasBk.setRtmaddress(rmtaddress);
				dtCapaTemasBk.setRtmaddressrst(rmtaddress);

				dtCapaTemasBk.setFechaCrea(hoy);
				dtCapaTemasBk.setIdusserCrea(kyUsuarioMod);
				dtCapaTemasBk.setIdusserModif(kyUsuarioMod);
				dtCapaTemasBk.setFechaModif(hoy);
				dtCapaTemasBk.setEstado(Estado.ACTIVO.getValor());

				dtCapaTemas = new DtCapaTemas();

				FuncionesStaticas.copyPropertiesObject(dtCapaTemas, dtCapaTemasBk);
				dtCapaTemasDao.saveDtCapaTemas(dtCapaTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapaTemas" + " :: " + dtCapaTemas.getIdCapaTemAgen().toString() + " :: "
								+ "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtCapaTemasBk = getDtCapaTemasBkXid(dtCapaTemas.getIdCapaTemAgen(), kyUsuarioMod);
		return dtCapaTemasBk;
	}

	@Override
	public void deleteDtCapaTemas(DtCapaTemasBk dtCapaTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapaTemas dtCapaTemas = null;
			if (dtCapaTemasBk.getIdCapaTemAgen() != null && dtCapaTemasBk.getIdCapaTemAgen().longValue() > 0) {

				dtCapaTemas = dtCapaTemasDao.getDtCapaTemas(dtCapaTemasBk.getIdCapaTemAgen());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaTemas.setRtmaddressrst(rmtaddress);
				dtCapaTemas.setIdusserModif(kyUsuarioMod);
				dtCapaTemas.setFechaModif(hoy);
				Long estadoanterior = dtCapaTemas.getEstado();
				dtCapaTemas.setEstado(Estado.ELIMINADO.getValor());

				dtCapaTemasDao.updateDtCapaTemas(dtCapaTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaTemas" + " :: " + dtCapaTemas.getIdCapaTemAgen().toString() + " :: "
								+ estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCapaTemas(DtCapaTemasBk dtCapaTemasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtCapaTemas dtCapaTemas = null;
			if (dtCapaTemasBk.getIdCapaTemAgen() != null && dtCapaTemasBk.getIdCapaTemAgen().longValue() > 0) {

				dtCapaTemas = dtCapaTemasDao.getDtCapaTemas(dtCapaTemasBk.getIdCapaTemAgen());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaTemas.setRtmaddressrst(rmtaddress);
				dtCapaTemas.setIdusserModif(kyUsuarioMod);
				dtCapaTemas.setFechaModif(hoy);
				Long estadoanterior = dtCapaTemas.getEstado();
				dtCapaTemas.setEstado(Estado.ACTIVO.getValor());

				dtCapaTemasDao.updateDtCapaTemas(dtCapaTemas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtCapaTemas" + " :: " + dtCapaTemas.getIdCapaTemAgen().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCapaTemasBk> getDtCapaTemasXFiltro(Long idCapacitacion, Long idTema, Long idSubtema,
			Long kyUsuarioMod) {
		List<DtCapaTemasBk> dtCapaTemasBkss = new ArrayList<DtCapaTemasBk>();
		try {
			List<DtCapaTemas> dtCapaTemassss = dtCapaTemasDao.getXFiltro(idCapacitacion, idTema, idSubtema);
			for (DtCapaTemas dtCapaTemas : dtCapaTemassss) {
				DtCapaTemasBk dtCapaTemasBk = new DtCapaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaTemasBk, dtCapaTemas);
				completarDtCapaTemas(dtCapaTemasBk);
				setACLDtCapaTemasBk(dtCapaTemasBk, kyUsuarioMod);
				dtCapaTemasBkss.add(dtCapaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaTemasBkss;
	}

	@Override
	public List<DtCapaTemasBk> getDtCapaTemasXFiltro(Long idCapacitacion, Long idTema, Long idSubtema, int inicial,
			int MAX, Long kyUsuarioMod) {
		List<DtCapaTemasBk> dtCapaTemasBkss = new ArrayList<DtCapaTemasBk>();
		try {
			List<DtCapaTemas> dtCapaTemassss = dtCapaTemasDao.getXFiltro(idCapacitacion, idTema, idSubtema, inicial,
					MAX);
			for (DtCapaTemas dtCapaTemas : dtCapaTemassss) {
				DtCapaTemasBk dtCapaTemasBk = new DtCapaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaTemasBk, dtCapaTemas);
				completarDtCapaTemas(dtCapaTemasBk);
				setACLDtCapaTemasBk(dtCapaTemasBk, kyUsuarioMod);
				dtCapaTemasBkss.add(dtCapaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaTemasBkss;
	}

	@Override
	public Long getDtCapaTemasTotalXFiltro(Long idCapacitacion, Long idTema, Long idSubtema, Long kyUsuarioMod) {
		try {
			Long totalDtCapaTemassss = dtCapaTemasDao.getTotalXFiltro(idCapacitacion, idTema, idSubtema);

			return totalDtCapaTemassss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCapaTemasBk(DtCapaTemasBk dtCapaTemasBk, Long kyUsuarioMod) {
		DtCapaTemasACL dtCapaTemasACL = new DtCapaTemasACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPATEMAS_CREA)) {
					dtCapaTemasACL.setEsEditable(true);
					dtCapaTemasACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCAPATEMAS_VE)) {
					dtCapaTemasACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPATEMAS_CREA)) {
					dtCapaTemasACL.setEditopcion(1);
				} else {
					dtCapaTemasACL.setEditopcion(2);
				}
			} else {
				dtCapaTemasACL.setEditopcion(2);
			}
		} else {
			dtCapaTemasACL.setEditopcion(2);
		}
		dtCapaTemasBk.setDtCapaTemasACL(dtCapaTemasACL);
	}

	/// ADICIONALES

	/**
	 * DT_ENTIDAD_SEDES SERVICIO: LISTA DE LAS DISTINTAS SEDES ASIGNADAS A LA
	 * ENTIDAD
	 */
	@Override
	public DtEntidadSedesBk getDtEntidadSedesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtEntidadSedes dtEntidadSedes = dtEntidadSedesDao.getDtEntidadSedes(id);
		DtEntidadSedesBk dtEntidadSedesBk = null;
		if (dtEntidadSedes != null) {
			dtEntidadSedesBk = new DtEntidadSedesBk();
			FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedes);
			completarDtEntidadSedes(dtEntidadSedesBk);
			if (kyUsuarioMod != null)
				setACLDtEntidadSedesBk(dtEntidadSedesBk, kyUsuarioMod);
		}
		return dtEntidadSedesBk;
	}

	@Override
	public List<DtEntidadSedesBk> getAllDtEntidadSedesActivos(Long kyUsuarioMod) {
		List<DtEntidadSedesBk> dtEntidadSedesBkss = new ArrayList<DtEntidadSedesBk>();
		try {
			List<DtEntidadSedes> dtEntidadSedess = dtEntidadSedesDao.getActivasDtEntidadSedes();
			for (DtEntidadSedes dtEntidadSedes : dtEntidadSedess) {
				DtEntidadSedesBk dtEntidadSedesBk = new DtEntidadSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedes);
				completarDtEntidadSedes(dtEntidadSedesBk);
				setACLDtEntidadSedesBk(dtEntidadSedesBk, kyUsuarioMod);
				dtEntidadSedesBkss.add(dtEntidadSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSedesBkss;
	}

	@Override
	public List<DtEntidadSedesBk> getAllDtEntidadSedesActivosCero(Long kyUsuarioMod) {
		List<DtEntidadSedesBk> dtEntidadSedesBkss = new ArrayList<DtEntidadSedesBk>();
		try {
			List<DtEntidadSedes> dtEntidadSedess = dtEntidadSedesDao.getActivasDtEntidadSedesCero();
			for (DtEntidadSedes dtEntidadSedes : dtEntidadSedess) {
				DtEntidadSedesBk dtEntidadSedesBk = new DtEntidadSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedes);
				completarDtEntidadSedes(dtEntidadSedesBk);
				setACLDtEntidadSedesBk(dtEntidadSedesBk, kyUsuarioMod);
				dtEntidadSedesBkss.add(dtEntidadSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSedesBkss;
	}

	private void completarDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk) {
		// try{
		// if(dtEntidadSedesBk.getEstado()!=null &&
		// dtEntidadSedesBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEntidadSedesBk.getEstado());
		// if(prtParametros!=null)
		// dtEntidadSedesBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtEntidadSedesBk.getIdEntidad() != null && dtEntidadSedesBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtEntidadSedesBk.getIdEntidad());
				if (dtEntidades != null)
					dtEntidadSedesBk.setIdEntidadTxt(dtEntidades.getRazSocial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEntidadSedesBk.getIdSede() != null && dtEntidadSedesBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtEntidadSedesBk.getIdSede());
				if (msSedes != null)
					dtEntidadSedesBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtEntidadSedesBk saveorupdateDtEntidadSedesBk(DtEntidadSedesBk dtEntidadSedesBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtEntidadSedesMng.validarDtEntidadSedesBk(dtEntidadSedesBk);

		DtEntidadSedes dtEntidadSedes = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtEntidadSedesBk.getIdEntiSed() != null && dtEntidadSedesBk.getIdEntiSed().longValue() > 0) {

				dtEntidadSedes = dtEntidadSedesDao.getDtEntidadSedes(dtEntidadSedesBk.getIdEntiSed());

				boolean cambios = AuditoriaDtEntidadSedesMng.auditarCambiosDtEntidadSedes(dtEntidadSedesBk,
						dtEntidadSedes, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtEntidadSedes.setRtmaddressrst(rmtaddress);
					dtEntidadSedes.setIdusserModif(kyUsuarioMod);
					dtEntidadSedes.setFechaModif(hoy);
					dtEntidadSedesDao.updateDtEntidadSedes(dtEntidadSedes);
				}
			} else {
				dtEntidadSedesBk.setRtmaddress(rmtaddress);
				dtEntidadSedesBk.setRtmaddressrst(rmtaddress);

				dtEntidadSedesBk.setFechaCrea(hoy);
				dtEntidadSedesBk.setIdusserCrea(kyUsuarioMod);
				dtEntidadSedesBk.setIdusserModif(kyUsuarioMod);
				dtEntidadSedesBk.setFechaModif(hoy);
				dtEntidadSedesBk.setEstado(Estado.ACTIVO.getValor());

				dtEntidadSedes = new DtEntidadSedes();

				FuncionesStaticas.copyPropertiesObject(dtEntidadSedes, dtEntidadSedesBk);
				dtEntidadSedesDao.saveDtEntidadSedes(dtEntidadSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtEntidadSedes" + " :: " + dtEntidadSedes.getIdEntiSed().toString() + " :: "
								+ "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtEntidadSedesBk = getDtEntidadSedesBkXid(dtEntidadSedes.getIdEntiSed(), kyUsuarioMod);
		return dtEntidadSedesBk;
	}

	@Override
	public void deleteDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtEntidadSedes dtEntidadSedes = null;
			if (dtEntidadSedesBk.getIdEntiSed() != null && dtEntidadSedesBk.getIdEntiSed().longValue() > 0) {

				dtEntidadSedes = dtEntidadSedesDao.getDtEntidadSedes(dtEntidadSedesBk.getIdEntiSed());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidadSedes.setRtmaddressrst(rmtaddress);
				dtEntidadSedes.setIdusserModif(kyUsuarioMod);
				dtEntidadSedes.setFechaModif(hoy);
				Long estadoanterior = dtEntidadSedes.getEstado();
				dtEntidadSedes.setEstado(Estado.ELIMINADO.getValor());

				dtEntidadSedesDao.updateDtEntidadSedes(dtEntidadSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtEntidadSedes" + " :: " + dtEntidadSedes.getIdEntiSed().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtEntidadSedes dtEntidadSedes = null;
			if (dtEntidadSedesBk.getIdEntiSed() != null && dtEntidadSedesBk.getIdEntiSed().longValue() > 0) {

				dtEntidadSedes = dtEntidadSedesDao.getDtEntidadSedes(dtEntidadSedesBk.getIdEntiSed());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEntidadSedes.setRtmaddressrst(rmtaddress);
				dtEntidadSedes.setIdusserModif(kyUsuarioMod);
				dtEntidadSedes.setFechaModif(hoy);
				Long estadoanterior = dtEntidadSedes.getEstado();
				dtEntidadSedes.setEstado(Estado.ACTIVO.getValor());

				dtEntidadSedesDao.updateDtEntidadSedes(dtEntidadSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtEntidadSedes" + " :: " + dtEntidadSedes.getIdEntiSed().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtEntidadSedesBk> getDtEntidadSedesXFiltro(Long idEntidad, Long idSede, Long kyUsuarioMod) {
		List<DtEntidadSedesBk> dtEntidadSedesBkss = new ArrayList<DtEntidadSedesBk>();
		try {
			List<DtEntidadSedes> dtEntidadSedessss = dtEntidadSedesDao.getXFiltro(idEntidad, idSede);
			for (DtEntidadSedes dtEntidadSedes : dtEntidadSedessss) {
				DtEntidadSedesBk dtEntidadSedesBk = new DtEntidadSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedes);
				completarDtEntidadSedes(dtEntidadSedesBk);
				setACLDtEntidadSedesBk(dtEntidadSedesBk, kyUsuarioMod);
				dtEntidadSedesBkss.add(dtEntidadSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSedesBkss;
	}

	@Override
	public List<DtEntidadSedesBk> getDtEntidadSedesXFiltro(Long idEntidad, Long idSede, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtEntidadSedesBk> dtEntidadSedesBkss = new ArrayList<DtEntidadSedesBk>();
		try {
			List<DtEntidadSedes> dtEntidadSedessss = dtEntidadSedesDao.getXFiltro(idEntidad, idSede, inicial, MAX);
			for (DtEntidadSedes dtEntidadSedes : dtEntidadSedessss) {
				DtEntidadSedesBk dtEntidadSedesBk = new DtEntidadSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadSedesBk, dtEntidadSedes);
				completarDtEntidadSedes(dtEntidadSedesBk);
				setACLDtEntidadSedesBk(dtEntidadSedesBk, kyUsuarioMod);
				dtEntidadSedesBkss.add(dtEntidadSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadSedesBkss;
	}

	@Override
	public Long getDtEntidadSedesTotalXFiltro(Long idEntidad, Long idSede, Long kyUsuarioMod) {
		try {
			Long totalDtEntidadSedessss = dtEntidadSedesDao.getTotalXFiltro(idEntidad, idSede);

			return totalDtEntidadSedessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtEntidadSedesBk(DtEntidadSedesBk dtEntidadSedesBk, Long kyUsuarioMod) {
		DtEntidadSedesACL dtEntidadSedesACL = new DtEntidadSedesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADSEDES_CREA)) {
					dtEntidadSedesACL.setEsEditable(true);
					dtEntidadSedesACL.setEliminar(true);
				} else if (roles.contains(Roles.DTENTIDADSEDES_VE)) {
					dtEntidadSedesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADSEDES_CREA)) {
					dtEntidadSedesACL.setEditopcion(1);
				} else {
					dtEntidadSedesACL.setEditopcion(2);
				}
			} else {
				dtEntidadSedesACL.setEditopcion(2);
			}
		} else {
			dtEntidadSedesACL.setEditopcion(2);
		}
		dtEntidadSedesBk.setDtEntidadSedesACL(dtEntidadSedesACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroEstado() {
		if (prtParametrosIdparametroEstadoListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroEstadoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroEstadoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroEstadoListaCache;
	}

	/**
	 * DT_CONSULTAS SERVICIO: LISTA DE LOS DATOS REGISTRADOS EN UNA CONSULTA
	 */
	@Override
	public DtConsultasBk getDtConsultasBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtConsultas dtConsultas = dtConsultasDao.getDtConsultas(id);
		DtConsultasBk dtConsultasBk = null;
		if (dtConsultas != null) {
			dtConsultasBk = new DtConsultasBk();
			FuncionesStaticas.copyPropertiesObject(dtConsultasBk, dtConsultas);
			completarDtConsultas(dtConsultasBk);
			if (kyUsuarioMod != null)
				setACLDtConsultasBk(dtConsultasBk, kyUsuarioMod);
		}
		return dtConsultasBk;
	}

	@Override
	public List<DtConsultasBk> getAllDtConsultasActivos(Long kyUsuarioMod) {
		List<DtConsultasBk> dtConsultasBkss = new ArrayList<DtConsultasBk>();
		try {
			List<DtConsultas> dtConsultass = dtConsultasDao.getActivasDtConsultas();
			for (DtConsultas dtConsultas : dtConsultass) {
				DtConsultasBk dtConsultasBk = new DtConsultasBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasBk, dtConsultas);
				completarDtConsultas(dtConsultasBk);
				setACLDtConsultasBk(dtConsultasBk, kyUsuarioMod);
				dtConsultasBkss.add(dtConsultasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasBkss;
	}

	@Override
	public List<DtConsultasBk> getAllDtConsultasActivosCero(Long kyUsuarioMod) {
		List<DtConsultasBk> dtConsultasBkss = new ArrayList<DtConsultasBk>();
		try {
			List<DtConsultas> dtConsultass = dtConsultasDao.getActivasDtConsultasCero();
			for (DtConsultas dtConsultas : dtConsultass) {
				DtConsultasBk dtConsultasBk = new DtConsultasBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasBk, dtConsultas);
				completarDtConsultas(dtConsultasBk);
				setACLDtConsultasBk(dtConsultasBk, kyUsuarioMod);
				dtConsultasBkss.add(dtConsultasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasBkss;
	}

	private void completarDtConsultas(DtConsultasBk dtConsultasBk) {
		try {
			if (dtConsultasBk.getIdUsuexterno() != null && dtConsultasBk.getIdUsuexterno().longValue() > 0) {
				DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
						.getDtUsuarioExterno(dtConsultasBk.getIdUsuexterno());
				if (dtUsuarioExterno != null) {
					dtConsultasBk.setIdUsuexternoTxt(dtUsuarioExterno.getNombre());
					dtConsultasBk.setNombre(dtUsuarioExterno.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdSistAdm() != null && dtConsultasBk.getIdSistAdm().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtConsultasBk.getIdSistAdm());
				if (msSisAdmistrativo != null)
					dtConsultasBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdTema() != null && dtConsultasBk.getIdTema().longValue() > 0) {
				MsTema msTema = msTemaDao.getMsTema(dtConsultasBk.getIdTema());
				if (msTema != null)
					dtConsultasBk.setIdTemaTxt(msTema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdSubtema() != null && dtConsultasBk.getIdSubtema().longValue() > 0) {
				MsSubtema msSubtema = msSubtemaDao.getMsSubtema(dtConsultasBk.getIdSubtema());
				if (msSubtema != null)
					dtConsultasBk.setIdSubtemaTxt(msSubtema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtConsultasBk.getEstado()!=null &&
		// dtConsultasBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtConsultasBk.getEstado());
		// if(prtParametros!=null)
		// dtConsultasBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtConsultasBk.getIdPrestservic() != null && dtConsultasBk.getIdPrestservic().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtConsultasBk.getIdPrestservic());
				if (prtParametros != null)
					dtConsultasBk.setIdPrestservicTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdModalidad() != null && dtConsultasBk.getIdModalidad().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtConsultasBk.getIdModalidad());
				if (prtParametros != null)
					dtConsultasBk.setIdModalidadTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdUsuinterno() != null && dtConsultasBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtConsultasBk.getIdUsuinterno());
				if (msUsuarios != null)
					dtConsultasBk.setIdUsuinternoTxt(msUsuarios.getNombres());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdEntidad() != null && dtConsultasBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtConsultasBk.getIdEntidad());
				if (dtEntidades != null) {
					dtConsultasBk.setIdEntidadTxt(dtEntidades.getRazSocial());
					dtConsultasBk.setRazSocial(dtEntidades.getRazSocial());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdOrigen() != null && dtConsultasBk.getIdOrigen().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtConsultasBk.getIdOrigen());
				if (prtParametros != null)
					dtConsultasBk.setIdOrigenTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdCargo() != null && dtConsultasBk.getIdCargo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtConsultasBk.getIdCargo());
				if (prtParametros != null)
					dtConsultasBk.setIdCargoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtConsultasBk.getIdSede() != null && dtConsultasBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtConsultasBk.getIdSede());
				if (msSedes != null)
					dtConsultasBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtConsultasBk saveorupdateDtConsultasBk(DtConsultasBk dtConsultasBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtConsultasMng.validarDtConsultasBk(dtConsultasBk);

		DtConsultas dtConsultas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtConsultasBk.getIdConsulta() != null && dtConsultasBk.getIdConsulta().longValue() > 0) {

				dtConsultas = dtConsultasDao.getDtConsultas(dtConsultasBk.getIdConsulta());

				boolean cambios = AuditoriaDtConsultasMng.auditarCambiosDtConsultas(dtConsultasBk, dtConsultas,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtConsultas.setRtmaddressrst(rmtaddress);
					dtConsultas.setIdusserModif(kyUsuarioMod);
					dtConsultas.setFechaModif(hoy);
					dtConsultasDao.updateDtConsultas(dtConsultas);
				}
			} else {
				dtConsultasBk.setRtmaddress(rmtaddress);
				dtConsultasBk.setRtmaddressrst(rmtaddress);

				dtConsultasBk.setFechaCrea(hoy);
				dtConsultasBk.setIdusserCrea(kyUsuarioMod);
				dtConsultasBk.setIdusserModif(kyUsuarioMod);
				dtConsultasBk.setFechaModif(hoy);
				dtConsultasBk.setEstado(Estado.ACTIVO.getValor());

				dtConsultas = new DtConsultas();

				FuncionesStaticas.copyPropertiesObject(dtConsultas, dtConsultasBk);
				dtConsultasDao.saveDtConsultas(dtConsultas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtConsultas" + " :: " + dtConsultas.getIdConsulta().toString() + " :: " + "0"
								+ " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtConsultasBk = getDtConsultasBkXid(dtConsultas.getIdConsulta(), kyUsuarioMod);
		return dtConsultasBk;
	}

	@Override
	public void deleteDtConsultas(DtConsultasBk dtConsultasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtConsultas dtConsultas = null;
			if (dtConsultasBk.getIdConsulta() != null && dtConsultasBk.getIdConsulta().longValue() > 0) {

				dtConsultas = dtConsultasDao.getDtConsultas(dtConsultasBk.getIdConsulta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtConsultas.setRtmaddressrst(rmtaddress);
				dtConsultas.setIdusserModif(kyUsuarioMod);
				dtConsultas.setFechaModif(hoy);
				Long estadoanterior = dtConsultas.getEstado();
				dtConsultas.setEstado(Estado.ELIMINADO.getValor());

				dtConsultasDao.updateDtConsultas(dtConsultas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtConsultas" + " :: " + dtConsultas.getIdConsulta().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtConsultas(DtConsultasBk dtConsultasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtConsultas dtConsultas = null;
			if (dtConsultasBk.getIdConsulta() != null && dtConsultasBk.getIdConsulta().longValue() > 0) {

				dtConsultas = dtConsultasDao.getDtConsultas(dtConsultasBk.getIdConsulta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtConsultas.setRtmaddressrst(rmtaddress);
				dtConsultas.setIdusserModif(kyUsuarioMod);
				dtConsultas.setFechaModif(hoy);
				Long estadoanterior = dtConsultas.getEstado();
				dtConsultas.setEstado(Estado.ACTIVO.getValor());

				dtConsultasDao.updateDtConsultas(dtConsultas);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtConsultas" + " :: " + dtConsultas.getIdConsulta().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtConsultasBk> getDtConsultasXFiltro(Timestamp fechaConsu, Long idUsuexterno, Long idSistAdm,
			Long idTema, Long idSubtema, Long estado, Long kyUsuarioMod) {
		List<DtConsultasBk> dtConsultasBkss = new ArrayList<DtConsultasBk>();
		try {
			List<DtConsultas> dtConsultassss = dtConsultasDao.getXFiltro(fechaConsu, idUsuexterno, idSistAdm, idTema,
					idSubtema, estado);
			for (DtConsultas dtConsultas : dtConsultassss) {
				DtConsultasBk dtConsultasBk = new DtConsultasBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasBk, dtConsultas);
				completarDtConsultas(dtConsultasBk);
				setACLDtConsultasBk(dtConsultasBk, kyUsuarioMod);
				dtConsultasBkss.add(dtConsultasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasBkss;
	}

	@Override
	public List<DtConsultasBk> getDtConsultasXFiltro(Timestamp fechaConsu, Long idUsuexterno, Long idSistAdm,
			Long idTema, Long idSubtema, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtConsultasBk> dtConsultasBkss = new ArrayList<DtConsultasBk>();
		try {
			List<DtConsultas> dtConsultassss = dtConsultasDao.getXFiltro(fechaConsu, idUsuexterno, idSistAdm, idTema,
					idSubtema, estado, inicial, MAX);
			for (DtConsultas dtConsultas : dtConsultassss) {
				DtConsultasBk dtConsultasBk = new DtConsultasBk();
				FuncionesStaticas.copyPropertiesObject(dtConsultasBk, dtConsultas);
				completarDtConsultas(dtConsultasBk);
				setACLDtConsultasBk(dtConsultasBk, kyUsuarioMod);
				dtConsultasBkss.add(dtConsultasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtConsultasBkss;
	}

	@Override
	public Long getDtConsultasTotalXFiltro(Timestamp fechaConsu, Long idUsuexterno, Long idSistAdm, Long idTema,
			Long idSubtema, Long estado, Long kyUsuarioMod) {
		try {
			Long totalDtConsultassss = dtConsultasDao.getTotalXFiltro(fechaConsu, idUsuexterno, idSistAdm, idTema,
					idSubtema, estado);

			return totalDtConsultassss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtConsultasBk(DtConsultasBk dtConsultasBk, Long kyUsuarioMod) {
		DtConsultasACL dtConsultasACL = new DtConsultasACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCONSULTAS_CREA)) {
					dtConsultasACL.setEsEditable(true);
					dtConsultasACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCONSULTAS_VE)) {
					dtConsultasACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCONSULTAS_CREA)) {
					dtConsultasACL.setEditopcion(1);
				} else {
					dtConsultasACL.setEditopcion(2);
				}
			} else {
				dtConsultasACL.setEditopcion(2);
			}
		} else {
			dtConsultasACL.setEditopcion(2);
		}
		dtConsultasBk.setDtConsultasACL(dtConsultasACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdPrestservic() {
		if (prtParametrosIdparametroIdPrestservicListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdPrestservicListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdPrestservicListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdPrestservicListaCache;
	}

	/**
	 * DT_VISITAS_PROYECTO SERVICIO: LISTA DE LOS DISTINTOS PROYECTOS DE
	 * INVERSIÓN RELACIONADOS A LAS VISITAS
	 */
	@Override
	public DtVisitasProyectoBk getDtVisitasProyectoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtVisitasProyecto dtVisitasProyecto = dtVisitasProyectoDao.getDtVisitasProyecto(id);
		DtVisitasProyectoBk dtVisitasProyectoBk = null;
		if (dtVisitasProyecto != null) {
			dtVisitasProyectoBk = new DtVisitasProyectoBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasProyectoBk, dtVisitasProyecto);
			completarDtVisitasProyecto(dtVisitasProyectoBk);
			if (kyUsuarioMod != null)
				setACLDtVisitasProyectoBk(dtVisitasProyectoBk, kyUsuarioMod);
		}
		return dtVisitasProyectoBk;
	}

	@Override
	public List<DtVisitasProyectoBk> getAllDtVisitasProyectoActivos(Long kyUsuarioMod) {
		List<DtVisitasProyectoBk> dtVisitasProyectoBkss = new ArrayList<DtVisitasProyectoBk>();
		try {
			List<DtVisitasProyecto> dtVisitasProyectos = dtVisitasProyectoDao.getActivasDtVisitasProyecto();
			for (DtVisitasProyecto dtVisitasProyecto : dtVisitasProyectos) {
				DtVisitasProyectoBk dtVisitasProyectoBk = new DtVisitasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasProyectoBk, dtVisitasProyecto);
				completarDtVisitasProyecto(dtVisitasProyectoBk);
				setACLDtVisitasProyectoBk(dtVisitasProyectoBk, kyUsuarioMod);
				dtVisitasProyectoBkss.add(dtVisitasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasProyectoBkss;
	}

	@Override
	public List<DtVisitasProyectoBk> getAllDtVisitasProyectoActivosCero(Long kyUsuarioMod) {
		List<DtVisitasProyectoBk> dtVisitasProyectoBkss = new ArrayList<DtVisitasProyectoBk>();
		try {
			List<DtVisitasProyecto> dtVisitasProyectos = dtVisitasProyectoDao.getActivasDtVisitasProyectoCero();
			for (DtVisitasProyecto dtVisitasProyecto : dtVisitasProyectos) {
				DtVisitasProyectoBk dtVisitasProyectoBk = new DtVisitasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasProyectoBk, dtVisitasProyecto);
				completarDtVisitasProyecto(dtVisitasProyectoBk);
				setACLDtVisitasProyectoBk(dtVisitasProyectoBk, kyUsuarioMod);
				dtVisitasProyectoBkss.add(dtVisitasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasProyectoBkss;
	}

	private void completarDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk) {
		try {
			if (dtVisitasProyectoBk.getIdVisita() != null && dtVisitasProyectoBk.getIdVisita().longValue() > 0) {
				DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasProyectoBk.getIdVisita());
				if (dtVisitas != null)
					dtVisitasProyectoBk.setIdVisitaTxt(dtVisitas.getConclusion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasProyectoBk.getIdProyecto() != null && dtVisitasProyectoBk.getIdProyecto().longValue() > 0) {
				MsProyectoInversion msProyectoInversion = msProyectoInversionDao
						.getMsProyectoInversion(dtVisitasProyectoBk.getIdProyecto());
				if (msProyectoInversion != null) {
					dtVisitasProyectoBk.setIdProyectoTxt(msProyectoInversion.getNombre());
					dtVisitasProyectoBk.setNombre(msProyectoInversion.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtVisitasProyectoBk saveorupdateDtVisitasProyectoBk(DtVisitasProyectoBk dtVisitasProyectoBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtVisitasProyectoMng.validarDtVisitasProyectoBk(dtVisitasProyectoBk);

		DtVisitasProyecto dtVisitasProyecto = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasProyectoBk.getIdVisitaProyecto() != null
					&& dtVisitasProyectoBk.getIdVisitaProyecto().longValue() > 0) {

				dtVisitasProyecto = dtVisitasProyectoDao
						.getDtVisitasProyecto(dtVisitasProyectoBk.getIdVisitaProyecto());

				boolean cambios = AuditoriaDtVisitasProyectoMng.auditarCambiosDtVisitasProyecto(dtVisitasProyectoBk,
						dtVisitasProyecto, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtVisitasProyecto.setRtmaddressrst(rmtaddress);
					dtVisitasProyecto.setIdusserModif(kyUsuarioMod);
					dtVisitasProyecto.setFechaModif(hoy);
					dtVisitasProyectoDao.updateDtVisitasProyecto(dtVisitasProyecto);
				}
			} else {
				dtVisitasProyectoBk.setRtmaddress(rmtaddress);
				dtVisitasProyectoBk.setRtmaddressrst(rmtaddress);

				dtVisitasProyectoBk.setFechaCrea(hoy);
				dtVisitasProyectoBk.setIdusserCrea(kyUsuarioMod);
				dtVisitasProyectoBk.setIdusserModif(kyUsuarioMod);
				dtVisitasProyectoBk.setFechaModif(hoy);
				dtVisitasProyectoBk.setEstado(Estado.ACTIVO.getValor());

				dtVisitasProyecto = new DtVisitasProyecto();

				FuncionesStaticas.copyPropertiesObject(dtVisitasProyecto, dtVisitasProyectoBk);
				dtVisitasProyectoDao.saveDtVisitasProyecto(dtVisitasProyecto);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtVisitasProyecto" + " :: "
								+ dtVisitasProyecto.getIdVisitaProyecto().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtVisitasProyectoBk = getDtVisitasProyectoBkXid(dtVisitasProyecto.getIdVisitaProyecto(), kyUsuarioMod);
		return dtVisitasProyectoBk;
	}

	@Override
	public void deleteDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtVisitasProyecto dtVisitasProyecto = null;
			if (dtVisitasProyectoBk.getIdVisitaProyecto() != null
					&& dtVisitasProyectoBk.getIdVisitaProyecto().longValue() > 0) {

				dtVisitasProyecto = dtVisitasProyectoDao
						.getDtVisitasProyecto(dtVisitasProyectoBk.getIdVisitaProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasProyecto.setRtmaddressrst(rmtaddress);
				dtVisitasProyecto.setIdusserModif(kyUsuarioMod);
				dtVisitasProyecto.setFechaModif(hoy);
				Long estadoanterior = dtVisitasProyecto.getEstado();
				dtVisitasProyecto.setEstado(Estado.ELIMINADO.getValor());

				dtVisitasProyectoDao.updateDtVisitasProyecto(dtVisitasProyecto);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtVisitasProyecto" + " :: " + dtVisitasProyecto.getIdVisitaProyecto().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtVisitasProyecto dtVisitasProyecto = null;
			if (dtVisitasProyectoBk.getIdVisitaProyecto() != null
					&& dtVisitasProyectoBk.getIdVisitaProyecto().longValue() > 0) {

				dtVisitasProyecto = dtVisitasProyectoDao
						.getDtVisitasProyecto(dtVisitasProyectoBk.getIdVisitaProyecto());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasProyecto.setRtmaddressrst(rmtaddress);
				dtVisitasProyecto.setIdusserModif(kyUsuarioMod);
				dtVisitasProyecto.setFechaModif(hoy);
				Long estadoanterior = dtVisitasProyecto.getEstado();
				dtVisitasProyecto.setEstado(Estado.ACTIVO.getValor());

				dtVisitasProyectoDao.updateDtVisitasProyecto(dtVisitasProyecto);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtVisitasProyecto" + " :: " + dtVisitasProyecto.getIdVisitaProyecto().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtVisitasProyectoBk> getDtVisitasProyectoXFiltro(Long idVisita, Long idProyecto, String detalle,
			Long kyUsuarioMod) {
		List<DtVisitasProyectoBk> dtVisitasProyectoBkss = new ArrayList<DtVisitasProyectoBk>();
		try {
			List<DtVisitasProyecto> dtVisitasProyectosss = dtVisitasProyectoDao.getXFiltro(idVisita, idProyecto,
					detalle);
			for (DtVisitasProyecto dtVisitasProyecto : dtVisitasProyectosss) {
				DtVisitasProyectoBk dtVisitasProyectoBk = new DtVisitasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasProyectoBk, dtVisitasProyecto);
				completarDtVisitasProyecto(dtVisitasProyectoBk);
				setACLDtVisitasProyectoBk(dtVisitasProyectoBk, kyUsuarioMod);
				dtVisitasProyectoBkss.add(dtVisitasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasProyectoBkss;
	}

	@Override
	public List<DtVisitasProyectoBk> getDtVisitasProyectoXFiltro(Long idVisita, Long idProyecto, String detalle,
			int inicial, int MAX, Long kyUsuarioMod) {
		List<DtVisitasProyectoBk> dtVisitasProyectoBkss = new ArrayList<DtVisitasProyectoBk>();
		try {
			List<DtVisitasProyecto> dtVisitasProyectosss = dtVisitasProyectoDao.getXFiltro(idVisita, idProyecto,
					detalle, inicial, MAX);
			for (DtVisitasProyecto dtVisitasProyecto : dtVisitasProyectosss) {
				DtVisitasProyectoBk dtVisitasProyectoBk = new DtVisitasProyectoBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasProyectoBk, dtVisitasProyecto);
				completarDtVisitasProyecto(dtVisitasProyectoBk);
				setACLDtVisitasProyectoBk(dtVisitasProyectoBk, kyUsuarioMod);
				dtVisitasProyectoBkss.add(dtVisitasProyectoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasProyectoBkss;
	}

	@Override
	public Long getDtVisitasProyectoTotalXFiltro(Long idVisita, Long idProyecto, String detalle, Long kyUsuarioMod) {
		try {
			Long totalDtVisitasProyectosss = dtVisitasProyectoDao.getTotalXFiltro(idVisita, idProyecto, detalle);

			return totalDtVisitasProyectosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtVisitasProyectoBk(DtVisitasProyectoBk dtVisitasProyectoBk, Long kyUsuarioMod) {
		DtVisitasProyectoACL dtVisitasProyectoACL = new DtVisitasProyectoACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASPROYECTO_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
					// PURIBE 22032024 - FIN
					dtVisitasProyectoACL.setEsEditable(true);
					dtVisitasProyectoACL.setEliminar(true);
				} else if (roles.contains(Roles.DTVISITASPROYECTO_VE)) {
					dtVisitasProyectoACL.setEsEditable(true);
				}
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASPROYECTO_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
					// PURIBE 22032024 - FIN--
					dtVisitasProyectoACL.setEditopcion(1);
				} else {
					dtVisitasProyectoACL.setEditopcion(2);
				}
			} else {
				dtVisitasProyectoACL.setEditopcion(2);
			}
		} else {
			dtVisitasProyectoACL.setEditopcion(2);
		}
		dtVisitasProyectoBk.setDtVisitasProyectoACL(dtVisitasProyectoACL);
	}

	/// ADICIONALES

	/**
	 * DT_CAPA_USUEXTERNOS SERVICIO: LISTA DE LOS PARTICIPANTES QUE ASISTEN A LA
	 * CAPACITACIÓN
	 */
	@Override
	public DtCapaUsuexternosBk getDtCapaUsuexternosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCapaUsuexternos dtCapaUsuexternos = dtCapaUsuexternosDao.getDtCapaUsuexternos(id);
		DtCapaUsuexternosBk dtCapaUsuexternosBk = null;
		if (dtCapaUsuexternos != null) {
			dtCapaUsuexternosBk = new DtCapaUsuexternosBk();
			FuncionesStaticas.copyPropertiesObject(dtCapaUsuexternosBk, dtCapaUsuexternos);
			completarDtCapaUsuexternos(dtCapaUsuexternosBk);
			if (kyUsuarioMod != null)
				setACLDtCapaUsuexternosBk(dtCapaUsuexternosBk, kyUsuarioMod);
		}
		return dtCapaUsuexternosBk;
	}

	@Override
	public List<DtCapaUsuexternosBk> getAllDtCapaUsuexternosActivos(Long kyUsuarioMod) {
		List<DtCapaUsuexternosBk> dtCapaUsuexternosBkss = new ArrayList<DtCapaUsuexternosBk>();
		try {
			List<DtCapaUsuexternos> dtCapaUsuexternoss = dtCapaUsuexternosDao.getActivasDtCapaUsuexternos();
			for (DtCapaUsuexternos dtCapaUsuexternos : dtCapaUsuexternoss) {
				DtCapaUsuexternosBk dtCapaUsuexternosBk = new DtCapaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaUsuexternosBk, dtCapaUsuexternos);
				completarDtCapaUsuexternos(dtCapaUsuexternosBk);
				setACLDtCapaUsuexternosBk(dtCapaUsuexternosBk, kyUsuarioMod);
				dtCapaUsuexternosBkss.add(dtCapaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaUsuexternosBkss;
	}

	@Override
	public List<DtCapaUsuexternosBk> getAllDtCapaUsuexternosActivosCero(Long kyUsuarioMod) {
		List<DtCapaUsuexternosBk> dtCapaUsuexternosBkss = new ArrayList<DtCapaUsuexternosBk>();
		try {
			List<DtCapaUsuexternos> dtCapaUsuexternoss = dtCapaUsuexternosDao.getActivasDtCapaUsuexternosCero();
			for (DtCapaUsuexternos dtCapaUsuexternos : dtCapaUsuexternoss) {
				DtCapaUsuexternosBk dtCapaUsuexternosBk = new DtCapaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaUsuexternosBk, dtCapaUsuexternos);
				completarDtCapaUsuexternos(dtCapaUsuexternosBk);
				setACLDtCapaUsuexternosBk(dtCapaUsuexternosBk, kyUsuarioMod);
				dtCapaUsuexternosBkss.add(dtCapaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaUsuexternosBkss;
	}

	private void completarDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk) {
		try {
			if (dtCapaUsuexternosBk.getIdCapacitacion() != null
					&& dtCapaUsuexternosBk.getIdCapacitacion().longValue() > 0) {
				DtCapacitacion dtCapacitacion = dtCapacitacionDao
						.getDtCapacitacion(dtCapaUsuexternosBk.getIdCapacitacion());
				if (dtCapacitacion != null)
					dtCapaUsuexternosBk.setIdCapacitacionTxt(dtCapacitacion.getNomEvento());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtCapaUsuexternosBk.getEstado()!=null &&
		// dtCapaUsuexternosBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtCapaUsuexternosBk.getEstado());
		// if(prtParametros!=null)
		// dtCapaUsuexternosBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtCapaUsuexternosBk.getIdUsuexterno() != null
					&& dtCapaUsuexternosBk.getIdUsuexterno().longValue() > 0) {
				DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
						.getDtUsuarioExterno(dtCapaUsuexternosBk.getIdUsuexterno());
				if (dtUsuarioExterno != null) {
					dtCapaUsuexternosBk.setIdUsuexternoTxt(dtUsuarioExterno.getNombre());
					dtCapaUsuexternosBk.setNombre(dtUsuarioExterno.getNombre());
					dtCapaUsuexternosBk.setaPaterno(dtUsuarioExterno.getApaterno());
					dtCapaUsuexternosBk.setaMaterno(dtUsuarioExterno.getAmaterno());
					dtCapaUsuexternosBk.setNumDocu(dtUsuarioExterno.getNumDocum());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaUsuexternosBk.getIdCargoUsuext() != null
					&& dtCapaUsuexternosBk.getIdCargoUsuext().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCapaUsuexternosBk.getIdCargoUsuext());
				if (prtParametros != null)
					dtCapaUsuexternosBk.setIdCargoUsuextTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtCapaUsuexternosBk.getIdEntidad() != null && dtCapaUsuexternosBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtCapaUsuexternosBk.getIdEntidad());
				if (dtEntidades != null)
					dtCapaUsuexternosBk.setIdEntidadTxt(dtEntidades.getRazSocial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtCapaUsuexternosBk saveorupdateDtCapaUsuexternosBk(DtCapaUsuexternosBk dtCapaUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtCapaUsuexternosMng.validarDtCapaUsuexternosBk(dtCapaUsuexternosBk);

		DtCapaUsuexternos dtCapaUsuexternos = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCapaUsuexternosBk.getIdCapaUsuext() != null
					&& dtCapaUsuexternosBk.getIdCapaUsuext().longValue() > 0) {

				dtCapaUsuexternos = dtCapaUsuexternosDao.getDtCapaUsuexternos(dtCapaUsuexternosBk.getIdCapaUsuext());

				boolean cambios = AuditoriaDtCapaUsuexternosMng.auditarCambiosDtCapaUsuexternos(dtCapaUsuexternosBk,
						dtCapaUsuexternos, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCapaUsuexternos.setRtmaddressrst(rmtaddress);
					dtCapaUsuexternos.setIdusserModif(kyUsuarioMod);
					dtCapaUsuexternos.setFechaModif(hoy);
					dtCapaUsuexternosDao.updateDtCapaUsuexternos(dtCapaUsuexternos);
				}
			} else {
				dtCapaUsuexternosBk.setRtmaddress(rmtaddress);
				dtCapaUsuexternosBk.setRtmaddressrst(rmtaddress);

				dtCapaUsuexternosBk.setFechaCrea(hoy);
				dtCapaUsuexternosBk.setIdusserCrea(kyUsuarioMod);
				dtCapaUsuexternosBk.setIdusserModif(kyUsuarioMod);
				dtCapaUsuexternosBk.setFechaModif(hoy);
				dtCapaUsuexternosBk.setEstado(Estado.ACTIVO.getValor());

				dtCapaUsuexternos = new DtCapaUsuexternos();

				FuncionesStaticas.copyPropertiesObject(dtCapaUsuexternos, dtCapaUsuexternosBk);
				dtCapaUsuexternosDao.saveDtCapaUsuexternos(dtCapaUsuexternos);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCapaUsuexternos" + " :: " + dtCapaUsuexternos.getIdCapaUsuext().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtCapaUsuexternosBk = getDtCapaUsuexternosBkXid(dtCapaUsuexternos.getIdCapaUsuext(), kyUsuarioMod);
		return dtCapaUsuexternosBk;
	}

	@Override
	public void deleteDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCapaUsuexternos dtCapaUsuexternos = null;
			if (dtCapaUsuexternosBk.getIdCapaUsuext() != null
					&& dtCapaUsuexternosBk.getIdCapaUsuext().longValue() > 0) {

				dtCapaUsuexternos = dtCapaUsuexternosDao.getDtCapaUsuexternos(dtCapaUsuexternosBk.getIdCapaUsuext());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaUsuexternos.setRtmaddressrst(rmtaddress);
				dtCapaUsuexternos.setIdusserModif(kyUsuarioMod);
				dtCapaUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtCapaUsuexternos.getEstado();
				dtCapaUsuexternos.setEstado(Estado.ELIMINADO.getValor());

				dtCapaUsuexternosDao.updateDtCapaUsuexternos(dtCapaUsuexternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtCapaUsuexternos" + " :: " + dtCapaUsuexternos.getIdCapaUsuext().toString()
						+ " :: " + estadoanterior + " :: " + " " + Estado.ELIMINADO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCapaUsuexternos dtCapaUsuexternos = null;
			if (dtCapaUsuexternosBk.getIdCapaUsuext() != null
					&& dtCapaUsuexternosBk.getIdCapaUsuext().longValue() > 0) {

				dtCapaUsuexternos = dtCapaUsuexternosDao.getDtCapaUsuexternos(dtCapaUsuexternosBk.getIdCapaUsuext());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapaUsuexternos.setRtmaddressrst(rmtaddress);
				dtCapaUsuexternos.setIdusserModif(kyUsuarioMod);
				dtCapaUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtCapaUsuexternos.getEstado();
				dtCapaUsuexternos.setEstado(Estado.ACTIVO.getValor());

				dtCapaUsuexternosDao.updateDtCapaUsuexternos(dtCapaUsuexternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtCapaUsuexternos" + " :: " + dtCapaUsuexternos.getIdCapaUsuext().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCapaUsuexternosBk> getDtCapaUsuexternosXFiltro(Long idCapacitacion, Long idUsuexterno,
			Long idCargoUsuext, Long idEntidad, Long kyUsuarioMod) {
		List<DtCapaUsuexternosBk> dtCapaUsuexternosBkss = new ArrayList<DtCapaUsuexternosBk>();
		try {
			List<DtCapaUsuexternos> dtCapaUsuexternossss = dtCapaUsuexternosDao.getXFiltro(idCapacitacion, idUsuexterno,
					idCargoUsuext, idEntidad);
			for (DtCapaUsuexternos dtCapaUsuexternos : dtCapaUsuexternossss) {
				DtCapaUsuexternosBk dtCapaUsuexternosBk = new DtCapaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaUsuexternosBk, dtCapaUsuexternos);
				completarDtCapaUsuexternos(dtCapaUsuexternosBk);
				setACLDtCapaUsuexternosBk(dtCapaUsuexternosBk, kyUsuarioMod);
				dtCapaUsuexternosBkss.add(dtCapaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaUsuexternosBkss;
	}

	@Override
	public List<DtCapaUsuexternosBk> getDtCapaUsuexternosXFiltro(Long idCapacitacion, Long idUsuexterno,
			Long idCargoUsuext, Long idEntidad, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtCapaUsuexternosBk> dtCapaUsuexternosBkss = new ArrayList<DtCapaUsuexternosBk>();
		try {
			List<DtCapaUsuexternos> dtCapaUsuexternossss = dtCapaUsuexternosDao.getXFiltro(idCapacitacion, idUsuexterno,
					idCargoUsuext, idEntidad, inicial, MAX);
			for (DtCapaUsuexternos dtCapaUsuexternos : dtCapaUsuexternossss) {
				DtCapaUsuexternosBk dtCapaUsuexternosBk = new DtCapaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtCapaUsuexternosBk, dtCapaUsuexternos);
				completarDtCapaUsuexternos(dtCapaUsuexternosBk);
				setACLDtCapaUsuexternosBk(dtCapaUsuexternosBk, kyUsuarioMod);
				dtCapaUsuexternosBkss.add(dtCapaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapaUsuexternosBkss;
	}

	@Override
	public Long getDtCapaUsuexternosTotalXFiltro(Long idCapacitacion, Long idUsuexterno, Long idCargoUsuext,
			Long idEntidad, Long kyUsuarioMod) {
		try {
			Long totalDtCapaUsuexternossss = dtCapaUsuexternosDao.getTotalXFiltro(idCapacitacion, idUsuexterno,
					idCargoUsuext, idEntidad);

			return totalDtCapaUsuexternossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCapaUsuexternosBk(DtCapaUsuexternosBk dtCapaUsuexternosBk, Long kyUsuarioMod) {
		DtCapaUsuexternosACL dtCapaUsuexternosACL = new DtCapaUsuexternosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAUSUEXTERNOS_CREA)) {
					dtCapaUsuexternosACL.setEsEditable(true);
					dtCapaUsuexternosACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCAPAUSUEXTERNOS_VE)) {
					dtCapaUsuexternosACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPAUSUEXTERNOS_CREA)) {
					dtCapaUsuexternosACL.setEditopcion(1);
				} else {
					dtCapaUsuexternosACL.setEditopcion(2);
				}
			} else {
				dtCapaUsuexternosACL.setEditopcion(2);
			}
		} else {
			dtCapaUsuexternosACL.setEditopcion(2);
		}
		dtCapaUsuexternosBk.setDtCapaUsuexternosACL(dtCapaUsuexternosACL);
	}

	/**
	 * DT_VISITAS_USUEXTERNOS SERVICIO: LISTA DE LOS PARTICIPANTES DE LA VISITA
	 */
	@Override
	public DtVisitasUsuexternosBk getDtVisitasUsuexternosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtVisitasUsuexternos dtVisitasUsuexternos = dtVisitasUsuexternosDao.getDtVisitasUsuexternos(id);
		DtVisitasUsuexternosBk dtVisitasUsuexternosBk = null;
		if (dtVisitasUsuexternos != null) {
			dtVisitasUsuexternosBk = new DtVisitasUsuexternosBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternosBk, dtVisitasUsuexternos);
			completarDtVisitasUsuexternos(dtVisitasUsuexternosBk);
			if (kyUsuarioMod != null)
				setACLDtVisitasUsuexternosBk(dtVisitasUsuexternosBk, kyUsuarioMod);
		}
		return dtVisitasUsuexternosBk;
	}

	@Override
	public List<DtVisitasUsuexternosBk> getAllDtVisitasUsuexternosActivos(Long kyUsuarioMod) {
		List<DtVisitasUsuexternosBk> dtVisitasUsuexternosBkss = new ArrayList<DtVisitasUsuexternosBk>();
		try {
			List<DtVisitasUsuexternos> dtVisitasUsuexternoss = dtVisitasUsuexternosDao.getActivasDtVisitasUsuexternos();
			for (DtVisitasUsuexternos dtVisitasUsuexternos : dtVisitasUsuexternoss) {
				DtVisitasUsuexternosBk dtVisitasUsuexternosBk = new DtVisitasUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternosBk, dtVisitasUsuexternos);
				completarDtVisitasUsuexternos(dtVisitasUsuexternosBk);
				setACLDtVisitasUsuexternosBk(dtVisitasUsuexternosBk, kyUsuarioMod);
				dtVisitasUsuexternosBkss.add(dtVisitasUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuexternosBkss;
	}

	@Override
	public List<DtVisitasUsuexternosBk> getAllDtVisitasUsuexternosActivosCero(Long kyUsuarioMod) {
		List<DtVisitasUsuexternosBk> dtVisitasUsuexternosBkss = new ArrayList<DtVisitasUsuexternosBk>();
		try {
			List<DtVisitasUsuexternos> dtVisitasUsuexternoss = dtVisitasUsuexternosDao
					.getActivasDtVisitasUsuexternosCero();
			for (DtVisitasUsuexternos dtVisitasUsuexternos : dtVisitasUsuexternoss) {
				DtVisitasUsuexternosBk dtVisitasUsuexternosBk = new DtVisitasUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternosBk, dtVisitasUsuexternos);
				completarDtVisitasUsuexternos(dtVisitasUsuexternosBk);
				setACLDtVisitasUsuexternosBk(dtVisitasUsuexternosBk, kyUsuarioMod);
				dtVisitasUsuexternosBkss.add(dtVisitasUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuexternosBkss;
	}

	private void completarDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk) {
		try {
			if (dtVisitasUsuexternosBk.getIdVisita() != null && dtVisitasUsuexternosBk.getIdVisita().longValue() > 0) {
				DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasUsuexternosBk.getIdVisita());
				if (dtVisitas != null)
					dtVisitasUsuexternosBk.setIdVisitaTxt(dtVisitas.getConclusion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasUsuexternosBk.getIdUsuexterno() != null
					&& dtVisitasUsuexternosBk.getIdUsuexterno().longValue() > 0) {
				DtUsuarioExterno dtUsuarioExterno = dtUsuarioExternoDao
						.getDtUsuarioExterno(dtVisitasUsuexternosBk.getIdUsuexterno());
				if (dtUsuarioExterno != null) {
					dtVisitasUsuexternosBk.setIdUsuexternoTxt(dtUsuarioExterno.getNombre());
					dtVisitasUsuexternosBk.setNombre(dtUsuarioExterno.getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtVisitasUsuexternosBk.getEstado()!=null &&
		// dtVisitasUsuexternosBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtVisitasUsuexternosBk.getEstado());
		// if(prtParametros!=null)
		// dtVisitasUsuexternosBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtVisitasUsuexternosBk.getIdCargoUsuext() != null
					&& dtVisitasUsuexternosBk.getIdCargoUsuext().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao
						.getPrtParametros(dtVisitasUsuexternosBk.getIdCargoUsuext());
				if (prtParametros != null)
					dtVisitasUsuexternosBk.setIdCargoUsuextTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtVisitasUsuexternosBk saveorupdateDtVisitasUsuexternosBk(DtVisitasUsuexternosBk dtVisitasUsuexternosBk,
			String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtVisitasUsuexternosMng.validarDtVisitasUsuexternosBk(dtVisitasUsuexternosBk);

		DtVisitasUsuexternos dtVisitasUsuexternos = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasUsuexternosBk.getIdVisitUsuext() != null
					&& dtVisitasUsuexternosBk.getIdVisitUsuext().longValue() > 0) {

				dtVisitasUsuexternos = dtVisitasUsuexternosDao
						.getDtVisitasUsuexternos(dtVisitasUsuexternosBk.getIdVisitUsuext());

				boolean cambios = AuditoriaDtVisitasUsuexternosMng.auditarCambiosDtVisitasUsuexternos(
						dtVisitasUsuexternosBk, dtVisitasUsuexternos, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtVisitasUsuexternos.setRtmaddressrst(rmtaddress);
					dtVisitasUsuexternos.setIdusserModif(kyUsuarioMod);
					dtVisitasUsuexternos.setFechaModif(hoy);
					dtVisitasUsuexternosDao.updateDtVisitasUsuexternos(dtVisitasUsuexternos);
				}
			} else {
				dtVisitasUsuexternosBk.setRtmaddress(rmtaddress);
				dtVisitasUsuexternosBk.setRtmaddressrst(rmtaddress);

				dtVisitasUsuexternosBk.setFechaCrea(hoy);
				dtVisitasUsuexternosBk.setIdusserCrea(kyUsuarioMod);
				dtVisitasUsuexternosBk.setIdusserModif(kyUsuarioMod);
				dtVisitasUsuexternosBk.setFechaModif(hoy);
				dtVisitasUsuexternosBk.setEstado(Estado.ACTIVO.getValor());

				dtVisitasUsuexternos = new DtVisitasUsuexternos();

				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternos, dtVisitasUsuexternosBk);
				dtVisitasUsuexternosDao.saveDtVisitasUsuexternos(dtVisitasUsuexternos);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtVisitasUsuexternos" + " :: "
								+ dtVisitasUsuexternos.getIdVisitUsuext().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtVisitasUsuexternosBk = getDtVisitasUsuexternosBkXid(dtVisitasUsuexternos.getIdVisitUsuext(), kyUsuarioMod);
		return dtVisitasUsuexternosBk;
	}

	@Override
	public void deleteDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtVisitasUsuexternos dtVisitasUsuexternos = null;
			if (dtVisitasUsuexternosBk.getIdVisitUsuext() != null
					&& dtVisitasUsuexternosBk.getIdVisitUsuext().longValue() > 0) {

				dtVisitasUsuexternos = dtVisitasUsuexternosDao
						.getDtVisitasUsuexternos(dtVisitasUsuexternosBk.getIdVisitUsuext());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasUsuexternos.setRtmaddressrst(rmtaddress);
				dtVisitasUsuexternos.setIdusserModif(kyUsuarioMod);
				dtVisitasUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtVisitasUsuexternos.getEstado();
				dtVisitasUsuexternos.setEstado(Estado.ELIMINADO.getValor());

				dtVisitasUsuexternosDao.updateDtVisitasUsuexternos(dtVisitasUsuexternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtVisitasUsuexternos" + " :: " + dtVisitasUsuexternos.getIdVisitUsuext().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtVisitasUsuexternos dtVisitasUsuexternos = null;
			if (dtVisitasUsuexternosBk.getIdVisitUsuext() != null
					&& dtVisitasUsuexternosBk.getIdVisitUsuext().longValue() > 0) {

				dtVisitasUsuexternos = dtVisitasUsuexternosDao
						.getDtVisitasUsuexternos(dtVisitasUsuexternosBk.getIdVisitUsuext());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtVisitasUsuexternos.setRtmaddressrst(rmtaddress);
				dtVisitasUsuexternos.setIdusserModif(kyUsuarioMod);
				dtVisitasUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtVisitasUsuexternos.getEstado();
				dtVisitasUsuexternos.setEstado(Estado.ACTIVO.getValor());

				dtVisitasUsuexternosDao.updateDtVisitasUsuexternos(dtVisitasUsuexternos);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtVisitasUsuexternos" + " :: " + dtVisitasUsuexternos.getIdVisitUsuext().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtVisitasUsuexternosBk> getDtVisitasUsuexternosXFiltro(Long idVisita, Long idUsuexterno,
			Long idCargoUsuext, Long kyUsuarioMod) {
		List<DtVisitasUsuexternosBk> dtVisitasUsuexternosBkss = new ArrayList<DtVisitasUsuexternosBk>();
		try {
			List<DtVisitasUsuexternos> dtVisitasUsuexternossss = dtVisitasUsuexternosDao.getXFiltro(idVisita,
					idUsuexterno, idCargoUsuext);
			for (DtVisitasUsuexternos dtVisitasUsuexternos : dtVisitasUsuexternossss) {
				DtVisitasUsuexternosBk dtVisitasUsuexternosBk = new DtVisitasUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternosBk, dtVisitasUsuexternos);
				completarDtVisitasUsuexternos(dtVisitasUsuexternosBk);
				setACLDtVisitasUsuexternosBk(dtVisitasUsuexternosBk, kyUsuarioMod);
				dtVisitasUsuexternosBkss.add(dtVisitasUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuexternosBkss;
	}

	@Override
	public List<DtVisitasUsuexternosBk> getDtVisitasUsuexternosXFiltro(Long idVisita, Long idUsuexterno,
			Long idCargoUsuext, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtVisitasUsuexternosBk> dtVisitasUsuexternosBkss = new ArrayList<DtVisitasUsuexternosBk>();
		try {
			List<DtVisitasUsuexternos> dtVisitasUsuexternossss = dtVisitasUsuexternosDao.getXFiltro(idVisita,
					idUsuexterno, idCargoUsuext, inicial, MAX);
			for (DtVisitasUsuexternos dtVisitasUsuexternos : dtVisitasUsuexternossss) {
				DtVisitasUsuexternosBk dtVisitasUsuexternosBk = new DtVisitasUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternosBk, dtVisitasUsuexternos);
				completarDtVisitasUsuexternos(dtVisitasUsuexternosBk);
				setACLDtVisitasUsuexternosBk(dtVisitasUsuexternosBk, kyUsuarioMod);
				dtVisitasUsuexternosBkss.add(dtVisitasUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuexternosBkss;
	}

	@Override
	public Long getDtVisitasUsuexternosTotalXFiltro(Long idVisita, Long idUsuexterno, Long idCargoUsuext,
			Long kyUsuarioMod) {
		try {
			Long totalDtVisitasUsuexternossss = dtVisitasUsuexternosDao.getTotalXFiltro(idVisita, idUsuexterno,
					idCargoUsuext);

			return totalDtVisitasUsuexternossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtVisitasUsuexternosBk(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, Long kyUsuarioMod) {
		DtVisitasUsuexternosACL dtVisitasUsuexternosACL = new DtVisitasUsuexternosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASUSUEXTERNOS_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
					dtVisitasUsuexternosACL.setEsEditable(true);
					dtVisitasUsuexternosACL.setEliminar(true);
				} else if (roles.contains(Roles.DTVISITASUSUEXTERNOS_VE)) {
					// PURIBE 22032024 - FIN--
					dtVisitasUsuexternosACL.setEsEditable(true);
				}
				// PURIBE 22032024 - INICIO--
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITASUSUEXTERNOS_CREA)
						|| roles.contains(Roles.PERFIL_USU_OGC)
						|| roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
					// PURIBE 22032024 - FIN-
					dtVisitasUsuexternosACL.setEditopcion(1);
				} else {
					dtVisitasUsuexternosACL.setEditopcion(2);
				}
			} else {
				dtVisitasUsuexternosACL.setEditopcion(2);
			}
		} else {
			dtVisitasUsuexternosACL.setEditopcion(2);
		}
		dtVisitasUsuexternosBk.setDtVisitasUsuexternosACL(dtVisitasUsuexternosACL);
	}

	/// ADICIONALES

	/**
	 * DT_CARGOS_USUEXTER SERVICIO: LISTA DE LOS CARGOS DE LOS USUARIOS EXTERNOS
	 */
	@Override
	public DtCargosUsuexterBk getDtCargosUsuexterBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtCargosUsuexter dtCargosUsuexter = dtCargosUsuexterDao.getDtCargosUsuexter(id);
		DtCargosUsuexterBk dtCargosUsuexterBk = null;
		if (dtCargosUsuexter != null) {
			dtCargosUsuexterBk = new DtCargosUsuexterBk();
			FuncionesStaticas.copyPropertiesObject(dtCargosUsuexterBk, dtCargosUsuexter);
			completarDtCargosUsuexter(dtCargosUsuexterBk);
			if (kyUsuarioMod != null)
				setACLDtCargosUsuexterBk(dtCargosUsuexterBk, kyUsuarioMod);
		}
		return dtCargosUsuexterBk;
	}

	@Override
	public List<DtCargosUsuexterBk> getAllDtCargosUsuexterActivos(Long kyUsuarioMod) {
		List<DtCargosUsuexterBk> dtCargosUsuexterBkss = new ArrayList<DtCargosUsuexterBk>();
		try {
			List<DtCargosUsuexter> dtCargosUsuexters = dtCargosUsuexterDao.getActivasDtCargosUsuexter();
			for (DtCargosUsuexter dtCargosUsuexter : dtCargosUsuexters) {
				DtCargosUsuexterBk dtCargosUsuexterBk = new DtCargosUsuexterBk();
				FuncionesStaticas.copyPropertiesObject(dtCargosUsuexterBk, dtCargosUsuexter);
				completarDtCargosUsuexter(dtCargosUsuexterBk);
				setACLDtCargosUsuexterBk(dtCargosUsuexterBk, kyUsuarioMod);
				dtCargosUsuexterBkss.add(dtCargosUsuexterBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCargosUsuexterBkss;
	}

	@Override
	public List<DtCargosUsuexterBk> getAllDtCargosUsuexterActivosCero(Long kyUsuarioMod) {
		List<DtCargosUsuexterBk> dtCargosUsuexterBkss = new ArrayList<DtCargosUsuexterBk>();
		try {
			List<DtCargosUsuexter> dtCargosUsuexters = dtCargosUsuexterDao.getActivasDtCargosUsuexterCero();
			for (DtCargosUsuexter dtCargosUsuexter : dtCargosUsuexters) {
				DtCargosUsuexterBk dtCargosUsuexterBk = new DtCargosUsuexterBk();
				FuncionesStaticas.copyPropertiesObject(dtCargosUsuexterBk, dtCargosUsuexter);
				completarDtCargosUsuexter(dtCargosUsuexterBk);
				setACLDtCargosUsuexterBk(dtCargosUsuexterBk, kyUsuarioMod);
				dtCargosUsuexterBkss.add(dtCargosUsuexterBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCargosUsuexterBkss;
	}

	private void completarDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk) {
		// try{
		// if(dtCargosUsuexterBk.getIdUsuextEnti()!=null &&
		// dtCargosUsuexterBk.getIdUsuextEnti().longValue()>0){
		// DtEntidadesUsuexternos dtEntidadesUsuexternos =
		// dtEntidadesUsuexternosDao.getDtEntidadesUsuexternos(dtCargosUsuexterBk.getIdUsuextEnti());
		// if(dtEntidadesUsuexternos!=null)
		// dtCargosUsuexterBk.setIdUsuextEntiTxt(dtEntidadesUsuexternos.get);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtCargosUsuexterBk.getIdCargo() != null && dtCargosUsuexterBk.getIdCargo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtCargosUsuexterBk.getIdCargo());
				if (prtParametros != null)
					dtCargosUsuexterBk.setIdCargoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtCargosUsuexterBk.getEstado()!=null &&
		// dtCargosUsuexterBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtCargosUsuexterBk.getEstado());
		// if(prtParametros!=null)
		// dtCargosUsuexterBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtCargosUsuexterBk saveorupdateDtCargosUsuexterBk(DtCargosUsuexterBk dtCargosUsuexterBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtCargosUsuexterMng.validarDtCargosUsuexterBk(dtCargosUsuexterBk);

		DtCargosUsuexter dtCargosUsuexter = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtCargosUsuexterBk.getIdCargoUsuexter() != null
					&& dtCargosUsuexterBk.getIdCargoUsuexter().longValue() > 0) {

				dtCargosUsuexter = dtCargosUsuexterDao.getDtCargosUsuexter(dtCargosUsuexterBk.getIdCargoUsuexter());

				boolean cambios = AuditoriaDtCargosUsuexterMng.auditarCambiosDtCargosUsuexter(dtCargosUsuexterBk,
						dtCargosUsuexter, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtCargosUsuexter.setRtmaddressrst(rmtaddress);
					dtCargosUsuexter.setIduserModif(kyUsuarioMod);
					dtCargosUsuexter.setFechaModif(hoy);
					dtCargosUsuexterDao.updateDtCargosUsuexter(dtCargosUsuexter);
				}
			} else {
				dtCargosUsuexterBk.setRtmaddress(rmtaddress);
				dtCargosUsuexterBk.setRtmaddressrst(rmtaddress);

				dtCargosUsuexterBk.setFechaCrea(hoy);
				dtCargosUsuexterBk.setIduserCrea(kyUsuarioMod);
				dtCargosUsuexterBk.setIduserModif(kyUsuarioMod);
				dtCargosUsuexterBk.setFechaModif(hoy);
				dtCargosUsuexterBk.setEstado(Estado.ACTIVO.getValor());

				dtCargosUsuexter = new DtCargosUsuexter();

				FuncionesStaticas.copyPropertiesObject(dtCargosUsuexter, dtCargosUsuexterBk);
				dtCargosUsuexterDao.saveDtCargosUsuexter(dtCargosUsuexter);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtCargosUsuexter" + " :: " + dtCargosUsuexter.getIdCargoUsuexter().toString()
								+ " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtCargosUsuexterBk = getDtCargosUsuexterBkXid(dtCargosUsuexter.getIdCargoUsuexter(), kyUsuarioMod);
		return dtCargosUsuexterBk;
	}

	@Override
	public void deleteDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCargosUsuexter dtCargosUsuexter = null;
			if (dtCargosUsuexterBk.getIdCargoUsuexter() != null
					&& dtCargosUsuexterBk.getIdCargoUsuexter().longValue() > 0) {

				dtCargosUsuexter = dtCargosUsuexterDao.getDtCargosUsuexter(dtCargosUsuexterBk.getIdCargoUsuexter());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCargosUsuexter.setRtmaddressrst(rmtaddress);
				dtCargosUsuexter.setIduserModif(kyUsuarioMod);
				dtCargosUsuexter.setFechaModif(hoy);
				Long estadoanterior = dtCargosUsuexter.getEstado();
				dtCargosUsuexter.setEstado(Estado.ELIMINADO.getValor());

				dtCargosUsuexterDao.updateDtCargosUsuexter(dtCargosUsuexter);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtCargosUsuexter" + " :: " + dtCargosUsuexter.getIdCargoUsuexter().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCargosUsuexter dtCargosUsuexter = null;
			if (dtCargosUsuexterBk.getIdCargoUsuexter() != null
					&& dtCargosUsuexterBk.getIdCargoUsuexter().longValue() > 0) {

				dtCargosUsuexter = dtCargosUsuexterDao.getDtCargosUsuexter(dtCargosUsuexterBk.getIdCargoUsuexter());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCargosUsuexter.setRtmaddressrst(rmtaddress);
				dtCargosUsuexter.setIduserModif(kyUsuarioMod);
				dtCargosUsuexter.setFechaModif(hoy);
				Long estadoanterior = dtCargosUsuexter.getEstado();
				dtCargosUsuexter.setEstado(Estado.ACTIVO.getValor());

				dtCargosUsuexterDao.updateDtCargosUsuexter(dtCargosUsuexter);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "ELIMINADO dtCargosUsuexter" + " :: " + dtCargosUsuexter.getIdCargoUsuexter().toString()
						+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtCargosUsuexterBk> getDtCargosUsuexterXFiltro(Long idUsuextEnti, Long idCargo, Long kyUsuarioMod) {
		List<DtCargosUsuexterBk> dtCargosUsuexterBkss = new ArrayList<DtCargosUsuexterBk>();
		try {
			List<DtCargosUsuexter> dtCargosUsuextersss = dtCargosUsuexterDao.getXFiltro(idUsuextEnti, idCargo);
			for (DtCargosUsuexter dtCargosUsuexter : dtCargosUsuextersss) {
				DtCargosUsuexterBk dtCargosUsuexterBk = new DtCargosUsuexterBk();
				FuncionesStaticas.copyPropertiesObject(dtCargosUsuexterBk, dtCargosUsuexter);
				completarDtCargosUsuexter(dtCargosUsuexterBk);
				setACLDtCargosUsuexterBk(dtCargosUsuexterBk, kyUsuarioMod);
				dtCargosUsuexterBkss.add(dtCargosUsuexterBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCargosUsuexterBkss;
	}

	@Override
	public List<DtCargosUsuexterBk> getDtCargosUsuexterXFiltro(Long idUsuextEnti, Long idCargo, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtCargosUsuexterBk> dtCargosUsuexterBkss = new ArrayList<DtCargosUsuexterBk>();
		try {
			List<DtCargosUsuexter> dtCargosUsuextersss = dtCargosUsuexterDao.getXFiltro(idUsuextEnti, idCargo, inicial,
					MAX);
			for (DtCargosUsuexter dtCargosUsuexter : dtCargosUsuextersss) {
				DtCargosUsuexterBk dtCargosUsuexterBk = new DtCargosUsuexterBk();
				FuncionesStaticas.copyPropertiesObject(dtCargosUsuexterBk, dtCargosUsuexter);
				completarDtCargosUsuexter(dtCargosUsuexterBk);
				setACLDtCargosUsuexterBk(dtCargosUsuexterBk, kyUsuarioMod);
				dtCargosUsuexterBkss.add(dtCargosUsuexterBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCargosUsuexterBkss;
	}

	@Override
	public Long getDtCargosUsuexterTotalXFiltro(Long idUsuextEnti, Long idCargo, Long kyUsuarioMod) {
		try {
			Long totalDtCargosUsuextersss = dtCargosUsuexterDao.getTotalXFiltro(idUsuextEnti, idCargo);

			return totalDtCargosUsuextersss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtCargosUsuexterBk(DtCargosUsuexterBk dtCargosUsuexterBk, Long kyUsuarioMod) {
		DtCargosUsuexterACL dtCargosUsuexterACL = new DtCargosUsuexterACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCARGOSUSUEXTER_CREA)) {
					dtCargosUsuexterACL.setEsEditable(true);
					dtCargosUsuexterACL.setEliminar(true);
				} else if (roles.contains(Roles.DTCARGOSUSUEXTER_VE)) {
					dtCargosUsuexterACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCARGOSUSUEXTER_CREA)) {
					dtCargosUsuexterACL.setEditopcion(1);
				} else {
					dtCargosUsuexterACL.setEditopcion(2);
				}
			} else {
				dtCargosUsuexterACL.setEditopcion(2);
			}
		} else {
			dtCargosUsuexterACL.setEditopcion(2);
		}
		dtCargosUsuexterBk.setDtCargosUsuexterACL(dtCargosUsuexterACL);
	}

	/// ADICIONALES

	/**
	 * MS_TEMA SERVICIO: LISTA DE LOS TEMAS REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public MsTemaBk getMsTemaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsTema msTema = msTemaDao.getMsTema(id);
		MsTemaBk msTemaBk = null;
		if (msTema != null) {
			msTemaBk = new MsTemaBk();
			FuncionesStaticas.copyPropertiesObject(msTemaBk, msTema);
			completarMsTema(msTemaBk);
			if (kyUsuarioMod != null)
				setACLMsTemaBk(msTemaBk, kyUsuarioMod);
		}
		return msTemaBk;
	}

	@Override
	public List<MsTemaBk> getAllMsTemaActivos(Long kyUsuarioMod) {
		List<MsTemaBk> msTemaBkss = new ArrayList<MsTemaBk>();
		try {
			List<MsTema> msTemas = msTemaDao.getActivasMsTema();
			for (MsTema msTema : msTemas) {
				MsTemaBk msTemaBk = new MsTemaBk();
				FuncionesStaticas.copyPropertiesObject(msTemaBk, msTema);
				completarMsTema(msTemaBk);
				setACLMsTemaBk(msTemaBk, kyUsuarioMod);
				msTemaBkss.add(msTemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msTemaBkss;
	}

	@Override
	public List<MsTemaBk> getAllMsTemaActivosCero(Long kyUsuarioMod) {
		List<MsTemaBk> msTemaBkss = new ArrayList<MsTemaBk>();
		try {
			List<MsTema> msTemas = msTemaDao.getActivasMsTemaCero();
			for (MsTema msTema : msTemas) {
				MsTemaBk msTemaBk = new MsTemaBk();
				FuncionesStaticas.copyPropertiesObject(msTemaBk, msTema);
				completarMsTema(msTemaBk);
				setACLMsTemaBk(msTemaBk, kyUsuarioMod);
				msTemaBkss.add(msTemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msTemaBkss;
	}

	// private void completarMsTema(MsTemaBk msTemaBk){
	// try{
	// if(msTemaBk.getIdSistAdmi()!=null &&
	// msTemaBk.getIdSistAdmi().longValue()>0){
	// MsSisAdmistrativo msSisAdmistrativo =
	// msSisAdmistrativoDao.getMsSisAdmistrativo(msTemaBk.getIdSistAdmi());
	// if(msSisAdmistrativo!=null)
	// msTemaBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//// try{
	//// if(msTemaBk.getEstado()!=null && msTemaBk.getEstado().longValue()>0){
	//// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(msTemaBk.getEstado());
	//// if(prtParametros!=null)
	//// msTemaBk.setEstadoTxt(prtParametros.getDescripcion());
	//// }
	//// } catch (Exception e) {
	//// e.printStackTrace();
	//// }
	// try{
	// if(msTemaBk.getTipoServicio()!=null &&
	// msTemaBk.getTipoServicio().longValue()>0){
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(msTemaBk.getTipoServicio());
	// if(prtParametros!=null)
	// msTemaBk.setTipoServicioTxt(prtParametros.getDescripcion());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	//
	// }

	@Override
	public MsTemaBk saveorupdateMsTemaBk(MsTemaBk msTemaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsTemaMng.validarMsTemaBk(msTemaBk);

		MsTema msTema = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msTemaBk.getIdTema() != null && msTemaBk.getIdTema().longValue() > 0) {

				msTema = msTemaDao.getMsTema(msTemaBk.getIdTema());

				boolean cambios = AuditoriaMsTemaMng.auditarCambiosMsTema(msTemaBk, msTema, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msTema.setRtmaddressrst(rmtaddress);
					msTema.setIdusserModif(kyUsuarioMod);
					msTema.setFechaModif(hoy);
					msTemaDao.updateMsTema(msTema);
				}
			} else {
				msTemaBk.setRtmaddress(rmtaddress);
				msTemaBk.setRtmaddressrst(rmtaddress);

				msTemaBk.setFechaCrea(hoy);
				msTemaBk.setIdusserCrea(kyUsuarioMod);
				msTemaBk.setIdusserModif(kyUsuarioMod);
				msTemaBk.setFechaModif(hoy);
				msTemaBk.setEstado(Estado.ACTIVO.getValor());

				msTema = new MsTema();

				FuncionesStaticas.copyPropertiesObject(msTema, msTemaBk);
				msTemaDao.saveMsTema(msTema);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msTema" + " :: " + msTema.getIdTema().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msTemaBk = getMsTemaBkXid(msTema.getIdTema(), kyUsuarioMod);
		return msTemaBk;
	}

	@Override
	public void deleteMsTema(MsTemaBk msTemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsTema msTema = null;
			if (msTemaBk.getIdTema() != null && msTemaBk.getIdTema().longValue() > 0) {

				msTema = msTemaDao.getMsTema(msTemaBk.getIdTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msTema.setRtmaddressrst(rmtaddress);
				msTema.setIdusserModif(kyUsuarioMod);
				msTema.setFechaModif(hoy);
				Long estadoanterior = msTema.getEstado();
				msTema.setEstado(Estado.ELIMINADO.getValor());

				msTemaDao.updateMsTema(msTema);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msTema"
								+ " :: " + msTema.getIdTema().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsTema(MsTemaBk msTemaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsTema msTema = null;
			if (msTemaBk.getIdTema() != null && msTemaBk.getIdTema().longValue() > 0) {

				msTema = msTemaDao.getMsTema(msTemaBk.getIdTema());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msTema.setRtmaddressrst(rmtaddress);
				msTema.setIdusserModif(kyUsuarioMod);
				msTema.setFechaModif(hoy);
				Long estadoanterior = msTema.getEstado();
				msTema.setEstado(Estado.ACTIVO.getValor());

				msTemaDao.updateMsTema(msTema);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msTema"
								+ " :: " + msTema.getIdTema().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsTemaBk> getMsTemaXFiltro(Long idSistAdmi, String descripcion, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsTemaBk> msTemaBkss = new ArrayList<MsTemaBk>();
		try {
			List<MsTema> msTemasss = msTemaDao.getXFiltro(idSistAdmi, descripcion, fechaCrea, fechaModif, estado);
			for (MsTema msTema : msTemasss) {
				MsTemaBk msTemaBk = new MsTemaBk();
				FuncionesStaticas.copyPropertiesObject(msTemaBk, msTema);
				completarMsTema(msTemaBk);
				setACLMsTemaBk(msTemaBk, kyUsuarioMod);
				msTemaBkss.add(msTemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msTemaBkss;
	}

	@Override
	public List<MsTemaBk> getMsTemaXFiltro(Long idSistAdmi, String descripcion, Timestamp fechaCrea,
			Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsTemaBk> msTemaBkss = new ArrayList<MsTemaBk>();
		try {
			List<MsTema> msTemasss = msTemaDao.getXFiltro(idSistAdmi, descripcion, fechaCrea, fechaModif, estado,
					inicial, MAX);
			for (MsTema msTema : msTemasss) {
				MsTemaBk msTemaBk = new MsTemaBk();
				FuncionesStaticas.copyPropertiesObject(msTemaBk, msTema);
				completarMsTema(msTemaBk);
				setACLMsTemaBk(msTemaBk, kyUsuarioMod);
				msTemaBkss.add(msTemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msTemaBkss;
	}

	@Override
	public Long getMsTemaTotalXFiltro(Long idSistAdmi, String descripcion, Timestamp fechaCrea, Timestamp fechaModif,
			Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsTemasss = msTemaDao.getTotalXFiltro(idSistAdmi, descripcion, fechaCrea, fechaModif, estado);

			return totalMsTemasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsTemaBk(MsTemaBk msTemaBk, Long kyUsuarioMod) {
		MsTemaACL msTemaACL = new MsTemaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSTEMA_CREA)) {
					msTemaACL.setEsEditable(true);
					msTemaACL.setEliminar(true);
				} else if (roles.contains(Roles.MSTEMA_VE)) {
					msTemaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSTEMA_CREA)) {
					msTemaACL.setEditopcion(1);
				} else {
					msTemaACL.setEditopcion(2);
				}
			} else {
				msTemaACL.setEditopcion(2);
			}
		} else {
			msTemaACL.setEditopcion(2);
		}
		msTemaBk.setMsTemaACL(msTemaACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroTipoServicio() {
		if (prtParametrosIdparametroTipoServicioListaCache == null) {
			// MPINARES 14022024 - INICIO
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("TIPOS DE SERVICIO");
			// MPINARES 14022024 - FIN
			prtParametrosIdparametroTipoServicioListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroTipoServicioListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroTipoServicioListaCache;
	}

	/**
	 * DT_USUARIOS_SEDES SERVICIO: LISTA DE LAS SEDES A LAS QUE PUEDEN
	 * PERTENECER LOS USUARIOS
	 */
	@Override
	public DtUsuariosSedesBk getDtUsuariosSedesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtUsuariosSedes dtUsuariosSedes = dtUsuariosSedesDao.getDtUsuariosSedes(id);
		DtUsuariosSedesBk dtUsuariosSedesBk = null;
		if (dtUsuariosSedes != null) {
			dtUsuariosSedesBk = new DtUsuariosSedesBk();
			FuncionesStaticas.copyPropertiesObject(dtUsuariosSedesBk, dtUsuariosSedes);
			completarDtUsuariosSedes(dtUsuariosSedesBk);
			if (kyUsuarioMod != null)
				setACLDtUsuariosSedesBk(dtUsuariosSedesBk, kyUsuarioMod);
		}
		return dtUsuariosSedesBk;
	}

	@Override
	public List<DtUsuariosSedesBk> getAllDtUsuariosSedesActivos(Long kyUsuarioMod) {
		List<DtUsuariosSedesBk> dtUsuariosSedesBkss = new ArrayList<DtUsuariosSedesBk>();
		try {
			List<DtUsuariosSedes> dtUsuariosSedess = dtUsuariosSedesDao.getActivasDtUsuariosSedes();
			for (DtUsuariosSedes dtUsuariosSedes : dtUsuariosSedess) {
				DtUsuariosSedesBk dtUsuariosSedesBk = new DtUsuariosSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuariosSedesBk, dtUsuariosSedes);
				completarDtUsuariosSedes(dtUsuariosSedesBk);
				setACLDtUsuariosSedesBk(dtUsuariosSedesBk, kyUsuarioMod);
				dtUsuariosSedesBkss.add(dtUsuariosSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuariosSedesBkss;
	}

	@Override
	public List<DtUsuariosSedesBk> getAllDtUsuariosSedesActivosCero(Long kyUsuarioMod) {
		List<DtUsuariosSedesBk> dtUsuariosSedesBkss = new ArrayList<DtUsuariosSedesBk>();
		try {
			List<DtUsuariosSedes> dtUsuariosSedess = dtUsuariosSedesDao.getActivasDtUsuariosSedesCero();
			for (DtUsuariosSedes dtUsuariosSedes : dtUsuariosSedess) {
				DtUsuariosSedesBk dtUsuariosSedesBk = new DtUsuariosSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuariosSedesBk, dtUsuariosSedes);
				completarDtUsuariosSedes(dtUsuariosSedesBk);
				setACLDtUsuariosSedesBk(dtUsuariosSedesBk, kyUsuarioMod);
				dtUsuariosSedesBkss.add(dtUsuariosSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuariosSedesBkss;
	}

	private void completarDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk) {
		try {
			if (dtUsuariosSedesBk.getIdSede() != null && dtUsuariosSedesBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtUsuariosSedesBk.getIdSede());
				if (msSedes != null)
					dtUsuariosSedesBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuariosSedesBk.getIdusuario() != null && dtUsuariosSedesBk.getIdusuario().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtUsuariosSedesBk.getIdusuario());
				if (msUsuarios != null)
					dtUsuariosSedesBk.setIdusuarioTxt(msUsuarios.getNombres());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtUsuariosSedesBk.getEstado()!=null &&
		// dtUsuariosSedesBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtUsuariosSedesBk.getEstado());
		// if(prtParametros!=null)
		// dtUsuariosSedesBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public DtUsuariosSedesBk saveorupdateDtUsuariosSedesBk(DtUsuariosSedesBk dtUsuariosSedesBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtUsuariosSedesMng.validarDtUsuariosSedesBk(dtUsuariosSedesBk);

		DtUsuariosSedes dtUsuariosSedes = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtUsuariosSedesBk.getIdUsuSede() != null && dtUsuariosSedesBk.getIdUsuSede().longValue() > 0) {

				dtUsuariosSedes = dtUsuariosSedesDao.getDtUsuariosSedes(dtUsuariosSedesBk.getIdUsuSede());

				boolean cambios = AuditoriaDtUsuariosSedesMng.auditarCambiosDtUsuariosSedes(dtUsuariosSedesBk,
						dtUsuariosSedes, kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtUsuariosSedes.setRtmaddressrst(rmtaddress);
					dtUsuariosSedes.setIdusserModif(kyUsuarioMod);
					dtUsuariosSedes.setFechaModif(hoy);
					dtUsuariosSedesDao.updateDtUsuariosSedes(dtUsuariosSedes);
				}
			} else {
				dtUsuariosSedesBk.setRtmaddress(rmtaddress);
				dtUsuariosSedesBk.setRtmaddressrst(rmtaddress);

				dtUsuariosSedesBk.setFechaCrea(hoy);
				dtUsuariosSedesBk.setIdusserCrea(kyUsuarioMod);
				dtUsuariosSedesBk.setIdusserModif(kyUsuarioMod);
				dtUsuariosSedesBk.setFechaModif(hoy);
				dtUsuariosSedesBk.setEstado(Estado.ACTIVO.getValor());

				dtUsuariosSedes = new DtUsuariosSedes();

				FuncionesStaticas.copyPropertiesObject(dtUsuariosSedes, dtUsuariosSedesBk);
				dtUsuariosSedesDao.saveDtUsuariosSedes(dtUsuariosSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO dtUsuariosSedes" + " :: " + dtUsuariosSedes.getIdUsuSede().toString() + " :: "
								+ "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtUsuariosSedesBk = getDtUsuariosSedesBkXid(dtUsuariosSedes.getIdUsuSede(), kyUsuarioMod);
		return dtUsuariosSedesBk;
	}

	@Override
	public void deleteDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtUsuariosSedes dtUsuariosSedes = null;
			if (dtUsuariosSedesBk.getIdUsuSede() != null && dtUsuariosSedesBk.getIdUsuSede().longValue() > 0) {

				dtUsuariosSedes = dtUsuariosSedesDao.getDtUsuariosSedes(dtUsuariosSedesBk.getIdUsuSede());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtUsuariosSedes.setRtmaddressrst(rmtaddress);
				dtUsuariosSedes.setIdusserModif(kyUsuarioMod);
				dtUsuariosSedes.setFechaModif(hoy);
				Long estadoanterior = dtUsuariosSedes.getEstado();
				dtUsuariosSedes.setEstado(Estado.ELIMINADO.getValor());

				dtUsuariosSedesDao.updateDtUsuariosSedes(dtUsuariosSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtUsuariosSedes" + " :: " + dtUsuariosSedes.getIdUsuSede().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtUsuariosSedes dtUsuariosSedes = null;
			if (dtUsuariosSedesBk.getIdUsuSede() != null && dtUsuariosSedesBk.getIdUsuSede().longValue() > 0) {

				dtUsuariosSedes = dtUsuariosSedesDao.getDtUsuariosSedes(dtUsuariosSedesBk.getIdUsuSede());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtUsuariosSedes.setRtmaddressrst(rmtaddress);
				dtUsuariosSedes.setIdusserModif(kyUsuarioMod);
				dtUsuariosSedes.setFechaModif(hoy);
				Long estadoanterior = dtUsuariosSedes.getEstado();
				dtUsuariosSedes.setEstado(Estado.ACTIVO.getValor());

				dtUsuariosSedesDao.updateDtUsuariosSedes(dtUsuariosSedes);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtUsuariosSedes" + " :: " + dtUsuariosSedes.getIdUsuSede().toString()
								+ " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtUsuariosSedesBk> getDtUsuariosSedesXFiltro(Long idSede, Long idusuario, Long kyUsuarioMod) {
		List<DtUsuariosSedesBk> dtUsuariosSedesBkss = new ArrayList<DtUsuariosSedesBk>();
		try {
			List<DtUsuariosSedes> dtUsuariosSedessss = dtUsuariosSedesDao.getXFiltro(idSede, idusuario);
			for (DtUsuariosSedes dtUsuariosSedes : dtUsuariosSedessss) {
				DtUsuariosSedesBk dtUsuariosSedesBk = new DtUsuariosSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuariosSedesBk, dtUsuariosSedes);
				completarDtUsuariosSedes(dtUsuariosSedesBk);
				setACLDtUsuariosSedesBk(dtUsuariosSedesBk, kyUsuarioMod);
				dtUsuariosSedesBkss.add(dtUsuariosSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuariosSedesBkss;
	}

	@Override
	public List<DtUsuariosSedesBk> getDtUsuariosSedesXFiltro(Long idSede, Long idusuario, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<DtUsuariosSedesBk> dtUsuariosSedesBkss = new ArrayList<DtUsuariosSedesBk>();
		try {
			List<DtUsuariosSedes> dtUsuariosSedessss = dtUsuariosSedesDao.getXFiltro(idSede, idusuario, inicial, MAX);
			for (DtUsuariosSedes dtUsuariosSedes : dtUsuariosSedessss) {
				DtUsuariosSedesBk dtUsuariosSedesBk = new DtUsuariosSedesBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuariosSedesBk, dtUsuariosSedes);
				completarDtUsuariosSedes(dtUsuariosSedesBk);
				setACLDtUsuariosSedesBk(dtUsuariosSedesBk, kyUsuarioMod);
				dtUsuariosSedesBkss.add(dtUsuariosSedesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuariosSedesBkss;
	}

	@Override
	public Long getDtUsuariosSedesTotalXFiltro(Long idSede, Long idusuario, Long kyUsuarioMod) {
		try {
			Long totalDtUsuariosSedessss = dtUsuariosSedesDao.getTotalXFiltro(idSede, idusuario);

			return totalDtUsuariosSedessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtUsuariosSedesBk(DtUsuariosSedesBk dtUsuariosSedesBk, Long kyUsuarioMod) {
		DtUsuariosSedesACL dtUsuariosSedesACL = new DtUsuariosSedesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTUSUARIOSSEDES_CREA)) {
					dtUsuariosSedesACL.setEsEditable(true);
					dtUsuariosSedesACL.setEliminar(true);
				} else if (roles.contains(Roles.DTUSUARIOSSEDES_VE)) {
					dtUsuariosSedesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTUSUARIOSSEDES_CREA)) {
					dtUsuariosSedesACL.setEditopcion(1);
				} else {
					dtUsuariosSedesACL.setEditopcion(2);
				}
			} else {
				dtUsuariosSedesACL.setEditopcion(2);
			}
		} else {
			dtUsuariosSedesACL.setEditopcion(2);
		}
		dtUsuariosSedesBk.setDtUsuariosSedesACL(dtUsuariosSedesACL);
	}

	/// ADICIONALES

	/**
	 * MS_INDICADOR SERVICIO: LISTA DE LOS INDICADORES REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public MsIndicadorBk getMsIndicadorBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsIndicador msIndicador = msIndicadorDao.getMsIndicador(id);
		MsIndicadorBk msIndicadorBk = null;
		if (msIndicador != null) {
			msIndicadorBk = new MsIndicadorBk();
			FuncionesStaticas.copyPropertiesObject(msIndicadorBk, msIndicador);
			completarMsIndicador(msIndicadorBk);
			if (kyUsuarioMod != null)
				setACLMsIndicadorBk(msIndicadorBk, kyUsuarioMod);
		}
		return msIndicadorBk;
	}

	@Override
	public List<MsIndicadorBk> getAllMsIndicadorActivos(Long kyUsuarioMod) {
		List<MsIndicadorBk> msIndicadorBkss = new ArrayList<MsIndicadorBk>();
		try {
			List<MsIndicador> msIndicadors = msIndicadorDao.getActivasMsIndicador();
			for (MsIndicador msIndicador : msIndicadors) {
				MsIndicadorBk msIndicadorBk = new MsIndicadorBk();
				FuncionesStaticas.copyPropertiesObject(msIndicadorBk, msIndicador);
				completarMsIndicador(msIndicadorBk);
				setACLMsIndicadorBk(msIndicadorBk, kyUsuarioMod);
				msIndicadorBkss.add(msIndicadorBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msIndicadorBkss;
	}

	@Override
	public List<MsIndicadorBk> getAllMsIndicadorActivosCero(Long kyUsuarioMod) {
		List<MsIndicadorBk> msIndicadorBkss = new ArrayList<MsIndicadorBk>();
		try {
			List<MsIndicador> msIndicadors = msIndicadorDao.getActivasMsIndicadorCero();
			for (MsIndicador msIndicador : msIndicadors) {
				MsIndicadorBk msIndicadorBk = new MsIndicadorBk();
				FuncionesStaticas.copyPropertiesObject(msIndicadorBk, msIndicador);
				completarMsIndicador(msIndicadorBk);
				setACLMsIndicadorBk(msIndicadorBk, kyUsuarioMod);
				msIndicadorBkss.add(msIndicadorBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msIndicadorBkss;
	}

	private void completarMsIndicador(MsIndicadorBk msIndicadorBk) {
		try {
			if (msIndicadorBk.getIdObjetvo() != null && msIndicadorBk.getIdObjetvo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msIndicadorBk.getIdObjetvo());
				if (prtParametros != null)
					msIndicadorBk.setIdObjetvoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msIndicadorBk.getIdNivlstrat() != null && msIndicadorBk.getIdNivlstrat().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msIndicadorBk.getIdNivlstrat());
				if (prtParametros != null)
					msIndicadorBk.setIdNivlstratTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msIndicadorBk.getIdFactor() != null && msIndicadorBk.getIdFactor().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msIndicadorBk.getIdFactor());
				if (prtParametros != null)
					msIndicadorBk.setIdFactorTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msIndicadorBk.getIdFuenteinfor() != null && msIndicadorBk.getIdFuenteinfor().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msIndicadorBk.getIdFuenteinfor());
				if (prtParametros != null)
					msIndicadorBk.setIdFuenteinforTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msIndicadorBk.getEstado()!=null &&
		// msIndicadorBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msIndicadorBk.getEstado());
		// if(prtParametros!=null)
		// msIndicadorBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsIndicadorBk saveorupdateMsIndicadorBk(MsIndicadorBk msIndicadorBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionMsIndicadorMng.validarMsIndicadorBk(msIndicadorBk);

		MsIndicador msIndicador = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msIndicadorBk.getIdIndicador() != null && msIndicadorBk.getIdIndicador().longValue() > 0) {

				msIndicador = msIndicadorDao.getMsIndicador(msIndicadorBk.getIdIndicador());

				boolean cambios = AuditoriaMsIndicadorMng.auditarCambiosMsIndicador(msIndicadorBk, msIndicador,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					msIndicador.setRtmaddressrst(rmtaddress);
					msIndicador.setIdusserModif(kyUsuarioMod);
					msIndicador.setFechaModif(hoy);
					msIndicadorDao.updateMsIndicador(msIndicador);
				}
			} else {
				msIndicadorBk.setRtmaddress(rmtaddress);
				msIndicadorBk.setRtmaddressrst(rmtaddress);

				msIndicadorBk.setFechaCrea(hoy);
				msIndicadorBk.setIdusserCrea(kyUsuarioMod);
				msIndicadorBk.setIdusserModif(kyUsuarioMod);
				msIndicadorBk.setFechaModif(hoy);
				msIndicadorBk.setEstado(Estado.ACTIVO.getValor());

				msIndicador = new MsIndicador();

				FuncionesStaticas.copyPropertiesObject(msIndicador, msIndicadorBk);
				msIndicadorDao.saveMsIndicador(msIndicador);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "CREADO msIndicador" + " :: " + msIndicador.getIdIndicador().toString() + " :: " + "0"
								+ " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msIndicadorBk = getMsIndicadorBkXid(msIndicador.getIdIndicador(), kyUsuarioMod);
		return msIndicadorBk;
	}

	@Override
	public void deleteMsIndicador(MsIndicadorBk msIndicadorBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsIndicador msIndicador = null;
			if (msIndicadorBk.getIdIndicador() != null && msIndicadorBk.getIdIndicador().longValue() > 0) {

				msIndicador = msIndicadorDao.getMsIndicador(msIndicadorBk.getIdIndicador());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msIndicador.setRtmaddressrst(rmtaddress);
				msIndicador.setIdusserModif(kyUsuarioMod);
				msIndicador.setFechaModif(hoy);
				Long estadoanterior = msIndicador.getEstado();
				msIndicador.setEstado(Estado.ELIMINADO.getValor());

				msIndicadorDao.updateMsIndicador(msIndicador);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msIndicador" + " :: " + msIndicador.getIdIndicador().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsIndicador(MsIndicadorBk msIndicadorBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsIndicador msIndicador = null;
			if (msIndicadorBk.getIdIndicador() != null && msIndicadorBk.getIdIndicador().longValue() > 0) {

				msIndicador = msIndicadorDao.getMsIndicador(msIndicadorBk.getIdIndicador());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msIndicador.setRtmaddressrst(rmtaddress);
				msIndicador.setIdusserModif(kyUsuarioMod);
				msIndicador.setFechaModif(hoy);
				Long estadoanterior = msIndicador.getEstado();
				msIndicador.setEstado(Estado.ACTIVO.getValor());

				msIndicadorDao.updateMsIndicador(msIndicador);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msIndicador" + " :: " + msIndicador.getIdIndicador().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsIndicadorBk> getMsIndicadorXFiltro(String descripcion, Long idObjetvo, Long idNivlstrat,
			Long idFactor, Long idFuenteinfor, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsIndicadorBk> msIndicadorBkss = new ArrayList<MsIndicadorBk>();
		try {
			List<MsIndicador> msIndicadorsss = msIndicadorDao.getXFiltro(descripcion, idObjetvo, idNivlstrat, idFactor,
					idFuenteinfor, fechaModif, estado);
			for (MsIndicador msIndicador : msIndicadorsss) {
				MsIndicadorBk msIndicadorBk = new MsIndicadorBk();
				FuncionesStaticas.copyPropertiesObject(msIndicadorBk, msIndicador);
				completarMsIndicador(msIndicadorBk);
				setACLMsIndicadorBk(msIndicadorBk, kyUsuarioMod);
				msIndicadorBkss.add(msIndicadorBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msIndicadorBkss;
	}

	@Override
	public List<MsIndicadorBk> getMsIndicadorXFiltro(String descripcion, Long idObjetvo, Long idNivlstrat,
			Long idFactor, Long idFuenteinfor, Timestamp fechaModif, Long estado, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<MsIndicadorBk> msIndicadorBkss = new ArrayList<MsIndicadorBk>();
		try {
			List<MsIndicador> msIndicadorsss = msIndicadorDao.getXFiltro(descripcion, idObjetvo, idNivlstrat, idFactor,
					idFuenteinfor, fechaModif, estado, inicial, MAX);
			for (MsIndicador msIndicador : msIndicadorsss) {
				MsIndicadorBk msIndicadorBk = new MsIndicadorBk();
				FuncionesStaticas.copyPropertiesObject(msIndicadorBk, msIndicador);
				completarMsIndicador(msIndicadorBk);
				setACLMsIndicadorBk(msIndicadorBk, kyUsuarioMod);
				msIndicadorBkss.add(msIndicadorBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msIndicadorBkss;
	}

	@Override
	public Long getMsIndicadorTotalXFiltro(String descripcion, Long idObjetvo, Long idNivlstrat, Long idFactor,
			Long idFuenteinfor, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsIndicadorsss = msIndicadorDao.getTotalXFiltro(descripcion, idObjetvo, idNivlstrat, idFactor,
					idFuenteinfor, fechaModif, estado);

			return totalMsIndicadorsss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsIndicadorBk(MsIndicadorBk msIndicadorBk, Long kyUsuarioMod) {
		MsIndicadorACL msIndicadorACL = new MsIndicadorACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSINDICADOR_CREA)) {
					msIndicadorACL.setEsEditable(true);
					msIndicadorACL.setEliminar(true);
				} else if (roles.contains(Roles.MSINDICADOR_VE)) {
					msIndicadorACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSINDICADOR_CREA)) {
					msIndicadorACL.setEditopcion(1);
				} else {
					msIndicadorACL.setEditopcion(2);
				}
			} else {
				msIndicadorACL.setEditopcion(2);
			}
		} else {
			msIndicadorACL.setEditopcion(2);
		}
		msIndicadorBk.setMsIndicadorACL(msIndicadorACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdObjetvo() {
		if (prtParametrosIdparametroIdObjetvoListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdObjetvoListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdObjetvoListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdObjetvoListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdNivlstrat() {
		if (prtParametrosIdparametroIdNivlstratListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdNivlstratListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdNivlstratListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdNivlstratListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdFactor() {
		if (prtParametrosIdparametroIdFactorListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdFactorListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdFactorListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdFactorListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdFuenteinfor() {
		if (prtParametrosIdparametroIdFuenteinforListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdFuenteinforListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdFuenteinforListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdFuenteinforListaCache;
	}

	/**
	 * DT_ENCUESTA SERVICIO: LISTA DE ENCUESTAS
	 */
	@Override
	public DtEncuestaBk getDtEncuestaBkXid(Integer id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtEncuesta dtEncuesta = dtEncuestaDao.getDtEncuesta(id);
		DtEncuestaBk dtEncuestaBk = null;
		if (dtEncuesta != null) {
			dtEncuestaBk = new DtEncuestaBk();
			FuncionesStaticas.copyPropertiesObject(dtEncuestaBk, dtEncuesta);
			completarDtEncuesta(dtEncuestaBk);
			if (kyUsuarioMod != null)
				setACLDtEncuestaBk(dtEncuestaBk, kyUsuarioMod);
		}
		return dtEncuestaBk;
	}

	@Override
	public List<DtEncuestaBk> getAllDtEncuestaActivos(Long kyUsuarioMod) {
		List<DtEncuestaBk> dtEncuestaBkss = new ArrayList<DtEncuestaBk>();
		try {
			List<DtEncuesta> dtEncuestas = dtEncuestaDao.getActivasDtEncuesta();
			for (DtEncuesta dtEncuesta : dtEncuestas) {
				DtEncuestaBk dtEncuestaBk = new DtEncuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaBk, dtEncuesta);
				completarDtEncuesta(dtEncuestaBk);
				setACLDtEncuestaBk(dtEncuestaBk, kyUsuarioMod);
				dtEncuestaBkss.add(dtEncuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaBkss;
	}

	@Override
	public List<DtEncuestaBk> getAllDtEncuestaActivosCero(Long kyUsuarioMod) {
		List<DtEncuestaBk> dtEncuestaBkss = new ArrayList<DtEncuestaBk>();
		try {
			List<DtEncuesta> dtEncuestas = dtEncuestaDao.getActivasDtEncuestaCero();
			for (DtEncuesta dtEncuesta : dtEncuestas) {
				DtEncuestaBk dtEncuestaBk = new DtEncuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaBk, dtEncuesta);
				completarDtEncuesta(dtEncuestaBk);
				setACLDtEncuestaBk(dtEncuestaBk, kyUsuarioMod);
				dtEncuestaBkss.add(dtEncuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaBkss;
	}

	private void completarDtEncuesta(DtEncuestaBk dtEncuestaBk) {
		try {
			if (dtEncuestaBk.getTipoServicio() != null && dtEncuestaBk.getTipoServicio().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtEncuestaBk.getTipoServicio());
				if (prtParametros != null)
					dtEncuestaBk.setTipoServicioTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(dtEncuestaBk.getEstado()!=null &&
		// dtEncuestaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(dtEncuestaBk.getEstado());
		// if(prtParametros!=null)
		// dtEncuestaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (dtEncuestaBk.getIdOrigen() != null && dtEncuestaBk.getIdOrigen().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtEncuestaBk.getIdOrigen());
				if (prtParametros != null)
					dtEncuestaBk.setIdOrigenTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtEncuestaBk.getIdPrestacion() != null && dtEncuestaBk.getIdPrestacion().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtEncuestaBk.getIdPrestacion());
				if (prtParametros != null)
					dtEncuestaBk.setIdPrestacionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public DtEncuestaBk saveorupdateDtEncuestaBk(DtEncuestaBk dtEncuestaBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {

		ValidacionDtEncuestaMng.validarDtEncuestaBk(dtEncuestaBk);

		DtEncuesta dtEncuesta = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtEncuestaBk.getIdEncuesta() != null && dtEncuestaBk.getIdEncuesta().longValue() > 0) {

				dtEncuesta = dtEncuestaDao.getDtEncuesta(dtEncuestaBk.getIdEncuesta());

				boolean cambios = AuditoriaDtEncuestaMng.auditarCambiosDtEncuesta(dtEncuestaBk, dtEncuesta,
						kyUsuarioMod, user, rmtaddress, nivel);

				if (cambios) {
					dtEncuesta.setRtmaddressrst(rmtaddress);
					dtEncuesta.setIdusserModif(kyUsuarioMod);
					dtEncuesta.setFechaModif(hoy);
					dtEncuestaDao.updateDtEncuesta(dtEncuesta);
				}
			} else {
				dtEncuestaBk.setRtmaddress(rmtaddress);
				dtEncuestaBk.setRtmaddressrst(rmtaddress);

				dtEncuestaBk.setFechaCrea(hoy);
				dtEncuestaBk.setIdusserCrea(kyUsuarioMod);
				dtEncuestaBk.setIdusserModif(kyUsuarioMod);
				dtEncuestaBk.setFechaModif(hoy);
				dtEncuestaBk.setEstado(Estado.ACTIVO.getValor());

				dtEncuesta = new DtEncuesta();

				FuncionesStaticas.copyPropertiesObject(dtEncuesta, dtEncuestaBk);
				dtEncuestaDao.saveDtEncuesta(dtEncuesta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "CREADO dtEncuesta"
								+ " :: " + dtEncuesta.getIdEncuesta().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		dtEncuestaBk = getDtEncuestaBkXid(dtEncuesta.getIdEncuesta(), kyUsuarioMod);
		return dtEncuestaBk;
	}

	@Override
	public void deleteDtEncuesta(DtEncuestaBk dtEncuestaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtEncuesta dtEncuesta = null;
			if (dtEncuestaBk.getIdEncuesta() != null && dtEncuestaBk.getIdEncuesta().longValue() > 0) {

				dtEncuesta = dtEncuestaDao.getDtEncuesta(dtEncuestaBk.getIdEncuesta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEncuesta.setRtmaddressrst(rmtaddress);
				dtEncuesta.setIdusserModif(kyUsuarioMod);
				dtEncuesta.setFechaModif(hoy);
				Long estadoanterior = dtEncuesta.getEstado();
				dtEncuesta.setEstado(Estado.ELIMINADO.getValor());

				dtEncuestaDao.updateDtEncuesta(dtEncuesta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtEncuesta" + " :: " + dtEncuesta.getIdEncuesta().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarDtEncuesta(DtEncuestaBk dtEncuestaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtEncuesta dtEncuesta = null;
			if (dtEncuestaBk.getIdEncuesta() != null && dtEncuestaBk.getIdEncuesta().longValue() > 0) {

				dtEncuesta = dtEncuestaDao.getDtEncuesta(dtEncuestaBk.getIdEncuesta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtEncuesta.setRtmaddressrst(rmtaddress);
				dtEncuesta.setIdusserModif(kyUsuarioMod);
				dtEncuesta.setFechaModif(hoy);
				Long estadoanterior = dtEncuesta.getEstado();
				dtEncuesta.setEstado(Estado.ACTIVO.getValor());

				dtEncuestaDao.updateDtEncuesta(dtEncuesta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtEncuesta" + " :: " + dtEncuesta.getIdEncuesta().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<DtEncuestaBk> getDtEncuestaXFiltro(Long tipoServicio, Timestamp fechaInicio, Timestamp fechaFin,
			Long idOrigen, Long idPrestacion, Long kyUsuarioMod) {
		List<DtEncuestaBk> dtEncuestaBkss = new ArrayList<DtEncuestaBk>();
		try {
			// List<DtEncuesta> dtEncuestasss =
			// dtEncuestaDao.getXFiltro(tipoServicio,fechaInicio,fechaFin,idOrigen,idPrestacion);
			List<DtEncuesta> dtEncuestasss = dtEncuestaDao.getXFiltro(tipoServicio, fechaInicio, fechaFin, idOrigen,
					idPrestacion, null);// PURIBE 22042024 -INICIO-->
			for (DtEncuesta dtEncuesta : dtEncuestasss) {
				DtEncuestaBk dtEncuestaBk = new DtEncuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaBk, dtEncuesta);
				completarDtEncuesta(dtEncuestaBk);
				setACLDtEncuestaBk(dtEncuestaBk, kyUsuarioMod);
				dtEncuestaBkss.add(dtEncuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaBkss;
	}

	@Override
	public List<DtEncuestaBk> getDtEncuestaXFiltro(Long tipoServicio, Timestamp fechaInicio, Timestamp fechaFin,
			Long idOrigen, Long idPrestacion, int inicial, int MAX, Long kyUsuarioMod) {
		List<DtEncuestaBk> dtEncuestaBkss = new ArrayList<DtEncuestaBk>();
		try {
			List<DtEncuesta> dtEncuestasss = dtEncuestaDao.getXFiltro(tipoServicio, fechaInicio, fechaFin, idOrigen,
					idPrestacion, inicial, MAX);
			for (DtEncuesta dtEncuesta : dtEncuestasss) {
				DtEncuestaBk dtEncuestaBk = new DtEncuestaBk();
				FuncionesStaticas.copyPropertiesObject(dtEncuestaBk, dtEncuesta);
				completarDtEncuesta(dtEncuestaBk);
				setACLDtEncuestaBk(dtEncuestaBk, kyUsuarioMod);
				dtEncuestaBkss.add(dtEncuestaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEncuestaBkss;
	}

	@Override
	public Long getDtEncuestaTotalXFiltro(Long tipoServicio, Timestamp fechaInicio, Timestamp fechaFin, Long idOrigen,
			Long idPrestacion, Long kyUsuarioMod) {
		try {
			Long totalDtEncuestasss = dtEncuestaDao.getTotalXFiltro(tipoServicio, fechaInicio, fechaFin, idOrigen,
					idPrestacion);

			return totalDtEncuestasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLDtEncuestaBk(DtEncuestaBk dtEncuestaBk, Long kyUsuarioMod) {
		DtEncuestaACL dtEncuestaACL = new DtEncuestaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENCUESTA_CREA)) {
					dtEncuestaACL.setEsEditable(true);
					dtEncuestaACL.setEliminar(true);
				} else if (roles.contains(Roles.DTENCUESTA_VE)) {
					dtEncuestaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENCUESTA_CREA)) {
					dtEncuestaACL.setEditopcion(1);
				} else {
					dtEncuestaACL.setEditopcion(2);
				}
			} else {
				dtEncuestaACL.setEditopcion(2);
			}
		} else {
			dtEncuestaACL.setEditopcion(2);
		}
		dtEncuestaBk.setDtEncuestaACL(dtEncuestaACL);
	}

	/// ADICIONALES

	/**
	 * MS_LOCAL SERVICIO: LISTA DE LOS LOCALES REGISTRADOS EN EL SISTEMA
	 */
	@Override
	public MsLocalBk getMsLocalBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsLocal msLocal = msLocalDao.getMsLocal(id);
		MsLocalBk msLocalBk = null;
		if (msLocal != null) {
			msLocalBk = new MsLocalBk();
			FuncionesStaticas.copyPropertiesObject(msLocalBk, msLocal);
			completarMsLocal(msLocalBk);
			if (kyUsuarioMod != null)
				setACLMsLocalBk(msLocalBk, kyUsuarioMod);
		}
		return msLocalBk;
	}

	@Override
	public List<MsLocalBk> getAllMsLocalActivos(Long kyUsuarioMod) {
		List<MsLocalBk> msLocalBkss = new ArrayList<MsLocalBk>();
		try {
			List<MsLocal> msLocals = msLocalDao.getActivasMsLocal();
			for (MsLocal msLocal : msLocals) {
				MsLocalBk msLocalBk = new MsLocalBk();
				FuncionesStaticas.copyPropertiesObject(msLocalBk, msLocal);
				completarMsLocal(msLocalBk);
				setACLMsLocalBk(msLocalBk, kyUsuarioMod);
				msLocalBkss.add(msLocalBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msLocalBkss;
	}

	@Override
	public List<MsLocalBk> getAllMsLocalActivosCero(Long kyUsuarioMod) {
		List<MsLocalBk> msLocalBkss = new ArrayList<MsLocalBk>();
		try {
			List<MsLocal> msLocals = msLocalDao.getActivasMsLocalCero();
			for (MsLocal msLocal : msLocals) {
				MsLocalBk msLocalBk = new MsLocalBk();
				FuncionesStaticas.copyPropertiesObject(msLocalBk, msLocal);
				completarMsLocal(msLocalBk);
				setACLMsLocalBk(msLocalBk, kyUsuarioMod);
				msLocalBkss.add(msLocalBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msLocalBkss;
	}

	private void completarMsLocal(MsLocalBk msLocalBk) {

		try {
			if (msLocalBk.getCodDpto() != null && msLocalBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = msLocalBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msLocalBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msLocalBk.getCodDpto() != null && msLocalBk.getCodDpto().intValue() > 0
					&& msLocalBk.getCodProv() != null && msLocalBk.getCodProv().intValue() > 0) {
				int iiCodDpto = msLocalBk.getCodDpto().intValue();
				int iiCodProv = msLocalBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msLocalBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msLocalBk.getCodDpto() != null && msLocalBk.getCodDpto().intValue() > 0
					&& msLocalBk.getCodProv() != null && msLocalBk.getCodProv().intValue() > 0
					&& msLocalBk.getCodDistr() != null && msLocalBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = msLocalBk.getCodDpto().intValue();
				int iiCodProv = msLocalBk.getCodProv().intValue();
				int iiCodDistr = msLocalBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msLocalBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msLocalBk.getEstado()!=null &&
		// msLocalBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msLocalBk.getEstado());
		// if(prtParametros!=null)
		// msLocalBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (msLocalBk.getIdSede() != null && msLocalBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(msLocalBk.getIdSede());
				if (msSedes != null)
					msLocalBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msLocalBk.getIdpais() != null && msLocalBk.getIdpais().longValue() > 0) {
				MsPaises msPaises = msPaisesDao.getMsPaises(msLocalBk.getIdpais());
				if (msPaises != null)
					msLocalBk.setIdpaisTxt(msPaises.getPaisNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public MsLocalBk saveorupdateMsLocalBk(MsLocalBk msLocalBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsLocalMng.validarMsLocalBk(msLocalBk);

		MsLocal msLocal = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msLocalBk.getIdLocal() != null && msLocalBk.getIdLocal().longValue() > 0) {

				msLocal = msLocalDao.getMsLocal(msLocalBk.getIdLocal());

				boolean cambios = AuditoriaMsLocalMng.auditarCambiosMsLocal(msLocalBk, msLocal, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msLocal.setRtmaddressrst(rmtaddress);
					msLocal.setIdduserModif(kyUsuarioMod);
					msLocal.setFechaModif(hoy);
					msLocalDao.updateMsLocal(msLocal);
				}
			} else {
				msLocalBk.setRtmaddress(rmtaddress);
				msLocalBk.setRtmaddressrst(rmtaddress);

				msLocalBk.setFechaCrea(hoy);
				msLocalBk.setIdduserCrea(kyUsuarioMod);
				msLocalBk.setIdduserModif(kyUsuarioMod);
				msLocalBk.setFechaModif(hoy);
				msLocalBk.setEstado(Estado.ACTIVO.getValor());

				msLocal = new MsLocal();

				FuncionesStaticas.copyPropertiesObject(msLocal, msLocalBk);
				msLocalDao.saveMsLocal(msLocal);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msLocal" + " :: " + msLocal.getIdLocal().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msLocalBk = getMsLocalBkXid(msLocal.getIdLocal(), kyUsuarioMod);
		return msLocalBk;
	}

	@Override
	public void deleteMsLocal(MsLocalBk msLocalBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsLocal msLocal = null;
			if (msLocalBk.getIdLocal() != null && msLocalBk.getIdLocal().longValue() > 0) {

				msLocal = msLocalDao.getMsLocal(msLocalBk.getIdLocal());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msLocal.setRtmaddressrst(rmtaddress);
				msLocal.setIdduserModif(kyUsuarioMod);
				msLocal.setFechaModif(hoy);
				Long estadoanterior = msLocal.getEstado();
				msLocal.setEstado(Estado.ELIMINADO.getValor());

				msLocalDao.updateMsLocal(msLocal);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msLocal"
								+ " :: " + msLocal.getIdLocal().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsLocal(MsLocalBk msLocalBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsLocal msLocal = null;
			if (msLocalBk.getIdLocal() != null && msLocalBk.getIdLocal().longValue() > 0) {

				msLocal = msLocalDao.getMsLocal(msLocalBk.getIdLocal());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msLocal.setRtmaddressrst(rmtaddress);
				msLocal.setIdduserModif(kyUsuarioMod);
				msLocal.setFechaModif(hoy);
				Long estadoanterior = msLocal.getEstado();
				msLocal.setEstado(Estado.ACTIVO.getValor());

				msLocalDao.updateMsLocal(msLocal);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msLocal"
								+ " :: " + msLocal.getIdLocal().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsLocalBk> getMsLocalXFiltro(String descripcion, String direccion, String referencia, Integer codDpto,
			Integer codProv, Integer codDistr, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsLocalBk> msLocalBkss = new ArrayList<MsLocalBk>();
		try {
			List<MsLocal> msLocalsss = msLocalDao.getXFiltro(descripcion, direccion, referencia, codDpto, codProv,
					codDistr, fechaModif, estado);
			for (MsLocal msLocal : msLocalsss) {
				MsLocalBk msLocalBk = new MsLocalBk();
				FuncionesStaticas.copyPropertiesObject(msLocalBk, msLocal);
				completarMsLocal(msLocalBk);
				setACLMsLocalBk(msLocalBk, kyUsuarioMod);
				msLocalBkss.add(msLocalBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msLocalBkss;
	}

	@Override
	public List<MsLocalBk> getMsLocalXFiltro(String descripcion, String direccion, String referencia, Integer codDpto,
			Integer codProv, Integer codDistr, Timestamp fechaModif, Long estado, int inicial, int MAX,
			Long kyUsuarioMod) {
		List<MsLocalBk> msLocalBkss = new ArrayList<MsLocalBk>();
		try {
			List<MsLocal> msLocalsss = msLocalDao.getXFiltro(descripcion, direccion, referencia, codDpto, codProv,
					codDistr, fechaModif, estado, inicial, MAX);
			for (MsLocal msLocal : msLocalsss) {
				MsLocalBk msLocalBk = new MsLocalBk();
				FuncionesStaticas.copyPropertiesObject(msLocalBk, msLocal);
				completarMsLocal(msLocalBk);
				setACLMsLocalBk(msLocalBk, kyUsuarioMod);
				msLocalBkss.add(msLocalBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msLocalBkss;
	}

	@Override
	public Long getMsLocalTotalXFiltro(String descripcion, String direccion, String referencia, Integer codDpto,
			Integer codProv, Integer codDistr, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsLocalsss = msLocalDao.getTotalXFiltro(descripcion, direccion, referencia, codDpto, codProv,
					codDistr, fechaModif, estado);

			return totalMsLocalsss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsLocalBk(MsLocalBk msLocalBk, Long kyUsuarioMod) {
		MsLocalACL msLocalACL = new MsLocalACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSLOCAL_CREA)) {
					msLocalACL.setEsEditable(true);
					msLocalACL.setEliminar(true);
				} else if (roles.contains(Roles.MSLOCAL_VE)) {
					msLocalACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSLOCAL_CREA)) {
					msLocalACL.setEditopcion(1);
				} else {
					msLocalACL.setEditopcion(2);
				}
			} else {
				msLocalACL.setEditopcion(2);
			}
		} else {
			msLocalACL.setEditopcion(2);
		}
		msLocalBk.setMsLocalACL(msLocalACL);
	}

	/// ADICIONALES

	/**
	 * MS_META SERVICIO: LISTA DE LAS METAS CON SUS VALORES
	 */
	@Override
	public MsMetaBk getMsMetaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsMeta msMeta = msMetaDao.getMsMeta(id);
		MsMetaBk msMetaBk = null;
		if (msMeta != null) {
			msMetaBk = new MsMetaBk();
			FuncionesStaticas.copyPropertiesObject(msMetaBk, msMeta);
			completarMsMeta(msMetaBk);
			if (kyUsuarioMod != null)
				setACLMsMetaBk(msMetaBk, kyUsuarioMod);
		}
		return msMetaBk;
	}

	@Override
	public List<MsMetaBk> getAllMsMetaActivos(Long kyUsuarioMod) {
		List<MsMetaBk> msMetaBkss = new ArrayList<MsMetaBk>();
		try {
			List<MsMeta> msMetas = msMetaDao.getActivasMsMeta();
			for (MsMeta msMeta : msMetas) {
				MsMetaBk msMetaBk = new MsMetaBk();
				FuncionesStaticas.copyPropertiesObject(msMetaBk, msMeta);
				completarMsMeta(msMetaBk);
				setACLMsMetaBk(msMetaBk, kyUsuarioMod);
				msMetaBkss.add(msMetaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msMetaBkss;
	}

	@Override
	public List<MsMetaBk> getAllMsMetaActivosCero(Long kyUsuarioMod) {
		List<MsMetaBk> msMetaBkss = new ArrayList<MsMetaBk>();
		try {
			List<MsMeta> msMetas = msMetaDao.getActivasMsMetaCero();
			for (MsMeta msMeta : msMetas) {
				MsMetaBk msMetaBk = new MsMetaBk();
				FuncionesStaticas.copyPropertiesObject(msMetaBk, msMeta);
				completarMsMeta(msMetaBk);
				setACLMsMetaBk(msMetaBk, kyUsuarioMod);
				msMetaBkss.add(msMetaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msMetaBkss;
	}

	private void completarMsMeta(MsMetaBk msMetaBk) {
		try {
			if (msMetaBk.getIdTipoServicio() != null && msMetaBk.getIdTipoServicio().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msMetaBk.getIdTipoServicio());
				if (prtParametros != null)
					msMetaBk.setIdTipoServicioTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msMetaBk.getIdSistAdmi() != null && msMetaBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(msMetaBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					msMetaBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msMetaBk.getIdSede() != null && msMetaBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(msMetaBk.getIdSede());
				if (msSedes != null)
					msMetaBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msMetaBk.getEstado()!=null && msMetaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msMetaBk.getEstado());
		// if(prtParametros!=null)
		// msMetaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsMetaBk saveorupdateMsMetaBk(MsMetaBk msMetaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsMetaMng.validarMsMetaBk(msMetaBk);

		MsMeta msMeta = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msMetaBk.getIdMeta() != null && msMetaBk.getIdMeta().longValue() > 0) {

				msMeta = msMetaDao.getMsMeta(msMetaBk.getIdMeta());

				boolean cambios = AuditoriaMsMetaMng.auditarCambiosMsMeta(msMetaBk, msMeta, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msMeta.setRtmaddressrst(rmtaddress);
					msMeta.setIdusserModif(kyUsuarioMod);
					msMeta.setFechaModif(hoy);
					msMetaDao.updateMsMeta(msMeta);
				}
			} else {
				msMetaBk.setRtmaddress(rmtaddress);
				msMetaBk.setRtmaddressrst(rmtaddress);

				msMetaBk.setFechaCrea(hoy);
				msMetaBk.setIdusserCrea(kyUsuarioMod);
				msMetaBk.setIdusserModif(kyUsuarioMod);
				msMetaBk.setFechaModif(hoy);
				msMetaBk.setEstado(Estado.ACTIVO.getValor());

				msMeta = new MsMeta();

				FuncionesStaticas.copyPropertiesObject(msMeta, msMetaBk);
				msMetaDao.saveMsMeta(msMeta);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msMeta" + " :: " + msMeta.getIdMeta().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msMetaBk = getMsMetaBkXid(msMeta.getIdMeta(), kyUsuarioMod);
		return msMetaBk;
	}

	@Override
	public void deleteMsMeta(MsMetaBk msMetaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsMeta msMeta = null;
			if (msMetaBk.getIdMeta() != null && msMetaBk.getIdMeta().longValue() > 0) {

				msMeta = msMetaDao.getMsMeta(msMetaBk.getIdMeta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msMeta.setRtmaddressrst(rmtaddress);
				msMeta.setIdusserModif(kyUsuarioMod);
				msMeta.setFechaModif(hoy);
				Long estadoanterior = msMeta.getEstado();
				msMeta.setEstado(Estado.ELIMINADO.getValor());

				msMetaDao.updateMsMeta(msMeta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msMeta"
								+ " :: " + msMeta.getIdMeta().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsMeta(MsMetaBk msMetaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsMeta msMeta = null;
			if (msMetaBk.getIdMeta() != null && msMetaBk.getIdMeta().longValue() > 0) {

				msMeta = msMetaDao.getMsMeta(msMetaBk.getIdMeta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msMeta.setRtmaddressrst(rmtaddress);
				msMeta.setIdusserModif(kyUsuarioMod);
				msMeta.setFechaModif(hoy);
				Long estadoanterior = msMeta.getEstado();
				msMeta.setEstado(Estado.ACTIVO.getValor());

				msMetaDao.updateMsMeta(msMeta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msMeta"
								+ " :: " + msMeta.getIdMeta().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsMetaBk> getMsMetaXFiltro(Integer annio, Long idTipoServicio, Long idSistAdmi, Long idSede, Long valor,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsMetaBk> msMetaBkss = new ArrayList<MsMetaBk>();
		try {
			List<MsMeta> msMetasss = msMetaDao.getXFiltro(annio, idTipoServicio, idSistAdmi, idSede, valor, fechaCrea,
					fechaModif, estado);
			for (MsMeta msMeta : msMetasss) {
				MsMetaBk msMetaBk = new MsMetaBk();
				FuncionesStaticas.copyPropertiesObject(msMetaBk, msMeta);
				completarMsMeta(msMetaBk);
				setACLMsMetaBk(msMetaBk, kyUsuarioMod);
				msMetaBkss.add(msMetaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msMetaBkss;
	}

	@Override
	public List<MsMetaBk> getMsMetaXFiltro(Integer annio, Long idTipoServicio, Long idSistAdmi, Long idSede, Long valor,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsMetaBk> msMetaBkss = new ArrayList<MsMetaBk>();
		try {
			List<MsMeta> msMetasss = msMetaDao.getXFiltro(annio, idTipoServicio, idSistAdmi, idSede, valor, fechaCrea,
					fechaModif, estado, inicial, MAX);
			for (MsMeta msMeta : msMetasss) {
				MsMetaBk msMetaBk = new MsMetaBk();
				FuncionesStaticas.copyPropertiesObject(msMetaBk, msMeta);
				completarMsMeta(msMetaBk);
				setACLMsMetaBk(msMetaBk, kyUsuarioMod);
				msMetaBkss.add(msMetaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msMetaBkss;
	}

	@Override
	public Long getMsMetaTotalXFiltro(Integer annio, Long idTipoServicio, Long idSistAdmi, Long idSede, Long valor,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsMetasss = msMetaDao.getTotalXFiltro(annio, idTipoServicio, idSistAdmi, idSede, valor, fechaCrea,
					fechaModif, estado);

			return totalMsMetasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsMetaBk(MsMetaBk msMetaBk, Long kyUsuarioMod) {
		MsMetaACL msMetaACL = new MsMetaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSMETA_CREA)) {
					msMetaACL.setEsEditable(true);
					msMetaACL.setEliminar(true);
				} else if (roles.contains(Roles.MSMETA_VE)) {
					msMetaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSMETA_CREA)) {
					msMetaACL.setEditopcion(1);
				} else {
					msMetaACL.setEditopcion(2);
				}
			} else {
				msMetaACL.setEditopcion(2);
			}
		} else {
			msMetaACL.setEditopcion(2);
		}
		msMetaBk.setMsMetaACL(msMetaACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdTipoServicio() {
		if (prtParametrosIdparametroIdTipoServicioListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdTipoServicioListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdTipoServicioListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdTipoServicioListaCache;
	}

	/**
	 * MS_ALERTA SERVICIO: LISTA DE LAS ALERTAS GENERADAS EN EL SISTMA
	 */
	@Override
	public MsAlertaBk getMsAlertaBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsAlerta msAlerta = msAlertaDao.getMsAlerta(id);
		MsAlertaBk msAlertaBk = null;
		if (msAlerta != null) {
			msAlertaBk = new MsAlertaBk();
			FuncionesStaticas.copyPropertiesObject(msAlertaBk, msAlerta);
			completarMsAlerta(msAlertaBk);
			if (kyUsuarioMod != null)
				setACLMsAlertaBk(msAlertaBk, kyUsuarioMod);
		}
		return msAlertaBk;
	}

	@Override
	public List<MsAlertaBk> getAllMsAlertaActivos(Long kyUsuarioMod) {
		List<MsAlertaBk> msAlertaBkss = new ArrayList<MsAlertaBk>();
		try {
			List<MsAlerta> msAlertas = msAlertaDao.getActivasMsAlerta();
			for (MsAlerta msAlerta : msAlertas) {
				MsAlertaBk msAlertaBk = new MsAlertaBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaBk, msAlerta);
				completarMsAlerta(msAlertaBk);
				setACLMsAlertaBk(msAlertaBk, kyUsuarioMod);
				msAlertaBkss.add(msAlertaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaBkss;
	}

	@Override
	public List<MsAlertaBk> getAllMsAlertaActivosCero(Long kyUsuarioMod) {
		List<MsAlertaBk> msAlertaBkss = new ArrayList<MsAlertaBk>();
		try {
			List<MsAlerta> msAlertas = msAlertaDao.getActivasMsAlertaCero();
			for (MsAlerta msAlerta : msAlertas) {
				MsAlertaBk msAlertaBk = new MsAlertaBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaBk, msAlerta);
				completarMsAlerta(msAlertaBk);
				setACLMsAlertaBk(msAlertaBk, kyUsuarioMod);
				msAlertaBkss.add(msAlertaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaBkss;
	}

	private void completarMsAlerta(MsAlertaBk msAlertaBk) {
		try {
			if (msAlertaBk.getIdCaracterst() != null && msAlertaBk.getIdCaracterst().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msAlertaBk.getIdCaracterst());
				if (prtParametros != null)
					msAlertaBk.setIdCaracterstTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msAlertaBk.getDia() != null && msAlertaBk.getDia().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msAlertaBk.getDia().longValue());
				if (prtParametros != null)
					msAlertaBk.setDiaTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msAlertaBk.getHora() != null && msAlertaBk.getHora().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msAlertaBk.getHora().longValue());
				if (prtParametros != null)
					msAlertaBk.setHoraTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// try{
		// if(msAlertaBk.getEstado()!=null &&
		// msAlertaBk.getEstado().longValue()>0){
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msAlertaBk.getEstado());
		// if(prtParametros!=null)
		// msAlertaBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public MsAlertaBk saveorupdateMsAlertaBk(MsAlertaBk msAlertaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsAlertaMng.validarMsAlertaBk(msAlertaBk);

		MsAlerta msAlerta = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msAlertaBk.getIdAlerta() != null && msAlertaBk.getIdAlerta().longValue() > 0) {

				msAlerta = msAlertaDao.getMsAlerta(msAlertaBk.getIdAlerta());

				boolean cambios = AuditoriaMsAlertaMng.auditarCambiosMsAlerta(msAlertaBk, msAlerta, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msAlerta.setRtmaddressrst(rmtaddress);
					msAlerta.setIdusserModif(kyUsuarioMod);
					msAlerta.setFechaModif(hoy);
					msAlertaDao.updateMsAlerta(msAlerta);
				}
			} else {
				msAlertaBk.setRtmaddress(rmtaddress);
				msAlertaBk.setRtmaddressrst(rmtaddress);

				msAlertaBk.setFechaCrea(hoy);
				msAlertaBk.setIdusserCrea(kyUsuarioMod);
				msAlertaBk.setIdusserModif(kyUsuarioMod);
				msAlertaBk.setFechaModif(hoy);
				msAlertaBk.setEstado(Estado.ACTIVO.getValor());

				msAlerta = new MsAlerta();

				FuncionesStaticas.copyPropertiesObject(msAlerta, msAlertaBk);
				msAlertaDao.saveMsAlerta(msAlerta);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msAlerta" + " :: " + msAlerta.getIdAlerta().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msAlertaBk = getMsAlertaBkXid(msAlerta.getIdAlerta(), kyUsuarioMod);
		return msAlertaBk;
	}

	@Override
	public void deleteMsAlerta(MsAlertaBk msAlertaBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsAlerta msAlerta = null;
			if (msAlertaBk.getIdAlerta() != null && msAlertaBk.getIdAlerta().longValue() > 0) {

				msAlerta = msAlertaDao.getMsAlerta(msAlertaBk.getIdAlerta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msAlerta.setRtmaddressrst(rmtaddress);
				msAlerta.setIdusserModif(kyUsuarioMod);
				msAlerta.setFechaModif(hoy);
				Long estadoanterior = msAlerta.getEstado();
				msAlerta.setEstado(Estado.ELIMINADO.getValor());

				msAlertaDao.updateMsAlerta(msAlerta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msAlerta" + " :: " + msAlerta.getIdAlerta().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void activarMsAlerta(MsAlertaBk msAlertaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsAlerta msAlerta = null;
			if (msAlertaBk.getIdAlerta() != null && msAlertaBk.getIdAlerta().longValue() > 0) {

				msAlerta = msAlertaDao.getMsAlerta(msAlertaBk.getIdAlerta());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msAlerta.setRtmaddressrst(rmtaddress);
				msAlerta.setIdusserModif(kyUsuarioMod);
				msAlerta.setFechaModif(hoy);
				Long estadoanterior = msAlerta.getEstado();
				msAlerta.setEstado(Estado.ACTIVO.getValor());

				msAlertaDao.updateMsAlerta(msAlerta);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msAlerta" + " :: " + msAlerta.getIdAlerta().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsAlertaBk> getMsAlertaXFiltro(Long idCaracterst, String otrosDestin, Integer dia, Integer hora,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		List<MsAlertaBk> msAlertaBkss = new ArrayList<MsAlertaBk>();
		try {
			List<MsAlerta> msAlertasss = msAlertaDao.getXFiltro(idCaracterst, otrosDestin, dia, hora, fechaCrea,
					fechaModif, estado);
			for (MsAlerta msAlerta : msAlertasss) {
				MsAlertaBk msAlertaBk = new MsAlertaBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaBk, msAlerta);
				completarMsAlerta(msAlertaBk);
				setACLMsAlertaBk(msAlertaBk, kyUsuarioMod);
				msAlertaBkss.add(msAlertaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaBkss;
	}

	@Override
	public List<MsAlertaBk> getMsAlertaXFiltro(Long idCaracterst, String otrosDestin, Integer dia, Integer hora,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsAlertaBk> msAlertaBkss = new ArrayList<MsAlertaBk>();
		try {
			List<MsAlerta> msAlertasss = msAlertaDao.getXFiltro(idCaracterst, otrosDestin, dia, hora, fechaCrea,
					fechaModif, estado, inicial, MAX);
			for (MsAlerta msAlerta : msAlertasss) {
				MsAlertaBk msAlertaBk = new MsAlertaBk();
				FuncionesStaticas.copyPropertiesObject(msAlertaBk, msAlerta);
				completarMsAlerta(msAlertaBk);
				setACLMsAlertaBk(msAlertaBk, kyUsuarioMod);
				msAlertaBkss.add(msAlertaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msAlertaBkss;
	}

	@Override
	public Long getMsAlertaTotalXFiltro(Long idCaracterst, String otrosDestin, Integer dia, Integer hora,
			Timestamp fechaCrea, Timestamp fechaModif, Long estado, Long kyUsuarioMod) {
		try {
			Long totalMsAlertasss = msAlertaDao.getTotalXFiltro(idCaracterst, otrosDestin, dia, hora, fechaCrea,
					fechaModif, estado);

			return totalMsAlertasss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsAlertaBk(MsAlertaBk msAlertaBk, Long kyUsuarioMod) {
		MsAlertaACL msAlertaACL = new MsAlertaACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msUsuariosBk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msUsuariosBk != null && msUsuariosBk.getRolesSistema() != null) {
				List<String> roles = msUsuariosBk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSALERTA_CREA)) {
					msAlertaACL.setEsEditable(true);
					msAlertaACL.setEliminar(true);
				} else if (roles.contains(Roles.MSALERTA_VE)) {
					msAlertaACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSALERTA_CREA)) {
					msAlertaACL.setEditopcion(1);
				} else {
					msAlertaACL.setEditopcion(2);
				}
			} else {
				msAlertaACL.setEditopcion(2);
			}
		} else {
			msAlertaACL.setEditopcion(2);
		}
		msAlertaBk.setMsAlertaACL(msAlertaACL);
	}

	/// ADICIONALES

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdCaracterst() {
		if (prtParametrosIdparametroIdCaracterstListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroIdCaracterstListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdCaracterstListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdCaracterstListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroDia() {
		if (prtParametrosIdparametroDiaListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroDiaListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroDiaListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroDiaListaCache;
	}

	/**
	 * ADICIONAR EN EL prtParametrosDao
	 * 
	 * @Override public List<PrtParametros> getListaIdparametro() { StringBuffer
	 *           sb = new StringBuffer(100); sb.append("SELECT tablaa FROM
	 *           PrtParametros tablaa "); sb.append("WHERE tablaa.estado >= 1
	 *           "); sb.append("ORDER BY tablaa.idparametro asc "); return
	 *           super.find(sb.toString()); }
	 **/
	@Override
	public List<IDValorDto> getPrtParametrosIdparametroHora() {
		if (prtParametrosIdparametroHoraListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getListaIdparametro();
			prtParametrosIdparametroHoraListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroHoraListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroHoraListaCache;
	}

	/**
	 * MS_USUARIOS SERVICIO: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL
	 * SISTEMA "USUARIOS INTERNOS"
	 */
	@Override
	public MsUsuariosBk getMsUsuariosBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(id);
		MsUsuariosBk msUsuariosBk = null;
		if (msUsuarios != null) {
			msUsuariosBk = new MsUsuariosBk();
			FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
			completarMsUsuarios(msUsuariosBk);
			if (kyUsuarioMod != null)
				setACLMsUsuariosBk(msUsuariosBk, kyUsuarioMod);
		}
		return msUsuariosBk;
	}

	@Override
	public List<MsUsuariosBk> getAllMsUsuariosActivos(Long kyUsuarioMod) {
		List<MsUsuariosBk> msUsuariosBkss = new ArrayList<MsUsuariosBk>();
		try {
			List<MsUsuarios> msUsuarioss = msUsuariosDao.getActivasMsUsuarios();
			for (MsUsuarios msUsuarios : msUsuarioss) {
				MsUsuariosBk msUsuariosBk = new MsUsuariosBk();
				FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
				completarMsUsuarios(msUsuariosBk);
				setACLMsUsuariosBk(msUsuariosBk, kyUsuarioMod);
				msUsuariosBkss.add(msUsuariosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUsuariosBkss;
	}

	@Override
	public List<MsUsuariosBk> getAllMsUsuariosActivosCero(Long kyUsuarioMod) {
		List<MsUsuariosBk> msUsuariosBkss = new ArrayList<MsUsuariosBk>();
		try {
			List<MsUsuarios> msUsuarioss = msUsuariosDao.getActivasMsUsuariosCero();
			for (MsUsuarios msUsuarios : msUsuarioss) {
				MsUsuariosBk msUsuariosBk = new MsUsuariosBk();
				FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
				completarMsUsuarios(msUsuariosBk);
				setACLMsUsuariosBk(msUsuariosBk, kyUsuarioMod);
				msUsuariosBkss.add(msUsuariosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUsuariosBkss;
	}

	private void completarMsUsuarios(MsUsuariosBk msUsuariosBk) {
		// try {
		// if (msUsuariosBk.getEstado() != null &&
		// msUsuariosBk.getEstado().longValue() > 0) {
		// PrtParametros prtParametros =
		// prtParametrosDao.getPrtParametros(msUsuariosBk.getEstado());
		// if (prtParametros != null)
		// msUsuariosBk.setEstadoTxt(prtParametros.getDescripcion());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			if (msUsuariosBk.getIdCargo() != null && msUsuariosBk.getIdCargo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msUsuariosBk.getIdCargo());
				if (prtParametros != null)
					msUsuariosBk.setIdCargoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (msUsuariosBk.getCodDpto() != null && msUsuariosBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = msUsuariosBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msUsuariosBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUsuariosBk.getCodDpto() != null && msUsuariosBk.getCodDpto().intValue() > 0
					&& msUsuariosBk.getCodProv() != null && msUsuariosBk.getCodProv().intValue() > 0) {
				int iiCodDpto = msUsuariosBk.getCodDpto().intValue();
				int iiCodProv = msUsuariosBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msUsuariosBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUsuariosBk.getCodDpto() != null && msUsuariosBk.getCodDpto().intValue() > 0
					&& msUsuariosBk.getCodProv() != null && msUsuariosBk.getCodProv().intValue() > 0
					&& msUsuariosBk.getCodDistr() != null && msUsuariosBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = msUsuariosBk.getCodDpto().intValue();
				int iiCodProv = msUsuariosBk.getCodProv().intValue();
				int iiCodDistr = msUsuariosBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					msUsuariosBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUsuariosBk.getIdpais() != null && msUsuariosBk.getIdpais().longValue() > 0) {
				MsPaises msPaises = msPaisesDao.getMsPaises(msUsuariosBk.getIdpais());
				if (msPaises != null)
					msUsuariosBk.setIdpaisTxt(msPaises.getPaisNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUsuariosBk.getIdSistAdmi() != null && msUsuariosBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(msUsuariosBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					msUsuariosBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUsuariosBk.getIdSede() != null && msUsuariosBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(msUsuariosBk.getIdSede());
				if (msSedes != null)
					msUsuariosBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msUsuariosBk.getIdCondlabr() != null && msUsuariosBk.getIdCondlabr().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msUsuariosBk.getIdCondlabr());
				if (prtParametros != null)
					msUsuariosBk.setIdCondlabrTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (msUsuariosBk.getUsername() != null && msUsuariosBk.getUsername().length() > 0) {
				List<String> roles = new ArrayList<String>();
				List<MsRoles> msRolesss = msRolesDao.getXFiltro(msUsuariosBk.getUsername(), null);
				List<String> rolesDesc = new ArrayList<String>();
				for (MsRoles msRoles : msRolesss) {
					roles.add(msRoles.getRol());
					rolesDesc.add(Roles.getDescripcion(msRoles.getRol()));
				}
				msUsuariosBk.setRolesSistema(roles);
				msUsuariosBk.setRolesSistemaDes(rolesDesc);
				List<String> perfilesSistema = new ArrayList<String>();
				for (String key : Roles.ROLES_POR_PERFIL.keySet()) {
					List<String> rolesdelperfil = Roles.ROLES_POR_PERFIL.get(key);
					boolean tieneelperfil = true;

					if (key.equals(Roles.PERFIL_USUARIO_EXTERNO_OGC)
							&& perfilesSistema.contains(Roles.PERFIL_USU_OGC)) {
						continue;
					}
					if (key.equals(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)
							&& perfilesSistema.contains(Roles.PERFIL_USU_OGC)) {
						continue;
					}
					if (key.equals(Roles.PERFIL_USUARIO_EXTERNO_OGC)
							&& perfilesSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
						continue;
					}
					if (key.equals(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)
							&& perfilesSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
						continue;
					}
					if (key.equals(Roles.PERFIL_ADMIN_REPORTES)
							&& perfilesSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
						continue;
					}
					if (key.equals(Roles.PERFIL_USU_OGC) && perfilesSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
						continue;
					}
					if (key.equals(Roles.PERFIL_GC) && perfilesSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
						continue;
					}

					for (String rolp : rolesdelperfil) {
						if (!roles.contains(rolp)) {
							tieneelperfil = false;
							break;
						}
					}
					if (tieneelperfil) {
						perfilesSistema.add(key);

						if (key.equals(Roles.PERFIL_USU_OGC)
								&& perfilesSistema.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
							perfilesSistema.remove(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT);
						}
						if (key.equals(Roles.PERFIL_USU_OGC)
								&& perfilesSistema.contains(Roles.PERFIL_USUARIO_EXTERNO_OGC)) {
							perfilesSistema.remove(Roles.PERFIL_USUARIO_EXTERNO_OGC);
						}
						if (key.equals(Roles.PERFIL_ADMINISTRADOR) && perfilesSistema.contains(Roles.PERFIL_USU_OGC)) {
							perfilesSistema.remove(Roles.PERFIL_USU_OGC);
						}
						if (key.equals(Roles.PERFIL_ADMINISTRADOR)
								&& perfilesSistema.contains(Roles.PERFIL_USUARIO_EXTERNO_OGC)) {
							perfilesSistema.remove(Roles.PERFIL_USUARIO_EXTERNO_OGC);
						}
						if (key.equals(Roles.PERFIL_ADMINISTRADOR)
								&& perfilesSistema.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
							perfilesSistema.remove(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT);
						}
						if (key.equals(Roles.PERFIL_ADMINISTRADOR)
								&& perfilesSistema.contains(Roles.PERFIL_ADMIN_REPORTES)) {
							perfilesSistema.remove(Roles.PERFIL_ADMIN_REPORTES);
						}
						if (key.equals(Roles.PERFIL_ADMINISTRADOR) && perfilesSistema.contains(Roles.PERFIL_GC)) {
							perfilesSistema.remove(Roles.PERFIL_GC);
						}
					}
				}
				msUsuariosBk.setPerfilesSistema(perfilesSistema);
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	@Override
	public MsUsuariosBk saveorupdateMsUsuariosBk(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, Long kySedeMod, String rmtaddress, boolean solocontrasenia) throws Validador {

		ValidacionMsUsuariosMng.validarMsUsuariosBk(msUsuariosBk, solocontrasenia);

		if (msUsuariosBk.getContrasenia() != null && msUsuariosBk.getContrasenia().length() >= 6) {
			Encriptar enc = new Encriptar();
			String emcriptado = enc.EncriptarData(msUsuariosBk.getUsername().toLowerCase(),
					msUsuariosBk.getContrasenia());
			msUsuariosBk.setContrasenia(emcriptado);
		}
		// SI USUARIO ES NUEVO VERIFICAR QUE NOMBRE DE USUARIO NO SE REPITA
		if (msUsuariosBk.getIdusuario() == null || msUsuariosBk.getIdusuario().longValue() <= 0) {
			List<MsUsuarios> msUsuariosList = msUsuariosDao.getAllMsUsuarios();
			for (MsUsuarios msUsuarioss : msUsuariosList) {
				if (msUsuariosBk.getUsername().toString().equals(msUsuarioss.getUsername().toString())
						&& msUsuariosBk.getIdusuario() != msUsuarioss.getIdusuario()) {
					throw new Validador(Messages.getStringToKey("msUsuariosRegistro.usuario_ya_existe"));
				}
			}
		}

		///////////
		List<String> perfilesOldSistema = new ArrayList<String>();
		if (msUsuariosBk.getUsername() != null && msUsuariosBk.getUsername().length() > 0) {
			List<String> roles = new ArrayList<String>();
			List<MsRoles> msRolesss = msRolesDao.getXFiltro(msUsuariosBk.getUsername());
			for (MsRoles msRoles : msRolesss) {
				roles.add(msRoles.getRol());
			}
			for (String key : Roles.ROLES_POR_PERFIL.keySet()) {
				List<String> rolesdelperfil = Roles.ROLES_POR_PERFIL.get(key);
				boolean tieneelperfil = true;
				if (key.equals(Roles.PERFIL_USUARIO_EXTERNO_OGC) && perfilesOldSistema.contains(Roles.PERFIL_USU_OGC)) {
					continue;
				}
				if (key.equals(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)
						&& perfilesOldSistema.contains(Roles.PERFIL_USU_OGC)) {
					continue;
				}
				if (key.equals(Roles.PERFIL_USUARIO_EXTERNO_OGC)
						&& perfilesOldSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
					continue;
				}
				if (key.equals(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)
						&& perfilesOldSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
					continue;
				}
				if (key.equals(Roles.PERFIL_ADMIN_REPORTES)
						&& perfilesOldSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
					continue;
				}
				if (key.equals(Roles.PERFIL_USU_OGC) && perfilesOldSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
					continue;
				}
				if (key.equals(Roles.PERFIL_GC) && perfilesOldSistema.contains(Roles.PERFIL_ADMINISTRADOR)) {
					continue;
				}
				for (String rolp : rolesdelperfil) {
					if (!roles.contains(rolp)) {
						tieneelperfil = false;
						break;
					}
				}
				if (tieneelperfil) {
					perfilesOldSistema.add(key);

					if (key.equals(Roles.PERFIL_USU_OGC)
							&& perfilesOldSistema.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
						perfilesOldSistema.remove(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT);
					}
					if (key.equals(Roles.PERFIL_USU_OGC)
							&& perfilesOldSistema.contains(Roles.PERFIL_USUARIO_EXTERNO_OGC)) {
						perfilesOldSistema.remove(Roles.PERFIL_USUARIO_EXTERNO_OGC);
					}
					if (key.equals(Roles.PERFIL_ADMINISTRADOR) && perfilesOldSistema.contains(Roles.PERFIL_USU_OGC)) {
						perfilesOldSistema.remove(Roles.PERFIL_USU_OGC);
					}
					if (key.equals(Roles.PERFIL_ADMINISTRADOR)
							&& perfilesOldSistema.contains(Roles.PERFIL_USUARIO_EXTERNO_OGC)) {
						perfilesOldSistema.remove(Roles.PERFIL_USUARIO_EXTERNO_OGC);
					}
					if (key.equals(Roles.PERFIL_ADMINISTRADOR)
							&& perfilesOldSistema.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)) {
						perfilesOldSistema.remove(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT);
					}
					if (key.equals(Roles.PERFIL_ADMINISTRADOR)
							&& perfilesOldSistema.contains(Roles.PERFIL_ADMIN_REPORTES)) {
						perfilesOldSistema.remove(Roles.PERFIL_ADMIN_REPORTES);
					}
					if (key.equals(Roles.PERFIL_ADMINISTRADOR) && perfilesOldSistema.contains(Roles.PERFIL_GC)) {
						perfilesOldSistema.remove(Roles.PERFIL_GC);
					}
				}
			}
		}

		List<String> perfilesSistema = msUsuariosBk.getPerfilesSistema();
		List<String> roles = msUsuariosBk.getRolesSistema();
		for (String key : perfilesOldSistema) {
			if (!perfilesSistema.contains(key)) {
				List<String> rolesdelperfil = Roles.ROLES_POR_PERFIL.get(key);
				for (String rol : rolesdelperfil) {
					if (roles.contains(rol)) {
						roles.remove(rol);
					}
				}
			}
		}
		//////////

		if (perfilesSistema != null && perfilesSistema.size() > 0) {
			for (String perfil : perfilesSistema) {
				List<String> rolesdelperfil = Roles.ROLES_POR_PERFIL.get(perfil);
				if (rolesdelperfil != null && rolesdelperfil.size() > 0) {
					if (roles == null) {
						roles = new ArrayList<String>();
					}
					for (String rolp : rolesdelperfil) {
						if (!roles.contains(rolp)) {
							roles.add(rolp);
						}
					}
				}
			}
		}

		if (roles == null) {
			throw new Validador(Messages.getStringToKey("msUsuariosRegistro.no_se_asigno_roles"));
		} else if (roles.size() <= 0) {
			throw new Validador(Messages.getStringToKey("msUsuariosRegistro.no_se_asigno_roles"));
		}

		// ********************************
		// List<String> roles = msUsuariosBk.getRolesSistema();
		//
		// List<String> perfilesSistema = msUsuariosBk.getPerfilesSistema();
		// if (perfilesSistema != null && perfilesSistema.size() > 0) {
		// for (String perfil : perfilesSistema) {
		// List<String> rolesdelperfil = Roles.ROLES_POR_PERFIL.get(perfil);
		// if (rolesdelperfil != null && rolesdelperfil.size() > 0) {
		// if (roles == null) {
		// roles = new ArrayList<String>();
		// }
		// for (String rolp : rolesdelperfil) {
		// if (!roles.contains(rolp)) {
		// roles.add(rolp);
		// }
		// }
		// }
		// }
		// }
		//
		// if (roles == null) {
		// throw new
		// Validador(Messages.getStringToKey("msUsuariosRegistro.no_se_asigno_roles"));
		// } else if (roles.size() <= 0) {
		// throw new
		// Validador(Messages.getStringToKey("msUsuariosRegistro.no_se_asigno_roles"));
		// }
		// --------------------------------------------------

		MsUsuarios msUsuarios = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msUsuariosBk.getIdusuario() != null && msUsuariosBk.getIdusuario().longValue() > 0) {
				msUsuarios = msUsuariosDao.getMsUsuarios(msUsuariosBk.getIdusuario());
				boolean cambios = AuditoriaMsUsuariosMng.auditarCambiosMsUsuarios(msUsuariosBk, msUsuarios,
						kyUsuarioMod, user, rmtaddress, nivel);
				if (cambios) {
					msUsuarios.setRtmaddressmodif(rmtaddress);
					msUsuarios.setIduserModif(kyUsuarioMod);
					msUsuarios.setFechaModif(hoy);
					msUsuariosDao.updateMsUsuarios(msUsuarios);
				}
			} else {
				msUsuariosBk.setRtmaddress(rmtaddress);
				msUsuariosBk.setRtmaddressmodif(rmtaddress);
				// msUsuariosBk.setIdsede(kySedeMod);
				// msUsuariosBk.setIdunidad(kyAreaMod);

				msUsuariosBk.setFechaCrea(hoy);
				msUsuariosBk.setIduserCrea(kyUsuarioMod);
				msUsuariosBk.setIduserModif(kyUsuarioMod);
				msUsuariosBk.setFechaModif(hoy);
				msUsuariosBk.setEstado(Estado.ACTIVO.getValor());

				msUsuarios = new MsUsuarios();

				FuncionesStaticas.copyPropertiesObject(msUsuarios, msUsuariosBk);
				msUsuariosDao.saveMsUsuarios(msUsuarios);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "CREADO msUsuarios"
								+ " :: " + msUsuarios.getIdusuario().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		// -----------------------ROLES------------------------
		// --ELIMINAR
		List<MsRoles> msRolesss = msRolesDao.getXFiltro(msUsuarios.getUsername(), null);
		for (MsRoles msRoles : msRolesss) {
			if (!roles.contains(msRoles.getRol())) {
				MsRolesBk msRolesBk = new MsRolesBk();
				FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
				msRolesBk.setEstado(Estado.ELIMINADO.getValor());
				saveorupdateMsRolesBk(msRolesBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
			}
		}
		// --
		// --CREAR
		for (String rol : roles) {
			MsRoles msRoles = msRolesDao.getXUserRol(msUsuarios.getUsername(), rol);
			if (msRoles != null) {
				MsRolesBk msRolesBk = new MsRolesBk();
				FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
				if (msRolesBk.getEstado() == null || msRolesBk.getEstado().intValue() != 1) {
					msRolesBk.setEstado(Estado.ACTIVO.getValor());
					saveorupdateMsRolesBk(msRolesBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
				}
			} else {
				MsRolesBk msRolesBk = new MsRolesBk();
				msRolesBk.setUsername(msUsuarios.getUsername());
				msRolesBk.setRol(rol);
				msRolesBk.setEstado(Estado.ACTIVO.getValor());
				saveorupdateMsRolesBk(msRolesBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
			}
		}
		// --
		// -----------------------------------------------

		msUsuariosBk = getMsUsuariosBkXid(msUsuarios.getIdusuario(), kyUsuarioMod);

		msUsuariosBkCache = null;
		msUsuariosBkXUseranameCache = null;
		cacheMsUsuariosBkActivos = null;

		return msUsuariosBk;
	}

	@Override
	public void activarMsUsuarios(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsUsuarios msUsuarios = null;
			if (msUsuariosBk.getIdusuario() != null && msUsuariosBk.getIdusuario().longValue() > 0) {

				msUsuarios = msUsuariosDao.getMsUsuarios(msUsuariosBk.getIdusuario());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msUsuarios.setRtmaddressmodif(rmtaddress);
				msUsuarios.setIduserModif(kyUsuarioMod);
				msUsuarios.setFechaModif(hoy);
				Long estadoanterior = msUsuarios.getEstado();
				msUsuarios.setEstado(Estado.ACTIVO.getValor());

				msUsuariosDao.updateMsUsuarios(msUsuarios);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msUsuarios" + " :: " + msUsuarios.getIdusuario().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void deleteMsUsuarios(MsUsuariosBk msUsuariosBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			MsUsuarios msUsuarios = null;
			if (msUsuariosBk.getIdusuario() != null && msUsuariosBk.getIdusuario().longValue() > 0) {

				msUsuarios = msUsuariosDao.getMsUsuarios(msUsuariosBk.getIdusuario());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msUsuarios.setRtmaddressmodif(rmtaddress);
				msUsuarios.setIduserModif(kyUsuarioMod);
				msUsuarios.setFechaModif(hoy);
				Long estadoanterior = msUsuarios.getEstado();
				msUsuarios.setEstado(Estado.ELIMINADO.getValor());

				msUsuariosDao.updateMsUsuarios(msUsuarios);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO msUsuarios" + " :: " + msUsuarios.getIdusuario().toString() + " :: "
								+ estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public List<MsUsuariosBk> getMsUsuariosXFiltro(Long dni, String nombres, String apellidoPaterno,
			String apellidoMaterno, Timestamp fechaInic, Timestamp fechaCese, String direccion, String username,
			Integer codDpto, Integer codProv, Integer codDistr, Long kyUsuarioMod) {
		List<MsUsuariosBk> msUsuariosBkss = new ArrayList<MsUsuariosBk>();
		try {
			List<MsUsuarios> msUsuariossss = msUsuariosDao.getXFiltro(dni, nombres, apellidoPaterno, apellidoMaterno,
					fechaInic, fechaCese, direccion, username, codDpto, codProv, codDistr);
			for (MsUsuarios msUsuarios : msUsuariossss) {
				MsUsuariosBk msUsuariosBk = new MsUsuariosBk();
				FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
				completarMsUsuarios(msUsuariosBk);
				setACLMsUsuariosBk(msUsuariosBk, kyUsuarioMod);
				msUsuariosBkss.add(msUsuariosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUsuariosBkss;
	}

	@Override
	public List<MsUsuariosBk> getMsUsuariosXFiltro(Long dni, String nombres, String apellidoPaterno,
			String apellidoMaterno, Timestamp fechaInic, Timestamp fechaCese, String direccion, String username,
			Integer codDpto, Integer codProv, Integer codDistr, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsUsuariosBk> msUsuariosBkss = new ArrayList<MsUsuariosBk>();
		try {
			List<MsUsuarios> msUsuariossss = msUsuariosDao.getXFiltro(dni, nombres, apellidoPaterno, apellidoMaterno,
					fechaInic, fechaCese, direccion, username, codDpto, codProv, codDistr, inicial, MAX);
			for (MsUsuarios msUsuarios : msUsuariossss) {
				MsUsuariosBk msUsuariosBk = new MsUsuariosBk();
				FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
				completarMsUsuarios(msUsuariosBk);
				setACLMsUsuariosBk(msUsuariosBk, kyUsuarioMod);
				msUsuariosBkss.add(msUsuariosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msUsuariosBkss;
	}

	@Override
	public Long getMsUsuariosTotalXFiltro(Long dni, String nombres, String apellidoPaterno, String apellidoMaterno,
			Timestamp fechaInic, Timestamp fechaCese, String direccion, String username, Integer codDpto,
			Integer codProv, Integer codDistr, Long kyUsuarioMod) {
		try {
			Long totalMsUsuariossss = msUsuariosDao.getTotalXFiltro(dni, nombres, apellidoPaterno, apellidoMaterno,
					fechaInic, fechaCese, direccion, username, codDpto, codProv, codDistr);

			return totalMsUsuariossss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsUsuariosBk(MsUsuariosBk msUsuariosBk, Long kyUsuarioMod) {
		MsUsuariosACL msUsuariosACL = new MsUsuariosACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msusuariosbk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msusuariosbk != null && msusuariosbk.getRolesSistema() != null) {
				List<String> roles = msusuariosbk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUSUARIOS_CREA)) {
					msUsuariosACL.setEsEditable(true);
					msUsuariosACL.setEliminar(true);
				} else if (roles.contains(Roles.MSUSUARIOS_VE)) {
					msUsuariosACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUSUARIOS_CREA)) {
					msUsuariosACL.setEditopcion(1);
				} else {
					msUsuariosACL.setEditopcion(2);
				}
			} else {
				msUsuariosACL.setEditopcion(2);
			}
		} else {
			msUsuariosACL.setEditopcion(2);
		}
		msUsuariosBk.setMsUsuariosACL(msUsuariosACL);
	}

	/// ADICIONALES
	public void actualizarContraseniaMsUsuario(MsUsuariosBk ttUsuariosSistemaDto) throws Validador {

		if (ttUsuariosSistemaDto.getContrasenia().length() == 0) {
			throw new Validador("DEBE INGRESAR LA CONTRASEÑA");
		} else {
			if (ttUsuariosSistemaDto.getContrasenia().length() < 6) {
				throw new Validador("LA CONTRASEÑA DEBE CONTENER UN MÍNIMO DE 6 CARACTERES");
			} else {
				if (ttUsuariosSistemaDto.getContraseniaConfir().length() == 0) {
					throw new Validador("DEBE REPETIR LA CONTRASEÑA");
				} else {
					if (!ttUsuariosSistemaDto.getContrasenia().equals(ttUsuariosSistemaDto.getContraseniaConfir()))
						throw new Validador("ERROR LAS CONTRASEÑAS INGRESADAS NO COINCIDEN, VUELVA A INTENTARLO");
				}
			}
		}

		String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,100})";
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(ttUsuariosSistemaDto.getContrasenia());
		boolean resultado = matcher.matches();
		if (!resultado) {
			throw new Validador(
					"LA CONTRASEÑA DEBE AL MENOS CONTENER UN DÍGITO DE 0-9,  DEBE CONTENER AL MENOS UNA LETRA EN MINÚSCULA, DEBE CONTENER AL MENOS UNA LETRA MAYÚSCULA DEBE CONTENER UN SÍMBOLO ESPECIAL EN LA LISTA \"@ # $%\" Y DEBE TENER UNA LONGITUD DE AL MENOS 6 CARACTERES Y MÁXIMO DE 100.");
		}

		Encriptar enc = new Encriptar();
		String encriptado = enc.EncriptarData(ttUsuariosSistemaDto.getUsername().toLowerCase(),
				ttUsuariosSistemaDto.getContrasenia());

		Timestamp diahoy = new Timestamp(System.currentTimeMillis());

		MsUsuarios ttUsuariosSistema = msUsuariosDao.getMsUsuarios(ttUsuariosSistemaDto.getIdusuario());

		if (ttUsuariosSistema.getContrasenia() != null) {
			if (ttUsuariosSistema.getContrasenia().equals(encriptado))
				throw new Validador("LA NUEVA CONTRASEÑA NO PUEDE SER IGUAL A LA ANTERIOR CONTRASEÑA");
		}

		ttUsuariosSistema.setContrasenia(encriptado);
		ttUsuariosSistema.setFechaModif(diahoy);
		ttUsuariosSistema.setIduserModif(ttUsuariosSistemaDto.getIdusuario());
		try {
			msUsuariosDao.updateMsUsuarios(ttUsuariosSistema);
		} catch (Exception e) {
			throw new Validador(
					"ERROR:(actualizarContraseniaUsuariosSistema) INESPERADO: POR FAVOR ENVIE ESTE MENSAJE AL ADMINISTRADOR DEL SISTEMA, GRACIAS.\n"
							+ e.getMessage());
		}
	}

	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdCondlabr() {
		if (prtParametrosIdparametroIdCondlabrListaCache == null) {
			// List<PrtParametros> prtParametrossss =
			// prtParametrosDao.getListaIdparametro();
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("CONDICIÓN LABORAL");
			if (prtParametrossss != null) {
				prtParametrosIdparametroIdCondlabrListaCache = new ArrayList<IDValorDto>();
				for (PrtParametros prtParametros : prtParametrossss) {
					IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
							prtParametros.getDescripcion());
					prtParametrosIdparametroIdCondlabrListaCache.add(idparametroDto);
				}
			}
		}
		return prtParametrosIdparametroIdCondlabrListaCache;
	}

	public MsUsuariosBk getMsUsuariosBkXidCH(Long id) {
		if (id == null)
			return null;
		MsUsuariosBk msUsuariosBk = null;
		if (getMsUsuariosBkCache() != null) {
			msUsuariosBk = getMsUsuariosBkCache().get(id);
		}
		if (msUsuariosBk == null) {
			MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(id);
			if (msUsuarios != null) {
				msUsuariosBk = new MsUsuariosBk();
				FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
				completarMsUsuarios(msUsuariosBk);
			}
		}
		return msUsuariosBk;
	}

	public Map<Long, MsUsuariosBk> getMsUsuariosBkCache() {
		if (msUsuariosBkCache == null) {
			msUsuariosBkCache = new HashMap<Long, MsUsuariosBk>();
			List<MsUsuarios> msUsuarioss = msUsuariosDao.getActivasMsUsuarios();
			for (MsUsuarios msUsuarios : msUsuarioss) {
				MsUsuariosBk msUsuariosBk = new MsUsuariosBk();
				FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
				completarMsUsuarios(msUsuariosBk);
				msUsuariosBkCache.put(msUsuariosBk.getIdusuario(), msUsuariosBk);
			}
		}
		return msUsuariosBkCache;
	}

	@Override
	public MsUsuariosBk getMsUsuariosBkXUsername(String username) {
		if (username == null)
			return null;
		List<MsUsuarios> msUsuariosss = msUsuariosDao.getByIdMsUsuarios(username);
		MsUsuarios msUsuarios = null;
		if (!msUsuariosss.isEmpty()) {
			if (msUsuariosss.size() > 1) {
				log.info("ERROR EXISTE MÁS DE UN USUARIO CON EL NOMBRE " + username);
			}
			msUsuarios = msUsuariosss.get(0);
		}
		MsUsuariosBk msUsuariosBk = null;
		if (msUsuarios != null) {
			msUsuariosBk = new MsUsuariosBk();
			FuncionesStaticas.copyPropertiesObject(msUsuariosBk, msUsuarios);
			completarMsUsuarios(msUsuariosBk);
		}
		return msUsuariosBk;
	}

	@Override
	public Map<String, MsUsuariosBk> getMsUsuariosBkXUseranameCache() {
		if (msUsuariosBkXUseranameCache == null) {
			msUsuariosBkXUseranameCache = new HashMap<String, MsUsuariosBk>();
			List<MsUsuariosBk> msUsuariosBksss = getAllMsUsuariosActivos(null);
			for (MsUsuariosBk msUsuariosBk : msUsuariosBksss) {
				msUsuariosBkXUseranameCache.put(msUsuariosBk.getUsername(), msUsuariosBk);
			}
		}
		return msUsuariosBkXUseranameCache;
	}

	@Override
	public CacheMsUsuariosBk getCacheMsUsuariosBkActivos() {
		if (cacheMsUsuariosBkActivos == null) {
			List<MsUsuariosBk> msUsuariosBksss = getAllMsUsuariosActivos(null);
			cacheMsUsuariosBkActivos = new CacheMsUsuariosBk(msUsuariosBksss.size() + 10, this);
			cacheMsUsuariosBkActivos.setTotalCargar(msUsuariosBksss.size());
			for (MsUsuariosBk msUsuariosBk : msUsuariosBksss) {
				cacheMsUsuariosBkActivos.put(msUsuariosBk.getIdusuario(), msUsuariosBk, 60);
			}
		}
		return cacheMsUsuariosBkActivos;
	}

	@Override
	public List<IDValorDto> getListaAnnio() {
		List<IDValorDto> listaAnnio = null;
		if (listaAnnio == null) {
			int y = Calendar.getInstance().get(Calendar.YEAR);
			IDValorDto iDValorDto = null;
			listaAnnio = new ArrayList<IDValorDto>();
			for (int i = y - 5; i < y + 5; i++) {
				iDValorDto = new IDValorDto(new Long(i), Integer.toString(i));
				listaAnnio.add(iDValorDto);
			}
		}
		return listaAnnio;
	}

	/**
	 * MS_ROLES SERVICIO: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
	 */

	public MsRolesBk getMsRolesBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		MsRoles msRoles = msRolesDao.getMsRoles(id);
		MsRolesBk msRolesBk = null;
		if (msRoles != null) {
			msRolesBk = new MsRolesBk();
			FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
			completarMsRoles(msRolesBk);
			if (kyUsuarioMod != null)
				setACLMsRolesBk(msRolesBk, kyUsuarioMod);
		}
		return msRolesBk;
	}

	public List<MsRolesBk> getAllMsRolesActivos(Long kyUsuarioMod) {
		List<MsRolesBk> msRolesBkss = new ArrayList<MsRolesBk>();
		try {
			List<MsRoles> msRoless = msRolesDao.getActivasMsRoles();
			for (MsRoles msRoles : msRoless) {
				MsRolesBk msRolesBk = new MsRolesBk();
				FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
				completarMsRoles(msRolesBk);
				setACLMsRolesBk(msRolesBk, kyUsuarioMod);
				msRolesBkss.add(msRolesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msRolesBkss;
	}

	public List<MsRolesBk> getAllMsRolesActivosCero(Long kyUsuarioMod) {
		List<MsRolesBk> msRolesBkss = new ArrayList<MsRolesBk>();
		try {
			List<MsRoles> msRoless = msRolesDao.getActivasMsRolesCero();
			for (MsRoles msRoles : msRoless) {
				MsRolesBk msRolesBk = new MsRolesBk();
				FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
				completarMsRoles(msRolesBk);
				setACLMsRolesBk(msRolesBk, kyUsuarioMod);
				msRolesBkss.add(msRolesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msRolesBkss;
	}

	private void completarMsRoles(MsRolesBk msRolesBk) {

	}

	public MsRolesBk saveorupdateMsRolesBk(MsRolesBk msRolesBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {

		ValidacionMsRolesMng.validarMsRolesBk(msRolesBk);

		MsRoles msRoles = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (msRolesBk.getIdrol() != null && msRolesBk.getIdrol().longValue() > 0) {

				msRoles = msRolesDao.getMsRoles(msRolesBk.getIdrol());

				boolean cambios = AuditoriaMsRolesMng.auditarCambiosMsRoles(msRolesBk, msRoles, kyUsuarioMod, user,
						rmtaddress, nivel);

				if (cambios) {
					msRoles.setRtmaddressmodif(rmtaddress);
					msRoles.setIduserModif(kyUsuarioMod);
					msRoles.setFechaModif(hoy);
					msRolesDao.updateMsRoles(msRoles);
				}
			} else {
				msRolesBk.setRtmaddress(rmtaddress);
				msRolesBk.setRtmaddressmodif(rmtaddress);

				msRolesBk.setFechaCrea(hoy);
				msRolesBk.setIduserCrea(kyUsuarioMod);
				msRolesBk.setIduserModif(kyUsuarioMod);
				msRolesBk.setFechaModif(hoy);
				msRolesBk.setEstado(Estado.ACTIVO.getValor());

				msRoles = new MsRoles();

				FuncionesStaticas.copyPropertiesObject(msRoles, msRolesBk);
				msRolesDao.saveMsRoles(msRoles);

				log.log(Level.INFO, "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
						+ "CREADO msRoles" + " :: " + msRoles.getIdrol().toString() + " :: " + "0" + " :: " + "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

		msRolesBk = getMsRolesBkXid(msRoles.getIdrol(), kyUsuarioMod);
		return msRolesBk;
	}

	public void deleteMsRoles(MsRolesBk msRolesBk, String user, Long kyUsuarioMod, Long kyAreaMod, String rmtaddress)
			throws Validador {
		try {
			MsRoles msRoles = null;
			if (msRolesBk.getIdrol() != null && msRolesBk.getIdrol().longValue() > 0) {

				msRoles = msRolesDao.getMsRoles(msRolesBk.getIdrol());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				msRoles.setRtmaddressmodif(rmtaddress);
				msRoles.setIduserModif(kyUsuarioMod);
				msRoles.setFechaModif(hoy);
				Long estadoanterior = msRoles.getEstado();
				msRoles.setEstado(Estado.ELIMINADO.getValor());

				msRolesDao.updateMsRoles(msRoles);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: " + "ELIMINADO msRoles"
								+ " :: " + msRoles.getIdrol().toString() + " :: " + estadoanterior + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	public List<MsRolesBk> getMsRolesXFiltro(String username, String rol, Long kyUsuarioMod) {
		List<MsRolesBk> msRolesBkss = new ArrayList<MsRolesBk>();
		try {
			List<MsRoles> msRolessss = msRolesDao.getXFiltro(username, rol);
			for (MsRoles msRoles : msRolessss) {
				MsRolesBk msRolesBk = new MsRolesBk();
				FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
				completarMsRoles(msRolesBk);
				setACLMsRolesBk(msRolesBk, kyUsuarioMod);
				msRolesBkss.add(msRolesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msRolesBkss;
	}

	public List<MsRolesBk> getMsRolesXFiltro(String username, String rol, int inicial, int MAX, Long kyUsuarioMod) {
		List<MsRolesBk> msRolesBkss = new ArrayList<MsRolesBk>();
		try {
			List<MsRoles> msRolessss = msRolesDao.getXFiltro(username, rol, inicial, MAX);
			for (MsRoles msRoles : msRolessss) {
				MsRolesBk msRolesBk = new MsRolesBk();
				FuncionesStaticas.copyPropertiesObject(msRolesBk, msRoles);
				completarMsRoles(msRolesBk);
				setACLMsRolesBk(msRolesBk, kyUsuarioMod);
				msRolesBkss.add(msRolesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msRolesBkss;
	}

	public Long getMsRolesTotalXFiltro(String username, String rol, Long kyUsuarioMod) {
		try {
			Long totalMsRolessss = msRolesDao.getTotalXFiltro(username, rol);

			return totalMsRolessss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setACLMsRolesBk(MsRolesBk msRolesBk, Long kyUsuarioMod) {
		MsRolesACL msRolesACL = new MsRolesACL();
		if (kyUsuarioMod != null) {
			MsUsuariosBk msusuariosbk = getMsUsuariosBkXidCH(kyUsuarioMod);
			if (msusuariosbk != null && msusuariosbk.getRolesSistema() != null) {
				List<String> roles = msusuariosbk.getRolesSistema();
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSROLES_CREA)) {
					msRolesACL.setEsEditable(true);
					msRolesACL.setEliminar(true);
				} else if (roles.contains(Roles.MSROLES_VE)) {
					msRolesACL.setEsEditable(true);
				}
				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSROLES_CREA)) {
					msRolesACL.setEditopcion(1);
				} else {
					msRolesACL.setEditopcion(2);
				}
			} else {
				msRolesACL.setEditopcion(2);
			}
		} else {
			msRolesACL.setEditopcion(2);
		}
		msRolesBk.setMsRolesACL(msRolesACL);
	}

	public List<IIDValorDto> getDepartamentosV() {
		List<IIDValorDto> ubigeoItemDtos = new ArrayList<IIDValorDto>();
		List<MsUbigeo> departamentos = msUbigeoDao.getDepartamentos();
		for (MsUbigeo acMsUbigeo : departamentos) {
			IIDValorDto ubigeoItemDto = new IIDValorDto(acMsUbigeo.getId().getCodDpto(), acMsUbigeo.getDescripcion());
			ubigeoItemDtos.add(ubigeoItemDto);
		}
		return ubigeoItemDtos;
	}

	public List<IIDValorDto> getProvinciasV(Integer id_dpto) {
		List<IIDValorDto> ubigeoItemProv = new ArrayList<IIDValorDto>();
		List<MsUbigeo> departamentos = msUbigeoDao.getProvincias(id_dpto);
		for (MsUbigeo acMsUbigeo : departamentos) {
			IIDValorDto ubigeoItemDto = new IIDValorDto(acMsUbigeo.getId().getCodProv(), acMsUbigeo.getDescripcion());
			ubigeoItemProv.add(ubigeoItemDto);
		}
		return ubigeoItemProv;
	}

	public List<IIDValorDto> getDistritosV(Integer id_dpto, Integer id_prov) {
		List<IIDValorDto> ubigeoItemDist = new ArrayList<IIDValorDto>();
		List<MsUbigeo> departamentos = msUbigeoDao.getDistritos(id_dpto, id_prov);
		for (MsUbigeo acMsUbigeo : departamentos) {
			IIDValorDto ubigeoItemDto = new IIDValorDto(acMsUbigeo.getId().getCodDistr(), acMsUbigeo.getDescripcion());
			ubigeoItemDist.add(ubigeoItemDto);
		}
		return ubigeoItemDist;
	}

	public Integer getxDefectoCoddpto() {
		if (xDefectoCoddpto == null || xDefectoCoddpto.intValue() <= 0) {
			MsUbigeo msUbigeo = msUbigeoDao.getDepartamentosXNombre("LIMA");
			if (msUbigeo != null) {
				xDefectoCoddpto = msUbigeo.getId().getCodDpto();
			}

		}
		return xDefectoCoddpto;
	}

	public Integer getxDefectoCodprov() {
		if (xDefectoCodprov == null || xDefectoCodprov.intValue() <= 0) {
			Integer coddpto = getxDefectoCoddpto();
			if (coddpto != null) {
				if (coddpto.intValue() > 0) {
					MsUbigeo msUbigeo = msUbigeoDao.getProvinciasXNombre(coddpto, "LIMA");
					if (msUbigeo != null) {
						xDefectoCodprov = msUbigeo.getId().getCodProv();
					}
				}
			}
		}
		return xDefectoCodprov;
	}

	public Integer getxDefectoCoddist() {
		if (xDefectoCoddist == null || xDefectoCoddist.intValue() <= 0) {
			Integer coddpto = getxDefectoCoddpto();
			Integer codprov = getxDefectoCodprov();
			if (coddpto != null && codprov != null) {
				if (coddpto.intValue() > 0 && codprov.intValue() > 0) {
					MsUbigeo msUbigeo = msUbigeoDao.getDistritosXNombre(coddpto, codprov, "LIMA");
					if (msUbigeo != null) {
						xDefectoCoddist = msUbigeo.getId().getCodDistr();
					}
				}
			}
		}
		return xDefectoCoddist;
	}

	// PURIBE 01022024 - INICIO-->
	// @Override
	// public void deleteDtVisitas(List<DtVisitasBk> dtVisitasBkL, String user,
	// Long kyUsuarioMod, Long kyAreaMod,
	// String rmtaddress) throws Validador {
	// try {
	// DtVisitas dtVisitas = null;
	// String msm="";
	//
	// Long estadoAnulado = PropertiesMg.getSistemLong(
	// PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
	// PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
	// Long estadoFinalizado = PropertiesMg.getSistemLong(
	// PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
	// PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
	//
	// for (DtVisitasBk dtVisitasBk : dtVisitasBkL) {
	//
	// if (dtVisitasBk.getIdVisita() != null &&
	// dtVisitasBk.getIdVisita().longValue() > 0) {
	//
	// dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());
	//
	// this.validaranularDtVisitas(dtVisitasBk,kyUsuarioMod);
	//
	//
	// if(dtVisitasBk.getEstado().longValue()==estadoAnulado){
	// msm = "LA VISITA DE ID: "+ dtVisitasBk.getIdVisita()+" YA SE ENCUENTRA
	// ANULADA;";
	//
	// throw new Validador(msm);
	//
	//
	//
	// }else if (dtVisitasBk.getEstado().longValue()==estadoFinalizado) {
	// msm = "NO ES POSIBLE ANULAR UN REGISTRO FINALIZADO, ID:
	// "+dtVisitasBk.getIdVisita();
	// // JSFUtil.showMessageError(msm, Messages
	// // .getStringToKey("comun.ERROR"));
	// throw new Validador(msm);
	// }
	//
	//
	// // Delete Visita User
	// List<DtVisitasUsuinternosBk> listaInternalUseraSelect=
	// getDtVisitasUsuinternosXFiltro(dtVisitasBk.getIdVisita(),null,kyUsuarioMod);
	// for (DtVisitasUsuinternosBk vistUser : listaInternalUseraSelect) {
	// DtVisitasUsuinternosBk vistaUsuarioBk= new DtVisitasUsuinternosBk();
	// FuncionesStaticas.copyPropertiesObject(vistaUsuarioBk, vistUser);
	// this.deleteDtVisitasUsuinternos(vistaUsuarioBk, user,
	// kyUsuarioMod,
	// kyAreaMod,
	// rmtaddress
	// );
	// }
	//
	//
	// Timestamp hoy = new Timestamp(System.currentTimeMillis());
	//
	// dtVisitas.setRtmaddressrst(rmtaddress);
	// dtVisitas.setIdusserModif(kyUsuarioMod);
	// dtVisitas.setFechaModif(hoy);
	// Long estadoanterior = dtVisitas.getEstado();
	// dtVisitas.setEstado(PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
	// PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO));
	//
	// dtVisitasDao.updateDtVisitas(dtVisitas);
	//
	// log.log(Level.INFO,
	// "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " ::
	// "
	// + "ELIMINADO dtVisitas" + " :: " + dtVisitas.getIdVisita().toString() + "
	// :: "
	// + estadoanterior + " :: " + "0");
	//
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new Validador(e.getMessage());
	// }
	// }
	// PURIBE 01022024 - FIN-->
	// PURIBE 01022024 - INICIO-->
	public void validaranularDtVisitas(DtVisitasBk dtVisitasBk, Long kyUsuarioMod) throws Validador {

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);

		Integer mesServicio = dtVisitasBk.getFechaVisita().getMonth() + 1;

		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}
		// private DtAmpliacionFechaDao ampliacionFechaDao = null;
		// getDtAmpliacionFechaXFiltro
		// List<DtAmpliacionFecha> dtAmpliacionFechasss =
		// dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSede,
		// idSistAdmi);
		DtAmpliacionFechaBk dtAmpliacionFechasss = this.getDtAmpliacionFechaXFiltro(idTipoFechaCorteEjecucion,
				dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), kyUsuarioMod, mesServicio);
		// List<DtAmpliacionFecha> dtAmpliacionFechasss =
		// dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion,
		// dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), mesServicio +
		// 1);
		// Ahora Mes Actual, por confirmar
		ValidacionDtVisitasMng.validarFechaAnulacion(dtVisitasBk, dtAmpliacionFechasss);
	}
	// PURIBE 01022024 - FIN-->
	// PURIBE 01022024 - INICIO-->
	// @Override
	// public DtAmpliacionFechaBk getDtAmpliacionFechaXFiltro(Long
	// tipoFechaCorte, Long idSede, Long idSistAdmi,
	// Long kyUsuarioMod,int mesServicio) {
	// //List<DtAmpliacionFechaBk> dtAmpliacionFechaBkss = new
	// ArrayList<DtAmpliacionFechaBk>();
	// DtAmpliacionFechaBk dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
	// try {
	// DtAmpliacionFecha dtAmpliacionFechasss =
	// dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSede,
	// idSistAdmi,mesServicio + 1);
	//
	// if (dtAmpliacionFechasss == null) {
	// dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte,
	// idSedeTodas,
	// idSistAdmi, mesServicio + 1);
	//
	//
	// if (dtAmpliacionFechasss == null) {
	// dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte,
	// idSede,
	// idSisAdmTodos, mesServicio + 1);
	//
	//
	// if (dtAmpliacionFechasss == null) {
	// dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte,
	// idSedeTodas,
	// idSisAdmTodos, mesServicio + 1);
	// }
	// }
	// }
	//
	// //for (DtAmpliacionFecha dtAmpliacionFecha : dtAmpliacionFechasss) {
	//
	// FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk,
	// dtAmpliacionFechasss);
	// completarDtAmpliacionFecha(dtAmpliacionFechaBk);
	// setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);
	// //dtAmpliacionFechaBkss.add(dtAmpliacionFechaBk);
	// //}
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return dtAmpliacionFechaBk;
	// }
	// PURIBE 01022024 - FIN-->

	// MPINARES 24012023 - INICIO
	@Override
	public List<DtEntidadesDto> getMsInstitucionesXCodigoEjecutora(String codEjec, Long idSistAdmi) throws Validador {
		List<DtEntidadesDto> msInstitucionesBks = new ArrayList<DtEntidadesDto>();
		try {
			// List<DtEntidades> dtEntidadessss =
			// dtEntidadesDao.getXFiltro(codEjec, null, null, null, null,
			// null, null, null, null, null);
			List<DtEntidades> dtEntidadessss = dtEntidadesDao.getXFiltro(codEjec, null, null, null, null, null, null,
					null, null, null);
			if (dtEntidadessss != null && dtEntidadessss.size() > 1) {
				throw new Validador(
						MessageFormat.format("SE ENCONTRÓ MAS DE UNA RESPUESTA PARA EL CODIGO DE EJECUTORA INGRESADO",
								Messages.getStringToKey("dtAsistencias.titulotabla")));
			}

			if (dtEntidadessss == null || dtEntidadessss.size() < 1) {
				throw new Validador(
						MessageFormat.format("NO SE ENCONTRÓ LA ENTIDAD CON EL CÓDIGO DE EJECUTORA " + codEjec,
								Messages.getStringToKey("dtAsistencias.titulotabla")));
			}

			DtEntidades msObjectBks = dtEntidadessss.get(0);

			if (msObjectBks != null && msObjectBks.getIdEntidad() != null) {
				List<DtEntidadSisAdmin> dtEntidadSistemaAdminList = dtEntidadSisAdminDao
						.getDtEntidadSistemaAdminByIdEntity(msObjectBks.getIdEntidad());

				if (dtEntidadSistemaAdminList != null && dtEntidadSistemaAdminList.size() > 0) {
					boolean estaVinculado = false;
					for (DtEntidadSisAdmin dtEntidadSistemaAdminBkko : dtEntidadSistemaAdminList) {
						if (dtEntidadSistemaAdminBkko.getIdSistAdmi() != null
								&& dtEntidadSistemaAdminBkko.getIdSistAdmi().longValue() > 0) {
							if (dtEntidadSistemaAdminBkko.getIdSistAdmi().longValue() == idSistAdmi) {
								estaVinculado = true;
							}

						}
					}
					if (estaVinculado == false) {
						throw new Validador(MessageFormat.format(
								"LA ENTIDAD " + msObjectBks.getRazSocial().trim()
										+ " NO ESTA VINCULADA A SU SISTEMA ADMINISTRATIVO.",
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					}

				} else {
					throw new Validador(MessageFormat.format(
							"LA ENTIDAD " + msObjectBks.getRazSocial().trim()
									+ " NO ESTA VINCULADA A NINGÚN SISTEMA ADMINISTRATIVO.",
							Messages.getStringToKey("dtAsistencias.titulotabla")));
				}
			}

			DtEntidadesDto msInstitucionesBk = new DtEntidadesDto();
			FuncionesStaticas.copyPropertiesObject(msInstitucionesBk, msObjectBks);
			completarDtEntidadesDtoo(msInstitucionesBk);
			msInstitucionesBks.add(msInstitucionesBk);

			// for (DtEntidades msInstituciones : dtEntidadessss) {
			// DtEntidadesDto msInstitucionesBk = new DtEntidadesDto();
			// FuncionesStaticas.copyPropertiesObject(msInstitucionesBk,
			// msInstituciones);
			//// completarMsInstitucionesDto(msInstitucionesBk);
			//// completarDtEntidades(msInstitucionesBk);
			// msInstitucionesBks.add(msInstitucionesBk);
			// }
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		return msInstitucionesBks;
	}

	@Override
	public List<DtEntidadesDto> getMsInstitucionesXEjecutoraSisAdminSede(String codEjec, Long idSistAdmi, Long idSede)
			throws Validador {

		List<DtEntidadesDto> msInstitucionesBks = new ArrayList<DtEntidadesDto>();
		try {
			// List<DtEntidades> dtEntidadessss =
			// dtEntidadesDao.getXFiltro(codEjec, null, null, null, null,
			// null, null, null, null, null);
			List<DtEntidades> dtEntidadessss = dtEntidadesDao.getXFiltro(codEjec, null, null, null, null, null, null,
					null, null, null);
			if (dtEntidadessss != null && dtEntidadessss.size() > 1) {
				throw new Validador(
						MessageFormat.format("SE ENCONTRÓ MAS DE UNA RESPUESTA PARA EL CODIGO DE EJECUTORA INGRESADO",
								Messages.getStringToKey("dtAsistencias.titulotabla")));
			}

			if (dtEntidadessss == null || dtEntidadessss.size() < 1) {
				throw new Validador(
						MessageFormat.format("NO SE ENCONTRÓ LA ENTIDAD CON EL CÓDIGO DE EJECUTORA " + codEjec,
								Messages.getStringToKey("dtAsistencias.titulotabla")));
			}

			DtEntidades msObjectBks = dtEntidadessss.get(0);

			if (msObjectBks != null && msObjectBks.getIdEntidad() != null) {
				// PARA VERIFICAR SISTEMA ADMINISTRATIVO
				List<DtEntidadSisAdmin> dtEntidadSistemaAdminList = dtEntidadSisAdminDao
						.getDtEntidadSistemaAdminByIdEntity(msObjectBks.getIdEntidad());

				if (dtEntidadSistemaAdminList != null && dtEntidadSistemaAdminList.size() > 0) {
					boolean estaVinculado = false;
					for (DtEntidadSisAdmin dtEntidadSistemaAdminBkko : dtEntidadSistemaAdminList) {
						if (dtEntidadSistemaAdminBkko.getIdSistAdmi() != null
								&& dtEntidadSistemaAdminBkko.getIdSistAdmi().longValue() > 0) {
							if (dtEntidadSistemaAdminBkko.getIdSistAdmi().longValue() == idSistAdmi) {
								estaVinculado = true;
							}

						}
					}
					if (estaVinculado == false) {
						throw new Validador(MessageFormat.format(
								"LA ENTIDAD " + msObjectBks.getRazSocial().trim()
										+ " NO ESTA VINCULADA A SU SISTEMA ADMINISTRATIVO.",
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					}

				} else {
					throw new Validador(MessageFormat.format(
							"LA ENTIDAD " + msObjectBks.getRazSocial().trim()
									+ " NO ESTA VINCULADA A NINGÚN SISTEMA ADMINISTRATIVO.",
							Messages.getStringToKey("dtAsistencias.titulotabla")));
				}

				// PARA VERIFICAR SEDE
				List<DtEntidadSedes> dtEntidadSedesList = dtEntidadSedesDao.getXFiltro(msObjectBks.getIdEntidad(),
						idSede);
				if (dtEntidadSedesList == null || dtEntidadSedesList.size() < 1) {
					throw new Validador(MessageFormat.format(
							"LA ENTIDAD " + msObjectBks.getRazSocial().trim()
									+ " NO ESTA VINCULADA A LA SEDE DEL USUARIO.",
							Messages.getStringToKey("dtAsistencias.titulotabla")));
				}

			}

			DtEntidadesDto msInstitucionesBk = new DtEntidadesDto();
			FuncionesStaticas.copyPropertiesObject(msInstitucionesBk, msObjectBks);
			completarDtEntidadesDtoo(msInstitucionesBk);
			msInstitucionesBks.add(msInstitucionesBk);

			// for (DtEntidades msInstituciones : dtEntidadessss) {
			// DtEntidadesDto msInstitucionesBk = new DtEntidadesDto();
			// FuncionesStaticas.copyPropertiesObject(msInstitucionesBk,
			// msInstituciones);
			//// completarMsInstitucionesDto(msInstitucionesBk);
			//// completarDtEntidades(msInstitucionesBk);
			// msInstitucionesBks.add(msInstitucionesBk);
			// }
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		return msInstitucionesBks;
	}

	@Override
	public List<DtAsistenciaBk> getDtAsistenciaXFiltroV(Date fechaInicio, Date fechaFin, Long idProgramacion,
			Long kyUsuarioMod) throws Validador {

		// try {
		// GregorianCalendar fechaInig = new GregorianCalendar();
		// GregorianCalendar fechaFing = new GregorianCalendar();
		// fechaInig.setTimeInMillis(fechaInicio.getTime());
		// fechaFing.setTimeInMillis(fechaFin.getTime());
		//
		// if(fechaInig.after(fechaFing)){
		// String msm = "LA FECHA DE INICIO NO PUEDE SER MAYOR A LA FECHA DE
		// FIN";
		// throw new
		// Validador(MessageFormat.format(msm,Messages.getStringToKey("dtAsistencia.titulotabla")));
		// }
		// } catch (Validador e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// throw new Validador(e.getMessage());
		// }

		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.after(fechaFin)) {
				Date fechatmp = fechaInicio;
				fechaInicio = fechaFin;
				fechaFin = fechatmp;
			}
		} else if (fechaInicio != null) {
			fechaFin = fechaInicio;
		} else if (fechaFin != null) {
			fechaInicio = fechaFin;
			fechaFin = fechaInicio;
		}

		if (fechaFin != null) {
			Timestamp fechFin = new Timestamp(fechaFin.getTime());
			fechaFin = FuncionesStaticas.getDiaMasUno(fechFin);
		}

		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistenciasss = dtAsistenciaDao.getXFiltroV(fechaInicio, fechaFin, idProgramacion);
			for (DtAsistencia dtAsistencia : dtAsistenciasss) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				// completarDtAsistencia(dtAsistenciaBk);
				completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																	// 18062024
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}

	@Override
	public List<DtAsistenciaBk> getDtAsistenciaXFiltroV2(Date fechaInicio, Date fechaFin, Long idProgramacion,
			Long kyUsuarioMod, long sede, int rol, long sistemaadmi) throws Validador {

		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.after(fechaFin)) {
				Date fechatmp = fechaInicio;
				fechaInicio = fechaFin;
				fechaFin = fechatmp;
			}
		} else if (fechaInicio != null) {
			fechaFin = fechaInicio;
		} else if (fechaFin != null) {
			fechaInicio = fechaFin;
			fechaFin = fechaInicio;
		}

		if (fechaFin != null) {
			Timestamp fechFin = new Timestamp(fechaFin.getTime());
			fechaFin = FuncionesStaticas.getDiaMasUno(fechFin);
		}

		List<DtAsistenciaBk> dtAsistenciaBkss = new ArrayList<DtAsistenciaBk>();
		try {
			List<DtAsistencia> dtAsistenciasss = new ArrayList<>();
			// List<DtAsistencia> dtAsistenciasss =
			// dtAsistenciaDao.getXFiltroV(fechaInicio, fechaFin,
			// idProgramacion);
			Long idProgram = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
			if (rol == 0) {
				if (idProgram == idProgramacion)

				{
					dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, null, null,
							null);
				} else {
					dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, null, null,
							null);
				}
			} else if (rol == 1) {
				if (idProgram == idProgramacion)

				{
					dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, sede, null,
							null);
				} else {
					dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, sede, null,
							null);
				}

			} else if (rol == 2) {

				if (idProgram == idProgramacion)

				{
					dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, sede,
							sistemaadmi, kyUsuarioMod);
				} else {
					dtAsistenciasss = dtAsistenciaDao.getXFiltro(fechaInicio, fechaFin, idProgramacion, sede,
							sistemaadmi, kyUsuarioMod);
				}

			}
			for (DtAsistencia dtAsistencia : dtAsistenciasss) {
				DtAsistenciaBk dtAsistenciaBk = new DtAsistenciaBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
				// completarDtAsistencia(dtAsistenciaBk);
				completarDtAsistencia(dtAsistenciaBk, kyUsuarioMod);// CUSCATA -
																	// 18062024
				setACLDtAsistenciaBk(dtAsistenciaBk, kyUsuarioMod);
				dtAsistenciaBkss.add(dtAsistenciaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaBkss;
	}

	@Override
	public List<DtAsistenciaTemasBk> getDtAsistenciaTemasXIdAsistencia(Long idAsistencia) {
		List<DtAsistenciaTemasBk> dtAsistenciaTemasBkss = new ArrayList<DtAsistenciaTemasBk>();
		try {
			List<DtAsistenciaTemas> dtAsistenciaTemassss = dtAsistenciaTemasDao
					.getDtAsistenciaTemasByIdAsistencia(idAsistencia);
			for (DtAsistenciaTemas dtAsistenciaTemas : dtAsistenciaTemassss) {
				DtAsistenciaTemasBk dtAsistenciaTemasBk = new DtAsistenciaTemasBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasBk, dtAsistenciaTemas);
				completarDtAsistenciaTemas(dtAsistenciaTemasBk);
				// setACLDtAsistenciaTemasBk(dtAsistenciaTemasBk, kyUsuarioMod);
				dtAsistenciaTemasBkss.add(dtAsistenciaTemasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaTemasBkss;
	}

	@Override
	public List<DtEntidadesBk> getMsInstitucionesIdprovee(String rasonsocial, Long idSistAdmi) {
		List<DtEntidadesBk> msInstitucionesIdproveeLista = new ArrayList<DtEntidadesBk>();
		if (rasonsocial == null)
			return msInstitucionesIdproveeLista;
		if (rasonsocial.length() < 3)
			return msInstitucionesIdproveeLista;
		List<DtEntidades> msInstitucionessss = dtEntidadesDao.getListaRasonsocialXSisAdmin(rasonsocial.toUpperCase(),
				idSistAdmi);
		for (DtEntidades msInstituciones : msInstitucionessss) {
			DtEntidadesBk msInstitucionesBk = new DtEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(msInstitucionesBk, msInstituciones);
			completarDtEntidadesUbi(msInstitucionesBk);
			msInstitucionesIdproveeLista.add(msInstitucionesBk);
		}
		return msInstitucionesIdproveeLista;
	}

	@Override
	public List<DtEntidadesBk> getMsInstitucionesIdSisadminIdsede(String rasonsocial, Long idSistAdmi, Long idSede) {

		List<DtEntidadesBk> msInstitucionesIdproveeLista = new ArrayList<DtEntidadesBk>();
		if (rasonsocial == null)
			return msInstitucionesIdproveeLista;
		if (rasonsocial.length() < 3)
			return msInstitucionesIdproveeLista;
		List<DtEntidades> msInstitucionessss = dtEntidadesDao
				.getListaRasonsocialXSisAdminSede(rasonsocial.toUpperCase(), idSistAdmi, idSede);
		for (DtEntidades msInstituciones : msInstitucionessss) {
			DtEntidadesBk msInstitucionesBk = new DtEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(msInstitucionesBk, msInstituciones);
			completarDtEntidadesUbi(msInstitucionesBk);
			msInstitucionesIdproveeLista.add(msInstitucionesBk);
		}
		return msInstitucionesIdproveeLista;
	}

	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdTipoEntidad() {
		if (prtParametrosIdparametroIdTipoEntidadListaCache == null) {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getHijosXDescripcion("TIPO ENTIDAD");
			prtParametrosIdparametroIdTipoEntidadListaCache = new ArrayList<IDValorDto>();
			for (PrtParametros prtParametros : prtParametrossss) {
				IDValorDto idparametroDto = new IDValorDto(prtParametros.getIdparametro(),
						prtParametros.getDescripcion());
				prtParametrosIdparametroIdTipoEntidadListaCache.add(idparametroDto);
			}
		}
		return prtParametrosIdparametroIdTipoEntidadListaCache;
	}

	public List<IDValorDto> getListaMsPaisesActivos() {
		List<IDValorDto> msPaisesBks = new ArrayList<IDValorDto>();
		try {
			List<MsPaises> msPaisess = msPaisesDao.getActivasMsPaises();
			for (MsPaises msPaises : msPaisess) {
				IDValorDto iDValorDto = new IDValorDto(msPaises.getIdpais(), msPaises.getPaisNombre());
				msPaisesBks.add(iDValorDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msPaisesBks;
	}

	@Override
	public Long getxDefectoCodpais() {
		if (xDefectoCodpais == null) {
			MsPaises msPaises = msPaisesDao.getByNombreMsPaises("PERÚ");
			if (msPaises != null) {
				xDefectoCodpais = msPaises.getIdpais();
			}
		}
		return xDefectoCodpais;
	}
	//
	// @Override
	// public Integer getxDefectoCoddpto() {
	// if (xDefectoCoddpto == null || xDefectoCoddpto.intValue() <= 0) {
	// MsUbigeo msUbigeo = msUbigeoDao.getDepartamentosXNombre("LIMA");
	// if (msUbigeo != null) {
	// xDefectoCoddpto = msUbigeo.getId().getCodDpto();
	// }
	//
	// }
	// return xDefectoCoddpto;
	// }
	//
	// @Override
	// public Integer getxDefectoCodprov() {
	// if (xDefectoCodprov == null || xDefectoCodprov.intValue() <= 0) {
	// Integer coddpto = getxDefectoCoddpto();
	// if (coddpto != null) {
	// if (coddpto.intValue() > 0) {
	// MsUbigeo msUbigeo = msUbigeoDao.getProvinciasXNombre(coddpto, "LIMA");
	// if (msUbigeo != null) {
	// xDefectoCodprov = msUbigeo.getId().getCodProv();
	// }
	// }
	// }
	// }
	// return xDefectoCodprov;
	// }
	//
	// @Override
	// public Integer getxDefectoCoddist() {
	// if (xDefectoCoddist == null || xDefectoCoddist.intValue() <= 0) {
	// Integer coddpto = getxDefectoCoddpto();
	// Integer codprov = getxDefectoCodprov();
	// if (coddpto != null && codprov != null) {
	// if (coddpto.intValue() > 0 && codprov.intValue() > 0) {
	// MsUbigeo msUbigeo = msUbigeoDao.getDistritosXNombre(coddpto, codprov,
	// "LIMA");
	// if (msUbigeo != null) {
	// xDefectoCoddist = msUbigeo.getId().getCodDistr();
	// }
	// }
	// }
	// }
	// return xDefectoCoddist;
	// }

	@Override
	public List<IDValorDto> getMsTemaIdTemaIdTemaXSisAdmin(Long idSistAdmi) {
		List<IDValorDto> retorno = new ArrayList<IDValorDto>();
		List<MsTema> msTemasss = msTemaDao.getTemaByIdSistemaAdmin(idSistAdmi);
		for (MsTema msTema : msTemasss) {
			IDValorDto idTemaDto = new IDValorDto(msTema.getIdTema(), msTema.getDescripcion());
			retorno.add(idTemaDto);
		}
		return retorno;

	}

	public List<IDValorDto> getSubTemaByIdSistemaAdminTema(Long idTema) throws Validador {
		List<IDValorDto> retorno = new ArrayList<IDValorDto>();
		try {
			Long idPadre = idTema;
			List<MsSubtema> objectList = msSubtemaDao.getSubTemaByIdSistemaAdminTema(idPadre);
			for (MsSubtema oObject : objectList) {
				IDValorDto idTemaDto = new IDValorDto(oObject.getIdSubtema(), oObject.getDescripcion());
				retorno.add(idTemaDto);
			}
		} catch (Exception e) {
			throw new Validador(
					"ERROR:(getTemaByIdSistemaAdmin) INESPERADO: POR FAVOR ENVIE ESTE MENSAJE AL ADMINISTRADOR DEL SISTEMA, GRACIAS.\n"
							+ e.getMessage());
		}
		return retorno;
	}

	@Override
	public void reactivarDtAsistencia(DtAsistenciaBk dtAsistenciaBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtAsistencia dtAsistencia = null;
			if (dtAsistenciaBk.getIdAsistencia() != null && dtAsistenciaBk.getIdAsistencia().longValue() > 0) {

				validarreactivarDtAsistencia(dtAsistenciaBk);
				// DtAsistenciaBk dtAsistenciaBke=new DtAsistenciaBk();
				// FuncionesStaticas.copyPropertiesObject(dtAsistenciaBke,
				// dtAsistenciaBk);
				// Long idSistemaAdmin = JSFUtil.getPerfilUsuarioController()
				// .getUsuariosSistema().getIdSistAdmi();
				dtAsistencia = dtAsistenciaDao.getDtAsistencia(dtAsistenciaBk.getIdAsistencia());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistencia.setRtmaddressrst(rmtaddress);
				dtAsistencia.setIdusserModif(kyUsuarioMod);
				dtAsistencia.setFechaModif(hoy);
				dtAsistencia.setIdSistAdm(kyAreaMod);
				Long estadoanterior = dtAsistencia.getEstado();
				dtAsistencia.setEstado(Estado.ACTIVO.getValor());

				dtAsistenciaDao.updateDtAsistencia(dtAsistencia);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "Reactivando dtAsistencia" + " :: " + dtAsistencia.getIdAsistencia().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ACTIVO.getValor());// MPINARES
																										// 24012023
																										// -
																										// INICIO

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public void reactivarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtCapacitacion dtCapacitacion = null;
			if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

				validarreactivarDtCapacitacion(dtCapacitacionBk);
				dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapacitacion.setRtmaddressrst(rmtaddress);
				dtCapacitacion.setIdusserModif(kyUsuarioMod);
				dtCapacitacion.setFechaModif(hoy);
				dtCapacitacion.setIdSistAdm(kyAreaMod);
				Long estadoanterior = dtCapacitacion.getEstado();
				dtCapacitacion.setEstado(Estado.ACTIVO.getValor());

				dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "Reactivando dtCapacitacion" + " :: " + dtCapacitacion.getIdCapacitacion().toString()
								+ " :: " + estadoanterior + " :: " + " " + Estado.ACTIVO.getValor());

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	public void validarreactivarDtAsistencia(DtAsistenciaBk dtAsistenciaBk) throws Validador {

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);
		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);
		Integer mesServicio = dtAsistenciaBk.getFechaAsistencia().getMonth() + 1;
		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}
		DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
				dtAsistenciaBk.getIdSede(), dtAsistenciaBk.getIdSistAdm(), mesServicio + 1);// Ahora
																							// Mes
																							// Actual,
																							// por
																							// confirmar

		if (autorizacionEjecucion == null) {
			autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
					dtAsistenciaBk.getIdSistAdm(), mesServicio + 1);// Ahora Mes
																	// Actual,
																	// por
																	// confirmar
			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, dtAsistenciaBk.getIdSede(),
						idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual, por
														// confirmar
				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
							idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual,
															// por confirmar
				}
			}
		}
		ValidacionDtAsistenciaMng.validarFechaReactiva(dtAsistenciaBk, autorizacionEjecucion);

	}

	public void validarreactivarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk) throws Validador {

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);
		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);
		Integer mesServicio = dtCapacitacionBk.getFechaInic().getMonth() + 1;
		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}
		DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
				dtCapacitacionBk.getIdSede(), dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora
		// Mes
		// Actual,
		// por
		// confirmar

		if (autorizacionEjecucion == null) {
			autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
					dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora
																		// Mes
																		// Actual,
																		// por
																		// confirmar
			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion,
						dtCapacitacionBk.getIdSede(), idSisAdmTodos, mesServicio + 1);// Ahora
																						// Mes
																						// Actual,
																						// por
																						// confirmar
				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
							idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual,
															// por confirmar
				}
			}
		}
		ValidacionDtCapacitacionMng.validarFechaReactiva(dtCapacitacionBk, autorizacionEjecucion);

	}

	@Override
	public DtAsistenciaBk getDtAsistenciaBkXidV2(Long id) {
		if (id == null)
			return null;
		DtAsistencia dtAsistencia = dtAsistenciaDao.getDtAsistencia(id);
		DtAsistenciaBk dtAsistenciaBk = null;
		if (dtAsistencia != null) {
			dtAsistenciaBk = new DtAsistenciaBk();
			FuncionesStaticas.copyPropertiesObject(dtAsistenciaBk, dtAsistencia);
		}
		return dtAsistenciaBk;
	}

	// MPINARES 24012023 - FIN

	// MPINARES 14022024 - INICIO
	@Override
	public List<DtCapacitacionBk> getDtCapacitacionXFiltroV(Date fechaInicio, Date fechaFin, Long idProgramacion,
			Long kyUsuarioMod) {
		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.after(fechaFin)) {
				Date fechatmp = fechaInicio;
				fechaInicio = fechaFin;
				fechaFin = fechatmp;
			}
		} else if (fechaInicio != null) {
			fechaFin = fechaInicio;
		} else if (fechaFin != null) {
			fechaInicio = fechaFin;
			fechaFin = fechaInicio;
		}

		if (fechaFin != null) {
			Timestamp fechFin = new Timestamp(fechaFin.getTime());
			fechaFin = FuncionesStaticas.getDiaMasUno(fechFin);
		}

		List<DtCapacitacionBk> dtCapacitacionBkss = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacionssss = dtCapacitacionDao.getXFiltroV(fechaInicio, fechaFin,
					idProgramacion);
			for (DtCapacitacion dtCapacitacion : dtCapacitacionssss) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
				dtCapacitacionBkss.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBkss;
	}

	@Override
	public List<DtCapacitacionBk> getDtCapacitacionXFiltroV2(Date fechaInicio, Date fechaFin, Long idProgramacion,
			Long kyUsuarioMod, long sede, int rol, long sistemaadmi) {
		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.after(fechaFin)) {
				Date fechatmp = fechaInicio;
				fechaInicio = fechaFin;
				fechaFin = fechatmp;
			}
		} else if (fechaInicio != null) {
			fechaFin = fechaInicio;
		} else if (fechaFin != null) {
			fechaInicio = fechaFin;
			fechaFin = fechaInicio;
		}

		if (fechaFin != null) {
			Timestamp fechFin = new Timestamp(fechaFin.getTime());
			fechaFin = FuncionesStaticas.getDiaMasUno(fechFin);
		}

		List<DtCapacitacionBk> dtCapacitacionBkss = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacionssss = new ArrayList<>();
			
			Long idProgram = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
			
			dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(null, null, idProgramacion, null,
					null, kyUsuarioMod);
			
			/*if (rol == 0) {
				if (idProgram == idProgramacion)

				{
					dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(fechaInicio, fechaFin, idProgramacion, null,
							null, null);
				} else {
					dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(fechaInicio, fechaFin, idProgramacion, null,
							null, null);
				}
			} else if (rol == 1) {
				if (idProgram == idProgramacion)

				{
					dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(fechaInicio, fechaFin, idProgramacion, sede,
							null, null);
				} else {
					dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(fechaInicio, fechaFin, idProgramacion, sede,
							null, null);
				}

			} else if (rol == 2) {

				if (idProgram == idProgramacion)

				{
					dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(fechaInicio, fechaFin, idProgramacion, sede,
							sistemaadmi, kyUsuarioMod);
				} else {
					dtCapacitacionssss = dtCapacitacionDao.getXFiltroV2(fechaInicio, fechaFin, idProgramacion, sede,
							sistemaadmi, kyUsuarioMod);
				}

			}*/

			// List<DtCapacitacion> dtCapacitacionssss =
			// dtCapacitacionDao.getXFiltroV(fechaInicio,
			// fechaFin,idProgramacion);
			for (DtCapacitacion dtCapacitacion : dtCapacitacionssss) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				setACLDtCapacitacionBk(dtCapacitacionBk, kyUsuarioMod);
				dtCapacitacionBkss.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBkss;
	}

	public List<IDValorDto> getIDValorMsLocalBksss() throws Validador {
		List<IDValorDto> retorno = new ArrayList<IDValorDto>();
		try {
			List<MsLocal> msLocalss = msLocalDao.getActivasMsLocal();
			for (MsLocal msLocal : msLocalss) {
				String sedeTxt = "";
				String depart = "";
				String prov = "";
				if (msLocal.getIdSede() != null && msLocal.getIdSede().intValue() > 0) {
					MsSedes msSedes = msSedesDao.getMsSedes(msLocal.getIdSede());
					sedeTxt = msSedes.getSede();
				}
				depart = msUbigeoDao.getMsUbigeoByCodes(msLocal.getCodDpto().longValue(), 0L, 0L).getDescripcion();
				prov = msUbigeoDao
						.getMsUbigeoByCodes(msLocal.getCodDpto().longValue(), msLocal.getCodProv().longValue(), 0L)
						.getDescripcion();
				IDValorDto iDValorDto = new IDValorDto();
				iDValorDto.setId(msLocal.getIdLocal());
				iDValorDto.setValor(
						msLocal.getDescripcion() + "-SEDE " + sedeTxt + " DEPART:" + depart + " PROV:" + prov);
				retorno.add(iDValorDto);
			}
		} catch (Exception e) {
			throw new Validador(
					"ERROR:(getIDValorMsLocalBksss) INESPERADO: POR FAVOR ENVIE ESTE MENSAJE AL ADMINISTRADOR DEL SISTEMA, GRACIAS.\n"
							+ e.getMessage());
		}
		return retorno;
	}

	@Override
	public List<MsLocalBk> getMsLocalIdLocalListaCache() {
		if (msLocalIdLocalListaCache == null) {
			List<MsLocal> msLocalss = msLocalDao.getActivasMsLocal();
			msLocalIdLocalListaCache = new ArrayList<MsLocalBk>();
			for (MsLocal msLocal : msLocalss) {
				MsLocalBk msLocalBk = new MsLocalBk();
				FuncionesStaticas.copyPropertiesObject(msLocalBk, msLocal);
				msLocalIdLocalListaCache.add(msLocalBk);
			}
		}
		return msLocalIdLocalListaCache;
	}

	public void setMsLocalIdLocalListaCache(List<MsLocalBk> msLocalIdLocalListaCache) {
		this.msLocalIdLocalListaCache = msLocalIdLocalListaCache;
	}

	public List<IDValorDto> getIDValorMsLocalBksssXSede(Long idSede) throws Validador {

		List<IDValorDto> retorno = new ArrayList<IDValorDto>();
		try {
			getMsLocalIdLocalListaCache();
			if (msLocalIdLocalListaCache != null) {
				for (MsLocalBk local : msLocalIdLocalListaCache) {
					if (local.getIdSede() == idSede) {
						String sedeTxt = "";
						String depart = "";
						String prov = "";
						if (local.getIdSede() != null && local.getIdSede().intValue() > 0) {
							MsSedes msSedes = msSedesDao.getMsSedes(local.getIdSede());
							sedeTxt = msSedes.getSede();
						}
						depart = msUbigeoDao.getMsUbigeoByCodes(local.getCodDpto().longValue(), 0L, 0L)
								.getDescripcion();
						prov = msUbigeoDao
								.getMsUbigeoByCodes(local.getCodDpto().longValue(), local.getCodProv().longValue(), 0L)
								.getDescripcion();
						IDValorDto iDValorDto = new IDValorDto();
						iDValorDto.setId(local.getIdLocal());
						iDValorDto.setValor(
								local.getDescripcion() + "-SEDE " + sedeTxt + " DEPART:" + depart + " PROV:" + prov);
						retorno.add(iDValorDto);
					}

				}
			}

		} catch (Exception e) {
			throw new Validador(
					"ERROR:(getIDValorMsLocalBksssXSede) INESPERADO: POR FAVOR ENVIE ESTE MENSAJE AL ADMINISTRADOR DEL SISTEMA, GRACIAS.\n"
							+ e.getMessage());
		}
		return retorno;
	}

	@Override
	public List<IDValorDto> getPrtParametrosIdparametroIdModalidadCapas() {
		getPrtParametrosIdparametroIdModalidad();
		List<IDValorDto> prtParametrosIdparametroIdModalidadCapas = new ArrayList<IDValorDto>();
		if (prtParametrosIdparametroIdModalidadListaCache != null
				&& prtParametrosIdparametroIdModalidadListaCache.size() > 0) {
			Long idModalidadTel = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_TELEFONO,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_TELEFONO);
			for (IDValorDto modalidadCapa : prtParametrosIdparametroIdModalidadListaCache) {
				if (modalidadCapa.getId().longValue() != idModalidadTel) {
					prtParametrosIdparametroIdModalidadCapas.add(modalidadCapa);
				}
			}
		}
		return prtParametrosIdparametroIdModalidadCapas;
	}

	@Override
	public String getEndpointVentanilla() {
		if (endpointVentanilla == null) {
			List<PrtParametros> prtParametrosss = prtParametrosDao.getHijosXDescripcion("SERVICIO DE TRAMITE");
			if (!prtParametrosss.isEmpty()) {
				for (PrtParametros prtParametros : prtParametrosss) {
					if (prtParametros.getDescripcion() != null) { // &&
																	// prtParametros.getDescripcion().contains("ventanillastd")
						endpointVentanilla = prtParametros.getDescripcion();
					}
				}
			}
		}
		return endpointVentanilla;
	}

	@Override
	public void setEndpointVentanilla(String endpointVentanilla) {
		this.endpointVentanilla = endpointVentanilla;
	}

	@Override
	public List<IDValorDto> getListaProcedeEjecucion() {
		if (listaProcedeEjecucion == null) {
			listaProcedeEjecucion = new ArrayList<IDValorDto>();
			IDValorDto valor1 = new IDValorDto(1L, "SÍ");
			listaProcedeEjecucion.add(valor1);
			IDValorDto valor2 = new IDValorDto(2L, "NO");
			listaProcedeEjecucion.add(valor2);
		}
		return listaProcedeEjecucion;
	}

	public void prepublicarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, String user, Long kyUsuarioMod,
			Long kyAreaMod, String rmtaddress) throws Validador {
		try {

			DtCapacitacion dtCapacitacion = null;
			if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

				dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());
				DtCapacitacionBk dtCapacitacionBkac = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBkac, dtCapacitacion);
				// VERIFICANDO********************************************************
				Long estadoAnulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
				Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);

				if (dtCapacitacionBkac.getEstado().longValue() == estadoAnulado
						|| dtCapacitacionBkac.getEstado().longValue() == estadoFinalizado) {
					String msm = "NO ES POSIBLE PRE-PUBLICAR UN REGISTRO FINALIZADO O ANULADO, ID: "
							+ dtCapacitacionBkac.getIdCapacitacion();
					throw new Validador(
							MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}
				// *****************VERIFICAR FECHA************************
				GregorianCalendar fechaActual = new GregorianCalendar();
				GregorianCalendar fechaCapa = new GregorianCalendar();
				fechaCapa.setTimeInMillis(dtCapacitacionBkac.getFechaInic().getTime());
				fechaActual = fechaLimitDia(fechaActual);
				fechaCapa = fechaLimitDia(fechaCapa);
				if (fechaCapa.before(fechaActual)) {
					String msm = "SE HAN SELECCIONADO CAPACITACIONES CON FECHA DE INICIO ANTERIOR A LA FECHA ACTUAL, ID: "
							+ dtCapacitacionBkac.getIdCapacitacion();
					throw new Validador(
							MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}

				if (dtCapacitacionBkac.getFlagPubli() != null && dtCapacitacionBkac.getFlagPubli().longValue() == 1L) {
					String msm = "LA CAPACITACIÓN DE ID: " + dtCapacitacionBkac.getIdCapacitacion()
							+ " YA SE ENCUENTRA PUBLICADA;";
					throw new Validador(
							MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}

				if (dtCapacitacionBkac.getFlagPubli() != null && dtCapacitacionBkac.getFlagPubli().longValue() == 2L) {
					String msm = "LA CAPACITACIÓN DE ID: " + dtCapacitacionBkac.getIdCapacitacion()
							+ " YA SE ENCUENTRA PRE-PUBLICADA;";
					throw new Validador(
							MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}
				// ********************************************************

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtCapacitacion.setIdusserModif(kyUsuarioMod);
				dtCapacitacion.setFechaModif(hoy);
				dtCapacitacion.setFlagPubli(2L);

				dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "PRE-PUBLICADO dtCapacitacion" + " :: "
								+ dtCapacitacion.getIdCapacitacion().toString() + " :: " + "1" + " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	public static GregorianCalendar fechaLimitDia(GregorianCalendar fechaLimitIni) {
		fechaLimitIni.set(Calendar.HOUR_OF_DAY, fechaLimitIni.getActualMinimum(Calendar.HOUR_OF_DAY));
		fechaLimitIni.set(Calendar.MINUTE, fechaLimitIni.getActualMinimum(Calendar.MINUTE));
		fechaLimitIni.set(Calendar.SECOND, fechaLimitIni.getActualMinimum(Calendar.SECOND));
		fechaLimitIni.set(Calendar.MILLISECOND, fechaLimitIni.getActualMinimum(Calendar.MILLISECOND));
		return fechaLimitIni;
	}

	private GregorianCalendar minimFecha(GregorianCalendar fechaIniMesComp) {
		fechaIniMesComp.set(Calendar.HOUR_OF_DAY, fechaIniMesComp.getActualMinimum(Calendar.HOUR_OF_DAY));
		fechaIniMesComp.set(Calendar.MINUTE, fechaIniMesComp.getActualMinimum(Calendar.MINUTE));
		fechaIniMesComp.set(Calendar.SECOND, fechaIniMesComp.getActualMinimum(Calendar.SECOND));
		fechaIniMesComp.set(Calendar.MILLISECOND, fechaIniMesComp.getActualMinimum(Calendar.MILLISECOND));
		return fechaIniMesComp;
	}

	public List<DtCapacitacionBk> getDtCapacitacionXIdPadre(Long idCapaPadre) {
		List<DtCapacitacionBk> dtCapacitacionBks = new ArrayList<DtCapacitacionBk>();
		try {
			List<DtCapacitacion> dtCapacitacionsss = dtCapacitacionDao.getDtcapaXIDPadre(idCapaPadre);
			for (DtCapacitacion dtCapacitacion : dtCapacitacionsss) {
				DtCapacitacionBk dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
				dtCapacitacionBks.add(dtCapacitacionBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtCapacitacionBks;
	}

	@Override
	public DtCapacitacionBk validDtCapacitacionList(List<DtCapacitacionBk> dtCapacitacionBkListNew, Long kyUsuarioMod)
			throws Validador {
		try {

			List<DtCapacitacionBk> dtCapacitacionBkList = new ArrayList<DtCapacitacionBk>();
			for (DtCapacitacionBk dtCapacitacionBko : dtCapacitacionBkListNew) {
				dtCapacitacionBko = getDtCapacitacionBkXid(dtCapacitacionBko.getIdCapacitacion(), kyUsuarioMod);
				dtCapacitacionBkList.add(dtCapacitacionBko);
			}

			Long estadoAcumulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ACUMULADO,
					PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ACUMULADO);
			Long idModoMultiSistema = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDMODO_MULTISISTEMA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDMODO_MULTISISTEMA);
			Long idModoUnSistema = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDMODO_UNSISTEMA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDMODO_UNSISTEMA);

			DtCapacitacionBk dtCapacitAcumula = new DtCapacitacionBk();

			if (dtCapacitacionBkList != null && dtCapacitacionBkList.size() > 1) {
				Timestamp fechaDocIni = null;
				Timestamp fechaDocFin = null;
				DtCapacitacionBk dtCapacitacionBkIni = dtCapacitacionBkList.get(0);
				dtCapacitAcumula.setIdLocal(dtCapacitacionBkIni.getIdLocal());
				dtCapacitAcumula.setCantPartic(dtCapacitacionBkIni.getCantPartic());
				dtCapacitAcumula.setCantParticAsist(dtCapacitacionBkIni.getCantParticAsist());
				dtCapacitAcumula.setNomEvento(dtCapacitacionBkIni.getNomEvento());
				dtCapacitAcumula.setIdNivel(dtCapacitacionBkIni.getIdNivel());
				dtCapacitAcumula.setIdPrestacion(dtCapacitacionBkIni.getIdPrestacion());
				dtCapacitAcumula.setIdTipo(dtCapacitacionBkIni.getIdTipo());
				dtCapacitAcumula.setIdFinancia(dtCapacitacionBkIni.getIdFinancia());
				dtCapacitAcumula.setIdModalidad(dtCapacitacionBkIni.getIdModalidad());
				dtCapacitAcumula.setDetalleCapaVirtual(dtCapacitacionBkIni.getDetalleCapaVirtual());
				dtCapacitAcumula.setFechaSoli(dtCapacitacionBkIni.getFechaSoli());
				dtCapacitAcumula.setFechaSoliJUD(dtCapacitacionBkIni.getFechaSoliJUD());
				dtCapacitAcumula.setFechaInicJUD(dtCapacitacionBkIni.getFechaInicJUD());
				dtCapacitAcumula.setFechaFinJUD(dtCapacitacionBkIni.getFechaInicJUD());

				List<DtCapaPublicoBk> listaCargosSelect = null;

				GregorianCalendar fechaIniMesComp = new GregorianCalendar();
				fechaIniMesComp.setTimeInMillis(dtCapacitacionBkList.get(0).getFechaInic().getTime());
				fechaIniMesComp = minimFecha(fechaIniMesComp);

				for (DtCapacitacionBk dtCapacitacionActBk : dtCapacitacionBkList) {
					// COMPARAR FECHAS
					GregorianCalendar fechaComp = new GregorianCalendar();
					fechaComp.setTimeInMillis(dtCapacitacionActBk.getFechaInic().getTime());
					fechaComp = minimFecha(fechaComp);
					if (!fechaIniMesComp.equals(fechaComp)) {
						String msm = "NO ES POSIBLE ACUMULAR CAPACITACIONES CON FECHAS DE INICIO DISTINTAS";
						throw new Validador(
								MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
					}

					// VERIFICAR SI EVENTO YA ES PRODUCTO DE UNA ACUMULACION
					if (dtCapacitacionActBk.getIdCapacitacion() != null
							&& dtCapacitacionActBk.getIdCapacitacion().longValue() > 0) {
						List<DtCapacitacionBk> dtCapacitacionBkListt = getDtCapacitacionXIdPadre(
								dtCapacitacionActBk.getIdCapacitacion());
						if (dtCapacitacionBkListt.size() > 0) {
							String msm = "NO ES POSIBLE ACUMULAR LA CAPACITACIÓN SELECCIONADA CON ID:00"
									+ dtCapacitacionActBk.getIdCapacitacion()
									+ ", DEBIDO A QUE ES UN EVENTO CREADO A PARTIR DE UNA ACUMULACIÓN";
							throw new Validador(
									MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
						}
					}

					if (dtCapacitacionActBk.getEstado().longValue() == estadoAcumulado) {
						String msm = "NO ES POSIBLE ACUMULAR LA CAPACITACIÓN SELECCIONADA, ID:00"
								+ dtCapacitacionActBk.getIdCapacitacion() + ", DEBIDO A QUE SE ENCUENTRA ACUMULADA";
						throw new Validador(
								MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
					}

					for (DtCapacitacionBk dtCapacitacionActBkTemp : dtCapacitacionBkList) {

						if (dtCapacitacionActBk.getIdModo().compareTo(dtCapacitacionActBkTemp.getIdModo()) != 0
								&& dtCapacitacionActBkTemp.getIdCapacitacion()
										.compareTo(dtCapacitacionActBk.getIdCapacitacion()) != 0) {

							String msm = "NO ES POSIBLE ACUMULAR LA CAPACITACIÓN SELECCIONADA, ID:00"
									+ dtCapacitacionActBk.getIdCapacitacion()
									+ ", DEBIDO A QUE  SON DE DIFERENTES MODO, TODOS LOS SELECCIONADOS DEBEN DE SER DEL MISMO MODO";
							throw new Validador(
									MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
						}

						if (dtCapacitacionActBk.getIdModo().compareTo(idModoMultiSistema) == 0
								&& dtCapacitacionActBkTemp.getIdCapacitacion()
										.compareTo(dtCapacitacionActBk.getIdCapacitacion()) != 0
								&& dtCapacitacionActBkTemp.getIdSistAdm()
										.compareTo(dtCapacitacionActBk.getIdSistAdm()) == 0
								&& dtCapacitacionActBkTemp.getIdUsuinterno() != null && dtCapacitacionActBkTemp
										.getIdUsuinterno().compareTo(dtCapacitacionActBk.getIdUsuinterno()) == 0) {

							String msm = "NO ES POSIBLE ACUMULAR LA CAPACITACIÓN SELECCIONADA, ID:00"
									+ dtCapacitacionActBk.getIdCapacitacion()
									+ ", LOS DE MODO MULTISISTEMA DEBEN SER DE DIFERENTE SISTEMA ADMINISTRATIVO";
							throw new Validador(
									MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
						}

						if (dtCapacitacionActBk.getIdModo().compareTo(idModoUnSistema) == 0
								&& dtCapacitacionActBkTemp.getIdCapacitacion()
										.compareTo(dtCapacitacionActBk.getIdCapacitacion()) != 0
								&& dtCapacitacionActBkTemp.getIdSistAdm()
										.compareTo(dtCapacitacionActBk.getIdSistAdm()) != 0) {
							String msm = "NO ES POSIBLE ACUMULAR LA CAPACITACIÓN SELECCIONADA, ID:00"
									+ dtCapacitacionActBk.getIdCapacitacion()
									+ ", LOS DE MODO UN SOLO SISTEMA DEBEN TENER EL MISMO SISTEMA ADMINISTRATIVO";
							throw new Validador(
									MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));

						}

						if (fechaDocIni == null) {
							fechaDocIni = dtCapacitacionActBk.getFechaInic();
						}
						if (fechaDocFin == null) {
							fechaDocFin = dtCapacitacionActBk.getFechaFin();
						}

						if (dtCapacitacionActBk.getFechaInic() != null
								&& fechaDocIni.after(dtCapacitacionActBk.getFechaInic())) {
							fechaDocIni = dtCapacitacionActBk.getFechaInic();
						}
						if (dtCapacitacionActBk.getFechaFin() != null
								&& fechaDocFin.before(dtCapacitacionActBk.getFechaFin())) {
							fechaDocFin = dtCapacitacionActBk.getFechaFin();
						}
					}
				}
				dtCapacitAcumula.setFechaInic(fechaDocIni);
				dtCapacitAcumula.setFechaInicJUD(fechaDocIni);
				dtCapacitAcumula.setFechaFin(fechaDocFin);
				dtCapacitAcumula.setFechaFinJUD(fechaDocFin);

			}

			// log.log(Level.INFO,
			// "CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress
			// + " :: "
			// + "ELIMINADO dtCapacitacion" + " :: " +
			// dtCapacitacion.getIdCapacitacion().toString()
			// + " :: " + estadoanterior + " :: " + "0");

			return dtCapacitAcumula;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}

	@Override
	public DtCapacitacionBk saveorupdateDtCapacitacionAcumulaBk(DtCapacitacionBk dtCapacitAcumula, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {

		if (dtCapacitAcumula.getFechaSoli() == null) {
			String msm = "INGRESE LA FECHA DE SOLICITUD";
			throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
		}

		if (dtCapacitAcumula.getDtCapaAcumulaListBkJSss() != null
				&& dtCapacitAcumula.getDtCapaAcumulaListBkJSss().size() > 0) {
			if (dtCapacitAcumula.getFechaInic() == null) {
				String msm = "INGRESE LA FECHA DE INICIO";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getFechaFin() == null) {
				String msm = "INGRESE LA FECHA DE FIN";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			Long idVirtual = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_VIRTUAL,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL);

			if (dtCapacitAcumula.getIdModalidad() == null || dtCapacitAcumula.getIdModalidad().longValue() < 1) {
				String msm = "SELECCIONE LA MODALIDAD";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getIdModalidad().longValue() == idVirtual.longValue()) {
				if (dtCapacitAcumula.getDetalleCapaVirtual() == null
						|| dtCapacitAcumula.getDetalleCapaVirtual().length() < 1) {
					String msm = "INGRESE EL ENLACE DE CONEXIÓN VIRTUAL";
					throw new Validador(
							MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}
			} else {
				if (dtCapacitAcumula.getIdLocal() == null || dtCapacitAcumula.getIdLocal() < 1) {
					String msm = "SELECCIONE LUGAR DE CAPACITACIÓN";
					throw new Validador(
							MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
				}
			}

			if (dtCapacitAcumula.getCantPartic() == null || dtCapacitAcumula.getCantPartic() < 1) {
				String msm = "INGRESE LA CANTIDAD DE PARTICIPANTES PROGRAMADOS";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getNomEvento() == null || dtCapacitAcumula.getNomEvento().length() < 1) {
				String msm = "INGRESE EL NOMBRE DEL EVENTO";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getIdNivel() == null || dtCapacitAcumula.getIdNivel() < 1) {
				String msm = "SELECCIONE EL NIVEL";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getIdPrestacion() == null || dtCapacitAcumula.getIdPrestacion() < 1) {
				String msm = "SELECCIONE LA PRESTACIÓN";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getIdTipo() == null || dtCapacitAcumula.getIdTipo() < 1) {
				String msm = "SELECCIONE EL TIPO";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			if (dtCapacitAcumula.getIdFinancia() == null || dtCapacitAcumula.getIdFinancia() < 1) {
				String msm = "SELECCIONE EL FINANCIAMIENTO";
				throw new Validador(MessageFormat.format(msm, Messages.getStringToKey("dtCapacitacion.titulotabla")));
			}

			// if (listaCargosSelect == null || listaCargosSelect.size() <= 0) {
			// JSFUtil.addError(
			// "SELECCIONE EL PÚBLICO OBJETIVO",
			// Messages.getStringToKey("dtCapacitacionRegistro.acumulocorrectotitulo"));
			// return null;
			// }

			// PARA ACUMULACION
			DtCapacitacionBk dtCapacitacionBkNew = new DtCapacitacionBk();
			dtCapacitacionBkNew = copiarDatosAcumulac(dtCapacitacionBkNew, dtCapacitAcumula);
			DtCapacitacionBk dtCapacitacionBkini = dtCapacitAcumula.getDtCapaAcumulaListBkJSss().get(0);
			// MODO MULTISISTEMA
			Long idMulti = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDMODO_MULTISISTEMA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDMODO_MULTISISTEMA);
			dtCapacitacionBkNew.setIdModo(idMulti);
			// TIPO FINANCIAMIENTO
			dtCapacitacionBkNew.setIdFinancia(dtCapacitacionBkini.getIdFinancia());
			// ORIGEN
			dtCapacitacionBkNew.setIdOrigen(dtCapacitacionBkini.getIdOrigen());
			// PROGRAMACION
			dtCapacitacionBkNew.setIdProgramacion(dtCapacitacionBkini.getIdProgramacion());
			// SEDE Y SIST ADMIN
			dtCapacitacionBkNew.setIdSede(dtCapacitacionBkini.getIdSede());
			dtCapacitacionBkNew.setIdSistAdm(dtCapacitacionBkini.getIdSistAdm());

			try {
				dtCapacitacionBkNew = saveorupdateDtCapacitacionBk(dtCapacitacionBkNew, user, kyUsuarioMod, kyAreaMod,
						rmtaddress);
				if (dtCapacitacionBkNew.getIdCapacitacion() != null) {
					// se adicionan los publicos objetivos nuevos
					// for (DtCapaPublicoBk dtCapaPublicoBkkaa :
					// listaCargosSelect) {
					// dtCapaPublicoBkkaa
					// .setIdCapacitacion(dtCapacitacionBkNew
					// .getIdCapacitacion());
					//
					// servicio.saveorupdateDtCapaPublicoBk(
					// dtCapaPublicoBkkaa,
					// JSFUtil.getPerfilUsuarioController().getUser(),
					// JSFUtil.getPerfilUsuarioController()
					// .getKyUsuarioMod(), JSFUtil
					// .getPerfilUsuarioController()
					// .getKyAreaMod(), JSFUtil
					// .getPerfilUsuarioController()
					// .getKySedeMod(), JSFUtil
					// .getPerfilUsuarioController()
					// .getRmtaddress());
					// }

					// SE COLOCA ID DEL PADRE EN LAS CAPACITACIONES ACUMULADAS
					List<DtCapacitacionBk> DtCapacitacionBkListt = dtCapacitAcumula.getDtCapaAcumulaListBkJSss();
					// CONTENDRA LISTA DE TEMAS A AGENDAR
					List<DtCapaTemasBk> dtCapaTemasBkListNew = new ArrayList<DtCapaTemasBk>();
					// CONTENDRA LISTA DE ENTIDADES A AGENDAR
					List<DtCapaEntidadesBk> dtCapaEntidadesBkListNew = new ArrayList<DtCapaEntidadesBk>();
					for (DtCapacitacionBk dtCapacitacionBkko : DtCapacitacionBkListt) {
						Long estadoAcumulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ACUMULADO,
								PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ACUMULADO);
						dtCapacitacionBkko.setEstado(estadoAcumulado);
						dtCapacitacionBkko.setIdcapaPadre(dtCapacitacionBkNew.getIdCapacitacion());
						dtCapacitacionBkko = saveorupdateDtCapacitacionBk(dtCapacitacionBkko, user, kyUsuarioMod,
								kyAreaMod, rmtaddress);

						// BUSCAR TEMAS AGENDADOS EN CAPACITACIONES ACUMULADAS
						if (dtCapacitacionBkko.getIdCapacitacion() != null) {
							List<DtCapaTemasBk> dtCapaTemasBkList = getDtCapaTemasByIdDCapa(
									dtCapacitacionBkko.getIdCapacitacion());
							if (dtCapaTemasBkList != null && dtCapaTemasBkList.size() > 0) {
								for (DtCapaTemasBk dtCapaTemasBke : dtCapaTemasBkList) {
									DtCapaTemasBk dtCapaTemasBky = new DtCapaTemasBk();
									dtCapaTemasBky.setIdTema(dtCapaTemasBke.getIdTema());
									dtCapaTemasBky.setIdSubtema(dtCapaTemasBke.getIdSubtema());
									dtCapaTemasBky.setIdCapacitacion(dtCapacitacionBkNew.getIdCapacitacion());
									dtCapaTemasBky.setIdUsuinterno(dtCapaTemasBke.getIdUsuinterno());
									dtCapaTemasBky.setIdSistAdmi(dtCapaTemasBke.getIdSistAdmi());
									if (!dtCapaTemasBkListNew.contains(dtCapaTemasBky)) {
										dtCapaTemasBkListNew.add(dtCapaTemasBky);
									}
								}
							}
						}

						// BUSCAR ENTIDADES ASIGNADAS EN CAPACITACIONES
						// ACUMULADAS
						if (dtCapacitacionBkko.getIdCapacitacion() != null) {
							List<DtCapaEntidadesBk> dtCapaEntidadesBkList = getDtCapaEntidadByIdDCapa(
									dtCapacitacionBkko.getIdCapacitacion());
							if (dtCapaEntidadesBkList != null && dtCapaEntidadesBkList.size() > 0) {
								for (DtCapaEntidadesBk dtCapaEntidadesBke : dtCapaEntidadesBkList) {
									// SE COPIA LISTA ACTUAL DE ENTIDADES
									List<DtCapaEntidadesBk> listDtCapaEntidadesBka = dtCapaEntidadesBkListNew;
									boolean exist = false;
									for (DtCapaEntidadesBk dtCapaEntidadesBkba : listDtCapaEntidadesBka) {
										if (dtCapaEntidadesBkba.getIdEntidad().longValue() == dtCapaEntidadesBke
												.getIdEntidad().longValue()) {
											exist = true;
											break;
										}
									}
									if (!exist) {
										DtCapaEntidadesBk dtCapaEntidadesBky = new DtCapaEntidadesBk();
										dtCapaEntidadesBky.setIdEntidad(dtCapaEntidadesBke.getIdEntidad());
										dtCapaEntidadesBky.setIdCapacitacion(dtCapacitacionBkNew.getIdCapacitacion());
										dtCapaEntidadesBkListNew.add(dtCapaEntidadesBky);
									}
								}
							}
						}

						// GRABAR TEMAS AGENDADOS EN LA NUEVA CAPACITACION
						if (dtCapaTemasBkListNew != null && dtCapaTemasBkListNew.size() > 0) {
							for (DtCapaTemasBk dtCapaTemasBkx : dtCapaTemasBkListNew) {
								saveorupdateDtCapaTemasBk(dtCapaTemasBkx, user, kyUsuarioMod, kyAreaMod, rmtaddress);
							}
						}

						// GRABAR ENTIDADES ASIGNADAS EN LA NUEVA CAPACITACION
						if (dtCapaEntidadesBkListNew != null && dtCapaEntidadesBkListNew.size() > 0) {
							for (DtCapaEntidadesBk dtCapaEntidadesBkx : dtCapaEntidadesBkListNew) {
								saveorupdateDtCapaEntidadesBk(dtCapaEntidadesBkx, user, kyUsuarioMod, kyAreaMod,
										rmtaddress);
							}
						}
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Validador(e.getMessage());
			}

		}

		dtCapacitAcumula = getDtCapacitacionBkXid(dtCapacitAcumula.getIdCapacitacion(), kyUsuarioMod);
		return dtCapacitAcumula;
	}

	public DtCapacitacionBk copiarDatosAcumulac(DtCapacitacionBk dtCapacitacionBkaa,
			DtCapacitacionBk dtCapacitacionBkeee) {
		Long estadoAcumulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ACUMULADO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ACUMULADO);
		dtCapacitacionBkaa.setEstado(estadoAcumulado);
		dtCapacitacionBkaa.setFechaSoli(dtCapacitacionBkeee.getFechaSoli());
		dtCapacitacionBkaa.setFechaInic(dtCapacitacionBkeee.getFechaInic());
		dtCapacitacionBkaa.setFechaFin(dtCapacitacionBkeee.getFechaFin());
		dtCapacitacionBkaa.setIdModalidad(dtCapacitacionBkeee.getIdModalidad());
		dtCapacitacionBkaa.setDetalleCapaVirtual(dtCapacitacionBkeee.getDetalleCapaVirtual());
		dtCapacitacionBkaa.setIdLocal(dtCapacitacionBkeee.getIdLocal());
		dtCapacitacionBkaa.setCantPartic(dtCapacitacionBkeee.getCantPartic());
		dtCapacitacionBkaa.setCantParticAsist(dtCapacitacionBkeee.getCantParticAsist());
		dtCapacitacionBkaa.setNomEvento(dtCapacitacionBkeee.getNomEvento());
		dtCapacitacionBkaa.setIdNivel(dtCapacitacionBkeee.getIdNivel());
		dtCapacitacionBkaa.setIdPrestacion(dtCapacitacionBkeee.getIdPrestacion());
		dtCapacitacionBkaa.setIdTipo(dtCapacitacionBkeee.getIdTipo());
		return dtCapacitacionBkaa;
	}

	public List<DtCapaTemasBk> getDtCapaTemasByIdDCapa(Long idCapacitacion) throws Validador {
		List<DtCapaTemasBk> msObjectBks = new ArrayList<DtCapaTemasBk>();
		try {
			List<DtCapaTemas> msObjectDom = dtCapaTemasDao.getByIdCapacDtCapaTemas(idCapacitacion);
			for (DtCapaTemas msObject : msObjectDom) {
				DtCapaTemasBk oObjectBk = new DtCapaTemasBk();
				FuncionesStaticas.copyPropertiesObject(oObjectBk, msObject);
				completarDtCapaTemas(oObjectBk);
				msObjectBks.add(oObjectBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		return msObjectBks;
	}

	public List<DtCapaEntidadesBk> getDtCapaEntidadByIdDCapa(Long idCapacitacion) throws Validador {
		List<DtCapaEntidadesBk> msObjectBks = new ArrayList<DtCapaEntidadesBk>();
		try {
			List<DtCapaEntidades> msObjectDom = dtCapaEntidadesDao.getByIdCapacDtCapaEntidades(idCapacitacion);
			for (DtCapaEntidades msObject : msObjectDom) {
				DtCapaEntidadesBk oObjectBk = new DtCapaEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(oObjectBk, msObject);
				completarDtCapaEntidades(oObjectBk);
				msObjectBks.add(oObjectBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		return msObjectBks;
	}

	// MPINARES 14022024 - FIN

	// PURIBE 14032024 -INICIO-->

	private void completarDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk) {
		try {
			if (dtVisitasUsuinternosBk.getIdVisita() != null && dtVisitasUsuinternosBk.getIdVisita().longValue() > 0) {
				DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasUsuinternosBk.getIdVisita());
				if (dtVisitas != null)
					dtVisitasUsuinternosBk.setIdVisitaTxt(dtVisitas.getConclusion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasUsuinternosBk.getIdUsuinterno() != null
					&& dtVisitasUsuinternosBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtVisitasUsuinternosBk.getIdUsuinterno());

				if (msUsuarios != null) {
					String Nombrecompleto = FuncionesStaticas.getNombreCompleto(msUsuarios);
					dtVisitasUsuinternosBk.setIdUsuinternoTxt(Nombrecompleto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasUsuinternosBk.getEstado() != null && dtVisitasUsuinternosBk.getEstado().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasUsuinternosBk.getEstado());
				if (prtParametros != null)
					dtVisitasUsuinternosBk.setEstadoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasUsuinternosBk.getIdTema() != null && dtVisitasUsuinternosBk.getIdTema().longValue() > 0) {
				MsTema msTema = msTemaDao.getMsTema(dtVisitasUsuinternosBk.getIdTema());
				if (msTema != null)
					dtVisitasUsuinternosBk.setIdTemaTxt(msTema.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (dtVisitasUsuinternosBk.getIdUsuinterno() != null
					&& dtVisitasUsuinternosBk.getIdUsuinterno().longValue() > 0) {
				MsUsuarios msUsuarios = msUsuariosDao.getMsUsuarios(dtVisitasUsuinternosBk.getIdUsuinterno());
				if (msUsuarios != null)
					dtVisitasUsuinternosBk.setIdSistAdm(msUsuarios.getIdSistAdmi());
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(msUsuarios.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					dtVisitasUsuinternosBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// PURIBE 14032024 -FIN-->

	// PURIBE 14032024 - INICIO-->
	@Override
	public List<DtVisitasUsuinternosBk> getDtVisitasUsuinternosXFiltro(Long idVisita, Long kyUsuarioMod) {
		List<DtVisitasUsuinternosBk> dtVisitasUsuinternosBkss = new ArrayList<DtVisitasUsuinternosBk>();
		try {
			List<DtVisitasUsuinternos> dtVisitasUsuinternossss = dtVisitasUsuinternosDao.getXFiltro(idVisita);
			for (DtVisitasUsuinternos dtVisitasUsuinternos : dtVisitasUsuinternossss) {
				DtVisitasUsuinternosBk dtVisitasUsuinternosBk = new DtVisitasUsuinternosBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasUsuinternosBk, dtVisitasUsuinternos);
				completarDtVisitasUsuinternos(dtVisitasUsuinternosBk);
				setACLDtVisitasUsuinternosBk(dtVisitasUsuinternosBk, kyUsuarioMod);
				dtVisitasUsuinternosBkss.add(dtVisitasUsuinternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasUsuinternosBkss;
	}
	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 -INICIO-->
	@Override
	public List<MsUsuariosDto> getMsUsuariosCachee() {
		if (msUsuariosListaCache == null) {
			// listo usuarios activos falta poner, usuarios que filtrados por
			// roles
			List<MsUsuarios> msUsuariossss = msUsuariosDao.getActivasMsUsuarios();
			msUsuariosListaCache = new ArrayList<MsUsuariosDto>();
			for (MsUsuarios msUsuarios : msUsuariossss) {
				MsUsuariosDto msUsuariosDto = new MsUsuariosDto();
				FuncionesStaticas.copyPropertiesObject(msUsuariosDto, msUsuarios);
				String Nombrecompleto = FuncionesStaticas.getNombreCompleto(msUsuarios);
				msUsuariosDto.setIdUsuinternoTxt(Nombrecompleto);

				try {
					if (msUsuariosDto.getIdusuario() != null && msUsuariosDto.getIdusuario().longValue() > 0) {
						MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
								.getMsSisAdmistrativo(msUsuariosDto.getIdSistAdmi());
						if (msSisAdmistrativo != null)
							msUsuariosDto.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				msUsuariosListaCache.add(msUsuariosDto);

			}
		}
		return msUsuariosListaCache;
	}

	// PURIBE 22032024 -INICIO-->
	@Override
	public List<MsUsuariosDto> getMsUsuariosCache(Long idSede, int pProfile, String sUsername) {
		if (perfilcache == null || perfilcache != pProfile) {
			msUsuariosListaCache = null;
			perfilcache = pProfile;
		}

		if (msUsuariosListaCache == null || msUsuariosListaCache.size() == 0) {

			List<MsUsuarios> msUsuariossss;
			if (pProfile == 1) {

				msUsuariossss = msUsuariosDao.getActivasMsUsuarios();
			} else {
				msUsuariossss = msUsuariosDao.getMsUsuarioByIdSedexUsername(idSede, sUsername);
			}

			// PURIBE 22032024 -FIN-->
			msUsuariosListaCache = new ArrayList<MsUsuariosDto>();
			for (MsUsuarios msUsuarios : msUsuariossss) {
				MsUsuariosDto msUsuariosDto = new MsUsuariosDto();
				FuncionesStaticas.copyPropertiesObject(msUsuariosDto, msUsuarios);
				String Nombrecompleto = FuncionesStaticas.getNombreCompleto(msUsuarios);
				msUsuariosDto.setIdUsuinternoTxt(Nombrecompleto);

				try {
					if (msUsuariosDto.getIdusuario() != null && msUsuariosDto.getIdusuario().longValue() > 0) {
						MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
								.getMsSisAdmistrativo(msUsuariosDto.getIdSistAdmi());
						if (msSisAdmistrativo != null)
							msUsuariosDto.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				msUsuariosListaCache.add(msUsuariosDto);

			}
		}
		return msUsuariosListaCache;
	}
	// PURIBE 14032024 -FIN-->

	// PURIBE 14032024 - INICIO -->
	@Override
	public List<DtEntidadesBk> getDtEntidadesXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo,
			Long idCaract, Integer codDpto, Integer codProv, Integer codDistr, Long idSistAdmi, String geozona,
			Long kyUsuarioMod) {
		List<DtEntidadesBk> dtEntidadesBkss = new ArrayList<DtEntidadesBk>();
		try {
			List<DtEntidades> dtEntidadessss = dtEntidadesDao.getXFiltro(codEjec, razSocial, ruc, idTipo, idCaract,
					codDpto, codProv, codDistr, idSistAdmi, geozona);
			// PURIBE 14032024 - FIN-->
			for (DtEntidades dtEntidades : dtEntidadessss) {
				DtEntidadesBk dtEntidadesBk = new DtEntidadesBk();
				FuncionesStaticas.copyPropertiesObject(dtEntidadesBk, dtEntidades);
				completarDtEntidades(dtEntidadesBk);
				setACLDtEntidadesBk(dtEntidadesBk, kyUsuarioMod);
				dtEntidadesBkss.add(dtEntidadesBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtEntidadesBkss;
	}

	/* PURIBE 14032024 - INICIO--> */
	/* PURIBE 04042024 - INICIO--> */
	@Override
	public List<DtVisitasBk> getAllDtVisitasActivosCero(Long kyUsuarioMod, Timestamp fechaInicio, Timestamp fechaFin,
			int programada, long sede, int rol, long sistemaadmi) {
		List<DtVisitasBk> dtVisitasBkss = new ArrayList<DtVisitasBk>();
		try {
			// List<DtVisitas> dtVisitass =
			// dtVisitasDao.getActivasDtVisitasCero(fechaInicio,fechaFin);
			List<DtVisitas> dtVisitass = new ArrayList<>();

			if (rol == 0) {
				if (programada == 1)

				{
					dtVisitass = dtVisitasDao.getXFiltro(null, null, 121L, null, null, null, null, null, null, null,
							null, fechaInicio, fechaFin, null);
				} else {
					dtVisitass = dtVisitasDao.getXFiltro(null, null, null, null, null, null, null, null, null, null,
							null, fechaInicio, fechaFin, null);
				}
			} else if (rol == 1) {
				if (programada == 1)

				{
					dtVisitass = dtVisitasDao.getXFiltro(null, null, 121L, null, null, null, null, sede, null, null,
							null, fechaInicio, fechaFin, null);
				} else {
					dtVisitass = dtVisitasDao.getXFiltro(null, null, null, null, null, null, null, sede, null, null,
							null, fechaInicio, fechaFin, null);
				}

			} else if (rol == 2) {

				if (programada == 1)

				{
					dtVisitass = dtVisitasDao.getXFiltro(null, null, 121L, null, null, null, null, sede, sistemaadmi,
							null, null, fechaInicio, fechaFin, kyUsuarioMod);
				} else {
					dtVisitass = dtVisitasDao.getXFiltro(null, null, null, null, null, null, null, sede, sistemaadmi,
							null, null, fechaInicio, fechaFin, kyUsuarioMod);
				}

			}
			/* PURIBE 04042024 - FIN--> */

			for (DtVisitas dtVisitas : dtVisitass) {
				DtVisitasBk dtVisitasBk = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
				completarDtVisitas(dtVisitasBk);
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
				dtVisitasBkss.add(dtVisitasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasBkss;
	}

	/* PURIBE 14032024 - FIN--> */
	/* PURIBE 14032024 - INICIO--> */
	private void completarDtVisitas(DtVisitasBk dtVisitasBk) {
		try {
			if (dtVisitasBk.getEstado() != null && dtVisitasBk.getEstado().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getEstado());
				if (prtParametros != null)
					dtVisitasBk.setEstadoTxt(prtParametros.getDescripcion());
			}

			if (dtVisitasBk.getEstado() != null && dtVisitasBk.getEstado().longValue() > 0) {
				Long estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
				Long estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
				/* PURIBE 22042024 - INICIO--> */
				Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
				if (dtVisitasBk.getEstado().longValue() == estadoNuevo) {
					dtVisitasBk.setEstadoTxt("EN PROCESO");
				} else if (dtVisitasBk.getEstado().longValue() == estadoEliminado) {
					dtVisitasBk.setEstadoTxt("ANULADO");
				} else if (dtVisitasBk.getEstado().longValue() == estadoFinalizado) {
					dtVisitasBk.setEstadoTxt("FINALIZADO");
				}
				/* PURIBE 22042024 - FIN--> */ else {
					PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getEstado());
					if (prtParametros != null)
						dtVisitasBk.setEstadoTxt(prtParametros.getDescripcion());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdOrigen() != null && dtVisitasBk.getIdOrigen().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getIdOrigen());
				if (prtParametros != null)
					dtVisitasBk.setIdOrigenTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdProgramacion() != null && dtVisitasBk.getIdProgramacion().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getIdProgramacion());
				if (prtParametros != null)
					dtVisitasBk.setIdProgramacionTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdModalidad() != null && dtVisitasBk.getIdModalidad().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getIdModalidad());
				if (prtParametros != null)
					dtVisitasBk.setIdModalidadTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdTipo() != null && dtVisitasBk.getIdTipo().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getIdTipo());
				if (prtParametros != null)
					dtVisitasBk.setIdTipoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdLugar() != null && dtVisitasBk.getIdLugar().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getIdLugar());
				if (prtParametros != null)
					dtVisitasBk.setIdLugarTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdSede() != null && dtVisitasBk.getIdSede().longValue() > 0) {
				MsSedes msSedes = msSedesDao.getMsSedes(dtVisitasBk.getIdSede());
				if (msSedes != null)
					dtVisitasBk.setIdSedeTxt(msSedes.getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdSistAdm() != null && dtVisitasBk.getIdSistAdm().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(dtVisitasBk.getIdSistAdm());
				if (msSisAdmistrativo != null)
					dtVisitasBk.setIdSistAdmTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdFinancia() != null && dtVisitasBk.getIdFinancia().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtVisitasBk.getIdFinancia());
				if (prtParametros != null)
					dtVisitasBk.setIdFinanciaTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdEntidad() != null && dtVisitasBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtVisitasBk.getIdEntidad());

				if (dtEntidades != null) {
					dtVisitasBk.setIdEntidadTxt(dtEntidades.getRazSocial());
					dtVisitasBk.setCodEjecutora(dtEntidades.getCodEjec());// PURIBE
																			// 14032024
																			// -INICIO-->
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			if (dtVisitasBk.getIdEntidad() != null && dtVisitasBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtVisitasBk.getIdEntidad());

				if (dtEntidades != null)
					dtVisitasBk.setIdDepartamento(Long.parseLong(String.valueOf(dtEntidades.getCodDpto())));

				if (dtVisitasBk.getIdDepartamento() != null) {
					MsUbigeoId msUbigeoId = new MsUbigeoId();

					msUbigeoId.setCodDpto(Integer.parseInt(String.valueOf(dtVisitasBk.getIdDepartamento())));
					msUbigeoId.setCodProv(0);
					msUbigeoId.setCodDistr(0);
					MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
					if (msUbigeo != null) {
						dtVisitasBk.setIdDepartamentoTxt(msUbigeo.getDescripcion());
					}

				}

			}
			if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {
				//JPUYEN 17062024 - INICIO
				List<DtVisitasUsuinternos> dtVisitasUsuinternoss = new ArrayList<>();
				if(dtVisitasBk.getEstado() == Estado.ELIMINADO.getValor()){
					dtVisitasUsuinternoss = dtVisitasUsuinternosDao.getXFiltroConcatenacionLista(dtVisitasBk.getIdVisita());
				}else{
					dtVisitasUsuinternoss = dtVisitasUsuinternosDao.getXFiltro(dtVisitasBk.getIdVisita());
				}
				//JPUYEN 17062024 - INICIO

				if (dtVisitasUsuinternoss != null) {
					int totalRegistros = dtVisitasUsuinternoss.size();
					int contador = 0;
					String concatenar = "";

					for (DtVisitasUsuinternos visita : dtVisitasUsuinternoss) {
						MsUsuarios msUsuarios = new MsUsuarios();
						msUsuarios = msUsuariosDao.getMsUsuarios(visita.getIdUsuinterno());
						concatenar += msUsuarios.getApellidoPaterno() + ' ' + msUsuarios.getApellidoMaterno();

						contador++;

						// Agrega una coma solo si no es el último elemento
						if (contador < totalRegistros) {
							concatenar += ",";
						}

					}

					dtVisitasBk.setIdParticipanteTxt(concatenar);
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			if (dtVisitasBk.getIdEntidad() != null && dtVisitasBk.getIdEntidad().longValue() > 0) {
				DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtVisitasBk.getIdEntidad());

				if (dtEntidades != null)
					dtVisitasBk.setIdDepartamento(Long.parseLong(String.valueOf(dtEntidades.getCodDpto())));

				if (dtVisitasBk.getIdDepartamento() != null) {
					MsUbigeoId msUbigeoId = new MsUbigeoId();

					msUbigeoId.setCodDpto(Integer.parseInt(String.valueOf(dtVisitasBk.getIdDepartamento())));
					msUbigeoId.setCodProv(0);
					msUbigeoId.setCodDistr(0);
					MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
					if (msUbigeo != null) {
						dtVisitasBk.setIdDepartamentoTxt(msUbigeo.getDescripcion());
					}

				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	/* PURIBE 14032024 - FIN--> */

	// PURIBE 14032024 - INICIO-->
	@Override
	public void deleteDtVisitas(List<DtVisitasBk> dtVisitasBkL, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtVisitas dtVisitas = null;
			String msm = "";

			Long estadoAnulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
					PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
			Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
					PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);

			for (DtVisitasBk dtVisitasBk : dtVisitasBkL) {

				if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {

					dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());

					this.validaranularDtVisitas(dtVisitasBk, kyUsuarioMod);

					if (dtVisitasBk.getEstado().longValue() == estadoAnulado) {
						// msm = "LA VISITA DE ID: "+
						// dtVisitasBk.getIdVisita()+" YA SE ENCUENTRA
						// ANULADA;";
						// msm = "La visita de id: "+
						// dtVisitasBk.getIdVisita()+" ya se encuentra
						// anulada";//PURIBE 29032024 INICIO-->
						msm = "La reunión de trabajo de ID: " + dtVisitasBk.getIdVisita() + " ya se encuentra anulada";// PURIBE
																														// 29032024
																														// INICIO-->//PURIBE
																														// 12042024
																														// INICIO-->

						throw new Validador(msm);

					} else if (dtVisitasBk.getEstado().longValue() == estadoFinalizado) {
						// msm = "NO ES POSIBLE ANULAR UN REGISTRO FINALIZADO,
						// ID: "+dtVisitasBk.getIdVisita();
						msm = "No es posible anular un registo finalizado, ID: " + dtVisitasBk.getIdVisita();// PURIBE
																												// 29032024
																												// INICIO-->
						// JSFUtil.showMessageError(msm, Messages
						// .getStringToKey("comun.ERROR"));
						throw new Validador(msm);
					}

					// Delete Visita User
					List<DtVisitasUsuinternosBk> listaInternalUseraSelect = this
							.getDtVisitasUsuinternosXFiltro(dtVisitasBk.getIdVisita(), kyUsuarioMod);
					for (DtVisitasUsuinternosBk vistUser : listaInternalUseraSelect) {
						DtVisitasUsuinternosBk vistaUsuarioBk = new DtVisitasUsuinternosBk();
						FuncionesStaticas.copyPropertiesObject(vistaUsuarioBk, vistUser);
						this.deleteDtVisitasUsuinternos(vistaUsuarioBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
					}

					Timestamp hoy = new Timestamp(System.currentTimeMillis());

					dtVisitas.setRtmaddressrst(rmtaddress);
					dtVisitas.setIdusserModif(kyUsuarioMod);
					dtVisitas.setFechaModif(hoy);
					Long estadoanterior = dtVisitas.getEstado();
					dtVisitas.setEstado(PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
							PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO));

					dtVisitasDao.updateDtVisitas(dtVisitas);

					log.log(Level.INFO,
							"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
									+ "ELIMINADO dtVisitas" + " :: " + dtVisitas.getIdVisita().toString() + " :: "
									+ estadoanterior + " :: " + "0");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}
	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 - INICIO-->
	@Override
	public List<DtVisitasBk> getDtVisitasXFiltro(Timestamp fechaVisita, Long idOrigen, Long idProgramacion,
			Long idModalidad, Long idTipo, Long idLugar, Long idEntidad, Long idSede, Long idSistAdm, Long idFinancia,
			Timestamp fechaProgramada, Long kyUsuarioMod) {
		List<DtVisitasBk> dtVisitasBkss = new ArrayList<DtVisitasBk>();
		try {
			List<DtVisitas> dtVisitassss = dtVisitasDao.getXFiltro(fechaVisita, idOrigen, idProgramacion, idModalidad,
					idTipo, idLugar, idEntidad, idSede, idSistAdm, idFinancia, fechaProgramada,null,null,kyUsuarioMod);//JPUYEN 17062024 - se grega kyUsuarioMod
			for (DtVisitas dtVisitas : dtVisitassss) {
				DtVisitasBk dtVisitasBk = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasBk, dtVisitas);
				completarDtVisitas(dtVisitasBk);
				setACLDtVisitasBk(dtVisitasBk, kyUsuarioMod);
				dtVisitasBkss.add(dtVisitasBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtVisitasBkss;
	}
	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 - INICIO-->
	@Override
	public List<PrtParametrosBk> getPrtParametrosXFiltro(Long idpadre, String descripcion, Long kyUsuarioMod) {
		List<PrtParametrosBk> prtParametrosBkss = new ArrayList<PrtParametrosBk>();
		try {
			List<PrtParametros> prtParametrossss = prtParametrosDao.getXFiltro(idpadre, descripcion);
			for (PrtParametros prtParametros : prtParametrossss) {
				PrtParametrosBk prtParametrosBk = new PrtParametrosBk();
				FuncionesStaticas.copyPropertiesObject(prtParametrosBk, prtParametros);
				completarPrtParametros(prtParametrosBk);
				setACLPrtParametrosBk(prtParametrosBk, kyUsuarioMod);
				prtParametrosBkss.add(prtParametrosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prtParametrosBkss;
	}
	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 - INICIO-->
	private void completarDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, Long kyUsuarioMod) {
		try {
			if (dtUsuarioExternoBk.getEstado() != null && dtUsuarioExternoBk.getEstado().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(dtUsuarioExternoBk.getEstado());
				if (prtParametros != null)
					dtUsuarioExternoBk.setEstadoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getIdTipodocumento() != null
					&& dtUsuarioExternoBk.getIdTipodocumento().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao
						.getPrtParametros(dtUsuarioExternoBk.getIdTipodocumento());
				if (prtParametros != null)
					dtUsuarioExternoBk.setIdTipodocumentoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getCodDpto() != null && dtUsuarioExternoBk.getCodDpto().intValue() > 0) {
				int iiCodDpto = dtUsuarioExternoBk.getCodDpto().intValue();
				int iiCodProv = 0;
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtUsuarioExternoBk.setCodDptoTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getCodDpto() != null && dtUsuarioExternoBk.getCodDpto().intValue() > 0
					&& dtUsuarioExternoBk.getCodProv() != null && dtUsuarioExternoBk.getCodProv().intValue() > 0) {
				int iiCodDpto = dtUsuarioExternoBk.getCodDpto().intValue();
				int iiCodProv = dtUsuarioExternoBk.getCodProv().intValue();
				int iiCodDistr = 0;
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtUsuarioExternoBk.setCodProvTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getCodDpto() != null && dtUsuarioExternoBk.getCodDpto().intValue() > 0
					&& dtUsuarioExternoBk.getCodProv() != null && dtUsuarioExternoBk.getCodProv().intValue() > 0
					&& dtUsuarioExternoBk.getCodDistr() != null && dtUsuarioExternoBk.getCodDistr().intValue() > 0) {
				int iiCodDpto = dtUsuarioExternoBk.getCodDpto().intValue();
				int iiCodProv = dtUsuarioExternoBk.getCodProv().intValue();
				int iiCodDistr = dtUsuarioExternoBk.getCodDistr().intValue();
				MsUbigeoId msUbigeoId = new MsUbigeoId();
				msUbigeoId.setCodDpto(iiCodDpto);
				msUbigeoId.setCodProv(iiCodProv);
				msUbigeoId.setCodDistr(iiCodDistr);
				MsUbigeo msUbigeo = msUbigeoDao.getMsUbigeo(msUbigeoId);
				if (msUbigeo != null)
					dtUsuarioExternoBk.setCodDistrTxt(msUbigeo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (dtUsuarioExternoBk.getIdpais() != null && dtUsuarioExternoBk.getIdpais().longValue() > 0) {
				MsPaises msPaises = msPaisesDao.getMsPaises(dtUsuarioExternoBk.getIdpais());
				if (msPaises != null)
					dtUsuarioExternoBk.setIdpaisTxt(msPaises.getPaisNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// puribe

		try {
			if (dtUsuarioExternoBk.getIdUsuexterno() != null && dtUsuarioExternoBk.getIdUsuexterno().longValue() > 0) {

				List<DtEntidadesUsuexternos> dtEntidadesUsuexternosList = dtEntidadesUsuexternosDao
						.getXFiltroidUsuexterno(dtUsuarioExternoBk.getIdUsuexterno());

				if (dtEntidadesUsuexternosList != null && dtEntidadesUsuexternosList.size() > 0) {
					DtEntidadesUsuexternos dtEntidadesUsuexternosCopy = dtEntidadesUsuexternosList.get(0);
					if (dtEntidadesUsuexternosCopy.getIdUsuextEnti() != null
							&& dtEntidadesUsuexternosCopy.getIdUsuextEnti().longValue() > 0) {
						// PARA ENTIDAD
						if (dtEntidadesUsuexternosCopy.getIdEntidad() != null
								&& dtEntidadesUsuexternosCopy.getIdEntidad().longValue() > 0) {
							DtEntidades dtEntidades = dtEntidadesDao
									.getDtEntidades(dtEntidadesUsuexternosCopy.getIdEntidad());
							if (dtEntidades != null) {
								// dtUsuarioExternoBk.setNombreEntidad(dtEntidades.getRazSocial());
								// dtUsuarioExternoBk.setEjecutorEntidad(dtEntidades.getCodEjec());
								// PURIBE 22042024 - INICIO-->
								dtUsuarioExternoBk.setNombreEntidad(dtEntidades.getRazSocial());
								dtUsuarioExternoBk.setEjecutorEntidad(dtEntidades.getCodEjec());
								// PURIBE 22042024 - FIN-->
							}
						}

						// PARA CARGOS

						List<DtCargosUsuexterBk> dtCargosUsuexterList = this.getDtCargosUsuexterXFiltro(
								dtEntidadesUsuexternosCopy.getIdUsuextEnti(), null, kyUsuarioMod);
						if (dtCargosUsuexterList != null && dtCargosUsuexterList.size() > 0) {
							// List<String> cargos = new ArrayList<String>();

							for (int i = 0; i < dtCargosUsuexterList.size(); i++) {
								if (dtCargosUsuexterList.get(i).getIdCargo() != null
										&& dtCargosUsuexterList.get(i).getIdCargo().longValue() > 0) {
									PrtParametros prtParametros = prtParametrosDao
											.getPrtParametros(dtCargosUsuexterList.get(i).getIdCargo());
									if (prtParametros != null) {

										dtCargosUsuexterList.get(i).setIdCargoTxt(prtParametros.getDescripcion());
										// cargos.add(prtParametros.getDescripcion());
									}
								}
							}

							dtUsuarioExternoBk.setUsucargos(dtCargosUsuexterList);

						}

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// PURIBE 14032024 - FIN-->

	}

	// PURIBE 14032024 - INICIO-->
	@Override
	public List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro(String nombre, String aPaterno, String aMaterno,
			String direccion, Integer codDpto, Integer codProv, Integer codDistr, String numDocum, Long kyUsuarioMod) {
		List<DtUsuarioExternoBk> dtUsuarioExternoBkss = new ArrayList<DtUsuarioExternoBk>();

		try {

			List<DtUsuarioExterno> dtUsuarioExternosss = dtUsuarioExternoDao.getXFiltro(nombre, aPaterno, aMaterno,
					direccion, codDpto, codProv, codDistr, numDocum);

			for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternosss) {
				DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
				completarDtUsuarioExterno(dtUsuarioExternoBk, kyUsuarioMod);
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
				dtUsuarioExternoBkss.add(dtUsuarioExternoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuarioExternoBkss;
	}
	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 -INICIO-->
	private void completarMsTema(MsTemaBk msTemaBk) {
		try {
			if (msTemaBk.getIdSistAdmi() != null && msTemaBk.getIdSistAdmi().longValue() > 0) {
				MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
						.getMsSisAdmistrativo(msTemaBk.getIdSistAdmi());
				if (msSisAdmistrativo != null)
					msTemaBk.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msTemaBk.getEstado() != null && msTemaBk.getEstado().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msTemaBk.getEstado());
				if (prtParametros != null)
					msTemaBk.setEstadoTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (msTemaBk.getTipoServicio() != null && msTemaBk.getTipoServicio().longValue() > 0) {
				PrtParametros prtParametros = prtParametrosDao.getPrtParametros(msTemaBk.getTipoServicio());
				if (prtParametros != null)
					msTemaBk.setTipoServicioTxt(prtParametros.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (msTemaBk.getIdTema() != null && msTemaBk.getIdTema().longValue() > 0) {
				msTemaBk.setIdTemaTxt(msTemaBk.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// PURIBE 14032024 -FIN->

	}

	// PURIBE 14032024 - INICIO-->
	@Override
	public List<MsTemaBk> getMsTemaXFiltro(String descripcion, Long idSistAdmi, Long tipoServicio, Long kyUsuarioMod) {
		List<MsTemaBk> msTemaBkss = new ArrayList<MsTemaBk>();
		try {
			List<MsTema> msTemasss = msTemaDao.getXFiltro(descripcion, idSistAdmi, tipoServicio);
			for (MsTema msTema : msTemasss) {
				MsTemaBk msTemaBk = new MsTemaBk();
				FuncionesStaticas.copyPropertiesObject(msTemaBk, msTema);
				completarMsTema(msTemaBk);
				setACLMsTemaBk(msTemaBk, kyUsuarioMod);
				msTemaBkss.add(msTemaBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msTemaBkss;
	}
	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 - INICIO-->
	@Override
	public void reactivarDtVisitas(DtVisitasBk dtVisitasBk, String user, Long kyUsuarioMod, Long kyAreaMod,
			String rmtaddress) throws Validador {
		try {
			DtVisitas dtVisitas = null;
			String msm = "";
			Timestamp hoy = new Timestamp(System.currentTimeMillis());

			int nivel = 1;

			if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {
				dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());

				this.validarreactivarDtVisitas(dtVisitasBk, kyUsuarioMod);

				boolean cambios = AuditoriaDtVisitasMng.auditarCambiosDtVisitas(dtVisitasBk, dtVisitas,
						dtVisitas.getIdusserCrea(), dtVisitas.getIdusserCrea().toString(), dtVisitas.getRtmaddress(),
						nivel);

				if (cambios) {

					dtVisitas.setRtmaddressrst(rmtaddress);
					dtVisitas.setIdusserModif(kyUsuarioMod);
					dtVisitas.setFechaModif(hoy);
					// Long estadoanterior = dtVisitas.getEstado();
					// dtVisitas.setEstado(PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
					// PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO));

					dtVisitasDao.updateDtVisitas(dtVisitas);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

	}

	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 - INICIO-->
	public void validarreactivarDtVisitas(DtVisitasBk dtVisitasBk, Long kyUsuarioMod) throws Validador {

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);

		Integer mesServicio = dtVisitasBk.getFechaVisita().getMonth() + 1;

		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}

		DtAmpliacionFechaBk dtAmpliacionFechasss = this.getDtAmpliacionFechaXFiltro(idTipoFechaCorteEjecucion,
				dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), kyUsuarioMod, mesServicio);

		ValidacionDtVisitasMng.validarFechaReactiva(dtVisitasBk, dtAmpliacionFechasss);

	}

	// PURIBE 14032024 - FIN-->

	// PURIBE 14032024 - INICIO-->
	@Override
	public DtAmpliacionFechaBk getDtAmpliacionFechaXFiltro(Long tipoFechaCorte, Long idSede, Long idSistAdmi,
			Long kyUsuarioMod, int mesServicio) {

		DtAmpliacionFechaBk dtAmpliacionFechaBk = new DtAmpliacionFechaBk();
		try {
			DtAmpliacionFecha dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSede, idSistAdmi,
					mesServicio + 1);

			if (dtAmpliacionFechasss == null) {
				dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSedeTodas, idSistAdmi,
						mesServicio + 1);

				if (dtAmpliacionFechasss == null) {
					dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSede, idSisAdmTodos,
							mesServicio + 1);

					if (dtAmpliacionFechasss == null) {
						dtAmpliacionFechasss = dtAmpliacionFechaDao.getXFiltro(tipoFechaCorte, idSedeTodas,
								idSisAdmTodos, mesServicio + 1);
					}
				}
			}

			FuncionesStaticas.copyPropertiesObject(dtAmpliacionFechaBk, dtAmpliacionFechasss);
			completarDtAmpliacionFecha(dtAmpliacionFechaBk);
			setACLDtAmpliacionFechaBk(dtAmpliacionFechaBk, kyUsuarioMod);

			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAmpliacionFechaBk;
	}
	// PURIBE 14032024 - FIN-->

	@Override
	public Long getDtUsuarioExternoTotalXFiltro(String nombre, String aPaterno, String aMaterno, String direccion,
			Integer codDpto, Integer codProv, Integer codDistr, String numDocum, Long kyUsuarioMod) {
		try {
			Long totalDtUsuarioExternosss = dtUsuarioExternoDao.getTotalXFiltro(nombre, aPaterno, aMaterno, direccion,
					codDpto, codProv, codDistr, numDocum);

			return totalDtUsuarioExternosss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// PURIBE 22042024 -INICIO-->

	public DtVisitasBk finalizarDtVisita(DtVisitasBk dtVisitasBk, Long idSistemaAdmin, Long kyUsuarioMod)
			throws Validador {

		DtVisitas dtVisitas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel = 1;

		try {
			if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {
				dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());

				boolean cambios = AuditoriaDtVisitasMng.auditarCambiosDtVisitas(dtVisitasBk, dtVisitas,
						dtVisitas.getIdusserCrea(), dtVisitas.getIdusserCrea().toString(), dtVisitas.getRtmaddress(),
						nivel);

				if (cambios) {

					FuncionesStaticas.copyPropertiesObject(dtVisitas, dtVisitasBk);
					dtVisitas.setIdusserModif(kyUsuarioMod);
					dtVisitas.setFechaModif(hoy);
					dtVisitasDao.updateDtVisitas(dtVisitas);

				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Validador(e.getMessage());
		}

		dtVisitasBk = getDtVisitasBkXid(dtVisitas.getIdVisita(), kyUsuarioMod);
		return dtVisitasBk;

	}

	public boolean validarFechaEdit(DtVisitasBk dtVisitasBk) throws Validador {
		boolean retorno = false;
		try {
			if (dtVisitasBk != null && dtVisitasBk.getIdVisita() != null) {
				if (dtVisitasBk.getFechaVisita() != null) {
					GregorianCalendar fechaLimitEdit = new GregorianCalendar();
					fechaLimitEdit = VerfechaLimitEditMensual(dtVisitasBk.getFechaVisita(), -1);
					GregorianCalendar fechaHoy = new GregorianCalendar();
					// con ampliacion de fecha de programacion
					DtAmpliacionFecha autorizacionProgramacion = this
							.getautorizacionProgramacion2(dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm());
					if (autorizacionProgramacion != null && autorizacionProgramacion.getFechaFin() != null) {
						GregorianCalendar fechaautorizacionProgramacion = new GregorianCalendar();
						fechaautorizacionProgramacion = VerfechaLimitFinDay(autorizacionProgramacion.getFechaFin(), 0);
						//
						if (fechaHoy.before(fechaautorizacionProgramacion)
								&& fechaautorizacionProgramacion.after(fechaLimitEdit)) {
							int meslimitEdit = fechaLimitEdit.get(Calendar.MONTH);
							int mesamplProg = fechaautorizacionProgramacion.get(Calendar.MONTH);
							if (meslimitEdit == mesamplProg) {
								fechaLimitEdit = fechaautorizacionProgramacion;
							}
						}
					}
					// ***************************************
					if (fechaHoy.after(fechaLimitEdit)) {
						retorno = false;
					} else {
						retorno = true;
					}
				}
			} else {
				retorno = true;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Validador(e.getMessage());
		}

		return retorno;
	}

	public static GregorianCalendar VerfechaLimitFinDay(Date fecha, int mesLimit) {
		GregorianCalendar fechaLimitFin = new GregorianCalendar();
		fechaLimitFin.setTimeInMillis(fecha.getTime());
		fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
		fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
		fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
		fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
		return fechaLimitFin;
	}

	public static GregorianCalendar VerfechaLimitEditMensual(Date fecha, int mesLimit) {
		GregorianCalendar fechaLimitFin = new GregorianCalendar();
		fechaLimitFin.setTimeInMillis(fecha.getTime());
		fechaLimitFin.add(Calendar.MONTH, mesLimit);

		GregorianCalendar fechaServicio = new GregorianCalendar();
		fechaServicio.setTimeInMillis(fecha.getTime());
		int diaHoy = fechaServicio.get(Calendar.DATE);

		Long diasLimitProg = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIALIMIT_PROGRAMAR,
				PropertiesMg.DEFOULT_DIALIMIT_PROGRAMAR);
		fechaLimitFin.set(Calendar.DAY_OF_MONTH, diasLimitProg.intValue());

		fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
		fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
		fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
		fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));

		return fechaLimitFin;
	}

	@Override
	public void updateBloqueoEncuesta(DtEncuestaBk dtEncuestaBk, Long kyUsuarioMod, String rmtaddress)
			throws Validador {
		try {

			if (dtEncuestaBk.getIdEncuesta() != null) {
				Long flagBloqueado = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI,
						PropertiesMg.DEFAULT_PRTPARAMETROS_ENCUESTA_BLOQUEADO_SI);
				Timestamp hoy = new Timestamp(System.currentTimeMillis());
				DtEncuesta encuesta = dtEncuestaDao.getDtEncuesta(dtEncuestaBk.getIdEncuesta());

				encuesta.setFlagBloqueo(flagBloqueado);

				encuesta.setIdusserModif(kyUsuarioMod);
				encuesta.setFechaModif(hoy);
				encuesta.setRtmaddressrst(rmtaddress);
				dtEncuestaDao.updateDtEncuesta(encuesta);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}

	}

	public void validarfinalizarDtVisitas(DtVisitasBk dtVisitasBk, Long kyUsuarioMod) throws Validador {

		Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);

		Integer mesServicio = dtVisitasBk.getFechaVisita().getMonth() + 1;

		if (mesServicio.intValue() == 12) {
			mesServicio = 0;
		}
		DtAmpliacionFechaBk dtAmpliacionFechasss = this.getDtAmpliacionFechaXFiltro(idTipoFechaCorteEjecucion,
				dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), kyUsuarioMod, mesServicio);

		ValidacionDtVisitasMng.validarFechaAnulacion(dtVisitasBk, dtAmpliacionFechasss);

	}

	@Override
	public List<DtEntidadesBk> getMsInstitucionesActivas(String rasonsocial) {
		List<DtEntidadesBk> msInstitucionesIdproveeLista = new ArrayList<DtEntidadesBk>();
		if (rasonsocial == null)
			return msInstitucionesIdproveeLista;
		if (rasonsocial.length() < 3)
			return msInstitucionesIdproveeLista;
		List<DtEntidades> msInstitucionessss = dtEntidadesDao.getListaRasonsocial(rasonsocial.toUpperCase());
		for (DtEntidades msInstituciones : msInstitucionessss) {
			DtEntidadesBk msInstitucionesBk = new DtEntidadesBk();
			FuncionesStaticas.copyPropertiesObject(msInstitucionesBk, msInstituciones);
			msInstitucionesIdproveeLista.add(msInstitucionesBk);
		}
		return msInstitucionesIdproveeLista;
	}

	// public DtEncuestaBk getIdEncuesta(Long idTipoServicio, Long
	// fechaServicio, Long idServicio) throws Validador {
	// DtEncuesta encuesta = null;
	// Long idOrigen = 0L;
	// Long idPresta = 0L;
	// Long idTipoServicioAsistencia =
	// PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN;
	// Long idTipoServicioCapacitacion =
	// PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA;
	// Long idTipoServicioVisita =
	// PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA;
	// Long idTipoServicioConsulta =
	// PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA;
	//
	// if (idTipoServicio.longValue() == idTipoServicioAsistencia.longValue()) {
	// DtAsistencia dtAsistencia = dtAsistenciaDao.getDtAsistencia(idServicio);
	// if (dtAsistencia != null)
	// idOrigen = dtAsistencia.getIdOrigen();
	// } else if (idTipoServicio.longValue() ==
	// idTipoServicioCapacitacion.longValue()) {
	// DtCapacitacion dtCapacitacion =
	// dtCapacitacionDao.getDtCapacitacion(idServicio);
	// if (dtCapacitacion != null) {
	// idOrigen = dtCapacitacion.getIdOrigen();
	// idPresta = dtCapacitacion.getIdPrestacion();
	// }
	// } else if (idTipoServicio.longValue() ==
	// idTipoServicioVisita.longValue()) {
	// DtVisitas dtVisitas = dtVisitasDao.getDtVisitas(idServicio);
	// if (dtVisitas != null)
	// idOrigen = dtVisitas.getIdOrigen();
	// } else if (idTipoServicio.longValue() ==
	// idTipoServicioConsulta.longValue()) {
	// DtConsultas dtConsultas = dtConsultasDao.getDtConsultas(idServicio);
	// if (dtConsultas != null)
	// idOrigen = dtConsultas.getIdOrigen();
	// }
	//
	// List<DtEncuesta> lstEncuesta = dtEncuestaDao.getXFiltro(idTipoServicio,
	// null, null, null, null,
	// new Date(fechaServicio));
	// if (lstEncuesta != null && lstEncuesta.size() > 0) {
	//
	// for (DtEncuesta ent : lstEncuesta) {
	// if (ent.getIdEncuesta() != null) {
	// if (ent.getIdOrigen() != null && ent.getIdPrestacion() != null) {
	// if (idPresta != null && idOrigen != null &&
	// idOrigen.compareTo(ent.getIdOrigen()) == 0
	// && idPresta.compareTo(ent.getIdPrestacion()) == 0) {
	// encuesta = ent;
	// break;
	// }
	// } else if (ent.getIdOrigen() != null) {
	// if (idOrigen != null && idOrigen.compareTo(ent.getIdOrigen()) == 0) {
	// encuesta = ent;
	// }
	// } else if (ent.getIdPrestacion() != null) {
	// if (idPresta != null && idPresta.compareTo(ent.getIdPrestacion()) == 0) {
	// encuesta = ent;
	// }
	// }
	//
	// if (encuesta == null && (ent.getIdOrigen() == null ||
	// ent.getIdOrigen().intValue() == 0)
	// && (ent.getIdPrestacion() == null || ent.getIdPrestacion().intValue() ==
	// 0)) {
	// encuesta = ent;
	// }
	// }
	//
	// }
	//
	// }
	//
	// DtEncuestaBk encuestaBk = toBeanBk(encuesta, DtEncuestaBk.class);
	// if (encuestaBk == null) {
	//
	// PrtParametros prtParametros =
	// prtParametrosDao.getPrtParametros(idTipoServicio);
	// // PrtParametrosBk parametro = getParametro(idTipoServicio);
	// if (prtParametros == null)
	// return encuestaBk; // throw new Validador("No se encontró el
	// // tipo de servicio");
	// else
	// return encuestaBk; // throw new Validador("No se encontró
	// // encuesta de
	// // "+parametro.getDescripcion()+" para el
	// // "+FuncionesStaticas.toString(new
	// // Date(fechaServicio)));
	// } else {
	// return encuestaBk;
	// }
	// }

	// @SuppressWarnings({ "unchecked" })
	// public <T> T toBeanBk(Object objDomain, Class<T> classBk) throws
	// Validador {
	// if (objDomain == null)
	// return null;
	// try {
	// Object objBk = classBk.newInstance();
	// BeanUtils.copyProperties(objDomain, objBk);
	// PropertyDescriptor[] atributos =
	// Introspector.getBeanInfo(objDomain.getClass()).getPropertyDescriptors();
	// for (PropertyDescriptor atributo : atributos) {
	// try {
	//
	// if (!DtServicioBk.esCampoSinDescripcion(atributo.getName())) {
	// BeanWrapper bwDomain = new BeanWrapperImpl(objDomain);
	// BeanWrapper bwBk = new BeanWrapperImpl(objBk);
	// Long valorId =
	// Long.parseLong((bwDomain.getPropertyValue(atributo.getName()).toString()));
	// // if(atributo.getName().startsWith("tipo")) {
	// if (DtServicioBk.esCampoDePrtParametro(atributo.getName())) {
	// PrtParametros parametro = prtParametrosDao.getPrtParametros(valorId);
	// try {
	// String descripcionParametro = parametro.getDescripcion() != null
	// && parametro.getDescripcion().equalsIgnoreCase("Eliminado") ? "ANULADO"
	// : parametro.getDescripcion();
	// bwBk.setPropertyValue(atributo.getName() + "_txt", descripcionParametro);
	// } catch (NotWritablePropertyException nwpe) {
	// bwBk.setPropertyValue("descripcion" +
	// StringUtils.capitalize(atributo.getName()),
	// parametro.getDescripcion());
	// }
	// }
	// if (atributo.getName().equals("idUsuexterno")) {
	// DtUsuarioExterno usuarioExterno =
	// dtUsuarioExternoDao.getDtUsuarioExterno(valorId);
	// bwBk.setPropertyValue("dniUser", usuarioExterno.getNumDocu());
	// bwBk.setPropertyValue("idUsuexterno_txt",
	// FuncionesStaticas.defaultString(usuarioExterno.getNombre(), "") + " "
	// + FuncionesStaticas.defaultString(usuarioExterno.getAPaterno(), "") + " "
	// + FuncionesStaticas.defaultString(usuarioExterno.getAMaterno(), ""));
	// bwBk.setPropertyValue("correoUsuext", usuarioExterno.getCorreo());
	// bwBk.setPropertyValue("fijoUsuext", usuarioExterno.getOtroTelefono());
	// bwBk.setPropertyValue("celularUsuext", usuarioExterno.getOtroCelular());
	// }
	// if (atributo.getName().equals("idSede")) {
	// MsSedes sede = msSedesDao.getMsSedes(valorId);
	// try {
	// bwBk.setPropertyValue("idSede_txt", sede.getSede());
	// } catch (NotWritablePropertyException nwpe) {
	// bwBk.setPropertyValue("nombreSede", sede.getSede());
	// }
	// }
	// if (atributo.getName().contains("idSistAdm") ||
	// atributo.getName().contains("idSistAdmi")
	// || atributo.getName().contains("id_sist_admi")) {
	// MsSisAdmistrativo sistemaAdministrativo = msSisAdmistrativoDao
	// .getMsSisAdmistrativo(valorId);
	// try {
	// bwBk.setPropertyValue("nombreSistAdmi",
	// sistemaAdministrativo.getDescripcion());
	// } catch (NotWritablePropertyException nwpe) {
	// try {
	// bwBk.setPropertyValue("idSistAdm_txt",
	// sistemaAdministrativo.getDescripcion());
	// } catch (NotWritablePropertyException nwpe2) {
	// try {
	// bwBk.setPropertyValue("idSistAdmi_txt",
	// sistemaAdministrativo.getDescripcion());
	// } catch (NotWritablePropertyException nwpe3) {
	// bwBk.setPropertyValue("id_sist_admi_txt",
	// sistemaAdministrativo.getDescripcion());
	// }
	// }
	// }
	// }
	// if (atributo.getName().equals("idProyecto")) {
	// MsProyectoInversion proyecto =
	// msProyectoInversionDao.getMsProyectoInversion(valorId);
	// bwBk.setPropertyValue("codigo", proyecto.getCodigo());
	// bwBk.setPropertyValue("nombre", proyecto.getNombre());
	// }
	// if (atributo.getName().equals("idEntidad")) {
	// DtEntidades entidad = dtEntidadesDao.getDtEntidades(valorId);
	// bwBk.setPropertyValue("idEntidad_txt", entidad.getRazSocial());
	// try {
	// bwBk.setPropertyValue("codEjec", entidad.getCodEjec());
	// } catch (NotWritablePropertyException nwpe) {
	// bwBk.setPropertyValue("codEjecutora", entidad.getCodEjec());
	// }
	// bwBk.setPropertyValue("codEntidad_txt",
	// entidad.getCodEjec() + " " + entidad.getRazSocial());
	// }
	// if (atributo.getName().equals("idLocal")) {
	// MsLocal local = msLocalDao.getMsLocal(valorId);
	// bwBk.setPropertyValue("idLocal_txt", local.getDescripcion());
	// }
	// if (atributo.getName().equals("idTema") ||
	// atributo.getName().equals("id_tema")) {
	// MsTema tema = msTemaDao.getMsTema(valorId);
	// bwBk.setPropertyValue("idTema_txt", tema.getDescripcion());
	// }
	// bwDomain = null;
	// bwBk = null;
	// }
	// } catch (Exception e) {
	// // e.printStackTrace();
	// System.out
	// .println("WARNING: [toBeanBk] No se pudo obtener la descripción de " +
	// atributo.getName());
	// }
	// }
	// return (T) objBk;
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new Validador(e.getMessage());
	// }
	//
	// }

	@Override
	public List<DtUsuarioExternoBk> getDtUsuarioExternoXFiltro2(String nombre, Long kyUsuarioMod) {
		List<DtUsuarioExternoBk> dtUsuarioExternoBkss = new ArrayList<DtUsuarioExternoBk>();

		try {

			List<DtUsuarioExterno> dtUsuarioExternosss = dtUsuarioExternoDao.getXFiltroList(nombre);

			for (DtUsuarioExterno dtUsuarioExterno : dtUsuarioExternosss) {
				DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();
				FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);
				// completarDtUsuarioExterno(dtUsuarioExternoBk,kyUsuarioMod);
				setACLDtUsuarioExternoBk(dtUsuarioExternoBk, kyUsuarioMod);
				dtUsuarioExternoBkss.add(dtUsuarioExternoBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtUsuarioExternoBkss;
	}

	public DtAmpliacionFecha getautorizacionProgramacion2(Long idsede, Long idsisAdmin) {

		Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
				PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
		Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
				PropertiesMg.DEFOULT_IDSEDES_TODAS);
		int mes = FuncionesStaticas.getMonth();

		Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
				PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);

		DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada, idsede,
				idsisAdmin, mes);

		// ***********************************************************************************************************
		DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				idSedeTodas, idsisAdmin, mes);

		if (autorizacionProgramacion2 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion2;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion2;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				idsede, idSisAdmTodos, mes);
		if (autorizacionProgramacion3 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion3;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion3;
			}
		}

		DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
				idSedeTodas, idSisAdmTodos, mes);
		if (autorizacionProgramacion4 != null) {
			if (autorizacionProgramacion != null) {
				if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
					autorizacionProgramacion = autorizacionProgramacion4;
				}
			} else {
				autorizacionProgramacion = autorizacionProgramacion4;
			}
		}
		return autorizacionProgramacion;
	}

	// PURIBE 22042024 -FIN-->

	// INICIO CUSCATA - 18062024
	private List<DtAsistenciaUsuexternosBk> getAllDtAsistenciaUsuexternosByIdAsistencia(Long idAsistencia,
			Long kyUsuarioMod) {
		List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuexternosBkss = new ArrayList<DtAsistenciaUsuexternosBk>();
		try {
			List<DtAsistenciaUsuexternos> dtAsistenciaUsuexternoss = dtAsistenciaUsuexternosDao
					.getByIdAsistDtAsisteUsuariosExt(idAsistencia);
			for (DtAsistenciaUsuexternos dtAsistenciaUsuexternos : dtAsistenciaUsuexternoss) {
				DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = new DtAsistenciaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(dtAsistenciaUsuexternosBk, dtAsistenciaUsuexternos);
				completarDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk);
				setACLDtAsistenciaUsuexternosBk(dtAsistenciaUsuexternosBk, kyUsuarioMod);
				dtAsistenciaUsuexternosBkss.add(dtAsistenciaUsuexternosBk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtAsistenciaUsuexternosBkss;
	}
	// FIN CUSCATA - 18062024

	// CUSCATA - 18062024
	@Override
	public DtUsuarioExternoBk getUsuarioPorDNI(Long numDocum, Long kyUsuarioMod) {
		long startMethod = System.currentTimeMillis();

		DtUsuarioExternoBk dtUsuarioExternoBk = new DtUsuarioExternoBk();

		DtUsuarioExterno dtUsuarioExterno = null;
		List<DtUsuarioExterno> listaUsuarioExterno = dtUsuarioExternoDao.getXFiltro(null, null, null, numDocum, null,
				null, null, null, null);

		if (listaUsuarioExterno != null && !listaUsuarioExterno.isEmpty()) {
			dtUsuarioExterno = listaUsuarioExterno.iterator().next();
			FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoBk, dtUsuarioExterno);

			List<DtEntidadesUsuexternos> dtEntidadesUsuexternosList = dtEntidadesUsuexternosDao
					.getXFiltroidUsuexterno(dtUsuarioExterno.getIdUsuexterno());
			if (dtEntidadesUsuexternosList != null && !dtEntidadesUsuexternosList.isEmpty()) {
				DtEntidadesUsuexternos dtEntidadesUsuexternos = dtEntidadesUsuexternosList.iterator().next();

				List<DtCargosUsuexterBk> dtCargosUsuexterList = this
						.getDtCargosUsuexterXFiltro(dtEntidadesUsuexternos.getIdUsuextEnti(), null, kyUsuarioMod);
				if (dtCargosUsuexterList != null && !dtCargosUsuexterList.isEmpty()) {
					dtUsuarioExternoBk.setUsucargos(dtCargosUsuexterList);
					dtUsuarioExternoBk.setIdEntidad(dtEntidadesUsuexternos.getIdEntidad());
				}

			}

		}

		long finalMethod = System.currentTimeMillis() - startMethod;
		log.log(Level.INFO, "finalMethod getUsuarioPorDNI:: " + finalMethod);

		return dtUsuarioExternoBk;
	}
	
	@Override
	public DtUsuarioExternoBk getUsuarioCapacitacionPorDNI(Long numDocum, Long kyUsuarioMod) {
		DtUsuarioExternoBk dtUsuarioExternoBk = this.getUsuarioPorDNI(numDocum, kyUsuarioMod);
		DtEntidades dtEntidades = dtEntidadesDao.getDtEntidades(dtUsuarioExternoBk.getIdEntidad());
		if (dtEntidades != null) {
			dtUsuarioExternoBk.setIdEntidad(dtEntidades.getIdEntidad());
			dtUsuarioExternoBk.setIdEntidadTxt(dtEntidades.getRazSocial());
			dtUsuarioExternoBk.setCodEjecutora(dtEntidades.getCodEjec());
		}
		return dtUsuarioExternoBk;
	}

	// @Override
	// public List<DtUsuarioExternoBk>
	// getMsUsuariosExternoBkXnombreapellido(String nombreapellido) throws
	// Validador {
	// if (nombreapellido == null){
	// return null;
	// }
	// List<DtUsuarioExternoBk> dtusuarioExternoBkList = new ArrayList<>();
	//
	// if(nombreapellido==null || nombreapellido.length()<3){
	// return dtusuarioExternoBkList;
	// }
	//
	// String[] terms = nombreapellido.split(" ");
	// List<DtUsuarioExterno> usuarios =
	// dtUsuarioExternoDao.getDtUsuarioExtByNombreapellido(terms);
	// for (DtUsuarioExterno usuario : usuarios) {
	// DtUsuarioExternoBk usuariobk = new DtUsuarioExternoBk();
	// usuariobk.setIdUsuexterno(usuario.getIdUsuexterno());
	// usuariobk.setApaterno(usuario.getApaterno());
	// usuariobk.setAmaterno(usuario.getAmaterno());
	// usuariobk.setNombre(usuario.getNombre());
	// usuariobk.setNombresCompletos(usuario.getApaterno()+"
	// "+usuario.getAmaterno()+" "+usuario.getNombre() );
	// usuariobk.setCorreo(usuario.getCorreo());
	// usuariobk.setOtroTelefono(usuario.getOtroTelefono());
	// usuariobk.setOtroCelular(usuario.getOtroCelular());
	// usuariobk.setNumDocum(usuario.getNumDocum());
	// dtusuarioExternoBkList.add(usuariobk);
	// }
	// return dtusuarioExternoBkList;
	// }

	// FIN CUSCATA - 18062024

	// JPUYEN 14052024 - INICIO
	@Override
	public DtVisitasUsuexternosBk getDtVisitasUsuexternoBkXid(Long id, Long kyUsuarioMod) {
		if (id == null)
			return null;
		DtVisitasUsuinternos dtVisitasUsuinternos = dtVisitasUsuinternosDao.getDtVisitasUsuinternos(id);
		DtVisitasUsuexternosBk dtVisitasUsuexternosBk = null;
		if (dtVisitasUsuinternos != null) {
			dtVisitasUsuexternosBk = new DtVisitasUsuexternosBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasUsuexternosBk, dtVisitasUsuinternos);
			// completarDtVisitasUsuinternos(dtVisitasUsuexternosBk);
			if (kyUsuarioMod != null) {
				setACLDtVisitasUsuexternosBk(dtVisitasUsuexternosBk, kyUsuarioMod);
			}
		}
		return dtVisitasUsuexternosBk;
	}
	// JPUYEN 14052024 - FIN

	// JPUYEN 14052024 - INICIO
	@Override
	public DtUsuarioExternoBk getMsUsuariosExternoBkXDni(String dni) throws Validador {

		if (dni == null) {
			return null;
		}
		List<DtUsuarioExterno> msUsuariosExterno = dtUsuarioExternoDao.getDtUsuarioExtByDni(dni);

		if (!msUsuariosExterno.isEmpty()) {
			if (msUsuariosExterno.size() > 1) {
				log.info("ERROR EXISTE MÁS DE UNA PERSONA CON EL DNI " + dni);
				throw new Validador("SE ENCONTRÓ MAS DE UNA PERSONA CON EL DNI INGRESADO");

			} else if (msUsuariosExterno.size() > 1) {
				throw new Validador("EL DNI INGRESADO NO SE ENCUENTRA REGISTRADO, POR FAVOR COMPLETE LOS DATOS");
			}

		}

		DtUsuarioExternoBk usuariobk = new DtUsuarioExternoBk();

		for (DtUsuarioExterno usuario : msUsuariosExterno) {
			// FuncionesStaticas.copyPropertiesObject(usuariobk, usuario);
			usuariobk.setIdUsuexterno(usuario.getIdUsuexterno());
			usuariobk.setApaterno(usuario.getApaterno());
			usuariobk.setAmaterno(usuario.getAmaterno());
			usuariobk.setNombre(usuario.getNombre());
			usuariobk.setNombresCompletos(
					usuario.getApaterno() + " " + usuario.getAmaterno() + " " + usuario.getNombre());
			usuariobk.setCorreo(usuario.getCorreo());
			usuariobk.setOtroTelefono(usuario.getOtroTelefono());
			usuariobk.setOtroCelular(usuario.getOtroCelular());
			usuariobk.setNumDocum(usuario.getNumDocum());

			completarDtUsuarioExterno(usuariobk);
		}
		return usuariobk;

	}

	@Override
	public List<DtUsuarioExternoBk> getMsUsuariosExternoBkXnombreapellido(String nombreapellido) throws Validador {
		if (nombreapellido == null) {
			return null;
		}
		List<DtUsuarioExternoBk> dtusuarioExternoBkList = new ArrayList<>();

		if (nombreapellido == null || nombreapellido.length() < 3) {
			return dtusuarioExternoBkList;
		}

		String[] terms = nombreapellido.split(" ");

		List<DtUsuarioExterno> usuarios = dtUsuarioExternoDao.getDtUsuarioExtByNombreapellido(terms);
		for (DtUsuarioExterno usuario : usuarios) {
			DtUsuarioExternoBk usuariobk = new DtUsuarioExternoBk();
			// FuncionesStaticas.copyPropertiesObject(usuariobk, usuario);
			usuariobk.setIdUsuexterno(usuario.getIdUsuexterno());
			usuariobk.setApaterno(usuario.getApaterno());
			usuariobk.setAmaterno(usuario.getAmaterno());
			usuariobk.setNombre(usuario.getNombre());
			usuariobk.setNombresCompletos(
					usuario.getApaterno() + " " + usuario.getAmaterno() + " " + usuario.getNombre());
			usuariobk.setCorreo(usuario.getCorreo());
			usuariobk.setOtroTelefono(usuario.getOtroTelefono());
			usuariobk.setOtroCelular(usuario.getOtroCelular());
			usuariobk.setNumDocum(usuario.getNumDocum());
			dtusuarioExternoBkList.add(usuariobk);
		}
		return dtusuarioExternoBkList;

	}

	// JPUYEN 14052024 - FIN

	// JPUYEN 14052024 - INICIO
	@Override
	public List<MsUsuariosDto> getMsUsuariosFilter(Long idSede) {

		// if (msUsuariosListaCache == null) {

		List<MsUsuarios> msUsuariossss = new ArrayList<>();

		if (idSede != null && idSede.intValue() > 0) {
			msUsuariossss = msUsuariosDao.getActivasMsUsuariosFilterXsede(idSede);
		} else {
			msUsuariossss = msUsuariosDao.getActivasMsUsuarios();
		}

		msUsuariosListaCache = new ArrayList<MsUsuariosDto>();
		for (MsUsuarios msUsuarios : msUsuariossss) {
			MsUsuariosDto msUsuariosDto = new MsUsuariosDto();
			FuncionesStaticas.copyPropertiesObject(msUsuariosDto, msUsuarios);
			String Nombrecompleto = FuncionesStaticas.getNombreCompleto(msUsuarios);
			msUsuariosDto.setIdUsuinternoTxt(Nombrecompleto);

			try {
				if (msUsuariosDto.getIdusuario() != null && msUsuariosDto.getIdusuario().longValue() > 0) {
					MsSisAdmistrativo msSisAdmistrativo = msSisAdmistrativoDao
							.getMsSisAdmistrativo(msUsuariosDto.getIdSistAdmi());
					if (msSisAdmistrativo != null)
						msUsuariosDto.setIdSistAdmiTxt(msSisAdmistrativo.getDescripcion());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			msUsuariosListaCache.add(msUsuariosDto);

		}
		// }
		return msUsuariosListaCache;
	}
	// JPUYEN 14052024 - FIN


	@Override
	public void deleteDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, String user,
			Long kyUsuarioMod, Long kyAreaMod, String rmtaddress) throws Validador {
		try {
			DtAsistenciaUsuexternos dtAsistenciaUsuexternos = null;
			if (dtAsistenciaUsuexternosBk.getIdAsistUsuext() != null
					&& dtAsistenciaUsuexternosBk.getIdAsistUsuext().longValue() > 0) {

				dtAsistenciaUsuexternos = dtAsistenciaUsuexternosDao
						.getDtAsistenciaUsuexternos(dtAsistenciaUsuexternosBk.getIdAsistUsuext());

				Timestamp hoy = new Timestamp(System.currentTimeMillis());

				dtAsistenciaUsuexternos.setRtmaddressrst(rmtaddress);
				dtAsistenciaUsuexternos.setIdusserModif(kyUsuarioMod);
				dtAsistenciaUsuexternos.setFechaModif(hoy);
				Long estadoanterior = dtAsistenciaUsuexternos.getEstado();
				dtAsistenciaUsuexternos.setEstado(Estado.ELIMINADO.getValor());

				dtAsistenciaUsuexternosDao.updateDtAsistenciaUsuexternos(dtAsistenciaUsuexternos);

				log.log(Level.INFO,
						"CAMBIO :: " + kyUsuarioMod + " :: " + user + " :: " + rmtaddress + " :: "
								+ "ELIMINADO dtAsistenciaUsuexternos" + " :: "
								+ dtAsistenciaUsuexternos.getIdAsistUsuext().toString() + " :: " + estadoanterior
								+ " :: " + "0");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
	}
	
	@Override
	public DtVisitasBk finalizarDtVisitasBk(
			DtVisitasBk dtVisitasBk,	
			List<DtAnexoBk> dtAnexosBkss,// JPUYEN 17062024 - NUEVO PARAMETRO
			String user,
			Long kyUsuarioMod, 
			Long kyAreaMod, 
			String rmtaddress		
			) throws Validador{
		
		//PURIBE 14032024 -INICIO-->
		
				Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
						PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
				Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
						PropertiesMg.DEFOULT_IDSEDES_TODAS);

				
				Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);
				DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
						dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), FuncionesStaticas.getMonth());

				// ***********************************************************************************************************
				DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada, dtVisitasBk.getIdSede(),
						dtVisitasBk.getIdSistAdm(), FuncionesStaticas.getMonth());
				
				if (autorizacionProgramacion2 != null) {
					if (autorizacionProgramacion != null) {
						if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
							autorizacionProgramacion = autorizacionProgramacion2;
						}
					} else {
						autorizacionProgramacion = autorizacionProgramacion2;
					}
				}

				DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
						dtVisitasBk.getIdSede(), idSisAdmTodos, FuncionesStaticas.getMonth());
				if (autorizacionProgramacion3 != null) {
					if (autorizacionProgramacion != null) {
						if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
							autorizacionProgramacion = autorizacionProgramacion3;
						}
					} else {
						autorizacionProgramacion = autorizacionProgramacion3;
					}
				}

				DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada, idSedeTodas,
						idSisAdmTodos, FuncionesStaticas.getMonth());
				if (autorizacionProgramacion4 != null) {
					if (autorizacionProgramacion != null) {
						if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
							autorizacionProgramacion = autorizacionProgramacion4;
						}
					} else {
						autorizacionProgramacion = autorizacionProgramacion4;
					}
				}

			
				Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);
				// Integer mesServicio=dtVisitasBk.getFechaVisita().getMonth()+1;
				// SPRINT_4.1 INICIO

				Integer mesServicio = dtVisitasBk.getFechaVisita().getMonth() + 1;

				
			
				if (mesServicio.intValue() == 12) {
					mesServicio = 0;
				}
				DtAmpliacionFecha autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion,
						dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm(), mesServicio + 1);// Ahora
																								// Mes
																								// Actual,
																								// por
																								// confirmar

				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion, idSedeTodas,
							dtVisitasBk.getIdSistAdm(), mesServicio + 1);// Ahora Mes
																			// Actual,
																			// por
																			// confirmar
					if (autorizacionEjecucion == null) {
						autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion, dtVisitasBk.getIdSede(),
								idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual, por
																// confirmar
						if (autorizacionEjecucion == null) {
							autorizacionEjecucion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteEjecucion, idSedeTodas,
									idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual,
																	// por confirmar
						}
					}
				}

				
				DtVisitas dtVisitasOrig = null;
				if (dtVisitasBk.getIdVisita() != null && dtVisitasBk.getIdVisita().longValue() > 0) {
					dtVisitasOrig = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());
				}
				//PURIBE 14032024 -FIN-->

				//PURIBE 14032024 -INICIO-->
				ValidacionDtVisitasMng.validarDtVisitasBk(dtVisitasBk,autorizacionProgramacion,autorizacionEjecucion,msRolesDao.isRolAdministradorOGC(kyUsuarioMod),dtVisitasOrig);
				//PURIBE 14032024 -FIN-->
				ValidacionDtVisitasMng.validarAnexos(dtAnexosBkss);// JPUYEN 17062024 - SE AGREGA VALIDADOR DE ARCHIVOS

		DtVisitas dtVisitas = null;
		Timestamp hoy = new Timestamp(System.currentTimeMillis());

		int nivel=1;

		try {
			if(dtVisitasBk.getIdVisita()!=null && dtVisitasBk.getIdVisita().longValue()>0){

				dtVisitas = dtVisitasDao.getDtVisitas(dtVisitasBk.getIdVisita());

				boolean cambios = AuditoriaDtVisitasMng.auditarCambiosDtVisitas(dtVisitasBk,dtVisitas, kyUsuarioMod, user, rmtaddress, nivel);

				if(cambios){	
					dtVisitas.setRtmaddressrst(rmtaddress);
					dtVisitas.setIdusserModif(kyUsuarioMod);
					dtVisitas.setFechaModif(hoy);		
					dtVisitasDao.updateDtVisitas(dtVisitas);				
				}			
			}else{
				dtVisitasBk.setRtmaddress(rmtaddress);
				dtVisitasBk.setRtmaddressrst(rmtaddress);

				dtVisitasBk.setFechaCrea(hoy);				
				dtVisitasBk.setIdusserCrea(kyUsuarioMod);				
				dtVisitasBk.setIdusserModif(kyUsuarioMod);
				dtVisitasBk.setFechaModif(hoy);
				dtVisitasBk.setEstado(Estado.ACTIVO.getValor());		

				dtVisitas = new DtVisitas();

				FuncionesStaticas.copyPropertiesObject(dtVisitas,dtVisitasBk);
				dtVisitasDao.saveDtVisitas(dtVisitas);

				log.log(Level.INFO,"CAMBIO :: "+kyUsuarioMod+" :: "+ user + " :: "+ rmtaddress+" :: "+"CREADO dtVisitas"+" :: "+dtVisitas.getIdVisita().toString()+" :: "+ "0" + " :: "+ "1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Validador(e.getMessage());
		}
		
		
		
		cargarAnexos(dtAnexosBkss, dtVisitas.getIdVisita(), user, kyUsuarioMod, kyAreaMod, rmtaddress);
		

		dtVisitasBk = getDtVisitasBkXid(dtVisitas.getIdVisita(),kyUsuarioMod);			
		return dtVisitasBk;		
	}
	
	// JPUYEN 17062024 - INICIO
		private void cargarAnexos(List<DtAnexoBk> tdAnexosBkss, Long iddocumento, String user, Long kyUsuarioMod,
				Long kyAreaMod, String rmtaddress) throws Validador {

			Long idTiposervicio = PropertiesMg
					.getSistemLong(
							PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA,
							PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA);
			
			List<DtAnexoBk> TdAnexosBksssActuales = getDtAnexoXFiltro(null, null, idTiposervicio, null, iddocumento,kyUsuarioMod);

			if (tdAnexosBkss != null && !tdAnexosBkss.isEmpty()) {
				for (DtAnexoBk tdAnexosBkAct : TdAnexosBksssActuales) {
					if (!tdAnexosBkss.contains(tdAnexosBkAct)) {
						deleteDtAnexo(tdAnexosBkAct, user, kyUsuarioMod, kyAreaMod, rmtaddress);
					}
				}
				for (DtAnexoBk tdAnexosBk : tdAnexosBkss) {
					if (tdAnexosBk.getIdmaestro() == null || tdAnexosBk.getIdmaestro().longValue() <= 0) {
						tdAnexosBk.setIdmaestro(iddocumento);
						tdAnexosBk.setIdTiposervicio(idTiposervicio);
						
						tdAnexosBk = this.saveorupdateDtAnexoBk(tdAnexosBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
						if (tdAnexosBk.getFilename() != null) {
							if (tdAnexosBk.getFilename().startsWith("TEMP")) {
								File file_tdAnexosBk = FuncionesStaticas
										.getFileSistemaCompletoSearch(tdAnexosBk.getFilename(), tdAnexosBk.getFechaCrea());
								if (file_tdAnexosBk != null && file_tdAnexosBk.exists()) {
									String nuevonombre = FuncionesStaticas.getFileNameSistemaVisita(iddocumento,
											tdAnexosBk.getIdusserCrea(), tdAnexosBk.getFilenameoriginal());
									String nuevaruta = FuncionesStaticas.getFileNameRutaSistema(nuevonombre);
									if (FuncionesStaticas.moveTo(file_tdAnexosBk, nuevaruta)) {
										tdAnexosBk.setFilename(nuevonombre);
										tdAnexosBk = this.saveorupdateDtAnexoBk(tdAnexosBk, user, kyUsuarioMod, kyAreaMod,rmtaddress);
									} else {
										log.info("NO SE PUDO MOVER EL ARCHIVO DE: " + file_tdAnexosBk.getAbsolutePath()
												+ " A " + nuevaruta);
									}
								} else {
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm");
									log.info("ARCHIVO NO ENCONTRADO: " + tdAnexosBk.getFilename() + " en " + sdf);
								}
							}
						}
					} else {
						this.saveorupdateDtAnexoBk(tdAnexosBk, user, kyUsuarioMod, kyAreaMod, rmtaddress);
					}
				}
			} else {
				for (DtAnexoBk tdAnexosBkAct : TdAnexosBksssActuales) {
					deleteDtAnexo(tdAnexosBkAct, user, kyUsuarioMod, kyAreaMod, rmtaddress);
				}
			}
		}
		
		public DtEncuestaBk getIdEncuesta(Long idTipoServicio, Long fechaServicio) throws Validador {
			// System.out.println("RegistramefServiceImp.getIdEncuesta("+idTipoServicio+",
			// "+FuncionesStaticas.toString(new Date(fechaServicio))+")"); 
			DtEncuesta encuesta = dtEncuestaDao.findPeriodo(idTipoServicio, new Date(fechaServicio));
			DtEncuestaBk encuestaBk = toBeanBk(encuesta, DtEncuestaBk.class);
			if (encuestaBk == null) {
				PrtParametrosBk parametro = getParametro(idTipoServicio);
				if (parametro == null)
					return encuestaBk; // throw new Validador("No se encontró el
										// tipo de servicio");
				else
					return encuestaBk; // throw new Validador("No se encontró
										// encuesta de
										// "+parametro.getDescripcion()+" para el
										// "+FuncionesStaticas.toString(new
										// Date(fechaServicio)));
			} else {
				return encuestaBk;
			}
		}

		@Override
		public List<DtCapaUsuexternosBk> getDtCapaUsuarioExtByIdDCapa(Long idCapacitacion) {
			List<DtCapaUsuexternosBk> msObjectBks = new ArrayList<DtCapaUsuexternosBk>();
			try {
				List<DtCapaUsuexternos> msObjectDom = dtCapaUsuexternosDao.getByIdCapacDtCapaUsuariosExt(idCapacitacion);
				for (DtCapaUsuexternos msObject : msObjectDom) {
					DtCapaUsuexternosBk oObjectBk = new DtCapaUsuexternosBk();
					FuncionesStaticas.copyPropertiesObject(oObjectBk, msObject);
					completarDtCapaUsuexternos(oObjectBk);
					msObjectBks.add(oObjectBk);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return msObjectBks;
		}
		
		public DtCapacitacionBk getDtCapacitacionBkXid(Long id) {
			if (id == null)
				return null;
			DtCapacitacion dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(id);
			DtCapacitacionBk dtCapacitacionBk = null;
			if (dtCapacitacion != null) {
				dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
				completarDtCapacitacion(dtCapacitacionBk);
			}
			return dtCapacitacionBk;
		}
		
		public void deleteDtEntidadUsuarioExterno(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk) throws Validador {
			try {
				DtEntidadesUsuexternos msObject = null;
				if (dtEntidadesUsuexternosBk.getIdUsuexterno() != null
						&& dtEntidadesUsuexternosBk.getIdUsuexterno().longValue() > 0) {

					msObject = dtEntidadesUsuexternosDao
							.getDtEntidadesUsuexternos(dtEntidadesUsuexternosBk.getIdUsuextEnti());

					// Date hoy = new Date(System.currentTimeMillis());
					Timestamp hoy = new Timestamp(System.currentTimeMillis());

					msObject.setFechaModif(hoy);
					msObject.setEstado(dtEntidadesUsuexternosDao.getEstadoEliminado());
					Long estadoanterior = msObject.getEstado();

					dtEntidadesUsuexternosDao.updateDtEntidadesUsuexternos(msObject);

					log.log(Level.INFO,
							"CAMBIO :: " + msObject.getIdusserModif() + " :: " + " :: " + msObject.getRtmaddress() + " :: "
									+ "ELIMINADO DtEntidadSede" + " :: " + msObject.getIdUsuextEnti().toString() + " :: "
									+ estadoanterior + " :: " + "0");
				}
			} catch (Exception e) {
				log.info(e.getMessage());
				throw new Validador(e.getMessage());
			}

		}
		
		private List<DtCargosUsuexterBk> getDtCargosUsuexterBks(Long idEntidadUsuext) {
			List<DtCargosUsuexterBk> msObjectBks = new ArrayList<DtCargosUsuexterBk>();
			try {
				List<DtCargosUsuexter> dtCargosUsuexterList = dtCargosUsuexterDao.getByIdDtCargosUsuexter(idEntidadUsuext);
				for (DtCargosUsuexter msObject : dtCargosUsuexterList) {
					DtCargosUsuexterBk oObjectBk = new DtCargosUsuexterBk();
					FuncionesStaticas.copyPropertiesObject(oObjectBk, msObject);
					// completarMsPaises(oObjectBk);
					msObjectBks.add(oObjectBk);
				}
			} catch (Exception e) {
				log.info(e.getMessage());
			}
			return msObjectBks;
		}
		
		public void enviarNotificacionConfirmacionPorCorreo(final List<DtCapaUsuexternosBk> participantes,
				final DtCapacitacionBk dtCapacitacionBk, final String url) throws Validador { // VBALDEONH

			Thread myThread = new Thread() {
				public void run() {
					try {
						List<String> recipients = new ArrayList<String>();
						DtUsuarioExterno usuarioExterno;
						String nombre = "";
						// VBALDEONH SPRINT5 INICIO
						for (DtCapaUsuexternosBk participante : participantes) {
							recipients = new ArrayList<String>();
							recipients.add(participante.getCorreoUsuext());
							usuarioExterno = dtUsuarioExternoDao.getDtUsuarioExterno(participante.getIdUsuexterno());
							if (usuarioExterno != null)
								nombre = StringUtils.capitalize(usuarioExterno.getNombre().toLowerCase()) + " "
										+ StringUtils.capitalize(usuarioExterno.getApaterno().toLowerCase()) + " "
										+ StringUtils.capitalize(usuarioExterno.getAmaterno().toLowerCase());

							// SPRINT11 INICIO
							StringBuilder msg = new StringBuilder();
							msg.append("<table align='center' width='100%'>");
							msg.append("<tr><td width='50%' align='left'><img src='" + url + "/images/u2.png'></td>");
							msg.append("<td width='50%' align='right'><img src='" + url + "/images/u0.png'></td></tr>");
							msg.append("</table>");
							msg.append(
									"<div style='padding:11px;line-height:50px;background:#FFFFFF;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-ms-border-radius:5px; width:100%'>");
							msg.append(
									"<div align='center' valign='middle' height='33px' style='background:#FFFFFF !important; line-height:28px;align:center !important;valign:middle;background:#C8000E;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-ms-border-radius:5px; width:100%' ><h1><b style='color:white;'>Estimado(a), "
											+ nombre + "</b></h1></div>"); 

							Long idVirtual = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_VIRTUAL,
									PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL);

							msg.append(
									"<div valign='middle' height='28px' style='background:#FFFFFF !important; line-height:28px;font-size:20px;'>Un gusto saludarte. A través de este correo, confirmamos tu inscripción a la capacitación \"<b style='font-size:20px;'>"
											+ (dtCapacitacionBk.getNomEvento() == null ? " "
													: dtCapacitacionBk.getNomEvento().trim().toUpperCase())
											+ "\"</b> programada para el "
											+ (dtCapacitacionBk.getFechaInic() == null ? " "
													: FuncionesStaticas.getfechaLargaFormateadaConEstilo(
															dtCapacitacionBk.getFechaInic()))); 

							if (dtCapacitacionBk.getIdModalidad() != null
									&& dtCapacitacionBk.getIdModalidad().longValue() == idVirtual.longValue()) {
								msg.append("</div>");
								msg.append(
										"<br/><div valign='middle' height='28px' style='background:#FFFFFF !important; line-height:28px;font-size:20px;'>Recuerda unirte a la videollamada, ingresando al siguiente enlace en la fecha y hora antes indicada: ");// SPRINT_3
								msg.append("<a style='text-decoration:none;' target='_blank' href='"
										+ dtCapacitacionBk.getDetalleCapaVirtual() + "'><font color='blue'><b>"
										+ dtCapacitacionBk.getDetalleCapaVirtual() + "</b></font></a> </div>");
							} else {
								msg.append(" En " + dtCapacitacionBk.getIdLocalTxt() + ".</div>");
							}
							msg.append(
									"<div valign='middle' height='28px' style='background:#FFFFFF !important; line-height:28px;font-size:20px;'> <br/>  Si tienes alguna consulta, puedes comunicarte con nuestro equipo a través de los datos de contacto que se encuentran en el siguiente directorio virtual: ");
							msg.append(
									"<a style='text-decoration:none;' target='_blank' href='http://bit.ly/directorioconectamef'><font color='blue'><b>http://bit.ly/directorioconectamef</b></font></a> </div>");// SPRINT17
							msg.append(
									"<br/><div valign='middle' height='28px' style='background:#FFFFFF !important; line-height:28px; font-size:19px;'>¡Contamos con tu participación!</div>");// SPRINT19
							msg.append(
									"<div valign='middle' height='50px' style='background:#FFFFFF !important; line-height:50px;font-size:19px;'><p  style='color: red; font-weight:bold'>Equipo CONECTAMEF</p></div>");// SPRINT19
							msg.append("</div>");

							EmailUtil email = new EmailUtil();
							email.sendEmail(recipients, null, null,
									"CONFIRMACIÓN DE INSCRIPCIÓN DE CAPACITACIÓN ─ REGISTRAMEF  ", msg.toString());

						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			myThread.start();

		}

		@Override
		public DtCapacitacionBk confirmardtCapacitacionNoProg(DtCapacitacionBk dtCapacitacionBk, 
																String user,
																Long kyUsuarioMod, 
																Long kyAreaMod, 
																String rmtaddress) throws Validador {
			
			
			List<DtCapaUsuexternosBk> dtCapaUsuexternosBksss =	dtCapacitacionBk.getDtCapacitacionUsuariosBkJSss();
			
			if (dtCapaUsuexternosBksss != null && dtCapaUsuexternosBksss.size() > 0) {
				
				List<DtCapaUsuexternosBk> participantes= new ArrayList<DtCapaUsuexternosBk>();
				dtCapacitacionBk= this.getDtCapacitacionBkXid(dtCapaUsuexternosBksss.get(0).getIdCapacitacion());
				
				if(dtCapacitacionBk.getEstado()!=null && dtCapacitacionBk.getEstado().longValue()==PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO).longValue()) {
					throw new Validador(MessageFormat.format("CAPACITACION",
							Messages.getStringToKey("registro.participante.externo.error.servicio.finalizado")));
    			}    
				
				try{        				
					for (DtCapaUsuexternosBk dtCapaUsuexternosBk : dtCapaUsuexternosBksss) {
						System.out.println(dtCapaUsuexternosBk.getIdCargoUsuext()+"idcapauserext");
						if(dtCapaUsuexternosBk.getFlagMedioreg()!=null && dtCapaUsuexternosBk.getFlagMedioreg().intValue()==2){
							
							dtCapaUsuexternosBk.setFlagConfirReg(Long.valueOf(PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_CONFIRMAR_REGISTRO_SI, PropertiesMg.DEFAULT_PRTPARAMETROS_CONFIRMAR_REGISTRO_SI)));
		        			dtCapaUsuexternosBk.setFechaFlagConfirReg(new Timestamp(System.currentTimeMillis()));
		        			
		        			this.saveorupdateDtCapaUsuexternosBk(dtCapaUsuexternosBk,
										        					user,
										        					kyUsuarioMod, 
										        					kyAreaMod, 
										        					rmtaddress);	
		        			
							participantes.add(dtCapaUsuexternosBk);
							
							//ACTUALIZAR PERSONA
							if(dtCapaUsuexternosBk.getIdUsuexterno()!=null && dtCapaUsuexternosBk.getIdUsuexterno().longValue()>0){
								
								DtUsuarioExternoBk userOrig = this.getDtUsuarioExternoBkXid(dtCapaUsuexternosBk.getIdUsuexterno());
								
								if(userOrig!=null){
									
									userOrig.setCorreo(dtCapaUsuexternosBk.getCorreoUsuext());
									userOrig.setOtroCelular(dtCapaUsuexternosBk.getCelularUsuext());
									userOrig.setOtroTelefono(dtCapaUsuexternosBk.getFijoUsuext());
									this.saveorupdateDtUsuarioExternoBk(userOrig, user, kyUsuarioMod, kyAreaMod, rmtaddress);
								
								}
								//ACTUALIZAR ENTIDAD}
								if(dtCapaUsuexternosBk.getIdEntidad()!=null && dtCapaUsuexternosBk.getIdEntidad().longValue()>0){
									
									DtEntidadesUsuexternosBk entidadUsuorig=new DtEntidadesUsuexternosBk();
									List<DtEntidadesUsuexternosBk> entidadOrig=this.getDtEntidadUsuarioByUser(userOrig.getIdUsuexterno());
									
									if(entidadOrig!=null && entidadOrig.size()>0){
										//VERIFICAMOS SI EXISTE ENTIDAD IGUAL
										boolean existentidad=false;
										for(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBka : entidadOrig){
											if(dtEntidadesUsuexternosBka.getIdEntidad().longValue()==dtCapaUsuexternosBk.getIdEntidad().longValue()){
												existentidad=true;
												entidadUsuorig=dtEntidadesUsuexternosBka;
												break;
											}
										}
										if(existentidad==false){
											//SE DESACTIVAN TODAS 
											for(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBka : entidadOrig){
												DtEntidadesUsuexternosBk obj=dtEntidadesUsuexternosBka;
												this.deleteDtEntidadUsuarioExterno(obj);
											}
											//SE CREA LA NUEVA
											DtEntidadesUsuexternosBk dtEntidadesUsuexternosBka=new DtEntidadesUsuexternosBk();
											dtEntidadesUsuexternosBka.setIdEntidad(dtCapaUsuexternosBk.getIdEntidad());
											dtEntidadesUsuexternosBka.setIdUsuexterno(dtCapaUsuexternosBk.getIdUsuexterno());
											entidadUsuorig=this.saveOrUpdateDtEntidadUsuario(dtEntidadesUsuexternosBka, rmtaddress, kyAreaMod);
										}
									}else{
										DtEntidadesUsuexternosBk dtEntidadesUsuexternosBka=new DtEntidadesUsuexternosBk();
										dtEntidadesUsuexternosBka.setIdEntidad(dtCapaUsuexternosBk.getIdEntidad());
										dtEntidadesUsuexternosBka.setIdUsuexterno(dtCapaUsuexternosBk.getIdUsuexterno());
										entidadUsuorig=this.saveOrUpdateDtEntidadUsuario(dtEntidadesUsuexternosBka, rmtaddress, kyAreaMod);
									}
									
									//ACTUALIZAR CARGOS
									if(dtCapaUsuexternosBk.getIdCargoUsuext()!=null && dtCapaUsuexternosBk.getIdCargoUsuext().longValue()>0){
										List<DtCargosUsuexterBk> cargodOrig=this.getDtCargosUsuexterBks(entidadUsuorig.getIdUsuextEnti());
										if(cargodOrig!=null && cargodOrig.size()>0){
											//VERIFICAMOS SI EXISTE ENTIDAD IGUAL
											boolean existeCargo=false;
											for(DtCargosUsuexterBk DtCargosUsuexterBka : cargodOrig){
												if(DtCargosUsuexterBka.getIdCargo()!=null && DtCargosUsuexterBka.getIdCargo().longValue()==dtCapaUsuexternosBk.getIdCargoUsuext().longValue()){//SPRINT39
													existeCargo=true;
													break;
												}
											}
											if(existeCargo==false){
												DtCargosUsuexterBk dtCargosUsuexterBka=new DtCargosUsuexterBk();
												dtCargosUsuexterBka.setIdUsuextEnti(entidadUsuorig.getIdUsuextEnti());
												dtCargosUsuexterBka.setIdCargo(dtCapaUsuexternosBk.getIdCargoUsuext());
												
												this.saveorupdateDtCargosUsuexterBk(dtCargosUsuexterBka, user, 
																					kyUsuarioMod, kyAreaMod,  rmtaddress);
											}
										}else{
											DtCargosUsuexterBk dtCargosUsuexterBka=new DtCargosUsuexterBk();
											dtCargosUsuexterBka.setIdUsuextEnti(entidadUsuorig.getIdUsuextEnti());
											dtCargosUsuexterBka.setIdCargo(dtCapaUsuexternosBk.getIdCargoUsuext());
											this.saveorupdateDtCargosUsuexterBk(dtCargosUsuexterBka, user, 
																				kyUsuarioMod, kyAreaMod,  rmtaddress);
										}
									}
								}

								
							}

							
						} else{
							log.info("EL PARTICIPANTE "+dtCapaUsuexternosBk.getNombre()+", CON DNI "+dtCapaUsuexternosBk.getNumDocu()+" NO HA SIDO INSCRITO VIRTUALMENTE");
						}
						
					}
					if(participantes!=null && participantes.size()>0)
						this.enviarNotificacionConfirmacionPorCorreo(participantes,dtCapacitacionBk,  "JSFUtil.getBaseURL()");
					else{
						throw new Validador(MessageFormat.format("CAPACITACION",
								Messages.getStringToKey("registro.participante.externo.no.se.notifico")));
					}
    			} catch (Validador e) {
    				throw new Validador(MessageFormat.format("CAPACITACION",
							Messages.getStringToKey("registro.participante.externo.no.se.notifico.asistencia")));
    			} catch (Exception e) {
    				throw new Validador(MessageFormat.format("CAPACITACION",
							Messages.getStringToKey("registro.participante.externo.no.se.notifico.asistencia")));
    			}
				
				
			}
			
			
			return dtCapacitacionBk;
		}
		
		private boolean isCapacitacionFinalizada(Long idCapacitacion){
			DtCapacitacionBk dtCapacitacionBk;				
			dtCapacitacionBk= this.getDtCapacitacionBkXid(idCapacitacion);
			if(dtCapacitacionBk==null){
				return true;
			}else if(dtCapacitacionBk.getEstado()!=null && dtCapacitacionBk.getEstado().longValue()==PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO).longValue()) {
				return true;
			}
			return false;
		}

		@Override
		public DtCapacitacionBk confirmarAsistenciaCapaNoProg(DtCapacitacionBk dtCapacitacionBk, 
															  String user,
															  Long kyUsuarioMod, 
															  Long kyAreaMod, 
															  String rmtaddress) throws Validador {
			
			List<DtCapaUsuexternosBk> dtCapaUsuexternosBksss =	dtCapacitacionBk.getDtCapacitacionUsuariosBkJSss();
			
				if (dtCapaUsuexternosBksss != null && dtCapaUsuexternosBksss.size() > 0) {
					List<DtCapaUsuexternosBk> participantesx= new ArrayList<DtCapaUsuexternosBk>();
	        			try{  
	        				if (isCapacitacionFinalizada(dtCapaUsuexternosBksss.get(0).getIdCapacitacion())) {
	        					throw new Validador(MessageFormat.format("CAPACITACION",
	    								Messages.getStringToKey("registro.participante.externo.error.servicio.finalizado")));
	        				}
	        				
							for (DtCapaUsuexternosBk dtCapaUsuexternosBk : dtCapaUsuexternosBksss) {
								if(dtCapaUsuexternosBk.getFlagMedioreg() !=null && dtCapaUsuexternosBk.getFlagMedioreg().intValue()==2){
									
									dtCapaUsuexternosBk.setFlagAsistencia(Long.valueOf(PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ASISTENCIA_SI, PropertiesMg.DEFAULT_PRTPARAMETROS_ASISTENCIA_SI)));
									
									dtCapaUsuexternosBk.setFechaFlagAsistencia(new Timestamp(System.currentTimeMillis()));
									
										this.saveorupdateDtCapaUsuexternosBk(dtCapaUsuexternosBk,
												user,
												kyUsuarioMod, 
												kyAreaMod, 
												rmtaddress);	
									
									participantesx.add(dtCapaUsuexternosBk);
								} else {
									log.info("EL PARTICIPANTE "+dtCapaUsuexternosBk.getNombre()+", CON DNI "+dtCapaUsuexternosBk.getNumDocu()+" NO HA SIDO INSCRITO VIRTUALMENTE");
								}
							}
							
							if(participantesx!=null && participantesx.size()>0) {
								log.info( Messages.getStringToKey("registro.participante.externo.confirmacion.asistencia.correctoo") );
							}
							
	        			} catch (Validador e) {
	        				throw new Validador(MessageFormat.format("CAPACITACION",
	    							Messages.getStringToKey("registro.participante.externo.no.se.notifico.asistencia")));
	        			} catch (Exception e) {
	        				throw new Validador(MessageFormat.format("CAPACITACION",
	    							Messages.getStringToKey("registro.participante.externo.no.se.notifico.asistencia")));
	        			}				
					
				}
			
			
			return dtCapacitacionBk;
		}

		@Override
		public DtCapacitacionBk confirmarNOAsistenciaCapaNoProg(DtCapacitacionBk dtCapacitacionBk, 
																String user,
																Long kyUsuarioMod, Long kyAreaMod, 
																String rmtaddress) throws Validador {
			
			List<DtCapaUsuexternosBk> dtCapaUsuexternosBksss =	dtCapacitacionBk.getDtCapacitacionUsuariosBkJSss();
			
				if (dtCapaUsuexternosBksss != null && dtCapaUsuexternosBksss.size() > 0) {
					List<DtCapaUsuexternosBk> participantesx= new ArrayList<DtCapaUsuexternosBk>();
	        			try{  
	        				if (isCapacitacionFinalizada(dtCapaUsuexternosBksss.get(0).getIdCapacitacion())) {
	        					throw new Validador(MessageFormat.format("CAPACITACION",
	    								Messages.getStringToKey("registro.participante.externo.error.servicio.finalizado")));
	        				}
							for (DtCapaUsuexternosBk dtCapaUsuexternosBk : dtCapaUsuexternosBksss) {
								if(dtCapaUsuexternosBk.getFlagMedioreg()!=null && dtCapaUsuexternosBk.getFlagMedioreg().intValue()==2){
									
									dtCapaUsuexternosBk.setFlagAsistencia(Long.valueOf(PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ASISTENCIA_NO, PropertiesMg.DEFAULT_PRTPARAMETROS_ASISTENCIA_NO)));
									dtCapaUsuexternosBk.setFechaFlagAsistencia(new Timestamp(System.currentTimeMillis()));
									
									this.saveorupdateDtCapaUsuexternosBk(dtCapaUsuexternosBk,
											user,
											kyUsuarioMod, 
											kyAreaMod, 
											rmtaddress);	
									
									participantesx.add(dtCapaUsuexternosBk);
									
								} else {
									log.info("EL PARTICIPANTE "+dtCapaUsuexternosBk.getNombre()+", CON DNI "+dtCapaUsuexternosBk.getNumDocu()+" NO HA SIDO INSCRITO VIRTUALMENTE");
								}

							}
							
							if(participantesx!=null && participantesx.size()>0) {
								log.info( Messages.getStringToKey("registro.participante.externo.confirmacion.no.asistencia.correcto") );
							}
																	

	        			} catch (Validador e) {
	        				throw new Validador(MessageFormat.format("CAPACITACION",
	    							Messages.getStringToKey("registro.participante.externo.no.se.notifico.no.asistencia")));
	        			} catch (Exception e) {
	        				log.warning("ERROR: " + e.getMessage());
	        				throw new Validador(MessageFormat.format("CAPACITACION",
	    							Messages.getStringToKey("registro.participante.externo.no.se.notifico.no.asistencia")));
	        			}			
					
				}
			
			
			return dtCapacitacionBk;
		}
		
		private void validarfinalizarDtCapacitaciones(DtCapacitacionBk dtCapacitacionBk) throws Validador {

			Long idTipoFechaCorteEjecucion = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_EJEC);

			Integer mesServicio = dtCapacitacionBk.getFechaInic().getMonth() + 1;

			if (mesServicio.intValue() == 12) {
				mesServicio = 0;
			}
			DtAmpliacionFecha autorizacionEjecucion = ampliacionFechaDao.find(idTipoFechaCorteEjecucion,
					dtCapacitacionBk.getIdSede(), dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora
																									// Mes
																									// Actual,
																									// por
																									// confirmar

			if (autorizacionEjecucion == null) {
				autorizacionEjecucion = ampliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
						dtCapacitacionBk.getIdSistAdm(), mesServicio + 1);// Ahora
																			// Mes
																			// Actual,
																			// por
																			// confirmar
				if (autorizacionEjecucion == null) {
					autorizacionEjecucion = ampliacionFechaDao.find(idTipoFechaCorteEjecucion, dtCapacitacionBk.getIdSede(),
							idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual, por
															// confirmar
					if (autorizacionEjecucion == null) {
						autorizacionEjecucion = ampliacionFechaDao.find(idTipoFechaCorteEjecucion, idSedeTodas,
								idSisAdmTodos, mesServicio + 1);// Ahora Mes Actual,
																// por confirmar
					}
				}
			}

			ValidacionDtCapacitacionMng.validarFechaFinaliza(dtCapacitacionBk, autorizacionEjecucion);

		}
		
		private Integer getParticipanteAsistente(Long idCapacitacion) throws Validador {

			return dtCapaUsuexternosDao.getParticipanteAsistente(idCapacitacion);

		}
		
		private DtCapacitacionBk finalizarDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, 
														 Long idUsuario) throws Validador {

			DtCapacitacion dtCapacitacion = null;
			Timestamp hoy = new Timestamp(System.currentTimeMillis());

			int nivel = 1;

			try {
				// SPRINT5
				if (dtCapacitacionBk.getIdCapacitacion() != null && dtCapacitacionBk.getIdCapacitacion().longValue() > 0) {

					dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(dtCapacitacionBk.getIdCapacitacion());
					boolean cambios = AuditoriaDtCapacitacionMng.auditarCambiosDtCapacitacion(dtCapacitacionBk,
							dtCapacitacion, dtCapacitacion.getIdusserCrea(), dtCapacitacion.getIdusserCrea().toString(),
							dtCapacitacion.getRtmaddress(), nivel);

					if (cambios) {

						dtCapacitacion.setIdusserModif(idUsuario);
						dtCapacitacion.setFechaModif(hoy);
						dtCapacitacionDao.updateDtCapacitacion(dtCapacitacion);

					}
				}
			} catch (Exception e) {
				log.info(e.getMessage());
				throw new Validador(e.getMessage());
			}
			dtCapacitacionBk = getDtCapacitacionBkXid(dtCapacitacion.getIdCapacitacion());
			return dtCapacitacionBk;

		}
		
		

		@Override
		public DtCapacitacionBk finalizarDtCapacitacionNoProg(DtCapacitacionBk dtCapacitacionBk, 
															  String user,
															  Long kyUsuarioMod, Long kyAreaMod, String rmtaddress, 
															  List<DtAnexoBk> tdAnexosBkss) throws Validador {
			
			
			this.validarfinalizarDtCapacitaciones(dtCapacitacionBk);
			
			if (dtCapacitacionBk.getIdCapacitacion() != null) {
				
				this.saveorupdateDtCapacitacionNoProg(dtCapacitacionBk, user, kyUsuarioMod, kyAreaMod, rmtaddress, tdAnexosBkss);
				
				dtCapacitacionBk.setCantParticAsist(this.getParticipanteAsistente(dtCapacitacionBk.getIdCapacitacion()));
				
				Long estadoFinalizado = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
				
				Timestamp hoy = new Timestamp(System.currentTimeMillis());
				dtCapacitacionBk.setFechaFinalizacion(hoy);
				
				dtCapacitacionBk.setEstado(estadoFinalizado);
				
				this.finalizarDtCapacitacion(dtCapacitacionBk, kyUsuarioMod);
				
				Long idTipoServicioCapacitacion = this.getParametro(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA, PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA);
				
				
				this.enviarEncuestaPorCorreo((dtCapacitacionBk.getNomEvento()!=null?dtCapacitacionBk.getNomEvento():""),
						dtCapacitacionBk.getDtCapacitacionUsuariosBkJSss(), idTipoServicioCapacitacion, 
						dtCapacitacionBk.getIdCapacitacion(), 
						FuncionesStaticas.timestampToDate(dtCapacitacionBk.getFechaInic()), "HTTP://URL",hoy);
				
				DtEncuestaBk encuesta= this.getIdEncuesta(idTipoServicioCapacitacion, FuncionesStaticas.timestampToDate(dtCapacitacionBk.getFechaInic()).getTime(),dtCapacitacionBk.getIdCapacitacion());//SPRINT_6
				encuesta.setIdusserModif(kyUsuarioMod);
				
				if(encuesta==null || encuesta.getIdEncuesta()==null || encuesta.getIdEncuesta().longValue()<1){				
					log.info(Messages.getStringToKey("dtEncuesta.valida.no.enviar.correo")+ " IdTipoServicio="+idTipoServicioCapacitacion +" idServicio="+dtCapacitacionBk.getIdCapacitacion()+" fechaServicio="+FuncionesStaticas.timestampToDate(dtCapacitacionBk.getFechaInic()));				
				}
				
				if(encuesta!=null) {					
					this.updateBloqueoEncuesta(encuesta);
				}
				
			}
			
			
			return dtCapacitacionBk;
		}

		@Override
		public DtUsuarioExternoBk getDtUsuarioExtByDni(String dni) throws Validador {
			DtUsuarioExternoBk msObjectBks = new DtUsuarioExternoBk();
			List<DtUsuarioExterno> msObjectDom = dtUsuarioExternoDao.getDtUsuarioExtByDni(dni);
			if (msObjectDom.size() > 1) {
				throw new Validador("SE ENCONTRÓ MAS DE UNA PERSONA CON EL DNI INGRESADO");
			} else if (msObjectDom.size() < 1) {
				throw new Validador(
						// "El DNI ingresado no se encuentra registrado, por favor
						// complete los datos."); //SPRINT5
						"EL DNI INGRESADO NO SE ENCUENTRA REGISTRADO, POR FAVOR COMPLETE LOS DATOS"); // SPRINT11
			}
			DtUsuarioExterno msObject = msObjectDom.get(0);
			FuncionesStaticas.copyPropertiesObject(msObjectBks, msObject);
			completarDtUsuarioExterno(msObjectBks);

			return msObjectBks;
		}

		@Override
		public DtCapaUsuexternosBk getDtCapaUsuexternos(Long idCapacitacion, Long idUsuexterno) throws Validador {
			DtCapaUsuexternos dtCapaUsuexternos = this.dtCapaUsuexternosDao.getDtCapaUsuexternos(idCapacitacion,
					idUsuexterno);

			DtCapaUsuexternosBk oObjectBk = null;
			if (dtCapaUsuexternos != null) {
				oObjectBk = new DtCapaUsuexternosBk();
				FuncionesStaticas.copyPropertiesObject(oObjectBk, dtCapaUsuexternos);
				completarDtCapaUsuexternos(oObjectBk);
			}
			return oObjectBk;
		}

		@Override
		public DtCapacitacionBk getOnlyDtCapacitacionBkById(Long id) {
			if (id == null)
				return null;
			DtCapacitacion dtCapacitacion = dtCapacitacionDao.getDtCapacitacion(id);
			DtCapacitacionBk dtCapacitacionBk = null;
			if (dtCapacitacion != null) {
				dtCapacitacionBk = new DtCapacitacionBk();
				FuncionesStaticas.copyPropertiesObject(dtCapacitacionBk, dtCapacitacion);
			}
			return dtCapacitacionBk;
		}
		
		

		// JPUYEN 17062024 - FIN
}