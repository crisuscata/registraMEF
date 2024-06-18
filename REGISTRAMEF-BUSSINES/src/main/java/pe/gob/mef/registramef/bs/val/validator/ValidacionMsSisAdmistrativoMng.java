package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsSisAdmistrativoBk;

/**
 * MS_SIS_ADMISTRATIVO SERVICIO VALIDACIÓN: ALMACENA LOS SISTEMAS ADMINISTRATIVOS REGISTRADOS EN EL SISTEMA "SISTEMA ADMINISTRATIVO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsSisAdmistrativoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsSisAdmistrativoMng.class.getName());
	
	public static void validarMsSisAdmistrativoBk(MsSisAdmistrativoBk msSisAdmistrativoBk)
	 throws Validador
	{
                //FORANEAS
                if(msSisAdmistrativoBk.getEstado()!=null && msSisAdmistrativoBk.getEstado().longValue()<=0){
			msSisAdmistrativoBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		//validarDescripcion(msSisAdmistrativoBk.getDescripcion());
		if(msSisAdmistrativoBk.getDescripcion()!=null){
				if(msSisAdmistrativoBk.getDescripcion().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msSisAdmistrativo.noexceder"),
							Messages.getStringToKey("msSisAdmistrativo.descripcion"),
							Messages.getStringToKey("msSisAdmistrativo.titulotabla"),
							100,
							Messages.getStringToKey("msSisAdmistrativo.articuloDescripcion")
									));				
//				msSisAdmistrativoBk.setDescripcion(msSisAdmistrativoBk.getDescripcion().toUpperCase());
				}

		
		
		
		
		
		
		
		//validarFlagasocencuesta(msSisAdmistrativoBk.getFlagasocencuesta());

		
		//validarAbreviatura(msSisAdmistrativoBk.getAbreviatura());
		if(msSisAdmistrativoBk.getAbreviatura()!=null){
				if(msSisAdmistrativoBk.getAbreviatura().trim().length()>10)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msSisAdmistrativo.noexceder"),
							Messages.getStringToKey("msSisAdmistrativo.abreviatura"),
							Messages.getStringToKey("msSisAdmistrativo.titulotabla"),
							10,
							Messages.getStringToKey("msSisAdmistrativo.articuloAbreviatura")
									));				
//				msSisAdmistrativoBk.setAbreviatura(msSisAdmistrativoBk.getAbreviatura().toUpperCase());
				}

				
	}

	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.ingrese"),
			Messages.getStringToKey("msSisAdmistrativo.descripcion"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla"),
			Messages.getStringToKey("msSisAdmistrativo.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.invalidoingrese"),
			Messages.getStringToKey("msSisAdmistrativo.descripcion"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.noexceder"),
			Messages.getStringToKey("msSisAdmistrativo.descripcion"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla"),100,
			Messages.getStringToKey("msSisAdmistrativo.articuloDescripcion")));
				}
	}
	
	
	
	
	
	
	
	
	public static void validarFlagasocencuesta(Integer flagasocencuesta)
	 throws Validador
	{				
					if(flagasocencuesta==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.invalidoingrese"),
			Messages.getStringToKey("msSisAdmistrativo.flagasocencuesta"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla"),
			Messages.getStringToKey("msSisAdmistrativo.articuloFlagasocencuesta")));
	}	
	
	
	public static void validarAbreviatura(String abreviatura)
	 throws Validador
	{					
			if(abreviatura==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.ingrese"),
			Messages.getStringToKey("msSisAdmistrativo.abreviatura"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla"),
			Messages.getStringToKey("msSisAdmistrativo.articuloAbreviatura")));
			if(abreviatura.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.invalidoingrese"),
			Messages.getStringToKey("msSisAdmistrativo.abreviatura"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla")));						
			if(abreviatura!=null){
				if(abreviatura.trim().length()>10)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msSisAdmistrativo.noexceder"),
			Messages.getStringToKey("msSisAdmistrativo.abreviatura"),
			Messages.getStringToKey("msSisAdmistrativo.titulotabla"),10,
			Messages.getStringToKey("msSisAdmistrativo.articuloAbreviatura")));
				}
	}
		
}