package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSisAdminBk;

/**
 * DT_ENTIDAD_SIS_ADMIN SERVICIO VALIDACIÓN: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtEntidadSisAdminMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtEntidadSisAdminMng.class.getName());
	
	public static void validarDtEntidadSisAdminBk(DtEntidadSisAdminBk dtEntidadSisAdminBk)
	 throws Validador
	{
                //FORANEAS
                if(dtEntidadSisAdminBk.getIdEntidad()!=null && dtEntidadSisAdminBk.getIdEntidad().longValue()<=0){
			dtEntidadSisAdminBk.setIdEntidad(null);
		}
	        if(dtEntidadSisAdminBk.getIdSistAdmi()!=null && dtEntidadSisAdminBk.getIdSistAdmi().longValue()<=0){
			dtEntidadSisAdminBk.setIdSistAdmi(null);
		}
	        if(dtEntidadSisAdminBk.getEstado()!=null && dtEntidadSisAdminBk.getEstado().longValue()<=0){
			dtEntidadSisAdminBk.setEstado(null);
		}
	        
		//VALIDANDO
		//validarIdEntidad(dtEntidadSisAdminBk.getIdEntidad());

		//validarIdSistAdmi(dtEntidadSisAdminBk.getIdSistAdmi());

		
		
		
		
		
		
		
				
	}

	public static void validarIdEntidad(Long idEntidad)
	 throws Validador
	{				
					if(idEntidad==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSisAdmin.seleccione"),
			Messages.getStringToKey("dtEntidadSisAdmin.idEntidad"),
			Messages.getStringToKey("dtEntidadSisAdmin.titulotabla"),
			Messages.getStringToKey("dtEntidadSisAdmin.articuloIdEntidad")));
			if(idEntidad.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSisAdmin.invalidoseleccione"),
			Messages.getStringToKey("dtEntidadSisAdmin.idEntidad"),
			Messages.getStringToKey("dtEntidadSisAdmin.titulotabla"),
			Messages.getStringToKey("dtEntidadSisAdmin.articuloIdEntidad")));			
	}
	public static void validarIdSistAdmi(Long idSistAdmi)
			 throws Validador
				{				
								if(idSistAdmi==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSisAdmin.invalidoingrese"),
						Messages.getStringToKey("dtEntidadSisAdmin.idSistAdmi"),
						Messages.getStringToKey("dtEntidadSisAdmin.titulotabla"),
						Messages.getStringToKey("dtEntidadSisAdmin.articuloIdSistAdmi")));
					}
	
	
	
	
	
	
	
	
		
}