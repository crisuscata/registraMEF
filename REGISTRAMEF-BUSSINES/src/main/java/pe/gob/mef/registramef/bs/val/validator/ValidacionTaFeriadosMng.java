package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.TaFeriadosBk;

/**
 * TA_FERIADOS SERVICIO VALIDACIÓN: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL AÑO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionTaFeriadosMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionTaFeriadosMng.class.getName());
	
	public static void validarTaFeriadosBk(TaFeriadosBk taFeriadosBk)
	 throws Validador
	{
                //FORANEAS
                if(taFeriadosBk.getFeEstado()!=null && taFeriadosBk.getFeEstado().longValue()<=0){
			taFeriadosBk.setFeEstado(null);
		}
	        
		//VALIDANDO
		
		//validarFeDesc(taFeriadosBk.getFeDesc());
		if(taFeriadosBk.getFeDesc()!=null){
				if(taFeriadosBk.getFeDesc().trim().length()>255)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("taFeriados.noexceder"),
							Messages.getStringToKey("taFeriados.feDesc"),
							Messages.getStringToKey("taFeriados.titulotabla"),
							255,
							Messages.getStringToKey("taFeriados.articuloFeDesc")
									));				
//				taFeriadosBk.setFeDesc(taFeriadosBk.getFeDesc().toUpperCase());
				}

		
		
		
		
		
				
	}

	public static void validarFeDesc(String feDesc)
	 throws Validador
	{					
			if(feDesc==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("taFeriados.ingrese"),
			Messages.getStringToKey("taFeriados.feDesc"),
			Messages.getStringToKey("taFeriados.titulotabla"),
			Messages.getStringToKey("taFeriados.articuloFeDesc")));
			if(feDesc.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("taFeriados.invalidoingrese"),
			Messages.getStringToKey("taFeriados.feDesc"),
			Messages.getStringToKey("taFeriados.titulotabla")));						
			if(feDesc!=null){
				if(feDesc.trim().length()>255)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("taFeriados.noexceder"),
			Messages.getStringToKey("taFeriados.feDesc"),
			Messages.getStringToKey("taFeriados.titulotabla"),255,
			Messages.getStringToKey("taFeriados.articuloFeDesc")));
				}
	}
	
	
	
	
	
		
}