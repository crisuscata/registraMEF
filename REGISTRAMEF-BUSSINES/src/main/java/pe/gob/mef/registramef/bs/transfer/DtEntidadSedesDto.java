package pe.gob.mef.registramef.bs.transfer;

/**
 * DtEntidadSedes: Lista De Las Distintas Sedes Asignadas A La Entidad
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37 / Creación de la clase
 *          /
 * 
 */
public class DtEntidadSedesDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4182699500241874760L;

	// ID
	private Long idEntiSed;

	// PROPIEDADES
	private Long idEntidad = null;
	private Long idSede = null;

	// ADICIONALES
	private String idSedeTxt = null;
	
	private Integer editopcion = 1;

	public DtEntidadSedesDto() {
	}

	public Long getIdEntiSed() {
		return this.idEntiSed;
	}

	public void setIdEntiSed(Long idEntiSed) {
		this.idEntiSed = idEntiSed;
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
	
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	
	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}
}
