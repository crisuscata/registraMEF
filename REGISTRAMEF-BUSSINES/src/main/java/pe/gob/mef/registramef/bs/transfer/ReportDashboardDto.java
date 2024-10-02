package pe.gob.mef.registramef.bs.transfer;


public class ReportDashboardDto implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String monthYear;
	private Integer totalParticipants;
	private Integer totalEvents;
	private Integer totalVirtual;
	private Integer totalPresencial;
	private Integer totalTelefonico;
	private String abreviaturaAdmin;
	
	private Integer total;
	private String abreviatura;
	
	
	private String sede;
	private String descripcion  = null;
	private String apellidosNombres  = null;
	private Integer totalFueraPlazo  = null;
	private Double porcentajeFueraPlazo  = null;
	private Integer totalDentroPlazo  = null;
	private Double porcentajeDentroPlazo  = null;
	
	private String sistAdmin = null;
	private String tema = null;
	private String subtema = null;
	private Integer cantidadTotal = null;
	
	public String getSistAdmin() {
		return sistAdmin;
	}
	public void setSistAdmin(String sistAdmin) {
		this.sistAdmin = sistAdmin;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getSubtema() {
		return subtema;
	}
	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}
	public Integer getCantidadTotal() {
		return cantidadTotal;
	}
	public void setCantidadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getApellidosNombres() {
		return apellidosNombres;
	}
	public void setApellidosNombres(String apellidosNombres) {
		this.apellidosNombres = apellidosNombres;
	}
	public Integer getTotalFueraPlazo() {
		return totalFueraPlazo;
	}
	public void setTotalFueraPlazo(Integer totalFueraPlazo) {
		this.totalFueraPlazo = totalFueraPlazo;
	}
	public Double getPorcentajeFueraPlazo() {
		return porcentajeFueraPlazo;
	}
	public void setPorcentajeFueraPlazo(Double porcentajeFueraPlazo) {
		this.porcentajeFueraPlazo = porcentajeFueraPlazo;
	}
	public Integer getTotalDentroPlazo() {
		return totalDentroPlazo;
	}
	public void setTotalDentroPlazo(Integer totalDentroPlazo) {
		this.totalDentroPlazo = totalDentroPlazo;
	}
	public Double getPorcentajeDentroPlazo() {
		return porcentajeDentroPlazo;
	}
	public void setPorcentajeDentroPlazo(Double porcentajeDentroPlazo) {
		this.porcentajeDentroPlazo = porcentajeDentroPlazo;
	}
	public Integer getTotalParticipants() {
		return totalParticipants;
	}
	public void setTotalParticipants(Integer totalParticipants) {
		this.totalParticipants = totalParticipants;
	}
	public Integer getTotalPresencial() {
		return totalPresencial;
	}
	public void setTotalPresencial(Integer totalPresencial) {
		this.totalPresencial = totalPresencial;
	}
	public Integer getTotalEvents() {
		return totalEvents;
	}
	public void setTotalEvents(Integer totalEvents) {
		this.totalEvents = totalEvents;
	}
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public Integer getTotalVirtual() {
		return totalVirtual;
	}
	public void setTotalVirtual(Integer totalVirtual) {
		this.totalVirtual = totalVirtual;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAbreviaturaAdmin() {
		return abreviaturaAdmin;
	}
	public void setAbreviaturaAdmin(String abreviaturaAdmin) {
		this.abreviaturaAdmin = abreviaturaAdmin;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Integer getTotalTelefonico() {
		return totalTelefonico;
	}
	public void setTotalTelefonico(Integer totalTelefonico) {
		this.totalTelefonico = totalTelefonico;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}

}
