package pe.gob.mef.registramef.bs.service.imp;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import pe.gob.mef.registramef.bs.service.Scheduler;


/**
 * SERVICIO:
 * 
 * @author Carlos Aguilar
 * @version 2.0, 27/02/2022 22:42
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi / 27/02/2022 22:42 / Creación de la
 *          clase /
 * 
 */
@Service
public class SchedulerImp implements Scheduler, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5312370662584349817L;

	@Override
	public void onTotales() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doTotales(Timestamp ULTIMA_EJECUCION, Timestamp fechalimite) {
		// TODO Auto-generated method stub
		
	}


}