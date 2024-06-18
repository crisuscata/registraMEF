package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;

public class DtAsistenciaACL implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5397462171973079363L;
	private boolean esEditable = false;
	private boolean eliminar = false;
	private int editopcion = 1;
	
	private boolean reactivar = false;//MPINARES 24012023 - INICIO
	
	public DtAsistenciaACL() {
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

	@Override
	public String toString() {
		return "DtAsistenciaACL [esEditable=" + esEditable + ", eliminar=" + eliminar + ", editopcion=" + editopcion
				+ "]";
	}	
	
	//MPINARES 24012023 - INICIO
		public boolean isReactivar() {
			return reactivar;
		}

		public void setReactivar(boolean reactivar) {
			this.reactivar = reactivar;
		}
	//MPINARES 24012023 - FIN
}
