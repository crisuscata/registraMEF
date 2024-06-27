package pe.gob.mef.registramef.web.controller.rs.data;

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

	// ID
	private MsUbigeoId id;

	// PROPIEDADES
	private String descripcion = null;
	private Integer codDpto = null;
	public String getCoddistTxt() {
		return coddistTxt;
	}

	public void setCoddistTxt(String coddistTxt) {
		this.coddistTxt = coddistTxt;
	}

	public String getCoddptoTxt() {
		return coddptoTxt;
	}

	public void setCoddptoTxt(String coddptoTxt) {
		this.coddptoTxt = coddptoTxt;
	}

	public String getCodprovTxt() {
		return codprovTxt;
	}

	public void setCodprovTxt(String codprovTxt) {
		this.codprovTxt = codprovTxt;
	}
   //PURIBE 20012024 - INICIO-->
	private Integer codProv = null;
	private Long idubigeo = null;
	private Long estado = null;

	private String coddistTxt = null;
	private String coddptoTxt=null;
	private String codprovTxt=null;
	
	// ADICIONALES
	
	private Integer editopcion = 1;

	public MsUbigeoJS() {
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}
	   //PURIBE 20012024 - FIN-->
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
}
