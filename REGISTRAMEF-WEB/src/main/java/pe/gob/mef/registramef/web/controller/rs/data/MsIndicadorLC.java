package pe.gob.mef.registramef.web.controller.rs.data;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.transfer.bk.MsIndicadorBk;

@XmlRootElement
public class MsIndicadorLC implements Serializable  {

	protected long contador = 0;
	private long tiempoenBD = 0;
	private long tiempoenproceso = 0;
	private boolean creamodifica = false;
	protected List<MsIndicadorBk> data = null;
	
	public MsIndicadorLC() {
	}

	public long getContador() {
		return contador;
	}

	public void setContador(long contador) {
		this.contador = contador;
	}

	public List<MsIndicadorBk> getData() {
		return data;
	}

	public void setData(List<MsIndicadorBk> data) {
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
}
