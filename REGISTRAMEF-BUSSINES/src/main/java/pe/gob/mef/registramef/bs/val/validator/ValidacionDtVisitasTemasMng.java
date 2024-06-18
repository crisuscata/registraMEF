package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasTemasBk;

/**
 * DT_VISITAS_TEMAS SERVICIO VALIDACIÓN: ALAMACENA LOS TEMAS DE LA VISITA "TEMAS DE LA VISITA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtVisitasTemasMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtVisitasTemasMng.class.getName());
	
	public static void validarDtVisitasTemasBk(DtVisitasTemasBk dtVisitasTemasBk)
	 throws Validador
	{
                //FORANEAS
                if(dtVisitasTemasBk.getEstado()!=null && dtVisitasTemasBk.getEstado().longValue()<=0){
			dtVisitasTemasBk.setEstado(null);
		}
	        if(dtVisitasTemasBk.getIdVisita()!=null && dtVisitasTemasBk.getIdVisita().longValue()<=0){
			dtVisitasTemasBk.setIdVisita(null);
		}
	        if(dtVisitasTemasBk.getIdTema()!=null && dtVisitasTemasBk.getIdTema().longValue()<=0){
			dtVisitasTemasBk.setIdTema(null);
		}
	        
		//VALIDANDO
		
		
		
		
		
		//validarIdVisita(dtVisitasTemasBk.getIdVisita());

		
		
		//validarIdTema(dtVisitasTemasBk.getIdTema());

				
	}

	
	
	
	
	
	public static void validarIdVisita(Long idVisita)
	 throws Validador
	{				
					if(idVisita==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasTemas.seleccione"),
			Messages.getStringToKey("dtVisitasTemas.idVisita"),
			Messages.getStringToKey("dtVisitasTemas.titulotabla"),
			Messages.getStringToKey("dtVisitasTemas.articuloIdVisita")));
			if(idVisita.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasTemas.invalidoseleccione"),
			Messages.getStringToKey("dtVisitasTemas.idVisita"),
			Messages.getStringToKey("dtVisitasTemas.titulotabla"),
			Messages.getStringToKey("dtVisitasTemas.articuloIdVisita")));			
	}
	
	
	public static void validarIdTema(Long idTema)
			 throws Validador
				{				
								if(idTema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasTemas.invalidoingrese"),
						Messages.getStringToKey("dtVisitasTemas.idTema"),
						Messages.getStringToKey("dtVisitasTemas.titulotabla"),
						Messages.getStringToKey("dtVisitasTemas.articuloIdTema")));
					}
	
		
}