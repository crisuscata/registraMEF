package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasProyectoBk;

/**
 * DT_VISITAS_PROYECTO SERVICIO VALIDACIÓN: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS VISITAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtVisitasProyectoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtVisitasProyectoMng.class.getName());
	
	public static void validarDtVisitasProyectoBk(DtVisitasProyectoBk dtVisitasProyectoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtVisitasProyectoBk.getIdVisita()!=null && dtVisitasProyectoBk.getIdVisita().longValue()<=0){
			dtVisitasProyectoBk.setIdVisita(null);
		}
	        if(dtVisitasProyectoBk.getIdProyecto()!=null && dtVisitasProyectoBk.getIdProyecto().longValue()<=0){
			dtVisitasProyectoBk.setIdProyecto(null);
		}
	        
		//VALIDANDO
		validarIdVisita(dtVisitasProyectoBk.getIdVisita());

		validarIdProyecto(dtVisitasProyectoBk.getIdProyecto());

		
		//validarDetalle(dtVisitasProyectoBk.getDetalle());
		if(dtVisitasProyectoBk.getDetalle()!=null){
				if(dtVisitasProyectoBk.getDetalle().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtVisitasProyecto.noexceder"),
							Messages.getStringToKey("dtVisitasProyecto.detalle"),
							Messages.getStringToKey("dtVisitasProyecto.titulotabla"),
							300,
							Messages.getStringToKey("dtVisitasProyecto.articuloDetalle")
							));				
//				dtVisitasProyectoBk.setDetalle(dtVisitasProyectoBk.getDetalle().toUpperCase());
				}

		
		
		
		
		
		
		
				
	}

	public static void validarIdVisita(Long idVisita)
	 throws Validador
	{				
					if(idVisita==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasProyecto.seleccione"),
			Messages.getStringToKey("dtVisitasProyecto.idVisita"),
			Messages.getStringToKey("dtVisitasProyecto.titulotabla"),
			Messages.getStringToKey("dtVisitasProyecto.articuloIdVisita")));
			if(idVisita.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasProyecto.invalidoseleccione"),
			Messages.getStringToKey("dtVisitasProyecto.idVisita"),
			Messages.getStringToKey("dtVisitasProyecto.titulotabla"),
			Messages.getStringToKey("dtVisitasProyecto.articuloIdVisita")));			
	}
	public static void validarIdProyecto(Long idProyecto)
			 throws Validador
				{				
								if(idProyecto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasProyecto.invalidoingrese"),
						Messages.getStringToKey("dtVisitasProyecto.idProyecto"),
						Messages.getStringToKey("dtVisitasProyecto.titulotabla"),
						Messages.getStringToKey("dtVisitasProyecto.articuloIdProyecto")));
					}
	
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasProyecto.ingrese"),
			Messages.getStringToKey("dtVisitasProyecto.detalle"),
			Messages.getStringToKey("dtVisitasProyecto.titulotabla"),
			Messages.getStringToKey("dtVisitasProyecto.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasProyecto.invalidoingrese"),
			Messages.getStringToKey("dtVisitasProyecto.detalle"),
			Messages.getStringToKey("dtVisitasProyecto.titulotabla"),
			Messages.getStringToKey("dtVisitasProyecto.articuloDetalle")));						
			if(detalle!=null){
				if(detalle.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasProyecto.noexceder"),
			Messages.getStringToKey("dtVisitasProyecto.detalle"),
			Messages.getStringToKey("dtVisitasProyecto.titulotabla"),300,
			Messages.getStringToKey("dtVisitasProyecto.articuloDetalle")));
				}
	}
	
	
	
	
	
	
	
		
}