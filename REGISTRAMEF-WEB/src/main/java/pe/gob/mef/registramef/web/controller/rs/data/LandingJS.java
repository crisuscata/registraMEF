// PURIBE 15042024 - INICIO -->
package pe.gob.mef.registramef.web.controller.rs.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 * @author Pablo Uribe
 * @version 2.0, 15/04/2024 08:42
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Pablo Uribe Caillahui /15/04/2024 08:42  / Creación de la clase /
 * 
 */
@XmlRootElement
public class LandingJS  implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6602064884152803272L;

	
	private boolean listareunion = false;

	private boolean registroreunion = false;
	private boolean listaasistencia = false;

	private boolean registroasistencia = false;
	private boolean listacapacitacion = false;

	private boolean registrocapacitacion = false;
	public LandingJS() {
	}
	
	public boolean isListareunion() {
		return listareunion;
	}

	public void setListareunion(boolean listareunion) {
		this.listareunion = listareunion;
	}

	public boolean isRegistroreunion() {
		return registroreunion;
	}

	public void setRegistroreunion(boolean registroreunion) {
		this.registroreunion = registroreunion;
	}

	public boolean isListaasistencia() {
		return listaasistencia;
	}

	public void setListaasistencia(boolean listaasistencia) {
		this.listaasistencia = listaasistencia;
	}

	public boolean isRegistroasistencia() {
		return registroasistencia;
	}

	public void setRegistroasistencia(boolean registroasistenca) {
		this.registroasistencia = registroasistenca;
	}

	public boolean isListacapacitacion() {
		return listacapacitacion;
	}

	public void setListacapacitacion(boolean listacapacitacion) {
		this.listacapacitacion = listacapacitacion;
	}

	public boolean isRegistrocapacitacion() {
		return registrocapacitacion;
	}

	public void setRegistrocapacitacion(boolean registrocapacitacion) {
		this.registrocapacitacion = registrocapacitacion;
	}

	

}
//PURIBE 15042024 - FIN -->