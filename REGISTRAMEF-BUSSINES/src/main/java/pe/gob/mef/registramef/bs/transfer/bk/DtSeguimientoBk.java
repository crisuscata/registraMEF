package pe.gob.mef.registramef.bs.transfer.bk;

import java.util.Date;

import pe.gob.mef.registramef.bs.transfer.PerfilDto;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.registramef.bs.utils.PropertiesMg.Modulo;

public class DtSeguimientoBk {

	private Long idSeguimiento;
	private Date fechaSeguimiento;
	private Long idProgramacion;
	private Long idModalidad;
	private Long idFinancia;
	private Long idEntidad;
	private Long idLocal;
	private Long idSede;
	private Long idSistAdmi;
	private Date fechaEjecucion;
	private Long idEstadoActual;
	private String motivo;
	private Long idEstadoSeguimiento;
	private Long estado;
	private Long idusserCrea;
	private Long idusserModif;
	private Date fechaCrea;
	private Date fechaModif;
	private String rtmaddress;
	private String rtmaddressrst;

	private boolean anulado = false;
	private boolean finalizado = false;

	private String idProgramacion_txt;
	private String idSede_txt;
	private String idSistAdmi_txt;

	private String idModalidad_txt;
	private String idFinancia_txt;
	private String idLocal_txt;

	private String codEjec;
	private String idEntidad_txt;
	private String codEntidad_txt;

	private String idEstadoActual_txt;
	private String idEstadoSeguimiento_txt;

	private String estado_txt;

	private PerfilDto perfil;
	private Modulo modulo;

	public Long getIdSeguimiento() {
		return idSeguimiento;
	}

	public void setIdSeguimiento(Long idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public Date getFechaSeguimiento() {
		return fechaSeguimiento;
	}

	public void setFechaSeguimiento(Date fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}

	public Long getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(Long idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public Long getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(Long idModalidad) {
		this.idModalidad = idModalidad;
	}

	public Long getIdFinancia() {
		return idFinancia;
	}

	public void setIdFinancia(Long idFinancia) {
		this.idFinancia = idFinancia;
	}

	public Long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public Long getIdSistAdmi() {
		return idSistAdmi;
	}

	public void setIdSistAdmi(Long idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getIdusserCrea() {
		return idusserCrea;
	}

	public void setIdusserCrea(Long idusserCrea) {
		this.idusserCrea = idusserCrea;
	}

	public Long getIdusserModif() {
		return idusserModif;
	}

	public void setIdusserModif(Long idusserModif) {
		this.idusserModif = idusserModif;
	}

	public Date getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public Date getFechaModif() {
		return fechaModif;
	}

	public void setFechaModif(Date fechaModif) {
		this.fechaModif = fechaModif;
	}

	public String getRtmaddress() {
		return rtmaddress;
	}

	public void setRtmaddress(String rtmaddress) {
		this.rtmaddress = rtmaddress;
	}

	public String getRtmaddressrst() {
		return rtmaddressrst;
	}

	public void setRtmaddressrst(String rtmaddressrst) {
		this.rtmaddressrst = rtmaddressrst;
	}

	public boolean isAnulado() {
		Long estadoAnulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
		if (estado.longValue() == estadoAnulado.longValue()) {
			anulado = true;
		}
		return anulado;
	}

	public boolean isFinalizado() {
		Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO,
				PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
		if (estado.longValue() == estadoFinalizado.longValue()) {
			finalizado = true;
		}
		return finalizado;
	}

	public String getIdProgramacion_txt() {
		return idProgramacion_txt;
	}

	public void setIdProgramacion_txt(String idProgramacion_txt) {
		this.idProgramacion_txt = idProgramacion_txt;
	}

	public String getIdModalidad_txt() {
		return idModalidad_txt;
	}

	public void setIdModalidad_txt(String idModalidad_txt) {
		this.idModalidad_txt = idModalidad_txt;
	}

	public String getIdFinancia_txt() {
		return idFinancia_txt;
	}

	public void setIdFinancia_txt(String idFinancia_txt) {
		this.idFinancia_txt = idFinancia_txt;
	}

	public String getCodEjec() {
		return codEjec;
	}

	public void setCodEjec(String codEjec) {
		this.codEjec = codEjec;
	}

	public String getIdEntidad_txt() {
		return idEntidad_txt;
	}

	public void setIdEntidad_txt(String idEntidad_txt) {
		this.idEntidad_txt = idEntidad_txt;
	}

	public String getCodEntidad_txt() {
		return codEntidad_txt;
	}

	public void setCodEntidad_txt(String codEntidad_txt) {
		this.codEntidad_txt = codEntidad_txt;
	}

	public String getIdLocal_txt() {
		return idLocal_txt;
	}

	public void setIdLocal_txt(String idLocal_txt) {
		this.idLocal_txt = idLocal_txt;
	}

	public String getIdSede_txt() {
		return idSede_txt;
	}

	public void setIdSede_txt(String idSede_txt) {
		this.idSede_txt = idSede_txt;
	}

	public String getIdSistAdmi_txt() {
		return idSistAdmi_txt;
	}

	public void setIdSistAdmi_txt(String idSistAdmi_txt) {
		this.idSistAdmi_txt = idSistAdmi_txt;
	}

	public PerfilDto getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDto perfil) {
		this.perfil = perfil;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getEstado_txt() {
		return estado_txt;
	}

	public void setEstado_txt(String estado_txt) {
		this.estado_txt = estado_txt;
	}

	public Long getIdEstadoActual() {
		return idEstadoActual;
	}

	public void setIdEstadoActual(Long idEstadoActual) {
		this.idEstadoActual = idEstadoActual;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Long getIdEstadoSeguimiento() {
		return idEstadoSeguimiento;
	}

	public void setIdEstadoSeguimiento(Long idEstadoSeguimiento) {
		this.idEstadoSeguimiento = idEstadoSeguimiento;
	}

	public String getIdEstadoActual_txt() {
		return idEstadoActual_txt;
	}

	public void setIdEstadoActual_txt(String idEstadoActual_txt) {
		this.idEstadoActual_txt = idEstadoActual_txt;
	}

	public String getIdEstadoSeguimiento_txt() {
		return idEstadoSeguimiento_txt;
	}

	public void setIdEstadoSeguimiento_txt(String idEstadoSeguimiento_txt) {
		this.idEstadoSeguimiento_txt = idEstadoSeguimiento_txt;
	}
}