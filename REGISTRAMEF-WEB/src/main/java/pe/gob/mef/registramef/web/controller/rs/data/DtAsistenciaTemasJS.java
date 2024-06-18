package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaTemasACL;

/**
 * MSUSUARIOS BAKING: USUARIOS //MPINARES 24012023 - INICIO - NUEVA CLASE
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37  / Creación de la clase /
 * 
 */
@XmlRootElement
public class DtAsistenciaTemasJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075180943557971849L;

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
		
		private boolean add = false;
		private Long contador = null;
		
		public DtAsistenciaTemasJS() {
			
		}

		public Long getIdAsistTema() {
			return idAsistTema;
		}

		public void setIdAsistTema(Long idAsistTema) {
			this.idAsistTema = idAsistTema;
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

		public String getDetalle() {
			return detalle;
		}

		public void setDetalle(String detalle) {
			this.detalle = detalle;
		}

		public Long getIdAsistencia() {
			return idAsistencia;
		}

		public void setIdAsistencia(Long idAsistencia) {
			this.idAsistencia = idAsistencia;
		}

		public Long getIdTema() {
			return idTema;
		}

		public void setIdTema(Long idTema) {
			this.idTema = idTema;
		}

		public Long getIdSubtema() {
			return idSubtema;
		}

		public void setIdSubtema(Long idSubtema) {
			this.idSubtema = idSubtema;
		}

		public Long getEstado() {
			return estado;
		}

		public void setEstado(Long estado) {
			this.estado = estado;
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

		public Long getIdUsuinterno() {
			return idUsuinterno;
		}

		public void setIdUsuinterno(Long idUsuinterno) {
			this.idUsuinterno = idUsuinterno;
		}

		public Long getIdSistAdmi() {
			return idSistAdmi;
		}

		public void setIdSistAdmi(Long idSistAdmi) {
			this.idSistAdmi = idSistAdmi;
		}

		public String getIdAsistenciaTxt() {
			return idAsistenciaTxt;
		}

		public void setIdAsistenciaTxt(String idAsistenciaTxt) {
			this.idAsistenciaTxt = idAsistenciaTxt;
		}

		public String getIdTemaTxt() {
			return idTemaTxt;
		}

		public void setIdTemaTxt(String idTemaTxt) {
			this.idTemaTxt = idTemaTxt;
		}

		public String getIdSubtemaTxt() {
			return idSubtemaTxt;
		}

		public void setIdSubtemaTxt(String idSubtemaTxt) {
			this.idSubtemaTxt = idSubtemaTxt;
		}

		public String getEstadoTxt() {
			return estadoTxt;
		}

		public void setEstadoTxt(String estadoTxt) {
			this.estadoTxt = estadoTxt;
		}

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

		public DtAsistenciaTemasACL getDtAsistenciaTemasACL() {
			return dtAsistenciaTemasACL;
		}

		public void setDtAsistenciaTemasACL(DtAsistenciaTemasACL dtAsistenciaTemasACL) {
			this.dtAsistenciaTemasACL = dtAsistenciaTemasACL;
		}
		
		
		
		
		
			
}
