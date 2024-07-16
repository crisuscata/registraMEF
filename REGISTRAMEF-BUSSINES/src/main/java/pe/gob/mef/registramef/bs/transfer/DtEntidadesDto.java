package pe.gob.mef.registramef.bs.transfer;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadesACL;

/**
 * DT_ENTIDADES BAKING: ALMACENA LAS ENTIDAD REGISTRADAS EN EL SISTEMA "ENTIDADES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
public class DtEntidadesDto implements java.io.Serializable {

	//ID
	private Long idEntidad;
		
	//PROPIEDADES
	private String codEjec = null;
	private String razSocial = null;
	private String direccion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long ruc = null;
	private Long estado = null;
	private Long idTipo = null;
	private Long idCaract = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private Long idSistAdmi = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private String geozona = null;
	
	
	//ADICIONALES
	private String estadoTxt = null;
	private String idTipoTxt = null;
	private String idCaractTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idpaisTxt = null;
	private String idSistAdmiTxt = null;
	private String geozonaTxt = null;
	private String razSocialUbigeo = null;
	
	private DtEntidadesACL dtEntidadesACL = null;		
		
	public DtEntidadesDto() {
	}
	
	public Long getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}
	
	public String getCodEjec() {
						return this.codEjec;
					}

	public void setCodEjec(String codEjec) {
						this.codEjec = codEjec;
					}
	
	public String getRazSocial() {
						return this.razSocial;
					}

	public void setRazSocial(String razSocial) {
						this.razSocial = razSocial;
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
	
	public Timestamp getFechaModif() {
						return this.fechaModif;
					}

	public void setFechaModif(Timestamp fechaModif) {
						this.fechaModif = fechaModif;
					}
	
	public Long getRuc() {
						return this.ruc;
					}

	public void setRuc(Long ruc) {
						this.ruc = ruc;
					}
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	public Long getIdTipo() {
						return this.idTipo;
					}

	public void setIdTipo(Long idTipo) {
						this.idTipo = idTipo;
					}
	
	public Long getIdCaract() {
						return this.idCaract;
					}

	public void setIdCaract(Long idCaract) {
						this.idCaract = idCaract;
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
	
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
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
	
	public String getGeozona() {
						return this.geozona;
					}

	public void setGeozona(String geozona) {
						this.geozona = geozona;
					}
	
	
	
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdTipoTxt() {
		return this.idTipoTxt;
	}
	public void setIdTipoTxt(String idTipoTxt) {
		this.idTipoTxt = idTipoTxt;
	}
	public String getIdCaractTxt() {
		return this.idCaractTxt;
	}
	public void setIdCaractTxt(String idCaractTxt) {
		this.idCaractTxt = idCaractTxt;
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
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}
	public String getGeozonaTxt() {
		return this.geozonaTxt;
	}
	public void setGeozonaTxt(String geozonaTxt) {
		this.geozonaTxt = geozonaTxt;
	}
		
	
	public DtEntidadesACL getDtEntidadesACL() {
		return dtEntidadesACL;
	}

	public void setDtEntidadesACL(DtEntidadesACL dtEntidadesACL) {
		this.dtEntidadesACL = dtEntidadesACL;
	}
	
	public String getCclase(){
		if(estado!=null && estado.intValue()>0){
			return "cverde";
		}else{
			
		}return "camarillo";
	}
       
        public void setCclase(String cclase) {
	}
        
        public String getCestado(){
		if(estado!=null && estado.intValue()>0){
			return "Activo";
		}else{			
		}
		return "Anulado";
	}
         
        public void setCestado(String cestado) {
	}

		public String getRazSocialUbigeo() {
			return razSocialUbigeo;
		}

		public void setRazSocialUbigeo(String razSocialUbigeo) {
			this.razSocialUbigeo = razSocialUbigeo;
		}
        
        

}
