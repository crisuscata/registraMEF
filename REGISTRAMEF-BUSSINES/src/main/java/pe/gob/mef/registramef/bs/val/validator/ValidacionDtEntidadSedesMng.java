package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSedesBk;

/**
 * DT_ENTIDAD_SEDES SERVICIO VALIDACIÓN: ALMACENA LAS DISTINTAS SEDES ASIGNADAS A LA ENTIDAD "SEDES ASIGNADAS A LA ENTIDAD"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtEntidadSedesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtEntidadSedesMng.class.getName());
	
	public static void validarDtEntidadSedesBk(DtEntidadSedesBk dtEntidadSedesBk)
	 throws Validador
	{
                //FORANEAS
                if(dtEntidadSedesBk.getEstado()!=null && dtEntidadSedesBk.getEstado().longValue()<=0){
			dtEntidadSedesBk.setEstado(null);
		}
	        if(dtEntidadSedesBk.getIdEntidad()!=null && dtEntidadSedesBk.getIdEntidad().longValue()<=0){
			dtEntidadSedesBk.setIdEntidad(null);
		}
	        if(dtEntidadSedesBk.getIdSede()!=null && dtEntidadSedesBk.getIdSede().longValue()<=0){
			dtEntidadSedesBk.setIdSede(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarEstado(dtEntidadSedesBk.getEstado());

		//validarIdEntidad(dtEntidadSedesBk.getIdEntidad());

		//validarIdSede(dtEntidadSedesBk.getIdSede());

		
		
				
	}

	
	
	
	public static void validarEstado(Long estado)
			 throws Validador
				{				
								if(estado==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSedes.invalidoingrese"),
						Messages.getStringToKey("dtEntidadSedes.estado"),
						Messages.getStringToKey("dtEntidadSedes.titulotabla"),
						Messages.getStringToKey("dtEntidadSedes.articuloEstado")));
					}
	
	
	public static void validarIdEntidad(Long idEntidad)
	 throws Validador
	{				
					if(idEntidad==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSedes.seleccione"),
			Messages.getStringToKey("dtEntidadSedes.idEntidad"),
			Messages.getStringToKey("dtEntidadSedes.titulotabla"),
			Messages.getStringToKey("dtEntidadSedes.articuloIdEntidad")));
			if(idEntidad.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSedes.invalidoseleccione"),
			Messages.getStringToKey("dtEntidadSedes.idEntidad"),
			Messages.getStringToKey("dtEntidadSedes.titulotabla"),
			Messages.getStringToKey("dtEntidadSedes.articuloIdEntidad")));			
	}
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtEntidadSedes.invalidoingrese"),
						Messages.getStringToKey("dtEntidadSedes.idSede"),
						Messages.getStringToKey("dtEntidadSedes.titulotabla"),
						Messages.getStringToKey("dtEntidadSedes.articuloIdSede")));
					}
	
	
	
		
}