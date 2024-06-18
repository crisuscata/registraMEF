package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaTemasACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ASISTENCIA_TEMAS BAKING: LISTA DE LOS DISTINTOS TEMAS AGENDADOS EN LA ASISTENCIA TECNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtAsistenciaTemasBk implements java.io.Serializable {

	//ID
	private Long idAsistTema;
		
	//PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String detalle = null;
	private Long idAsistencia = null;
	private Long idTema = null;
	private Long idSubtema = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idUsuinterno = null;
	private Long idSistAdmi = null;
	
	
	//ADICIONALES
	private String idAsistenciaTxt = null;
	private String idTemaTxt = null;
	private String idSubtemaTxt = null;
	private String estadoTxt = null;
	
	private DtAsistenciaTemasACL dtAsistenciaTemasACL = null;	
	//MPINARES 24012023 - INICIO
		private boolean add = false;
		private Long contador = null;
		//MPINARES 24012023 - FIN
		
	public DtAsistenciaTemasBk() {
	}
	
	public Long getIdAsistTema() {
		return this.idAsistTema;
	}

	public void setIdAsistTema(Long idAsistTema) {
		this.idAsistTema = idAsistTema;
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
	
	public String getDetalle() {
						return this.detalle;
					}

	public void setDetalle(String detalle) {
						this.detalle = detalle;
					}
	
	public Long getIdAsistencia() {
						return this.idAsistencia;
					}

	public void setIdAsistencia(Long idAsistencia) {
						this.idAsistencia = idAsistencia;
					}
	
	public Long getIdTema() {
						return this.idTema;
					}

	public void setIdTema(Long idTema) {
						this.idTema = idTema;
					}
	
	public Long getIdSubtema() {
						return this.idSubtema;
					}

	public void setIdSubtema(Long idSubtema) {
						this.idSubtema = idSubtema;
					}
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
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
	
	public Long getIdUsuinterno() {
						return this.idUsuinterno;
					}

	public void setIdUsuinterno(Long idUsuinterno) {
						this.idUsuinterno = idUsuinterno;
					}
	
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	
	
	
	public String getIdAsistenciaTxt() {
		return this.idAsistenciaTxt;
	}
	public void setIdAsistenciaTxt(String idAsistenciaTxt) {
		this.idAsistenciaTxt = idAsistenciaTxt;
	}
	public String getIdTemaTxt() {
		return this.idTemaTxt;
	}
	public void setIdTemaTxt(String idTemaTxt) {
		this.idTemaTxt = idTemaTxt;
	}
	public String getIdSubtemaTxt() {
		return this.idSubtemaTxt;
	}
	public void setIdSubtemaTxt(String idSubtemaTxt) {
		this.idSubtemaTxt = idSubtemaTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		
	
	public DtAsistenciaTemasACL getDtAsistenciaTemasACL() {
		return dtAsistenciaTemasACL;
	}

	public void setDtAsistenciaTemasACL(DtAsistenciaTemasACL dtAsistenciaTemasACL) {
		this.dtAsistenciaTemasACL = dtAsistenciaTemasACL;
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
        
      //MPINARES 24012023 - INICIO
      		public boolean isAdd() {
      			return add;
      		}

      		public void setAdd(boolean add) {
      			this.add = add;
      		}

      		public Long getContador() {
      			return contador;
      		}

      		public void setContador(Long contador) {
      			this.contador = contador;
      		}
      		//MPINARES 24012023 - FIN
        
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
