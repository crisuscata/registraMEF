package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DtAsistenciaUsuexternosJS implements java.io.Serializable {

	// ID
	private Long idAsistUsuext;

	private String aPaterno = null;
	private String aMaterno = null;
	private Long numDocu = null;
	private String nombresApellidos = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idAsistencia = null;
	private Long idUsuexterno = null;
	private String nombre = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idCargoUsuext = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	private Long ctrlConfirmacion = null;

	// ADICIONALES
	private String idAsistenciaTxt = null;
	private String idUsuexternoTxt = null;
	private String estadoTxt = null;
	private String idCargoUsuextTxt = null;

	public Long getIdAsistUsuext() {
		return idAsistUsuext;
	}

	public void setIdAsistUsuext(Long idAsistUsuext) {
		this.idAsistUsuext = idAsistUsuext;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public Long getNumDocu() {
		return numDocu;
	}

	public void setNumDocu(Long numDocu) {
		this.numDocu = numDocu;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
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

	public Timestamp getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public Timestamp getFechaModif() {
		return fechaModif;
	}

	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}

	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Long getIdUsuexterno() {
		return idUsuexterno;
	}

	public void setIdUsuexterno(Long idUsuexterno) {
		this.idUsuexterno = idUsuexterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
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

	public Long getIdCargoUsuext() {
		return idCargoUsuext;
	}

	public void setIdCargoUsuext(Long idCargoUsuext) {
		this.idCargoUsuext = idCargoUsuext;
	}

	public String getCorreoUsuext() {
		return correoUsuext;
	}

	public void setCorreoUsuext(String correoUsuext) {
		this.correoUsuext = correoUsuext;
	}

	public String getFijoUsuext() {
		return fijoUsuext;
	}

	public void setFijoUsuext(String fijoUsuext) {
		this.fijoUsuext = fijoUsuext;
	}

	public String getCelularUsuext() {
		return celularUsuext;
	}

	public void setCelularUsuext(String celularUsuext) {
		this.celularUsuext = celularUsuext;
	}

	public Long getCtrlConfirmacion() {
		return ctrlConfirmacion;
	}

	public void setCtrlConfirmacion(Long ctrlConfirmacion) {
		this.ctrlConfirmacion = ctrlConfirmacion;
	}

	public String getIdAsistenciaTxt() {
		return idAsistenciaTxt;
	}

	public void setIdAsistenciaTxt(String idAsistenciaTxt) {
		this.idAsistenciaTxt = idAsistenciaTxt;
	}

	public String getIdUsuexternoTxt() {
		return idUsuexternoTxt;
	}

	public void setIdUsuexternoTxt(String idUsuexternoTxt) {
		this.idUsuexternoTxt = idUsuexternoTxt;
	}

	public String getEstadoTxt() {
		return estadoTxt;
	}

	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}

	public String getIdCargoUsuextTxt() {
		return idCargoUsuextTxt;
	}

	public void setIdCargoUsuextTxt(String idCargoUsuextTxt) {
		this.idCargoUsuextTxt = idCargoUsuextTxt;
	}

}
