package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;

public class DtVisitasACL implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2555241943431988602L;
	private boolean esEditable = false;
	private boolean eliminar = false;
	private int editopcion = 1;
	private boolean reactivar = false;
	
	
	public DtVisitasACL() {
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
		return "DtVisitasACL [esEditable=" + esEditable + ", eliminar=" + eliminar + ", editopcion=" + editopcion
				+ "]";
	}	
	//PURIBE 01022024 - INICIO-->
	public boolean isReactivar() {
		return reactivar;
	}

	public void setReactivar(boolean reactivar) {
		this.reactivar = reactivar;
	}
}
