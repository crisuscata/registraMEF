package pe.gob.mef.registramef.bs.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * DT_ENTIDAD_SIS_ADMIN ENTIDAD:
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48 / Creación de la clase
 *          /
 * 
 */
@Entity
@Table(name = "DT_ENTIDAD_SIS_ADMIN")
public class DtEntidadSisAdmin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6877162330435718657L;

	// ID
	private Long identidadSisadm = null;

	// PROPIEDADES
	private Long idEntidad = null;
	private Long idSistAdmi = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;

	private Long idSede = null;// MPINARES 24012023 - INICIO

	public DtEntidadSisAdmin() {
	}

	@SequenceGenerator(name = "G_DT_ENTIDAD_SIS_ADMIN", sequenceName = PropertiesMg.ESQUEMA
			+ "SQ_DT_ENTIDAD_SIS_ADMIN", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_ENTIDAD_SIS_ADMIN")
	@Id
	@Column(name = "IDENTIDAD_SISADM", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getIdentidadSisadm() {
		return this.identidadSisadm;
	}

	public void setIdentidadSisadm(Long identidadSisadm) {
		this.identidadSisadm = identidadSisadm;
	}

	@Column(name = "ID_ENTIDAD", precision = 10, scale = 0)
	public Long getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	@Column(name = "ID_SIST_ADMI", precision = 10, scale = 0)
	public Long getIdSistAdmi() {
		return this.idSistAdmi;
	}

	public void setIdSistAdmi(Long idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}

	@Column(name = "FECHA_CREA", length = 7)
	public Timestamp getFechaCrea() {
		return this.fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	@Column(name = "FECHA_MODIF", length = 7)
	public Timestamp getFechaModif() {
		return this.fechaModif;
	}

	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}

	@Column(name = "IDUSSER_CREA", precision = 10, scale = 0)
	public Long getIdusserCrea() {
		return this.idusserCrea;
	}

	public void setIdusserCrea(Long idusserCrea) {
		this.idusserCrea = idusserCrea;
	}

	@Column(name = "IDUSSER_MODIF", precision = 10, scale = 0)
	public Long getIdusserModif() {
		return this.idusserModif;
	}

	public void setIdusserModif(Long idusserModif) {
		this.idusserModif = idusserModif;
	}

	@Column(name = "ESTADO", precision = 10, scale = 0)
	public Long getEstado() {
		return this.estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	@Column(name = "RTMADDRESS", length = 50)
	public String getRtmaddress() {
		return this.rtmaddress;
	}

	public void setRtmaddress(String rtmaddress) {
		this.rtmaddress = rtmaddress;
	}

	@Column(name = "RTMADDRESSRST", length = 50)
	public String getRtmaddressrst() {
		return this.rtmaddressrst;
	}

	public void setRtmaddressrst(String rtmaddressrst) {
		this.rtmaddressrst = rtmaddressrst;
	}

	// MPINARES 24012023 - INICIO
	@Column(name = "ID_SEDE", precision = 10, scale = 0)
	public Long getIdSede() {
		return this.idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}
	// MPINARES 24012023 - FIN

}
