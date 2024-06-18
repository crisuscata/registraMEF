package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * MSUSUARIOS BAKING: USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37  / Creación de la clase /
 * 
 */
@XmlRootElement
public class DtAmpliacionFechaJS implements java.io.Serializable {

	// ID
	private Long idAutorizacion;

	// PROPIEDADES
	private Long tipoFechaCorte = null;
	private Long idSede = null;
	private Long idSistAdmi = null;
	private Timestamp fechaInicio = null;
	private Timestamp fechaFin = null;
	
	
	// ADICIONALES
	private String tipoFechaCorteTxt = null;
	private String idSedeTxt = null;
	private String idSistAdmiTxt = null;
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public DtAmpliacionFechaJS() {
	}

	public Long getIdAutorizacion() {
		return this.idAutorizacion;
	}

	public void setIdAutorizacion(Long idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	
	public Long getTipoFechaCorte() {
						return this.tipoFechaCorte;
					}

	public void setTipoFechaCorte(Long tipoFechaCorte) {
						this.tipoFechaCorte = tipoFechaCorte;
					}
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public java.util.Date getFechaInicioJUD() {
		java.util.Date fechaInicioJUD = null;
		if (fechaInicio != null)
			fechaInicioJUD = new java.util.Date(fechaInicio.getTime());
		return fechaInicioJUD;
	}
	public void setFechaInicioJUD(java.util.Date fechaInicioJUD) {
		if (fechaInicioJUD != null)
			this.fechaInicio = new Timestamp(fechaInicioJUD.getTime());
		else
			this.fechaInicio = null;
	}	
	public Timestamp getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public java.util.Date getFechaFinJUD() {
		java.util.Date fechaFinJUD = null;
		if (fechaFin != null)
			fechaFinJUD = new java.util.Date(fechaFin.getTime());
		return fechaFinJUD;
	}
	public void setFechaFinJUD(java.util.Date fechaFinJUD) {
		if (fechaFinJUD != null)
			this.fechaFin = new Timestamp(fechaFinJUD.getTime());
		else
			this.fechaFin = null;
	}	
	
	
	public String getTipoFechaCorteTxt() {
		return this.tipoFechaCorteTxt;
	}
	public void setTipoFechaCorteTxt(String tipoFechaCorteTxt) {
		this.tipoFechaCorteTxt = tipoFechaCorteTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
