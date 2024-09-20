package pe.gob.mef.registramef.web.controller.rs.data;

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
public class MenuaccesosJS  implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6602064884152803272L;
	
	// PURIBE 04042024 - INICIO-->
		private boolean programacionreunion = false;
		private boolean programacionasistencia = false;
		private boolean programacioncapacitacion = false;
		

		private boolean registroreunion = false;
		private boolean registroasistencia = false;
		private boolean registrocapacitacion = false;
		
		// PURIBE 04042024 - FIN-->
		private boolean registrocapacitacionpubli = false;
		private boolean registroconsulta = false;
		
		private boolean reporteservicioresumen = false;
		private boolean reporteserviciosede = false;
		private boolean reporteserviciorepresentante = false;
		private boolean reportegenerico = false;
		private boolean reportemetas = false;
		private boolean reporteencuestas = false;
		private boolean reporteentidadesgeozona= false;
		private boolean reporteentidadescobertura= false;
		private boolean reporteusuariosdirectorio = false;
		private boolean reporteusuariosinterno = false;
		private boolean reporteusuariosexterno = false;
		
		private boolean usuarios = false;
		private boolean usuariosexternos = false;
		private boolean datossisadministrativo = false;
		private boolean datostemas = false;
		private boolean datossubtemas = false;
		private boolean entidades = false;	
		private boolean datolocales = false;
		private boolean datogeozona = false;
		private boolean datosede = false;
		private boolean datometas = false;
		private boolean datoindicadores = false;
		private boolean datoencuestas = false;
		private boolean datoproyectos = false;
		private boolean datoampliacion = false;
		
		
		private boolean parametros = false;
		private boolean paises = false;
		private boolean ubigeo = false;
		private boolean feriados = false;
		private boolean alerta = false;
		private boolean mantenimiento = false;
		
	
    public MenuaccesosJS() {
	}

	public boolean isEntidades() {
		return entidades;
	}

	public void setEntidades(boolean entidades) {
		this.entidades = entidades;
	}
	
	// PURIBE 04042024 - INICIO-->
		public boolean isProgramacionreunion() {
			return programacionreunion;
		}

		public void setProgramacionreunion(boolean programacionreunion) {
			this.programacionreunion = programacionreunion;
		}

		public boolean isRegistroreunion() {
			return registroreunion;
		}

		public void setRegistroreunion(boolean registroreunion) {
			this.registroreunion = registroreunion;
		}
		
		
		
		// PURIBE 04042024 - FIN-->

	public boolean isProgramacionasistencia() {
			return programacionasistencia;
		}

		public void setProgramacionasistencia(boolean programacionasistencia) {
			this.programacionasistencia = programacionasistencia;
		}

		public boolean isProgramacioncapacitacion() {
			return programacioncapacitacion;
		}

		public void setProgramacioncapacitacion(boolean programacioncapacitacion) {
			this.programacioncapacitacion = programacioncapacitacion;
		}

		public boolean isRegistroasistencia() {
			return registroasistencia;
		}

		public void setRegistroasistencia(boolean registroasistencia) {
			this.registroasistencia = registroasistencia;
		}

		public boolean isRegistrocapacitacion() {
			return registrocapacitacion;
		}

		public void setRegistrocapacitacion(boolean registrocapacitacion) {
			this.registrocapacitacion = registrocapacitacion;
		}

	public boolean isUsuarios() {
		return usuarios;
	}

	public void setUsuarios(boolean usuarios) {
		this.usuarios = usuarios;
	}

	public boolean isUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(boolean ubigeo) {
		this.ubigeo = ubigeo;
	}

	public boolean isParametros() {
		return parametros;
	}

	public void setParametros(boolean parametros) {
		this.parametros = parametros;
	}

	public boolean isRegistrocapacitacionpubli() {
		return registrocapacitacionpubli;
	}

	public void setRegistrocapacitacionpubli(boolean registrocapacitacionpubli) {
		this.registrocapacitacionpubli = registrocapacitacionpubli;
	}

	public boolean isRegistroconsulta() {
		return registroconsulta;
	}

	public void setRegistroconsulta(boolean registroconsulta) {
		this.registroconsulta = registroconsulta;
	}

	public boolean isReporteservicioresumen() {
		return reporteservicioresumen;
	}

	public void setReporteservicioresumen(boolean reporteservicioresumen) {
		this.reporteservicioresumen = reporteservicioresumen;
	}

	public boolean isReporteserviciosede() {
		return reporteserviciosede;
	}

	public void setReporteserviciosede(boolean reporteserviciosede) {
		this.reporteserviciosede = reporteserviciosede;
	}

	public boolean isReporteserviciorepresentante() {
		return reporteserviciorepresentante;
	}

	public void setReporteserviciorepresentante(boolean reporteserviciorepresentante) {
		this.reporteserviciorepresentante = reporteserviciorepresentante;
	}

	public boolean isReportegenerico() {
		return reportegenerico;
	}

	public void setReportegenerico(boolean reportegenerico) {
		this.reportegenerico = reportegenerico;
	}

	public boolean isReportemetas() {
		return reportemetas;
	}

	public void setReportemetas(boolean reportemetas) {
		this.reportemetas = reportemetas;
	}

	public boolean isReporteencuestas() {
		return reporteencuestas;
	}

	public void setReporteencuestas(boolean reporteencuestas) {
		this.reporteencuestas = reporteencuestas;
	}

	public boolean isReporteentidadesgeozona() {
		return reporteentidadesgeozona;
	}

	public void setReporteentidadesgeozona(boolean reporteentidadesgeozona) {
		this.reporteentidadesgeozona = reporteentidadesgeozona;
	}

	public boolean isReporteentidadescobertura() {
		return reporteentidadescobertura;
	}

	public void setReporteentidadescobertura(boolean reporteentidadescobertura) {
		this.reporteentidadescobertura = reporteentidadescobertura;
	}

	public boolean isReporteusuariosdirectorio() {
		return reporteusuariosdirectorio;
	}

	public void setReporteusuariosdirectorio(boolean reporteusuariosdirectorio) {
		this.reporteusuariosdirectorio = reporteusuariosdirectorio;
	}

	public boolean isReporteusuariosinterno() {
		return reporteusuariosinterno;
	}

	public void setReporteusuariosinterno(boolean reporteusuariosinterno) {
		this.reporteusuariosinterno = reporteusuariosinterno;
	}

	public boolean isReporteusuariosexterno() {
		return reporteusuariosexterno;
	}

	public void setReporteusuariosexterno(boolean reporteusuariosexterno) {
		this.reporteusuariosexterno = reporteusuariosexterno;
	}

	public boolean isUsuariosexternos() {
		return usuariosexternos;
	}

	public void setUsuariosexternos(boolean usuariosexternos) {
		this.usuariosexternos = usuariosexternos;
	}

	public boolean isDatossisadministrativo() {
		return datossisadministrativo;
	}

	public void setDatossisadministrativo(boolean datossisadministrativo) {
		this.datossisadministrativo = datossisadministrativo;
	}

	public boolean isDatostemas() {
		return datostemas;
	}

	public void setDatostemas(boolean datostemas) {
		this.datostemas = datostemas;
	}

	public boolean isDatossubtemas() {
		return datossubtemas;
	}

	public void setDatossubtemas(boolean datossubtemas) {
		this.datossubtemas = datossubtemas;
	}

	public boolean isDatolocales() {
		return datolocales;
	}

	public void setDatolocales(boolean datolocales) {
		this.datolocales = datolocales;
	}

	public boolean isDatogeozona() {
		return datogeozona;
	}

	public void setDatogeozona(boolean datogeozona) {
		this.datogeozona = datogeozona;
	}

	public boolean isDatosede() {
		return datosede;
	}

	public void setDatosede(boolean datosede) {
		this.datosede = datosede;
	}

	public boolean isDatometas() {
		return datometas;
	}

	public void setDatometas(boolean datometas) {
		this.datometas = datometas;
	}

	public boolean isDatoindicadores() {
		return datoindicadores;
	}

	public void setDatoindicadores(boolean datoindicadores) {
		this.datoindicadores = datoindicadores;
	}

	public boolean isDatoencuestas() {
		return datoencuestas;
	}

	public void setDatoencuestas(boolean datoencuestas) {
		this.datoencuestas = datoencuestas;
	}

	public boolean isDatoproyectos() {
		return datoproyectos;
	}

	public void setDatoproyectos(boolean datoproyectos) {
		this.datoproyectos = datoproyectos;
	}

	public boolean isDatoampliacion() {
		return datoampliacion;
	}

	public void setDatoampliacion(boolean datoampliacion) {
		this.datoampliacion = datoampliacion;
	}

	public boolean isPaises() {
		return paises;
	}

	public void setPaises(boolean paises) {
		this.paises = paises;
	}

	public boolean isFeriados() {
		return feriados;
	}

	public void setFeriados(boolean feriados) {
		this.feriados = feriados;
	}

	public boolean isAlerta() {
		return alerta;
	}

	public void setAlerta(boolean alerta) {
		this.alerta = alerta;
	}

	public boolean isMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(boolean mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	
	
	
    
}
