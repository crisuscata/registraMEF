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
public class MsRolesJS implements java.io.Serializable {

	// ID
	private Long idrol;

	// PROPIEDADES
	private String username = null;
	private String rol = null;
	
	
	// ADICIONALES
	
	private Integer editopcion = 1;

	public MsRolesJS() {
	}

	public Long getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}
	
	public String getUsername() {
						return this.username;
					}

	public void setUsername(String username) {
						this.username = username;
					}
	public String getRol() {
						return this.rol;
					}

	public void setRol(String rol) {
						this.rol = rol;
					}
	
	
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
