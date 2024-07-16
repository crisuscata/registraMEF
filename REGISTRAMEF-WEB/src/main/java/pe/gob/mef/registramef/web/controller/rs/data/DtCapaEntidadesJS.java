package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaTemasACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaEntidadesACL;
import pe.gob.mef.registramef.bs.ctlracceso.DtCapaTemasACL;

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
public class DtCapaEntidadesJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075180943557971849L;

	//ID
		private Long idCapaEnti;
			
		//PROPIEDADES
		private Long idusserCrea = null;
		private Long idusserModif = null;
		private Timestamp fechaCrea = null;
		private Timestamp fechaModif = null;
		private Long idCapacitacion = null;
		private Long idEntidad = null;
		private Long estado = null;
		private String rtmaddress = null;
		private String rtmaddressrst = null;
		
		
		//ADICIONALES
		private String idCapacitacionTxt = null;
		private String idEntidadTxt = null;
		private String estadoTxt = null;
		private String codEjecutora = null;//MPINARES 14022024 - INICIO
		
		private DtCapaEntidadesACL dtCapaEntidadesACL = null;	
		
		public DtCapaEntidadesJS() {
			
		}

		public Long getIdCapaEnti() {
			return idCapaEnti;
		}

		public void setIdCapaEnti(Long idCapaEnti) {
			this.idCapaEnti = idCapaEnti;
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

		public Long getIdCapacitacion() {
			return idCapacitacion;
		}

		public void setIdCapacitacion(Long idCapacitacion) {
			this.idCapacitacion = idCapacitacion;
		}

		public Long getIdEntidad() {
			return idEntidad;
		}

		public void setIdEntidad(Long idEntidad) {
			this.idEntidad = idEntidad;
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

		public String getIdCapacitacionTxt() {
			return idCapacitacionTxt;
		}

		public void setIdCapacitacionTxt(String idCapacitacionTxt) {
			this.idCapacitacionTxt = idCapacitacionTxt;
		}

		public String getIdEntidadTxt() {
			return idEntidadTxt;
		}

		public void setIdEntidadTxt(String idEntidadTxt) {
			this.idEntidadTxt = idEntidadTxt;
		}

		public String getEstadoTxt() {
			return estadoTxt;
		}

		public void setEstadoTxt(String estadoTxt) {
			this.estadoTxt = estadoTxt;
		}

		public String getCodEjecutora() {
			return codEjecutora;
		}

		public void setCodEjecutora(String codEjecutora) {
			this.codEjecutora = codEjecutora;
		}

		public DtCapaEntidadesACL getDtCapaEntidadesACL() {
			return dtCapaEntidadesACL;
		}

		public void setDtCapaEntidadesACL(DtCapaEntidadesACL dtCapaEntidadesACL) {
			this.dtCapaEntidadesACL = dtCapaEntidadesACL;
		}

		
		
		
		
			
}
