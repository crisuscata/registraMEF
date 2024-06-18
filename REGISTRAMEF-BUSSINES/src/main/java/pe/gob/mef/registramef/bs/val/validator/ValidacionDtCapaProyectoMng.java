package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaProyectoBk;

/**
 * DT_CAPA_PROYECTO SERVICIO VALIDACIÓN: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CAPACITACIONES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCapaProyectoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtCapaProyectoMng.class.getName());
	
	public static void validarDtCapaProyectoBk(DtCapaProyectoBk dtCapaProyectoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtCapaProyectoBk.getIdProyecto()!=null && dtCapaProyectoBk.getIdProyecto().longValue()<=0){
			dtCapaProyectoBk.setIdProyecto(null);
		}
	        if(dtCapaProyectoBk.getIdCapacitacion()!=null && dtCapaProyectoBk.getIdCapacitacion().longValue()<=0){
			dtCapaProyectoBk.setIdCapacitacion(null);
		}
	        
		//VALIDANDO
		validarIdProyecto(dtCapaProyectoBk.getIdProyecto());

		validarIdCapacitacion(dtCapaProyectoBk.getIdCapacitacion());

		
		//validarDetalle(dtCapaProyectoBk.getDetalle());
		if(dtCapaProyectoBk.getDetalle()!=null){
				if(dtCapaProyectoBk.getDetalle().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapaProyecto.noexceder"),
							Messages.getStringToKey("dtCapaProyecto.detalle"),
							Messages.getStringToKey("dtCapaProyecto.titulotabla"),
							300,
							Messages.getStringToKey("dtCapaProyecto.articuloDetalle")
							));				
//				dtCapaProyectoBk.setDetalle(dtCapaProyectoBk.getDetalle().toUpperCase());
				}

		
		
		
		
		
		
		
				
	}
public static void validarIdProyecto(Long idProyecto)
			 throws Validador
				{				
								if(idProyecto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaProyecto.invalidoingrese"),
						Messages.getStringToKey("dtCapaProyecto.idProyecto"),
						Messages.getStringToKey("dtCapaProyecto.titulotabla"),
						Messages.getStringToKey("dtCapaProyecto.articuloIdProyecto")));
					}
	
	
	public static void validarIdCapacitacion(Long idCapacitacion)
	 throws Validador
	{				
					if(idCapacitacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaProyecto.seleccione"),
			Messages.getStringToKey("dtCapaProyecto.idCapacitacion"),
			Messages.getStringToKey("dtCapaProyecto.titulotabla"),
			Messages.getStringToKey("dtCapaProyecto.articuloIdCapacitacion")));
			if(idCapacitacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaProyecto.invalidoseleccione"),
			Messages.getStringToKey("dtCapaProyecto.idCapacitacion"),
			Messages.getStringToKey("dtCapaProyecto.titulotabla"),
			Messages.getStringToKey("dtCapaProyecto.articuloIdCapacitacion")));			
	}
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaProyecto.ingrese"),
			Messages.getStringToKey("dtCapaProyecto.detalle"),
			Messages.getStringToKey("dtCapaProyecto.titulotabla"),
			Messages.getStringToKey("dtCapaProyecto.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaProyecto.invalidoingrese"),
			Messages.getStringToKey("dtCapaProyecto.detalle"),
			Messages.getStringToKey("dtCapaProyecto.titulotabla"),
			Messages.getStringToKey("dtCapaProyecto.articuloDetalle")));						
			if(detalle!=null){
				if(detalle.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapaProyecto.noexceder"),
			Messages.getStringToKey("dtCapaProyecto.detalle"),
			Messages.getStringToKey("dtCapaProyecto.titulotabla"),300,
			Messages.getStringToKey("dtCapaProyecto.articuloDetalle")));
				}
	}
	
	
	
	
	
	
	
		
}