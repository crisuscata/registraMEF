package pe.gob.mef.registramef.web.controller.rs.data;

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
public class DtUsuarioExternoJS implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// ID
	private Long idUsuexterno;

	// PROPIEDADES
	private String nombre = null;
	private String aPaterno = null;
	private String aMaterno = null;
	private String direccion = null;
	private String correo = null;
	private Long telefFijo = null;
	private Long telefCell = null;
	private Long numDocu = null;
	private String sexo = null;
	private Long idTipodocumento = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private String otroTelefono = null;
	private String otroCelular = null;
	private String numDocum = null;
	private Long flagMedioreg = null;
	
	private Long idCargo=null;
	private String idCargoTxt=null;
	
	// ADICIONALES
	private String estadoTxt = null;
	private String idTipodocumentoTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idpaisTxt = null;
	
	private Integer editopcion = 1;

	public DtUsuarioExternoJS() {
	}

	public Long getIdUsuexterno() {
		return this.idUsuexterno;
	}

	public void setIdUsuexterno(Long idUsuexterno) {
		this.idUsuexterno = idUsuexterno;
	}
	
	public String getDireccion() {
						return this.direccion;
					}

	public void setDireccion(String direccion) {
						this.direccion = direccion;
					}
	public Long getNumDocu() {
						return this.numDocu;
					}

	public void setNumDocu(Long numDocu) {
						this.numDocu = numDocu;
					}
	public String getSexo() {
						return this.sexo;
					}

	public void setSexo(String sexo) {
						this.sexo = sexo;
					}
	public Long getIdTipodocumento() {
						return this.idTipodocumento;
					}

	public void setIdTipodocumento(Long idTipodocumento) {
						this.idTipodocumento = idTipodocumento;
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
	public String getOtroTelefono() {
						return this.otroTelefono;
					}

	public void setOtroTelefono(String otroTelefono) {
						this.otroTelefono = otroTelefono;
					}
	public String getOtroCelular() {
						return this.otroCelular;
					}

	public void setOtroCelular(String otroCelular) {
						this.otroCelular = otroCelular;
					}
	public String getNumDocum() {
						return this.numDocum;
					}

	public void setNumDocum(String numDocum) {
						this.numDocum = numDocum;
					}
	public Long getFlagMedioreg() {
						return this.flagMedioreg;
					}

	public void setFlagMedioreg(Long flagMedioreg) {
						this.flagMedioreg = flagMedioreg;
					}
	
	
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdTipodocumentoTxt() {
		return this.idTipodocumentoTxt;
	}
	public void setIdTipodocumentoTxt(String idTipodocumentoTxt) {
		this.idTipodocumentoTxt = idTipodocumentoTxt;
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
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getTelefFijo() {
		return telefFijo;
	}

	public void setTelefFijo(Long telefFijo) {
		this.telefFijo = telefFijo;
	}

	public Long getTelefCell() {
		return telefCell;
	}

	public void setTelefCell(Long telefCell) {
		this.telefCell = telefCell;
	}

	public String getIdCargoTxt() {
		return idCargoTxt;
	}

	public void setIdCargoTxt(String idCargoTxt) {
		this.idCargoTxt = idCargoTxt;
	}	
	
}
