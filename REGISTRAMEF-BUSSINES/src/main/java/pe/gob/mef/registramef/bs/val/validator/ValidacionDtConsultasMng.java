package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasBk;

/**
 * DT_CONSULTAS SERVICIO VALIDACIÓN: ALMACENA LOS DATOS REGISTRADOS EN UNA CONSULTA "CONSULTAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtConsultasMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtConsultasMng.class.getName());
	
	public static void validarDtConsultasBk(DtConsultasBk dtConsultasBk)
	 throws Validador
	{
                //FORANEAS
                if(dtConsultasBk.getEstado()!=null && dtConsultasBk.getEstado().longValue()<=0){
			dtConsultasBk.setEstado(null);
		}
	        if(dtConsultasBk.getIdPrestservic()!=null && dtConsultasBk.getIdPrestservic().longValue()<=0){
			dtConsultasBk.setIdPrestservic(null);
		}
	        if(dtConsultasBk.getIdModalidad()!=null && dtConsultasBk.getIdModalidad().longValue()<=0){
			dtConsultasBk.setIdModalidad(null);
		}
	        if(dtConsultasBk.getIdUsuexterno()!=null && dtConsultasBk.getIdUsuexterno().longValue()<=0){
			dtConsultasBk.setIdUsuexterno(null);
		}
	        if(dtConsultasBk.getIdUsuinterno()!=null && dtConsultasBk.getIdUsuinterno().longValue()<=0){
			dtConsultasBk.setIdUsuinterno(null);
		}
	        if(dtConsultasBk.getIdEntidad()!=null && dtConsultasBk.getIdEntidad().longValue()<=0){
			dtConsultasBk.setIdEntidad(null);
		}
	        if(dtConsultasBk.getIdTema()!=null && dtConsultasBk.getIdTema().longValue()<=0){
			dtConsultasBk.setIdTema(null);
		}
	        if(dtConsultasBk.getIdSubtema()!=null && dtConsultasBk.getIdSubtema().longValue()<=0){
			dtConsultasBk.setIdSubtema(null);
		}
	        if(dtConsultasBk.getIdOrigen()!=null && dtConsultasBk.getIdOrigen().longValue()<=0){
			dtConsultasBk.setIdOrigen(null);
		}
	        if(dtConsultasBk.getIdCargo()!=null && dtConsultasBk.getIdCargo().longValue()<=0){
			dtConsultasBk.setIdCargo(null);
		}
	        if(dtConsultasBk.getIdSede()!=null && dtConsultasBk.getIdSede().longValue()<=0){
			dtConsultasBk.setIdSede(null);
		}
	        if(dtConsultasBk.getIdSistAdm()!=null && dtConsultasBk.getIdSistAdm().longValue()<=0){
			dtConsultasBk.setIdSistAdm(null);
		}
	        
		//VALIDANDO
		//validarFechaConsu(dtConsultasBk.getFechaConsu());

		
		//validarDetalle(dtConsultasBk.getDetalle());
		if(dtConsultasBk.getDetalle()!=null){
				if(dtConsultasBk.getDetalle().trim().length()>500)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtConsultas.noexceder"),
							Messages.getStringToKey("dtConsultas.detalle"),
							Messages.getStringToKey("dtConsultas.titulotabla"),
							500,
							Messages.getStringToKey("dtConsultas.articuloDetalle")
							));				
//				dtConsultasBk.setDetalle(dtConsultasBk.getDetalle().toUpperCase());
				}

		
		//validarRespuesta(dtConsultasBk.getRespuesta());
		if(dtConsultasBk.getRespuesta()!=null){
				if(dtConsultasBk.getRespuesta().trim().length()>600)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtConsultas.noexceder"),
							Messages.getStringToKey("dtConsultas.respuesta"),
							Messages.getStringToKey("dtConsultas.titulotabla"),
							600,
							Messages.getStringToKey("dtConsultas.articuloRespuesta")
							));				
//				dtConsultasBk.setRespuesta(dtConsultasBk.getRespuesta().toUpperCase());
				}

		
		
		
		
		
		//validarIdPrestservic(dtConsultasBk.getIdPrestservic());

		//validarIdModalidad(dtConsultasBk.getIdModalidad());

		//validarIdUsuexterno(dtConsultasBk.getIdUsuexterno());

		//validarIdUsuinterno(dtConsultasBk.getIdUsuinterno());

		//validarIdEntidad(dtConsultasBk.getIdEntidad());

		//validarIdTema(dtConsultasBk.getIdTema());

		//validarIdSubtema(dtConsultasBk.getIdSubtema());

		//validarIdOrigen(dtConsultasBk.getIdOrigen());

		
		
		//validarIdCargo(dtConsultasBk.getIdCargo());

		//validarIdSede(dtConsultasBk.getIdSede());

		//validarIdSistAdm(dtConsultasBk.getIdSistAdm());

		
		//validarCorreoUsuext(dtConsultasBk.getCorreoUsuext());
		if(dtConsultasBk.getCorreoUsuext()!=null){
				if(dtConsultasBk.getCorreoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtConsultas.noexceder"),
							Messages.getStringToKey("dtConsultas.correoUsuext"),
							Messages.getStringToKey("dtConsultas.titulotabla"),
							50,
							Messages.getStringToKey("dtConsultas.articuloCorreoUsuext")
									));				
//				dtConsultasBk.setCorreoUsuext(dtConsultasBk.getCorreoUsuext().toUpperCase());
				}

		
		//validarFijoUsuext(dtConsultasBk.getFijoUsuext());
		if(dtConsultasBk.getFijoUsuext()!=null){
				if(dtConsultasBk.getFijoUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtConsultas.noexceder"),
							Messages.getStringToKey("dtConsultas.fijoUsuext"),
							Messages.getStringToKey("dtConsultas.titulotabla"),
							50,
							Messages.getStringToKey("dtConsultas.articuloFijoUsuext")
									));				
//				dtConsultasBk.setFijoUsuext(dtConsultasBk.getFijoUsuext().toUpperCase());
				}

		
		//validarCelularUsuext(dtConsultasBk.getCelularUsuext());
		if(dtConsultasBk.getCelularUsuext()!=null){
				if(dtConsultasBk.getCelularUsuext().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtConsultas.noexceder"),
							Messages.getStringToKey("dtConsultas.celularUsuext"),
							Messages.getStringToKey("dtConsultas.titulotabla"),
							50,
							Messages.getStringToKey("dtConsultas.articuloCelularUsuext")
									));				
//				dtConsultasBk.setCelularUsuext(dtConsultasBk.getCelularUsuext().toUpperCase());
				}

		//validarFechaFinalizacion(dtConsultasBk.getFechaFinalizacion());

		//validarFechaSoli(dtConsultasBk.getFechaSoli());

				
	}

	public static void validarFechaConsu(Timestamp fechaConsu)
	 throws Validador
	{				
					if(fechaConsu==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.fechaConsu"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloFechaConsu")));
		}
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.ingrese"),
			Messages.getStringToKey("dtConsultas.detalle"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.detalle"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloDetalle")));						
			if(detalle!=null){
				if(detalle.trim().length()>500)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.noexceder"),
			Messages.getStringToKey("dtConsultas.detalle"),
			Messages.getStringToKey("dtConsultas.titulotabla"),500,
			Messages.getStringToKey("dtConsultas.articuloDetalle")));
				}
	}
	
	public static void validarRespuesta(String respuesta)
	 throws Validador
	{					
			if(respuesta==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.ingrese"),
			Messages.getStringToKey("dtConsultas.respuesta"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloRespuesta")));
			if(respuesta.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.respuesta"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloRespuesta")));						
			if(respuesta!=null){
				if(respuesta.trim().length()>600)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.noexceder"),
			Messages.getStringToKey("dtConsultas.respuesta"),
			Messages.getStringToKey("dtConsultas.titulotabla"),600,
			Messages.getStringToKey("dtConsultas.articuloRespuesta")));
				}
	}
	
	
	
	
	
	public static void validarIdPrestservic(Long idPrestservic)
			 throws Validador
				{				
								if(idPrestservic==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idPrestservic"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdPrestservic")));
					}
	
	public static void validarIdModalidad(Long idModalidad)
			 throws Validador
				{				
								if(idModalidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idModalidad"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdModalidad")));
					}
	
	public static void validarIdUsuexterno(Long idUsuexterno)
			 throws Validador
				{				
								if(idUsuexterno==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idUsuexterno"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdUsuexterno")));
					}
	
	
	public static void validarIdUsuinterno(Long idUsuinterno)
	 throws Validador
	{				
					if(idUsuinterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.seleccione"),
			Messages.getStringToKey("dtConsultas.idUsuinterno"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloIdUsuinterno")));
			if(idUsuinterno.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoseleccione"),
			Messages.getStringToKey("dtConsultas.idUsuinterno"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloIdUsuinterno")));			
	}
	public static void validarIdEntidad(Long idEntidad)
			 throws Validador
				{				
								if(idEntidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idEntidad"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdEntidad")));
					}
	
	public static void validarIdTema(Long idTema)
			 throws Validador
				{				
								if(idTema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idTema"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdTema")));
					}
	
	public static void validarIdSubtema(Long idSubtema)
			 throws Validador
				{				
								if(idSubtema==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idSubtema"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdSubtema")));
					}
	
	public static void validarIdOrigen(Long idOrigen)
			 throws Validador
				{				
								if(idOrigen==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idOrigen"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdOrigen")));
					}
	
	
	
	public static void validarIdCargo(Long idCargo)
			 throws Validador
				{				
								if(idCargo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idCargo"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdCargo")));
					}
	
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
						Messages.getStringToKey("dtConsultas.idSede"),
						Messages.getStringToKey("dtConsultas.titulotabla"),
						Messages.getStringToKey("dtConsultas.articuloIdSede")));
					}
	
	
	public static void validarIdSistAdm(Long idSistAdm)
	 throws Validador
	{				
					if(idSistAdm==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.seleccione"),
			Messages.getStringToKey("dtConsultas.idSistAdm"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloIdSistAdm")));
			if(idSistAdm.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoseleccione"),
			Messages.getStringToKey("dtConsultas.idSistAdm"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloIdSistAdm")));			
	}
	
	public static void validarCorreoUsuext(String correoUsuext)
	 throws Validador
	{					
			if(correoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.ingrese"),
			Messages.getStringToKey("dtConsultas.correoUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloCorreoUsuext")));
			if(correoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.correoUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla")));						
			if(correoUsuext!=null){
				if(correoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.noexceder"),
			Messages.getStringToKey("dtConsultas.correoUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla"),50,
			Messages.getStringToKey("dtConsultas.articuloCorreoUsuext")));
				}
	}
	
	public static void validarFijoUsuext(String fijoUsuext)
	 throws Validador
	{					
			if(fijoUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.ingrese"),
			Messages.getStringToKey("dtConsultas.fijoUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloFijoUsuext")));
			if(fijoUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.fijoUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla")));						
			if(fijoUsuext!=null){
				if(fijoUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.noexceder"),
			Messages.getStringToKey("dtConsultas.fijoUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla"),50,
			Messages.getStringToKey("dtConsultas.articuloFijoUsuext")));
				}
	}
	
	public static void validarCelularUsuext(String celularUsuext)
	 throws Validador
	{					
			if(celularUsuext==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.ingrese"),
			Messages.getStringToKey("dtConsultas.celularUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloCelularUsuext")));
			if(celularUsuext.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.celularUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla")));						
			if(celularUsuext!=null){
				if(celularUsuext.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.noexceder"),
			Messages.getStringToKey("dtConsultas.celularUsuext"),
			Messages.getStringToKey("dtConsultas.titulotabla"),50,
			Messages.getStringToKey("dtConsultas.articuloCelularUsuext")));
				}
	}
	
	public static void validarFechaFinalizacion(Timestamp fechaFinalizacion)
	 throws Validador
	{				
					if(fechaFinalizacion==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.fechaFinalizacion"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloFechaFinalizacion")));
		}
	
	public static void validarFechaSoli(Timestamp fechaSoli)
	 throws Validador
	{				
					if(fechaSoli==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtConsultas.invalidoingrese"),
			Messages.getStringToKey("dtConsultas.fechaSoli"),
			Messages.getStringToKey("dtConsultas.titulotabla"),
			Messages.getStringToKey("dtConsultas.articuloFechaSoli")));
		}
		
}