package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtEncuestaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ENCUESTA BAKING: LISTA DE ENCUESTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtEncuestaBk implements java.io.Serializable {

	//ID
	private Integer idEncuesta;
		
	//PROPIEDADES
	private Long tipoServicio = null;
	private Timestamp fechaInicio = null;
	private Timestamp fechaFin = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long flagBloqueo = null;
	private Long idOrigen = null;
	private Long idPrestacion = null;
	
	
	//ADICIONALES
	private String tipoServicioTxt = null;
	private String estadoTxt = null;
	private String idOrigenTxt = null;
	private String idPrestacionTxt = null;
	
	private DtEncuestaACL dtEncuestaACL = null;		
		
	public DtEncuestaBk() {
	}
	
	public Integer getIdEncuesta() {
		return this.idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	
	public Long getTipoServicio() {
						return this.tipoServicio;
					}

	public void setTipoServicio(Long tipoServicio) {
						this.tipoServicio = tipoServicio;
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
	
	public Timestamp getFechaModif() {
						return this.fechaModif;
					}

	public void setFechaModif(Timestamp fechaModif) {
						this.fechaModif = fechaModif;
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
	
	public Long getFlagBloqueo() {
						return this.flagBloqueo;
					}

	public void setFlagBloqueo(Long flagBloqueo) {
						this.flagBloqueo = flagBloqueo;
					}
	
	public Long getIdOrigen() {
						return this.idOrigen;
					}

	public void setIdOrigen(Long idOrigen) {
						this.idOrigen = idOrigen;
					}
	
	public Long getIdPrestacion() {
						return this.idPrestacion;
					}

	public void setIdPrestacion(Long idPrestacion) {
						this.idPrestacion = idPrestacion;
					}
	
	
	
	public String getTipoServicioTxt() {
		return this.tipoServicioTxt;
	}
	public void setTipoServicioTxt(String tipoServicioTxt) {
		this.tipoServicioTxt = tipoServicioTxt;
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
	public String getIdOrigenTxt() {
		return this.idOrigenTxt;
	}
	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}
	public String getIdPrestacionTxt() {
		return this.idPrestacionTxt;
	}
	public void setIdPrestacionTxt(String idPrestacionTxt) {
		this.idPrestacionTxt = idPrestacionTxt;
	}
		
	
	public DtEncuestaACL getDtEncuestaACL() {
		return dtEncuestaACL;
	}

	public void setDtEncuestaACL(DtEncuestaACL dtEncuestaACL) {
		this.dtEncuestaACL = dtEncuestaACL;
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
