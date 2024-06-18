package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtEncuestaRespuestaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ENCUESTA_RESPUESTA BAKING: LISTA DE RESPUESTAS A LAS ENCUESTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtEncuestaRespuestaBk implements java.io.Serializable {

	//ID
	private Long idRespuesta;
		
	//PROPIEDADES
	private Long idUsuexterno = null;
	private Integer idEncuesta = null;
	private Long idServicio = null;
	private String tipoPregunta = null;
	private String idPregunta = null;
	private String respuesta = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idExpositor = null;
	private String pregunta = null;
	
	
	//ADICIONALES
	private String idEncuestaTxt = null;
	private String estadoTxt = null;
	private String idExpositorTxt = null;
	
	private DtEncuestaRespuestaACL dtEncuestaRespuestaACL = null;		
		
	public DtEncuestaRespuestaBk() {
	}
	
	public Long getIdRespuesta() {
		return this.idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	
	public Long getIdUsuexterno() {
						return this.idUsuexterno;
					}

	public void setIdUsuexterno(Long idUsuexterno) {
						this.idUsuexterno = idUsuexterno;
					}
	
	public Integer getIdEncuesta() {
						return this.idEncuesta;
					}

	public void setIdEncuesta(Integer idEncuesta) {
						this.idEncuesta = idEncuesta;
					}
	
	public Long getIdServicio() {
						return this.idServicio;
					}

	public void setIdServicio(Long idServicio) {
						this.idServicio = idServicio;
					}
	
	public String getTipoPregunta() {
						return this.tipoPregunta;
					}

	public void setTipoPregunta(String tipoPregunta) {
						this.tipoPregunta = tipoPregunta;
					}
	
	public String getIdPregunta() {
						return this.idPregunta;
					}

	public void setIdPregunta(String idPregunta) {
						this.idPregunta = idPregunta;
					}
	
	public String getRespuesta() {
						return this.respuesta;
					}

	public void setRespuesta(String respuesta) {
						this.respuesta = respuesta;
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
	
	public Long getIdExpositor() {
						return this.idExpositor;
					}

	public void setIdExpositor(Long idExpositor) {
						this.idExpositor = idExpositor;
					}
	
	public String getPregunta() {
						return this.pregunta;
					}

	public void setPregunta(String pregunta) {
						this.pregunta = pregunta;
					}
	
	
	
	public String getIdEncuestaTxt() {
		return this.idEncuestaTxt;
	}
	public void setIdEncuestaTxt(String idEncuestaTxt) {
		this.idEncuestaTxt = idEncuestaTxt;
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
	public String getIdExpositorTxt() {
		return this.idExpositorTxt;
	}
	public void setIdExpositorTxt(String idExpositorTxt) {
		this.idExpositorTxt = idExpositorTxt;
	}
		
	
	public DtEncuestaRespuestaACL getDtEncuestaRespuestaACL() {
		return dtEncuestaRespuestaACL;
	}

	public void setDtEncuestaRespuestaACL(DtEncuestaRespuestaACL dtEncuestaRespuestaACL) {
		this.dtEncuestaRespuestaACL = dtEncuestaRespuestaACL;
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
