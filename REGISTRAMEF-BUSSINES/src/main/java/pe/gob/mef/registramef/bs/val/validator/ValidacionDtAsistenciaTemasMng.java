package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;

/**
 * DT_ASISTENCIA_TEMAS SERVICIO VALIDACIÓN: ALMACENA LOS DISTINTOS TEMAS AGENDADOS EN LA ASISTENCIA TECNICA "TEMAS DE LA ASISTENCIA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtAsistenciaTemasMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtAsistenciaTemasMng.class.getName());
	
	public static void validarDtAsistenciaTemasBk(DtAsistenciaTemasBk dtAsistenciaTemasBk)
	 throws Validador
	{
                //FORANEAS
                if(dtAsistenciaTemasBk.getIdAsistencia()!=null && dtAsistenciaTemasBk.getIdAsistencia().longValue()<=0){
			dtAsistenciaTemasBk.setIdAsistencia(null);
		}
	        if(dtAsistenciaTemasBk.getIdTema()!=null && dtAsistenciaTemasBk.getIdTema().longValue()<=0){
			dtAsistenciaTemasBk.setIdTema(null);
		}
	        if(dtAsistenciaTemasBk.getIdSubtema()!=null && dtAsistenciaTemasBk.getIdSubtema().longValue()<=0){
			dtAsistenciaTemasBk.setIdSubtema(null);
		}
	        if(dtAsistenciaTemasBk.getEstado()!=null && dtAsistenciaTemasBk.getEstado().longValue()<=0){
			dtAsistenciaTemasBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		
		
		
		
		//validarDetalle(dtAsistenciaTemasBk.getDetalle());
		if(dtAsistenciaTemasBk.getDetalle()!=null){
				if(dtAsistenciaTemasBk.getDetalle().trim().length()>400)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtAsistenciaTemas.noexceder"),
							Messages.getStringToKey("dtAsistenciaTemas.detalle"),
							Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
							400,
							Messages.getStringToKey("dtAsistenciaTemas.articuloDetalle")
							));				
//				dtAsistenciaTemasBk.setDetalle(dtAsistenciaTemasBk.getDetalle().toUpperCase());
				}

		//validarIdAsistencia(dtAsistenciaTemasBk.getIdAsistencia());

		//validarIdTema(dtAsistenciaTemasBk.getIdTema());

		//validarIdSubtema(dtAsistenciaTemasBk.getIdSubtema());

		
		
		
		//validarIdUsuinterno(dtAsistenciaTemasBk.getIdUsuinterno());

		//validarIdSistAdmi(dtAsistenciaTemasBk.getIdSistAdmi());

				
	}

	
	
	
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.ingrese"),
			Messages.getStringToKey("dtAsistenciaTemas.detalle"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.invalidoingrese"),
			Messages.getStringToKey("dtAsistenciaTemas.detalle"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloDetalle")));						
			if(detalle!=null){
				if(detalle.trim().length()>400)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.noexceder"),
			Messages.getStringToKey("dtAsistenciaTemas.detalle"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),400,
			Messages.getStringToKey("dtAsistenciaTemas.articuloDetalle")));
				}
	}
	
	public static void validarIdAsistencia(Long idAsistencia)
	 throws Validador
	{				
					if(idAsistencia==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.seleccione"),
			Messages.getStringToKey("dtAsistenciaTemas.idAsistencia"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloIdAsistencia")));
			if(idAsistencia.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtAsistenciaTemas.idAsistencia"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloIdAsistencia")));			
	}
	public static void validarIdTema(Long idTema)
			 throws Validador
				{				
								if(idTema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.invalidoingrese"),
						Messages.getStringToKey("dtAsistenciaTemas.idTema"),
						Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
						Messages.getStringToKey("dtAsistenciaTemas.articuloIdTema")));
					}
	
	public static void validarIdSubtema(Long idSubtema)
			 throws Validador
				{				
								if(idSubtema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.invalidoingrese"),
						Messages.getStringToKey("dtAsistenciaTemas.idSubtema"),
						Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
						Messages.getStringToKey("dtAsistenciaTemas.articuloIdSubtema")));
					}
	
	
	
	
	
	public static void validarIdUsuinterno(Long idUsuinterno)
	 throws Validador
	{				
					if(idUsuinterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.seleccione"),
			Messages.getStringToKey("dtAsistenciaTemas.idUsuinterno"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloIdUsuinterno")));
			if(idUsuinterno.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtAsistenciaTemas.idUsuinterno"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloIdUsuinterno")));			
	}
	
	public static void validarIdSistAdmi(Long idSistAdmi)
	 throws Validador
	{				
					if(idSistAdmi==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.seleccione"),
			Messages.getStringToKey("dtAsistenciaTemas.idSistAdmi"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloIdSistAdmi")));
			if(idSistAdmi.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistenciaTemas.invalidoseleccione"),
			Messages.getStringToKey("dtAsistenciaTemas.idSistAdmi"),
			Messages.getStringToKey("dtAsistenciaTemas.titulotabla"),
			Messages.getStringToKey("dtAsistenciaTemas.articuloIdSistAdmi")));			
	}
		
}