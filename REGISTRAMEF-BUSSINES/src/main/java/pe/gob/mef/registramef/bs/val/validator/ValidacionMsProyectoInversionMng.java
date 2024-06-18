package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsProyectoInversionBk;

/**
 * MS_PROYECTO_INVERSION SERVICIO VALIDACIÓN: ALMACENA LOS DATOS DE PROYECTOS DE INVERSIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsProyectoInversionMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsProyectoInversionMng.class.getName());
	
	public static void validarMsProyectoInversionBk(MsProyectoInversionBk msProyectoInversionBk)
	 throws Validador
	{
                //FORANEAS
                if(msProyectoInversionBk.getIdSede()!=null && msProyectoInversionBk.getIdSede().longValue()<=0){
			msProyectoInversionBk.setIdSede(null);
		}
	        if(msProyectoInversionBk.getEstado()!=null && msProyectoInversionBk.getEstado().longValue()<=0){
			msProyectoInversionBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		//validarCodigo(msProyectoInversionBk.getCodigo());
		if(msProyectoInversionBk.getCodigo()!=null){
				if(msProyectoInversionBk.getCodigo().trim().length()>7)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msProyectoInversion.noexceder"),
							Messages.getStringToKey("msProyectoInversion.codigo"),
							Messages.getStringToKey("msProyectoInversion.titulotabla"),
							7,
							Messages.getStringToKey("msProyectoInversion.articuloCodigo")
									));				
//				msProyectoInversionBk.setCodigo(msProyectoInversionBk.getCodigo().toUpperCase());
				}

		
		//validarNombre(msProyectoInversionBk.getNombre());
		if(msProyectoInversionBk.getNombre()!=null){
				if(msProyectoInversionBk.getNombre().trim().length()>470)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msProyectoInversion.noexceder"),
							Messages.getStringToKey("msProyectoInversion.nombre"),
							Messages.getStringToKey("msProyectoInversion.titulotabla"),
							470,
							Messages.getStringToKey("msProyectoInversion.articuloNombre")
							));				
//				msProyectoInversionBk.setNombre(msProyectoInversionBk.getNombre().toUpperCase());
				}

		//validarIdSede(msProyectoInversionBk.getIdSede());

		
		
		
		
		
		
		
				
	}

	public static void validarCodigo(String codigo)
	 throws Validador
	{					
			if(codigo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.ingrese"),
			Messages.getStringToKey("msProyectoInversion.codigo"),
			Messages.getStringToKey("msProyectoInversion.titulotabla"),
			Messages.getStringToKey("msProyectoInversion.articuloCodigo")));
			if(codigo.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.invalidoingrese"),
			Messages.getStringToKey("msProyectoInversion.codigo"),
			Messages.getStringToKey("msProyectoInversion.titulotabla")));						
			if(codigo!=null){
				if(codigo.trim().length()>7)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.noexceder"),
			Messages.getStringToKey("msProyectoInversion.codigo"),
			Messages.getStringToKey("msProyectoInversion.titulotabla"),7,
			Messages.getStringToKey("msProyectoInversion.articuloCodigo")));
				}
	}
	
	public static void validarNombre(String nombre)
	 throws Validador
	{					
			if(nombre==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.ingrese"),
			Messages.getStringToKey("msProyectoInversion.nombre"),
			Messages.getStringToKey("msProyectoInversion.titulotabla"),
			Messages.getStringToKey("msProyectoInversion.articuloNombre")));
			if(nombre.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.invalidoingrese"),
			Messages.getStringToKey("msProyectoInversion.nombre"),
			Messages.getStringToKey("msProyectoInversion.titulotabla"),
			Messages.getStringToKey("msProyectoInversion.articuloNombre")));						
			if(nombre!=null){
				if(nombre.trim().length()>470)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.noexceder"),
			Messages.getStringToKey("msProyectoInversion.nombre"),
			Messages.getStringToKey("msProyectoInversion.titulotabla"),470,
			Messages.getStringToKey("msProyectoInversion.articuloNombre")));
				}
	}
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msProyectoInversion.invalidoingrese"),
						Messages.getStringToKey("msProyectoInversion.idSede"),
						Messages.getStringToKey("msProyectoInversion.titulotabla"),
						Messages.getStringToKey("msProyectoInversion.articuloIdSede")));
					}
	
	
	
	
	
	
	
	
		
}