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
	// PURIBE 04042024 - INICIO-->
		private boolean programacionreunion = false;
		private boolean programacionasistencia = false;
		private boolean programacioncapacitacion = false;
		

		private boolean registroreunion = false;
		private boolean registroasistencia = false;
		private boolean registrocapacitacion = false;
		// PURIBE 04042024 - FIN-->
	
    public MenuaccesosJS() {
	}

	public boolean isEntidades() {
		return entidades;
	}

	public void setEntidades(boolean entidades) {
		this.entidades = entidades;
	}
	
	// PURIBE 04042024 - INICIO-->
		public boolean isProgramacionreunion() {
			return programacionreunion;
		}

		public void setProgramacionreunion(boolean programacionreunion) {
			this.programacionreunion = programacionreunion;
		}

		public boolean isRegistroreunion() {
			return registroreunion;
		}

		public void setRegistroreunion(boolean registroreunion) {
			this.registroreunion = registroreunion;
		}
		
		
		
		// PURIBE 04042024 - FIN-->

	public boolean isProgramacionasistencia() {
			return programacionasistencia;
		}

		public void setProgramacionasistencia(boolean programacionasistencia) {
			this.programacionasistencia = programacionasistencia;
		}

		public boolean isProgramacioncapacitacion() {
			return programacioncapacitacion;
		}

		public void setProgramacioncapacitacion(boolean programacioncapacitacion) {
			this.programacioncapacitacion = programacioncapacitacion;
		}

		public boolean isRegistroasistencia() {
			return registroasistencia;
		}

		public void setRegistroasistencia(boolean registroasistencia) {
			this.registroasistencia = registroasistencia;
		}

		public boolean isRegistrocapacitacion() {
			return registrocapacitacion;
		}

		public void setRegistrocapacitacion(boolean registrocapacitacion) {
			this.registrocapacitacion = registrocapacitacion;
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
