package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasProyectoBk;

/**
 * DT_CONSULTAS_PROYECTO SERVICIO VALIDACIÓN: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CONSULTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtConsultasProyectoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtConsultasProyectoMng.class.getName());
	
	public static void validarDtConsultasProyectoBk(DtConsultasProyectoBk dtConsultasProyectoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtConsultasProyectoBk.getIdConsulta()!=null && dtConsultasProyectoBk.getIdConsulta().longValue()<=0){
			dtConsultasProyectoBk.setIdConsulta(null);
		}
	        if(dtConsultasProyectoBk.getIdProyecto()!=null && dtConsultasProyectoBk.getIdProyecto().longValue()<=0){
			dtConsultasProyectoBk.setIdProyecto(null);
		}
	        if(dtConsultasProyectoBk.getEstado()!=null && dtConsultasProyectoBk.getEstado().longValue()<=0){
			dtConsultasProyectoBk.setEstado(null);
		}
	        
		//VALIDANDO
		validarIdConsulta(dtConsultasProyectoBk.getIdConsulta());

		validarIdProyecto(dtConsultasProyectoBk.getIdProyecto());

		
		//validarDetalle(dtConsultasProyectoBk.getDetalle());
		if(dtConsultasProyectoBk.getDetalle()!=null){
				if(dtConsultasProyectoBk.getDetalle().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtConsultasProyecto.noexceder"),
							Messages.getStringToKey("dtConsultasProyecto.detalle"),
							Messages.getStringToKey("dtConsultasProyecto.titulotabla"),
							300,
							Messages.getStringToKey("dtConsultasProyecto.articuloDetalle")
							));				
//				dtConsultasProyectoBk.setDetalle(dtConsultasProyectoBk.getDetalle().toUpperCase());
				}

		
		
		
		
		
		
		
				
	}

	public static void validarIdConsulta(Long idConsulta)
	 throws Validador
	{				
					if(idConsulta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultasProyecto.seleccione"),
			Messages.getStringToKey("dtConsultasProyecto.idConsulta"),
			Messages.getStringToKey("dtConsultasProyecto.titulotabla"),
			Messages.getStringToKey("dtConsultasProyecto.articuloIdConsulta")));
			if(idConsulta.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultasProyecto.invalidoseleccione"),
			Messages.getStringToKey("dtConsultasProyecto.idConsulta"),
			Messages.getStringToKey("dtConsultasProyecto.titulotabla"),
			Messages.getStringToKey("dtConsultasProyecto.articuloIdConsulta")));			
	}
	public static void validarIdProyecto(Long idProyecto)
			 throws Validador
				{				
								if(idProyecto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultasProyecto.invalidoingrese"),
						Messages.getStringToKey("dtConsultasProyecto.idProyecto"),
						Messages.getStringToKey("dtConsultasProyecto.titulotabla"),
						Messages.getStringToKey("dtConsultasProyecto.articuloIdProyecto")));
					}
	
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultasProyecto.ingrese"),
			Messages.getStringToKey("dtConsultasProyecto.detalle"),
			Messages.getStringToKey("dtConsultasProyecto.titulotabla"),
			Messages.getStringToKey("dtConsultasProyecto.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultasProyecto.invalidoingrese"),
			Messages.getStringToKey("dtConsultasProyecto.detalle"),
			Messages.getStringToKey("dtConsultasProyecto.titulotabla"),
			Messages.getStringToKey("dtConsultasProyecto.articuloDetalle")));						
			if(detalle!=null){
				if(detalle.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultasProyecto.noexceder"),
			Messages.getStringToKey("dtConsultasProyecto.detalle"),
			Messages.getStringToKey("dtConsultasProyecto.titulotabla"),300,
			Messages.getStringToKey("dtConsultasProyecto.articuloDetalle")));
				}
	}
	
	
	
	
	
	
	
		
}