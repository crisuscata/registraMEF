package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.ctlracceso.DtAsistenciaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ASISTENCIA BAKING: LISTA DE LOS DATOS REGISTRADOS EN UNA ASISTENCIA TECNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtAsistenciaBk implements java.io.Serializable {

	//ID
	private Long idAsistencia;
		
	//PROPIEDADES
	private Long idEntidad = null;
	private Long idSede = null;
	private Timestamp fechaAsistencia = null;
	private Long idUsuinterno = null;
	private Long idSistAdm = null;
	private Long idOrigen = null;
	private Long idProgramacion = null;
	private Long estado = null;
	private String detalle = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idModalidad = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaProgramada = null;
	private Timestamp fechaSoli = null;
	
	
	//ADICIONALES
	private String idEntidadTxt = null;
	private String idSedeTxt = null;
	private String idUsuinternoTxt = null;
	private String idSistAdmTxt = null;
	private String idOrigenTxt = null;
	private String idProgramacionTxt = null;
	private String estadoTxt = null;
	private String idModalidadTxt = null;
	private String idFinanciaTxt = null;
	
	private DtAsistenciaACL dtAsistenciaACL = null;		
	
	//MPINARES 24012023 - INICIO
		private List<DtAsistenciaTemasBk> dtAsistenciaTemasBkJSss = null;
		private String codEjecutora = null;
		private List<String> dniUser = null;
		private List<String> usuExt = null;
		private List<String> dniUserTxt = null;
		private List<String> usuExtTxt = null;
		private boolean vistaProgramado = false;
		private boolean checked = false;
		private boolean finalizado = false;
		private boolean anulado = false;
		//MPINARES 24012023 - FIN
		
		private List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuariosBkJSss = null;//CUSCATA - 18062024
		private DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk=null;//CUSCATA - 18062024
		private List<DtAnexoBk> dtAnexosBKJSss = null;
		
	public DtAsistenciaBk() {
	}
	
	public Long getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
					}
	
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	
	public Timestamp getFechaAsistencia() {
		return this.fechaAsistencia;
	}
	public void setFechaAsistencia(Timestamp fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}
	public java.util.Date getFechaAsistenciaJUD() {
		java.util.Date fechaAsistenciaJUD = null;
		if (fechaAsistencia != null)
			fechaAsistenciaJUD = new java.util.Date(fechaAsistencia.getTime());
		return fechaAsistenciaJUD;
	}
	public void setFechaAsistenciaJUD(java.util.Date fechaAsistenciaJUD) {
		if (fechaAsistenciaJUD != null)
			this.fechaAsistencia = new Timestamp(fechaAsistenciaJUD.getTime());
		else
			this.fechaAsistencia = null;
	}	
	
	public Long getIdUsuinterno() {
						return this.idUsuinterno;
					}

	public void setIdUsuinterno(Long idUsuinterno) {
						this.idUsuinterno = idUsuinterno;
					}
	
	public Long getIdSistAdm() {
						return this.idSistAdm;
					}

	public void setIdSistAdm(Long idSistAdm) {
						this.idSistAdm = idSistAdm;
					}
	
	public Long getIdOrigen() {
						return this.idOrigen;
					}

	public void setIdOrigen(Long idOrigen) {
						this.idOrigen = idOrigen;
					}
	
	public Long getIdProgramacion() {
						return this.idProgramacion;
					}

	public void setIdProgramacion(Long idProgramacion) {
						this.idProgramacion = idProgramacion;
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
	
	public Long getIdModalidad() {
						return this.idModalidad;
					}

	public void setIdModalidad(Long idModalidad) {
						this.idModalidad = idModalidad;
					}
	
	public Long getIdFinancia() {
						return this.idFinancia;
					}

	public void setIdFinancia(Long idFinancia) {
						this.idFinancia = idFinancia;
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
	
	public Timestamp getFechaProgramada() {
		return this.fechaProgramada;
	}
	public void setFechaProgramada(Timestamp fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public java.util.Date getFechaProgramadaJUD() {
		java.util.Date fechaProgramadaJUD = null;
		if (fechaProgramada != null)
			fechaProgramadaJUD = new java.util.Date(fechaProgramada.getTime());
		return fechaProgramadaJUD;
	}
	public void setFechaProgramadaJUD(java.util.Date fechaProgramadaJUD) {
		if (fechaProgramadaJUD != null)
			this.fechaProgramada = new Timestamp(fechaProgramadaJUD.getTime());
		else
			this.fechaProgramada = null;
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
	
	
	
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getIdUsuinternoTxt() {
		return this.idUsuinternoTxt;
	}
	public void setIdUsuinternoTxt(String idUsuinternoTxt) {
		this.idUsuinternoTxt = idUsuinternoTxt;
	}
	public String getIdSistAdmTxt() {
		return this.idSistAdmTxt;
	}
	public void setIdSistAdmTxt(String idSistAdmTxt) {
		this.idSistAdmTxt = idSistAdmTxt;
	}
	public String getIdOrigenTxt() {
		return this.idOrigenTxt;
	}
	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}
	public String getIdProgramacionTxt() {
		return this.idProgramacionTxt;
	}
	public void setIdProgramacionTxt(String idProgramacionTxt) {
		this.idProgramacionTxt = idProgramacionTxt;
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
	public String getIdModalidadTxt() {
		return this.idModalidadTxt;
	}
	public void setIdModalidadTxt(String idModalidadTxt) {
		this.idModalidadTxt = idModalidadTxt;
	}
	public String getIdFinanciaTxt() {
		return this.idFinanciaTxt;
	}
	public void setIdFinanciaTxt(String idFinanciaTxt) {
		this.idFinanciaTxt = idFinanciaTxt;
	}
		
	
	public DtAsistenciaACL getDtAsistenciaACL() {
		return dtAsistenciaACL;
	}

	public void setDtAsistenciaACL(DtAsistenciaACL dtAsistenciaACL) {
		this.dtAsistenciaACL = dtAsistenciaACL;
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
        
      //MPINARES 24012023 - INICIO
      		public List<DtAsistenciaTemasBk> getDtAsistenciaTemasBkJSss() {
      			return dtAsistenciaTemasBkJSss;
      		}

      		public void setDtAsistenciaTemasBkJSss(List<DtAsistenciaTemasBk> dtAsistenciaTemasBkJSss) {
      			this.dtAsistenciaTemasBkJSss = dtAsistenciaTemasBkJSss;
      		}

      		public String getCodEjecutora() {
      			return codEjecutora;
      		}

      		public void setCodEjecutora(String codEjecutora) {
      			this.codEjecutora = codEjecutora;
      		}

      		public List<String> getDniUser() {
      			return dniUser;
      		}

      		public void setDniUser(List<String> dniUser) {
      			this.dniUser = dniUser;
      		}

      		public List<String> getUsuExt() {
      			return usuExt;
      		}

      		public void setUsuExt(List<String> usuExt) {
      			this.usuExt = usuExt;
      		}
      		
      		public String getUsuExtTxt() {
      			StringBuffer sb = new StringBuffer();
      			if (getUsuExt() != null && getUsuExt().size() > 0) {
      				for (String objeto : getUsuExt()) {
      					sb.append(objeto.toString()+", ").append('\n');
      				}
      			}
      			return sb.toString();
      		}
      		
      		public String getDniUserTxt() {
      			StringBuffer sb = new StringBuffer();
      			if (getDniUser() != null && getDniUser().size() > 0) {
      				for (String objeto : getDniUser()) {
      					sb.append("N°"+objeto.toString()+", ").append('\n');
      				}
      			}
      			return sb.toString();
      		}

      		public boolean isVistaProgramado() {
      			return vistaProgramado;
      		}

      		public void setVistaProgramado(boolean vistaProgramado) {
      			this.vistaProgramado = vistaProgramado;
      		}

      		public boolean isChecked() {
      			return checked;
      		}

      		public void setChecked(boolean checked) {
      			this.checked = checked;
      		}

      		public void setDniUserTxt(List<String> dniUserTxt) {
      			this.dniUserTxt = dniUserTxt;
      		}

      		public void setUsuExtTxt(List<String> usuExtTxt) {
      			this.usuExtTxt = usuExtTxt;
      		}

      		public boolean isFinalizado() {
//      			Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
      			Long estadoFinalizado =Estado.FINALIZADO.getValor();
      			if (estado.longValue()==estadoFinalizado.longValue()){
      				finalizado=true;
      			}
      			return finalizado;
      		}

      		public void setFinalizado(boolean finalizado) {
      			this.finalizado = finalizado;
      		}
      		
      		public boolean isAnulado() {
//      			Long estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
      			Long estadoEliminado = Estado.ELIMINADO.getValor();
      			if (estado==estadoEliminado){
      				anulado=true;
      			}
      			return anulado;
      		}


      		public void setAnulado(boolean anulado) {
      			this.anulado = anulado;
      		}
      		
      		
      		
      		
      		//MPINARES 24012023 - FIN

	public void setEsEliminado(boolean esEliminado) {		
	}
	
	//INICIO CUSCATA - 18062024
		public List<DtAsistenciaUsuexternosBk> getDtAsistenciaUsuariosBkJSss() {
			return dtAsistenciaUsuariosBkJSss;
		}

		public void setDtAsistenciaUsuariosBkJSss(List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuariosBkJSss) {
			this.dtAsistenciaUsuariosBkJSss = dtAsistenciaUsuariosBkJSss;
		}
		
		public String getTemasTxt() {
			StringBuffer sb = new StringBuffer();
			if (getDtAsistenciaTemasBkJSss() != null && getDtAsistenciaTemasBkJSss().size() > 0) {
				for (DtAsistenciaTemasBk objeto : getDtAsistenciaTemasBkJSss()) {
					sb.append(objeto.getIdTemaTxt()+", ").append('\n');
				}
			}
			return sb.toString();
		}
		
		public String getSubtemastTxt() {
			StringBuffer sb = new StringBuffer();
			if (getDtAsistenciaTemasBkJSss() != null && getDtAsistenciaTemasBkJSss().size() > 0) {
				for (DtAsistenciaTemasBk objeto : getDtAsistenciaTemasBkJSss()) {
					sb.append(objeto.getIdSubtemaTxt()+", ").append('\n');
				}
			}
			return sb.toString();
		}

		public DtAsistenciaUsuexternosBk getDtAsistenciaUsuexternosBk() {
			return dtAsistenciaUsuexternosBk;
		}

		public void setDtAsistenciaUsuexternosBk(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk) {
			this.dtAsistenciaUsuexternosBk = dtAsistenciaUsuexternosBk;
		}
		//FIN CUSCATA - 18062024
		
		public List<DtAnexoBk> getDtAnexosBKJSss() {
			return dtAnexosBKJSss;
		}

		public void setDtAnexosBKJSss(List<DtAnexoBk> dtAnexosBKJSss) {
			this.dtAnexosBKJSss = dtAnexosBKJSss;
		}
}
