package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCargosUsuexterBk;

/**
 * DT_CARGOS_USUEXTER SERVICIO VALIDACIÓN: ALMACENA LOS CARGOS DE LOS USUARIOS EXTERNOS "CARGO DE USUARIO EXTERNO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCargosUsuexterMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtCargosUsuexterMng.class.getName());
	
	public static void validarDtCargosUsuexterBk(DtCargosUsuexterBk dtCargosUsuexterBk)
	 throws Validador
	{
                //FORANEAS
                if(dtCargosUsuexterBk.getIdUsuextEnti()!=null && dtCargosUsuexterBk.getIdUsuextEnti().longValue()<=0){
			dtCargosUsuexterBk.setIdUsuextEnti(null);
		}
	        if(dtCargosUsuexterBk.getIdCargo()!=null && dtCargosUsuexterBk.getIdCargo().longValue()<=0){
			dtCargosUsuexterBk.setIdCargo(null);
		}
	        if(dtCargosUsuexterBk.getEstado()!=null && dtCargosUsuexterBk.getEstado().longValue()<=0){
			dtCargosUsuexterBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarIdUsuextEnti(dtCargosUsuexterBk.getIdUsuextEnti());

		//validarIdCargo(dtCargosUsuexterBk.getIdCargo());

		
		
		
				
	}

	
	
	
	
	public static void validarIdUsuextEnti(Long idUsuextEnti)
	 throws Validador
	{				
					if(idUsuextEnti==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCargosUsuexter.seleccione"),
			Messages.getStringToKey("dtCargosUsuexter.idUsuextEnti"),
			Messages.getStringToKey("dtCargosUsuexter.titulotabla"),
			Messages.getStringToKey("dtCargosUsuexter.articuloIdUsuextEnti")));
			if(idUsuextEnti.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCargosUsuexter.invalidoseleccione"),
			Messages.getStringToKey("dtCargosUsuexter.idUsuextEnti"),
			Messages.getStringToKey("dtCargosUsuexter.titulotabla"),
			Messages.getStringToKey("dtCargosUsuexter.articuloIdUsuextEnti")));			
	}
	public static void validarIdCargo(Long idCargo)
			 throws Validador
				{				
								if(idCargo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCargosUsuexter.invalidoingrese"),
						Messages.getStringToKey("dtCargosUsuexter.idCargo"),
						Messages.getStringToKey("dtCargosUsuexter.titulotabla"),
						Messages.getStringToKey("dtCargosUsuexter.articuloIdCargo")));
					}
	
	
	
	
		
}