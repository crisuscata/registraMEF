package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsPaisesBk;

/**
 * MS_PAISES SERVICIO VALIDACIÓN: ALMACENA A LOS PAISES REGISTRADOS EN EL SISTEMA "PAÍSES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsPaisesMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsPaisesMng.class.getName());
	
	public static void validarMsPaisesBk(MsPaisesBk msPaisesBk)
	 throws Validador
	{
                //FORANEAS
                if(msPaisesBk.getEstado()!=null && msPaisesBk.getEstado().longValue()<=0){
			msPaisesBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		//validarPaisNombre(msPaisesBk.getPaisNombre());
		if(msPaisesBk.getPaisNombre()!=null){
				if(msPaisesBk.getPaisNombre().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msPaises.noexceder"),
							Messages.getStringToKey("msPaises.paisNombre"),
							Messages.getStringToKey("msPaises.titulotabla"),
							100,
							Messages.getStringToKey("msPaises.articuloPaisNombre")
									));				
//				msPaisesBk.setPaisNombre(msPaisesBk.getPaisNombre().toUpperCase());
				}

		
		
		
		
		
		
		
		
		//validarAcronimo(msPaisesBk.getAcronimo());
		if(msPaisesBk.getAcronimo()!=null){
				if(msPaisesBk.getAcronimo().trim().length()>20)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msPaises.noexceder"),
							Messages.getStringToKey("msPaises.acronimo"),
							Messages.getStringToKey("msPaises.titulotabla"),
							20,
							Messages.getStringToKey("msPaises.articuloAcronimo")
									));				
//				msPaisesBk.setAcronimo(msPaisesBk.getAcronimo().toUpperCase());
				}

				
	}

	public static void validarPaisNombre(String paisNombre)
	 throws Validador
	{					
			if(paisNombre==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msPaises.ingrese"),
			Messages.getStringToKey("msPaises.paisNombre"),
			Messages.getStringToKey("msPaises.titulotabla"),
			Messages.getStringToKey("msPaises.articuloPaisNombre")));
			if(paisNombre.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msPaises.invalidoingrese"),
			Messages.getStringToKey("msPaises.paisNombre"),
			Messages.getStringToKey("msPaises.titulotabla")));						
			if(paisNombre!=null){
				if(paisNombre.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msPaises.noexceder"),
			Messages.getStringToKey("msPaises.paisNombre"),
			Messages.getStringToKey("msPaises.titulotabla"),100,
			Messages.getStringToKey("msPaises.articuloPaisNombre")));
				}
	}
	
	
	
	
	
	
	
	
	public static void validarAcronimo(String acronimo)
	 throws Validador
	{					
			if(acronimo==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msPaises.ingrese"),
			Messages.getStringToKey("msPaises.acronimo"),
			Messages.getStringToKey("msPaises.titulotabla"),
			Messages.getStringToKey("msPaises.articuloAcronimo")));
			if(acronimo.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msPaises.invalidoingrese"),
			Messages.getStringToKey("msPaises.acronimo"),
			Messages.getStringToKey("msPaises.titulotabla")));						
			if(acronimo!=null){
				if(acronimo.trim().length()>20)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msPaises.noexceder"),
			Messages.getStringToKey("msPaises.acronimo"),
			Messages.getStringToKey("msPaises.titulotabla"),20,
			Messages.getStringToKey("msPaises.articuloAcronimo")));
				}
	}
		
}