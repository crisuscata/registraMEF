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
public class MsProyectoInversionJS implements java.io.Serializable {

	// ID
	private Long idProyecto;

	// PROPIEDADES
	private String codigo = null;
	private String nombre = null;
	private Long idSede = null;
	
	
	// ADICIONALES
	private String idSedeTxt = null;
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public MsProyectoInversionJS() {
	}

	public Long getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public String getCodigo() {
						return this.codigo;
					}

	public void setCodigo(String codigo) {
						this.codigo = codigo;
					}
	public String getNombre() {
						return this.nombre;
					}

	public void setNombre(String nombre) {
						this.nombre = nombre;
					}
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	
	
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
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
