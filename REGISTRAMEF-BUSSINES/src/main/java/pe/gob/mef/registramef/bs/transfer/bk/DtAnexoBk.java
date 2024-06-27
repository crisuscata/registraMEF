package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtAnexoACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ANEXO BAKING: LISTA DE LOS DOCUMENTOS ANEXADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtAnexoBk implements java.io.Serializable {

	//ID
	private Long idAnexo;
		
	//PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String filename = null;
	private String filenameoriginal = null;
	private Long estado = null;
	private Long idTiposervicio = null;
	private Long tipoAnexo = null;
	private Long idmaestro = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long flagMaterialCapa = null;
	
	
	//ADICIONALES
	private String estadoTxt = null;
	private String idTiposervicioTxt = null;
	private String tipoAnexoTxt = null;
	
	private DtAnexoACL dtAnexoACL = null;	
	
	private String data = null; // JPUYEN 14052024
	private byte[] databyte = null; // JPUYEN 14052024
		
	public DtAnexoBk() {
	}
	
	public Long getIdAnexo() {
		return this.idAnexo;
	}

	public void setIdAnexo(Long idAnexo) {
		this.idAnexo = idAnexo;
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
	
	public String getFilename() {
						return this.filename;
					}

	public void setFilename(String filename) {
						this.filename = filename;
					}
	
	public String getFilenameoriginal() {
						return this.filenameoriginal;
					}

	public void setFilenameoriginal(String filenameoriginal) {
						this.filenameoriginal = filenameoriginal;
					}
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	public Long getIdTiposervicio() {
						return this.idTiposervicio;
					}

	public void setIdTiposervicio(Long idTiposervicio) {
						this.idTiposervicio = idTiposervicio;
					}
	
	public Long getTipoAnexo() {
						return this.tipoAnexo;
					}

	public void setTipoAnexo(Long tipoAnexo) {
						this.tipoAnexo = tipoAnexo;
					}
	
	public Long getIdmaestro() {
						return this.idmaestro;
					}

	public void setIdmaestro(Long idmaestro) {
						this.idmaestro = idmaestro;
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
	
	public Long getFlagMaterialCapa() {
						return this.flagMaterialCapa;
					}

	public void setFlagMaterialCapa(Long flagMaterialCapa) {
						this.flagMaterialCapa = flagMaterialCapa;
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
	public String getIdTiposervicioTxt() {
		return this.idTiposervicioTxt;
	}
	public void setIdTiposervicioTxt(String idTiposervicioTxt) {
		this.idTiposervicioTxt = idTiposervicioTxt;
	}
	public String getTipoAnexoTxt() {
		return this.tipoAnexoTxt;
	}
	public void setTipoAnexoTxt(String tipoAnexoTxt) {
		this.tipoAnexoTxt = tipoAnexoTxt;
	}
		
	
	public DtAnexoACL getDtAnexoACL() {
		return dtAnexoACL;
	}

	public void setDtAnexoACL(DtAnexoACL dtAnexoACL) {
		this.dtAnexoACL = dtAnexoACL;
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
	
	// JPUYEN 14052024 - INICIO
		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public byte[] getDatabyte() {
			return databyte;
		}

		public void setDatabyte(byte[] databyte) {
			this.databyte = databyte;
		}
		
		// JPUYEN 14052024 - FIN
}
