package pe.gob.mef.registramef.web.controller.rs.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * MSUSUARIOS BAKING: USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37 / Creación de la clase
 *          /
 * 
 */
@XmlRootElement
public class TdAnexosJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731777848783041331L;

	// ID
	private Long idanexo;

	// PROPIEDADES
	private Long iddocumento = null;
	private String filename = null;
	private String filenameoriginal = null;
	private Long lastmodified = null;
	private Long tamanio = null;
	private String tipo = null;
	private Integer tipodocumento = null;

	// ADICIONALES
	private String iduserCreaTxt = null;
	private String iduserModifTxt = null;
	private String data = null;
	private String letter = null;
	private Integer editopcion = 1;

	public TdAnexosJS() {
	}

	public Long getIdanexo() {
		return this.idanexo;
	}

	public void setIdanexo(Long idanexo) {
		this.idanexo = idanexo;
	}

	public Long getIddocumento() {
		return this.iddocumento;
	}

	public void setIddocumento(Long iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilenameoriginal() {
		return this.filenameoriginal;
	}

	public void setFilenameoriginal(String filenameoriginal) {
		this.filenameoriginal = filenameoriginal;
	}

	public Long getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Long lastmodified) {
		this.lastmodified = lastmodified;
	}

	public Long getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Integer tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getIduserCreaTxt() {
		return this.iduserCreaTxt;
	}

	public void setIduserCreaTxt(String iduserCreaTxt) {
		this.iduserCreaTxt = iduserCreaTxt;
	}

	public String getIduserModifTxt() {
		return this.iduserModifTxt;
	}

	public void setIduserModifTxt(String iduserModifTxt) {
		this.iduserModifTxt = iduserModifTxt;
	}

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}
}
