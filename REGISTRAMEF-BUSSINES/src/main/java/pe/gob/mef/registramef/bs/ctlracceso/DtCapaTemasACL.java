package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;

public class DtCapaTemasACL implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8175815834341145184L;
	private boolean esEditable = false;
	private boolean eliminar = false;
	private int editopcion = 1;
	
	public DtCapaTemasACL() {
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
		return "DtCapaTemasACL [esEditable=" + esEditable + ", eliminar=" + eliminar + ", editopcion=" + editopcion
				+ "]";
	}	
	
	
}
