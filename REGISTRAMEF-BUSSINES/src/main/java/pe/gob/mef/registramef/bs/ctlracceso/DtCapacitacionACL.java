package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;

public class DtCapacitacionACL implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2130203967971237274L;
	private boolean esEditable = false;
	private boolean eliminar = false;
	private boolean reactivar = false;//MPINARES 14022024 - INICIO
	private int editopcion = 1;
	
	public DtCapacitacionACL() {
	}

	public boolean isEsEditable() {
		return esEditable;
	}

	public void setEsEditable(boolean esEditable) {
		this.esEditable = esEditable;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public int getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(int editopcion) {
		this.editopcion = editopcion;
	}
	//MPINARES 14022024 - INICIO
		public boolean isReactivar() {
			return reactivar;
		}

		public void setReactivar(boolean reactivar) {
			this.reactivar = reactivar;
		}
		//MPINARES 14022024 - FIN

	@Override
	public String toString() {
		return "DtCapacitacionACL [esEditable=" + esEditable + ", eliminar=" + eliminar + ", editopcion=" + editopcion
				+ "]";
	}	
	
	
}
