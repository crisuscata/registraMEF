package pe.gob.mef.registramef.bs.ctlracceso;

import java.io.Serializable;

public class DtVisitasACL implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2555241943431988602L;
	private boolean esEditable = false;
	private boolean finalizar = false;
	private boolean eliminar = false;
	private int editopcion = 1;
	private boolean reactivar = false;
	private int editentidad = 1;//PURIBE 04042024 - INICIO-->
	
	
	public DtVisitasACL() {
	}

	public boolean isEsEditable() {
		return esEditable;
	}

	public void setEsEditable(boolean esEditable) {
		this.esEditable = esEditable;
	}
	
	//PURIBE 04042024 - INICIO-->
		public int getEditentidad() {
			return editentidad;
		}

		public void setEditentidad(int editentidad) {
			this.editentidad = editentidad;
		}
		
		//PURIBE 04042024 - FIN-->

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
	
	//PURIBE 04042024 - INICIO-->

		public boolean isFinalizar() {
			return finalizar;
		}

		public void setFinalizar(boolean finalizar) {
			this.finalizar = finalizar;
		}
		//PURIBE 04042024 - FIN-->
}
