package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuinternosBk;

/**
 * DT_VISITAS_USUINTERNOS SERVICIO VALIDACIÓN: ALMACENA A LOS PARTICIPANTES DE LA VISITA "PARTICIPANTES DE LA VISITA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtVisitasUsuinternosMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtVisitasUsuinternosMng.class.getName());
	
	public static void validarDtVisitasUsuinternosBk(DtVisitasUsuinternosBk dtVisitasUsuinternosBk)
	 throws Validador
	{
                //FORANEAS
                if(dtVisitasUsuinternosBk.getIdVisita()!=null && dtVisitasUsuinternosBk.getIdVisita().longValue()<=0){
			dtVisitasUsuinternosBk.setIdVisita(null);
		}
	        if(dtVisitasUsuinternosBk.getIdUsuinterno()!=null && dtVisitasUsuinternosBk.getIdUsuinterno().longValue()<=0){
			dtVisitasUsuinternosBk.setIdUsuinterno(null);
		}
	        if(dtVisitasUsuinternosBk.getEstado()!=null && dtVisitasUsuinternosBk.getEstado().longValue()<=0){
			dtVisitasUsuinternosBk.setEstado(null);
		}
	        if(dtVisitasUsuinternosBk.getIdTema()!=null && dtVisitasUsuinternosBk.getIdTema().longValue()<=0){
			dtVisitasUsuinternosBk.setIdTema(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdVisita(dtVisitasUsuinternosBk.getIdVisita());

		//validarIdUsuinterno(dtVisitasUsuinternosBk.getIdUsuinterno());

		
		
		
		//validarIdTema(dtVisitasUsuinternosBk.getIdTema());

				
	}

	
	
	
	
	public static void validarIdVisita(Long idVisita)
	 throws Validador
	{				
					if(idVisita==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuinternos.seleccione"),
			Messages.getStringToKey("dtVisitasUsuinternos.idVisita"),
			Messages.getStringToKey("dtVisitasUsuinternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuinternos.articuloIdVisita")));
			if(idVisita.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuinternos.invalidoseleccione"),
			Messages.getStringToKey("dtVisitasUsuinternos.idVisita"),
			Messages.getStringToKey("dtVisitasUsuinternos.titulotabla"),
			Messages.getStringToKey("dtVisitasUsuinternos.articuloIdVisita")));			
	}
	public static void validarIdUsuinterno(Long idUsuinterno)
			 throws Validador
				{				
								if(idUsuinterno==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuinternos.invalidoingrese"),
						Messages.getStringToKey("dtVisitasUsuinternos.idUsuinterno"),
						Messages.getStringToKey("dtVisitasUsuinternos.titulotabla"),
						Messages.getStringToKey("dtVisitasUsuinternos.articuloIdUsuinterno")));
					}
	
	
	
	
	public static void validarIdTema(Long idTema)
			 throws Validador
				{				
								if(idTema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitasUsuinternos.invalidoingrese"),
						Messages.getStringToKey("dtVisitasUsuinternos.idTema"),
						Messages.getStringToKey("dtVisitasUsuinternos.titulotabla"),
						Messages.getStringToKey("dtVisitasUsuinternos.articuloIdTema")));
					}
	
		
}