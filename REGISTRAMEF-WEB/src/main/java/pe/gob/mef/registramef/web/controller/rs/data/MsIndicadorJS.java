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
public class MsIndicadorJS implements java.io.Serializable {

	// ID
	private Long idIndicador;

	// PROPIEDADES
	private String descripcion = null;
	private String formula = null;
	private Long idObjetvo = null;
	private Long idNivlstrat = null;
	private Long idFactor = null;
	private Long idFuenteinfor = null;
	
	
	// ADICIONALES
	private String idObjetvoTxt = null;
	private String idNivlstratTxt = null;
	private String idFactorTxt = null;
	private String idFuenteinforTxt = null;
	private String estadoTxt = null;
	
	private Integer editopcion = 1;

	public MsIndicadorJS() {
	}

	public Long getIdIndicador() {
		return this.idIndicador;
	}

	public void setIdIndicador(Long idIndicador) {
		this.idIndicador = idIndicador;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	public String getFormula() {
						return this.formula;
					}

	public void setFormula(String formula) {
						this.formula = formula;
					}
	public Long getIdObjetvo() {
						return this.idObjetvo;
					}

	public void setIdObjetvo(Long idObjetvo) {
						this.idObjetvo = idObjetvo;
					}
	public Long getIdNivlstrat() {
						return this.idNivlstrat;
					}

	public void setIdNivlstrat(Long idNivlstrat) {
						this.idNivlstrat = idNivlstrat;
					}
	public Long getIdFactor() {
						return this.idFactor;
					}

	public void setIdFactor(Long idFactor) {
						this.idFactor = idFactor;
					}
	public Long getIdFuenteinfor() {
						return this.idFuenteinfor;
					}

	public void setIdFuenteinfor(Long idFuenteinfor) {
						this.idFuenteinfor = idFuenteinfor;
					}
	
	
	public String getIdObjetvoTxt() {
		return this.idObjetvoTxt;
	}
	public void setIdObjetvoTxt(String idObjetvoTxt) {
		this.idObjetvoTxt = idObjetvoTxt;
	}
	public String getIdNivlstratTxt() {
		return this.idNivlstratTxt;
	}
	public void setIdNivlstratTxt(String idNivlstratTxt) {
		this.idNivlstratTxt = idNivlstratTxt;
	}
	public String getIdFactorTxt() {
		return this.idFactorTxt;
	}
	public void setIdFactorTxt(String idFactorTxt) {
		this.idFactorTxt = idFactorTxt;
	}
	public String getIdFuenteinforTxt() {
		return this.idFuenteinforTxt;
	}
	public void setIdFuenteinforTxt(String idFuenteinforTxt) {
		this.idFuenteinforTxt = idFuenteinforTxt;
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
