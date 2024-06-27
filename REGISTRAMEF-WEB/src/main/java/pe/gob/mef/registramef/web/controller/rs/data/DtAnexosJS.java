package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * MSUSUARIOS BAKING: ANEXOS
 * 
 * @author Juan Carlos Puyen Santos
 * @version 2.0, 15/06/2024 10:30
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Juan Carlos Puyen Santos/15/06/2024 10:30  / Creación de la clase /
 * 
 */
@XmlRootElement
public class DtAnexosJS implements java.io.Serializable {

	/**
	 * // JPUYEN 14052024 - CREACION CLASE
	 */
	private static final long serialVersionUID = -5566995450534185418L;

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
	private Integer flagMaterialCapa=null;
	
	// ADICIONALES
	private String idTiposervicio_txt = null;
	private String estado_txt = null;
	private boolean materialCapa=false;
	private String materialCapaTxt=null;
	private String data = null;
	private byte[] databyte = null;
	private String letter = null;
	private Integer editopcion = 1;
	private Long tamanio = null;
	private String tipo = null;
	

	// PROPIEDADES
	private Long iddocumento = null;
	private Long lastmodified = null;
	private Integer tipodocumento = null;

	// ADICIONALES
	private String iduserCreaTxt = null;
	private String iduserModifTxt = null;
	/*
	private String estadoTxt = null;
	private String idTiposervicioTxt=null;
	private String tipoAnexoTxt = null;*/
			
		public Long getIddocumento() {
		return iddocumento;
	}


	public void setIddocumento(Long iddocumento) {
		this.iddocumento = iddocumento;
	}


	public Long getLastmodified() {
		return lastmodified;
	}


	public void setLastmodified(Long lastmodified) {
		this.lastmodified = lastmodified;
	}


	public Integer getTipodocumento() {
		return tipodocumento;
	}


	public void setTipodocumento(Integer tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	public String getIduserCreaTxt() {
		return iduserCreaTxt;
	}


	public void setIduserCreaTxt(String iduserCreaTxt) {
		this.iduserCreaTxt = iduserCreaTxt;
	}


	public String getIduserModifTxt() {
		return iduserModifTxt;
	}


	public void setIduserModifTxt(String iduserModifTxt) {
		this.iduserModifTxt = iduserModifTxt;
	}


		public DtAnexosJS() {
		}


		public Long getIdAnexo() {
			return idAnexo;
		}


		public void setIdAnexo(Long idAnexo) {
			this.idAnexo = idAnexo;
		}


		public Long getIdusserCrea() {
			return idusserCrea;
		}


		public void setIdusserCrea(Long idusserCrea) {
			this.idusserCrea = idusserCrea;
		}


		public Long getIdusserModif() {
			return idusserModif;
		}


		public void setIdusserModif(Long idusserModif) {
			this.idusserModif = idusserModif;
		}


		public Timestamp getFechaCrea() {
			return fechaCrea;
		}


		public void setFechaCrea(Timestamp fechaCrea) {
			this.fechaCrea = fechaCrea;
		}


		public Timestamp getFechaModif() {
			return fechaModif;
		}


		public void setFechaModif(Timestamp fechaModif) {
			this.fechaModif = fechaModif;
		}


		public String getFilename() {
			return filename;
		}


		public void setFilename(String filename) {
			this.filename = filename;
		}


		public String getFilenameoriginal() {
			return filenameoriginal;
		}


		public void setFilenameoriginal(String filenameoriginal) {
			this.filenameoriginal = filenameoriginal;
		}


		public Long getEstado() {
			return estado;
		}


		public void setEstado(Long estado) {
			this.estado = estado;
		}


		public Long getIdTiposervicio() {
			return idTiposervicio;
		}


		public void setIdTiposervicio(Long idTiposervicio) {
			this.idTiposervicio = idTiposervicio;
		}


		public Long getTipoAnexo() {
			return tipoAnexo;
		}


		public void setTipoAnexo(Long tipoAnexo) {
			this.tipoAnexo = tipoAnexo;
		}


		public Long getIdmaestro() {
			return idmaestro;
		}


		public void setIdmaestro(Long idmaestro) {
			this.idmaestro = idmaestro;
		}


		public String getRtmaddress() {
			return rtmaddress;
		}


		public void setRtmaddress(String rtmaddress) {
			this.rtmaddress = rtmaddress;
		}


		public String getRtmaddressrst() {
			return rtmaddressrst;
		}


		public void setRtmaddressrst(String rtmaddressrst) {
			this.rtmaddressrst = rtmaddressrst;
		}


		public Integer getFlagMaterialCapa() {
			return flagMaterialCapa;
		}


		public void setFlagMaterialCapa(Integer flagMaterialCapa) {
			this.flagMaterialCapa = flagMaterialCapa;
		}


		public String getIdTiposervicio_txt() {
			return idTiposervicio_txt;
		}


		public void setIdTiposervicio_txt(String idTiposervicio_txt) {
			this.idTiposervicio_txt = idTiposervicio_txt;
		}


		public String getEstado_txt() {
			return estado_txt;
		}


		public void setEstado_txt(String estado_txt) {
			this.estado_txt = estado_txt;
		}


		public boolean isMaterialCapa() {
			return materialCapa;
		}


		public void setMaterialCapa(boolean materialCapa) {
			this.materialCapa = materialCapa;
		}


		public String getMaterialCapaTxt() {
			return materialCapaTxt;
		}


		public void setMaterialCapaTxt(String materialCapaTxt) {
			this.materialCapaTxt = materialCapaTxt;
		}


		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public String getLetter() {
			return letter;
		}


		public void setLetter(String letter) {
			this.letter = letter;
		}


		public Integer getEditopcion() {
			return editopcion;
		}


		public void setEditopcion(Integer editopcion) {
			this.editopcion = editopcion;
		}


		public Long getTamanio() {
			return tamanio;
		}


		public void setTamanio(Long tamanio) {
			this.tamanio = tamanio;
		}


		public String getTipo() {
			return tipo;
		}


		public void setTipo(String tipo) {
			this.tipo = tipo;
		}


		public byte[] getDatabyte() {
			return databyte;
		}


		public void setDatabyte(byte[] databyte) {
			this.databyte = databyte;
		}


	
		
}
