package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;

public class PrtParametrosACL implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6242331705240738787L;
	private boolean esEditable = false;
	private boolean eliminar = false;
	private int editopcion = 1;
	
	public PrtParametrosACL() {
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
		return "PrtParametrosACL [esEditable=" + esEditable + ", eliminar=" + eliminar + ", editopcion=" + editopcion
				+ "]";
	}	
	
	
}
