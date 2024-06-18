package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsSedesACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * MS_SEDES BAKING: LISTA LAS SEDES REGISTRADAS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class MsSedesBk implements java.io.Serializable {

	//ID
	private Long idSede;
		
	//PROPIEDADES
	private String sede = null;
	private Long idGrupo = null;
	private Long idMacregion = null;
	private String sigla = null;
	private Integer codDpto = null;
	private String direccion = null;
	private Long orden = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Integer flagvisible = null;
	private Integer flagvisiblerpte = null;
	
	
	//ADICIONALES
	private String idGrupoTxt = null;
	private String idMacregionTxt = null;
	private String codDptoTxt = null;
	private String estadoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idpaisTxt = null;
	
	private MsSedesACL msSedesACL = null;		
		
	public MsSedesBk() {
	}
	
	public Long getIdSede() {
		return this.idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}
	
	public String getSede() {
						return this.sede;
					}

	public void setSede(String sede) {
						this.sede = sede;
					}
	
	public Long getIdGrupo() {
						return this.idGrupo;
					}

	public void setIdGrupo(Long idGrupo) {
						this.idGrupo = idGrupo;
					}
	
	public Long getIdMacregion() {
						return this.idMacregion;
					}

	public void setIdMacregion(Long idMacregion) {
						this.idMacregion = idMacregion;
					}
	
	public String getSigla() {
						return this.sigla;
					}

	public void setSigla(String sigla) {
						this.sigla = sigla;
					}
	
	public Integer getCodDpto() {
						return this.codDpto;
					}

	public void setCodDpto(Integer codDpto) {
						this.codDpto = codDpto;
					}
	
	public String getDireccion() {
						return this.direccion;
					}

	public void setDireccion(String direccion) {
						this.direccion = direccion;
					}
	
	public Long getOrden() {
						return this.orden;
					}

	public void setOrden(Long orden) {
						this.orden = orden;
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
	
	public Integer getFlagvisible() {
						return this.flagvisible;
					}

	public void setFlagvisible(Integer flagvisible) {
						this.flagvisible = flagvisible;
					}
	
	public Integer getFlagvisiblerpte() {
						return this.flagvisiblerpte;
					}

	public void setFlagvisiblerpte(Integer flagvisiblerpte) {
						this.flagvisiblerpte = flagvisiblerpte;
					}
	
	
	
	public String getIdGrupoTxt() {
		return this.idGrupoTxt;
	}
	public void setIdGrupoTxt(String idGrupoTxt) {
		this.idGrupoTxt = idGrupoTxt;
	}
	public String getIdMacregionTxt() {
		return this.idMacregionTxt;
	}
	public void setIdMacregionTxt(String idMacregionTxt) {
		this.idMacregionTxt = idMacregionTxt;
	}
	public String getCodDptoTxt() {
		return this.codDptoTxt;
	}
	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
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
		
	
	public MsSedesACL getMsSedesACL() {
		return msSedesACL;
	}

	public void setMsSedesACL(MsSedesACL msSedesACL) {
		this.msSedesACL = msSedesACL;
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
