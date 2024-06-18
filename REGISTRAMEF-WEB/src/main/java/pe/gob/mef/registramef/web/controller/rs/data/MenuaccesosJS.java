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
public class MenuaccesosJS  implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6602064884152803272L;
	private boolean entidades = false;	
	private boolean usuarios = false;
	private boolean ubigeo = false;
	private boolean parametros = false;
	
    public MenuaccesosJS() {
	}

	public boolean isEntidades() {
		return entidades;
	}

	public void setEntidades(boolean entidades) {
		this.entidades = entidades;
	}

	public boolean isUsuarios() {
		return usuarios;
	}

	public void setUsuarios(boolean usuarios) {
		this.usuarios = usuarios;
	}

	public boolean isUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(boolean ubigeo) {
		this.ubigeo = ubigeo;
	}

	public boolean isParametros() {
		return parametros;
	}

	public void setParametros(boolean parametros) {
		this.parametros = parametros;
	}
    
}
