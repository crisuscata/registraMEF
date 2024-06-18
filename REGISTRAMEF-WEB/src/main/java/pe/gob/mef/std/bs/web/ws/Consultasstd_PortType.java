/**
 * Consultasstd_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.mef.std.bs.web.ws;
//SPRINT01.2 NUEVO
public interface Consultasstd_PortType extends java.rmi.Remote {
    public pe.gob.mef.std.bs.web.ws.ExpedienteRegWSDto consultaExpedienteReg(int anio, java.lang.String numero) throws java.rmi.RemoteException, pe.gob.mef.std.bs.web.ws.ErrorInfo;
    public pe.gob.mef.std.bs.web.ws.ExpedienteSACCDto consultaExpediente(int anio, java.lang.String numero) throws java.rmi.RemoteException, pe.gob.mef.std.bs.web.ws.ErrorInfo;
}
