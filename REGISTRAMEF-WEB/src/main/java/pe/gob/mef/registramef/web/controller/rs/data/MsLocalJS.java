package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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
public class MsLocalJS implements java.io.Serializable {

	// ID
	private Long idLocal;

	// PROPIEDADES
	private String descripcion = null;
	private String direccion = null;
	private String referencia = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idSede = null;
	private Long idpais = null;
	
	
	// ADICIONALES
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idSedeTxt = null;
	private String idpaisTxt = null;
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public MsLocalJS() {
	}

	public Long getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public String getDireccion() {
						return this.direccion;
					}

	public void setDireccion(String direccion) {
						this.direccion = direccion;
					}
	public String getReferencia() {
						return this.referencia;
					}

	public void setReferencia(String referencia) {
						this.referencia = referencia;
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
	public Integer getCodDistr() {
						return this.codDistr;
					}

	public void setCodDistr(Integer codDistr) {
						this.codDistr = codDistr;
					}
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	public Long getIdpais() {
						return this.idpais;
					}

	public void setIdpais(Long idpais) {
						this.idpais = idpais;
					}
	
	
	public String getCodDptoTxt() {
		return this.codDptoTxt;
	}
	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
	}
	public String getCodProvTxt() {
		return this.codProvTxt;
	}
	public void setCodProvTxt(String codProvTxt) {
		this.codProvTxt = codProvTxt;
	}
	public String getCodDistrTxt() {
		return this.codDistrTxt;
	}
	public void setCodDistrTxt(String codDistrTxt) {
		this.codDistrTxt = codDistrTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getIdpaisTxt() {
		return this.idpaisTxt;
	}
	public void setIdpaisTxt(String idpaisTxt) {
		this.idpaisTxt = idpaisTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
