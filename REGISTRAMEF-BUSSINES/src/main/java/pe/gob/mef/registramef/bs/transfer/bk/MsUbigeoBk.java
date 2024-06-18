package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsUbigeoACL;
import pe.gob.mef.registramef.bs.domain.MsUbigeoId;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_UBIGEO BAKING: LISTA EL UBIGEO (DEPARTAMENTO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27 / Creación de la clase
 *          /
 * 
 */
public class MsUbigeoBk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7012661740911947251L;

	// ID
	private MsUbigeoId id;

	// PROPIEDADES
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private String descripcion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idubigeo = null;

	// ADICIONALES
	private String estadoTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idTxt=null;
	private Integer tipo = null;
	private String tipoTxt = null;
	
	private MsUbigeoACL msUbigeoACL = null;

	public MsUbigeoBk() {
	}

	public MsUbigeoId getId() {
		return this.id;
	}

	public void setId(MsUbigeoId id) {
		this.id = id;
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

	public Timestamp getFechaCrea() {
		return this.fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public java.util.Date getFechaCreaJUD() {
		java.util.Date fechaCreaJUD = null;
		if (fechaCrea != null)
			fechaCreaJUD = new java.util.Date(fechaCrea.getTime());
		return fechaCreaJUD;
	}

	public void setFechaCreaJUD(java.util.Date fechaCreaJUD) {
		if (fechaCreaJUD != null)
			this.fechaCrea = new Timestamp(fechaCreaJUD.getTime());
		else
			this.fechaCrea = null;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Long getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(Long idubigeo) {
		this.idubigeo = idubigeo;
	}

	public MsUbigeoACL getMsUbigeoACL() {
		return msUbigeoACL;
	}

	public void setMsUbigeoACL(MsUbigeoACL msUbigeoACL) {
		this.msUbigeoACL = msUbigeoACL;
	}

	public String getCclase() {
		if (estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			return "cverde";
		} else {

		}
		return "camarillo";
	}

	public void setCclase(String cclase) {
	}

	public String getCestado() {
		if (estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			return "Activo";
		} else {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MsUbigeoBk other = (MsUbigeoBk) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getEstadoTxt() {
		if (estadoTxt==null && estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			estadoTxt="Activo";
		} else {
			if (estadoTxt==null && estado != null) 
			     estadoTxt="Eliminado";
		}
		return estadoTxt;
	}

	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}

	public String getCodDptoTxt() {
		return codDptoTxt;
	}

	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
	}

	public String getCodProvTxt() {
		return codProvTxt;
	}

	public void setCodProvTxt(String codProvTxt) {
		this.codProvTxt = codProvTxt;
	}

	public String getCodDistrTxt() {
		return codDistrTxt;
	}

	public void setCodDistrTxt(String codDistrTxt) {
		this.codDistrTxt = codDistrTxt;
	}
	
	public String getIdTxt() {
		if(idTxt==null){
			idTxt = id==null?"000000":id.toString();
		}
		return idTxt;
	}

	public void setIdTxt(String idTxt) {
		this.idTxt = idTxt;
	}
	
	public Integer getTipo() {
		if(tipo==null){
			if(id!=null){
				if(id.getCodDistr()!=null && id.getCodDistr().intValue()>0){
					tipo=3;
				}else if(id.getCodProv()!=null && id.getCodProv().intValue()>0){
					tipo=2;
				}else if(id.getCodDpto()!=null && id.getCodDpto().intValue()>0){
					tipo=1;
				}
			}
		}
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTipoTxt() {
		if(tipoTxt==null){
			if(id!=null){
				if(id.getCodDistr()!=null && id.getCodDistr().intValue()>0){
					tipoTxt="Distrito";
				}else if(id.getCodProv()!=null && id.getCodProv().intValue()>0){
					tipoTxt="Provincia";
				}else if(id.getCodDpto()!=null && id.getCodDpto().intValue()>0){
					tipoTxt="Departamento";
				}
			}
		}
		return tipoTxt;
	}

	public void setTipoTxt(String tipoTxt) {
		this.tipoTxt = tipoTxt;
	}
}
