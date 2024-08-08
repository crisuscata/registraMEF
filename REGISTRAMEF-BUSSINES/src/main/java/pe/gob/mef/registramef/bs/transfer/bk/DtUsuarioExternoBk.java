package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.ctlracceso.DtUsuarioExternoACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_USUARIO_EXTERNO BAKING: LISTA DE LOS USUARIOS EXTERNOS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtUsuarioExternoBk implements java.io.Serializable {

	//ID
	private Long idUsuexterno;
		
	//PROPIEDADES
	private String apaterno = null;
	private String amaterno = null;
	private String nombre = null;
	private String nombresCompletos=null;//CUSCATA - 18062024
	private Long numDocu = null;
	private String correo = null;
	private Long telefFijo = null;
	private Long telefCell = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private String direccion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private String sexo = null;
	private Long idTipodocumento = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private String otroTelefono = null;
	private String otroCelular = null;
	private String numDocum = null;
	private Long flagMedioreg = null;
	//PURIBE 22042024 - INICIO
	private String nombreEntidad = null;
	private String ejecutorEntidad = null;
	//PURIBE 22042024 - FIN
	
	
	//ADICIONALES
	private String estadoTxt = null;
	private String idTipodocumentoTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idpaisTxt = null;
	private List<DtCargosUsuexterBk> usucargos;//PURIBE 14032024 - INICIO-->
	//PURIBE 14032024 - INICIO-->
	//INICIO CUSCATA - 07082024
	private Long idEntidad = null;
	private String idEntidadTxt = null;
	private String codEjecutora = null;
    //FIN CUSCATA - 07082024
	
	public List<DtCargosUsuexterBk> getUsucargos() {
		return usucargos;
	}

	public void setUsucargos(List<DtCargosUsuexterBk> usucargos) {
		this.usucargos = usucargos;
	}
	//PURIBE 14032024 - FIN-->
	
	private DtUsuarioExternoACL dtUsuarioExternoACL = null;		
		
	public DtUsuarioExternoBk() {
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
	
	public Long getNumDocu() {
						return this.numDocu;
					}

	public void setNumDocu(Long numDocu) {
						this.numDocu = numDocu;
					}
	
	public String getCorreo() {
						return this.correo;
					}

	public void setCorreo(String correo) {
						this.correo = correo;
					}
	
	public Long getTelefFijo() {
						return this.telefFijo;
					}

	public void setTelefFijo(Long telefFijo) {
						this.telefFijo = telefFijo;
					}
	
	public Long getTelefCell() {
						return this.telefCell;
					}

	public void setTelefCell(Long telefCell) {
						this.telefCell = telefCell;
					}
	
	public Timestamp getFechaModif() {
		return this.fechaModif;
	}
	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}
	public java.util.Date getFechaModifJUD() {
		java.util.Date fechaModifJUD = null;
		if (fechaModif != null)
			fechaModifJUD = new java.util.Date(fechaModif.getTime());
		return fechaModifJUD;
	}
	public void setFechaModifJUD(java.util.Date fechaModifJUD) {
		if (fechaModifJUD != null)
			this.fechaModif = new Timestamp(fechaModifJUD.getTime());
		else
			this.fechaModif = null;
	}	
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	public String getDireccion() {
						return this.direccion;
					}

	public void setDireccion(String direccion) {
						this.direccion = direccion;
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
	
	public String getSexo() {
						return this.sexo;
					}

	public void setSexo(String sexo) {
						this.sexo = sexo;
					}
	
	public Long getIdTipodocumento() {
						return this.idTipodocumento;
					}

	public void setIdTipodocumento(Long idTipodocumento) {
						this.idTipodocumento = idTipodocumento;
					}
	
	public Integer getCodDpto() {
						return this.codDpto;
					}

	public void setCodDpto(Integer codDpto) {
						this.codDpto = codDpto;
					}
	
	public Integer getCodProv() {
						return this.codProv;
					}

	public void setCodProv(Integer codProv) {
						this.codProv = codProv;
					}
	
	public Integer getCodDistr() {
						return this.codDistr;
					}

	public void setCodDistr(Integer codDistr) {
						this.codDistr = codDistr;
					}
	
	public Long getIdpais() {
						return this.idpais;
					}

	public void setIdpais(Long idpais) {
						this.idpais = idpais;
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
	
	public String getOtroTelefono() {
						return this.otroTelefono;
					}

	public void setOtroTelefono(String otroTelefono) {
						this.otroTelefono = otroTelefono;
					}
	
	public String getOtroCelular() {
						return this.otroCelular;
					}

	public void setOtroCelular(String otroCelular) {
						this.otroCelular = otroCelular;
					}
	
	public String getNumDocum() {
						return this.numDocum;
					}

	public void setNumDocum(String numDocum) {
						this.numDocum = numDocum;
					}
	
	public Long getFlagMedioreg() {
						return this.flagMedioreg;
					}

	public void setFlagMedioreg(Long flagMedioreg) {
						this.flagMedioreg = flagMedioreg;
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
	public String getIdTipodocumentoTxt() {
		return this.idTipodocumentoTxt;
	}
	public void setIdTipodocumentoTxt(String idTipodocumentoTxt) {
		this.idTipodocumentoTxt = idTipodocumentoTxt;
	}
	public String getCodDptoTxt() {
		return this.codDptoTxt;
	}
	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
	}
	public String getCodProvTxt() {
		return this.codProvTxt;
	}
	public void setCodProvTxt(String codProvTxt) {
		this.codProvTxt = codProvTxt;
	}
	public String getCodDistrTxt() {
		return this.codDistrTxt;
	}
	public void setCodDistrTxt(String codDistrTxt) {
		this.codDistrTxt = codDistrTxt;
	}
	public String getIdpaisTxt() {
		return this.idpaisTxt;
	}
	public void setIdpaisTxt(String idpaisTxt) {
		this.idpaisTxt = idpaisTxt;
	}
		
	
	public DtUsuarioExternoACL getDtUsuarioExternoACL() {
		return dtUsuarioExternoACL;
	}

	public void setDtUsuarioExternoACL(DtUsuarioExternoACL dtUsuarioExternoACL) {
		this.dtUsuarioExternoACL = dtUsuarioExternoACL;
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
	
	//PURIBE 22042024 - INICIO-->
		public String getNombreEntidad() {
			return nombreEntidad;
		}

		public void setNombreEntidad(String nombreEntidad) {
			this.nombreEntidad = nombreEntidad;
		}

		public String getEjecutorEntidad() {
			return ejecutorEntidad;
		}

		public void setEjecutorEntidad(String ejecutorEntidad) {
			this.ejecutorEntidad = ejecutorEntidad;
		}
		
		public String getNombreCompleto(){
			return (getApaterno() != null ? " " + getApaterno() : "")
			+ (getAmaterno() != null ? " " + getAmaterno() : "")
			+ (getNombre() != null ? " " + getNombre() : "") ;
		}
		
		//PURIBE 22042024 - FIN-->
		
		//INICIO CUSCATA - 18062024
		public String getNombresCompletos() {
			return nombresCompletos;
		}

		public void setNombresCompletos(String nombresCompletos) {
			this.nombresCompletos = nombresCompletos;
		}

		public String getAmaterno() {
			return amaterno;
		}

		public void setAmaterno(String amaterno) {
			this.amaterno = amaterno;
		}

		public String getApaterno() {
			return apaterno;
		}

		public void setApaterno(String apaterno) {
			this.apaterno = apaterno;
		}
	//FIN CUSCATA - 18062024
//INICIO CUSCATA - 07082024
		public Long getIdEntidad() {
			return idEntidad;
		}

		public void setIdEntidad(Long idEntidad) {
			this.idEntidad = idEntidad;
		}

		public String getIdEntidadTxt() {
			return idEntidadTxt;
		}

		public void setIdEntidadTxt(String idEntidadTxt) {
			this.idEntidadTxt = idEntidadTxt;
		}

		public String getCodEjecutora() {
			return codEjecutora;
		}

		public void setCodEjecutora(String codEjecutora) {
			this.codEjecutora = codEjecutora;
		}
//FIN CUSCATA - 07082024
}
