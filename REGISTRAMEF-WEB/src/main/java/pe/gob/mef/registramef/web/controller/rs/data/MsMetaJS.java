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
public class MsMetaJS implements java.io.Serializable {

	// ID
	private Long idMeta;

	// PROPIEDADES
	private Integer annio = null;
	private Long idTipoServicio = null;
	private Long idSistAdmi = null;
	private Long idSede = null;
	private Long valor = null;
	
	
	// ADICIONALES
	private String idTipoServicioTxt = null;
	private String idSistAdmiTxt = null;
	private String idSedeTxt = null;
	
	private Integer editopcion = 1;

	public MsMetaJS() {
	}

	public Long getIdMeta() {
		return this.idMeta;
	}

	public void setIdMeta(Long idMeta) {
		this.idMeta = idMeta;
	}
	
	public Integer getAnnio() {
						return this.annio;
					}

	public void setAnnio(Integer annio) {
						this.annio = annio;
					}
	public Long getIdTipoServicio() {
						return this.idTipoServicio;
					}

	public void setIdTipoServicio(Long idTipoServicio) {
						this.idTipoServicio = idTipoServicio;
					}
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	public Long getValor() {
						return this.valor;
					}

	public void setValor(Long valor) {
						this.valor = valor;
					}
	
	
	public String getIdTipoServicioTxt() {
		return this.idTipoServicioTxt;
	}
	public void setIdTipoServicioTxt(String idTipoServicioTxt) {
		this.idTipoServicioTxt = idTipoServicioTxt;
	}
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
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
