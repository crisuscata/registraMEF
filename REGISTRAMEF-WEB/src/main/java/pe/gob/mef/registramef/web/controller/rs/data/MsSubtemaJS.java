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
public class MsSubtemaJS implements java.io.Serializable {

	// ID
	private Long idSubtema;

	// PROPIEDADES
	private String descripcion = null;
	private Long idTema = null;
	private Long idIndicador = null;
	
	
	// ADICIONALES
	private String idTemaTxt = null;
	private String estadoTxt = null;
	private String idIndicadorTxt = null;
	
	private Integer editopcion = 1;

	public MsSubtemaJS() {
	}

	public Long getIdSubtema() {
		return this.idSubtema;
	}

	public void setIdSubtema(Long idSubtema) {
		this.idSubtema = idSubtema;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public Long getIdTema() {
						return this.idTema;
					}

	public void setIdTema(Long idTema) {
						this.idTema = idTema;
					}
	public Long getIdIndicador() {
						return this.idIndicador;
					}

	public void setIdIndicador(Long idIndicador) {
						this.idIndicador = idIndicador;
					}
	
	
	public String getIdTemaTxt() {
		return this.idTemaTxt;
	}
	public void setIdTemaTxt(String idTemaTxt) {
		this.idTemaTxt = idTemaTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdIndicadorTxt() {
		return this.idIndicadorTxt;
	}
	public void setIdIndicadorTxt(String idIndicadorTxt) {
		this.idIndicadorTxt = idIndicadorTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
