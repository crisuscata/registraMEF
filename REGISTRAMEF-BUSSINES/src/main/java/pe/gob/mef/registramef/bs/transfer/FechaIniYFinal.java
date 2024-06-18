package pe.gob.mef.registramef.bs.transfer;

import java.io.Serializable;
import java.sql.Timestamp;

public class FechaIniYFinal implements Serializable{

	/**
	 * //MPINARES 29092023 - INICIO - NUEVA CLASE
	 */
	private static final long serialVersionUID = 2344692539945923146L;
	private Timestamp fechaIni = null;
	private Timestamp fechaFin = null;
	
	public FechaIniYFinal() {
		// TODO Auto-generated constructor stub
	}

	public FechaIniYFinal(Timestamp fechaIni, Timestamp fechaFin) {
		super();
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}

	public Timestamp getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Timestamp fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

}
