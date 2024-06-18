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
public class PrtParametrosJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2352603525002381333L;

	// ID
	private Long idparametro;

	// PROPIEDADES
	private Long idpadre = null;
	private String descripcion = null;
	private Integer estado = null;
	
	
	// ADICIONALES
	private String idpadreTxt = null;
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	//PURIBE 25012024 - INICIO
		private Integer notificacion = null; 
		
		//PURIBE 25012024 - FIN
	
	public PrtParametrosJS() {
	}

	public Long getIdparametro() {
		return this.idparametro;
	}

	public void setIdparametro(Long idparametro) {
		this.idparametro = idparametro;
	}
	
	public Long getIdpadre() {
						return this.idpadre;
					}

	public void setIdpadre(Long idpadre) {
						this.idpadre = idpadre;
					}
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public Integer getEstado() {
						return this.estado;
					}

	public void setEstado(Integer estado) {
						this.estado = estado;
					}
	
	
	public String getIdpadreTxt() {
		return this.idpadreTxt;
	}
	public void setIdpadreTxt(String idpadreTxt) {
		this.idpadreTxt = idpadreTxt;
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
	
	//PURIBE 25012024 - INICIO

		public Integer getNotificacion() {
			return notificacion;
		}

		public void setNotificacion(Integer notificacion) {
			this.notificacion = notificacion;
		}
		//PURIBE 25012024 - FIN
}
