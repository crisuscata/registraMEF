package pe.gob.mef.registramef.bs.service;

import java.sql.Timestamp;

/**
 * MS_UNIDADES_ORG SERVICIO: UNIDADES ORGÁNICAS
 * //MPINARES 29092023 - INICIO - NUEVA CLASE
 * 
 * @author Carlos Aguilar
 * @version 2.0, 27/02/2022 22:42
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/
 *          /Carlos Aguilar Chamochumbi / 27/02/2022 22:42 / Creación de la
 *          clase /
 * 
 */
public interface Scheduler {

	void onTotales();

	void doTotales(Timestamp ULTIMA_EJECUCION, Timestamp fechalimite);	
	
}