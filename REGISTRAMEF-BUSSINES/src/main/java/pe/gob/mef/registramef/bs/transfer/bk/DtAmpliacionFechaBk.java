package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtAmpliacionFechaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_AMPLIACION_FECHA BAKING: LISTA DE AMPLIACIONES DE LOS DÍAS DE PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtAmpliacionFechaBk implements java.io.Serializable {

	//ID
	private Long idAutorizacion;
		
	//PROPIEDADES
	private Long tipoFechaCorte = null;
	private Long idSede = null;
	private Long idSistAdmi = null;
	private Timestamp fechaInicio = null;
	private Timestamp fechaFin = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String tipoFechaCorteTxt = null;
	private String idSedeTxt = null;
	private String idSistAdmiTxt = null;
	private String estadoTxt = null;
	
	private DtAmpliacionFechaACL dtAmpliacionFechaACL = null;		
		
	public DtAmpliacionFechaBk() {
	}
	
	public Long getIdAutorizacion() {
		return this.idAutorizacion;
	}

	public void setIdAutorizacion(Long idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	
	public Long getTipoFechaCorte() {
						return this.tipoFechaCorte;
					}

	public void setTipoFechaCorte(Long tipoFechaCorte) {
						this.tipoFechaCorte = tipoFechaCorte;
					}
	
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	
	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public java.util.Date getFechaInicioJUD() {
		java.util.Date fechaInicioJUD = null;
		if (fechaInicio != null)
			fechaInicioJUD = new java.util.Date(fechaInicio.getTime());
		return fechaInicioJUD;
	}
	public void setFechaInicioJUD(java.util.Date fechaInicioJUD) {
		if (fechaInicioJUD != null)
			this.fechaInicio = new Timestamp(fechaInicioJUD.getTime());
		else
			this.fechaInicio = null;
	}	
	
	public Timestamp getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public java.util.Date getFechaFinJUD() {
		java.util.Date fechaFinJUD = null;
		if (fechaFin != null)
			fechaFinJUD = new java.util.Date(fechaFin.getTime());
		return fechaFinJUD;
	}
	public void setFechaFinJUD(java.util.Date fechaFinJUD) {
		if (fechaFinJUD != null)
			this.fechaFin = new Timestamp(fechaFinJUD.getTime());
		else
			this.fechaFin = null;
	}	
	
	public Timestamp getFechaModif() {
		return this.fechaModif;
	}
	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}
	public java.util.Date getFechaModifJUD() {
		java.util.Date fechaModifJUD = null;
		if (fechaModif != null)
			fechaModifJUD = new java.util.Date(fechaModif.getTime());
		return fechaModifJUD;
	}
	public void setFechaModifJUD(java.util.Date fechaModifJUD) {
		if (fechaModifJUD != null)
			this.fechaModif = new Timestamp(fechaModifJUD.getTime());
		else
			this.fechaModif = null;
	}	
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	public Long getIdusserCrea() {
						return this.idusserCrea;
					}

	public void setIdusserCrea(Long idusserCrea) {
						this.idusserCrea = idusserCrea;
					}
	
	public Long getIdusserModif() {
						return this.idusserModif;
					}

	public void setIdusserModif(Long idusserModif) {
						this.idusserModif = idusserModif;
					}
	
	public Timestamp getFechaCrea() {
						return this.fechaCrea;
					}

	public void setFechaCrea(Timestamp fechaCrea) {
						this.fechaCrea = fechaCrea;
					}
	
	public String getRtmaddress() {
						return this.rtmaddress;
					}

	public void setRtmaddress(String rtmaddress) {
						this.rtmaddress = rtmaddress;
					}
	
	public String getRtmaddressrst() {
						return this.rtmaddressrst;
					}

	public void setRtmaddressrst(String rtmaddressrst) {
						this.rtmaddressrst = rtmaddressrst;
					}
	
	
	
	public String getTipoFechaCorteTxt() {
		return this.tipoFechaCorteTxt;
	}
	public void setTipoFechaCorteTxt(String tipoFechaCorteTxt) {
		this.tipoFechaCorteTxt = tipoFechaCorteTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}
	public String getEstadoTxt() {
		if (estadoTxt==null && estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			estadoTxt="Activo";
		} else {
			if (estadoTxt==null && estado != null) 
			     estadoTxt="Eliminado";
		}
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		
	
	public DtAmpliacionFechaACL getDtAmpliacionFechaACL() {
		return dtAmpliacionFechaACL;
	}

	public void setDtAmpliacionFechaACL(DtAmpliacionFechaACL dtAmpliacionFechaACL) {
		this.dtAmpliacionFechaACL = dtAmpliacionFechaACL;
	}
	
	public String getCclase(){
		if(estado!=null && estado.longValue()>Estado.ELIMINADO.getValor()){
			return "cverde";
		}else{
			
		}return "camarillo";
	}
       
        public void setCclase(String cclase) {
	}
        
        public String getCestado(){
		if(estado!=null && estado.longValue()>Estado.ELIMINADO.getValor()){
			return "Activo";
		}else{			
		}
		return "Eliminado";
	}
         
        public void setCestado(String cestado) {
	}
        
        public boolean getEsEliminado() {
		boolean retorno = false;
		if (estado != null && estado.longValue() == Estado.ELIMINADO.getValor()) {
			retorno = true;
		} 
		return retorno;
	}

	public void setEsEliminado(boolean esEliminado) {		
	}
}
