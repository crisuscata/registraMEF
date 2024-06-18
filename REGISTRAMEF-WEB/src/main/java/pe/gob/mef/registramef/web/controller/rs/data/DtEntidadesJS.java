package pe.gob.mef.registramef.web.controller.rs.data;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.transfer.DtEntidadSedesDto;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSisAdminBk;

/**
 * MSUSUARIOS BAKING: USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37 / Creación de la clase
 *          /
 * 
 */
@XmlRootElement
public class DtEntidadesJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4510776905572938988L;

	// ID
	private Long idEntidad;

	// PROPIEDADES
	private String codEjec = null;
	private String razSocial = null;
	private String direccion = null;
	private Long ruc = null;
	private Long idTipo = null;
	private Long idCaract = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private Long idSistAdmi = null;
	private String geozona = null;

	// ADICIONALES
	private String estadoTxt = null;
	private String idTipoTxt = null;
	private String idCaractTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idpaisTxt = null;
	private String idSistAdmiTxt = null;

	private List<DtEntidadSedesDto> dtEntidadSedesss = null;

	private Integer editopcion = 1;
	
	//MPINARES 24012023 - INICIO
		private Long idSede = null;
		private List<DtEntidadSisAdminBk> dtEntidadSisAdminBkJSss = null;
		//MPINARES 24012023 - FIN

	public DtEntidadesJS() {
	}

	public Long getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getCodEjec() {
		return this.codEjec;
	}

	public void setCodEjec(String codEjec) {
		this.codEjec = codEjec;
	}

	public String getRazSocial() {
		return this.razSocial;
	}

	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getRuc() {
		return this.ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}

	public Long getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public Long getIdCaract() {
		return this.idCaract;
	}

	public void setIdCaract(Long idCaract) {
		this.idCaract = idCaract;
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

	public Long getIdpais() {
		return this.idpais;
	}

	public void setIdpais(Long idpais) {
		this.idpais = idpais;
	}

	public Long getIdSistAdmi() {
		return this.idSistAdmi;
	}

	public void setIdSistAdmi(Long idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}

	public String getGeozona() {
		return this.geozona;
	}

	public void setGeozona(String geozona) {
		this.geozona = geozona;
	}

	public String getEstadoTxt() {
		return this.estadoTxt;
	}

	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}

	public String getIdTipoTxt() {
		return this.idTipoTxt;
	}

	public void setIdTipoTxt(String idTipoTxt) {
		this.idTipoTxt = idTipoTxt;
	}

	public String getIdCaractTxt() {
		return this.idCaractTxt;
	}

	public void setIdCaractTxt(String idCaractTxt) {
		this.idCaractTxt = idCaractTxt;
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

	public String getIdpaisTxt() {
		return this.idpaisTxt;
	}

	public void setIdpaisTxt(String idpaisTxt) {
		this.idpaisTxt = idpaisTxt;
	}

	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}

	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}

	public List<DtEntidadSedesDto> getDtEntidadSedesss() {
		return dtEntidadSedesss;
	}

	public void setDtEntidadSedesss(List<DtEntidadSedesDto> dtEntidadSedesss) {
		this.dtEntidadSedesss = dtEntidadSedesss;
	}
	
	//MPINARES 24012023 - INICIO
	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}
	
	public List<DtEntidadSisAdminBk> getDtEntidadSisAdminBkJSss() {
		return dtEntidadSisAdminBkJSss;
	}

	public void setDtEntidadSisAdminBkJSss(List<DtEntidadSisAdminBk> dtEntidadSisAdminBkJSss) {
		this.dtEntidadSisAdminBkJSss = dtEntidadSisAdminBkJSss;
	}
	
    
  //MPINARES 24012023 - FIN
}
