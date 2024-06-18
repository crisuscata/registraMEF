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
public class DtEncuestaJS implements java.io.Serializable {

	// ID
	private Integer idEncuesta;

	// PROPIEDADES
	private Long tipoServicio = null;
	private Timestamp fechaInicio = null;
	private Timestamp fechaFin = null;
	private Long flagBloqueo = null;
	private Long idOrigen = null;
	private Long idPrestacion = null;
	
	
	// ADICIONALES
	private String idOrigenTxt = null;
	private String idPrestacionTxt = null;
	
	private Integer editopcion = 1;

	public DtEncuestaJS() {
	}

	public Integer getIdEncuesta() {
		return this.idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	
	public Long getTipoServicio() {
						return this.tipoServicio;
					}

	public void setTipoServicio(Long tipoServicio) {
						this.tipoServicio = tipoServicio;
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
	public Long getFlagBloqueo() {
						return this.flagBloqueo;
					}

	public void setFlagBloqueo(Long flagBloqueo) {
						this.flagBloqueo = flagBloqueo;
					}
	public Long getIdOrigen() {
						return this.idOrigen;
					}

	public void setIdOrigen(Long idOrigen) {
						this.idOrigen = idOrigen;
					}
	public Long getIdPrestacion() {
						return this.idPrestacion;
					}

	public void setIdPrestacion(Long idPrestacion) {
						this.idPrestacion = idPrestacion;
					}
	
	
	public String getIdOrigenTxt() {
		return this.idOrigenTxt;
	}
	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}
	public String getIdPrestacionTxt() {
		return this.idPrestacionTxt;
	}
	public void setIdPrestacionTxt(String idPrestacionTxt) {
		this.idPrestacionTxt = idPrestacionTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
