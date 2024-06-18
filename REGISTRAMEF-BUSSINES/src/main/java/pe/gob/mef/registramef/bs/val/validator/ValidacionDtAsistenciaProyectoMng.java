package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaProyectoBk;

/**
 * DT_ASISTENCIA_PROYECTO SERVICIO VALIDACIÓN: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LA ASISTENCIA TÉCNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtAsistenciaProyectoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtAsistenciaProyectoMng.class.getName());
	
	public static void validarDtAsistenciaProyectoBk(DtAsistenciaProyectoBk dtAsistenciaProyectoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtAsistenciaProyectoBk.getIdAsistencia()!=null && dtAsistenciaProyectoBk.getIdAsistencia().longValue()<=0){
			dtAsistenciaProyectoBk.setIdAsistencia(null);
		}
	        if(dtAsistenciaProyectoBk.getIdProyecto()!=null && dtAsistenciaProyectoBk.getIdProyecto().longValue()<=0){
			dtAsistenciaProyectoBk.setIdProyecto(null);
		}
	        if(dtAsistenciaProyectoBk.getEstado()!=null && dtAsistenciaProyectoBk.getEstado().longValue()<=0){
			dtAsistenciaProyectoBk.setEstado(null);
		}
	        
		//VALIDANDO
		validarIdAsistencia(dtAsistenciaProyectoBk.getIdAsistencia());

		validarIdProyecto(dtAsistenciaProyectoBk.getIdProyecto());

		
		//validarDetalle(dtAsistenciaProyectoBk.getDetalle());
		if(dtAsistenciaProyectoBk.getDetalle()!=null){
				if(dtAsistenciaProyectoBk.getDetalle().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtAsistenciaProyecto.noexceder"),
							Messages.getStringToKey("dtAsistenciaProyecto.detalle"),
							Messages.getStringToKey("dtAsistenciaProyecto.titulotabla"),
							300,
							Messages.getStringToKey("dtAsistenciaProyecto.articuloDetalle")
									));				
//				dtAsistenciaProyectoBk.setDetalle(dtAsistenciaProyectoBk.getDetalle().toUpperCase());
				}

		
		
		
		
		
		
		
				
	}

	public static void validarIdAsistencia(Long idAsistencia)
	 throws Validador
	{				
					if(idAsistencia==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaProyecto.seleccione"),
			Messages.getStringToKey("dtAsistenciaProyecto.idAsistencia"),
			Messages.getStringToKey("dtAsistenciaProyecto.titulotabla"),
			Messages.getStringToKey("dtAsistenciaProyecto.articuloIdAsistencia")));
			if(idAsistencia.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaProyecto.invalidoseleccione"),
			Messages.getStringToKey("dtAsistenciaProyecto.idAsistencia"),
			Messages.getStringToKey("dtAsistenciaProyecto.titulotabla"),
			Messages.getStringToKey("dtAsistenciaProyecto.articuloIdAsistencia")));			
	}
	public static void validarIdProyecto(Long idProyecto)
			 throws Validador
				{				
								if(idProyecto==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaProyecto.invalidoingrese"),
						Messages.getStringToKey("dtAsistenciaProyecto.idProyecto"),
						Messages.getStringToKey("dtAsistenciaProyecto.titulotabla"),
						Messages.getStringToKey("dtAsistenciaProyecto.articuloIdProyecto")));
					}
	
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaProyecto.ingrese"),
			Messages.getStringToKey("dtAsistenciaProyecto.detalle"),
			Messages.getStringToKey("dtAsistenciaProyecto.titulotabla"),
			Messages.getStringToKey("dtAsistenciaProyecto.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaProyecto.invalidoingrese"),
			Messages.getStringToKey("dtAsistenciaProyecto.detalle"),
			Messages.getStringToKey("dtAsistenciaProyecto.titulotabla")));						
			if(detalle!=null){
				if(detalle.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaProyecto.noexceder"),
			Messages.getStringToKey("dtAsistenciaProyecto.detalle"),
			Messages.getStringToKey("dtAsistenciaProyecto.titulotabla"),300,
			Messages.getStringToKey("dtAsistenciaProyecto.articuloDetalle")));
				}
	}
	
	
	
	
	
	
	
		
}