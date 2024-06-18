package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaCargoUserBk;

/**
 * MS_ALERTA_CARGO_USER SERVICIO VALIDACIÓN: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsAlertaCargoUserMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsAlertaCargoUserMng.class.getName());
	
	public static void validarMsAlertaCargoUserBk(MsAlertaCargoUserBk msAlertaCargoUserBk)
	 throws Validador
	{
                //FORANEAS
                if(msAlertaCargoUserBk.getIdalerta()!=null && msAlertaCargoUserBk.getIdalerta().longValue()<=0){
			msAlertaCargoUserBk.setIdalerta(null);
		}
	        if(msAlertaCargoUserBk.getIdcargo()!=null && msAlertaCargoUserBk.getIdcargo().longValue()<=0){
			msAlertaCargoUserBk.setIdcargo(null);
		}
	        if(msAlertaCargoUserBk.getEstado()!=null && msAlertaCargoUserBk.getEstado().longValue()<=0){
			msAlertaCargoUserBk.setEstado(null);
		}
	        
		//VALIDANDO
		//validarIdalerta(msAlertaCargoUserBk.getIdalerta());

		//validarIdcargo(msAlertaCargoUserBk.getIdcargo());

		
		
		
		
		
		
		
				
	}

	public static void validarIdalerta(Long idalerta)
	 throws Validador
	{				
					if(idalerta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlertaCargoUser.seleccione"),
			Messages.getStringToKey("msAlertaCargoUser.idalerta"),
			Messages.getStringToKey("msAlertaCargoUser.titulotabla"),
			Messages.getStringToKey("msAlertaCargoUser.articuloIdalerta")));
			if(idalerta.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlertaCargoUser.invalidoseleccione"),
			Messages.getStringToKey("msAlertaCargoUser.idalerta"),
			Messages.getStringToKey("msAlertaCargoUser.titulotabla"),
			Messages.getStringToKey("msAlertaCargoUser.articuloIdalerta")));			
	}
	public static void validarIdcargo(Long idcargo)
			 throws Validador
				{				
								if(idcargo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msAlertaCargoUser.invalidoingrese"),
						Messages.getStringToKey("msAlertaCargoUser.idcargo"),
						Messages.getStringToKey("msAlertaCargoUser.titulotabla"),
						Messages.getStringToKey("msAlertaCargoUser.articuloIdcargo")));
					}
	
	
	
	
	
	
	
	
		
}