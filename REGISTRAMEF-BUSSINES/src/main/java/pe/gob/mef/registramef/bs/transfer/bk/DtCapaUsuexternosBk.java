package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtCapaUsuexternosACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CAPA_USUEXTERNOS BAKING: LISTA DE LOS PARTICIPANTES QUE ASISTEN A LA CAPACITACIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtCapaUsuexternosBk implements java.io.Serializable {

	//ID
	private Long idCapaUsuext;
		
	//PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idCapacitacion = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idUsuexterno = null;
	private String nombre = null;
	private Long idCargoUsuext = null;
	private Long idEntidad = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	private Long flagMedioreg = null;
	private Long flagAsistencia = null;
	private Long flagConfirReg = null;
	private Timestamp fechaFlagConfirReg = null;
	private Timestamp fechaFlagAsistencia = null;
	
	
	//ADICIONALES
	private String idCapacitacionTxt = null;
	private String estadoTxt = null;
	private String idUsuexternoTxt = null;
	private String idCargoUsuextTxt = null;
	private String idEntidadTxt = null;
	//INICIO CUSCATA - 07082024
	private String numDocu = null;
	private String aPaterno = null;
	private String aMaterno = null;
	private String nombresApellidos = null;
	private String codEjecutora = null;
	private Long idCargo = null;
	private String idCargoTxt = null;
	//FIN CUSCATA - 07082024
	
	private DtCapaUsuexternosACL dtCapaUsuexternosACL = null;		
		
	public DtCapaUsuexternosBk() {
	}
	
	public Long getIdCapaUsuext() {
		return this.idCapaUsuext;
	}

	public void setIdCapaUsuext(Long idCapaUsuext) {
		this.idCapaUsuext = idCapaUsuext;
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
	
	public Long getIdCapacitacion() {
						return this.idCapacitacion;
					}

	public void setIdCapacitacion(Long idCapacitacion) {
						this.idCapacitacion = idCapacitacion;
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

	public Long getIdCargoUsuext() {
						return this.idCargoUsuext;
					}

	public void setIdCargoUsuext(Long idCargoUsuext) {
						this.idCargoUsuext = idCargoUsuext;
					}
	
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
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
	
	public Long getFlagMedioreg() {
						return this.flagMedioreg;
					}

	public void setFlagMedioreg(Long flagMedioreg) {
						this.flagMedioreg = flagMedioreg;
					}
	
	public Long getFlagAsistencia() {
						return this.flagAsistencia;
					}

	public void setFlagAsistencia(Long flagAsistencia) {
						this.flagAsistencia = flagAsistencia;
					}
	
	public Long getFlagConfirReg() {
						return this.flagConfirReg;
					}

	public void setFlagConfirReg(Long flagConfirReg) {
						this.flagConfirReg = flagConfirReg;
					}
	
	public Timestamp getFechaFlagConfirReg() {
		return this.fechaFlagConfirReg;
	}
	public void setFechaFlagConfirReg(Timestamp fechaFlagConfirReg) {
		this.fechaFlagConfirReg = fechaFlagConfirReg;
	}
	public java.util.Date getFechaFlagConfirRegJUD() {
		java.util.Date fechaFlagConfirRegJUD = null;
		if (fechaFlagConfirReg != null)
			fechaFlagConfirRegJUD = new java.util.Date(fechaFlagConfirReg.getTime());
		return fechaFlagConfirRegJUD;
	}
	public void setFechaFlagConfirRegJUD(java.util.Date fechaFlagConfirRegJUD) {
		if (fechaFlagConfirRegJUD != null)
			this.fechaFlagConfirReg = new Timestamp(fechaFlagConfirRegJUD.getTime());
		else
			this.fechaFlagConfirReg = null;
	}	
	
	public Timestamp getFechaFlagAsistencia() {
		return this.fechaFlagAsistencia;
	}
	public void setFechaFlagAsistencia(Timestamp fechaFlagAsistencia) {
		this.fechaFlagAsistencia = fechaFlagAsistencia;
	}
	public java.util.Date getFechaFlagAsistenciaJUD() {
		java.util.Date fechaFlagAsistenciaJUD = null;
		if (fechaFlagAsistencia != null)
			fechaFlagAsistenciaJUD = new java.util.Date(fechaFlagAsistencia.getTime());
		return fechaFlagAsistenciaJUD;
	}
	public void setFechaFlagAsistenciaJUD(java.util.Date fechaFlagAsistenciaJUD) {
		if (fechaFlagAsistenciaJUD != null)
			this.fechaFlagAsistencia = new Timestamp(fechaFlagAsistenciaJUD.getTime());
		else
			this.fechaFlagAsistencia = null;
	}	
	
	
	
	public String getIdCapacitacionTxt() {
		return this.idCapacitacionTxt;
	}
	public void setIdCapacitacionTxt(String idCapacitacionTxt) {
		this.idCapacitacionTxt = idCapacitacionTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdUsuexternoTxt() {
		return this.idUsuexternoTxt;
	}
	public void setIdUsuexternoTxt(String idUsuexternoTxt) {
		this.idUsuexternoTxt = idUsuexternoTxt;
	}
	public String getIdCargoUsuextTxt() {
		return this.idCargoUsuextTxt;
	}
	public void setIdCargoUsuextTxt(String idCargoUsuextTxt) {
		this.idCargoUsuextTxt = idCargoUsuextTxt;
	}
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}
		
	
	public DtCapaUsuexternosACL getDtCapaUsuexternosACL() {
		return dtCapaUsuexternosACL;
	}

	public void setDtCapaUsuexternosACL(DtCapaUsuexternosACL dtCapaUsuexternosACL) {
		this.dtCapaUsuexternosACL = dtCapaUsuexternosACL;
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
//INICIO CUSCATA - 07082024
	public String getNumDocu() {
		return numDocu;
	}

	public void setNumDocu(String numDocu) {
		this.numDocu = numDocu;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getCodEjecutora() {
		return codEjecutora;
	}

	public void setCodEjecutora(String codEjecutora) {
		this.codEjecutora = codEjecutora;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public String getIdCargoTxt() {
		return idCargoTxt;
	}

	public void setIdCargoTxt(String idCargoTxt) {
		this.idCargoTxt = idCargoTxt;
	}
//FIN CUSCATA - 07082024	
}
