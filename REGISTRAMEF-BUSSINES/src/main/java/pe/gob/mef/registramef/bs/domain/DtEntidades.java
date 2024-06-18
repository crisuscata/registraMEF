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
 * DT_ENTIDADES ENTIDAD: ALMACENA LAS ENTIDAD REGISTRADAS EN EL SISTEMA
 * "ENTIDADES"
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
@Table(name = "DT_ENTIDADES")
public class DtEntidades implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6032237550265127730L;

	// ID
	private Long idEntidad = null;

	// PROPIEDADES
	private String codEjec = null;
	private String razSocial = null;
	private String direccion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long ruc = null;
	private Long estado = null;
	private Long idTipo = null;
	private Long idCaract = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private Long idSistAdmi = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private String geozona = null;

	private Long idSede = null;// MPINARES 24012023 - INICIO

	public DtEntidades() {
	}

	@SequenceGenerator(name = "G_DT_ENTIDADES", sequenceName = PropertiesMg.ESQUEMA
			+ "SQ_DT_ENTIDADES", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_ENTIDADES")
	@Id
	@Column(name = "ID_ENTIDAD", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	@Column(name = "COD_EJEC", length = 10)
	public String getCodEjec() {
		return this.codEjec;
	}

	public void setCodEjec(String codEjec) {
		this.codEjec = codEjec;
	}

	@Column(name = "RAZ_SOCIAL", length = 200)
	public String getRazSocial() {
		return this.razSocial;
	}

	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
	}

	@Column(name = "DIRECCION", length = 300)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	@Column(name = "RUC", precision = 11, scale = 0)
	public Long getRuc() {
		return this.ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}

	@Column(name = "ESTADO", precision = 10, scale = 0)
	public Long getEstado() {
		return this.estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	@Column(name = "ID_TIPO", precision = 10, scale = 0)
	public Long getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	@Column(name = "ID_CARACT", precision = 10, scale = 0)
	public Long getIdCaract() {
		return this.idCaract;
	}

	public void setIdCaract(Long idCaract) {
		this.idCaract = idCaract;
	}

	@Column(name = "COD_DPTO", precision = 2, scale = 0)
	public Integer getCodDpto() {
		return this.codDpto;
	}

	public void setCodDpto(Integer codDpto) {
		this.codDpto = codDpto;
	}

	@Column(name = "COD_PROV", precision = 2, scale = 0)
	public Integer getCodProv() {
		return this.codProv;
	}

	public void setCodProv(Integer codProv) {
		this.codProv = codProv;
	}

	@Column(name = "COD_DISTR", precision = 2, scale = 0)
	public Integer getCodDistr() {
		return this.codDistr;
	}

	public void setCodDistr(Integer codDistr) {
		this.codDistr = codDistr;
	}

	@Column(name = "IDPAIS", precision = 10, scale = 0)
	public Long getIdpais() {
		return this.idpais;
	}

	public void setIdpais(Long idpais) {
		this.idpais = idpais;
	}

	@Column(name = "ID_SIST_ADMI", precision = 10, scale = 0)
	public Long getIdSistAdmi() {
		return this.idSistAdmi;
	}

	public void setIdSistAdmi(Long idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
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

	@Column(name = "GEOZONA", length = 2)
	public String getGeozona() {
		return this.geozona;
	}

	public void setGeozona(String geozona) {
		this.geozona = geozona;
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
