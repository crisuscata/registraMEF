package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtConsultasACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CONSULTAS BAKING: LISTA DE LOS DATOS REGISTRADOS EN UNA CONSULTA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtConsultasBk implements java.io.Serializable {

	//ID
	private Long idConsulta;
		
	//PROPIEDADES
	private Timestamp fechaConsu = null;
	private Long idUsuexterno = null;private String nombre = null;
	private Long idSistAdm = null;
	private Long idTema = null;
	private Long idSubtema = null;
	private Long estado = null;
	private String detalle = null;
	private String respuesta = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idPrestservic = null;
	private Long idModalidad = null;
	private Long idUsuinterno = null;
	private Long idEntidad = null;private String razSocial = null;
	private Long idOrigen = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idCargo = null;
	private Long idSede = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaSoli = null;
	
	
	//ADICIONALES
	private String idUsuexternoTxt = null;
	private String idSistAdmTxt = null;
	private String idTemaTxt = null;
	private String idSubtemaTxt = null;
	private String estadoTxt = null;
	private String idPrestservicTxt = null;
	private String idModalidadTxt = null;
	private String idUsuinternoTxt = null;
	private String idEntidadTxt = null;
	private String idOrigenTxt = null;
	private String idCargoTxt = null;
	private String idSedeTxt = null;
	
	private DtConsultasACL dtConsultasACL = null;		
		
	public DtConsultasBk() {
	}
	
	public Long getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public Timestamp getFechaConsu() {
		return this.fechaConsu;
	}
	public void setFechaConsu(Timestamp fechaConsu) {
		this.fechaConsu = fechaConsu;
	}
	public java.util.Date getFechaConsuJUD() {
		java.util.Date fechaConsuJUD = null;
		if (fechaConsu != null)
			fechaConsuJUD = new java.util.Date(fechaConsu.getTime());
		return fechaConsuJUD;
	}
	public void setFechaConsuJUD(java.util.Date fechaConsuJUD) {
		if (fechaConsuJUD != null)
			this.fechaConsu = new Timestamp(fechaConsuJUD.getTime());
		else
			this.fechaConsu = null;
	}	
	
	
public Long getIdUsuexterno() {
						return this.idUsuexterno;
					}

	public void setIdUsuexterno(Long idUsuexterno) {
						this.idUsuexterno = idUsuexterno;
					}
public String getNombre() {
						return this.nombre;
					}

	public void setNombre(String nombre) {
						this.nombre = nombre;
					}

	public Long getIdSistAdm() {
						return this.idSistAdm;
					}

	public void setIdSistAdm(Long idSistAdm) {
						this.idSistAdm = idSistAdm;
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
	
	public String getDetalle() {
						return this.detalle;
					}

	public void setDetalle(String detalle) {
						this.detalle = detalle;
					}
	
	public String getRespuesta() {
						return this.respuesta;
					}

	public void setRespuesta(String respuesta) {
						this.respuesta = respuesta;
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
	
	public Long getIdPrestservic() {
						return this.idPrestservic;
					}

	public void setIdPrestservic(Long idPrestservic) {
						this.idPrestservic = idPrestservic;
					}
	
	public Long getIdModalidad() {
						return this.idModalidad;
					}

	public void setIdModalidad(Long idModalidad) {
						this.idModalidad = idModalidad;
					}
	
	public Long getIdUsuinterno() {
						return this.idUsuinterno;
					}

	public void setIdUsuinterno(Long idUsuinterno) {
						this.idUsuinterno = idUsuinterno;
					}
	
	
public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
					}
public String getRazSocial() {
						return this.razSocial;
					}

	public void setRazSocial(String razSocial) {
						this.razSocial = razSocial;
					}

	public Long getIdOrigen() {
						return this.idOrigen;
					}

	public void setIdOrigen(Long idOrigen) {
						this.idOrigen = idOrigen;
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
	
	public Long getIdCargo() {
						return this.idCargo;
					}

	public void setIdCargo(Long idCargo) {
						this.idCargo = idCargo;
					}
	
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	
	public String getCorreoUsuext() {
						return this.correoUsuext;
					}

	public void setCorreoUsuext(String correoUsuext) {
						this.correoUsuext = correoUsuext;
					}
	
	public String getFijoUsuext() {
						return this.fijoUsuext;
					}

	public void setFijoUsuext(String fijoUsuext) {
						this.fijoUsuext = fijoUsuext;
					}
	
	public String getCelularUsuext() {
						return this.celularUsuext;
					}

	public void setCelularUsuext(String celularUsuext) {
						this.celularUsuext = celularUsuext;
					}
	
	public Timestamp getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}
	public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public java.util.Date getFechaFinalizacionJUD() {
		java.util.Date fechaFinalizacionJUD = null;
		if (fechaFinalizacion != null)
			fechaFinalizacionJUD = new java.util.Date(fechaFinalizacion.getTime());
		return fechaFinalizacionJUD;
	}
	public void setFechaFinalizacionJUD(java.util.Date fechaFinalizacionJUD) {
		if (fechaFinalizacionJUD != null)
			this.fechaFinalizacion = new Timestamp(fechaFinalizacionJUD.getTime());
		else
			this.fechaFinalizacion = null;
	}	
	
	public Timestamp getFechaSoli() {
		return this.fechaSoli;
	}
	public void setFechaSoli(Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}
	public java.util.Date getFechaSoliJUD() {
		java.util.Date fechaSoliJUD = null;
		if (fechaSoli != null)
			fechaSoliJUD = new java.util.Date(fechaSoli.getTime());
		return fechaSoliJUD;
	}
	public void setFechaSoliJUD(java.util.Date fechaSoliJUD) {
		if (fechaSoliJUD != null)
			this.fechaSoli = new Timestamp(fechaSoliJUD.getTime());
		else
			this.fechaSoli = null;
	}	
	
	
	
	public String getIdUsuexternoTxt() {
		return this.idUsuexternoTxt;
	}
	public void setIdUsuexternoTxt(String idUsuexternoTxt) {
		this.idUsuexternoTxt = idUsuexternoTxt;
	}
	public String getIdSistAdmTxt() {
		return this.idSistAdmTxt;
	}
	public void setIdSistAdmTxt(String idSistAdmTxt) {
		this.idSistAdmTxt = idSistAdmTxt;
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
	public String getIdPrestservicTxt() {
		return this.idPrestservicTxt;
	}
	public void setIdPrestservicTxt(String idPrestservicTxt) {
		this.idPrestservicTxt = idPrestservicTxt;
	}
	public String getIdModalidadTxt() {
		return this.idModalidadTxt;
	}
	public void setIdModalidadTxt(String idModalidadTxt) {
		this.idModalidadTxt = idModalidadTxt;
	}
	public String getIdUsuinternoTxt() {
		return this.idUsuinternoTxt;
	}
	public void setIdUsuinternoTxt(String idUsuinternoTxt) {
		this.idUsuinternoTxt = idUsuinternoTxt;
	}
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}
	public String getIdOrigenTxt() {
		return this.idOrigenTxt;
	}
	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}
	public String getIdCargoTxt() {
		return this.idCargoTxt;
	}
	public void setIdCargoTxt(String idCargoTxt) {
		this.idCargoTxt = idCargoTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
		
	
	public DtConsultasACL getDtConsultasACL() {
		return dtConsultasACL;
	}

	public void setDtConsultasACL(DtConsultasACL dtConsultasACL) {
		this.dtConsultasACL = dtConsultasACL;
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
