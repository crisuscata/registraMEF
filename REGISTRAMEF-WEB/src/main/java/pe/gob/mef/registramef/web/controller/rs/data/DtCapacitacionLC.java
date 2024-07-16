package pe.gob.mef.registramef.web.controller.rs.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;

@XmlRootElement
public class DtCapacitacionLC implements Serializable  {

	protected long contador = 0;
	private long tiempoenBD = 0;
	private long tiempoenproceso = 0;
	private boolean creamodifica = false;
	protected List<DtCapacitacionBk> data = null;
	private boolean prepublicar = false;
	private boolean acumular = false;
	
	public DtCapacitacionLC() {
	}

	public long getContador() {
		return contador;
	}

	public void setContador(long contador) {
		this.contador = contador;
	}

	public List<DtCapacitacionBk> getData() {
		return data;
	}

	public void setData(List<DtCapacitacionBk> data) {
		this.data = data;
	}

	public long getTiempoenBD() {
		return tiempoenBD;
	}

	public void setTiempoenBD(long tiempoenBD) {
		this.tiempoenBD = tiempoenBD;
	}

	public long getTiempoenproceso() {
		return tiempoenproceso;
	}

	public void setTiempoenproceso(long tiempoenproceso) {
		this.tiempoenproceso = tiempoenproceso;
	}	
	
	public boolean isCreamodifica() {
		return creamodifica;
	}

	public void setCreamodifica(boolean creamodifica) {
		this.creamodifica = creamodifica;
	}

	public boolean isPrepublicar() {
		return prepublicar;
	}

	public void setPrepublicar(boolean prepublicar) {
		this.prepublicar = prepublicar;
	}

	public boolean isAcumular() {
		return acumular;
	}

	public void setAcumular(boolean acumular) {
		this.acumular = acumular;
	}
	
	
}
