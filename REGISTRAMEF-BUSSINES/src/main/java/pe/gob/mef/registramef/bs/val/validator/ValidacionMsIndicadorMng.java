package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsIndicadorBk;

/**
 * MS_INDICADOR SERVICIO VALIDACIÓN: ALMACENA LOS INDICADORES REGISTRADOS EN EL SISTEMA "INDICADORES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionMsIndicadorMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionMsIndicadorMng.class.getName());
	
	public static void validarMsIndicadorBk(MsIndicadorBk msIndicadorBk)
	 throws Validador
	{
                //FORANEAS
                if(msIndicadorBk.getIdObjetvo()!=null && msIndicadorBk.getIdObjetvo().longValue()<=0){
			msIndicadorBk.setIdObjetvo(null);
		}
	        if(msIndicadorBk.getIdNivlstrat()!=null && msIndicadorBk.getIdNivlstrat().longValue()<=0){
			msIndicadorBk.setIdNivlstrat(null);
		}
	        if(msIndicadorBk.getIdFactor()!=null && msIndicadorBk.getIdFactor().longValue()<=0){
			msIndicadorBk.setIdFactor(null);
		}
	        if(msIndicadorBk.getIdFuenteinfor()!=null && msIndicadorBk.getIdFuenteinfor().longValue()<=0){
			msIndicadorBk.setIdFuenteinfor(null);
		}
	        if(msIndicadorBk.getEstado()!=null && msIndicadorBk.getEstado().longValue()<=0){
			msIndicadorBk.setEstado(null);
		}
	        
		//VALIDANDO
		
		//validarDescripcion(msIndicadorBk.getDescripcion());
		if(msIndicadorBk.getDescripcion()!=null){
				if(msIndicadorBk.getDescripcion().trim().length()>500)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msIndicador.noexceder"),
							Messages.getStringToKey("msIndicador.descripcion"),
							Messages.getStringToKey("msIndicador.titulotabla"),
							500,
							Messages.getStringToKey("msIndicador.articuloDescripcion")
							));				
//				msIndicadorBk.setDescripcion(msIndicadorBk.getDescripcion().toUpperCase());
				}

		
		//validarFormula(msIndicadorBk.getFormula());
		if(msIndicadorBk.getFormula()!=null){
				if(msIndicadorBk.getFormula().trim().length()>500)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("msIndicador.noexceder"),
							Messages.getStringToKey("msIndicador.formula"),
							Messages.getStringToKey("msIndicador.titulotabla"),
							500,
							Messages.getStringToKey("msIndicador.articuloFormula")
							));				
//				msIndicadorBk.setFormula(msIndicadorBk.getFormula().toUpperCase());
				}

		
		
		
		
		//validarIdObjetvo(msIndicadorBk.getIdObjetvo());

		//validarIdNivlstrat(msIndicadorBk.getIdNivlstrat());

		//validarIdFactor(msIndicadorBk.getIdFactor());

		//validarIdFuenteinfor(msIndicadorBk.getIdFuenteinfor());

		
		
		
				
	}

	public static void validarDescripcion(String descripcion)
	 throws Validador
	{					
			if(descripcion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.ingrese"),
			Messages.getStringToKey("msIndicador.descripcion"),
			Messages.getStringToKey("msIndicador.titulotabla"),
			Messages.getStringToKey("msIndicador.articuloDescripcion")));
			if(descripcion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.invalidoingrese"),
			Messages.getStringToKey("msIndicador.descripcion"),
			Messages.getStringToKey("msIndicador.titulotabla"),
			Messages.getStringToKey("msIndicador.articuloDescripcion")));						
			if(descripcion!=null){
				if(descripcion.trim().length()>500)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.noexceder"),
			Messages.getStringToKey("msIndicador.descripcion"),
			Messages.getStringToKey("msIndicador.titulotabla"),500,
			Messages.getStringToKey("msIndicador.articuloDescripcion")));
				}
	}
	
	public static void validarFormula(String formula)
	 throws Validador
	{					
			if(formula==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.ingrese"),
			Messages.getStringToKey("msIndicador.formula"),
			Messages.getStringToKey("msIndicador.titulotabla"),
			Messages.getStringToKey("msIndicador.articuloFormula")));
			if(formula.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.invalidoingrese"),
			Messages.getStringToKey("msIndicador.formula"),
			Messages.getStringToKey("msIndicador.titulotabla"),
			Messages.getStringToKey("msIndicador.articuloFormula")));						
			if(formula!=null){
				if(formula.trim().length()>500)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.noexceder"),
			Messages.getStringToKey("msIndicador.formula"),
			Messages.getStringToKey("msIndicador.titulotabla"),500,
			Messages.getStringToKey("msIndicador.articuloFormula")));
				}
	}
	
	
	
	
	public static void validarIdObjetvo(Long idObjetvo)
			 throws Validador
				{				
								if(idObjetvo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.invalidoingrese"),
						Messages.getStringToKey("msIndicador.idObjetvo"),
						Messages.getStringToKey("msIndicador.titulotabla"),
						Messages.getStringToKey("msIndicador.articuloIdObjetvo")));
					}
	
	public static void validarIdNivlstrat(Long idNivlstrat)
			 throws Validador
				{				
								if(idNivlstrat==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.invalidoingrese"),
						Messages.getStringToKey("msIndicador.idNivlstrat"),
						Messages.getStringToKey("msIndicador.titulotabla"),
						Messages.getStringToKey("msIndicador.articuloIdNivlstrat")));
					}
	
	public static void validarIdFactor(Long idFactor)
			 throws Validador
				{				
								if(idFactor==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.invalidoingrese"),
						Messages.getStringToKey("msIndicador.idFactor"),
						Messages.getStringToKey("msIndicador.titulotabla"),
						Messages.getStringToKey("msIndicador.articuloIdFactor")));
					}
	
	public static void validarIdFuenteinfor(Long idFuenteinfor)
			 throws Validador
				{				
								if(idFuenteinfor==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("msIndicador.invalidoingrese"),
						Messages.getStringToKey("msIndicador.idFuenteinfor"),
						Messages.getStringToKey("msIndicador.titulotabla"),
						Messages.getStringToKey("msIndicador.articuloIdFuenteinfor")));
					}
	
	
	
	
		
}