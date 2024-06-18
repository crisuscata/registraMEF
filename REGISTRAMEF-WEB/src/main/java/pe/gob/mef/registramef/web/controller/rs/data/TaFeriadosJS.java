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
public class TaFeriadosJS implements java.io.Serializable {

	// ID
	private Timestamp feFecha;

	// PROPIEDADES
	private String feDesc = null;
	
	
	// ADICIONALES
	private String feEstadoTxt = null;
	
	private Integer editopcion = 1;

	public TaFeriadosJS() {
	}

	public Timestamp getFeFecha() {
		return this.feFecha;
	}

	public void setFeFecha(Timestamp feFecha) {
		this.feFecha = feFecha;
	}
	
	public String getFeDesc() {
						return this.feDesc;
					}

	public void setFeDesc(String feDesc) {
						this.feDesc = feDesc;
					}
	
	
	public String getFeEstadoTxt() {
		return this.feEstadoTxt;
	}
	public void setFeEstadoTxt(String feEstadoTxt) {
		this.feEstadoTxt = feEstadoTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
