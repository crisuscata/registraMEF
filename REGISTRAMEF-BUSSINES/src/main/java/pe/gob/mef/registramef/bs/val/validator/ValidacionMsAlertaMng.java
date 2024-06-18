package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaBk;

/**
 * MS_ALERTA SERVICIO VALIDACIÓN: ALMACENA LAS ALERTAS GENERADAS EN EL SISTMA "ALERTAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsAlertaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsAlertaMng.class.getName());
	
	public static void validarMsAlertaBk(MsAlertaBk msAlertaBk)
	 throws Validador
	{
                //FORANEAS
                if(msAlertaBk.getDia()!=null && msAlertaBk.getDia().longValue()<=0){
			msAlertaBk.setDia(null);
		}
	        if(msAlertaBk.getHora()!=null && msAlertaBk.getHora().longValue()<=0){
			msAlertaBk.setHora(null);
		}
	        if(msAlertaBk.getIdCaracterst()!=null && msAlertaBk.getIdCaracterst().longValue()<=0){
			msAlertaBk.setIdCaracterst(null);
		}
	        if(msAlertaBk.getEstado()!=null && msAlertaBk.getEstado().longValue()<=0){
			msAlertaBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		
		//validarDia(msAlertaBk.getDia());

		//validarHora(msAlertaBk.getHora());

		
		
		
		//validarOtrosDestin(msAlertaBk.getOtrosDestin());
		if(msAlertaBk.getOtrosDestin()!=null){
				if(msAlertaBk.getOtrosDestin().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msAlerta.noexceder"),
							Messages.getStringToKey("msAlerta.otrosDestin"),
							Messages.getStringToKey("msAlerta.titulotabla"),
							100,
							Messages.getStringToKey("msAlerta.articuloOtrosDestin")
									));				
//				msAlertaBk.setOtrosDestin(msAlertaBk.getOtrosDestin().toUpperCase());
				}

		//validarIdCaracterst(msAlertaBk.getIdCaracterst());

		
		
		
				
	}

	
	public static void validarDia(Integer dia)
			 throws Validador
				{				
								if(dia==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlerta.invalidoingrese"),
						Messages.getStringToKey("msAlerta.dia"),
						Messages.getStringToKey("msAlerta.titulotabla"),
						Messages.getStringToKey("msAlerta.articuloDia")));
					}
	
	public static void validarHora(Integer hora)
			 throws Validador
				{				
								if(hora==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlerta.invalidoingrese"),
						Messages.getStringToKey("msAlerta.hora"),
						Messages.getStringToKey("msAlerta.titulotabla"),
						Messages.getStringToKey("msAlerta.articuloHora")));
					}
	
	
	
	
	public static void validarOtrosDestin(String otrosDestin)
	 throws Validador
	{					
			if(otrosDestin==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlerta.ingrese"),
			Messages.getStringToKey("msAlerta.otrosDestin"),
			Messages.getStringToKey("msAlerta.titulotabla"),
			Messages.getStringToKey("msAlerta.articuloOtrosDestin")));
			if(otrosDestin.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlerta.invalidoingrese"),
			Messages.getStringToKey("msAlerta.otrosDestin"),
			Messages.getStringToKey("msAlerta.titulotabla")));						
			if(otrosDestin!=null){
				if(otrosDestin.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlerta.noexceder"),
			Messages.getStringToKey("msAlerta.otrosDestin"),
			Messages.getStringToKey("msAlerta.titulotabla"),100,
			Messages.getStringToKey("msAlerta.articuloOtrosDestin")));
				}
	}
	public static void validarIdCaracterst(Long idCaracterst)
			 throws Validador
				{				
								if(idCaracterst==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlerta.invalidoingrese"),
						Messages.getStringToKey("msAlerta.idCaracterst"),
						Messages.getStringToKey("msAlerta.titulotabla"),
						Messages.getStringToKey("msAlerta.articuloIdCaracterst")));
					}
	
	
	
	
		
}