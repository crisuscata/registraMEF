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
public class MsPaisesJS implements java.io.Serializable {

	// ID
	private Long idpais;

	// PROPIEDADES
	private String paisNombre = null;
	private String acronimo = null;
	
	
	// ADICIONALES
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public MsPaisesJS() {
	}

	public Long getIdpais() {
		return this.idpais;
	}

	public void setIdpais(Long idpais) {
		this.idpais = idpais;
	}
	
	public String getPaisNombre() {
						return this.paisNombre;
					}

	public void setPaisNombre(String paisNombre) {
						this.paisNombre = paisNombre;
					}
	public String getAcronimo() {
						return this.acronimo;
					}

	public void setAcronimo(String acronimo) {
						this.acronimo = acronimo;
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
