package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.domain.MsUbigeoId;

/**
 * MSUSUARIOS BAKING: USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37  / Creación de la clase /
 * 
 */
@XmlRootElement
public class MsUbigeoJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5576348650809034531L;

	// ID
	private MsUbigeoId id;

	// PROPIEDADES
	private String descripcion = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idubigeo = null;

	// ADICIONALES
	private String estadoTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idTxt=null;
	private Integer tipo = null;
	private String tipoTxt = null;
 
	private Integer editopcion = 1;

	public MsUbigeoJS() {
	}

	public MsUbigeoId getId() {
		return this.id;
	}

	public void setId(MsUbigeoId id) {
		this.id = id;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public Integer getCodDpto() {
						return this.codDpto;
					}

	public void setCodDpto(Integer codDpto) {
						this.codDpto = codDpto;
					}
	public Integer getCodProv() {
						return this.codProv;
					}

	public void setCodProv(Integer codProv) {
						this.codProv = codProv;
					}
	public Long getIdubigeo() {
						return this.idubigeo;
					}

	public void setIdubigeo(Long idubigeo) {
						this.idubigeo = idubigeo;
					}
	
	
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}

	public Integer getCodDistr() {
		return codDistr;
	}

	public void setCodDistr(Integer codDistr) {
		this.codDistr = codDistr;
	}

	public Timestamp getFechaModif() {
		return fechaModif;
	}

	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}

	public Timestamp getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getEstadoTxt() {
		return estadoTxt;
	}

	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}

	public String getCodDptoTxt() {
		return codDptoTxt;
	}

	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
	}

	public String getCodDistrTxt() {
		return codDistrTxt;
	}

	public void setCodDistrTxt(String codDistrTxt) {
		this.codDistrTxt = codDistrTxt;
	}

	public String getCodProvTxt() {
		return codProvTxt;
	}

	public void setCodProvTxt(String codProvTxt) {
		this.codProvTxt = codProvTxt;
	}

	public String getIdTxt() {
		return idTxt;
	}

	public void setIdTxt(String idTxt) {
		this.idTxt = idTxt;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTipoTxt() {
		return tipoTxt;
	}

	public void setTipoTxt(String tipoTxt) {
		this.tipoTxt = tipoTxt;
	}			
}
