package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtAnexoBk;

/**
 * DT_ANEXO SERVICIO VALIDACIÓN: ALMACENA LOS DOCUMENTOS ANEXADOS EN EL SISTEMA "ANEXO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtAnexoMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtAnexoMng.class.getName());
	
	public static void validarDtAnexoBk(DtAnexoBk dtAnexoBk)
	 throws Validador
	{
                //FORANEAS
                if(dtAnexoBk.getEstado()!=null && dtAnexoBk.getEstado().longValue()<=0){
			dtAnexoBk.setEstado(null);
		}
	        if(dtAnexoBk.getIdTiposervicio()!=null && dtAnexoBk.getIdTiposervicio().longValue()<=0){
			dtAnexoBk.setIdTiposervicio(null);
		}
	        if(dtAnexoBk.getTipoAnexo()!=null && dtAnexoBk.getTipoAnexo().longValue()<=0){
			dtAnexoBk.setTipoAnexo(null);
		}
	        
		//VALIDANDO
		
		
		
		
		//validarFilename(dtAnexoBk.getFilename());

		//validarFilenameoriginal(dtAnexoBk.getFilenameoriginal());

		
		//validarIdTiposervicio(dtAnexoBk.getIdTiposervicio());

		//validarTipoAnexo(dtAnexoBk.getTipoAnexo());

		//validarIdmaestro(dtAnexoBk.getIdmaestro());

		
		
		//validarFlagMaterialCapa(dtAnexoBk.getFlagMaterialCapa());

				
	}

	
	
	
	public static void validarFilename(String filename)
			 throws Validador
				{				
								if(filename==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.invalidoingrese"),
						Messages.getStringToKey("dtAnexo.filename"),
						Messages.getStringToKey("dtAnexo.titulotabla"),
						Messages.getStringToKey("dtAnexo.articuloFilename")));
					}
	
	public static void validarFilenameoriginal(String filenameoriginal)
			 throws Validador
				{				
								if(filenameoriginal==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.invalidoingrese"),
						Messages.getStringToKey("dtAnexo.filenameoriginal"),
						Messages.getStringToKey("dtAnexo.titulotabla"),
						Messages.getStringToKey("dtAnexo.articuloFilenameoriginal")));
					}
	
	
	
	public static void validarIdTiposervicio(Long idTiposervicio)
	 throws Validador
	{				
					if(idTiposervicio==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.seleccione"),
			Messages.getStringToKey("dtAnexo.idTiposervicio"),
			Messages.getStringToKey("dtAnexo.titulotabla"),
			Messages.getStringToKey("dtAnexo.articuloIdTiposervicio")));
			if(idTiposervicio.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.invalidoseleccione"),
			Messages.getStringToKey("dtAnexo.idTiposervicio"),
			Messages.getStringToKey("dtAnexo.titulotabla"),
			Messages.getStringToKey("dtAnexo.articuloIdTiposervicio")));			
	}
	public static void validarTipoAnexo(Long tipoAnexo)
			 throws Validador
				{				
								if(tipoAnexo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.invalidoingrese"),
						Messages.getStringToKey("dtAnexo.tipoAnexo"),
						Messages.getStringToKey("dtAnexo.titulotabla"),
						Messages.getStringToKey("dtAnexo.articuloTipoAnexo")));
					}
	
	
	public static void validarIdmaestro(Long idmaestro)
	 throws Validador
	{				
					if(idmaestro==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.seleccione"),
			Messages.getStringToKey("dtAnexo.idmaestro"),
			Messages.getStringToKey("dtAnexo.titulotabla"),
			Messages.getStringToKey("dtAnexo.articuloIdmaestro")));
			if(idmaestro.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.invalidoseleccione"),
			Messages.getStringToKey("dtAnexo.idmaestro"),
			Messages.getStringToKey("dtAnexo.titulotabla"),
			Messages.getStringToKey("dtAnexo.articuloIdmaestro")));			
	}
	
	
	
	public static void validarFlagMaterialCapa(Long flagMaterialCapa)
	 throws Validador
	{				
					if(flagMaterialCapa==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAnexo.invalidoingrese"),
			Messages.getStringToKey("dtAnexo.flagMaterialCapa"),
			Messages.getStringToKey("dtAnexo.titulotabla"),
			Messages.getStringToKey("dtAnexo.articuloFlagMaterialCapa")));
	}	
	
		
}