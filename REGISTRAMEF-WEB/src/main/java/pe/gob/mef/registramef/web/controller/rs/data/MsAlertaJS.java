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
public class MsAlertaJS implements java.io.Serializable {

	// ID
	private Long idAlerta;

	// PROPIEDADES
	private Integer dia = null;
	private Integer hora = null;
	private String otrosDestin = null;
	private Long idCaracterst = null;
	
	
	// ADICIONALES
	private String diaTxt = null;
	private String horaTxt = null;
	private String idCaracterstTxt = null;
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public MsAlertaJS() {
	}

	public Long getIdAlerta() {
		return this.idAlerta;
	}

	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}
	
	public Integer getDia() {
						return this.dia;
					}

	public void setDia(Integer dia) {
						this.dia = dia;
					}
	public Integer getHora() {
						return this.hora;
					}

	public void setHora(Integer hora) {
						this.hora = hora;
					}
	public String getOtrosDestin() {
						return this.otrosDestin;
					}

	public void setOtrosDestin(String otrosDestin) {
						this.otrosDestin = otrosDestin;
					}
	public Long getIdCaracterst() {
						return this.idCaracterst;
					}

	public void setIdCaracterst(Long idCaracterst) {
						this.idCaracterst = idCaracterst;
					}
	
	
	public String getDiaTxt() {
		return this.diaTxt;
	}
	public void setDiaTxt(String diaTxt) {
		this.diaTxt = diaTxt;
	}
	public String getHoraTxt() {
		return this.horaTxt;
	}
	public void setHoraTxt(String horaTxt) {
		this.horaTxt = horaTxt;
	}
	public String getIdCaracterstTxt() {
		return this.idCaracterstTxt;
	}
	public void setIdCaracterstTxt(String idCaracterstTxt) {
		this.idCaracterstTxt = idCaracterstTxt;
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
