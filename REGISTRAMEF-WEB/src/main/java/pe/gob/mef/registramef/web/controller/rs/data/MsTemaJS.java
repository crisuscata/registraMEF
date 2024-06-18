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
public class MsTemaJS implements java.io.Serializable {

	// ID
	private Long idTema;

	// PROPIEDADES
	private String descripcion = null;
	private Long idSistAdmi = null;
	private Long tipoServicio = null;
	
	
	// ADICIONALES
	private String idSistAdmiTxt = null;
	private String estadoTxt = null;
	private String tipoServicioTxt = null;
	
	private Integer editopcion = 1;

	public MsTemaJS() {
	}

	public Long getIdTema() {
		return this.idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	public Long getTipoServicio() {
						return this.tipoServicio;
					}

	public void setTipoServicio(Long tipoServicio) {
						this.tipoServicio = tipoServicio;
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
	public String getTipoServicioTxt() {
		return this.tipoServicioTxt;
	}
	public void setTipoServicioTxt(String tipoServicioTxt) {
		this.tipoServicioTxt = tipoServicioTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}			
}
