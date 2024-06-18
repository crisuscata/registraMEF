/**
 * ExpedienteWSDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.mef.registramef.web.controller.rs.data;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExpedienteJS implements java.io.Serializable {

	/**
	 * //MPINARES 14022024 - INICIO - NUEVA CLASE
	 */
	private static final long serialVersionUID = -5820872753460951976L;
	private java.lang.String anexos;
    private java.lang.String asunto;
    private java.lang.String expedienteiddoc;
    private java.lang.String fechahoradeiniciodetramite;
    private java.lang.String fechahoradeldocumento;
    private java.lang.String fechahorafindocumento;
    private java.lang.String fechahorarecepcion;
    private java.lang.String modalidadIngreso;
    private java.lang.String noexpediente;
    private java.lang.String numerodedocumento;
    private java.lang.String numerodefolios;
    private java.lang.String observacionfindocumento;
    private java.lang.String situacionactual;
    private java.lang.String tipodedocumento;

	public ExpedienteJS() {
	}

	public ExpedienteJS(String anexos, String asunto, String expedienteiddoc, String fechahoradeiniciodetramite,
			String fechahoradeldocumento, String fechahorafindocumento, String fechahorarecepcion,
			String modalidadIngreso, String noexpediente, String numerodedocumento, String numerodefolios,
			String observacionfindocumento, String situacionactual, String tipodedocumento) {
		super();
		this.anexos = anexos;
		this.asunto = asunto;
		this.expedienteiddoc = expedienteiddoc;
		this.fechahoradeiniciodetramite = fechahoradeiniciodetramite;
		this.fechahoradeldocumento = fechahoradeldocumento;
		this.fechahorafindocumento = fechahorafindocumento;
		this.fechahorarecepcion = fechahorarecepcion;
		this.modalidadIngreso = modalidadIngreso;
		this.noexpediente = noexpediente;
		this.numerodedocumento = numerodedocumento;
		this.numerodefolios = numerodefolios;
		this.observacionfindocumento = observacionfindocumento;
		this.situacionactual = situacionactual;
		this.tipodedocumento = tipodedocumento;
	}

	public java.lang.String getAnexos() {
		return anexos;
	}

	public void setAnexos(java.lang.String anexos) {
		this.anexos = anexos;
	}

	public java.lang.String getAsunto() {
		return asunto;
	}

	public void setAsunto(java.lang.String asunto) {
		this.asunto = asunto;
	}

	public java.lang.String getExpedienteiddoc() {
		return expedienteiddoc;
	}

	public void setExpedienteiddoc(java.lang.String expedienteiddoc) {
		this.expedienteiddoc = expedienteiddoc;
	}

	public java.lang.String getFechahoradeiniciodetramite() {
		return fechahoradeiniciodetramite;
	}

	public void setFechahoradeiniciodetramite(java.lang.String fechahoradeiniciodetramite) {
		this.fechahoradeiniciodetramite = fechahoradeiniciodetramite;
	}

	public java.lang.String getFechahoradeldocumento() {
		return fechahoradeldocumento;
	}

	public void setFechahoradeldocumento(java.lang.String fechahoradeldocumento) {
		this.fechahoradeldocumento = fechahoradeldocumento;
	}

	public java.lang.String getFechahorafindocumento() {
		return fechahorafindocumento;
	}

	public void setFechahorafindocumento(java.lang.String fechahorafindocumento) {
		this.fechahorafindocumento = fechahorafindocumento;
	}

	public java.lang.String getFechahorarecepcion() {
		return fechahorarecepcion;
	}

	public void setFechahorarecepcion(java.lang.String fechahorarecepcion) {
		this.fechahorarecepcion = fechahorarecepcion;
	}

	public java.lang.String getModalidadIngreso() {
		return modalidadIngreso;
	}

	public void setModalidadIngreso(java.lang.String modalidadIngreso) {
		this.modalidadIngreso = modalidadIngreso;
	}

	public java.lang.String getNoexpediente() {
		return noexpediente;
	}

	public void setNoexpediente(java.lang.String noexpediente) {
		this.noexpediente = noexpediente;
	}

	public java.lang.String getNumerodedocumento() {
		return numerodedocumento;
	}

	public void setNumerodedocumento(java.lang.String numerodedocumento) {
		this.numerodedocumento = numerodedocumento;
	}

	public java.lang.String getNumerodefolios() {
		return numerodefolios;
	}

	public void setNumerodefolios(java.lang.String numerodefolios) {
		this.numerodefolios = numerodefolios;
	}

	public java.lang.String getObservacionfindocumento() {
		return observacionfindocumento;
	}

	public void setObservacionfindocumento(java.lang.String observacionfindocumento) {
		this.observacionfindocumento = observacionfindocumento;
	}

	public java.lang.String getSituacionactual() {
		return situacionactual;
	}

	public void setSituacionactual(java.lang.String situacionactual) {
		this.situacionactual = situacionactual;
	}

	public java.lang.String getTipodedocumento() {
		return tipodedocumento;
	}

	public void setTipodedocumento(java.lang.String tipodedocumento) {
		this.tipodedocumento = tipodedocumento;
	}

	

	

	
}
