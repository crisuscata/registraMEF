package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaRespuestaBk;

/**
 * DT_ENCUESTA_RESPUESTA SERVICIO VALIDACIÓN: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtEncuestaRespuestaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtEncuestaRespuestaMng.class.getName());
	
	public static void validarDtEncuestaRespuestaBk(DtEncuestaRespuestaBk dtEncuestaRespuestaBk)
	 throws Validador
	{
                //FORANEAS
                if(dtEncuestaRespuestaBk.getIdEncuesta()!=null && dtEncuestaRespuestaBk.getIdEncuesta().longValue()<=0){
			dtEncuestaRespuestaBk.setIdEncuesta(null);
		}
	        if(dtEncuestaRespuestaBk.getEstado()!=null && dtEncuestaRespuestaBk.getEstado().longValue()<=0){
			dtEncuestaRespuestaBk.setEstado(null);
		}
	        if(dtEncuestaRespuestaBk.getIdExpositor()!=null && dtEncuestaRespuestaBk.getIdExpositor().longValue()<=0){
			dtEncuestaRespuestaBk.setIdExpositor(null);
		}
	        
		//VALIDANDO
		validarIdUsuexterno(dtEncuestaRespuestaBk.getIdUsuexterno());

		validarIdEncuesta(dtEncuestaRespuestaBk.getIdEncuesta());

		validarIdServicio(dtEncuestaRespuestaBk.getIdServicio());

		
		//validarTipoPregunta(dtEncuestaRespuestaBk.getTipoPregunta());
		if(dtEncuestaRespuestaBk.getTipoPregunta()!=null){
				if(dtEncuestaRespuestaBk.getTipoPregunta().trim().length()>20)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
							Messages.getStringToKey("dtEncuestaRespuesta.tipoPregunta"),
							Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
							20,
							Messages.getStringToKey("dtEncuestaRespuesta.articuloTipoPregunta")
									));				
//				dtEncuestaRespuestaBk.setTipoPregunta(dtEncuestaRespuestaBk.getTipoPregunta().toUpperCase());
				}

		
		//validarIdPregunta(dtEncuestaRespuestaBk.getIdPregunta());
		if(dtEncuestaRespuestaBk.getIdPregunta()!=null){
				if(dtEncuestaRespuestaBk.getIdPregunta().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
							Messages.getStringToKey("dtEncuestaRespuesta.idPregunta"),
							Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
							50,
							Messages.getStringToKey("dtEncuestaRespuesta.articuloIdPregunta")
									));				
//				dtEncuestaRespuestaBk.setIdPregunta(dtEncuestaRespuestaBk.getIdPregunta().toUpperCase());
				}

		
		//validarRespuesta(dtEncuestaRespuestaBk.getRespuesta());
		if(dtEncuestaRespuestaBk.getRespuesta()!=null){
				if(dtEncuestaRespuestaBk.getRespuesta().trim().length()>600)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
							Messages.getStringToKey("dtEncuestaRespuesta.respuesta"),
							Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
							600,
							Messages.getStringToKey("dtEncuestaRespuesta.articuloRespuesta")
									));				
//				dtEncuestaRespuestaBk.setRespuesta(dtEncuestaRespuestaBk.getRespuesta().toUpperCase());
				}

		
		
		
		
		
		
		
		//validarIdExpositor(dtEncuestaRespuestaBk.getIdExpositor());

		
		//validarPregunta(dtEncuestaRespuestaBk.getPregunta());
		if(dtEncuestaRespuestaBk.getPregunta()!=null){
				if(dtEncuestaRespuestaBk.getPregunta().trim().length()>3000)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
							Messages.getStringToKey("dtEncuestaRespuesta.pregunta"),
							Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
							3000,
							Messages.getStringToKey("dtEncuestaRespuesta.articuloPregunta")
							));				
//				dtEncuestaRespuestaBk.setPregunta(dtEncuestaRespuestaBk.getPregunta().toUpperCase());
				}

				
	}

	public static void validarIdUsuexterno(Long idUsuexterno)
	 throws Validador
	{				
					if(idUsuexterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.seleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idUsuexterno"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdUsuexterno")));
			if(idUsuexterno.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoseleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idUsuexterno"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdUsuexterno")));			
	}
	
	public static void validarIdEncuesta(Integer idEncuesta)
	 throws Validador
	{				
					if(idEncuesta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.seleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idEncuesta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdEncuesta")));
			if(idEncuesta.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoseleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idEncuesta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdEncuesta")));			
	}
	
	public static void validarIdServicio(Long idServicio)
	 throws Validador
	{				
					if(idServicio==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.seleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idServicio"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdServicio")));
			if(idServicio.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoseleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idServicio"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdServicio")));			
	}
	
	public static void validarTipoPregunta(String tipoPregunta)
	 throws Validador
	{					
			if(tipoPregunta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.ingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.tipoPregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloTipoPregunta")));
			if(tipoPregunta.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.tipoPregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla")));						
			if(tipoPregunta!=null){
				if(tipoPregunta.trim().length()>20)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
			Messages.getStringToKey("dtEncuestaRespuesta.tipoPregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),20,
			Messages.getStringToKey("dtEncuestaRespuesta.articuloTipoPregunta")));
				}
	}
	
	public static void validarIdPregunta(String idPregunta)
	 throws Validador
	{					
			if(idPregunta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.ingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.idPregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdPregunta")));
			if(idPregunta.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.idPregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla")));						
			if(idPregunta!=null){
				if(idPregunta.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
			Messages.getStringToKey("dtEncuestaRespuesta.idPregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),50,
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdPregunta")));
				}
	}
	
	public static void validarRespuesta(String respuesta)
	 throws Validador
	{					
			if(respuesta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.ingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.respuesta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloRespuesta")));
			if(respuesta.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.respuesta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla")));						
			if(respuesta!=null){
				if(respuesta.trim().length()>600)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
			Messages.getStringToKey("dtEncuestaRespuesta.respuesta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),600,
			Messages.getStringToKey("dtEncuestaRespuesta.articuloRespuesta")));
				}
	}
	
	
	
	
	
	
	
	
	public static void validarIdExpositor(Long idExpositor)
	 throws Validador
	{				
					if(idExpositor==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.seleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idExpositor"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdExpositor")));
			if(idExpositor.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoseleccione"),
			Messages.getStringToKey("dtEncuestaRespuesta.idExpositor"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloIdExpositor")));			
	}
	
	public static void validarPregunta(String pregunta)
	 throws Validador
	{					
			if(pregunta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.ingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.pregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloPregunta")));
			if(pregunta.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.invalidoingrese"),
			Messages.getStringToKey("dtEncuestaRespuesta.pregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),
			Messages.getStringToKey("dtEncuestaRespuesta.articuloPregunta")));						
			if(pregunta!=null){
				if(pregunta.trim().length()>3000)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEncuestaRespuesta.noexceder"),
			Messages.getStringToKey("dtEncuestaRespuesta.pregunta"),
			Messages.getStringToKey("dtEncuestaRespuesta.titulotabla"),3000,
			Messages.getStringToKey("dtEncuestaRespuesta.articuloPregunta")));
				}
	}
		
}