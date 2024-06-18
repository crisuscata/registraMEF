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
public class MsSisAdmistrativoJS implements java.io.Serializable {

	// ID
	private Long idSistAdmi;

	// PROPIEDADES
	private String descripcion = null;
	private Integer flagasocencuesta = null;
	private String abreviatura = null;
	
	
	// ADICIONALES
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public MsSisAdmistrativoJS() {
	}

	public Long getIdSistAdmi() {
		return this.idSistAdmi;
	}

	public void setIdSistAdmi(Long idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public Integer getFlagasocencuesta() {
						return this.flagasocencuesta;
					}

	public void setFlagasocencuesta(Integer flagasocencuesta) {
						this.flagasocencuesta = flagasocencuesta;
					}
	public String getAbreviatura() {
						return this.abreviatura;
					}

	public void setAbreviatura(String abreviatura) {
						this.abreviatura = abreviatura;
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
