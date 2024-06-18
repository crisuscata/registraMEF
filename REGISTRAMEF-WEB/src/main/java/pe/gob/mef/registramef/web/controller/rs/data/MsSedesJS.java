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
public class MsSedesJS implements java.io.Serializable {

	// ID
	private Long idSede;

	// PROPIEDADES
	private String sigla = null;
	private String sede = null;
	private String direccion = null;
	private Long idGrupo = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idMacregion = null;
	private Long idpais = null;
	private Long orden = null;
	private Integer flagvisible = null;
	private Integer flagvisiblerpte = null;
	
	
	// ADICIONALES
	private String idGrupoTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String estadoTxt = null;
	private String idMacregionTxt = null;
	private String idpaisTxt = null;
	
	private Integer editopcion = 1;

	public MsSedesJS() {
	}

	public Long getIdSede() {
		return this.idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}
	
	public String getSigla() {
						return this.sigla;
					}

	public void setSigla(String sigla) {
						this.sigla = sigla;
					}
	public String getSede() {
						return this.sede;
					}

	public void setSede(String sede) {
						this.sede = sede;
					}
	public String getDireccion() {
						return this.direccion;
					}

	public void setDireccion(String direccion) {
						this.direccion = direccion;
					}
	public Long getIdGrupo() {
						return this.idGrupo;
					}

	public void setIdGrupo(Long idGrupo) {
						this.idGrupo = idGrupo;
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
	public Long getIdMacregion() {
						return this.idMacregion;
					}

	public void setIdMacregion(Long idMacregion) {
						this.idMacregion = idMacregion;
					}
	public Long getIdpais() {
						return this.idpais;
					}

	public void setIdpais(Long idpais) {
						this.idpais = idpais;
					}
	public Long getOrden() {
						return this.orden;
					}

	public void setOrden(Long orden) {
						this.orden = orden;
					}
	public Integer getFlagvisible() {
						return this.flagvisible;
					}

	public void setFlagvisible(Integer flagvisible) {
						this.flagvisible = flagvisible;
					}
	public Integer getFlagvisiblerpte() {
						return this.flagvisiblerpte;
					}

	public void setFlagvisiblerpte(Integer flagvisiblerpte) {
						this.flagvisiblerpte = flagvisiblerpte;
					}
	
	
	public String getIdGrupoTxt() {
		return this.idGrupoTxt;
	}
	public void setIdGrupoTxt(String idGrupoTxt) {
		this.idGrupoTxt = idGrupoTxt;
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
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdMacregionTxt() {
		return this.idMacregionTxt;
	}
	public void setIdMacregionTxt(String idMacregionTxt) {
		this.idMacregionTxt = idMacregionTxt;
	}
	public String getIdpaisTxt() {
		return this.idpaisTxt;
	}
	public void setIdpaisTxt(String idpaisTxt) {
		this.idpaisTxt = idpaisTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
